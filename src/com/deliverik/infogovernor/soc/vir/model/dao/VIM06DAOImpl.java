/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM06SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM06TB;

/**
  * ����: vim06DAOʵ��
  * ��������: vim06DAOʵ��
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class VIM06DAOImpl extends
		BaseHibernateDAOImpl<VIM06Info> implements VIM06DAO {

	/**
	 * ���캯��
	 */
	public VIM06DAOImpl(){
		super(VIM06TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM06Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM06Info findByPK(Serializable pk) {
		VIM06Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM06SearchCond cond){
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
	public List<VIM06Info> findByCond(final VIM06SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VIM06SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getStrategyid_eq())){
			c.add(Restrictions.eq("strategyid", Integer.parseInt(cond.getStrategyid_eq())));
			c.addOrder(Order.asc("resourceitem"));
		}
		return c;
	}

}