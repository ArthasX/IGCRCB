/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.condition;

/**
 * ����: �豸��ϵ��Ϣ�����ӿ�(VG-PV-Meta)
 * ��������: �豸��ϵ��Ϣ�����ӿ�(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public interface SOC0131SearchCond {
	/**
	 * Դ�ʲ�IDȡ��
	 * @return Դ�ʲ�ID
	 */
	public String getSrpareiid_eq();


	/**
	 * DomainIDȡ��
	 * @return DomainID
	 */
	public String getSrdomainid_eq();


	/**
	 * Domain�汾ȡ��
	 * @return Domain�汾
	 */
	public String getSrdomainversion_eq();


	/**
	 * Դ�ʲ���汾ȡ��
	 * @return Դ�ʲ���汾
	 */
	public String getSrparversion_eq();


	/**
	 * Դ�ʲ�С�汾ȡ��
	 * @return Դ�ʲ�С�汾
	 */
	public String getSrparsmallversion_eq();

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getSrcreatetime_eq();

}
