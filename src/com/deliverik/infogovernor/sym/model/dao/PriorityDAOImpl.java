/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCond;
import com.deliverik.infogovernor.sym.model.entity.PriorityTB;

/**
 * ����:���ȼ�DAOʵ����
 * ����������1. ȫ������
 * 			2.���������������ȡ��
 * 			3.������������
 * ������¼��fangyunlong@deliverik.com    2010/12/14
 */
@SuppressWarnings("deprecation")
public class PriorityDAOImpl extends BaseHibernateDAOImpl<Priority> implements PriorityDAO {

	/**
	 * ���캯��
	 */
	public PriorityDAOImpl(){
		super(PriorityTB.class);
	}
	
	/**
     * ȫ������
     * @return ���������
     */
	public List<Priority> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		List<Priority> ret = findByCriteria(c);
		return ret;
	}

	 /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
	public List<Priority> findByCond(final PrioritySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ivalue"));
		List<Priority> ret = findByCriteria(c, start, count);
		return ret;
	}
	 /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
	public int getSearchCount(final PrioritySearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	protected DetachedCriteria getCriteria(PrioritySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( !StringUtils.isEmpty(cond.getPvalue())){
			c.add(Expression.eq("pvalue", cond.getPvalue()));
		}
		if( !StringUtils.isEmpty(cond.getIvalue())){
			c.add(Expression.eq("ivalue", cond.getIvalue()));
		}
		if( !StringUtils.isEmpty(cond.getUvalue())){
			c.add(Expression.eq("uvalue", cond.getUvalue()));
		}
		if( !StringUtils.isEmpty(cond.getPprtype())){
			c.add(Expression.eq("pprtype", cond.getPprtype()));
		}
		
		return c;
	}

}
