/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.dbm.model.condition;


/**
 * 
 * @Description:�¼�����ͳ����Ϣ��Cond��
 * @Author
 * @History
 * @Version V1.0
 */

public class IncidentTendencySearchCondImpl implements IncidentTendencySearchCond{
	
	/**ͳ����**/
	private String ityear;

	/**ͳ����**/
	private String itmonth;

	/**ͳ����**/
	private String itday;

	/**�¼�����ID**/
	private String itdefid;
	
	/**�¼���������**/
	private String itdefiname;
	
	/**�¼���������**/
	private int itamount;
	
	/**�¼���ʱ�������**/
	private int ittimelyamount;
	
	/**�¼�ƽ�����ʱ�䣨��������**/
	private int itaveragetime;;
	
	/**�¼���ʱ�����**/
	private double itrate;

	/**����ʱ��**/
	private String itcreateTime;
	
	/**������**/
	private String itcreateYear;
	
	/**������**/
	private String itcreateMonth;
	
	/**������**/
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

