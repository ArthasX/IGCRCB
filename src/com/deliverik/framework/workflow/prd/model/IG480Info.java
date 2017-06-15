/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程组定义表接口
  * 功能描述: 流程组定义表接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG480Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPgdid();

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getPgdname();

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPgddesc();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getPgdstatus();

	/**
	 * 流程图xml取得
	 *
	 * @return 流程图xml
	 */
	public String getPgdxml();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getPgdcrtime();

	/**
	 * 序列号生成处理类取得
	 *
	 * @return 序列号生成处理类
	 */
	public String getSerialGenerator();

	/**
	 * 模板类型取得
	 *
	 * @return 模板类型
	 */
	public Integer getPtid();

}