/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;

/**
 * <p>概述:表单联动实体接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG286Info  extends BaseModel {
	
	/**
	 * 功能：主键ID
	 * @return 主键ID
	 */
	public String getPlid() ;

	/**
	 * 功能：主动id
	 * @return 主动id
	 */
	public String getInitiativepidid() ;

	/**
	 * 功能：被动id
	 * @return 被动id
	 */
	public String getPassivitypidid() ;

	/**
	 * 功能：关联描述
	 * @return 关联描述
	 */
	public String getPldesc();

	/**
	 * 功能：bl名称
	 * @return bl名称
	 */
	public String getPlblname();

	/**
	 * 功能：js事件名称
	 * @return js事件名称
	 */
	public String getPljsevent();

	/**
	 * 功能：表单关联类型
	 * @return 表单关联类型
	 */
	public String getPljtype();
	
	/**
	 * 功能：流程定义id
	 * @return 流程定义id
	 */
	public String getPldpdid();
	
	/**
	 * 功能：表单按钮id
	 * @return 表单按钮id
	 */
	public String getPldactionid();
	
	/**
	 * 功能：主动表单名称
	 * @return 主动表单名称
	 */
	public String getInitiativepidname();

	/**
	 * 功能：被动表单名称
	 * @return 被动表单名称
	 */
	public String getPassivitypidname();
	
	/**
	 * 功能：流程定义
	 * @return processDefinitionTB
	 */
	public IG380TB getProcessDefinitionTB();

}