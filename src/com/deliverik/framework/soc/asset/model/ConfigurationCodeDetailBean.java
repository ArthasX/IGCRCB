/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.soc.asset.model;

/**
 * �ʲ�����ȡֵ��Χbean
 * 
 */
public class ConfigurationCodeDetailBean {


	/**
	 * �ʲ�����ȡֵ��Χ��ʶȡ��
	 * @return �ʲ�����ȡֵ��Χ��ʶ
	 */
	public String ccdcategory;
	
	/**
	 * �ʲ�����ȡֵ��Χ��ʶ����ȡ��
	 * @return �ʲ�����ȡֵ��Χ��ʶ����
	 */
	public String ccdlabel;

	public String getCcdcategory() {
		return ccdcategory;
	}

	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	public String getCcdlabel() {
		return ccdlabel;
	}

	public void setCcdlabel(String ccdlabel) {
		this.ccdlabel = ccdlabel;
	}



}