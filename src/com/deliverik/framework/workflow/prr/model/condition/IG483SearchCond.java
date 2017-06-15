/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ������ʵ������������ӿ�
  * ��������: ������ʵ������������ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG483SearchCond {

	/**
	 * �����鷢��������ȡ��
	 *
	 * @return �����鷢��������
	 */
	public String getPgrusername_like();

	/**
	 * �����鷢��ʱ�俪ʼȡ��
	 * @return �����鷢��ʱ�俪ʼ
	 */
	public String getPgropentime_begin();

	/**
	 * �����鷢��ʱ�����ȡ��
	 * @return �����鷢��ʱ�����
	 */
	public String getPgropentime_end();

	/**
	 * ���������к�ȡ��
	 *
	 * @return ���������к�
	 */
	public String getPgrserialnum_like();

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getPgrtitle_like();
	
	/**
	 * ����ģ������ȡ��
	 * 
	 * @return ����ģ������
	 */
	public String getPttype();

	/**
	 * �����ʶȡ��
	 * @return order �����ʶ
	 */
	public String getOrder();

	/**
	 * �����ֶ�ȡ��
	 * @return sing �����ֶ�
	 */
	public String getSing();
	
	/**
	 * �Ƿ���������趨
	 * @return �Ƿ��������
	 */
	public String getIstest();

	/**
	 * �����鶨��idȡ��
	 *
	 * @return �����鶨��id
	 */
	public String getPgdid();

	/**
	 * �������Ƿ�ر�ȡ��
	 * @return �������Ƿ�ر�
	 */
	public boolean isActive();

}