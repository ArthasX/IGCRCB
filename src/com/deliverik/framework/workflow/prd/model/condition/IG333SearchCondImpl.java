/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;


/**
 * ����״̬��������ʵ��
 *
 */
public class IG333SearchCondImpl implements IG333SearchCond {
	
	/**
	 *  ����״̬ID
	 */
	protected String psdid;
	
	/**
	 * ��������ID
	 */
	protected String pdid;
	/**
	 * ��������ID(Ӧ������ר��)
	 */
	protected String pdid_like;

	/**
	 * ����״̬����
	 */
	protected String psdname;
	
	/**
	 * ����״̬��ʶ
	 */
	protected String psdcode;
	
	/**
	 * ���̽ڵ��Ƿ�̬ȡ�����߱�ʶ��0����ȡ�����ߣ�1��̬ȡ������ ��
	 */
	protected String psdflag;
	
	/**
	 * ���ɽڵ�ID
	 */
	protected String assignpsdid;
	
	/**
	 * ���ɰ�ťID
	 */
	protected String assignpbdid;
	
	/**
	 * �������ر�״̬
	 */
	protected String notContainEndStatus;
	
	/**
	 * ��������ʼ״̬
	 */
	protected String notContainStartStatus;
	
	/**
	 * ����������״̬
	 */
	protected String notContainSelf;
	
	protected String psdtype;
	protected String psdmode;
	
	/** ����״̬ID */
	protected String psdid_like;
	
	/** ��ȫ�����Ʊ�ʶ */
	protected String formGlobalControl;

	/** �ϼ�״̬ID */
	protected String ppsdid;
	
	/** һ��״̬ */
	protected String fatherflag;
	
	protected String bysequence;

	protected String orderField;
	/** ��ȡǰ�ڵ� */
	protected String fingerprint;
	/**Ӧ�����̱�ʶ*/
	protected String drmSign;


protected String subpsdtype;
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
	
	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	 * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ����״̬�����趨
	 * @param psdname ����״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * ����״̬��ʶȡ��
	 * @return ����״̬��ʶ
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ����״̬��ʶ�趨
	 * @param psdcode ����״̬��ʶ
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * ���ɽڵ�IDȡ��
	 * 
	 * @return ���ɽڵ�ID
	 */
	public String getAssignpsdid() {
		return assignpsdid;
	}

	/**
	 * ���ɽڵ�ID�趨
	 * 
	 * @param assignpsdid ���ɽڵ�ID
	 */
	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
	}

	/**
	 * ���ɰ�ťIDȡ��
	 * 
	 * @return ���ɰ�ťID
	 */
	public String getAssignpbdid() {
		return assignpbdid;
	}

	/**
	 * ���ɰ�ťID�趨
	 * 
	 * @param assignpbdid ���ɰ�ťID
	 */
	public void setAssignpbdid(String assignpbdid) {
		this.assignpbdid = assignpbdid;
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

	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * ����״̬ID�趨
	 * 
	 * @param psdid_like ����״̬ID
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}
	
	/**
     * ��ȫ�ֿ��Ʊ�ʶȡ��
     * @return ��ȫ�ֿ��Ʊ�ʶ
     */
	public String getFormGlobalControl() {
		return formGlobalControl;
	}

	/**
	 * ��ȫ�����Ʊ�ʶ�趨
	 * @param formGlobalControl ��ȫ�ֿ��Ʊ�ʶ
	 */
	public void setFormGlobalControl(String formGlobalControl) {
		this.formGlobalControl = formGlobalControl;
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

	/**
	 * @return the fatherflag
	 */
	public String getFatherflag() {
		return fatherflag;
	}

	/**
	 * @param fatherflag the fatherflag to set
	 */
	public void setFatherflag(String fatherflag) {
		this.fatherflag = fatherflag;
	}

	/**
	 * bysequence   ȡ��
	 * @return bysequence bysequence
	 */
	public String getBysequence() {
		return bysequence;
	}

	/**
	 * bysequence   �趨
	 * @param bysequence bysequence
	 */
	public void setBysequence(String bysequence) {
		this.bysequence = bysequence;
	}

	/**
	 * orderField   ȡ��
	 * @return orderField orderField
	 */
	public String getOrderField() {
		return orderField;
	}

	/**
	 * orderField   �趨
	 * @param orderField orderField
	 */
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	/**
	 * subpsdtype   ȡ��
	 * @return subpsdtype subpsdtype
	 */
	public String getSubpsdtype() {
		return subpsdtype;
	}

	/**
	 * subpsdtype   �趨
	 * @param subpsdtype subpsdtype
	 */
	public void setSubpsdtype(String subpsdtype) {
		this.subpsdtype = subpsdtype;
	}

	/**
	 * @return the ��������ID(Ӧ������ר��)
	 */
	public String getPdid_like() {
		return pdid_like;
	}

	/**
	 * @param ��������ID(Ӧ������ר��) the pdid_like to set
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}
	/**  
	 * ??��???��??��?����?  
	 * @return fingerprint ??��??��?����?  
	 */
	
	public String getFingerprint() {
		return fingerprint;
	}

	/**  
	 * ����????��??��?����?  
	 * @param fingerprint ??��??��?����?  
	 */
	
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	/**  
	 * ��ȡdrmSign  
	 * @return drmSign 
	 */
	public String getDrmSign() {
		return drmSign;
	}

	/**  
	 * ����drmSign  
	 * @param drmSign
	 */
	
	public void setDrmSign(String drmSign) {
		this.drmSign = drmSign;
	}
	
	
}
