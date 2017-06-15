/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCond;

/**
 * ����: ��Ŀ��Ԥ���ϵ���ѯDAO�ӿ�
 * ������������Ŀ��Ԥ���ϵ���ѯDAO�ӿ�
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
public interface ProjectBudgetRelationDAO extends BaseHibernateDAO<ProjectBudgetRelationInfo>{
	/***
	 * ��������
	 * @param cond ��������
	 * @param start ��ʼҳ
	 * @param count ��¼����
	 * @return �������Ľ����
	 */
	public List<ProjectBudgetRelationInfo> findBycond(ProjectBudgetRelationSearchCond cond,int start,int count);
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectBudgetRelationInfo findByPK(Serializable pk);
}
