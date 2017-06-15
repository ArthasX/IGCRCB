/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.lom.model.Inventory;
import com.deliverik.framework.base.BaseEntity;

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Inventory")
public class InventoryTB extends BaseEntity implements Serializable, Cloneable, Inventory {
	
	/** �̵�ID */
	@Id
	@TableGenerator(
		    name="INVENTORY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="INVENTORY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INVENTORY_TABLE_GENERATOR")
	protected Integer inid;
	
	/** ��Ʒ���� */
	protected String goodscategory;
	
	/** ��Ʒ���� */
	protected String goodsname;
	
	/** ��Ʒ��� */
	protected String goodscode;
	
	/** �������� */
	protected String inventorydate;
	
	/** ���´������� */
	protected Integer lminventoryamount;
	
	/** ���´��̽�� */
	protected BigDecimal lminventorymoney;
	
	/** ���¹������� */
	protected Integer cminputamount;
	
	/** ���¹����� */
	protected BigDecimal cminputmoney;
	
	/** ƽ���� */
	protected BigDecimal average;
	
	/** ������������ */
	protected Integer cmoutamount;
	
	/** �������ý�� */
	protected BigDecimal cmoutmoney;
	
	/** ���µ������� */
	protected Integer cmregamount;
	
	/** ���µ������ */
	protected BigDecimal cmregmoney;
	
	/** ���º������� */
	protected Integer cmhavoamount;
	
	/** ���º������ */
	protected BigDecimal cmhavomoney;
	
	/** ���½������ */
	protected Integer cmsurplusamount;
	
	/** ���½���� */
	protected BigDecimal cmsurplusmoney;


	@Override
	public Serializable getPK() {
		return inid;
	}

	public Integer getInid() {
		return inid;
	}

	public void setInid(Integer inid) {
		this.inid = inid;
	}

	public String getInventorydate() {
		return inventorydate;
	}

	public void setInventorydate(String inventorydate) {
		this.inventorydate = inventorydate;
	}

	public String getGoodscategory() {
		return goodscategory;
	}

	public void setGoodscategory(String goodscategory) {
		this.goodscategory = goodscategory;
	}

	public String getGoodscode() {
		return goodscode;
	}

	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}

	public BigDecimal getLminventorymoney() {
		return lminventorymoney;
	}

	public void setLminventorymoney(BigDecimal lminventorymoney) {
		this.lminventorymoney = lminventorymoney;
	}

	public BigDecimal getCminputmoney() {
		return cminputmoney;
	}

	public void setCminputmoney(BigDecimal cminputmoney) {
		this.cminputmoney = cminputmoney;
	}

	public BigDecimal getAverage() {
		return average;
	}

	public void setAverage(BigDecimal average) {
		this.average = average;
	}

	public BigDecimal getCmoutmoney() {
		return cmoutmoney;
	}

	public void setCmoutmoney(BigDecimal cmoutmoney) {
		this.cmoutmoney = cmoutmoney;
	}

	public BigDecimal getCmhavomoney() {
		return cmhavomoney;
	}

	public void setCmhavomoney(BigDecimal cmhavomoney) {
		this.cmhavomoney = cmhavomoney;
	}

	public BigDecimal getCmsurplusmoney() {
		return cmsurplusmoney;
	}

	public void setCmsurplusmoney(BigDecimal cmsurplusmoney) {
		this.cmsurplusmoney = cmsurplusmoney;
	}

	public String getRemark() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getLminventoryamount() {
		return lminventoryamount;
	}

	public void setLminventoryamount(Integer lminventoryamount) {
		this.lminventoryamount = lminventoryamount;
	}

	public Integer getCminputamount() {
		return cminputamount;
	}

	public void setCminputamount(Integer cminputamount) {
		this.cminputamount = cminputamount;
	}

	public Integer getCmoutamount() {
		return cmoutamount;
	}

	public void setCmoutamount(Integer cmoutamount) {
		this.cmoutamount = cmoutamount;
	}

	public Integer getCmhavoamount() {
		return cmhavoamount;
	}

	public void setCmhavoamount(Integer cmhavoamount) {
		this.cmhavoamount = cmhavoamount;
	}

	public Integer getCmsurplusamount() {
		return cmsurplusamount;
	}

	public void setCmsurplusamount(Integer cmsurplusamount) {
		this.cmsurplusamount = cmsurplusamount;
	}

	public Integer getCmregamount() {
		return cmregamount;
	}

	public void setCmregamount(Integer cmregamount) {
		this.cmregamount = cmregamount;
	}

	public BigDecimal getCmregmoney() {
		return cmregmoney;
	}

	public void setCmregmoney(BigDecimal cmregmoney) {
		this.cmregmoney = cmregmoney;
	}


}
