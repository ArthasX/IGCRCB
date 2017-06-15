/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 食堂接待信息查询接口实现
 *
 */
public class EentertainmentSearchCondImpl implements EentertainmentSearchCond {
	
	/**
	 * 食堂接待信息开始时间查询
	 */
	public String eetime_from;
	
	/**
	 * 食堂接待信息结束时间查询
	 */
	public String eetime_to;
	
	public Integer rid_mon;
	
	public Integer rid_org;

	/**
	 * 食堂接待信息时间查询取得
	 * @return 食堂接待信息开始时间查询
	 */
	public String getEetime_from() {
		return eetime_from;
	}

	/**
	 * 食堂接待信息开始时间查询设定
	 * @param eetime_from 食堂接待信息开始时间查询
	 */
	public void setEetime_from(String eetime_from) {
		this.eetime_from = eetime_from;
	}

	/**
	 * 食堂接待信息结束时间查询取得
	 * @return 食堂接待信息结束时间查询
	 */
	public String getEetime_to() {
		return eetime_to;
	}

	/**
	 * 食堂接待信息结束时间查询设定
	 * @param eetime_to 食堂接待信息结束时间查询
	 */
	public void setEetime_to(String eetime_to) {
		this.eetime_to = eetime_to;
	}

	public Integer getRid_mon() {
		return rid_mon;
	}

	public void setRid_mon(Integer rid_mon) {
		this.rid_mon = rid_mon;
	}

	public Integer getRid_org() {
		return rid_org;
	}

	public void setRid_org(Integer rid_org) {
		this.rid_org = rid_org;
	}

}
