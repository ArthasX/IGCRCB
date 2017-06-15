/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
 * ����: SOC0114VWTB_FX���������ӿ�
 * ��������: FX: Fuxin���������ӿ�
 * ������¼: 2013-10-26
 * �޸ļ�¼: 
 */
public interface SOC0114VW_FXSearchCond {
	/**
	 * eiidȡ��
	 *
	 * @return eiid eiid
	 */
	public Integer getEiid();
	/**
	 * eiversiionȡ��
	 *
	 * @return eiversiion eiversiion
	 */
	public Integer getEiversion();
	/**
	 * eismallversionȡ��
	 *
	 * @return eismallversion eismallversion
	 */
	public Integer getEismallversion();
	/**
	 * domainidȡ��
	 *
	 * @return domainid domainid
	 */
	public Integer getDomainid();
	/**
	 * domainversionȡ��
	 *
	 * @return domainversion domainversion
	 */
	public Integer getDomainversion();
	/**
	 * fingerprintȡ��
	 *
	 * @return fingerprint fingerprint
	 */
	public String getFingerprint();
}