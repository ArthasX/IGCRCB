/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset;


import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * 概述: 审计对比结果信息表实体接口
 * 功能描述: 审计对比结果信息表实体接口
 * 创建记录: 2012/03/05
 * 修改记录: 
 */
public interface SOC0137Info{
	
	/**
	 * 审计任务ID取得
	 *
	 * @return 审计任务ID
	 */
	public Integer getAutid();

	/**
	 * 对比结果类型取得
	 *
	 * @return 对比结果类型
	 */
	public String getAucmptype();

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 大版本取得
	 *
	 * @return 大版本
	 */
	public Integer getEiversion();
	
	/**
	 * 小版本取得
	 *
	 * @return 小版本
	 */
	public Integer getEismallversion();

	/**
	 * 资产名称取得
	 *
	 * @return 资产名称
	 */
	public String getEiname();

	/**
	 * 合理标识取得
	 *
	 * @return 合理标识
	 */
	public String getAuflag() ;

	/**
	 * 资产层次码取得
	 * @return 资产层次码
	 */
	public String getEsyscoding();

	/**
	 * 模型实体取得
	 * @return 模型实体
	 */
	public SOC0117TB getEntityTB();
	
	/**
	 * 审计时间戳取得
	 *
	 * @return 审计时间戳
	 */
	public String getAutime();
}
