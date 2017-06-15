/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM04SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM04TB;
import com.ibm.icu.text.SimpleDateFormat;

/**
  * ����: CRM04DAOʵ��
  * ��������: CRM04DAOʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CRM04DAOImpl extends
		BaseHibernateDAOImpl<CRM04Info> implements CRM04DAO {

	/**
	 * ���캯��
	 */
	public CRM04DAOImpl(){
		super(CRM04TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM04Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM04Info findByPK(Serializable pk) {
		CRM04Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM04SearchCond cond){
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
	public List<CRM04Info> findByCond(final CRM04SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		
		c.addOrder(Order.desc("alarmtime"));//����ʱ���ɽ���Զ����
		c.addOrder(Order.desc("rulelevel"));//���ռ����ɸߵ�������
		
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CRM04SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���澯IP��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.like("serverip", "%"+cond.getIp_like()+"%"));
		}
		if(cond.getPriority() != null && cond.getPriority().length != 0){
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		//����ʼ�ĸ澯����ʱ�䲻Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmtime_from())){
			//ת������ʱ��
			c.add(Expression.ge("alarmtime", cond.getAlarmtime_from()));
		//Ϊ��ʱĬ����ʾ�����ȫ���澯
		}else{
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String from = format.format(date) + " 00:00";
			c.add(Expression.ge("alarmtime", from));
		}
		//�������ĸ澯����ʱ�䲻Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmtime_to())){
			//ת������ʱ��
			c.add(Expression.le("alarmtime", cond.getAlarmtime_to()));
		}else{
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String to = format.format(date) + " 23:59";
			c.add(Expression.le("alarmtime", to));
		}
		//���澯���ݹؼ��ֲ�Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getWord_like())){
			c.add(Expression.like("alarmmsg", "%"+cond.getWord_like()+"%"));
		}
		c.add(Expression.eq("alarmstate","1"));
		return c;
	}

}