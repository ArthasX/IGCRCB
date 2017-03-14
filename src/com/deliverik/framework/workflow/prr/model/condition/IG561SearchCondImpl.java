/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 状态级私有表单值记录表检索条件实现
  * 功能描述: 状态级私有表单值记录表检索条件实现
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public class IG561SearchCondImpl implements
		IG561SearchCond {
    /**流程id*/
    protected String prid_q;
    /**节点id*/
    protected String psdid_l;
    /**表单id*/
    protected String pidid_l;
    /**piid*/
    protected String piid_q;
    
    public String getPiid_q() {
        return piid_q;
    }
    public void setPiid_q(String piid_q) {
        this.piid_q = piid_q;
    }
    public String getPrid_q() {
        return prid_q;
    }
    public void setPrid_q(String prid_q) {
        this.prid_q = prid_q;
    }
    public String getPsdid_l() {
        return psdid_l;
    }
    public void setPsdid_l(String psdid_l) {
        this.psdid_l = psdid_l;
    }
    public String getPidid_l() {
        return pidid_l;
    }
    public void setPidid_l(String pidid_l) {
        this.pidid_l = pidid_l;
    }
    
}