package com.spring.royallife.converter;

import com.spring.royallife.dto.BankDetailData;
import com.spring.royallife.entity.BankEntity;

public interface BankDetailsConverter {
  public void convert(BankEntity bankDetailEntity, BankDetailData bankDetailData);
}
