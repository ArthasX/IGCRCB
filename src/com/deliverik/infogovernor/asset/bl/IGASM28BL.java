package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;

/**
 * 检查项配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM28BL extends BaseBL {


	/**
	 * 检查项信息查询处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchEntityItemAction(IGASM28DTO dto) throws BLException;
	
	/**
	 * 检查项信息登记处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO insertEntityItemAction(IGASM28DTO dto) throws BLException;
	
	/**
	 * 检查项信息删除处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO deleteEntityItemAction(IGASM28DTO dto) throws BLException;

	/**
	 * 检查项配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2804Action(IGASM28DTO dto) throws BLException;

	/**
	 * 检查项配置信息编辑处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO editEntityItemAction(IGASM28DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 检查项配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2805Action(IGASM28DTO dto) throws BLException;

	/**
	 * 检查项关系管理画面初期化处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2806Action(IGASM28DTO dto) throws BLException;

	/**
	 * 检查项关系删除处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO deleteEntityItemRelationAction(IGASM28DTO dto) throws BLException;

	/**
	 * 检查项关系编辑画面初期化处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO initIGASM2807Action(IGASM28DTO dto) throws BLException;

	/**
	 * 检查项关系登记处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO insertEntityItemRelationAction(IGASM28DTO dto) throws BLException;

	/**
	 * 检查项关系变更处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO updateEntityItemRelationAction(IGASM28DTO dto) throws BLException;
	
	/**
	 *	获取检查项关联关系处理
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchRelationListAction(IGASM28DTO dto) throws BLException;
	

	/**
	 *检查项信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM28DTO initEntityItem(IGASM28DTO dto) throws BLException;
	/**
	 *检查项信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM28DTO updateEntityItem(IGASM28DTO dto) throws BLException;
	
	/**
	 * 获取检查项编号最大值
	 *
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 */
	public IGASM28DTO searchEntityItemLableAction(IGASM28DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是指定类型资产管理角色负责人
	 * 
	 * @param dto IGASM28DTO
	 * @return IGASM28DTO
	 * @throws BLException 
	 */
	public IGASM28DTO checkEntityItemDomain(IGASM28DTO dto) throws BLException;
	
	
	/**
	 * 检查项查询
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGASM28DTO searchCheckItemListAction(IGASM28DTO dto) throws BLException;
	
	/**
	 * 检查项属性 取值范围
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO 
	 */
	public IGASM28DTO searchRiskPropertyActioin(IGASM28DTO dto) throws BLException;
	

	/**
	 * 添加资产属性
	 * @param eiid 资产ID
	 * @param lst_EntityItemConfigValueInfo 资产属性信息
	 * @throws BLException
	 */
	public IGASM28DTO createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo)
			throws BLException;
	
	
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException ;

}
