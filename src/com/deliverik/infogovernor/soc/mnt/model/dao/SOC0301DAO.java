/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCond;

/**
  * ����: DMXʵʱ������ܱ�DAO�ӿ�
  * ��������: DMXʵʱ������ܱ�DAO�ӿ�
  * ������¼: 2012/05/16
  * �޸ļ�¼: 
  */
public interface SOC0301DAO extends BaseHibernateDAO<SOC0301Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0301Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0301Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0301SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0301Info> findByCond(
			final SOC0301SearchCond cond, final int start,
			final int count);
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public  List<SOC0301Info> findByCondOrderByTimeAndName(final SOC0301SearchCond cond, final int start,
			final int count);

}