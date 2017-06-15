package com.deliverik.infogovernor.scheduling.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BLType;
import com.deliverik.infogovernor.mtp.bl.task.QuartzJobDetailsBL;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCondImpl;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessInfoBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessInfoEntityBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessParticipantBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessRecordBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH02DTO;
import com.deliverik.infogovernor.scheduling.dto.IGSCH03DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0201Form;
import com.deliverik.infogovernor.scheduling.form.IGSCH0202Form;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.scheduling.jobs.PersonTimerJob;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzJobsTB;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzProcessInfoTB;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzProcessParticipantTB;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM13BL;

public class IGSCH02BLImpl extends BaseBLImpl implements IGSCH02BL {
	
	static Log log = LogFactory.getLog(IGSCH02BLImpl.class);

	private QuartzJobsBL quartzJobsBL;
	private QuartzProcessRecordBL quartzProcessRecordBL;
	private QuartzProcessParticipantBL quartzProcessParticipantBL;
	private QuartzProcessInfoBL quartzProcessInfoBL;
	
	private IG500BL ig500BL;
	private IG337BL ig337BL;
	private IG599BL ig599BL;
	private IGCIM13BL igcim13BL;

	private IG036BL ig036BL;
	
	private SendMessageBL sendMessageBL;
	
	/**流程模板操作*/
	protected IG259BL ig259BL;
	
	/**流程定义操作*/
	protected IG380BL ig380BL;
	
	protected IG007BL ig007BL;
	
	/**流程操作*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	protected IG731BL ig731BL;
	
	protected QuartzProcessInfoEntityBL quartzProcessInfoEntityBL;
	/**日常运维计划信息处理BL*/
	protected QuartzJobDetailsBL quartzJobDetailsBL;
	
