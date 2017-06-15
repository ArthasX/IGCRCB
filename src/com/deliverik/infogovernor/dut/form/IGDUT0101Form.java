/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;

public class IGDUT0101Form extends BaseForm  implements DutyAuditDef ,DutyAuditTime{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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


	/**���ʱ��ID */
	protected Integer datid;
	
	
	/**�����ʱ�� */
	protected String dattime;
	
	/**�����ʱ������ */
	protected String[] dattimes;
	
	/**����ʱ�� */
	protected String datlimtime;

	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";
	
	/** �����ʶ */
	protected Integer dadorderby;
	
	/** �������� */
	protected String periodType;
	
	protected String week_value;
	
	protected String month_value;
	
	protected String quarter_monthValue;
	
	protected String quarter_dayValue;
	
	public String getQuarter_monthValue() {
		return quarter_monthValue;
	}

	public void setQuarter_monthValue(String quarter_monthValue) {
		this.quarter_monthValue = quarter_monthValue;
	}

	public String getQuarter_dayValue() {
		return quarter_dayValue;
	}

	public void setQuarter_dayValue(String quarter_dayValue) {
		this.quarter_dayValue = quarter_dayValue;
	}

	public String getMonth_value() {
		return month_value;
	}

	public void setMonth_value(String month_value) {
		this.month_value = month_value;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public String getWeek_value() {
		return week_value;
	}

	public void setWeek_value(String week_value) {
		this.week_value = week_value;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return datlimtime
	 */
	public String getDatlimtime() {
		return datlimtime;
	}

	/**
	 * ����ʱ���趨
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	
	/**
	 * �����ʱ������ȡ��
	 * @return dattimes
	 */
	public String[] getDattimes() {
		return dattimes;
	}

	/**
	 * �����ʱ�������趨
	 */
	public void setDattimes(String[] dattimes) {
		this.dattimes = dattimes;
	}

	/**
	 * �����������ʶȡ��
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �����������ʶ�趨
	 * @return mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
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
     * 
	 *���ʱ��IDȡ��
	 * @return ���ʱ��ID
	 */
	public Integer getDatid() {
		return datid;
	}
    
	/**
	 * 
	 * ���ʱ��ID�趨
	 * @param datid ���ʱ��ID
	 */
	public void setDatid(Integer datid) {
		this.datid = datid;
	}
    
    
	/**
	 * ���ʱ��ȡ��
	 * @return ���ʱ��
	 */
	public String getDattime() {
		return dattime;
	}
	
    /**
     * ���ʱ������
     * @param dattime ���ʱ��
     */
	public void setDattime(String dattime) {
		this.dattime = dattime;
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

	public String getPeriodValue() {
		return null;
	}

	public String getFingerPrint() {
		return null;
	}

	



}
