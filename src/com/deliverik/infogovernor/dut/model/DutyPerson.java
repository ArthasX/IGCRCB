/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ֵ���˹���ʵ��ӿ�
 */
public interface DutyPerson extends BaseModel {	
	
	/**
	 * �����ID
	 */
	public Integer getDperid();

	/**
	 * ֵ��ƻ�ID
	 */
	public Integer getDpid();
	
	/**
	 * ֵ������
	 */
	public String getDpertime();
	
	/**
	 * �װ�/ҹ��
	 */
	public String getDptype();
	
	/**
	 * ֵ����ID
	 */
	public String getDperuserid();
	
	/**
	 * ֵ��������
	 */
	public String getDperusername();

}
