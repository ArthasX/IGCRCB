/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM04BL extends BaseBL {
	
	/**
	 * <p>
	 * Description: 用户查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 角色查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户角色查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserRoleAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户角色查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchUserRoleForManagerAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 删除用户角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO revokeUserRoleAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 添加用户角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO grantUserRoleAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 角色菜单查询
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleActionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 删除角色菜单
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO revokeRoleActionAction(IGSYM04DTO dto) throws BLException; 
	
	/**
	 * <p>
	 * Description: 添加角色菜单
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO grantRoleActionAction(IGSYM04DTO dto) throws BLException; 
	
	/**
	 * <p>
	 * Description: 菜单授权
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO roleActionAction(IGSYM04DTO dto) throws BLException; 
	
	/**
	 * <p>
	 * Description: 机构查询
	 * </p>
	 * 
	 * @return List<Organization>
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchOrganizationAll(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据角色查询用户
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUser(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据角色查询用户不分页
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUserALL(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 获取角色负责人
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	public IGSYM04DTO searchRoleManagerAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 设置角色负责人
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	public IGSYM04DTO saveRoleManagerAction(IGSYM04DTO dto) throws BLException;
	

	/**
	 * 设置值班人
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author wangxiaoqiang@deliverik.com
	 */
	public IGSYM04DTO saveDutyflagAction(IGSYM04DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 根据角色类型查询用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSYM04DTO searchUserByRoleType(IGSYM04DTO dto) throws BLException;

/**
	 * 报表信息查询处理
	 *
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 */
	public IGSYM04DTO searchReportFileDefinitionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 报表信息变更初始化
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO initReportFileDefinitionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 报表授权信息查询处理
	 *
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 */
	public IGSYM04DTO searchRoleReportAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 添加报表角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public IGSYM04DTO grantRoleReportAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 删除报表角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public void revokeRoleReportAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 报表版本信息查询处理
	 *
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 */
	public IGSYM04DTO searchReportFileVersionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 报表授权信息初始化
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO roleReportFileDefinitionAction(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 授权用户RRID查询
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO searchRoleReportRfdidByRoleid(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 所有报表查询
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO searchReportFileDefinition(IGSYM04DTO dto) throws BLException;
	
	/**
	 * 通过角色ID查询角色名
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 */
	
	public IGSYM04DTO searchRolenameByRoleId(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 按角色ID删除报表
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public void revokeRoleReportActionByRoleid(IGSYM04DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 按角色ID添加报表
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author 
	 * @update
	 */
	
	public IGSYM04DTO grantRoleReportActionByRoleid(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据角色查询用户
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author   
	 * @update
	 */
	
	public IGSYM04DTO searchRoleUserByOrg(IGSYM04DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 查询所有流程信息
	 * </p>
	 * 
	 * @return IGSYM04DTO
	 * @author   
	 * @update
	 */
	public IGSYM04DTO getProcessInfoAll(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据角色类型查询用户不需要分页
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGSYM04DTO searchUserByRoleTypeNoPage(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据角色类型查询不属于该角色的用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGSYM04DTO searchUserNoByRoleType(IGSYM04DTO dto) throws BLException;
	

	/**
	 * <p>
	 * Description: 删除角色用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGSYM04DTO deleteRoleUser(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 添加角色用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGSYM04DTO saveRoleUser(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通过角色id查询角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author renxiaodi
	 * @update
	 */
	public IGSYM04DTO searchRoleByRoleId(IGSYM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据角色类型查询不属于该角色的同步用户
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author   
	 */
	public IGSYM04DTO searchUserNoByRoleTypeSyn(IGSYM04DTO dto) throws BLException;
	
	/** 资源组授权 Start 2012/11/19 */
	/**
	 * 查询同步的角色列表
	 * @return
	 * @throws BLException
	 */
	public IGSYM04DTO searchSYNRoleAction(IGSYM04DTO dto) throws BLException;
	/** 资源组授权 End */
}
