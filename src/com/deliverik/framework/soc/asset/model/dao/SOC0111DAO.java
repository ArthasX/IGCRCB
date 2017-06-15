/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;

/**
  * ����: �ʲ������DAO�ӿ�
  * ��������: �ʲ������DAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0111DAO extends BaseHibernateDAO<SOC0111Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0111Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0111Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0111SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0111Info> findByCond(
			final SOC0111SearchCond cond, final int start,
			final int count);
	/**
	 * ��ѯ���EiddId
	 * @return 
	 */
	public Integer findMaxEiddId();

	/**
	 * ��ȡ�ʲ�����汾
	 * @param eiddid
	 * @param version
	 * @return
	 */
	public List<SOC0111Info> searchEiDomainDefByPK(Integer eiddid,
			Integer version);

}