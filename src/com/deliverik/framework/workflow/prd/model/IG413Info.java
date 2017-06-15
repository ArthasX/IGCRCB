package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程事件定义信息
 *
 */
public interface IG413Info  extends BaseModel {

	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public String getPedid();

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 状态ID取得
	 * 
	 * @return 状态ID
	 */
	public String getPsdid();

	/**
	 * 动作ID取得
	 * 
	 * @return 动作ID
	 */
	public String getPedactionid();

	/**
	 * 事件类型取得
	 * 
	 * @return 事件类型
	 */
	public String getPedtype();

	/**
	 * 自定义BL名称取得
	 * 
	 * @return 自定义BL名称
	 */
	public String getPedblid();

	/**
	 * 事件执行顺序取得
	 * 
	 * @return 事件执行顺序
	 */
	public Integer getPedorder();
	
	
	/**
	 * 事件加入描述取得
	 * 
	 * @return 事件执行顺序
	 */
	public String getPedec();

}