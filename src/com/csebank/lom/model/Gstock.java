/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * ��Ʒ�ӿ�
 * 
 */
public interface Gstock extends BaseModel {

	/** ��Ʒ����IDȡ�� */
	public Integer getGsid();

	/** ��Ʒ����ȡ�� */
	public String getGscategory();

	/** ��Ʒ����ȡ�� */
	public String getGsname();

	/** ��Ʒ���ȡ�� */
	public String getGscode();

	/** ������ȡ�� */
	public Integer getGsnum();

	/** �������������ȡ�� */
	public String getGsorg();

	/** �ɹ�ƽ����ȡ�� */
	public BigDecimal getGsavgprice();

	/** ��������ȡ�� */
	public Integer getGsfreezenum();
	
	/** ���һ�θ��������� */
	public String getGsuserid();
	
	/** ���һ�θ���ʱ�� */
	public String getGsusername();
	
	/** ��¼�汾��ʶ */
	public String getGsdate();
}
