/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.form;


import com.deliverik.framework.base.BaseForm;

/**
 * ����:��ض����ѯform
 * ����������
 * ������¼�����    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT0104Form extends BaseForm{
	
	/**
	 * �������id
	 */
	protected String mtId_eq;
	
	/**
	 * ��ض�������
	 */
	protected String moName_eq;
	
	/**
	 * ����ʱ���
	 */
	protected String moCreateTime_from;
	
	/**
	 * ����ʱ�䵽
	 */
	protected String moCreateTime_to;
	
	/**
	 * ��ض���id
	 */
	protected String moId;
	
	/**
	 * ��ض���״̬
	 */
	protected String deleteFlag;

	/**
	 * ����ʱ�䵽��ȡ
	 * @return
	 */
	public String getMoCreateTime_to() {
		return moCreateTime_to;
	}
	
	/**
	 * ����ʱ�䵽�趨
	 * @return
	 */
	public void setMoCreateTime_to(String moCreateTime_to) {
		this.moCreateTime_to = moCreateTime_to;
	}

	/**
	 * ����ʱ��ӻ�ȡ
	 * @return
	 */
	public String getMoCreateTime_from() {
		return moCreateTime_from;
	}

	/**
	 * ����ʱ����趨
	 * @return
	 */
	public void setMoCreateTime_from(String moCreateTime_from) {
		this.moCreateTime_from = moCreateTime_from;
	}

	/**
	 * �������idȡ��
	 * @return
	 */
	public String getMtId_eq() {
		return mtId_eq;
	}

	/**
	 * �������id�趨
	 * @param mtId_eq
	 */
	public void setMtId_eq(String mtId_eq) {
		this.mtId_eq = mtId_eq;
	}

	/**
	 * ��ض�������ȡ��
	 * @return
	 */
	public String getMoName_eq() {
		return moName_eq;
	}

	/**
	 * ��ض��������趨
	 * @param moName_eq
	 */
	public void setMoName_eq(String moName_eq) {
		this.moName_eq = moName_eq;
	}

	/**
	 * ��ض���״̬ȡ��
	 * @return
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * ��ض���״̬�趨
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * ��ض���idȡ��
	 * @return
	 */
	public String getMoId() {
		return moId;
	}

	/**
	 * ��ض���id�趨
	 * @param moId
	 */
	public void setMoId(String moId) {
		this.moId = moId;
	}
}
