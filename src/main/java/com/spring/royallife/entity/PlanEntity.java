package com.spring.royallife.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class PlanEntity {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String planNo;

	@OneToOne
	private CommitEntity commit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanNo() {
		return planNo;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	public CommitEntity getCommit() {
		return commit;
	}

	public void setCommit(CommitEntity commit) {
		this.commit = commit;
	}

}
