/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_ͳ�ƻ���_���kpi��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface ChangeKpiSearchCond {
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getKpiYear();
	
	/**
	 * ��ȡ�·�
	 * @return �·�
	 */
	public String getKpiMonth();
	
	/**
	 * ��ȡ��ʼʱ��
	 * @return ��ʼʱ��
	 */
	public String getKpiOpenTime();
	
	/**
	 * ��ȡ����ʱ��
	 * @return ����ʱ��
	 */
	public String getKpiEndTime();

}