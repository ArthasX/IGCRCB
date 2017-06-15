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
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditDefTB;

/**
 * ���������DAOʵ��
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditDefDAOImpl extends BaseHibernateDAOImpl<RiskAuditDef> implements RiskAuditDefDAO {

	/**
	 * ���캯��
	 */
	public RiskAuditDefDAOImpl(){
		super(RiskAuditDefTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAuditDef> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("radid"));
		List<RiskAuditDef> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param radid ����
	 * @return �������
	 */
	public RiskAuditDef findByPK(Serializable radid) {

		RiskAuditDef result = super.findByPK(radid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditDefSearchCond cond){
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
	public List<RiskAuditDef> findByCond(final RiskAuditDefSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(!StringUtils.isEmpty(cond.getByLevelDesc())){
			c.addOrder(Order.desc("radlevel"));
		}else{
			c.addOrder(Order.asc("radcode"));
		}
		
		List<RiskAuditDef> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskAuditDefSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRaid() != null && cond.getRaid() != 0){
			c.add(Expression.eq("raid", cond.getRaid()));
		}
		if( StringUtils.isNotEmpty(cond.getRadstatus())){
			c.add(Expression.eq("radstatus", cond.getRadstatus()));
		}
		if( !StringUtils.isEmpty(cond.getRadcode())){
			c.add(Expression.like("radcode", cond.getRadcode()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getRadparcode_q())){
			c.add(Expression.eq("radparcode", cond.getRadparcode_q()));
		}
		if( !StringUtils.isEmpty(cond.getRadparcode())){
			c.add(Expression.like("radparcode", cond.getRadparcode()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getRadcode_q())){
			c.add(Expression.eq("radcode", cond.getRadcode_q()));
		}
		if( StringUtils.isNotEmpty(cond.getRaversion())){
			c.add(Expression.eq("raversion", cond.getRaversion()));
		}
		
		
		return c;
	}



}
