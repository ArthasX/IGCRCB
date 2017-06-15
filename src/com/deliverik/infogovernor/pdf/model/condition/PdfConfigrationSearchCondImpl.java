/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
  * 概述: 报表对应BL及模板名称配置表检索条件实现
  * 功能描述: 报表对应BL及模板名称配置表检索条件实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public class PdfConfigrationSearchCondImpl implements
		PdfConfigrationSearchCond {

    /** 流程定义id*/ 
    protected String pdid;

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
    
    
}