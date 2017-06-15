/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;

/**
 * ֵ�������ʵ��
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DutyAuditDef")
public class DutyAuditDefTB extends BaseEntity implements Serializable, Cloneable, DutyAuditDef {
	
	@Id
	@TableGenerator(
		    name="DUTYAUDITDEF_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DUTYAUDITDEF_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DUTYAUDITDEF_TABLE_GENERATOR")
	
	
	/**
	 * �����ID
	 */
	protected Integer dadid;

	/**
	 * ֵ������
	 */
	protected String dadcategory;
	
	/**
	 * ������
	 */
	protected String dadtype;
	
	/**
	 * �������
	 */
	protected String dadname;
	
	/**
	 * �ʱ������
	 */
	protected String dadlimtime;
	
	/**
	 * ���������
	 */
	protected String dadcontent;
	
	/**
	 * ���˵��
	 */
	protected String dadinfo;
	
	/**
	 * ʹ��״̬
	 */
	protected String dadstatus;
	
	/**
	 * ������ID
	 */
	protected String daduserid;
	
	/**
	 * ����������
	 */
	protected String dadusername;
	
	/**
	 * ����ʱ��
	 */
	protected String dadupdtime;
	
	/** �����ʶ */
	protected Integer dadorderby;
	
	/** �������� */
	protected String periodType;
	
	/** ����ʱ�� */
	protected String periodValue;
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPeriodType() {
		return periodType;
	}

	/**
	 * ���������趨
	 * @param periodType ��������
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getPeriodValue() {
		return periodValue;
	}

	/**
	 * ����ʱ���趨
	 * @param periodValue����ʱ��
	 */
	public void setPeriodValue(String periodValue) {
		this.periodValue = periodValue;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return dadid;
	}
	
	/**
	 * �����ID
	 * @return �����ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * ֵ������
	 * @param dadid ֵ������
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}

	/**
	 * ֵ������
	 * @return ֵ������
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * ֵ������
	 * @param dadcategory ֵ������
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * ������
	 * @return ������
	 */
	public String getDadtype() {
		return dadtype;
	}

	/**
	 * ������
	 * @param dadtype ������
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}

	/**
	 * �������
	 * @return �������
	 */
	public String getDadname() {
		return dadname;
	}

	/**
	 * �������
	 * @param dadname �������
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}

	/**
	 * �ʱ������
	 * @return �ʱ������
	 */
	public String getDadlimtime() {
		return dadlimtime;
	}

	/**
	 * �ʱ������
	 * @param dadlimtime �ʱ������
	 */
	public void setDadlimtime(String dadlimtime) {
		this.dadlimtime = dadlimtime;
	}

	/**
	 * ���������
	 * @return ���������
	 */
	public String getDadcontent() {
		return dadcontent;
	}

	/**
	 * ���������
	 * @param dadcontent ���������
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}

	/**
	 * ���˵��
	 * @return ���˵��
	 */
	public String getDadinfo() {
		return dadinfo;
	}

	/**
	 * ���˵��
	 * @param dadinfo ���˵��
	 */
	public void setDadinfo(String dadinfo) {
		this.dadinfo = dadinfo;
	}

	/**
	 * ʹ��״̬
	 * @return ʹ��״̬
	 */
	public String getDadstatus() {
		return dadstatus;
	}

	/**
	 * ʹ��״̬
	 * @param dadstatus ʹ��״̬
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
	}

	/**
	 * ������ID
	 * @return ������ID
	 */
	public String getDaduserid() {
		return daduserid;
	}

	/**
	 * ������ID
	 * @param daduserid ������ID
	 */
	public void setDaduserid(String daduserid) {
		this.daduserid = daduserid;
	}

	/**
	 * ����������
	 * @return ����������
	 */
	public String getDadusername() {
		return dadusername;
	}

	/**
	 * ����������
	 * @param dadusername ����������
	 */
	public void setDadusername(String dadusername) {
		this.dadusername = dadusername;
	}

	/**
	 * ����ʱ��
	 * @return ����ʱ��
	 */
	public String getDadupdtime() {
		return dadupdtime;
	}

	/**
	 * ����ʱ��
	 * @param dadupdtime ����ʱ��
	 */
	public void setDadupdtime(String dadupdtime) {
		this.dadupdtime = dadupdtime;
	}

	/**
	 * �����ʶȡ��
	 *
	 * @return dadorderby �����ʶ
	 */
	public Integer getDadorderby() {
		return dadorderby;
	}

	/**
	 * �����ʶ�趨
	 *
	 * @param dadorderby �����ʶ
	 */
	public void setDadorderby(Integer dadorderby) {
		this.dadorderby = dadorderby;
	}

}
