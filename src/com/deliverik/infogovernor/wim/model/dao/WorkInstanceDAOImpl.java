/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;

/**
  * ����: ����ʵ��DAOʵ��
  * ��������: ����ʵ��DAOʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkInstanceDAOImpl extends
		BaseHibernateDAOImpl<WorkInstanceInfo> implements WorkInstanceDAO {

	/**
	 * ���캯��
	 */
	public WorkInstanceDAOImpl(){
		super(WorkInstanceTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkInstanceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkInstanceInfo findByPK(Serializable pk) {
		WorkInstanceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkInstanceSearchCond cond){
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
	public List<WorkInstanceInfo> findByCond(final WorkInstanceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(WorkInstanceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//����ʵ������
		if(StringUtils.isNotEmpty(cond.getWiname())){
			c.add(Restrictions.like("winame", ""+cond.getWiname()+""));
		}
		
		//����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����
		if(cond.getWistatus()!=null){
			c.add(Restrictions.eq("wistatus", ""+cond.getWistatus()+""));
		}
		
		//���ţ�id��
		if(StringUtils.isNotEmpty(cond.getWiDepartmentid())){
			c.add(Restrictions.eq("widepartmentid", cond.getWiDepartmentid()));
		}
		
		//��Ա��userid��
		if(StringUtils.isNotEmpty(cond.getWiuserid())){
			c.add(Restrictions.eq("wiuserid", cond.getWiuserid()));
		}
		
		//�������ͣ�1���Զ�����2���ֶ�����
		if(StringUtils.isNotEmpty(cond.getWiLunchType())){
			c.add(Restrictions.eq("wiLunchType", cond.getWiLunchType()));
		}
		
		//ִ������ʱ�䣨Сʱ��
		if(StringUtils.isNotEmpty(cond.getExcuteTime())){
			c.add(Restrictions.eq("excuteTime", cond.getExcuteTime()));
		}
		
		//ʵ�ʴ�������
		if(StringUtils.isNotEmpty(cond.getActualDealwithDate())){
			c.add(Restrictions.like("actualDealwithDate", cond.getActualDealwithDate()+"%"));
		}
		
		//����ȷ������
		if(StringUtils.isNotEmpty(cond.getConfirmDate())){
			c.add(Restrictions.like("confirmDate", cond.getConfirmDate()+"%"));
		}
		
		//����������
		if(StringUtils.isNotEmpty(cond.getTitleDate())){
			c.add(Restrictions.like("titleDate", cond.getTitleDate()+"%"));
		}
		
		//���¼����
		if(StringUtils.isNotEmpty(cond.getCrtDate())){
			c.add(Restrictions.like("crtDate", cond.getCrtDate()+"%"));
		}
		
		return c;
	}

}