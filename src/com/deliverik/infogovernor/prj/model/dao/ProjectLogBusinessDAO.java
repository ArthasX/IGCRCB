/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogBusinessSearchCond;

/**
  * ����: ��Ŀ��־�����DAO�ӿ�
  * ��������: ��Ŀ��־�����DAO�ӿ�
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public interface ProjectLogBusinessDAO extends BaseHibernateDAO<ProjectLogBusinessInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProjectLogBusinessInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectLogBusinessInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProjectLogBusinessSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProjectLogBusinessInfo> findByCond(
			final ProjectLogBusinessSearchCond cond, final int start,
			final int count);

}