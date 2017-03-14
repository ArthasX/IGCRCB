package com.deliverik.infogovernor.fin.model;

import com.deliverik.framework.base.BaseModel;

public interface Expense  extends BaseModel {

	public abstract Integer getExid();

	public abstract Integer getBid();

	public abstract String getExdesc();

	public abstract Double getExamount();

	public abstract String getExinfo();

	public abstract String getExstatus();

	public abstract String getExreqid();

	public abstract String getExreqname();

	public abstract String getExinittime();

	public abstract String getExopentime();

	public abstract String getExapvid();

	public abstract String getExapvname();

	public abstract String getExclosetime();

	public abstract String getExattkey();

	public abstract String getExeiinfo();

	public abstract String getExprinfo();

	public abstract String getExpinfo();

	public abstract String getExorginfo();
	
	public abstract String getBtitle();

}