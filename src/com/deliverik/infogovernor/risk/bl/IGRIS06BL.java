package com.deliverik.infogovernor.risk.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;

/**
 * 检查项配置管理业务逻辑接口
 *
 * 
 */
public interface IGRIS06BL extends BaseBL {


	/**
	 * 检查项信息查询处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO searchEntityItemAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 * 检查项信息登记处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO insertEntityItemAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 * 检查项信息删除处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO deleteEntityItemAction(IGRIS06DTO dto) throws BLException;

	/**
	 * 检查项配置信息编辑画面初期化处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO initIGRIS0604Action(IGRIS06DTO dto) throws BLException;

	/**
	 * 检查项配置信息编辑处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO editEntityItemAction(IGRIS06DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 检查项配置信息历史记录画面初期化处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO initIGRIS0605Action(IGRIS06DTO dto) throws BLException;

	/**
	 * 检查项关系管理画面初期化处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO initIGRIS0606Action(IGRIS06DTO dto) throws BLException;

	/**
	 * 检查项关系删除处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO deleteEntityItemRelationAction(IGRIS06DTO dto) throws BLException;

	/**
	 * 检查项关系编辑画面初期化处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO initIGRIS0607Action(IGRIS06DTO dto) throws BLException;

	/**
	 * 检查项关系登记处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO insertEntityItemRelationAction(IGRIS06DTO dto) throws BLException;

	/**
	 * 检查项关系变更处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO updateEntityItemRelationAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 *	获取检查项关联关系处理
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO searchRelationListAction(IGRIS06DTO dto) throws BLException;
	

	/**
	 *检查项信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGRIS06DTO initEntityItem(IGRIS06DTO dto) throws BLException;
	/**
	 *检查项信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGRIS06DTO updateEntityItem(IGRIS06DTO dto) throws BLException;
	
	/**
	 * 获取检查项编号最大值
	 *
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 */
	public IGRIS06DTO searchEntityItemLableAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是指定类型资产管理角色负责人
	 * 
	 * @param dto IGRIS06DTO
	 * @return IGRIS06DTO
	 * @throws BLException 
	 */
	public IGRIS06DTO checkEntityItemDomain(IGRIS06DTO dto) throws BLException;
	
	
	/**
	 * 检查项查询
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO
	 */
	public IGRIS06DTO searchCheckItemListAction(IGRIS06DTO dto) throws BLException;
	
	/**
	 * 检查项属性 取值范围
	 * @param dto IGASM18DTO
	 * @return IGASM18DTO 
	 */
	public IGRIS06DTO searchRiskPropertyActioin(IGRIS06DTO dto) throws BLException;
	

	/**
	 * 添加资产属性
	 * @param eiid 资产ID
	 * @param lst_EntityItemConfigValueInfo 资产属性信息
	 * @throws BLException
	 */
	public IGRIS06DTO createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo)
			throws BLException;
	
	
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException;

	/**	
	 * 功能：遍历出所有检查项详细信息
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGRIS06DTO serachCheckItemInfoListAction(IGRIS06DTO dto) throws BLException;
		
	public IGRIS06DTO searchCheckItemListNotPageAction(IGRIS06DTO dto) throws BLException;
	
	public IGRIS06DTO searchCheckItemWindowAction(IGRIS06DTO dto) throws BLException;
	
	/**	
	 * 功能：更新检查项状态
	 * @param dto
	 * @return 条数
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public Integer updateCheckItemStatus(IGRIS06DTO dto) throws BLException;
}
