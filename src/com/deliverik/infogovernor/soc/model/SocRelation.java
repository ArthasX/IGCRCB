/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * SOC��ϵʵ��ӿ�
 * 
 */
public interface SocRelation  extends BaseModel {
	
	/**
	 * �ʲ���Ϣʵ��
	 * @return �ʲ���Ϣʵ��
	 */
	//public EntityItemTB getEntityItemTB();
	
	/**
	 * ����ID
	 * @return ����ID
	 */
	public Integer getSrid();

	/**
	 * �ʲ�label
	 * @return �ʲ�label
	 */
	public String getSreilabel();
	
	/**
	 * �����ʲ�label
	 * @return �����ʲ�label
	 */
	public String getSrpareilabel();

	/**
	 * �����ʲ�coding
	 * @return �����ʲ�coding
	 */
	public String getSresycoding();

	/**
	 * �����ʲ���������
	 * @return �����ʲ���������
	 */
	public String getSrename();

	/**
	 * Ԥ��1
	 * @return Ԥ��1
	 */
	public String getSrkey1();

	/**
	 * Ԥ��2
	 * @return Ԥ��2
	 */
	public String getSrkey2();
	
	/**
	 * �汾��
	 * @return �汾��
	 */
	public Integer getVersion();
}