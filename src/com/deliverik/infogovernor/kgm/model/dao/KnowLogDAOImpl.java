/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowLogTB;

/**
  * ����: knowLogDAOʵ��
  * ��������: knowLogDAOʵ��
  * ������¼: 2011/05/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class KnowLogDAOImpl extends
		BaseHibernateDAOImpl<KnowLogInfo> implements KnowLogDAO {

	/**
	 * ���캯��
	 */
	public KnowLogDAOImpl(){
		super(KnowLogTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<KnowLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public KnowLogInfo findByPK(Serializable pk) {
		KnowLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowLogSearchCond cond){
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
	public List<KnowLogInfo> findByCond(final KnowLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("klid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(KnowLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( cond.getKlkid() !=null && !"0".equals(cond.getKlkid())){
			c.add(Expression.eq("klkid", cond.getKlkid()));
		}
		return c;
	}

}