/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM11DTO;

/**
 * 签到BL 
 * 2015年3月13日10:21:51
 */

public interface IGDRM11BL extends BaseBL {
	 /**
     * @Description: 签到初始化显示
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM11DTO    
     * @throws
     */
	public IGDRM11DTO initIGDRM1101Action(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: 签到查操作
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO updateIGDRM1101Action(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: 代签到初始化显示 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO initIGDRM1102Action(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: 代签到操作 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO updateIGDRM1102Action(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: 代签到-可签到流程初始化显示 
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public IGDRM11DTO showSigninableProcess(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: 签到-数据推送 
	 * @param dto
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public void pushSigninableMessage(IGDRM11DTO dto)throws BLException;
	/**
	 * @Description: 代签到-数据推送 
	 * @param dto
	 * @throws BLException    
	 * IGDRM11DTO    
	 * @throws
	 */
	public void pushSigninHelpMessage(IGDRM11DTO dto)throws BLException;

}
