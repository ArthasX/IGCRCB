/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;

/**
  * ����: �Զ����������ñ�ʵ��
  * ��������: �Զ����������ñ�ʵ��
  * ������¼: 2012/11/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CustomConfiguration")
public class CustomConfigurationTB extends BaseEntity implements Serializable,
		Cloneable, CustomConfigurationInfo {

	/** ����ID */
	@Id
	@GeneratedValue(generator = "rfdid")
	@GenericGenerator(name = "rfdid", strategy = "assigned")
	protected Integer rfdid;

	/** ������ID */
	protected String pdid;

	/** ͳ�Ƶ�״̬ */
	protected String prstatusInfo;

	/** ��ID */
	protected String pidid;

	/** ��ֵ */
	protected String pidvalue;

	/** �Ǽ���ID */
	protected String userid;
	
	/** ����ʱ�� */
	protected String createTime;
	
	/** ����ʱ�� */
	protected String updateTime;

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param rfdid ����ID
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param pdid ������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ͳ�Ƶ�״̬ȡ��
	 *
	 * @return ͳ�Ƶ�״̬
	 */
	public String getPrstatusInfo() {
		return prstatusInfo;
	}

	/**
	 * ͳ�Ƶ�״̬�趨
	 *
	 * @param prstatusInfo ͳ�Ƶ�״̬
	 */
	public void setPrstatusInfo(String prstatusInfo) {
		this.prstatusInfo = prstatusInfo;
	}

	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ��ID�趨
	 *
	 * @param pidid ��ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getPidvalue() {
		return pidvalue;
	}

	/**
	 * ��ֵ�趨
	 *
	 * @param pidvalue ��ֵ
	 */
	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}

	/**
	 * �Ǽ���IDȡ��
	 *
	 * @return �Ǽ���ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �Ǽ���ID�趨
	 *
	 * @param userid �Ǽ���ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rfdid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}