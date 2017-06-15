/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.SocRelation;
import com.deliverik.infogovernor.soc.model.condition.SocRelationSearchCond;

/**
 * SOC��ϵDAO�ӿ�
 */
public interface SocRelationDAO extends BaseHibernateDAO<SocRelation> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SocRelation> findAll();

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public SocRelation findByPK(Serializable rcid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SocRelationSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SocRelation> findByCond(final SocRelationSearchCond cond, final int start, final int count);
	
	
}
