/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM02Info;

/**
  * ����: CRM02ʵ��
  * ��������: CRM02ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM02")
public class CRM02TB extends BaseEntity implements Serializable,
		Cloneable, CRM02Info {

	/** collecttime */
	protected String collecttime;

	/** tablename */
	@Id
	protected String tablename;

	/** status */
	protected String status;

	/**
	 * collecttimeȡ��
	 *
	 * @return collecttime
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * collecttime�趨
	 *
	 * @param collecttime collecttime
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * tablenameȡ��
	 *
	 * @return tablename
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * tablename�趨
	 *
	 * @param tablename tablename
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
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
		return collecttime;
	}

}