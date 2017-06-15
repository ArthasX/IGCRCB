/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;

/**
 * ���̶���_����״̬FORM
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0104Form extends BaseForm implements IG333SearchCond{
	/** ����״̬ID */
	protected String psdid;
	
	/** ����ID */
	protected String pdid;
	
	
	/** ����״̬������ */
	protected String psdname;
	
	/** ����״̬������ */
	protected String psddesc;
	
	/** ����״̬�ı�ʶ */
	protected String psdcode;
	
	protected String pdxml;
	
	protected String psdtype;
	
	protected String psdmode;

	/**
	 * ���̽ڵ��Ƿ�̬ȡ�����߱�ʶ��0����ȡ�����ߣ�1��̬ȡ������ ��
	 */
	protected String psdflag;

	/** �ϼ�״̬ID */
	protected String ppsdid;
	
	/**
	 * ���̽ڵ㶯̬�����߱�ʶȡ��
	 * @return ���̽ڵ㶯̬�����߱�ʶ
	 */
	public String getPsdflag() {
		return psdflag;
	}

	/**
	 * ���̽ڵ㶯̬�����߱�ʶ�趨
	 * @param psdflag ���̽ڵ㶯̬�����߱�ʶ
	 */
	public void setPsdflag(String psdflag) {
		this.psdflag = psdflag;
	}
	
	public String getPdxml() {
		return pdxml;
	}

	public void setPdxml(String pdxml) {
		this.pdxml = pdxml;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPsdname() {
		return psdname;
	}

	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	public String getPsddesc() {
		return psddesc;
	}

	public void setPsddesc(String psddesc) {
		this.psddesc = psddesc;
	}

	public String getPsdcode() {
		return psdcode;
	}

	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}
	
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/**
	 * �鿴ģʽ
	 *
	 * @return �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ
	 *
	 * @param viewHistory  0�����£�1��ʷ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	public String assignpbdid;
	public String assignpsdid;
	public String notContainEndStatus;
	public String notContainStartStatus;
	public String notContainSelf;


	public String getAssignpbdid() {
		return assignpbdid;
	}

	public void setAssignpbdid(String assignpbdid) {
		this.assignpbdid = assignpbdid;
	}

	public String getAssignpsdid() {
		return assignpsdid;
	}

	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
	}

	public String getNotContainEndStatus() {
		return notContainEndStatus;
	}

	public void setNotContainEndStatus(String notContainEndStatus) {
		this.notContainEndStatus = notContainEndStatus;
	}

	public String getNotContainSelf() {
		return notContainSelf;
	}

	public void setNotContainSelf(String notContainSelf) {
		this.notContainSelf = notContainSelf;
	}

	public String getNotContainStartStatus() {
		return notContainStartStatus;
	}

	public void setNotContainStartStatus(String notContainStartStatus) {
		this.notContainStartStatus = notContainStartStatus;
	}

	public String getPsdtype() {
		return psdtype;
	}

	public void setPsdtype(String psdtype) {
		this.psdtype = psdtype;
	}

	public String getPsdmode() {
		return psdmode;
	}

	public void setPsdmode(String psdmode) {
		this.psdmode = psdmode;
	}

	public String getPsdid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFormGlobalControl() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�״̬ID�趨
	 * @param ppsdid �ϼ�״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	public String getFatherflag() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond#getBysequence()
	 */
	public String getBysequence() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond#getOrderField()
	 */
	public String getOrderField() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond#getSubpsdtype()
	 */
	public String getSubpsdtype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPdid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFingerprint() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond#getDrmSign()
	 */
	public String getDrmSign() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
