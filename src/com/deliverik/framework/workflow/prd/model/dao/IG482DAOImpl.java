/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG482TB;

/**
  * ����: �����������ϵ�����DAOʵ��
  * ��������: �����������ϵ�����DAOʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG482DAOImpl extends
		BaseHibernateDAOImpl<IG482Info> implements IG482DAO {

	/**
	 * ���캯��
	 */
	public IG482DAOImpl(){
		super(IG482TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG482Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG482Info findByPK(Serializable pk) {
		IG482Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG482SearchCond cond){
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
	public List<IG482Info> findByCond(final IG482SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG482SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�����鶨��ID
		if(StringUtils.isNotEmpty(cond.getPgdid())){
			c.add(Restrictions.eq("pgdid", cond.getPgdid()));
		}
		//�ο����̶���ID
		if(StringUtils.isNotEmpty(cond.getRpdid())){
			c.add(Restrictions.eq("rpdid", cond.getRpdid()));
		}
		return c;
	}

}