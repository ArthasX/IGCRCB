/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.condition.AcceptuserSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.AcceptuserTB;

/**
  * ����: ���չ�����ʾ���������ݱ�DAOʵ��
  * ��������: ���չ�����ʾ���������ݱ�DAOʵ��
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public class AcceptuserDAOImpl extends
		BaseHibernateDAOImpl<AcceptuserInfo> implements AcceptuserDAO {

	/**
	 * ���캯��
	 */
	public AcceptuserDAOImpl(){
		super(AcceptuserTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AcceptuserInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AcceptuserInfo findByPK(Serializable pk) {
		AcceptuserInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AcceptuserSearchCond cond){
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
	public List<AcceptuserInfo> findByCond(final AcceptuserSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AcceptuserSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//������Ա����ID(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getAporgid())){
			c.add(Restrictions.eq("aporgid", cond.getAporgid()));
		}
		//������Աid(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getApuserid())){
			c.add(Restrictions.eq("apuserid", cond.getApuserid()));
		}
		
		//������ʾrwid
		if(cond.getRwid() != null && cond.getRwid() != 0){
			c.add(Restrictions.eq("rwid", cond.getRwid()));
		}
		return c;
	}

}