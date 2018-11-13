package com.fenbi.yjsj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenbi.yjsj.pojo.FenbiResult;
import com.fenbi.yjsj.pojo.Fund;
import com.fenbi.yjsj.service.FundService;

@Controller
@RequestMapping("/fund")
@Transactional(rollbackFor=Exception.class)
public class FundController {
	static String[] arr = {"110011","110003","001409","002601","270049"};
	@Autowired
	private FundService fundService;
	
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public FenbiResult selectFunds() {
		List<Fund> funds = fundService.selectAll();
		return new FenbiResult(funds);
	}
	@RequestMapping("/update")
	@ResponseBody

	public FenbiResult updateRate() {
		for(int i=0;i<arr.length;i++) {
			fundService.updateRate(arr[i]);		
		}
		return new FenbiResult();
		
		
		
	}
	
}
