/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.condition;

/**
 * ����: �豸��ϵ��Ϣ����ʵ��(VG-PV-Meta)
 * ��������: �豸��ϵ��Ϣ����ʵ��(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class SOC0131SearchCondImpl implements SOC0131SearchCond{
	/**Դ�ʲ�ID*/
	protected String srpareiid_eq;
	
	/**DomainID*/
	protected String srdomainid_eq;
	
	/**Domain�汾*/
	protected String srdomainversion_eq;
	
	/**Դ�ʲ���汾*/
	protected String srparversion_eq;
	
	/**Դ�ʲ�С�汾*/
	protected String srparsmallversion_eq;
	
	/**����ʱ��*/
	protected String srcreatetime_eq;
	
	/**
	 * Դ�ʲ�IDȡ��
	 * @return Դ�ʲ�ID
	 */
	public String getSrpareiid_eq() {
		return srpareiid_eq;
	}

	/**
	 * Դ�ʲ�ID�趨
	 * @param srpareiidԴ�ʲ�ID
	 */
	public void setSrpareiid_eq(String srpareiid_eq) {
		this.srpareiid_eq = srpareiid_eq;
	}

	/**
	 * DomainIDȡ��
	 * @return DomainID
	 */
	public String getSrdomainid_eq() {
		return srdomainid_eq;
	}

	/**
	 * DomainID�趨
	 * @param srdomainidDomainID
	 */
	public void setSrdomainid_eq(String srdomainid_eq) {
		this.srdomainid_eq = srdomainid_eq;
	}

	/**
	 * Domain�汾ȡ��
	 * @return Domain�汾
	 */
	public String getSrdomainversion_eq() {
		return srdomainversion_eq;
	}

	/**
	 * Domain�汾�趨
	 * @param srdomainversionDomain�汾
	 */
	public void setSrdomainversion_eq(String srdomainversion_eq) {
		this.srdomainversion_eq = srdomainversion_eq;
	}

	/**
	 * Դ�ʲ���汾ȡ��
	 * @return Դ�ʲ���汾
	 */
	public String getSrparversion_eq() {
		return srparversion_eq;
	}

	/**
	 * Դ�ʲ���汾�趨
	 * @param srparversionԴ�ʲ���汾
	 */
	public void setSrparversion_eq(String srparversion_eq) {
		this.srparversion_eq = srparversion_eq;
	}

	/**
	 * Դ�ʲ�С�汾ȡ��
	 * @return Դ�ʲ�С�汾
	 */
	public String getSrparsmallversion_eq() {
		return srparsmallversion_eq;
	}

	/**
	 * Դ�ʲ�С�汾�趨
	 * @param srparsmallversionԴ�ʲ�С�汾
	 */
	public void setSrparsmallversion_eq(String srparsmallversion_eq) {
		this.srparsmallversion_eq = srparsmallversion_eq;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getSrcreatetime_eq() {
		return srcreatetime_eq;
	}

	/**
	 * ����ʱ���趨
	 * @param srcreatetime����ʱ��
	 */
	public void setSrcreatetime_eq(String srcreatetime_eq) {
		this.srcreatetime_eq = srcreatetime_eq;
	}

}
