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
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditTB;

/**
 * �������DAOʵ��
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditDAOImpl extends BaseHibernateDAOImpl<RiskAudit> implements RiskAuditDAO {

	/**
	 * ���캯��
	 */
	public RiskAuditDAOImpl(){
		super(RiskAuditTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAudit> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("raid"));
		List<RiskAudit> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public RiskAudit findByPK(Serializable raid) {

		RiskAudit result = super.findByPK(raid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditSearchCond cond){
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
	public List<RiskAudit> findByCond(final RiskAuditSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("raid"));
		List<RiskAudit> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskAuditSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRaid() != null && cond.getRaid() != 0){
			c.add(Expression.eq("raid", cond.getRaid()));
		}
		if( StringUtils.isNotEmpty(cond.getRaversion())){
			c.add(Expression.eq("raversion", cond.getRaversion()));
		}
		if( StringUtils.isNotEmpty(cond.getRastatus())){
			c.add(Expression.eq("rastatus", cond.getRastatus()));
		}
		return c;
	}

	/**
	 * ��ȡ��ǰ���汾����ʶ
	 * @return ���汾����ʶ
	 */
	
	@SuppressWarnings("unchecked")
	public String getMaxRacode() {
		String sql =  "select max(ra.racode) from RiskAuditTB ra";
		NamedParamMap p = getNamedParamMap();
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}

}
