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
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00001TB;

/**
  * ����: �豸��Ϣ��DAOʵ��
  * ��������: �豸��Ϣ��DAOʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00001DAOImpl extends
		BaseHibernateDAOImpl<Mss00001Info> implements Mss00001DAO {

	/**
	 * ���캯��
	 */
	public Mss00001DAOImpl(){
		super(Mss00001TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00001Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00001Info findByPK(Serializable pk) {
		Mss00001Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00001SearchCond cond){
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
	public List<Mss00001Info> findByCond(final Mss00001SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Mss00001SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getTypeid())){
			c.add(Expression.eq("typeid",cond.getTypeid()));
		}
		if(StringUtils.isNotEmpty(cond.getDeviceip())){
			c.add(Expression.eq("deviceip",cond.getDeviceip()));
		}
		if(StringUtils.isNotEmpty(cond.getDeviceip2())){
			c.add(Expression.eq("deviceip2",cond.getDeviceip2()));
		}
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.or(Expression.eq("deviceip",cond.getIp_like()), Expression.eq("deviceip2",cond.getIp_like())));
		}
		if(StringUtils.isNotEmpty(cond.getDeviceip_like())){
			c.add(Expression.or(Expression.like("deviceip","%"+cond.getDeviceip_like()+"%"), Expression.like("deviceip2","%"+cond.getDeviceip_like()+"%")));
		}
		return c;
	}

}