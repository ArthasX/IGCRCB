package com.deliverik.framework.asset.model.condition;

/**
 * <p>
 * 资产统计信息检索条件
 * </p>
 * <p>
 * (未做说明的属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>ciupdtime_from</td>
 * <td>资产登记开始时间（大于等于）</td>
 * </tr>
 * <tr>
 * <td>ciupdtime_to</td>
 * <td>资产登记截止时间（小于等于）</td>
 * </tr> 
 * <tr>
 * <td>eiorgsyscoding_q</td>
 * <td>资产所属机构层次码（前方一致模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>eparcoding</td>
 * <td>资产模型上级层次码（根据层次码统计该资产模型下的资产数量）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG011SearchCond {
	
	/**
	 * 资产登记开始时间取得
	 * @return 资产登记开始时间
	 */
	public String getCiupdtime_from();
	
	/**
	 * 资产登记截止时间取得
	 * @return 资产登记截止时间
	 */
	public String getCiupdtime_to();
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding_q();
	
	/**
	 * 机构查询类型（平台保留）取得
	 * @return 机构查询类型（平台保留）
	 */
	public String getOrgType();
	
	/**
	 * 资产模型上级层次码取得
	 * @return 资产模型上级层次码
	 */
	public String getEparcoding();
}
