/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 食堂接待信息查询接口
 *
 */
public interface EentertainmentSearchCond {
	
	/**
	 * 食堂接待信息查询时间开始
	 */
	public String getEetime_from();
	
	/**
	 * 食堂接待信息查询时间结束
	 */
	public String getEetime_to();
	
	public Integer getRid_org();
	
	public Integer getRid_mon();

}
