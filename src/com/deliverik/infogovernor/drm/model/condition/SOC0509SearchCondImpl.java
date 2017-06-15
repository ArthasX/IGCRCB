/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;

/**
  * 概述: 预案章节信息检索条件实现
  * 功能描述: 预案章节信息检索条件实现
  * 创建记录: 2016/07/07
  * 修改记录: 
  */
public class SOC0509SearchCondImpl implements
		SOC0509SearchCond {

	protected String esyscoding_like;
	protected String eid;
	/** 资产模型层次码区间检索条件（平台保留） */
	protected List<String> esyscodingList;
	protected String cname;
	protected String pcid;
	private String esyscoding;

	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}

	public String getEsyscoding_like() {
		return esyscoding_like;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEid() {
		return eid;
	}

	public List<String> getEsyscodingList() {
		return esyscodingList;
	}

	public void setEsyscodingList(List<String> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPcid() {
		return pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

}