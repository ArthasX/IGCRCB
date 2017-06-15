/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCond;

/**
  * ����: ��ѡ����DAO�ӿ�
  * ��������: ��ѡ����DAO�ӿ�
  * ������¼: 2016/10/09
  * �޸ļ�¼: 
  */
public interface OptionSencesDAO extends BaseHibernateDAO<OptionSencesInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OptionSencesInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public OptionSencesInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final OptionSencesSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<OptionSencesInfo> findByCond(
			final OptionSencesSearchCond cond, final int start,
			final int count);

}