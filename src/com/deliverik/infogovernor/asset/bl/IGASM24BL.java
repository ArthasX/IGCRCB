package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM24DTO;

/**
 * 发票配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM24BL extends BaseBL {


	/**
	 * 发票信息查询处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO searchEntityItemAction(IGASM24DTO dto) throws BLException;
	
	/**
	 * 发票信息登记处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO insertEntityItemAction(IGASM24DTO dto) throws BLException;
	
	/**
	 * 发票信息删除处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO deleteEntityItemAction(IGASM24DTO dto) throws BLException;

	/**
	 * 发票配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO initIGASM2404Action(IGASM24DTO dto) throws BLException;

	/**
	 * 发票配置信息编辑处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO editEntityItemAction(IGASM24DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 发票配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO initIGASM2405Action(IGASM24DTO dto) throws BLException;

	/**
	 * 发票关系管理画面初期化处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO initIGASM2406Action(IGASM24DTO dto) throws BLException;

	/**
	 * 发票关系删除处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO deleteEntityItemRelationAction(IGASM24DTO dto) throws BLException;

	/**
	 * 发票关系编辑画面初期化处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO initIGASM2407Action(IGASM24DTO dto) throws BLException;

	/**
	 * 发票关系登记处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO insertEntityItemRelationAction(IGASM24DTO dto) throws BLException;

	/**
	 * 发票关系变更处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO updateEntityItemRelationAction(IGASM24DTO dto) throws BLException;
	
	/**
	 *	获取发票关联关系处理
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO searchRelationListAction(IGASM24DTO dto) throws BLException;
	

	/**
	 *发票信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM24DTO initEntityItem(IGASM24DTO dto) throws BLException;
	/**
	 *发票信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM24DTO updateEntityItem(IGASM24DTO dto) throws BLException;
	
	/**
	 * 获取发票编号最大值
	 *
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 */
	public IGASM24DTO searchEntityItemLableAction(IGASM24DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是指定类型资产管理角色负责人
	 * 
	 * @param dto IGASM24DTO
	 * @return IGASM24DTO
	 * @throws BLException 
	 */
	public IGASM24DTO checkEntityItemDomain(IGASM24DTO dto) throws BLException;

    /**
     * 查询初始化新增页面信息
     * @param dto
     */
    public IGASM24DTO searchInitEntityInfo(IGASM24DTO dto)throws BLException;
}
