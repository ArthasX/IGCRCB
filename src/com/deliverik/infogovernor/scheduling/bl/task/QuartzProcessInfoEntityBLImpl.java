/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCond;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.dao.QuartzProcessInfoEntityDAO;

/**
 * 
 * 流程与资产关系业务逻辑实现
 * 
 */
public class QuartzProcessInfoEntityBLImpl extends BaseBLImpl implements QuartzProcessInfoEntityBL {
	
	/** 流程状态跃迁规则DAO操作 */
	protected QuartzProcessInfoEntityDAO quartzProcessInfoEntityDAO;

	public void setQuartzProcessInfoEntityDAO(
			QuartzProcessInfoEntityDAO quartzProcessInfoEntityDAO) {
		this.quartzProcessInfoEntityDAO = quartzProcessInfoEntityDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getQuartzProcessInfoEntitySearchCount(QuartzProcessInfoEntitySearchCond cond) {
		return quartzProcessInfoEntityDAO.getSearchCount(cond);
	}
	
	

	/**
	 * 主键检索处理
	 * 
	 * @param pieid 流程状态跃迁规则ID
	 * @return 流程状态跃迁规则信息
	 * @throws BLException 
	 */
	
	public QuartzProcessInfoEntity searchQuartzProcessInfoEntityByKey(Integer qpieid) throws BLException {
		return quartzProcessInfoEntityDAO.findByPK(qpieid);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntity(
			QuartzProcessInfoEntitySearchCond cond) {
		return quartzProcessInfoEntityDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 全部检索处理
	 * 
	 * @return 检索结果列表
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntityAll() {
		return quartzProcessInfoEntityDAO.findAll();
	}

	/**
	 * 新增处理
	 * 
	 * @param QuartzProcessInfoEntity 新增数据
	 * @return 资产信息
	 */
	
	public QuartzProcessInfoEntity registQuartzProcessInfoEntity(
			QuartzProcessInfoEntity quartzProcessInfoEntity) throws BLException {
		return quartzProcessInfoEntityDAO.save(quartzProcessInfoEntity);
	}

	/**
	 * 删除处理
	 * 
	 * @param pieid 删除流程状态跃迁规则主键
	 * @return
	 */
	
	public void deleteQuartzProcessInfoEntity(Integer qpieid) throws BLException {
		QuartzProcessInfoEntity quartzProcessInfoEntity = quartzProcessInfoEntityDAO.findByPK(qpieid);
		quartzProcessInfoEntityDAO.delete(quartzProcessInfoEntity);
	}

	/**
	 * 变更处理
	 * 
	 * @param quartzProcessInfoEntity 变更数据
	 * @return 流程状态跃迁规则
	 */
	
	public QuartzProcessInfoEntity updateQuartzProcessInfoEntity(
			QuartzProcessInfoEntity quartzProcessInfoEntity) throws BLException {
		return quartzProcessInfoEntityDAO.save(quartzProcessInfoEntity);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<QuartzProcessInfoEntity> searchQuartzProcessInfoEntityByPrid(Integer qprid) {
		QuartzProcessInfoEntitySearchCondImpl cond = new QuartzProcessInfoEntitySearchCondImpl();
		cond.setQprid(qprid);
		return quartzProcessInfoEntityDAO.findByCond(cond, 0, 0);
	}



}
