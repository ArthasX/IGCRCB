/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 报表对应BL及模板名称配置表接口
  * 功能描述: 报表对应BL及模板名称配置表接口
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public interface PdfConfigrationInfo extends BaseModel {

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 数据填充BL名称取得
	 *
	 * @return 数据填充BL名称
	 */
	public String getPdfbl();

	/**
	 * PDF报表模板名称取得
	 *
	 * @return PDF报表模板名称
	 */
	public String getTemplatename();
	
	/**
     * @return the PDF报表导出文件名称
     */
    public String getExportname() ;
    
    /**
     * @return the PDF报表XML文件名称
     */
    public String getXmlname();

}