/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM07SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM07TB;

/**
  * ����: ���������Ϣ��DAOʵ��
  * ��������: ���������Ϣ��DAOʵ��
  * ������¼: 2014/03/24
  * �޸ļ�¼: 
  */
public class VIM07DAOImpl extends BaseHibernateDAOImpl<VIM07Info> implements VIM07DAO {

	/**
	 * ���캯��
	 */
	public VIM07DAOImpl(){
		super(VIM07TB.class);
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM07SearchCond cond){
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
	public List<VIM07Info> findByCond(VIM07SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VIM07SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		if(cond.getPid() != null && cond.getPid() > 0){
			c.add(Restrictions.eq("pid", cond.getPid()));
		}
		return c;
	}

}