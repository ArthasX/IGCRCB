/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: OA��ɫ���ñ��������ʵ��
  * ��������: OA��ɫ���ñ��������ʵ��
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public class IG001SearchCondImpl implements
		IG001SearchCond {

	/** ָ��������صĽ�ɫ���� */
	protected String protype_eq;

	/**
	 * ָ��������صĽ�ɫ����ȡ��
	 *
	 * @return protype_eq ָ��������صĽ�ɫ����
	 */
	public String getProtype_eq() {
		return protype_eq;
	}

	/**
	 * ָ��������صĽ�ɫ�����趨
	 *
	 * @param protype_eq ָ��������صĽ�ɫ����
	 */
	public void setProtype_eq(String protype_eq) {
		this.protype_eq = protype_eq;
	}
	
}