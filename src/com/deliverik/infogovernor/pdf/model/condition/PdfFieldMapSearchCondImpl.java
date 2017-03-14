/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
  * 概述: PDF报表与流程表单映射表检索条件实现
  * 功能描述: PDF报表与流程表单映射表检索条件实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public class PdfFieldMapSearchCondImpl implements
		PdfFieldMapSearchCond {
    
    /** 流程定义id*/ 
    String pdid;

    /** 表单类型*/ 
    String formtype;
    
    /**
     * @return the pdid
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param pdid the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    /**
     * @return the 表单类型
     */
    public String getFormtype() {
        return formtype;
    }

    /**
     * @param 表单类型 the formtype to set
     */
    public void setFormtype(String formtype) {
        this.formtype = formtype;
    }
    
}