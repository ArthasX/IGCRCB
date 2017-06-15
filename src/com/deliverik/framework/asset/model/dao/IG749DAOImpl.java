/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.condition.IG749SearchCond;
import com.deliverik.framework.asset.model.entity.IG749VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: �ʲ�ģ����ͼDAOʵ��
  * ��������: �ʲ�ģ����ͼDAOʵ��
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public class IG749DAOImpl extends
		BaseHibernateDAOImpl<IG749Info> implements IG749DAO {

	/**
	 * ���캯��
	 */
	public IG749DAOImpl(){
		super(IG749VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG749Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG749Info findByPK(Serializable pk) {
		IG749Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG749SearchCond cond){
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
	public List<IG749Info> findByCond(final IG749SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG749SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}