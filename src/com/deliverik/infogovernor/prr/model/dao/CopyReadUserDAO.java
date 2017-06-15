/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;

/**
  * ����: �����˱�DAO�ӿ�
  * ��������: �����˱�DAO�ӿ�
  * ������¼: 2013/02/25
  * �޸ļ�¼: 
  */
public interface CopyReadUserDAO extends BaseHibernateDAO<CopyReadUserInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CopyReadUserInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CopyReadUserInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CopyReadUserSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CopyReadUserInfo> findByCond(
			final CopyReadUserSearchCond cond, final int start,
			final int count);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public List<CopyReadUserInfo> getCopyReadUserInfo(
			final CopyReadUserSearchCond cond, final int start,final int count);
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int getCopyReadUserCount( final CopyReadUserSearchCond cond) ;
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public List<CopyReadUserInfo> getCopyReadUserInfoDesc(final CopyReadUserSearchCond cond, final int start,final int count);
}