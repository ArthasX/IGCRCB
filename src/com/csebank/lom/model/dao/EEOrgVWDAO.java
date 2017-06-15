/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.condition.EEOrgVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂招待部门汇总DAO接口
 * 作者：唐晓娜
 */
public interface EEOrgVWDAO extends BaseHibernateDAO<EEOrg> {


	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EEOrg> findByCond(final EEOrgVWSearchCond cond, final int start, final int count);
	
	
	

}
