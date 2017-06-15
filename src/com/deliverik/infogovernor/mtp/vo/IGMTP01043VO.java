/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.mtp.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * 值班计划
 */
public class IGMTP01043VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String showDay;//日期
	private String bgColor;//颜色
	private String link = "0"; //0：不可点击链接   1：可点击链接   2：当天可点击(白班不可编辑)
	private String title;
	private String img;//图片
	private String dptime;
	private String selectedDate;  //1选中,0未选中
	private String dateYMD;//完整的日期年月日

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
