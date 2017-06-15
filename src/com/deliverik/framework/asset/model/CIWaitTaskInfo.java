/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CI变更待处理任务接口
  * 功能描述: CI变更待处理任务接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CIWaitTaskInfo extends BaseModel {

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getCiwtid();

	/**
	 * 任务创建时间取得
	 *
	 * @return 任务创建时间
	 */
	public String getCiwtcreatetime();

	/**
	 * 源文件名取得
	 *
	 * @return 源文件名
	 */
	public String getCiwtfilename();
	
	/**
	 * 顶级CI取得
	 * 
	 * @return 顶级CI
	 */
	public String getCiwttopci();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getCiwtstatus();

	/**
	 * 解析开始时间取得
	 *
	 * @return 解析开始时间
	 */
	public String getCiwtparsestart();

	/**
	 * 解析结束时间取得
	 *
	 * @return 解析结束时间
	 */
	public String getCiwtparseend();

	/**
	 * CI实体生成开始时间取得
	 *
	 * @return CI实体生成开始时间
	 */
	public String getCiwtcistart();

	/**
	 * CI实体生成结束时间取得
	 *
	 * @return CI实体生成结束时间
	 */
	public String getCiwtciend();
	
	/**
	 * 逻辑删除标识设定
	 *
	 * @param deleteflag逻辑删除标识
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