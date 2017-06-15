package com.deliverik.infogovernor.soc.cim.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM14DTO;

/**
 * 设备配置管理业务逻辑接口
 *
 * 
 */
public interface IGCIM14BL extends BaseBL {


	/**
	 * 人员信息查询处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO searchEntityItemAction(IGCIM14DTO dto) throws BLException;
	
	/**
	 * 人员信息登记处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO insertEntityItemAction(IGCIM14DTO dto) throws BLException;
	
	/**
	 * 人员信息删除处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO deleteEntityItemAction(IGCIM14DTO dto) throws BLException;

	/**
	 * 人员配置信息编辑画面初期化处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO initIGCIM1404Action(IGCIM14DTO dto) throws BLException;

	/**
	 * 人员配置信息编辑处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO editEntityItemAction(IGCIM14DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 人员关系管理画面初期化处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO initIGCIM1406Action(IGCIM14DTO dto) throws BLException;

	/**
	 * 人员关系删除处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO deleteEntityItemRelationAction(IGCIM14DTO dto) throws BLException;

	/**
	 * 人员关系编辑画面初期化处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO initIGCIM1407Action(IGCIM14DTO dto) throws BLException;

	/**
	 * 人员关系登记处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO insertEntityItemRelationAction(IGCIM14DTO dto) throws BLException;

	/**
	 * 人员关系变更处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO updateEntityItemRelationAction(IGCIM14DTO dto) throws BLException;
	
	/**
	 *	获取人员关联关系处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO searchRelationListAction(IGCIM14DTO dto) throws BLException;

	/**
	 *人员信息编辑画面初期显示处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO initEntityItem(IGCIM14DTO dto) throws BLException;
	/**
	 *人员信息修改处理
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO updateEntityItem(IGCIM14DTO dto) throws BLException;
	
	/**
	 * 获取人员编号最大值
	 *
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 */
	public IGCIM14DTO searchEntityItemLableAction(IGCIM14DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是人员资产管理角色负责人
	 * 
	 * @param dto IGCIM14DTO
	 * @return IGCIM14DTO
	 * @throws BLException 
	 */
	public IGCIM14DTO checkEntityItemDomain(IGCIM14DTO dto) throws BLException;
}
