package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM16DTO;

/**
 * 数据配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM16BL extends BaseBL {


	/**
	 * 数据信息查询处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO searchEntityItemAction(IGASM16DTO dto) throws BLException;
	
	/**
	 * 数据信息登记处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO insertEntityItemAction(IGASM16DTO dto) throws BLException;
	
	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO deleteEntityItemAction(IGASM16DTO dto) throws BLException;

	/**
	 * 数据配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initIGASM1604Action(IGASM16DTO dto) throws BLException;

	/**
	 * 数据配置信息编辑处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO editEntityItemAction(IGASM16DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 数据配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initIGASM1605Action(IGASM16DTO dto) throws BLException;

	/**
	 * 数据关系管理画面初期化处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initIGASM1606Action(IGASM16DTO dto) throws BLException;

	/**
	 * 数据关系删除处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO deleteEntityItemRelationAction(IGASM16DTO dto) throws BLException;

	/**
	 * 数据关系编辑画面初期化处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initIGASM1607Action(IGASM16DTO dto) throws BLException;

	/**
	 * 数据关系登记处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO insertEntityItemRelationAction(IGASM16DTO dto) throws BLException;

	/**
	 * 数据关系变更处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO updateEntityItemRelationAction(IGASM16DTO dto) throws BLException;
	
	/**
	 *	获取数据关联关系处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO searchRelationListAction(IGASM16DTO dto) throws BLException;
	

	/**
	 *数据信息编辑画面初期显示处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO initEntityItem(IGASM16DTO dto) throws BLException;
	/**
	 *数据信息修改处理
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO updateEntityItem(IGASM16DTO dto) throws BLException;
	
	/**
	 * 获取数据编号最大值
	 *
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 */
	public IGASM16DTO searchEntityItemLableAction(IGASM16DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是数据资产管理角色负责人
	 * 
	 * @param dto IGASM16DTO
	 * @return IGASM16DTO
	 * @throws BLException 
	 */
	public IGASM16DTO checkEntityItemDomain(IGASM16DTO dto) throws BLException;
}
