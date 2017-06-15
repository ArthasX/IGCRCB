/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.condition.IG506SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;

/**
  * ����: ��Ա���ֵ��DAOʵ��
  * ��������: ��Ա���ֵ��DAOʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG506DAOImpl extends BaseHibernateDAOImpl<IG506Info> implements IG506DAO {

	/**
	 * ���캯��
	 */
	public IG506DAOImpl(){
		super(IG506TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG506Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG506Info findByPK(Serializable pk) {
		IG506Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG506SearchCond cond){
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
	public List<IG506Info> findByCond(final IG506SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG506SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		return c;
	}

}