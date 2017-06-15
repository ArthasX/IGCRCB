/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>����:���̹�ͨ�����ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG202Info extends BaseModel {
	
	/**
	 * ���ܣ����̱�������IDȡ��
	 * @return ���̱�������ID
	 */
	public Integer getPidid();

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname();

	/**
	 * ���ܣ����̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel();

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPiddesc();

	/**
	 * ���ܣ����̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype();

	/**
	 * ���ܣ����̱���ѡ��ȡ��
	 * @return ���̱���ѡ��
	 */
	public String getPidoption();

	/**
	 * ���ܣ����̱���Ĭ��ֵȡ��
	 * @return ���̱���Ĭ��ֵ
	 */
	public String getPiddefault();

	/**
	 * ���ܣ����̱����Ƿ����ȡ��
	 * @return ���̱����Ƿ����
	 */
	public String getPidrequired();

	/**
	 * ���ܣ����̱��������ʶȡ��
	 * @return ���̱��������ʶ
	 */
	public String getPidsortid();

	/**
	 * ���ܣ��������̱���CCIDȡ��
	 * @return �������̱���CCID
	 */
	public String getCcid();

	public String getPidmode();
	
	/**
	 * ����Ϣ������ʾģʽȡ��
	 *
	 * @return ����Ϣ����ģʽ
	 */
	public String getRowwidth();
	
	/**
	 * ˽�б���Ȩ�޷�Χ�趨
	 * 
	 * @return ˽�б���Ȩ�޷�Χ
	 */
	public String getPrivatescope();
}
