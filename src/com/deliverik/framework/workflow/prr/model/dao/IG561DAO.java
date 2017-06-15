/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCond;

/**
  * ����: ״̬��˽�б�ֵ��¼��DAO�ӿ�
  * ��������: ״̬��˽�б�ֵ��¼��DAO�ӿ�
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public interface IG561DAO extends BaseHibernateDAO<IG561Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG561Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG561Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG561SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG561Info> findByCond(
			final IG561SearchCond cond, final int start,
			final int count);
	
	
	/**
     * ���̹رսڵ� ״̬˽�б���ʾ��ѯ������������ʾ��״̬��˽�б�����ʾ����
     * @Title: searchIG561VW
     * @Description: ���̹رսڵ� ״̬˽�б���ʾ��ѯ������������ʾ��״̬��˽�б�����ʾ����
     * @param 
     * prid ����id 
     * ppuserid ������id
     * isAdmin �Ƿ������̹���Ա
     * @return list561VW
     * @throws
     */
    public List<IG561VWInfo> searchIG561VW(final String prid ,final String ppuserid,final boolean isAdmin);


}