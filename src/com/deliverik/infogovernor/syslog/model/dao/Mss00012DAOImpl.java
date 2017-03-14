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
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00012SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00012TB;

/**
  * ����: MSS00012DAOʵ��
  * ��������: MSS00012DAOʵ��
  * ������¼: 2013/04/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00012DAOImpl extends
		BaseHibernateDAOImpl<Mss00012Info> implements Mss00012DAO {

	/**
	 * ���캯��
	 */
	public Mss00012DAOImpl(){
		super(Mss00012TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00012Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00012Info findByPK(Serializable pk) {
		Mss00012Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00012SearchCond cond) throws Exception{
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
	public List<Mss00012Info> findByCond(final Mss00012SearchCond cond, final int start, final int count) throws Exception{
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Mss00012SearchCond cond) throws Exception{
		DetachedCriteria c = getDetachedCriteria();
		
		//���澯IP��Ϊ��ʱ
		// ���澯IP��Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getIp_like())) {
			c.add(Expression.like("deviceip", "%" + cond.getIp_like() + "%"));
		}
		// ����ʼ�ĸ澯����ʱ�䲻Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getStarttime_from())) {
			// ת������ʱ��
			c.add(Expression.ge("starttime", cond.getStarttime_from()));
		}
		// �������ĸ澯����ʱ�䲻Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getStarttime_to())) {
			// ת������ʱ��
			c.add(Expression.le("starttime", cond.getStarttime_to()));
		}

		if (StringUtils.isNotEmpty(cond.getEndtime_from())) {
			// ת������ʱ��
			c.add(Expression.ge("endtime", cond.getEndtime_from()));
		}
		// �������ĸ澯����ʱ�䲻Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getStarttime_to())) {
			// ת������ʱ��
			c.add(Expression.le("endtime", cond.getStarttime_to()));
		}

		// ���澯���ݹؼ��ֲ�Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getWord_like())) {
			c.add(Expression.like("alarmmsg", "%" + cond.getWord_like() + "%"));
		}
		// ���豸����syscoding��Ϊ��ʱ
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		if (cond.getPriority() != null && cond.getPriority().length != 0) {
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		if (cond.getCvalue() != null && cond.getCvalue().length != 0) {
			c.add(Expression.in("rulelevel", cond.getCvalue()));
		}
		if (StringUtils.isNotEmpty(cond.getState())) {
			c.add(Expression.eq("state",Integer.parseInt(cond.getState())));
		}
		if(cond.getId()!=null&&cond.getId().length!=0)
		{
			c.add(Expression.in("id", cond.getId()));
		}
		return c;
	}

}