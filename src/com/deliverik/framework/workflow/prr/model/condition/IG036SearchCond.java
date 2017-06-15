package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>
 * 日志信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>prid</td>
 * <td>流程记录ID</td>
 * </tr>
 * <tr>
 * <td>rluserid</td>
 * <td>日志处理人ID</td>
 * </tr>
 * <tr>
 * <td>rlusername</td>
 * <td>日志处理人姓名</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG036SearchCond {
	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();

	/**
	 * 日志处理人ID取得
	 * @return 日志处理人ID
	 */
	public String getRluserid();
	
	/**
	 * 日志处理人姓名取得
	 * @return 日志处理人姓名
	 */
	public String getRlusername();
	
	/**
	 * 用户角色
	 * @return 用户角色
	 */
	public List<Integer> getRoleid();
	
	/**
	 * 用户角色排序标识
	 * @return 用户角色排序标识
	 */
	public boolean isRoleorder() ;
	
	/**
	 * 排除掉的日志类型
	 * @return 排除掉的日志类型
	 */
	public String getNotEqualrlType();
	
	/**
	 * 日志类型
	 * @return 日志类型
	 */
	public String getRlType();
	
	/**
	 * 流程状态编码取得
	 * @return 流程状态编码
	 */
	public String getPsdcode();
	
	/**
	 * 排序标识取得
	 * @return 排序标识
	 */
	public String getRoleorder_type();
	
	/**
	 * 角色负责人标识取得
	 * @return 角色负责人标识
	 */
	public String getRolemanger();

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();

	/**
	 * 流程状态分支编号取得
	 * @return 流程状态分支编号
	 */
	public Integer getPsdnum();

}
