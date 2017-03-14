/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG692SearchCond;

/**
 * <p>
 *  ����:���񹤵�ͳ��DAO�ӿ�
 * </p>
 * <p>
 *  ������¼: ���� 2010/10/28 ���񹤵�ͳ��DAO�ӿ�
 * </p>
 */
public interface IG692DAO extends BaseHibernateDAO<IG933Info> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<List<String>> findByCond(
			final IG692SearchCond cond, final int start,final int count);
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<List<String>> findByCond2(
			final IG692SearchCond cond, final int start,final int count);

}
