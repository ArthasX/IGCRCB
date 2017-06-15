/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCond;
import com.deliverik.infogovernor.drm.model.entity.OptionSencesTB;

/**
  * ����: ��ѡ����DAOʵ��
  * ��������: ��ѡ����DAOʵ��
  * ������¼: 2016/10/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class OptionSencesDAOImpl extends
		BaseHibernateDAOImpl<OptionSencesInfo> implements OptionSencesDAO {

	/**
	 * ���캯��
	 */
	public OptionSencesDAOImpl(){
		super(OptionSencesTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OptionSencesInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public OptionSencesInfo findByPK(Serializable pk) {
		OptionSencesInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final OptionSencesSearchCond cond){
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
	public List<OptionSencesInfo> findByCond(final OptionSencesSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(OptionSencesSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getPrid_eq() != null && cond.getPrid_eq() > 0) {
			
			c.add(Restrictions.eq("prid", cond.getPrid_eq()));
		}
		return c;
	}

}