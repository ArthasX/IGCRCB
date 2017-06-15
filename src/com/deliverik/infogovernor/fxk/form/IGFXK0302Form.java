package com.deliverik.infogovernor.fxk.form;

import com.deliverik.framework.base.BaseForm;

public class IGFXK0302Form extends BaseForm {
    /**工作名称*/
    protected String riskname;
    /**工作说明*/
    protected String riskdesc;
    /**负责人*/
    protected String riskpeople;
    /**工作开始时间*/
    protected String riskstart;
    /**工作结束时间*/
    protected String riskend;
    /**工作提配时间*/
    protected String allocationtime;
    /**模式0修改，1查询*/
    protected String mode;
    /**流程id*/
    protected String prid;
    /**pidid表单*/
    protected String pidid;
    /**第？行*/
    protected String pvrownumber;
    
    public String getRiskname() {
        return riskname;
    }
    public void setRiskname(String riskname) {
        this.riskname = riskname;
    }
    public String getRiskdesc() {
        return riskdesc;
    }
    public void setRiskdesc(String riskdesc) {
        this.riskdesc = riskdesc;
    }
    public String getRiskpeople() {
        return riskpeople;
    }
    public void setRiskpeople(String riskpeople) {
        this.riskpeople = riskpeople;
    }
    public String getRiskstart() {
        return riskstart;
    }
    public void setRiskstart(String riskstart) {
        this.riskstart = riskstart;
    }
    public String getRiskend() {
        return riskend;
    }
    public void setRiskend(String riskend) {
        this.riskend = riskend;
    }
    public String getAllocationtime() {
        return allocationtime;
    }
    public void setAllocationtime(String allocationtime) {
        this.allocationtime = allocationtime;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getPrid() {
        return prid;
    }
    public void setPrid(String prid) {
        this.prid = prid;
    }
    public String getPidid() {
        return pidid;
    }
    public void setPidid(String pidid) {
        this.pidid = pidid;
    }
    public String getPvrownumber() {
        return pvrownumber;
    }
    public void setPvrownumber(String pvrownumber) {
        this.pvrownumber = pvrownumber;
    }
   
    
    
}

