/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ʷ���¼��ͼʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ReportHistoryVWInfo {

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid() ;

	/**
	 * ���ʶȡ��
	 * @return key ���ʶ
	 */
	public String getKey() ;

	/**
	 * ������ȡ��
	 * @return prtype ������
	 */
	public String getPrtype() ;

	/**
	 * ˵��ȡ��
	 * @return reportdesc ˵��
	 */
	public String getReportdesc();
}
