package com.deliverik.infogovernor.sym.model.condition;

public interface SMSLogSearchCond {

	/**主键ID**/
	public abstract Integer getSid();

	/**手机号码**/
	public abstract String getTelnumber();

	/**短信内容**/
	public abstract String getSmstext();

	/**创建时间开始**/
	public abstract String getS_ctime();

	/**创建时间结束**/
	public abstract String getE_ctime();
	
	/**更新时间开始**/
	public abstract String getS_utime();

	/**更新时间结束**/
	public abstract String getE_utime();
	
	/**发送次数大于**/
	public abstract Integer getGt_sendcount();
	
	/**发送次数小于**/
	public abstract Integer getLt_sendcount();

	/**发送状态**/
	public abstract String getSendstatus();

}