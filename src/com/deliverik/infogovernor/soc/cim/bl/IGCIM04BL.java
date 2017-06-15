package com.deliverik.infogovernor.soc.cim.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;

/**
 * 资产配置模型管理业务逻辑接口
 *
 *
 */
public interface IGCIM04BL extends BaseBL {


	/**
	 * 资产信息查询处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO searchEntityAction(IGCIM04DTO dto) throws BLException;
	
	/**
	 * 资产信息登记处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO insertEntityAction(IGCIM04DTO dto) throws BLException;
	
	/**
	 * 资产信息编辑画面初期显示处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO initIGCIM0402Action(IGCIM04DTO dto) throws BLException;

	/**
	 * 资产信息更新处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO updateEntityAction(IGCIM04DTO dto) throws BLException;

	/**
	 * 资产配置信息登记处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO insertConfigurationAction(IGCIM04DTO dto) throws BLException;

	/**
	 * 资产配置信息编辑画面初期显示处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO initIGASM0104Action(IGCIM04DTO dto) throws BLException;

	/**
	 * 资产配置信息更新处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO updateConfigurationAction(IGCIM04DTO dto) throws BLException;

	/**
	 * 资产详细信息画面初期显示处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO initIGCIM0406Action(IGCIM04DTO dto) throws BLException;

	/**
	 * 资产信息删除处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO deleteEntityAction(IGCIM04DTO dto) throws BLException;

	/**
	 * 资产配置信息删除处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO deleteConfigurationAction(IGCIM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 资产模型状态变化
	 * </p>
	 * 
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 * @throws BLException
	 * @author wangxing
	 * @update
	 */
	public void changeEntityStatus(IGCIM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 资产模型属性状态变化
	 * </p>
	 * 
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 * @throws BLException
	 * @author wangxing
	 * @update
	 */
	public void changeConfigStatus(IGCIM04DTO dto) throws BLException;
	
	/**
	 * 资产下拉数据标识查询
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO searchConfigurationCodeDetailBean(IGCIM04DTO dto) throws BLException;
	
	public IGCIM04DTO searchConfigurationCodeDetail(IGCIM04DTO dto) throws BLException;
	
	public IGCIM04DTO searchCfgCodeDetailByCategory(IGCIM04DTO dto) throws BLException;
	/**
	 * 资产下拉数据登记处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO insertConfigurationCodeDetailAction(IGCIM04DTO dto) throws BLException;
	
	public IGCIM04DTO getCfgCodeDetailByCategory(IGCIM04DTO dto) throws BLException;
	
	public IGCIM04DTO insertCfgCodeDetailAction(IGCIM04DTO dto) throws BLException;
	
	/**
	 * 查询不包括机房、机柜及服务记录的一级模型（生成EXCEL模板使用）
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 */
	public IGCIM04DTO searchEntityActionForExportExcelModel(IGCIM04DTO dto) throws BLException;
	/**
	 * 导出Excel模板
	 * @throws Exception
	 */
	public IGCIM04DTO searchInfoForExportExcel(String esyscode) throws BLException;
	
	/**
	 * 资产属性默认值编辑画面初期化处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 * @throws Exception
	 */
	public IGCIM04DTO initIGASM0114Action(IGCIM04DTO dto) throws BLException;
	
	/**
	 * 资产属性默认值编辑处理
	 *
	 * @param dto IGCIM04DTO
	 * @return IGCIM04DTO
	 * @throws BLException 
	 */
	public IGCIM04DTO editIGASM0114Action(IGCIM04DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * 资产类别编号查询处理
	 * @param dto
	 * @return IGCIM04DTO
	 * @throws BLException
	 */
	public IGCIM04DTO searchEntityTypesNums(IGCIM04DTO dto) throws BLException;
	
	/**
	 * 查询entity树
	 * @throws BLException
	 * @author wangxing
	 */
	public IGCIM04DTO searchEntityTreeAction(IGCIM04DTO dto) throws BLException;
}
