/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 模块：后勤管理-接待你管理
 * 说明：部门外出就餐统计汇总DAO接口
 * 作者：唐晓娜
 */
public interface DealOrgVWDAO extends BaseHibernateDAO<DealOrg> {


	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DealOrg> findByCond(final DealOrgVWSearchCond cond, final int start, final int count);

}
