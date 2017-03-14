/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.model;



/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 业务系统可用性显示
 * </p>
 * 
 * @version 1.0
 */
public interface BussinessAvailval {

	/**
	 * 业务系统名称
	 * @return 业务系统名称
	 */
	public String getGname();
	/**
	 * 业务系统可用性
	 * @return 业务系统名称
	 */
	public String getAvailval();

}