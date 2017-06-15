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
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditResultTB;

/**
 * ������ƽ��DAOʵ��
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditResultDAOImpl extends BaseHibernateDAOImpl<RiskAuditResult> implements RiskAuditResultDAO {

	/**
	 * ���캯��
	 */
	public RiskAuditResultDAOImpl(){
		super(RiskAuditResultTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAuditResult> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rarid"));
		List<RiskAuditResult> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rarid ����
	 * @return �������
	 */
	public RiskAuditResult findByPK(Serializable rarid) {

		RiskAuditResult result = super.findByPK(rarid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditResultSearchCond cond){
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
	public List<RiskAuditResult> findByCond(final RiskAuditResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rarid"));
		List<RiskAuditResult> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskAuditResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRaiid() != null && cond.getRaiid() != 0){
			c.add(Expression.eq("raiid", cond.getRaiid()));
		}
		if(cond.getRarid() != null && cond.getRarid() != 0){
			c.add(Expression.eq("rarid", cond.getRarid()));
		}
		if(cond.getRadid() != null && cond.getRadid() != 0){
			c.add(Expression.eq("radid", cond.getRadid()));
		}
		if( StringUtils.isNotEmpty(cond.getRaruserid())){
			c.add(Expression.eq("raruserid", cond.getRaruserid()));
		}
		if( !StringUtils.isEmpty(cond.getRadcode())){
			c.add(Expression.like("radcode", cond.getRadcode()+"%"));
		}
		return c;
	}



}
