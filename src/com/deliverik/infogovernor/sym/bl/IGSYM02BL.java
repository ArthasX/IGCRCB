/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGSYM02BL extends BaseBL {
	
	/**
	 * <p>
	 * Description: 用户查询
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchUserAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户删除/激活
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGSYM02DTO changeUserFlagAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户新增
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO insertUserAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户变更初始化
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO initIGSYM0202Action(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户变更
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO updateUserAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户变更
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO updateUserManagerAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 机构查询
	 * </p>
	 * 
	 * @return IGSYM02DTO
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchOrganizationAll(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户数量查询
	 * </p>
	 * 
	 * @return IGSYM02DTO
	 * @author songhaiyang@deliverik.com
	 * @update
	 */
	public int searchUserCount(IGSYM02DTO dto) throws BLException;
	
	/** <p>
	 * Description: 用户查询
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchUserActionForIGASM0101() throws BLException;
	
	/**
	 * <p>
	 * Description: 用户首页列表取得
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGSYM02DTO searchComboBoxAction(IGSYM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 用户查询
	 * 无分页
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM02DTO searchUserActionNoPage(IGSYM02DTO dto) throws BLException ;
}
