/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ����ָ��չʾ���ݲ�ѯ��������ʵ��
  * ��������: ����ָ��չʾ���ݲ�ѯ��������ʵ��
  * ������¼: 2014/07/26
  * �޸ļ�¼: 
  */
public class RiskIndexContextVWSearchCondImpl implements
		RiskIndexContextVWSearchCond {

	/**����*/
	protected String esyscoding;

	/**
	 * ����ȡ��
	 * @return esyscoding ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �����趨
	 * @param esyscoding ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
}