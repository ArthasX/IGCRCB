/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;

/**
  * ����: �����ʵ����ʵ��
  * ��������: �����ʵ����ʵ��
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RegulatoryReportInstance")
public class RegulatoryReportInstanceTB extends BaseEntity implements Serializable,
		Cloneable, RegulatoryReportInstanceInfo {

	/** ����ID */
	@Id
	@TableGenerator(
		name="REGULATORYREPORTINSTANCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REGULATORYREPORTINSTANCE_SEQUENCE", initialValue=1000, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REGULATORYREPORTINSTANCE_TABLE_GENERATOR")
	protected Integer instanceID;

	/** ������ */
	protected String prtype;

	/** ���ʶ */
	protected String key;

	/** �����ʱ�� */
	protected String inittime;

	/** �����ʱ�� */
	protected String endtime;

	/** �����ʱ�� */
	protected String limittime;

	/** ��ע */
	protected String remark;

	/** ״̬��0������1����������2��ֹ,3�ر�*/
	protected String status;
	
	/** ������ID */
	protected String userid;
	
	/** ���������� */
	protected String username;
	
	/** �걨˵�� */
	protected String reportdesc;
	
	/** �� */
	protected String year;
	
	/** ���� */
	protected String quarter;
	
	/** �·� */
	protected String month;
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * ����ID�趨
	 *
	 * @param instanceID ����ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * �������趨
	 *
	 * @param prtype ������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���ʶȡ��
	 *
	 * @return ���ʶ
	 */
	public String getKey() {
		return key;
	}

	/**
	 * ���ʶ�趨
	 *
	 * @param key ���ʶ
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getInittime() {
		return inittime;
	}

	/**
	 * �����ʱ���趨
	 *
	 * @param inittime �����ʱ��
	 */
	public void setInittime(String inittime) {
		this.inittime = inittime;
	}

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * �����ʱ���趨
	 *
	 * @param endtime �����ʱ��
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getLimittime() {
		return limittime;
	}

	/**
	 * �����ʱ���趨
	 *
	 * @param limittime �����ʱ��
	 */
	public void setLimittime(String limittime) {
		this.limittime = limittime;
	}

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ��ע�趨
	 *
	 * @param remark ��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ״̬�趨
	 *
	 * @param status ״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * ������ID
	 * 
	 * @return ������ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ������ID
	 * @param userid ������ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����������
	 * @return ����������
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ����������
	 * @param username ����������
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * �걨˵��
	 * @return �걨˵��
	 */
	public String getReportdesc() {
		return reportdesc;
	}
	/**
	 * �걨˵��
	 * @param reportdesc �걨˵��
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}
	
	/**
	 * ��ȡ��
	 * @return ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ���趨
	 * @param year ��
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * �����趨
	 * @param quarter ����
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return instanceID;
	}

}