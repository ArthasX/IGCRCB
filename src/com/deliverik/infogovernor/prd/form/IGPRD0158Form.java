/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prd.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.entity.IG335TB;

/**
 * ����: ����֪ͨ�����趨Form
 * ��������: ����֪ͨ�����趨Form
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD0158Form extends BaseForm {
	
	protected static int pssize = 0;
	protected static int pisize = 0;
	protected static int processWholeTactic_listSize = 0;
	
	
	public IGPRD0158Form() {
		super();
	}

	/** ���̶���ID */
	protected String pdid;
	
	/** ������ID */
	protected String pidid;
	
	/** ���������� */
	protected String pidname;
	
	/** �Ƿ񷢶��� */
	protected String sms;
	
	/** �Ƿ��ʼ� */
	protected String email;
	
	/** ������ID */
	protected String pidid_all[];
	
	/** ����������Ա�ֵ */
	protected String pivalue_all[];
	
	/** �� */
	protected String notifyd_all[];

	/** Сʱ */
	protected String notifyh_all[];

	/** �� */
	protected String notifym_all[];

	/** ��ɫID */
	protected String roleid_all[];

	/** ����BL */
	protected String processbl_all[];
	
	/** ����״̬����ID */
	protected String psdid_s[];
	
	/** ȷ�Ͻڵ��Ƿ���֪ͨ */
	protected String psdconfirms_s[];
	
	/** ��״̬�Ƿ�֪ͨ */
	protected String isnotify [];
	
	/** ���̶���ID */
	protected String pdid_i[];
	
	/** ״̬����ID */
	protected String psdid_i[];
	
	/** ������ID */
	protected String pidid_i[];
	
	/** ��ֵ */
	protected String pivalue[];

	/** �� */
	protected String notifyd[];

	/** Сʱ */
	protected String notifyh[];

	/** �� */
	protected String notifym[];
	
	/** �ϱ�_�� */
	protected String reportd[];
	
	/** �ϱ�_Сʱ */
	protected String reporth[];
	
	/** �ϱ�_�� */
	protected String reportm[];
	
	/** ��ɫ���� */
	protected String rolename[];

	/** ��ɫID */
	protected String roleid[];
	
	/** �ϱ���ɫ������ */
	protected String rolemanager[];

	/** ����BL */
	protected String processbl[];
	
	/** �����ϼ�֪ͨ��ID */
	protected String notifierids[];
	
	/** �����ϼ�֪ͨ������ */
	protected String notifiernames[];
	
	/** ȷ�Ͻڵ��Ƿ���֪ͨ */
	protected String psdconfirms[];
	
	public void initForm(int pssize, int pisize, int processWholeTactic_listSize){
		// ����״̬����ID 
		psdid_s = new String[pssize];
		// �Ƿ��ȷ�϶���
		psdconfirms_s = new String[pssize];
		// ��״̬�Ƿ�֪ͨ 
		isnotify = new String[pssize];
		// ������ID
		pidid_all = new String[processWholeTactic_listSize];
		// ����������Ա�ֵ
		pivalue_all = new String[processWholeTactic_listSize];
		// �����������-��
		notifyd_all = new String[processWholeTactic_listSize];
		// �����������-Сʱ
		notifyh_all = new String[processWholeTactic_listSize];
		// �����������-��
		notifym_all = new String[processWholeTactic_listSize];
		// �����������-��ɫ
		roleid_all = new String[processWholeTactic_listSize];
		// �����������-����BL
		processbl_all = new String[processWholeTactic_listSize];
		// ���̶���ID 
		pdid_i = new String[pisize];
		// ״̬����ID 
		psdid_i = new String[pisize];
		// ������ID 
		pidid_i = new String[pisize];
		// ��ֵ 
		pivalue = new String[pisize];
		// �� 
		notifyd = new String[pisize];
		// Сʱ 
		notifyh = new String[pisize];
		// �� 
		notifym = new String[pisize];
		// �ϱ�_�� 
		reportd = new String[pisize];
		// �ϱ�_Сʱ 
		reporth = new String[pisize];
		// �ϱ�_�� 
		reportm = new String[pisize];
		// ��ɫ���� 
		rolename = new String[pisize];
		// ��ɫID 
		roleid = new String[pisize];
		// �ϱ���ɫ������ 
		rolemanager = new String[pisize];
		// ����BL
		processbl = new String[pisize];
		// �����ϼ�֪ͨ��ID 
		notifierids = new String[pisize];
		// �����ϼ�֪ͨ������
		notifiernames = new String[pisize];
		// ȷ�Ͻڵ��Ƿ���֪ͨ
		psdconfirms = new String[pisize];
	}
	

	/**
	 * pssizeȡ��
	 * @return pssize pssize
	 */
	public int getPssize() {
		return pssize;
	}

	/**
	 * pssize�趨
	 * @param pssize pssize
	 */
	public void setPssize(int pssize) {
	    IGPRD0158Form.pssize= pssize;
	}

	/** 
     * processWholeTactic_listSize �趨
     * @param processWholeTactic_listSize processWholeTactic_listSize 
     */
    public void setProcessWholeTactic_listSize(int processWholeTactic_listSize) {
        IGPRD0158Form.processWholeTactic_listSize = processWholeTactic_listSize;
    }


    /**
	 * pisizeȡ��
	 * @return pisize pisize
	 */
	public int getPisize() {
		return pisize;
	}

	/**
	 * pisize�趨
	 * @param pisize pisize
	 */
	public void setPisize(int pisize) {
	    IGPRD0158Form.pisize = pisize;
	}

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * ������IDȡ��
	 * @return pidid ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����������ȡ��
	 * @return pidname ����������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * �����������趨
	 * @param pidname ����������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/** 
     * ������ID ȡ��
     * @return pidid_all ������ID 
     */
    public String[] getPidid_all() {
        return pidid_all;
    }


    /** 
     * ������ID �趨
     * @param pidid_all ������ID 
     */
    public void setPidid_all(String[] pidid_all) {
        this.pidid_all = pidid_all;
    }


    /** 
     * ����������Ա�ֵ ȡ��
     * @return pivalue_all ����������Ա�ֵ 
     */
    public String[] getPivalue_all() {
        return pivalue_all;
    }


    /** 
     * ����������Ա�ֵ �趨
     * @param pivalue_all ����������Ա�ֵ 
     */
    public void setPivalue_all(String[] pivalue_all) {
        this.pivalue_all = pivalue_all;
    }


    /** 
     * �� ȡ��
     * @return notifyd_all �� 
     */
    public String[] getNotifyd_all() {
        return notifyd_all;
    }


    /** 
     * �� �趨
     * @param notifyd_all �� 
     */
    public void setNotifyd_all(String[] notifyd_all) {
        this.notifyd_all = notifyd_all;
    }


    /** 
     * Сʱ ȡ��
     * @return notifyh_all Сʱ 
     */
    public String[] getNotifyh_all() {
        return notifyh_all;
    }


    /** 
     * Сʱ �趨
     * @param notifyh_all Сʱ 
     */
    public void setNotifyh_all(String[] notifyh_all) {
        this.notifyh_all = notifyh_all;
    }


    /** 
     * �� ȡ��
     * @return notifym_all �� 
     */
    public String[] getNotifym_all() {
        return notifym_all;
    }


    /** 
     * �� �趨
     * @param notifym_all �� 
     */
    public void setNotifym_all(String[] notifym_all) {
        this.notifym_all = notifym_all;
    }


    /** 
     * ��ɫID ȡ��
     * @return roleid_all ��ɫID 
     */
    public String[] getRoleid_all() {
        return roleid_all;
    }


    /** 
     * ��ɫID �趨
     * @param roleid_all ��ɫID 
     */
    public void setRoleid_all(String[] roleid_all) {
        this.roleid_all = roleid_all;
    }


    /** 
     * ����BL ȡ��
     * @return processbl_all ����BL 
     */
    public String[] getProcessbl_all() {
        return processbl_all;
    }


    /** 
     * ����BL �趨
     * @param processbl_all ����BL 
     */
    public void setProcessbl_all(String[] processbl_all) {
        this.processbl_all = processbl_all;
    }


    /**
	 * ����״̬����IDȡ��
	 * @return psdid_s ����״̬����ID
	 */
	public String[] getPsdid_s() {
		return psdid_s;
	}

	/**
	 * ����״̬����ID�趨
	 * @param psdid_s ����״̬����ID
	 */
	public void setPsdid_s(String[] psdid_s) {
		this.psdid_s = psdid_s;
	}

	/**
	 * ȷ�Ͻڵ��Ƿ���֪ͨȡ��
	 * @return psdconfirms_s ȷ�Ͻڵ��Ƿ���֪ͨ
	 */
	public String[] getPsdconfirms_s() {
		return psdconfirms_s;
	}

	/**
	 * ȷ�Ͻڵ��Ƿ���֪ͨ�趨
	 * @param psdconfirms_s ȷ�Ͻڵ��Ƿ���֪ͨ
	 */
	public void setPsdconfirms_s(String[] psdconfirms_s) {
		this.psdconfirms_s = psdconfirms_s;
	}

	/**
	 * ״̬����IDȡ��
	 * @return psdid_i ״̬����ID
	 */
	public String[] getPsdid_i() {
		return psdid_i;
	}

	/**
	 * ״̬����ID�趨
	 * @param psdid_i ״̬����ID
	 */
	public void setPsdid_i(String[] psdid_i) {
		
		this.psdid_i = psdid_i;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid_i ���̶���ID
	 */
	public String[] getPdid_i() {
		return pdid_i;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid_i ���̶���ID
	 */
	public void setPdid_i(String[] pdid_i) {
		
		this.pdid_i = pdid_i;
	}

	/**
	 * ������IDȡ��
	 * @return pidid_i ������ID
	 */
	public String[] getPidid_i() {
		return pidid_i;
	}

	/**
	 * ������ID�趨
	 * @param pidid_i ������ID
	 */
	public void setPidid_i(String pidid_i[]) {
		
		this.pidid_i = pidid_i;
	}

	/**
	 * ��ֵȡ��
	 * @return pivalue ��ֵ
	 */
	public String[] getPivalue() {
		return pivalue;
	}

	/**
	 * ��ֵ�趨
	 * @param pivalue ��ֵ
	 */
	public void setPivalue(String[] pivalue) {
		
		this.pivalue = pivalue;
	}

	/**
	 * ��ȡ��
	 * @return notifyd ��
	 */
	public String[] getNotifyd() {
		return notifyd;
	}

	/**
	 * ���趨
	 * @param notifyd ��
	 */
	public void setNotifyd(String[] notifyd) {
		
		this.notifyd = notifyd;
	}

	/**
	 * Сʱȡ��
	 * @return notifyh Сʱ
	 */
	public String[] getNotifyh() {
		return notifyh;
	}

	/**
	 * Сʱ�趨
	 * @param notifyh Сʱ
	 */
	public void setNotifyh(String[] notifyh) {
		
		this.notifyh = notifyh;
	}

	/**
	 * ��ȡ��
	 * @return notifym ��
	 */
	public String[] getNotifym() {
		return notifym;
	}

	/**
	 * ���趨
	 * @param notifym ��
	 */
	public void setNotifym(String[] notifym) {
		
		this.notifym = notifym;
	}

	/**
	 * �ϱ�_��ȡ��
	 * @return reportd �ϱ�_��
	 */
	public String[] getReportd() {
		return reportd;
	}

	/**
	 * �ϱ�_���趨
	 * @param reportd �ϱ�_��
	 */
	public void setReportd(String[] reportd) {
		
		this.reportd = reportd;
	}

	/**
	 * �ϱ�_Сʱȡ��
	 * @return reporth �ϱ�_Сʱ
	 */
	public String[] getReporth() {
		return reporth;
	}

	/**
	 * �ϱ�_Сʱ�趨
	 * @param reporth �ϱ�_Сʱ
	 */
	public void setReporth(String[] reporth) {
		
		this.reporth = reporth;
	}

	/**
	 * �ϱ�_��ȡ��
	 * @return reportm �ϱ�_��
	 */
	public String[] getReportm() {
		return reportm;
	}

	/**
	 * �ϱ�_���趨
	 * @param reportm �ϱ�_��
	 */
	public void setReportm(String[] reportm) {
		
		this.reportm = reportm;
	}

	/**
	 * ��ɫ����ȡ��
	 * @return rolename ��ɫ����
	 */
	public String[] getRolename() {
		return rolename;
	}

	/**
	 * ��ɫ�����趨
	 * @param rolename ��ɫ����
	 */
	public void setRolename(String[] rolename) {
		this.rolename = rolename;
	}

	/**
	 * ��ɫIDȡ��
	 * @return roleid ��ɫID
	 */
	public String[] getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 * @param roleid ��ɫID
	 */
	public void setRoleid(String[] roleid) {
		
		this.roleid = roleid;
	}

	/**
	 * �ϱ���ɫ������ȡ��
	 * @return rolemanager �ϱ���ɫ������
	 */
	public String[] getRolemanager() {
		return rolemanager;
	}

	/**
	 * �ϱ���ɫ�������趨
	 * @param rolemanager �ϱ���ɫ������
	 */
	public void setRolemanager(String[] rolemanager) {
		
		this.rolemanager = rolemanager;
	}

	/**
	 * ����BLȡ��
	 * @return processbl ����BL
	 */
	public String[] getProcessbl() {
		return processbl;
	}

	/**
	 * ����BL�趨
	 * @param processbl ����BL
	 */
	public void setProcessbl(String[] processbl) {
		
		this.processbl = processbl;
	}


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		if("EDIT".equals(mapping.getParameter()) || "SET".equals(mapping.getParameter())) {
			initForm(pssize, pisize, processWholeTactic_listSize);
		} else {
		}
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

	/**
	 * �Ƿ񷢶���ȡ��
	 * @return sms �Ƿ񷢶���
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * �Ƿ񷢶����趨
	 * @param sms �Ƿ񷢶���
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * �Ƿ��ʼ�ȡ��
	 * @return email �Ƿ��ʼ�
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * �Ƿ��ʼ��趨
	 * @param email �Ƿ��ʼ�
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ��״̬�Ƿ�֪ͨȡ��
	 * @return isnotify ��״̬�Ƿ�֪ͨ
	 */
	public String[] getIsnotify() {
		return isnotify;
	}

	/**
	 * ��״̬�Ƿ�֪ͨ�趨
	 * @param isnotify ��״̬�Ƿ�֪ͨ
	 */
	public void setIsnotify(String isnotify[]) {
		
		this.isnotify = isnotify;
	}

	/**
	 * �����ϼ�֪ͨ��IDȡ��
	 * @return notifierids �����ϼ�֪ͨ��ID
	 */
	public String[] getNotifierids() {
		return notifierids;
	}

	/**
	 * �����ϼ�֪ͨ��ID�趨
	 * @param notifierids �����ϼ�֪ͨ��ID
	 */
	public void setNotifierids(String[] notifierids) {
		this.notifierids = notifierids;
	}

	/**
	 * �����ϼ�֪ͨ������ȡ��
	 * @return notifiernames �����ϼ�֪ͨ������
	 */
	public String[] getNotifiernames() {
		return notifiernames;
	}

	/**
	 * �����ϼ�֪ͨ�������趨
	 * @param notifiernames �����ϼ�֪ͨ������
	 */
	public void setNotifiernames(String[] notifiernames) {
		this.notifiernames = notifiernames;
	}

	/**
	 * ȷ�Ͻڵ��Ƿ���֪ͨȡ��
	 * @return psdconfirms ȷ�Ͻڵ��Ƿ���֪ͨ
	 */
	public String[] getPsdconfirms() {
		return psdconfirms;
	}

	/**
	 * ȷ�Ͻڵ��Ƿ���֪ͨ�趨
	 * @param psdconfirms ȷ�Ͻڵ��Ƿ���֪ͨ
	 */
	public void setPsdconfirms(String[] psdconfirms) {
		this.psdconfirms = psdconfirms;
	}
}
