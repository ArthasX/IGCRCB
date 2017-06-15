/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM02DTO;



/**
 * 	规则模板控制类
 *	@author wangxing
 */
public interface IGALM02BL extends BaseBL {
	
	public IGALM02DTO insertRuleTempAndCondition(IGALM02DTO dto) throws BLException;

	//查询监控类型
	public IGALM02DTO searchMonitorType(IGALM02DTO dto) throws BLException;

	//查询规则模板
	public IGALM02DTO searchRuleTemp(IGALM02DTO dto) throws BLException;

	//删除规则模板
	public IGALM02DTO deleteRuleTemp(IGALM02DTO dto) throws BLException;

	//规则模板修改页面初始化
	public IGALM02DTO initRuleTemp(IGALM02DTO dto) throws BLException;

	//规则模板修改
	public IGALM02DTO updateRuleTemp(IGALM02DTO dto) throws BLException;

	//规则模板状态修改
	public IGALM02DTO updateRuleTempState(IGALM02DTO dto) throws BLException;
	
}
