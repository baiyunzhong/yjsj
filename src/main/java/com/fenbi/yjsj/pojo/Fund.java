package com.fenbi.yjsj.pojo;

public class Fund {
	private Integer id;
	private String name ;
	private Integer type ;
	private String fundCode;
	private String company;
	private Double dayGrowthRate;
	private String typeName;
	
	public Fund() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Fund(Integer id, String name, Integer type, String fundCode, String company, Double dayGrowthRate) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.fundCode = fundCode;
		this.company = company;
		this.dayGrowthRate = dayGrowthRate;
	}


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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getDayGrowthRate() {
		return dayGrowthRate;
	}

	public void setDayGrowthRate(Double dayGrowthRate) {
		this.dayGrowthRate = dayGrowthRate;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Fund [id=" + id + ", name=" + name + ", type=" + type + ", fundCode=" + fundCode + ", company="
				+ company + ", dayGrowthRate=" + dayGrowthRate + ", typeName=" + typeName + "]";
	}
	
}
