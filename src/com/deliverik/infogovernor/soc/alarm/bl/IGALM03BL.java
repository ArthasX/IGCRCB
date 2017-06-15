/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM03DTO;



/**
 *	监控对象规则控制类
 *	2013.08.01
 *	@author wangxing
 */
public interface IGALM03BL extends BaseBL {
	
	/**
	 * 获取监控对象视图
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO searchIGALM03Action(IGALM03DTO dto) throws BLException;
	
	/**
	 * 修改监控对象状态，决定是否生成告警
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO changeStatus(IGALM03DTO dto) throws BLException;
	
	/**
	 * 获取规则模板
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO getRuleTemps(IGALM03DTO dto) throws BLException;
	
	/**
	 * 配置监控对象告警规则
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO insertRuleTemps(IGALM03DTO dto) throws BLException;
	
	/**
	 * 获取CRM09关系实体
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGALM03DTO getCRM09Info(IGALM03DTO dto) throws BLException;
	
}
