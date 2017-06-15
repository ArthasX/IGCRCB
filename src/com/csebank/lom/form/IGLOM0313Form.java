/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.LoanPayDetail;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * ����Ǽ�Form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0313Form extends BaseForm  implements LoanPayDetail{

	/** ���ID */
	protected Integer ldid;
	
	/** ���ID */
	protected Integer lpdid;
	
	/** ��Ʊ���� */
	protected String lpdinvoicedate;
	
	/** ��Ʊ�� */
	protected String lpdinvoicenum;
	
	/** ��Ʊǩ����λ */
	protected String lpdinvoicecor;
	
	/** ��Ʊ��� */
	protected BigDecimal lpdinvoiceamount;
	
	/** ʵ����;˵�� */
	protected String lpdinvoicecomment;
	
	/** �������� */
	protected String lpddate;
	
	/** ������ */
	protected String lpduser;
	
	/** ���ʽ */
	protected String lpdtype;
	
	/** ������ */
	protected BigDecimal lpdamount;
	
	/** ����״̬ 4 */
	protected String lpdstatus;
	
	/** �����˻�������� */
	protected String lpduserorg;
	
	/** �����˻��� */
	protected String lpduserorgname;
	
	/** ʵ�ʷ�Ʊ��� */
	protected BigDecimal lpdactinvoice;
	
	/** ʵ�ʻ����� */
	protected String lpdactuser;
	
	/** ɾ�����Ʊ���� */
	protected String[] deleteLpdid;
	
	/** �軹��ʱ�� */
	public String lpdtime;


	/**
	 * ���IDȡ��
	 * @return ���ID
	 */
	public Integer getLdid() {
		return ldid;
	}

	/**
	 * ���ID�趨
	 * @param lpdid ���ID
	 */
	public void setLdid(Integer ldid) {
		this.ldid = ldid;
	}

	public String getLpdtype_q() {
		return null;
	}

	/**
	 * ��Ʊ����ȡ��
	 * @return ��Ʊ����
	 */
	public String getLpdinvoicedate() {
		return lpdinvoicedate;
	}

	/**
	 * ��Ʊ�����趨
	 * @param lpdinvoicedate ��Ʊ����
	 */
	public void setLpdinvoicedate(String lpdinvoicedate) {
		this.lpdinvoicedate = lpdinvoicedate;
	}

	/**
	 * ��Ʊ��ȡ��
	 * @return ��Ʊ��
	 */
	public String getLpdinvoicenum() {
		return lpdinvoicenum;
	}

	/**
	 * ��Ʊ���趨
	 * @param lpdinvoicenum ��Ʊ��
	 */
	public void setLpdinvoicenum(String lpdinvoicenum) {
		this.lpdinvoicenum = lpdinvoicenum;
	}

	/**
	 * ��Ʊ��λȡ��
	 * @return ��Ʊ��λ
	 */
	public String getLpdinvoicecor() {
		return lpdinvoicecor;
	}

	/**
	 * ��Ʊ��λ�趨
	 * @param lpdinvoicecor ��Ʊ��λ
	 */
	public void setLpdinvoicecor(String lpdinvoicecor) {
		this.lpdinvoicecor = lpdinvoicecor;
	}

	/**
	 * ��Ʊ���ȡ��
	 * @return ��Ʊ���
	 */
	public BigDecimal getLpdinvoiceamount() {
		return lpdinvoiceamount;
	}

	/**
	 * ��Ʊ����趨
	 * @param lpdinvoiceamount ��Ʊ���
	 */
	public void setLpdinvoiceamount(BigDecimal lpdinvoiceamount) {
		this.lpdinvoiceamount = lpdinvoiceamount;
	}

	/**
	 * ʵ����;˵��ȡ��
	 * @return ʵ����;˵��
	 */
	public String getLpdinvoicecomment() {
		return lpdinvoicecomment;
	}

	/**
	 * ʵ����;˵���趨
	 * @param lpdinvoicecomment ʵ����;˵��
	 */
	public void setLpdinvoicecomment(String lpdinvoicecomment) {
		this.lpdinvoicecomment = lpdinvoicecomment;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getLpddate() {
		return lpddate;
	}

	/**
	 * ���������趨
	 * @param lpddate ��������
	 */
	public void setLpddate(String lpddate) {
		this.lpddate = lpddate;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getLpduser() {
		return lpduser;
	}

	/**
	 * �������趨
	 * @param lpduser ������
	 */
	public void setLpduser(String lpduser) {
		this.lpduser = lpduser;
	}

	/**
	 * ���ʽȡ��
	 * @return ���ʽ
	 */
	public String getLpdtype() {
		return lpdtype;
	}

	/**
	 * ���ʽ�趨
	 * @param lpdtype ���ʽ
	 */
	public void setLpdtype(String lpdtype) {
		this.lpdtype = lpdtype;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public BigDecimal getLpdamount() {
		return lpdamount;
	}

	/**
	 * �������趨
	 * @param lpdamount ������
	 */
	public void setLpdamount(BigDecimal lpdamount) {
		this.lpdamount = lpdamount;
	}

	/**
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String getLpdstatus() {
		return lpdstatus;
	}

	/**
	 * ����״̬�趨
	 * @param lpdstatus ����״̬
	 */
	public void setLpdstatus(String lpdstatus) {
		this.lpdstatus = lpdstatus;
	}

	/**
	 * �����˻��������ȡ��
	 * @return �����˻��������
	 */
	public String getLpduserorg() {
		return lpduserorg;
	}

	/**
	 * �����˻���������趨
	 * @param lpduserorg �����˻��������
	 */
	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	/**
	 * �����˻�������ȡ��
	 * @return �����˻�������
	 */
	public String getLpduserorgname() {
		return lpduserorgname;
	}

	/**
	 * �����˻��������趨
	 * @param lpduserorgname �����˻�������
	 */
	public void setLpduserorgname(String lpduserorgname) {
		this.lpduserorgname = lpduserorgname;
	}

	/**
	 * ʵ�ʷ�Ʊ���ȡ��
	 * @return ʵ�ʷ�Ʊ���
	 */
	public BigDecimal getLpdactinvoice() {
		return lpdactinvoice;
	}

	/**
	 * ʵ�ʷ�Ʊ����趨
	 * @param lpdactinvoice ʵ�ʷ�Ʊ���
	 */
	public void setLpdactinvoice(BigDecimal lpdactinvoice) {
		this.lpdactinvoice = lpdactinvoice;
	}

	/**
	 * ʵ�ʻ�����ȡ��
	 * @return ʵ�ʻ�����
	 */
	public String getLpdactuser() {
		return lpdactuser;
	}

	/**
	 * ʵ�ʻ������趨
	 * @param lpdactuser ʵ�ʻ�����
	 */
	public void setLpdactuser(String lpdactuser) {
		this.lpdactuser = lpdactuser;
	}

	/**
	 * ɾ�����Ʊ����ȡ��
	 * @return ɾ�����Ʊ����
	 */
	public String[] getDeleteLpdid() {
		return deleteLpdid;
	}

	/**
	 * ɾ�����Ʊ�����趨
	 * @param deleteLpdid ɾ�����Ʊ����
	 */
	public void setDeleteLpdid(String[] deleteLpdid) {
		this.deleteLpdid = deleteLpdid;
	}

	public Integer getAcid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdcomment() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdpersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdpersionname() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getLpdstockamount() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrganizationTB getOrganizationTB() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����Idȡ��
	 * @return ����Id
	 */
	public Integer getLpdid() {
		return lpdid;
	}

	/**
	 * ����Id�趨
	 * @param lpdid ����Id
	 */
	public void setLpdid(Integer lpdid) {
		this.lpdid = lpdid;
	}
	
	/**
	 * �軹��ʱ��ȡ��
	 * @return �軹��ʱ��
	 */
	public String getLpdtime() {
		return lpdtime;
	}

	/**
	 * �軹��ʱ���趨
	 * @param lpdtime �軹��ʱ��
	 */
	public void setLpdtime(String lpdtime) {
		this.lpdtime = lpdtime;
	}
	
}
