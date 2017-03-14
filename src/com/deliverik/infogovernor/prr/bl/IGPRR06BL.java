package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.dto.IGPRR06DTO;

public interface IGPRR06BL {
	
	public IGPRR01DTO search(IGPRR01DTO dto)throws BLException ;

	public IGPRR01DTO searchAll(IGPRR01DTO dto)throws BLException;
	
	public IGPRR01DTO searchByEIID(IGPRR01DTO dto) throws BLException;
		/**
	 * 流程查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessRecordAction(IGPRR06DTO dto) throws BLException;

	/**
	 * 查询流程ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessDefinitionIdAction(IGPRR06DTO dto) throws BLException;

	/**
	 * 获取查询定义信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessQueryTitleAction(IGPRR06DTO dto) throws BLException;

	/**
	 * 流程导出操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO exportProcessRecordAction(IGPRR06DTO dto) throws BLException;
	
	/**
	 * 流程查询JSP取得
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGPRR06DTO searchForwardJsp(IGPRR06DTO dto) throws BLException;
}
