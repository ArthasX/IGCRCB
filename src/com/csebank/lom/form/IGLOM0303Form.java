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
 * ���ǼǱ��Form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0303Form extends BaseForm  implements LoanPayDetail {


	/** �軹��ID */
	protected Integer lpdid;
	
	/** �軹������(0:��� 1:�ֽ𻹿� 2:֧Ʊ����) */
	protected String lpdtype;
	
	/** �軹���� */
	protected String lpduser;
	
	/** �軹������ */
	protected String lpddate;
	
	/** �軹���� */
	protected BigDecimal lpdamount;
	
	/** ��; */
	protected String lpdcomment;
	
	/** ״̬(���ʱ: 0:��ȷ�� 1:������ 2:��ȷ�� 3:����δͨ�� 4:�ѻ���) */
	protected String lpdstatus;
	
	/** �༭��ʶ */
	protected String mode = "0";
	
	/** ����˻�������� */
	protected String lpduserorg;
	
	/** ����˻������� */
	protected String lpduserorgname;
	
	/** ����� */
	protected BigDecimal lpdstockamount;
	
	/** �Ӵ�ID */
	protected Integer rid;
	
	/** �軹��ʱ�� */
	public String lpdtime;
	
	/** ���ý�� */
	protected BigDecimal availableAmount;
	
	
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
	 * �軹��IDȡ��
	 * @return �軹��ID
	 */
	public Integer getLpdid() {
		return lpdid;
	}

	/**
	 * �軹��ID�趨
	 * @param lpdid �軹��ID
	 */
	public void setLpdid(Integer lpdid) {
		this.lpdid = lpdid;
	}

	/**
	 * �軹������ȡ��
	 * @return �軹������
	 */
	public String getLpdtype() {
		return lpdtype;
	}

	/**
	 * �軹�������趨
	 * @param lpdtype �軹������
	 */
	public void setLpdtype(String lpdtype) {
		this.lpdtype = lpdtype;
	}

	/**
	 * �軹����ȡ��
	 * @return �軹����
	 */
	public String getLpduser() {
		return lpduser;
	}

	/**
	 * �軹�����趨
	 * @param lpduser �軹����
	 */
	public void setLpduser(String lpduser) {
		this.lpduser = lpduser;
	}

	/**
	 * �軹������ȡ��
	 * @return �軹������
	 */
	public String getLpddate() {
		return lpddate;
	}

	/**
	 * �軹�������趨
	 * @param lpddate �軹������
	 */
	public void setLpddate(String lpddate) {
		this.lpddate = lpddate;
	}

	/**
	 * �軹����ȡ��
	 * @return �軹����
	 */
	public BigDecimal getLpdamount() {
		return lpdamount;
	}

	/**
	 * �軹�����趨
	 * @param lpdamount �軹����
	 */
	public void setLpdamount(BigDecimal lpdamount) {
		this.lpdamount = lpdamount;
	}

	/**
	 * ��;ȡ��
	 * @return ��;
	 */
	public String getLpdcomment() {
		return lpdcomment;
	}

	/**
	 * ��;�趨
	 * @param lpdcomment ��;
	 */
	public void setLpdcomment(String lpdcomment) {
		this.lpdcomment = lpdcomment;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getLpdstatus() {
		return lpdstatus;
	}

	/**
	 * ״̬�趨
	 * @param lpdstatus ״̬
	 */
	public void setLpdstatus(String lpdstatus) {
		this.lpdstatus = lpdstatus;
	}

	public Integer getLdid() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getLpdinvoiceamount() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicecomment() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicecor() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicedate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicenum() {
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

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getAcid() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrganizationTB getOrganizationTB() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����˻��������ȡ��
	 * @return ����˻��������
	 */
	public String getLpduserorg() {
		return lpduserorg;
	}

	/**
	 * ����˻���������趨
	 * @param lpduserorg ����˻��������
	 */
	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	/**
	 * ����˻�������ȡ��
	 * @return ����˻�������
	 */
	public String getLpduserorgname() {
		return lpduserorgname;
	}

	/**
	 * ����˻��������趨
	 * @param lpduserorgname ����˻�������
	 */
	public void setLpduserorgname(String lpduserorgname) {
		this.lpduserorgname = lpduserorgname;
	}

	/**
	 * �Ӵ�IDȡ��
	 * @return �Ӵ�ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�ID�趨
	 * @param rid �Ӵ�ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	/**
	 * �����ȡ��
	 * @return �����
	 */
	public BigDecimal getLpdstockamount() {
		return lpdstockamount;
	}

	/**
	 * ������趨
	 * @param lpdstockamount �����
	 */
	public void setLpdstockamount(BigDecimal lpdstockamount) {
		this.lpdstockamount = lpdstockamount;
	}

	public BigDecimal getLpdactinvoice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdactuser() {
		// TODO Auto-generated method stub
		return null;
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
	
	/**
	 * ���ý��ȡ��
	 * @return ���ý��
	 */
	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	/**
	 * ���ý���趨
	 * @param availableAmount ���ý��
	 */
	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}
	
}
