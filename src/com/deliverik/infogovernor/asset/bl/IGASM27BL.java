package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.infogovernor.asset.dto.IGASM2701DTO;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;

/**
 * 风险点配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM27BL extends BaseBL {


	/**
	 * 风险点信息查询处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO searchEntityItemAction(IGASM27DTO dto) throws BLException;
	
	/**
	 * 风险点信息登记处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO insertEntityItemAction(IGASM27DTO dto) throws BLException;
	
	/**
	 * 风险点信息删除处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO deleteEntityItemAction(IGASM27DTO dto) throws BLException;

	/**
	 * 风险点配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO initIGASM2704Action(IGASM27DTO dto) throws BLException;

	/**
	 * 风险点配置信息编辑处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO editEntityItemAction(IGASM27DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 风险点配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO initIGASM2705Action(IGASM27DTO dto) throws BLException;

	/**
	 * 风险点关系管理画面初期化处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO initIGASM2706Action(IGASM27DTO dto) throws BLException;

	/**
	 * 风险点关系删除处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO deleteEntityItemRelationAction(IGASM27DTO dto) throws BLException;

	/**
	 * 风险点关系编辑画面初期化处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO initIGASM2707Action(IGASM27DTO dto) throws BLException;

	/**
	 * 风险点关系登记处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO insertEntityItemRelationAction(IGASM27DTO dto) throws BLException;

	/**
	 * 风险点关系变更处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO updateEntityItemRelationAction(IGASM27DTO dto) throws BLException;
	
	/**
	 *	获取风险点关联关系处理
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO searchRelationListAction(IGASM27DTO dto) throws BLException;
	

	/**
	 *风险点信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM27DTO initEntityItem(IGASM27DTO dto) throws BLException;
	/**
	 *风险点信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM27DTO updateEntityItem(IGASM27DTO dto) throws BLException;
	
	/**
	 * 获取风险点编号最大值
	 *
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 */
	public IGASM27DTO searchEntityItemLableAction(IGASM27DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是指定类型资产管理角色负责人
	 * 
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 * @throws BLException 
	 */
	public IGASM27DTO checkEntityItemDomain(IGASM27DTO dto) throws BLException;
	/**查询风险级别  风险严重*/
	public IGASM27DTO searchRiskPropertyActioin(IGASM27DTO dto)	throws BLException;
	/**
	 *插入风险点 主属性及子属性 
	 * @param dto IGASM27DTO
	 * @return IGASM27DTO
	 * @throws BLException
	 * */
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException ;
	
	/**风险点自定义视图查询*/
	public IGASM27DTO searchRiskPointManagerAction(IGASM27DTO dto)throws BLException;
}
