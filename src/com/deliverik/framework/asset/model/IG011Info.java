package com.deliverik.framework.asset.model;

/**
 * 资产统计信息
 *
 */
public interface IG011Info {

	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getCid();
	
	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getCvalue();
	
	/**
	 * 总数取得
	 * @return 总数
	 */
	public Integer getTotal();
	
	/**
	 * 每种资产模型数量所占总数的百分数取得
	 * @return 每种资产模型数量所占总数的百分数
	 */
	public String getProportion();
	

	/**
	 * 每种资产模型数量所占总数的百分数设定
	 *
	 * @param proportion 每种资产模型数量所占总数的百分数
	 */
	public void setProportion(String proportion);
	
}