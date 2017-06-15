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
import com.deliverik.infogovernor.syslog.model.Mss00008Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00008SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00008TB;

/**
  * ����: SYSLOG��Ϣ��DAOʵ��
  * ��������: SYSLOG��Ϣ��DAOʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00008DAOImpl extends
		BaseHibernateDAOImpl<Mss00008Info> implements Mss00008DAO {

	/**
	 * ���캯��
	 */
	public Mss00008DAOImpl(){
		super(Mss00008TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00008Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00008Info findByPK(Serializable pk) {
		Mss00008Info result = super.findByPK(pk);
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
	public int getSearchCount(final Mss00008SearchCond cond) throws Exception{
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
	public List<Mss00008Info> findByCond(final Mss00008SearchCond cond, final int start, final int count) throws Exception{
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("createtime"));//����ʱ���ɽ���Զ����
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
	protected DetachedCriteria getCriteria(Mss00008SearchCond cond) throws Exception{
		DetachedCriteria c = getDetachedCriteria();
		
		//���澯IP��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getIp_like())){
			c.add(Expression.like("deviceip", "%"+cond.getIp_like()+"%"));
		}
		if(cond.getPriority() != null && cond.getPriority().length != 0){
			c.add(Expression.in("rulelevel", cond.getPriority()));
		}
		//����ʼ�ĸ澯����ʱ�䲻Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmtime_from())){
			//ת������ʱ��
			c.add(Expression.ge("createtime", cond.getAlarmtime_from()));
		
		}
		//�������ĸ澯����ʱ�䲻Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getAlarmtime_to())){
			//ת������ʱ��
			c.add(Expression.le("createtime", cond.getAlarmtime_to()));
		}
		//���澯���ݹؼ��ֲ�Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getWord_like())){
			c.add(Expression.like("alarmmsg", "%"+cond.getWord_like()+"%"));
		}
		//���豸����syscoding��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("devicetype", cond.getEsyscoding()));
		}
		
		if("2".equals(cond.getIsalarm())){//2Ϊ���ε�syslog
			c.add(Expression.eq("isalarm", 2));
		}else if("1".equals(cond.getIsalarm())){//1Ϊ�澯
			c.add(Expression.eq("isalarm", 1));
		}else if(StringUtils.isEmpty(cond.getIsalarm())){//���Ϊ�գ�����ʾ�����ε�syslog
			c.add(Expression.not(Expression.eq("isalarm", 2)));
		}
		
		return c;
	}
	

}