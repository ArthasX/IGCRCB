package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程模板信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>ptid</td>
 * <td>流程模板ID</td>
 * </tr>
 * <tr>
 * <td>ptname</td>
 * <td>流程模板名称</td>
 * </tr>
 * <tr>
 * <td>pttype</td>
 * <td>流程模板类型</td>
 * </tr>
 * <tr>
 * <td>ptstatus</td>
 * <td>流程模板状态（a:启用，i:停用）</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG259SearchCond {
	
	/**
	 * 流程模板ID取得
	 * @return 流程模板ID
	 */
	public Integer getPtid();

	/**
	 * 流程模板名称取得
	 * @return 流程模板名称
	 */
	public String getPtname();

	/**
	 * 流程模板类型取得
	 * @return 流程模板类型
	 */
	public String getPttype();
	/**
	 * 流程模板状态（a启用，i停用）取得
	 * @return 流程模板状态
	 */
	public String getPtstatus();

	/**
	 * 流程模板使用位置标识（平台保留）取得
	 * @return 流程模板使用位置标识
	 */
	public String getPtqrtzflag();
	
	/**
	 * 流程模板类型是否为工作（平台保留）取得
	 * @return 流程模板类型是否为工作
	 */
	public int getIsWorkPt();
	
	/**
	 * 流程状态数组
	 * @return 流程状态数组
	 */
	public String[] getPtstatuses();


}
