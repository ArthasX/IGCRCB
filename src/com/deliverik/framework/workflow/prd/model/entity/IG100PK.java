/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;


/**
 * ���̲����߱���Ȩ��������
 *
 */
@SuppressWarnings("serial")
public class IG100PK extends BasePK implements Serializable {
	
	/** ���̲����߱���Ȩ��ID */
	protected String pipdid;
	
	/** ���ͣ�0�����趨Ȩ�ޱ���1��δ�趨Ȩ�ޱ��� */
	protected String type;
	
	/**
	 * ���캯��
	 */
	public IG100PK(){}
	
	/**
	 * ���캯��
	 */
	public IG100PK(String pipdid, String type) {
		this.pipdid = pipdid;
		this.type = type;
	}
}
