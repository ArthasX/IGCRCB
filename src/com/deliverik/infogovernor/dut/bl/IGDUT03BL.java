/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;

/**
 * 值班情况按日期汇总BL
 */
public interface IGDUT03BL extends BaseBL {
	
	/**
	 * 
	 * Description: 值班检查信息查询
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 * @throws BLException
	 * @update
	 */
	public IGDUT03DTO searchDutyResultAction(IGDUT03DTO dto) throws BLException;
	
	/**
	 * 值班情况汇总查询处理
	 *
	 * @param dto IGDUT03DTO
	 * @return IGDUT03DTO
	 */
	public IGDUT03DTO searchAllDutyResultAction(IGDUT03DTO dto) throws BLException;

	/**
	 * 
	 * Description: 值班预警信息查询
	 * @param dto IGDUT03DTO
	 * @return IGDUT03DTO
	 * @throws BLException
	 * @update
	 */
	public IGDUT03DTO initIGDUT0301Action(IGDUT03DTO dto) throws BLException;
	
    /**
     * 维修表添加功能动作
     * @param dto IGDUT03DTO
     * @return IGDUT03DTO
     * @throws BLException
     * @update
     */
    public IGDUT03DTO registOnDutyPersonRecordAction(IGDUT03DTO dto) throws BLException;
    
    /**
     * 维修表删除功能动作
     * @param dto IGDUT03DTO
     * @return IGDUT03DTO
     * @throws BLException
     * @update
     */
    public IGDUT03DTO deleteOnDutyPersonRecordAction(IGDUT03DTO dto) throws BLException;
    
    /**
     * 维修表更新功能动作
     * @param dto IGDUT03DTO
     * @return IGDUT03DTO
     * @throws BLException
     * @update
     */
    public IGDUT03DTO updateOnDutyPersonRecordAction(IGDUT03DTO dto) throws BLException;

    	/**
    	 * 维修表条件检索
    	 * @param dto IGDUT03DTO
    	 * @return IGDUT03DTO
    	 * @
    	 */
    public IGDUT03DTO searchOnDutyPersonRecord(IGDUT03DTO dto) throws BLException;
    
    /**
     * 分页检索
     * @param dto
  	 * @return IGDUT03DTO
     */
    public IGDUT03DTO searchODPRAction(IGDUT03DTO dto)
			throws BLException; 
    
    /** 初始化更新页
     * 
     * @param dto
  	 * @return IGDUT03DTO
     *
     */
    public IGDUT03DTO initIGDUT0304Action(IGDUT03DTO dto) throws BLException;
    
    /**
     * 查询进入区域Checkbox List
     * 
   	 * @return
     */
    public IGDUT03DTO searchOnDutyPersonRecordArea(IGDUT03DTO dto) throws BLException;

    /**
     * 值班结果说明修改处理
     * @param dto
     * @return
     * @throws BLException
     */
	public IGDUT03DTO changeDrresultAction(IGDUT03DTO dto) throws BLException;
}
