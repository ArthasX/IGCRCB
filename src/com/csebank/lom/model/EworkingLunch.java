/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * ʳ�ù�������Ϣʵ��ӿ�
 *
 */
public interface EworkingLunch extends BaseModel {

	/** �������������� */
	public Integer getEwlid();
	
	/** ���� */
	public String getEwldate();
	
	public String getLunchcardname();
	
	public Integer getLunchcardnum();
	
	public BigDecimal getLunchcardprince();
	
	public Integer getIcid();

}
