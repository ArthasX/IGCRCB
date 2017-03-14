/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.crc.igflow.event.status.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险管理定时任务BL接口
 * </p>
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */
public interface IGFXKDataSendBL extends BaseBL{
	
	/**
	 * 发送消息
	 * @throws BLException
	 */
	public void dataSend(Object bTime,Object eTime,Object title) throws BLException;
}
