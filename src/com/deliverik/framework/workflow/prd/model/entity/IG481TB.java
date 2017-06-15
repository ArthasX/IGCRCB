/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG481Info;

/**
  * ����: �������Ա��ʵ��
  * ��������: �������Ա��ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG481PK.class)
@Table(name="IG481")
public class IG481TB extends BaseEntity implements Serializable,
		Cloneable, IG481Info {

	/** ������id */
	@Id
	protected String pgdid;

	/** ��������id */
	@Id
	protected String pdid;

	/** ����ʽ */
	protected String createType;

	/** ���̰汾 */
	protected String pdversion;

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * ������id�趨
	 *
	 * @param pgdid ������id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * ��������idȡ��
	 *
	 * @return ��������id
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������id�趨
	 *
	 * @param pdid ��������id
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����ʽȡ��
	 *
	 * @return ����ʽ
	 */
	public String getCreateType() {
		return createType;
	}

	/**
	 * ����ʽ�趨
	 *
	 * @param createType ����ʽ
	 */
	public void setCreateType(String createType) {
		this.createType = createType;
	}

	/**
	 * ���̰汾ȡ��
	 *
	 * @return ���̰汾
	 */
	public String getPdversion() {
		return pdversion;
	}

	/**
	 * ���̰汾�趨
	 *
	 * @param pdversion ���̰汾
	 */
	public void setPdversion(String pdversion) {
		this.pdversion = pdversion;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG481PK(pgdid, pdid);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pdid == null) ? 0 : pdid.hashCode());
		result = prime * result + ((pgdid == null) ? 0 : pgdid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IG481TB other = (IG481TB) obj;
		if (pdid == null) {
			if (other.pdid != null)
				return false;
		} else if (!pdid.equals(other.pdid))
			return false;
		if (pgdid == null) {
			if (other.pgdid != null)
				return false;
		} else if (!pgdid.equals(other.pgdid))
			return false;
		return true;
	}
	
}