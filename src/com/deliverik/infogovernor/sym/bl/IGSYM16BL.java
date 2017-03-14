package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM16DTO;

/**
 * 基础数据管理业务逻辑接口
 *
 * 
 */
public interface IGSYM16BL extends BaseBL {

	/**
	 * <p>
	 * 查询数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM16DTO searchCodeTreeAction(IGSYM16DTO dto) throws BLException;

	/**
	 * <p>
	 * 查询entity树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM16DTO searchEntityTreeAction(IGSYM16DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询1级结点不可选的数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchSpecialCodeTreeAction(IGSYM16DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询1级结点不可选，并且状态为可用的数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchSpecialCodeTreeByCdStatusAction(IGSYM16DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询Entitiy树（指定1级结点）
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchEntityTreeByLevelAction(IGSYM16DTO dto) throws BLException;
}
