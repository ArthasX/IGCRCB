/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * ÿ���̵�
 * 
 * @author 
 */
public interface Inventory extends BaseModel {
	
	/** ID */
	public Integer getInid();
	
	/** �������� */
	public String getInventorydate();
	
	/** ��Ʒ���� */
	public String getGoodsname();
	
	/** ��Ʒ���� */
	public String getGoodscategory();
	
	/** ��Ʒ��� */
	public String getGoodscode();
	
	/** ���´������� */
	public Integer getLminventoryamount();
	
	/** ���´��̽�� */
	public BigDecimal getLminventorymoney();
	
	/** ���¹������� */
	public Integer getCminputamount();
	
	/** ���¹����� */
	public BigDecimal getCminputmoney();
	
	/** ƽ���� */
	public BigDecimal getAverage();
	
	/** ������������ */
	public Integer getCmoutamount();
	
	/** �������ý�� */
	public BigDecimal getCmoutmoney();
	
	/** ���µ������� */
	public Integer getCmregamount();
	
	/** ���µ������ */
	public BigDecimal getCmregmoney();
	
	/** ���º������� */
	public Integer getCmhavoamount();
	
	/** ���º������ */
	public BigDecimal getCmhavomoney();
	
	/** ���½������ */
	public Integer getCmsurplusamount();
	
	/** ���½���� */
	public BigDecimal getCmsurplusmoney();
	
	/** ��ע */
	public String getRemark();
	

}
