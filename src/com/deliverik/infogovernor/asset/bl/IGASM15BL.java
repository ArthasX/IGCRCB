package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM15DTO;

/**
 * 设备配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM15BL extends BaseBL {


	/**
	 * 人员信息查询处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO searchEntityItemAction(IGASM15DTO dto) throws BLException;
	
	/**
	 * 人员信息登记处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO insertEntityItemAction(IGASM15DTO dto) throws BLException;
	
	/**
	 * 人员信息删除处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO deleteEntityItemAction(IGASM15DTO dto) throws BLException;

	/**
	 * 人员配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initIGASM1504Action(IGASM15DTO dto) throws BLException;

	/**
	 * 人员配置信息编辑处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO editEntityItemAction(IGASM15DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 人员配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initIGASM1505Action(IGASM15DTO dto) throws BLException;

	/**
	 * 人员关系管理画面初期化处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initIGASM1506Action(IGASM15DTO dto) throws BLException;

	/**
	 * 人员关系删除处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO deleteEntityItemRelationAction(IGASM15DTO dto) throws BLException;

	/**
	 * 人员关系编辑画面初期化处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initIGASM1507Action(IGASM15DTO dto) throws BLException;

	/**
	 * 人员关系登记处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO insertEntityItemRelationAction(IGASM15DTO dto) throws BLException;

	/**
	 * 人员关系变更处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO updateEntityItemRelationAction(IGASM15DTO dto) throws BLException;
	
	/**
	 *	获取人员关联关系处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO searchRelationListAction(IGASM15DTO dto) throws BLException;

	/**
	 *人员信息编辑画面初期显示处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO initEntityItem(IGASM15DTO dto) throws BLException;
	/**
	 *人员信息修改处理
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO updateEntityItem(IGASM15DTO dto) throws BLException;
	
	/**
	 * 获取人员编号最大值
	 *
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 */
	public IGASM15DTO searchEntityItemLableAction(IGASM15DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是人员资产管理角色负责人
	 * 
	 * @param dto IGASM15DTO
	 * @return IGASM15DTO
	 * @throws BLException 
	 */
	public IGASM15DTO checkEntityItemDomain(IGASM15DTO dto) throws BLException;
}
