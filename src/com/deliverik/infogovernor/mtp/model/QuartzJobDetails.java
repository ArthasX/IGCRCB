/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : SOC
 * </p>
 * <p>
 * Description: 日常运维计划信息接口
 * </p>
 * 
 * @author duchong@deliverik.com
 */

public interface QuartzJobDetails  extends BaseModel {

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Integer getQjdid();

	/**
	 * 获取运维任务主键
	 * @return 主键
	 */
	public Integer getQjid();

	/**
	 * 获取执行时间
	 * @return 执行时间
	 */
	public String getQjdtime();

	/**
	 * 获取星期几
	 * @return 星期几
	 */
	public String getQjdweek();

	/**
	 * 获取执行状态
	 * @return 执行状态
	 */
	public String getQjdtype();

	/**
	 * 获取触发器名称
	 * @return 触发器名称
	 */
	public String getQjdtriname();

	/**
	 * 获取触发器所属组的名称
	 * @return 触发器所属组的名称
	 */
	public String getQjdtrigrpname();
}