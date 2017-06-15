/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG485Info;
import com.deliverik.framework.workflow.prr.model.condition.IG485SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;

/**
  * ����: �����������ϵʵ����DAO�ӿ�
  * ��������: �����������ϵʵ����DAO�ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG485DAO extends BaseHibernateDAO<IG485Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG485Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG485Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG485SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG485Info> findByCond(
			final IG485SearchCond cond, final int start,
			final int count);
	
	/**
	 * ����ָ�����̺�״̬����ѯ�������ϵʵ�����У�
	 * �����̵Ĳο����̺Ͳο�״̬�ļ�¼
	 * @param pgrid ������ID
	 * @param pgdid �����鶨��ID
	 * @param ipsdid Ӱ��״̬ID
	 * @return �ο������б�
	 */
	public List<Object[]> checkPend(final Integer pgrid, final String pgdid, final String ipsdid);
	
	/**
	 * ����ָ���������״̬����ѯ״̬��صĹ��������У�
	 * @param pgrid ������ʵ��ID
	 * @param ipsdid Ӱ��״̬ID
	 * @return Ӱ������ID�б�
	 */
	public List<IG224VW> searchPendPrid(final Integer pgrid, final String ipsdid);
	
	/**
	 * ��ѯ������ϵʵ��δ�����¼
	 * @param prid �ο�����ID
	 * @param rpsdid �ο�����״̬ID
	 * @return δ�����¼
	 */
	public List<IG485VW> searchNotDone(final Integer prid, final String rpsdid);

}