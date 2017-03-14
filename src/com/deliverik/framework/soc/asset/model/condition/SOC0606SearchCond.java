/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * <p>
 * 资产属性信息检索条件
 * </p>
 * <p>
 * <br>
 * <table border="1">
 * <tr>
 * <td>eiid</td>
 * <td>资产ID</td>
 * </tr> 
 * <tr>
 * <td>cname</td>
 * <td>资产模型属性名称（模糊匹配）</td>
 * </tr> 
 * <tr>
 * <td>esyscoding_q</td>
 * <td>资产模型层次码（根据层次码取得该资产及其继承得到的所有资产属性信息）</td>
 * </tr> 
 * </table>
 * </p>
 */
public interface SOC0606SearchCond {

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid();
	
	/**
	 * 资产模型属性名称设定
	 *
	 * @param cname 资产模型属性名称
	 */
	public String getCname();
	
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding_q();
	
	/**
	 * 资产模型层次码取得（SOC）
	 * @return 资产模型层次码
	 */
	public String getClabel_q();
	
	/**
	 * 资产ID集合（SOC）
	 * @return 资产ID集合（SOC）
	 */
	public List<Integer> getEiid_list();
	
	public String getSreilabel_q();
	
	public String getSrname_q();
	
	/**
	 * 资产模型id取得
	 *
	 * @return eid_q 资产模型id
	 */
	
	public String getEid_q();
	
	public String getCiversion();
}
