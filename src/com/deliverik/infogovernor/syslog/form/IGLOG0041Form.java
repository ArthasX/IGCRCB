/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
 * <p>
 * Title : InfoGovernor 日志告警模板管理
 * </p>
 * <p>
 * Description: 监控管理 >> 监控配置 >> 告警规则模板管理Form
 * </p>
 * 
 * @author wangrongguang@deliverik.com
 * @version 1.0
 */

public class IGLOG0041Form extends BaseForm {
	
	private static final long serialVersionUID = -7806752326705441563L;
	
	private String ename; 
	
	private String esyscoding;
	
	private IGLOG0041VO vo;
	
	protected String[] deleteId;
	
	protected String typeid;
	
	/** 模板状态 */
	protected String tempstate;
	
	/** 模板id */
	protected String ruletempid;
	
	/** 模板名称 */
	protected String ruletempname;
	
	/** 查询条件模板状态 */
	protected String tempstates;
	
	/** 使用该模板的设备ip */
	protected String deviceip;
	
	protected String summary;
	
	
	public String getDeviceip() {
		return deviceip;
	}
	
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	public String getEsyscoding() {
		return esyscoding;
	}
	
	public void setVo(IGLOG0041VO vo) {
		this.vo = vo;
	}
	
	public IGLOG0041VO getVo() {
		return vo;
	}
	
	/**
	 * deleteId取得
	 */
	public String[] getDeleteId() {
		return deleteId;
	}
	/**
	 * deleteId设定
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}
	/**
	 * 模板状态取得
	 */
	public String getTempstate() {
		return tempstate;
	}
	/**
	 * 模板状态设定
	 */
	public void setTempstate(String tempstate) {
		this.tempstate = tempstate;
	}
	/**
	 * 模板id取得
	 */
	public String getRuletempid() {
		return ruletempid;
	}
	/**
	 * 模板id设定
	 */
	public void setRuletempid(String ruletempid) {
		this.ruletempid = ruletempid;
	}
	/**
	 * 模板名称取得
	 */
	public String getRuletempname() {
		return ruletempname;
	}
	/**
	 * 模板名称设定
	 */
	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}
	/**
	 * 查询条件模板状态取得
	 */
	public String getTempstates() {
		return tempstates;
	}
	/**
	 * 查询条件模板状态设定
	 */
	public void setTempstates(String tempstates) {
		this.tempstates = tempstates;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}
