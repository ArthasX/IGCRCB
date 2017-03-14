/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;

/**
  * ����: ���չ�ϵ��DAO�ӿ�
  * ��������: ���չ�ϵ��DAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0121DAO extends BaseHibernateDAO<SOC0121Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0121Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0121Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0121SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0121Info> findByCond(
			final SOC0121SearchCond cond, final int start,
			final int count);

	/**
	 * ��ͼ�����˹�ϵ
	 * @return
	 */
	public List<SOC0121Info> searchShowStorageIOSnapshotRelation();

}