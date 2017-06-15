/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM03BL extends BaseBL {
	
	/**
	 * <p>
	 * Description: 角色查询
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO searchRoleAction(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 角色删除
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO deleteRoleAction(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 角色新增
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO insertRoleAction(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 角色变更初始化
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO initIGSYM0302Action(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 角色变更
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO updateRoleAction(IGSYM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 取得角色管理域树(资产控制使用)
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO getRoleDomainTree(IGSYM03DTO sym03dto,String roletype,User user) throws BLException;
	public IGSYM03DTO getRoleDomainTree(IGSYM03DTO sym03dto) throws BLException;
	/**
	 * 根据传入的该用户的角色集合和角色类型取得所有该类型的角色的资产管理内容树的并集
	 * @param 角色类型(页面传入)
	 * @param 该用户的角色集合(session中取得)
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM03DTO getAssetDomainTree(IGSYM03DTO sym03dto,String roletype,User user) throws BLException;
	
	/**
	 * <p>
	 * Description: 角色查询（IGSYM0306弹出画面使用）
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 */
	
	public IGSYM03DTO searchRoleActionFor0306(IGSYM03DTO dto) throws BLException;
	
	/**
	 * 根据传入的角色ID，查询树
	 * @param 角色ID
	 * @return 
	 * @throws BLException
	 * @author
	 */
	public Map<String, TreeNode> getRoleDomainsTree(String roleId) throws BLException;
}
