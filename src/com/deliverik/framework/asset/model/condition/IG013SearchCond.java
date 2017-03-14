package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * <p>
 * 资产信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>eid</td>
 * <td>资产模型ID</td>
 * </tr>
 * <tr>
 * <td>einame</td>
 * <td>资产名称（模糊匹配）</td>
 * </tr>
 * <tr>
 * <td>eilabel</td>
 * <td>资产编号</td>
 * </tr> 
 * <tr>
 * <td>eiorgsyscoding</td>
 * <td>资产所属机构层次码（前方一致模糊匹配）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG013SearchCond {
	
	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产编号取得
	 * @return 资产编号
	 */
	public String getEilabel();
	
	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEiname();
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding();
	
	/**
	 * 资产ID取得（平台保留）
	 * @return 资产ID
	 */
	public String getEiid();
	
	/**
	 * 资产版本号取得
	 * @return 资产版本号
	 */
	public Integer getEiversion();
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion() ;
	
	public List<String> getEilabel_list();
	
	/**
	 * 资产名称（完全匹配 ）取得
	 * @return 资产名称（完全匹配 ）
	 */
	public String getEiname_equal();

}
