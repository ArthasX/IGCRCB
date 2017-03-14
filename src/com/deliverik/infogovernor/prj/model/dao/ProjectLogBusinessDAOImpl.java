/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogBusinessSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogBusinessTB;

/**
  * ����: ��Ŀ��־�����DAOʵ��
  * ��������: ��Ŀ��־�����DAOʵ��
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ProjectLogBusinessDAOImpl extends
		BaseHibernateDAOImpl<ProjectLogBusinessInfo> implements ProjectLogBusinessDAO {

	/**
	 * ���캯��
	 */
	public ProjectLogBusinessDAOImpl(){
		super(ProjectLogBusinessTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProjectLogBusinessInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectLogBusinessInfo findByPK(Serializable pk) {
		ProjectLogBusinessInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProjectLogBusinessSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProjectLogBusinessInfo> findByCond(final ProjectLogBusinessSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("plbid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ProjectLogBusinessSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//projectID
		if( cond.getPlbpid() != null && cond.getPlbpid() != 0){
			c.add(Expression.eq("plbpid", cond.getPlbpid()));
		}
		//projectLogID
		if( cond.getPlbplid() != null && cond.getPlbplid() != 0){
			c.add(Expression.eq("plbplid", cond.getPlbplid()));
		}
		return c;
	}

}