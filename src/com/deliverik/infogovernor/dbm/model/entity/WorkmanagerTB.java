/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;

/**
  * ����: ��������ʵ��
  * ��������: ��������ʵ��
  * ������¼: 2016/04/19
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workmanager")
public class WorkmanagerTB extends BaseEntity implements Serializable,
		Cloneable, WorkmanagerInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="WORKMANAGER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKMANAGER_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKMANAGER_TABLE_GENERATOR")
	protected Integer wmid;

	/** �������� */
	protected String wmname;

	/** ���� */
	protected String wmdesc;

	/** ���״̬(0-δ���1-�����) */
	protected String wmstatus;

	/** �������� */
	protected String wmstartdate;

	/** ����������� */
	protected String wmlimitdate;

	/** ʵ��������� */
	protected String wmfactdate;

	/** Ƶ�� */
	protected String wmfrequency;

	/** ����ִ�б��ʽ  */
	protected String wmcron;

	/** ������id */
	protected String wmuserid;

	/** ���������� */
	protected String wmusername;

	/** �����˽�ɫid */
	protected String wmroleid;

	/** �����˽�ɫ���� */
	protected String wmrolename;

	/** ѡ�� */
	protected String wmoption;

	/** ����ʱ�䣨Сʱ�� */
	protected String wmremindh;

	/** ����ʱ�䣨���ӣ� */
	protected String wmremindm;

	/** ������Դ 0-�Ǽ�1-����  */
	protected String wmtype;

	/** �Ƿ�����0-����1-��������  */
	protected String wmremind;

	/** ��ע */
	protected String wmremark;
	
	/** ����Դ wmid  */
	protected String rewmid;
	
	/** ���ռ��Ƶ��(��) */
	protected String wmfrequencyweeks;
	
	/** ���ռ��Ƶ��(��) */
	protected String wmfrequencymonths;
	
	/** Ƶ��(ÿ�����һ��) */
	protected String wmfrequencymonthlastday;
	
	/**
	 * @return the Ƶ��(ÿ�����һ��)
	 */
	public String getWmfrequencymonthlastday() {
		return wmfrequencymonthlastday;
	}

	/**
	 * @param Ƶ��(ÿ�����һ��) the wmfrequencymonthlastday to set
	 */
	public void setWmfrequencymonthlastday(String wmfrequencymonthlastday) {
		this.wmfrequencymonthlastday = wmfrequencymonthlastday;
	}

	/**
	 * @return the ����Դwmid
	 */
	public String getRewmid() {
		return rewmid;
	}

	/**
	 * @param ����Դwmid the rewmid to set
	 */
	public void setRewmid(String rewmid) {
		this.rewmid = rewmid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * �����趨
	 *
	 * @param wmid ����
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getWmname() {
		return wmname;
	}

	/**
	 * ���������趨
	 *
	 * @param wmname ��������
	 */
	public void setWmname(String wmname) {
		this.wmname = wmname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getWmdesc() {
		return wmdesc;
	}

	/**
	 * �����趨
	 *
	 * @param wmdesc ����
	 */
	public void setWmdesc(String wmdesc) {
		this.wmdesc = wmdesc;
	}

	/**
	 * ���״̬(0-δ���1-�����)ȡ��
	 *
	 * @return ���״̬(0-δ���1-�����)
	 */
	public String getWmstatus() {
		return wmstatus;
	}

	/**
	 * ���״̬(0-δ���1-�����)�趨
	 *
	 * @param wmstatus ���״̬(0-δ���1-�����)
	 */
	public void setWmstatus(String wmstatus) {
		this.wmstatus = wmstatus;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getWmstartdate() {
		return wmstartdate;
	}

	/**
	 * ���������趨
	 *
	 * @param wmstartdate ��������
	 */
	public void setWmstartdate(String wmstartdate) {
		this.wmstartdate = wmstartdate;
	}

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getWmlimitdate() {
		return wmlimitdate;
	}

	/**
	 * ������������趨
	 *
	 * @param wmlimitdate �����������
	 */
	public void setWmlimitdate(String wmlimitdate) {
		this.wmlimitdate = wmlimitdate;
	}

	/**
	 * ʵ���������ȡ��
	 *
	 * @return ʵ���������
	 */
	public String getWmfactdate() {
		return wmfactdate;
	}

	/**
	 * ʵ����������趨
	 *
	 * @param wmfactdate ʵ���������
	 */
	public void setWmfactdate(String wmfactdate) {
		this.wmfactdate = wmfactdate;
	}

	/**
	 * Ƶ��ȡ��
	 *
	 * @return Ƶ��
	 */
	public String getWmfrequency() {
		return wmfrequency;
	}

	/**
	 * Ƶ���趨
	 *
	 * @param wmfrequency Ƶ��
	 */
	public void setWmfrequency(String wmfrequency) {
		this.wmfrequency = wmfrequency;
	}

	/**
	 * ����ִ�б��ʽ ȡ��
	 *
	 * @return ����ִ�б��ʽ 
	 */
	public String getWmcron() {
		return wmcron;
	}

	/**
	 * ����ִ�б��ʽ �趨
	 *
	 * @param wmcron ����ִ�б��ʽ 
	 */
	public void setWmcron(String wmcron) {
		this.wmcron = wmcron;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getWmuserid() {
		return wmuserid;
	}

	/**
	 * ������id�趨
	 *
	 * @param wmuserid ������id
	 */
	public void setWmuserid(String wmuserid) {
		this.wmuserid = wmuserid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getWmusername() {
		return wmusername;
	}

	/**
	 * �����������趨
	 *
	 * @param wmusername ����������
	 */
	public void setWmusername(String wmusername) {
		this.wmusername = wmusername;
	}

	/**
	 * �����˽�ɫidȡ��
	 *
	 * @return �����˽�ɫid
	 */
	public String getWmroleid() {
		return wmroleid;
	}

	/**
	 * �����˽�ɫid�趨
	 *
	 * @param wmroleid �����˽�ɫid
	 */
	public void setWmroleid(String wmroleid) {
		this.wmroleid = wmroleid;
	}

	/**
	 * �����˽�ɫ����ȡ��
	 *
	 * @return �����˽�ɫ����
	 */
	public String getWmrolename() {
		return wmrolename;
	}

	/**
	 * �����˽�ɫ�����趨
	 *
	 * @param wmrolename �����˽�ɫ����
	 */
	public void setWmrolename(String wmrolename) {
		this.wmrolename = wmrolename;
	}

	/**
	 * ѡ��ȡ��
	 *
	 * @return ѡ��
	 */
	public String getWmoption() {
		return wmoption;
	}

	/**
	 * ѡ���趨
	 *
	 * @param wmoption ѡ��
	 */
	public void setWmoption(String wmoption) {
		this.wmoption = wmoption;
	}

	/**
	 * ����ʱ�䣨Сʱ��ȡ��
	 *
	 * @return ����ʱ�䣨Сʱ��
	 */
	public String getWmremindh() {
		return wmremindh;
	}

	/**
	 * ����ʱ�䣨Сʱ���趨
	 *
	 * @param wmremindh ����ʱ�䣨Сʱ��
	 */
	public void setWmremindh(String wmremindh) {
		this.wmremindh = wmremindh;
	}

	/**
	 * ����ʱ�䣨���ӣ�ȡ��
	 *
	 * @return ����ʱ�䣨���ӣ�
	 */
	public String getWmremindm() {
		return wmremindm;
	}

	/**
	 * ����ʱ�䣨���ӣ��趨
	 *
	 * @param wmremindm ����ʱ�䣨���ӣ�
	 */
	public void setWmremindm(String wmremindm) {
		this.wmremindm = wmremindm;
	}

	/**
	 * ������Դ 0-�Ǽ�1-���� ȡ��
	 *
	 * @return ������Դ 0-�Ǽ�1-���� 
	 */
	public String getWmtype() {
		return wmtype;
	}

	/**
	 * ������Դ 0-�Ǽ�1-���� �趨
	 *
	 * @param wmtype ������Դ 0-�Ǽ�1-���� 
	 */
	public void setWmtype(String wmtype) {
		this.wmtype = wmtype;
	}

	/**
	 * �Ƿ�����0-����1-�������� ȡ��
	 *
	 * @return �Ƿ�����0-����1-�������� 
	 */
	public String getWmremind() {
		return wmremind;
	}

	/**
	 * �Ƿ�����0-����1-�������� �趨
	 *
	 * @param wmremind �Ƿ�����0-����1-�������� 
	 */
	public void setWmremind(String wmremind) {
		this.wmremind = wmremind;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return wmid;
	}

	/**
	 * @return the ��ע
	 */
	public String getWmremark() {
		return wmremark;
	}

	/**
	 * @param ��ע the wmremark to set
	 */
	public void setWmremark(String wmremark) {
		this.wmremark = wmremark;
	}

	/**
	 * @return the ���ռ��Ƶ��(��)
	 */
	public String getWmfrequencyweeks() {
		return wmfrequencyweeks;
	}

	/**
	 * @param ���ռ��Ƶ��(��) the wmfrequencyweeks to set
	 */
	public void setWmfrequencyweeks(String wmfrequencyweeks) {
		this.wmfrequencyweeks = wmfrequencyweeks;
	}

	/**
	 * @return the ���ռ��Ƶ��(��)
	 */
	public String getWmfrequencymonths() {
		return wmfrequencymonths;
	}

	/**
	 * @param ���ռ��Ƶ��(��) the wmfrequencymonths to set
	 */
	public void setWmfrequencymonths(String wmfrequencymonths) {
		this.wmfrequencymonths = wmfrequencymonths;
	}

}