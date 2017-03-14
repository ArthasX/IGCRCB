/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.IgTest;
import com.deliverik.infogovernor.soc.model.condition.IgTestSearchCond;
import com.deliverik.infogovernor.soc.model.entity.IgTestTB;

/**
 * SOC��ϵDAOʵ��
 */
@SuppressWarnings("deprecation")
public class IgTestDAOImpl extends BaseHibernateDAOImpl<IgTest> implements IgTestDAO {

	/**
	 * ���캯��
	 */
	public IgTestDAOImpl(){
		super(IgTestTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IgTest> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("id"));
		List<IgTest> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rcid ����
	 * @return �������
	 */
	public IgTest findByPK(Serializable id) {

		IgTest result = super.findByPK(id);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IgTestSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgTest> findByCond(final IgTestSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("id"));
		List<IgTest> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IgTestSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		return c;
	}



}
