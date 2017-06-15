package com.deliverik.infogovernor.fxk.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fxk.dto.IGFXK03DTO;
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险评估BL接口
 * </p>
 * 
 * @author fenghuan@deliverik.com
 * @version 1.0
 */
public interface IGFXK03BL extends BaseBL {
	/**
	 * 风险计划查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK03DTO searchRiskproAction(IGFXK03DTO dto) throws BLException;
	public IGFXK03DTO searchLableValueAction(IGFXK03DTO dto) throws BLException ;
	/**
	 * 计划任务修改之前查询
	 */
	public IGFXK03DTO searchFXK0302FormAction(IGFXK03DTO dto) throws BLException;
	/**
	 * 计划任务修改
	 */
	public IGFXK03DTO editFXK0302FormAction(IGFXK03DTO dto) throws BLException; 
	/**
	 * 
	* @Title: searchUserLabelValueBean 
	* @Description: TODO 查询负责人下拉列表
	* @param dto
	* @return
	* @throws BLException    
	* IGFXK03DTO    
	* @throws
	 */
	public IGFXK03DTO searchUserLabelValueBean(IGFXK03DTO dto) throws BLException;
}
