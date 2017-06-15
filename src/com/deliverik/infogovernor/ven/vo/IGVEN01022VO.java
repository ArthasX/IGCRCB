package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * ���ռ����Ϣ��������֣�
 *
 */
@SuppressWarnings("serial")
public class IGVEN01022VO extends BaseVO implements Serializable{
	/** Ƶ��Ϊ������ */
	protected String dayvalue;
	
	/** �Ƿ���ѡ���ʶ */
	protected String ischecked;
	
	/** Ƶ��Ϊ������ */
	protected String weekvalue;
	
	/** ��������ʾ */
	protected String weekdata;
	
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
	
}


