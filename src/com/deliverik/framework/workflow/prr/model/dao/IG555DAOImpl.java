/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG555Info;
import com.deliverik.framework.workflow.prr.model.condition.IG555SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG555TB;

/**
  * ����: ���̴���ҳ����������ϢDAOʵ��
  * ��������: ���̴���ҳ����������ϢDAOʵ��
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
public class IG555DAOImpl extends
		BaseHibernateDAOImpl<IG555Info> implements IG555DAO {

	/**
	 * ���캯��
	 */
	public IG555DAOImpl(){
		super(IG555TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG555Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG555Info findByPK(Serializable pk) {
		IG555Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG555SearchCond cond){
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
	public List<IG555Info> findByCond(final IG555SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG555SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}