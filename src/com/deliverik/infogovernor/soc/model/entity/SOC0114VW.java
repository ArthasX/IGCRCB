/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.infogovernor.soc.model.SOC0114VWInfo;

/**
 * ����: SOC0114VWTB_FX
 * ��������: FX: Fuxin
 * ������¼: 2013-10-26
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0114VWPK.class)
public class SOC0114VW implements Serializable, Cloneable, SOC0114VWInfo {

	@Id
	protected Integer domainid;
	@Id
	protected Integer domainversion;
	//	eiid �ڵ�eiid
	protected Integer eiid;
	//	einame �ڵ�����
	protected String einame;
	//	esyscoding �ڵ�����
	protected String esyscoding;
	//	eiversion �ڵ��汾
	protected String eiversion;
	//	eismallversion �ڵ�С�汾
	protected String eismallversion;
	//	linkid ��·ID
	@Id
	protected Integer linkid;
	//	linkorder ��·�ڵ�����
	@Id
	protected String linkorder;
	//	hostIP ����IP
	protected String hostIP;
	//	hostEiid ����EIID
	protected Integer hostEiid;
	protected Integer hostVersion;
	protected Integer hostSmallVersion;
	protected String hostEsyscoding;
	protected String resourceid;
	
	/**
	 * eiidȡ��
	 *
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}
	/**
	 * einameȡ��
	 *
	 * @return einame einame
	 */
	public String getEiname() {
		return einame;
	}
	/**
	 * esyscodingȡ��
	 *
	 * @return esyscoding esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**
	 * eiversionȡ��
	 *
	 * @return eiversion eiversion
	 */
	public String getEiversion() {
		return eiversion;
	}
	/**
	 * eismallversionȡ��
	 *
	 * @return eismallversion eismallversion
	 */
	public String getEismallversion() {
		return eismallversion;
	}
	/**
	 * linkidȡ��
	 *
	 * @return linkid linkid
	 */
	public Integer getLinkid() {
		return linkid;
	}
	/**
	 * linkorderȡ��
	 *
	 * @return linkorder linkorder
	 */
	public String getLinkorder() {
		return linkorder;
	}
	/**
	 * hostIPȡ��
	 *
	 * @return hostIP hostIP
	 */
	public String getHostIP() {
		return hostIP;
	}
	/**
	 * hostEiidȡ��
	 *
	 * @return hostEiid hostEiid
	 */
	public Integer getHostEiid() {
		return hostEiid;
	}
	/**
	 * eiid�趨
	 *
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 * einame�趨
	 *
	 * @param einame einame
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**
	 * esyscoding�趨
	 *
	 * @param esyscoding esyscoding
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * eiversion�趨
	 *
	 * @param eiversion eiversion
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}
	/**
	 * eismallversion�趨
	 *
	 * @param eismallversion eismallversion
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}
	/**
	 * linkid�趨
	 *
	 * @param linkid linkid
	 */
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}
	/**
	 * linkorder�趨
	 *
	 * @param linkorder linkorder
	 */
	public void setLinkorder(String linkorder) {
		this.linkorder = linkorder;
	}
	/**
	 * hostIP�趨
	 *
	 * @param hostIP hostIP
	 */
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	/**
	 * hostEiid�趨
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
