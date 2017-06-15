package com.deliverik.framework.model.condition;

/**
 * 数据信息查询条件接口
 * 
 */
public interface CodeDetailDefSearchCond {
	
	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid ();

	/**
	 * 数据CD取得
	 * @return 数据CD
	 */
	public String getCid ();

	/**
	 * 数据分类CD(父)取得
	 * @return 数据分类CD(父)
	 */
	public String getPccid ();

	/**
	 * 数据CD(父)取得
	 * @return 数据CD(父)
	 */
	public String getPcid ();
	
	/**
	 * 数据CD状态取得
	 * @return 数据CD状态
	 */
	public String getCdstatus();
	
	/**
	 * 查询1级结点
	 */
	public String getClevel();
	
	/**
	 * 查询指定结点的下级树
	 */
	public String getSyscoding_q();
	
	/**
	 * 查询指定的结点
	 */
	public String getSyscoding();
	
	/**
	 * 资产关联关系用条件
	 */
	public String getBusinesscode_like();
	
	public String getCvalue_like();

}
