/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.TrainparticipateInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainparticipateSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainparticipateTB;

/**
  * ����: ��ѵ������DAOʵ��
  * ��������: ��ѵ������DAOʵ��
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public class TrainparticipateDAOImpl extends
		BaseHibernateDAOImpl<TrainparticipateInfo> implements TrainparticipateDAO {

	/**
	 * ���캯��
	 */
	public TrainparticipateDAOImpl(){
		super(TrainparticipateTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainparticipateInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainparticipateInfo findByPK(Serializable pk) {
		TrainparticipateInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TrainparticipateSearchCond cond){
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
	public List<TrainparticipateInfo> findByCond(final TrainparticipateSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(TrainparticipateSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTrid() != null && cond.getTrid() > 0){
			c.add(Restrictions.eq("trid", cond.getTrid()));
		}
		return c;
	}

}