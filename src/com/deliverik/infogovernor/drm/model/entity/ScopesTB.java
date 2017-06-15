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
import com.deliverik.infogovernor.drm.model.ScopesInfo;

/**
  * ����: �¼�Ӱ�췶Χʵ��
  * ��������: �¼�Ӱ�췶Χʵ��
  * ������¼: 2015/03/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="scopes")
public class ScopesTB extends BaseEntity implements Serializable,
		Cloneable, ScopesInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="SCOPES_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SCOPES_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SCOPES_TABLE_GENERATOR")
	protected Integer scopeid;

	/** �¼�ID */
	protected Integer eventid;

	/** Ӱ�췶Χ */
	protected String impscope;

	/** ҵ���ж� */
	protected String impbus;

	/** �ж�ʱ�� */
	protected String imptime;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getScopeid() {
		return scopeid;
	}

	/**
	 * �����趨
	 *
	 * @param scopeid ����
	 */
	public void setScopeid(Integer scopeid) {
		this.scopeid = scopeid;
	}

	/**
	 * �¼�IDȡ��
	 *
	 * @return �¼�ID
	 */
	public Integer getEventid() {
		return eventid;
	}

	/**
	 * �¼�ID�趨
	 *
	 * @param eventid �¼�ID
	 */
	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	/**
	 * Ӱ�췶Χȡ��
	 *
	 * @return Ӱ�췶Χ
	 */
	public String getImpscope() {
		return impscope;
	}

	/**
	 * Ӱ�췶Χ�趨
	 *
	 * @param IMPSCOPE Ӱ�췶Χ
	 */
	public void setImpscope(String impscope) {
		this.impscope = impscope;
	}

	/**
	 * ҵ���ж�ȡ��
	 *
	 * @return ҵ���ж�
	 */
	public String getImpbus() {
		return impbus;
	}

	/**
	 * ҵ���ж��趨
	 *
	 * @param IMPBUS ҵ���ж�
	 */
	public void setImpbus(String impbus) {
		this.impbus = impbus;
	}

	/**
	 * �ж�ʱ��ȡ��
	 *
	 * @return �ж�ʱ��
	 */
	public String getImptime() {
		return imptime;
	}

	/**
	 * �ж�ʱ���趨
	 *
	 * @param IMPTIME �ж�ʱ��
	 */
	public void setImptime(String imptime) {
		this.imptime = imptime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return scopeid;
	}

}