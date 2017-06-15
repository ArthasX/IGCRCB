/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.form.IGRPT0402Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 概述: 报表统计
 * 功能描述: 负责报表统计查询
 */
@SuppressWarnings("serial")
public class IGRPT04DTO extends BaseDTO{
	
	protected User user;
	
	protected List<CodeDetail> parCodeDetailList;
	protected List<CodeDetail> cldCodeDetailList;
	protected List<ReportFileDefinition> rfdList;
	protected IGRPT0402Form igrpt0402Form;
	protected String temName;
	
	/** 流程定义id */
    protected String pdid;
    
	/** 流程状态*/
    protected String psdcode;
    
    /** 流程表单*/
    protected String pidid;
    
    /** 流程表单值域*/
    protected String pidvalue;
    
    /** 报表定义主键 */
    protected String rfdid;
    
    /** 报表标题*/
    protected String title;
    
    /** 二级树形表单统计报表标记*/
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
     * @return the 流程定义id
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param 流程定义id the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    /**
     * @return the 流程状态
     */
    public String getPsdcode() {
        return psdcode;
    }

    /**
     * @param 流程状态 the psdcode to set
     */
    public void setPsdcode(String psdcode) {
        this.psdcode = psdcode;
    }

    /**
     * @return the 流程表单
     */
    public String getPidid() {
        return pidid;
    }

    /**
     * @param 流程表单 the pidid to set
     */
    public void setPidid(String pidid) {
        this.pidid = pidid;
    }

    /**
     * @return the 流程表单值域
     */
    public String getPidvalue() {
        return pidvalue;
    }

    /**
     * @param 流程表单值域 the pidvalue to set
     */
    public void setPidvalue(String pidvalue) {
        this.pidvalue = pidvalue;
    }

    /**
     * @return the 报表定义主键
     */
    public String getRfdid() {
        return rfdid;
    }

    /**
     * @param 报表定义主键 the rfdid to set
     */
    public void setRfdid(String rfdid) {
        this.rfdid = rfdid;
    }

    /**
     * @return the 报表标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param 报表标题 the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the 二级树形表单统计报表标记
     */
    public String getTreeFormLevel2() {
        return treeFormLevel2;
    }

    /**
     * @param 二级树形表单统计报表标记 the treeFormLevel2 to set
     */
    public void setTreeFormLevel2(String treeFormLevel2) {
        this.treeFormLevel2 = treeFormLevel2;
    }
}
