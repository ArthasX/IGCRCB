/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.plugin.sms.dto;

import java.io.Serializable;
import java.util.Locale;

import com.deliverik.framework.base.BaseDTO;
/**
 * ����:�澯��Ϣ����DTO
 * ����������
 * ������¼��2012/09/28 By ¬��Ԫ
 */

@SuppressWarnings("serial")
public class SMSDTO extends BaseDTO implements Serializable{
	
	/** ���ʻ���Ϣ */
	protected Locale locale;
	
	/**
	 * getter and setter
	 */
	/**
	 * ���ʻ���Ϣȡ��
	 *
	 * @return locale ���ʻ���Ϣ
	 */
	public Locale getLocale() {
		return locale;
	}
	/**
	 * ���ʻ���Ϣ�趨
	 *
	 * @param locale ���ʻ���Ϣ
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}