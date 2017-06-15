package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 资产模型属性信息
 * </p>
 */
public interface SOC0109Info  extends BaseModel {

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
	 * 资产模型属性分类取得
	 * @return 资产模型属性分类
	 */
	public String getCcategory();
	
	/**
	 * 资产模型属性取值范围ID取得
	 * @return 资产模型属性取值范围ID
	 */
	public String getCoption();
	
	/**
	 * 资产模型属性编号取得
	 * @return 资产模型属性编号
	 */
	public String getClabel();

	/**
	 * 资产模型属性是否显示标识取得
	 * @return 资产模型属性是否显示标识
	 */
	public Integer getCseq();

	/**
	 * 资产模型属性数据类型取得
	 * @return 资产模型属性数据类型
	 */
	public String getCattach();
	
	/**
	 * 资产模型属性必填项取得
	 * @return 资产模型属性必填项
	 */
	public String getCrequired();
	
	/**
	 * 资产模型属性所属模型层次码取得
	 * @return 资产模型属性所属模型层次码
	 */
	public String getEsyscoding();
	
	/**
	 * 排序标识取得
	 * @return 排序标识
	 */
	public Integer getCorder();
}