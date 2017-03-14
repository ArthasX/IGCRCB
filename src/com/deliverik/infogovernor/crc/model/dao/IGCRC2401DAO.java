package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;
/**
 * 概述: 事件平均解决时间DAO接口
 * 修改记录: 
 */
public interface IGCRC2401DAO extends BaseHibernateDAO<IGCRC2401VW>{
	/**
	 * 事件平均解决时间
	 */
	public List<IGCRC2401VW> getFindStatistics(IGCRC2401Cond cond);
	
	
	/**
	 *  时间平均解决时间 
	 *  确认时间---开始时间
	 * @param cond
	 * @return
	 */
	public List<IGCRC2401VW> getFindStatisticsConfirm(IGCRC2401Cond cond);
}
