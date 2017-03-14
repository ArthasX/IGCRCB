package com.deliverik.infogovernor.soc.mnt.bl;


import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT03DTO;

/**
 * 资产配置管理业务逻辑接口
 *
 * 
 */
public interface IGMNT03BL extends BaseBL {
	/**
	 * 设备配置信息编辑画面初期化处理
	 *
	 * @param dto IGMNT03DTO
	 * @return IGMNT03DTO
	 */
	public IGMNT03DTO initIGMNT0204Action(IGMNT03DTO dto) throws BLException;
}
