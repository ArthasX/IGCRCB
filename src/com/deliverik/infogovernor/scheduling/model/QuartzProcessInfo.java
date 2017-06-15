package com.deliverik.infogovernor.scheduling.model;

import com.deliverik.framework.base.BaseModel;

public interface QuartzProcessInfo  extends BaseModel {

	public abstract Integer getQpiid();

	public abstract Integer getQprid();

	public abstract String getQpivarname();

	public abstract String getQpivartype();
	
	public abstract String getQpivarlabel();

	public abstract String getQpivarvalue();

	public abstract String getQpiattkey();
	
	public abstract String getQpidid();
	
	public abstract String getQpidmode();
	
	public abstract String getQprivatescope();
	
	public abstract String getQpidcomment();
	
	/**
	 * 参与者具有的流程变量权限取得
	 * @return 参与者具有的流程变量权限
	 */
	public abstract String getQpidaccess();
}