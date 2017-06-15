/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;

/**
 * 概述: 比对结果DAO接口
 * 功能描述: 比对结果DAO接口
 * 创建记录:  yukexin 2014-8-12 11:08:46
 * 修改记录: 
 */
public interface IGCRC2301DAO extends BaseHibernateDAO<IGCRC2301VWInfo>{
    
    /**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IGCRC2301VWInfo> searchIGCRC2301VWInfo(final IGCRC2301Cond cond);
    
    
    /**
	 * 条件检索处理
	 * 		查询处理驳回次数
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
    public List<Integer> searchList(final IGCRC2301Cond cond);
    
    /**
	 * 条件检索处理
	 *		查询处理工单的总数 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
    public List<Integer> searchListSum(final IGCRC2301Cond cond);
    
}
