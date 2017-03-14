/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: CI����ԱȽ����Ϣ��DAO�ӿ�
  * ��������: CI����ԱȽ����Ϣ��DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIResultDAO extends BaseHibernateDAO<CIResultInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIResultInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIResultInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CIResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIResultInfo> findByCond(
			final CIResultSearchCond cond, final int start,
			final int count);

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateCIResultWithout(CIResultSearchCond cond)
		throws BLException;

}