package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;

/**
 * 首页业务逻辑接口
 *
 * 
 */
public interface IGVIR10BL extends BaseBL {
	
	/**
	 *  获取流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getProcessList(IGVIR10DTO dto) throws BLException;
	
	
	/**
	 * 获取资源信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResouceInfo(IGVIR10DTO dto)throws BLException;
	
	
	/**
	 * 获取金额信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getFigureInfo(IGVIR10DTO dto)throws BLException;
	
	
	/**
	 * 初始化用户Action信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initVir10UserAction(IGVIR10DTO dto)throws BLException;
	

	/**
	 * 初始化管理员Action信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initVir10ManageAction(IGVIR10DTO dto)throws BLException;
	
	
	/**
	 * 获取各部门资源使用情况
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResourceInfoByOrg(IGVIR10DTO dto)throws BLException;
	
	
	/**
	 * 获取资源概况
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getResourceSurvey(IGVIR10DTO dto)throws BLException;
	
	/**
	 * 获取待处理的流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getPendingProcessList(IGVIR10DTO dto)throws BLException;

	/**
	 * 初始化管理员首页
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initManageHomePageAction(IGVIR10DTO dto) throws BLException;
	
	/**
	 * 获取模板信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO getTemplateList(IGVIR10DTO dto)throws BLException;


	/**
	 * 初始化用户首页
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initUserHomePageAction(IGVIR10DTO dto) throws BLException;

	/**
	 * 改变虚机状态操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO changeVMAction(IGVIR10DTO dto) throws BLException;

	/**
	 * 初始化资源管理首页
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR10DTO initResourceManageHomePageAction(IGVIR10DTO dto) throws BLException;
}
