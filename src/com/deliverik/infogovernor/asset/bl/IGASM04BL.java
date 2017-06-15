package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;

/**
 * 合同配置管理业务逻辑接口
 *
 * 
 */
public interface IGASM04BL extends BaseBL {


	/**
	 * 合同信息查询处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemAction(IGASM04DTO dto) throws BLException;
	
	/**
	 * 合同信息登记处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO insertEntityItemAction(IGASM04DTO dto) throws BLException;
	
	/**
	 * 合同信息删除处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO deleteEntityItemAction(IGASM04DTO dto) throws BLException;

	/**
	 * 合同配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0404Action(IGASM04DTO dto) throws BLException;

	/**
	 * 合同配置信息编辑处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO editEntityItemAction(IGASM04DTO dto) throws BLException,
	FileNotFoundException, IOException;

	/**
	 * 合同配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0405Action(IGASM04DTO dto) throws BLException;

	/**
	 * 合同关系管理画面初期化处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0406Action(IGASM04DTO dto) throws BLException;

	/**
	 * 合同关系删除处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO deleteEntityItemRelationAction(IGASM04DTO dto) throws BLException;

	/**
	 * 合同关系编辑画面初期化处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initIGASM0407Action(IGASM04DTO dto) throws BLException;

	/**
	 * 合同关系登记处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO insertEntityItemRelationAction(IGASM04DTO dto) throws BLException;

	/**
	 * 合同关系变更处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO updateEntityItemRelationAction(IGASM04DTO dto) throws BLException;
	
	/**
	 *	获取合同关联关系处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchRelationListAction(IGASM04DTO dto) throws BLException;
	
	/**
	 *合同信息编辑画面初期显示处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO initEntityItem(IGASM04DTO dto) throws BLException;
	/**
	 *合同信息修改处理
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO updateEntityItem(IGASM04DTO dto) throws BLException;
	
	/**
	 * 获取合同编号最大值
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemLableAction(IGASM04DTO dto) throws BLException;
	
	/**
	 * 判断登陆用户是否是合同资产管理角色负责人
	 * 
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 * @throws BLException 
	 */
	public IGASM04DTO checkEntityItemDomain(IGASM04DTO dto) throws BLException;
	
	/**
	 * 应付款登记查询处理(对应应付款登记查询)
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemCompactVWAction(IGASM04DTO dto) throws BLException;
	
	/**
	 * 应付款登记查询处理2(对应应付款查询)
	 *
	 * @param dto IGASM04DTO
	 * @return IGASM04DTO
	 */
	public IGASM04DTO searchEntityItemCompactVW2Action(IGASM04DTO dto) throws BLException;

	
	/**
	 * 合同付款导出处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO intiIGASM0422Action(IGASM04DTO dto) throws BLException;

	/**
	 * 合同付款登记初期显示
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO initIGASM0421Action(IGASM04DTO dto) throws BLException;

	/**
	 * 合同付款登记处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO editIGASM0421Action(IGASM04DTO dto) throws BLException; 
	
	/**
     * 合同统计查询处理
     * add by zhangze
     * @param dto IGASM04DTO
     * @return IGASM04DTO
     */
    public IGASM04DTO searchStatics(IGASM04DTO dto) throws BLException;
	
	/**
	 * 合同付款导出处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM04DTO intiIGASM0420Action(IGASM04DTO dto) throws BLException;
}
