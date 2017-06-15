package com.deliverik.infogovernor.sdl.model.dao;

import java.io.Serializable;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;
import com.deliverik.infogovernor.sdl.model.entity.SdlDefineInfoTB;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class SdlDefineInfoTBDAOImpl extends BaseHibernateDAOImpl<SdlDefineInfo> implements SdlDefineInfoTBDAO {

	/**
	 * 
	 */
	public SdlDefineInfoTBDAOImpl(){
		super(SdlDefineInfoTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<SdlDefineInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("sdiid"));
		List<SdlDefineInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public SdlDefineInfo findByPK(Serializable siid) {

		SdlDefineInfo rl = super.findByPK(siid);
		if(rl == null) return null;

		return rl;
	}

	public List<SdlDefineInfo> findByCond(final SdlDefineInfoSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sdiid"));
		List<SdlDefineInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(SdlDefineInfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if( !StringUtils.isEmpty(cond.getSdiyear())){
			c.add(Expression.eq("sdiyear", cond.getSdiyear()));
		}
		if( cond.getSdieiid() != null && cond.getSdieiid() != 0){
			c.add(Expression.eq("sdieiid", cond.getSdieiid()));
		}
		if( !StringUtils.isEmpty(cond.getSdieiname())){
			c.add(Expression.eq("sdieiname", cond.getSdieiname()));
		}
		return c;
	}

	public int getSearchCount(final SdlDefineInfoSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}


}
