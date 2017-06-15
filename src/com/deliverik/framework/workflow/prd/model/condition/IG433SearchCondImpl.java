/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ����:��������Condʵ����
 * ����������
 *           
 * ������¼���κ���    2010/11/26
 */
public class IG433SearchCondImpl implements IG433SearchCond {

	/**
	 * ���̼�¼��Ŀ
	 */
	protected String prtitle;

	/**
	 * ���̼�¼��������ID
	 */
	protected String prpdid;

	/**
	 * ���̼�¼�������û�����
	 */
	protected String prusername;
	
	/**
	 * ���̼�¼�����̶�
	 */
	protected String prurgency;
	
	/**
	 * ���̼�¼����ʱ�䣨����ڣ�
	 */
	protected String propentime;
	
	/**
	 * ���̼�¼������
	 */
	protected String prserialnum;
	
	/**
	 * ���̼�¼�ƻ�ִ������
	 */
	protected String prclosetime;

	/**
	 * �����Ƿ��������
	 */
	protected String assessmentstatus;
	
	/**�����ֶ�*/
	protected String order;
	
	/**�����ʶ*/
	protected String sing;
	
	/**
	 * �������������
	 */
	protected Integer paid;
	
	/**
	 * �¼����code
	 */
	protected String paeventtypecode;
	
	/**��������*/
	protected String prtype;
	
	/**����ID*/
	protected Integer paprid;
	
	/**
	 * ��ȡ����ID
	 * @return ����ID
	 */
	public Integer getPaprid() {
		return paprid;
	}

	/**
	 * ����ID�趨
	 * @param paprid ����ID
	 */
	public void setPaprid(Integer paprid) {
		this.paprid = paprid;
	}

	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ������������
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	/**
	 *�������������ȡ��
	 * 
	 * @return �������������
	 */
	public Integer getPaid() {
		return paid;
	}

	/**
	 *��������������趨
	 * 
	 * @param paid �������������
	 */
	public void setPaid(Integer paid) {
		this.paid = paid;
	}
	
	/**
	 * ���ܣ������ʶȡ��
	 * @return  �����ʶ
	 */
	public String getSing() {
		return sing;
	}
	/**
	 * ���ܣ������ʶ�趨
	 * @param order �����ʶ
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}
	/**
	 * ���ܣ������ֶ�ȡ��
	 * @return  �����ֶ�
	 */
	public String getOrder() {
		return order;
	}
	/**
	 * ���ܣ������ֶ��趨
	 * @param order �����ֶ�
	 */
	public void setOrder(String order) {
		this.order = order;
	}
	
	/**
	 * ���ܣ����������ȡ��
	 * @return  ���������
	 */
	public String getAssessmentstatus() {
		return assessmentstatus;
	}
	
	/**
	 * ���ܣ�����������趨
	 * @param assessmentstatus ���������
	 */
	public void setAssessmentstatus(String assessmentstatus) {
		this.assessmentstatus = assessmentstatus;
	}

	/**
	 * ���ܣ����̼�¼��Ŀȡ��
	 * @return  ���̼�¼��Ŀ
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���ܣ����̼�¼��Ŀ�趨
	 * @param prtitle ���̼�¼��Ŀ
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	
	/**
	 * ���ܣ����̼�¼�������û�����ȡ��
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���ܣ����̼�¼�������û������趨
	 * @param prusername ���̼�¼�������û�����
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ���ܣ����̼�¼�����̶�ȡ��
	 * @return ���̼�¼�����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * ���ܣ����̼�¼�����̶��趨
	 * @param prurgency ���̼�¼�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * ���ܣ����̼�¼����ʱ�䣨����ڣ�ȡ��
	 * @return ���̼�¼����ʱ�䣨����ڣ�
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���ܣ����̼�¼����ʱ�䣨����ڣ��趨
	 * @param propentime ���̼�¼����ʱ�䣨����ڣ�
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���ܣ����̼�¼��������IDȡ��
	 * @return ���̼�¼��������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���ܣ����̼�¼��������ID�趨
	 * @param prpdid ���̼�¼��������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ�������趨
	 * @param prduration ���̼�¼�ƻ�ִ������
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ���ܣ����̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���ܣ����̼�¼�������趨
	 * @param prserialnum ���̼�¼������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	
	/**
	 *�¼����codeȡ��
	 * 
	 * @return �¼����code
	 */
	public String getPaeventtypecode() {
		return paeventtypecode;
	}

	/**
	 *�¼����code�趨
	 * 
	 * @param paeventtypecode�¼����code
	 */
	public void setPaeventtypecode(String paeventtypecode) {
		this.paeventtypecode = paeventtypecode;
	}
}
