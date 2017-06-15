package com.deliverik.infogovernor.scheduling.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
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
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
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
import com.deliverik.infogovernor.scheduling.dto.IGSCH03DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0301Form;
import com.deliverik.infogovernor.scheduling.form.IGSCH0302Form;
import com.deliverik.infogovernor.scheduling.jobs.EnterpriseTimerJob;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
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
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务策略_企业定时任务BL
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public class IGSCH03BLImpl extends BaseBLImpl implements IGSCH03BL {
	
	static Log log = LogFactory.getLog(IGSCH03BLImpl.class);

	private QuartzJobsBL quartzJobsBL;
	
	private RoleBL roleBL;
	
	private QuartzProcessRecordBL quartzProcessRecordBL;
	
	private QuartzProcessParticipantBL quartzProcessParticipantBL;
	
	private IG500BL ig500BL;
	
	private IG337BL ig337BL;
	
	private SendMessageBL sendMessageBL;
	
	private IG036BL ig036BL;
	
	private QuartzProcessInfoBL quartzProcessInfoBL;
	
	private IG599BL ig599BL;
	
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

	public void setQuartzProcessInfoBL(QuartzProcessInfoBL quartzProcessInfoBL) {
		this.quartzProcessInfoBL = quartzProcessInfoBL;
	}

	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	public void setIg036BL(IG036BL ig036BL) {
		this.ig036BL = ig036BL;
	}

	public void setQuartzProcessRecordBL(QuartzProcessRecordBL quartzProcessRecordBL) {
		this.quartzProcessRecordBL = quartzProcessRecordBL;
	}

	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}

	
	public void setQuartzProcessParticipantBL(
			QuartzProcessParticipantBL quartzProcessParticipantBL) {
		this.quartzProcessParticipantBL = quartzProcessParticipantBL;
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
	
	public IGSCH03DTO saveQuartzJobs(IGSCH03DTO dto) throws BLException {
		log.debug("========保存短信提醒处理开始========");
		QuartzJobsTB quartzJobsTB = new QuartzJobsTB();
		quartzJobsTB.clone(dto.getQuartzJobs());
		quartzJobsTB.setQjtriname("trigger" + System.currentTimeMillis());
		quartzJobsTB.setQjtrigrp("triggerGroup" + System.currentTimeMillis());
		
		IGSCH0301Form form = dto.getIgsch0301Form();
		String periodType = form.getPeriodType();
		String CustomDate = form.getCustomDate();
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		String startDate = form.getQjcrttime();
		String periodInfo = this.getPeriodInfo(periodType, CustomDate, exeHour, exeMinute,startDate);
		
		quartzJobsTB.setQjperiodinfo(periodInfo);
		
		QuartzJobs quartzJobs = quartzJobsBL.saveQuartzJobs(quartzJobsTB);
		createEnterpriseTimerJob(quartzJobs);
		dto.addMessage(new ActionMessage("IGSCH0302.I001", "短信提醒基本信息"));
		log.debug("========保存短信提醒处理终了========");
		 return dto;
	}

	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	public void setIg337BL(IG337BL ig337BL) {
		this.ig337BL = ig337BL;
	}

	public IGSCH03DTO findRole(IGSCH03DTO dto) throws BLException {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
		cond.setRoletypeEqual(2);
		String roles_BP_EX = ResourceUtility.getString("ROLES_BP_EX");
		if(!StringUtils.isEmpty(roles_BP_EX)){
			cond.setRoles_BP_EX(roles_BP_EX.split(","));
		}
		cond.setRoles_Like(WorkFlowConstDefine.PROCESS_ROLE_MARK);
		dto.setRolelist(roleBL.searchRole(cond, 0, 0));
		return dto;
	}
	
	public IGSCH03DTO saveQuartzWorkAction(IGSCH03DTO dto) throws BLException {
		log.debug("========保存指派任务处理开始========");
		QuartzProcessRecord quartzProcessRecord = quartzProcessRecordBL.
			saveQuartzProcessRecord(dto.getQuartzProcessRecord());
		Integer qprid = quartzProcessRecord.getQprid();
		QuartzJobsTB quartzJobsTB = new QuartzJobsTB();
		quartzJobsTB.clone(dto.getQuartzJobs());
		quartzJobsTB.setQjinfo(String.valueOf(qprid));
		quartzJobsTB.setQjtriname("trigger" + System.currentTimeMillis());
		quartzJobsTB.setQjtrigrp("triggerGroup" + System.currentTimeMillis());

		QuartzJobs quartzJobs = quartzJobsBL.saveQuartzJobs(quartzJobsTB);
		
		IGSCH0302Form igsch0302Form = dto.getIgsch0302Form();
		
		QuartzProcessParticipantTB qppTB01 = new QuartzProcessParticipantTB();
		qppTB01.setQprid(qprid);
		qppTB01.setQpproleid(igsch0302Form.getQprroleid());
		qppTB01.setQpprolename(igsch0302Form.getQprrolename());
		qppTB01.setQppuserid(igsch0302Form.getQjcrtuser());
		qppTB01.setQppusername(igsch0302Form.getQjcrtusername());
		qppTB01.setQpptype(IGSCH01BLType.PARTICIPANT_TYPE);
		qppTB01.setQppuserinfo(igsch0302Form.getQprinfo());
		qppTB01.setQppstatus(IGSCH01BLType.PARTICIPANT_STATUS_INITIAL);
		qppTB01.setQpporgid(igsch0302Form.getQprorgid());
		qppTB01.setQpporgname(igsch0302Form.getQprorgname());
		quartzProcessParticipantBL.saveQuartzProcessParticipant(qppTB01);
		QuartzProcessParticipantTB qppTB02 = new QuartzProcessParticipantTB();
		qppTB02.clone(qppTB01);
		qppTB02.setQppstatus(IGSCH01BLType.PARTICIPANT_STATUS_DISPATCHER);
		quartzProcessParticipantBL.saveQuartzProcessParticipant(qppTB02);
		QuartzProcessParticipantTB qppTB03 = new QuartzProcessParticipantTB();
		qppTB03.clone(qppTB01);
		qppTB03.setQppstatus(IGSCH01BLType.PARTICIPANT_STATUS_VERIFY);
		quartzProcessParticipantBL.saveQuartzProcessParticipant(qppTB03);
		QuartzProcessParticipantTB qppTB04 = new QuartzProcessParticipantTB();
		qppTB04.setQprid(qprid);
		qppTB04.setQpproleid(igsch0302Form.getQjimplroleid());
		qppTB04.setQpprolename(igsch0302Form.getQjimplrolename());
		qppTB04.setQppuserid(igsch0302Form.getQjimpluser());
		qppTB04.setQppusername(igsch0302Form.getQjimplusername());
		qppTB04.setQpptype(IGSCH01BLType.PARTICIPANT_TYPE);
		qppTB04.setQppuserinfo(igsch0302Form.getQprinfo());
		qppTB04.setQppstatus(IGSCH01BLType.PARTICIPANT_STATUS_IMPLEMENT);
		qppTB04.setQpporgid(igsch0302Form.getQjorgid());
		qppTB04.setQpporgname(igsch0302Form.getQjorgname());
		quartzProcessParticipantBL.saveQuartzProcessParticipant(qppTB04);
		
		
		List<QuartzProcessInfo> qprInfoList = new ArrayList<QuartzProcessInfo>();
		if(igsch0302Form.getPivarvalue() != null){
			for(int i=0;i<igsch0302Form.getPivarvalue().length;i++){
				QuartzProcessInfoTB qprInfo = new QuartzProcessInfoTB();
				qprInfo.setQpivarlabel(igsch0302Form.getPivarlabel()[i]);
				qprInfo.setQpivarname(igsch0302Form.getPivarname()[i]);
				qprInfo.setQpivartype(igsch0302Form.getPivartype()[i]);
				qprInfo.setQpivarvalue(igsch0302Form.getPivarvalue()[i]);
				qprInfo.setQprid(qprid);
				qprInfoList.add(qprInfo);
			}
		}
		if(!qprInfoList.isEmpty()){
			quartzProcessInfoBL.saveQuartzProcessInfos(qprInfoList);
		}
		createEnterpriseTimerJob(quartzJobs);
		dto.addMessage(new ActionMessage("IGSCH0302.I002", "指派任务基本信息"));
		log.debug("========保存指派任务处理终了========");
		return dto;
	}
	
	

	public void init(IGSCH03DTO dto) throws BLException {
		
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
			List<IG337Info> participantList= new ArrayList<IG337Info>();
			for (QuartzProcessParticipant quartzProcessParticipant : qppList) {
				IG337TB ppTB = this.copyProcessParticipant(quartzProcessParticipant);
				ppTB.setPrid(prid);
				ig337BL.registIG337Info(ppTB);
				if(ppTB.getPpstatus().equals(IGSCH01BLType.PROCESS_STATUS_WAITING_IMPLEMENT)){
					participantList.add(ppTB);
				}
			}
			//sendMessage(participantList, prid);//发短信
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
			
			// 填充工作历史记录
			IG036TB recordLog = new IG036TB();
			recordLog.setPrid(prid);
			recordLog.setRluserid(quartzProcessRecord.getQpruserid());
			recordLog.setRlusername(quartzProcessRecord.getQprusername());
			recordLog.setRlcomment(quartzProcessRecord.getQprdesc());
			recordLog.setRltime(prTB.getPropentime());
			recordLog.setRoleid(quartzProcessRecord.getQprroleid());
			recordLog.setRlrolename(quartzProcessRecord.getQprrolename());
			recordLog.setRlorgid(quartzProcessRecord.getQprorgid());
			recordLog.setRlorgname(quartzProcessRecord.getQprorgname());
			recordLog.setRlattkey(quartzProcessRecord.getQprattkey());
			ig036BL.registIG036Info(recordLog);
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
		if(StringUtils.isNotEmpty(qpr.getQprduration())){
			prTB.setPrduration(sdf.format(System.currentTimeMillis() + 86400000 * Integer.valueOf(qpr.getQprduration().trim())));
		}else{
			prTB.setPrduration("");
		}
		
//		prTB.setPrid(qpr.getQprid());
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String today = sdf.format(System.currentTimeMillis());
		IG337TB ppTB = new IG337TB();
		ppTB.setPpattkey(qpp.getQppattkey());
		ppTB.setPpcomment(qpp.getQppcomment());
//		ppTB.setPpid(qpp.getQppid());
		if(qpp.getQppinittime() != null){
			ppTB.setPpinittime(today);
		}else{
			ppTB.setPpinittime(qpp.getQppinittime());
		}
		ppTB.setPporgid(qpp.getQpporgid());
		if(qpp.getQppproctime() != null){
			ppTB.setPpproctime(today);
		}else{
			ppTB.setPpproctime(qpp.getQppproctime());
		}
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
			period = "月" + Integer.valueOf(startDate.split("/")[2]) + "日  ";
		} else if ("once".equals(periodType)){
			period = startDate + " " + exeHour + ":" + exeMinute;
			return period;
		}
		return "每" + period + exeHour + ":" + exeMinute;
	}
	
	protected String getWeekOfDate(String strDate,String language) {
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
	
	public IGSCH03DTO getProcessDefinitions(IGSCH03DTO dto) throws BLException {
		IG259Info pt = ig259BL.searchIG259ByPrType("WA");
		if(pt == null){
			throw new BLException("IGCO10000.E004","流程模板");
		}
		List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
		dto.setPdList(pdList);
		return dto;
	}

	public IGSCH03DTO getProcessInfoDefs(IGSCH03DTO dto) throws BLException {
		List<IG007Info> pidList = ig007BL.searchIG007InfoByPdid(dto.getPdid());
		dto.setPidList(pidList);
		return dto;
	}
	
	public void createEnterpriseTimerJob(QuartzJobs quartzJobs) throws BLException{
		EnterpriseTimerJob enterpriseTimerJob = new EnterpriseTimerJob();
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
						quartzJobs.getQjtrigrp(), enterpriseTimerJob, cronExpression, beganDate, endDate);
			} else {
				//仅执行一次
				JobManager.addJob(jobName, jobGroupName, quartzJobs.getQjtriname(), 
						quartzJobs.getQjtrigrp(), enterpriseTimerJob, cronExpression);
			}
		} catch (SchedulerException e) {
			log.error("==========Exception form personTimerJob===========");
			throw new BLException("", "SchedulerException");
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
		
	}
	
	/**
	 * 发短信
	 * 
	 * @param participantList
	 * @param prid
	 * @throws BLException 
	 */
	private void sendMessage(List<IG337Info> participantList,Integer prid) throws BLException{
		if(participantList!=null){
			for(IG337Info pp : participantList){
				if(!StringUtils.isEmpty(pp.getPpuserid())){
					sendMessageToUser(pp.getPpuserid(), prid);
					continue;
				}
				if(pp.getPproleid()!=null&&pp.getPproleid()!=0){
					sendMessageToRole(pp.getPproleid(), prid);
				}
			}
		}
	}

	/**
	 * 给用户发短信
	 * 
	 * @param userid
	 * @param prid
	 * @throws BLException 
	 */
	private void sendMessageToUser(String userid, Integer prid) throws BLException{
		IG500Info processrecord = ig500BL.searchIG500InfoByKey(prid);//this.getProcessRecord(prid);
		String message ="工单号为("+ processrecord.getPrserialnum() + ")的"+processrecord.getPrtitle()+"事件需要您处理。";
		sendMessageBL.sendSmsToUser(userid, message);
	}

	/**
	 * 给角色值班手机发短信
	 * 
	 * @param roleid
	 * @param prid
	 * @throws BLException 
	 */
	private void sendMessageToRole(Integer roleid, Integer prid) throws BLException{
		IG500Info processrecord = ig500BL.searchIG500InfoByKey(prid);
		String message = "工单号为("+ processrecord.getPrserialnum() + ")的"+processrecord.getPrtitle()+"事件需要您处理。";
		sendMessageBL.sendSmsToRole(roleid, message);
	}

}