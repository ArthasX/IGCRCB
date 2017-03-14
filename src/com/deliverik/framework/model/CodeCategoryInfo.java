package com.deliverik.framework.model;

/**
 * 数据分类信息接口
 * @author
 *
 */
public interface CodeCategoryInfo {

	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid ();

	/**
	 * 数据分类名取得
	 * @return 数据分类名
	 */
	public String getCcname ();

	/**
	 * 数据分类说明取得
	 * @return 数据分类说明
	 */
	public String getCcinfo ();

	/**
	 * 数据分类编辑标识取得
	 * @return 数据分类编辑标识
	 */
	public String getCceditable ();

	/**
	 * 数据分类CD(父)取得
	 * @return 数据分类CD(父)
	 */
	public String getPccid ();

	/**
	 * 父子类型数据分类标识取得
	 * @return 父子类型数据分类标识
	 */
	public String getPcflag ();
}