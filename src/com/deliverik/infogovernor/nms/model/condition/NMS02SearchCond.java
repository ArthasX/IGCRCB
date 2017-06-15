/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: SNMP������Ϣʵ���ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS02SearchCond {

	/**
	 * ɾ����ʶȡ��
	 * @return ɾ����ʶ
	 */
	public String getDeleteflag();

	/**
	 * SNMP�汾ȡ��
	 * @return SNMP�汾
	 */
	public Integer getSnmpVersion();

	/**
	 * �˿�ȡ��
	 * @return �˿�
	 */
	public Integer getSnmpPort();

	/**
	 * ��ȡ������ȡ��
	 * @return ��ȡ������
	 */
	public String getReadCommit();

	/**
	 * V3��ȫ�û�ȡ��
	 * @return V3��ȫ�û�
	 */
	public String getSnmpUser();

	/**
	 * V3�����֤����ȡ��
	 * @return V3�����֤����
	 */
	public String getSnmpPassword();

}
