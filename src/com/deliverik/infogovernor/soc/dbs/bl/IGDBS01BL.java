/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.dto.IGDBS01DTO;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;

/**
 * @概述SOC EMC运维存储管理平台首页BL
 * @功能描述 1. 左IOPS/吞吐量
 *			2. 左主机信息
 *			3. 左读写比率、缓存命中率
 *			4. 右IOPS/吞吐量
 *			5. 右主机信息
 * 			6. 右读写比率、缓存命中率
 *			7. 业务运行情况
 *			8. 流程KPI
 *			9.运维日历显示
 * @创建记录：李旭峙    2010/12/09
 * @version 1.0
 */

public interface IGDBS01BL extends BaseBL {

	/**
	 * 功能: 运维日历显示
	 * @param  IGDBS01DTO dto
	 * @return 运维日历xml返回
	 * @throws BLException
	 */
	public IGDBS01DTO getOperationManagement(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: 业务运行情况
	 * @param  IGDBS01DTO dto
	 * @return 业务运行数据
	 * @throws BLException
	 */
	public IGDBS01DTO getBusinessRus(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: 流程KPI
	 * @param  IGDBS01DTO dto
	 * @return 流程KPI
	 * @throws BLException
	 */
//	public IGDBS01DTO getProcessKPI(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: IOPS/吞吐量
	 * @param  IGDBS01DTO dto
	 * @return IOPS/吞吐量
	 * @throws BLException
	 */
	public IGDBS01DTO  getIOPSandThroughput1(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: IOPS/吞吐量
	 * @param  IGDBS01DTO dto
	 * @return IOPS/吞吐量
	 * @throws BLException
	 */
	public IGDBS01DTO  getIOPSandThroughputCX(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: IOPS/吞吐量
	 * @param  IGDBS01DTO dto
	 * @return IOPS/吞吐量
	 * @throws BLException
	 */
	public IGDBS01DTO  getIOPSandThroughput2(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: 读比率/写比率/缓存命中率
	 * @param  IGDBS01DTO dto
	 * @return 读比率/写比率/缓存命中率
	 * @throws BLException
	 */
	public IGDBS01DTO  getReadperWriteperHitper1(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: 读比率/写比率/缓存命中率
	 * @param  IGDBS01DTO dto
	 * @return 读比率/写比率/缓存命中率
	 * @throws BLException
	 */
	public IGDBS01DTO  getReadperWriteperHitper2(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: 主机详细信息
	 * @param  IGDBS01DTO dto
	 * @return 主机详细信息
	 * @throws BLException
	 */
	public IGDBS01DTO  getHostInfo1(IGDBS01DTO dto) throws BLException;
	
	/**
	 * 功能: 主机详细信息
	 * @param  IGDBS01DTO dto
	 * @return 主机详细信息
	 * @throws BLException
	 */
	public IGDBS01DTO  getHostInfo2(IGDBS01DTO dto) throws BLException;
	
	/**
	 * DashBoard性能实时数据导入
	 */
	public List<Collect_Symmetrix_Monitor_Rt> getSymmetrixMonitorData();
	
	/**
	 * 生成告警信息
	 * @param dataListAll
	 */
	public void getWarnInfo(List<Collect_Symmetrix_Monitor_Rt> dataListAll)throws BLException;
	/**
	 * get存储饼图
	 * @param dataListAll
	 */
	public IGDBS01DTO  getPieAll(IGDBS01DTO dto) throws BLException;
	/**
	 * 告警查询信息getWarningList
	 * @param dataListAll
	 */
	public IGDBS01DTO  getWarningList(IGDBS01DTO dto) throws BLException;

}
