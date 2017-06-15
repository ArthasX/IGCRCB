/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;
import com.deliverik.infogovernor.rdp.model.condition.RealtimedetailSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.RealtimedetailTB;

/**
  * ����: ��־��ϢDAOʵ��
  * ��������: ��־��ϢDAOʵ��
  * ������¼: 2014/05/06
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class RealtimedetailDAOImpl extends
		BaseHibernateDAOImpl<RealtimedetailInfo> implements RealtimedetailDAO {

	/**
	 * ���캯��
	 */
	public RealtimedetailDAOImpl(){
		super(RealtimedetailTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<RealtimedetailInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
	public RealtimedetailInfo findByPK(Serializable pk) {
		RealtimedetailInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RealtimedetailSearchCond cond){
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
	public List<RealtimedetailInfo> findByCond(final RealtimedetailSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
//		c.addOrder(Order.desc("id"));
		c.addOrder(Order.asc("id"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RealtimedetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(null!=cond.getTaskid()){
			c.add(Expression.eq("taskid", cond.getTaskid()));
		}
		if(StringUtils.isNotEmpty(cond.getHostip())){
			c.add(Expression.eq("hostip", cond.getHostip()));
		}
		if(null!=cond.getRtdid_gt()){
			c.add(Expression.gt("id", cond.getRtdid_gt()));
		}
		return c;
	}

}