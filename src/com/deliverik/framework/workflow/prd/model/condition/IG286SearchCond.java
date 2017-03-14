/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>概述:流程级联表单查询条件接口</p>
 * <p>功能描述:</p>
 * <p>创建记录：</p>
 */
public interface IG286SearchCond {
	/**
	 * 功能：流程级联表单ID取得
	 * @return 流程级联表单ID
	 */
	public String getPlid();
	
	/**
	 * 功能：主动表单id取得
	 * @return 主动表单id
	 */ 
	public String getInitiativepidid();
	
	/**
	 * 功能：联动表单id取得
	 * @return 联动表单id
	 */
	public String getPassivitypidid();
	
	/**
	 * 功能：联动表单说明取得
	 * @return 联动表单说明
	 */
	public String getPldesc();
	
	/**
	 * 功能：联动BL名称取得
	 * @return 联动BL名称
	 */
	public String getPlblname();
	
	/**
	 * 功能：联动JS取得
	 * @return 联动JS
	 */
	public String getPljsevent();
	
	/**
	 * 功能：联动类型取得
	 * @return 联动类型
	 */
	public String getPljtype();
	
	/**
	 * 功能：流程ID取得
	 * @return 流程ID
	 */
	public String getPldpdid();
	
	/**
	 * 功能：联动ActionID取得
	 * @return 联动ActionID
	 */
	public String getPldactionid();
	
	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPlid_like();
}
