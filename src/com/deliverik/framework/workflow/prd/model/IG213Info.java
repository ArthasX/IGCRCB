/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/** 
 * ���̽�ɫ���Ͷ���
 *
 */
public interface IG213Info  extends BaseModel {
	/**
	 * ���̽�ɫ���Ͷ���IDȡ��
	 * @return ���̽�ɫ���Ͷ���ID
	 */
	public String getPrtdid();
	
	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid();

	/**
	 * ���̽�ɫ����ȡ��
	 * @return ���̽�ɫ����
	 */
	public String getRoletype();
	
}
