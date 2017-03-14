/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR01SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 采集结果DAO接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface CR01DAO extends BaseHibernateDAO<CR01VWInfo>{

	/**
	 * 采集结果查询
	 * @param cond 查询条件
	 * @param start 起始页码
	 * @param length 显示条数
	 * @return 查询结果
	 */
	public List<CR01VWInfo> searchCR01VWInfoList(final CR01SearchCond cond,int start,int length);
}
