/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.plugin.alarmSocket.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;

/***
 * 集成告警相关业务逻辑接口
 * @time 2014/06/20
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */

public interface IGAlarmSocketBL extends BaseBL{
	
	/**
	 * 新增集成告警处理
	 * @param msg socket获取告警信息
	 * @return int 0：成功  1：失败
	 * @throws BLException
	 */
	public int registIgalarm(IGCRC02DTO dto) throws Exception;
}
