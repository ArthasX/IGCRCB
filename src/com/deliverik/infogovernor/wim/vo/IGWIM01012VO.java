/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.wim.form.IGWIM0102Form;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;

/**
 * 
 * @Description �������ѯ/ɾ��VO
 *
 * @date 2017��6��14��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class IGWIM01012VO extends BaseVO{

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
	
	/** Ƶ�������ڼ��� */
	protected List<IGWIM01012VO> weekList;
	
	/** Ƶ������������ */
	protected List<IGWIM01012VO> monthList;
	
	/** Ƶ��Сʱ���� */
	protected List<IGWIM01012VO> hourList;
	
	/** Ƶ�ʷּ��� */
	protected List<IGWIM01012VO> minutesList;
	
	/** �������ѯForm */
	protected IGWIM0102Form igwim0102Form; 
	
	/** ��������Ϣ���� */
	protected List<WorkDefinitionInfo> definitionInfos;
	
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
	 * Ƶ�������ڼ���ȡ��
	 * @return Ƶ�������ڼ���
	 */
	public List<IGWIM01012VO> getWeekList() {
		return weekList;
	}

	/**
	 * Ƶ�������ڼ����趨
	 * @param Ƶ�������ڼ���
	 */
	public void setWeekList(List<IGWIM01012VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * Ƶ������������ȡ��
	 * @return Ƶ������������
	 */
	public List<IGWIM01012VO> getMonthList() {
		return monthList;
	}

	/**
	 * Ƶ�������������趨
	 * @param Ƶ������������
	 */
	public void setMonthList(List<IGWIM01012VO> monthList) {
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
	public List<IGWIM01012VO> getHourList() {
		return hourList;
	}

	/**
	 * Ƶ��Сʱ�����趨
	 * @param Ƶ��Сʱ����
	 */
	public void setHourList(List<IGWIM01012VO> hourList) {
		this.hourList = hourList;
	}

	/**
	 * Ƶ�ʷּ���ȡ��
	 * @return Ƶ�ʷּ���
	 */
	public List<IGWIM01012VO> getMinutesList() {
		return minutesList;
	}

	/**
	 * Ƶ�ʷּ����趨
	 * @param Ƶ�ʷּ���
	 */
	public void setMinutesList(List<IGWIM01012VO> minutesList) {
		this.minutesList = minutesList;
	}

	/**
	 * �������ѯFormȡ��
	 * @return �������ѯForm
	 */
	public IGWIM0102Form getIgwim0102Form() {
		return igwim0102Form;
	}

	/**
	 * �������ѯForm�趨
	 * @param �������ѯForm
	 */
	public void setIgwim0102Form(IGWIM0102Form igwim0102Form) {
		this.igwim0102Form = igwim0102Form;
	}

	/**
	 * ��������Ϣ����ȡ��
	 * @return ��������Ϣ����
	 */
	public List<WorkDefinitionInfo> getDefinitionInfos() {
		return definitionInfos;
	}

	/**
	 * ��������Ϣ�����趨
	 * @param ��������Ϣ����
	 */
	public void setDefinitionInfos(List<WorkDefinitionInfo> definitionInfos) {
		this.definitionInfos = definitionInfos;
	}
	
}
