package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 机柜平面图画面FORM
 * 
 */
public class IGASM1114Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 机柜ID */
	protected String eiid;
	
	protected String jitype;
	
	/** 设备ID */
	protected String device_eiid;
	
	/**
	 * 机柜ID取得
	 * @return 机房ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 机柜ID设定
	 *
	 * @param eiid 机房ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 设备ID取得
	 * @return 设备ID
	 */
	public String getDevice_eiid() {
		return device_eiid;
	}

	/**
	 * 设备ID设定
	 *
	 * @param device_eiid 设备ID
	 */
	public void setDevice_eiid(String device_eiid) {
		this.device_eiid = device_eiid;
	}

	public String getJitype() {
		return jitype;
	}

	public void setJitype(String jitype) {
		this.jitype = jitype;
	}
}
