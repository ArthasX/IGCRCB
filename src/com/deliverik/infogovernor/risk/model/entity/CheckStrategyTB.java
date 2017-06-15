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
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;

/**
  * ����: ������ʵ��
  * ��������: ������ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckStrategy")
public class CheckStrategyTB extends BaseEntity implements Serializable,
		Cloneable, CheckStrategyInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="CHECKSTRATEGY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKSTRATEGY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKSTRATEGY_TABLE_GENERATOR")
	protected Integer csid;

	/** ������� */
	protected String csname;

	/** ���� */
	protected String csdesc;

	/** ״̬ */
	protected String csstatus;

	/** ��ʼ���� */
	protected String csstartdate;

	/** �������� */
	protected String csenddate;

	/** ��鷽ʽ*/
	protected String csrtestmode;
	
	/** Ƶ�� */
	protected String csfrequency;
	
	/** ��Ҫ�̶�*/
	protected String cstype;

	/** ����ִ�б��ʽ */
	protected String cscron;

	/** ������ID */
	protected String csuserid;

	/** ���������� */
	protected String csusername;

	/** �������ɫID */
	protected String csroleid;

	/** �������ɫ���� */
	protected String csrolename;

	/** ����������id */
	protected String csasset;
	
	/** �������������� */
	protected String csassetname;
	
	/** �����������ɫid*/
	protected String csassetorgid;
	
	/** ��������������*/
	protected String csassetorgname;
	
	/** ���� */
	protected String csattch ;

	/** ѡ�� */
	protected String csoption ;
	
	

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * �����趨
	 *
	 * @param csid ����
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getCsname() {
		return csname;
	}

	/**
	 * ��������趨
	 *
	 * @param csname �������
	 */
	public void setCsname(String csname) {
		this.csname = csname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCsdesc() {
		return csdesc;
	}

	/**
	 * �����趨
	 *
	 * @param csdesc ����
	 */
	public void setCsdesc(String csdesc) {
		this.csdesc = csdesc;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getCsstatus() {
		return csstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param csstatus ״̬
	 */
	public void setCsstatus(String csstatus) {
		this.csstatus = csstatus;
	}

	/**
	 * ��ʼ����ȡ��
	 *
	 * @return ��ʼ����
	 */
	public String getCsstartdate() {
		return csstartdate;
	}

	/**
	 * ��ʼ�����趨
	 *
	 * @param csstartdate ��ʼ����
	 */
	public void setCsstartdate(String csstartdate) {
		this.csstartdate = csstartdate;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCsenddate() {
		return csenddate;
	}

	/**
	 * ���������趨
	 *
	 * @param csenddate ��������
	 */
	public void setCsenddate(String csenddate) {
		this.csenddate = csenddate;
	}

	/**
	 * Ƶ��ȡ��
	 *
	 * @return Ƶ��
	 */
	public String getCsfrequency() {
		return csfrequency;
	}

	/**
	 * Ƶ���趨
	 *
	 * @param csfrequency Ƶ��
	 */
	public void setCsfrequency(String csfrequency) {
		this.csfrequency = csfrequency;
	}

	/**
	 * ����ִ�б��ʽȡ��
	 *
	 * @return ����ִ�б��ʽ
	 */
	public String getCscron() {
		return cscron;
	}

	/**
	 * ����ִ�б��ʽ�趨
	 *
	 * @param cscron ����ִ�б��ʽ
	 */
	public void setCscron(String cscron) {
		this.cscron = cscron;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getCsuserid() {
		return csuserid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param csuserid ������ID
	 */
	public void setCsuserid(String csuserid) {
		this.csuserid = csuserid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getCsusername() {
		return csusername;
	}

	/**
	 * �����������趨
	 *
	 * @param csusername ����������
	 */
	public void setCsusername(String csusername) {
		this.csusername = csusername;
	}

	/**
	 * �������ɫIDȡ��
	 *
	 * @return �������ɫID
	 */
	public String getCsroleid() {
		return csroleid;
	}

	/**
	 * �������ɫID�趨
	 *
	 * @param csroleid �������ɫID
	 */
	public void setCsroleid(String csroleid) {
		this.csroleid = csroleid;
	}

	/**
	 * �������ɫ����ȡ��
	 *
	 * @return �������ɫ����
	 */
	public String getCsrolename() {
		return csrolename;
	}

	/**
	 * �������ɫ�����趨
	 *
	 * @param csrolename �������ɫ����
	 */
	public void setCsrolename(String csrolename) {
		this.csrolename = csrolename;
	}

	/**
	 * ����������idȡ��
	 *
	 * @return ����������id
	 */
	public String getCsasset() {
		return csasset;
	}

	/**
	 * ����������id�趨
	 *
	 * @param csasset ����������id
	 */
	public void setCsasset(String csasset) {
		this.csasset = csasset;
	}

	/**
	 * ��������������ȡ��
	 *
	 * @return ��������������
	 */
	public String getCsassetname() {
		return csassetname;
	}

	/**
	 * ���������������趨
	 *
	 * @param csassetname ��������������
	 */
	public void setCsassetname(String csassetname) {
		this.csassetname = csassetname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCsattch () {
		return csattch ;
	}

	/**
	 * �����趨
	 *
	 * @param csattch  ����
	 */
	public void setCsattch (String csattch ) {
		this.csattch  = csattch ;
	}

	/**
	 * ѡ��ȡ��
	 *
	 * @return ѡ��
	 */
	public String getCsoption () {
		return csoption ;
	}

	/**
	 * ѡ���趨
	 *
	 * @param csoption  ѡ��
	 */
	public void setCsoption (String csoption ) {
		this.csoption  = csoption ;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return csid;
	}

	/**
	 * @return the csrtestmode
	 */
	public String getCsrtestmode() {
		return csrtestmode;
	}

	/**
	 * @param csrtestmode the csrtestmode to set
	 */
	public void setCsrtestmode(String csrtestmode) {
		this.csrtestmode = csrtestmode;
	}

	/**
	 * @return the cstype
	 */
	public String getCstype() {
		return cstype;
	}

	/**
	 * @param cstype the cstype to set
	 */
	public void setCstype(String cstype) {
		this.cstype = cstype;
	}

	/**
	 * @return the csassetorgid
	 */
	public String getCsassetorgid() {
		return csassetorgid;
	}

	/**
	 * @param csassetorgid the csassetorgid to set
	 */
	public void setCsassetorgid(String csassetorgid) {
		this.csassetorgid = csassetorgid;
	}

	/**
	 * @return the csassetorgname
	 */
	public String getCsassetorgname() {
		return csassetorgname;
	}

	/**
	 * @param csassetorgname the csassetorgname to set
	 */
	public void setCsassetorgname(String csassetorgname) {
		this.csassetorgname = csassetorgname;
	}

	
}