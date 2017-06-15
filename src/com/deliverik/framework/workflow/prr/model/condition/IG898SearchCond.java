/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 表格类表单值表检索条件接口
  * 功能描述: 表格类表单值表检索条件接口
  * 创建记录: 2013/06/25
  * 修改记录: 
  */
public interface IG898SearchCond {

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid();
	
	/**
	 * 父级表单定义主键取得
	 * @return pidid 父级表单定义主键
	 */
	public String getPidid();
	
	/**
     * 表单名称取得
     * @return pidname 表单名称
     */
    public String getPidname();
    
	/**
	 * 行号取得
	 * @return rownumber 行号
	 */
	public String getRownumber();
	
	/**
	 * 获取列名
	 * @return pvcolname 行号
	 */
	public String getPvcolname();
	
	/**
	 * 表单值
	 * @return
	 */
	public String getPvalue();
}