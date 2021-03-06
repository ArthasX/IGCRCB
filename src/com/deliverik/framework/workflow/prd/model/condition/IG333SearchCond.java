/*
 * ±±?????????í??????????????°??¨?ù????±????ù???¨????
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>
 * ?÷??×??????÷????
 * </p>
 * <p>
 * ?¨?????÷?????????¨±???????)<br>
 * <table border="1">
 * <tr>
 * <td>pdid</td>
 * <td>?÷??????ID</td>
 * </tr>
 * <tr>
 * <td>psdid</td>
 * <td>?÷??×???ID</td>
 * </tr>
 * <tr>
 * <td>psdname</td>
 * <td>?÷??×???????</td>
 * </tr>
 * <tr>
 * <td>psdcode</td>
 * <td>?÷??×???±ê??</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG333SearchCond {
	/**
	 * ?÷??×???ID????
	 * @return ?÷??×???ID
	 */
	public String getPsdid();
	
	/**
	 * ?÷??????ID????
	 * @return ?÷??????ID
	 */
	public String getPdid();

	/**
	 * ?÷??×???????????
	 * @return ?÷??×???????
	 */
	public String getPsdname();
	
	/**
	 * ?÷??×???±ê??????
	 * @return ?÷??×???±ê??
	 */
	public String getPsdcode();
	
	/**
	 * ?÷????????????????±ê??????
	 * @return ?÷????????????????±ê??
	 */
	public String getPsdflag();
	
	/**
	 * ????????ID????
	 * 
	 * @return ????????ID
	 */
	public String getAssignpsdid();

	/**
	 * ????°???ID????
	 * 
	 * @return ????°???ID
	 */
	public String getAssignpbdid();
	
	/**
	 * ??°ü????±?×???
	 * 
	 * @return 
	 */
	public String getNotContainEndStatus();
	
	/**
	 * ??°ü??±??í×???
	 * 
	 * @return 
	 */
	public String getNotContainSelf();
	
	/**
	 * ??°ü??????×???
	 * 
	 * @return 
	 */
	public String getNotContainStartStatus();
	
	public String getPsdtype();
	public String getPsdmode();
	
	/**
	 * ?÷??×???ID????
	 * 
	 * @return ?÷??×???ID
	 */
	public String getPsdid_like();
	
	/**
     * ±í??????????±ê??????
     * @return ±í??????????±ê??
     */
	public String getFormGlobalControl() ;

	/**
	 * ????×???ID????
	 * @return ????×???ID
	 */
	public String getPpsdid();

	/**
	 * @return the fatherflag
	 */
	public String getFatherflag();

	public String getBysequence();
	
	public String getOrderField();

	public String getSubpsdtype();
	/**
	 * @return the 流程名称ID(应急管理专用)
	 */
	public String getPdid_like();
	/**  
	 * 获取获取前节点  
	 * @return fingerprint 获取前节点  
	 */
	
	public String getFingerprint();
	
	/**  
	 * 获取应急流程标识  
	 * @return drmSign 
	 */
	public String getDrmSign();
}
