/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ֵ��������ʵ��ӿ�
 * 
 */
public interface DutyResult  extends BaseModel {

	/**
	 * ֵ��������IDȡ��
	 * @return ֵ��������ID
	 */
	public Integer getDrid();

	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�ID
	 */
	public Integer getDpid();

	/**
	 * �����IDȡ��
	 * @return �����ID
	 */
	public Integer getDadid();
	
	/**
	 * ֵ������
	 */
	public String getDadcategory();

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getDadtype();

	/**
	 * ֵ������
	 */
	public String getDptime();
	
	/**
	 * �װ�/ҹ��
	 */
	public String getDptype();
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getDadname();

	/**
	 * ���ʱ��ȡ��
	 * @return ���ʱ��
	 */
	public String getDattime();

	/**
	 * �ʱ������ȡ��
	 * @return �ʱ������
	 */
	public String getDatlimtime();

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getDadcontent();

	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getDrcontent();

	/**
	 * ʵ���ʱ��ȡ��
	 * @return ʵ���ʱ��
	 */
	public String getDrfilltime();

	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String getDrresult();

	/**
	 * �������д��IDȡ��
	 * @return �������д��ID
	 */
	public String getDruserid();

	/**
	 * �������д������ȡ��
	 * @return �������д������
	 */
	public String getDrusername();

	/**
	 * �������дʱ��ȡ��
	 * @return �������дʱ��
	 */
	public String getDrcretime();
	
	/** ��ա�ʱ����ȡ��
	 * @return ��ա�ʱ����
	 */
	public String getDrlimdtime();
	
}