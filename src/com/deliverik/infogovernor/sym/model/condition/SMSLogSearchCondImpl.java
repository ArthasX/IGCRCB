package com.deliverik.infogovernor.sym.model.condition;

/**
 * ����:���ŷ��ͼ�¼��ѯ ����
 * �������������ŷ��ͼ�¼��ѯ ����
 * ������¼��zhaojun@deliverik.com    2010/12/20
 */

public class SMSLogSearchCondImpl implements SMSLogSearchCond {
	
	/**����ID**/
	protected Integer sid;
	
	/**�ֻ�����**/
	protected String telnumber;
	
	/**��������**/
	protected String smstext;
	
	/**����ʱ�俪ʼ**/
	protected String s_ctime;
	
	/**����ʱ�����**/
	protected String e_ctime;
	
	/**����ʱ�俪ʼ**/
	protected String s_utime;

	
	/**����ʱ�����**/
	protected String e_utime;
	
	/**���ʹ�������**/
	protected Integer gt_sendcount;
	
	/**���ʹ���С��**/
	protected Integer lt_sendcount;
	
	
	/**����״̬**/
	protected String sendstatus;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getSmstext() {
		return smstext;
	}

	public void setSmstext(String smstext) {
		this.smstext = smstext;
	}

	public String getSendstatus() {
		return sendstatus;
	}

	public void setSendstatus(String sendstatus) {
		this.sendstatus = sendstatus;
	}

	public String getS_ctime() {
		return s_ctime;
	}

	public void setS_ctime(String sCtime) {
		s_ctime = sCtime;
	}

	public String getE_ctime() {
		return e_ctime;
	}

	public void setE_ctime(String eCtime) {
		e_ctime = eCtime;
	}

	public String getS_utime() {
		return s_utime;
	}

	public void setS_utime(String sUtime) {
		s_utime = sUtime;
	}

	public String getE_utime() {
		return e_utime;
	}

	public void setE_utime(String eUtime) {
		e_utime = eUtime;
	}

	public Integer getGt_sendcount() {
		return gt_sendcount;
	}

	public void setGt_sendcount(Integer gtSendcount) {
		gt_sendcount = gtSendcount;
	}

	public Integer getLt_sendcount() {
		return lt_sendcount;
	}

	public void setLt_sendcount(Integer ltSendcount) {
		lt_sendcount = ltSendcount;
	}

}

