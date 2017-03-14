package com.deliverik.infogovernor.dbm.model;

public interface IncidentTendency {

	/**
	 * @return the ityear
	 */
	public abstract String getItyear();

	/**
	 * @return the itmonth
	 */
	public abstract String getItmonth();

	/**
	 * @return the itday
	 */
	public abstract String getItday();

	/**
	 * @return the itamount
	 */
	public abstract int getItamount();


	/**
	 * @return the itaveragetime
	 */
	public abstract int getItaveragetime();

	/**
	 * @return the fingerprint
	 */
	public abstract String getFingerprint();

}