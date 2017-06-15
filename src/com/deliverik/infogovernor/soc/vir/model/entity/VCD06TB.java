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
import com.deliverik.infogovernor.soc.vir.model.VCD06Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: vCloud��֯��ƽ̨��������ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="VCD06")
public class VCD06TB extends BaseEntity implements VCD06Info{
	
	/** ���� */
	@Id
	@TableGenerator(
		name="VCD06_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VCD06_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VCD06_TABLE_GENERATOR")
	protected Integer id;
	
	/** vCloud��֯ */
	protected String vorg;
	
	/** ������ */
	protected String orgsyscoding;
	
	/** �������� */
	protected String orgname;

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * vCloud��֯ȡ��
	 * @return vorg vCloud��֯
	 */
	public String getVorg() {
		return vorg;
	}

	/**
	 * vCloud��֯�趨
	 * @param vorg vCloud��֯
	 */
	public void setVorg(String vorg) {
		this.vorg = vorg;
	}

	/**
	 * ������ȡ��
	 * @return orgsyscoding ������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * �������趨
	 * @param orgsyscoding ������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * ���������趨
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Serializable getPK() {
		return this.id;
	}

}
