package com.deliverik.infogovernor.sym.model;

public interface SMSLog {

	/**
	 * ����ID
	 * **/
	public abstract Integer getSid();

	/**
	 * �ֻ�����
	 * **/
	public abstract String getTelnumber();
	
	/**
	 * ��������
	 * **/
	public abstract String getSmstext();
	
	/**
	 * ����ʱ��
	 * **/
	public abstract String getCtime();
	
	/**
	 * ����ʱ��
	 * **/
	public abstract String getUtime();
	
	/**
	 * ���ʹ���
	 * **/
	public abstract Integer getSendcount();
	
	/**
	 * ����״̬
	 * **/
	public abstract String getSendstatus();

}