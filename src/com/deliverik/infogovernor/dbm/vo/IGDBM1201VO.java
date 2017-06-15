/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * 科技运行综合分析(一)DashBaord查询结果 VO
 * 
 * @author
 * 
 */
@SuppressWarnings("serial")
public class IGDBM1201VO extends BaseVO implements Serializable {

	/* 服务工单值 */
	protected String swoValue;

	/* 故障申报值 */
	protected String ftdValue;

	/* 服务请求 */
	protected String serValue;

	/* 事件 */
	protected String teValue;

	/* 问题 */
	protected String tpValue;

	/* 变更 */
	protected String chaValue;

	/* 请求 */
	protected String reqValue;

	/* 指派 */
	protected String assValue;
	
	/*返回一切需要xml流的字符串*/
	protected String resultXML;

	/** 科技运行综合分析(一)DashBaord查询结果 */
	protected List<IG500Info> IG500InfoList;

	/**
	 * 科技运行综合分析(一)DashBaord查询结果 is returned.
	 * 
	 * @return IG500InfoList
	 */
	public List<IG500Info> getIG500InfoList() {
		return IG500InfoList;
	}

	/**
	 * 科技运行综合分析(一)DashBaord查询结果 is set.
	 * 
	 * @param IG500InfoList
	 *            全网IP地址过滤信息
	 */
	public void setIG500InfoList(List<IG500Info> iG500InfoList) {
		IG500InfoList = iG500InfoList;
	}

	public String getSwoValue() {
		return swoValue;
	}

	public void setSwoValue(String swoValue) {
		this.swoValue = swoValue;
	}

	public String getFtdValue() {
		return ftdValue;
	}

	public void setFtdValue(String ftdValue) {
		this.ftdValue = ftdValue;
	}

	public String getSerValue() {
		return serValue;
	}

	public void setSerValue(String serValue) {
		this.serValue = serValue;
	}

	public String getTeValue() {
		return teValue;
	}

	public void setTeValue(String teValue) {
		this.teValue = teValue;
	}

	public String getTpValue() {
		return tpValue;
	}

	public void setTpValue(String tpValue) {
		this.tpValue = tpValue;
	}

	public String getChaValue() {
		return chaValue;
	}

	public void setChaValue(String chaValue) {
		this.chaValue = chaValue;
	}

	public String getReqValue() {
		return reqValue;
	}

	public void setReqValue(String reqValue) {
		this.reqValue = reqValue;
	}

	public String getAssValue() {
		return assValue;
	}

	public void setAssValue(String assValue) {
		this.assValue = assValue;
	}

	public String getResultXML() {
		return resultXML;
	}

	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
}
