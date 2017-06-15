/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCond;

/**
 * 概述:知识流程关联信息业务逻辑接口
 * 功能描述：知识流程关联信息业务逻辑接口
 * 创建记录：刘鹏 2010/12/07
 * 修改记录：
 */
public interface KnowledgeProcessBL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(KnowledgeProcessSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param kpid知识流程关联信息ID
	 * @return 知识流程关联信息
	 */
	public KnowledgeProcess searchKnowledgeProcessByKey(Integer kpid)
			throws BLException;

	/**
	 * 全部检索处理
	 * 
	 * @return 全部知识流程关联信息
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchKnowledgeProcess(KnowledgeProcessSearchCond cond,
			int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param knowledgeProcess登录数据
	 * @return 知识流程关联信息
	 */
	public KnowledgeProcess registKnowledgeProcess(KnowledgeProcess knowledgeProcess)
			throws BLException;
	
	/**
	 * 流程处理中查看的知识关联处理
	 * 
	 * @param 流程ID
	 * @param 知识ID
	 * @param 知识版本
	 */
	public void registKnowledgeProcess(Integer prid, Integer knid, Integer knversion) throws BLException;
	
	/**
	 * 服务工单处理中查看的知识关联处理
	 * 
	 * @param 服务工单ID
	 * @param 知识ID
	 * @param 知识版本
	 */
	public void registKnowledgeService(Integer sfid, Integer knid, Integer knversion) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param kpid知识流程关联信息ID
	 */
	public void deleteKnowledgeProcess(Integer kpid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param knowledgeProcess变更数据
	 * @return 知识流程关联信息
	 */
	public KnowledgeProcess updateKnowledgeProcess(KnowledgeProcess knowledgeProcess)
			throws BLException;
	
	/**
	 * 流程关联知识处理
	 * 
	 * @param prid流程ID
	 * @param knidList知识ID集合
	 * @param knversionList知识版本集合
	 */
	public void processRelateKnowledge(Integer prid, List<Integer> knidList, List<Integer> knversionList) throws BLException;
	
	/**
	 * 知识关联流程处理
	 * 
	 * @param knid知识ID
	 * @param pridList流程ID集合
	 */
	public void knowledgeRelateProcess(Integer knid, Integer knversion, List<Integer> pridList) throws BLException;
	
	/**
	 * 服务工单关联知识处理
	 * 
	 * @param sfid服务工单ID
	 * @param knidList知识ID集合
	 * @param knversionList知识版本集合
	 */
	public void serviceRelateKnowledge(Integer sfid, List<Integer> knidList, List<Integer> knversionList) throws BLException;
	
	/**
	 * 知识关联服务工单处理
	 * 
	 * @param knid知识ID
	 * @param knversion知识版本
	 * @param sfidList服务工单ID集合
	 */
	public void knowledgeRelateService(Integer knid, Integer knversion, List<Integer> pridList) throws BLException;
	
	/**
	 * 指定流程关联知识集合查询处理
	 * 
	 * @param prid流程ID
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessByPrid(Integer prid);
	
	/**
	 * 指定知识关联流程集合查询处理
	 * 
	 * @param knid知识ID
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchProcessByKnid(Integer knid);
	
	/**
	 * 指定服务工单关联知识集合查询处理
	 * 
	 * @param sfid服务工单ID
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchKnowledgeServiceBySfid(Integer sfid);
	
	/**
	 * 指定知识关联服务工单集合查询处理
	 * 
	 * @param knid知识ID
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchServiceByKnid(Integer knid);
	
	/**
	 * 知识关联的流程或服务工单查询处理
	 * @param knid
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessByKnid(Integer knid);
	
}
