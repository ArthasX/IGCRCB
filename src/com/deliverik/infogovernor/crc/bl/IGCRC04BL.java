/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更处理BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGCRC04BL extends BaseBL{

	/**
	 * 流程查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO searchProcessRecords(IGCRC04DTO dto) throws BLException;

	/**
	 * 变更批量处理页面初始化操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO initIGCRC0402Action(IGCRC04DTO dto) throws BLException;

	/**
	 * 变更批量处理操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO disposeAction(IGCRC04DTO dto) throws BLException;

	/**
	 * 初始化分派页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO initAssignPageAction(IGCRC04DTO dto) throws BLException;

	/**
	 * 变更批量
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO assignAction(IGCRC04DTO dto) throws BLException;
	/**
	 * 检查工作批量
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO assignWorkAction(IGCRC04DTO dto) throws BLException;
	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getPivarQueryInfoAction(IGCRC04DTO dto) throws BLException;
	
	/**
	 * 导出变更管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getExcelDataList(IGCRC04DTO dto) throws BLException ;

	/**
	 * 取得主流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getParentProcessInfoAction(IGCRC04DTO dto) throws BLException;

	/**
	 * 取得日志附件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getRecordLogAttachmentAction(IGCRC04DTO dto) throws BLException;
	
	public IGCRC04DTO assignSecureAction(IGCRC04DTO dto) throws BLException;
}
