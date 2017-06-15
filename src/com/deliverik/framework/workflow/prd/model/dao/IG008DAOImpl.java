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
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG008TB;

/**
  * ����: ��Ա����ɫ�޶�DAOʵ��
  * ��������: ��Ա����ɫ�޶�DAOʵ��
  * ������¼: 2013/11/27
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG008DAOImpl extends
		BaseHibernateDAOImpl<IG008Info> implements IG008DAO {

	/**
	 * ���캯��
	 */
	public IG008DAOImpl(){
		super(IG008TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG008Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG008Info findByPK(Serializable pk) {
		IG008Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG008SearchCond cond){
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
	public List<IG008Info> findByCond(final IG008SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG008SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPidid())){
			c.add(Expression.eq("pidid", cond.getPidid()));
		}
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.like("pidid", cond.getPdid() + "%"));
		}
		return c;
	}

}