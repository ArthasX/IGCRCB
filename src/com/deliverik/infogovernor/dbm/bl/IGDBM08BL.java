/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM08DTO;

/**
 * @概述锦州银行工作综合分析首页BL
 * @功能描述 1. 取得月工作类型数量及占比值
 *           2. 取得工作平均解决时间趋势值
 *           3. 取得工作数量趋势值
 *           4. 取得工作及时解决率值
 * @创建记录 赵俊  2010/11/30
 * @version 1.0
 */

public interface IGDBM08BL extends BaseBL {

	/**
	 * 功能: 取得月工作类型数量及占比值
	 * @param  IGDBM08DTO dto
	 * @return 工作各类型数据值
	 * @throws BLException
	 */
	public IGDBM08DTO getPieValue(IGDBM08DTO dto) throws BLException;
	
	/**
	 * 功能: 取得工作平均解决时间趋势值
	 * @param  IGDBM08DTO dto
	 * @return 工作平均解决时间趋势12个月值
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForAvg(IGDBM08DTO dto) throws BLException;
	
	/**
	 * 功能: 取得工作数量趋势值
	 * @param  IGDBM08DTO dto
	 * @return 工作数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForCount(IGDBM08DTO dto) throws BLException;
	
	/**
	 * 功能: 取得工作及时解决率趋势值
	 * @param  IGDBM08DTO dto
	 * @return 工作数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForSolve(IGDBM08DTO dto) throws BLException;
	/**
	 * 功能: 取得工作综合分析页面所有模块值
	 * @param  IGDBM08DTO dto
	 * @return 工作综合分析页面所有模块值
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkAllMode(IGDBM08DTO dto) throws BLException;
}
