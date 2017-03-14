/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.soc.asset.model.entity.ConfigurationCodeDetailTB;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetail;



/**
 * <p>
 * �ʲ�ģ������ȡֵ��Χʵ��
 * </p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="ConfigurationCodeDetail")
public class ConfigurationCodeDetailTB extends BaseEntity implements Serializable, Cloneable, ConfigurationCodeDetail {

	/**
	 * �ʲ�ģ������ȡֵ��ΧID
	 */
	@Id
	@TableGenerator(
		    name="CONFIGURATIONCODEDETAIL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="CONFIGURATIONCODEDETAIL_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CONFIGURATIONCODEDETAIL_TABLE_GENERATOR")
	protected Integer ccdid;

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ
	 */
	public String ccdcategory;
	
	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ����
	 */
	public String ccdlabel;

	/**
	 * �ʲ�ģ������ȡֵ��Χֵ
	 */
	public String ccdvalue;

	/**
	 * �ʲ�ģ������ȡֵ��Χ״̬
	 */
	public String ccdstatus;

	/**
	 * �ʲ�ģ������ȡֵ��Χ����Ӧ��
	 */
	public String ccdtype;

	/**
	 * �ʲ�ģ������ȡֵ��ΧԤ���ֶ�
	 */
	public String ccdinfo;
	
	/**
	 * ����
	 * @return 
	 */
	public Serializable getPK() {
		return ccdid;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧIDȡ��
	 * @return �ʲ�ģ������ȡֵ��ΧID
	 */
	public Integer getCcdid() {
		return ccdid;
	}
	
	/**
	 * �ʲ�ģ������ȡֵ��ΧID�趨
	 *
	 * @param ccdid �ʲ�ģ������ȡֵ��ΧID
	 */
	public void setCcdid(Integer ccdid) {
		this.ccdid = ccdid;
	}
	
	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ��ʶ
	 */
	public String getCcdcategory() {
		return ccdcategory;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ�趨
	 *
	 * @param ccdcategory �ʲ�ģ������ȡֵ��Χ��ʶ
	 */
	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ����ȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ��ʶ����
	 */
	public String getCcdlabel() {
		return ccdlabel;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ�����趨
	 *
	 * @param ccdlabel �ʲ�ģ������ȡֵ��Χ��ʶ����
	 */
	public void setCcdlabel(String ccdlabel) {
		this.ccdlabel = ccdlabel;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χֵȡ��
	 * @return �ʲ�ģ������ȡֵ��Χֵ
	 */
	public String getCcdvalue() {
		return ccdvalue;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χֵ�趨
	 *
	 * @param ccdvalue �ʲ�ģ������ȡֵ��Χֵ
	 */
	public void setCcdvalue(String ccdvalue) {
		this.ccdvalue = ccdvalue;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ״̬ȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ״̬
	 */
	public String getCcdstatus() {
		return ccdstatus;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ״̬�趨
	 *
	 * @param ccdstatus �ʲ�ģ������ȡֵ��Χ״̬
	 */
	public void setCcdstatus(String ccdstatus) {
		this.ccdstatus = ccdstatus;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ����Ӧ��ȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ����Ӧ��
	 */
	public String getCcdtype() {
		return ccdtype;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ����Ӧ���趨
	 *
	 * @param ccdtype �ʲ�ģ������ȡֵ��Χ����Ӧ��
	 */
	public void setCcdtype(String ccdtype) {
		this.ccdtype = ccdtype;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧԤ���ֶ�ȡ��
	 * @return �ʲ�ģ������ȡֵ��ΧԤ���ֶ�
	 */
	public String getCcdinfo() {
		return ccdinfo;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧԤ���ֶ��趨
	 *
	 * @param ccdinfo �ʲ�ģ������ȡֵ��ΧԤ���ֶ�
	 */
	public void setCcdinfo(String ccdinfo) {
		this.ccdinfo = ccdinfo;
	}
	
	public ConfigurationCodeDetailTB clone(ConfigurationCodeDetail ccd){
		this.ccdid = ccd.getCcdid();
		this.ccdcategory = ccd.getCcdcategory();
		this.ccdlabel = ccd.getCcdlabel();
		this.ccdvalue = ccd.getCcdvalue();
		this.ccdstatus = ccd.getCcdstatus();
		this.ccdtype = ccd.getCcdtype();
		this.ccdinfo = ccd.getCcdinfo();
		return this;
	}

}
