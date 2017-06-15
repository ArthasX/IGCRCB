/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM04DTO;

/**
 * @概述锦州银行基础设施首页BL
 * @功能描述： 1.四大主机使用率
 *           2.四大主机当日利用率趋势
 *           3.四大主机数据库与中间件使用率
 *           4.核心存储当月利用率趋势
 *           5.相关事件与相关问题数
 * @创建记录 李旭峙  2010/11/29
 * @version 1.0
 */

public interface IGDBM04BL extends BaseBL {

	/**
	 * 功能:当日核心系统主机CPU/内存利用率xml
	 * @param IGDBM04DTO dto
	 * @return 当日核心系统主机cpu内存使用率
	 * @throws BLException
	 */
	public IGDBM04DTO setKernelUseAvg(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * 功能:当日前置系统主机CPU/内存利用率xml
	 * @param IGDBM04DTO dto
	 * @return 当日前置系统主机cpu内存使用率
	 * @throws BLException
	 */
	public IGDBM04DTO setPrefixUseAvg(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * 功能:当日中间业务主机CPU/内存利用率xml
	 * @param IGDBM04DTO dto
	 * @return 当日中间业务主机cpu内存使用率
	 * @throws BLException
	 */
	public IGDBM04DTO setMiddleOperationUseAvg(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * 功能:当日网银主机CPU/内存利用率xml
	 * @param IGDBM04DTO dto
	 * @return 当日网银主机cpu内存使用率
	 * @throws BLException
	 */
	public IGDBM04DTO setNetbankUseAvg(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * 功能:各主机IT运行情况
	 * @param IGDBM04DTO dto
	 * @return 各主机利用率数据
	 * @throws BLException
	 */
	public IGDBM04DTO setEquipment(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * 功能:获得核心业务主机数据库或中间件各部分利用率
	 * @param IGDBM04DTO dto
	 * @return 数据库或中间件各部分利用率
	 * @throws BLException
	 */
	public IGDBM04DTO getSystemPiller(IGDBM04DTO dto)  throws BLException;
	
	/**
	 * 功能:基础设施首页相关事件问题仪表
	 * @param IGDBM04DTO dto
	 * @return 事件问题数量
	 * @throws BLException
	 */
	public IGDBM04DTO getSomeThingsQuestions(IGDBM04DTO dto)throws BLException;
	
	/**
	 * 功能:核心存储当月利用率趋势
	 * @param IGDBM04DTO dto
	 * @return 核心存储当月利用率
	 * @throws BLException
	 */
	public IGDBM04DTO getDoubleColorLine(IGDBM04DTO dto)  throws BLException;
}
