/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sya.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;
import com.deliverik.infogovernor.sya.model.condition.InstitutionSearchCond;
import com.deliverik.infogovernor.sya.model.entity.InstitutionTB;

/**
  * ����: ��Ч����DAOʵ��
  * ��������: ��Ч����DAOʵ��
  * ������¼: 2015/01/05
  * �޸ļ�¼: 
  */
public class InstitutionDAOImpl extends
		BaseHibernateDAOImpl<InstitutionInfo> implements InstitutionDAO {

	/**
	 * ���캯��
	 */
	public InstitutionDAOImpl(){
		super(InstitutionTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InstitutionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InstitutionInfo findByPK(Serializable pk) {
		InstitutionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InstitutionSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("createtime"));
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
	public List<InstitutionInfo> findByCond(final InstitutionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("createtime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(InstitutionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getInname())){
			c.add(Restrictions.like("inname","%" + cond.getInname() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getIntype())){
			c.add(Restrictions.like("intype", cond.getIntype().split("_tree_")[0]+"%"));
		}
		return c;
	}

}