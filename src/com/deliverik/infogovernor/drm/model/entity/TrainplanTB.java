/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;

/**
  * ����: ��ѵ�ƻ���ʵ��
  * ��������: ��ѵ�ƻ���ʵ��
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="trainplan")
public class TrainplanTB extends BaseEntity implements Serializable,
		Cloneable, TrainplanInfo {

	/** ���� */
	@Id
	@TableGenerator(
			name="TRAINPLANTB_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="TRAINPLANTB_SEQUENCE", initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TRAINPLANTB_TABLE_GENERATOR")
	protected  Integer tpid;

	/** �ƻ����� */
	protected String tpname;

	/** ������id */
	protected String tpuserid;

	/** ���������� */
	protected String tpusername;

	/** ������id */
	protected String ptorgid;

	/** ���������� */
	protected String tporgname;

	/** �������� */
	protected String tptime;

	/** �ƻ�״̬ */
	protected String tpstatus;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * �����趨
	 *
	 * @param tpid ����
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * �ƻ�����ȡ��
	 *
	 * @return �ƻ�����
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * �ƻ������趨
	 *
	 * @param tpname �ƻ�����
	 */
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getTpuserid() {
		return tpuserid;
	}

	/**
	 * ������id�趨
	 *
	 * @param tpuserid ������id
	 */
	public void setTpuserid(String tpuserid) {
		this.tpuserid = tpuserid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTpusername() {
		return tpusername;
	}

	/**
	 * �����������趨
	 *
	 * @param tpusername ����������
	 */
	public void setTpusername(String tpusername) {
		this.tpusername = tpusername;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPtorgid() {
		return ptorgid;
	}

	/**
	 * ������id�趨
	 *
	 * @param ptorgid ������id
	 */
	public void setPtorgid(String ptorgid) {
		this.ptorgid = ptorgid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getTporgname() {
		return tporgname;
	}

	/**
	 * �����������趨
	 *
	 * @param tporgname ����������
	 */
	public void setTporgname(String tporgname) {
		this.tporgname = tporgname;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getTptime() {
		return tptime;
	}

	/**
	 * ���������趨
	 *
	 * @param tptime ��������
	 */
	public void setTptime(String tptime) {
		this.tptime = tptime;
	}

	/**
	 * �ƻ�״̬ȡ��
	 *
	 * @return �ƻ�״̬
	 */
	public String getTpstatus() {
		return tpstatus;
	}

	/**
	 * �ƻ�״̬�趨
	 *
	 * @param tpstatus �ƻ�״̬
	 */
	public void setTpstatus(String tpstatus) {
		this.tpstatus = tpstatus;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return tpid;
	}

}