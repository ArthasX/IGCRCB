/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.dbm.model.condition;


/**
 * 
 * @Description:事件趋势统计信息表Cond类
 * @Author
 * @History
 * @Version V1.0
 */

public class IncidentTendencySearchCondImpl implements IncidentTendencySearchCond{
	
	/**统计年**/
	private String ityear;

	/**统计月**/
	private String itmonth;

	/**统计日**/
	private String itday;

	/**事件分类ID**/
	private String itdefid;
	
	/**事件分类名称**/
	private String itdefiname;
	
	/**事件分类名称**/
	private int itamount;
	
	/**事件及时解决数量**/
	private int ittimelyamount;
	
	/**事件平均解决时间（分钟数）**/
	private int itaveragetime;;
	
	/**事件及时解决率**/
	private double itrate;

	/**创建时间**/
	private String itcreateTime;
	
	/**创建年**/
	private String itcreateYear;
	
	/**创建月**/
	private String itcreateMonth;
	
	/**创建日**/
	private String itcreateDay;


	public String getItyear() {
		return ityear;
	}

	public void setItyear(String ityear) {
		this.ityear = ityear;
	}

	public String getItmonth() {
		return itmonth;
	}

	public void setItmonth(String itmonth) {
		this.itmonth = itmonth;
	}

	public String getItday() {
		return itday;
	}

	public void setItday(String itday) {
		this.itday = itday;
	}

	public String getItdefid() {
		return itdefid;
	}

	public void setItdefid(String itdefid) {
		this.itdefid = itdefid;
	}

	public String getItdefiname() {
		return itdefiname;
	}

	public void setItdefiname(String itdefiname) {
		this.itdefiname = itdefiname;
	}

	public int getItamount() {
		return itamount;
	}

	public void setItamount(int itamount) {
		this.itamount = itamount;
	}

	public int getIttimelyamount() {
		return ittimelyamount;
	}

	public void setIttimelyamount(int ittimelyamount) {
		this.ittimelyamount = ittimelyamount;
	}

	public int getItaveragetime() {
		return itaveragetime;
	}

	public void setItaveragetime(int itaveragetime) {
		this.itaveragetime = itaveragetime;
	}

	public double getItrate() {
		return itrate;
	}

	public void setItrate(double itrate) {
		this.itrate = itrate;
	}

	public String getItcreateTime() {
		return itcreateTime;
	}

	public void setItcreateTime(String itcreateTime) {
		this.itcreateTime = itcreateTime;
	}

	public String getItcreateYear() {
		return itcreateYear;
	}

	public void setItcreateYear(String itcreateYear) {
		this.itcreateYear = itcreateYear;
	}

	public String getItcreateMonth() {
		return itcreateMonth;
	}

	public void setItcreateMonth(String itcreateMonth) {
		this.itcreateMonth = itcreateMonth;
	}

	public String getItcreateDay() {
		return itcreateDay;
	}

	public void setItcreateDay(String itcreateDay) {
		this.itcreateDay = itcreateDay;
	}

}

