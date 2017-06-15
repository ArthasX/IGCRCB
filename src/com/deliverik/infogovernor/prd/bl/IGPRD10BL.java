/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prd.dto.IGPRD10DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRD10BL extends BaseBL{

	/**
	 * 流程定义信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO searchLastProcessDefinitionAction(IGPRD10DTO dto) throws BLException;

	/**
	 * 加载流程定义信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO initProcessDefinitionAction(IGPRD10DTO dto) throws BLException;

	/**
	 * 更改流程定义操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO changeProcessDefinitionAction(IGPRD10DTO dto) throws BLException;

	/**
	 * 取得节点按钮信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO searchProcessStepButtonAction(IGPRD10DTO dto) throws BLException;

}
