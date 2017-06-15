/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;

public interface IGPRJ01BL {
	
	public IGPRJ01DTO insertEntityAction(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO findProjectByCond(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO findProjectById(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO insertProjectLog(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO closeProject(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO findAllProject(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO getPrincipal(IGPRJ01DTO dto) throws BLException;//负责人
	
	public IGPRJ01DTO removePrincipal(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO addPrincipal(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO getParticipant(IGPRJ01DTO dto) throws BLException;//参与者
	
	/**
	 * 根据项目类型编码，返回项目类型名称
	 */
	public IGPRJ01DTO findProjectTypeAction(IGPRJ01DTO dto);
	
	public IGPRJ01DTO removeParticipant(IGPRJ01DTO dto) throws BLException;
	
	public IGPRJ01DTO addParticipant(IGPRJ01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 获得日志类别显示
	 * </p>
	 */
	public IGPRJ01DTO findProjectLogType(IGPRJ01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 查找日志类别详细信息显示
	 * </p>
	 */
	public IGPRJ01DTO searchProjectLogTypeMessage(IGPRJ01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 项目删除处理
	 * </p>
	 */
	public IGPRJ01DTO removeProject(IGPRJ01DTO dto) throws BLException;
	
	/**
	 * 项目基本信息修改
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRJ01DTO updateProject(IGPRJ01DTO dto)throws BLException;
	
	/**
	 * 项目基本信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRJ01DTO selectProject(IGPRJ01DTO dto) throws BLException ;
	
	/**
	 * 投资使用情况报表导出查询
	 * @param dto
	 * @return
	 */
	public IGPRJ01DTO exportSearchAction(IGPRJ01DTO dto);
	
	/***
	 * 投资类使用合同明细报表导出查询
	 * @param dto
	 * @return
	 */
	public IGPRJ01DTO exportSearchInvestCaAction(IGPRJ01DTO dto);
	
}
