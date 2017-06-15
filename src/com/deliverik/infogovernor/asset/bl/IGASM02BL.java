package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM02DTO;

/**
 * 资产配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM02BL extends BaseBL {


	/**
	 * 资产项信息查询处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO searchEntityItemAction(IGASM02DTO dto) throws BLException;
	
	/**
	 * 资产项信息登记处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO insertEntityItemAction(IGASM02DTO dto) throws BLException;
	
	/**
	 * 资产项信息删除处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO deleteEntityItemAction(IGASM02DTO dto) throws BLException;

	/**
	 * 资产项配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0204Action(IGASM02DTO dto) throws BLException;

	/**
	 * 资产项配置信息编辑处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO editEntityItemAction(IGASM02DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 资产项配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0205Action(IGASM02DTO dto) throws BLException;

	/**
	 * 资产项关系管理画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0206Action(IGASM02DTO dto) throws BLException;

	/**
	 * 资产项关系删除处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO deleteEntityItemRelationAction(IGASM02DTO dto) throws BLException;

	/**
	 * 资产项关系编辑画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0207Action(IGASM02DTO dto) throws BLException;

	/**
	 * 资产项关系登记处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO insertEntityItemRelationAction(IGASM02DTO dto) throws BLException;

	/**
	 * 资产项关系变更处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO updateEntityItemRelationAction(IGASM02DTO dto) throws BLException;
	
	/**
	 *	获取配置项关联关系处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO searchRelationListAction(IGASM02DTO dto) throws BLException;
	/**
	 * 设备依赖关系画面初期化处理
	 *
	 * @param dto IGASM02DTO
	 * @return IGASM02DTO
	 */
	public IGASM02DTO initIGASM0206BelongAction(IGASM02DTO dto) throws BLException  ;
}
