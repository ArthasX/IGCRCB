/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.infogovernor.soc.model.SOC0114VWInfo;

/**
 * 概述: SOC0114VWTB_FX
 * 功能描述: FX: Fuxin
 * 创建记录: 2013-10-26
 * 修改记录: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0114VWPK.class)
public class SOC0114VW implements Serializable, Cloneable, SOC0114VWInfo {

	@Id
	protected Integer domainid;
	@Id
	protected Integer domainversion;
	//	eiid 节点eiid
	protected Integer eiid;
	//	einame 节点名称
	protected String einame;
	//	esyscoding 节点层次码
	protected String esyscoding;
	//	eiversion 节点大版本
	protected String eiversion;
	//	eismallversion 节点小版本
	protected String eismallversion;
	//	linkid 链路ID
	@Id
	protected Integer linkid;
	//	linkorder 链路节点排序
	@Id
	protected String linkorder;
	//	hostIP 主机IP
	protected String hostIP;
	//	hostEiid 主机EIID
	protected Integer hostEiid;
	protected Integer hostVersion;
	protected Integer hostSmallVersion;
	protected String hostEsyscoding;
	protected String resourceid;
	
	/**
	 * eiid取得
	 *
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}
	/**
	 * einame取得
	 *
	 * @return einame einame
	 */
	public String getEiname() {
		return einame;
	}
	/**
	 * esyscoding取得
	 *
	 * @return esyscoding esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**
	 * eiversion取得
	 *
	 * @return eiversion eiversion
	 */
	public String getEiversion() {
		return eiversion;
	}
	/**
	 * eismallversion取得
	 *
	 * @return eismallversion eismallversion
	 */
	public String getEismallversion() {
		return eismallversion;
	}
	/**
	 * linkid取得
	 *
	 * @return linkid linkid
	 */
	public Integer getLinkid() {
		return linkid;
	}
	/**
	 * linkorder取得
	 *
	 * @return linkorder linkorder
	 */
	public String getLinkorder() {
		return linkorder;
	}
	/**
	 * hostIP取得
	 *
	 * @return hostIP hostIP
	 */
	public String getHostIP() {
		return hostIP;
	}
	/**
	 * hostEiid取得
	 *
	 * @return hostEiid hostEiid
	 */
	public Integer getHostEiid() {
		return hostEiid;
	}
	/**
	 * eiid设定
	 *
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 * einame设定
	 *
	 * @param einame einame
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**
	 * esyscoding设定
	 *
	 * @param esyscoding esyscoding
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * eiversion设定
	 *
	 * @param eiversion eiversion
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}
	/**
	 * eismallversion设定
	 *
	 * @param eismallversion eismallversion
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}
	/**
	 * linkid设定
	 *
	 * @param linkid linkid
	 */
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}
	/**
	 * linkorder设定
	 *
	 * @param linkorder linkorder
	 */
	public void setLinkorder(String linkorder) {
		this.linkorder = linkorder;
	}
	/**
	 * hostIP设定
	 *
	 * @param hostIP hostIP
	 */
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	/**
	 * hostEiid设定
	 *
	 * @param hostEiid hostEiid
	 */
	public void setHostEiid(Integer hostEiid) {
		this.hostEiid = hostEiid;
	}
	public Integer getDomainid() {
		return domainid;
	}
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}
	public Integer getDomainversion() {
		return domainversion;
	}
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}
	public Integer getHostVersion() {
		return hostVersion;
	}
	public void setHostVersion(Integer hostVersion) {
		this.hostVersion = hostVersion;
	}
	public Integer getHostSmallVersion() {
		return hostSmallVersion;
	}
	public void setHostSmallVersion(Integer hostSmallVersion) {
		this.hostSmallVersion = hostSmallVersion;
	}
	public String getResourceid() {
		return resourceid;
	}
	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}
	public String getHostEsyscoding() {
		return hostEsyscoding;
	}
	public void setHostEsyscoding(String hostEsyscoding) {
		this.hostEsyscoding = hostEsyscoding;
	}
	
	
}
