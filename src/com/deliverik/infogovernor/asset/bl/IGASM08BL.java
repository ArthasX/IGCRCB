package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM08DTO;

/**
 * 应用配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM08BL extends BaseBL {


	/**
	 * 应用信息查询处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchEntityItemAction(IGASM08DTO dto) throws BLException;
	
	/**
	 * 应用信息登记处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO insertEntityItemAction(IGASM08DTO dto) throws BLException;
	
	/**
	 * 应用信息删除处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO deleteEntityItemAction(IGASM08DTO dto) throws BLException;

	/**
	 * 应用配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0804Action(IGASM08DTO dto) throws BLException;

	/**
	 * 应用配置信息编辑处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO editEntityItemAction(IGASM08DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 应用配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0805Action(IGASM08DTO dto) throws BLException;

	/**
	 * 应用关系管理画面初期化处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0806Action(IGASM08DTO dto) throws BLException;

	/**
	 * 应用关系删除处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO deleteEntityItemRelationAction(IGASM08DTO dto) throws BLException;

	/**
	 * 应用关系编辑画面初期化处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO initIGASM0807Action(IGASM08DTO dto) throws BLException;

	/**
	 * 应用关系登记处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO insertEntityItemRelationAction(IGASM08DTO dto) throws BLException;

	/**
	 * 应用关系变更处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO updateEntityItemRelationAction(IGASM08DTO dto) throws BLException;
	
	/**
	 *	获取应用关联关系处理
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchRelationListAction(IGASM08DTO dto) throws BLException;
	

	/**
	 *应用信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM08DTO initEntityItem(IGASM08DTO dto) throws BLException;
	/**
	 *应用信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM08DTO updateEntityItem(IGASM08DTO dto) throws BLException;
	
	/**
	 * 获取应用编号最大值
	 *
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 */
	public IGASM08DTO searchEntityItemLableAction(IGASM08DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是应用资产管理角色负责人
	 * 
	 * @param dto IGASM08DTO
	 * @return IGASM08DTO
	 * @throws BLException 
	 */
	public IGASM08DTO checkEntityItemDomain(IGASM08DTO dto) throws BLException;
}
