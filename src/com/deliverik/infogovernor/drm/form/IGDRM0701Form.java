package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ����ѯHELP������FORM
 * IGCOM0302Form ActionForm
 */
public class IGDRM0701Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** �������� */
	protected String prdesc;
	
	/** ���̶������� */
	protected String prpdid;
	
	/**�������*/
	protected Integer prid;
	
	/**��������*/
	protected String prtitle;
	
	/**����״̬*/
	protected String prstatus;
	
	/**����������*/
	protected String prusername;
	
	/**��ʼʱ��*/
	protected String propentime;
	
	/**����ʱ��*/
	protected String prclosetime;
	
	/**�����̶�*/
	protected String prurgency;

	/** ���̱�� */
	protected String prserialnum;
	
	/** ����״̬���� */
	protected String[] prStatusArray;
	/** �����ƻ����� */
	protected String status;
	
	/** �����ƻ����ͣ����⣩ */
	protected Integer prassetid;	
	
	/**
	 * @return the prassetid
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * @param prassetid the prassetid to set
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**  
	 * ��ȡstatus  
	 * @return status 
	 */
	public String getStatus() {
		return status;
	}

	/**  
	 * ����status  
	 * @param status
	 */
	
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the ��������
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * @param �������� the prdesc to set
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * @return the ���̶�������
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * @param ���̶������� the prpdid to set
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * @return the �������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * @param ������� the prid to set
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * @return the ��������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * @param �������� the prtitle to set
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * @return the ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * @param ����״̬ the prstatus to set
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * @return the ����������
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * @param ���������� the prusername to set
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * @return the ��ʼʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * @param ��ʼʱ�� the propentime to set
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * @return the ����ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * @param ����ʱ�� the prclosetime to set
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * @return the �����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * @param �����̶� the prurgency to set
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * @return the ���̱��
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * @param ���̱�� the prserialnum to set
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * @return the ����״̬����
	 */
	public String[] getPrStatusArray() {
		return prStatusArray;
	}

	/**
	 * @param ����״̬���� the prStatusArray to set
	 */
	public void setPrStatusArray(String[] prStatusArray) {
		this.prStatusArray = prStatusArray;
	}


}
