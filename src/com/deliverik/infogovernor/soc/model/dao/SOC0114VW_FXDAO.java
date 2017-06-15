/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.SOC0114VWInfo;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCond;

/**
 * 概述: SOC0114VW_FXDAO接口
 * 功能描述: SOC0114VW_FXDAO接口
 * 创建记录: 2013/10/26
 * 修改记录: 
 */
public interface SOC0114VW_FXDAO extends BaseHibernateDAO<SOC0114VWInfo> {
	/**
	 * 条件检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public List<SOC0114VWInfo> findByCond(final SOC0114VW_FXSearchCond cond);
	/**
	 * 条件检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public List<SOC0114VWInfo> findByCondForBJ(final SOC0114VW_FXSearchCond cond);
	
	/**
	 * 根据主机eiid获取环境类型
	 * @param string
	 * @return
	 */
	public String getEitype(String eiid);
}