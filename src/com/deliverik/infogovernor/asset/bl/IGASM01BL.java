package com.deliverik.infogovernor.asset.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;

/**
 * 资产配置模型管理业务逻辑接口
 *
 *
 */
public interface IGASM01BL extends BaseBL {


	/**
	 * 资产信息查询处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchEntityAction(IGASM01DTO dto) throws BLException;
	
	/**
	 * 资产信息登记处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertEntityAction(IGASM01DTO dto) throws BLException;
	
	/**
	 * 资产信息编辑画面初期显示处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0102Action(IGASM01DTO dto) throws BLException;

	/**
	 * 资产信息更新处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO updateEntityAction(IGASM01DTO dto) throws BLException;

	/**
	 * 资产配置信息登记处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertConfigurationAction(IGASM01DTO dto) throws BLException;

	/**
	 * 资产配置信息编辑画面初期显示处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0104Action(IGASM01DTO dto) throws BLException;

	/**
	 * 资产配置信息更新处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO updateConfigurationAction(IGASM01DTO dto) throws BLException;

	/**
	 * 资产详细信息画面初期显示处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0106Action(IGASM01DTO dto) throws BLException;

	/**
	 * 资产信息删除处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO deleteEntityAction(IGASM01DTO dto) throws BLException;

	/**
	 * 资产配置信息删除处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO deleteConfigurationAction(IGASM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 资产模型状态变化
	 * </p>
	 * 
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeEntityStatus(IGASM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 资产模型属性状态变化
	 * </p>
	 * 
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeConfigStatus(IGASM01DTO dto) throws BLException;
	
	/**
	 * 资产下拉数据标识查询
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchConfigurationCodeDetailBean(IGASM01DTO dto) throws BLException;
	
	public IGASM01DTO searchConfigurationCodeDetail(IGASM01DTO dto) throws BLException;
	
	public IGASM01DTO searchCfgCodeDetailByCategory(IGASM01DTO dto) throws BLException;
	/**
	 * 资产下拉数据登记处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertConfigurationCodeDetailAction(IGASM01DTO dto) throws BLException;
	
	public IGASM01DTO getCfgCodeDetailByCategory(IGASM01DTO dto) throws BLException;
	
	public IGASM01DTO insertCfgCodeDetailAction(IGASM01DTO dto) throws BLException;
	
	/**
	 * 查询不包括机房、机柜及服务记录的一级模型（生成EXCEL模板使用）
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchEntityActionForExportExcelModel(IGASM01DTO dto) throws BLException;
	/**
	 * 导出Excel模板
	 * @throws Exception
	 */
	public IGASM01DTO searchInfoForExportExcel(String esyscode) throws BLException;
	
	/**
	 * 资产属性默认值编辑画面初期化处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws Exception
	 */
	public IGASM01DTO initIGASM0114Action(IGASM01DTO dto) throws BLException;
	
	/**
	 * 资产属性默认值编辑处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException 
	 */
	public IGASM01DTO editIGASM0114Action(IGASM01DTO dto) throws BLException, FileNotFoundException, IOException;
}
