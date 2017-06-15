/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.plugin.eventProcess.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机配置同步插件BL接口
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
public interface EVEProBL extends BaseBL{

	/**
	 * 事件流程超时提醒同步
	 * @throws BLException
	 */
	public void dataSynchronism() throws BLException;
}
