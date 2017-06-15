/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM06DTO;

/**
 * @概述锦州银行事件综合分析首页BL
 * @功能描述 1. 取得月事件类型数量及占比值
 *           2. 取得事件平均解决时间趋势值
 *           3. 取得事件数量趋势值
 *           4. 取得事件及时解决率值
 * @创建记录 赵俊  2010/11/30
 * @version 1.0
 */

public interface IGDBM06BL extends BaseBL {

	/**
	 * 功能: 取得月事件类型数量及占比值
	 * @param  IGDBM06DTO dto
	 * @return 事件各类型数据值
	 * @throws BLException
	 */
	public IGDBM06DTO getPieValue(IGDBM06DTO dto) throws BLException;
	
	/**
	 * 功能: 取得事件平均解决时间趋势值
	 * @param  IGDBM06DTO dto
	 * @return 事件平均解决时间趋势12个月值
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForAvg(IGDBM06DTO dto) throws BLException;
	
	/**
	 * 功能: 取得事件数量趋势值
	 * @param  IGDBM06DTO dto
	 * @return 事件数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForCount(IGDBM06DTO dto) throws BLException;
	
	/**
	 * 功能: 取得事件及时解决率趋势值
	 * @param  IGDBM06DTO dto
	 * @return 事件数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForSolve(IGDBM06DTO dto) throws BLException;
	/**
	 * 功能: 取得事件综合分析页面所有模块值
	 * @param  IGDBM06DTO dto
	 * @return 事件综合分析页面所有模块值
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentAllMode(IGDBM06DTO dto) throws BLException;
}
