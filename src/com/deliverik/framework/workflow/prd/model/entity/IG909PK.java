/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;


/**
 * ����ȱʡ����Ȩ��������
 *
 */
@SuppressWarnings("serial")
public class IG909PK extends BasePK implements Serializable {
	
	/** ����ȱʡ����Ȩ��ID */
	protected String pdvid;
	
	/** ���ͣ�0�����趨Ȩ�ޱ���1��δ�趨Ȩ�ޱ��� */
	protected String type;
	
	/**
	 * ���캯��
	 */
	public IG909PK(){}
	
	/**
	 * ���캯��
	 */
	public IG909PK(String pdvid, String type) {
		this.pdvid = pdvid;
		this.type = type;
	}
}
