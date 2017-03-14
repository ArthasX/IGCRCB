package com.deliverik.infogovernor.sdl.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;




/**
 * 
 */
public interface SdlInfoTBDAO extends BaseHibernateDAO<SdlInfo> {

	/**
	 *
	 * @return 
	 */
	public List<SdlInfo> findAll();

	/**
	 *
	 * @param rlid
	 * @return 
	 */
	public SdlInfo findByPK(Serializable siid);

	public List<SdlInfo> findByCond(final SdlInfoSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final SdlInfoSearchCond cond);
}
