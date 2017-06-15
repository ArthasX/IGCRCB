/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00007Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00007SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00007TB;

/**
  * ����: �澯��Ϣ��ʷ��DAOʵ��
  * ��������: �澯��Ϣ��ʷ��DAOʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00007DAOImpl extends
		BaseHibernateDAOImpl<Mss00007Info> implements Mss00007DAO {

	/**
	 * ���캯��
	 */
	public Mss00007DAOImpl(){
		super(Mss00007TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00007Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00007Info findByPK(Serializable pk) {
		Mss00007Info result = super.findByPK(pk);
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
	public int getSearchCount(final Mss00007SearchCond cond) throws Exception{
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
	public List<Mss00007Info> findByCond(final Mss00007SearchCond cond, final int start, final int count) throws Exception{
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("syslogtime"));//����ʱ���ɽ���Զ����
		c.addOrder(Order.desc("rulelevel"));//���ռ����ɸߵ�������
		return findByCriteria(c, start, count);
	}

	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 * @throws BLException 
	 */
	protected DetachedCriteria getCriteria(Mss00007SearchCond cond) throws Exception{
		DetachedCriteria c = getDetachedCriteria();
		
		//���澯IP��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.like("deviceip", "%"+cond.getIp_like()+"%"));
		}
//		//���澯���ȼ���Ϊ��ʱ
//		if(StringUtils.isNotEmpty(cond.getPriority_eq())){
//			c.add(Expression.eq("rulelevel", cond.getPriority_eq()));
//		}
		//����ʼ�ĸ澯����ʱ�䲻Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmtime_from())){
			//ת������ʱ��
			c.add(Expression.ge("syslogtime", cond.getAlarmtime_from()));
		}
		//�������ĸ澯����ʱ�䲻Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmtime_to())){
			//ת������ʱ��
			c.add(Expression.le("syslogtime", cond.getAlarmtime_to()));
		}
		//���澯���ݹؼ��ֲ�Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getWord_like())){
			c.add(Expression.like("syslogmsg", "%"+cond.getWord_like()+"%"));
		}
		//���豸����syscoding��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		//���澯״̬alarmstate��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmstate())){
			c.add(Expression.eq("alarmstate", new Integer(cond.getAlarmstate())));
		}
		if(cond.getPriority() != null && cond.getPriority().length != 0){
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		
		return c;
	}

}