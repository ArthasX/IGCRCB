/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.mtp.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * ֵ��ƻ�
 */
public class IGMTP01043VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String showDay;//����
	private String bgColor;//��ɫ
	private String link = "0"; //0�����ɵ������   1���ɵ������   2������ɵ��(�װ಻�ɱ༭)
	private String title;
	private String img;//ͼƬ
	private String dptime;
	private String selectedDate;  //1ѡ��,0δѡ��
	private String dateYMD;//����������������

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

	public String getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}

	public String getDateYMD() {
		return dateYMD;
	}

	public void setDateYMD(String dateYMD) {
		this.dateYMD = dateYMD;
	}

}
