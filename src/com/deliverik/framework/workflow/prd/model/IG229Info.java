/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

 /**
  * ����:����������ϸ��¼��ӿ�
  * ��������������������ϸ��¼��ӿ�
  *           
  * ������¼��wangxiaoqiang    2010/11/29
  */
public interface IG229Info {
	/**
	 *����
	 */
	public Integer getPadid();

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

