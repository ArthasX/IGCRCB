/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM02DTO;

/**
 * @概述锦州银行行长首页BL
 * @功能描述： 1.事件问题变更数量
 *           2.本月事件及本月问题数量
 *           3.监控面板
 *           4.年度事件数量及平均解决问题趋势
 *           5.年度问题数量及解决率
 *           6.年度变更数量及成功率
 *           7.柱图
 *           8.备注日历
 * @创建记录：李旭峙 2010/10/26
 * @version 1.0
 */

public interface IGDBM02BL extends BaseBL {

	/**
	 * 功能:行长首页监视器控件
	 * @param IGDBM02DTO dto
	 * @return 各系统运行情况
	 * @throws BLException
	 */
	public IGDBM02DTO getMonitor(IGDBM02DTO dto) throws BLException;
	
	
	/**
	 * 
	 * 功能:处长首页事件、问题、变更数量取得处理
	 * @param IGDBM02DTO dto
	 * @return 事件、问题、变更数量
	 * @throws BLException
	 */
	public IGDBM02DTO getProcessCount(IGDBM02DTO dto)  throws BLException;
	
	
	/**
	 * 功能:生成处长首页变更计划日历xml
	 * @param IGDBM02DTO dto
	 * @return 变更计划日历
	 * @throws BLException
	 */
	public IGDBM02DTO setChangePlan(IGDBM02DTO dto) throws BLException ;
	
	
	
	/**
	 * 功能:处长首页本月事件数量取得处理
	 * @param IGDBM02DTO dto
	 * @return 本月事件数量
	 * @throws BLException
	 */
	public IGDBM02DTO getCurrentMouthEventCount(IGDBM02DTO dto)  throws BLException;
	
	/**
	 * 功能:处长首页本月问题数量取得处理
	 * @param IGDBM02DTO dto
	 * @return 本月问题数量
	 * @throws BLException
	 */
	public IGDBM02DTO getCurrentMouthProblemCount(IGDBM02DTO dto)  throws BLException;
	
	/**
	 * 
	 * 功能:处长首页各中心工作数量取得处理
	 * @param IGDBM02DTO dto
	 * @return 各中心工作数量
	 * @throws BLException
	 */
	public IGDBM02DTO getWorkCount(IGDBM02DTO dto)  throws BLException;
	

	/**
	 * 功能:生成处长首页年度事件数量及平均解决时间xml
	 * @param IGDBM02DTO dto
	 * @return 事件数量及平均解决时间
	 * @throws BLException
	 */
	public IGDBM02DTO setEventAvgCost(IGDBM02DTO dto)  throws BLException;
	

	/**
	 * 功能:生成处长首页年度问题数量及平均解决率xml
	 * @param IGDBM02DTO dto
	 * @return 年度问题数量及平均解决率
	 * @throws BLException
	 */
	public IGDBM02DTO setproProblemAvgSolute(IGDBM02DTO dto)  throws BLException;
	

	/**
	 * 功能:生成处长首页年度问题数量及平均解决率xml
	 * @param IGDBM02DTO dto
	 * @return 年度问题数量及平均解决率
	 * @throws BLException
	 */
	public IGDBM02DTO setproChangeAvgSuccess(IGDBM02DTO dto)  throws BLException;
	
	/**
	 * 功能:银联成功率线形图
	 * @param IGDBM02DTO dto
	 * @return 银联成功率
	 * @throws BLException
	 */
	public IGDBM02DTO getPLine(IGDBM02DTO dto) throws BLException;
	
	/**
	 * 功能:银联成功率仪表
	 * @param IGDBM02DTO dto
	 * @return 银联成功数量
	 * @throws BLException
	 */
	public IGDBM02DTO getStudy(IGDBM02DTO dto)throws BLException;
}
