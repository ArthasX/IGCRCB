/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCond;

/**
  * ����: IG342DAO�ӿ�
  * ��������: IG342DAO�ӿ�
  * ������¼: 2012/08/03
  * �޸ļ�¼: 
  */
public interface IG342DAO extends BaseHibernateDAO<IG342Info> {

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG342SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG342Info> findByCond(
			final IG342SearchCond cond, final int start,
			final int count);

}