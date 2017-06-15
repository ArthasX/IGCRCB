package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;

/**
 * 设备配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM14BL extends BaseBL {


	/**
	 * 服务记录信息查询处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO searchEntityItemAction(IGASM14DTO dto) throws BLException;
	
	/**
	 * 服务记录信息登记处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO insertEntityItemAction(IGASM14DTO dto) throws BLException;
	
	/**
	 * 服务记录信息删除处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO deleteEntityItemAction(IGASM14DTO dto) throws BLException;

	/**
	 * 服务记录配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1404Action(IGASM14DTO dto) throws BLException;

	/**
	 * 服务记录配置信息编辑处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO editEntityItemAction(IGASM14DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 服务记录配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1405Action(IGASM14DTO dto) throws BLException;

	/**
	 * 服务记录关系管理画面初期化处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1406Action(IGASM14DTO dto) throws BLException;

	/**
	 * 服务记录关系删除处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO deleteEntityItemRelationAction(IGASM14DTO dto) throws BLException;

	/**
	 * 服务记录关系编辑画面初期化处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initIGASM1407Action(IGASM14DTO dto) throws BLException;

	/**
	 * 服务记录关系登记处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO insertEntityItemRelationAction(IGASM14DTO dto) throws BLException;

	/**
	 * 服务记录关系变更处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO updateEntityItemRelationAction(IGASM14DTO dto) throws BLException;

	/**
	 *服务记录信息编辑画面初期显示处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO initEntityItem(IGASM14DTO dto) throws BLException;
	/**
	 *服务记录信息修改处理
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO updateEntityItem(IGASM14DTO dto) throws BLException;
	
	/**
	 * 获取服务记录编号最大值
	 *
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 */
	public IGASM14DTO searchEntityItemLableAction(IGASM14DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是服务记录资产管理角色负责人
	 * 
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 * @throws BLException 
	 */
	public IGASM14DTO checkEntityItemDomain(IGASM14DTO dto) throws BLException;
	
	/**
	 * 通过设备查询服务记录
	 * 
	 * @param dto IGASM14DTO
	 * @return IGASM14DTO
	 * @throws BLException 
	 */
	public IGASM14DTO searchServiceAction(IGASM14DTO dto) throws BLException;
}
