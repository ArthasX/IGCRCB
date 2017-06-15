package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;

/**
 * 概述: 比对结果DAO接口
 * 功能描述: 比对结果DAO接口
 * 创建记录:  史凯龙 2014/07/22
 * 修改记录: 
 */
public interface IGCRC1303DAO extends BaseHibernateDAO<IGCRC1303VWInfo>{
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IGCRC1303Cond cond);
	
	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<IGCRC1303VWInfo> searchIGCRC1303VWInfo(final IGCRC1303Cond cond, final int start,
			final int count);
    
    
    /**
     * 检索每个文档的文档类型
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<String> searchType();
    
    /**
     * 检索下载表中的每条记录的文档类型
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<String> searchDownType();
}
