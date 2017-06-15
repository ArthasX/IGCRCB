/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;

/**	
 * 概述:变更总体统计Dao接口
 * 创建记录：yukexin    2014-8-15 下午5:17:57	
 * 修改记录：null
 */	
public interface IGCRC2201DAO extends BaseHibernateDAO<IGCRC2201VWInfo> {

	/**
	 * 变更总体统计检索
	 * 
	 * @param cond
	 * @return List<ChangeTreadVWInfo>
	 */
	public List<IGCRC2201VWInfo> searchChangeTreadVW(final IGCRC2201Cond cond);
}
