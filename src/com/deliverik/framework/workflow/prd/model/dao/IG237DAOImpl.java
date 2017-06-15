/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG237TB;

/**
  * ����: ���̲���֪ͨ��DAOʵ��
  * ��������: ���̲���֪ͨ��DAOʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG237DAOImpl extends
		BaseHibernateDAOImpl<IG237Info> implements IG237DAO {

	/**
	 * ���캯��
	 */
	public IG237DAOImpl(){
		super(IG237TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG237Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG237Info findByPK(Serializable pk) {
		IG237Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG237SearchCond cond){
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
	public List<IG237Info> findByCond(final IG237SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG237SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPsdid())) {
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdconfirm())) {
			c.add(Expression.eq("psdconfirm", cond.getPsdconfirm()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdid_like())) {
			c.add(Expression.like("psdid", cond.getPsdid_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPivalue())) {
			c.add(Expression.eq("pivalue", cond.getPivalue()));
		}
		return c;
	}

}