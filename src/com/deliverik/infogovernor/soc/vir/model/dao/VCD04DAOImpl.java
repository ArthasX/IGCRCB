/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD04TB;

/**
  * ����: vCloud������־DAOʵ��
  * ��������: vCloud������־DAOʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD04DAOImpl extends
		BaseHibernateDAOImpl<VCD04Info> implements VCD04DAO {

	/**
	 * ���캯��
	 */
	public VCD04DAOImpl(){
		super(VCD04TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD04Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD04Info findByPK(Serializable pk) {
		VCD04Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VCD04SearchCond cond){
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
	public List<VCD04Info> findByCond(final VCD04SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VCD04SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPid() != null && cond.getPid() > 0){
			c.add(Restrictions.eq("pid", cond.getPid()));
		}
		return c;
	}

}