/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.kgm.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.condition.AttachmentSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeDAO;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeVWDAO;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTB;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTBPK;



 /**
  * 概述:知识库信息业务逻辑实现
  * 功能描述：知识库信息业务逻辑实现
  * 创建记录：wangxiaoqiang 2010/12/07
  * 修改记录：
  */
public class KnowledgeBLImpl extends BaseBLImpl implements KnowledgeBL {
	
	/** 知识库信息DAO */
	protected KnowledgeDAO knowledgeDAO;
	
	/** 最新版知识信息DAO */
	protected KnowledgeVWDAO knowledgeVWDAO;
	
	/**附件BL*/
	protected AttachmentBL attachmentBL;

	/**
	 * 最新版知识信息DAO
	 * @param knowledgeVWDAO 最新版知识信息DAO
	 */
	public void setKnowledgeVWDAO(KnowledgeVWDAO knowledgeVWDAO) {
		this.knowledgeVWDAO = knowledgeVWDAO;
	}

	/**
	 * 知识库信息DAO
	 * 
	 * @param knowledgeDAO 知识库信息DAO
	 */
	public void setKnowledgeDAO(KnowledgeDAO knowledgeDAO) {
		this.knowledgeDAO = knowledgeDAO;
	}

	/**
	 * 附件BL设定
	 * @param attachmentBL附件BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 持久化处理
	 * 
	 * @param Knowledge实体类
	 * @return Knowledge实体类
	 */
	public Knowledge registKnowledge(Knowledge knowledge) throws BLException {
		KnowledgeTB knowledgeTB = (KnowledgeTB)SerializationUtils.clone(knowledge);
		if(StringUtils.isEmpty(knowledgeTB.getKnserial())){
			knowledgeTB.setKnserial(this.getKnserial());
		}
		return knowledgeDAO.save(knowledgeTB);
	}

	

	/**
	 * 主键检索处理
	 * 
	 * @param id 主键
	 * @return 检索结果
	 */
	public Knowledge searchKnowledgeByPK(KnowledgeTBPK pk) throws BLException {
		Knowledge knowledge = knowledgeDAO.findByPK(pk);
		
		AttachmentSearchCondImpl cond = new AttachmentSearchCondImpl();
		cond.setAttkey(knowledge.getKnattkey());
		
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		if(knowledge.getKnattkey()!=null &&(!"".equals(knowledge.getKnattkey()))){
			attachmentList = attachmentBL.searchAttachmentsByAttkey(knowledge.getKnattkey());
			knowledge.setAttachmentList(attachmentList);
		}
		return knowledge;
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<Knowledge> searchAllKnowledge() throws BLException {
		return knowledgeDAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(KnowledgeSearchCond cond) throws BLException {
		return knowledgeDAO.getSearchCount(cond);
	}
	/**
	 * 知识序列号取得
	 * 
	 * @param cond 检索条件
	 * @return 知识序列号
	 */
	public String getKnserial() throws BLException {
		String knserial = knowledgeDAO.getKnserial();
		if(knserial ==null){
			knserial = "K000001";
		}else{
			int num = Integer.parseInt(knserial.substring(1,knserial.length()));
			knserial = "K" + StringUtils.leftPad(String.valueOf(num+1), 6 ,"0");
		}
		return knserial;
	}
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Knowledge> searchKnowledgeByCond(KnowledgeSearchCond cond,
			int start, int count) throws BLException {
		return knowledgeDAO.findByCond(cond, start, count);
	}

	/**
	 * 删除处理
	 * 
	 * @param Knowledge实体类
	 */
	public void deleteKnowledge(Knowledge knowledge) throws BLException {
		knowledgeDAO.delete(knowledge);
	}

	/**
	 * 变更处理
	 * 
	 * @param knowledge变更数据
	 * @return 知识库信息
	 */
	public Knowledge updateKnowledge(Knowledge knowledge)
			throws BLException {
		KnowledgeTBPK pk = new KnowledgeTBPK(knowledge.getKnid(),knowledge.getKnversion());
		Knowledge kl= checkExistKnowledge(pk);
		KnowledgeTB klTB = (KnowledgeTB)knowledge;
		if(StringUtils.isNotEmpty(kl.getKnserial())){
			klTB.setKnserial(kl.getKnserial());
		}else{
			klTB.setKnserial(this.getKnserial());
		}
		return knowledgeDAO.save(klTB);
	}
	
	/**
	 * 知识库信息存在检查
	 * 
	 * @param 知识流程关联信息ID
	 * @return 知识流程关联信息
	 * @throws BLException
	 */
	protected Knowledge checkExistKnowledge(KnowledgeTBPK pk)
			throws BLException {
		Knowledge info = knowledgeDAO.findByPK(pk);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "知识库基本信息");
		}
		return info;
	}
	
	/**
	 * 查找最大的id
	 * 
	 * @return 最大id号
	 * @throws BLException
	 */
	public Integer getMaxknid() throws BLException {
		Integer knid = knowledgeDAO.getMaxgKnid();
		return knid;
	}
	
	/**
	 * 查找最大的id
	 * 
	 * @return 最大id号
	 * @throws BLException
	 */
	public Integer getMaxVersion(Integer knid) throws BLException {
		Integer knversion = knowledgeDAO.getMaxVersion(knid);
		return knversion;
	}
	
	/**
	 * 查找最大的id
	 * 
	 * @return 最大id号
	 * @throws BLException
	 */
	public int getSearchNotCheckCount(KnowledgeSearchCond knowledgeSearchCond) throws BLException {
		int knversion = knowledgeDAO.getSearchNotCheckCount(knowledgeSearchCond);
		return knversion;
	}

	/**
	 * 知识历史版本取得
	 * @param knowledgeSearchCond
	 * @return
	 * @throws BLException
	 */
	public List<Knowledge> getKnowledgeHistory(KnowledgeSearchCond knowledgeSearchCond) throws BLException {
		
		List<Knowledge> knowledgeList_pro = knowledgeDAO.findByCond_History(knowledgeSearchCond, 0, 0);
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();
		for(int i=0;i<knowledgeList_pro.size();i++){
			List<Attachment> attachmentList = new ArrayList<Attachment>();
			Knowledge knowledge = knowledgeList_pro.get(i);
			if(StringUtils.isNotEmpty(knowledgeList_pro.get(i).getKnattkey())){
				attachmentList = attachmentBL.searchAttachmentsByAttkey(knowledge.getKnattkey());
				knowledge.setAttachmentList(attachmentList);
			}
			knowledgeList.add(knowledge);
		}
		return knowledgeList;
	}
	
	/**
	 * 根据知识id检索当前有效知识处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public Knowledge searchKnowledgeByByKnid(KnowledgeSearchCond cond) throws BLException {
		return knowledgeDAO.findByKnid(cond);
	}
}

