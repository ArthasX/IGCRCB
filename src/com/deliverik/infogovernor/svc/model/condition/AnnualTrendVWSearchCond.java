/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ�Ʋ�ѯ�����ӿ�
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public interface AnnualTrendVWSearchCond {
	
	/**
	 * ���ȡ��
	 * @return year ���
	 */
	public String getYear();

	/**
	 * ����idȡ��
	 * @return orgid ����id
	 */
	public String getOrgid();
}
