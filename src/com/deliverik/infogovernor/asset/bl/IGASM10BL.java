package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.dto.IGASM10DTO;

/**
 * 定制统计业务逻辑接口
 *
 * 
 */
public interface IGASM10BL extends BaseBL {


	/**
	 * 资产项信息查询处理
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO searchEntityItemAction(IGASM10DTO dto) throws BLException;
	
	/**
	 * 资产项配置信息详细画面初期化处理
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1004Action(IGASM10DTO dto) throws BLException;

	/**
	 * 资产项配置信息历史记录画面初期化处理
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1005Action(IGASM10DTO dto) throws BLException;

	/**
	 * 资产项关系管理画面初期化处理
	 *
	 * @param dto IGASM10DTO
	 * @return IGASM10DTO
	 */
	public IGASM10DTO initIGASM1006Action(IGASM10DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询资产模型属性
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGASM01DTO searchConfigurationsByEntity(IGASM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 查询资产模型属性对应的取值范围下拉
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public List<LabelValueBean> searchCcdvalueByCoption(String coption) throws BLException;
}
