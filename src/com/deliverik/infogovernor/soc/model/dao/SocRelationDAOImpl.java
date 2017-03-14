/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.SocRelation;
import com.deliverik.infogovernor.soc.model.condition.SocRelationSearchCond;
import com.deliverik.infogovernor.soc.model.entity.SocRelationTB;

/**
 * SOC��ϵDAOʵ��
 */
@SuppressWarnings("deprecation")
public class SocRelationDAOImpl extends BaseHibernateDAOImpl<SocRelation> implements SocRelationDAO {

	/**
	 * ���캯��
	 */
	public SocRelationDAOImpl(){
		super(SocRelationTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SocRelation> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("srid"));
		List<SocRelation> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rcid ����
	 * @return �������
	 */
	public SocRelation findByPK(Serializable srid) {

		SocRelation result = super.findByPK(srid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SocRelationSearchCond cond){
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
	public List<SocRelation> findByCond(final SocRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("srid"));
		List<SocRelation> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SocRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�ʲ����
		if( !StringUtils.isEmpty(cond.getSreilabel())){
			c.add(Expression.eq("sreilabel",cond.getSreilabel()));
		}
		
		//�汾��
		if( !StringUtils.isEmpty(cond.getSrkey1())){
			c.add(Expression.eq("srkey1",cond.getSrkey1()));
		}
		
		//�����ʲ�coding
		if( !StringUtils.isEmpty(cond.getSresycoding())){
			c.add(Expression.eq("sresycoding",cond.getSresycoding()));
		}
		
		return c;
	}



}
