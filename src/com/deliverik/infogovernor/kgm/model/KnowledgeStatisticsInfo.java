/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model;

/**
 * 概述: 知识库统计接口
 * 功能描述：知识库统计接口
 * 创建记录：wanglei  2014/3/13
 * 修改记录：
 */
public interface KnowledgeStatisticsInfo{
	
	/**
	 *知识贡献人姓名取得
	 * 
	 * @return 知识贡献人姓名
	 */
	public String getKnproffername();
	
	/**
	 *主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKlsid();
	
	/**
	 *统计数量取得
	 * 
	 * @return 统计数量
	 */
	public Integer getKlscount();
	
	/**
	 *分类取得
	 * 
	 * @return 分类
	 */
	public String getKnclass();
	
	/**
	 *知识贡献人取得
	 * 
	 * @return 知识贡献人
	 */
	public String getKnproffer();
	
	/**
	 *类别名称取得
	 * 
	 * @return 类别名称
	 */
	public String getKnclassname();
	
}
