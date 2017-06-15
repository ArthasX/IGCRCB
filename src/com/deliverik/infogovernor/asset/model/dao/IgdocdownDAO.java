/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.IgdocdownInfo;
import com.deliverik.infogovernor.asset.model.condition.IgdocdownSearchCond;

/**
  * ����: ���ؼ�¼��DAO�ӿ�
  * ��������: ���ؼ�¼��DAO�ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface IgdocdownDAO extends BaseHibernateDAO<IgdocdownInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IgdocdownInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IgdocdownInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IgdocdownSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgdocdownInfo> findByCond(
			final IgdocdownSearchCond cond, final int start,
			final int count);

	public List<IgdocdownInfo> insertDate(IgdocdownSearchCond cond);

}