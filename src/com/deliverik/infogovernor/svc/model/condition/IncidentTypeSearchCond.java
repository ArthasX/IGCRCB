/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ�Ʋ�ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentTypeSearchCond {
	
	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid();

	/**
	 * ���ȡ��
	 * @return year ���
	 */
	public String getYear();

	/**
	 * �·�ȡ��
	 * @return month �·�
	 */
	public String getMonth();
}
