package com.deliverik.framework.model.condition;

/**
 * 数据分类信息查询条件接口
 * 
 */
public interface CodeCategorySearchCond {
	
	/**
	 * 分类CD取得
	 * @return 分类CD
	 */
	public String getCcid ();
	
	/**
	 * 上级分类CD取得
	 * @return 上级分类CD
	 */
	public String getPccid ();

	/**
	 * 分类编辑标识取得
	 * @return 分类编辑标识
	 */
	public String getCceditable ();
	
	/**
	 * 是否层次数据取得
	 * @return 是否层次数据
	 */
	public boolean isTree();
	
}
