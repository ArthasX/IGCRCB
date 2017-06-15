/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.dbm.model.condition;



/**
 * 
 * @Description:变更趋势统计表实体查询条件Cond类
 * @Author
 * @History
 * @Version V1.0
 */

public class ChangeTendencySearchCondImpl implements ChangeTendencySearchCond{
	
	/**统计年**/
	private String ctyear;
	
	/**统计月**/
	private String ctmonth;
	
	/**统计日**/
	private String ctday;
	
	/**变更类型ID**/
	private String cttypeid;
	
	/**变更类型名**/
	private String cttypecname;
	
	/**变更数量（已关闭）**/
	private int ctamount;
	
	/**变更分类占比**/
	private double ctpercent;
	
	/**变更成功数量**/
	private int ctsucAmount;
	
	/**变更失败数量**/
	private int ctfailAmount;
	
	/**变更存在问题数量**/
	private String ctprobAmount;
	
	/**变更成功率**/
	private Double ctsucRate;
	
	/**创建时间**/
	private String ctcreateTime;
	
	/**创建年**/
	private String ctcreateYear;
	
	/**创建月**/
	private String ctcreateMonth;
	
	/**创建日**/
	private String ctcreateDay;
	
	/**时间戳**/
	private String Fingerprint;


	public String getCtyear() {
		return ctyear;
	}

	public void setCtyear(String ctyear) {
		this.ctyear = ctyear;
	}

	public String getCtmonth() {
		return ctmonth;
	}

	public void setCtmonth(String ctmonth) {
		this.ctmonth = ctmonth;
	}

	public String getCtday() {
		return ctday;
	}

	public void setCtday(String ctday) {
		this.ctday = ctday;
	}

	public String getCttypeid() {
		return cttypeid;
	}

	public void setCttypeid(String cttypeid) {
		this.cttypeid = cttypeid;
	}

	public String getCttypecname() {
		return cttypecname;
	}

	public void setCttypecname(String cttypecname) {
		this.cttypecname = cttypecname;
	}

	public int getCtamount() {
		return ctamount;
	}

	public void setCtamount(int ctamount) {
		this.ctamount = ctamount;
	}

	public double getCtpercent() {
		return ctpercent;
	}

	public void setCtpercent(double ctpercent) {
		this.ctpercent = ctpercent;
	}

	public int getCtsucAmount() {
		return ctsucAmount;
	}

	public void setCtsucAmount(int ctsucAmount) {
		this.ctsucAmount = ctsucAmount;
	}

	public int getCtfailAmount() {
		return ctfailAmount;
	}

	public void setCtfailAmount(int ctfailAmount) {
		this.ctfailAmount = ctfailAmount;
	}

	public String getCtprobAmount() {
		return ctprobAmount;
	}

	public void setCtprobAmount(String ctprobAmount) {
		this.ctprobAmount = ctprobAmount;
	}

	public Double getCtsucRate() {
		return ctsucRate;
	}

	public void setCtsucRate(Double ctsucRate) {
		this.ctsucRate = ctsucRate;
	}

	public String getCtcreateTime() {
		return ctcreateTime;
	}

	public void setCtcreateTime(String ctcreateTime) {
		this.ctcreateTime = ctcreateTime;
	}

	public String getCtcreateYear() {
		return ctcreateYear;
	}

	public void setCtcreateYear(String ctcreateYear) {
		this.ctcreateYear = ctcreateYear;
	}

	public String getCtcreateMonth() {
		return ctcreateMonth;
	}

	public void setCtcreateMonth(String ctcreateMonth) {
		this.ctcreateMonth = ctcreateMonth;
	}

	public String getCtcreateDay() {
		return ctcreateDay;
	}

	public void setCtcreateDay(String ctcreateDay) {
		this.ctcreateDay = ctcreateDay;
	}

	public String getFingerprint() {
		return Fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		Fingerprint = fingerprint;
	}
}

