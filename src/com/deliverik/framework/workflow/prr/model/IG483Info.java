/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������ʵ����ӿ�
  * ��������: ������ʵ����ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG483Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPgrid();

	/**
	 * �����鷢����idȡ��
	 *
	 * @return �����鷢����id
	 */
	public String getPgruserid();

	/**
	 * �����鷢��������ȡ��
	 *
	 * @return �����鷢��������
	 */
	public String getPgrusername();

	/**
	 * �����鷢��ʱ��ȡ��
	 *
	 * @return �����鷢��ʱ��
	 */
	public String getPgropentime();

	/**
	 * ������ر�ʱ��ȡ��
	 *
	 * @return ������ر�ʱ��
	 */
	public String getPgrclosetime();

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public Integer getOcount();

	/**
	 * �ر���������ȡ��
	 *
	 * @return �ر���������
	 */
	public Integer getCcount();

	/**
	 * ���������к�ȡ��
	 *
	 * @return ���������к�
	 */
	public String getPgrserialnum();

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getPgrtitle();

	/**
	 * �����鷢���˻�����ȡ��
	 *
	 * @return �����鷢���˻�����
	 */
	public String getPgrorgid();

	/**
	 * �����鷢���˻�������ȡ��
	 *
	 * @return �����鷢���˻�������
	 */
	public String getPgrorgname();

	/**
	 * �����鶨��idȡ��
	 *
	 * @return �����鶨��id
	 */
	public String getPgdid();

	/**
	 * �����鶨������ȡ��
	 *
	 * @return �����鶨������
	 */
	public String getPgdname();
	
	/**
	 * ����ģ������ȡ��
	 * 
	 * @return ����ģ������
	 */
	public String getPttype();
	
	/**
	 * �Ƿ���������趨
	 * @return �Ƿ��������
	 */
	public String getIstest();

}