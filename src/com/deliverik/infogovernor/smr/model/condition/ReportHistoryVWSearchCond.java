/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ʷ���¼��ͼ��ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ReportHistoryVWSearchCond {
	
	/**
	 * ������ȡ��
	 * @return prtype ������
	 */
	public String getPrtype();

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid();
	
	/**
	 * ��ǰ����IDȡ��
	 * @return currentPrid ��ǰ����ID
	 */
	public Integer getCurrentPrid();
}
