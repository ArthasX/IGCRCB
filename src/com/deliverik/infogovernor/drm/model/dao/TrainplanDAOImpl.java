/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainplanSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainplanTB;

/**
  * ����: ��ѵ�ƻ���DAOʵ��
  * ��������: ��ѵ�ƻ���DAOʵ��
  * ������¼: 2015/04/10
  * �޸ļ�¼: 
  */
public class TrainplanDAOImpl extends
		BaseHibernateDAOImpl<TrainplanInfo> implements TrainplanDAO {

	/**
	 * ���캯��
	 */
	public TrainplanDAOImpl(){
		super(TrainplanTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainplanInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainplanInfo findByPK(Serializable pk) {
		TrainplanInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TrainplanSearchCond cond){
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
	public List<TrainplanInfo> findByCond(final TrainplanSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(TrainplanSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTporgname() != null && !"".equals(cond.getTporgname())){
		
			c.add(Restrictions.like("tporgname", "%"+cond.getTporgname()+"%"));
		}
		
		if(cond.getTpusername() != null && !"".equals(cond.getTpusername())){
			
			c.add(Restrictions.like("tpusername", "%"+cond.getTpusername()+"%"));
		}
		
		if( cond.getStartTimeBegin() != null && !"".equals(cond.getStartTimeBegin())){
			c.add(Restrictions.ge("tptime", cond.getStartTimeBegin()));
		}
		
		if( cond.getStartTimeEnd() != null && !"".equals(cond.getStartTimeEnd())){
			c.add(Restrictions.le("tptime", cond.getStartTimeEnd()));
		}
		return c;
	}

}