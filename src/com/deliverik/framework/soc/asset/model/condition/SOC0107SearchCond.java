package com.deliverik.framework.soc.asset.model.condition;

/**
 * <p>
 * 资产属性信息检索条件
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>eid</td>
 * <td>资产模型ID</td>
 * </tr> 
 * <tr>
 * <td>eiid</td>
 * <td>资产ID</td>
 * </tr>
 * <tr>
 * <td>cid</td>
 * <td>资产模型属性ID</td>
 * </tr> 
 * <tr>
 * <td>civersion</td>
 * <td>资产属性大版本号</td>
 * </tr> 
 * <tr>
 * <td>cismallversion</td>
 * <td>资产属性小版本号</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0107SearchCond {

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid();
	
	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产属性大版本号取得
	 * @return 资产属性大版本号
	 */
	public String getCiversion();
	
	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public String getCid();
	
	/**
	 * 资产模型属性值取得
	 * @return 资产模型属性值
	 */
	public String getCivalue();
	
	/**
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public String getCismallversion();
	
	public String[] getCids();
}
