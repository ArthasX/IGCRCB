/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.condition.IG343SearchCond;

/**
  * ����: IG343DAO�ӿ�
  * ��������: IG343DAO�ӿ�
  * ������¼: 2012/07/12
  * �޸ļ�¼: 
  */
public interface IG343DAO extends BaseHibernateDAO<IG343Info> {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG343Info> findByCond(
			final IG343SearchCond cond, final int start, final int count);
}