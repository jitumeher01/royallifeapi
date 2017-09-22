package com.spring.royallife.dto;

import java.util.ArrayList;
import java.util.List;

public class GrowthData {

	private Integer totalAmount;

	List<GrowthRowData> growthRows = new ArrayList<GrowthRowData>();

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<GrowthRowData> getGrowthRows() {
		return growthRows;
	}

	public void setGrowthRows(List<GrowthRowData> growthRows) {
		this.growthRows = growthRows;
	}

}
