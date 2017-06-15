/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.model.Mss00008Info;

/**
 * �豸��־ʵʱ��ʾ
 * @author ��ʡ
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0101VO extends BaseVO implements Serializable {
	
	/** ʵʱ�豸��־�б� */
	private List<Mss00008Info> sysLogList;
	
	/** �澯�����б�(�ַ�����ʽ) */
	protected String alarmPrioritiesStr;
	
	protected String checkedPrioritiesStr;
	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** ʵʱ����ˢ��Ƶ�� */
	protected String refreshRate;
	
	/** �豸ʵʱ�澯��Ϣ�б�(������) */
	protected List<IGLOG0003VO> list_vo;
	
	/** ʵʱsyslogʵ�� */
	protected Mss00008Info syslogbean;
	
	/** �澯���� */
	protected Integer totalcount;
	
	/** ��ά��Ա */
	protected String isMaintain;
	
	public Integer getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}


	public Mss00008Info getSyslogbean() {
		return syslogbean;
	}

	public void setSyslogbean(Mss00008Info syslogbean) {
		this.syslogbean = syslogbean;
	}
	
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	public void setList_vo(List<IGLOG0003VO> list_vo) {
		this.list_vo = list_vo;
	}

	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}
	
	public List<CodeDetail> getAlarmPrioritiesList() {
		return alarmPrioritiesList;
	}

	public void setAlarmPrioritiesList(List<CodeDetail> alarmPrioritiesList) {
		this.alarmPrioritiesList = alarmPrioritiesList;
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
	
	/**
	 * ʵʱ�豸��־�б�ȡ��
	 * @return
	 */
	public List<Mss00008Info> getSysLogList() {
		return sysLogList;
	}
	
	/**
	 * ʵʱ�豸��־�б��趨
	 * @param sysLogList
	 */
	public void setSysLogList(List<Mss00008Info> sysLogList) {
		this.sysLogList = sysLogList;
	}

	/**
	 * ��ά��Ա��ʶȡ��
	 *
	 * @return isMaintain ��ά��Ա
	 */
	public String getIsMaintain() {
		return isMaintain;
	}
	
	/**
	 * ��ά��Ա�趨
	 *
	 * @param isMaintain ��ά��Ա
	 */
	public void setIsMaintain(String isMaintain) {
		this.isMaintain = isMaintain;
	}
	
}
