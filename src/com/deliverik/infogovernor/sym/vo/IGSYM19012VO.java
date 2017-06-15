/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
/**
 * ����:��Ϣ����ģ�廭������VO
 * ������¼�����    2011/10/18
 * ����������SOCԭ��Ϣʱ���趨
 * �޸�ʱ�䣺LuJiayuan 2013/01/29 ����ϲ���ԭIGSYM17012VO����IGSYM19012VO
 */
@SuppressWarnings("serial")
public class IGSYM19012VO extends BaseVO implements Serializable{
	
	/**
	 * ���
	 */
	protected String year;
	
	/**
	 * �·�
	 */
	protected String month;
	
	/**
	 * ��
	 */
	protected String day;
	
	/**
	 * ��ʱ
	 */
	protected Integer factTime;
	
	/**
	 * ������Ԫ����ɫ
	 */
	protected String cellColor;
	
	/**
	 * ������ɫ
	 */
	protected String dayColor;
	
	/**
	 * ����
	 */
	protected Integer pwtId;
	
	/**
	 * �ڼ���
	 */
	protected Integer pwtSleepTime;
	
	/**
	 * �ջ�ȡ
	 * @return
	 */
	public String getDay() {
		return day;
	}

	/**
	 * ���趨
	 * @param day
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * ��ʱ��ȡ
	 * @return
	 */
	public Integer getFactTime() {
		return factTime;
	}

	/**
	 * ��ʱ�趨
	 * @param factTime
	 */
	public void setFactTime(Integer factTime) {
		this.factTime = factTime;
	}

	/**
	 * ������Ԫ����ɫ��ȡ
	 * @return
	 */
	public String getCellColor() {
		return cellColor;
	}

	/**
	 * ������Ԫ����ɫ�趨
	 * @param color
	 */
	public void setCellColor(String cellColor) {
		this.cellColor = cellColor;
	}

	/**
	 * ������ȡ
	 * @return
	 */
	public Integer getPwtId() {
		return pwtId;
	}

	/**
	 * �����趨
	 * @param pwtId
	 */
	public void setPwtId(Integer pwtId) {
		this.pwtId = pwtId;
	}

	/**
	 * ��ѯ��ݻ�ȡ
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ��ѯ����趨
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * �·ݻ�ȡ
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * �ڼ��ջ�ȡ
	 * @return
	 */
	public Integer getPwtSleepTime() {
		return pwtSleepTime;
	}

	/**
	 * �ڼ����趨
	 * @param pwtSleepTime
	 */
	public void setPwtSleepTime(Integer pwtSleepTime) {
		this.pwtSleepTime = pwtSleepTime;
	}

	/**
	 * ������ɫ��ȡ
	 * @return
	 */
	public String getDayColor() {
		return dayColor;
	}

	/**
	 * ������ɫ�趨
	 * @param dayColor
	 */
	public void setDayColor(String dayColor) {
		this.dayColor = dayColor;
	}
}
