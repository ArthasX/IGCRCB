package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;

/**
 * �ʲ�������ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0109DAOImpl extends BaseHibernateDAOImpl<SOC0109Info> implements SOC0109DAO {

	/**
	 * ���캯��
	 */
	public SOC0109DAOImpl(){
		super(SOC0109TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	@Override
	public List<SOC0109Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("cid"));
		List<SOC0109Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param cid ����
	 * @return �������
	 */
	@Override
	public SOC0109Info findByPK(Serializable cid) {

		SOC0109Info config = super.findByPK(cid);
		if(config == null) return null;

		return config;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0109SearchCond cond){
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
	public List<SOC0109Info> findByCond(final SOC0109SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("cid"));
		List<SOC0109Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ��ȡ���CID��
	 * @param cond
	 * @return
	 */
	public List<SOC0109Info> findMaxCidByCond(final SOC0109SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("cid"));
		List<SOC0109Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0109SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�ʲ�����ID
		if(!StringUtils.isEmpty(cond.getCid())){
			c.add(Expression.eq("cid", cond.getCid()));
		}
		//�ʲ�����ID like
		if(!StringUtils.isEmpty(cond.getCid_like())){
			c.add(Expression.like("cid", cond.getCid_like() + "%"));
		}
		//�ʲ�ģ��ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", cond.getEid()));
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
		// �ʲ���������Ĭ�����Ա�־
		if (cond.getCseq() != null && cond.getCseq() != 0) {
			c.add(Expression.ne("cseq", cond.getCseq()));
		}
		//�ʲ�����״̬
		if( cond.getCattachList()!=null && cond.getCattachList().size()>0){
			c.add(Expression.in("cattach", cond.getCattachList()));
		}

		// �ʲ����Բ���뼯��
		if (cond.getEsyscodingList() != null && cond.getEsyscodingList().size() > 0) {
			c.add(Restrictions.in("esyscoding", cond.getEsyscodingList()));
		}

		// �ʲ��� like
		if (!StringUtils.isEmpty(cond.getEsyscoding_like())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding_like() + "%"));
		}
		return c;
	}


}
