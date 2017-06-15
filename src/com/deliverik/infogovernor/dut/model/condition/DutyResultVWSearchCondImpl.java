/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.condition;


/**
 * ֵ���ձ���ͼ��ѯ�����ӿ�ʵ��
 */
public class DutyResultVWSearchCondImpl implements DutyResultVWSearchCond{
	
	/** �����ID */
	protected Integer dadid;
	
	/** ֵ���ձ�ID */
	protected Integer drid;
	
	/** ������ */
	protected String dadtype;
	
	/** ������� */
	protected String dadname;
	
	/** ���ʱ�� */
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

	/** ֵ��ƻ�ID */
	protected Integer dpid;
	
	/** ֵ������ */
	protected String dadcategory;
	
	/** ���ʱ��� */
	protected String dattime_form;
	
	/** ���ʱ�䵽 */
	protected String dattime_to;
	
	/** ���ʱ���ѯ���� */
	protected String dattime_q;

	
	
	/**
	 * ���ʱ���ѯ����ȡ��
	 * @return ���ʱ���ѯ����
	 */
	public String getDattime_q() {
		return dattime_q;
	}




	/**
	 * ���ʱ���ѯ�����趨
	 *
	 * @param dattime_q ���ʱ���ѯ����
	 */
	public void setDattime_q(String dattime_q) {
		this.dattime_q = dattime_q;
	}




	/**
	 * ���ʱ��(��)ȡ��
	 * @return ���ʱ���
	 */
	public String getDattime_form() {
		return dattime_form;
	}




	/**
	 * ���ʱ��(��)�趨
	 *
	 * @param dattime_form ���ʱ��(��)
	 */
	public void setDattime_form(String dattime_form) {
		this.dattime_form = dattime_form;
	}




	/**
	 * ���ʱ��(��)ȡ��
	 * @return ���ʱ��(��)
	 */
	public String getDattime_to() {
		return dattime_to;
	}




	/**
	 * ���ʱ��(��)�趨
	 *
	 * @param dattime_to ���ʱ��(��)
	 */
	public void setDattime_to(String dattime_to) {
		this.dattime_to = dattime_to;
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
	

}
