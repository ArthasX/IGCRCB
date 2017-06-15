/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;

/**
  * ����: ������ʵ����DAO�ӿ�
  * ��������: ������ʵ����DAO�ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG483DAO extends BaseHibernateDAO<IG483Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG483Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG483Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG483SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG483Info> findByCond(
			final IG483SearchCond cond, final int start,
			final int count);
	
	/**
	 * ��ѯ��ǰĬ�������ˮ�ţ�WG+2λ��+6λ��ˮ��
	 * @param pgrserialnum ��ˮ��
	 * @return �����ˮ��
	 */
	public String getMaxPgrserialnum(final String pgrserialnum);
	
	/**
	 * ��ѯ�������Ա�б�
	 * @param pgrid ������ID
	 * @return �������Ա�б�
	 */
	public List<IG500Info> searchProcess(final Integer pgrid);
	
	/**
	 * ��ѯ�������ⷢ�������prid
	 * @param pgrid ��������-������ʵ��ID
	 */
	public List<Map<String,Object>> searchProcessInfoByCond(final int pgrid);

}