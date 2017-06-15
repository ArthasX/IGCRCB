package com.deliverik.infogovernor.drm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;

/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 
 * 修改记录: 
 */
public interface IGDRM20BL extends BaseBL{

	IGDRM20DTO insertEntityAction(IGDRM20DTO dto) throws BLException;

	IGDRM20DTO updateEntityAction(IGDRM20DTO dto) throws BLException;

	/**
	 * 获取预案章节信息树
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO getPlanSectionTree(IGDRM20DTO dto) throws BLException;

	/**
	 * 新增预案章节处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO insertSoc0509Info(IGDRM20DTO dto)throws BLException;

	/**
	 * 查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO searchPlanAction(IGDRM20DTO dto) throws BLException;

	/**
	 * 启用章节
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO startAction(IGDRM20DTO dto) throws BLException;
	/**
	 * 停用章节
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO stopAction(IGDRM20DTO dto) throws BLException;

	/**
	 * 初始化Entity实体
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO initEntityAction(IGDRM20DTO dto) throws BLException;

	/**
	 * 删除某个Entity下的SOC0509
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO deletePlanOfEntity(IGDRM20DTO dto) throws BLException;
	/**
	 * 重命名某个Entity下的SOC0509
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO renamePlanOfEntity(IGDRM20DTO dto) throws BLException;

	/**
	 * 获取某个模型下的详细信息
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO getPlanTreeDetail(IGDRM20DTO dto) throws BLException;

	/**
	 * 初始化模板信息和模板下字节点的信息（如果有）
	 * @param dto
	 * @throws BLException
	 */
	IGDRM20DTO initModelAction(IGDRM20DTO dto) throws BLException;
	
	/**
	 * 初始化预案模板信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO initS0C0117EditInfo(IGDRM20DTO dto) throws BLException;

	/**
	 * 复制模板
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM20DTO copyAction(IGDRM20DTO dto) throws BLException;

	IGDRM20DTO sortSoc0509Action(IGDRM20DTO dto) throws BLException;

}
