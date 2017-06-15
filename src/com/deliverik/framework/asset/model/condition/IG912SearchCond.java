package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * 设备资产信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>设备资产ID</td>
 * </tr> 
 * <tr>
 * <td>container_eiid</td>
 * <td>机柜ID</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>设备资产编号</td>
 * </tr> 
 * <tr>
 * <td>einame</td>
 * <td>设备资产名称（模糊匹配）</td>
 * </tr>
 * <tr>
 * <td>u_total</td>
 * <td>设备资产高</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG912SearchCond {

	/**
	 * 设备资产ID取得
	 * @return 机柜ID
	 */
	public Integer getEiid();

	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */
	public Integer getContainer_eiid();

	/**
	 * 设备资产编号取得
	 * @return 设备资产编号
	 */
	public String getEilabel();

	/**
	 * 设备资产名称取得
	 * @return 设备资产名称
	 */
	public String getEiname();

	/**
	 * 设备资产高度（U）取得
	 * @return 设备资产高度（U）
	 */
	public String getU_total();
	
	/**
	 * 是否上架标志位取得
	 * @return 是否上架标志位
	 */
	String getInJiguiFlg();
	
	/**
	 * 设备层次码
	 * @return 设备层次码
	 */
	String getEsyscoding();
	
	/**
	 * 设备层次码取得
	 * @return 设备层次码
	 */
	public String getInroomFlg();

	/**
	 * 设备形状
	 */
	public String[] getEiStatuses();
}
