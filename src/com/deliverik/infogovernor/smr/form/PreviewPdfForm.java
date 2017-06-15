/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 报表预览Form
 *
 */
@SuppressWarnings("serial")
public class PreviewPdfForm extends BaseForm {
    /** 流程ID */
    protected Integer prid;
    
    /** 流程定义ID */
    protected String pdid;

    /**
     * @return the 流程ID
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * @param 流程ID the prid to set
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * @return the 流程定义ID
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param 流程定义ID the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }
	
}