/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;

/**
 * @Description: ���̶��������Ϣ�༭����Form
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */

@SuppressWarnings("serial")
public class IGPRD0105Form extends BaseForm implements IG333Info {
	
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
	
	/** ģʽ 0�Ǽǣ�1�༭ */
	protected String mode;
	
	/** ����״̬��¼��ʱ��� */
	protected String fingerPrint;
	
	/** ���̽ڵ����� */
	protected String psdtype;
	
	/** ���̽ڵ�ģʽ */
	protected String psdmode;
	
	protected char[] pdxml;

	/**
     * ����ҳ������
     */
    protected String assignPageType;
    
	/** ����״̬ǰ������� */
	protected List<IG211TB> processStatusInfoDef;
	
	/**
	 * ���̽ڵ��Ƿ�̬ȡ�����߱�ʶ��0����ȡ�����ߣ�1��̬ȡ������ ��
	 */
	protected String psdflag;
	

	/**
	 * ���ɲ��������ͣ�0��Ա��1��ɫ ��
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
	 * ����״̬ID
	 */
	protected String assignpsdid;
	
	/**
	 * ���ɰ�ťID
	 */
	protected String assignpbdid;
	
	/**
	 * ���ɱ�ʶ
	 */
	protected String assignflag;
	
	protected String participantchange;
	
	/** ��ȫ�����Ʊ�ʶ */
	protected String formGlobalControl;
	
	/** ����״̬ */
	protected String[] assignpsdids;
	
	/** ���ɰ�ť*/
	protected String[] assignpbdids;
	
	/** ������� */
	protected String[] assignflags;
    
    /** js���� */
    protected String jsfunction;
    
	/** ���� */
	protected String bysequence;

	/** �ϼ�״̬ID */
	protected String ppsdid;

	/** ����������ͼ */
	protected String psdxml;
	
	/** ��̬��֧������0������ɫ��1�����û��� */
	protected String branchcond;
	
	/** �Ƿ�ɴ��洦�� */
	protected String replaceDispose;
/** ״̬��˽�б���id */
    protected String[] pidids;
    /** ״̬��˽�б���Ĭ��ֵ  */
    protected String[] defvalues;
    
    public String[] getPidids() {
        return pidids;
    }

    public void setPidids(String[] pidids) {
        this.pidids = pidids;
    }

    public String[] getDefvalues() {
        return defvalues;
    }
    
    public void setDefvalues(String[] defvalues) {
        this.defvalues = defvalues;
    }
	
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
	 * ����״̬��¼��ʱ���ȡ��
	 * @return ����״̬��¼��ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}
	
	/**
	 * ����״̬��¼��ʱ����趨
	 * @param fingerPrint ����״̬��¼��ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * ģʽȡ��
	 * @return ģʽ
	 */
	public String getMode() {
		return mode;
	}
	
	/**
	 * ģʽ�趨
	 * @param mode ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
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
	 * ����״̬ǰ�������ȡ��
	 * @return ����״̬ǰ�������
	 */
	public List<IG211TB> getProcessStatusInfoDef() {
		return processStatusInfoDef;
	}

	/**
	 * ����״̬ǰ��������趨
	 * @param processStatusInfoDef ����״̬ǰ�������
	 */
	public void setProcessStatusInfoDef(
			List<IG211TB> processStatusInfoDef) {
		this.processStatusInfoDef = processStatusInfoDef;
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

	public char[] getPdxml() {
		return pdxml;
	}

	public void setPdxml(char[] pdxml) {
		this.pdxml = pdxml;
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

	public String getAssignpsdid() {
		return assignpsdid;
	}

	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
	}

	public String getAssignpbdid() {
		return assignpbdid;
	}

	public void setAssignpbdid(String assignpbdid) {
		this.assignpbdid = assignpbdid;
	}

	public String getAssignflag() {
		return assignflag;
	}

	public void setAssignflag(String assignflag) {
		this.assignflag = assignflag;
	}

	public String getParticipantchange() {
		return participantchange;
	}

	public void setParticipantchange(String participantchange) {
		this.participantchange = participantchange;
	}

	protected String isSelected;

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
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String[] getAssignpsdids() {
		return assignpsdids;
	}

	/**
	 * ���ɰ�ťȡ��
	 * @return ���ɰ�ť
	 */
	public String[] getAssignpbdids() {
		return assignpbdids;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String[] getAssignflags() {
		return assignflags;
	}

	/**
	 * ����״̬�趨
	 * @param assignpsdids ����״̬
	 */
	public void setAssignpsdids(String[] assignpsdids) {
		this.assignpsdids = assignpsdids;
	}

	/**
	 * ���ɰ�ť�趨
	 * @param assignpbdids ���ɰ�ť
	 */
	public void setAssignpbdids(String[] assignpbdids) {
		this.assignpbdids = assignpbdids;
	}

	/**
	 * ��������趨
	 * @param assignflags �������
	 */
	public void setAssignflags(String[] assignflags) {
		this.assignflags = assignflags;
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
	 * @return bysequence ����
	 */
	public String getBysequence() {
		return bysequence;
	}

	/**
	 * �����趨
	 * @param bysequence ����
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
