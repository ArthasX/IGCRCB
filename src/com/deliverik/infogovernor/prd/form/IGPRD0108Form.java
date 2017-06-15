/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ���̶���_������_Ȩ��Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0108Form extends BaseForm {
	
	/** ������_Ȩ������ID */
	protected Integer pipdid;
	
	/** ���̱�����ID */
	protected Integer pidid;
	
	/** ���̱�����ID���� */
	protected String[] pidids;
	
	/** ������_Ȩ������ID���� */
	protected String[] pipdids;
	
	/** ����״̬��ID */
	protected String psdid;
	
	/** ���̲����ߵ�ID */
	protected String ppdid;
	
	/** ���̱��������� */
	protected String pidname;
	
	/** ���̱�������ʾ���� */
	protected String pidlabel;
	
	/** ���̱��������� */
	protected String piddesc;
	
	/** ���̱��������� */
	protected String pidtype;
	
	/** ������Ա�Ա�����Ȩ�� */
	protected String pidaccess;
	
	/** ������Ա�Ա�����Ȩ�޼��� */
	protected String[] pidaccesses;
	
	protected String[] pidrequired;
	
	/** ������_Ȩ�޼�¼��ʱ��� */
	protected String fingerPrint;

	/** ����ID */
	protected String pdid;
	
	/** ������Ա��ѡ�Ķ������� */
	protected String pikey;
	
	protected String[] pikeys;
	protected String[] pikeynames;
	
	/**������ť��ʾ��Ϣ���� */
	protected String[] pikeydecs;
	
	/** ���ͼ��� */
	protected String[] types;
	
	protected String[] pbdid;
	
	protected String[] ppbdname;
	
	protected String[] ppbddesc;
	
	protected String[] ppbdauth;
	
	protected String[] ppbdid;
	
	protected String[] relevantPdid;
	
	protected String[] psprpid;
	
    /** �Ƿ�У������� */
    protected String[] checkrequired;
    
    /** �Ƿ�У�鴦���¼ */
	protected String[] checkrecord;
	
	/** ����ҳjs���� */
	protected String[] acturl;

	/** ������״̬ID */
	protected String ppsdid;
	
	public String[] getPikeydecs() {
		return pikeydecs;
	}

	public void setPikeydecs(String[] pikeydecs) {
		this.pikeydecs = pikeydecs;
	}

	public String[] getPikeynames() {
		return pikeynames;
	}

	public void setPikeynames(String[] pikeynames) {
		this.pikeynames = pikeynames;
	}

	public String[] getPidids() {
		return pidids;
	}

	public void setPidids(String[] pidids) {
		this.pidids = pidids;
	}

	public String[] getPipdids() {
		return pipdids;
	}

	public void setPipdids(String[] pipdids) {
		this.pipdids = pipdids;
	}

	public String[] getPidaccesses() {
		return pidaccesses;
	}

	public void setPidaccesses(String[] pidaccesses) {
		this.pidaccesses = pidaccesses;
	}

	public String getPikey() {
		return pikey;
	}

	public void setPikey(String pikey) {
		this.pikey = pikey;
	}

	public String[] getPikeys() {
		return pikeys;
	}

	public void setPikeys(String[] pikeys) {
		this.pikeys = pikeys;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public Integer getPipdid() {
		return pipdid;
	}

	public void setPipdid(Integer pipdid) {
		this.pipdid = pipdid;
	}

	public Integer getPidid() {
		return pidid;
	}

	public void setPidid(Integer pidid) {
		this.pidid = pidid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getPpdid() {
		return ppdid;
	}

	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	public String getPidname() {
		return pidname;
	}

	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	public String getPidlabel() {
		return pidlabel;
	}

	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	public String getPiddesc() {
		return piddesc;
	}

	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	public String getPidtype() {
		return pidtype;
	}

	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	public String getPidaccess() {
		return pidaccess;
	}

	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * ���ͼ���ȡ��
	 * 
	 * @return ���ͼ���
	 */
	public String[] getTypes() {
		return types;
	}

	/**
	 * ���ͼ����趨
	 * 
	 * @param type ���ͼ���
	 */
	public void setTypes(String[] types) {
		this.types = types;
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

	public String[] getPbdid() {
		return pbdid;
	}

	public void setPbdid(String[] pbdid) {
		this.pbdid = pbdid;
	}

	public String[] getPpbdname() {
		return ppbdname;
	}

	public void setPpbdname(String[] ppbdname) {
		this.ppbdname = ppbdname;
	}

	public String[] getPpbddesc() {
		return ppbddesc;
	}

	public void setPpbddesc(String[] ppbddesc) {
		this.ppbddesc = ppbddesc;
	}

	public String[] getPpbdauth() {
		return ppbdauth;
	}

	public void setPpbdauth(String[] ppbdauth) {
		this.ppbdauth = ppbdauth;
	}

	public String[] getPpbdid() {
		return ppbdid;
	}

	public void setPpbdid(String[] ppbdid) {
		this.ppbdid = ppbdid;
	}

	public String[] getPidrequired() {
		return pidrequired;
	}

	public void setPidrequired(String[] pidrequired) {
		this.pidrequired = pidrequired;
	}

    /**
     * @return the relevantPdid
     */
    public String[] getRelevantPdid() {
        return relevantPdid;
    }

    /**
     * @param relevantPdid the relevantPdid to set
     */
    public void setRelevantPdid(String[] relevantPdid) {
        this.relevantPdid = relevantPdid;
    }

    /**
     * @return the psprpid
     */
    public String[] getPsprpid() {
        return psprpid;
    }

    /**
     * @param psprpid the psprpid to set
     */
    public void setPsprpid(String[] psprpid) {
        this.psprpid = psprpid;
    }

	/**
	 *�Ƿ�У�������ȡ��
	 */
	public String[] getCheckrequired() {
		return checkrequired;
	}

	/**
	 *�Ƿ�У��������趨
	 */
	public void setCheckrequired(String[] checkrequired) {
		this.checkrequired = checkrequired;
	}

	/**
	 *�Ƿ�У�鴦���¼ȡ��
	 */
	public String[] getCheckrecord() {
		return checkrecord;
	}

	/**
	 *�Ƿ�У�鴦���¼�趨
	 */
	public void setCheckrecord(String[] checkrecord) {
		this.checkrecord = checkrecord;
	}

	/**
	 *����ҳjs����ȡ��
	 */
	public String[] getActurl() {
		return acturl;
	}

	/**
	 *����ҳjs�����趨
	 */
	public void setActurl(String[] acturl) {
		this.acturl = acturl;
	}

	/**
	 * ������״̬IDȡ��
	 * @return ������״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * ������״̬ID�趨
	 * @param ppsdid ������״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
	
}
