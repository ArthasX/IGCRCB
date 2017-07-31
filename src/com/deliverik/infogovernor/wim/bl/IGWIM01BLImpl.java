/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.quartz.SchedulerException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.util.DateUtils;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.bl.task.WorkInstanceBL;
import com.deliverik.infogovernor.wim.bl.task.WorkLogBL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;
import com.deliverik.infogovernor.wim.form.IGWIM0102Form;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkDefinitionSearchCondImpl;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCondImpl;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;
import com.deliverik.infogovernor.wim.model.entity.WorkLogTB;
import com.deliverik.infogovernor.wim.vo.IGWIM01011VO;
import com.deliverik.plugin.workItem.job.WorkItemJob;

import jxl.Sheet;
import jxl.Workbook;

/**
 * @Description 工作项管理BL实现
 * 
 * @date 2017年6月9日16:24:25
 * 
 * @author WangLiang
 *
 */
public class IGWIM01BLImpl extends BaseBLImpl implements IGWIM01BL{
	
	static Log log = LogFactory.getLog(IGWIM01BLImpl.class);
	
	/** 工作项定义管理BL注入 */
	protected WorkDefinitionBL workDefinitionBL;
	
	/** 工作项实例管理BL注入 */
	protected WorkInstanceBL workInstanceBL;
	
	/** 工作日志管理BL注入 */
	protected WorkLogBL workLogBL;
	
	/** 人员BL */
	protected UserBL userBL;
	
	/** 用户角色BL注入 */
	protected UserRoleBL userRoleBL;
	
	/** 角色BL注入 */
	protected RoleBL roleBL;
	
	/**
	 * 工作项管理BL设定
	 * @param 工作项管理BL
	 */
	public void setWorkDefinitionBL(WorkDefinitionBL workDefinitionBL) {
		this.workDefinitionBL = workDefinitionBL;
	}
	
	/**
	 * 工作项实例管理BL设定
	 * @param 工作项实例管理BL
	 */
	public void setWorkInstanceBL(WorkInstanceBL workInstanceBL) {
		this.workInstanceBL = workInstanceBL;
	}

	/**
	 * 工作日志管理BL注入设定
	 * @param 工作日志管理BL注入
	 */
	public void setWorkLogBL(WorkLogBL workLogBL) {
		this.workLogBL = workLogBL;
	}
	
	/**
	 * 人员BL
	 * @param 人员BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * 用户角色BL设定
	 * @param 用户角色BL注入
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 角色BL设定
	 * @param 角色BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * @Description 工作项定义登记
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO registerWorkDefinitionAction(IGWIM01DTO dto) throws BLException {
		log.info("==========工作项登记BL处理开始==========");
		
		//工作项管理Form取得
		IGWIM0101Form form = dto.getIgwim0101Form();
		//登陆用户取得
		User user = dto.getUser();
		
		if(form!=null && form instanceof IGWIM0101Form){
			//获取系统日期（yyyy/MM/dd hh:mm）
			String currentDateTime = IGStringUtils.getCurrentDateTime();
			//新增
			WorkDefinitionTB wdTB = new WorkDefinitionTB();
			BeanUtils.copyProperties(form, wdTB);
			//设置是否每月最后一天发起
			wdTB.setMonthLastDay(form.getMonthLastDay()==null?"N":form.getMonthLastDay());
			//设置发起人（当前登录用户）
			wdTB.setInitiatorId(user.getUsername());
			//设置创建日期
			wdTB.setCrtDate(currentDateTime);
			
			//调用BL保存到工作定义表
			WorkDefinitionInfo definitionInfo = workDefinitionBL.registWorkDefinition(wdTB);
			//保存工作定义信息
			dto.setWorkDefinitionInfo(definitionInfo);
			
			//添加工作实例定时任务
			if("1".equals(definitionInfo.getWdstatus())){
				dto.setAddOrRemoveFlag("1");
				//添加工作定时任务
				jobManageAction(dto);
			}
			//设置成功提示信息
			dto.addMessage(new ActionMessage("IGCO10000.I004","工作项信息"));
		}
		log.info("==========工作项登记BL处理结束==========");
		return dto;
	}
	
	/**
	 * @Description 工作项更新
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO updateWorkDefinitionAction(IGWIM01DTO dto) throws BLException {
		log.info("==========工作项修改BL操作开始==========");
		//获取Form
		IGWIM0101Form form = dto.getIgwim0101Form();
		
		//实例化工作项定义实体
		WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(form.getWdid());
		
		//Copyproperties时排除的属性{"创建日期","fingerprint","发起人","发起时间","备用字段"}
		String[] strArray={"crtDate","fingerprint","initiatorId","wdcreatetime","reservedFiled"};
		
		//将Form赋值给工作项定义
		BeanUtils.copyProperties(form, definitionInfo,strArray);
		
		//调用BL修改工作项信息
		workDefinitionBL.updateWorkDefinition(definitionInfo);
		
		//保存工作定义信息
		dto.setWorkDefinitionInfo(definitionInfo);
		
		//添加工作实例定时任务
		if("1".equals(definitionInfo.getWdstatus())){
			dto.setAddOrRemoveFlag("1");
			//添加工作定时任务
		}
		
		//更新工作实例定时任务
		jobManageAction(dto);
		
		//设置成功提示信息
		dto.addMessage(new ActionMessage("IGCO10000.I005","工作项信息"));
		
		log.info("==========工作项修改BL操作结束==========");
		return dto;
	}
	
	/**
	 * @Description 工作项新增初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWIM01DTO workDefinitionInitAction(IGWIM01DTO dto) throws BLException {
		log.debug("========工作项新增初始化BL处理开始========");
		
		//获取工作项管理Form
		IGWIM0101Form form = dto.getIgwim0101Form();
		
		// 周集合
		List<IGWIM01011VO> weekList = new ArrayList<IGWIM01011VO>();
		IGWIM01011VO week1vo = new IGWIM01011VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("周一");
		weekList.add(week1vo);
		
		IGWIM01011VO week2vo = new IGWIM01011VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("周二");
		weekList.add(week2vo);
		
		IGWIM01011VO week3vo = new IGWIM01011VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("周三");
		weekList.add(week3vo);
		
		IGWIM01011VO week4vo = new IGWIM01011VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("周四");
		weekList.add(week4vo);
		
		IGWIM01011VO week5vo = new IGWIM01011VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("周五");
		weekList.add(week5vo);
		
		IGWIM01011VO week6vo = new IGWIM01011VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("周六");
		weekList.add(week6vo);
		
		IGWIM01011VO week7vo = new IGWIM01011VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("周日");
		weekList.add(week7vo);
		
		// 每月天数集合
		List<IGWIM01011VO> monthList = new ArrayList<IGWIM01011VO>();
		for (int i = 1; i < 31; i++) {
			// 天
			String dayvalue = String.valueOf(i);
			// 是否已选择
			IGWIM01011VO monthvo = new IGWIM01011VO();
			monthvo.setDayvalue(dayvalue);
			monthList.add(monthvo);
		}
		
		//小时集合
		List<IGWIM01011VO> hourList = new ArrayList<IGWIM01011VO>();
		for (int i = 0; i < 24; i++) {
			String hour = String.valueOf(i);
			IGWIM01011VO hourVo = new IGWIM01011VO();
			hourVo.setHourvalue(hour);
			hourList.add(hourVo);
		}
		
		//分集合
		List<IGWIM01011VO> minutesList = new ArrayList<IGWIM01011VO>();
		int j=0;
		for (int i = 0; i < 4; i++) {
			String minutes = String.valueOf(j);
			IGWIM01011VO minutesVo = new IGWIM01011VO();
			minutesVo.setMinutesvalue(minutes);
			minutesList.add(minutesVo);
			j+=15;
		}
		
		//若工作项wdid不为空，查询工作项信息
		if(form!=null && form.getWdid()!=null && form.getWdid()!=0){
			WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(form.getWdid());
			dto.setWorkDefinitionInfo(definitionInfo);
		}
		
		//保存频率周星期集合
		dto.setWeekList(weekList);
		//保存频率月天数集合
		dto.setMonthList(monthList);
		//保存频率小时集合
		dto.setHourList(hourList);
		//保存频率分集合
		dto.setMinutesList(minutesList);
		log.debug("========工作项新增初始化BL处理结束========");

		return dto;
	}
	
	/**
	 * @Description 生成工作定时任务表达式（规则）
	 * @param wdCycle 周期/频率（Y，day，week，month，quarter，halfyear，year）
	 * @param wdHour 小时
	 * @param wdMinutes 分钟
	 * @param beginDate 开始日期（yyyy/MM/dd hh:mm）
	 * @param singleChoose 当周期/频率为周或月份时，保存每周的周几/每月的几号，其他情况下为空
	 * @return 工作定时任务表达式（规则）
	 */
	private String generateExpression(String wdCycle, String wdHour, String wdMinutes, String beginDate, String singleChoose) {
		log.info("==========生成工作定时任务表达式（规则）开始==========");
		
		//定义表达式
		String expression = "";
		
		if("day".equals(wdCycle)){
			expression = "0 " + wdMinutes + " " + wdHour + " * * ?";
			
		}else if("week".equals(wdCycle)){
			expression = "0 " + wdMinutes + " " + wdHour + " ? * " + singleChoose;
			
		}else if("month".equals(wdCycle)){
			expression = "0 " + wdMinutes + " " + wdHour + " " + singleChoose + " * ?";
			
		}else if("Y".equals(wdCycle)){
			expression = "0 " + wdMinutes + " " + wdHour + " " + "L" + " * ?";
			
		}else if("quarter".equals(wdCycle)){
			String day = beginDate.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = beginDate.split("/")[1];
			expression = "0 " + wdMinutes + " " + wdHour + " " + day1 + " " + month + "/3 ?";
			
		}else if("halfyear".equals(wdCycle)){
			String day = beginDate.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = beginDate.split("/")[1];
//			expression = "0 " + wdMinutes + " " + wdHour + " " + day1 + " " + month + "," + ((Integer.parseInt(month) + 6) % 12) + " ?";
			expression = "0 " + wdMinutes + " " + wdHour + " " + day1 + " " + month + "/6 ?";
			
		}else if("year".equals(wdCycle)){
			String day = beginDate.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = beginDate.split("/")[1];
			expression = "0 " + wdMinutes + " " + wdHour + " " + day1 + " " + month + " ?";
		}
		
		log.debug("<<<<<<<<<<工作项定时任务表达式："+expression+">>>>>>>>>>");
		
		log.info("==========生成工作定时任务表达式（规则）结束==========");
		return expression;
	}
	
