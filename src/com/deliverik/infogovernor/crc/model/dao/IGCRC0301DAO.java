package com.deliverik.infogovernor.crc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;

/**
 * 概述: 问题查询DAO接口
 * 功能描述: 问题查询DAO接口
 * 创建记录: 2017/08/07
 * 修改记录: 
 */
public interface IGCRC0301DAO extends BaseHibernateDAO<IGCRC0301VWInfo> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IGCRC0301VWInfo> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond);
}
