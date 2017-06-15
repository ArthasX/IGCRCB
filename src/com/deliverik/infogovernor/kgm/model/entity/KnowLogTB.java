/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;

/**
  * ����: knowLogʵ��
  * ��������: knowLogʵ��
  * ������¼: 2011/05/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="knowLog")
public class KnowLogTB extends BaseEntity implements Serializable,
		Cloneable, KnowLogInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="KNOWLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="KNOWLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="KNOWLOG_TABLE_GENERATOR")
	protected Integer klid;

	/** ֪ʶID */
	protected Integer klkid;

	/** ����ʱ�� */
	protected String kltime;

	/** ������־��ɫID */
	protected String klroleid;

	/** �������ӽ�ɫ���� */
	protected String klrolename;

	/** �û�ID */
	protected String kluserid;

	/** �û����� */
	protected String klusername;

	/** ��־���� */
	protected String kldesc;

	/** ��ע��Ϣ */
	protected String klcommend;

	/** ����ID */
	protected String klorgid;

	/** �������� */
	protected String klorgname;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getKlid() {
		return klid;
	}

	/**
	 * �����趨
	 *
	 * @param klid ����
	 */
	public void setKlid(Integer klid) {
		this.klid = klid;
	}

	/**
	 * ֪ʶIDȡ��
	 *
	 * @return ֪ʶID
	 */
	public Integer getKlkid() {
		return klkid;
	}

	/**
	 * ֪ʶID�趨
	 *
	 * @param klkid ֪ʶID
	 */
	public void setKlkid(Integer klkid) {
		this.klkid = klkid;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getKltime() {
		return kltime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param kltime ����ʱ��
	 */
	public void setKltime(String kltime) {
		this.kltime = kltime;
	}

	/**
	 * ������־��ɫIDȡ��
	 *
	 * @return ������־��ɫID
	 */
	public String getKlroleid() {
		return klroleid;
	}

	/**
	 * ������־��ɫID�趨
	 *
	 * @param klroleid ������־��ɫID
	 */
	public void setKlroleid(String klroleid) {
		this.klroleid = klroleid;
	}

	/**
	 * �������ӽ�ɫ����ȡ��
	 *
	 * @return �������ӽ�ɫ����
	 */
	public String getKlrolename() {
		return klrolename;
	}

	/**
	 * �������ӽ�ɫ�����趨
	 *
	 * @param klrolename �������ӽ�ɫ����
	 */
	public void setKlrolename(String klrolename) {
		this.klrolename = klrolename;
	}

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getKluserid() {
		return kluserid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param kluserid �û�ID
	 */
	public void setKluserid(String kluserid) {
		this.kluserid = kluserid;
	}

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getKlusername() {
		return klusername;
	}

	/**
	 * �û������趨
	 *
	 * @param klusername �û�����
	 */
	public void setKlusername(String klusername) {
		this.klusername = klusername;
	}

	/**
	 * ��־����ȡ��
	 *
	 * @return ��־����
	 */
	public String getKldesc() {
		return kldesc;
	}

	/**
	 * ��־�����趨
	 *
	 * @param kldesc ��־����
	 */
	public void setKldesc(String kldesc) {
		this.kldesc = kldesc;
	}

	/**
	 * ��ע��Ϣȡ��
	 *
	 * @return ��ע��Ϣ
	 */
	public String getKlcommend() {
		return klcommend;
	}

	/**
	 * ��ע��Ϣ�趨
	 *
	 * @param klcommend ��ע��Ϣ
	 */
	public void setKlcommend(String klcommend) {
		this.klcommend = klcommend;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getKlorgid() {
		return klorgid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param klorgid ����ID
	 */
	public void setKlorgid(String klorgid) {
		this.klorgid = klorgid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getKlorgname() {
		return klorgname;
	}

	/**
	 * ���������趨
	 *
	 * @param klorgname ��������
	 */
	public void setKlorgname(String klorgname) {
		this.klorgname = klorgname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return klid;
	}

}