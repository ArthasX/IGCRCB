/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程参与者检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>psdid</td>
 * <td>流程状态ID</td>
 * </tr>
 * <tr>
 * <td>ppdid</td>
 * <td>流程参与者ID</td>
 * </tr>
 * <tr>
 * <td>roleid</td>
 * <td>流程参与者角色ID</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG222SearchCond {
	/**
	 * 流程参与者ID取得
	 * @return 流程参与者ID
	 */
	public String getPpdid();
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程参与者角色ID取得
	 * @return 流程参与者角色ID
	 */
	public Integer getRoleid();

	/**
	 * 流程参与者批准取得
	 * @return 流程参与者批准
	 */
	public String getPpapprove();
	
	/**
	 * 流程参与者驳回取得
	 * @return 流程参与者驳回
	 */
	public String getPpdeny();
	
	/**
	 * 流程参与者提交取得
	 * @return 流程参与者提交
	 */
	public String getPpsubmit();
	
	/**
	 * 流程参与者中止取得
	 * @return 流程参与者中止
	 */
	public String getPpterm();
	
	/**
	 * 流程参与者更新取得
	 * @return 流程参与者更新
	 */
	public String getPpupdate();
	
	public String getPdid();

	public Integer getPrid();

	/**
	 * 流程参与者ID取得
	 * 
	 * @return 流程参与者ID
	 */
	public String getPpdid_like();
	
	/**
	 * 是否按机构取得 
	 * @return 是否按机构
	 */
	public String getIsOrg();
	
}
