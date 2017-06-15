/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
 * ����: SOC0114VWTB_FX��������ʵ��
 * ��������: FX: Fuxin��������ʵ��
 * ������¼: 2013-10-26
 * �޸ļ�¼: 
 */
public class SOC0114VW_FXSearchCondImpl implements SOC0114VW_FXSearchCond {
	protected Integer eiid;
	protected Integer eiversion;
	protected Integer eismallversion;
	protected Integer domainid;
	protected Integer domainversion;
	protected String fingerprint;
	/**
	 * eiidȡ��
	 *
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}
	/**
	 * eiversiionȡ��
	 *
	 * @return eiversiion eiversiion
	 */
	public Integer getEiversion() {
		return eiversion;
	}
	/**
	 * eismallversionȡ��
	 *
	 * @return eismallversion eismallversion
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * domainidȡ��
	 *
	 * @return domainid domainid
	 */
	public Integer getDomainid() {
		return domainid;
	}
	/**
	 * domainversionȡ��
	 *
	 * @return domainversion domainversion
	 */
	public Integer getDomainversion() {
		return domainversion;
	}
	/**
	 * fingerprintȡ��
	 *
	 * @return fingerprint fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
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
	 * eiversiion�趨
	 *
	 * @param eiversiion eiversiion
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	/**
	 * eismallversion�趨
	 *
	 * @param eismallversion eismallversion
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	/**
	 * domainid�趨
	 *
	 * @param domainid domainid
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}
	/**
	 * domainversion�趨
	 *
	 * @param domainversion domainversion
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}
	/**
	 * fingerprint�趨
	 *
	 * @param fingerprint fingerprint
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
}