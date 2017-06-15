/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 功能： 人员工作统计
 * @author yukexin 2014-8-7 16:19:26
 */
public interface IGCRC2101VWInfo extends BaseModel{
	/**
	 * 主键取得
	 * @return userID  主键
	 */
	public String getUserID();
	/**
	 * 人员名字取得
	 * @return userName  人员名字
	 */
	public String getUserName();
	/**
	 * 事件个数取得
	 * @return incidentNum  事件个数
	 */
	public Integer getIncidentNum();
	/**
	 * 问题个数取得
	 * @return problemNum  问题个数
	 */
	public Integer getProblemNum();
	/**
	 * 变更个数取得
	 * @return changeNum  变更个数
	 */
	public Integer getChangeNum();
	/**
	 * 服务请求个数取得
	 * @return serviceNum  服务请求个数
	 */
	public Integer getServiceNum();
	/**
	 * 服务请求个数取得
	 * @return developNum  服务请求个数
	 */
	public Integer getDevelopNum();
	
}
