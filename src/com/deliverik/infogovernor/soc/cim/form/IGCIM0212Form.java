/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;

/**
 * ����: �ʲ�����Form
 * ��������: �ʲ�����Form
 * ������¼: 2011/04/26
 * �޸ļ�¼: 
 */
public class IGCIM0212Form extends BaseForm implements SOC0111SearchCond{
	private static final long serialVersionUID = 1L;
	
	/** ���� */
	protected Integer eiddid;
	
	/** �汾�� */
	protected Integer version;
	
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * ��������
	 * 
	 * @param eiddid����
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	
	/**
	 * �汾��ȡ��
	 * 
	 * @return �汾��
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾������
	 * 
	 * @param version�汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	
	
	
	
	
	
	public String getCreatetime_from() {
		return null;
	}

	public String getCreatetime_to() {
		return null;
	}

	public String getEiddid_eq() {
		return null;
	}

	public String getName_like() {
		return null;
	}
	
	
	
}
