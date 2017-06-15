package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM50DTO;
import com.deliverik.infogovernor.asset.dto.IGASM42DTO;

/**
 * 文档配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM50BL extends BaseBL {


	/**
	 * 文档信息查询处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO searchEntityItemAction(IGASM50DTO dto) throws BLException;
	
	/**
	 * 文档信息登记处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO insertEntityItemAction(IGASM50DTO dto) throws BLException;
	
	/**
	 * 文档信息删除处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO deleteEntityItemAction(IGASM50DTO dto) throws BLException;

	/**
	 * 文档配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO initIGASM5004Action(IGASM50DTO dto) throws BLException;

	/**
	 * 文档配置信息编辑处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO editEntityItemAction(IGASM50DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 文档配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO initIGASM5005Action(IGASM50DTO dto) throws BLException;

	/**
	 * 文档关系管理画面初期化处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO initIGASM5006Action(IGASM50DTO dto) throws BLException;

	/**
	 * 文档关系删除处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO deleteEntityItemRelationAction(IGASM50DTO dto) throws BLException;

	/**
	 * 文档关系编辑画面初期化处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO initIGASM5007Action(IGASM50DTO dto) throws BLException;

	/**
	 * 文档关系登记处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO insertEntityItemRelationAction(IGASM50DTO dto) throws BLException;

	/**
	 * 文档关系变更处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO updateEntityItemRelationAction(IGASM50DTO dto) throws BLException;
	
	/**
	 *	获取文档关联关系处理
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO searchRelationListAction(IGASM50DTO dto) throws BLException;
	

	/**
	 *文档信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM50DTO initEntityItem(IGASM50DTO dto) throws BLException;
	/**
	 *文档信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM50DTO updateEntityItem(IGASM50DTO dto) throws BLException;
	
	/**
	 * 获取文档编号最大值
	 *
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 */
	public IGASM50DTO searchEntityItemLableAction(IGASM50DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是指定类型资产管理角色负责人
	 * 
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 * @throws BLException 
	 */
//	public IGASM50DTO checkEntityItemDomain(IGASM50DTO dto) throws BLException;
	
	/**
	 * 查询文档资产信息细项
	 * @param dto IGASM50DTO
	 * @return IGASM50DTO
	 * @throws BLException
	 */
	public IGASM50DTO getAssetDetailInfomation(IGASM50DTO dto) throws BLException;
	
	
	/**
	 * 在下载记录表中新增一条数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
//	public IGASM42DTO downFileInsertData(IGASM42DTO dto) throws BLException;
	
}
