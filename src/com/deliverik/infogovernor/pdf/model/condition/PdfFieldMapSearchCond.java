/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
  * 概述: PDF报表与流程表单映射表检索条件接口
  * 功能描述: PDF报表与流程表单映射表检索条件接口
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public interface PdfFieldMapSearchCond {
    
    /**
     * @return the pdid
     */
    public String getPdid();
    
    /**
     * @return the 表单类型
     */
    public String getFormtype() ;
}