/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00002SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00002TB;

/**
  * ����: �澯�����DAOʵ��
  * ��������: �澯�����DAOʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00002DAOImpl extends
		BaseHibernateDAOImpl<Mss00002Info> implements Mss00002DAO {

	/**
	 * ���캯��
	 */
	public Mss00002DAOImpl(){
		super(Mss00002TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00002Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00002Info findByPK(Serializable pk) {
		Mss00002Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws Exception 
	 */
	public int getSearchCount(final Mss00002SearchCond cond) throws Exception{
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
	 * @throws Exception 
	 */
	public List<Mss00002Info> findByCond(final Mss00002SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 * @throws BLException 
	 */
	protected DetachedCriteria getCriteria(Mss00002SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getDeviceid())){
			c.add(Expression.eq("deviceid", Integer.parseInt(cond.getDeviceid())));
		}
		if(cond.getRuletempid()!= null){
			c.add(Expression.eq("ruletempid", cond.getRuletempid()));
		}
		return c;
	}

}