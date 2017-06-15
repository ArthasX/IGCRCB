package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;

/**
 * ������ϸ��Ϣ����FORM
 * 
 */
public class IGSYM1502Form extends BaseForm implements CodeDetailDefSearchCond {

	private static final long serialVersionUID = 1L;
	
	/** ���ݷ���CD */
	protected String ccid ;
	/** ���ݷ���CD */
	protected String tempccid ;
	
	/** ����CD */
	protected String cid ;
	
	/** ����CD */
	protected String tempcid ;
	
	/** ���ݷ���CD */
	protected String ccname ;
	
	/** ����id */
	protected String pcid ;
	
	/** �������� */
	protected String pcvalue ;
	
	/** ״̬ 0-ͣ�ã�1-���� */
	protected String cdstatus;
	
	/** ���� */
	protected String clevel;
	
	protected String pccid;
	
	/** ��ѯָ�������¼��� */
	protected String syscoding_q;
	
	/** ��ѯָ����� */
	protected String syscoding;
	
	protected String psyscoding;
	
	/** �Ƿ��ѡ����ڵ� 1������ */
	protected String rootSelect;
	
	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * ���ݷ���CD�趨
	 *
	 * @param ccid ���ݷ���CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * ����CD�趨
	 *
	 * @param cid ����CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getPcvalue() {
		return pcvalue;
	}

	public void setPcvalue(String pcvalue) {
		this.pcvalue = pcvalue;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
	/**
	 * ״̬ 0-ͣ�ã�1-����
	 * @return ״̬
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * ״̬ 0-ͣ�ã�1-����
	 *
	 * @param cdstatus ״̬
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	public String getTempcid() {
		return tempcid;
	}

	public void setTempcid(String tempcid) {
		this.tempcid = tempcid;
	}

	public String getTempccid() {
		return tempccid;
	}

	public void setTempccid(String tempccid) {
		this.tempccid = tempccid;
	}

	public String getClevel() {
		return clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public String getPccid() {
		return pccid;
	}

	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	public String getPcid() {
		return pcid;
	}

	public String getPsyscoding() {
		return psyscoding;
	}

	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	public String getSyscoding_q() {
		return syscoding_q;
	}

	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
	}

	

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	public String getSyscoding() {
		return syscoding;
	}

	public String getBusinesscode_like() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �Ƿ��ѡ����ڵ�ȡ��
	 * @return �Ƿ��ѡ����ڵ�
	 */
	public String getRootSelect() {
		return rootSelect;
	}

	/**
	 * �Ƿ��ѡ����ڵ��趨
	 * @param rootSelect�Ƿ��ѡ����ڵ�
	 */
	public void setRootSelect(String rootSelect) {
		this.rootSelect = rootSelect;
	}

	public String getCvalue_like() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
