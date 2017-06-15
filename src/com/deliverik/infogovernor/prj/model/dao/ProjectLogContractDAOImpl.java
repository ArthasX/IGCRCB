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
import com.deliverik.infogovernor.prj.model.ProjectLogContractInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogContractSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogContractTB;

/**
  * ����: ��Ŀ��־��ͬ��DAOʵ��
  * ��������: ��Ŀ��־��ͬ��DAOʵ��
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ProjectLogContractDAOImpl extends
		BaseHibernateDAOImpl<ProjectLogContractInfo> implements ProjectLogContractDAO {

	/**
	 * ���캯��
	 */
	public ProjectLogContractDAOImpl(){
		super(ProjectLogContractTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProjectLogContractInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectLogContractInfo findByPK(Serializable pk) {
		ProjectLogContractInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ProjectLogContractSearchCond cond){
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
	public List<ProjectLogContractInfo> findByCond(final ProjectLogContractSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("plcid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ProjectLogContractSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//projectID
		if( cond.getPlcpid() != null && cond.getPlcpid() != 0){
			c.add(Expression.eq("plcpid", cond.getPlcpid()));
		}
		//projectLogID
		if( cond.getPlcplid() != null && cond.getPlcplid() != 0){
			c.add(Expression.eq("plcplid", cond.getPlcplid()));
		}
		return c;
	}

}