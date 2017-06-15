/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 食堂成本信息查询接口实现
 *
 */
public class LunchCardSearchCondImpl implements LunchCardSearchCond {
	
	/**
	 * 餐卡名称
	 */
	public String typename;
	
	/**
	 * 餐卡状态
	 */
	public String desc;
	
	/**
	 * 餐卡编号
	 */
	public Integer icid;

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getIcid() {
		return icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

}
