package com.deliverik.infogovernor.mtp.form;

import com.deliverik.framework.base.BaseForm;

public class IGMTP0103Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private Integer showYear;
	private Integer showMonth;
	private String forward;
	private String dadcategory;
	
	private String begin_time;
	private String end_time;
	private String[] selectedCheck;
	
	/** 流程定义ID */
	protected String pdid;
	
	public String getDadcategory() {
		return dadcategory;
	}

	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public Integer getShowYear() {
		return showYear;
	}

	public void setShowYear(Integer showYear) {
		this.showYear = showYear;
	}

	public Integer getShowMonth() {
		return showMonth;
	}

	public void setShowMonth(Integer showMonth) {
		this.showMonth = showMonth;
	}

	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String[] getSelectedCheck() {
		return selectedCheck;
	}

	public void setSelectedCheck(String[] selectedCheck) {
		this.selectedCheck = selectedCheck;
	}
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

}
