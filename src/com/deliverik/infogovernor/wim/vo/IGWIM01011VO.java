/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;

/**
 * @Description ����������/�޸�VO
 * 
 * @date 2017��6��9��16:09:40
 * 
 * @author WangLiang
 *
 */
@SuppressWarnings("serial")
public class IGWIM01011VO extends BaseVO{

	/** Ƶ��Ϊ������ */
	protected String dayvalue;
	
	/** �Ƿ���ѡ���ʶ */
	protected String ischecked;
	
	/** Ƶ��Ϊ������ */
	protected String weekvalue;
	
	/** ��������ʾ */
	protected String weekdata;
	
	/** Сʱ���� */
	protected String hourvalue;
	
	/** ������ */
	protected String minutesvalue;
	
	/** ���������Ϣ */
	protected WorkDefinitionInfo workDefinitionInfo;
	
	/** Ƶ�������ڼ��� */
	protected List<IGWIM01011VO> weekList;
	
	/** Ƶ������������ */
	protected List<IGWIM01011VO> monthList;
	
	/** Ƶ��Сʱ���� */
	protected List<IGWIM01011VO> hourList;
	
	/** Ƶ�ʷּ��� */
	protected List<IGWIM01011VO> minutesList;
	
	/**
	 * Ƶ��Ϊ������ȡ��
	 * @return Ƶ��Ϊ������
	 */
	public String getDayvalue() {
		return dayvalue;
	}
	
	/**
	 * Ƶ��Ϊ�������趨
	 *
	 * @param dayvalue Ƶ��Ϊ������
	 */
	public void setDayvalue(String dayvalue) {
		this.dayvalue = dayvalue;
	}
	
	/**
	 * �Ƿ���ѡ���ʶȡ��
	 * @return �Ƿ���ѡ���ʶ
	 */
	public String getIschecked() {
		return ischecked;
	}
	
	/**
	 * �Ƿ���ѡ���ʶ�趨
	 *
	 * @param ischecked �Ƿ���ѡ���ʶ
	 */
	public void setIschecked(String ischecked) {
		this.ischecked = ischecked;
	}
	
	/**
	 * Ƶ��Ϊ������ȡ��
	 * @return Ƶ��Ϊ������
	 */
	public String getWeekvalue() {
		return weekvalue;
	}
	
	/**
	 * Ƶ��Ϊ�������趨
	 *
	 * @param weekvalue Ƶ��Ϊ������
	 */
	public void setWeekvalue(String weekvalue) {
		this.weekvalue = weekvalue;
	}
	
	/**
	 * ��������ʾȡ��
	 * @return ��������ʾ
	 */
	public String getWeekdata() {
		return weekdata;
	}
	
	/**
	 * ��������ʾ�趨
	 *
	 * @param weekdata ��������ʾ
	 */
	public void setWeekdata(String weekdata) {
		this.weekdata = weekdata;
	}

	/**
	 * ���������Ϣȡ��
	 * @return ���������Ϣ
	 */
	public WorkDefinitionInfo getWorkDefinitionInfo() {
		return workDefinitionInfo;
	}

	/**
	 * ���������Ϣ�趨
	 * @param ���������Ϣ
	 */
	public void setWorkDefinitionInfo(WorkDefinitionInfo workDefinitionInfo) {
		this.workDefinitionInfo = workDefinitionInfo;
	}

	/**
	 * Ƶ�������ڼ���ȡ��
	 * @return Ƶ�������ڼ���
	 */
	public List<IGWIM01011VO> getWeekList() {
		return weekList;
	}

	/**
	 * Ƶ�������ڼ����趨
	 * @param Ƶ�������ڼ���
	 */
	public void setWeekList(List<IGWIM01011VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * Ƶ������������ȡ��
	 * @return Ƶ������������
	 */
	public List<IGWIM01011VO> getMonthList() {
		return monthList;
	}

	/**
	 * Ƶ�������������趨
	 * @param Ƶ������������
	 */
	public void setMonthList(List<IGWIM01011VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * Сʱ����ȡ��
	 * @return Сʱ����
	 */
	public String getHourvalue() {
		return hourvalue;
	}

	/**
	 * Сʱ�����趨
	 * @param Сʱ����
	 */
	public void setHourvalue(String hourvalue) {
		this.hourvalue = hourvalue;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getMinutesvalue() {
		return minutesvalue;
	}

	/**
	 * �������趨
	 * @param ������
	 */
	public void setMinutesvalue(String minutesvalue) {
		this.minutesvalue = minutesvalue;
	}
	
	/**
	 * Ƶ��Сʱ����ȡ��
	 * @return Ƶ��Сʱ����
	 */
	public List<IGWIM01011VO> getHourList() {
		return hourList;
	}

	/**
	 * Ƶ��Сʱ�����趨
	 * @param Ƶ��Сʱ����
	 */
	public void setHourList(List<IGWIM01011VO> hourList) {
		this.hourList = hourList;
	}

	/**
	 * Ƶ�ʷּ���ȡ��
	 * @return Ƶ�ʷּ���
	 */
	public List<IGWIM01011VO> getMinutesList() {
		return minutesList;
	}

	/**
	 * Ƶ�ʷּ����趨
	 * @param Ƶ�ʷּ���
	 */
	public void setMinutesList(List<IGWIM01011VO> minutesList) {
		this.minutesList = minutesList;
	}
}
