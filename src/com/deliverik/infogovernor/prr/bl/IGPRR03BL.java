/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程辅助功能bl接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRR03BL extends BaseBL{

	/**
	 * 角色信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchRoleListAction(IGPRR03DTO dto) throws BLException;

	/**
	 * 查询角色配置信息
	 * @param dto
	 * @return
	 */
	public IGPRR03DTO searchIG001InfoListAction(IGPRR03DTO dto) throws BLException;

	/**
	 * 角色配置信息删除操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO deleteIG001Action(IGPRR03DTO dto) throws BLException;

	/**
	 * 角色配置信息新增操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO addIG001InfoAction(IGPRR03DTO dto) throws BLException;

	/**
	 * 查询用户信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchUserRoleAction(IGPRR03DTO dto) throws BLException;

	/**
	 * 过滤角色信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchRoleidNotInAction(IGPRR03DTO dto) throws BLException;

}
