/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: �����鶨�����������ӿ�
  * ��������: �����鶨�����������ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG480SearchCond {
	/**
	 * �����鶨��IDȡ��
	 * @return �����鶨��ID
	 */
	public String getPgdid_like();

	/**
	 * ���� (like)
	 * @return
	 */
	public String getPgddesc();
	/**
	 * �����鶨������
	 * @return
	 */
	public String getPgdname_like();
	/**
	 * ������״̬
	 * @return
	 */
	public String getPgdstatus();
	/**
	 * ������ģ������
	 * @return
	 */
	public Integer getPtid();
	
}