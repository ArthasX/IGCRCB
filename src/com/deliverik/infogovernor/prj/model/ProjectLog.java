package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;

public interface ProjectLog  extends BaseModel {

	public abstract Integer getPlid();

	public abstract Integer getPid();

	public abstract Integer getPlroleid();

	public abstract String getPlrolename();

	public abstract String getPluserid();

	public abstract String getPlusername();

	public abstract String getPlinfo();

	public abstract String getPltype();

	public abstract String getPltime();

	public abstract String getPlattkey();

}