/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;

/**
  * ����: MSS00012ʵ��
  * ��������: MSS00012ʵ��
  * ������¼: 2013/04/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="MSS00012")
public class Mss00012TB extends BaseEntity implements Serializable,
		Cloneable, Mss00012Info {

	/** ID */
	@Id
	protected Integer id;

	/** deviceid */
	protected Integer deviceid;

	/** deviceip */
	protected String deviceip;

	/** devicename */
	protected String devicename;

	/** rulelevel */
	protected String rulelevel;

	/** alarmmsg */
	protected String alarmmsg;
	
	protected Integer prid;

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/** isalarm */
	protected Integer isalarm;
	
	/** createtime */
	protected String createtime;
	/**ȷ��ʱ��*/
	protected String starttime;
	/**�޸�ʱ��*/
	protected String endtime;
	
	
	
	
	
	protected Integer state;
	

	


	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id�趨
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * deviceidȡ��
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid() {
		return deviceid;
	}

	/**
	 * deviceid�趨
	 *
	 * @param deviceid deviceid
	 */
	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}

	/**
	 * deviceipȡ��
	 *
	 * @return deviceip
	 */
	public String getDeviceip() {
		return deviceip;
	}

	/**
	 * deviceip�趨
	 *
	 * @param deviceip deviceip
	 */
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	/**
	 * devicenameȡ��
	 *
	 * @return devicename
	 */
	public String getDevicename() {
		return devicename;
	}

	/**
	 * devicename�趨
	 *
	 * @param devicename devicename
	 */
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	/**
	 * rulelevelȡ��
	 *
	 * @return rulelevel
	 */
	public String getRulelevel() {
		return rulelevel;
	}

	/**
	 * rulelevel�趨
	 *
	 * @param rulelevel rulelevel
	 */
	public void setRulelevel(String rulelevel) {
		this.rulelevel = rulelevel;
	}

	/**
	 * alarmmsgȡ��
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * alarmmsg�趨
	 *
	 * @param alarmmsg alarmmsg
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	/**
	 * isalarmȡ��
	 *
	 * @return isalarm
	 */
	public Integer getIsalarm() {
		return isalarm;
	}

	/**
	 * isalarm�趨
	 *
	 * @param isalarm isalarm
	 */
	public void setIsalarm(Integer isalarm) {
		this.isalarm = isalarm;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	
}