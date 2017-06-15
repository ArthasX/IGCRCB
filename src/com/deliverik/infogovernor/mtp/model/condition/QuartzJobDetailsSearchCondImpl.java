package com.deliverik.infogovernor.mtp.model.condition;

/**
 * 日常运维计划信息检索条件实现
 */
public class QuartzJobDetailsSearchCondImpl implements QuartzJobDetailsSearchCond {

	/**QuartzJoss表主键*/
	protected Integer qjid;

	/**执行时间*/
	protected String qjdtime;

	/**星期几 */
	protected String qjdweek;

	/**执行状态（1已执行，0未执行） */
	protected String qjdtype;
	
	/**触发器名称*/
	protected String qjdtriname;
	
	/**
	 * 获取触发器名称
	 * @return 触发器名称
	 */
	public String getQjdtriname() {
		return qjdtriname;
	}

	/**
	 * 设置触发器名称
	 * @param qjdtriname 触发器名称
	 */
	public void setQjdtriname(String qjdtriname) {
		this.qjdtriname = qjdtriname;
	}

	/**
	 * 获取运维任务主键
	 * @return 主键
	 */
	public Integer getQjid() {
		return qjid;
	}

	/**
	 * 设置运维任务主键
	 * @param qjid 主键
	 */
	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}

	/**
	 * 获取执行时间
	 * @return 执行时间
	 */
	public String getQjdtime() {
		return qjdtime;
	}

	/**
	 * 设置执行时间
	 * @param qjdtime 执行时间
	 */
	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}

	/**
	 * 获取星期几
	 * @return 星期几
	 */
	public String getQjdweek() {
		return qjdweek;
	}

	/**
	 * 设置星期几
	 * @param qjdweek 星期几
	 */
	public void setQjdweek(String qjdweek) {
		this.qjdweek = qjdweek;
	}

	/**
	 * 获取执行状态
	 * @return 执行状态
	 */
	public String getQjdtype() {
		return qjdtype;
	}

	/**
	 * 设置执行状态
	 * @param qjdtype 执行状态
	 */
	public void setQjdtype(String qjdtype) {
		this.qjdtype = qjdtype;
	}
	
}
