package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR09DTO;

/**
 * 概述:非现场监管报表DashBoard后台处理
 * 创建人：王省
 * 创建记录： 2013-09-10
 */
public interface IGSMR09BL extends BaseBL{
	
	/**
	 * 获取电子交易笔数合计和电子交易金额合计
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getElecTransTotal(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 跨行交易笔数分析
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getMultiBankTransCount(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getTechnologyInfo(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 机构信息科技投入
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPieGraph(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 信息科技人力资源投入
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPieGraph1(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 左侧第二行第二个竖图
	 * 年报
	 */
	public IGSMR09DTO getTechnologyAudit(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 交易笔数趋势分析
	 * 季报 
	 */
	public IGSMR09DTO getMultiBankTransCountTrend(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 电子银行业务规模
	 * 季报
	 */
	public IGSMR09DTO getElecWorkScale(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 右侧第一行横图
	 * 年报 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPersonnel(IGSMR09DTO dto) throws BLException ;

	/**
	 * 跨行交易分析（金额）
	 * 季报 
	 */
	public IGSMR09DTO getMultiBankTransMoney(IGSMR09DTO dto) throws BLException;

	/**
	 * 交易金额趋势分析
	 * 季报 
	 */
	public IGSMR09DTO getMultiBankTransMoneyTrend(IGSMR09DTO dto) throws BLException;

	/**
	 * 左侧第二行第一个竖图
	 * 年报
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getTechnologyNumber(IGSMR09DTO dto) throws BLException;

	/**
	 * 年度项目情况
	 * 右侧第三行饼图
	 * 年报
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getBarGraph(IGSMR09DTO dto) throws BLException;

	/**
	 * 右侧第二行三个横图
	 * 年报
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getTechnologySort(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 信息科技项目分析报表
	 * 系统类别占比
	 * 左侧饼图
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalysePieGraph(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 信息科技项目分析报表
	 * 近一年项目情况分析
	 * 右侧折现图
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalyseTrendGraph(IGSMR09DTO dto) throws BLException;
	
	/**
	 * 信息科技项目分析报表
	 * 项目明细
	 * 上部表格
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalyseGridGraph(IGSMR09DTO dto) throws BLException;
}
