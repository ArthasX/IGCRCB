/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * 报表信息查询条件接口
 * 
 */
public interface ReportFileDefinitionSearchCond {
	
	/**
	 * 报表显示名称(模糊匹配)取得
	 * @return 报表显示名称(模糊匹配)
	 */
	public String getRfdtitle_like();
	
	/**
	 * 报表显示名称取得
	 * @return 报表显示名称
	 */
	public String getRfdtitle();
	
	/**
	 * 报表发布名称取得
	 * @return 报表发布名称
	 */
	public String getRfdfilename();
	
	/**
	 * 报表分类取得
	 * @return 报表分类
	 */
	public String getRfdtype();
	
	public Integer getRfdid();

}
