/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;

/**
 * 概述:我的填报（年报）查询 
 * 功能描述：我的填报（年报）查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-07-25
 * 修改记录：
 */
public interface IGSMR03BL extends BaseBL {

	/**
	 * 查询需要我处理的年报
	 *
	 */
	public IGSMR03DTO needMeManagerAction(IGSMR03DTO dto) throws BLException;
	
	/**
	 * 查询报表审批
	 *
	 */
	public IGSMR03DTO reportExamineAction(IGSMR03DTO dto)throws BLException;
	
	/**
	 * 查询年报审批
	 *
	 */
	public IGSMR03DTO AnnualreportExamineAction(IGSMR03DTO dto);
	
	/**
	 * 填报查看
	 *
	 */
	public IGSMR03DTO seeFillInAction(IGSMR03DTO dto)throws BLException;
	
	/**
	 * 填报中止
	 *
	 */
	public IGSMR03DTO stopFillInAction(IGSMR03DTO dto)throws BLException;
	
	
	/**
	 * 催办
	 *
	 */
	public IGSMR03DTO pressAction(IGSMR03DTO dto)throws BLException;	

	/**
	 * 设置提醒时间
	 *
	 */
	public IGSMR03DTO setCautionTimeAction(IGSMR03DTO dto)throws BLException;	
	
	/**
	 * 清除提醒时间
	 *
	 */
	public IGSMR03DTO eliminateCautionTimeAction(IGSMR03DTO dto)throws BLException;	
	
	/**
	 * 提醒时间查询
	 *
	 */
	public IGSMR03DTO searchCautionTimeAction(IGSMR03DTO dto)throws BLException;
	
	/**
	 * 中止提醒时间
	 *
	 */
	public IGSMR03DTO stopCautionTimeAction(IGSMR03DTO dto)throws BLException;
	
	/**
	 * 点击首页跳转到报表的我的工作
	 *
	 */
	public IGSMR03DTO init0304Action(IGSMR03DTO dto)throws BLException;
	
	/**
	 * 通用查询 
	 *
	 */
	public IGSMR03DTO init0305Action(IGSMR03DTO dto)throws BLException;
}
