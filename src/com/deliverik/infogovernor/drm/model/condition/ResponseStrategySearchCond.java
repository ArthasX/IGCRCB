/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ������Ӧ���Լ��������ӿ�
  * ��������: ������Ӧ���Լ��������ӿ�
  * ������¼: 2016/09/20
  * �޸ļ�¼: 
  */
public interface ResponseStrategySearchCond {
	/**
	 * ����id
	 */
	public Integer getSenceid();

	/**
	 * �ؼ���ƥ�� in
	 * 
	 * @return
	 */
	public String[] getKeyword_in();

	/**
	 * ����id����
	 * 
	 * @return
	 */
	public Integer[] getSenceids();
}