/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;

/**
  * ����: �������ϸ��ʵ��
  * ��������: �������ϸ��ʵ��
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RegulatoryReportDetail")
public class RegulatoryReportDetailTB extends BaseEntity implements Serializable,
		Cloneable, RegulatoryReportDetailInfo {

	/** ����ID */
	@Id
	@TableGenerator(
		name="REGULATORYREPORTDETAIL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REGULATORYREPORTDETAIL_SEQUENCE", initialValue=1000, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REGULATORYREPORTDETAIL_TABLE_GENERATOR")
	protected Integer detailID;

	/** �ʵ��ID */
	protected Integer instanceID;

	/** ����ID */
	protected Integer prid;
	

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getDetailID() {
		return detailID;
	}

	/**
	 * ����ID�趨
	 *
	 * @param detailID ����ID
	 */
	public void setDetailID(Integer detailID) {
		this.detailID = detailID;
	}

	/**
	 * �ʵ��IDȡ��
	 *
	 * @return �ʵ��ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * �ʵ��ID�趨
	 *
	 * @param instanceID �ʵ��ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return detailID;
	}

}