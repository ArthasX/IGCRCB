package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCond;

/**
 * ���̲����߱���Ȩ����ͼDAO�ӿ�
 */
public interface IG893DAO extends
		BaseHibernateDAO<IG893Info> {

	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG893Info> findByCond(final IG893SearchCond cond);
	
}
