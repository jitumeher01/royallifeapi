package com.spring.royallife.facade.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.royallife.converter.CommitConverter;
import com.spring.royallife.converter.UserConverter;
import com.spring.royallife.dto.CommitData;
import com.spring.royallife.dto.UserData;
import com.spring.royallife.entity.CommitEntity;
import com.spring.royallife.entity.UserEntity;
import com.spring.royallife.facade.CommitFacade;
import com.spring.royallife.repository.CommitRepository;
import com.spring.royallife.service.UserService;

@Service
public class CommitFacadeImpl implements CommitFacade {

	@Autowired
	private UserService userService;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private CommitConverter commitConverter;

	@Autowired
	private CommitRepository commitRepository;

	@Override
	public UserData getCommitDetails(String userId) throws Exception {
		UserEntity userEntity = userService.findByUserId(userId);
		UserData userData = new UserData();
		CommitData commitData = new CommitData();

		userConverter.convert(userEntity, userData);
		if (userEntity.getCommit() != null) {
			commitConverter.convert(userEntity.getCommit(), commitData);
			userData.setCommitData(commitData);
		}else {
			throw new Exception("User not Commit !");
		}

		return userData;
	}

	@Override
	public void addCommit(CommitData commitData) {
		CommitEntity commitEntity = new CommitEntity();
		UserEntity userEntity = userService.findByUserId(commitData.getUserId());

		LocalDate today = LocalDate.now();

		LocalDate planDate = null;
		int days = 0;
		if (commitData.getPlan().equalsIgnoreCase("15DAYS")) {
			commitEntity.setName("15 Days Plan");
			commitEntity.setPlanNo("15");
			planDate = today.plusDays(15);
			days = 15;

		} else if (commitData.getPlan().equalsIgnoreCase("30DAYS")) {
			commitEntity.setName("30 Days Plan");
			commitEntity.setPlanNo("30");
			planDate = today.plusDays(30);
			days = 30;
		}

		int amount = Integer.parseInt(commitData.getCommitAmount());
		int maturityAmount = (amount * days) / 100 + amount;
		commitEntity.setMaturityAmount(Integer.toString(maturityAmount));
		commitEntity.setReceiveAmount(Integer.toString(maturityAmount));

		commitEntity.setCommitAmount(commitData.getCommitAmount());
		commitEntity.setSendAmount(commitData.getCommitAmount());
		commitEntity.setCommitDate(asDate(today));

		commitEntity.setMaturityDate(asDate(planDate));

		commitEntity.setUser(userEntity);
		commitRepository.save(commitEntity);

	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

}
