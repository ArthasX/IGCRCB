package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;

/**
 * 审计对比结果查询画面FORM
 * 
 */
public class IGCIM0302Form extends BaseForm implements SOC0103SearchCond{
	
	private static final long serialVersionUID = 1L;

	
	/** 审计时间戳 开始 */
	protected String autime_from;
	
	/** 审计时间戳 结束 */
	protected String autime_to;
	
	/** 审计任务描述 */
	protected String autdesc;
	
	/** 资产层次码 */
	protected String esyscoding;
	
	/** 资产名称 */
	protected String ename;
	
	/** 合理标识 */
	protected String[] checkbox;
	
	/** 审计ID */
	protected Integer[] aurids;
	
	/** 审计结果说明 */
	protected String[] auresultdesces;
	
	/** 审计任务ID */
	protected Integer autid;
	
	/** 更新时间 */
	protected String autupdtime;
	
	/** 对比时间 */
	protected String autcomptime;

	protected Integer eiid;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 审计任务描述取得
	 * @return 审计任务描述
	 */
	public String getAutdesc() {
		return autdesc;
	}

	/**
	 * 审计任务描述设定
	 * @param autdesc 审计任务描述
	 */
	public void setAutdesc(String autdesc) {
		this.autdesc = autdesc;
	}

	/**
	 * 审计时间戳 开始取得
	 * @return 审计时间戳 开始
	 */
	public String getAutime_from() {
		return autime_from;
	}

	/**
	 * 审计时间戳 开始设定
	 * @param autime_from 审计时间戳 开始
	 */
	public void setAutime_from(String autime_from) {
		this.autime_from = autime_from;
	}

	/**
	 * 审计时间戳 结束取得
	 * @return 审计时间戳 结束
	 */
	public String getAutime_to() {
		return autime_to;
	}

	/**
	 * 审计时间戳 结束设定
	 * @param autime_to 审计时间戳 结束
	 */
	public void setAutime_to(String autime_to) {
		this.autime_to = autime_to;
	}

	/**
	 * 资产层次码取得
	 * @return 资产层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产层次码设定
	 * @param esyscoding 资产层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产名称设定
	 * @param einame 资产名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 合理标识取得
	 * @return 合理标识
	 */
	public String[] getCheckbox() {
		return checkbox;
	}

	/**
	 * 合理标识设定
	 * @param checkbox 合理标识
	 */
	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * 审计结果说明取得
	 * @return 审计结果说明
	 */
	public String[] getAuresultdesces() {
		return auresultdesces;
	}

	/**
	 * 审计结果说明设定 
	 * @param auresultdesces 审计结果说明
	 */
	public void setAuresultdesces(String[] auresultdesces) {
		this.auresultdesces = auresultdesces;
	}

	/**
	 * 审计ID取得
	 * @return 审计ID
	 */
	public Integer[] getAurids() {
		return aurids;
	}

	/**
	 * 审计ID设定
	 * @param aurids 审计ID
	 */
	public void setAurids(Integer[] aurids) {
		this.aurids = aurids;
	}

	/**
	 * 审计任务ID取得
	 * @return 审计任务ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * 审计任务ID设定
	 * @param autid 审计任务ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * 更新时间取得
	 * @return 更新时间
	 */
	public String getAutupdtime() {
		return autupdtime;
	}

	/**
	 * 更新时间设定
	 * @param autupdtime 更新时间
	 */
	public void setAutupdtime(String autupdtime) {
		this.autupdtime = autupdtime;
	}

	/**
	 * 对比时间取得
	 * @return 对比时间
	 */
	public String getAutcomptime() {
		return autcomptime;
	}

	/**
	 * 对比时间设定
	 * @param autcomptime 对比时间
	 */
	public void setAutcomptime(String autcomptime) {
		this.autcomptime = autcomptime;
	}
	

}
