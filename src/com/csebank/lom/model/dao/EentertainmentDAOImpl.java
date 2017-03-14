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

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.csebank.lom.model.entity.EentertainmentTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ʳ�ýӴ�����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class EentertainmentDAOImpl extends BaseHibernateDAOImpl<Eentertainment> implements EentertainmentDAO {

	/**
	 * ���캯��
	 */
	public EentertainmentDAOImpl(){
		super(EentertainmentTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Eentertainment> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eedate"));
		List<Eentertainment> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param eeid ����
	 * @return �������
	 */
	public Eentertainment findByPK(Serializable eeid) {

		Eentertainment result = super.findByPK(eeid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EentertainmentSearchCond cond){
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
	public List<Eentertainment> findByCond(final EentertainmentSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eedate"));
		List<Eentertainment> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EentertainmentSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	
		//ʳ�óɱ���Ϣ��ʼʱ��
		if(StringUtils.isNotEmpty(cond.getEetime_from())){
			c.add(Expression.ge("eedate", cond.getEetime_from()));
		}

		//ʳ�óɱ���Ϣ����ʱ��
		if(StringUtils.isNotEmpty(cond.getEetime_to())){
			c.add(Expression.le("eedate", cond.getEetime_to()));
		}
		
		if(cond.getRid_mon()!=null && cond.getRid_mon()!=0){
			c.add(Expression.eq("rid", cond.getRid_mon()));
		}
		
		if(cond.getRid_org()!=null && cond.getRid_org()!=0){
			c.add(Expression.eq("rid", cond.getRid_org()));
		}

		return c;
	}

}
