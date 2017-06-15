package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM09DTO;

/**
 * 服务商配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM09BL extends BaseBL {


	/**
	 * 服务商信息查询处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO searchEntityItemAction(IGASM09DTO dto) throws BLException;
	
	/**
	 * 服务商信息登记处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO insertEntityItemAction(IGASM09DTO dto) throws BLException;
	
	/**
	 * 服务商信息删除处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO deleteEntityItemAction(IGASM09DTO dto) throws BLException;

	/**
	 * 服务商配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initIGASM0904Action(IGASM09DTO dto) throws BLException;

	/**
	 * 服务商配置信息编辑处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO editEntityItemAction(IGASM09DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 服务商配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initIGASM0905Action(IGASM09DTO dto) throws BLException;

	/**
	 * 服务商关系管理画面初期化处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initIGASM0906Action(IGASM09DTO dto) throws BLException;

	/**
	 * 服务商关系删除处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO deleteEntityItemRelationAction(IGASM09DTO dto) throws BLException;

	/**
	 * 服务商关系编辑画面初期化处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initIGASM0907Action(IGASM09DTO dto) throws BLException;

	/**
	 * 服务商关系登记处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO insertEntityItemRelationAction(IGASM09DTO dto) throws BLException;

	/**
	 * 服务商关系变更处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO updateEntityItemRelationAction(IGASM09DTO dto) throws BLException;
	
	/**
	 *	获取服务商关联关系处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO searchRelationListAction(IGASM09DTO dto) throws BLException;
	
	/**
	 *服务商信息编辑画面初期显示处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO initEntityItem(IGASM09DTO dto) throws BLException;
	/**
	 *服务商信息修改处理
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO updateEntityItem(IGASM09DTO dto) throws BLException;
	
	/**
	 * 获取服务商编号最大值
	 *
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 */
	public IGASM09DTO searchEntityItemLableAction(IGASM09DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是服务商资产管理角色负责人
	 * 
	 * @param dto IGASM09DTO
	 * @return IGASM09DTO
	 * @throws BLException 
	 */
	public IGASM09DTO checkEntityItemDomain(IGASM09DTO dto) throws BLException;
	/**
	 * 服务商信息导出处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM09DTO intiIGASM0901Action(IGASM09DTO dto) throws BLException;
}
