/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
  * 概述: 告警规则表检索条件实现
  * 功能描述: 告警规则表检索条件实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00002SearchCondImpl implements
		Mss00002SearchCond {
	
	private String[] deleteId;
	private String name_like; 
	private String ip_like;
	private String esyscoding;
	private IGLOG0041VO vo;
	protected String deviceid;
	/** 规则模板id */
	protected Integer ruletempid;
	
	public String getName_like() {
		return name_like;
	}
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
	public String getIp_like() {
		return ip_like;
	}
	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
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
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}
	public String[] getDeleteId() {
		return deleteId;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	/**
	 * 规则模板id取得
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}
	/**
	 * 规则模板id设定
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}
	
}