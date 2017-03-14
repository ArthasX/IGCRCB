/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
public class ChangeKpiSearchCondImpl implements ChangeKpiSearchCond{
	
	/**��ȡ���*/
	protected String kpiYear;
	
	/**��ȡ�·�*/
	protected String kpiMonth;
	
	/**��ʼʱ��*/
	protected String kpiOpenTime;
	
	/**����ʱ��*/
	protected String kpiEndTime;

	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getKpiYear() {
		return kpiYear;
	}

	/**
	 * �����·�
	 * @param kpiMonth �·�
	 */
	public void setKpiYear(String kpiYear) {
		this.kpiYear = kpiYear;
	}

	/**
	 * ��ȡ�·�
	 * @return �·�
	 */
	public String getKpiMonth() {
		return kpiMonth;
	}

	/**
	 * �������
	 * @param kpiYear ���
	 */
	public void setKpiMonth(String kpiMonth) {
		this.kpiMonth = kpiMonth;
	}

	/**
	 * ��ȡ��ʼʱ��
	 * @return ��ʼʱ��
	 */
	public String getKpiOpenTime() {
		return kpiOpenTime;
	}

	/**
	 * ���ÿ�ʼʱ��
	 * @param kpiOpenTime ��ʼʱ��
	 */
	public void setKpiOpenTime(String kpiOpenTime) {
		this.kpiOpenTime = kpiOpenTime;
	}

	/**
	 * ��ȡ����ʱ��
	 * @return ����ʱ��
	 */
	public String getKpiEndTime() {
		return kpiEndTime;
	}

	/**
	 * ���ý���ʱ��
	 * @param kpiEndTime ����ʱ��
	 */
	public void setKpiEndTime(String kpiEndTime) {
		this.kpiEndTime = kpiEndTime;
	}
	
}
