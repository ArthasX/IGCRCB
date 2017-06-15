/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.emo.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.emo.model.EmInfo;
import com.deliverik.infogovernor.emo.model.condition.EmSearchCond;
import com.deliverik.infogovernor.emo.model.entity.EmTB;

/**
  * ����: oracle���ܲɼ�DAOʵ��
  * ��������: oracle���ܲɼ�DAOʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class EmDAOImpl extends
		BaseHibernateDAOImpl<EmInfo> implements EmDAO {

	/**
	 * ���캯��
	 */
	public EmDAOImpl(){
		super(EmTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmInfo findByPK(Serializable pk) {
		EmInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EmSearchCond cond){
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
	public List<EmInfo> findByCond(final EmSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EmSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		String type_str = "";
		if(StringUtils.isNotEmpty(cond.getEm_type())){
			c.add(Expression.eq("em_type", cond.getEm_type()));
			type_str = "where em_type='"+cond.getEm_type()+"'";
		}
		if(StringUtils.isNotEmpty(cond.getFingerprint())){
			c.add(Restrictions.sqlRestriction("fingerprint ='"+cond.getFingerprint()+"'"));
		}
		if(StringUtils.isNotEmpty(cond.getMax_collecttime())){
			c.add(Restrictions.sqlRestriction("em_collecttime = (select max(em_collecttime) from EM "+type_str+" and fingerprint='"+cond.getFingerprint()+"')"));
		}
		if(StringUtils.isNotEmpty(cond.getOrder_Totail_desc())){
			c.addOrder(Order.desc("em_Totail"));
		}
		return c;
	}

}