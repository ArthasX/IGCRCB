/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskStrategySearchCond;
import com.deliverik.infogovernor.ven.model.entity.RiskStrategyTB;

/**
  * ����: ���ղ��Ա�DAOʵ��
  * ��������: ���ղ��Ա�DAOʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class RiskStrategyDAOImpl extends
		BaseHibernateDAOImpl<RiskStrategyInfo> implements RiskStrategyDAO {

	/**
	 * ���캯��
	 */
	public RiskStrategyDAOImpl(){
		super(RiskStrategyTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskStrategyInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskStrategyInfo findByPK(Serializable pk) {
		RiskStrategyInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskStrategySearchCond cond){
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
	public List<RiskStrategyInfo> findByCond(final RiskStrategySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rsid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskStrategySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getRsname())){
			c.add(Restrictions.like("rsname","%"+cond.getRsname()+"%"));
		}
		return c;
	}

}