/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;

/**
  * ����: ���ղ���ָ���ϵ��ʵ��
  * ��������: ���ղ���ָ���ϵ��ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="StrategyIndexRelation")
public class StrategyIndexRelationTB extends BaseEntity implements Serializable,
		Cloneable, StrategyIndexRelationInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="STRATEGYINDEXRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="STRATEGYINDEXRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="STRATEGYINDEXRELATION_TABLE_GENERATOR")
	protected Integer sirid;

	/** ���ղ���id */
	protected Integer rsid;

	/** ����ָ��id */
	protected Integer riid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getSirid() {
		return sirid;
	}

	/**
	 * �����趨
	 *
	 * @param sirid ����
	 */
	public void setSirid(Integer sirid) {
		this.sirid = sirid;
	}

	/**
	 * ���ղ���idȡ��
	 *
	 * @return ���ղ���id
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * ���ղ���id�趨
	 *
	 * @param rsid ���ղ���id
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * ����ָ��idȡ��
	 *
	 * @return ����ָ��id
	 */
	public Integer getRiid() {
		return riid;
	}

	/**
	 * ����ָ��id�趨
	 *
	 * @param riid ����ָ��id
	 */
	public void setRiid(Integer riid) {
		this.riid = riid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return sirid;
	}

}