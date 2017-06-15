/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM03DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 预支费用管理_预支费用管理设定_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM03BL extends BaseBL {
	
	/**
	 * 
	 * Description: 预支费用信息查询
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM03DTO searchAdvanCescostAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 预支费用信息设定
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM03DTO insertAdvanCescostAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 预支费用信息变更
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM03DTO updateAdvanCescostAction(IGLOM03DTO dto) throws BLException ;
	
	/**
	 * 状态更新初期显示
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGLOM03DTO initAdvanCescostAction(IGLOM03DTO dto) throws BLException ;

	/**
	 * 删除处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGLOM03DTO deleteAdvanCescostAction(IGLOM03DTO dto) throws BLException ;
	
	/**
	 * 可用金额取得
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAvailableAmountAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 借款信息设定
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM03DTO insertLoanPayDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 借款更新初期显示
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO initLoanPayDetailAction(IGLOM03DTO dto) throws BLException ;

	/**
	 * 借款确认处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO changeLoanPayDetailAction(IGLOM03DTO dto) throws BLException ;

	/**
	 * 借款删除处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO deleteLoanPayDetailAction(IGLOM03DTO dto) throws BLException ;
	
	/**
	 * 
	 * 借款信息查询
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	
	public IGLOM03DTO searchLoanPayDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 借款信息查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailNoPagingAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 冲抵计财部借款汇总处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailSummaryAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 冲抵计财部借款处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO loanPayDetailCredit(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 预支人员统计查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchPersonLoanSummaryAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 预支人员统计导出处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportPersonLoanSummaryAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 人员借款明细统计查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchPersonLoanDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 人员借款明细统计导出处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportPersonLoanDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 预支明细统计查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAdvanceDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 预支明细统计导出处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportAdvanceDetailAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 预支月度统计处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAdvancesummaryAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 还款发票查询处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 */
	public IGLOM03DTO searchLoanPayInvoiceAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 还款发票确认还款处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 */
	public IGLOM03DTO changeLoanPayInvoiceAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 还款发票删除处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * @throws BLException
	 */
	public IGLOM03DTO deleteLoanPayInvoiceAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 还款发票新增处理
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGLOM03DTO insertPayInvioceAction(IGLOM03DTO dto) throws BLException;
	
	/**
	 * 预支汇总定时任务处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO advanceSummaryJob(IGLOM03DTO dto) throws BLException;

}
