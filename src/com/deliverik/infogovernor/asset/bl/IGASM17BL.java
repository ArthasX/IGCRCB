package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM17DTO;

/**
 * 组件配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM17BL extends BaseBL {


	/**
	 * 组件信息查询处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchEntityItemAction(IGASM17DTO dto) throws BLException;
	
	/**
	 * 组件信息登记处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO insertEntityItemAction(IGASM17DTO dto) throws BLException;
	
	/**
	 * 组件信息删除处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO deleteEntityItemAction(IGASM17DTO dto) throws BLException;

	/**
	 * 组件配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1704Action(IGASM17DTO dto) throws BLException;

	/**
	 * 组件配置信息编辑处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO editEntityItemAction(IGASM17DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 组件配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1705Action(IGASM17DTO dto) throws BLException;

	/**
	 * 组件关系管理画面初期化处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1706Action(IGASM17DTO dto) throws BLException;

	/**
	 * 组件关系删除处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO deleteEntityItemRelationAction(IGASM17DTO dto) throws BLException;

	/**
	 * 组件关系编辑画面初期化处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initIGASM1707Action(IGASM17DTO dto) throws BLException;

	/**
	 * 组件关系登记处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO insertEntityItemRelationAction(IGASM17DTO dto) throws BLException;

	/**
	 * 组件关系变更处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO updateEntityItemRelationAction(IGASM17DTO dto) throws BLException;
	
	/**
	 *	获取组件关联关系处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchRelationListAction(IGASM17DTO dto) throws BLException;
	
	/**
	 *组件信息编辑画面初期显示处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO initEntityItem(IGASM17DTO dto) throws BLException;
	/**
	 *组件信息修改处理
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO updateEntityItem(IGASM17DTO dto) throws BLException;
	
	/**
	 * 获取组件编号最大值
	 *
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 */
	public IGASM17DTO searchEntityItemLableAction(IGASM17DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是组件资产管理角色负责人
	 * 
	 * @param dto IGASM17DTO
	 * @return IGASM17DTO
	 * @throws BLException 
	 */
	public IGASM17DTO checkEntityItemDomain(IGASM17DTO dto) throws BLException;
}
