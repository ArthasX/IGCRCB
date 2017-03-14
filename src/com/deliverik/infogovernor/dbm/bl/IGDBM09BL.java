/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM09DTO;

/**
 * @概述锦州银行系统可用率分析首页BL
 * @功能描述 1.当前实际可用率         
 *			2.实际可用率全年累计        
 *			3.可用率年度趋势         
 *			4.工作及时解决率趋势
 * @创建记录：李旭峙    2010/12/01
 * @version 1.0
 */

public interface IGDBM09BL extends BaseBL {

	/**
	 * 功能: 取得当前实际可用率
	 * @param  IGDBM09DTO dto
	 * @return 当前实际可用率值
	 * @throws BLException
	 */
	public IGDBM09DTO getCurrentActualAvailability(IGDBM09DTO dto) throws BLException;
	
	/**
	 * 功能: 取得实际可用率全年累计
	 * @param  IGDBM09DTO dto
	 * @return 实际可用率全年累计值
	 * @throws BLException
	 */
	public IGDBM09DTO getYearActualAvailability(IGDBM09DTO dto) throws BLException;
	
	/**
	 * 功能: 取得可用率年度趋势
	 * @param  IGDBM09DTO dto
	 * @return 可用率年度趋势12个月值
	 * @throws BLException
	 */
	public IGDBM09DTO getAvailabilityYearTrends(IGDBM09DTO dto) throws BLException;
	
	/**
	 * 功能: 取得工作及时解决率趋势
	 * @param  IGDBM09DTO dto
	 * @return 工作及时解决率趋势12个月值
	 * @throws BLException
	 */
	public IGDBM09DTO getWorkTimelySolutionlyTrends(IGDBM09DTO dto) throws BLException;
}
