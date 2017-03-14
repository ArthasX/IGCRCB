/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM07DTO;

/**
 * @概述锦州银行变更综合分析首页BL
 * @功能描述 1. 取得月变更类型数量及占比值
 *           2. 取得变更平均解决时间趋势值
 *           3. 取得变更数量趋势值
 *           4. 取得变更及时解决率值
 * @创建记录 赵俊  2010/11/30
 * @version 1.0
 */

public interface IGDBM07BL extends BaseBL {

	/**
	 * 功能: 取得月变更类型数量及占比值
	 * @param  IGDBM07DTO dto
	 * @return 变更各类型数据值
	 * @throws BLException
	 */
	public IGDBM07DTO getPieValue(IGDBM07DTO dto) throws BLException;
	
	/**
	 * 功能: 取得变更平均解决时间趋势值
	 * @param  IGDBM07DTO dto
	 * @return 变更平均解决时间趋势12个月值
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForAvg(IGDBM07DTO dto) throws BLException;
	
	/**
	 * 功能: 取得变更数量趋势值
	 * @param  IGDBM07DTO dto
	 * @return 变更数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForCount(IGDBM07DTO dto) throws BLException;
	
	/**
	 * 功能: 取得变更及时解决率趋势值
	 * @param  IGDBM07DTO dto
	 * @return 变更数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForSolve(IGDBM07DTO dto) throws BLException;
	/**
	 * 功能: 取得变更综合分析页面所有模块值
	 * @param  IGDBM07DTO dto
	 * @return 变更综合分析页面所有模块值
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeAllMode(IGDBM07DTO dto) throws BLException;
}
