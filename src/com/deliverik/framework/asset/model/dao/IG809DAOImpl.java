/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.asset.model.condition.IG809SearchCond;
import com.deliverik.framework.asset.model.entity.IG809TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * �ʲ���ϵͼ�ļ���ϢDAO�ӿ�ʵ��
 *
 */
@SuppressWarnings("deprecation")
public class IG809DAOImpl extends BaseHibernateDAOImpl<IG809Info> implements IG809DAO{

	/**
	 * ���캯��
	 */
	public IG809DAOImpl(){
		super(IG809TB.class);
	}
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG809Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eirfid"));
		List<IG809Info> ret = findByCriteria(c);

		return ret;
	}
	
	/**
	 * ������������
	 * @param eirfid ����
	 * @return �������
	 */
	public IG809Info findByPK(Serializable eirfid) {

		IG809Info result = super.findByPK(eirfid);
		if(result == null) return null;

		return result;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG809SearchCond cond){
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
	public List<IG809Info> findByCond(final IG809SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eirfid"));
		List<IG809Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG809SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�ʲ�ID
		if(cond.getEiid() != null && cond.getEiid() != 0){
			c.add(Expression.eq("eiid", cond.getEiid()));
		}
		//����ͼ����
		if( StringUtils.isNotEmpty(cond.getEirftype())){
			c.add(Expression.eq("eirftype", cond.getEirftype()));
		}
		//�ļ���
		if( StringUtils.isNotEmpty(cond.getEirfname())){
			c.add(Expression.eq("eirfname", cond.getEirfname()));
		}
		//�ʲ�ID����
		if( cond.getEiidList() != null && cond.getEiidList().size() > 0){
			c.add(Expression.in("eiid", cond.getEiidList()));
		}
		return c;
	}
}
