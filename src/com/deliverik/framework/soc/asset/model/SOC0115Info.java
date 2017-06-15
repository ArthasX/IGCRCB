/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 待处理任务接口
  * 功能描述: 待处理任务接口
  * 创建记录: 2011/04/29
  * 修改记录: 
  */
public interface SOC0115Info extends BaseModel {

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getEitid();

	/**
	 * 任务创建时间取得
	 *
	 * @return 任务创建时间
	 */
	public String getEitcreatetime();

	/**
	 * 顶级ci取得
	 *
	 * @return 顶级ci
	 */
	public String getEittopci();

	/**
	 * 源文件名取得
	 *
	 * @return 源文件名
	 */
	public String getEitfilename();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getEitstatus();

	/**
	 * 解析开始时间取得
	 *
	 * @return 解析开始时间
	 */
	public String getEitparsestart();

	/**
	 * 解析结束时间取得
	 *
	 * @return 解析结束时间
	 */
	public String getEitparseend();

	/**
	 * CI实体生成开始时间取得
	 *
	 * @return CI实体生成开始时间
	 */
	public String getEitcistart();

	/**
	 * CI实体生成结束时间取得
	 *
	 * @return CI实体生成结束时间
	 */
	public String getEitciend();

	/**
	 * 关系建立开始时间取得
	 *
	 * @return 关系建立开始时间
	 */
	public String getEitrelationstart();

	/**
	 * 关系建立结束时间取得
	 *
	 * @return 关系建立结束时间
	 */
	public String getEitrelationend();
	
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
	public SOC0113Info getEiImportProgrammeTB();

}