package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;

/**
 * 机柜配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM12BL extends BaseBL {


	/**
	 * 机柜信息查询处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO searchEntityItemAction(IGASM12DTO dto) throws BLException;
	
	/**
	 * 机柜信息登记处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO insertEntityItemAction(IGASM12DTO dto) throws BLException;
	
	/**
	 * 机柜信息删除处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO deleteEntityItemAction(IGASM12DTO dto) throws BLException;

	/**
	 * 机柜配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO initIGASM1204Action(IGASM12DTO dto) throws BLException;

	/**
	 * 机柜配置信息编辑处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO editEntityItemAction(IGASM12DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 机柜配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO initIGASM1205Action(IGASM12DTO dto) throws BLException;

	/**
	 * 机柜关系管理画面初期化处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO initIGASM1206Action(IGASM12DTO dto) throws BLException;

	/**
	 * 机柜关系删除处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO deleteEntityItemRelationAction(IGASM12DTO dto) throws BLException;

	/**
	 * 机柜关系编辑画面初期化处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO initIGASM1207Action(IGASM12DTO dto) throws BLException;

	/**
	 * 机柜关系登记处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO insertEntityItemRelationAction(IGASM12DTO dto) throws BLException;

	/**
	 * 机柜关系变更处理
	 *
	 * @param dto IGASM12DTO
	 * @return IGASM12DTO
	 */
	public IGASM12DTO updateEntityItemRelationAction(IGASM12DTO dto) throws BLException;
}
