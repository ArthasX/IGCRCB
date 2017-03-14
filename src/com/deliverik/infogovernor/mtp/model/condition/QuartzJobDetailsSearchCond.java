package com.deliverik.infogovernor.mtp.model.condition;


/**
 * <p>
 * 日常运维计划信息检索条件
 * </p>
 */
public interface QuartzJobDetailsSearchCond {
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
}
