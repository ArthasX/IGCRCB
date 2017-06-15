/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
 * 概述: 报表字段与流程公有表单值映射关系视图检索条件接口 
 * 功能描述: 报表字段与流程公有表单值映射关系视图检索条件接口 
 * 创建记录: 2013/07/31
 * 修改记录:
 */
public interface PdfIg898MapVWSearchCond {
    /**
     * @return the 流程主键
     */
    public Integer getPrid();

    /**
     * @return the 表单名称
     */
    public String getPidname();

    /**
     * @return the 表单定义ID
     */
    public String getPidid();
    
    /**
     * @return the 父绑定字段
     */
    public String getPdatabinding() ;
    
    /**
     * @return the 排序设置
     */
    public String getOrderby();
    /**
	 * @return the 表格式表单值行号
	 */
	public String getPvrownumber();

}