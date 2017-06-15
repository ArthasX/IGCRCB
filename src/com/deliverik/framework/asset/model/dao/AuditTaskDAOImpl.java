/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCond;
import com.deliverik.framework.asset.model.entity.AuditTaskTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ��������DAOʵ��
  * ��������: ��������DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class AuditTaskDAOImpl extends
		BaseHibernateDAOImpl<AuditTaskInfo> implements AuditTaskDAO {

	/**
	 * ���캯��
	 */
	public AuditTaskDAOImpl(){
		super(AuditTaskTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditTaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditTaskInfo findByPK(Serializable pk) {
		AuditTaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditTaskSearchCond cond){
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
	public List<AuditTaskInfo> findByCond(final AuditTaskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("auttime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AuditTaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�����������
		if (StringUtils.isNotEmpty(cond.getAutdesc_like())) {
			c.add(Expression.like("autdesc", "%" + cond.getAutdesc_like() + "%"));
		}
		//״̬
		if (StringUtils.isNotEmpty(cond.getAutstatus_eq())) {
			c.add(Expression.eq("autstatus", cond.getAutstatus_eq()));
		}
		//ʱ��
		if(StringUtils.isNotEmpty(cond.getAuttime_from())||StringUtils.isNotEmpty(cond.getAuttime_to())){
			c.add(Expression.between("auttime", cond.getAuttime_from(), cond.getAuttime_to()));
		}
		return c;
	}

}