package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;

/***
 * ����鿴_�����趨
 * @author byf
 *
 */
@SuppressWarnings("serial")
public class IGRPT0402Form extends BaseForm{
	
    /** ���������� */
    protected String rfdid;
    
	/**ģ������*/
	protected String templateName;
	
	/**ģ��·��*/
	protected String reportPath;
	
	/** ���̶���id */
	protected String pdid;
	
	/** �������� */
	protected String rfdpictype;
	
	/** �Ƿ��Ʊ���(0�����ƣ�1������) */
	protected String isFlag;

	/** ����״̬*/
	protected String psdcode;
	
	/** ���̱�*/
	protected String pidid;
	
	/** ���̱�ֵ��*/
	protected String pidvalue;
	
	/** �������*/
	protected String title;
	
	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getReportPath() {
		return reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

    /**
     * @return the �Ƿ��Ʊ���(0�����ƣ�1������)
     */
    public String getIsFlag() {
        return isFlag;
    }

    /**
     * @param �Ƿ��Ʊ���(0�����ƣ�1������) the isFlag to set
     */
    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }

    /**
     * @return the ����������
     */
    public String getRfdid() {
        return rfdid;
    }

    /**
     * @param ���������� the rfdid to set
     */
    public void setRfdid(String rfdid) {
        this.rfdid = rfdid;
    }

    /**
     * @return the ����״̬
     */
    public String getPsdcode() {
        return psdcode;
    }

    /**
     * @param ����״̬ the psdcode to set
     */
    public void setPsdcode(String psdcode) {
        this.psdcode = psdcode;
    }

    /**
     * @return the ���̱�
     */
    public String getPidid() {
        return pidid;
    }

    /**
     * @param ���̱� the pidid to set
     */
    public void setPidid(String pidid) {
        this.pidid = pidid;
    }

    /**
     * @return the ���̱�ֵ��
     */
    public String getPidvalue() {
        return pidvalue;
    }

    /**
     * @param ���̱�ֵ�� the pidvalue to set
     */
    public void setPidvalue(String pidvalue) {
        this.pidvalue = pidvalue;
    }

    /**
     * @return the �������
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param ������� the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
