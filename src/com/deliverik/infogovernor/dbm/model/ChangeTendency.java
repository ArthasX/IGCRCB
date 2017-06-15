package com.deliverik.infogovernor.dbm.model;

import com.deliverik.framework.base.BaseModel;

public interface ChangeTendency extends BaseModel{

	public abstract String getCtyear();

	public abstract String getCtmonth();

	public abstract String getCtday();

	public abstract int getCtamount();

	public abstract double getCtsucRate();

	public abstract String getFingerprint();

}