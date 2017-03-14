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
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00003SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00003TB;

/**
  * ����: �澯����������DAOʵ��
  * ��������: �澯����������DAOʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00003DAOImpl extends
		BaseHibernateDAOImpl<Mss00003Info> implements Mss00003DAO {

	/**
	 * ���캯��
	 */
	public Mss00003DAOImpl(){
		super(Mss00003TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00003Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00003Info findByPK(Serializable pk) {
		Mss00003Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00003SearchCond cond){
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
	public List<Mss00003Info> findByCond(final Mss00003SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Mss00003SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
//		if( !StringUtils.isEmpty(cond.getRuleid().toString())){
//			c.add(Expression.eq("ruleid", cond.getRuleid()));
//		}
		if(!StringUtils.isEmpty(cond.getIsTemp())){
			if("1".equals(cond.getIsTemp())){
				c.add(Expression.isNotNull("ruletempid"));
			}else if("2".equals(cond.getIsTemp())){
				c.add(Expression.isNull("ruletempid"));
			}
		}
		if(cond.getRuletempid()!=null){
			c.add(Expression.eq("ruletempid", cond.getRuletempid()));
		}
		return c;
	}

}