/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;


/**
 * 值班管理业务逻辑接口
 *
 *
 */
public interface IGDUT02BL extends BaseBL {

	/**
	 * <p>
	 * Description: 值班交接详细信息查询
	 * </p>
	 */
	public IGDUT02DTO initIGDUT0204Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * 值班交接确认信息查询处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0205Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * 值班交接确认处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO confirmIGDUT0205Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * 值班中止详细信息查询处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0207Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * 值班中止处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO terminateIGDUT0207Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 值班人初期显示
	 * </p>
	 */
	public IGDUT02DTO initIGDUT0202Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 添加值班人
	 * </p>
	 */
	public IGDUT02DTO addDutyPersonAction(IGDUT02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 删除值班人
	 * </p>
	 */
	public IGDUT02DTO removeDutyPersonAction(IGDUT02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 日历初始化信息
	 * </p>
	 */
	public IGDUT02DTO initIGDUT0201Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * 值班日报初始化处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0203Action(IGDUT02DTO dto) throws BLException;
	
	/**
	 * 值班日报保存处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO insertIGDUT0203Action(IGDUT02DTO dto) throws BLException;
	/**
	 * 
	 * Description: 启动值班计划查询
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 * @throws BLException
	 * @update
	 * 
	 */
	public IGDUT02DTO searchDutyPlanAction(IGDUT02DTO dto) throws BLException;

	/**
	 * 启动处理
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO changeDutyPlanAction(IGDUT02DTO dto) throws BLException ;
}
