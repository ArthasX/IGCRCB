/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图检索条件实现
  * 功能描述: 报表字段与流程公有表单值映射关系视图检索条件实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public class PdfIg599MapVWSearchCondImpl implements
		PdfIg599MapVWSearchCond {
    
    /** 流程ID */
    protected Integer prid;
    
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
  
}