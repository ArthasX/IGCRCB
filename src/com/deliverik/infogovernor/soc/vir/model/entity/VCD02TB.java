/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;

/**
  * ����: ������Դ��Ŀ��Ϣʵ��
  * ��������: ������Դ��Ŀ��Ϣʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD02")
public class VCD02TB extends BaseEntity implements Serializable,
		Cloneable, VCD02Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="VCD02_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD02_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD02_TABLE_GENERATOR")
	protected Integer id;

	/** ��Ŀ���� */
	protected String projectName;

	/** ��������ʱ�� */
	protected String expectDeployTime;

	/** ��Ŀ����ʱ�� */
	protected String projectExpireTime;

	/** ��Ŀ��� */
	protected String projectType;

	/** ��Ŀ˵�� */
	protected String projectDesc;

	/** ����˵�� */
	protected String projectApplyReason;

	/** ��������� */
	protected String orgsyscoding;

	/** �������� */
	protected String orgname;

	/** �Զ�������� */
	protected String progress;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ��Ŀ����ȡ��
	 *
	 * @return ��Ŀ����
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * ��Ŀ�����趨
	 *
	 * @param projectName ��Ŀ����
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getExpectDeployTime() {
		return expectDeployTime;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param expectDeployTime ��������ʱ��
	 */
	public void setExpectDeployTime(String expectDeployTime) {
		this.expectDeployTime = expectDeployTime;
	}

	/**
	 * ��Ŀ����ʱ��ȡ��
	 *
	 * @return ��Ŀ����ʱ��
	 */
	public String getProjectExpireTime() {
		return projectExpireTime;
	}

	/**
	 * ��Ŀ����ʱ���趨
	 *
	 * @param projectExpireTime ��Ŀ����ʱ��
	 */
	public void setProjectExpireTime(String projectExpireTime) {
		this.projectExpireTime = projectExpireTime;
	}

	/**
	 * ��Ŀ���ȡ��
	 *
	 * @return ��Ŀ���
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * ��Ŀ����趨
	 *
	 * @param projectType ��Ŀ���
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * ��Ŀ˵��ȡ��
	 *
	 * @return ��Ŀ˵��
	 */
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * ��Ŀ˵���趨
	 *
	 * @param projectDesc ��Ŀ˵��
	 */
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	/**
	 * ����˵��ȡ��
	 *
	 * @return ����˵��
	 */
	public String getProjectApplyReason() {
		return projectApplyReason;
	}

	/**
	 * ����˵���趨
	 *
	 * @param projectApplyReason ����˵��
	 */
	public void setProjectApplyReason(String projectApplyReason) {
		this.projectApplyReason = projectApplyReason;
	}

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * ����������趨
	 *
	 * @param orgsyscoding ���������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 *
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * �Զ��������ȡ��
	 *
	 * @return �Զ��������
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * �Զ���������趨
	 *
	 * @param progress �Զ��������
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

}