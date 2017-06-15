/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
  * 概述: mss00011检索条件实现
  * 功能描述: mss00011检索条件实现
  * 创建记录: 2013/04/16
  * 修改记录: 
  */
public class Mss00011SearchCondImpl implements
		Mss00011SearchCond {

	private String ruleid;
	private String devicestate;
	private String[] deleteId;
	private String name_like; 
	private String type_eq;
	private String esyscoding;
	private String typeid;
	private String deviceid;
	private IGLOG0041VO vo;
	
	
	public String getName_like() {
		return name_like;
	}
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
	public String getType_eq() {
		return type_eq;
	}
	public void setType_eq(String type_eq) {
		this.type_eq = type_eq;
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
	public String getRuleid() {
		return ruleid;
	}
	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getDevicestate() {
		return devicestate;
	}
	public void setDevicestate(String devicestate) {
		this.devicestate = devicestate;
	}
	
}