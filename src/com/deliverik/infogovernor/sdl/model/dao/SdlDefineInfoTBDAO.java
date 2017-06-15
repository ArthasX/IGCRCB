package com.deliverik.infogovernor.sdl.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;




/**
 * 
 */
public interface SdlDefineInfoTBDAO extends BaseHibernateDAO<SdlDefineInfo> {

	/**
	 *
	 * @return 
	 */
	public List<SdlDefineInfo> findAll();

	/**
	 *
	 * @param rlid
	 * @return 
	 */
	public SdlDefineInfo findByPK(Serializable siid);

	public List<SdlDefineInfo> findByCond(final SdlDefineInfoSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final SdlDefineInfoSearchCond cond);
}
