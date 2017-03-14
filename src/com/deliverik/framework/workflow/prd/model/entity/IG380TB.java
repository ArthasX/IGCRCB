package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG380Info;


/**
 * �������Ͷ�����Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG380")
public class IG380TB extends BaseEntity implements Serializable, Cloneable, IG380Info {
	/**
	 * �������Ͷ���ID
	 */
	@Id
	protected String pdid;

	/**
	 * ����ģ��ID
	 */
	protected Integer ptid;

	/**
	 * �������Ͷ�������
	 */
	protected String pdname;

	/**
	 * �������Ͷ�������
	 */
	protected String pddesc;

	/**
	 * �������Ͷ��崴��ʱ��
	 */
	protected String pdcrtdate;

	/**
	 * �������Ͷ���״̬��a���ã�iͣ�ã�
	 */
	protected String pdstatus;
	
	/**
	 * ����ͼxml��Ϣ
	 */
	protected String pdxml;

	/**
	 * ������־Ȩ��
	 */
	protected String permission;
	
	/**
	 * ������������
	 */
	protected String serialgenerator;

	/**
     * �˵�ID
     */
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
	 * ����ȡ��
	 * @return pdid
	 */
	public Serializable getPK() {
		return pdid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG380TB))
			return false;
		IG380Info target = (IG380Info) obj;
		if (!(getPdid()==target.getPdid()))
			return false;
		return true;
	}

	
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
	 * �������Ͷ���IDȡ��
	 * @return �������Ͷ���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * �������Ͷ���ID�趨
	  * @param pdid �������Ͷ���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ����ģ��ID�趨
	  * @param ptid ����ģ��ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * �������Ͷ�������ȡ��
	 * @return �������Ͷ�������
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * �������Ͷ��������趨
	  * @param pdname �������Ͷ�������
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * �������Ͷ�������ȡ��
	 * @return �������Ͷ�������
	 */
	public String getPddesc() {
		return pddesc;
	}

	/**
	 * �������Ͷ��������趨
	  * @param pddesc �������Ͷ�������
	 */
	public void setPddesc(String pddesc) {
		this.pddesc = pddesc;
	}

	/**
	 * �������Ͷ��崴��ʱ��ȡ��
	 * @return �������Ͷ��崴��ʱ��
	 */
	public String getPdcrtdate() {
		return pdcrtdate;
	}

	/**
	 * �������Ͷ��崴��ʱ���趨
	  * @param pdcrtdate �������Ͷ��崴��ʱ��
	 */
	public void setPdcrtdate(String pdcrtdate) {
		this.pdcrtdate = pdcrtdate;
	}

	/**
	 * �������Ͷ���״̬ȡ��
	 * @return �������Ͷ���״̬
	 */
	public String getPdstatus() {
		return pdstatus;
	}

	/**
	 * �������Ͷ���״̬�趨
	  * @param pdstatus �������Ͷ���״̬
	 */
	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}

	/**
	 * ����ͼxml��Ϣȡ��
	 * @return ����ͼxml��Ϣ
	 */
	public String getPdxml() {
		return pdxml;
	}

	/**
	 * ����ͼxml��Ϣ�趨
	  * @param pdxml ����ͼxml��Ϣ
	 */
	public void setPdxml(String pdxml) {
		this.pdxml = pdxml;
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


	/**
     * �˵�IDȡ��
     * 
     * @return �˵�ID
     */
    public String getPdactname() {
        return pdactname;
    }


    /**
     * �˵�ID�趨
     * 
     * @param pdactname �˵�ID
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
