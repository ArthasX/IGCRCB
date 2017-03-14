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
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;

/**
  * ����: ��ѵ�����ʵ��
  * ��������: ��ѵ�����ʵ��
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="trainmission")
public class TrainmissionTB extends BaseEntity implements Serializable,
		Cloneable, TrainmissionInfo {

	/** tmid */
	@Id
	@TableGenerator(
			name="TRAINMISSION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="TRAINMISSION_SEQUENCE", initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TRAINMISSION_TABLE_GENERATOR")
	protected Integer tmid;

	/** ��� */
	protected  Integer tpid;

	/** ��ѵ�γ� */
	protected String tmcourse;

	/** ��ѵ���� */
	protected String tmorg;

	/** ��ѵʱ�� */
	protected String tmtime;

	/** ��ѵ���� */
	protected String tmtarget;

	/** ����key */
	protected String tmatt;

	/**
	 * tmidȡ��
	 *
	 * @return tmid
	 */
	public Integer getTmid() {
		return tmid;
	}

	/**
	 * tmid�趨
	 *
	 * @param tmid tmid
	 */
	public void setTmid(Integer tmid) {
		this.tmid = tmid;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * ����趨
	 *
	 * @param tpid ���
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * ��ѵ�γ�ȡ��
	 *
	 * @return ��ѵ�γ�
	 */
	public String getTmcourse() {
		return tmcourse;
	}

	/**
	 * ��ѵ�γ��趨
	 *
	 * @param tmcourse ��ѵ�γ�
	 */
	public void setTmcourse(String tmcourse) {
		this.tmcourse = tmcourse;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTmorg() {
		return tmorg;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param tmorg ��ѵ����
	 */
	public void setTmorg(String tmorg) {
		this.tmorg = tmorg;
	}

	/**
	 * ��ѵʱ��ȡ��
	 *
	 * @return ��ѵʱ��
	 */
	public String getTmtime() {
		return tmtime;
	}

	/**
	 * ��ѵʱ���趨
	 *
	 * @param tmtime ��ѵʱ��
	 */
	public void setTmtime(String tmtime) {
		this.tmtime = tmtime;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTmtarget() {
		return tmtarget;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param tmtarget ��ѵ����
	 */
	public void setTmtarget(String tmtarget) {
		this.tmtarget = tmtarget;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getTmatt() {
		return tmatt;
	}

	/**
	 * �����趨
	 *
	 * @param tmatt ����
	 */
	public void setTmatt(String tmatt) {
		this.tmatt = tmatt;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return tmid;
	}

	
}