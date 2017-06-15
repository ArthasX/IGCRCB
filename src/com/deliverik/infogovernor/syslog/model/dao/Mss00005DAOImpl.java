/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00005SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00005TB;
import com.ibm.icu.text.SimpleDateFormat;

/**
  * ����: �澯��Ϣ���DAOʵ��
  * ��������: �澯��Ϣ���DAOʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00005DAOImpl extends
		BaseHibernateDAOImpl<Mss00005Info> implements Mss00005DAO {

	/**
	 * ���캯��
	 */
	public Mss00005DAOImpl(){
		super(Mss00005TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00005Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00005Info findByPK(Serializable pk) {
		Mss00005Info result = super.findByPK(pk);
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
	public int getSearchCount(final Mss00005SearchCond cond) throws Exception{
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
	public List<Mss00005Info> findByCond(final Mss00005SearchCond cond, final int start, final int count) throws Exception{
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
	protected DetachedCriteria getCriteria(Mss00005SearchCond cond) throws Exception{
		DetachedCriteria c = getDetachedCriteria();
		
		//���澯IP��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.like("deviceip", "%"+cond.getIp_like()+"%"));
		}
//		//���澯���ȼ���Ϊ��ʱ
//		if(StringUtils.isNotEmpty(cond.getPriority_eq())){
//			c.add(Expression.eq("rulelevel", cond.getPriority_eq()));
//		}
		if(cond.getPriority() != null && cond.getPriority().length != 0){
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		//����ʼ�ĸ澯����ʱ�䲻Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmtime_from())){
			//ת������ʱ��
			c.add(Expression.ge("syslogtime", cond.getAlarmtime_from()));
		//Ϊ��ʱĬ����ʾ�����ȫ���澯
		}else{
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String from = format.format(date) + " 00:00";
			c.add(Expression.ge("syslogtime", from));
		}
		//�������ĸ澯����ʱ�䲻Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmtime_to())){
			//ת������ʱ��
			c.add(Expression.le("syslogtime", cond.getAlarmtime_to()));
		}else{
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String to = format.format(date) + " 23:59";
			c.add(Expression.le("syslogtime", to));
		}
		//���澯���ݹؼ��ֲ�Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getWord_like())){
			c.add(Expression.like("syslogmsg", "%"+cond.getWord_like()+"%"));
		}
		//���豸����syscoding��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		//���澯״̬��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmstate())){
			c.add(Expression.eq("alarmstate", new Integer(cond.getAlarmstate())));
		}
		//��Ҫ�޸��ĸ澯id��Ϊ��ʱ
		if(cond.getIds() != null && cond.getIds().length != 0){
			Integer[] ids = new Integer[cond.getIds().length];
			for(int i = 0;i<cond.getIds().length;i++){
				ids[i] = Integer.parseInt(cond.getIds()[i]);
			}
			c.add(Expression.in("alarmid", ids));
		}
		return c;
	}
	
}