/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR04DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程服务目录BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGPRR04BL extends BaseBL{

	/**
	 * 初始化服务目录显示页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR04DTO initServiceCatelogAction(IGPRR04DTO dto) throws BLException;

	/**
	 * 一级菜单下的服务目录查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR04DTO searchFirstActionServiceCatalog(IGPRR04DTO dto) throws BLException;

}
