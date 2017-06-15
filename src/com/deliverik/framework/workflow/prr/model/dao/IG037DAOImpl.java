/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG037Info;
import com.deliverik.framework.workflow.prr.model.condition.IG037SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG037TB;

/**
  * ����: ���̵�����־��DAOʵ��
  * ��������: ���̵�����־��DAOʵ��
  * ������¼: 2014/11/14
  * �޸ļ�¼: 
  */
public class IG037DAOImpl extends
		BaseHibernateDAOImpl<IG037Info> implements IG037DAO {

	/**
	 * ���캯��
	 */
	public IG037DAOImpl(){
		super(IG037TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG037Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG037Info findByPK(Serializable pk) {
		IG037Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG037SearchCond cond){
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
	public List<IG037Info> findByCond(final IG037SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG037SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��������
		if(cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		
		//���̵����û�ID
		if(StringUtils.isBlank(cond.getIruserid())){
			c.add(Restrictions.eq("iruserid", cond.getIruserid()));
		}
		
		//���̵��벿��ID
		if(StringUtils.isBlank(cond.getIrorgid())){
			c.add(Restrictions.eq("irorgid", cond.getIrorgid()));
		}
		
		//���̵��벿��ID��ƥ��
		if(StringUtils.isBlank(cond.getIrorgid_like_l())){
			c.add(Restrictions.like("irorgid", cond.getIrorgid_like_l()));
		}
		
		return c;
	}

}