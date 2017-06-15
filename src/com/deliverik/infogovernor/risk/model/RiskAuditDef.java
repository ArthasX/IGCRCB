/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���������ʵ��ӿ�
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDef  extends BaseModel {
	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid();

	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getRaid();

	/**
	 * ������ư汾ȡ��
	 * @return ������ư汾
	 */
	public String getRaversion();

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadname();

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode();

	/**
	 * ����������ϼ������ȡ��
	 * @return ����������ϼ������
	 */
	public String getRadparcode();
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getRadlevel();

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRaddesc();

	/**
	 * �����������ճ̶�ȡ��
	 * @return �����������ճ̶�
	 */
	public String getRadrisklevel();

	/**
	 * ���������������IDȡ��
	 * @return ���������������ID
	 */
	public String getRaduserid();

	/**
	 * �������������������ȡ��
	 * @return �������������������
	 */
	public String getRadusername();

	/**
	 * ������������β���ȡ��
	 * @return ������������β���
	 */
	public String getRadorg();
	
	/**
	 * ������������β��ű���ȡ��
	 * @return ������������β��ű���
	 */
	public String getRadorgcoding();

	/**
	 * �������������ֶ�ȡ��
	 * @return �������������ֶ�
	 */
	public String getRadmode();

	/**
	 * ����������������ȡ��
	 * @return ����������������
	 */
	public String getRadtype();

	/**
	 * ������������Ƶ��ȡ��
	 * @return ������������Ƶ��
	 */
	public String getRadfrequency();
	
	/**
	 * ���������״̬ȡ��
	 * @return ���������״̬
	 */
	public String getRadstatus();

}