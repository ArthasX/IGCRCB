package com.deliverik.infogovernor.sdl.model.dao;

import java.io.Serializable;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;
import com.deliverik.infogovernor.sdl.model.entity.SdlInfoTB;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class SdlInfoTBDAOImpl extends BaseHibernateDAOImpl<SdlInfo> implements SdlInfoTBDAO {

	/**
	 * 
	 */
	public SdlInfoTBDAOImpl(){
		super(SdlInfoTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<SdlInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("siid"));
		List<SdlInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public SdlInfo findByPK(Serializable siid) {

		SdlInfo rl = super.findByPK(siid);
		if(rl == null) return null;

		return rl;
	}

	public List<SdlInfo> findByCond(final SdlInfoSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("siid"));
		List<SdlInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(SdlInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if( cond.getSieiid() != null && cond.getSieiid() != 0){
			c.add(Expression.eq("sieiid", cond.getSieiid()));
		}
		if( cond.getSiprid() != null && cond.getSiprid() != 0){
			c.add(Expression.eq("siprid", cond.getSiprid()));
		}
		if( !StringUtils.isEmpty(cond.getSibegin())){
			c.add(Expression.ge("sibegin", cond.getSibegin()));
		}
		if( !StringUtils.isEmpty(cond.getSiend())){
			c.add(Expression.le("sibegin", cond.getSiend()));
		}
		if( !StringUtils.isEmpty(cond.getSitype())){
			c.add(Expression.eq("sitype", cond.getSitype()));
		}
		return c;
	}

	public int getSearchCount(final SdlInfoSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}


}
