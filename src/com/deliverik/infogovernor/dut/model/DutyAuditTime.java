/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;
/**
 * 
 * ֵ��������ʱ��ӿ�
 *
 */
public interface DutyAuditTime  extends BaseModel{
	/**
	 * 
	 * ���ʱ��IDȡ��
	 * @return ���ʱ��ID
	 */
	public  Integer getDatid();
	
	/**
	 * 
	 * �����IDȡ��
	 * @return �����ID
	 */
	public  Integer getDadid();
	
	/**
	 * 
	 * ���ʱ��ȡ��
	 * @return ���ʱ��
	 */
	public  String getDattime ();
	
	/**
	 * 
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getDatlimtime();
	
}