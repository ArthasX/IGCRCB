/**   
* @Title: IGVen01BL.java 
* @Package com.deliverik.infogovernor.ven.bl 
* @Description: TODO
* @author wangyaowen@Deliverik.com 
* @date 2014-12-1 上午10:55:23 
* @version V1.0   
*/
package com.deliverik.infogovernor.ven.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.ven.dto.IGVEN01DTO;

//史BL
public interface IGVEN01BL {
	/**
	 * <p>
	 * Description: 风险检查登记初始化
	 * </p>
	 */
	public IGVEN01DTO dispRiskCheckAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 检查策略保存
	 * </p>
	 */
	public IGVEN01DTO insertCheckStrategAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查查询
	 * </p>
	 */
	public IGVEN01DTO searchRiskCheckAction(IGVEN01DTO dto) throws BLException;
	/**	
	 * 功能：根据检查策略id查询检查策略
	 * @param dto
	 * @return IGVEN01DTO
	 * @throws BLException
	 * 修改记录：null 	
	 */
	public IGVEN01DTO searchCheckStrategyByCsid(IGVEN01DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 风险检查变更
	 * </p>
	 */
	public IGVEN01DTO updateRiskCheckAction(IGVEN01DTO dto) throws BLException ;
	/**
	 * 风险策略调整状态处理
	 * @param dto
	 * @return IGVEN01DTO
	 * @throws BLException
	 */
	public IGVEN01DTO changeCheckStrategyStatusOnlyAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * 风险策略复制逻辑
	 * @param dto
	 * @return IGVEN01DTO
	 * @throws BLException
	 */
	public IGVEN01DTO copyCheckStrategyStatusAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * 功能：批量发起监测工作指派流程
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO batchFlowAction(IGVEN01DTO dto) throws BLException;
	
	/**
	 * 批量处理页面初始化操作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO initIGRIS0402Action(IGVEN01DTO dto) throws BLException;
	
	/**
	 * 变更批量
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO assignAction(IGVEN01DTO dto) throws BLException;
}
