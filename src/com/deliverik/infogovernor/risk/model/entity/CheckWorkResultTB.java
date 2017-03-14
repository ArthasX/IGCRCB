/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;

/**
  * ����: �������ʵ��
  * ��������: �������ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckWorkResult")
public class CheckWorkResultTB extends BaseEntity implements Serializable,
		Cloneable, CheckWorkResultInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="CHECKWORKRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKWORKRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKWORKRESULT_TABLE_GENERATOR")
	protected Integer cwrid;

	/** ������id */
	protected Integer csid;

	/** ����������� */
	protected String cwrname;

	/** ����ʼʱ�� */
	protected String cwrplandate;

	/** �������ʱ�� */
	protected String cwrrealtime;

	/** ������id */
	protected String cwruserid;

	/** ���������� */
	protected String cwrusername;

	/** ����������id */
	protected String cwrassetid;

	/** �������������� */
	protected String cwrassetname;

	/** ���� */
	protected String cwrrate;
	
	/** ��鷽ʽ*/
	protected String cwrtestmode;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCwrid() {
		return cwrid;
	}

	/**
	 * �����趨
	 *
	 * @param cwrid ����
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * ������id�趨
	 *
	 * @param csid ������id
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getCwrname() {
		return cwrname;
	}

	/**
	 * ������������趨
	 *
	 * @param cwrname �����������
	 */
	public void setCwrname(String cwrname) {
		this.cwrname = cwrname;
	}

	/**
	 * ����ʼʱ��ȡ��
	 *
	 * @return ����ʼʱ��
	 */
	public String getCwrplandate() {
		return cwrplandate;
	}

	/**
	 * ����ʼʱ���趨
	 *
	 * @param cwrplandate ����ʼʱ��
	 */
	public void setCwrplandate(String cwrplandate) {
		this.cwrplandate = cwrplandate;
	}

	/**
	 * �������ʱ��ȡ��
	 *
	 * @return �������ʱ��
	 */
	public String getCwrrealtime() {
		return cwrrealtime;
	}

	/**
	 * �������ʱ���趨
	 *
	 * @param cwrrealtime �������ʱ��
	 */
	public void setCwrrealtime(String cwrrealtime) {
		this.cwrrealtime = cwrrealtime;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getCwruserid() {
		return cwruserid;
	}

	/**
	 * ������id�趨
	 *
	 * @param cwruserid ������id
	 */
	public void setCwruserid(String cwruserid) {
		this.cwruserid = cwruserid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getCwrusername() {
		return cwrusername;
	}

	/**
	 * �����������趨
	 *
	 * @param cwrusername ����������
	 */
	public void setCwrusername(String cwrusername) {
		this.cwrusername = cwrusername;
	}

	/**
	 * ����������idȡ��
	 *
	 * @return ����������id
	 */
	public String getCwrassetid() {
		return cwrassetid;
	}

	/**
	 * ����������id�趨
	 *
	 * @param cwrassetid ����������id
	 */
	public void setCwrassetid(String cwrassetid) {
		this.cwrassetid = cwrassetid;
	}

	/**
	 * ��������������ȡ��
	 *
	 * @return ��������������
	 */
	public String getCwrassetname() {
		return cwrassetname;
	}

	/**
	 * ���������������趨
	 *
	 * @param cwrassetname ��������������
	 */
	public void setCwrassetname(String cwrassetname) {
		this.cwrassetname = cwrassetname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCwrrate() {
		return cwrrate;
	}

	/**
	 * �����趨
	 *
	 * @param cwrrate ����
	 */
	public void setCwrrate(String cwrrate) {
		this.cwrrate = cwrrate;
	}

	
	/**
	 * ��鷽ʽȡ��
	 * 
	 * @return the cwrtestmode
	 */
	public String getCwrtestmode() {
		return cwrtestmode;
	}

	/**
	 * ��鷽ʽ�趨
	 * 
	 * @param cwrtestmode the cwrtestmode to set
	 */
	public void setCwrtestmode(String cwrtestmode) {
		this.cwrtestmode = cwrtestmode;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cwrid;
	}

}