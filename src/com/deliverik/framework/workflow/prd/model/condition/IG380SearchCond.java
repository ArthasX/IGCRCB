package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * 流程类型定义信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>流程类型定义ID</td>
 * </tr>
 * <tr>
 * <td>ptid</td>
 * <td>流程模板ID</td>
 * </tr>
 * <tr>
 * <td>pdname</td>
 * <td>流程类型定义名称</td>
 * </tr> 
 * <tr>
 * <td>pdstatus</td>
 * <td>流程类型定义状态（a:启用，i:停用）</td>
 * </tr> 
 * <tr>
 * <td>notSelfPd</td>
 * <td>流程模板ID（不匹配）</td>
 * </tr> 
 * </table>
 * </p>
 * 
 */
public interface IG380SearchCond {
	
	/**
	 * 流程类型定义ID取得
	 * @return 流程类型定义ID
	 */
	public String getPdid();

	/**
	 * 流程模板ID取得
	 * @return 流程模板ID
	 */
	public Integer getPtid();

	/**
	 * 流程类型定义名称取得
	 * @return 流程类型定义名称
	 */
	public String getPdname();

	/**
	 * 流程类型定义状态（a启用，i停用）取得
	 * @return 流程类型定义状态
	 */
	public String getPdstatus();

	/**
	 * 流程模板ID（不匹配）取得
	 * @return 流程模板ID
	 */
	public Integer getNotSelfPd();
	
	/**
	 * 根据流程ID取得自定义流程和标准流程ID
	 * @return 流程模板ID
	 */
	public Integer[] getPrTypeArray();
	
	/**
	 * 流程状态数组
	 * @return 流程状态数组
	 */
	public String[] getPdstatuses();
	
	/**
	 * 流程日志权限取得
	 * @return 流程日志权限
	 */
	public String getPermission();
	
	/**
	 * 流程类型定义ID取得
	 * 
	 * @return 流程类型定义ID
	 */
	public String getPdid_like();
	
    /**
     * 一组流程记录流程类型ID模糊查询
     */
	public String[] getPrpdid_like_or();
	public String[] getPdid_in();
	public String[] getPdid_not_in();
	
	/**
     * 流程发布位置菜单取得
     * @return  流程发布位置菜单  
     */
    public String getActname();
	
}
