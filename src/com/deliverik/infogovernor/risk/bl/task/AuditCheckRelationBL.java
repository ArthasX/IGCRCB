/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCond;

/**
 * 
 * 风险检查与风险审计关系业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public interface AuditCheckRelationBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(AuditCheckRelationSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param acrid 风险检查与风险审计关系ID
	 * @return 风险检查与风险审计关系
	 */
	public AuditCheckRelation searchAuditCheckRelationByKey(Integer acrid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部风险检查与风险审计关系信息
	 */
	public List<AuditCheckRelation> searchAuditCheckRelationAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditCheckRelation> searchAuditCheckRelation(AuditCheckRelationSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param AuditCheckRelation 登录数据
	 * @return 风险检查与风险审计关系
	 */
	public AuditCheckRelation registAuditCheckRelation(AuditCheckRelation auditCheckRelation) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param acrid 风险检查与风险审计关系ID
	 * @return
	 */
	public void deleteAuditCheckRelation(Integer acrid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param auditCheckRelation 变更数据
	 * @return 风险检查与风险审计关系
	 */
	public AuditCheckRelation updateAuditCheckRelation(AuditCheckRelation auditCheckRelation) throws BLException;

}
