/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkLogTB;

/**
  * ����: ������־DAOʵ��
  * ��������: ������־DAOʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkLogDAOImpl extends
		BaseHibernateDAOImpl<WorkLogInfo> implements WorkLogDAO {

	/**
	 * ���캯��
	 */
	public WorkLogDAOImpl(){
		super(WorkLogTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkLogInfo findByPK(Serializable pk) {
		WorkLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkLogSearchCond cond){
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
	public List<WorkLogInfo> findByCond(final WorkLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("actualDealwithDate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(WorkLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�����Ĺ���ʵ����wiid��
		if(cond.getWiid()!=null&&cond.getWiid()>0){
			c.add(Restrictions.eq("wiid", cond.getWiid()));
		}
		
		//ִ���ˣ�userid��
		if(StringUtils.isNotEmpty(cond.getExcutorId())){
			c.add(Restrictions.eq("excutorId", cond.getExcutorId()));
		}
		
		//����������
		if(StringUtils.isNotEmpty(cond.getTitleDate())){
			c.add(Restrictions.like("titleDate", cond.getTitleDate()+"%"));
		}
		
		//ִ��ʱ��
		if(StringUtils.isNotEmpty(cond.getExcuteTime())){
			c.add(Restrictions.like("excuteTime", cond.getExcuteTime()+"%"));
		}
		
		//ʵ�ʴ�������
		if(StringUtils.isNotEmpty(cond.getActualDealwithDate())){
			c.add(Restrictions.like("actualDealwithDate", cond.getActualDealwithDate()+"%"));
		}
		
		//���¼��������
		if(StringUtils.isNotEmpty(cond.getCrtDate())){
			c.add(Restrictions.like("crtDate", cond.getCrtDate()+"%"));
		}
		
		//���¼��������
		if(StringUtils.isNotEmpty(cond.getBtnAction())){
			c.add(Restrictions.eq("btnAction", cond.getBtnAction()));
		}
		
		return c;
	}

}