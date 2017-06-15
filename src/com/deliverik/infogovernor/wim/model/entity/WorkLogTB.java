/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;

/**
  * ����: ������־��ʵ��
  * ��������: ������־��ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workLog")
public class WorkLogTB extends BaseEntity implements Serializable,
		Cloneable, WorkLogInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="WORKLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKLOG_TABLE_GENERATOR")
	protected Integer wlid;

	/** ����ʵ�������� */
	protected Integer wiid;

	/** ������־���� */
	protected String wlname;

	/** ִ���ˣ�userid�� */
	protected String excutorId;

	/** ���� */
	protected String operation;

	/** ���������� */
	protected String titleDate;

	/** ִ��ʱ�� */
	protected String excuteTime;

	/** ʵ�ʴ������� */
	protected String actualDealwithDate;

	/** ִ��������� */
	protected String wlDescription;

	/** ���¼�������� */
	protected String crtDate;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWlid() {
		return wlid;
	}

	/**
	 * �����趨
	 *
	 * @param ����
	 */
	public void setWlid(Integer wlid) {
		this.wlid = wlid;
	}

	/**
	 * ����ʵ��������ȡ��
	 *
	 * @return ����ʵ��������
	 */
	public Integer getWiid() {
		return wiid;
	}

	/**
	 * ����ʵ���������趨
	 *
	 * @param ����ʵ��������
	 */
	public void setWiid(Integer wiid) {
		this.wiid = wiid;
	}

	/**
	 * ������־����ȡ��
	 *
	 * @return ������־����
	 */
	public String getWlname() {
		return wlname;
	}

	/**
	 * ������־�����趨
	 *
	 * @param ������־����
	 */
	public void setWlname(String wlname) {
		this.wlname = wlname;
	}

	/**
	 * ִ���ˣ�userid��ȡ��
	 *
	 * @return ִ���ˣ�userid��
	 */
	public String getExcutorId() {
		return excutorId;
	}

	/**
	 * ִ���ˣ�userid���趨
	 *
	 * @param ִ���ˣ�userid��
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * �����趨
	 *
	 * @param ����
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTitleDate() {
		return titleDate;
	}

	/**
	 * �����������趨
	 *
	 * @param ����������
	 */
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}

	/**
	 * ִ��ʱ��ȡ��
	 *
	 * @return excuteTime
	 */
	public String getExcuteTime() {
		return excuteTime;
	}

	/**
	 * ִ��ʱ���趨
	 *
	 * @param ִ��ʱ��
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}

	/**
	 * ʵ�ʴ�������ȡ��
	 *
	 * @return ʵ�ʴ�������
	 */
	public String getActualDealwithDate() {
		return actualDealwithDate;
	}

	/**
	 * ʵ�ʴ��������趨
	 *
	 * @param ʵ�ʴ�������
	 */
	public void setActualDealwithDate(String actualDealwithDate) {
		this.actualDealwithDate = actualDealwithDate;
	}

	/**
	 * ִ���������ȡ��
	 *
	 * @return ִ���������
	 */
	public String getWlDescription() {
		return wlDescription;
	}

	/**
	 * ִ����������趨
	 *
	 * @param ִ���������
	 */
	public void setWlDescription(String wlDescription) {
		this.wlDescription = wlDescription;
	}

	/**
	 * ���¼��������ȡ��
	 *
	 * @return ���¼��������
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * ���¼���������趨
	 *
	 * @param ���¼��������
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return wlid;
	}

}