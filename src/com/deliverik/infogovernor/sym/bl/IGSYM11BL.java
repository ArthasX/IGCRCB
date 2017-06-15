package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;

/**
 * 基础数据管理业务逻辑接口
 *
 * 
 */
public interface IGSYM11BL extends BaseBL {


	/**
	 * 数据分类信息画面初期显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1101Action(IGSYM11DTO dto) throws BLException;

	/**
	 * 数据分类登记处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO insertCodeCategoryAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据分类编辑画面初期显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1102Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据分类变更处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO updateCodeCategoryAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据信息详细画面初期显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1106Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据信息详细画面返回显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1106BackAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据信息删除处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO deleteCodeDetailAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据信息编辑画面初期显示
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO initIGSYM1104Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据信息登记处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO insertCodeDetailAction(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据信息更新处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO updateCodeDetailAction(IGSYM11DTO dto) throws BLException;
	/**
	 * 搜索优先级所有数据
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO findByPriorityCond(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据分类新增处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO saveIGSYM1107Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 数据分类删除处理
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public IGSYM11DTO deleteIGSYM1101Action(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 取得流程影响度及紧急度信息
	 *
	 * @param IGSYM11DTO
	 * @param 
	 */
	public IGSYM11DTO getPrimpactAndPrurgency(IGSYM11DTO dto) throws BLException;
	
	/**
	 * 保存优先级所有数据
	 *
	 * @param dto IGSYM11DTO
	 * @return IGSYM11DTO
	 */
	public void savePriority(IGSYM11DTO dto) throws BLException;
}
