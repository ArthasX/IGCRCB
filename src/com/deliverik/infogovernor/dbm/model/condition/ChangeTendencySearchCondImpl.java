/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.dbm.model.condition;



/**
 * 
 * @Description:�������ͳ�Ʊ�ʵ���ѯ����Cond��
 * @Author
 * @History
 * @Version V1.0
 */

public class ChangeTendencySearchCondImpl implements ChangeTendencySearchCond{
	
	/**ͳ����**/
	private String ctyear;
	
	/**ͳ����**/
	private String ctmonth;
	
	/**ͳ����**/
	private String ctday;
	
	/**�������ID**/
	private String cttypeid;
	
	/**���������**/
	private String cttypecname;
	
	/**����������ѹرգ�**/
	private int ctamount;
	
	/**�������ռ��**/
	private double ctpercent;
	
	/**����ɹ�����**/
	private int ctsucAmount;
	
	/**���ʧ������**/
	private int ctfailAmount;
	
	/**���������������**/
	private String ctprobAmount;
	
	/**����ɹ���**/
	private Double ctsucRate;
	
	/**����ʱ��**/
	private String ctcreateTime;
	
	/**������**/
	private String ctcreateYear;
	
	/**������**/
	private String ctcreateMonth;
	
	/**������**/
	private String ctcreateDay;
	
	/**ʱ���**/
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

