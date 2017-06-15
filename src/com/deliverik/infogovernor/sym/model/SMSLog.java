package com.deliverik.infogovernor.sym.model;

public interface SMSLog {

	/**
	 * 主键ID
	 * **/
	public abstract Integer getSid();

	/**
	 * 手机号码
	 * **/
	public abstract String getTelnumber();
	
	/**
	 * 短信内容
	 * **/
	public abstract String getSmstext();
	
	/**
	 * 创建时间
	 * **/
	public abstract String getCtime();
	
	/**
	 * 更新时间
	 * **/
	public abstract String getUtime();
	
	/**
	 * 发送次数
	 * **/
	public abstract Integer getSendcount();
	
	/**
	 * 发送状态
	 * **/
	public abstract String getSendstatus();

}