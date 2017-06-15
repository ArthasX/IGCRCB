/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG484TB;

/**
  * ����: �������Աʵ��DAOʵ��
  * ��������: �������Աʵ��DAOʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG484DAOImpl extends
		BaseHibernateDAOImpl<IG484Info> implements IG484DAO {

	/**
	 * ���캯��
	 */
	public IG484DAOImpl(){
		super(IG484TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG484Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG484Info findByPK(Serializable pk) {
		IG484Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG484SearchCond cond){
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
	public List<IG484Info> findByCond(final IG484SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG484SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//������ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		//������ID
		if(cond.getPgrid() != null && cond.getPgrid() > 0){
			c.add(Restrictions.eq("pgrid", cond.getPgrid()));
		}
		return c;
	}

}