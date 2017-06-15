/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG567Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;

/**
 * ����:���̲�������������ͼDAO�ӿ�
 * ����������
 *           
 * ������¼���κ���    2010/11/26
 */
public interface IG567DAO extends
		BaseHibernateDAO<IG567Info> {

	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG567Info> findByCond(final IG433SearchCond cond,final int start, final int count);

}
