package com.deliverik.framework.workflow.prr.model.condition;


/**
 * <p>
 * 流程变量信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>prid</td>
 * <td>流程记录ID</td>
 * </tr>
 * <tr>
 * <td>pdid</td>
 * <td>流程定义ID</td>
 * </tr>
 * <tr>
 * <td>pivarname</td>
 * <td>流程变量标识</td>
 * </tr>
 * <tr>
 * <td>pivartype</td>
 * <td>流程变量类型</td>
 * </tr>
 * <tr>
 * <td>userid</td>
 * <td>用户ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG599SearchCond {
	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();
	
	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid();
	
	/**
	 * 流程变量标识取得
	 * @return 流程变量标识
	 */
	public String getPivarname();
	
	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPivartype();
	
	/**
	 * 流程变量标识
	 */
	public String getPivarlabel();
	
	/**
	 * 流程变量值
	 */
	public String getPivarvalue();

	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid();

}
