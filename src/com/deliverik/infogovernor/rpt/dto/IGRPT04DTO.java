/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.form.IGRPT0402Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * ����: ����ͳ��
 * ��������: ���𱨱�ͳ�Ʋ�ѯ
 */
@SuppressWarnings("serial")
public class IGRPT04DTO extends BaseDTO{
	
	protected User user;
	
	protected List<CodeDetail> parCodeDetailList;
	protected List<CodeDetail> cldCodeDetailList;
	protected List<ReportFileDefinition> rfdList;
	protected IGRPT0402Form igrpt0402Form;
	protected String temName;
	
	/** ���̶���id */
    protected String pdid;
    
	/** ����״̬*/
    protected String psdcode;
    
    /** ���̱�*/
    protected String pidid;
    
    /** ���̱�ֵ��*/
    protected String pidvalue;
    
    /** ���������� */
    protected String rfdid;
    
    /** �������*/
    protected String title;
    
    /** �������α�ͳ�Ʊ�����*/
    protected String treeFormLevel2;
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CodeDetail> getParCodeDetailList() {
		return parCodeDetailList;
	}

	public void setParCodeDetailList(List<CodeDetail> parCodeDetailList) {
		this.parCodeDetailList = parCodeDetailList;
	}

	public List<CodeDetail> getCldCodeDetailList() {
		return cldCodeDetailList;
	}

	public void setCldCodeDetailList(List<CodeDetail> cldCodeDetailList) {
		this.cldCodeDetailList = cldCodeDetailList;
	}

	public List<ReportFileDefinition> getRfdList() {
		return rfdList;
	}

	public void setRfdList(List<ReportFileDefinition> rfdList) {
		this.rfdList = rfdList;
	}

    /**
     * @return the igrpt0402Form
     */
    public IGRPT0402Form getIgrpt0402Form() {
        return igrpt0402Form;
    }

    /**
     * @param igrpt0402Form the igrpt0402Form to set
     */
    public void setIgrpt0402Form(IGRPT0402Form igrpt0402Form) {
        this.igrpt0402Form = igrpt0402Form;
    }

    /**
     * @return the temName
     */
    public String getTemName() {
        return temName;
    }

    /**
     * @param temName the temName to set
     */
    public void setTemName(String temName) {
        this.temName = temName;
    }

    /**
     * @return the ���̶���id
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param ���̶���id the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
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

    /**
     * @return the �������α�ͳ�Ʊ�����
     */
    public String getTreeFormLevel2() {
        return treeFormLevel2;
    }

    /**
     * @param �������α�ͳ�Ʊ����� the treeFormLevel2 to set
     */
    public void setTreeFormLevel2(String treeFormLevel2) {
        this.treeFormLevel2 = treeFormLevel2;
    }
}
