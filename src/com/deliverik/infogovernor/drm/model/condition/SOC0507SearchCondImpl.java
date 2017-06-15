/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 预案信息表检索条件实现
  * 功能描述: 预案信息表检索条件实现
  * 创建记录: 2016/07/15
  * 修改记录: 
  */
public class SOC0507SearchCondImpl implements
		SOC0507SearchCond {

	private String cid;
	private String eid;
	private Integer eiid;
	private String esyscoding;

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getCid() {
		return cid;
	}

	public String getEid() {
		return eid;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

}