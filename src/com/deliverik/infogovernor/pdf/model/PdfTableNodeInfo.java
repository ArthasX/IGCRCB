/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: PDF报表XML中表格式表单节点定义表接口
  * 功能描述: PDF报表XML中表格式表单节点定义表接口
  * 创建记录: 2013/08/02
  * 修改记录: 
  */
public interface PdfTableNodeInfo extends BaseModel {

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 绑定名称取得
	 *
	 * @return 绑定名称
	 */
	public String getDatabinding();

	/**
	 * 父绑定名称取得
	 *
	 * @return 父绑定名称
	 */
	public String getPdatabinding();

	/**
     * @return the 报表节点类型：0固定，1可变
     */
    public String getNodetype();
}