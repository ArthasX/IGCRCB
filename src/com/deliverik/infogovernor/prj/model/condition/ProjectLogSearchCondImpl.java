package com.deliverik.infogovernor.prj.model.condition;

/**
 * 概述: projectlog表检索条件实现
 * 功能描述: projectlog表检索条件实现
 * 创建记录: 2012/04/19
 * 修改记录: 
 */
public class ProjectLogSearchCondImpl implements ProjectLogSearchCond {

	protected Integer pid;
	/**日志结束时间*/
	protected String pltime_to;
	/**日志开始时间*/
	protected String pltime_from;
	/**日志内容*/
	protected String plinfo;
	/**日志类型*/
	protected String pltype;
	/**日志类型不为空*/
	protected String pltype_ne;
	
	
	/**
	 * pid取得
	 * @return pid
	 *
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * pid设定
	 * @param pid
	 *
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 日志开始时间取得
	 * @return pltime_from
	 */
	public String getPltime_from() {
		return pltime_from;
	}
	/**
	 * 日志开始时间设定
	 * @param pltime_from
	 */
	public void setPltime_from(String pltime_from) {
		this.pltime_from = pltime_from;
	}
	/**
	 * 日志结束时间取得
	 * @return pltime_to
	 */
	public String getPltime_to() {
		return pltime_to;
	}
	/**
	 * 日志结束时间设定
	 * @param pltime_to
	 */
	public void setPltime_to(String pltime_to) {
		this.pltime_to = pltime_to;
	}
	/**
	 * 日志内容取得
	 * @return plinfo
	 */
	public String getPlinfo() {
		return plinfo;
	}
	/**
	 * 日志内容设定
	 * @param plinfo
	 */
	public void setPlinfo(String plinfo) {
		this.plinfo = plinfo;
	}
	/**
	 * 日志类型取得
	 * @return pltype
	 */
	public String getPltype() {
		return pltype;
	}
	/**
	 * 日志类型设定
	 * @param pltype
	 */
	public void setPltype(String pltype) {
		this.pltype = pltype;
	}
	/**
	 * 日志类型不为空取得
	 * @return pltype_ne
	 */
	public String getPltype_ne() {
		return pltype_ne;
	}
	/**
	 * 日志类型不为空设定
	 * @param pltype_ne
	 */
	public void setPltype_ne(String pltype_ne) {
		this.pltype_ne = pltype_ne;
	}
	
	
}
