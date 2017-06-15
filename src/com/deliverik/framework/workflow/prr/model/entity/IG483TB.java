/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG483Info;

/**
  * ����: ������ʵ����ʵ��
  * ��������: ������ʵ����ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG483")
public class IG483TB extends BaseEntity implements Serializable,
		Cloneable, IG483Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="IG483_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG483_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG483_TABLE_GENERATOR")
	protected Integer pgrid;

	/** �����鷢����id */
	protected String pgruserid;

	/** �����鷢�������� */
	protected String pgrusername;

	/** �����鷢��ʱ�� */
	protected String pgropentime;

	/** ������ر�ʱ�� */
	protected String pgrclosetime;

	/** ������������ */
	protected Integer ocount;

	/** �ر��������� */
	protected Integer ccount;

	/** ���������к� */
	protected String pgrserialnum;

	/** ��������� */
	protected String pgrtitle;

	/** �����鷢���˻����� */
	protected String pgrorgid;

	/** �����鷢���˻������� */
	protected String pgrorgname;

	/** �����鶨��id */
	protected String pgdid;

	/** �����鶨������ */
	protected String pgdname;

	/** ����ģ������ */
	protected String pttype;
	
	/** �Ƿ�������� */
	protected String istest;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * �����趨
	 *
	 * @param pgrid ����
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * �����鷢����idȡ��
	 *
	 * @return �����鷢����id
	 */
	public String getPgruserid() {
		return pgruserid;
	}

	/**
	 * �����鷢����id�趨
	 *
	 * @param pgruserid �����鷢����id
	 */
	public void setPgruserid(String pgruserid) {
		this.pgruserid = pgruserid;
	}

	/**
	 * �����鷢��������ȡ��
	 *
	 * @return �����鷢��������
	 */
	public String getPgrusername() {
		return pgrusername;
	}

	/**
	 * �����鷢���������趨
	 *
	 * @param pgrusername �����鷢��������
	 */
	public void setPgrusername(String pgrusername) {
		this.pgrusername = pgrusername;
	}

	/**
	 * �����鷢��ʱ��ȡ��
	 *
	 * @return �����鷢��ʱ��
	 */
	public String getPgropentime() {
		return pgropentime;
	}

	/**
	 * �����鷢��ʱ���趨
	 *
	 * @param pgropentime �����鷢��ʱ��
	 */
	public void setPgropentime(String pgropentime) {
		this.pgropentime = pgropentime;
	}

	/**
	 * ������ر�ʱ��ȡ��
	 *
	 * @return ������ر�ʱ��
	 */
	public String getPgrclosetime() {
		return pgrclosetime;
	}

	/**
	 * ������ر�ʱ���趨
	 *
	 * @param pgrclosetime ������ر�ʱ��
	 */
	public void setPgrclosetime(String pgrclosetime) {
		this.pgrclosetime = pgrclosetime;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public Integer getOcount() {
		return ocount;
	}

	/**
	 * �������������趨
	 *
	 * @param ocount ������������
	 */
	public void setOcount(Integer ocount) {
		this.ocount = ocount;
	}

	/**
	 * �ر���������ȡ��
	 *
	 * @return �ر���������
	 */
	public Integer getCcount() {
		return ccount;
	}

	/**
	 * �ر����������趨
	 *
	 * @param ccount �ر���������
	 */
	public void setCcount(Integer ccount) {
		this.ccount = ccount;
	}

	/**
	 * ���������к�ȡ��
	 *
	 * @return ���������к�
	 */
	public String getPgrserialnum() {
		return pgrserialnum;
	}

	/**
	 * ���������к��趨
	 *
	 * @param pgrserialnum ���������к�
	 */
	public void setPgrserialnum(String pgrserialnum) {
		this.pgrserialnum = pgrserialnum;
	}

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getPgrtitle() {
		return pgrtitle;
	}

	/**
	 * ����������趨
	 *
	 * @param pgrtitle ���������
	 */
	public void setPgrtitle(String pgrtitle) {
		this.pgrtitle = pgrtitle;
	}

	/**
	 * �����鷢���˻�����ȡ��
	 *
	 * @return �����鷢���˻�����
	 */
	public String getPgrorgid() {
		return pgrorgid;
	}

	/**
	 * �����鷢���˻������趨
	 *
	 * @param pgrorgid �����鷢���˻�����
	 */
	public void setPgrorgid(String pgrorgid) {
		this.pgrorgid = pgrorgid;
	}

	/**
	 * �����鷢���˻�������ȡ��
	 *
	 * @return �����鷢���˻�������
	 */
	public String getPgrorgname() {
		return pgrorgname;
	}

	/**
	 * �����鷢���˻��������趨
	 *
	 * @param pgrorgname �����鷢���˻�������
	 */
	public void setPgrorgname(String pgrorgname) {
		this.pgrorgname = pgrorgname;
	}

	/**
	 * �����鶨��idȡ��
	 *
	 * @return �����鶨��id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * �����鶨��id�趨
	 *
	 * @param pgdid �����鶨��id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * �����鶨������ȡ��
	 *
	 * @return �����鶨������
	 */
	public String getPgdname() {
		return pgdname;
	}

	/**
	 * �����鶨�������趨
	 *
	 * @param pgdname �����鶨������
	 */
	public void setPgdname(String pgdname) {
		this.pgdname = pgdname;
	}
	
	/**
	 * ����ģ������ȡ��
	 * 
	 * @return ����ģ������
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * ����ģ�������趨
	 * 
	 * @param pttype ����ģ������
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}
	
	/**
	 * �Ƿ���������趨
	 * @return �Ƿ��������
	 */
	public String getIstest() {
		return istest;
	}

	/**
	 * �Ƿ��������ȡ��
	 * @param istest �Ƿ��������
	 */
	public void setIstest(String istest) {
		this.istest = istest;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pgrid;
	}

}