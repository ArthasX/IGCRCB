/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.ScopesInfo;
import com.deliverik.infogovernor.drm.model.condition.ScopesSearchCond;
import com.deliverik.infogovernor.drm.model.entity.ScopesTB;

/**
  * ����: �¼�Ӱ�췶ΧDAOʵ��
  * ��������: �¼�Ӱ�췶ΧDAOʵ��
  * ������¼: 2015/03/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ScopesDAOImpl extends
		BaseHibernateDAOImpl<ScopesInfo> implements ScopesDAO {

	/**
	 * ���캯��
	 */
	public ScopesDAOImpl(){
		super(ScopesTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ScopesInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ScopesInfo findByPK(Serializable pk) {
		ScopesInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ScopesSearchCond cond){
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
	public List<ScopesInfo> findByCond(final ScopesSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ScopesSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(cond.getEventid()!=null&&cond.getEventid()!=0){
			c.add(Expression.eq("eventid", cond.getEventid()));
		}
		return c;
	}

}