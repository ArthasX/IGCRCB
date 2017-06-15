package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;

/**
 * 机房配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM07BL extends BaseBL {


	/**
	 * 机房信息查询处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO searchEntityItemAction(IGASM07DTO dto) throws BLException;
	
	/**
	 * 机房信息登记处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO insertEntityItemAction(IGASM07DTO dto) throws BLException;
	
	/**
	 * 机房信息删除处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO deleteEntityItemAction(IGASM07DTO dto) throws BLException;

	/**
	 * 机房配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0704Action(IGASM07DTO dto) throws BLException;

	/**
	 * 机房配置信息编辑处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO editEntityItemAction(IGASM07DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 机房配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0705Action(IGASM07DTO dto) throws BLException;

	/**
	 * 机房关系管理画面初期化处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0706Action(IGASM07DTO dto) throws BLException;

	/**
	 * 机房关系删除处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO deleteEntityItemRelationAction(IGASM07DTO dto) throws BLException;

	/**
	 * 机房关系编辑画面初期化处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO initIGASM0707Action(IGASM07DTO dto) throws BLException;

	/**
	 * 机房关系登记处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO insertEntityItemRelationAction(IGASM07DTO dto) throws BLException;

	/**
	 * 机房关系变更处理
	 *
	 * @param dto IGASM07DTO
	 * @return IGASM07DTO
	 */
	public IGASM07DTO updateEntityItemRelationAction(IGASM07DTO dto) throws BLException;
}
