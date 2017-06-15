/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;

/**
  * ����: ��ƶԱȽ����Ϣ��DAO�ӿ�
  * ��������: ��ƶԱȽ����Ϣ��DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0103DAO extends BaseHibernateDAO<SOC0103Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0103Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0103Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0103SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0103Info> findByCond(
			final SOC0103SearchCond cond, final int start,
			final int count);

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateSOC0103Without(SOC0103SearchCond cond)
		throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0137Info> findByCondOne(SOC0103SearchCond cond);
}