	/**
	 * @Description 工作实例定时任务管理/更新
	 * @param dto IGWIM01DTO 参数 WorkDefinitionInfo信息；addOrRemoveFlag：工作项定时任务添加/移除标识addOrRemoveFlag
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO jobManageAction(IGWIM01DTO dto) throws BLException {
		log.info("==========定时任务管理BL操作开始==========");
		
		//获取工作项信息
		WorkDefinitionInfo wdInfo = dto.getWorkDefinitionInfo();
		
		//工作组名称（相当于一个命名空间）
		String jobGroupName = "WorkItemCheckGroup" + wdInfo.getWdid();	
		
		//触发器名称
		String triggerName = "WorkItemCheckJobTrigger" + wdInfo.getWdid();	
		
		//触发器组名称
		String triggerGroupName = "WorkItemCheckJobTriggerGroup" + wdInfo.getWdid();	
		
		if("1".equals(dto.getAddOrRemoveFlag())){
			log.info("=====添加定时任务Job开始=====");
			//添加Job
			try {
				//日期格式化工具类
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				
				//Job取得
				WorkItemJob workItemJob = new WorkItemJob();	
				
				//工作项定义主键keyname List集合
				List<String> keyname = new ArrayList<String>();
				keyname.add("wdid");
				
				//工作项定义主键keyname Map集合
				Map<String, Integer> args = new HashMap<String, Integer>();
				args.put("wdid", wdInfo.getWdid());
				
				//<<<<<定时任务表达式生成所需参数获取开始>>>>>
				
				//定义周/月的某一天
				String singleChoose = null;
				if ("week".equals(wdInfo.getCycle())) {
					// 频率为周
					singleChoose = wdInfo.getWdweek();
				} else if ("month".equals(wdInfo.getCycle())) {
					//频率为月
					singleChoose = wdInfo.getWdmonth();
				}
				
				String wdHour = "";	//小时
				String wdMinutes = "";	//分钟
				
				//通过周期/频率决定开始日期的获取方式
				if("day".equals(wdInfo.getCycle()) || "week".equals(wdInfo.getCycle()) || "month".equals(wdInfo.getCycle())){
					//天，周，月通过下拉列表获取开始日期
					wdHour = wdInfo.getWdhour();
					wdMinutes = wdInfo.getWdminute();
					
				}else{
					//季度，半年，年通过日期控件获取开始日期
					String[] startDate = wdInfo.getBeginDate().split("\\ ");
					//拆分开始日期字符串获得时分
					String starttime = startDate[1];
					wdHour = starttime.split("\\:")[0];
					wdMinutes = starttime.split("\\:")[1];
				}

				// 取得执行周期表达式
				String expression = null;

				if ("month".equals(wdInfo.getCycle()) && "Y".equals(wdInfo.getMonthLastDay())) {// 频率为每月最后一天
					// 取得执行周期表达式,每月最后一天
					expression = this.generateExpression(wdInfo.getMonthLastDay(), wdHour, wdMinutes, wdInfo.getBeginDate(), null);
					singleChoose = "最后一";
				} else {
					// 除月最后一天外其他周期/频率
					expression = this.generateExpression(wdInfo.getCycle(), wdHour, wdMinutes, wdInfo.getBeginDate(), singleChoose);
				}
				
				//<<<<<定时任务表达式生成所需参数获取结束>>>>>
				
				//开始日期
				Date beganDate = format.parse(wdInfo.getBeginDate().length()>10?
						wdInfo.getBeginDate():wdInfo.getBeginDate()+" "+wdHour+":"+wdMinutes);
				
				//结束日期
				Date endDate = format.parse(wdInfo.getEstimateFinishDate());
				
				//添加工作定时任务
				JobManager.addJob(WorkItemJob.JOB_NAME, jobGroupName, triggerName, triggerGroupName, workItemJob, 
						keyname, args, expression, beganDate, endDate);
//				JobManager.addJob(WorkItemJob.JOB_NAME,workItemJob, expression);
				
			} catch (Exception e) {
				log.error("==========Exception form WorkItemCheckJob===========");
				log.debug(e.getMessage());
				log.error("quartz报错", e);
				throw new BLException("", "SchedulerException");
			}
			log.info("=====添加定时任务Job结束=====");
		}else{
			log.info("=====移除定时任务Job开始=====");
			try {
				//移除工作定时任务
				JobManager.removeJob(WorkItemJob.JOB_NAME, jobGroupName, triggerName, triggerGroupName);
			} catch (SchedulerException e) {
				log.error("==========Exception form WorkItemCheckJob===========");
				log.debug(e.getMessage());
				log.debug("quartz启动报错", e);
				throw new BLException("", "SchedulerException");
			}
			log.info("=====移除定时任务Job结束=====");
		}
		log.info("==========定时任务管理BL操作结束==========");
		return dto;
	}


	/**
	 * @Description 工作项查询
	 * @param dto
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO searchWorkDefinition(IGWIM01DTO dto) throws BLException {
		log.info("==========工作项查询BL处理开始==========");
		
		//获取工作项查询Form
		IGWIM0102Form form = dto.getIgwim0102Form();
		//实例化查询条件
		WorkDefinitionSearchCondImpl cond = new WorkDefinitionSearchCondImpl();
		//设置工作项名称
		cond.setWdname(form.getWdname());
		//设置发起人
		cond.setInitiatorId(form.getInitiatorId());
		//设置负责人
		cond.setLeaderName(form.getLeaderName());
		//设置启用状态
		cond.setWdstatus(form.getWdstatus());
		//设置开始日期从
		cond.setBeginDateStart(form.getBeginDateStart());
		//设置开始日期到
		cond.setBeginDateOver(form.getBeginDateOver());
		
		if(hasMostPower(dto.getUser().getUserid())){
			
			//有最高权限，可以查看所有发起人的工作
			//保存用户权限标识
			form.setIsNormalUser("0");
			
		}else if(StringUtils.isNotEmpty(hasLeaderPower(dto.getUser().getUserid()))){
			
			//有中心负责人权限，查询所在中心部门下的发起人的所有工作
			UserSearchCondImpl userCond = new UserSearchCondImpl();
			//设置查询条件ORGID
			userCond.setOrgid(hasLeaderPower(dto.getUser().getUserid()));
			//检索对应部门id的用户列表
			List<User> userList = userBL.searchUser(userCond);
			//实例化中心负责及以下用户userid集合
			List<String> newlist = new ArrayList<String>();
			
			if(userList!=null && userList.size()>0){
				//遍历该中心下的所有用户取得userid放到newlist集合中
				for (int i = 0; i < userList.size(); i++) {
					newlist.add(userList.get(i).getUsername());
				}
			}
			cond.setInitiatorId_in(newlist);
			//保存用户权限标识
			form.setIsNormalUser("0");
			
		}else{
			
			//主键检索userid
			User user = userBL.searchUserByKey(dto.getUser().getUserid());
			//普通用户，只能查看自己发起的工作
			cond.setInitiatorId(dto.getUser().getUsername());
			//设置当前用户为默认发起人
			form.setInitiatorId(user.getUsername());
			//设置普通用户标识
			form.setIsNormalUser("1");
		}
		
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		
		//检索条数
		int totalCount = workDefinitionBL.searchWorkDefinition(cond, 0, 0).size();
		
		if (totalCount == 0) {
			log.info("========工作项检索数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.info("========工作项数据件数过多========");
			// 用户检索数据件数过多
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//调用BL查询工作项信息
		List<WorkDefinitionInfo> wdList = workDefinitionBL.searchWorkDefinition(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		//保存查询结果集
		dto.setDefinitionInfos(wdList);
		//设置分页总条数
		pDto.setTotalCount(totalCount);
		
		log.info("==========工作项查询BL处理结束==========");
		return dto;
	}
	
	/**
	 * @Description 工作项信息删除处理
	 * @param dto IGWIM01DTO
	 * @return IGRIS06DTO
	 * @throws BLException
	 */
	public IGWIM01DTO deleteWorkDefinitoinAction(IGWIM01DTO dto) throws BLException {
		log.debug("========工作项信息删除BL处理开始========");
		
		//定义存储提示信息的字符串变量
		StringBuffer sbMsg = new StringBuffer();
		
		//定义已发起的工作项个数
		int launched = 0;
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			
			//获取删除项wdid
			String wdid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象检查项确认
			WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(Integer.parseInt(wdid));
			
			if (definitionInfo == null){
				throw new BLException("IGCO10000.E004","删除对象工作项基本");
			}
			
			//检索工作项是否已经发起
			WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
			
			//设置工作项定义id查询条件
			cond.setWdid(definitionInfo.getWdid());
			
			//调用BL查询工作实例
			List<WorkInstanceInfo> wiInfoList = workInstanceBL.searchWorkInstance(cond);
			
			if(wiInfoList!=null && wiInfoList.size()>0){
				
				//工作项已发起
				if(launched>0){
					sbMsg.append("，"+wiInfoList.get(0).getWdname());
					
				}else{
					sbMsg.append("存在如下已发起的工作项，删除失败！\n");
					sbMsg.append(wiInfoList.get(0).getWdname());
				}
				
				launched++;
				
				log.info("##########"+sbMsg);
			}
			
		}
		
