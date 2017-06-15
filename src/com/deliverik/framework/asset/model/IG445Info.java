package com.deliverik.framework.asset.model;

/**
 * 设备统计分析信息（平台保留）
 * 
 * 列出类型为设备（001）的一级子类的配置项汇总
 *
 */
public interface IG445Info {
	
	/** 机构层次码*/
	public String getOrgsyscoding();
	
	/** 机构名称*/
	public String getOrgname();
	
	/** 取得个数*/
	public Integer getCount();
	
	/** 取得所占百分数*/
	public String getProportion();
	
	/** 设置所占百分数*/
	public void setProportion(String proportion);
	
}