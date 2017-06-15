/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
  * 概述: PDF报表XML中表格式表单节点定义表检索条件接口
  * 功能描述: PDF报表XML中表格式表单节点定义表检索条件接口
  * 创建记录: 2013/08/02
  * 修改记录: 
  */
public interface PdfTableNodeSearchCond {
    /**
     * @return the pdid
     */
    public String getPdid();
    /**
	 * @return the 绑定名称
	 */
	public String getDatabinding();

	/**
	 * @return the 父绑定名称
	 */
	public String getPdatabinding();

	/**
	 * @return the 报表节点类型：0固定，1可变
	 */
	public String getNodetype();
}