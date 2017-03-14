/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;

/**
 * 概述: 比对结果DAO接口
 * 功能描述: 比对结果DAO接口
 * 创建记录: 2014/07/15
 * 修改记录: 
 */
public interface IGCRC1301DAO extends BaseHibernateDAO<IGCRC1301VWInfo> {
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IGCRC1301Cond cond);
	
	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<IGCRC1301VWInfo> searchIGCRC1301VWInfo(final IGCRC1301Cond cond, final int start,
			final int count);
    
    
    
    public List<IGCRC1301VWInfo> searchIGCRC1302VWInfo(final IGCRC1301Cond cond, final int start,
			final int count);
}
