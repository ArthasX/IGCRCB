/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * �Ӵ�����ʵ��ӿ�
 *
 */
public interface RecptionGuest extends BaseModel {


	/** �Ӵ�����ID */
	public Integer getRgid();

	/** �Ӵ�����ID */
	public Integer getRid();
	
	/** �Ӵ��������� */
	public String getRgname();
	
	/** �Ӵ�����ְ�� */
	public String getRgpost();
	
	/** �Ӵ����˵�λ */
	public String getRgunit();
	
	/** �Ӵ�������ϵ��ʽ */
	public String getRgtel();
	
	/** �Ǽ����� */
	public String getRgdate();

}
