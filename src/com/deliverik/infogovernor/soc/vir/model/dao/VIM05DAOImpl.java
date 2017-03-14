/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM05SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM05TB;

/**
  * ����: vim05DAOʵ��
  * ��������: vim05DAOʵ��
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class VIM05DAOImpl extends
		BaseHibernateDAOImpl<VIM05Info> implements VIM05DAO {

	/**
	 * ���캯��
	 */
	public VIM05DAOImpl(){
		super(VIM05TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM05Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM05Info findByPK(Serializable pk) {
		VIM05Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VIM05SearchCond cond){
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
	public List<VIM05Info> findByCond(final VIM05SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VIM05SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getStrategyName_eq())){
			c.add(Restrictions.like("name", "%"+cond.getStrategyName_eq()+"%"));
		}
		return c;
	}

}