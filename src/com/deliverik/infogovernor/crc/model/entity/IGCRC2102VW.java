/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;

/**	
 * ����:���� ��ѯ��α��ͼ
 * ������¼��yukexin    2014-8-15 ����3:27:32	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
@Entity
public class IGCRC2102VW implements Serializable,IGCRC2102VWInfo{
	/** ����  */	
	@Id
	protected String id;

	/** ����  */	
	protected String label;

	/** ֵ  */	
	protected String value;
	
	public IGCRC2102VW() {
		super();
	}
	public String getLabel() {
		return label;
	}

	public IGCRC2102VW(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	
	public String getFingerPrint() {
		return null;
	}
	/**
	 * ����ȡ��
	 * @return id  ����
	 */
	public String getId() {
		return id;
	}
	/**
	 * �����趨
	 * @param id  ����
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * ֵȡ��
	 * @return value  ֵ
	 */
	public String getValue() {
		return value;
	}
	/**
	 * ֵ�趨
	 * @param value  ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * �����趨
	 * @param label  ����
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
