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
public interface IG708Info {
	
	/**
	 * checkbox��ʶ
	 */
	public String getFlag();
	/**
	 *����
	 */
	public Integer getPadid();

	/**
	 *Ӱ��ϵͳ
	 */
	public String getPadaffectsystem();
	
	/**
	 *Ӱ��ϵͳ����
	 */
	public String getPadaffectsystemname();

	/**
	 *Ӱ�쿪ʼʱ��
	 */
	public String getPadstart();

	/**
	 *Ӱ�����ʱ��
	 */
	public String getPadend();

}

