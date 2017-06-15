package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;

/**
 * ������ϸ��Ϣ����FORM
 * 
 */
public class IGSYM1201Form extends BaseForm implements CodeDetailSearchCond {

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
	
	protected String psyscoding;
	
	/** ��ѯָ�������¼��� */
	protected String syscoding_q;
	
	/** ��ѯָ����� */
	protected String syscoding;
	
	/** entity syscoding */
	protected String esyscoding;
	
	/** entity parsyscoding */
	protected String eparsyscoding;
	
	protected String cvalue;
	
	protected String cdinfo_eq;
	
	public String getSyscoding() {
		return syscoding;
	}

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEparsyscoding() {
		return eparsyscoding;
	}

	public void setEparsyscoding(String eparsyscoding) {
		this.eparsyscoding = eparsyscoding;
	}

	public String getSyscoding_q() {
		return syscoding_q;
	}

	public void setSyscoding_q(String syscoding_q) {
		this.syscoding_q = syscoding_q;
	}

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

	public String getBusinesscode_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCdinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public String getCdinfo_eq() {
		return cdinfo_eq;
	}

	public void setCdinfo_eq(String cdinfo_eq) {
		this.cdinfo_eq = cdinfo_eq;
	}

	public List<String> getCidList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
