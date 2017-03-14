/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM01DTO;

/**
 * @概述锦州银行行长首页BL
 * @功能描述： 1.各地分行款项及涨幅
 *           2.监控面板
 *           3.银联、ATM、POS成功率仪表盘
 *           4.银联、ATM、POS成功率柱图
 *           5.当前工作统计
 *           6.变更计划查询
 *           7.IT运营趋势
 * @创建记录 李旭峙  2010/11/29
 * @version 1.0
 */

public interface IGDBM01BL extends BaseBL {

	/**
	 * 功能:银联成功率线形图
	 * @param IGDBM01DTO dto
	 * @return 银联成功率
	 * @throws BLException
	 */
	public IGDBM01DTO getPLine(IGDBM01DTO dto) throws BLException;
	
	/**
	 * 功能:当前工作柱形图
	 * @param IGDBM01DTO dto
	 * @return 当前工作数
	 * @throws BLException
	 */
	public IGDBM01DTO getCurrentWorkPiller(IGDBM01DTO dto) throws BLException;
	
	/**
	 * 功能:地图分行数据
	 * @param IGDBM01DTO dto
	 * @return 各分行存款贷款核心交易数
	 * @throws BLException
	 */
	public IGDBM01DTO getMap(IGDBM01DTO dto)throws BLException;
	
	/**
	 * 功能:银联成功率仪表
	 * @param IGDBM01DTO dto
	 * @return 银联成功数量
	 * @throws BLException
	 */
	public IGDBM01DTO getStudy(IGDBM01DTO dto)throws BLException;
	
	
	
	/**
	 * 功能:行长首页监视器控件
	 * @param IGDBM01DTO dto
	 * @return 各系统运行情况
	 * @throws BLException
	 */
	public IGDBM01DTO getMonitor(IGDBM01DTO dto) throws BLException;
	
	
	/**
	 * 功能:生成本月各事件类型不同紧急度数量xml
	 * @param IGDBM01DTO dto
	 * @return 各事件类型不同紧急度数量
	 * @throws BLException
	 */
	public IGDBM01DTO setAllTypeEventCount(IGDBM01DTO dto)  throws BLException;
	
	/**
	 * 功能:行长首页日历xml
	 * @param IGDBM01DTO dto
	 * @return 每月各天数
	 * @throws BLException
	 */
	public IGDBM01DTO setCalendar(IGDBM01DTO dto) throws BLException ;
	
	/**
	 * 功能:行长首页IT运行
	 * @param IGDBM01DTO dto
	 * @return 每月变更、问题、事件数量
	 * @throws BLException
	 */
	public IGDBM01DTO setITChart(IGDBM01DTO dto)  throws BLException;
}
