/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;

/**
  * ����: ���ɸ澯��ʵ��
  * ��������: ���ɸ澯��ʵ��
  * ������¼: 2014/06/21
  * �޸ļ�¼: 1.���ɸ澯������3���ֶηֱ�Ϊ���ָ�ʱ�䣨ʱ��ؼ���RecoveryTime��
  * 			�������ı���description���Ƿ����ɹ�����������isCreateOrder 2014-8-25 13:30:14
  * 	   2.���ɸ澯������2���ֶηֱ�Ϊ�����һ�θ澯�ķ���ʱ��prealarmtime��
  * 			�ø澯����ͬһ���кŵĸ澯�������Ĵ�����alarmcount 
  * 		  �����������ֶ�����Ϊͬһ���кŵĸ澯ѹ��Ϊһ��  2015-11-17 11:00:39 by wangxing
  */
@SuppressWarnings("serial")
@Entity
@Table(name="igalarm")
public class IgalarmTB extends BaseEntity implements Serializable,
		Cloneable, IgalarmInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="IGALARM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IGALARM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGALARM_TABLE_GENERATOR")
	protected Integer pk;

	/** ��� */
	protected String serial;

	/** �������� */
	protected String appname;

	/** IP��ַ */
	protected String ipaddr;

	/** �¼��ȼ� */
	protected String severity;

	/** �¼����� */
	protected String summary;

	/** ����/�ָ�ʱ�� */
	protected String lasttime;

	/** ״̬(0:δ����;1:�Ѵ���;2:�ر�) */
	protected String status;

	/** �¼������ */
	protected String pedeventid;
	
	/** �ָ�ʱ��  */	
	protected String recoveryTime; 

	/** ����  */	
	protected String description;
	
	/** �Ƿ����ɹ���  */	
	protected String isCreateOrder;
	
	/** ������ϵ��  */	
	protected String faultContact;
	
	/** �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)  */	
	protected String isShow;
	
	/** ���һ�θ澯�ķ���ʱ��  2015.11.17 by wangxing */
	protected String prealarmtime;
	
	/** �ø澯����ͬһ���кŵĸ澯�������Ĵ���    2015.11.17 by wangxing */
	protected Integer alarmcount;
	
	/** 
	 * �Ƿ���Ӧ����������״̬�ı�ʶ	2016.09.02 by wangxing
	 *  0:����״̬
	 *  1:����״̬
	 **/
	protected String shieldflag;
	
	/**
	 * Ӧ��������������
	 */
	protected String shielddesc;
	
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPk() {
		return pk;
	}

	/**
	 * �����趨
	 *
	 * @param pk ����
	 */
	public void setPk(Integer pk) {
		this.pk = pk;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * ����趨
	 *
	 * @param serial ���
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getAppname() {
		return appname;
	}

	/**
	 * ���������趨
	 *
	 * @param appname ��������
	 */
	public void setAppname(String appname) {
		this.appname = appname;
	}

	/**
	 * IP��ַȡ��
	 *
	 * @return IP��ַ
	 */
	public String getIpaddr() {
		return ipaddr;
	}

	/**
	 * IP��ַ�趨
	 *
	 * @param ipaddr IP��ַ
	 */
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	/**
	 * �¼��ȼ�ȡ��
	 *
	 * @return �¼��ȼ�
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * �¼��ȼ��趨
	 *
	 * @param severity �¼��ȼ�
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * �¼�����ȡ��
	 *
	 * @return �¼�����
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * �¼������趨
	 *
	 * @param summary �¼�����
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * ����/�ָ�ʱ��ȡ��
	 *
	 * @return ����/�ָ�ʱ��
	 */
	public String getLasttime() {
		return lasttime;
	}

	/**
	 * ����/�ָ�ʱ���趨
	 *
	 * @param lasttime ����/�ָ�ʱ��
	 */
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	/**
	 * ״̬(0:δ����;1:�Ѵ���)ȡ��
	 *
	 * @return ״̬(0:δ����;1:�Ѵ���)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ״̬(0:δ����;1:�Ѵ���)�趨
	 *
	 * @param status ״̬(0:δ����;1:�Ѵ���)
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * �¼������ȡ��
	 *
	 * @return �¼������
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * �¼�������趨
	 *
	 * @param pedeventid �¼������
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pk;
	}

	/**
	 * �ָ�ʱ��ȡ��
	 * @return recoveryTime  �ָ�ʱ��
	 */
	public String getRecoveryTime() {
		return recoveryTime;
	}

	/**
	 * �ָ�ʱ���趨
	 * @param recoveryTime  �ָ�ʱ��
	 */
	public void setRecoveryTime(String recoveryTime) {
		this.recoveryTime = recoveryTime;
	}

	/**
	 * ����ȡ��
	 * @return description  ����
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * �����趨
	 * @param description  ����
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * �Ƿ����ɹ���ȡ��
	 * @return isCreateOrder  �Ƿ����ɹ���
	 */
	public String getIsCreateOrder() {
		return isCreateOrder;
	}

	/**
	 * �Ƿ����ɹ����趨
	 * @param isCreateOrder  �Ƿ����ɹ���
	 */
	public void setIsCreateOrder(String isCreateOrder) {
		this.isCreateOrder = isCreateOrder;
	}

	/**
	 * ������ϵ��ȡ��
	 * @return faultContact  ������ϵ��
	 */
	public String getFaultContact() {
		return faultContact;
	}

	/**
	 * ������ϵ���趨
	 * @param faultContact  ������ϵ��
	 */
	public void setFaultContact(String faultContact) {
		this.faultContact = faultContact;
	}

	/**
	 * �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)ȡ��
	 * @return isShow  �Ƿ���ʾ��ʶ
	 */
	public String getIsShow() {
		return isShow;
	}

	/**
	 * �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)�趨
	 * @param isShow  �Ƿ���ʾ��ʶ
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	/**
	 * ���һ�θ澯ʱ��ȡ��
	 * @return prealarmtime ���һ�θ澯ʱ��
	 */
	public String getPrealarmtime() {
		return prealarmtime;
	}

	/**
	 * ���һ�θ澯ʱ���趨
	 * @param prealarmtime ���һ�θ澯ʱ��
	 */
	public void setPrealarmtime(String prealarmtime) {
		this.prealarmtime = prealarmtime;
	}

	/**
	 * �ø澯�����Ĵ���ȡ��
	 * @return alarmcount �ø澯�����Ĵ���
	 */
	public Integer getAlarmcount() {
		return alarmcount;
	}

	/**
	 * �ø澯�����Ĵ����趨
	 * @param alarmcount �ø澯�����Ĵ���
	 */
	public void setAlarmcount(Integer alarmcount) {
		this.alarmcount = alarmcount;
	}

	public String getShieldflag() {
		return shieldflag;
	}

	public void setShieldflag(String shieldflag) {
		this.shieldflag = shieldflag;
	}

	public String getShielddesc() {
		return shielddesc;
	}

	public void setShielddesc(String shielddesc) {
		this.shielddesc = shielddesc;
	}

	@Override
	public String toString() {
		return "IgalarmTB [pk=" + pk + ", serial=" + serial + ", appname="
				+ appname + ", ipaddr=" + ipaddr + ", severity=" + severity
				+ ", summary=" + summary + ", lasttime=" + lasttime
				+ ", status=" + status + ", pedeventid=" + pedeventid
				+ ", recoveryTime=" + recoveryTime + ", description="
				+ description + ", isCreateOrder=" + isCreateOrder
				+ ", faultContact=" + faultContact + ", isShow=" + isShow
				+ ", prealarmtime=" + prealarmtime + ", alarmcount="
				+ alarmcount + ", shieldflag=" + shieldflag + ", shielddesc="
				+ shielddesc + "]";
	}

}