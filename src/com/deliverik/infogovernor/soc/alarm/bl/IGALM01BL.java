/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM01DTO;



/**
 *	性能指标模板控制类
 *	@author wangxing
 */
public interface IGALM01BL extends BaseBL {
	
	public IGALM01DTO importPerfTemplateAction(IGALM01DTO dto) throws BLException;
	public IGALM01DTO searchALM0102Action(IGALM01DTO dto) throws BLException;
	public IGALM01DTO deleteALM0102Action(IGALM01DTO dto) throws BLException;
}
