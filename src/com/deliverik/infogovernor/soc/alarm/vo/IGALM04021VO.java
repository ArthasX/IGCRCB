package com.deliverik.infogovernor.soc.alarm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
//VO
public class IGALM04021VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;

	/** �澯��Ϣ��ѯ */
	private List<CRM04Info> igalm0401List;
	
	/** �澯�����б�(�ַ�����ʽ) */
	protected String alarmPrioritiesStr;
	
	protected String checkedPrioritiesStr;
	
	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** ʵʱ����ˢ��Ƶ�� */
	protected String refreshRate;
	
	
	/**
	 * igalm0401Listȡ��
	 *
	 * @return igalm0401List igalm0401List
	 */
	public List<CRM04Info> getIgalm0401List() {
		return igalm0401List;
	}
	/**
	 * igalm0401List�趨
	 *
	 * @param igalm0401List igalm0401List
	 */
	public void setIgalm0401List(List<CRM04Info> igalm0401List) {
		this.igalm0401List = igalm0401List;
	}
	
	/**
	 * alarmPrioritiesStrȡ��
	 *
	 * @return alarmPrioritiesStr
	 */
	public String getAlarmPrioritiesStr() {
		return alarmPrioritiesStr;
	}
	
	/**
	 * alarmPrioritiesStr�趨
	 *
	 * @param String igalm0401List
	 */
	public void setAlarmPrioritiesStr(String alarmPrioritiesStr) {
		this.alarmPrioritiesStr = alarmPrioritiesStr;
	}
	
	/**
	 * alarmPrioritiesListȡ��
	 *
	 * @return alarmPrioritiesList alarmPrioritiesList
	 */
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}
	
	/**
	 * alarmPrioritiesList�趨
	 *
	 * @param List<CodeDetail> alarmPrioritiesList
	 */
	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}
	
	/**
	 * refreshRateȡ��
	 *
	 * @return refreshRate refreshRate
	 */
	public String getRefreshRate() {
		return refreshRate;
	}
	
	/**
	 * refreshRate�趨
	 *
	 * @param String refreshRate
	 */
	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}
	
	/**
	 * checkedPrioritiesStrȡ��
	 *
	 * @return checkedPrioritiesStr checkedPrioritiesStr
	 */
	public String getCheckedPrioritiesStr() {
		return checkedPrioritiesStr;
	}	
	
	/**
	 * checkedPrioritiesStr�趨
	 *
	 * @param String checkedPrioritiesStr
	 */
	public void setCheckedPrioritiesStr(String checkedPrioritiesStr) {
		this.checkedPrioritiesStr = checkedPrioritiesStr;
	}
	
	
}
