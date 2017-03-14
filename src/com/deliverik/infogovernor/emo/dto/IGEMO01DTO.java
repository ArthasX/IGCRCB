/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.emo.dto;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;

/**
 * oracle���ܼ��DTO
 *
 */
@SuppressWarnings("serial")
public class IGEMO01DTO extends BaseDTO implements Serializable {
	
	/** ���� */
	protected String em_type;
	
	/** �ʲ�ID */
	protected String eiid;
	
	/** ������� */
	protected Map<String,Object> EmData;

	/**
	 * ����ȡ��
	 * @return em_type ����
	 */
	public String getEm_type() {
		return em_type;
	}

	/**
	 * �����趨
	 * @param em_type ����
	 */
	public void setEm_type(String em_type) {
		this.em_type = em_type;
	}

	/**
	 * emDataȡ��
	 * @return emData emData
	 */
	public Map<String, Object> getEmData() {
		return EmData;
	}

	/**
	 * emData�趨
	 * @param emData emData
	 */
	public void setEmData(Map<String, Object> emData) {
		EmData = emData;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

}
