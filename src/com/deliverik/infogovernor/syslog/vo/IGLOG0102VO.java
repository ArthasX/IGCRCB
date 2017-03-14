/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;

/**
 * ��ʷ�豸��־��ʾ
 * @author ��ʡ
 *	
 */
@SuppressWarnings("serial")
public class IGLOG0102VO extends BaseVO implements Serializable {
	
	/** ��ʷ�豸��־�б� */
	private List historySysLogList;

	/** �澯�����б�(�ַ�����ʽ) */
	protected String alarmPrioritiesStr;
	
	protected List<CodeDetail>ruleli=null;
	
	protected List<IGLOG0003VO> list_vo;
	
	public List<IGLOG0003VO> getList_vo() {
		return list_vo;
	}

	public void setList_vo(List<IGLOG0003VO> list_vo) {
		this.list_vo = list_vo;
	}

	public List<CodeDetail> getRuleli() {
		return ruleli;
	}

	public void setRuleli(List<CodeDetail> ruleli) {
		this.ruleli = ruleli;
	}

	protected String checkedPrioritiesStr;
	
	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
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
	 * ��ʷ�豸��־�б�ȡ��
	 * @return
	 */
	public List getHistorySysLogList() {
		return historySysLogList;
	}
	
	/**
	 * ��ʷ�豸��־�б��趨
	 * @param historySysLogList
	 */
	public void setHistorySysLogList(List historySysLogList) {
		this.historySysLogList = historySysLogList;
	}
	
}
