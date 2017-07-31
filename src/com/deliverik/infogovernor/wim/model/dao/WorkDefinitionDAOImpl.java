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
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkDefinitionSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;

/**
  * ����: ��������DAOʵ��
  * ��������: ��������DAOʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkDefinitionDAOImpl extends
		BaseHibernateDAOImpl<WorkDefinitionInfo> implements WorkDefinitionDAO {

	/**
	 * ���캯��
	 */
	public WorkDefinitionDAOImpl(){
		super(WorkDefinitionTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkDefinitionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkDefinitionInfo findByPK(Serializable pk) {
		WorkDefinitionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkDefinitionSearchCond cond){
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
	public List<WorkDefinitionInfo> findByCond(final WorkDefinitionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("crtDate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(WorkDefinitionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//����������
		if(StringUtils.isNotEmpty(cond.getWdname())){
			c.add(Restrictions.like("wdname", "%"+cond.getWdname()+"%"));
		}
		
		//������
		if(StringUtils.isNotEmpty(cond.getInitiatorId())){
			c.add(Restrictions.like("initiatorId", "%"+cond.getInitiatorId()+"%"));
		}
		
		//�෢����
		if(cond.getInitiatorId_in()!=null && cond.getInitiatorId_in().size()>0){
			c.add(Restrictions.in("initiatorId", cond.getInitiatorId_in()));
		}
		
		//����������
		if(StringUtils.isNotEmpty(cond.getLeaderName())){
			c.add(Restrictions.like("leaderName", "%"+cond.getLeaderName()+"%"));
		}
		
		//����״̬��0��δ���ã�1�������ã�ȡ��
		if(StringUtils.isNotEmpty(cond.getWdstatus())){
			c.add(Restrictions.eq("wdstatus",cond.getWdstatus()));
		}
		
		//��ʼ���ڴ� 
		if(StringUtils.isNotEmpty(cond.getBeginDateStart())){
			c.add(Restrictions.ge("beginDate", cond.getBeginDateStart()));
		}
		
		//��ʼ���ڵ�
		if(StringUtils.isNotEmpty(cond.getBeginDateOver())){
			c.add(Restrictions.le("beginDate", cond.getBeginDateOver()));
		}
		
		return c;
	}

}