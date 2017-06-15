/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;

/**
 * �豸��־�澯ʵʱ��ʾ
 * @author ��ʡ
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0001VO extends BaseVO implements Serializable {
	
	/** ʵʱ�豸��־�澯�б� */
	private List<Mss00005Info> sysLogAlarmList;
	
	/** �澯���� */
	protected Integer totalcount;
	
	/** �豸ʵʱ�澯��Ϣ�б�(������) */
	protected List<IGLOG0003VO> list_vo;
	
	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** �澯�����б�(�ַ�����ʽ) */
	protected String alarmPrioritiesStr;
	
	protected String checkedPrioritiesStr;
	
	/** ˢ��Ƶ�� */
	protected String refreshRate;
	
	
	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}


	public String getCheckedPrioritiesStr() {
		return checkedPrioritiesStr;
	}

	public void setCheckedPrioritiesStr(String checkedPrioritiesStr) {
		this.checkedPrioritiesStr = checkedPrioritiesStr;
	}

	public String getAlarmPrioritiesStr() {
		return alarmPrioritiesStr;
	}

	public void setAlarmPrioritiesStr(String alarmPrioritiesStr) {
		this.alarmPrioritiesStr = alarmPrioritiesStr;
	}
	
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}

	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
	}
	
	/**
	 * ʵʱ�豸��־�澯�б�ȡ��
	 * @return
	 */
	public List<Mss00005Info> getSysLogAlarmList() {
		return sysLogAlarmList;
	}
	
	/**
	 * ʵʱ�豸��־�澯�б��趨
	 * @param sysLogAlarmList
	 */
	public void setSysLogAlarmList(List<Mss00005Info> sysLogAlarmList) {
		this.sysLogAlarmList = sysLogAlarmList;
	}

	/**
	 * �澯����ȡ��
	 */
	public Integer getTotalcount() {
		return totalcount;
	}

	/**
	 * �澯�����趨
	 */
	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}
		/**
	 * �豸ʵʱ�澯��Ϣ�б�(������)ȡ��
	 */
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	/**
	 * �豸ʵʱ�澯��Ϣ�б�(������)�趨
	 */
	public void setList_vo(List<IGLOG0003VO> list_vo) {
		this.list_vo = list_vo;
	}
	
	

}
