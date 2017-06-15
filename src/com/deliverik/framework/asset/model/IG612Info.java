/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;


/**
  * 概述: 资产模型属性缺省值视图接口
  * 功能描述: 资产模型属性缺省值视图接口
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
public interface IG612Info {

	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public String getCid();

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产模型属性名称取得
	 * @return 资产模型属性名称
	 */
	public String getCname();

	/**
	 * 资产模型属性编号取得
	 * @return 资产模型属性编号
	 */
	public String getClabel();

	/**
	 * 资产模型属性说明取得
	 * @return 资产模型属性说明
	 */
	public String getCdesc();

	/**
	 * 资产模型属性单位取得
	 * @return 资产模型属性单位
	 */
	public String getCunit();

	/**
	 * 资产模型属性状态取得
	 * @return 资产模型属性状态
	 */
	public String getCstatus();

	/**
	 * 资产模型属性是否显示标识取得
	 * @return 资产模型属性是否显示标识
	 */
	public String getCseq();

	/**
	 * 资产模型属性类型取得
	 * @return 资产模型属性类型 
	 */
	public String getCcategory();

	/**
	 * 资产模型属性取值范围取得
	 * @return 资产模型属性取值范围
	 */
	public String getCoption();

	/**
	 * 资产模型属性附件标识取得
	 * @return 资产模型属性附件标识
	 */
	public String getCattach();

	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();

	/**
	 * 记录时间戳取得
	 * @return 记录时间戳
	 */
	public String getFingerPrint();
	
	/**
	 * 资产模型属性必填项取得
	 * @return 资产模型属性必填项
	 */
	public String getCrequired();
	
	/**
	 * 属性默认值取得
	 * @return 属性默认值
	 */
	public String getCvalue();

}