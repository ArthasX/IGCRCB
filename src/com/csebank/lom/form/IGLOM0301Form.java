/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.AdvanCescost;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ӵ������ǼǱ��Form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0301Form extends BaseForm  implements AdvanCescost {

	/** Ԥ֧����ID */
	protected Integer acid;
	
	/** Ԥ֧��� */
	protected BigDecimal acamount;
	
	/** �ƲƼ������� */
	protected String acdate;
	
	/** Ԥ֧��ʽ */
	protected String actype;
	
	/** ֧Ʊ�� */
	protected String acchequenum;
	
	/** Ԥ֧������ */
	protected String acserial;
	
	/** Ԥ֧��Ҫ��;˵�� */
	protected String accomment;
	
	/** Ԥ֧״̬ */
	protected String acstatus;
	
	/** �����ֽ��� */
	protected BigDecimal acfreezeamount;
	
	/** ���Ʊ��� */
	protected BigDecimal acinvoiceamount;
	
	/** ����� */
	protected BigDecimal acstockamount;
	
	/** Ԥ֧������� */
	protected String accreditdate;
	
	/** Ԥ֧�Ǽ����� */
	protected String acinsdate;
	
	/** �༭��ʶ */
	protected String mode = "0";
	
	/** �Ǽ���ID */
	protected String acuserid;
	
	/** �Ǽ������� */
	protected String acusername;
	
	/** Ԥ֧�Ǽ�ʱ�� */
	protected String acinstime;
	
	/**
	 * Ԥ֧����IDȡ��
	 * @return Ԥ֧����ID
	 */
	public Integer getAcid() {
		return acid;
	}

	/**
	 * Ԥ֧����ID�趨
	 * @param acid Ԥ֧����ID
	 */
	public void setAcid(Integer acid) {
		this.acid = acid;
	}

	/**
	 * Ԥ֧���ȡ��
	 * @return Ԥ֧���
	 */
	public BigDecimal getAcamount() {
		return acamount;
	}

	/**
	 * Ԥ֧����趨
	 * @param acamount Ԥ֧���
	 */
	public void setAcamount(BigDecimal acamount) {
		this.acamount = acamount;
	}

	/**
	 * �ƲƼ�������ȡ��
	 * @return �ƲƼ�������
	 */
	public String getAcdate() {
		return acdate;
	}

	/**
	 * �ƲƼ��������趨
	 * @param acdate �ƲƼ�������
	 */
	public void setAcdate(String acdate) {
		this.acdate = acdate;
	}

	/**
	 * Ԥ֧��ʽȡ��
	 * @return Ԥ֧��ʽ
	 */
	public String getActype() {
		return actype;
	}
	
	/**
	 * Ԥ֧��ʽ�趨
	 * @param actype Ԥ֧��ʽ
	 */
	public void setActype(String actype) {
		this.actype = actype;
	}

	/**
	 * ֧Ʊ��ȡ��
	 * @return ֧Ʊ��
	 */
	public String getAcchequenum() {
		return acchequenum;
	}

	/**
	 * ֧Ʊ���趨
	 * @param acchequenum ֧Ʊ��
	 */
	public void setAcchequenum(String acchequenum) {
		this.acchequenum = acchequenum;
	}

	/**
	 * Ԥ֧������ȡ��
	 * @return Ԥ֧������
	 */
	public String getAcserial() {
		return acserial;
	}

	/**
	 * Ԥ֧�������趨
	 * @param acserial Ԥ֧������
	 */
	public void setAcserial(String acserial) {
		this.acserial = acserial;
	}

	/**
	 * Ԥ֧��Ҫ��;˵��ȡ��
	 * @return Ԥ֧��Ҫ��;˵��
	 */
	public String getAccomment() {
		return accomment;
	}

	/**
	 * Ԥ֧��Ҫ��;˵���趨
	 * @param accomment Ԥ֧��Ҫ��;˵��
	 */
	public void setAccomment(String accomment) {
		this.accomment = accomment;
	}

	/**
	 * Ԥ֧״̬ȡ��
	 * @return Ԥ֧״̬
	 */
	public String getAcstatus() {
		return acstatus;
	}

	/**
	 * Ԥ֧����ID�趨
	 * @param acdate Ԥ֧����ID
	 */
	public void setAcstatus(String acstatus) {
		this.acstatus = acstatus;
	}

	/**
	 * �����ֽ���ȡ��
	 * @return �����ֽ���
	 */
	public BigDecimal getAcfreezeamount() {
		return acfreezeamount;
	}

	/**
	 * �����ֽ����趨
	 * @param acfreezeamount �����ֽ���
	 */
	public void setAcfreezeamount(BigDecimal acfreezeamount) {
		this.acfreezeamount = acfreezeamount;
	}
	
	/**
	 * ���Ʊ���ȡ��
	 * @return ���Ʊ���
	 */
	public BigDecimal getAcinvoiceamount() {
		return acinvoiceamount;
	}

	/**
	 * ���Ʊ����趨
	 * @param acinvoiceamount ���Ʊ���
	 */
	public void setAcinvoiceamount(BigDecimal acinvoiceamount) {
		this.acinvoiceamount = acinvoiceamount;
	}
	
	/**
	 * Ԥ֧���ʱ��ȡ��
	 * @return Ԥ֧���ʱ��
	 */
	public String getAccreditdate() {
		return accreditdate;
	}

	/**
	 * Ԥ֧���ʱ���趨
	 * @param accreditdate Ԥ֧���ʱ��
	 */
	public void setAccreditdate(String accreditdate) {
		this.accreditdate = accreditdate;
	}

	/**
	 * Ԥ֧�Ǽ�ʱ��ȡ��
	 * @return Ԥ֧�Ǽ�ʱ��
	 */
	public String getAcinsdate() {
		return acinsdate;
	}

	/**
	 * Ԥ֧�Ǽ�ʱ���趨
	 * @param acinsdate Ԥ֧�Ǽ�ʱ��
	 */
	public void setAcinsdate(String acinsdate) {
		this.acinsdate = acinsdate;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �༭��ʶȡ��
	 * @return �༭��ʶ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �༭��ʶ�趨
	 * @param mode �༭��ʶ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * �����ȡ��
	 * @return �����
	 */
	public BigDecimal getAcstockamount() {
		return acstockamount;
	}

	/**
	 * �����ȡ��
	 * @return �����
	 */
	public void setAcstockamount(BigDecimal acstockamount) {
		this.acstockamount = acstockamount;
	}
	
	/**
	 * �Ǽ���IDȡ��
	 * @return �Ǽ���ID
	 */
	public String getAcuserid() {
		return acuserid;
	}

	/**
	 * �Ǽ���ID�趨
	 * @param acuserid �Ǽ���ID
	 */
	public void setAcuserid(String acuserid) {
		this.acuserid = acuserid;
	}

	/**
	 * �Ǽ�������ȡ��
	 * @return �Ǽ�������
	 */
	public String getAcusername() {
		return acusername;
	}

	/**
	 * �Ǽ��������趨
	 * @param acusername �Ǽ�������
	 */
	public void setAcusername(String acusername) {
		this.acusername = acusername;
	}
	
	/**
	 * Ԥ֧�Ǽ�ʱ��ȡ��
	 * @return Ԥ֧�Ǽ�ʱ��
	 */
	public String getAcinstime() {
		return acinstime;
	}

	/**
	 * Ԥ֧�Ǽ�ʱ���趨
	 * @param acinstime Ԥ֧�Ǽ�ʱ��
	 */
	public void setAcinstime(String acinstime) {
		this.acinstime = acinstime;
	}
	
}
