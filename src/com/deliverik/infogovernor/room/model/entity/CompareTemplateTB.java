/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.room.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.room.model.CompareTemplateInfo;


/**
  * ����: compareTemplateʵ��
  * ��������: compareTemplateʵ��
  * ������¼: 2011/05/24
  * �޸ļ�¼: 2013-05-30 XuDongWang
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
	
	/**�豸�ʲ�ID*/
	protected String cteiid;
	
	/**�豸xλ������*/
	protected String ctx;
	
	/**�豸yλ������*/
	protected String cty;
	
	/**�豸�����ذ�x*/
	protected String ctfloorx;
	
	/**�豸�����ذ�y*/
	protected String ctfloory;
	
	/**�豸������*/
	protected String ctindex;
	
	/** ���� */
	protected String ctName;
	
	/** ˵�� */
	protected String ctInfo;
	
	/** ����������� */
	protected String ctZoneId;
	

	public Serializable getPK() {
		return ctpid;
	}

	/**
	 * ctpidȡ��
	 *
	 * @return ctpid ctpid
	 */
	public Integer getCtpid() {
		return ctpid;
	}
	
	/**
	 * ctcategoryȡ��
	 *
	 * @return ctcategory ctcategory
	 */
	public String getCtcategory() {
		return ctcategory;
	}

	/**
	 * cttypeȡ��
	 *
	 * @return cttype cttype
	 */
	public String getCttype() {
		return cttype;
	}

	/**
	 * cteiidȡ��
	 *
	 * @return cteiid cteiid
	 */
	public String getCteiid() {
		return cteiid;
	}

	/**
	 * ctxȡ��
	 *
	 * @return ctx ctx
	 */
	public String getCtx() {
		return ctx;
	}

	/**
	 * ctyȡ��
	 *
	 * @return cty cty
	 */
	public String getCty() {
		return cty;
	}

	/**
	 * ctfloorxȡ��
	 *
	 * @return ctfloorx ctfloorx
	 */
	public String getCtfloorx() {
		return ctfloorx;
	}

	/**
	 * ctflooryȡ��
	 *
	 * @return ctfloory ctfloory
	 */
	public String getCtfloory() {
		return ctfloory;
	}

	/**
	 * ctpid�趨
	 *
	 * @param ctpid ctpid
	 */
	public void setCtpid(Integer ctpid) {
		this.ctpid = ctpid;
	}
	
	/**
	 * ctcategory�趨
	 *
	 * @param ctcategory ctcategory
	 */
	public void setCtcategory(String ctcategory) {
		this.ctcategory = ctcategory;
	}

	/**
	 * cttype�趨
	 *
	 * @param cttype cttype
	 */
	public void setCttype(String cttype) {
		this.cttype = cttype;
	}

	/**
	 * cteiid�趨
	 *
	 * @param cteiid cteiid
	 */
	public void setCteiid(String cteiid) {
		this.cteiid = cteiid;
	}

	/**
	 * ctx�趨
	 *
	 * @param ctx ctx
	 */
	public void setCtx(String ctx) {
		this.ctx = ctx;
	}

	/**
	 * cty�趨
	 *
	 * @param cty cty
	 */
	public void setCty(String cty) {
		this.cty = cty;
	}

	/**
	 * ctfloorx�趨
	 *
	 * @param ctfloorx ctfloorx
	 */
	public void setCtfloorx(String ctfloorx) {
		this.ctfloorx = ctfloorx;
	}

	/**
	 * ctfloory�趨
	 *
	 * @param ctfloory ctfloory
	 */
	public void setCtfloory(String ctfloory) {
		this.ctfloory = ctfloory;
	}
	
	/**
	 * ctindex�趨
	 *
	 * @param ctindex ctindex
	 */
	public String getCtindex() {
		return ctindex;
	}
	
	/**
	 * ctindex�趨
	 *
	 * @param ctindex ctindex
	 */
	public void setCtindex(String ctindex) {
		this.ctindex = ctindex;
	}

	/**
	 * ctNameȡ��
	 *
	 * @return ctName ctName
	 */
	public String getCtName() {
		return ctName;
	}

	/**
	 * ctName�趨
	 *
	 * @param ctName ctName
	 */
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	/**
	 * ctInfoȡ��
	 *
	 * @return ctInfo ctInfo
	 */
	public String getCtInfo() {
		return ctInfo;
	}

	/**
	 * ctInfo�趨
	 *
	 * @param ctInfo ctInfo
	 */
	public void setCtInfo(String ctInfo) {
		this.ctInfo = ctInfo;
	}

	/**
	 * ctZoneIdȡ��
	 *
	 * @return ctZoneId ctZoneId
	 */
	public String getCtZoneId() {
		return ctZoneId;
	}

	/**
	 * ctZoneId�趨
	 *
	 * @param ctZoneId ctZoneId
	 */
	public void setCtZoneId(String ctZoneId) {
		this.ctZoneId = ctZoneId;
	}
}