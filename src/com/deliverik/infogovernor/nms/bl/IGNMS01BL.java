/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.bl.task.NMSBaseBL;
import com.deliverik.infogovernor.nms.dto.IGNMS01DTO;

/**
 * 概述: 自动发现BL接口
 * 功能描述: 自动发现BL接口
 * 创建记录: 2013/12/20
 * 修改记录: 
 */
public interface IGNMS01BL extends NMSBaseBL{
	
	/**
	 * 获取组版本
	 * 需要传入参数： groupID（必须）
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO searchGroupVersionAction(IGNMS01DTO dto) throws BLException;

    /**
     * <p>
     * 查询拓扑xml
     * </p>
     * 需要传出参数： userid（必须） groupID（可选） topoType（可选，默认为全网） groupVersion （各选，为空时查询最新版）
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGNMS01DTO searchTopoXML(IGNMS01DTO dto) throws BLException;
    
    /**
     *  生成拓扑显示用xml
     *  
     * @param dto
     * @return
     * @throws BLException 
     */
    public IGNMS01DTO saveTopoXML(IGNMS01DTO dto) throws BLException;
    
    /**
     * <p>
     * 更新拓扑坐标
     * </p>
     * 
     * 需要传出参数： userid（必须） groupID（可选） topoType（可选，默认为全网）
     * 
     * @param dto
     * @return
     * @throws BLException 
     */
    public IGNMS01DTO saveTopoInfo(IGNMS01DTO dto) throws BLException;
    
    /**
     * 获取面板大小
     * 
     * @param dto
     * @return
     */
    public IGNMS01DTO getPanelSize(IGNMS01DTO dto) throws BLException;
    
    /**
     * 更新面板大小
     * 
     * @param dto
     * @return
     * @throws BLException 
     */
    public IGNMS01DTO updatePanelSize(IGNMS01DTO dto) throws BLException;
    
	/**
	 * 查看SNMP配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO initNMS02Action(IGNMS01DTO dto) throws BLException;
	
	/**
	 * 登记SNMP配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO insertNMS02Action(IGNMS01DTO dto) throws BLException ;
	
	/**
	 * 删除SNMP配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO deleteNMS02Action(IGNMS01DTO dto) throws BLException ;

	/**
	 * 查看任务配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO initNMS03Action(IGNMS01DTO dto) throws BLException;
	
	/**
	 * 登记任务配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO insertNMS03Action(IGNMS01DTO dto) throws BLException ;
	
	/**
	 * 删除任务配置信息
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO deleteNMS03Action(IGNMS01DTO dto) throws BLException ;
	
	/**
	 * 启动扫描程序
	 * 需要传出参数： groupID（必须）
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO execCommandAction(IGNMS01DTO dto) throws BLException;
	 /**
	 * 取得拓扑设备图片路径
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO getImgUrl(IGNMS01DTO dto) throws BLException;
	/**
	 * 取得拓扑设备类型
	 * @param dto IGNMS01DTO
	 * @return IGNMS01DTO
	 * @throws BLException
	 */
	public IGNMS01DTO getDevType(IGNMS01DTO dto) throws BLException;
}
