/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * ����: CRM01��������ʵ��
  * ��������: CRM01��������ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM10SearchCondImpl implements
		CRM10SearchCond {
	protected String ip="";//IP
	protected String get_StartTime="";//��ʼʱ��
    protected String get_EndTime="";//����ʱ��
    protected String  Tablename="";
    protected String nowCollecttime="";
	public String getNowCollecttime() {
		return nowCollecttime;
	}
	public void setNowCollecttime(String nowCollecttime) {
		this.nowCollecttime = nowCollecttime;
	}
	public String getTablename() {
		return Tablename;
	}
	public void setTablename(String tablename) {
		Tablename = tablename;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getGet_StartTime() {
		return get_StartTime;
	}
	public void setGet_StartTime(String get_StartTime) {
		this.get_StartTime = get_StartTime;
	}
	public String getGet_EndTime() {
		return get_EndTime;
	}
	public void setGet_EndTime(String get_EndTime) {
		this.get_EndTime = get_EndTime;
	}
	public String getSymType() {
		return SymType;
	}
	public void setSymType(String symType) {
		SymType = symType;
	}
	protected String SymType="";//�豸����
}