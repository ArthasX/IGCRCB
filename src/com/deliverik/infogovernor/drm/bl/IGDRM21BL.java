package com.deliverik.infogovernor.drm.bl;

import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;

/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 
 * 修改记录: 
 */
public interface IGDRM21BL extends BaseBL{
	
	/**
	 * 预案编号生产
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO searchEntityItemLableAction(IGDRM21DTO dto) throws BLException ;

	/**
	 * 
	 * 预案信息新增
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO insertEntityItemAction(IGDRM21DTO dto) throws BLException;

	/**
	 * 创建初始化的预案新增画面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO initPlanInfo4Create(IGDRM21DTO dto)throws BLException;
	
	/**
	 * 查询预案树
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO getPlanSectionTree(IGDRM21DTO dto) throws BLException;

	/**
	 * 查询预案信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO searchPlan(IGDRM21DTO dto)throws BLException;

	/**
	 * 预案关联场景信息保存
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO savePlanInfo(IGDRM21DTO dto)throws BLException;

	/**
	 * 保存预案富文本信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO savePlanInfoContent(IGDRM21DTO dto)throws BLException;

	/**
	 * 初始化富文本信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO initUeditorInfo(IGDRM21DTO dto)throws BLException;

	/**
	 * 更新富文本信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO updatePlanInfoContent(IGDRM21DTO dto)throws BLException;

	/**
	 * 初始化场景信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO initStoryboardInfo(IGDRM21DTO dto)throws BLException;

	/**
	 * 查询业务系统信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO searchEntityDisp(IGDRM21DTO dto)throws BLException;

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO viewStoryboardInfo(IGDRM21DTO dto) throws BLException;

	/**
	 * 专项预案查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO searchSpecialPlanAction(IGDRM21DTO dto) throws BLException;

	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO initSoc0118EditInfo(IGDRM21DTO dto) throws BLException;

	/**
	 * 更新设备信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO updateEntityItemAction(IGDRM21DTO dto) throws BLException;

	/**
	 * 删除所选择的预案信息
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO deleteSelectedSoc0118(IGDRM21DTO dto) throws BLException;

	/**
	 * 加载所有预案信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO loadAllReservePlan(IGDRM21DTO dto)throws BLException;

	/**
	 * 加载预案富文本内容
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	IGDRM21DTO loadPlanTextContent(IGDRM21DTO dto) throws BLException;
	
	/**
	 * 专项预案导出操作
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 */
	public IGDRM21DTO exportSpecialPlanAction(IGDRM21DTO dto) throws BLException, IOException;
	

	/**
	 * 加载场景信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanScenceHtml(IGDRM21DTO dto) throws BLException;

	/**
	 * 加载预案中的组织架构信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanOrgHTML(IGDRM21DTO dto) throws BLException;

	/**
	 * 加载预案中的应急资源信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM21DTO loadPlanResourceHTML(IGDRM21DTO dto) throws BLException;

}
