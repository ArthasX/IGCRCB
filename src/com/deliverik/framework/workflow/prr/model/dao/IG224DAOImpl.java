/*
 * ����?????????��??????????????��??��?��????��????��???��????
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;

/**
 * ?��??��???????????DAO????
 * 
 */
@SuppressWarnings("deprecation")
public class IG224DAOImpl extends BaseHibernateDAOImpl<IG224Info> implements IG224DAO {

	/** Ig224 DAO */
	protected IG224DAO ig224DAO;
	/**
	 * ???��????
	 */
	public IG224DAOImpl(){
		super(IG224TB.class);
	}

	/**
	 * ?????��?��
	 * @return ?��?��?��????
	 */
	public List<IG224Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rslid"));
		List<IG224Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ?��?��?��?��???��
	 * @param rslid ?��?��
	 * @return ?��?��?��??
	 */
	public IG224Info findByPK(Serializable rslid) {

		IG224Info result = super.findByPK(rslid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ?????��?��?��??????????
	 * @param cond ?��?��????
	 * @return ?��?��?��??????
	 */
	public int getSearchCount(final IG224SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ?????��?��???��
	 * @param cond ?��?��????
	 * @param start ?��?��????????????
	 * @param count ?��?��????????
	 * @return ?��?��?��????����
	 */
	public List<IG224Info> findByCond(final IG224SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rslid"));
		List<IG224Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	/**
	 * ������������ dashboard ���ݳ�ʼ��ר��
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG224Info> findByCondOrderByRslopentime(final IG224SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rslOpenTime"));
		List<IG224Info> ret = findByCriteria(c, 0, 0);
		return ret;
	}

	/**
	 * ?��?��?????��??
	 * 
	 * @param cond ?��?��????
	 * @return ?��?��???��?��?????��
	 */
	protected DetachedCriteria getCriteria(IG224SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//?��??ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		//?????��???��???��?���???????����??
		if(cond.isCurrentPrstatus()){
			c.add(Expression.isNull("rslCloseTime"));
		}
		//?��??��????????��??
		if(StringUtils.isNotEmpty(cond.getPrstatus_ne())){
			c.add(Expression.ne("prstatus", cond.getPrstatus()));
		}
		//?��??��????????��??
		if(StringUtils.isNotEmpty(cond.getPrstatus())){
			if(cond.getPrstatus().length() > 3){
				c.add(Expression.eq("psdid", cond.getPrstatus()));
			}else{
				c.add(Expression.eq("prstatus", cond.getPrstatus()));
			}
		}
		//?��??��????��??ID?????��??
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		//?????��??��????��??ID?????��??
		if(StringUtils.isNotEmpty(cond.getPpsdid())){
			c.add(Expression.eq("ppsdid", cond.getPpsdid()));
		}
		//?��??????��????????��??
		if(StringUtils.isNotEmpty(cond.getVirtualstatus())){
			c.add(Expression.eq("virtualstatus", cond.getVirtualstatus()));
		}
		//???????�����???????��??
		if(cond.getPsdnum() != null && cond.getPsdnum() > 0){
			c.add(Expression.eq("psdnum", cond.getPsdnum()));
		}
		//?��?���???????
		if("Y".equals(cond.getNowstatus())){
			c.add(Expression.or(Expression.ne("virtualstatus", "1"), Expression.isNull("virtualstatus")));
		}
		
		//�Ƿ����״̬
		if(cond.isPend()) {
			c.add(Expression.eq("pend", "0"));
		}
		return c;
	}

}
