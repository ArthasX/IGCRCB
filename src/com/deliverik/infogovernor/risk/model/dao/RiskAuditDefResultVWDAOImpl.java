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
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;

/**
 * ��������������������ͼ�ӿ�
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditDefResultVWDAOImpl extends BaseHibernateDAOImpl<RiskAuditDefResultVWInfo> implements RiskAuditDefResultVWDAO {

	/**
	 * ���캯��
	 */
	public RiskAuditDefResultVWDAOImpl(){
		super(RiskAuditDefResultVWInfo.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAuditDefResultVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("radcode"));
		List<RiskAuditDefResultVWInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param acrid ����
	 * @return �������
	 */
	public RiskAuditDefResultVWInfo findByPK(Serializable acrid) {

		RiskAuditDefResultVWInfo result = super.findByPK(acrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditDefResultVWSearchCond cond){
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
	public List<RiskAuditDefResultVWInfo> findByCond(final RiskAuditDefResultVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("radcode"));
		List<RiskAuditDefResultVWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskAuditDefResultVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRaiid() != null && cond.getRaiid() != 0){
			c.add(Expression.eq("raiid", cond.getRaiid()));
		}
		if( StringUtils.isNotEmpty(cond.getRadstatus())){
			c.add(Expression.eq("radstatus", cond.getRadstatus()));
		}
		return c;
	}

	/**
	 * ��ȡ�������󼶴�
	 * @return �������󼶴�
	 */
	
	@SuppressWarnings("unchecked")
	public String getMaxRadlevel(final RiskAuditDefResultVWSearchCond cond) {
		String sql =  "select max(radrVW.radlevel) from RiskAuditDefResultVW radrVW where raiid = :raiid and radstatus =:radstatus";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("raiid", cond.getRaiid());
		p.setString("radstatus", cond.getRadstatus());
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}

}
