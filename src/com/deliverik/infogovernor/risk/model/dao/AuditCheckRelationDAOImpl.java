/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCond;
import com.deliverik.infogovernor.risk.model.entity.AuditCheckRelationTB;

/**
 * �����������ռ���ϵDAOʵ��
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class AuditCheckRelationDAOImpl extends BaseHibernateDAOImpl<AuditCheckRelation> implements AuditCheckRelationDAO {

	/**
	 * ���캯��
	 */
	public AuditCheckRelationDAOImpl(){
		super(AuditCheckRelationTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<AuditCheckRelation> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("acrid"));
		List<AuditCheckRelation> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param acrid ����
	 * @return �������
	 */
	public AuditCheckRelation findByPK(Serializable acrid) {

		AuditCheckRelation result = super.findByPK(acrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditCheckRelationSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditCheckRelation> findByCond(final AuditCheckRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("acrid"));
		List<AuditCheckRelation> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AuditCheckRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRadid() != null && cond.getRadid() != 0){
			c.add(Expression.eq("radid", cond.getRadid()));
		}
		if(cond.getRcid() != null && cond.getRcid() != 0){
			c.add(Expression.eq("rcid", cond.getRcid()));
		}
		return c;
	}



}
