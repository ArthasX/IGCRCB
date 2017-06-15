package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>
 * 流程参与用户信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>prid</td>
 * <td>流程记录ID</td>
 * </tr>
 * <tr>
 * <td>pproleid</td>
 * <td>流程参与用户角色ID</td>
 * </tr>
 * <tr>
 * <td>ppuserid</td>
 * <td>流程参与用户ID</td>
 * </tr>
 * <tr>
 * <td>ppinittime</td>
 * <td>流程参与用户指定时间</td>
 * </tr>
 * <tr>
 * <td>ppproctime</td>
 * <td>流程参与用户处理完成时间</td>
 * </tr>
 * <tr>
 * <td>ppstatus_q</td>
 * <td>流程参与用户的参与状态</td>
 * </tr>
 * <tr>
 * <td>ppsubstatus</td>
 * <td>流程参与用户子状态</td>
 * </tr>
 * <tr>
 * <td>ppuserinfo</td>
 * <td>流程参与用户信息</td>
 * </tr>
 * <tr>
 * <td>ppuseridIsNull</td>
 * <td>流程参与用户判断标识（Y判断流程参与用户是否为空，N判断流程参与用户是否不为空）</td>
 * </tr>
 * <tr>
 * <td>ppproctimeIsNull</td>
 * <td>流程参与用户处理完成标识（Y判断流程参与用户处理完成时间是否为空，N判断流程参与用户处理完成时间是否不为空）</td>
 * </tr>
 * <tr>
 * <td>ppidInList</td>
 * <td>流程参与用户信息ID区间检索条件（检索流程参与用户信息ID处于该区间中的流程参与用户信息）</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG337SearchCond {
	
	

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();

	/**
	 * 流程参与用户角色ID取得
	 * @return 流程参与用户角色ID
	 */
	public Integer getPproleid();

	/**
	 * 流程参与用户ID取得
	 * @return 流程参与用户ID
	 */
	public String getPpuserid();

	/**
	 * 流程参与用户指定时间取得
	 * @return 流程参与用户指定时间
	 */
	public String getPpinittime();

	/**
	 * 流程参与用户处理完成时间取得
	 * @return 流程参与用户处理完成时间
	 */
	public String getPpproctime();

	/**
	 * 流程参与用户的参与状态取得
	 * @return 流程参与用户的参与状态
	 */
	public String getPpstatus_q();
	

	/**
	 * 流程参与用户子状态取得
	 * @return 流程参与用户子状态
	 */
	public String getPpsubstatus();

	/**
	 * 流程参与用户信息取得
	 * @return 流程参与用户信息
	 */
	public String getPpuserinfo();
	
	/**
	 * 流程参与用户判断标识（Y判断流程参与用户是否为空，N判断流程参与用户是否不为空）取得
	 * @return 流程参与用户判断标识
	 */
	public String getPpuseridIsNull();
	
	/**
	 * 流程参与用户信息ID区间检索条件取得
	 * @return 流程参与用户信息ID区间检索条件
	 */
	public List<Integer> getPpidInList();
	
	/**
	 * 流程参与用户处理完成标识（Y判断流程参与用户处理完成时间是否为空，N判断流程参与用户处理完成时间是否不为空）取得
	 * @return 流程参与用户处理完成标识
	 */
	public String getPpproctimeIsNull();
	
	/**
	 * 流程参与用户的参与状态取得（平台保留）
	 * @return 流程参与用户的参与状态
	 */
	public String getPpstatus();
	
	/**
	 * 流程的所有参与者是否都是指定用户检索条件取得（平台保留）
	 * @return 流程的所有参与者是否都是指定用户检索条件
	 */
	public String getPpuserid_not();

	//====>130225Begin
	
	/**
	 * 参与人所属机构精确查询取得
	 *
	 * @return pporgid_eq 参与人所属机构精确查询
	 */
	public String getPporgid_eq();
	//====>130225End

	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid();

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum();
	
	/**
	 * 是否已经确认（1是null，0是有值）取得
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull();
}
