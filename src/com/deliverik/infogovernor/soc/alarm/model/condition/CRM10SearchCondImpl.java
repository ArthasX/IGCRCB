/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM01检索条件实现
  * 功能描述: CRM01检索条件实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM10SearchCondImpl implements
		CRM10SearchCond {
	protected String ip="";//IP
	protected String get_StartTime="";//开始时间
    protected String get_EndTime="";//结束时间
    protected String  Tablename="";
    protected String nowCollecttime="";
	public String getNowCollecttime() {
		return nowCollecttime;
	}
	public void setNowCollecttime(String nowCollecttime) {
		this.nowCollecttime = nowCollecttime;
	}
	public String getTablename() {
		return Tablename;
	}
	public void setTablename(String tablename) {
		Tablename = tablename;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getGet_StartTime() {
		return get_StartTime;
	}
	public void setGet_StartTime(String get_StartTime) {
		this.get_StartTime = get_StartTime;
	}
	public String getGet_EndTime() {
		return get_EndTime;
	}
	public void setGet_EndTime(String get_EndTime) {
		this.get_EndTime = get_EndTime;
	}
	public String getSymType() {
		return SymType;
	}
	public void setSymType(String symType) {
		SymType = symType;
	}
	protected String SymType="";//设备类型
}