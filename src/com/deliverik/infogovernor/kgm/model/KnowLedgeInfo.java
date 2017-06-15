/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model;

/**
 * 概述: 知识库查询信息接口
 * 功能描述：知识库查询信息接口
 * 创建记录：wangxiaoqiang    2010/12/07
 * 修改记录：
 */
public interface KnowLedgeInfo {
	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Integer getKnid();

	/**
	 * 知识库分类取得
	 * 
	 * @return 知识库分类
	 */
	public String getKnclass();
	
	/**
	 * 知识库分类名称取得
	 * 
	 * @return 知识库分类名称
	 */
	public String getKnclassname();

	/**
	 * 贡献人取得
	 * 
	 * @return 贡献人
	 */
	public String getKnproffername();

	/**
	 * 知识标题取得
	 * 
	 * @return 知识标题
	 */
	public String getKntitle();

	/**
	 * 事件取得
	 * 
	 * @return 事件
	 */
	public String getKnapprovetime();

	/**
	 * 总评分取得
	 * 
	 * @return 总评分
	 */
	public String getGrade();

	
	/**
	 * 流程数量取得
	 * @return 流程数量
	 */
	public Integer getProcessnum();
	
	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion();
	
	/**
	 *编号取得
	 * 
	 * @return 编号
	 */
	public String getKnserial();
}
