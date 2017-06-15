package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 资产模型信息
 * </p>
 */
public interface IG117Info  extends BaseModel {

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public Integer getEid();

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname();
	
	/**
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel();

	/**
	 * 资产模型说明取得
	 * @return 资产模型说明
	 */
	public String getEdesc();

	/**
	 * 资产模型状态取得
	 * @return 资产模型状态
	 */
	public String getEstatus();

	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory();

	/**
	 * 资产模型一级子类取得
	 * @return 资产模型一级子类
	 */
	public String getEkey1();

	/**
	 * 资产模型二级子类取得
	 * @return 资产模型二级子类
	 */
	public String getEkey2();

	/**
	 * 资产模型三级子类取得
	 * @return 资产模型三级子类
	 */
	public String getEkey3();
	
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();

	/**
	 * 资产模型父级层次码取得
	 * @return 资产模型父级层次码
	 */
	public String getEparcoding();
	
	/**
	 * 资产模型类别取得
	 * @return 资产模型类别
	 */
	public String getEmodeltype();

}