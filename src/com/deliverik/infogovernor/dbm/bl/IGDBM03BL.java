/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM03DTO;

/**
 * @概述锦州银行流程主题首页BL
 * @功能描述： 1.事件问题变更数量
 *           2.本月事件及本月问题数量
 *           3.故障统计
 *           4.年度事件数量及平均解决问题趋势
 *           5.年度问题数量及解决率
 *           6.年度变更数量及成功率
 *           7.柱图
 *           8.备注日历
 * @创建记录 李旭峙  2010/11/29
 * @version 1.0
 */

public interface IGDBM03BL extends BaseBL {
	/**
	 * 
	 * 功能:处长首页事件、问题、变更数量取得处理
	 * @param IGDBM03DTO dto
	 * @return 事件、问题、变更数
	 * @throws BLException
	 */
	public IGDBM03DTO getProcessCount(IGDBM03DTO dto)  throws BLException;

	
	/**
	 * 功能:生成处长首页变更计划日历xml
	 * @param IGDBM03DTO dto
	 * @return 变更计划数据
	 * @throws BLException
	 */
	public IGDBM03DTO setChangePlan(IGDBM03DTO dto) throws BLException ;
	

	/**
	 * 功能:生成本月各事件类型不同紧急度数量xml
	 * @param IGDBM03DTO dto
	 * @return 本月各事件类型不同紧急度数量
	 * @throws BLException
	 */
	public IGDBM03DTO setAllTypeEventCount(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * 功能:处长首页本月事件数量取得处理
	 * @param IGDBM03DTO dto
	 * @return 本月事件数量
	 * @throws BLException
	 */
	public IGDBM03DTO getCurrentMouthEventCount(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * 功能:处长首页本月问题数量取得处理
	 * @param IGDBM03DTO dto
	 * @return 本月问题数量
	 * @throws BLException
	 */
	public IGDBM03DTO getCurrentMouthProblemCount(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * 
	 * 功能:流程主题各种类型工作数量取得处理
	 * @param IGDBM03DTO dto
	 * @return 各种类型工作数量
	 * @throws BLException
	 */
	public IGDBM03DTO getAllTypeWorkCount(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * 功能:生成处长首页年度事件数量及平均解决时间xml
	 * @param IGDBM03DTO dto
	 * @return 年度事件数量及平均解决时间
	 * @throws BLException
	 */
	public IGDBM03DTO setEventAvgCost(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * 功能:生成处长首页年度问题数量及平均解决率xml
	 * @param IGDBM03DTO dto
	 * @return 年度问题数量及平均解决率
	 * @throws BLException
	 */
	public IGDBM03DTO setproProblemAvgSolute(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * 功能:生成处长首页年度问题数量及平均解决率xml
	 * @param IGDBM03DTO dto
	 * @return 年度问题数量及平均解决率
	 * @throws BLException
	 */
	public IGDBM03DTO setproChangeAvgSuccess(IGDBM03DTO dto)  throws BLException;

	/**
	 * 功能:生成事件优先级、影响程度、紧急程度xml
	 * @param IGDBM03DTO dto
	 * @throws BLException
	 */
	public IGDBM03DTO setproincidentInfo(IGDBM03DTO dto)  throws BLException;
	
	/**
	 * 功能:生成知识分类占比xml
	 * @param IGDBM03DTO dto
	 * @throws BLException
	 */
	public IGDBM03DTO setKnowledgeInfo(IGDBM03DTO dto)  throws BLException;
}
