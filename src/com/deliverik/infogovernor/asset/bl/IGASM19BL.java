package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM19DTO;

/**
 * 设备配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM19BL extends BaseBL {


	/**
	 * 人员信息查询处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM19DTO searchEntityItemAction(IGASM19DTO dto) throws BLException;
	
	/**
	 * 人员信息登记处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO insertEntityItemAction(IGASM19DTO dto) throws BLException;
	
	/**
	 * 人员信息删除处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO deleteEntityItemAction(IGASM19DTO dto) throws BLException;

	/**
	 * 人员配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initIGASM1904Action(IGASM19DTO dto) throws BLException;

	/**
	 * 人员配置信息编辑处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO editEntityItemAction(IGASM19DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 人员配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initIGASM1905Action(IGASM19DTO dto) throws BLException;

	/**
	 * 人员关系管理画面初期化处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initIGASM1906Action(IGASM19DTO dto) throws BLException;

	/**
	 * 人员关系删除处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO deleteEntityItemRelationAction(IGASM19DTO dto) throws BLException;

	/**
	 * 人员关系编辑画面初期化处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initIGASM1907Action(IGASM19DTO dto) throws BLException;

	/**
	 * 人员关系登记处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO insertEntityItemRelationAction(IGASM19DTO dto) throws BLException;

	/**
	 * 人员关系变更处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO updateEntityItemRelationAction(IGASM19DTO dto) throws BLException;
	
	/**
	 *	获取人员关联关系处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO searchRelationListAction(IGASM19DTO dto) throws BLException;

	/**
	 *人员信息编辑画面初期显示处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO initEntityItem(IGASM19DTO dto) throws BLException;
	/**
	 *人员信息修改处理
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO updateEntityItem(IGASM19DTO dto) throws BLException;
	
	/**
	 * 获取人员编号最大值
	 *
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 */
	public IGASM19DTO searchEntityItemLableAction(IGASM19DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是人员资产管理角色负责人
	 * 
	 * @param dto IGASM19DTO
	 * @return IGASM19DTO
	 * @throws BLException 
	 */
	public IGASM19DTO checkEntityItemDomain(IGASM19DTO dto) throws BLException;
}
