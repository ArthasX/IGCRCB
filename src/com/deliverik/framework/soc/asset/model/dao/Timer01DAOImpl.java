/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;

/**
  * ����: timer01DAOʵ��
  * ��������: timer01DAOʵ��
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Timer01DAOImpl extends
		BaseHibernateDAOImpl<Timer01Info> implements Timer01DAO {

	/**
	 * ���캯��
	 */
	public Timer01DAOImpl(){
		super(Timer01TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Timer01Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Timer01Info findByPK(Serializable pk) {
		Timer01Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Timer01SearchCond cond){
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
	public List<Timer01Info> findByCond(final Timer01SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Timer01SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTypeNames_Notin() != null && cond.getTypeNames_Notin().size() != 0){
			c.add(Expression.not(Expression.in("typename", cond.getTypeNames_Notin())));
		}
		if(cond.getTypeNames_In() != null && cond.getTypeNames_In().size() != 0){
			c.add(Expression.in("typename", cond.getTypeNames_In()));
		}
		if(cond.getResourceid_Notin() != null && cond.getResourceid_Notin().size() != 0){
			c.add(Expression.not(Expression.in("resourceid", cond.getResourceid_Notin())));
		}
		return c;
	}

}