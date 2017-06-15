/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.condition.IG505SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG505TB;

/**
  * ����: ���̱�ֵ��DAOʵ��
  * ��������: ���̱�ֵ��DAOʵ��
  * ������¼: 2013/08/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG505DAOImpl extends BaseHibernateDAOImpl<IG505Info> implements IG505DAO {

	/**
	 * ���캯��
	 */
	public IG505DAOImpl(){
		super(IG505TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG505Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG505Info findByPK(Serializable pk) {
		IG505Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG505SearchCond cond){
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
	public List<IG505Info> findByCond(final IG505SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG505SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		return c;
	}

}