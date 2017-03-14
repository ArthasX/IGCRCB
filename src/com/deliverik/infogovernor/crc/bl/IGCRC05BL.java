/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC05DTO;

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
public interface IGCRC05BL extends BaseBL{

	/**
	 * 流程查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO searchProcessRecords(IGCRC03DTO dto) throws BLException;

	/**
	 * 变更批量处理页面初始化操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO initIGCRC0402Action(IGCRC03DTO dto) throws BLException;

	/**
	 * 变更批量处理操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO disposeAction(IGCRC03DTO dto) throws BLException;

	/**
	 * 初始化分派页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO initAssignPageAction(IGCRC03DTO dto) throws BLException;

	/**
	 * 变更批量
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO assignAction(IGCRC03DTO dto) throws BLException;

	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO getPivarQueryInfoAction(IGCRC03DTO dto) throws BLException;
	
	/**
	 * 导出变更管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC05DTO getExcelDataList(IGCRC05DTO dto) throws BLException ;
}
