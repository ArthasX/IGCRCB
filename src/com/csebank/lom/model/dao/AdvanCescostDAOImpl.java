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

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.csebank.lom.model.entity.AdvanCescostTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * Ԥ֧����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class AdvanCescostDAOImpl extends BaseHibernateDAOImpl<AdvanCescost> implements AdvanCescostDAO {

	/**
	 * ���캯��
	 */
	public AdvanCescostDAOImpl(){
		super(AdvanCescostTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<AdvanCescost> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("acid"));
		List<AdvanCescost> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param acid ����
	 * @return �������
	 */
	public AdvanCescost findByPK(Serializable acid) {

		AdvanCescost result = super.findByPK(acid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AdvanCescostSearchCond cond){
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
	public List<AdvanCescost> findByCond(final AdvanCescostSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("acid"));
		List<AdvanCescost> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AdvanCescostSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��ʼʱ��
		if(StringUtils.isNotEmpty(cond.getAcdate_from())){
			c.add(Expression.ge("acinsdate", cond.getAcdate_from()));
		}

		//����ʱ��
		if(StringUtils.isNotEmpty(cond.getAcdate_to())){
			c.add(Expression.le("acinsdate", cond.getAcdate_to()));
		}
		
		//״̬
		if(StringUtils.isNotEmpty(cond.getAcstatus_q())){
			c.add(Expression.eq("acstatus", cond.getAcstatus_q()));
		}
		return c;
	}

}
