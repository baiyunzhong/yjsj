package com.fenbi.yjsj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fembi.test.TestWebMagic;
import com.fenbi.yjsj.mapper.FundMapper;
import com.fenbi.yjsj.pojo.Fund;
import com.fenbi.yjsj.service.FundService;
import com.fenbi.yjsj.utils.WebMagicUtil;

import us.codecraft.webmagic.Spider;

@Service
public class FundServiceImpl implements FundService {
	@Autowired
	private FundMapper fundMapper;
	
	@Override
	public List<Fund> selectAll() {
		
		return fundMapper.selectFundRate(); 
	}

	@Override
	@Transactional(transactionManager="txManager")
	public void updateRate(String str) {
			fundMapper.updateByCode(WebMagicUtil.getFund(str));
		
	}


}
