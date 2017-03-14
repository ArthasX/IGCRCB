/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTBPK;


 /**
  * 概述:知识库信息业务逻辑接口
  * 功能描述：知识库信息业务逻辑接口
  * 创建记录：wangxiaoqiang 2010/12/07
  * 修改记录：
  */
public interface KnowledgeBL extends BaseBL {
	/**
	 * 持久化处理
	 * 
	 * @param Knowledge实体类
	 * @return Knowledge实体类
	 */
	public Knowledge registKnowledge(Knowledge knowledge) throws BLException;

	/**
	 * 主键检索处理
	 * 
	 * @param id 主键
	 * @return 检索结果
	 */
	public Knowledge searchKnowledgeByPK(KnowledgeTBPK pk) throws BLException;

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<Knowledge> searchAllKnowledge() throws BLException;

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(KnowledgeSearchCond cond) throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Knowledge> searchKnowledgeByCond(KnowledgeSearchCond cond,
			int start, int count) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param Knowledge实体类
	 */
	public void deleteKnowledge(Knowledge knowledge) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param knowledgeProcess变更数据
	 * @return 知识流程关联信息
	 */
	public Knowledge updateKnowledge(Knowledge knowledge) throws BLException;
	
	/**
	 * 变更处理
	 * 
	 * @param knowledgeProcess变更数据
	 * @return 知识流程关联信息
	 */
	public Integer getMaxknid() throws BLException;
	
	/**
	 * 查找没有审批过的记录
	 * 
	 * @param knowledgeProcess变更数据
	 * @return 知识流程关联信息
	 */
	public int getSearchNotCheckCount(KnowledgeSearchCond knowledgeSearchCond) throws BLException;	
	
	/**
	 * 变更处理
	 * 
	 * @param knowledgeProcess变更数据
	 * @return 知识流程关联信息
	 */
	public Integer getMaxVersion(Integer knid) throws BLException;
	
	/**
	 * 知识历史版本取得
	 * @param knowledgeSearchCond
	 * @return
	 * @throws BLException
	 */
	public List<Knowledge> getKnowledgeHistory(KnowledgeSearchCond knowledgeSearchCond) throws BLException;
	/**
	 * 根据知识id检索当前有效知识处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public Knowledge searchKnowledgeByByKnid(KnowledgeSearchCond cond) throws BLException;
	
	/**
	 * 知识序列号取得
	 * 
	 * @param cond 检索条件
	 * @return 知识序列号
	 */
	public String getKnserial() throws BLException;
}

