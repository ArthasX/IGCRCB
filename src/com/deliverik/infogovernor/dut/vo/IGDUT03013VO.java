/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * ֵ��ƻ�
 */
public class IGDUT03013VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String showDay;
	private String bgColor;
	private String link = "0"; //0�����ɵ������   1���ɵ������   2������ɵ��(�װ಻�ɱ༭)
	private String title;
	private String redimg;
	private String yellowimg;
	private String delayimg;
	private String dptime;

	public String getDptime() {
		return dptime;
	}

	public void setDptime(String dptime) {
		this.dptime = dptime;
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

	public String getRedimg() {
		return redimg;
	}

	public void setRedimg(String redimg) {
		this.redimg = redimg;
	}

	public String getYellowimg() {
		return yellowimg;
	}

	public void setYellowimg(String yellowimg) {
		this.yellowimg = yellowimg;
	}

	public String getDelayimg() {
		return delayimg;
	}

	public void setDelayimg(String delayimg) {
		this.delayimg = delayimg;
	}
}
