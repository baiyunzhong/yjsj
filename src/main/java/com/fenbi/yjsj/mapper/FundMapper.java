package com.fenbi.yjsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;


import com.fenbi.yjsj.pojo.Fund;

public interface FundMapper {
	
	public List<Fund> selectFundRate();
	
	public void updateByCode(Fund fund);
}
