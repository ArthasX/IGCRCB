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
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;

/**
  * ����: ��֯�ܹ�������ʵ��
  * ��������: ��֯�ܹ�������ʵ��
  * ������¼: 2015/03/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="StructureRole")
public class StructureRoleTB extends BaseEntity implements Serializable,
		Cloneable, StructureRoleInfo {

	/** ��ˮ�� */
	@Id
	@TableGenerator(
		name="STRUCTUREROLE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="STRUCTUREROLE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="STRUCTUREROLE_TABLE_GENERATOR")
	protected Integer srid;

	/** ��֯�ܹ������ */
	protected String syscoding;

	/** ��֯�ܹ�cid */
	protected String cid;

	/** ��֯�ܹ����� */
	protected String sname;

	/** ��ɫid */
	protected Integer roleid;

	/** ��ɫ���� */
	protected String rolename;

	/** ��֯�ܹ����� YӦ����֯�ܹ���R�ճ���֯�ܹ� */
	protected String srtype;

	/**
	 * ��ˮ��ȡ��
	 *
	 * @return ��ˮ��
	 */
	public Integer getSrid() {
		return srid;
	}

	/**
	 * ��ˮ���趨
	 *
	 * @param srid ��ˮ��
	 */
	public void setSrid(Integer srid) {
		this.srid = srid;
	}

	/**
	 * ��֯�ܹ������ȡ��
	 *
	 * @return ��֯�ܹ������
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * ��֯�ܹ�������趨
	 *
	 * @param syscoding ��֯�ܹ������
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * ��֯�ܹ�cidȡ��
	 *
	 * @return ��֯�ܹ�cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * ��֯�ܹ�cid�趨
	 *
	 * @param cid ��֯�ܹ�cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * ��֯�ܹ�����ȡ��
	 *
	 * @return ��֯�ܹ�����
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * ��֯�ܹ������趨
	 *
	 * @param sname ��֯�ܹ�����
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * ��ɫidȡ��
	 *
	 * @return ��ɫid
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫid�趨
	 *
	 * @param roleid ��ɫid
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��ɫ����ȡ��
	 *
	 * @return ��ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param rolename ��ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * ��֯�ܹ����� YӦ����֯�ܹ���R�ճ���֯�ܹ�ȡ��
	 *
	 * @return ��֯�ܹ����� YӦ����֯�ܹ���R�ճ���֯�ܹ�
	 */
	public String getSrtype() {
		return srtype;
	}

	/**
	 * ��֯�ܹ����� YӦ����֯�ܹ���R�ճ���֯�ܹ��趨
	 *
	 * @param srtype ��֯�ܹ����� YӦ����֯�ܹ���R�ճ���֯�ܹ�
	 */
	public void setSrtype(String srtype) {
		this.srtype = srtype;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
    public Serializable getPK() {
		return srid;
	}

}