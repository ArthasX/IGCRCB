/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.condition.AdvanceSummarySearchCond;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.csebank.lom.model.entity.AdvanceSummaryTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * Ԥ֧����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class AdvanceSummaryDAOImpl extends BaseHibernateDAOImpl<AdvanceSummary> implements AdvanceSummaryDAO {

	/**
	 * ���캯��
	 */
	public AdvanceSummaryDAOImpl(){
		super(AdvanceSummaryTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<AdvanceSummary> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("asyear"));
		c.addOrder(Order.desc("asmonth"));
		List<AdvanceSummary> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param advanceSummaryTBPK ����
	 * @return �������
	 */
	public AdvanceSummary findByPK(Serializable advanceSummaryTBPK) {

		AdvanceSummary result = super.findByPK(advanceSummaryTBPK);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AdvanceSummarySearchCond cond){
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
	public List<AdvanceSummary> findByCond(final AdvanceSummarySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("asyear"));
		c.addOrder(Order.desc("asmonth"));
		List<AdvanceSummary> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AdvanceSummarySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		return c;
	}

	public List<AdvanceSummary> findByCond(AdvancesummaryCond cond, int start,
			int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("asyear"));
		c.addOrder(Order.asc("asmonth"));
		List<AdvanceSummary> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**Ԥ֧�¶�ͳ��
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AdvancesummaryCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//ͳ������
	
		if( !StringUtils.isEmpty(cond.getYear()) ){
			c.add(Expression.sql("asyear = '"+ cond.getYear()+"'"));
		}
		
		return c;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AdvancesummaryCond cond){
		DetachedCriteria c = getCriteria(cond);
		
		return getCount(c);
	}

}
