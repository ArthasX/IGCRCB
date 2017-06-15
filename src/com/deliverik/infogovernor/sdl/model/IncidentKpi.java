/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_统计汇总_事件kpi信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IncidentKpi {

	/**
	 * 获取类别ID
	 * @return 类别Id
	 */
	public abstract String getTypeId();
	/**
	 * 获取类别名称
	 * @return 类别名称
	 */
	public abstract String getTypeName();
	/**
	 * 获取类别层次码
	 * @return 类别层次码
	 */
	public abstract String getSyscoding();

	/**
	 * 获取紧急程度
	 * @return 紧急程度
	 */
	public abstract String getUrgency();
	/**
	 * 获取紧急程度名称
	 * @return 紧急程度名称
	 */
	public abstract String getUrgencyName();
	
	/**
	 * 获取平均解决时间
	 * @return 平均解决时间
	 */
	public abstract Float getResolve();

}