/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.fxk.dto.IGFXK07DTO;

public interface IGFXK07BL {
	/**
	 * 新增处理
	 * 风险提示添加
	 * @param Riskmanagerwaring 新增实例
	 * @return 新增实例
	 */
	public IGFXK07DTO addRiskmanagerwaring(IGFXK07DTO dto)	throws BLException;
	
	/**
	 * 查询处理 
	 * 风险提示信息查询
	 * @param
	 * @return 查询
	 */
	public IGFXK07DTO searchRiskmanagerwaring(IGFXK07DTO dto)throws BLException;
	
	/**
	 * 查询处理  通过主键rwid
	 * 风险提示信息查询
	 * @param
	 * @return 查询
	 */
	public IGFXK07DTO searchRiskmanagerwaringById(IGFXK07DTO dto)throws BLException;
	
	/**
	 * 流程查询JSP取得
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGFXK07DTO getProcessRecords(IGFXK07DTO dto) throws BLException;
}
