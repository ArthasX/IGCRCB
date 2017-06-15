/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程状态跃迁规则检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>ptdname</td>
 * <td>流程状态跃迁规则名称</td>
 * </tr>
 * <tr>
 * <td>ptdtype</td>
 * <td>流程状态跃迁规则类型</td>
 * </tr>
 * <tr>
 * <td>ptdcond</td>
 * <td>流程状态跃迁条件</td>
 * </tr>
 * <tr>
 * <td>ptdcond_like</td>
 * <td>流程状态跃迁条件（模糊匹配）</td>
 * </tr>
 * <tr>
 * <td>fpsdid</td>
 * <td>流程状态ID（From）</td>
 * </tr>
 * <tr>
 * <td>tpsdid</td>
 * <td>流程状态ID（To）</td>
 * </tr>
 * <tr>
 * <td>defaultRule</td>
 * <td>流程状态缺省跃迁条件</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG273SearchCond {
	/**
	 * 流程状态跃迁规则ID取得
	 * @return 流程状态跃迁规则ID
	 */
	public String getPtdid();
	
	/**
	 * 流程状态ID（From）取得
	 * @return 流程状态ID（From）
	 */
	public String getFpsdid();
	
	/**
	 * 流程状态ID（To）取得
	 * @return 流程状态ID（To）
	 */
	public String getTpsdid();

	/**
	 * 流程状态跃迁规则名称取得
	 * @return 流程状态跃迁规则名称
	 */
	public String getPtdname();
	
	/**
	 * 流程状态跃迁规则类型取得
	 * @return 流程状态跃迁规则类型
	 */
	public String getPtdtype();
	
	/**
	 * 流程状态跃迁条件取得
	 * @return 流程状态跃迁条件
	 */
	public String getPtdcond();
	
	/**
	 * 流程状态跃迁条件（模糊匹配）取得
	 * @return 流程状态跃迁条件
	 */
	public String getPtdcond_like();
	
	/**
	 * 流程状态缺省跃迁条件取得
	 * @return 流程状态缺省跃迁条件
	 */
	public boolean isDefaultRule();
	
	/**
	 * 流程状态非缺省跃迁条件取得
	 * @return 流程状态非缺省跃迁条件
	 */
	public boolean isNotDefaultRule();

	/**
	 * 流程参与者变量权限ID取得
	 * 
	 * @return 流程参与者变量权限ID
	 */
	public String getPtdid_like();
	
}
