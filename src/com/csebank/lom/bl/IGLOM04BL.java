/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl;

import com.csebank.lom.dto.IGLOM04DTO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发票信息_发票管理设定_BL
 * </p>
 * 
 * @version 
 */
public interface IGLOM04BL extends BaseBL {
	
	/**
	 * 
	 * Description: 发票信息查询
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGLOM04DTO searchInvoiceAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: 发票信息设定
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @update
	 */
	public IGLOM04DTO insertInvoiceAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 发票变更
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	public IGLOM04DTO updateInvoiceAction(IGLOM04DTO dto) throws BLException ;
	
	/**
	 * <p>
	 * Description: 通知删除
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public IGLOM04DTO deleteNoticeAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 发票变更初始化
	 * </p>
	 * 
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 * @throws BLException
	 * @author piaowei@deliverik.com
	 * @update
	 */
	
	public IGLOM04DTO initIGLOM0402Action(IGLOM04DTO dto) throws BLException;
	
	/**
	 * 查询invoice表中指定发票的详细信息
	 */
	public IGLOM04DTO searchStockDetailAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * 发票部门统计查询处理
	 *
	 * @param dto IGSDL06DTO
	 * @return IGSDL06DTO
	 */
	public IGLOM04DTO searchInvoiceVWAction(IGLOM04DTO dto) throws BLException;
	
	/**
	 * 发票年度统计信息查询处理
	 *
	 * @param dto IGLOM04DTO
	 * @return IGLOM04DTO
	 */
	public IGLOM04DTO searchInvoiceYearVWAction(IGLOM04DTO dto) throws BLException;
}
