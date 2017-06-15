package com.deliverik.infogovernor.dbm.model.condition;

public interface ChangeTendencySearchCond {

	public abstract String getCtyear();

	public abstract String getCtmonth();

	public abstract String getCtday();

	public abstract String getCttypeid();

	public abstract String getCttypecname();

	public abstract int getCtamount();

	public abstract double getCtpercent();

	public abstract int getCtsucAmount();

	public abstract int getCtfailAmount();

	public abstract String getCtprobAmount();

	public abstract Double getCtsucRate();

	public abstract String getCtcreateTime();

	public abstract String getCtcreateYear();

	public abstract String getCtcreateMonth();

	public abstract String getCtcreateDay();

	public abstract String getFingerprint();

}