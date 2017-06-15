package com.deliverik.infogovernor.risk.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;


/**
 * 风险检查业务逻辑接口
 *
 *
 */
public interface IGRIS02BL extends BaseBL {

	/**
	 * <p>
	 * Description: 初始化今天应该进行的风险检查
	 * </p>
	 */
	public void initRiskCheckResult(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查新增
	 * </p>
	 */
	public IGRIS02DTO insertRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查变更初始化
	 * </p>
	 */
	public IGRIS02DTO initupdateRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查变更
	 * </p>
	 */
	public IGRIS02DTO updateRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查查询
	 * </p>
	 */
	
	public IGRIS02DTO searchRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * 关联审计项初始化处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS02DTO searchRiskAuditDefAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 关联审计项保存
	 * </p>
	 */
	
	public IGRIS02DTO insertRiskAuditDefAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查调整状态
	 * </p>
	 */
	
	public IGRIS02DTO changeRiskCheckStatusAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查查看页
	 * </p>
	 */
	
	public IGRIS02DTO readRiskCheckAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查结果查询
	 * </p>
	 */
	
	public IGRIS02DTO searchRiskCheckResultAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查结果保存
	 * </p>
	 */
	
	public IGRIS02DTO insertRiskCheckResultAction(IGRIS02DTO dto) throws BLException;
	
	
	public IGRIS02DTO insertCheckStrategAction(IGRIS02DTO dto) throws BLException;
	
	
	
	
	/**
	 * <p>
	 * Description: 风险检查结果日报查询
	 * </p>
	 */
	
	public IGRIS02DTO searchRiskCheckResultReportByDayAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查结果阶段查询
	 * </p>
	 */
	
	public IGRIS02DTO searchRiskCheckResultReportByPeriodAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 最近一次风险检查结果查询
	 * </p>
	 */
	
	public IGRIS02DTO searchLastRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 检查工作监督查询
	 * </p>
	 */
	public IGRIS02DTO searchSuperviseRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 最近一次风险检查结果查询(统计分析页显示使用)
	 * </p>
	 */
	
	public List<RiskCheckResult> searchLastRiskCheckResultToVo() throws BLException;
	
	/**
	 * <p>
	 * Description: 风险检查结果查看页
	 * </p>
	 */
	
	public IGRIS02DTO readRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 解释quartz执行周期表达式
	 * </p>
	 */
	public String getCronInfo(String periodType,String startDate);
	
	/**
	 * <p>
	 * Description: 风险检查登记初始化
	 * </p>
	 */
	public IGRIS02DTO dispRiskCheckAction(IGRIS02DTO dto) throws BLException;
	public IGRIS02DTO sel(IGRIS02DTO dto);
	
	public IGRIS02DTO searchCheckWorkResulReportAction(IGRIS02DTO dto) throws BLException;
	
	public IGRIS02DTO changeCheckStrategyStatusAction(IGRIS02DTO dto) throws BLException;
	

	public IGRIS02DTO changeCheckStrategyStatusOnlyAction(IGRIS02DTO dto) throws BLException;
	
	public IGRIS02DTO selPoint(IGRIS02DTO dto) throws BLException;
	
	public IGRIS02DTO copyCheckStrategyStatusAction(IGRIS02DTO dto) throws BLException;
	
	
	/**	
	 * 功能：根据检查策略id查询检查策略
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGRIS02DTO searchCheckStrategyByCsid(IGRIS02DTO dto) throws BLException;

	/**
	 * 功能：批量发起检查工作指派流程
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO batchFlowAction(IGRIS02DTO dto) throws BLException;

	/**
	 * 功能：初始化分派页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO initIGRIS0402Action(IGRIS02DTO dto) throws BLException;

	public IGRIS02DTO assignAction(IGRIS02DTO dto) throws BLException;
}
