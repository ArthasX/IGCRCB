package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;

/***
 * 报表查看_参数设定
 * @author byf
 *
 */
@SuppressWarnings("serial")
public class IGRPT0402Form extends BaseForm{
	
    /** 报表定义主键 */
    protected String rfdid;
    
	/**模板名字*/
	protected String templateName;
	
	/**模板路径*/
	protected String reportPath;
	
	/** 流程定义id */
	protected String pdid;
	
	/** 报表类型 */
	protected String rfdpictype;
	
	/** 是否定制报表(0：定制，1：常规) */
	protected String isFlag;

	/** 流程状态*/
	protected String psdcode;
	
	/** 流程表单*/
	protected String pidid;
	
	/** 流程表单值域*/
	protected String pidvalue;
	
	/** 报表标题*/
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
     * @return the 是否定制报表(0：定制，1：常规)
     */
    public String getIsFlag() {
        return isFlag;
    }

    /**
     * @param 是否定制报表(0：定制，1：常规) the isFlag to set
     */
    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
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
}
