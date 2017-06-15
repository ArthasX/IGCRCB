/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;

/**
 * ֵ���ձ���ͼ
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "DutyResultVW")
@IdClass(DutyResultVWPK.class)
@SuppressWarnings("serial")
public class DutyResultVW implements Serializable, DutyResultVWInfo {
	
	/** �����ID */
	@Id
	protected Integer dadid;
	
	/** ֵ���ձ�ID */
	protected Integer drid;
	
	/** ֵ��ƻ�ID */
	protected Integer dpid;
	
	/** ������ */
	protected String dadtype;
	
	/** ������� */
	protected String dadname;
	
	/** ���ʱ�� */
	@Id
	protected String dattime;
	
	/** �ʱ������ */
	protected String datlimtime;
	
	/** ��������� */
	protected String dadcontent;
	
	/** ���˵�� */
	protected String dadinfo;
	
	/** ʹ��״̬ */
	protected String dadstatus;
	
	/** ����� */
	protected String drcontent;
	
	/** ʵ���ʱ�� */
	protected String drfilltime;
	
	/** ���˵�� */
	protected String drresult;

	/** ֵ������ */
	protected String dadcategory;
	
	/** ��ա�ʱ���� */
	protected String drlimdtime;
	
	/** ����ʱ�� */
	protected String dadlimtime;

	/** �����ʶ */
	protected String dadorderby;
	
	/** �������� */
	protected String periodType;
	
	/** ����ʱ�� */
	protected String periodValue;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return new DutyResultVWPK(dadid,dattime);
	}

	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPeriodType() {
		return periodType;
	}


	/**
	 * ���������趨
	 * @param periodType��������
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
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getDadlimtime() {
		return dadlimtime;
	}



	/**
	 * ����ʱ���趨
	 *
	 * @param dadlimtime ����ʱ��
	 */
	public void setDadlimtime(String dadlimtime) {
		this.dadlimtime = dadlimtime;
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
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDadcategory() {
		return dadcategory;
	}




	/**
	 * ֵ�������趨
	 *
	 * @param dadcategory ֵ������
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
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
	 * ֵ���ձ�IDȡ��
	 * @return ֵ���ձ�ID
	 */
	public Integer getDrid() {
		return drid;
	}



	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getDadtype() {
		return dadtype;
	}



	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getDadname() {
		return dadname;
	}



	/**
	 * ���ʱ��ȡ��
	 * @return ���ʱ��
	 */
	public String getDattime() {
		return dattime;
	}



	/**
	 * �ʱ������ȡ��
	 * @return �ʱ������
	 */
	public String getDatlimtime() {
		return datlimtime;
	}



	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getDadcontent() {
		return dadcontent;
	}



	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String getDadinfo() {
		return dadinfo;
	}



	/**
	 * ʹ��״̬ȡ��
	 * @return ʹ��״̬
	 */
	public String getDadstatus() {
		return dadstatus;
	}



	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getDrcontent() {
		return drcontent;
	}



	/**
	 * ʵ���ʱ��ȡ��
	 * @return ʵ���ʱ��
	 */
	public String getDrfilltime() {
		return drfilltime;
	}



	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String getDrresult() {
		return drresult;
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
	 * ֵ���ձ�ID�趨
	 *
	 * @param drid ֵ���ձ�ID
	 */
	public void setDrid(Integer drid) {
		this.drid = drid;
	}



	/**
	 * ������ �趨
	 *
	 * @param dadtype ������ 
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
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
	 * ���ʱ���趨
	 *
	 * @param dattime ���ʱ��
	 */
	public void setDattime(String dattime) {
		this.dattime = dattime;
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
	 * ����������趨
	 *
	 * @param dadcontent ���������
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}



	/**
	 * ���˵���趨
	 *
	 * @param dadinfo ���˵��
	 */
	public void setDadinfo(String dadinfo) {
		this.dadinfo = dadinfo;
	}



	/**
	 * ʹ��״̬�趨
	 *
	 * @param dadstatus ʹ��״̬
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
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
	 * ʵ���ʱ���趨
	 *
	 * @param drfilltime ʵ���ʱ��
	 */
	public void setDrfilltime(String drfilltime) {
		this.drfilltime = drfilltime;
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
	 * �����ʶȡ��
	 *
	 * @return dadorderby �����ʶ
	 */
	public String getDadorderby() {
		return dadorderby;
	}



	/**
	 * �����ʶ�趨
	 *
	 * @param dadorderby �����ʶ
	 */
	public void setDadorderby(String dadorderby) {
		this.dadorderby = dadorderby;
	}
	
	
	

	
}
