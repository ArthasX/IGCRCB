package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;


/**
 * <p>
 * 资产模型属性信息检索条件
 * </p>
 * <p>
 * (未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>eid</td>
 * <td>资产模型ID</td>
 * </tr>
 * <tr>
 * <td>cname</td>
 * <td>资产模型属性名称（模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>ccategory</td>
 * <td>资产模型属性类型</td>
 * </tr> 
 * <tr>
 * <td>cstatus</td>
 * <td>资产模型属性状态1启用，2停用）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface SOC0109SearchCond {
	/**
	 * 资产属性ID取得
	 * @return
	 */
	public String getCid();
	/**
	 * 资产属性ID like取得
	 * @return
	 */
	public String getCid_like();
	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产模型属性名称取得
	 * @return 资产模型属性名称
	 */
	public String getCname();
	
	/**
	 * 资产模型属性类型取得
	 * @return 资产模型属性类型
	 */
	public String getCcategory();
	
	/**
	 * 资产模型属性状态取得
	 * @return 资产模型属性状态
	 */
	public String getCstatus();
	
	/**
	 * 资产模型属性编号取得（平台保留）
	 * @return 资产模型属性编号
	 */
	public String getClabel();

	/**
	 * 资产模型属性是否显示标识取得（平台保留）
	 * @return 资产模型属性是否显示标识
	 */
	public Integer getCseq();
	
	/**
	 * 资产模型层次码区间检索条件取得（平台保留）
	 * @return 资产模型层次码区间检索条件
	 */
	public List<String> getEsyscodingList();
	
	/**
	 * 资产模型配置项区间检索条件取得（平台保留）
	 * @return 资产模型配置项区间检索条件
	 */
	public List<String> getCattachList();
	/**
	 *资产码模糊查询
	 * @return 资产码模糊查询检索条件
	 */
	public String getEsyscoding_like() ;
}
