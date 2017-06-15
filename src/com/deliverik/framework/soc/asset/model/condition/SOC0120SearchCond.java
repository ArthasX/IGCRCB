/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 导入数据版本管理表检索条件接口
  * 功能描述: 导入数据版本管理表检索条件接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0120SearchCond {
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag_eq();
	
	/**
	 * 实体名取得
	 *
	 * @return 实体名
	 */
	public String getImpeiname_eq();
	
	/**
	 * 实体名(模糊查询)取得
	 * @return 实体名(模糊查询)
	 */
	public String getImpeiname_like();
	
	/**
	 * 版本号取得
	 * @return 版本号
	 */
	public Integer getImpversion();
	
	/**
	 * 实体名取得
	 * @return 实体名
	 */
	public String getImpeiname();
	
	/**
	 * 设备模型名取得
	 * @return 设备模型名
	 */
	public String getEsyscoding();
	
	/**
	 * 导入时间取得
	 * @return 导入时间
	 */
	public String getImpcreatetime_s();
	
	/**
	 * 导入时间取得
	 * @return 导入时间
	 */
	public String getImpcreatetime_e();
}