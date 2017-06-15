/*
 * ±±?????????í??????????????°??¨?ù????±????ù???¨????
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
 * ?÷??×???????????DAO????
 * 
 */
@SuppressWarnings("deprecation")
public class IG224DAOImpl extends BaseHibernateDAOImpl<IG224Info> implements IG224DAO {

	/** Ig224 DAO */
	protected IG224DAO ig224DAO;
	/**
	 * ???ì????
	 */
	public IG224DAOImpl(){
		super(IG224TB.class);
	}

	/**
	 * ?????ì?÷
	 * @return ?ì?÷?á????
	 */
	public List<IG224Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rslid"));
		List<IG224Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ?÷?ü?ì?÷???í
	 * @param rslid ?÷?ü
	 * @return ?ì?÷?á??
	 */
	public IG224Info findByPK(Serializable rslid) {

		IG224Info result = super.findByPK(rslid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ?????ì?÷?á??????????
	 * @param cond ?ì?÷????
	 * @return ?ì?÷?á??????
	 */
	public int getSearchCount(final IG224SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ?????ì?÷???í
	 * @param cond ?ì?÷????
	 * @param start ?ì?÷????????????
	 * @param count ?ì?÷????????
	 * @return ?ì?÷?á????±í
	 */
	public List<IG224Info> findByCond(final IG224SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rslid"));
		List<IG224Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	/**
	 * 条件检索处理 dashboard 数据初始化专用
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG224Info> findByCondOrderByRslopentime(final IG224SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rslOpenTime"));
		List<IG224Info> ret = findByCriteria(c, 0, 0);
		return ret;
	}

	/**
	 * ?ì?÷?????ú??
	 * 
	 * @param cond ?ì?÷????
	 * @return ?ì?÷???ì?÷?????à
	 */
	protected DetachedCriteria getCriteria(IG224SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//?÷??ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		//?????é???÷???±?°×???????±ê??
		if(cond.isCurrentPrstatus()){
			c.add(Expression.isNull("rslCloseTime"));
		}
		//?÷??×????????é??
		if(StringUtils.isNotEmpty(cond.getPrstatus_ne())){
			c.add(Expression.ne("prstatus", cond.getPrstatus()));
		}
		//?÷??×????????é??
		if(StringUtils.isNotEmpty(cond.getPrstatus())){
			if(cond.getPrstatus().length() > 3){
				c.add(Expression.eq("psdid", cond.getPrstatus()));
			}else{
				c.add(Expression.eq("prstatus", cond.getPrstatus()));
			}
		}
		//?÷??×????¨??ID?????é??
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		//?????÷??×????¨??ID?????é??
		if(StringUtils.isNotEmpty(cond.getPpsdid())){
			c.add(Expression.eq("ppsdid", cond.getPpsdid()));
		}
		//?é??????×????????é??
		if(StringUtils.isNotEmpty(cond.getVirtualstatus())){
			c.add(Expression.eq("virtualstatus", cond.getVirtualstatus()));
		}
		//???????§±à???????é??
		if(cond.getPsdnum() != null && cond.getPsdnum() > 0){
			c.add(Expression.eq("psdnum", cond.getPsdnum()));
		}
		//?±?°×???????
		if("Y".equals(cond.getNowstatus())){
			c.add(Expression.or(Expression.ne("virtualstatus", "1"), Expression.isNull("virtualstatus")));
		}
		
		//是否挂起状态
		if(cond.isPend()) {
			c.add(Expression.eq("pend", "0"));
		}
		return c;
	}

}
