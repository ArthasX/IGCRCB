/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * ����: ���ù������������ʵ��
  * ��������: ���ù������������ʵ��
  * ������¼: 2012/07/25
  * �޸ļ�¼: 
  */

public class InternalauditJobSearchCondImpl implements
		InternalauditJobSearchCond {

	/**
	 * ��ȼƻ�
	 */
	private String iajYear_q;
	/**
	 * ��������
	 */
	private String iajName_like;
	/**
	 * ������ĿID
	 */
	private Integer iajIapId_q;
	/**
	 * ��ȡiajYear_q
	 * @return fiajYear_q iajYear_q
	 */
	public String getIajYear_q() {
		return iajYear_q;
	}
	/**
	 * ����iajYear_q
	 * @param iajYear_q  iajYear_q
	 */
	public void setIajYear_q(String iajYear_q) {
		this.iajYear_q = iajYear_q;
	}
	/**
	 * ��ȡiajName_like
	 * @return fiajName_like iajName_like
	 */
	public String getIajName_like() {
		return iajName_like;
	}
	/**
	 * ����iajName_like
	 * @param iajName_like  iajName_like
	 */
	public void setIajName_like(String iajName_like) {
		this.iajName_like = iajName_like;
	}
	/**
	 * ��ȡiajIapId_q
	 * @return fiajIapId_q iajIapId_q
	 */
	public Integer getIajIapId_q() {
		return iajIapId_q;
	}
	/**
	 * ����iajIapId_q
	 * @param iajIapId_q  iajIapId_q
	 */
	public void setIajIapId_q(Integer iajIapId_q) {
		this.iajIapId_q = iajIapId_q;
	}
	
}