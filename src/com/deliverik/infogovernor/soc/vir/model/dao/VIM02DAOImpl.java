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
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;

/**
  * ����: ������Դ��Ŀ��Ϣ��DAOʵ��
  * ��������: ������Դ��Ŀ��Ϣ��DAOʵ��
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class VIM02DAOImpl extends
		BaseHibernateDAOImpl<VIM02Info> implements VIM02DAO {

	/**
	 * ���캯��
	 */
	public VIM02DAOImpl(){
		super(VIM02TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM02Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM02Info findByPK(Serializable pk) {
		VIM02Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM02SearchCond cond){
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
	public List<VIM02Info> findByCond(final VIM02SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VIM02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (StringUtils.isNotEmpty(cond.getProgress_eq())) {
		    c.add(Restrictions.eq("progress", cond.getProgress_eq()));
		}
		
		return c;
	}

}