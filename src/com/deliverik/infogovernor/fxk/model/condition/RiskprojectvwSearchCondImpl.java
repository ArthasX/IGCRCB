/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * 概述: 通讯录检索条件实现
  * 功能描述: 通讯录检索条件实现
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public class RiskprojectvwSearchCondImpl implements
		RiskprojectvwSearchCond {
    /**计划编号*/
    protected String risknum_l;
    /**计划类型*/
    protected String risktype_q;
    /**计划标题*/
    protected String  title_l;
    /**计划发起者*/
    protected String  prusername_l;
    /**计划状态*/
    protected String  riskstatus_q;
    /**计划开始时间小于*/
    protected String  riskstart_le;
    /**计划开始时间大于*/
    protected String  riskstart_ge;
   
    public void setRisknum_l(String risknum_l) {
        this.risknum_l = risknum_l;
    }
    public void setRisktype_q(String risktype_q) {
        this.risktype_q = risktype_q;
    }
    public void setTitle_l(String title_l) {
        this.title_l = title_l;
    }
    public void setPrusername_l(String prusername_l) {
        this.prusername_l = prusername_l;
    }
    public void setRiskstatus_q(String riskstatus_q) {
        this.riskstatus_q = riskstatus_q;
    }
    public void setRiskstart_le(String riskstart_le) {
        this.riskstart_le = riskstart_le;
    }
    public void setRiskstart_ge(String riskstart_ge) {
        this.riskstart_ge = riskstart_ge;
    }
    public String getRisknum_l() {
        return risknum_l;
    }
    public String getRisktype_q() {
        return risktype_q;
    }
    public String getTitle_l() {
        return title_l;
    }
    public String getPrusername_l() {
        return prusername_l;
    }
    public String getRiskstatus_q() {
        return riskstatus_q;
    }
    public String getRiskstart_le() {
        return riskstart_le;
    }
    public String getRiskstart_ge() {
        return riskstart_ge;
    }
    
    
    
}