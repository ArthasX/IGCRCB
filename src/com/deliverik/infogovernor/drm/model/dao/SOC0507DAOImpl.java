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
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCond;
import com.deliverik.infogovernor.drm.model.entity.SOC0507TB;

/**
  * ����: Ԥ����Ϣ��DAOʵ��
  * ��������: Ԥ����Ϣ��DAOʵ��
  * ������¼: 2016/07/15
  * �޸ļ�¼: 
  */
public class SOC0507DAOImpl extends
		BaseHibernateDAOImpl<SOC0507Info> implements SOC0507DAO {

	/**
	 * ���캯��
	 */
	public SOC0507DAOImpl(){
		super(SOC0507TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0507Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0507Info findByPK(Serializable pk) {
		SOC0507Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0507SearchCond cond){
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
	public List<SOC0507Info> findByCond(final SOC0507SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0507SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//cid
		if(StringUtils.isNotEmpty(cond.getCid())){
			c.add(Restrictions.eq("cid", cond.getCid()));
		}
		//eid
		if(StringUtils.isNotEmpty(cond.getEid())){
			c.add(Restrictions.eq("eid", cond.getEid()));
		}
		//eiid
		if(cond.getEiid() != null && cond.getEiid() != 0){
			c.add(Restrictions.eq("eiid", cond.getEiid()));
		}
		//esyscoding
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Restrictions.eq("esyscoding", cond.getEsyscoding()));
		}
		return c;
	}

}