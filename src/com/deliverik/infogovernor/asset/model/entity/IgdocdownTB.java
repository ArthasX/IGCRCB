/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.IgdocdownInfo;

/**
  * ����: ���ؼ�¼��ʵ��
  * ��������: ���ؼ�¼��ʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="igdocdown")
public class IgdocdownTB extends BaseEntity implements Serializable,
		Cloneable, IgdocdownInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="IGDOCDOWN_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IGDOCDOWN_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDOCDOWN_TABLE_GENERATOR")
	protected Integer ddid;

	/** �ĵ��ʲ�ID */
	protected Integer eiid;

	/** ������ */
	protected String userid;

	/** ����ʱ�� */
	protected String downtime;

	/** ����λ�� */
	protected String downlocation;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getDdid() {
		return ddid;
	}

	/**
	 * �����趨
	 *
	 * @param ddid ����
	 */
	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}

	/**
	 * �ĵ��ʲ�IDȡ��
	 *
	 * @return �ĵ��ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ĵ��ʲ�ID�趨
	 *
	 * @param eiid �ĵ��ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �������趨
	 *
	 * @param userid ������
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getDowntime() {
		return downtime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param downtime ����ʱ��
	 */
	public void setDowntime(String downtime) {
		this.downtime = downtime;
	}

	/**
	 * ����λ��ȡ��
	 *
	 * @return ����λ��
	 */
	public String getDownlocation() {
		return downlocation;
	}

	/**
	 * ����λ���趨
	 *
	 * @param downlocation ����λ��
	 */
	public void setDownlocation(String downlocation) {
		this.downlocation = downlocation;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ddid;
	}

	public void setFingerprint(String fingerprint) {
		// TODO Auto-generated method stub
		this.fingerPrint = fingerprint;
	}

}