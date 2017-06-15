/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;
import com.deliverik.framework.soc.asset.model.condition.Timer02SearchCond;
import com.deliverik.framework.soc.asset.model.entity.Timer02TB;

/**
  * ����: timer02DAOʵ��
  * ��������: timer02DAOʵ��
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Timer02DAOImpl extends
		BaseHibernateDAOImpl<Timer02Info> implements Timer02DAO {

	/**
	 * ���캯��
	 */
	public Timer02DAOImpl(){
		super(Timer02TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Timer02Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Timer02Info findByPK(Serializable pk) {
		Timer02Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Timer02SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Timer02Info> findByCond(final Timer02SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("collectdate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Timer02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getType())){
			c.add(Expression.eq("typename", cond.getType()));
		}
		if(StringUtils.isNotEmpty(cond.getCollectdate())){
			c.add(Expression.like("collectdate", "%"+cond.getCollectdate()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getExecutstatus())){
			c.add(Expression.eq("executstatus", cond.getExecutstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getUuid())){
			c.add(Expression.eq("uuid", cond.getUuid()));
		}
		return c;
	}
	
}