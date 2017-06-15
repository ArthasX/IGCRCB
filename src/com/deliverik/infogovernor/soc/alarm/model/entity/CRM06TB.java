/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.ibm.icu.text.SimpleDateFormat;

/**
  * ����: CRM06ʵ��
  * ��������: CRM06ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM06")
public class CRM06TB extends BaseEntity implements Serializable,
		Cloneable, CRM06Info {

	/** serverid */
	@Id
	@GeneratedValue(generator = "serverid")
	@GenericGenerator(name = "serverid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "crm06_seq") })
	protected Integer serverid;

	/** fileid */
	protected Integer fileid;

	/** servername */
	protected String servername;

	/** servertype */
	protected String servertype;

	/** ip */
	protected String ip;
	
	/** ip2 */
	protected String ip2;

	/** server�Ƿ����ɳɹ� */
	protected String status;
	
	protected String createmessage;
	
	protected String host;
	
	/** �Ƿ����ø澯 */
	protected String alarmstatus;
	
	private Integer hqserverid;
	
	private String hqservername;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * serveridȡ��
	 *
	 * @return serverid
	 */
	public Integer getServerid() {
		return serverid;
	}

	/**
	 * serverid�趨
	 *
	 * @param serverid serverid
	 */
	public void setServerid(Integer serverid) {
		this.serverid = serverid;
	}

	/**
	 * fileidȡ��
	 *
	 * @return fileid
	 */
	public Integer getFileid() {
		return fileid;
	}

	/**
	 * fileid�趨
	 *
	 * @param fileid fileid
	 */
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	/**
	 * servernameȡ��
	 *
	 * @return servername
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * servername�趨
	 *
	 * @param servername servername
	 */
	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * servertypeȡ��
	 *
	 * @return servertype
	 */
	public String getServertype() {
		return servertype;
	}

	/**
	 * servertype�趨
	 *
	 * @param servertype servertype
	 */
	public void setServertype(String servertype) {
		this.servertype = servertype;
	}

	/**
	 * ipȡ��
	 *
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip�趨
	 *
	 * @param ip ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * statusȡ��
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * status�趨
	 *
	 * @param status status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return serverid;
	}

	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public String getAlarmstatus() {
		return alarmstatus;
	}

	public void setAlarmstatus(String alarmstatus) {
		this.alarmstatus = alarmstatus;
	}
	
	public void setCreatemessage(String createmessage) {
		this.createmessage = createmessage;
	}

	public String getCreatemessage() {
		return createmessage;
	}

	public Integer getHqserverid() {
		return hqserverid;
	}

	public void setHqserverid(Integer hqserverid) {
		this.hqserverid = hqserverid;
	}

	public String getHqservername() {
		return hqservername;
	}

	public void setHqservername(String hqservername) {
		this.hqservername = hqservername;
	}
	
	/**
	 * ������ת������Ӧ��ʽʱ��ķ���
	 */
	public String getTranToTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		date.setTime(Long.parseLong(fingerPrint));
		return sdf.format(date);
	}
	
}