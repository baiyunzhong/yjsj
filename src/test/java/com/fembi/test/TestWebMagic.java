package com.fembi.test;

import java.util.ArrayList;

import com.fenbi.yjsj.pojo.Fund;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;

//1.实现PageProcessor接口
public class TestWebMagic implements PageProcessor  {
	
	static ArrayList funds = new ArrayList();
	
	// 2.设置抓取网站的相关配置，可以包括编码、重试次数、抓取间隔1s等
	private Site site = Site.me().setCharset("utf-8").setRetryTimes(1000).setSleepTime(1000);
	@Override
	public Site getSite() {
		//3.返回site
		return site;
	}
	//5.爬取逻辑   ^(<em class="b-rate">).$(</em>)
	@Override   
	public void process(Page page) {
		//获取整个页面的Html代码，并且将其存到LinkedHashMap中
		page.putField("dayGrowthRate", page.getHtml().xpath("//em[@class='b-rate']/text()").replace("%", "").toString().trim());
		page.putField("name", page.getHtml().xpath("//div[@class='lt']/h1/text()").toString().trim());
		String name = page.getResultItems().get("name");
		Double rate = Double.parseDouble(page.getResultItems().get("dayGrowthRate")) ;
		String codeString = page.getHtml().xpath("//div[@class='lt']/h1/span/text()").toString().trim();
		String code = codeString.replaceAll("\\W", "");
		System.out.println(code);
		// 用Fund类来存抓取到的数据，方便存入数据库
		Fund fund = new Fund();
		fund.setName(name);
		fund.setDayGrowthRate(rate);
		funds.add(fund);
		
	}
	//4.爬取
	public static void main(String[] args) {
		//添加爬取的url ,开启5个线程爬取
		String[] arr = {"110011","110003","001409","002601","270049"};
		for(int i=0;i<arr.length;i++) {
			
			Spider spider = Spider.create(new TestWebMagic()).addUrl("http://www.howbuy.com/fund/"+arr[i]+"/").thread(5);
			//启动爬虫
			spider.run();
		}
		System.err.println(funds);
		
	}
	
}
