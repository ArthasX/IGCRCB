/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.entity.IG900TB;

/**
 * ����Ϣ��ѯ����Form
 * 
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0141Form extends BaseForm implements IG156Info{
	
	/** ǰ�������ֵ����ֽ��� */
	protected static final int MAX_BYTE = 64;
	
	protected String mode = "0";

	protected String pseid;
	
	protected String psebuttonid;
	
	protected String pseactionid;

	/** ���̶���ID */
	protected String pdid;

	/** ״̬ID */
	protected String psdid;

	/** �¼�ִ��˳�� */
	protected Integer pseorder;
	
	/** �������� */
	protected String psedec;
	
	/** ״̬����*/
	protected String psdcode;
	
	/** ��ť����*/
	protected String psbdname;

	/** �ϼ�״̬ID */
	protected String ppsdid;

	public String getPsdcode() {
		return psdcode;
	}

	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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

	

	public String getPseid() {
		return pseid;
	}

	public void setPseid(String pseid) {
		this.pseid = pseid;
	}

	public String getPsebuttonid() {
		return psebuttonid;
	}

	public void setPsebuttonid(String psebuttonid) {
		this.psebuttonid = psebuttonid;
	}

	public String getPseactionid() {
		return pseactionid;
	}

	public void setPseactionid(String pseactionid) {
		this.pseactionid = pseactionid;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public Integer getPseorder() {
		return pseorder;
	}

	public void setPseorder(Integer pseorder) {
		this.pseorder = pseorder;
	}

	public String getPsedec() {
		return psedec;
	}

	public void setPsedec(String psedec) {
		this.psedec = psedec;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public IG900TB getProcessButtonDefTB() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * @return the ��ť����
     */
    public String getPsbdname() {
        return psbdname;
    }

    /**
     * @param ��ť���� the psbdname to set
     */
    public void setPsbdname(String psbdname) {
        this.psbdname = psbdname;
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

}
