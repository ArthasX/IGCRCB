/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCond;

/**
  * ����: �Աȶ���DAO�ӿ�
  * ��������: �Աȶ���DAO�ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareobjectDAO extends BaseHibernateDAO<CompareobjectInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareobjectInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareobjectInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareobjectSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareobjectInfo> findByCond(
			final CompareobjectSearchCond cond, final int start,
			final int count);
	/**
	 * ת�ƶԱȶ��� ��ʷ����
	 * @param crid
	 * @return
	 */
	public boolean toHistory(Integer crid);
	
	/**
	 * ���ݹ���ɾ���Աȶ���
	 * @param crid
	 * @return
	 */
	public boolean delByCrid(Integer crid);
}