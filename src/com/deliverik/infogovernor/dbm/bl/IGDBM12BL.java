/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM12DTO;



/**
 * @概述常熟农商银行科技运行Dashboard BL
 * @功能描述 	 1. 
 *           2. 
 *           3. 
 *           4. 查询业务部和科技部工作数量
 * @创建记录 孙东东  2014/07/17
 * @version 1.0
 */
public interface IGDBM12BL extends BaseBL{
	
	/**
	 * 检查次数年度统计数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRcclass(IGDBM12DTO dto) throws BLException;
	
	/**
	 * 
	 * 各类问题及工作占比数据取得
	 * 
	 * @return dto
	 * @throws BLException
	 */
	public IGDBM12DTO getRcclassByMonth(IGDBM12DTO dto) throws BLException;

	
	/**
	 * 功能: 查询业务部和科技部工作数量
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getPieValue(IGDBM12DTO dto)throws BLException;
	
	/**
	 * 年度工作趋势数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRcTestMode(IGDBM12DTO dto) throws BLException;
	
	/**
	 * 信息安全工作总体趋势数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskCheckResult(IGDBM12DTO dto) throws BLException;
	
	/**
	 * 问题及整改情况数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getQuestions(IGDBM12DTO dto) throws BLException;
	
	/**
	 * 功能:各部门处理工单数量趋势分析xml
	 * @param IGDBM12DTO dto
	 * @return 各部门处理工单数量趋势分析
	 * @throws BLException
	 */
	public IGDBM12DTO setEventAvgCost(IGDBM12DTO dto)  throws BLException;

	/**
	 * 工单个类别数量占比数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getWorkOrderAction(IGDBM12DTO dto) throws BLException;

	/**
	 * 变更结果占比统计数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getChangeResultAction(IGDBM12DTO dto) throws BLException;

	/**
	 * 问题解决数量对比数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getQotnDataAction(IGDBM12DTO dto) throws BLException;

	/**
	 * 功能:生成处长首页变更计划日历xml
	 * @param IGDBM03DTO dto
	 * @return 变更计划数据
	 * @throws BLException
	 */
	public IGDBM12DTO setChangePlan(IGDBM12DTO dto) throws BLException;

	/**
	 * 时间趋势分析数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getEventTrendAction(IGDBM12DTO dto) throws BLException;
	public IGDBM12DTO getBusinessDepart(IGDBM12DTO dto) throws BLException;
	public IGDBM12DTO getScienceDepart(IGDBM12DTO dto) throws BLException;

	/**
	 * 流程查询操作开始
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchProcessRecordAction(IGDBM12DTO dto) throws BLException;

	/**
	 * 检查工作查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchRiskWorkAction(IGDBM12DTO dto) throws BLException;

	//科技风险 start↓↓↓↓↓
	/**
	 * 功能: 获取 风险部门工作情况-电子表数据
	 * @param  IGDBM12DTO dto
	 * @return  风险部门工作 数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getCounterValue(IGDBM12DTO dto)throws BLException;
	/**
	 * 功能: 获取 风险部门工作情况-电子表数据
	 * @param  IGDBM12DTO dto
	 * @return  风险部门工作 数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskCheck(IGDBM12DTO dto)throws BLException;
	/**
	 * 功能: 获取 本年度风险工作覆盖情况-检查
	 * @param  IGDBM12DTO dto
	 * @return  风险部门工作 数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskProblem(IGDBM12DTO dto)throws BLException;
	/**
	 * 功能: 获取 本年度风险问题及整改占比-问题及整改
	 * @param  IGDBM12DTO dto
	 * @return  风险部门工作 数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskRepository(IGDBM12DTO dto)throws BLException;
	/**
	 * 功能: 获取 风险评估工作总体情况-柱线图-问题及整改完成
	 * @param  IGDBM12DTO dto
	 * @return  风险部门工作 数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskRectification(IGDBM12DTO dto)throws BLException;
	/**
	 * 功能: 获取 风险评估工作总体情况-柱线图-检查工作
	 * @param  IGDBM12DTO dto
	 * @return  风险部门工作 数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskAssess(IGDBM12DTO dto)throws BLException;
	/**
	 * 功能: 获取 风险评估工作总体情况-柱线图-检查工作
	 * @param  IGDBM12DTO dto
	 * @return  风险部门工作 数量值
	 * @throws BLException
	 */
	public IGDBM12DTO searchIssueCorrectiveByField(IGDBM12DTO dto)throws BLException;
	/**
	 * 功能: 获取 风险评估工作总体情况-柱线图-检查工作
	 * @param  IGDBM12DTO dto
	 * @return  风险部门工作 数量值
	 * @throws BLException
	 */
	public IGDBM12DTO searchCounterInfo(IGDBM12DTO dto)throws BLException;
	/**
	 * 资产砖取页面操作(风险点,检查项)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchRiskRepositoryAction(IGDBM12DTO dto) throws BLException;
	
	//科技风险 end↑↑↑↑↑
}
