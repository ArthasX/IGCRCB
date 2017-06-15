package com.deliverik.infogovernor.dbm.model.condition;

public interface IncidentTendencySearchCond {

	public abstract String getItyear();

	public abstract String getItmonth();

	public abstract String getItday();

	public abstract String getItdefid();

	public abstract String getItdefiname();

	public abstract int getItamount();

	public abstract int getIttimelyamount();

	public abstract int getItaveragetime();

	public abstract double getItrate();

	public abstract String getItcreateTime();

	public abstract String getItcreateYear();

	public abstract String getItcreateMonth();

	public abstract String getItcreateDay();

}