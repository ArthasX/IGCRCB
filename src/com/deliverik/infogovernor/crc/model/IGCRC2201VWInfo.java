/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model;

/**
 * @Description: 变更总体统计接口
 * @Author zhangqiang
 * @History @2014-8-7新建
 * 
 * @Version V1.0
 */
public interface IGCRC2201VWInfo{

	/**
	 * typeId取得
	 * @return typeId  typeId
	 */
	public String getTypeId();
	
	/**
	 * 分类名取得
	 * @return typeName  分类名
	 */
	public String getTypeName();

	/**
	 * 总数取得
	 * 
	 * @return totalnum 总数
	 */
	public Integer getTotalnum();

	/**
	 * 评审通过数量取得
	 * 
	 * @return passnum 评审通过数量
	 */
	public Integer getPassnum();


	/**
	 * 成功数量取得
	 * 
	 * @return successnum 成功数量
	 */
	public Integer getSuccessnum();

}
