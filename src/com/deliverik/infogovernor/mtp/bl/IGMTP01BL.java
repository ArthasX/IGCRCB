package com.deliverik.infogovernor.mtp.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.dto.IGMTP03DTO;
import com.deliverik.infogovernor.mtp.dto.IGMTP04DTO;

public interface IGMTP01BL extends BaseBL {

	/**
	 * 取得流程模板定义信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMTP01DTO getProcessDefinitions(IGMTP01DTO dto) throws BLException;

	
	/**
	 * 根据运维计划登记信息生成执行周期表达式说明
	 * @param periodType 周期类型
	 * @param exeHour 小时
	 * @param exeMinute 分钟
	 * @param startDate 开始日期
	 * @return
	 */
	public String getPeriodInfo(String periodType, String exeHour, String exeMinute,String startDate);
	
	/**
	 * 根据登记的运维计划信息生成执行周期表达式
	 * @param periodType 周期类型
	 * @param exeHour 小时
	 * @param exeMinute 分钟
	 * @param qjcrttime 开始日期
	 * @return
	 */
	public String creatCronExp(String periodType,String exeHour, String exeMinute, String qjcrttime);
	
	/**
	 * 初始化运维计划详细设置页面（IGMTP0104）
	 * @param dto 
	 * @param cronExpression quartz表达式
	 * @return
	 * @throws Exception
	 */
	public IGMTP01DTO initIGMTP0104(IGMTP01DTO dto,String cronExpression) throws Exception;
	
	/**
	 * 初始化运维计划详细设置修改页面（IGMTP0106）
	 * @param dto 
	 * @param cronExpression quartz表达式
	 * @return
	 * @throws Exception
	 */
	public IGMTP01DTO initIGMTP0107(IGMTP01DTO dto,String cronExpression) throws Exception;

	/**
	 * 登记工作计划日历初始化
	 * @param dto 
	 * @return
	 * @throws Exception
	 */
	public IGMTP03DTO initIGMTP0104Action(IGMTP03DTO dto) throws BLException;

	/**
	 * 修改工作计划日历初始化
	 * @param dto 
	 * @return
	 * @throws Exception
	 */
	public IGMTP03DTO initIGMTP0107Action(IGMTP03DTO dto) throws BLException;	
	
	/**
	 * 修改工作计划变量初始化(IGMTP0107Action)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMTP03DTO initIGMTP0107(IGMTP03DTO dto) throws BLException;
	
	
	/**
	 * 取得运维计划任务
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMTP04DTO getQuartzJobs(IGMTP04DTO dto) throws BLException;


	/**
	 * 日常运维计划修改处理
	 * @param dto
	 * @throws BLException
	 */
	public IGMTP01DTO updateQuartzJobs(IGMTP01DTO dto) throws BLException;
	
	/**
	 * 修改工作计划变量初始化(IGMTP0104Action)
	 */
	public IGMTP03DTO initIGMTP0104(IGMTP03DTO dto) throws BLException ;
}
