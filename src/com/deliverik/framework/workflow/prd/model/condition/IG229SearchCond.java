/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

 /**
  * ����:����������ϸ��¼��Cond�ӿ�
  * ����������
  *           
  * ������¼��wangxiaoqiang    2010/11/29
  */
public interface IG229SearchCond {
	/**
	 *����ID
	 */
	public Integer getPadprid();

	/**
	 *Ӱ��ϵͳ
	 */
	public String getPadaffectsystem();

	/**
	 *Ӱ�쿪ʼʱ��
	 */
	public String getPadstart();

	/**
	 *Ӱ�����ʱ��
	 */
	public String getPadend();

}

