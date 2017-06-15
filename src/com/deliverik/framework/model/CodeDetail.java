package com.deliverik.framework.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 数据信息接口
 * @author
 *
 */
public interface CodeDetail  extends BaseModel {

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
	 * 数据值取得
	 * @return 数据值
	 */
	public String getCvalue ();

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
	 * 数据更新时间取得
	 * @return 数据更新时间
	 */
	public String getUpdtime ();
	
	/**
	 * 层次码
	 * @return 层次码
	 */
	public String getSyscoding ();
	/**
	 * 上级层次码
	 * @return 上级层次码
	 */
	public String getPsyscoding();
	
	/**
	 * 状态 0-停用，1-启用
	 * @return 状态
	 */
	public String getCdstatus();
	
	/**
	 * 数据业务码
	 * @return 数据业务码
	 */
	public String getBusinesscode();
	/**
	 * 数据说明
	 * @return 数据说明
	 */
	public String getCdinfo();
	
	/**
	 * 排列标识
	 * @return 排列标识
	 */
	public Integer getCdorder();
	
}