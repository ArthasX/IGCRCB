/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditInsTB;

/**
 * ��Ʒ���ʵ��DAOʵ��
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditInsDAOImpl extends BaseHibernateDAOImpl<RiskAuditIns> implements RiskAuditInsDAO {

	/** RiskAuditIns DAO */
	protected RiskAuditInsDAO riskAuditInsDAO;
	/**
	 * ���캯��
	 */
	public RiskAuditInsDAOImpl(){
		super(RiskAuditInsTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAuditIns> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("raiid"));
		List<RiskAuditIns> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param raiid ����
	 * @return �������
	 */
	public RiskAuditIns findByPK(Serializable raiid) {

		RiskAuditIns result = super.findByPK(raiid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditInsSearchCond cond){
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
	public List<RiskAuditIns> findByCond(final RiskAuditInsSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("raiid"));
		List<RiskAuditIns> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskAuditInsSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( StringUtils.isNotEmpty(cond.getRaicode())){
			c.add(Expression.eq("raicode", cond.getRaicode()));
		}
		if( cond.getRaid() != null && cond.getRaid() != 0){
			c.add(Expression.eq("raid", cond.getRaid()));
		}
		if( cond.getRaiid() != null && cond.getRaiid() != 0){
			c.add(Expression.eq("raiid", cond.getRaiid()));
		}
		if( StringUtils.isNotEmpty(cond.getRaistart())){
			c.add(Expression.ge("raistart", cond.getRaistart()));
		}
		if( StringUtils.isNotEmpty(cond.getRaiend())){
			c.add(Expression.le("raiend", cond.getRaiend()));
		}
		if( StringUtils.isNotEmpty(cond.getRaistatus())){
			c.add(Expression.eq("raistatus", cond.getRaistatus()));
		}
		return c;
	}

}
