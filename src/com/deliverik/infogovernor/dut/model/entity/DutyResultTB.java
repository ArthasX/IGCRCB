/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.DutyResult;

/**
 * ֵ��������ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DutyResult")
public class DutyResultTB extends BaseEntity implements Serializable, Cloneable, DutyResult {

	/** ֵ��������ID */
	@Id
	@TableGenerator(
		    name="DUTYRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DUTYRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DUTYRESULT_TABLE_GENERATOR")
	protected Integer drid;

	/** ֵ��ƻ�ID */
	protected Integer dpid;
	
	/** �����ID */
	protected Integer dadid;
	
	/**
	 * ֵ������
	 */
	protected String dadcategory;
	
	/** ������ */
	protected String dadtype;
	
	/** ������� */
	protected String dadname;
	
	/** ������� */
	protected String dptime;
	
	/** ������� */
	protected String dptype;
	
	/** ���ʱ�� */
	protected String dattime;
	
	/** �ʱ������ */
	protected String datlimtime;
	
	/** ��������� */
	protected String dadcontent;
	
	/** ����� */
	protected String drcontent;
	
	/** ʵ���ʱ�� */
	protected String drfilltime;
	
	/** ���˵�� */
	protected String drresult;
	
	/** �������д��ID */
	protected String druserid;
	
	/** �������д������ */
	protected String drusername;
	
	/** �������дʱ�� */
	protected String drcretime;
	
	/** ��ա�ʱ���� */
	protected String drlimdtime;
	


	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return drid;
	}
	
	/**
	 * ��ա�ʱ����ȡ��
	 * @return ��ա�ʱ����
	 */
	public String getDrlimdtime() {
		return drlimdtime;
	}

	/**
	 * ��ա�ʱ�����趨
	 *
	 * @param drlimdtime ��ա�ʱ����
	 */
	public void setDrlimdtime(String drlimdtime) {
		this.drlimdtime = drlimdtime;
	}
	
	/**
	 * ֵ��������IDȡ��
	 * @return ֵ��������ID
	 */
	public Integer getDrid() {
		return drid;
	}
	
	/**
	 * ֵ��������ID�趨
	 *
	 * @param drid ֵ��������ID
	 */
	public void setDrid(Integer drid) {
		this.drid = drid;
	}

	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�ID
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * ֵ��ƻ�ID�趨
	 *
	 * @param dpid ֵ��ƻ�ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	/**
	 * �����IDȡ��
	 * @return �����ID
	 */
	public Integer getDadid() {
		return dadid;
	}
	
	/**
	 * �����ID�趨
	 *
	 * @param dadid �����ID
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
	 * ������ȡ��
	 * @return ������
	 */
	public String getDadtype() {
		return dadtype;
	}
	
	/**
	 * �������趨
	 *
	 * @param dadtype ������
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getDadname() {
		return dadname;
	}
	
	/**
	 * ��������趨
	 *
	 * @param dadname �������
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}
	
	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDptime() {
		return dptime;
	}
	
	/**
	 * ֵ�������趨
	 *
	 * @param dptime ֵ������
	 */
	public void setDptime(String dptime) {
		this.dptime = dptime;
	}
	
	/**
	 * �װ�/ҹ��ȡ��
	 * @return �װ�/ҹ��
	 */
	public String getDptype() {
		return dptype;
	}
	
	/**
	 * �װ�/ҹ���趨
	 *
	 * @param dptype �װ�/ҹ��
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	/**
	 * ���ʱ��ȡ��
	 * @return ���ʱ��
	 */
	public String getDattime() {
		return dattime;
	}
	
	/**
	 * ���ʱ���趨
	 *
	 * @param dattime ���ʱ��
	 */
	public void setDattime(String dattime) {
		this.dattime = dattime;
	}

	/**
	 * �ʱ������ȡ��
	 * @return �ʱ������
	 */
	public String getDatlimtime() {
		return datlimtime;
	}
	
	/**
	 * �ʱ�������趨
	 *
	 * @param datlimtime �ʱ������
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getDadcontent() {
		return dadcontent;
	}
	
	/**
	 * ����������趨
	 *
	 * @param dadcontent ���������
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}

	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getDrcontent() {
		return drcontent;
	}
	
	/**
	 * ������趨
	 *
	 * @param drcontent �����
	 */
	public void setDrcontent(String drcontent) {
		this.drcontent = drcontent;
	}

	/**
	 * ʵ���ʱ��ȡ��
	 * @return ʵ���ʱ��
	 */
	public String getDrfilltime() {
		return drfilltime;
	}
	
	/**
	 * ʵ���ʱ���趨
	 *
	 * @param drfilltime ʵ���ʱ��
	 */
	public void setDrfilltime(String drfilltime) {
		this.drfilltime = drfilltime;
	}

	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String getDrresult() {
		return drresult;
	}
	
	/**
	 * ���˵���趨
	 *
	 * @param drresult ���˵��
	 */
	public void setDrresult(String drresult) {
		this.drresult = drresult;
	}

	/**
	 * �������д��IDȡ��
	 * @return �������д��ID
	 */
	public String getDruserid() {
		return druserid;
	}
	
	/**
	 * �������д��ID�趨
	 *
	 * @param druserid �������д��ID
	 */
	public void setDruserid(String druserid) {
		this.druserid = druserid;
	}

	/**
	 * �������д������ȡ��
	 * @return �������д������
	 */
	public String getDrusername() {
		return drusername;
	}
	
	/**
	 * �������д�������趨
	 *
	 * @param drusername �������д������
	 */
	public void setDrusername(String drusername) {
		this.drusername = drusername;
	}

	/**
	 * �������дʱ��ȡ��
	 * @return �������дʱ��
	 */
	public String getDrcretime() {
		return drcretime;
	}
	
	/**
	 * �������дʱ���趨
	 *
	 * @param drcretime �������дʱ��
	 */
	public void setDrcretime(String drcretime) {
		this.drcretime = drcretime;
	}
	
}
