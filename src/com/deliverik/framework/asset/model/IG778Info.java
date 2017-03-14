package com.deliverik.framework.asset.model;

import java.io.Serializable;

/**
 * 机柜信息
 * 
 */
public interface IG778Info extends Serializable {

	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public Integer getEid();

	/**
	 * 机柜名称取得
	 * @return 机柜名称
	 */
	public String getEiname();
	
	/**
	 * 机柜编号取得
	 * @return 机柜编号
	 */
	public String getEilabel();

	/**
	 * 机柜说明取得
	 * @return 机柜说明
	 */
	public String getEidesc();

	/**
	 * 机柜版本号取得
	 * @return 机柜版本号
	 */
	public Integer getEiversion();

	/**
	 * 登记日取得
	 * @return 登记日
	 */
	public String getEiinsdate();

	/**
	 * 机柜位置（X）取得
	 * @return 机柜位置（X）
	 */
	public String getX_value();

	/**
	 * 机柜位置（Y）取得
	 * @return 机柜位置（Y）
	 */
	public String getY_value();

	/**
	 * 机柜高度（U）取得
	 * @return 机柜高度（U）
	 */
	public String getU_total();

	/**
	 * 机柜横向宽取得
	 * @return 机柜横向宽
	 */
	public String getX_width();

	/**
	 * 机柜纵向宽取得
	 * @return 机柜纵向宽
	 */
	public String getY_width();

	/**
	 * 所属机房ID取得
	 * @return 所属机房ID
	 */
	public Integer getRoom_eiid();

	/**
	 * 所属机房编号取得
	 * @return 所属机房编号
	 */
	public String getRoom_eilabel();

	/**
	 * 所属机房名取得
	 * @return 所属机房名
	 */
	public String getRoom_einame();

	/**
	 * 机房显示图用：层取得
	 * 
	 * @return 层
	 */
	public String getGraphindex();
	
	/**
	 * 机房显示图用：是否已设置取得
	 * 
	 * @return 是否已设置
	 */
	public String getGraphstatus();

	/**
	 * 机房显示图用：类型名称取得
	 * 
	 * @return 类型名称
	 */
	public String getGraphtypeid();

	/**
	 * 机房显示图用：类型标识取得
	 * 
	 * @return 类型标识
	 */
	public String getGraphtypename();

	/**
	 * 额定电压取得
	 * 
	 * @return 额定电压
	 */
	public String getVoltage();

	/**
	 * 机柜重量取得
	 * 
	 * @return 机柜重量
	 */
	public String getWeight();

	/**
	 * 机柜规格取得
	 * 
	 * @return 机柜规格
	 */
	public String getStandard();
	
	/**
	 * 机柜中位置取得
	 * 
	 * @return 机柜中位置
	 */
	public String getU_value();
	
	/**
	 * 资产类型（空调用来区分立式挂式）取得
	 * 
	 * @return 资产类型（空调用来区分立式挂式）
	 */
	public String getEitype();

	/**
	 * 容器类型取得
	 * 
	 * @return 容器类型
	 */
	public String getContainertype();
	
	/**
	 * 机架横向U数取得
	 * 
	 * @return 机架横向U数
	 */
	public String getWidth();

}