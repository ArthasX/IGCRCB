/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/** 
 * 流程状态定义
 *
 */
public interface IG333Info  extends BaseModel {
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程名称ID取得
	 * @return 流程名称ID
	 */
	public String getPdid();

	/**
	 * 流程状态名称取得
	 * @return 流程状态名称
	 */
	public String getPsdname();
	
	/**
	 * 流程状态描述取得
	 * @return 流程状态描述
	 */
	public String getPsddesc();
	
	/**
	 * 流程状态标识取得
	 * @return 流程状态标识
	 */
	public String getPsdcode();
	
	/**
	 * 流程节点类型取得
	 * @return 流程节点类型
	 */
	public String getPsdtype();
	
	/**
	 * 流程节点模式取得
	 * @return 流程节点模式
	 */
	public String getPsdmode();
	
	/**
	 * 流程节点动态参与者标识取得
	 * @return 流程节点动态参与者标识
	 */
	public String getPsdflag();
	
	/**
	 * 分派参与者类型取得
	 * 
	 * @return 分派参与者类型
	 */
	public String getPsdassign();

	/**
	 * 是否机构过滤取得
	 * 
	 * @return 是否机构过滤
	 */
	public String getPsdorg();
	
	/**
	 * 有无确认操作取得
	 * 
	 * @return 有无确认操作
	 */
	public String getPsdconfirm();
	
	/**
	 * 分派节点ID取得
	 * 
	 * @return 分派节点ID
	 */
	public String getAssignpsdid();

	/**
	 * 分派按钮ID取得
	 * 
	 * @return 分派按钮ID
	 */
	public String getAssignpbdid();
	
	public String getParticipantchange();
	
	/**
	 * 是否必须分派标识取得
	 * 
	 * @return 是否必须分派标识
	 */
	public String getAssignflag();
	
	public String getIsSelected();

	/**
     * @return the 分配页面类型
     */
    public String getAssignPageType() ;
    
    /**
     * 表单全局控制标识取得
     * @return 表单全局控制标识
     */
	public String getFormGlobalControl();
	
	/**
	 * js方法取得
	 * @return jsfunction js方法
	 */
	public String getJsfunction();

	/**
	 * 排序取得
	 * @return 排序
	 */
	public String getBysequence();
	

	/**
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid();

	/**
	 * 子流程流程图取得
	 * @return 子流程流程图
	 */
	public String getPsdxml();

	/**
	 * 动态分支条件取得
	 * @return 动态分支条件
	 */
	public String getBranchcond();
	
	/**
	 * 是否可代替处理取得
	 * @return replaceDispose 是否可代替处理
	 */
	public String getReplaceDispose();
}
