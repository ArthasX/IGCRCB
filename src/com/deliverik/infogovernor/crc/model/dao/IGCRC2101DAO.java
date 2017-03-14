/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;

/**
 * 概述: 比对结果DAO接口
 * 功能描述: 比对结果DAO接口
 * 创建记录:  yukexin 2014-8-7 09:34:11
 * 修改记录: 
 */
public interface IGCRC2101DAO extends BaseHibernateDAO<IGCRC2101VWInfo>{
	
	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param start 起始id
     * @param count 每页多少条
     * @return 检索结果列表
     */
    public List<IGCRC2101VWInfo> searchIGCRC2101VWInfo(final IGCRC2101Cond cond, final int start,
			final int count);
    
    /**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IGCRC2101VWInfo> searchIGCRC2101VWInfo(final IGCRC2101Cond cond);
    
    /**	
     * 功能：查询部门下拉列表
     * @return 部门下拉列表
     * 修改记录：null 	
     */	
    public List<IGCRC2102VWInfo> searchDepartmentBeanList();
}
