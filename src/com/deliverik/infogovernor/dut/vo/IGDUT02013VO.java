/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * ֵ��ƻ�
 */
public class IGDUT02013VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String dutyType;
	private String showDay;
	private String bgColor;
	private String link = "0"; //0�����ɵ������   1���ɵ������   2������ɵ��(�װ಻�ɱ༭)
	private String title;
	private String img;
	private String dptime;
	private String dayShiftUsers;
	private String nightShiftUsers;

	public String getDptime() {
		return dptime;
	}

	public void setDptime(String dptime) {
		this.dptime = dptime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDutyType() {
		return dutyType;
	}

	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}

	public String getShowDay() {
		return showDay;
	}

	public void setShowDay(String showDay) {
		this.showDay = showDay;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDayShiftUsers() {
		return dayShiftUsers;
	}

	public void setDayShiftUsers(String dayShiftUsers) {
		this.dayShiftUsers = dayShiftUsers;
	}

	public String getNightShiftUsers() {
		return nightShiftUsers;
	}

	public void setNightShiftUsers(String nightShiftUsers) {
		this.nightShiftUsers = nightShiftUsers;
	}

}
