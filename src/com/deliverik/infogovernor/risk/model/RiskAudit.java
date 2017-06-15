/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * �������ʵ��ӿ�
 * 
 * @author lipeng@deliverik.com
 * 
 */

public interface RiskAudit extends BaseModel {
	/**
	 * �������IDȡ��
	 * 
	 * @return �������ID
	 */
	public Integer getRaid();

	/**
	 * ������ư汾ȡ��
	 * 
	 * @return ������ư汾
	 */
	public String getRaversion();
	
	/**
	 * ������ƴ�������ȡ��
	 * 
	 * @return ������ƴ�������
	 */
	public String getRadate();
	
	/**
	 * ������ƴ�����IDȡ��
	 * 
	 * @return ������ƴ�����ID
	 */
	public String getRauserid();
	
	/**
	 * ������ƴ���������ȡ��
	 * 
	 * @return ������ƴ���������
	 */
	public String getRausername();

	/**
	 * �����������ȡ��
	 * 
	 * @return �����������
	 */
	public String getRadesc();

	/**
	 * �������״̬ȡ��
	 * 
	 * @return �������״̬
	 */
	public String getRastatus();
	
	/**
	 * ������Ƹ���ʶȡ��
	 * 
	 * @return ������Ƹ���ʶ
	 */
	public String getRacode();

}