	/**用户BL*/
	protected UserBL userBL;
		
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	public void setQuartzJobDetailsBL(QuartzJobDetailsBL quartzJobDetailsBL) {
		this.quartzJobDetailsBL = quartzJobDetailsBL;
	}

	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	public void setQuartzProcessInfoBL(QuartzProcessInfoBL quartzProcessInfoBL) {
		this.quartzProcessInfoBL = quartzProcessInfoBL;
	}

	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	/**
	 * 设置流程模板操作
	 * @param ig259BL ProcessTemplateBL
	 */
	
	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	/**
	 * 设置流程定义操作
	 * @param ig380BL ig380BL
	 */
	
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}
	

	public void setIg036BL(IG036BL ig036BL) {
		this.ig036BL = ig036BL;
	}

	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	public void setIg337BL(IG337BL ig337BL) {
		this.ig337BL = ig337BL;
	}

	public void setQuartzProcessRecordBL(QuartzProcessRecordBL quartzProcessRecordBL) {
		this.quartzProcessRecordBL = quartzProcessRecordBL;
	}
	
	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}
	
	public void setQuartzProcessParticipantBL(QuartzProcessParticipantBL quartzProcessParticipantBL) {
		this.quartzProcessParticipantBL = quartzProcessParticipantBL;
	}

	public QuartzJobsBL getQuartzJobsBL() {
		return quartzJobsBL;
	}
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	public void setIg731BL(IG731BL ig731BL) {
		this.ig731BL = ig731BL;
	}

	public void setQuartzProcessInfoEntityBL(
			QuartzProcessInfoEntityBL quartzProcessInfoEntityBL) {
		this.quartzProcessInfoEntityBL = quartzProcessInfoEntityBL;
	}

	public void saveQuartzJobs(IGSCH02DTO dto) throws BLException {  //短信
		log.debug("========保存短信提醒处理开始========");
		QuartzJobsTB quartzJobsTB = new QuartzJobsTB();
		quartzJobsTB.clone(dto.getQuartzJobs());
		quartzJobsTB.setQjtriname("trigger" + System.currentTimeMillis());
		quartzJobsTB.setQjtrigrp("triggerGroup" + System.currentTimeMillis());
		
		IGSCH0201Form form = dto.getIgsch0201Form();
		String periodType = form.getPeriodType();
		String CustomDate = form.getCustomDate();
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		String startDate = form.getQjcrttime();
		String periodInfo = this.getPeriodInfo(periodType, CustomDate, exeHour, exeMinute,startDate);
		
		quartzJobsTB.setQjperiodinfo(periodInfo);
		QuartzJobs quartzJobs = quartzJobsBL.saveQuartzJobs(quartzJobsTB);
		
		PersonTimerJob personTimerJob = new PersonTimerJob();
		String jobName = "Job" + quartzJobs.getQjid();
		String jobGroupName = "Group" + quartzJobs.getQjid();
		String cronExpression = quartzJobs.getQjtricron();
		String creatTime = quartzJobs.getQjcrttime();
		String endTime = quartzJobs.getQjendtime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date beganDate = null;
		Date endDate = null;
		log.debug(cronExpression);
		try {
			if(null != endTime && !"".equals(endTime)){
				beganDate = format.parse(creatTime);
				endDate = format.parse(endTime);
				JobManager.addJob(jobName, jobGroupName, quartzJobs.getQjtriname(), 
						quartzJobs.getQjtrigrp(), personTimerJob, cronExpression, beganDate, endDate);
			} else {
				JobManager.addJob(jobName, jobGroupName, quartzJobs.getQjtriname(), 
						quartzJobs.getQjtrigrp(), personTimerJob, cronExpression);
			}
		} catch (SchedulerException e) {
			log.error("定时器无法执行");
			throw new BLException("","SchedulerException");
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
		dto.addMessage(new ActionMessage("IGSCH0202.I001", "短信提醒基本信息"));
		log.debug("========保存短信提醒处理终了========");
		
	}

	public void saveQuartzWorkAction(IGSCH02DTO dto) throws BLException {  //工作
		log.debug("========保存个人工作处理终了========");
		QuartzProcessRecord quartzProcessRecord = quartzProcessRecordBL.saveQuartzProcessRecord(dto.getQuartzProcessRecord());
		Integer qprid = quartzProcessRecord.getQprid();
		QuartzJobsTB quartzJobsTB = new QuartzJobsTB();
		quartzJobsTB.clone(dto.getQuartzJobs());
		quartzJobsTB.setQjinfo(String.valueOf(qprid));
		quartzJobsTB.setQjtriname("trigger" + System.currentTimeMillis());
		quartzJobsTB.setQjtrigrp("triggerGroup" + System.currentTimeMillis());
		
		QuartzJobs quartzJobs = quartzJobsBL.saveQuartzJobs(quartzJobsTB);
		
		IGSCH0202Form igsch0202Form = dto.getIgsch0202Form();
		
		QuartzProcessParticipantTB qppTB01 = new QuartzProcessParticipantTB();
		qppTB01.setQprid(qprid);
		qppTB01.setQpproleid(igsch0202Form.getQprroleid());
		qppTB01.setQpprolename(igsch0202Form.getQprrolename());
		qppTB01.setQppuserid(igsch0202Form.getQpruserid());
		qppTB01.setQppusername(igsch0202Form.getQprusername());
		qppTB01.setQpptype(IGSCH01BLType.PARTICIPANT_TYPE);
		qppTB01.setQppuserinfo(igsch0202Form.getQprinfo());
		qppTB01.setQppstatus(IGSCH01BLType.PARTICIPANT_STATUS_INITIAL);
		qppTB01.setQpporgid(igsch0202Form.getQprorgid());
		qppTB01.setQpporgname(igsch0202Form.getQprorgname());
		quartzProcessParticipantBL.saveQuartzProcessParticipant(qppTB01);
		QuartzProcessParticipantTB qppTB02 = new QuartzProcessParticipantTB();
		qppTB02.clone(qppTB01);
		qppTB02.setQppstatus(IGSCH01BLType.PARTICIPANT_STATUS_VERIFY);
		quartzProcessParticipantBL.saveQuartzProcessParticipant(qppTB02);
		
		List<QuartzProcessInfo> qprInfoList = new ArrayList<QuartzProcessInfo>();
		if(igsch0202Form.getPivarvalue() != null){
			for(int i=0;i<igsch0202Form.getPivarvalue().length;i++){
				QuartzProcessInfoTB qprInfo = new QuartzProcessInfoTB();
				qprInfo.setQpivarlabel(igsch0202Form.getPivarlabel()[i]);
				qprInfo.setQpivarname(igsch0202Form.getPivarname()[i]);
				qprInfo.setQpivartype(igsch0202Form.getPivartype()[i]);
				qprInfo.setQpivarvalue(igsch0202Form.getPivarvalue()[i]);
				qprInfo.setQprid(qprid);
				qprInfoList.add(qprInfo);
			}
		}
		if(!qprInfoList.isEmpty()){
			quartzProcessInfoBL.saveQuartzProcessInfos(qprInfoList);
		}
		
		createPersonJobs(quartzJobs);
		dto.addMessage(new ActionMessage("IGSCH0202.I002", "个人任务基本信息"));
		log.debug("========保存个人工作处理终了========");
	}
	
	public void createPersonJobs(QuartzJobs quartzJobs) throws BLException {
		PersonTimerJob personTimerJob = new PersonTimerJob();
		String jobName = "Job" + quartzJobs.getQjid();
		String jobGroupName = "Group" + quartzJobs.getQjid();
		String cronExpression = quartzJobs.getQjtricron();
		String creatTime = quartzJobs.getQjcrttime();
		String endTime = quartzJobs.getQjendtime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date beganDate = null;
		Date endDate = null;
		log.debug(cronExpression);
		try {
			if(null != endTime && !"".equals(endTime)){
				beganDate = format.parse(creatTime);
				endDate = format.parse(endTime);
				JobManager.addJob(jobName, jobGroupName, quartzJobs.getQjtriname(), 
						quartzJobs.getQjtrigrp(), personTimerJob, cronExpression, beganDate, endDate);
			} else {
				JobManager.addJob(jobName, jobGroupName, quartzJobs.getQjtriname(), 
						quartzJobs.getQjtrigrp(), personTimerJob, cronExpression);
			}
		} catch (SchedulerException e) {
			log.error("==========Exception form personTimerJob===========");
			throw new BLException("", "SchedulerException");
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
	}

	/**
	 * 根据传入参数决定调用哪个BL完成服务策略的自动发起工作任务
	 * @param dto02
	 * @param dto03
	 * @throws BLException
	 */
	public synchronized void initByWorkType(IGSCH02DTO dto02,IGSCH03DTO dto03) throws BLException {
		if(dto03!=null){
			IGSCH03BL sch03bl = (IGSCH03BL) WebApplicationSupport.getBean("IGSCH03BL");
			sch03bl.init(dto03);
		}else{
			this.init(dto02);
		}
	}
	
	public void init(IGSCH02DTO dto) throws BLException {
		
		//查询任务详细信息
		QuartzJobDetailsSearchCondImpl cond1 = new QuartzJobDetailsSearchCondImpl();
		cond1.setQjdtriname(dto.getTriggerName());
		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond1,0,0);
		if(qjdList == null || qjdList.size() == 0){
			return;
		}

		QuartzJobs qj = quartzJobsBL.searchQuartzJobsByKey(qjdList.get(0).getQjid());
		if(qj == null){
			return;
		}
		QuartzJobs quartzJobs = qj;
		String qjtype = quartzJobs.getQjtype();
		if("S".equals(qjtype)){ //短信
			String qjinfo = quartzJobs.getQjinfo();
			String userid = quartzJobs.getQjimpluser();
			sendMessageBL.sendSmsToUser(userid, qjinfo);
		} else if("W".equals(qjtype)){	//事件
			String qjinfo = quartzJobs.getQjinfo();
			Integer qprid = Integer.valueOf(qjinfo);
			QuartzProcessRecord quartzProcessRecord = quartzProcessRecordBL.findByPK(qprid);
			IG500TB prTB = this.copyProcessRecord(quartzProcessRecord);
			//ProcessRecord processRecord = ig500BL.registProcessRecord(prTB);
			//带日志发起 modify by yangliang 
			String userid = prTB.getPruserid();
			User user = userBL.searchUserByKey(userid);
			IG500Info processRecord = workFlowOperationBL.createProcessRecord(prTB,user,prTB.getPrroleid(),prTB.getPrdesc(),
					null,null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL, null, null);
		
			Integer prid = processRecord.getPrid();
			QuartzProcessParticipantSearchCondImpl pqqCond = new QuartzProcessParticipantSearchCondImpl();
			pqqCond.setQprid(qprid);
			List<QuartzProcessParticipant> qppList = quartzProcessParticipantBL.searchProcessParticipant(pqqCond, 0, 0);
			for (QuartzProcessParticipant quartzProcessParticipant : qppList) {
				IG337TB ppTB = this.copyProcessParticipant(quartzProcessParticipant);
				ppTB.setPrid(prid);
				ig337BL.registIG337Info(ppTB);
			}
			
			QuartzProcessInfoSearchCondImpl qpiCond = new QuartzProcessInfoSearchCondImpl();
			qpiCond.setQprid(qprid);
			List<QuartzProcessInfo> qpiList = quartzProcessInfoBL.searchQuartzProcessInfos(qpiCond, 0, 0);
			
			List<IG599Info> processInfoList = new ArrayList<IG599Info>();
			//流程与资产的关系
			List<QuartzProcessInfoEntity> qpieList = this.quartzProcessInfoEntityBL.searchQuartzProcessInfoEntityByPrid(qprid);
			for (QuartzProcessInfo quartzProcessInfo : qpiList) {
				IG599TB piTB = this.copyQuartzProcessInfo(quartzProcessInfo);
				piTB.setPrid(prid);
				//-------------------------yangsn
				processInfoList.add(piTB);
				IG599Info pi = ig599BL.saveIG599Info(piTB);
				if(qpieList != null){
					for(QuartzProcessInfoEntity quartzProcessInfoEntity : qpieList){
						if(quartzProcessInfo.getQpiid().equals(quartzProcessInfoEntity.getQpiid())){
							IG731TB pieTB = this.copyQuartzProcessInfoEntity(quartzProcessInfoEntity);
							pieTB.setPrid(prid);
							pieTB.setPiid(pi.getPiid());
							ig731BL.registIG731Info(pieTB);
						}
					}
				}
			}
			if(qpieList == null){
				ig599BL.saveOrUpdIG599Infos(processInfoList);
			}
			//-------------------------
		}
		
		//设置运维计划任务状态为已执行
		QuartzJobDetailsTB qjdtb = (QuartzJobDetailsTB)SerializationUtils.clone(qjdList.get(0));
		qjdtb.setQjdtype(IGMTP01BLType.JOB_TYPE_EXECUTION);
		quartzJobDetailsBL.updateQuartzJobDetails(qjdtb);
		
	}
	
	protected IG599TB copyQuartzProcessInfo(QuartzProcessInfo qpi){
		IG599TB piTB = new IG599TB();
		piTB.setPivarlabel(qpi.getQpivarlabel());
		piTB.setPiattkey(qpi.getQpiattkey());
		piTB.setPivarname(qpi.getQpivarname());
		piTB.setPivartype(qpi.getQpivartype());
		piTB.setPivarvalue(qpi.getQpivarvalue());
		return piTB;
	}
	
	protected IG731TB copyQuartzProcessInfoEntity(QuartzProcessInfoEntity qpie){
		IG731TB pieTB = new IG731TB();
		pieTB.setPrid(qpie.getQprid());
		pieTB.setPiid(qpie.getQpiid());
		pieTB.setEiid(qpie.getQeiid());
		return pieTB;
	}
	
	protected IG500TB copyProcessRecord(QuartzProcessRecord qpr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String today = sdf.format(System.currentTimeMillis());
		IG500TB prTB = new IG500TB();
		prTB.setPrassetid(qpr.getQprassetid());
		prTB.setPrassetname(qpr.getQprassetname());
		prTB.setPrbackplan(qpr.getQprbackplan());
		prTB.setPrbusiness(qpr.getQprbusiness());
		prTB.setPrclosetime(qpr.getQprclosetime());
		prTB.setPrdesc(qpr.getQprdesc());
		prTB.setPrduration(qpr.getQprduration());
		prTB.setPrimpact(qpr.getQprimpact());
		prTB.setPrimplplan(qpr.getQprimplplan());
		prTB.setPropentime(today);
		prTB.setPrplantime(today);
		prTB.setPrstatus(qpr.getQprstatus());
		prTB.setPrsubstatus(qpr.getQprsubstatus());
		prTB.setPrtitle(qpr.getQprtitle());
		prTB.setPrtype(qpr.getQprtype());
		prTB.setPrurgency(qpr.getQprurgency());
		prTB.setPrvfyplan(qpr.getQprvfyplan());
		prTB.setPrinfo(qpr.getQprinfo());
		prTB.setPid(qpr.getQpid());
		prTB.setPcode(qpr.getQpcode());
		prTB.setPname(qpr.getQpname());
		prTB.setPrsubtype(qpr.getQprsubtype());
		prTB.setPrcortype(qpr.getQprcortype());
		prTB.setPrcorid(qpr.getQprcorid());
		prTB.setPrcortitle(qpr.getQprcortitle());
		prTB.setPrassetcategory(qpr.getQprassetcategory());
		prTB.setPrusername(qpr.getQprusername());
		prTB.setPrrolename(qpr.getQprrolename());
		prTB.setPruserid(qpr.getQpruserid());
		prTB.setPrroleid(qpr.getQprroleid());
		prTB.setPrpdid(qpr.getQprpdid());
		prTB.setPrpdname(qpr.getQprpdname());
		prTB.setProrgid(qpr.getQprorgid());
		prTB.setProrgname(qpr.getQprorgname());
		return prTB;
	}
	
	protected IG337TB copyProcessParticipant(QuartzProcessParticipant qpp){
		IG337TB ppTB = new IG337TB();
		ppTB.setPpattkey(qpp.getQppattkey());
		ppTB.setPpcomment(qpp.getQppcomment());
		ppTB.setPpinittime(qpp.getQppinittime());
		ppTB.setPporgid(qpp.getQpporgid());
		ppTB.setPpproctime(qpp.getQppproctime());
		ppTB.setPproleid(qpp.getQpproleid());
		ppTB.setPprolename(qpp.getQpprolename());
		ppTB.setPpstatus(qpp.getQppstatus());
		ppTB.setPptype(qpp.getQpptype());
		ppTB.setPpuserid(qpp.getQppuserid());
		ppTB.setPpusername(qpp.getQppusername());
		ppTB.setPpuserinfo(qpp.getQppuserinfo());
		ppTB.setPrid(qpp.getQprid());
		ppTB.setPporgname(qpp.getQpporgname());
		return ppTB;
	}

	public String getPeriodInfo(String periodType, String CustomDate, 
			String exeHour, String exeMinute,String startDate){
		String period = null;
		if("week".equals(periodType)){
			period = "周" + this.getWeekOfDate(startDate,null) + " ";
		} else if ("month".equals(periodType)){
			period = "月" + Integer.valueOf(startDate.split("/")[2].trim()) + "日  ";
		} else if ("once".equals(periodType)){
			period = startDate + " " + exeHour + ":" + exeMinute;
			return period;
		} else if ("day".equals(periodType)){
			period = "日";
		} else if ("quarter".equals(periodType)){
			period = "三个月" + Integer.valueOf(startDate.split("/")[2].trim()) + "日  ";
		} 
		return "每" + period + exeHour + ":" + exeMinute;
	}
	
	public String getWeekOfDate(String strDate,String language) {
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
        if("eng".equals(language)){
        	return engWeekDays[w];
        }
        return weekDays[w];
    }

	public IGSCH02DTO getProcessDefinitions(IGSCH02DTO dto) throws BLException {
		IG259Info pt = ig259BL.searchIG259ByPrType("WB");
		if(pt == null){
			throw new BLException("IGCO10000.E004","流程模板");
		}
		List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
		dto.setPdList(pdList);
		return dto;
	}

	public IGSCH02DTO getProcessInfoDefs(IGSCH02DTO dto) throws BLException {
		List<IG007Info> pidList = ig007BL.searchIG007InfoByPdid(dto.getPdid());
		dto.setPidList(pidList);
		return dto;
	}
	
	public Timer01TB getTimer01(String uuid) throws Exception {
		Timer01TB timer01Info = (Timer01TB)igcim13BL.getTimer01ByUuid(uuid);
		return timer01Info;
	}

	public void setIgcim13BL(IGCIM13BL igcim13BL) {
		this.igcim13BL = igcim13BL;
	}

	public IGCIM13BL getIgcim13BL() {
		return igcim13BL;
	}

	public CodeListUtils getCodeListUtils() throws Exception {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		return codeListUtils;
	}

	public void updateTimer01(Timer01TB timer01TB) throws Exception {
		igcim13BL.updateTimer01(timer01TB);
	}
}