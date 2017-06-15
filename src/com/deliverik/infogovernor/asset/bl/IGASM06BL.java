package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM06DTO;

/**
 * 软件配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM06BL extends BaseBL {


	/**
	 * 软件信息查询处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO searchEntityItemAction(IGASM06DTO dto) throws BLException;
	
	/**
	 * 软件信息登记处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO insertEntityItemAction(IGASM06DTO dto) throws BLException;
	
	/**
	 * 软件信息删除处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO deleteEntityItemAction(IGASM06DTO dto) throws BLException;

	/**
	 * 软件配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initIGASM0604Action(IGASM06DTO dto) throws BLException;

	/**
	 * 软件配置信息编辑处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO editEntityItemAction(IGASM06DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 软件配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initIGASM0605Action(IGASM06DTO dto) throws BLException;

	/**
	 * 软件关系管理画面初期化处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initIGASM0606Action(IGASM06DTO dto) throws BLException;

	/**
	 * 软件关系删除处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO deleteEntityItemRelationAction(IGASM06DTO dto) throws BLException;

	/**
	 * 软件关系编辑画面初期化处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initIGASM0607Action(IGASM06DTO dto) throws BLException;

	/**
	 * 软件关系登记处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO insertEntityItemRelationAction(IGASM06DTO dto) throws BLException;

	/**
	 * 软件关系变更处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO updateEntityItemRelationAction(IGASM06DTO dto) throws BLException;
	
	/**
	 *	获取系统关联关系处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM06DTO searchRelationListAction(IGASM06DTO dto) throws BLException;

	/**
	 *软件信息编辑画面初期显示处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO initEntityItem(IGASM06DTO dto) throws BLException;
	/**
	 *软件信息修改处理
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO updateEntityItem(IGASM06DTO dto) throws BLException;
	
	/**
	 * 获取软件编号最大值
	 *
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 */
	public IGASM06DTO searchEntityItemLableAction(IGASM06DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是软件资产管理角色负责人
	 * 
	 * @param dto IGASM06DTO
	 * @return IGASM06DTO
	 * @throws BLException 
	 */
	public IGASM06DTO checkEntityItemDomain(IGASM06DTO dto) throws BLException;
}
