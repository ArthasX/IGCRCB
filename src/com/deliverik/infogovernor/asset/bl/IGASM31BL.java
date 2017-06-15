package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;

/**
 * 检查项配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM31BL extends BaseBL {


	/**
	 * 检查项信息查询处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchEntityItemAction(IGASM31DTO dto) throws BLException;
	
	/**
	 * 检查项信息登记处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO insertEntityItemAction(IGASM31DTO dto) throws BLException;
	
	/**
	 * 检查项信息删除处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO deleteEntityItemAction(IGASM31DTO dto) throws BLException;

	/**
	 * 检查项配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3104Action(IGASM31DTO dto) throws BLException;

	/**
	 * 检查项配置信息编辑处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO editEntityItemAction(IGASM31DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 检查项配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3105Action(IGASM31DTO dto) throws BLException;

	/**
	 * 检查项关系管理画面初期化处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3106Action(IGASM31DTO dto) throws BLException;

	/**
	 * 检查项关系删除处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO deleteEntityItemRelationAction(IGASM31DTO dto) throws BLException;

	/**
	 * 检查项关系编辑画面初期化处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO initIGASM3107Action(IGASM31DTO dto) throws BLException;

	/**
	 * 检查项关系登记处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO insertEntityItemRelationAction(IGASM31DTO dto) throws BLException;

	/**
	 * 检查项关系变更处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO updateEntityItemRelationAction(IGASM31DTO dto) throws BLException;
	
	/**
	 *	获取检查项关联关系处理
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchRelationListAction(IGASM31DTO dto) throws BLException;
	

	/**
	 *检查项信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM31DTO initEntityItem(IGASM31DTO dto) throws BLException;
	/**
	 *检查项信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM31DTO updateEntityItem(IGASM31DTO dto) throws BLException;
	
	/**
	 * 获取检查项编号最大值
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchEntityItemLableAction(IGASM31DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是指定类型资产管理角色负责人
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO checkEntityItemDomain(IGASM31DTO dto) throws BLException;
	
	/**
	 * 获取风险点指标所需下拉值
	 *
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 */
	public IGASM31DTO searchRiskPropertyActioin(IGASM31DTO dto)	throws BLException;
	
	
	/**
	 * 往Maintenanc中插入一条数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM31DTO insertMaintenance(IGASM31DTO dto)throws BLException;
	/**
	 * 风险指标展示信息查询
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO searchRiskIndexShow(IGASM31DTO dto) throws BLException;
	
	/**
	 * 风险指标展示内容查询
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO searchRiskIndexContext(IGASM31DTO dto) throws BLException;
	/**
	 * 风险指标展示内容具体单条查询
	 * 
	 * @param dto IGASM31DTO
	 * @return IGASM31DTO
	 * @throws BLException 
	 */
	public IGASM31DTO searchRiskIndexByRiid(IGASM31DTO dto) throws BLException;

	/**	
	 * 功能：查风险指标基本信息
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGASM31DTO initIGASM3116Action(IGASM31DTO dto) throws BLException;
}
