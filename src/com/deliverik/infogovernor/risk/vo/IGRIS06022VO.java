package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * ��������������
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGRIS06022VO extends BaseVO implements Serializable{
	
	/** ����  */	
	private String Label;
	/** ֵ  */	
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
	 * labelȡ��
	 * @return label  label
	 */
	public String getLabel() {
		return Label;
	}
	/**
	 * label�趨
	 * @param label  label
	 */
	public void setLabel(String label) {
		Label = label;
	}
	/**
	 * valueȡ��
	 * @return value  value
	 */
	public String getValue() {
		return Value;
	}
	/**
	 * value�趨
	 * @param value  value
	 */
	public void setValue(String value) {
		Value = value;
	}
	
}

