/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectBudgetRelationTB;

/**
 * ����: ��Ŀ��Ԥ���ϵ���ѯDAOʵ��
 * ������������Ŀ��Ԥ���ϵ���ѯDAOʵ��
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
public class ProjectBudgetRelationDAOImpl extends BaseHibernateDAOImpl<ProjectBudgetRelationInfo> implements ProjectBudgetRelationDAO{
	/**
	 * ���췽��
	 */
	public ProjectBudgetRelationDAOImpl(){
		super(ProjectBudgetRelationTB.class);
	}
	
	
	/***
	 * ��������
	 * @param cond ��������
	 * @param start ��ʼҳ
	 * @param count ��¼����
	 * @return �������Ľ����
	 */
	public List<ProjectBudgetRelationInfo> findBycond(ProjectBudgetRelationSearchCond cond,int start,int count) {
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c,start,count);
	}
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectBudgetRelationInfo findByPK(Serializable pk) {
		ProjectBudgetRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	@SuppressWarnings("deprecation")
	protected DetachedCriteria getCriteria(ProjectBudgetRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getBid_eq()!=null&&cond.getBid_eq()>0){
			c.add(Expression.eq("bid", cond.getBid_eq()));
		}
		if(cond.getPid_eq()!=null&&cond.getPid_eq()>0){
			c.add(Expression.eq("pid", cond.getPid_eq()));
		}
		return c;
	}
}
