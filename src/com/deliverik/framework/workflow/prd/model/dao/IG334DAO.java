/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;

/**
  * ����: ֪ͨ���Ի�����ϢDAO�ӿ�
  * ��������: ֪ͨ���Ի�����ϢDAO�ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG334DAO extends BaseHibernateDAO<IG334Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG334Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG334Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG334SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG334Info> findByCond(
			final IG334SearchCond cond, final int start,
			final int count);

	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG334VWInfo> findByCondTactics(final IG334SearchCond cond);
}