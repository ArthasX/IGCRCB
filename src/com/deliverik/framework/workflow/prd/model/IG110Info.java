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
 * Description: 查询显示列定义接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG110Info extends BaseModel{

	/**
	 * 主键取得
	 * @return sid 主键
	 */
	public String getSid();

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid();

	/**
	 * 显示列类型取得
	 * @return stype 显示列类型
	 */
	public String getStype();

	/**
	 * 显示列标识取得
	 * @return sflag 显示列标识
	 */
	public String getSflag();
	
	/**
	 * 标识名称取得
	 * @return sname 标识名称
	 */
	public String getSname();
	
	/**
	 * 宽度取得
	 * @return width 宽度
	 */
	public Integer getWidth();

}
