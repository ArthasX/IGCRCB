/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;

/**
 * <p>����:���������Ա����ͳ�Ʋ�ѯDAO�ӿ�</p>
 * <p>����������1.������������</p>
 * <p>������¼��</p>
 */

public interface IG160DAO extends BaseHibernateDAO<IG160Info> {

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG160Info> findByCond(final IG160SearchCond cond, final int start, final int count);

}
