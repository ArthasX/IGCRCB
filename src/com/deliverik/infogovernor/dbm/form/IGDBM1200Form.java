/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程钻取Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDBM1200Form extends BaseForm{

	/** 流程定义ID */
	protected String prpdid;
	
	/** 流程发起时间 */
	protected String propentime_like;
	
	/** 流程关闭时间*/
	protected String prclosetime_like;
	
	/** 流程状态 */
	protected String prstatus;
	
	/** 处理人处理状态*/
	protected String ppstatus;
	
	/** 扩展参数 */
	protected String other;
	
	/** 月份 */
	protected String month;
	
	/** 工单未关闭标识 */
	protected String prActive;
	
	/** 表单名称 */
	protected String[] varnames;
	
	/** 表单值 */
	protected String[] varvalues;
	
	/** 风险实际检查时间 */
	protected String rcrrealtime_like;
	
	/** 风险检查类型 */
	protected String rcclass;
	
	/** 检查方式  */
	protected String rcrtestmode;
	
	/** 流程处理用户ID */
	protected String ppuserid;
	
	/**资产层次码*/
	protected String esyscoding;

	/** 领域名称值 */
	protected String pivarvalue;
	
	/** 流程&资产ID */
	protected String countid;
	
	/** 流程&资产分类 */
	protected String type;
	/**流程关闭标识*/
	protected String prclose;
	
	/** 流程集合*/
	protected String prid_in;
	
	/** 是否为告警事件 1为是 0为否*/
	protected String alarm_Is;
	
	/** 事是否已经确认1为否0为是*/
	protected String ppbacktime_isNull;
	
	/**
	 * 流程定义ID取得
	 * @return prpdid 流程定义ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程定义ID设定
	 * @param prpdid 流程定义ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * 流程发起时间取得
	 * @return propentime_like 流程发起时间
	 */
	public String getPropentime_like() {
		return propentime_like;
	}

	/**
	 * 流程发起时间设定
	 * @param propentime_like 流程发起时间
	 */
	public void setPropentime_like(String propentime_like) {
		this.propentime_like = propentime_like;
	}

	/**
	 * 流程状态取得
	 * @return prstatus 流程状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态设定
	 * @param prstatus 流程状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	
	/**处理人处理状态取得
	 * @return the ppstatus
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**处理人处理状态设定
	 * @param ppstatus the ppstatus to set
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}
	
	/**
	 * 扩展参数取得
	 * @return other 扩展参数
	 */
	public String getOther() {
		return other;
	}

	/**
	 * 扩展参数设定
	 * @param other 扩展参数
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * 月份取得
	 * @return month 月份
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月份设定
	 * @param month 月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 工单未关闭标识取得
	 * @return prActive 工单未关闭标识
	 */
	public String getPrActive() {
		return prActive;
	}

	/**
	 * 工单未关闭标识设定
	 * @param prActive 工单未关闭标识
	 */
	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	/**
	 * 表单名称取得
	 * @return varnames 表单名称
	 */
	public String[] getVarnames() {
		return varnames;
	}

	/**
	 * 表单名称设定
	 * @param varnames 表单名称
	 */
	public void setVarnames(String[] varnames) {
		this.varnames = varnames;
	}

	/**
	 * 表单值取得
	 * @return varvalues 表单值
	 */
	public String[] getVarvalues() {
		return varvalues;
	}

	/**
	 * 表单值设定
	 * @param varvalues 表单值
	 */
	public void setVarvalues(String[] varvalues) {
		this.varvalues = varvalues;
	}

	/**
	 * 风险实际检查时间取得
	 * @return rcrrealtime_like 风险实际检查时间
	 */
	public String getRcrrealtime_like() {
		return rcrrealtime_like;
	}

	/**
	 * 风险实际检查时间设定
	 * @param rcrrealtime_like 风险实际检查时间
	 */
	public void setRcrrealtime_like(String rcrrealtime_like) {
		this.rcrrealtime_like = rcrrealtime_like;
	}

	/**
	 * 风险检查类型取得
	 * @return rcclass 风险检查类型
	 */
	public String getRcclass() {
		return rcclass;
	}

	/**
	 * 风险检查类型设定
	 * @param rcclass 风险检查类型
	 */
	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	/**
	 * 检查方式取得
	 * @return rcrtestmode 检查方式
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * 检查方式设定
	 * @param rcrtestmode 检查方式
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}

	/**
	 * 流程处理用户ID取得
	 * @return ppuserid 流程处理用户ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 流程处理用户ID设定
	 * @param ppuserid 流程处理用户ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * 资产层次码   取得
	 * @return esyscoding_like 资产层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产层次码   设定
	 * @param esyscoding_like 资产层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountid() {
		return countid;
	}

	public void setCountid(String countid) {
		this.countid = countid;
	}
	
	

	/**
	 * 流程关闭时间取得
	 * @return the prclosetime_like
	 */
	public String getPrclosetime_like() {
		return prclosetime_like;
	}

	/**
	 * 流程关闭时间设定
	 * @param prclosetime_like the prclosetime_like to set
	 */
	public void setPrclosetime_like(String prclosetime_like) {
		this.prclosetime_like = prclosetime_like;
	}

	public String getPivarvalue() {
		return pivarvalue;
	}

	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 流程关闭标识   取得
	 * @return prclose 流程关闭标识
	 */
	public String getPrclose() {
		return prclose;
	}

	/**
	 * 流程关闭标识   设定
	 * @param prclose 流程关闭标识
	 */
	public void setPrclose(String prclose) {
		this.prclose = prclose;
	}

	/**
	 * 流程集合获取
	 * @return the prid_in
	 */
	public String getPrid_in() {
		return prid_in;
	}

	/**
	 * 流程集合设定
	 * @param prid_in
	 */
	public void setPrid_in(String prid_in) {
		this.prid_in = prid_in;
	}

	/**
	 * 是否为告警事件1为是0为否获取
	 * @return the alarm_Is
	 */
	public String getAlarm_Is() {
		return alarm_Is;
	}

	/**
	 * 是否为告警事件1为是0为否设定
	 * @param alarm_Is
	 */
	public void setAlarm_Is(String alarm_Is) {
		this.alarm_Is = alarm_Is;
	}

	/**
	 * 事是否已经确认1为否0为是获取
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull() {
		return ppbacktime_isNull;
	}

	/**
	 * 事是否已经确认1为否0为是设定
	 * @param ppbacktime_isNull
	 */
	public void setPpbacktime_isNull(String ppbacktime_isNull) {
		this.ppbacktime_isNull = ppbacktime_isNull;
	}
	
}
