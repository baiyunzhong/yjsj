package com.fenbi.yjsj.service;

import java.util.List;

import com.fenbi.yjsj.pojo.Fund;

public interface FundService {
	/**
	 * 用来查询所有的fund数据
	 * @return
	 */
	public List<Fund> selectAll();
	/**
	 * 通过爬虫，存入fund的dayGrowthRate
	 */
	public void updateRate(String code);
}
