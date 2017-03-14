/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM04TB;

/**
  * ����: ��־��DAOʵ��
  * ��������: ��־��DAOʵ��
  * ������¼: 2014/02/19
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class VIM04DAOImpl extends
		BaseHibernateDAOImpl<VIM04Info> implements VIM04DAO {

	/**
	 * ���캯��
	 */
	public VIM04DAOImpl(){
		super(VIM04TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM04Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM04Info findByPK(Serializable pk) {
		VIM04Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM04SearchCond cond){
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
	public List<VIM04Info> findByCond(final VIM04SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VIM04SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (null != cond.getPid_eq()) {
		    c.add(Restrictions.eq("pid", cond.getPid_eq()));
		}
		return c;
	}

}