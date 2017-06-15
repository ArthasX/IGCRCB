/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_�¼�KPI��ѯForm
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0701Form extends BaseForm implements IncidentKpiSearchCond{

	/**��ȡ���*/
	protected String kpiYear;
	
	/**��ȡ�·�*/
	protected String kpiMonth;
	
	/**��ʼʱ��*/
	protected String kpiOpenTime;
	
	/**����ʱ��*/
	protected String kpiEndTime;
	
	/**��ʾ��ʽ*/
	protected String radioValue;

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

	public String getKpiOpenTime() {
		return kpiOpenTime;
	}

	public void setKpiOpenTime(String kpiOpenTime) {
		this.kpiOpenTime = kpiOpenTime;
	}

	public String getKpiEndTime() {
		return kpiEndTime;
	}

	public void setKpiEndTime(String kpiEndTime) {
		this.kpiEndTime = kpiEndTime;
	}
	
	/**
	 * ��ȡ����ʱ��
	 * @return ��ʾ��ʽ
	 */
	public String getRadioValue() {
		return radioValue;
	}

	/**
	 * ���ý���ʱ��
	 * @param radioValue ��ʾ��ʽ
	 */
	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}
}
