package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;

/**
 * 设备配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM03BL extends BaseBL {


	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备信息登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备信息删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO deleteEntityItemAction(IGASM03DTO dto) throws BLException;

	/**
	 * 设备配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0304Action(IGASM03DTO dto) throws BLException;

	/**
	 * 设备配置信息编辑处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO editEntityItemAction(IGASM03DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 设备配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0305Action(IGASM03DTO dto) throws BLException;

	/**
	 * 设备关系管理画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0306Action(IGASM03DTO dto) throws BLException;

	/**
	 * 设备关系删除处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO deleteEntityItemRelationAction(IGASM03DTO dto) throws BLException;

	/**
	 * 设备关系编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0307Action(IGASM03DTO dto) throws BLException;

	/**
	 * 设备关系登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertEntityItemRelationAction(IGASM03DTO dto) throws BLException;

	/**
	 * 设备关系变更处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO updateEntityItemRelationAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备下发信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchNewAndReciveEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备上缴信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchUsingEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备报废信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchCanScrapEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备下发处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityIssueAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备批量下发处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchIssueAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备上缴处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityPayAction(IGASM03DTO dto) throws BLException;
	/**
	 * 设备上缴处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public void entityBatchPayAction(IGASM03DTO dto) throws BLException;
	/**
	 * 查询指定eiid的待上缴设备
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityPayByEiidAction(IGASM03DTO dto) throws BLException;
	
	public IGASM03DTO searchPreScrapEntityItemAction(IGASM03DTO dto) throws BLException;
	
	public IGASM03DTO searchScrapEntityItemAction(IGASM03DTO dto) throws BLException;
	
	public IGASM03DTO searchReceiveEntityItemAction(IGASM03DTO dto) throws BLException;
	public void entityCancelPreScrapBatchAction(IGASM03DTO dto) throws BLException;
	public void entityPreScrapAction(IGASM03DTO dto) throws BLException;
	public void entityScrapBatchAction(IGASM03DTO dto) throws BLException;
	public void entityScrapAction(IGASM03DTO dto) throws BLException;
	public void entityPreScrapBatchAction(IGASM03DTO dto) throws BLException;
	
	public void entityCancelPreScrapAction(IGASM03DTO dto) throws BLException;
	/**
	 *设备信息编辑画面初期显示处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initEntityItem(IGASM03DTO dto) throws BLException;
	/**
	 *设备信息修改处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO updateEntityItem(IGASM03DTO dto) throws BLException;
	
	/**
	 *	获取设备关联关系处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchRelationListAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备批量入库登记编辑画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0317Action(IGASM03DTO dto) throws BLException;
	/**
	 * 设备批量入库登记处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO insertBatchEntityItemAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 获取设备编号最大值
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO searchEntityItemLableAction(IGASM03DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是设备资产管理角色负责人
	 * 
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @throws BLException 
	 */
	public IGASM03DTO checkEntityItemDomain(IGASM03DTO dto) throws BLException;
	/**
	 * 获取历史版本更新时间
	 * @param version
	 * @return list
	 * @throws BLException
	 */
	public List<IG887Info> getVersionUpdateTime(String eiid)throws BLException;
	
	/**
	 * 初始化资产配置信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO initXMLInfo(IGASM03DTO dto) throws BLException;
	
	/**
	 * 查看配置信息指定结点的信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO readXMLNodeInfo(IGASM03DTO dto) throws BLException;
	
	/**
	 * 比较2个版本配置信息XML中的数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM03DTO compareXMLInfoByVersion(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备配置信息版本比较画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0305ActionForXML(IGASM03DTO dto) throws BLException;
	
	/**
	 * 设备关系树画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGASM03DTO initIGASM0346Action(IGASM03DTO dto) throws BLException ;

	/**
	 * 设备关系管理POP画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 * @update 0000201
	 */
	public IGASM03DTO initIGASM1110Action(IGASM03DTO dto) throws BLException;
}
