/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.SocRelation;
import com.deliverik.infogovernor.soc.model.condition.SocRelationSearchCond;

/**
 * 
 * SOC关系信息业务逻辑接口
 *
 */
public interface SocRelationBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(SocRelationSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param rcid 风险检查信息ID
	 * @return 风险检查信息
	 */
	public SocRelation searchSocRelationByKey(Integer srid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部风险检查信息信息
	 */
	public List<SocRelation> searchSocRelationAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SocRelation> searchSocRelation(SocRelationSearchCond cond, int start, int count);
	
	/**
	 * 保存处理
	 * 
	 * @param SocRelation 保存数据
	 * @return 
	 */
	public SocRelation registSocRelation(SocRelation SocRelation) throws BLException;

	
}
