/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM05DTO;

/**
 * @概述锦州银行问题综合分析首页BL
 * @功能描述 1. 取得月问题类型数量及占比值
 *           2. 取得问题平均解决时间趋势值
 *           3. 取得问题数量趋势值
 *           4. 取得问题及时解决率值
 * @创建记录 赵俊  2010/11/29
 * @version 1.0
 */

public interface IGDBM05BL extends BaseBL {

	/**
	 * 功能: 取得月问题类型数量及占比值
	 * @param  IGDBM05DTO dto
	 * @return 问题各类型数据值
	 * @throws BLException
	 */
	public IGDBM05DTO getPieValue(IGDBM05DTO dto) throws BLException;
	
	/**
	 * 功能: 取得问题平均解决时间趋势值
	 * @param  IGDBM05DTO dto
	 * @return 问题平均解决时间趋势12个月值
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForAvg(IGDBM05DTO dto) throws BLException;
	
	/**
	 * 功能: 取得问题数量趋势值
	 * @param  IGDBM05DTO dto
	 * @return 问题数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForCount(IGDBM05DTO dto) throws BLException;
	
	/**
	 * 功能: 取得问题及时解决率趋势值
	 * @param  IGDBM05DTO dto
	 * @return 问题数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForSolve(IGDBM05DTO dto) throws BLException;
	/**
	 * 功能: 取得问题综合分析页面所有模块值
	 * @param  IGDBM05DTO dto
	 * @return 问题综合分析页面所有模块值
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemAllMode(IGDBM05DTO dto) throws BLException;
}
