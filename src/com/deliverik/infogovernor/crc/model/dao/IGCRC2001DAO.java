package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001Cond;

/**
 * 概述: 年度工作统计DAO接口
 * 创建记录:  lianghongyang 2014-8-7 09:34:11
 * 修改记录: 
 */
public interface IGCRC2001DAO extends BaseHibernateDAO<IGCRC2001VWInfo>{
	/**
	 * 查询年度工作统计
	 */
	public List<IGCRC2001VWInfo> getFindStatistics(IGCRC2001Cond cond);
	
}
