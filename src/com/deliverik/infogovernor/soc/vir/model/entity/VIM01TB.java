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
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;

/**
  * ����: vCenter ServiceInstanceʵ��
  * ��������: vCenter ServiceInstanceʵ��
  * ������¼: 2014/02/12
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="VIM01")
public class VIM01TB extends BaseEntity implements Serializable,
		Cloneable, VIM01Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="VIM01_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM01_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM01_TABLE_GENERATOR")
	protected Integer vcid;

	/** ���� */
	protected String vcname;

	/** URL */
	protected String vcurl;

	/** �û��� */
	protected String vcusername;

	/** ���� */
	protected String vcpassword;

	/** ״̬ */
	protected String vcstatus;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * �����趨
	 *
	 * @param vcid ����
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getVcname() {
		return vcname;
	}

	/**
	 * �����趨
	 *
	 * @param vcname ����
	 */
	public void setVcname(String vcname) {
		this.vcname = vcname;
	}

	/**
	 * URLȡ��
	 *
	 * @return URL
	 */
	public String getVcurl() {
		return vcurl;
	}

	/**
	 * URL�趨
	 *
	 * @param vcurl URL
	 */
	public void setVcurl(String vcurl) {
		this.vcurl = vcurl;
	}

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getVcusername() {
		return vcusername;
	}

	/**
	 * �û����趨
	 *
	 * @param vcusername �û���
	 */
	public void setVcusername(String vcusername) {
		this.vcusername = vcusername;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getVcpassword() {
		return vcpassword;
	}

	/**
	 * �����趨
	 *
	 * @param vcpassword ����
	 */
	public void setVcpassword(String vcpassword) {
		this.vcpassword = vcpassword;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getVcstatus() {
		return vcstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param vcstatus ״̬
	 */
	public void setVcstatus(String vcstatus) {
		this.vcstatus = vcstatus;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return vcid;
	}

}