/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.CompareTemplateInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: compareTemplateʵ��
  * ��������: compareTemplateʵ��
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareTemplate")
public class CompareTemplateTB extends BaseEntity implements Serializable,
		Cloneable, CompareTemplateInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="COMPARETEMPLATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="COMPARETEMPLATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="COMPARETEMPLATE_TABLE_GENERATOR")
	protected Integer ctpid;

	/** ���ID */
	protected String ctcategory;

	/** ���� */
	protected String cttype;

	/** ������ */
	protected String ctxwidth;

	/** ������ */
	protected String ctywidth;

	/** ֵ */
	protected String ctvalue;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCtpid() {
		return ctpid;
	}

	/**
	 * �����趨
	 *
	 * @param ctid ����
	 */
	public void setCtpid(Integer ctpid) {
		this.ctpid = ctpid;
	}

	/**
	 * ���IDȡ��
	 *
	 * @return ���ID
	 */
	public String getCtcategory() {
		return ctcategory;
	}

	/**
	 * ���ID�趨
	 *
	 * @param ctcategory ���ID
	 */
	public void setCtcategory(String ctcategory) {
		this.ctcategory = ctcategory;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCttype() {
		return cttype;
	}

	/**
	 * �����趨
	 *
	 * @param cttype ����
	 */
	public void setCttype(String cttype) {
		this.cttype = cttype;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getCtxwidth() {
		return ctxwidth;
	}

	/**
	 * �������趨
	 *
	 * @param ctxwidth ������
	 */
	public void setCtxwidth(String ctxwidth) {
		this.ctxwidth = ctxwidth;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getCtywidth() {
		return ctywidth;
	}

	/**
	 * �������趨
	 *
	 * @param ctywidth ������
	 */
	public void setCtywidth(String ctywidth) {
		this.ctywidth = ctywidth;
	}

	/**
	 * ֵȡ��
	 *
	 * @return ֵ
	 */
	public String getCtvalue() {
		return ctvalue;
	}

	/**
	 * ֵ�趨
	 *
	 * @param ctvalue ֵ
	 */
	public void setCtvalue(String ctvalue) {
		this.ctvalue = ctvalue;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ctpid;
	}

}