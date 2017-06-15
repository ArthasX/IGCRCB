/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.infogovernor.soc.model.condition.PortRelationSearchCond;

/**
  * ����: �˵��˹�ϵ��DAO�ӿ�
  * ��������: �˵��˹�ϵ��DAO�ӿ�
  * ������¼: 2013/01/17
  * �޸ļ�¼: 
  */
public interface PortRelationDAO extends BaseHibernateDAO<PortRelationInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PortRelationInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PortRelationInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PortRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PortRelationInfo> findByCond(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * ʣ��Hyper��ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<String> findByCondStr(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * ҵ��ϵͳ��ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondBuss(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * ����&HBA�ؼ��ֲ�ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondHost(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * �������ؼ��ֲ�ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondSwitch(
			final PortRelationSearchCond cond, final int start,
			final int count);
	/**
	 * FA
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondFa(
			final PortRelationSearchCond cond, final int start,
			final int count);

	/**
	 * ��ѯmeta��geteKeeper
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */	
	public List<String> findByCondHyper(
			final PortRelationSearchCond cond, final int start,
			final int count);	
	/**
	 * ��·��ѯHyper�õ�FAeiid
	 * @return
	 */		
	public List<String> getHypeEiid(final String eiid,final String einame);
}