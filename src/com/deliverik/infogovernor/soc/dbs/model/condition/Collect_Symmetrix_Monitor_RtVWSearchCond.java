/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.model.condition;

/**
 * 
 * @Description:�洢ʵʱ��Ϣ��ͼCond�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtVWSearchCond {
	/**
	 *���к�
	 */
	public String getSymmid();
	
	/**
	 * ��ѯʱ�俪ʼ
	 */
	public String getDate_from();
		
	/**
	 * ��ѯʱ�����
	 */
	public String getDate_to();
	
	/**
	 * �洢����
	 */
	public String getServerType();
}
