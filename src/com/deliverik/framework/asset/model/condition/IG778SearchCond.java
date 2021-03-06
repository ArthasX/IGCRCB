package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * 机柜信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>机柜ID</td>
 * </tr> 
 * <tr>
 * <td>room_eiid</td>
 * <td>机房ID</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>机柜编号</td>
 * </tr> 
 * <tr>
 * <td>einame</td>
 * <td>机柜名称（模糊匹配）。</td>
 * </tr>
 * <tr>
 * <td>u_total</td>
 * <td>机柜高
 * </td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG778SearchCond {

	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public Integer getEiid();

	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public Integer getRoom_eiid();

	/**
	 * 机柜编号取得
	 * @return 机柜编号
	 */
	public String getEilabel();

	/**
	 * 机柜名称取得
	 * @return 机柜名称
	 */
	public String getEiname();

	/**
	 * 机柜高度（U）取得
	 * @return 机柜高度（U）
	 */
	public String getU_total();
	
	/**
	 * 机柜是否已上架
	 * @return 机柜是否已上架
	 */
	public String getGraphstatus();
	
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
}
