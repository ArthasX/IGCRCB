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
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;

/**
  * ����: ��鹤��������������ʵ��
  * ��������: ��鹤��������������ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckworkInfoResult")
public class CheckworkInfoResultTB extends BaseEntity implements Serializable,
		Cloneable, CheckworkInfoResultInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="CHECKWORKINFORESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKWORKINFORESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKWORKINFORESULT_TABLE_GENERATOR")
	protected Integer cwirid;

	/** �������id */
	protected Integer cwrid;

	/** ��鹤��id */
	protected Integer rcrid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCwirid() {
		return cwirid;
	}

	/**
	 * �����趨
	 *
	 * @param cwirid ����
	 */
	public void setCwirid(Integer cwirid) {
		this.cwirid = cwirid;
	}

	/**
	 * �������idȡ��
	 *
	 * @return �������id
	 */
	public Integer getCwrid() {
		return cwrid;
	}

	/**
	 * �������id�趨
	 *
	 * @param cwrid �������id
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}

	/**
	 * ��鹤��idȡ��
	 *
	 * @return ��鹤��id
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * ��鹤��id�趨
	 *
	 * @param rcrid ��鹤��id
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cwirid;
	}

}