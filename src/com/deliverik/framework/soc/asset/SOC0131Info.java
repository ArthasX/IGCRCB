/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;

/**
 * ����: �豸��ϵ��Ϣ(VG-PV-Meta)
 * ��������: �豸��ϵ��Ϣ(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface SOC0131Info {

	/**
	 * VG_Nameȡ��
	 * @return VG_Name
	 */
	public String getVgName();


	
	/**
	 * PseudoNameȡ��
	 * @return PseudoName
	 */
	public String getPseudoName() ;


	/**
	 * IOPathsȡ��
	 * @return IOPaths
	 */ 
	public String getIoPaths() ;
	
	
	/**
	 * HBAPathȡ��
	 * @return HBAPath
	 */
	public String getHbaPath();
	

	
	/**
	 * SymmSnȡ��
	 * @return SymmSn
	 */
	public String getSymmSn();

	
	/**
	 * SymFaPortȡ��
	 * @return SymFaPort
	 */
	public String getSymFaPort();

	/**
	 * SymLogicalDeviceȡ��
	 * @return SymLogicalDevice
	 */
	public String getSymLogicalDevice();
	
}
