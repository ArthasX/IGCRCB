/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;

/**	
 * ����: �������ͳ��ʵ��
 * ������¼��yukexin    2014-8-7 ����9:10:14	
 * �޸ļ�¼��null
 */	
@Entity
public class IGCRC2201VW implements IGCRC2201VWInfo {
	
	@Id
	/** ���� */
	private String typeId;
	
	/** ������ */
	private String typeName;

	/** ���� */
	private Integer totalnum;

	/** ����ͨ������ */
	private Integer passnum;

	/** ����ͨ���� */
//	private Double passrate;

	/** �ɹ����� */
	private Integer successnum;

	/** �ɹ��� */
//	private Double successrate;

	/**
	 * typeIdȡ��
	 * @return typeId  typeId
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * typeId�趨
	 * @param typeId  typeId
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * ������ȡ��
	 * @return typeName  ������
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * �������趨
	 * @param typeName  ������
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * ����ȡ��
	 * @return totalnum  ����
	 */
	public Integer getTotalnum() {
		return totalnum;
	}

	/**
	 * �����趨
	 * @param totalnum  ����
	 */
	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	/**
	 * ����ͨ������ȡ��
	 * @return passnum  ����ͨ������
	 */
	public Integer getPassnum() {
		return passnum;
	}

	/**
	 * ����ͨ�������趨
	 * @param passnum  ����ͨ������
	 */
	public void setPassnum(Integer passnum) {
		this.passnum = passnum;
	}


	/**
	 * �ɹ�����ȡ��
	 * @return successnum  �ɹ�����
	 */
	public Integer getSuccessnum() {
		return successnum;
	}

	/**
	 * �ɹ������趨
	 * @param successnum  �ɹ�����
	 */
	public void setSuccessnum(Integer successnum) {
		this.successnum = successnum;
	}




}
