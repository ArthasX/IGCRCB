/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ����״̬
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG333")
public class IG333TB extends BaseEntity implements Serializable, Cloneable, IG333Info {
	
	/** ����״̬ID */
	@Id
	protected String psdid;
	
	/**
	 * ��������ID
	 */
	protected String pdid;

	/**
	 * ����״̬����
	 */
	protected String psdname;
	
	/**
	 * ����״̬����
	 */
	protected String psddesc;
	
	/**
	 * ����״̬��ʶ
	 */
	protected String psdcode;
	
	/**
	 * ���̽ڵ�����
	 */
	protected String psdtype;
	
	/**
	 * ���̽ڵ�ģʽ
	 */
	protected String psdmode;
	
	protected String participantchange;
	
	/** ��ȫ�����Ʊ�ʶ */
	protected String formGlobalControl;
	
	/**
	 * ���̽ڵ��Ƿ�̬ȡ�����߱�ʶ��0����ȡ�����ߣ�1��̬ȡ�����ߣ�
	 */
	protected String psdflag;
	
	/**
	 * ���ɲ��������ͣ�0��Ա��1��ɫ��
	 */
	protected String psdassign;
	
	/**
	 * �Ƿ�������ˣ�0�ǣ�1�� ��
	 */
	protected String psdorg;
	
	/**
	 * ����ȷ�ϲ�����0�ޣ�1�У�
	 */
	protected String psdconfirm;
	
	/**
	 * ���ɽڵ�ID
	 */
	protected String assignpsdid;
	
	/**
	 * ���ɰ�ťID
	 */
	protected String assignpbdid;
	
	/**
	 * �Ƿ������ɱ�ʶ
	 */
	protected String assignflag;
	
	/**
	 * �����߾��е����̱���Ȩ��
	 */
	@Transient
	protected String isSelected;
	
    /**
     * ����ҳ������
     */
    protected String assignPageType;
    
    /** js���� */
    protected String jsfunction;
    
	/**
	 * ����
	 */
	protected String bysequence;

	/** �ϼ�״̬ID */
	protected String ppsdid;
	
	/** ����������ͼ */
	protected String psdxml;
	
	/** ��̬��֧������0������ɫ��1�����û��� */
	protected String branchcond;
	
	/** �Ƿ�ɴ��洦�� */
	protected String replaceDispose;
	
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
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return psdid;
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
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsddesc() {
		return psddesc;
	}

	/**
	 * ����״̬�����趨
	 * @param psddesc ����״̬����
	 */
	public void setPsddesc(String psddesc) {
		this.psddesc = psddesc;
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
	 * ���̽ڵ�����ȡ��
	 * @return ���̽ڵ�����
	 */
	public String getPsdtype() {
		return psdtype;
	}

	/**
	 * ���̽ڵ������趨
	 * @param psdtype ���̽ڵ�����
	 */
	public void setPsdtype(String psdtype) {
		this.psdtype = psdtype;
	}
	
	/**
	 * ���̽ڵ�ģʽȡ��
	 * @return ���̽ڵ�ģʽ
	 */
	public String getPsdmode() {
		return psdmode;
	}

	/**
	 * ���̽ڵ�ģʽ�趨
	 * @param psdmode���̽ڵ�ģʽ
	 */
	public void setPsdmode(String psdmode) {
		this.psdmode = psdmode;
	}

	/**
	 * ���ɲ���������ȡ��
	 * 
	 * @return ���ɲ���������
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * ���ɲ����������趨
	 * 
	 * @param psdassign ���ɲ���������
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}

	/**
	 * �Ƿ��������ȡ��
	 * 
	 * @return �Ƿ��������
	 */
	public String getPsdorg() {
		return psdorg;
	}

	/**
	 * �Ƿ���������趨
	 * 
	 * @param psdorg �Ƿ��������
	 */
	public void setPsdorg(String psdorg) {
		this.psdorg = psdorg;
	}

	/**
	 * ����ȷ�ϲ���ȡ��
	 * 
	 * @return ����ȷ�ϲ���
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * ����ȷ�ϲ����趨
	 * 
	 * @param psdconfirm ����ȷ�ϲ���
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
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

	public String getParticipantchange() {
		return participantchange;
	}

	public void setParticipantchange(String participantchange) {
		this.participantchange = participantchange;
	}
	
	/**
	 * �Ƿ������ɱ�ʶȡ��
	 * 
	 * @return �Ƿ������ɱ�ʶ
	 */
	public String getAssignflag() {
		return assignflag;
	}

	/**
	 * �Ƿ������ɱ�ʶ�趨
	 * 
	 * @param assignflag �Ƿ������ɱ�ʶ
	 */
	public void setAssignflag(String assignflag) {
		this.assignflag = assignflag;
	}
	
	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

    /**
     * @return the ����ҳ������
     */
    public String getAssignPageType() {
        return assignPageType;
    }

    /**
     * @param ����ҳ������ the assginPageType to set
     */
    public void setAssignPageType(String assignPageType) {
        this.assignPageType = assignPageType;
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
	 * js����ȡ��
	 * @return jsfunction js����
	 */
	public String getJsfunction() {
		return jsfunction;
	}

	/**
	 * js�����趨
	 * @param jsfunction js����
	 */
	public void setJsfunction(String jsfunction) {
		this.jsfunction = jsfunction;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getBysequence() {
		return bysequence;
	}

	/**
	 * �����趨
	 * 
	 * @param bysequence
	 *            ����
	 */
	public void setBysequence(String bysequence) {
		this.bysequence = bysequence;
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
	 * ����������ͼȡ��
	 * @return ����������ͼ
	 */
	public String getPsdxml() {
		return psdxml;
	}

	/**
	 * ����������ͼ�趨
	 * @param psdxml ����������ͼ
	 */
	public void setPsdxml(String psdxml) {
		this.psdxml = psdxml;
	}

	/**
	 * ��̬��֧����ȡ��
	 * @return ��̬��֧����
	 */
	public String getBranchcond() {
		return branchcond;
	}

	/**
	 * ��̬��֧�����趨
	 * @param branchcond ��̬��֧����
	 */
	public void setBranchcond(String branchcond) {
		this.branchcond = branchcond;
	}

	/**
	 * �Ƿ�ɴ��洦��ȡ��
	 * @return replaceDispose �Ƿ�ɴ��洦��
	 */
	public String getReplaceDispose() {
		return replaceDispose;
	}

	/**
	 * �Ƿ�ɴ��洦���趨
	 * @param replaceDispose �Ƿ�ɴ��洦��
	 */
	public void setReplaceDispose(String replaceDispose) {
		this.replaceDispose = replaceDispose;
	}
	
}
