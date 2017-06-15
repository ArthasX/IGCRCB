package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM15DTO;

/**
 * 基础数据管理业务逻辑接口
 *
 * 
 */
public interface IGSYM15BL extends BaseBL {


	/**
	 * 数据分类信息画面初期显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1501Action(IGSYM15DTO dto) throws BLException;
	
//	/**
//	 * 数据分类删除处理
//	 *
//	 * @param dto IGSYM15DTO
//	 * @return IGSYM15DTO
//	 */
//	public IGSYM15DTO deleteCodeCategoryAction(IGSYM15DTO dto) throws BLException;
//	
	/**
	 * 数据分类登记处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO insertCodeCategoryDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据分类编辑画面初期显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
//	public IGSYM15DTO initIGSYM1102Action(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据分类变更处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO updateCodeCategoryDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据信息详细画面初期显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1502Action(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据信息详细画面返回显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1502BackAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO deleteCodeDetailDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO realdeleteCodeDetailDefAction(IGSYM15DTO dto) throws BLException;
	
	
	/**
	 * 数据信息编辑画面初期显示
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO initIGSYM1503Action(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据信息登记处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO insertCodeDetailDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据信息更新处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO updateCodeDetailDefAction(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据分类新增处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO saveIGSYM11501Action(IGSYM15DTO dto) throws BLException;
	
	/**
	 * 数据分类删除处理
	 *
	 * @param dto IGSYM15DTO
	 * @return IGSYM15DTO
	 */
	public IGSYM15DTO deleteIGSYM1501Action(IGSYM15DTO dto) throws BLException;
	/**
	 * 数据分类信息画面初期显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM15DTO initIGSYM1506Action(IGSYM15DTO dto) throws BLException;
	
}
