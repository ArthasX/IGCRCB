/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00011SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00011VW;

/**
  * ����: mss00011DAOʵ��
  * ��������: mss00011DAOʵ��
  * ������¼: 2013/04/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00011DAOImpl extends
		BaseHibernateDAOImpl<Mss00011Info> implements Mss00011DAO {

	/**
	 * ���캯��
	 */
	public Mss00011DAOImpl(){
		super(Mss00011VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00011Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00011Info findByPK(Serializable pk) {
		Mss00011Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00011SearchCond cond){
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
	public List<Mss00011Info> findByCond(final Mss00011SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Mss00011SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���澯IP��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getName_like())){
			c.add(Expression.like("devicename", "%"+cond.getName_like()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getType_eq())){
			c.add(Expression.eq("typeid", cond.getType_eq()));
		}
		return c;
	}

}