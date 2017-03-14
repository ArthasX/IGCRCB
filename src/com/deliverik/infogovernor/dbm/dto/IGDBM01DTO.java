/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.dbm.dto;


import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;

public class IGDBM01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/*银联成率柱图*/
	protected List<Integer> pillerYL;
	
	/*地图信息*/
	protected String maps;
	
	/*地图名称*/
	protected String mapname;
	
	/*银联成功率仪表*/
	protected int meter;
	
	/*日历年份*/
	protected int year ;
		
	/*日历月份*/
	protected int month;
	
	/*相关事件*/
	protected int somethings;
	
	/*相关问题*/
	protected int somequestion;
	
	/*监视器控件*/
	protected String monitor;
	
	/*返回一切需要xml流的字符串*/
	protected String resultXML;
	
	/*当前工作* 数据格式   "事件数量,问题数量,变更数量,工作数量"*/
	protected String currentWork; 
	
	protected User user;

	public List<Integer> getPillerYL() {
		return pillerYL;
	}

	public void setPillerYL(List<Integer> pillerYL) {
		this.pillerYL = pillerYL;
	}

	public String getMaps() {
		return maps;
	}

	public void setMaps(String maps) {
		this.maps = maps;
	}

	public String getMapname() {
		return mapname;
	}

	public void setMapname(String mapname) {
		this.mapname = mapname;
	}

	public int getMeter() {
		return meter;
	}

	public void setMeter(int meter) {
		this.meter = meter;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getResultXML() {
		return resultXML;
	}
	public void setResultXML(String resultXML) {
		this.resultXML = resultXML;
	}
	public int getSomethings() {
		return somethings;
	}
	public void setSomethings(int somethings) {
		this.somethings = somethings;
	}
	public int getSomequestion() {
		return somequestion;
	}
	public void setSomequestion(int somequestion) {
		this.somequestion = somequestion;
	}

	public String getCurrentWork() {
		return currentWork;
	}

	public void setCurrentWork(String currentWork) {
		this.currentWork = currentWork;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}