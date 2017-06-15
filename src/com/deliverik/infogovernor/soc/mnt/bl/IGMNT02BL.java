/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
/**
 * 概述:容量监控管理接口
 * 功能描述：
 * 创建记录：
 */
public interface IGMNT02BL extends BaseBL{
	/**
	 * 容量对象list查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO searchSOC0423Action(IGMNT02DTO dto) throws BLException;
	
	/**
	 * 容量对象删除
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO deleteSOC0423Action(IGMNT02DTO dto) throws BLException;
	/**
	 * 容量对象更新
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO updateSOC0423Action(IGMNT02DTO dto) throws BLException;
	/**
	 * 容量对象监控管理 获取hostlist for select
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO initHostListSelectAction(IGMNT02DTO dto) throws BLException;
    /**
     * <p>
	 * Description: 错误日志查询
	 * </p>
     * @param dto
     * @return IGMNT02DTO
     * @throws BLException
	 * @update
     */
	public IGMNT02DTO searchSOC0305Action(IGMNT02DTO dto) throws BLException;

	public IGMNT02DTO getEiImportProgrammeAction(IGMNT02DTO dto) throws BLException;

	public IGMNT02DTO searchSOC0305ByCond(IGMNT02DTO dto) throws BLException;
	
	public IGMNT02DTO updateSOC0305(IGMNT02DTO dto) throws BLException;

	public IGMNT02DTO getAlarmSeverity(IGMNT02DTO dto) throws BLException;

	public IGMNT02DTO getCiList(IGMNT02DTO dto) throws BLException;
	/**
	 * 查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO searchSOC0306Action(IGMNT02DTO dto) throws BLException;
	
	/**
	 * 弹出窗口查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMNT02DTO popSOC0306Action(IGMNT02DTO dto) throws BLException ;
}
