/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;

/**
 * ��ʷ�豸��־�澯��ʾ
 * @author ��ʡ
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0002VO extends BaseVO implements Serializable {
	
	/** ��ʷ�豸��־�澯�б� */
	private List<Mss00005Info> historySysLogAlarmList;
	
	/** �澯���� */
	protected Integer totalcount; 
	
	
	/** �澯�����б�(�ַ�����ʽ) */
	protected String alarmPrioritiesStr;
	
	
	protected String checkedPrioritiesStr;
	
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
	/**
	 * ��ʷ�豸��־�澯�б�ȡ��
	 * @return
	 */
	public List<Mss00005Info> getHistorySysLogAlarmList() {
		return historySysLogAlarmList;
	}
	
	/**
	 * ��ʷ�豸��־�澯�б��趨
	 * @param historySysLogAlarmList
	 */
	public void setHistorySysLogAlarmList(List<Mss00005Info> historySysLogAlarmList) {
		this.historySysLogAlarmList = historySysLogAlarmList;
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
	
}
