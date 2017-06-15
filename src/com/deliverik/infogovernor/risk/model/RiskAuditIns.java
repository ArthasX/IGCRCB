/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ������Ʒ���ʵ��ӿ�
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskAuditIns  extends BaseModel {
	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid();

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
	 * ������Ʒ�����ȡ��
	 * @return ������Ʒ�����
	 */
	public String getRaicode();

	/**
	 * ������Ʒ��𴴽�����ȡ��
	 * @return ������Ʒ��𴴽�����
	 */
	public String getRaistart();

	/**
	 * ������Ʒ����������ȡ��
	 * @return ������Ʒ����������
	 */
	public String getRaiend();

	/**
	 * ������Ʒ�������ȡ��
	 * @return ������Ʒ�������
	 */
	public String getRaidesc();

	/**
	 * ������Ʒ���״̬ȡ��
	 * @return ������Ʒ���״̬
	 */
	public String getRaistatus();
}