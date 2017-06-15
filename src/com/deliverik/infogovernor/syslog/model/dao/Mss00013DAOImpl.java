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
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00013TB;

/**
  * ����: mss00013DAOʵ��
  * ��������: mss00013DAOʵ��
  * ������¼: 2013/08/15
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00013DAOImpl extends
		BaseHibernateDAOImpl<Mss00013Info> implements Mss00013DAO {

	/**
	 * ���캯��
	 */
	public Mss00013DAOImpl(){
		super(Mss00013TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00013Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00013Info findByPK(Serializable pk) {
		Mss00013Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00013SearchCond cond){
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
	public List<Mss00013Info> findByCond(final Mss00013SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Mss00013SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getIp_eq())){
			c.add(Expression.eq("deviceip", cond.getIp_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getPriority_eq())){
			c.add(Expression.eq("rulelevel", cond.getPriority_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getContent())){
			c.add(Expression.eq("alarmmsg", cond.getContent()));
		}
		if (cond.getCvalue() != null && cond.getCvalue().length != 0) {
			c.add(Expression.in("rulelevel", cond.getCvalue()));
		}
		
		if (StringUtils.isNotEmpty(cond.getIp_like())) {
			c.add(Expression.like("deviceip", "%" + cond.getIp_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getContent_like())){
			c.add(Expression.like("alarmmsg", "%" + cond.getContent_like() + "%"));
		}
		return c;
	}

}