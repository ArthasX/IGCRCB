/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainrecordSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainrecordTB;

/**
  * ����: ��ѵ��¼DAOʵ��
  * ��������: ��ѵ��¼DAOʵ��
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public class TrainrecordDAOImpl extends
		BaseHibernateDAOImpl<TrainrecordInfo> implements TrainrecordDAO {

	/**
	 * ���캯��
	 */
	public TrainrecordDAOImpl(){
		super(TrainrecordTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TrainrecordInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TrainrecordInfo findByPK(Serializable pk) {
		TrainrecordInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TrainrecordSearchCond cond){
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
	public List<TrainrecordInfo> findByCond(final TrainrecordSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(TrainrecordSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getTrname())){
			c.add(Restrictions.like("trname", "%"+cond.getTrname()+"%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getTrstimeFrom())){
			c.add(Restrictions.ge("trstime", cond.getTrstimeFrom()));
		}
		
		if(StringUtils.isNotEmpty(cond.getTrstimeTo())){
			c.add(Restrictions.le("trstime", cond.getTrstimeTo()));
		}
		
		return c;
	}

}