/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM01BL extends BaseBL {
	
	/**
	 * <p>
	 * Description: 机构查询
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO searchOrganizationAction(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 机构删除
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO deleteOrganizationAction(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 机构新增
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO insertOrganizationAction(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 机构变更初始化
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO initIGSYM0102Action(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 机构变更
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO updateOrganizationAction(IGSYM01DTO dto) throws BLException;
	
	/**
	 * 根据传入的机构ID，查询树
	 * @param 机构ID
	 * @return 
	 * @throws BLException
	 * @author
	 */
	public Map<String, TreeNode> getOrgsyscodingTree(String orgid) throws BLException;
	
	/**
	 * 查询所有机构
	 * @return List<Organization>
	 */
	
	public IGSYM01DTO searchOrganizationAll(IGSYM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询存在的上级机构（一级机构）
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 */
	
	public IGSYM01DTO searchOrgTreeAction(IGSYM01DTO dto,String type) throws BLException;
	
	public void changePTStatus(IGSYM01DTO dto) throws BLException ;
	
	/**
	 * <p>
	 * 查询存在的上级机构（一级机构）
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM01DTO searchItemTreeAction(IGSYM01DTO dto,String type) throws BLException;
	
	/**
	 * <p>
	 * Description: 机构查询(IGASM1303Action调用)
	 * </p>
	 */
	
	public IGSYM01DTO searchOrganizationForIGASM1303Action(IGSYM01DTO dto) throws BLException; 
	
	/**
	 * <p>
	 * 取得该结点的机构全名
	 * </p>
	 * @param  syscoding
	 * @throws BLException
	 */

	public String getCompleteOrgName(String syscoding);
	
	/**
	 * <p>
	 * Description: 机构查询(IGASM01BL调用)
	 * </p>
	 */
	
	public IGSYM01DTO searchOrganizationForIGASM0101() throws BLException;
	
	public IGSYM01DTO searchITEMS0174Tree(IGSYM01DTO dto) throws BLException;
}
