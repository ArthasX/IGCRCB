/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: �ʲ������ʵ��
  * ��������: �ʲ������ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(EiDomainDefPK.class)
@Table(name="EiDomainDef")
public class EiDomainDefTB extends BaseEntity implements Serializable,
		Cloneable, EiDomainDefInfo {

	/** ���� */
	@Id
	protected Integer eiddid;

	/** ���� */
	protected String name;

	/** �汾�� */
	@Id
	protected Integer version;

	/** ���� */
	protected String description;
	/**
	 * ����ʱ��
	 */
	protected String createtime;
	/**
	 * ����ʱ��
	 */
	protected String updatetime;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * �����趨
	 *
	 * @param eiddid����
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����趨
	 *
	 * @param name����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �汾��ȡ��
	 *
	 * @return �汾��
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾���趨
	 *
	 * @param version�汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * �����趨
	 *
	 * @param description����
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return  new EiDomainDefPK(eiddid,version);
	}
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getCreatetime() {
		return createtime;
	}
	/**
	 * ����ʱ������
	 * @param createtime����ʱ��
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getUpdatetime() {
		return updatetime;
	}
	/**
	 * ����ʱ������
	 * @param updatetime����ʱ��
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
	

}