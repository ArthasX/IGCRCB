/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>����:���̹�ͨ����ʵ��ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG787Info {
	/**
	 * ���ܣ����̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();

	
	/**
	 * ���ܣ���ͨ��������ȡ��
	 * @return ��ͨ��������
	 */
	public String getGeneralname();

	/**
	 * ���ܣ���ͨ����IDȡ��
	 * @return ��ͨ����ID
	 */
	public Integer getPidgid();

	/**
	 * ���ܣ���ͨ����ֵȡ��
	 * @return ��ͨ����ֵ
	 */
	public String getGeneralvalue();
}