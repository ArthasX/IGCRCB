/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * 
 * 报表信息业务逻辑接口
 *
 */
public interface ReportFileDefinitionBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(ReportFileDefinitionSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param rfdid 报表信息ID
	 * @return 报表信息
	 */
	public ReportFileDefinition searchReportFileDefinitionByKey(Integer rfdid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部报表信息信息
	 */
	public List<ReportFileDefinition> searchReportFileDefinitionAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ReportFileDefinition> searchReportFileDefinition(ReportFileDefinitionSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param ReportFileDefinition 登录数据
	 * @return 报表信息
	 */
	public ReportFileDefinition registReportFileDefinition(ReportFileDefinition reportFileDefinition) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param rfdid 报表信息ID
	 * @return
	 */
	public void deleteReportFileDefinition(Integer rfdid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param reportFileDefinition 变更数据
	 * @return 报表信息
	 */
	public ReportFileDefinition updateReportFileDefinition(ReportFileDefinition reportFileDefinition) throws BLException;
	
	/**
	 * 校验报表显示名称是否存在
	 * 
	 * @param rfdtitle 报表显示名称
	 * @return
	 * @throws BLException 
	 */
	public void checkRfdtitle(String rfdtitle) throws BLException;
	
	/**
	 * 校验报表发布名称是否存在
	 * 
	 * @param rfdtitle 报表发布名称
	 * @return
	 * @throws BLException 
	 */
	public void checkRfdfilename(String rfdfilename,String rfdtype) throws BLException;
	
}
