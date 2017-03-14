package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM10DTO;

/**
 * 基础数据管理业务逻辑接口
 *
 * 
 */
public interface IGSYM10BL extends BaseBL {


	/**
	 * 数据分类信息画面初期显示
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1001Action(IGSYM10DTO dto) throws BLException;
	
	/**
	 * 数据分类删除处理
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO deleteCodeCategoryAction(IGSYM10DTO dto) throws BLException;
	
	/**
	 * 数据信息详细画面初期显示
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1006Action(IGSYM10DTO dto) throws BLException;
	
	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO deleteCodeDetailAction(IGSYM10DTO dto) throws BLException;
	
	/**
	 * 数据信息编辑画面初期显示
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO initIGSYM1004Action(IGSYM10DTO dto) throws BLException;
	
	/**
	 * 数据信息登记处理
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO insertCodeDetailAction(IGSYM10DTO dto) throws BLException;
	
	/**
	 * 数据信息更新处理
	 *
	 * @param dto IGSYM10DTO
	 * @return IGSYM10DTO
	 */
	public IGSYM10DTO updateCodeDetailAction(IGSYM10DTO dto) throws BLException;
	
}
