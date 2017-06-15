/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 合同统计Form
 * 功能描述: 合同统计Form
 * 创建记录: 2013/06/22
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM0424Form extends BaseForm implements IG499SearchCond{
	
	/** 合同类别 */
	protected String compacttype;
	
	/** 签订时间 */
	protected String condudetime;
	
	/** 服务商 */
	protected String facilitator;
	
	/** 经手人 */
	protected String operator;
	
	/** 合同名称 */
	protected String einame;
	
	/** 合同编号 */
	protected String eilabel;
	
	/** 查询时间点 */
	protected String datetime;
	
	/** 签订时间:从 */
	protected String condudetime_from;
	
	/** 签订时间:到 */
	protected String condudetime_to;
	
	/** 查询时间:从 */
	protected String time_from;
	
	/** 查询时间:到 */
	protected String time_to;
	
	public String getTime_from() {
		return time_from;
	}

	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	public String getTime_to() {
		return time_to;
	}

	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}

	/** 是否付款完毕 */
	protected String payed;//1:是；0：否

	/**
	 * 合同类别取得
	 * @return 合同类别
	 */
	public String getCompacttype() {
		return compacttype;
	}

	/**
	 * 合同类别设定
	 * @param compacttype合同类别
	 */
	public void setCompacttype(String compacttype) {
		this.compacttype = compacttype;
	}

	/**
	 * 签订时间取得
	 * @return 签订时间
	 */
	public String getCondudetime() {
		return condudetime;
	}

	/**
	 * 签订时间设定
	 * @param condudetime签订时间
	 */
	public void setCondudetime(String condudetime) {
		this.condudetime = condudetime;
	}

	/**
	 * 服务商取得
	 * @return 服务商
	 */
	public String getFacilitator() {
		return facilitator;
	}

	/**
	 * 服务商设定
	 * @param facilitator服务商
	 */
	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
	}

	/**
	 * 经手人取得
	 * @return 经手人
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * 经手人设定
	 * @param operator经手人
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 合同名称取得
	 * @return 合同名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 合同名称设定
	 * @param einame合同名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 合同编号取得
	 * @return 合同编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 合同编号设定
	 * @param eilabel合同编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 查询时间点取得
	 * @return 查询时间点
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * 查询时间点设定
	 * @param datetime查询时间点
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * 签订时间:从取得
	 * @return 签订时间:从
	 */
	public String getCondudetime_from() {
		return condudetime_from;
	}

	/**
	 * 签订时间:从设定
	 * @param condudetime_from签订时间:从
	 */
	public void setCondudetime_from(String condudetime_from) {
		this.condudetime_from = condudetime_from;
	}

	/**
	 * 签订时间:到取得
	 * @return 签订时间:到
	 */
	public String getCondudetime_to() {
		return condudetime_to;
	}

	/**
	 * 签订时间:到设定
	 * @param condudetime_to签订时间:到
	 */
	public void setCondudetime_to(String condudetime_to) {
		this.condudetime_to = condudetime_to;
	}

	public String getEiid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPayed() {
		return payed;
	}

	public void setPayed(String payed) {
		this.payed = payed;
	}

	public String getEiorgsyscoding_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEiusername() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEiorgsyscoding_in(String arg0) {
		// TODO Auto-generated method stub
		
	}

    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.IG499SearchCond#getEname()
     */
    public String getEname() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.deliverik.framework.asset.model.condition.IG499SearchCond#getEsyscoding()
     */
    public String getEsyscoding() {
        // TODO Auto-generated method stub
        return null;
    }
}
