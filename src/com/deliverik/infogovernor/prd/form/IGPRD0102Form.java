/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;

/**
 * ���̶��������Ϣ�༭����Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0102Form extends BaseForm implements IG380Info,IG243Info {
	
	/** �������͵Ĵ���ʱ�� */
	protected String pdcrtdate;
	
	/** �������͵����� */
	protected String pddesc;

	/** ���̶����ID */
	protected String pdid;
	
	/** �������͵����� */
	protected String pdname;
	
	/** �������͵����� */
	protected String pdname_bak;
	
	/** �������͵�״̬ */
	protected String pdstatus;
	
	/** ����״̬ͣ������ TEST:Ϊ����ͣ�� CHANGE:Ϊ���� */
	protected String flag;
	
	/** ����ģ���ID */
	protected Integer ptid;
	
	/** ���̶����¼��ʱ��� */
	protected String fingerPrint;
	
	/** ģʽ 0�Ǽǣ�1�༭ */
	protected String mode = "0";
	
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;
	
	protected String pdxml;
	
	protected String pttype;
	
	/**
	 * ������־Ȩ��
	 */
	protected String permission;
	
	protected String ptdid;

	/** �������ƶ��� */
	protected String ptitlename;

	/** ��������Ȩ�� 0�ɼ���1���ɼ� */
	protected String ptitleaccess;

	/** �����ֶ����� */
	protected String pdescname;

	/** �����ֶ�Ȩ�� 0���ɼ���1���ɼ� */
	protected String pdescaccess;
	
	/** ������������ */
	protected String serialgenerator;
	
	/** �˵�ID */
	protected String pdactname;
	
	  /** ��ܱ����˵�� */
    protected String reportdesc;
    
    /** ������Ϣ������ */
    protected String messagegenerator;
    
    /** ���̱�� */
    protected String pdserialnumber;
    
    /** ����Ŀ¼����� */
    protected String pdservicecatalog;
    
    /** ����Ŀ¼��ʾ���� */
    protected String pdservicecatalogname;
	
	/**
	 * ������־Ȩ��ȡ��
	 * @return ������־Ȩ��
	 */
	public String getPermission() {
		return permission;
	}


	/**
	 * ������־Ȩ���趨
	  * @param permission ������־Ȩ��
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	/**
	 * �������͵Ĵ���ʱ��ȡ��
	 * 
	 * @return �������͵Ĵ���ʱ��
	 */
	public String getPdcrtdate() {
		return pdcrtdate;
	}

	/**
	 * �������͵Ĵ���ʱ���趨
	 *
	 * @param pdcrtdate �������͵Ĵ���ʱ��
	 */
	public void setPdcrtdate(String pdcrtdate) {
		this.pdcrtdate = pdcrtdate;
	}

	/**
	 * �������͵�����ȡ��
	 * 
	 * @return �������͵�����
	 */
	public String getPddesc() {
		return pddesc;
	}

	/**
	 * �������͵������趨
	 *
	 * @param pddesc �������͵�����
	 */
	public void setPddesc(String pddesc) {
		this.pddesc = pddesc;
	}

	/**
	 * �������͵�IDȡ��
	 * 
	 * @return �������͵�ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * �������͵�ID�趨
	 *
	 * @param pdid �������͵�ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * �������͵�����ȡ��
	 * 
	 * @return �������͵�����
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * �������͵������趨
	 *
	 * @param pdname �������͵�����
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * �������͵�״̬ȡ��
	 * 
	 * @return �������͵�״̬
	 */
	public String getPdstatus() {
		return pdstatus;
	}

	/**
	 * �������͵�״̬�趨
	 *
	 * @param pdstatus �������͵�״̬
	 */
	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}


	/**
	 * ����ģ���IDȡ��
	 * 
	 * @return ����ģ���ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ����ģ���ID�趨
	 *
	 * @param ptid ����ģ���ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * ���̶����¼��ʱ���ȡ��
	 * 
	 * @return ���̶����¼��ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ���̶����¼��ʱ����趨
	 *
	 * @param fingerPrint ���̶����¼��ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * ģʽȡ��
	 * 
	 * @return ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ģʽ�趨
	 *
	 * @param mode ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * �������͵�����ȡ��
	 * 
	 * @return �������͵�����
	 */
	public String getPdname_bak() {
		return pdname_bak;
	}

	/**
	 * �������͵������趨
	 *
	 * @param pdname_bak �������͵�����
	 */
	public void setPdname_bak(String pdname_bak) {
		this.pdname_bak = pdname_bak;
	}

	public String getPdxml() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPttype() {
		return pttype;
	}

	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * �����趨
	 *
	 * @param ptdid ����
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * �������ƶ���ȡ��
	 *
	 * @return �������ƶ���
	 */
	public String getPtitlename() {
		return ptitlename;
	}

	/**
	 * �������ƶ����趨
	 *
	 * @param ptitlename �������ƶ���
	 */
	public void setPtitlename(String ptitlename) {
		this.ptitlename = ptitlename;
	}

	/**
	 * ��������Ȩ�� 0�ɼ���1���ɼ�ȡ��
	 *
	 * @return ��������Ȩ�� 0�ɼ���1���ɼ�
	 */
	public String getPtitleaccess() {
		return ptitleaccess;
	}

	/**
	 * ��������Ȩ�� 0�ɼ���1���ɼ��趨
	 *
	 * @param ptitleaccess ��������Ȩ�� 0�ɼ���1���ɼ�
	 */
	public void setPtitleaccess(String ptitleaccess) {
		this.ptitleaccess = ptitleaccess;
	}

	/**
	 * �����ֶ�����ȡ��
	 *
	 * @return �����ֶ�����
	 */
	public String getPdescname() {
		return pdescname;
	}

	/**
	 * �����ֶ������趨
	 *
	 * @param pdescname �����ֶ�����
	 */
	public void setPdescname(String pdescname) {
		this.pdescname = pdescname;
	}

	/**
	 * �����ֶ�Ȩ�� 0���ɼ���1���ɼ�ȡ��
	 *
	 * @return �����ֶ�Ȩ�� 0���ɼ���1���ɼ�
	 */
	public String getPdescaccess() {
		return pdescaccess;
	}

	/**
	 * �����ֶ�Ȩ�� 0���ɼ���1���ɼ��趨
	 *
	 * @param pdescaccess �����ֶ�Ȩ�� 0���ɼ���1���ɼ�
	 */
	public void setPdescaccess(String pdescaccess) {
		this.pdescaccess = pdescaccess;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ptdid;
	}

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


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * ������������ȡ��
	 * 
	 * @return ������������
	 */
	public String getSerialgenerator() {
		return serialgenerator;
	}

	/**
	 * �������������趨
	 * 
	 * @param serialgenerator ������������
	 */
	public void setSerialgenerator(String serialgenerator) {
		this.serialgenerator = serialgenerator;
	}

	/** ����һ���˵��б� */
    protected List<LabelValueBean> actionLabelValueList;

    /**
     * @return the ����һ���˵��б�
     */
    public List<LabelValueBean> getActionLabelValueList() {
        return actionLabelValueList;
    }

    /**
     * @param ����һ���˵��б� the actionLabelValueList to set
     */
    public void setActionLabelValueList(List<LabelValueBean> actionLabelValueList) {
        this.actionLabelValueList = actionLabelValueList;
    }
    
    /**
     * @return the �˵�ID
     */
    public String getPdactname() {
        return pdactname;
    }


    /**
     * @param �˵�ID the pdactname to set
     */
    public void setPdactname(String pdactname) {
        this.pdactname = pdactname;
    }


	/**
	 * ��ܱ����˵��ȡ��
	 * @return reportdesc ��ܱ����˵��
	 */
	public String getReportdesc() {
		return reportdesc;
	}


	/**
	 * ��ܱ����˵���趨
	 * @param reportdesc ��ܱ����˵��
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}


	/**
	 * ������Ϣ������ȡ��
	 * @return messagegenerator ������Ϣ������
	 */
	public String getMessagegenerator() {
		return messagegenerator;
	}


	/**
	 * ������Ϣ�������趨
	 * @param messagegenerator ������Ϣ������
	 */
	public void setMessagegenerator(String messagegenerator) {
		this.messagegenerator = messagegenerator;
	}


	/**
	 * ���̱��ȡ��
	 * @return pdserialnumber ���̱��
	 */
	public String getPdserialnumber() {
		return pdserialnumber;
	}


	/**
	 * ���̱���趨
	 * @param pdserialnumber ���̱��
	 */
	public void setPdserialnumber(String pdserialnumber) {
		this.pdserialnumber = pdserialnumber;
	}


	/**
	 * ����Ŀ¼�����ȡ��
	 * @return pdservicecatalog ����Ŀ¼�����
	 */
	public String getPdservicecatalog() {
		return pdservicecatalog;
	}


	/**
	 * ����Ŀ¼������趨
	 * @param pdservicecatalog ����Ŀ¼�����
	 */
	public void setPdservicecatalog(String pdservicecatalog) {
		this.pdservicecatalog = pdservicecatalog;
	}


	/**
	 * ����Ŀ¼��ʾ����ȡ��
	 * @return pdservicecatalogname ����Ŀ¼��ʾ����
	 */
	public String getPdservicecatalogname() {
		return pdservicecatalogname;
	}


	/**
	 * ����Ŀ¼��ʾ�����趨
	 * @param pdservicecatalogname ����Ŀ¼��ʾ����
	 */
	public void setPdservicecatalogname(String pdservicecatalogname) {
		this.pdservicecatalogname = pdservicecatalogname;
	}
    
}
