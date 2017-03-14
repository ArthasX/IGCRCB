package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM12DTO;

/**
 * 基础数据管理业务逻辑接口
 *
 * 
 */
public interface IGSYM12BL extends BaseBL {

	/**
	 * <p>
	 * 查询数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM12DTO searchCodeTreeAction(IGSYM12DTO dto) throws BLException;

	/**
	 * <p>
	 * 查询entity树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM12DTO searchEntityTreeAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 通过SOC表查询entity树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM12DTO searchSocEntityTreeAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询1级结点不可选的数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询1级结点不可选，并且状态为可用的数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeByCdStatusAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询Entitiy树（指定1级结点）
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchEntityTreeByLevelAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询Entitiy树（指定1级结点）
	 * </p>
	 * @throws BLException
	 * @author wangxing@deliverik.com
	 */
	public IGSYM12DTO searchSOCEntityTreeByLevelAction(IGSYM12DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询Entitiy树（只查询1级结点）
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeByPcidAction(IGSYM12DTO dto) throws BLException;
	/**
	 * 应急资源联合数据库查询资产模型
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM12DTO searchSocVWEntityTreeAction(IGSYM12DTO dto) throws BLException;
}
