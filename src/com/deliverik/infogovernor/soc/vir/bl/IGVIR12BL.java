package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR12DTO;

/**
 * 概述: 资源占用情况
 * 功能描述: 资源占用情况
 * 创建记录: 2014/02/12
 * 修改记录:
 */
public interface IGVIR12BL extends BaseBL {
	/**
	 * vCenter、host信息取得
	 *
	 * @param dto IGVIR12DTO
	 * @return IGVIR12DTO
	 */
	public IGVIR12DTO getvCenterList(IGVIR12DTO dto) throws BLException;
	/**
	 * vCenter、host信息取得
	 *
	 * @param dto IGVIR12DTO
	 * @return IGVIR12DTO
	 */
	public IGVIR12DTO getHostInfo(IGVIR12DTO dto) throws BLException;
	
	/**
	 * 启动或者关闭虚机
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO startOrStopPowerOfVM(IGVIR12DTO dto) throws BLException;
	
	/**
	 * 使用情况初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO initIGVIR1202Action(IGVIR12DTO dto) throws BLException;
	
	/**
	 * 指定vCenterHost资源使用情况查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO searchHostUsedAction(IGVIR12DTO dto) throws BLException;
}
