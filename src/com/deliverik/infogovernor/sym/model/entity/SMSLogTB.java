package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.SMSLog;

/**
 * ����:ʵ�����
 * �������������ŷ��ͼ�¼ʵ����
 * ������¼��zhaojun@deliverik.com    2010/12/20
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SMSLOG")
public class SMSLogTB extends BaseEntity implements Serializable, Cloneable, SMSLog {

	@Id
	@TableGenerator(name = "SMSLOG_TABLE_GENERATOR", 
			table = "SEQUENCE_GENERATOR_TABLE", 
			pkColumnName = "SEQUENCE_NAME", 
			valueColumnName = "SEQUENCE_VALUE", 
			pkColumnValue = "SMSLOG_SEQUENCE", 
			initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SMSLOG_TABLE_GENERATOR")
	
	/**����ID**/
	protected Integer sid;
	
	/**�ֻ�����**/
	protected String telnumber;
	
	/**��������**/
	protected String smstext;
	
	/**����ʱ��**/
	protected String ctime;
	
	/**����ʱ��**/
	protected String utime;
	
	/**���ʹ���**/
	protected Integer sendcount;
	
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

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getUtime() {
		return utime;
	}

	public void setUtime(String utime) {
		this.utime = utime;
	}

	public Integer getSendcount() {
		return sendcount;
	}

	public void setSendcount(Integer sendcount) {
		this.sendcount = sendcount;
	}

	public String getSendstatus() {
		return sendstatus;
	}

	public void setSendstatus(String sendstatus) {
		this.sendstatus = sendstatus;
	}

	@Override
	public Serializable getPK() {
		return sid;
	}

}

