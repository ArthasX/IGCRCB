package com.deliverik.infogovernor.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM05DTO;

/**
 * 概述: 配置分析bl接口
 * 功能描述: 配置分析bl接口
 * 创建记录: yanglongquan 2013/05/22
 * 修改记录: 
 */
public interface IGCIM05BL extends BaseBL {


	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM05DTO searchEntityItemAction(IGCIM05DTO dto) throws BLException;
	
	
	/**
	 * 判断登陆用户是否是设备资产管理角色负责人
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGCIM05DTO checkEntityItemDomain(IGCIM05DTO dto) throws BLException;
	
	
}
