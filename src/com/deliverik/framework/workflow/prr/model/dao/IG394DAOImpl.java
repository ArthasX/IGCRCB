/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG394Info;
import com.deliverik.framework.workflow.prr.model.condition.IG394SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG394TB;

/**
  * ����: ���Ѽ�¼��DAOʵ��
  * ��������: ���Ѽ�¼��DAOʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG394DAOImpl extends
		BaseHibernateDAOImpl<IG394Info> implements IG394DAO {

	/**
	 * ���캯��
	 */
	public IG394DAOImpl(){
		super(IG394TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG394Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG394Info findByPK(Serializable pk) {
		IG394Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG394SearchCond cond){
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
	public List<IG394Info> findByCond(final IG394SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG394SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdconfirm())){
			c.add(Expression.eq("psdconfirm", cond.getPsdconfirm()));
		}
		if(cond.getRoleid() !=null && cond.getRoleid() > 0){
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		if(StringUtils.isNotEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		return c;
	}

}