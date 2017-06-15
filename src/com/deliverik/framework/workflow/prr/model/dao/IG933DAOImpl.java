/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG933TB;

/**
 * ���񹤵�DAOʵ��
 */
@SuppressWarnings("deprecation")
public class IG933DAOImpl extends BaseHibernateDAOImpl<IG933Info> implements IG933DAO {

	/**
	 * ���캯��
	 */
	public IG933DAOImpl(){
		super(IG933TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG933Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("sfid"));
		List<IG933Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ȫ������
	 * @return ���������ʱ������
	 */
	public List<IG933Info> findAllAsc() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("sfid"));
		List<IG933Info> ret = findByCriteria(c);

		return ret;
	}
	
	/**
	 * ������������
	 * @param sfid ����
	 * @return �������
	 */
	public IG933Info findByPK(Serializable sfid) {

		IG933Info result = super.findByPK(sfid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG933SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG933Info> findByCond(final IG933SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sfstatus"));
		c.addOrder(Order.desc("sfid"));
		List<IG933Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�ʱ������
	 */
	public List<IG933Info> findByCondAsc(final IG933SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sfstatus"));
		c.addOrder(Order.asc("sfid"));
		List<IG933Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG933SearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();
		
		if(StringUtils.isNotEmpty(cond.getSfregisterid())){
			c.add(Expression.eq("sfregisterid", cond.getSfregisterid()));
		}
		if(StringUtils.isNotEmpty(cond.getSftype())){
			c.add(Expression.like("sftype", cond.getSftype()));
		}
		if(StringUtils.isNotEmpty(cond.getSfinstimebegin())){
			c.add(Expression.ge("sfinstime", cond.getSfinstimebegin()));
		}
		if(StringUtils.isNotEmpty(cond.getSfinstimeend())){
			c.add(Expression.le("sfinstime", cond.getSfinstimeend() + " 23:59"));
		}
		if(StringUtils.isNotEmpty(cond.getSfstatus())){
			c.add(Expression.eq("sfstatus", cond.getSfstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getSftitle())){
			c.add(Expression.like("sftitle", "%" + cond.getSftitle() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getSfcode())){
			c.add(Expression.like("sfcode", "%" + cond.getSfcode() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getSfreportname())){
			c.add(Expression.like("sfreportname", "%" + cond.getSfreportname() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getSfusername())){
		
		    c.createCriteria("userTB").add(Expression.like("username","%"+ cond.getSfusername()+"%"));
		}
		return c;
	}

	 /**
	 * ��ȡ���񹤵�������ֵ
	 * 
	 * @return ���񹤵�������ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String searchMaxID(String code) {
		String sql =  "select max(a.sfcode) from IG933TB a where a.sfcode like '" + code + "%'";
		NamedParamMap p = getNamedParamMap();
		List l = findByNamedParamMap(sql, p);
		if(l.size() == 0) return null;
		return (String) l.get(0);
	}
}
