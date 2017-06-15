/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.condition.HWorkVWSearchCond;
import com.deliverik.framework.workflow.prd.model.entity.HWorkVW;

/**
 * ģ�飺��ʷ����ͳ��-
 * ˵������ʷ����ͳ��DAO�ӿ�
 * ���ߣ�zhaoyunli
 */
public interface HWorkVWDAO extends BaseHibernateDAO<HWorkVW> {


	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<HWorkVW> findByCond(final HWorkVWSearchCond cond);

}
