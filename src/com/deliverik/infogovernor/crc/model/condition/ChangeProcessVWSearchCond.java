/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
  * 概述: 变更流程检索条件接口
  * 功能描述: 变更流程检索条件接口
  * 创建记录: 2015/01/04
  * 修改记录: 
  */
public interface ChangeProcessVWSearchCond {

	/**
	 * 流程主键取得
	 * @return the prid
	 */
	public Integer getPrid();

	/**
	 * 工单号取得
	 * @return the prserialnum_like
	 */
	public String getPrserialnum_like();

	/**
	 * 流程状态取得
	 * @return the prstatus
	 */
	public String getPrstatus();

	/**
	 * 流程开始时间(起始)取得
	 * @return the propentime_begin
	 */
	public String getPropentime_begin();

	/**
	 * 流程开始时间(结束)取得
	 * @return the propentime_end
	 */
	public String getPropentime_end();

	/**
	 * 流程关闭时间(起始)取得
	 * @return the prclosetime_begin
	 */
	public String getPrclosetime_begin();

	/**
	 * 流程关闭时间(结束)取得
	 * @return the prclosetime_end
	 */
	public String getPrclosetime_end();

	/**
	 * 变更分类取得
	 * @return the changeclassify
	 */
	public String getChangeclassify();

	/**
	 * 更新平台取得
	 * @return the updateplatform_like
	 */
	public String getUpdateplatform_like();
	
	/**
	 * 变更类型取得
	 * @return the changetype_like
	 */
	public String getChangetype_like();

	/**
	 * 变更原因取得
	 * @return the changereason_like
	 */
	public String getChangereason_like();

	/**
	 * 变更类别取得
	 * @return the changecategory
	 */
	public String getChangecategory();

	/**
	 * 流程名称取得
	 * @return the prtitle_like
	 */
	public String getPrtitle_like();
	
	/**
	 * 业务影响范围取得
	 * @return the businessscope
	 */
	public String getBusinessscope();
	
	/**
	 * 是否影响业务取得
	 * @return the isinfluence
	 */
	public String getIsinfluence();
	
	/**
	 * 变更内容取得
	 * @return the changecontent_like
	 */
	public String getChangecontent_like();
	
	/**
	 * 处理人取得
	 * @return ppusername_like  处理人
	 */
	public String getPpusername_like();
}