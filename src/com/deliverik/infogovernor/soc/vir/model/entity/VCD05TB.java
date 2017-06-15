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
import com.deliverik.infogovernor.soc.vir.model.VCD05Info;

/**
  * ����: vCloud����ģ��ʵ��
  * ��������: vCloud����ģ��ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD05")
public class VCD05TB extends BaseEntity implements Serializable,
		Cloneable, VCD05Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="VCD05_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD05_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD05_TABLE_GENERATOR")
	protected Integer id;

	/** ģ������ */
	protected String templateName;

	/** vCloudId */
	protected Integer vcloudid;

	/** vapp���� */
	protected String vappname;

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
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * ģ�������趨
	 *
	 * @param templateName ģ������
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * vCloudIdȡ��
	 *
	 * @return vCloudId
	 */
	public Integer getVcloudid() {
		return vcloudid;
	}

	/**
	 * vCloudId�趨
	 *
	 * @param vcloudid vCloudId
	 */
	public void setVcloudid(Integer vcloudid) {
		this.vcloudid = vcloudid;
	}

	/**
	 * vapp����ȡ��
	 *
	 * @return vapp����
	 */
	public String getVappname() {
		return vappname;
	}

	/**
	 * vapp�����趨
	 *
	 * @param vappname vapp����
	 */
	public void setVappname(String vappname) {
		this.vappname = vappname;
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