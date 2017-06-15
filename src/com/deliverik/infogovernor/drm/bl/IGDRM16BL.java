/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public interface IGDRM16BL extends BaseBL {
	
	/**
     * @Description: 查询事件所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO getEventssList(IGDRM16DTO dto);
	
	
	/**
	 * @throws BLException 
     * @Description: 查询所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO getList(IGDRM16DTO dto) throws BLException;
	
	/**
     * @Description: 删除事件一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO deleteEventssAction(IGDRM16DTO dto) throws BLException;
	/**
     * @Description: 新增事件一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO insertEventssAction(IGDRM16DTO dto) throws BLException;
	/**
     * @Description:取得事件一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO searchEventssByPK(IGDRM16DTO dto) throws BLException;
	/**
     * @Description:修改事件一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO updateEventssAction(IGDRM16DTO dto) throws BLException;

	 /**
     * @Description: 事件影响范围登记/修改/删除
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM16DTO editScopeAction(IGDRM16DTO dto)throws BLException;
    
    /**
     * @Description:修改事件等级
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO updateEventssLabelsAction(IGDRM16DTO dto) throws BLException;
	
	
	 /**
     * @Description:获取事件等级最大值
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO searchMaxLabelsAction(IGDRM16DTO dto) throws BLException;
}
