package com.deliverik.framework.asset.model;

/**
 * 机房信息
 * 
 */
public interface IG601Info {

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public Integer getEid();

	/**
	 * 机房名称取得
	 * @return 机房名称
	 */
	public String getEiname();
	
	/**
	 * 机房编号取得
	 * @return 机房编号
	 */
	public String getEilabel();

	/**
	 * 机房说明取得
	 * @return 机房说明
	 */
	public String getEidesc();

	/**
	 * 机房版本号取得
	 * @return 机房版本号
	 */
	public Integer getEiversion();

	/**
	 * 登记日取得
	 * @return 登记日
	 */
	public String getEiinsdate();

	/**
	 * 横向位置坐标长取得
	 * @return 横向位置坐标长
	 */
	public String getX_total();

	/**
	 * 纵向位置坐标长取得
	 * @return 纵向位置坐标长
	 */
	public String getY_total();

	/**
	 * 负责人取得
	 * @return 负责人
	 */
	public String getManager();
	
	/**
	 * 联系电话取得
	 * @return 联系电话
	 */
	public String getTel();
	/**
	 * 关联机房ID
	 * @return 关联机房ID
	 */
	public String getRelateroom();
	/**
	 * 关联地板X
	 * @return 关联地板X
	 */
	public String getRelatex();
	/**
	 * 关联地板Y
	 * @return 关联地板Y
	 */
	public String getRelatey();
	
}