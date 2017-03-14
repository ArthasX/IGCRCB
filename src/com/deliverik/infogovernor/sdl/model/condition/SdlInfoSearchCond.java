/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_服务水平信息查询MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlInfoSearchCond {
	
	/**
	 * 获取类别
	 * 
	 * @return 类别
	 */
	public String getSitype();

	/**
	 * 获取开始时间
	 * 
	 * @return 开始时间
	 */
	public String getSibegin();
	
	/**
	 * 获取结束时间
	 * 
	 * @return 结束时间
	 */
	public String getSiend();

	/**
	 * 获取相关资产ID
	 * 
	 * @return 相关资产ID
	 */
	public Integer getSieiid();

	/**
	 * 获取相关流程ID
	 * 
	 * @return 相关流程ID
	 */
	public Integer getSiprid();
	
	/**
	 * 获取评分
	 * 
	 * @return 评分
	 */
	public String getSimark();

}
