/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;

/**
 * ������DAO�ӿ�
 */
public interface IG463DAO extends BaseHibernateDAO<IG463Info> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG463Info> findByCond(final IG463SearchCond cond, final int start, final int count);

	/**
	 * ������������
	 * @param paid ����
	 * @return �������
	 */
	public IG463Info findIG463InfoByPK(Integer ppwid);
}
