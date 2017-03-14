/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.IgTest;
import com.deliverik.infogovernor.soc.model.condition.IgTestSearchCond;

/**
 * SOC��ϵDAO�ӿ�
 */
public interface IgTestDAO extends BaseHibernateDAO<IgTest> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IgTest> findAll();

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public IgTest findByPK(Serializable rcid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IgTestSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgTest> findByCond(final IgTestSearchCond cond, final int start, final int count);
	
	
}
