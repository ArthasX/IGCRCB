/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowLedgeInfoDAO;

 /**
  * 概述:知识库查询表BL实现类
  * 功能描述：知识库查询表BL实现类
  * 创建记录：wangxiaoqiang 2010/12/07
  * 修改记录：
  */
public class KnowLedgeInfoBLImpl extends BaseBLImpl implements KnowLedgeInfoBL {
	
	/** 知识库查询表信息DAO */
	protected KnowLedgeInfoDAO knowLedgeInfoDAO;

	/**
	 * 知识库查询表信息DAO
	 * 
	 * @param knowLedgeInfoDAO 知识库查询表信息DAO
	 */
	public void setKnowLedgeInfoDAO(KnowLedgeInfoDAO knowLedgeInfoDAO) {
		this.knowLedgeInfoDAO = knowLedgeInfoDAO;
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<KnowLedgeInfo> searchAllKnowLedgeInfo() throws BLException {
		return knowLedgeInfoDAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(KnowledgeSearchCond cond) throws BLException {
		return knowLedgeInfoDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowLedgeInfo> searchKnowLedgeInfoByCond(
			KnowledgeSearchCond cond, int start, int count)
			throws BLException {
		return knowLedgeInfoDAO.findByCond(cond, start, count);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowLedgeInfo> searchKnowLedgeInfoOrderByTime(
			KnowledgeSearchCond cond, int start, int count)
			throws BLException {
		return knowLedgeInfoDAO.findByCondTime(cond, start, count);
	}
	
	/**
	 * 检索各个中心贡献知识数量
	 * @return 各个中心贡献知识数量列表
	 */
	public List<KnowLedgeInfo> searchKnowLedgeSummary()throws BLException {
		return knowLedgeInfoDAO.findKgmSummary();
	}
}

