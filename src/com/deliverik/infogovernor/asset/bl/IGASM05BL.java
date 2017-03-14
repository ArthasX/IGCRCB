package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM05DTO;
import com.deliverik.infogovernor.asset.dto.IGASM42DTO;

/**
 * 文档配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM05BL extends BaseBL {


	/**
	 * 文档信息查询处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO searchEntityItemAction(IGASM05DTO dto) throws BLException;
	
	/**
	 * 文档信息登记处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO insertEntityItemAction(IGASM05DTO dto) throws BLException;
	
	/**
	 * 文档信息删除处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO deleteEntityItemAction(IGASM05DTO dto) throws BLException;

	/**
	 * 文档配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO initIGASM0504Action(IGASM05DTO dto) throws BLException;

	/**
	 * 文档配置信息编辑处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO editEntityItemAction(IGASM05DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 文档配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO initIGASM0505Action(IGASM05DTO dto) throws BLException;

	/**
	 * 文档关系管理画面初期化处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO initIGASM0506Action(IGASM05DTO dto) throws BLException;

	/**
	 * 文档关系删除处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO deleteEntityItemRelationAction(IGASM05DTO dto) throws BLException;

	/**
	 * 文档关系编辑画面初期化处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO initIGASM0507Action(IGASM05DTO dto) throws BLException;

	/**
	 * 文档关系登记处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO insertEntityItemRelationAction(IGASM05DTO dto) throws BLException;

	/**
	 * 文档关系变更处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO updateEntityItemRelationAction(IGASM05DTO dto) throws BLException;
	
	/**
	 *	获取文档关联关系处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO searchRelationListAction(IGASM05DTO dto) throws BLException;
	

	/**
	 *文档信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM05DTO initEntityItem(IGASM05DTO dto) throws BLException;
	/**
	 *文档信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM05DTO updateEntityItem(IGASM05DTO dto) throws BLException;
	
	/**
	 * 获取文档编号最大值
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGASM05DTO searchEntityItemLableAction(IGASM05DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是指定类型资产管理角色负责人
	 * 
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 * @throws BLException 
	 */
	public IGASM05DTO checkEntityItemDomain(IGASM05DTO dto) throws BLException;
	
	/**
	 * 查询文档资产信息细项
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 * @throws BLException
	 */
	public IGASM05DTO getAssetDetailInfomation(IGASM05DTO dto) throws BLException;
	
	
	/**
	 * 在下载记录表中新增一条数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM42DTO downFileInsertData(IGASM42DTO dto) throws BLException;
	
}
