package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM18DTO;

/**
 * 系统配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM18BL extends BaseBL {


	/**
	 * 系统信息查询处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO searchEntityItemAction(IGASM18DTO dto) throws BLException;
	
	/**
	 * 系统信息登记处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO insertEntityItemAction(IGASM18DTO dto) throws BLException;
	
	/**
	 * 系统信息删除处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO deleteEntityItemAction(IGASM18DTO dto) throws BLException;

	/**
	 * 系统配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO initIGASM1804Action(IGASM18DTO dto) throws BLException;

	/**
	 * 系统配置信息编辑处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO editEntityItemAction(IGASM18DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 系统配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO initIGASM1805Action(IGASM18DTO dto) throws BLException;

	/**
	 * 系统关系管理画面初期化处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO initIGASM1806Action(IGASM18DTO dto) throws BLException;

	/**
	 * 系统关系删除处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO deleteEntityItemRelationAction(IGASM18DTO dto) throws BLException;

	/**
	 * 系统关系编辑画面初期化处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO initIGASM1807Action(IGASM18DTO dto) throws BLException;

	/**
	 * 系统关系登记处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO insertEntityItemRelationAction(IGASM18DTO dto) throws BLException;

	/**
	 * 系统关系变更处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO updateEntityItemRelationAction(IGASM18DTO dto) throws BLException;
	
	/**
	 *	获取系统关联关系处理
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO searchRelationListAction(IGASM18DTO dto) throws BLException;
	

	/**
	 *系统信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM18DTO initEntityItem(IGASM18DTO dto) throws BLException;
	/**
	 *系统信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM18DTO updateEntityItem(IGASM18DTO dto) throws BLException;
	
	/**
	 * 获取系统编号最大值
	 *
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM18DTO searchEntityItemLableAction(IGASM18DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是系统资产管理角色负责人
	 * 
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 * @throws BLException 
	 */
	public IGASM18DTO checkEntityItemDomain(IGASM18DTO dto) throws BLException;
}
