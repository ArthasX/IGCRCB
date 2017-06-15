package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;


/**
 * 场景定义管理业务逻辑接口
 *
 *
 */
public interface IGDRM01BL extends BaseBL {
	/**
	 * 查询节点状态信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String getStautsInfo(IGDRM01DTO dto) throws BLException;
	/**
	 * 查询节点状态信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String getStautsFormLog(IGDRM01DTO dto) throws BLException;
	/**
	 * 初始化页面数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO initIgdrm0102Action(IGDRM01DTO dto)throws BLException;
	/**
	 * 查询场景资产方法
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchPlan(IGDRM01DTO dto)throws BLException;
	/**
	 * 查询节点状态信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getOrgInfo(IGDRM01DTO dto) throws BLException;
	/**
	 * 查询状态级附件信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public String getAttKey(IGDRM01DTO dto) throws BLException;
	/**
	 * 查询该流程下状态级表单XML
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getStateForm(IGDRM01DTO dto) throws BLException;


	/**
	 * 查询应急制度模型树
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchEntityTreeForIgdrm0105Action(IGDRM01DTO dto) throws BLException;

	/**
	 * 查询应急制度分类列表
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchEntityList(IGDRM01DTO dto) throws BLException;

	/**
	 * 查询场景信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getScene(IGDRM01DTO dto) throws BLException;
	
	/**
	 * 查询场景中的流程详细信息
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO searchFlowDetail(IGDRM01DTO dto) throws BLException;
	
/**
	 * 根据场景查询触发策略
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO searchSenceStrategy(IGDRM01DTO dto) throws BLException;
	/**
	 * 查询业务系统
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO switchMaster(IGDRM01DTO dto) throws BLException;
	/**
	 * 查询单条触发策略
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getSenceStrategy(IGDRM01DTO dto) throws BLException;

	/**
	 * 查询单条触发策略
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO saveSenceStrategy(IGDRM01DTO dto) throws BLException; 
	
	/**
	 * 删除单条触发策略
	 * @param rsid
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO delSenceStrategy(IGDRM01DTO dto) throws BLException;
	
	/**
	 * 查询导出场景中的流程详细信息
	 * 
	 * @param dto
	 * @return
	 */
	public IGDRM01DTO searchExportFlowDetail(IGDRM01DTO dto,Integer prid) throws BLException;
	
	/**
	 * 导出场景信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO exportSenceDetail(IGDRM01DTO dto,Integer prid) throws BLException; 
	
	/**
	 * 查询场景信息存储到form中
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM01DTO getSceneByEiid(IGDRM01DTO dto) throws BLException;
}
