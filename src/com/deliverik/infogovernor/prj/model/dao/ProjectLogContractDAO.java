/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.ProjectLogContractInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogContractSearchCond;

/**
  * ����: ��Ŀ��־��ͬ��DAO�ӿ�
  * ��������: ��Ŀ��־��ͬ��DAO�ӿ�
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public interface ProjectLogContractDAO extends BaseHibernateDAO<ProjectLogContractInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProjectLogContractInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectLogContractInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProjectLogContractSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProjectLogContractInfo> findByCond(
			final ProjectLogContractSearchCond cond, final int start,
			final int count);

}