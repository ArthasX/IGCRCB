/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;

/**
  * ����: �������ݰ汾�����DAO�ӿ�
  * ��������: �������ݰ汾�����DAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0120DAO extends BaseHibernateDAO<SOC0120Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0120Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0120Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0120SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0120Info> findByCond(
			final SOC0120SearchCond cond, final int start,
			final int count);
	
	/**
	 * �������汾����
	 * @param impversion 
	 */
	public List<SOC0120Info> searchImportVersionByImpname(String impeiname, Integer impversion);

	/**
	 * ������󲻴��ڼ��
	 * 
	 * @param impeinameʵ����
	 * @return
	 * @throws BLException 
	 */
	public List<SOC0120Info> findByImpeiname(SOC0120SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0120Info> findByCondAutoCollect(
			final SOC0120SearchCond cond, final int start,
			final int count);
}