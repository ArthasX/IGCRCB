package com.deliverik.infogovernor.sym.model.condition;

public interface SMSLogSearchCond {

	/**����ID**/
	public abstract Integer getSid();

	/**�ֻ�����**/
	public abstract String getTelnumber();

	/**��������**/
	public abstract String getSmstext();

	/**����ʱ�俪ʼ**/
	public abstract String getS_ctime();

	/**����ʱ�����**/
	public abstract String getE_ctime();
	
	/**����ʱ�俪ʼ**/
	public abstract String getS_utime();

	/**����ʱ�����**/
	public abstract String getE_utime();
	
	/**���ʹ�������**/
	public abstract Integer getGt_sendcount();
	
	/**���ʹ���С��**/
	public abstract Integer getLt_sendcount();

	/**����״̬**/
	public abstract String getSendstatus();

}