/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM01SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM01TB;

/**
  * ����: vCenter ServiceInstanceDAOʵ��
  * ��������: vCenter ServiceInstanceDAOʵ��
  * ������¼: 2014/02/12
  * �޸ļ�¼: 
  */
public class VIM01DAOImpl extends
		BaseHibernateDAOImpl<VIM01Info> implements VIM01DAO {

	/**
	 * ���캯��
	 */
	public VIM01DAOImpl(){
		super(VIM01TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM01Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM01Info findByPK(Serializable pk) {
		VIM01Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM01SearchCond cond){
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
	public List<VIM01Info> findByCond(final VIM01SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VIM01SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getVcurl())){
		    c.add(Restrictions.eq("vcurl", cond.getVcurl()));
		}
		return c;
	}

}