/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����鶨���ӿ�
  * ��������: �����鶨���ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG480Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPgdid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPgdname();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPgddesc();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getPgdstatus();

	/**
	 * ����ͼxmlȡ��
	 *
	 * @return ����ͼxml
	 */
	public String getPgdxml();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getPgdcrtime();

	/**
	 * ���к����ɴ�����ȡ��
	 *
	 * @return ���к����ɴ�����
	 */
	public String getSerialGenerator();

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public Integer getPtid();

}