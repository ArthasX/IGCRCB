/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询条件定义接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG111Info extends BaseModel{

	/**
	 * 主键取得
	 * @return qid 主键
	 */
	public String getQid();

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid();

	/**
	 * 查询方式取得
	 * @return qmode 查询方式
	 */
	public String getQmode();

	/**
	 * 查询条件标识取得
	 * @return qtype 查询条件标识
	 */
	public String getQtype();

	/**
	 * 查询条件标识取得
	 * @return qflag 查询条件标识
	 */
	public String getQflag();
	
	/**
	 * 标识名称取得
	 * @return qname 标识名称
	 */
	public String getQname();
	
	/**
	 * 表单定义实体取得
	 * @return pid 表单定义实体
	 */
	public IG007Info getPid();
}
