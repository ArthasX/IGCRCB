/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model.condition;
/**
 * ����:���ȼ���ѯ�ӿ�
 * ����������1.Ӱ���ֵȡ��
 * 			2.���ȼ�ֵȡ��
 * 			3.������ֵȡ��
 * 			4.��������ȡ��
 * ������¼��fangyunlong@deliverik.com    2010/12/14
 */
public interface PrioritySearchCond {
	
	/**
	 *Ӱ���ֵȡ��
	 * 
	 * @return Ӱ���ֵ
	 */
	public String getIvalue();

	/**
	 *���ȼ�ֵȡ��
	 * 
	 * @return ���ȼ�ֵ
	 */
	public String getPvalue();

	/**
	 *������ֵȡ��
	 * 
	 * @return ������ֵ
	 */
	public String getUvalue();
	
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getPprtype();

}
