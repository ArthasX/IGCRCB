/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.Ip_FilterTB;

/**
  * ����: ȫ��IP����DAOʵ��
  * ��������: ȫ��IP����DAOʵ��
  * ������¼: 2012/11/07
  * �޸ļ�¼: 
  */
public class Ip_FilterDAOImpl extends
		BaseHibernateDAOImpl<Ip_FilterInfo> implements Ip_FilterDAO {

	/**
	 * ���캯��
	 */
	public Ip_FilterDAOImpl(){
		super(Ip_FilterTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Ip_FilterInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("addtime"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Ip_FilterInfo findByPK(Serializable pk) {
		Ip_FilterInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Ip_FilterSearchCond cond){
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
	public List<Ip_FilterInfo> findByCond(final Ip_FilterSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Ip_FilterSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		/** IP��ַ */
		if(StringUtils.isNotEmpty(cond.getIp())){
		    c.add(Expression.eq("ip", cond.getIp()));
		}
		return c;
	}

}