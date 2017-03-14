/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.ProcessRecordInfo;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.dwp.bl.task.IGDWP0001BL;
import com.deliverik.infogovernor.dwp.bl.task.IGDWP0002BL;
import com.deliverik.infogovernor.dwp.bl.task.IGDWP0003BL;
import com.deliverik.infogovernor.dwp.bl.task.IGDWP0004BL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;
import com.deliverik.infogovernor.dwp.form.IGDWP0101Form;
import com.deliverik.infogovernor.dwp.form.IGDWP0103Form;
import com.deliverik.infogovernor.dwp.form.IGDWP0105Form;
import com.deliverik.infogovernor.dwp.form.IGDWP0106Form;
import com.deliverik.infogovernor.dwp.job.InformJob;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0002Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0003Info;
import com.deliverik.infogovernor.dwp.model.IGDWP0004Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0001SearchCondImpl;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0002SearchCondImpl;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0003SearchCondImpl;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0004SearchCondImpl;
import com.deliverik.infogovernor.dwp.model.entity.IGDWP0001TB;
import com.deliverik.infogovernor.dwp.model.entity.IGDWP0002TB;
import com.deliverik.infogovernor.dwp.model.entity.IGDWP0003TB;
import com.deliverik.infogovernor.dwp.model.entity.IGDWP0004TB;
import com.deliverik.infogovernor.dwp.util.IGDWPUtils;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP01BLImpl extends BaseBLImpl implements IGDWP01BL{

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGDWP01BLImpl.class);
	
	/** 日常工作计划实体BL */
	protected IGDWP0001BL igdwp0001BL;
	
	/** 日常工作计划流程信息BL */
	protected IGDWP0002BL igdwp0002BL;
	
	/** 日常工作计划表单信息BL */
	protected IGDWP0003BL igdwp0003BL;
	
	/** 日常工作计划参与人信息BL */
	protected IGDWP0004BL igdwp0004BL;
	
	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 短信发送BL */
	protected SendMessageBL sendMessageBL;
	
	/** 用户信息BL */
	protected UserBL userBL;
	
	/** 角色信息BL */
	protected RoleBL roleBL;
	
	/** 流程处理API */
	protected FlowOptBL flowOptBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/** 个人工作定义ID */
	protected String personageWork = "01084";
	/**
	 * 日常工作计划实体BL设定
	 * @param igdwp0001BL 日常工作计划实体BL
	 */
	public void setIgdwp0001BL(IGDWP0001BL igdwp0001bl) {
		igdwp0001BL = igdwp0001bl;
	}
	
	/**
	 * 日常工作计划流程信息BL设定
	 * @param igdwp0002BL 日常工作计划流程信息BL
	 */
	public void setIgdwp0002BL(IGDWP0002BL igdwp0002bl) {
		igdwp0002BL = igdwp0002bl;
	}

	/**
	 * 日常工作计划表单信息BL设定
	 * @param igdwp0003BL 日常工作计划表单信息BL
	 */
	public void setIgdwp0003BL(IGDWP0003BL igdwp0003bl) {
		igdwp0003BL = igdwp0003bl;
	}

	/**
	 * 日常工作计划参与人信息BL设定
	 * @param igdwp0004BL 日常工作计划参与人信息BL
	 */
	public void setIgdwp0004BL(IGDWP0004BL igdwp0004bl) {
		igdwp0004BL = igdwp0004bl;
	}

	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 短信发送BL设定
	 * @param sendMessageBL 短信发送BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * 用户信息BL设定
	 * @param userBL 用户信息BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 角色信息BL设定
	 * @param roleBL 角色信息BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 流程处理API设定
	 * @param flowOptBL 流程处理API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 日常工作计划查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO searchDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("===============日常工作计划查询操作开始===============");
		//实例化查询条件
		IGDWP0001SearchCondImpl cond = new IGDWP0001SearchCondImpl();
		cond.setIsAddJob(IGDWPUtils.IS_ADD_JOB_NO);
		List<IGDWP0001Info> tempList = igdwp0001BL.search(cond);
		for(IGDWP0001Info info:tempList){
			igdwp0001BL.delete(info);
		}
		cond.setIsAddJob(IGDWPUtils.IS_ADD_JOB_YES);
		//给查询条件赋值
		this.copyProperties(cond, dto.getForm());
		//查询总记录数
		int totalCount = igdwp0001BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		List<IGDWP0001Info> list = igdwp0001BL.search(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setDayWorkPlanList(list);
		log.debug("===============日常工作计划查询操作结束===============");
		return dto;
	}
	
	/**
	 * 流程类型查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO searchProcessDefinitions(IGDWP01DTO dto) throws BLException {
		log.debug("===============流程类型查询操作开始================");
		//实例化查询条件
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPrpdid_like_or(IGDWPUtils.getInstance().getProcessDefinitions().toArray(new String[0]));
		cond.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
		//查询流程定义信息
		List<IG380Info> list = workFlowDefinitionBL.searchLastProcessDefinition(cond,0,0);
		//处理流程定义数据
		Map<IG259Info, List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
		Map<Integer, IG259Info> templateMap = new HashMap<Integer, IG259Info>();
		for(IG380Info info:list){
			if(templateMap.get(info.getPtid()) == null){
				IG259Info template = workFlowDefinitionBL.searchProcessTemplateByKey(info.getPtid());
				templateMap.put(template.getPtid(), template);
				map.put(template, new ArrayList<IG380Info>());
			}
			IG259Info key = templateMap.get(info.getPtid());
			map.get(key).add(info);
		}
		dto.setProcessDefinitionMap(map);
		log.debug("===============流程类型查询操作结束================");
		return dto;
	}
	
	/**
	 * 初始化日常工作计划操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("================日常工作计划信息初始化操作开始=================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0103Form){
			//参数取得
			IGDWP0103Form form = (IGDWP0103Form) dto.getForm();
			if(form.getId() != null && form.getId() > 0){
				//工作计划查询
				IGDWP0001Info info = igdwp0001BL.searchByPk(form.getId());
				this.copyProperties(form, info);
			}else{
				form.setPtype(IGDWPUtils.TASK_EXECUTE_TYPE_DAY);
				//==========该段为齐鲁定制逻辑start============
				if(StringUtils.isNotEmpty(form.getPdid())){
					IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
			        condImpl.setPdid_like(form.getPdid());
			        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
			        List<IG380Info> list = workFlowDefinitionBL.searchProcessDefinition(condImpl);
			        if (list.size() == 0) {
			            //throw new BLException("IGCO10000.E027", dto.getPdid());
			        } else {
			        	IG380Info pd = list.get(list.size() - 1);
			        	form.setPdid(pd.getPdid());
			        	form.setPdname(pd.getPdname());
			        }
				}
				//==========该段为齐鲁定制逻辑end==============
			}
		}
		log.debug("================日常工作计划信息初始化操作结束=================");
		return dto;
	}
	
	/**
	 * 新增日常工作计划
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO insertDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("==============日常工作计划新增操作开始===============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0103Form){
			//参数取得
			IGDWP0103Form form = (IGDWP0103Form) dto.getForm();
			//登录用户取得
			User user = dto.getUser();
			//实例化实体
			IGDWP0001TB entity = new IGDWP0001TB();
			this.copyProperties(entity, form);
			entity.setPuserid(user.getUserid());
			entity.setPusername(user.getUsername());
			entity.setIsAddJob(IGDWPUtils.IS_ADD_JOB_NO);
			IGDWP0001Info info = igdwp0001BL.regist(entity);
			//如果是短信方式，设置短信策略
			if(IGDWPUtils.TASK_MODE_SMS.equals(form.getPmode())){
				if(entity.getPdid().startsWith(personageWork)){
					setStrategy(info);
				}else{
					dto.setAssignFlag(IGDWPUtils.ASSIGN_FLAG_YES);
				}
			}
			form.setId(info.getId());
		}
		log.debug("==============日常工作计划新增操作结束===============");
		return dto;
	}
	
	/**
	 * 设置策略
	 * @param plan 计划信息实体
	 */
	private void setStrategy(IGDWP0001Info plan) throws BLException{
		//获取表达式
		String cronExpression = creatCronExp(plan.getPtype(), plan.getStartdate(), plan.getEnddate(), plan.getPhour(), plan.getPminute());
		String jobName = "DayWorkPlanJob" + plan.getId();
		String jobGroupName = "DayWorkPlanGroup" + plan.getId();
		String triggerName = "DayWorkPlanTrigger" + plan.getId();
		String triggerGroupName = "DayWorkPlanTriggerGroup" + plan.getId();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			IGDWP0001TB tb = (IGDWP0001TB)SerializationUtils.clone(plan);
			//若计划没有结束时间，则取计划开始时间为结束时间
			if(StringUtils.isEmpty(plan.getStartdate())){
				throw new RuntimeException("计划未设置开始时间！");
			}else{
				if(StringUtils.isEmpty(plan.getEnddate()) || "".equals(plan.getEnddate())){
					tb.setEnddate(plan.getStartdate());
				}
			}
			
			Date beganDate = format.parse(tb.getStartdate());
 			Date endDate = format.parse(tb.getEnddate());
			Map<String,Integer> args = new HashMap<String, Integer>();
		    args.put("id", plan.getId());
		    List<String> keyname = new ArrayList<String>();
		    keyname.add("id");
		    if(IGDWPUtils.TASK_EXECUTE_TYPE_ONCE.equals(plan.getPtype())){
		    	JobManager.addJob(jobName, jobGroupName,triggerName, triggerGroupName, new InformJob(),
		    			keyname, args, cronExpression);
		    }else{
		    	JobManager.addJob(jobName,jobGroupName,triggerName,triggerGroupName, new InformJob(),
		    			keyname, args,cronExpression, beganDate,endDate);
		    }
			//更新计划信息
			tb.setIsAddJob(IGDWPUtils.IS_ADD_JOB_YES);
			igdwp0001BL.update(tb);
		} catch (Exception e) {
			log.error("==========Exception form DayWorkPlanInformJob===========");
			log.error("quarz报错", e);
			throw new BLException("IGCO10000.E141", "quarz报错！");
		}
	}
	
	/**
	 * 删除策略
	 * @param plan 策略信息
	 */
	public void deleteStrategy(IGDWP0001Info plan){
		//删除JOB
		String jobName = "DayWorkPlanJob" + plan.getId();
		String jobGroupName = "DayWorkPlanGroup" + plan.getId();
		String triggerName = "DayWorkPlanTrigger" + plan.getId();
		String triggerGroupName = "DayWorkPlanTriggerGroup" + plan.getId();
		try {
			if(JobManager.isJobAdded(jobName, jobGroupName)){
				JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
			}
		} catch (Exception e) {
			log.error("",e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取quartz执行表达式
	 * @param ptype 执行周期类型
	 * @param startdate 开始时间
	 * @param enddate 结束时间
	 * @param hour 时
	 * @param minute 分
	 * @return quartz执行表达式
	 */
	private String creatCronExp(String ptype, String startdate,String enddate,
			String hour, String minute){
		//quartz执行表达式
		String retCronExp = null;
		//秒 分 时 日 月 周
		if (IGDWPUtils.TASK_EXECUTE_TYPE_WEEK.equals(ptype)) {
			String week = getWeekOfDate(startdate, "en");
			retCronExp = "0 " + minute + " " + hour + " ? * " + week;
		} else if (IGDWPUtils.TASK_EXECUTE_TYPE_MONTH.equals(ptype)){
			String day = startdate.split("/")[2];
			retCronExp = "0 " + minute + " " + hour + " " + day + " * ?";
		} else if (IGDWPUtils.TASK_EXECUTE_TYPE_ONCE.equals(ptype)){
			String day = startdate.split("/")[2];
			String month = startdate.split("/")[1];
			String year = startdate.split("/")[0];
			retCronExp = "0 " + minute + " " + hour + " " + day + " " + month + " ? " + year;
		} else if (IGDWPUtils.TASK_EXECUTE_TYPE_DAY.equals(ptype)){
			retCronExp = "0 " + minute + " " + hour + " * * ?";
		} else if (IGDWPUtils.TASK_EXECUTE_TYPE_QUARTER.equals(ptype)){
			String day = startdate.split("/")[2];
			String month = startdate.split("/")[1];
			retCronExp = "0 " + minute + " " + hour + " " + day + " " + month + "/3 ?";
		}
		log.debug(retCronExp);
		return retCronExp;
	}
	
	/**
	 * 取得指定日期是星期几
	 * @param strDate 日期
	 * @param language 语言格式(默认中文，en：为英文)
	 * @return 星期几
	 */
	private String getWeekOfDate(String strDate,String language) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String[] engWeekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Calendar cal = Calendar.getInstance();
        try {
			cal.setTime(sdf.parse(strDate));
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        if("en".equals(language)){
        	return engWeekDays[w];
        }
        return weekDays[w];
    }

	/**
	 * 日常工作计划修改操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO changeDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("==============日常工作计划修改操作开始==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0103Form){
			IGDWP0103Form form = (IGDWP0103Form) dto.getForm();
			//查询计划信息
			IGDWP0001TB planTB = (IGDWP0001TB) igdwp0001BL.searchByPk(form.getId());
			this.copyProperties(planTB, form);
			IGDWP0001Info plan = igdwp0001BL.update(planTB);
			//重新添加quartz
			deleteStrategy(plan);
			setStrategy(plan);
		}
		log.debug("==============日常工作计划修改操作结束==============");
		return dto;
	}
	
	/**
	 * 策略执行
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO execute(IGDWP01DTO dto) throws BLException {
		log.debug("=============策略执行操作开始==============");
		//取得计划信息
		IGDWP0001Info plan = igdwp0001BL.searchByPk(dto.getId());
		//通知类策略执行
		if(IGDWPUtils.TASK_MODE_SMS.equals(plan.getPmode())){
			sendMessage(plan);
		}else{
			launchProcess(plan);
		}
		log.debug("=============策略执行操作结束==============");
		return dto;
	}

	/**
	 * 发起流程
	 * @param plan 计划信息
	 */
	private void launchProcess(IGDWP0001Info plan) throws BLException{
		//开始时间
		String planStartPidid= plan.getPdid()+"002";
 		//结束时间
		String planEndPidid  = plan.getPdid()+"016";
		//查询要发起的流程
		IGDWP0002SearchCondImpl cond = new IGDWP0002SearchCondImpl();
		cond.setPlanid(plan.getId());
		List<IGDWP0002Info> prList = igdwp0002BL.search(cond);
		for(IGDWP0002Info info:prList){
			//实例化日志信息
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setExecutorid(plan.getPuserid());
			logInfo.setExecutorRoleid(info.getPrroleid());
			//实例化流程信息
			ProcessRecord record = new ProcessRecord(logInfo);
			record.setDefid(plan.getPdid());
			record.setTitle(info.getPrtitle());
			record.setDescription(info.getPrdesc());
			record.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
			Map<String, String> map = new HashMap<String, String>();
			List<IG007Info> pidList = workFlowOperationBL.getProcessInfoDefs(plan.getPdid());
			Map<String, IG007Info> pidMap = new HashMap<String, IG007Info>();
			for(IG007Info pid:pidList){
				pidMap.put(pid.getPidid(), pid);
			}
			Map<String, IGDWP0003Info> entityMap = new HashMap<String, IGDWP0003Info>();
			//查询表单值
			IGDWP0003SearchCondImpl picond = new IGDWP0003SearchCondImpl();
			picond.setPrid(info.getId());
			List<IGDWP0003Info> piList = igdwp0003BL.search(picond);
			for(IGDWP0003Info pi:piList){
				IG007Info pid = pidMap.get(pi.getPidid());
				if("4".equals(pid.getPidtype())){
					if(StringUtils.isNotEmpty(pi.getPivarvalue())){
						map.put(pid.getPidname(), "N/A");
						entityMap.put(pi.getPidid(), pi);
					}
				}else{
//					if(pi.getPidid().equals(changePidid)){
//						if(StringUtils.isNotEmpty(pi.getPivarvalue())){
//							changeType = pi.getPivarvalue().split("_tree_")[1];
//						}
//					}
//					if(pi.getPidid().equals(planStartPidid) || pi.getPidid().equals(planEndPidid)){
//						//计划开始时间
//						//取出来表单  然后给表单赋值
//						map.put(pid.getPidname(), "");
//					}else{
						//取出来表单  然后给表单赋值
						map.put(pid.getPidname(), pi.getPivarvalue());
//					}
				}
			}
			record.setFormvalue(map);
			Integer prid = saveProcess(record,IGPRDCONSTANTS.BUTTON_UPDATE);
			logInfo.setPrid(prid);
			if(entityMap.size() > 0){
				//保存资产信息
				IG599SearchCondImpl pivcond = new IG599SearchCondImpl();
				pivcond.setPrid(prid);
				pivcond.setPivartype("4");
				pivcond.setPivarvalue("N/A");
				List<IG599Info> list = workFlowOperationBL.searchProcessInfoByCond(pivcond);
				for(IG599Info pi:list){
					IGDWP0003Info piInfo = entityMap.get(pi.getPidid());
					if(piInfo != null && StringUtils.isNotEmpty(piInfo.getPivarvalue())){
						for(String eiid : piInfo.getPivarvalue().split("#")){
							IG731TB pieTB = new IG731TB();
							pieTB.setEiversion(0);
							pieTB.setEiid(Integer.parseInt(eiid));
							pieTB.setPiid(pi.getPiid());
							pieTB.setPrid(prid);
							workFlowOperationBL.saveProcessInfoEntity(pieTB);
						}
					}
				}
			}
			//查询被分派节点
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(plan.getPdid() + "001", IGPRDCONSTANTS.BUTTON_SUBMIT);
			if(!lst_ProcessStatusDef.isEmpty()){
//				flowOptBL.transitionProcess(prid, plan.getPuserid(), "提交", IGStringUtils.getCurrentDateTime());
				//查询被分派人信息
				IGDWP0004SearchCondImpl assignInfoCond = new IGDWP0004SearchCondImpl();
				assignInfoCond.setPlanid(plan.getId());
				assignInfoCond.setPrid(info.getId());
				List<IGDWP0004Info> assignInfoList = igdwp0004BL.search(assignInfoCond);
				Map<String, List<IGDWP0004Info>> assignMap = new HashMap<String, List<IGDWP0004Info>>();
				for(IGDWP0004Info assign:assignInfoList){
					if(assignMap.get(assign.getPsdid()) == null){
						assignMap.put(assign.getPsdid(), new ArrayList<IGDWP0004Info>());
					}
					assignMap.get(assign.getPsdid()).add(assign);
				}
				StatusParticipant participant = new StatusParticipant(logInfo);
				for(IG333Info psd:lst_ProcessStatusDef){
					participant.setStatuscode(psd.getPsdid());
					List<IGDWP0004Info> list = assignMap.get(psd.getPsdid());
					if(list != null){
						for(IGDWP0004Info assign:list){
							participant.setRoleid(assign.getRoleid());
							participant.setUserid(assign.getUserid());
							flowSetBL.setStatusParticipant(participant);
						}
					}
				}
			}
			
			if(StringUtils.isNotEmpty(prid+"")){
				//如果流程ID 不为空 且没有发生异常 那么流程发起了
				//需要进行短信通知
				
				this.sendMessageBL.sendSmsToUser(plan.getPuserid(), plan.getPusername()+"您有"+info.getPrtitle()+"的工作待处理!");
			}
			
		}
	}
		
	/**
	 * 
	 * 流程发起
	 * 
	 * @param processRecordInfo 流程发起信息
	 * @param action 操作动作
	 * @return 流程ID
	 * @throws BLException
	 */
	private Integer saveProcess(ProcessRecordInfo processRecordInfo,String action) throws BLException{
		User user = userBL.searchUserByKey(processRecordInfo.getLogInfo().getExecutorid());
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(processRecordInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(processRecordInfo.getLogInfo().getAuthuserid());
		}
		//发起者角色
		Role role = roleBL.searchRoleByKey(processRecordInfo.getLogInfo().getExecutorRoleid());
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(processRecordInfo.getDefid());
		cond.setPdstatus(processRecordInfo.getDefstatus());
		List<IG380Info> lst_ProcessDefinition = workFlowDefinitionBL.searchProcessDefinition(cond);
		if(lst_ProcessDefinition.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "流程定义ID（" + processRecordInfo.getDefid() + "）");
		} else {
			IG259Info processTemplate = workFlowDefinitionBL.searchProcessTemplateByKey(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPtid());
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());
			psdCond.setPsdcode(Constants.PROCESS_STATUS_START);
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "发起状态");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "发起状态");
			} else {
				List<IG599Info> prInfoList = new ArrayList<IG599Info>();
				//查询流程表单定义信息
				List<IG007Info> processInfoDefList  = workFlowOperationBL.getProcessInfoDefs(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());
				if(processInfoDefList != null){
					Map<String, String> formvalue = processRecordInfo.getFormvalue();
					if(formvalue == null){
						formvalue = new HashMap<String, String>();
					}
					IG599TB prInfo = null;
					for(IG007Info processInfoDef:processInfoDefList){
						String value = formvalue.get(processInfoDef.getPidname());
						prInfo = workFlowOperationBL.getProcessInfoTBInstance();
						prInfo.setPivarlabel(processInfoDef.getPidlabel());
						prInfo.setPivarname(processInfoDef.getPidname());
						prInfo.setPivartype(processInfoDef.getPidtype());
						prInfo.setPivarvalue(value);
						prInfo.setPidid(processInfoDef.getPidid());
						prInfo.setPidmode(processInfoDef.getPidmode());
						prInfo.setPrivatescope(processInfoDef.getPrivatescope());
						prInfo.setPidaccess("3");//可写
						prInfoList.add(prInfo);
					}
				}
				IG500TB instance = workFlowOperationBL.getProcessRecordTBInstance();
				instance.setPrpdid(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());//流程定义ID
				instance.setPrpdname(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdname());//流程定义名称
				instance.setPrtitle(processRecordInfo.getTitle());//流程标题
				instance.setPrdesc(processRecordInfo.getDescription());//流程描述
				instance.setPrtype(processTemplate.getPttype());//流程类型
				instance.setPrinfo(user.getUsermobile());//流程发起者联系方式
				instance.setPruserid(user.getUserid());//流程发起者ID
				instance.setPrusername(user.getUsername());//流程发起者姓名
				instance.setPrroleid(role.getRoleid());//流程发起者角色ID
				instance.setPrrolename(role.getRolename());//流程发起者角色名称
				instance.setProrgid(user.getOrgid());//流程发起者机构层次码
				instance.setProrgname(user.getOrgname());//流程发起者机构名称
				//是否测试流程
				if(IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdstatus())){
					instance.setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
				}
				IG500Info processRecord = workFlowOperationBL.launchProcess(instance, user,
						processRecordInfo.getLogInfo().getExecutorRoleid(),
						null, null, processTemplate.getPttype(), prInfoList, processRecordInfo.getLogInfo().getComment(),
						lst_ProcessStatusDef.get(lst_ProcessDefinition.size() - 1).getPsdid(), action, null, authorizeuser,null,null,new HashMap<String, List<IG506TB>>(),null,null);
				log.debug(">>>调用流程发起处理结束，返回流程ID：" + processRecord.getPrid());
				return processRecord.getPrid();
			}
		}
		
	}
	/**
	 * 发送短信
	 * @param plan 计划信息实体
	 */
	private void sendMessage(IGDWP0001Info plan) {
		//取得短信发送内容
		String content = plan.getSmscontent();
		//==========该段为齐鲁定制逻辑===========
		//个人工作短信发给指定策略的人
		if(plan.getPdid().startsWith(personageWork)){
			this.sendMessageBL.sendSmsToUser(plan.getPuserid(), content);
		}else{
			IGDWP0004SearchCondImpl cond = new IGDWP0004SearchCondImpl();
			cond.setPlanid(plan.getId());
			List<IGDWP0004Info> list = igdwp0004BL.search(cond);
			for(IGDWP0004Info info:list){
				if((plan.getPdid() + "001").equals(info.getPsdid())){
					this.sendMessageBL.sendSmsToUser(info.getUserid(), content);
				}
			}
		}
		//发送短信
		//==========该段为齐鲁定制逻辑===========
	}
	
	/**
	 * 加载流程定义信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initProcessDefinitionAction(IGDWP01DTO dto) throws BLException {
		log.debug("=============加载流程定义信息操作开始================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0105Form){
			//登录用户取得
			User user = dto.getUser();
			//参数取得
			IGDWP0105Form form = (IGDWP0105Form) dto.getForm();
			//查询计划信息
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getId());
			dto.setPlan(plan);
			//查询流程定义信息
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(plan.getPdid());
			dto.setProcessDefinition(pd);
			//获取发起角色
			List<LabelValueBean> roleList = this.workFlowDefinitionBL.searchInitProcessParticipantRole(user.getUserid(), pd.getPdid());
			if(roleList.isEmpty()) {
				throw new BLException("IGCO10000.E004","发起角色基本");
			}
			if(StringUtils.isEmpty(form.getPrinfo())){
				form.setPrinfo(user.getUsermobile());
			}
			if(form.getPrroleid() == null || form.getPrroleid() == 0){
				form.setPrroleid(Integer.valueOf(roleList.get(0).getValue()));
			}
			dto.setLabelValueBeanList(roleList);
			//查询标题定义信息
			IG243SearchCondImpl titlecond = new IG243SearchCondImpl();
			titlecond.setPdid(pd.getPdid());
			List<IG243Info> lstProcessTitleDef = workFlowDefinitionBL.searchProcessTitleDef(titlecond);
			dto.setPtdInfo(lstProcessTitleDef.get(0));
			//查询表单权限
			String psdid = pd.getPdid() + "001";
			//查询状态定义信息
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
			dto.setProcessStatusDef(psd);
			List<IG893Info> participantVariableVW = workFlowOperationBL.searchParticipantVariableVW(psdid,form.getPrroleid());
			Map<String, IG893Info> participantVariableMap = new HashMap<String, IG893Info>();
			for(IG893Info info:participantVariableVW){
				participantVariableMap.put(info.getPidid(), info);
			}
			//查询表单定义信息
			List<IG007Info> pidList = workFlowOperationBL.getProcessInfoDefs(pd.getPdid());
			List<IG007Info> processInfoList = new ArrayList<IG007Info>();
			for(IG007Info info:pidList){
				IG893Info variable = participantVariableMap.get(info.getPidid());
				if(variable != null){
					if(IGPRDCONSTANTS.PROCESSTITLE_HIDE.compareTo(variable.getPidaccess()) < 0){
						IG007TB tb = (IG007TB) info;
						tb.setPidaccess(variable.getPidaccess());
						tb.setPidrequired(variable.getPidrequired());
						processInfoList.add(tb);
					}
				}
			}
			form.setPivarvalue(new String[pidList.size()]);
			dto.setProcessInfoList(processInfoList);
		}
		log.debug("=============加载流程定义信息操作结束================");
		return dto;
	}
	
	/**
	 * 策略流程登记操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO craeteProcessAction(IGDWP01DTO dto) throws BLException {
		log.debug("===============策略流程登记操作开始==================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0105Form){
			//参数取得
			IGDWP0105Form form = (IGDWP0105Form) dto.getForm();
			//查询计划信息
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getId());
			//实例化流程信息实体
			IGDWP0002TB prTB = new IGDWP0002TB();
			this.copyProperties(prTB, form);
			prTB.setId(null);
			prTB.setPlanid(form.getId());
			//新增流程实体信息
			IGDWP0002Info pr = igdwp0002BL.regist(prTB);
			dto.setProcess(pr);
			//处理资产信息
			Map<String, List<String>> entityMap = new HashMap<String, List<String>>();
			for(Iterator<Entry<Integer, String>> iter = form.getEntityMap().entrySet().iterator();iter.hasNext();){
				Entry<Integer, String> next = iter.next();
				String[] split = next.getValue().split("#");
				if(entityMap.get(split[0]) == null){
					entityMap.put(split[0],new ArrayList<String>());
				}
				entityMap.get(split[0]).add(split[1]);
			}
			//记录表单值
			if(form.getPivarvalue() != null && form.getPivarvalue().length > 0){
				for(int i=0;i<form.getPivarvalue().length;i++){
					IGDWP0003TB prInfoTB = new IGDWP0003TB();
					prInfoTB.setPidid(form.getPidid()[i]);
					prInfoTB.setPrid(pr.getId());
					prInfoTB.setPivarvalue(form.getPivarvalue()[i]);
					if(entityMap.get(form.getPidid()[i]) != null){
						int index = 0;
						StringBuffer value = new StringBuffer();
						for(String eiid:entityMap.get(form.getPidid()[i])){
							if(index > 0){
								value.append("#");
							}else{
								index ++;
							}
							value.append(eiid);
						}
						prInfoTB.setPivarvalue(value.toString());
					}
					igdwp0003BL.regist(prInfoTB);
					/**
					 * 暂时一种屮蛋的改法
					 */
					//TODO
					if(form.getPidid().length==(i+1)){
						break;
					}
				}
			}
			//查询是否需要分派
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(plan.getPdid() + "001", IGPRDCONSTANTS.BUTTON_SUBMIT);
			if(!lst_ProcessStatusDef.isEmpty()){
				dto.setAssignFlag(IGDWPUtils.ASSIGN_FLAG_YES);
			}else{
				setStrategy(plan);
			}
		}
		log.debug("===============策略流程登记操作结束==================");
		return dto;
	}
	
	/**
	 * 日常工作计划分派页初始化操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initDayWorkPlanAssignAction(IGDWP01DTO dto) throws BLException {
		log.debug("============日常工作计划分派页初始化操作开始==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0106Form){
			//页面参数
			IGDWP0106Form form = (IGDWP0106Form) dto.getForm();
			//查询计划信息
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getPlanid());
			Map<IG333Info,Map<Role, List<UserInfo>>> map = new LinkedHashMap<IG333Info, Map<Role,List<UserInfo>>>();
			if(IGDWPUtils.TASK_MODE_SMS.equals(plan.getPmode())){
				IG333TB psd = new IG333TB();
				psd.setPsdid(plan.getPdid() + "001");
				psd.setPsdname("接收人员");
				psd.setAssignflag("1");
				Map<Role, List<UserInfo>> roleMap = new LinkedHashMap<Role, List<UserInfo>>();
				IG213SearchCondImpl prtcond = new IG213SearchCondImpl();
				prtcond.setPdid(plan.getPdid());
				List<IG213Info> list = workFlowDefinitionBL.searchProcessRoleTypeDef(prtcond);
				String[] roleids = new String[list.size()];
				for(int i=0;i<list.size();i++){
					roleids[i] = list.get(i).getRoletype();
				}
				RoleSearchCondImpl cond = new RoleSearchCondImpl();
				cond.setRoletype(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
				cond.setRoletypeEqual(2);
				cond.setRoles_BP_EX(roleids);
				cond.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
				List<Role> roleList = roleBL.searchRole(cond, 0, 0);
				UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
				for(Role role:roleList){
					userInfoCond.setRoleida(role.getRoleid());
					List<UserInfo> userList = userBL.searchUserInfo(userInfoCond);
					if(userList.size() > 0){
						roleMap.put(role, userList);
					}
				}
				map.put(psd, roleMap);
			}else{
				//查询被分派节点
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(plan.getPdid() + "001", IGPRDCONSTANTS.BUTTON_SUBMIT);
				UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
				for(IG333Info psd:lst_ProcessStatusDef){
					Map<Role, List<UserInfo>> roleMap = new LinkedHashMap<Role, List<UserInfo>>();
					//查询可被分派角色
					List<IG298Info> lst_ProcessStatusRoleDef = workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
					for(IG298Info psrd:lst_ProcessStatusRoleDef){
						userInfoCond.setRoleida(psrd.getRoleid());
						if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
							userInfoCond.setOrgida(dto.getUser().getOrgid());
						}
						List<UserInfo> userList = userBL.searchUserInfo(userInfoCond);
						if(userList.size() > 0){
							roleMap.put(psrd.getRole(), userList);
						}
					}
					map.put(psd, roleMap);
				}
			}
			dto.setAssignInfoMap(map);
		}
		log.debug("============日常工作计划分派页初始化操作结束==============");
		return dto;
	}
	
	/**
	 * 保存分派信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO saveAssignAction(IGDWP01DTO dto) throws BLException {
		log.debug("==============保存分派信息操作开始===============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0106Form){
			//页面信息
			IGDWP0106Form form = (IGDWP0106Form) dto.getForm();
			if(form.getParticipants() != null && form.getParticipants().length > 0){
				for(String info:form.getParticipants()){
					String[] split = info.split("_");
					String psdid = split[0];
					Integer roleid = Integer.valueOf(split[1]);
					String userid = split[2];
					IGDWP0004TB tb = new IGDWP0004TB();
					tb.setPlanid(form.getPlanid());
					if(form.getPrid() != null && form.getPrid() > 0){
						tb.setPrid(form.getPrid());
					}
					tb.setPsdid(psdid);
					tb.setUserid(userid);
					tb.setRoleid(roleid);
					igdwp0004BL.regist(tb);
				}
			}
			//查询计划信息
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getPlanid());
			//设置策略
			setStrategy(plan);
		}
		log.debug("==============保存分派信息操作结束===============");
		return dto;
	}
	
	/**
	 * 日常工作计划删除操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO deleteDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("============日常工作计划删除操作开始=============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0101Form){
			//页面参数取得
			IGDWP0101Form form = (IGDWP0101Form) dto.getForm();
			//查询计划信息
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getPlanid());
			//删除JOB
			deleteStrategy(plan);
			//删除计划信息
			igdwp0001BL.delete(plan);
		}
		log.debug("============日常工作计划删除操作结束=============");
		return dto;
	}
	
	/**
	 * 编辑日常工作计划初始化操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO editDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("=============编辑日常工作计划初始化操作开始================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0103Form){
			//参数取得
			IGDWP0103Form form = (IGDWP0103Form) dto.getForm();
			//工作计划查询
			IGDWP0001Info igdwp0001info = igdwp0001BL.searchByPk(form.getId());
			this.copyProperties(form, igdwp0001info);
			
			IGDWP0002SearchCondImpl igdwp0002Cond = new IGDWP0002SearchCondImpl();
			igdwp0002Cond.setPlanid(igdwp0001info.getId());
			List<IGDWP0002Info> prList = igdwp0002BL.search(igdwp0002Cond);
			
			IGDWP0003SearchCondImpl igdwp0003Cond =  new IGDWP0003SearchCondImpl();
			if(null != prList && prList.size() > 0){
				igdwp0003Cond.setPrid(prList.get(0).getId());
			}
			List<IGDWP0003Info> igdwp0003List = igdwp0003BL.search(igdwp0003Cond);
			if(null != prList && prList.size() > 0){
				form.setPrtitle(prList.get(0).getPrtitle());
				form.setPrdesc(prList.get(0).getPrdesc());
			}
			
			//登录用户取得
			User user = dto.getUser();
			//查询流程定义信息
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(igdwp0001info.getPdid());
			dto.setProcessDefinition(pd);
			//如何发起类型是短信则不查询流程信息
			if("0".equals(form.getPmode())){
				return dto;
			}
			//获取发起角色
			List<LabelValueBean> roleList = this.workFlowDefinitionBL.searchInitProcessParticipantRole(user.getUserid(), pd.getPdid());
			if(roleList.isEmpty()) {
				throw new BLException("IGCO10000.E004","发起角色基本");
			}
			if(StringUtils.isEmpty(form.getPrinfo())){
				form.setPrinfo(user.getUsermobile());
			}
			if(form.getPrroleid() == null || form.getPrroleid() == 0){
				form.setPrroleid(Integer.valueOf(roleList.get(0).getValue()));
			}
			dto.setLabelValueBeanList(roleList);
			
			//查询标题定义信息
			IG243SearchCondImpl titlecond = new IG243SearchCondImpl();
			titlecond.setPdid(pd.getPdid());
			List<IG243Info> lstProcessTitleDef = workFlowDefinitionBL.searchProcessTitleDef(titlecond);
			dto.setPtdInfo(lstProcessTitleDef.get(0));
			//查询表单权限
			String psdid = pd.getPdid() + "001";
			//查询状态定义信息
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
			dto.setProcessStatusDef(psd);
			List<IG893Info> participantVariableVW = workFlowOperationBL.searchParticipantVariableVW(psdid,form.getPrroleid());
			Map<String, IG893Info> participantVariableMap = new HashMap<String, IG893Info>();
			for(IG893Info info:participantVariableVW){
				participantVariableMap.put(info.getPidid(), info);
			}
			//查询表单定义信息
			List<IG007Info> pidList = workFlowOperationBL.getProcessInfoDefs(pd.getPdid());
			List<IG007Info> processInfoList = new ArrayList<IG007Info>();
			for(IG007Info info:pidList){
				IG893Info variable = participantVariableMap.get(info.getPidid());
				if(variable != null){
					if(IGPRDCONSTANTS.PROCESSTITLE_HIDE.compareTo(variable.getPidaccess()) < 0){
						IG007TB tb = (IG007TB) info;
						// 只读
						String pidaccess = "2";
						if("1".equals(variable.getPidaccess())){
							pidaccess = variable.getPidaccess();
						}
						tb.setPidaccess(pidaccess);
						tb.setPidrequired(variable.getPidrequired());
						for (IGDWP0003Info igdwp0003Info : igdwp0003List) {
							if(variable.getPidid().equals(igdwp0003Info.getPidid())){
								tb.setPidvalue(igdwp0003Info.getPivarvalue());
							}
						}
						processInfoList.add(tb);
					}
				}
			}
			form.setPivarvalue(new String[pidList.size()]);
			dto.setProcessInfoList(processInfoList);
		}
		log.debug("=============编辑日常工作计划初始化操作结束================");
		return dto;
	}
}