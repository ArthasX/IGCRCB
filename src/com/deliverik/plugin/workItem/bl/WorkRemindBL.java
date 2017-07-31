/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.plugin.workItem.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 
 * @Description 工作项-工作实例提醒BL接口 
 *
 * @date 2017年6月22日
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public interface WorkRemindBL extends BaseBL{

	/**
	 * 工作实例提醒
	 * @throws BLException
	 */
	public void workInstanceRemind() throws BLException;
}
