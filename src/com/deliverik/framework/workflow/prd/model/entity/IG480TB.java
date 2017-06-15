/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG480Info;

/**
  * ����: �����鶨���ʵ��
  * ��������: �����鶨���ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG480")
public class IG480TB extends BaseEntity implements Serializable,
		Cloneable, IG480Info {

	/** ���� */
	@Id
	protected String pgdid;

	/** ���� */
	protected String pgdname;

	/** ���� */
	protected String pgddesc;

	/** ״̬ */
	protected String pgdstatus;

	/** ����ͼxml */
	protected String pgdxml;

	/** ����ʱ�� */
	protected String pgdcrtime;

	/** ���к����ɴ����� */
	protected String serialGenerator;

	/** ģ������ */
	protected Integer ptid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * �����趨
	 *
	 * @param pgdid ����
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPgdname() {
		return pgdname;
	}

	/**
	 * �����趨
	 *
	 * @param pgdname ����
	 */
	public void setPgdname(String pgdname) {
		this.pgdname = pgdname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPgddesc() {
		return pgddesc;
	}

	/**
	 * �����趨
	 *
	 * @param pgddesc ����
	 */
	public void setPgddesc(String pgddesc) {
		this.pgddesc = pgddesc;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getPgdstatus() {
		return pgdstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param pgdstatus ״̬
	 */
	public void setPgdstatus(String pgdstatus) {
		this.pgdstatus = pgdstatus;
	}

	/**
	 * ����ͼxmlȡ��
	 *
	 * @return ����ͼxml
	 */
	public String getPgdxml() {
		return pgdxml;
	}

	/**
	 * ����ͼxml�趨
	 *
	 * @param pgdxml ����ͼxml
	 */
	public void setPgdxml(String pgdxml) {
		this.pgdxml = pgdxml;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getPgdcrtime() {
		return pgdcrtime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param pgdcrtime ����ʱ��
	 */
	public void setPgdcrtime(String pgdcrtime) {
		this.pgdcrtime = pgdcrtime;
	}

	/**
	 * ���к����ɴ�����ȡ��
	 *
	 * @return ���к����ɴ�����
	 */
	public String getSerialGenerator() {
		return serialGenerator;
	}

	/**
	 * ���к����ɴ������趨
	 *
	 * @param serialGenerator ���к����ɴ�����
	 */
	public void setSerialGenerator(String serialGenerator) {
		this.serialGenerator = serialGenerator;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ģ�������趨
	 *
	 * @param ptid ģ������
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
	public Serializable getPK() {
		return pgdid;
	}

}