package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * 检查项下拉框对象
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGRIS06022VO extends BaseVO implements Serializable{
	
	/** 名称  */	
	private String Label;
	/** 值  */	
	private String Value;
	public IGRIS06022VO() {
		super();
	}
	public IGRIS06022VO(String label, String value) {
		super();
		Label = label;
		Value = value;
	}
	/**
	 * label取得
	 * @return label  label
	 */
	public String getLabel() {
		return Label;
	}
	/**
	 * label设定
	 * @param label  label
	 */
	public void setLabel(String label) {
		Label = label;
	}
	/**
	 * value取得
	 * @return value  value
	 */
	public String getValue() {
		return Value;
	}
	/**
	 * value设定
	 * @param value  value
	 */
	public void setValue(String value) {
		Value = value;
	}
	
}

