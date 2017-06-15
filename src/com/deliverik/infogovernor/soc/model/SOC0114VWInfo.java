/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.model;

/**
 * ����: SOC0114VWInfo_FX
 * ��������: FX: Fuxin
 * ������¼: 2013-10-26
 * �޸ļ�¼: 
 */
public interface SOC0114VWInfo {
	/**
	 * eiidȡ��
	 *
	 * @return eiid eiid
	 */
	public Integer getEiid();
	/**
	 * einameȡ��
	 *
	 * @return einame einame
	 */
	public String getEiname();
	/**
	 * esyscodingȡ��
	 *
	 * @return esyscoding esyscoding
	 */
	public String getEsyscoding();
	/**
	 * eiversionȡ��
	 *
	 * @return eiversion eiversion
	 */
	public String getEiversion();
	/**
	 * eismallversionȡ��
	 *
	 * @return eismallversion eismallversion
	 */
	public String getEismallversion();
	/**
	 * linkidȡ��
	 *
	 * @return linkid linkid
	 */
	public Integer getLinkid();
	/**
	 * linkorderȡ��
	 *
	 * @return linkorder linkorder
	 */
	public String getLinkorder();
	/**
	 * hostIPȡ��
	 *
	 * @return hostIP hostIP
	 */
	public String getHostIP();
	/**
	 * hostEiidȡ��
	 *
	 * @return hostEiid hostEiid
	 */
	public Integer getHostEiid();
	
	public Integer getDomainid();
	
	public Integer getDomainversion();
	
	public Integer getHostVersion() ;
	
	public Integer getHostSmallVersion();
	
	public String getResourceid();
	
	public String getHostEsyscoding();
}
