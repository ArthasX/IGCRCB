/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG787Info;
import com.deliverik.framework.workflow.prr.model.condition.IG787SearchCond;

/**
 * <p>����:���̹�ͨ������ͼDAO�ӿ�</p>
 * <p>����������1.������������</p>
 * <p>������¼��</p>
 */
public interface IG787DAO extends BaseHibernateDAO<IG787Info> {
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG787Info> findByCond(final IG787SearchCond cond, final int start, final int count);

}
