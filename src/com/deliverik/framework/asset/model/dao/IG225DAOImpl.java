package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.condition.IG225SearchCond;
import com.deliverik.framework.asset.model.entity.IG225TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * �ʲ�������ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG225DAOImpl extends BaseHibernateDAOImpl<IG225Info> implements IG225DAO {

	/**
	 * ���캯��
	 */
	public IG225DAOImpl(){
		super(IG225TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG225Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("cid"));
		List<IG225Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param cid ����
	 * @return �������
	 */
	public IG225Info findByPK(Serializable cid) {

		IG225Info config = super.findByPK(cid);
		if(config == null) return null;

		return config;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG225SearchCond cond){
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
	public List<IG225Info> findByCond(final IG225SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("cid"));
		List<IG225Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG225SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�ʲ�ģ��ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEid())));
		}	
		//�ʲ����Ա��
		if( !StringUtils.isEmpty(cond.getClabel())){
			c.add(Expression.eq("clabel", cond.getClabel()));
		}	
		//�ʲ���������
		if( !StringUtils.isEmpty(cond.getCname())){
			c.add(Expression.like("cname", "%" + cond.getCname() + "%"));
		}	
		//�ʲ���������
		if( !StringUtils.isEmpty(cond.getCcategory())){
			c.add(Expression.eq("ccategory", cond.getCcategory()));
		}
		//�ʲ�����״̬
		if( !StringUtils.isEmpty(cond.getCstatus())){
			c.add(Expression.eq("cstatus", cond.getCstatus()));
		}
		//�ʲ���������Ĭ�����Ա�־
		if( cond.getCseq()!=null && cond.getCseq()!= 0){
			c.add(Expression.ne("cseq", cond.getCseq()));
		}
		
		//�ʲ�����״̬
		if( cond.getCattachList()!=null && cond.getCattachList().size()>0){
			c.add(Expression.in("cattach", cond.getCattachList()));
		}
		return c;
	}


}
