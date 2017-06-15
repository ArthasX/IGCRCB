/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 资产关系图画面FORM
 * 
 */
@SuppressWarnings("serial")
public class IGCOM0314Form extends BaseForm {

	/** 资产ID */
	protected String eiid;
	
	/** 关系图XML */
	protected String graphXml;
	
	/** 主机下拉列表XML */
	protected String hostXml;
	
	/** 所选主机EIID */
	protected String selectHost;
	
	/** 所选主机索引 */
	protected String selectHostIndex;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 关系数 */
	protected String eircount;
	
	/** 域ID */
	protected Integer domainid;

	/** Domain版本 */
	protected Integer domainversion;
	
	/** 更新时间 */
	protected String updatetime;
	
	/** 硬盘资产eiid */
	protected String diskeiid;
	
	/**
	 * 硬盘资产eiid取得
	 * @return 硬盘资产eiid
	 */
	public String getDiskeiid() {
		return diskeiid;
	}

	/**
	 * 硬盘资产eiid设定
	 * @param diskeiid硬盘资产eiid
	 */
	public void setDiskeiid(String diskeiid) {
		this.diskeiid = diskeiid;
	}
	
	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 关系图XML取得
	 * 
	 * @return 关系图XML
	 */
	public String getGraphXml() {
		return graphXml;
	}

	/**
	 * 关系图XML设定
	 * @param graphXml关系图XML
	 */
	public void setGraphXml(String graphXml) {
		this.graphXml = graphXml;
	}
	
	/**
	 * 主机下拉列表XML取得
	 * @return 主机下拉列表XML
	 */
	public String getHostXml() {
		return hostXml;
	}

	/**
	 * 主机下拉列表XML设定
	 * @param hostXml主机下拉列表XML
	 */
	public void setHostXml(String hostXml) {
		this.hostXml = hostXml;
	}
	
	/**
	 * 所选主机EIID取得
	 * @return 所选主机EIID
	 */
	public String getSelectHost() {
		return selectHost;
	}

	/**
	 * 所选主机EIID设定
	 * @param selectHost所选主机EIID
	 */
	public void setSelectHost(String selectHost) {
		this.selectHost = selectHost;
	}

	/**
	 * 所选主机索引取得
	 * @return 所选主机索引
	 */
	public String getSelectHostIndex() {
		return selectHostIndex;
	}

	/**
	 * 所选主机索引设定
	 * @param selectHostIndex所选主机索引
	 */
	public void setSelectHostIndex(String selectHostIndex) {
		this.selectHostIndex = selectHostIndex;
	}

	/**
	 * 权限标识取得
	 * @return 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 *
	 * @param flag 权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * 关系数取得
	 * @return 关系数
	 */
	public String getEircount() {
		return eircount;
	}

	/**
	 * 关系数设定
	 *
	 * @param eircount 关系数
	 */
	public void setEircount(String eircount) {
		this.eircount = eircount;
	}
	
	/**
	 * 域ID取得
	 *
	 * @return 域ID
	 */
	public Integer getDomainid() {
		return domainid;
	}

	/**
	 * 域ID设定
	 *
	 * @param domainid 域ID
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	/**
	 * Domain版本取得
	 *
	 * @return Domain版本
	 */
	public Integer getDomainversion() {
		return domainversion;
	}

	/**
	 * Domain版本设定
	 *
	 * @param domainversion Domain版本
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}
	
	/**
	 * 更新时间取得
	 *
	 * @return 更新时间
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * 更新时间设定
	 *
	 * @param updatetime 更新时间
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
}
