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
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;

/**
  * ����: ��ѵ������ʵ��
  * ��������: ��ѵ������ʵ��
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="trainparticipate")
public class TrainparticipateTB extends BaseEntity implements Serializable,
		Cloneable, TrainparticipateInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="TRAINPARTICIPATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="TRAINPARTICIPATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TRAINPARTICIPATE_TABLE_GENERATOR")
	protected Integer tpaid;

	/** ��ѵ������ */
	protected String tpaname;

	/** ��ѵ����ϵ�绰 */
	protected String tpatel;

	/** ��ѵ��¼id */
	protected Integer trid;
	
	protected String tpaorg;
	
	

	/**  
	 * ��ȡtpaorg  
	 * @return tpaorg tpaorg  
	 */
	
	public String getTpaorg() {
		return tpaorg;
	}

	/**  
	 * ����tpaorg  
	 * @param tpaorg tpaorg  
	 */
	
	public void setTpaorg(String tpaorg) {
		this.tpaorg = tpaorg;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTpaid() {
		return tpaid;
	}

	/**
	 * �����趨
	 *
	 * @param tpaid ����
	 */
	public void setTpaid(Integer tpaid) {
		this.tpaid = tpaid;
	}

	/**
	 * ��ѵ������ȡ��
	 *
	 * @return ��ѵ������
	 */
	public String getTpaname() {
		return tpaname;
	}

	/**
	 * ��ѵ�������趨
	 *
	 * @param tpaname ��ѵ������
	 */
	public void setTpaname(String tpaname) {
		this.tpaname = tpaname;
	}

	/**
	 * ��ѵ����ϵ�绰ȡ��
	 *
	 * @return ��ѵ����ϵ�绰
	 */
	public String getTpatel() {
		return tpatel;
	}

	/**
	 * ��ѵ����ϵ�绰�趨
	 *
	 * @param tpatel ��ѵ����ϵ�绰
	 */
	public void setTpatel(String tpatel) {
		this.tpatel = tpatel;
	}

	/**
	 * ��ѵ��¼idȡ��
	 *
	 * @return ��ѵ��¼id
	 */
	public Integer getTrid() {
		return trid;
	}

	/**
	 * ��ѵ��¼id�趨
	 *
	 * @param trid ��ѵ��¼id
	 */
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return tpaid;
	}

}