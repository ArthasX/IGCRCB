/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;

/**
 * 
 * ֵ���������form
 *
 */
public class IGDUT0302Form extends BaseForm implements DutyResultSearchCond {
	

	private static final long serialVersionUID = 1L;

	/**
	 * ֵ��������ID
	 */
	protected Integer drid;

	/**
	 * ֵ��ƻ�ID
	 */
	protected Integer dpid;
	
	/**
	 * �����ID
	 */
	protected Integer dadid;
	
	/**
	 * ������
	 */
	protected String dadtype;
	
	/**
	 * �������
	 */
	protected String dadname;
	
	/**
	 * �������
	 */
	protected String dadname_q;
	
	/**
	 * ���ʱ��
	 */
	protected String dattime;
	
	/**
	 * �ʱ������
	 */
	protected String datlimtime;
	
	/**
	 * ���������
	 */
	protected String dadcontent;
	
	/**
	 * �����
	 */
	protected String drcontent;
	
	/**
	 * ʵ���ʱ��
	 */
	protected String drfilltime;
	
	/**
	 * ���˵��
	 */
	protected String drresult;
	
	/**
	 * �������д��ID
	 */
	protected String druserid;
	
	/**
	 * �������д������
	 */
	protected String drusername;
	
	/**
	 * �������дʱ��
	 */
	protected String drcretime;
	
	/**
	 * ֵ������
	 */
	protected String dptime;
	
	/**
	 * �װ�/ҹ��
	 */
	protected String dptype;
	
	/**
	 * ֵ������
	 */
	protected String dadcategory;

	/**
	 * ��ʼʱ��
	 */
	protected String dopentime;
	
	/**
	 * ����ʱ��
	 */
	protected String dclosetime;
	
	/**
	 * ֵ��������IDȡ��
	 * @return ֵ��������ID
	 */
	public Integer getDrid() {
		return drid;
	}

	/**
	 * ֵ��������ID����
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
	 * ֵ��ƻ�ID����
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
	 * �����ID����
	 * @param dadid �����ID
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getDadtype() {
		return dadtype;
	}

	/**
	 * ����������
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
	 * �����������
	 * @param dadname �������
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getDadname_q() {
		return dadname_q;
	}

	/**
	 * �����������
	 * @param dadname_q �������
	 */
	public void setDadname_q(String dadname_q) {
		this.dadname_q = dadname_q;
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
	 * �ʱ������ȡ��
	 * @return �ʱ������
	 */
	public String getDatlimtime() {
		return datlimtime;
	}

	/**
	 * �ʱ����������
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
	 * �������������
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
	 * ���������
	 * @param drcontent�����
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
	 * ʵ���ʱ������
	 * @param drfilltime ʵ���ʱ��
	 */
	public void setDrfilltime(String drfilltime) {
		this.drfilltime = drfilltime;
	}

	/**
	 * ���˵�� ȡ��
	 * @return ���˵��
	 */
	public String getDrresult() {
		return drresult;
	}

	/**
	 * ���˵������
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
	 * �������д��ID����
	 * @param druserid �������д��ID
	 */
	public void setDruserid(String druserid) {
		this.druserid = druserid;
	}

	/**
	 * �������д������
	 * @return �������д������
	 */
	public String getDrusername() {
		return drusername;
	}

	/**
	 * �������д����������
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
	 * �������дʱ������
	 * @param �������дʱ��
	 */
	public void setDrcretime(String drcretime) {
		this.drcretime = drcretime;
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
	 * @param dptype �װ�/ҹ��
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
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
	 * @param dadcategory ֵ������
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * ��ʼʱ��
	 * @return ��ʼʱ��
	 */
	public String getDopentime() {
		return dopentime;
	}

	/**
	 * ��ʼʱ��
	 * @param dopentime ��ʼʱ��
	 */
	public void setDopentime(String dopentime) {
		this.dopentime = dopentime;
	}

	/**
	 * ����ʱ��
	 * @return ����ʱ��
	 */
	public String getDclosetime() {
		return dclosetime;
	}

	/**
	 * ����ʱ��
	 * @param dclosetime ����ʱ��
	 */
	public void setDclosetime(String dclosetime) {
		this.dclosetime = dclosetime;
	}

	public String getDptime_ge() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDptime_le() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIsNullDrcontent() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
