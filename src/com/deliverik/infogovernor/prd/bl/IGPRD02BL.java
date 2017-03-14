/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prd.dto.IGPRD02DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:流程定义工具BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRD02BL extends BaseBL{

	/**
	 * 用户查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD02DTO searchUserInfoList(IGPRD02DTO dto) throws BLException;

	/**
	 * 初始化流程简略信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD02DTO initProccessDefinitionInfoAction(IGPRD02DTO dto) throws BLException;

}
