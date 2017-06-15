package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程页面定义信息
 *
 */
public interface IG126Info  extends BaseModel {

	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public String getPjdid();

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 页面类型取得
	 * 
	 * @return 页面类型
	 */
	public String getPjdtype();

	/**
	 * 自定义BL名称取得
	 * 
	 * @return 自定义BL名称
	 */
	public String getPjdblid();

	/**
	 * 页面路径取得
	 * 
	 * @return 页面路径
	 */
	public String getPjdurl();

}