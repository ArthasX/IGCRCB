/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ���յ�ָ���ϵ��������ʵ��
  * ��������: ���յ�ָ���ϵ��������ʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public class RiskToZhRelateVWSearchCondImpl implements
		RiskToZhRelateVWSearchCond {

	/**����*/
	protected String eiid;
	
	/**��ʶ��1 ���գ�0 �����*/
	protected String sign;

	/**
	 * ��ʶ��1���գ�0�����ȡ��
	 * @return sign ��ʶ��1���գ�0�����
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * ��ʶ��1���գ�0������趨
	 * @param sign ��ʶ��1���գ�0�����
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * ����ȡ��
	 * @return eiid ����
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �����趨
	 * @param eiid ����
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
}