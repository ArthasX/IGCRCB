/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG900Info;
import com.deliverik.framework.workflow.prd.model.condition.IG900SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG900TB;

/**
  * ����: ���̰�ť�����DAOʵ��
  * ��������: ���̰�ť�����DAOʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public class IG900DAOImpl extends
		BaseHibernateDAOImpl<IG900Info> implements IG900DAO {

	/**
	 * ���캯��
	 */
	public IG900DAOImpl(){
		super(IG900TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG900Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG900Info findByPK(Serializable pk) {
		IG900Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG900SearchCond cond){
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
	public List<IG900Info> findByCond(final IG900SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG900SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}