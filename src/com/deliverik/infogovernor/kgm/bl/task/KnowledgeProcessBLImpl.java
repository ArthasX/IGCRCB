/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCond;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeProcessDAO;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeProcessTB;

/**
 * 概述:知识流程关联信息业务逻辑实现
 * 功能描述：知识流程关联信息业务逻辑实现
 * 创建记录：刘鹏 2010/12/07
 * 修改记录：
 */
public class KnowledgeProcessBLImpl extends BaseBLImpl implements
		KnowledgeProcessBL {

	/** 知识流程关联信息DAO */
	protected KnowledgeProcessDAO knowledgeProcessDAO;

	/**
	 * 知识流程关联信息DAO
	 * 
	 * @param knowledgeProcessDAO 知识流程关联信息DAO
	 */
	public void setKnowledgeProcessDAO(KnowledgeProcessDAO knowledgeProcessDAO) {
		this.knowledgeProcessDAO = knowledgeProcessDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(KnowledgeProcessSearchCond cond) {
		return knowledgeProcessDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param kpid知识流程关联信息ID
	 * @return 知识流程关联信息
	 */
	public KnowledgeProcess searchKnowledgeProcessByKey(Integer kpid)
			throws BLException {
		return checkExistKnowledgeProcess(kpid);
	}

	/**
	 * 全部检索处理
	 * 
	 * @return 全部知识流程关联信息
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessAll() {
		return knowledgeProcessDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchKnowledgeProcess(KnowledgeProcessSearchCond cond,
			int start, int count) {
		return knowledgeProcessDAO.findByCond(cond, start, count);
	}

	/**
	 * 登录处理
	 * 
	 * @param knowledgeProcess登录数据
	 * @return 知识流程关联信息
	 */
	public KnowledgeProcess registKnowledgeProcess(KnowledgeProcess knowledgeProcess)
			throws BLException {
		return knowledgeProcessDAO.save(knowledgeProcess);
	}

	/**
	 * 删除处理
	 * 
	 * @param kpid知识流程关联信息ID
	 */
	public void deleteKnowledgeProcess(Integer kpid) throws BLException {

		KnowledgeProcess knowledgeProcess = checkExistKnowledgeProcess(kpid);

		knowledgeProcessDAO.delete(knowledgeProcess);
	}

	/**
	 * 变更处理
	 * 
	 * @param knowledgeProcess变更数据
	 * @return 知识流程关联信息
	 */
	public KnowledgeProcess updateKnowledgeProcess(KnowledgeProcess knowledgeProcess)
			throws BLException {
		checkExistKnowledgeProcess(knowledgeProcess.getKpid());
		return knowledgeProcessDAO.save(knowledgeProcess);
	}

	/**
	 * 知识流程关联信息存在检查
	 * 
	 * @param 知识流程关联信息ID
	 * @return 知识流程关联信息
	 * @throws BLException
	 */
	protected KnowledgeProcess checkExistKnowledgeProcess(Integer kpid)
			throws BLException {
		KnowledgeProcess info = knowledgeProcessDAO.findByPK(kpid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "知识流程关联基本");
		}
		return info;
	}
	
	/**
	 * 流程关联知识处理
	 * 
	 * @param prid流程ID
	 * @param knidList知识ID集合
	 * @param knversionList知识版本集合
	 */
	public void processRelateKnowledge(Integer prid, List<Integer> knidList, List<Integer> knversionList) throws BLException {
		this.registKnowledgeRelation(prid, null, knidList, knversionList, IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE);
	}
	
	/**
	 * 知识关联流程处理
	 * 
	 * @param knid知识ID
	 * @param pridList流程ID集合
	 */
	public void knowledgeRelateProcess(Integer knid, Integer knversion, List<Integer> pridList) throws BLException {
		this.registKnowledgeRelation(knid, knversion, pridList, null, IGKGMCONSTANTS.KNOWLEDGE_RELATE_PROCESS);
	}
	
	/**
	 * 服务工单关联知识处理
	 * 
	 * @param sfid服务工单ID
	 * @param knidList知识ID集合
	 * @param knversionList知识版本集合
	 */
	public void serviceRelateKnowledge(Integer sfid, List<Integer> knidList, List<Integer> knversionList) throws BLException {
		this.registKnowledgeRelation(sfid, null, knidList, knversionList, IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE);
	}
	
	/**
	 * 知识关联服务工单处理
	 * 
	 * @param knid知识ID
	 * @param knversion知识版本
	 * @param sfidList服务工单ID集合
	 */
	public void knowledgeRelateService(Integer knid, Integer knversion, List<Integer> pridList) throws BLException {
		this.registKnowledgeRelation(knid, knversion, pridList, null, IGKGMCONSTANTS.KNOWLEDGE_RELATE_SERVICE);
	}
	
	/**
	 * 知识关联处理
	 * 
	 * @param id知识或流程ID或服务工单ID
	 * @param knversion知识版本
	 * @param idList知识或流程ID集合或服务工单ID集合
	 * @param knversionList知识版本集合
	 */
	protected void registKnowledgeRelation(Integer id, Integer knversion, List<Integer> idList,
			List<Integer> knversionList, String connecttype) throws BLException {
		if(idList != null) {
			int i = 0;
			for(Integer key : idList){
				if(key != null && key > 0) {
					KnowledgeProcessTB kpTB = new KnowledgeProcessTB();
					if(IGKGMCONSTANTS.KNOWLEDGE_RELATE_PROCESS.equals(connecttype)) {//知识关联流程
						kpTB.setKnid(id);
						kpTB.setPrid(key);
						kpTB.setKnversion(knversion);
					} else if(IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE.equals(connecttype)) {//流程关联知识
						kpTB.setPrid(id);
						kpTB.setKnid(key);
						kpTB.setKnversion(knversionList.get(i++));
						kpTB.setKpEffect(IGKGMCONSTANTS.KPEFFECT_YES);//是否有效标识
					} else if(IGKGMCONSTANTS.KNOWLEDGE_RELATE_SERVICE.equals(connecttype)) {//知识关联服务工单
						kpTB.setKnid(id);
						kpTB.setSfid(key);
						kpTB.setKnversion(knversion);
					} else if(IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE.equals(connecttype)) {//服务工单关联知识
						kpTB.setSfid(id);
						kpTB.setKnid(key);
						kpTB.setKnversion(knversionList.get(i++));
						kpTB.setKpEffect(IGKGMCONSTANTS.KPEFFECT_YES);//是否有效标识
					}
					kpTB.setConnecttype(connecttype);//关联类型
					this.registKnowledgeProcess(kpTB);
				}
			}
		}
	}
	
	/**
	 * 流程处理中查看的知识关联处理
	 * 
	 * @param 流程ID
	 * @param 知识ID
	 * @param 知识版本
	 */
	public void registKnowledgeProcess(Integer prid, Integer knid, Integer knversion) throws BLException {
		List<KnowledgeProcess> kpList = checkExistKnowledgeProcessByKpEffect(prid, knid, knversion);
		if(kpList.isEmpty()) {
			KnowledgeProcessTB kpTB = new KnowledgeProcessTB();
			kpTB.setPrid(prid);//流程ID
			kpTB.setKnid(knid);//知识ID
			kpTB.setKnversion(knversion);//知识版本
			kpTB.setConnecttype(IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE);//关联类型
			kpTB.setKpEffect(IGKGMCONSTANTS.KPEFFECT_NO);//是否有效标识
			this.registKnowledgeProcess(kpTB);
		} else if(kpList.size() > 1){
			throw new BLException("IGCO10000.E004", "知识流程关联基本");
		} else {
			KnowledgeProcessTB kpTB = (KnowledgeProcessTB)SerializationUtils.clone(kpList.get(0));
			kpTB.setKnversion(knversion);
			this.updateKnowledgeProcess(kpTB);
		}
	}
	
	/**
	 * 服务工单处理中查看的知识关联处理
	 * 
	 * @param 服务工单ID
	 * @param 知识ID
	 * @param 知识版本
	 */
	public void registKnowledgeService(Integer sfid, Integer knid, Integer knversion) throws BLException {
		List<KnowledgeProcess> ksList = checkExistKnowledgeServiceByKpEffect(sfid, knid, knversion);
		if(ksList.isEmpty()) {
			KnowledgeProcessTB kpTB = new KnowledgeProcessTB();
			kpTB.setSfid(sfid);//服务工单ID
			kpTB.setKnid(knid);//知识ID
			kpTB.setKnversion(knversion);//知识版本
			kpTB.setConnecttype(IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE);//关联类型
			kpTB.setKpEffect(IGKGMCONSTANTS.KPEFFECT_NO);//是否有效标识
			this.registKnowledgeProcess(kpTB);
		} else if(ksList.size() > 1){
			throw new BLException("IGCO10000.E004", "知识服务工单关联基本");
		} else {
			KnowledgeProcessTB kpTB = (KnowledgeProcessTB)SerializationUtils.clone(ksList.get(0));
			kpTB.setKnversion(knversion);
			this.updateKnowledgeProcess(kpTB);
		}
	}
	
	/**
	 * 流程处理中查看的知识关联信息存在检查
	 * 
	 * @param 流程ID
	 * @param 知识ID
	 * @param 知识版本
	 * @return 关联信息集合
	 */
	protected List<KnowledgeProcess> checkExistKnowledgeProcessByKpEffect(Integer prid, Integer knid, Integer knversion) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setPrid(prid);//流程ID
		cond.setKnid(knid);//知识ID
		cond.setKnversion(knversion);//知识版本
		cond.setConnecttype(IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE);//关联类型
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 服务工单处理中查看的知识关联信息存在检查
	 * 
	 * @param 服务工单ID
	 * @param 知识ID
	 * @param 知识版本
	 * @return 关联信息
	 */
	protected List<KnowledgeProcess> checkExistKnowledgeServiceByKpEffect(Integer sfid, Integer knid, Integer knversion) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setSfid(sfid);//服务工单ID
		cond.setKnid(knid);//知识ID
		cond.setKnversion(knversion);//知识版本
		cond.setConnecttype(IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE);//关联类型
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 指定流程关联知识集合查询处理
	 * 
	 * @param prid流程ID
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessByPrid(Integer prid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setConnecttype(IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE);//流程关联知识
		cond.setPrid(prid);
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 指定知识关联流程集合查询处理
	 * 
	 * @param knid知识ID
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchProcessByKnid(Integer knid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setConnecttype(IGKGMCONSTANTS.KNOWLEDGE_RELATE_PROCESS);//知识关联流程
		cond.setKnid(knid);
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 指定服务工单关联知识集合查询处理
	 * 
	 * @param sfid服务工单ID
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchKnowledgeServiceBySfid(Integer sfid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setConnecttype(IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE);//服务工单关联知识
		cond.setSfid(sfid);
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 指定知识关联服务工单集合查询处理
	 * 
	 * @param knid知识ID
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchServiceByKnid(Integer knid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setConnecttype(IGKGMCONSTANTS.KNOWLEDGE_RELATE_SERVICE);//知识关联服务工单
		cond.setKnid(knid);
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 知识关联的流程或服务工单查询处理
	 * @param knid
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessByKnid(Integer knid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setKnid(knid);
		cond.setConnecttype(IGKGMCONSTANTS.KNOWLEDGE_RELATE_PROCESS);
		cond.setKpEffect(IGKGMCONSTANTS.KPEFFECT_YES);
		return knowledgeProcessDAO.findByCond_KnowledgeProcess(cond, 0, 0);
	}
	
}
