/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR10DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程导入BL接口 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRR10BL extends BaseBL{

	/**
	 * 流程定义查询操作开始
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO searchProcessDefinitionsAction(IGPRR10DTO dto) throws BLException;

	/**
	 * 封装导出模板
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO initProcessExportTemplateAction(IGPRR10DTO dto) throws BLException;

	/**
	 * 流程导入操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR10DTO importProcessRecordsAction(IGPRR10DTO dto) throws BLException;

}
