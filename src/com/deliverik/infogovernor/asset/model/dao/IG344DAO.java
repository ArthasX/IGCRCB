/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCond;

/**
  * ����: IG344DAO�ӿ�
  * ��������: IG344DAO�ӿ�
  * ������¼: 2012/07/13
  * �޸ļ�¼: 
  */
public interface IG344DAO extends BaseHibernateDAO<IG344Info> {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG344Info> findByCond(
			final IG344SearchCond cond, final int start, final int count);

}