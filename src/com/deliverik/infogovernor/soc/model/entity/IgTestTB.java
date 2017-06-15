/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.model.IgTest;

/**
 * SOC��ϵʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IgTest")
public class IgTestTB extends BaseEntity implements Serializable, Cloneable, IgTest {

	/** ����ID */
	@Id
	@TableGenerator(
		    name="IGTEST_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGTEST_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGTEST_TABLE_GENERATOR")
	protected Integer id;


	protected String xmlvalue;
	

	protected String attkey;
	
	

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return id;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getXmlvalue() {
		return xmlvalue;
	}



	public void setXmlvalue(String xmlvalue) {
		this.xmlvalue = xmlvalue;
	}



	public String getAttkey() {
		return attkey;
	}



	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	


}
