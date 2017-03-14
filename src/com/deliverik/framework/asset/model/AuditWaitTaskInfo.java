/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 审计待处理任务接口
  * 功能描述: 审计待处理任务接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface AuditWaitTaskInfo extends BaseModel {

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getAuwtid();

	/**
	 * 任务创建时间取得
	 *
	 * @return 任务创建时间
	 */
	public String getAuwtcreatetime();

	/**
	 * 源文件名取得
	 *
	 * @return 源文件名
	 */
	public String getAuwtfilename();
	
	/**
	 * 顶级CI取得
	 * 
	 * @return 顶级CI
	 */
	public String getAuwttopci();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getAuwtstatus();

	/**
	 * 解析开始时间取得
	 *
	 * @return 解析开始时间
	 */
	public String getAuwtparsestart();

	/**
	 * 解析结束时间取得
	 *
	 * @return 解析结束时间
	 */
	public String getAuwtparseend();

	/**
	 * CI实体生成开始时间取得
	 *
	 * @return CI实体生成开始时间
	 */
	public String getAuwtcistart();

	/**
	 * CI实体生成结束时间取得
	 *
	 * @return CI实体生成结束时间
	 */
	public String getAuwtciend();

	/**
	 * 删除标识取得
	 *
	 * @return 删除标识
	 */
	public String getDeleteflag();
	
	/**
	 * 顶级CI类型取得
	 *
	 * @return 顶级CI类型
	 */
	public Integer getImpTypeid();
	
	/**
	 * 导入对象类型信息取得
	 * @return 导入对象类型信息
	 */
	public EiImportProgrammeInfo getEiImportProgrammeTB();


}