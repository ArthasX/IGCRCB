/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.workflow.prd.model.IG913Info;

/**
 * 流程缺省变量权限
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG913VW implements Serializable, Cloneable, IG913Info {
	
	/** 流程自定义ID */
	@Id
	protected String pdid;
	
	/** 流程自定义名称 */
	protected String pdname;
	
	/** ig911表的主键 */
	protected String psprpid;
	
	/** ig931表的主键 */
    protected String dpsprpid;

    /**
     * @return the 流程自定义ID
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param 流程自定义ID the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    /**
     * @return the 流程自定义名称
     */
    public String getPdname() {
        return pdname;
    }

    /**
     * @param 流程自定义名称 the pdname to set
     */
    public void setPdname(String pdname) {
        this.pdname = pdname;
    }

    /**
     * @return the ig911表的主键
     */
    public String getPsprpid() {
        return psprpid;
    }

    /**
     * @param ig911表的主键 the psprpid to set
     */
    public void setPsprpid(String psprpid) {
        this.psprpid = psprpid;
    }

    /**
     * @return the ig931表的主键
     */
    public String getDpsprpid() {
        return dpsprpid;
    }

    /**
     * @param ig931表的主键 the dpsprpid to set
     */
    public void setDpsprpid(String dpsprpid) {
        this.dpsprpid = dpsprpid;
    }

	
	
}
