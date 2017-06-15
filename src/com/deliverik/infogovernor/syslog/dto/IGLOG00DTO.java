package com.deliverik.infogovernor.syslog.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.syslog.form.IGLOG0001Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0002Form;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.vo.IGLOG0003VO;

@SuppressWarnings("serial")
public class IGLOG00DTO extends BaseDTO implements Serializable{
	
	/** ʵʱ�澯��ϢForm */
	protected IGLOG0001Form iglog0001Form;
	
	/** ��ʷ�澯��ϢForm */
	protected IGLOG0002Form iglog0002Form;
	
	/** ���������� */
	protected int maxSearchCount;
	
	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ���ʻ���Ϣ */
	protected Locale locale;
	
	/** �豸ʵʱ�澯��Ϣ�б� */
	protected List<Mss00005Info> SysLogAlarmList;
	
	/** �豸��ʷ�澯��Ϣ�б� */
	protected List HistorySysLogAlarmList;//��Ϊ�����������л�����ݣ�������涨����
	
	/**�澯����*/
	protected Integer totalcount;
	
	/** �豸ʵʱ�澯��Ϣ�б�(������) */
	protected List<IGLOG0003VO> list_vo;
	
	/** ʵʱ����ˢ��Ƶ�� */
	protected String refreshRate;
	
	
	public String getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(String refreshRate) {
		this.refreshRate = refreshRate;
	}

	/** �澯�����б� */
	protected List<CodeDetail> alarmPrioritiesList;
	
	/** �澯�����б�(�ַ�����ʽ) */
	protected String alarmPrioritiesStr;
	
	
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

	public IGLOG0001Form getIglog0001Form() {
		return iglog0001Form;
	}

	public void setIglog0001Form(IGLOG0001Form iglog0001Form) {
		this.iglog0001Form = iglog0001Form;
	}


	public List<Mss00005Info> getSysLogAlarmList() {
		return SysLogAlarmList;
	}

	public void setSysLogAlarmList(List<Mss00005Info> sysLogAlarmList) {
		SysLogAlarmList = sysLogAlarmList;
	}

	public IGLOG0002Form getIglog0002Form() {
		return iglog0002Form;
	}

	public void setIglog0002Form(IGLOG0002Form iglog0002Form) {
		this.iglog0002Form = iglog0002Form;
	}

	public List getHistorySysLogAlarmList() {
		return HistorySysLogAlarmList;
	}

	public void setHistorySysLogAlarmList(List historySysLogAlarmList) {
		HistorySysLogAlarmList = historySysLogAlarmList;
	}
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
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