		//如果没有已发起的工作项，方可执行删除
		if(launched<=0){
			for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
				
				//获取删除项wdid
				String wdid = dto.getDeleteEntityItem()[i];
				
				//删除前删除对象检查项确认
				WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(Integer.parseInt(wdid));
				
				//工作项删除
				workDefinitionBL.deleteWorkDefinition(definitionInfo);
			}
			sbMsg.append("工作项删除成功！");
		}
		
		//保存提示信息
		dto.setMsg(sbMsg.toString());
		
		log.debug("========工作项信息删除BL处理结束========");
		return dto;
	}
	
	/**
	 * @Description 校验工作项是否合法
	 * @param info 工作定义信息
	 * @return
	 * @throws ParseException 
	 */
	private IGWIM01DTO checkQuartzIslegitimate(IGWIM01DTO dto) throws ParseException{
		//合法标识(false：默认有效)
		String isInvalid = "0";
		
		WorkDefinitionInfo info = dto.getWorkDefinitionInfo();
		
		//定义系统当前时间
		String currentTime = IGStringUtils.getCurrentDateTime();
		
		//获取预计完成时间
		String estimateFinishDate = info.getEstimateFinishDate();
		
		//定义循环查找次数标识
		int loopNum = 0;
		
		//获取开始日期（yyyy/MM/dd hh:ss）
		String beginTime = info.getBeginDate();
		
		//若周期为日、月或周
		String startTime = info.getBeginDate().substring(0, 10);	//获取开始日期（yyyy/MM/dd）
		//拼接开始日期和时间表单，拼接后格式为（yyyy/MM/dd hh:mm）
		if(StringUtils.isNotEmpty(startTime)){
			startTime += " "+info.getWdhour()+":"+info.getWdminute();
		}
		
		
		//取得用户选择的日期号
		String chooseDay = info.getWdmonth();
		if(StringUtils.isNotEmpty(chooseDay) && chooseDay.length() < 2){
			//日期（d）如果是一位补零
			chooseDay = "0"+chooseDay;
		}
		//日期最后一天
		String chooseLastday = info.getMonthLastDay();
		
		//定义选择的周
		String wdweek = info.getWdweek();
		//定义周转换成0~6的值类型
		int chooseWeek = -1;
		
		//<<<<<根据周期的几种情况比较服务器时间和开始日期（开始日期不能早于服务器时间）>>>>>
		if("quarter".equals(info.getCycle()) || "halfyear".equals(info.getCycle()) || "year".equals(info.getCycle())){
			
			//若周期为季度、半年或年
			int compairDate = compairDate(strParseDate(info.getBeginDate()), strParseDate(currentTime));
			if(compairDate == -1 || compairDate==0){
				isInvalid = "1";
				dto.setMsg("工作项状态更新失败，开始日期应该晚于系统日期！");
				dto.setIsInvalid(isInvalid);
				return dto;
			}
			
			if("quarter".equals(info.getCycle())){
				
				//周期为季度
				loopNum = 92;
				
			}else if("halfyear".equals(info.getCycle())){
				
				//周期为半年
				loopNum = 183;
				
			}else if("year".equals(info.getCycle())){
				
				//周期为年
				loopNum = 366;
			}
			
			//2017年7月12日和FXy确认的逻辑为保证Quartz至少能执行一次为基准的验证，季度、半年、年则无需校验
			//<<<<<结束循环校验>>>>>
			
		}else{
			
			//比较开始日期和系统日期
			int compairDate = compairDate(strParseDate(startTime), strParseDate(currentTime));
			
			if(compairDate ==-1 || compairDate==0){
				//如果开始日期小于系统日期，给予提示
				isInvalid = "1";
				dto.setMsg("工作项状态更新失败，开始日期应该晚于系统日期！");
				dto.setIsInvalid(isInvalid);
				return dto;
			}
			
			if("day".equals(info.getCycle())){
				
				//周期为日。不需要循环查找，因为以每天为周期，只要验证开始日期大于系统日期和预计完成日期小于开始日期通过即可。
				isInvalid = "0";
				dto.setIsInvalid(isInvalid);
				return dto;
				
			}else if("week".equals(info.getCycle())){
				
				//周期为周
				loopNum = 7;
				
			}else{
				
				//周期为月
				loopNum = 31;
			}
			
			
			if(StringUtils.isNotEmpty(wdweek)){
				
				if("MON".equals(wdweek)){
					
					chooseWeek = 1;
					
				}else if("TUE".equals(wdweek)){
					
					chooseWeek = 2;
					
				}else if("WED".equals(wdweek)){
					
					chooseWeek = 3;
					
				}else if("THU".equals(wdweek)){
					
					chooseWeek = 4;
					
				}else if("FRI".equals(wdweek)){
					
					chooseWeek = 5;
					
				}else if("SAT".equals(wdweek)){
					
					chooseWeek = 6;
					
				}else if("SUN".equals(wdweek)){
					
					chooseWeek = 0;
				}
			}
			
			
			
		}
		
		//计算预计完成日期和开始日期的差值（其中循环条件是差值不能小于1），若小于31天，则需要得到每天的日期（号）与选择的进行对比，没有相等验证未通过；
		//若差值>=31，则一定存在Quartz至少执行一次的规则，通过验证
		
		Date startDate = new Date(startTime);	//把开始日期转成日期格式
		
		Date estimatedDate = new Date(estimateFinishDate);	//把预计完成日期转成日期格式
		
		int diff = daysBetween(startTime, estimateFinishDate);	//计算两个日期的差（天）

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm");
		
		Calendar cal = Calendar.getInstance();  
		
		//<<<<<开始循环校验>>>>>
		if(diff > 0){
			//日期差小于指定天，根据日期差次数遍历进行一一对比
			if(diff < loopNum){
				
				//定义是否匹配日期的标识（0：否；1：是）；
				int equalFlag = 0;
				
				for (int i = 0; i <= diff; i++) {
					
					if("month".equals(info.getCycle())){
						
						//比较月最后一天
						if("Y".equals(chooseLastday)){
							if(i!=0){
								
								//获取开始日期的下一天和用户选择的日期比较
								String dateAfter=sdf.format(getDateAfter(strParseDate(startTime), i+1));  
								if(!(dateAfter.substring(5,7) .equals(startTime.substring(5,7)))){
									//如果下一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
							}else{
								//比较第一天
								//获取开始日期的下一天和用户选择的日期比较
								String dateAfter=sdf.format(getDateAfter(strParseDate(startTime),0));  
								if(!(dateAfter.substring(5,7) .equals(startTime.substring(5,7)))){
									//如果第一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
								
							}
						}else{
							//比较月
							
							//读取1~30天
							if(i!=0){
								
								//获取开始日期的下一天和用户选择的日期比较
								String dateAfter=sdf.format(getDateAfter(strParseDate(startTime),i));  
								if(dateAfter.substring(8,10).equals(chooseDay)){
									//如果下一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
							}else{
								//比较第一天
								if(startTime.substring(8,10).equals(chooseDay)){
									//如果第一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
								
							}
						}
					}
					
					
					//比较周
					if("week".equals(info.getCycle())){
						if(i!=0){
							
							//获取开始日期是星期几
							
					        cal.setTime(getDateAfter(strParseDate(startTime), i));  
					        int whichWeek = cal.get(Calendar.DAY_OF_WEEK) - 1; 
							
							//获取开始日期的下一天和用户选择的日期比较
							if(whichWeek == chooseWeek){
								//如果下一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
								equalFlag = 1;
								break;
							}
						}else{
							
							//获取开始日期是星期几
							cal.setTime(startDate);  
							int whichWeek = cal.get(Calendar.DAY_OF_WEEK) - 1; 
							
							//比较第一天
							if(whichWeek == chooseWeek){
								//如果第一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
								equalFlag = 1;
								break;
							}
							
						}
					}
					
					if("quarter".equals(info.getCycle()) || "halfyear".equals(info.getCycle()) || "year".equals(info.getCycle())){
						//比较季度、半年、年
						if(i!=0){
							
							//获取开始日期的下一天和用户选择的日期比较
							String dateAfter=sdf.format(getDateAfter(strParseDate(beginTime),i)); 
							if(dateAfter.substring(8,10) == chooseDay){
								//如果下一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
								equalFlag = 1;
								break;
							}
						}else{
							//比较第一天
							if(beginTime.substring(8,10) == chooseDay){
								//如果第一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
								equalFlag = 1;
								break;
							}
							
						}
					}
					
				}
				//循环结束后
				if(equalFlag==0){
					isInvalid = "1";
					dto.setMsg("工作项状态更新失败，该工作项日期超出范围，请修改后重新启用！");
					return dto;
				}else{
					isInvalid = "0";
					dto.setIsInvalid(isInvalid);
				}
			}else{
				isInvalid = "0";
				dto.setIsInvalid(isInvalid);
			}
		}else{
			//比较用户所选日期（dd）是否和开始日期为同一天，如果不是，则非法
			if(startTime.substring(8,10) != chooseDay){
				isInvalid = "1";
				dto.setMsg("工作项状态更新失败，该工作项日期超出范围，请修改后重新启用！");
				dto.setIsInvalid(isInvalid);
				return dto;
			}else{
				isInvalid = "0";
				dto.setIsInvalid(isInvalid);
			}
		}
		//<<<<<结束循环校验>>>>>
		return dto;
	}
	
	/**
	 * @Description 工作项状态修改
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 * @throws ParseException 
	 * @throws BeansException 
	 */
	public IGWIM01DTO updateWorkDefinitionStatusAction(IGWIM01DTO dto) throws BLException, BeansException, ParseException {
		log.info("==========工作项状态修改BL操作开始==========");
		
		//获取工作项管理Form
		IGWIM0101Form form = dto.getIgwim0101Form();
		
		//实例化工作项定义实体
		WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(form.getWdid());
		
		if(definitionInfo!=null){
			
			dto.setWorkDefinitionInfo(definitionInfo);
			
			//如果是0证明要启用
			if("0".equals(definitionInfo.getWdstatus())){
				
				//校验Quartz合法性
				dto = checkQuartzIslegitimate(dto);
				
				if("0".equals(dto.getIsInvalid())){
					
					//实例化WorkDefinitionTB
					WorkDefinitionTB definitionTB = new WorkDefinitionTB();
					
					//将definitionInfo赋值给definitionTB
					BeanUtils.copyProperties(definitionInfo, definitionTB);
					
					//<!----------停用工作项时清空实际完成日期开始-2017年7月3日13:13:04-WangLiang-------->
					if("1".equals(definitionInfo.getWdstatus())){
						
						definitionTB.setActualFinishDate("");
					}
					//<!----------停用工作项时清空实际完成日期结束---------->
					
					//若已启用1，则设置停用0，否则设置启用
					definitionTB.setWdstatus("1".equals(definitionInfo.getWdstatus())?"0":"1");
					
					//调用BL修改工作项信息
					WorkDefinitionInfo wdInfo = workDefinitionBL.updateWorkDefinition(definitionTB);
					
					if("1".equals(wdInfo.getWdstatus())){
						dto.setAddOrRemoveFlag("1");
					}else{
						dto.setAddOrRemoveFlag("2");
					}
					
					//保存工作定时任务
					dto.setWorkDefinitionInfo(wdInfo);
					
					//工作项定时任务更新
					jobManageAction(dto);
					
					dto.setMsg("工作项状态更新成功！");
					
				}else{
					
					return dto;
				}
			}else{
				
				//实例化WorkDefinitionTB
				WorkDefinitionTB definitionTB = new WorkDefinitionTB();
				
				//将definitionInfo赋值给definitionTB
				BeanUtils.copyProperties(definitionInfo, definitionTB);
				
				//<!----------停用工作项时清空实际完成日期开始-2017年7月3日13:13:04-WangLiang-------->
				if("1".equals(definitionInfo.getWdstatus())){
					
					definitionTB.setActualFinishDate("");
				}
				//<!----------停用工作项时清空实际完成日期结束---------->
				
				//若已启用1，则设置停用0，否则设置启用
				definitionTB.setWdstatus("1".equals(definitionInfo.getWdstatus())?"0":"1");
				
				//调用BL修改工作项信息
				WorkDefinitionInfo wdInfo = workDefinitionBL.updateWorkDefinition(definitionTB);
				
				if("1".equals(wdInfo.getWdstatus())){
					dto.setAddOrRemoveFlag("1");
				}else{
					dto.setAddOrRemoveFlag("2");
				}
				
				//保存工作定时任务
				dto.setWorkDefinitionInfo(wdInfo);
				
				//工作项定时任务更新
				jobManageAction(dto);
				
				dto.setMsg("工作项状态更新成功！");
			}
			
			
		}
		log.info("==========工作项状态修改BL操作结束==========");
		return dto;
	}
	
	
	/**
	 * @Description 发起工作实例
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 * 
	 */
	public IGWIM01DTO registerWorkInstanceAction(IGWIM01DTO dto) throws BLException{
		log.info("==========工作实例发起BL处理开始==========");
		//主键检索工作项定义信息
		WorkDefinitionInfo wdInfo = workDefinitionBL.searchWorkDefinitionByPK(dto.getWdid());
		
		//实例化工作实例
		WorkInstanceTB wiTB = new WorkInstanceTB();
		//设置工作项定义id
		wiTB.setWdid(wdInfo.getWdid());
		//设置工作项名称
		wiTB.setWdname(wdInfo.getWdname()+"工作项"+DateUtils.getCurrentYear()+DateUtils.getCurrentMonth()+DateUtils.getCurrentDate());
		//设置工作状态
		wiTB.setWistatus("未执行");
		
		//如果标识不为空，是手动发起，否则为自动发起
		if(StringUtils.isNotEmpty(dto.getLaunchFlag())){
			
			//手动发起，设置发起人
			wiTB.setInitiatorId(dto.getUser().getUsername());
			//设置发起类型
			wiTB.setWiLunchType("2");
			//设置开始日期
			wiTB.setBeginDate(IGStringUtils.getCurrentDateTime());
		}else{
			
			//自动发起，设置发起人
			wiTB.setInitiatorId(wdInfo.getInitiatorId());
			//设置发起类型
			wiTB.setWiLunchType("1");
			//设置开始日期
			wiTB.setBeginDate(wdInfo.getBeginDate());
		}
		//设置周期/频率
		wiTB.setCycle(wdInfo.getCycle());
		//设置负责人id
		wiTB.setLeaderId(wdInfo.getLeaderId());
		//设置负责人名称
		wiTB.setLeaderName(wdInfo.getLeaderName());
		//设置执行人id
		wiTB.setExcutorId(wdInfo.getExcutorId());
		//设置执行人名称
		wiTB.setExcutorName(wdInfo.getExcutorName());
		//设置创建日期
		wiTB.setCrtDate(DateUtils.getCurrentTime());
		//调用BL新增工作实例
		WorkInstanceInfo workInstanceInfo = workInstanceBL.registWorkInstance(wiTB);
		
		//保存工作项实例信息
		dto.setWorkInstanceInfo(workInstanceInfo);
		
		//新增日志表信息
		registerWorkLogAction(dto);
		
		dto.setMsg("工作实例发起成功！");
		
		log.info("==========工作实例发起BL处理结束==========");
		return dto;
	}
	
	
	/**
	 * @Description 新增工作日志
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 * 
	 */
	public IGWIM01DTO registerWorkLogAction(IGWIM01DTO dto) throws BLException{
		log.info("==========工作日志新增BL处理开始==========");
		//获取工作实例
		WorkInstanceInfo workInstanceInfo = dto.getWorkInstanceInfo();
		
		//实例化工作日志
		WorkLogTB wlTB = null;
		
		if(workInstanceInfo!=null){
			//获取执行人id
			String excutorId = workInstanceInfo.getExcutorId();
			//获取执行人名称
			String excutorName = workInstanceInfo.getExcutorName();
			//实例化工作日志
			
			for (int i = 0; i < excutorId.split("、").length; i++) {
				
				wlTB = new WorkLogTB();
				
				//设置工作实例wiid
				wlTB.setWiid(workInstanceInfo.getWiid());
				//设置执行人id
				wlTB.setExcutorId(excutorId.split("、")[i]);
				//设置执行人名称
				wlTB.setExcutorName(excutorName.split("、")[i]);
				//设置按钮动作
				wlTB.setBtnAction("2");
				//设置创建日期
				wlTB.setCrtDate(IGStringUtils.getCurrentDateTime());
				
				//调用BL新增工作日志
				workLogBL.registWorkLog(wlTB);
			}
			
		}
		
		log.info("==========工作日志新增BL处理结束==========");
		return dto;
	}
	
	/**
	 * @Description 工作项数据导入
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO importData(IGWIM01DTO dto) throws BLException{
		log.info("==========工作项数据导入BL处理开始==========");
		//获取form
		IGWIM0102Form form = dto.getIgwim0102Form();
		//导入结果
        Workbook xwb = null;
        FormFile file = null;
        file = form.getFileMap();
        try {
    		log.info("==============进行excel文件解析==============");
    		xwb = Workbook.getWorkbook(file.getInputStream());
    		log.info("============文件解析成功============");
    	} catch (Exception e) {
    		saveResult(form,"解析文件错误!");
    	}
        //获取sheet页
        Sheet sheet = xwb.getSheet(0);
        //获取数据行数
        int rows = sheet.getRows();
        //判断是否存在数据，如果不存在数据则抛出错误
        if(rows<=2){
        	saveResult(form,"没有数据请重新上传！");
        }
        //遍历数据并且插入数据
        for(int i=2;i<rows-1;i++){
        	//获取发起人内容
        	 String startPeople =  sheet.getCell(0,i).getContents();
        	 if(StringUtils.isEmpty(startPeople)){
        		 break;
        	 }
        	 //判断是否人员是否存在
        	 if(!(StringUtils.isNotEmpty(startPeople)&&searchUser(startPeople,""))){
        		 saveResult(form,"第"+(i+1)+"行发起人("+startPeople+")没有数据或者发起人填写不正确请核对后再上传！");
        	 }
        	 //获取工作项名称
        	 String workName =  sheet.getCell(1,i).getContents();
        	 if(StringUtils.isEmpty(workName)){
        		 saveResult(form,"第"+(i+1)+"行工作项名称没有数据请核对后再上传！");
        	 }
        	 //获取工作项描述
        	 String workDesc =  sheet.getCell(2,i).getContents();
        	 //获取周期
        	 String cycle  =  sheet.getCell(3,i).getContents();
        	 if(StringUtils.isEmpty(cycle)){
        		 saveResult(form,"第"+(i+1)+"行周期没有数据请核对后再上传！");
        	 }
        	 //获取周内容
        	 String weekContent = sheet.getCell(4,i).getContents();
        	 if("每周".equals(cycle)&&StringUtils.isEmpty(weekContent)){
        		 saveResult(form,"第"+(i+1)+"行周期选择的是每周，则周为必填请核对后再上传！"); 
        	 }
        	 //获取日期
        	 String monthContent = sheet.getCell(5,i).getContents();
        	 if("每月".equals(cycle)&&StringUtils.isEmpty(monthContent)){
        		 saveResult(form,"第"+(i+1)+"行周期选择的是每月，则日期为必填请核对后再上传！"); 
        	 }
        	 //获取时
        	 String hour = sheet.getCell(6,i).getContents();
        	 if(("每月".equals(cycle)||"每日".equals(cycle)||"每周".equals(cycle))&&StringUtils.isEmpty(hour)){
        		 saveResult(form,"第"+(i+1)+"行周期选择的是每天或每周或每月，则小时为必填请核对后再上传！"); 
        	 }
        	 
        	 //获取分
        	 String minute = sheet.getCell(7,i).getContents();
        	 if(("每月".equals(cycle)||"每日".equals(cycle)||"每周".equals(cycle))&&StringUtils.isEmpty(minute)){
        		 saveResult(form,"第"+(i+1)+"行周期选择的是每天或每周或每月，则分为必填请核对后再上传！"); 
        	 } 
        	 
        	 //获取开始日期
        	 String startDate = sheet.getCell(8,i).getContents();
        	 if(StringUtils.isEmpty(startDate)){
        		 saveResult(form,"第"+(i+1)+"行开始日期为必填请核对后再上传！"); 
        	 } 
        	 if(!isDate(startDate)){
        		 saveResult(form,"第"+(i+1)+"行开始日期填写错误请核对后再上传！");
        	 }
        	 //获取预计完成时间
        	 String expectDate = sheet.getCell(9,i).getContents();
        	 if(StringUtils.isNotEmpty(expectDate)&&!isDate(expectDate)){
        		 saveResult(form,"第"+(i+1)+"行预计完成时间填写错误请核对后再上传！");
        	 }
        	 //获取负责人ID
        	 String leadPeopleId =  sheet.getCell(10,i).getContents();
        	 //判断是否人员是否存在
        	 if(!(StringUtils.isNotEmpty(leadPeopleId)&&searchUser(leadPeopleId,""))){
        		 saveResult(form,"第"+(i+1)+"行负责人("+leadPeopleId+")没有数据或者发起人填写不正确请核对后再上传！");
        	 }
        	 String leadPeopleName = searchUserName(leadPeopleId);
        	 //获取执行人
        	 String excutePeopleId = sheet.getCell(11,i).getContents();
        	 String[] excutePeopleIdArr =  excutePeopleId.split("、");
        	 String excutePeopleName = "";
        	 if(excutePeopleIdArr == null||excutePeopleIdArr.length==0){
        		 saveResult(form,"第"+(i+1)+"行执行人("+excutePeopleId+")没有数据或者发起人填写不正确请核对后再上传！");
        	 }else{
        		 for(String userid:excutePeopleIdArr){
                	 //判断是否人员是否存在
                	 if(!(searchUser(userid,""))){
                		 saveResult(form,"第"+(i+1)+"行执行人("+excutePeopleId+")没有数据或者发起人填写不正确请核对后再上传！");
                	 }else{
                		 excutePeopleName+=searchUserName(userid)+"、";
                		 
                	 }
        		 }
        	 }
        	 //获取超时提醒时间
        	 String overDate =  sheet.getCell(12,i).getContents();
        	 if(StringUtils.isEmpty(overDate)){
        		 saveResult(form,"第"+(i+1)+"行超时提醒时间没有数据请核对后再上传！");
        	 }
        	 //必须输入0以上的数字
        	 try {
				int overTimes = Integer.parseInt(overDate);
			} catch (NumberFormatException e) {
				saveResult(form,"第"+(i+1)+"行超时提醒时间填写错误请核对后再上传！");
			}
        	 if(Integer.parseInt(overDate)<1){
        		 saveResult(form,"第"+(i+1)+"行超时提醒时间填写错误请核对后再上传！");
        	 }
        	//获取超时停止处理时间
        	 String overStopDate =  sheet.getCell(13,i).getContents();
        	 if(StringUtils.isEmpty(overDate)){
        		 saveResult(form,"第"+(i+1)+"行超时停止处理时间没有数据请核对后再上传！");
        	 }
        	 //必须输入0以上的数字
        	 try {
				int overStopTime = Integer.parseInt(overStopDate);
			} catch (NumberFormatException e) {
				saveResult(form,"第"+(i+1)+"行超时停止处理时间填写错误请核对后再上传！");
			}
        	 if(Integer.parseInt(overStopDate)<1){
        		 saveResult(form,"第"+(i+1)+"行超时停止处理时间填写错误请核对后再上传！");
        	 }
        	 String desc =  sheet.getCell(14,i).getContents();
        	 saveWorkDefine(startPeople, workName, workDesc, cycle, weekContent, monthContent, hour, minute, startDate, expectDate, leadPeopleId, leadPeopleName, excutePeopleId, excutePeopleName, overDate, overStopDate, desc);
        }
        form.setResult("导入成功！");
		log.info("==========工作项数据导入BL处理结束==========");
		return dto;
		
	}
	/**
	 * 查询人是否存在
	 * @param userid
	 * @param username
	 * @return
	 */
	private boolean searchUser(String userid,String username){
		 UserSearchCondImpl userCond = new UserSearchCondImpl();
		 if(StringUtils.isNotEmpty(username)){
			 userCond.setUsername_q(username);
		 }
		 if(StringUtils.isNotEmpty(userid)){
			 userCond.setUserid(userid);
		 }
		 userCond.setOrgid_like(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE);
		 List<User> userList = userBL.searchUser(userCond);
		 if(userList!=null && userList.size()>0){
			 return true;
		 }else{
			 return false;
		 }
	}
	/**
	 * 查询人是否存在
	 * @param userid
	 * @param username
	 * @return
	 * @throws BLException 
	 */
	private String searchUserName(String userid) throws BLException{
		User user = userBL.searchUserByKey(userid);
		return user.getUsername();
	}
	
	/**
	 * 保存校验结果并且抛出错误
	 * @param result 校验结果
	 * @param result form
	 * @throws BLException
	 */
	private void saveResult(IGWIM0102Form form,String result) throws BLException{
		log.error(result);
 		form.setResult(result);
 		throw new BLException("IGALM0101.E001",result);
	}
	
	/**
	 * 校验日期填写是否正确
	 * @param date 日期字符串
	 * @return
	 */
	private boolean isDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			format.parse(date);
			return true;
		} catch (ParseException e) {
			e.printStackTrace();
			log.error(date+"转换日期格式出错");
			return false;
		}
	}
	
	/**
	 * 保存工作项定义
	 * @param startPeople 发起人
	 * @param workName 工作项名称
	 * @param workDesc 工作项描述
	 * @param cycle 周期
	 * @param weekContent 周
	 * @param monthContent 日期
	 * @param hour 小时
	 * @param minute 分钟
	 * @param startDate 开始日期
	 * @param expectDate 预计
	 * @param leadPeople 负责人ID
	 * @param leadPeopleName 负责人名称
	 * @param excutePeople 执行人ID
	 * @param excutePeopleName 执行人名称
	 * @param overDate 超时提醒时间
	 * @param overStopDate 超时停止处理时间
	 * @param desc 备注
	 * @throws BLException 
	 */
	private void saveWorkDefine(String startPeople,String workName,String workDesc,String cycle,String weekContent,String monthContent,String hour,String minute,String startDate,String expectDate,String leadPeopleId,String leadPeopleName,String excutePeopleId,String excutePeopleName,String overDate,String overStopDate,String desc) throws BLException{
		WorkDefinitionTB tb = new WorkDefinitionTB();
		//主键检索用户，保存用户名为发起人
		User user = userBL.searchUserByKey(startPeople);
		tb.setInitiatorId(user.getUsername());
		tb.setWdname(workName);
		tb.setDescription(workDesc);
		//定义周期
		String zhouqi = "";
		
		if("每日".equals(cycle)){
			zhouqi = "day";
		}else if("每周".equals(cycle)){
			zhouqi = "week";
		}else if("每月".equals(cycle)){
			zhouqi = "month";
		}else if("每季度".equals(cycle)){
			zhouqi = "quarter";
		}else if("每半年".equals(cycle)){
			zhouqi = "halfyear";
		}else if("每年".equals(cycle)){
			zhouqi = "year";
		}else{
			zhouqi = "";
		}
		tb.setCycle(zhouqi);
		//定义周
		String week = "";
		
		if("周一".equals(weekContent)){
			week = "MON";
		}else if("周二".equals(weekContent)){
			week = "TUE";
		}else if("周三".equals(weekContent)){
			week = "WED";
		}else if("周四".equals(weekContent)){
			week = "THU";
		}else if("周五".equals(weekContent)){
			week = "FRI";
		}else if("周六".equals(weekContent)){
			week = "SAT";
		}else if("周日".equals(weekContent)){
			week = "SUN";
		}else{
			week = "";
		}
		
		
		
		if("每周".equals(zhouqi)){
			tb.setWdweek(week);
		}
		if("每月".equals(cycle)){
			if("月最后一天".equals(monthContent)){
				tb.setMonthLastDay("Y");
			}else{
				tb.setWdmonth(monthContent);
				tb.setMonthLastDay("N");
			}
		}
		
		if("每日".equals(cycle)||"每周".equals(cycle) ||"每月".equals(cycle)){
			tb.setWdhour(hour);
			tb.setWdminute(minute);
		}
		
		tb.setBeginDate(startDate);
		tb.setEstimateFinishDate(expectDate);
		tb.setLeaderId(leadPeopleId);
		tb.setLeaderName(leadPeopleName);
		tb.setExcutorId(excutePeopleId);
		tb.setExcutorName(excutePeopleName.substring(0,excutePeopleName.length()-1));
		tb.setOvertimeTipsTime(overDate);
		tb.setOvertimeStopDealTime(overStopDate);
		tb.setRemarks(desc);
		tb.setCrtDate(IGStringUtils.getCurrentDateTime());
		tb.setWdstatus("0");
		workDefinitionBL.registWorkDefinition(tb);
	}
	
	/**
	 * hasLeaderPower是否具有负责人权限、既查看本机构下用户工作的权限
	 * @param orgsyscoding 此角色说管理的机构码
	 * @return hasLeaderPower
	 */
	private String hasLeaderPower(String userid) {
		//是否具有负责人权限
		String orgsyscoding = "";
		for(LeaderRoleids roleid : LeaderRoleids.values()){
			Integer id = Integer.parseInt(roleid.toString().split("_")[1]);
			//是否具有查看本机构下用户的权限
			boolean tempPower = userRoleBL.isRoleInUserRole(userid, id);
			if(tempPower){
				Role roleInfo;
				try {
					roleInfo = roleBL.searchRoleByKey(id);
					orgsyscoding = roleInfo.getRoledomain();
					return orgsyscoding;
				} catch (BLException e) {
					log.error("查询角色报错roleid："+id+"---"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return orgsyscoding;
	}
	
	/**
	 * hasMostPower 查询用户是否具体最高权限，既查看所有用户的工作
	 * @param userid 用户id
	 * @return boolean
	 */
	private boolean hasMostPower(String userid) {
		//是否具有查看所有工作的最大权限
		boolean hasMostPower = userRoleBL.isRoleInUserRole(userid, IGWIMCONSTANTS.IGWIM_MOST_POWER_ROLEID);
		return hasMostPower;
	}
	
	/**
	 * @Description 查询用户是否是中心负责人以上岗位
	 * @param dto IGWIM01DTO userid:用户id
	 * @return IGWIM01DTO
	 */
	public IGWIM01DTO searchIsLeader(IGWIM01DTO dto){
		log.info("==========查询用户是否是中心负责人以上岗位开始==========");
		
		//检索用户是否有中心负责人权限
		String hasLeader = hasLeaderPower(dto.getUser().getUserid());
		//检索用户是否有科技总经理（最高）权限
		boolean isMost = hasMostPower(dto.getUser().getUserid());
		
		if(StringUtils.isNotEmpty(hasLeader) || isMost){
			//有负责人及或以上岗位权限
			dto.setIsLeader("1");
		}else{
			//普通员工
			dto.setIsLeader("0");
		}
		
		log.info("==========查询用户是否是中心负责人以上岗位结束==========");
		return dto;
	}
	
	/**
	 * 获取日期后几天的日期
	 * @param d 传入的日期
	 * @param day 增加的天数
	 * @return
	 */
	private Date getDateAfter(Date d, int day) {  
		
        Calendar now = Calendar.getInstance();  
        //设置当系统日期
        now.setTime(d);
        //系统日期+天
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
	
	/**
	 * 比较日期大小
	 * @param dt1 日期1
	 * @param dt2 日期2
	 * @return 返回1：日期1>日期2，返回-1：日期1<日期2，返回0：日期1=日期2
	 */
	private int compairDate(Date dt1,Date dt2){
		
		if(dt1.getTime() > dt2.getTime()){
			return 1;
		}else if(dt1.getTime() < dt2.getTime()){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 字符串格式转成日期
	 * @param str 字符串
	 * @return 日期
	 */
	private Date strParseDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("字符串强转成日期格式失败，要转换的字符串:"+str+"\n类：WorkRemindBLImpl，方法：strParseDate() Line：331\n"+e.getMessage());
			e.printStackTrace();
		}
		return date;
	}
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    private int daysBetween(String smdate,String bdate) throws ParseException{
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm");  
         Calendar cal = Calendar.getInstance();    
         cal.setTime(sdf.parse(smdate));    
         long time1 = cal.getTimeInMillis();                 
         cal.setTime(sdf.parse(bdate));    
         long time2 = cal.getTimeInMillis();         
         long between_days=(time2-time1)/(1000*3600*24);  
             
        return Integer.parseInt(String.valueOf(between_days));         
    }    
}
