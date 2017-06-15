package com.deliverik.infogovernor.scheduling.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.quartz.SchedulerException;

import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.infogovernor.mtp.bl.task.QuartzJobDetailsBL;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCondImpl;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessInfoBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessInfoEntityBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessParticipantBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessRecordBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH01DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0101Form;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzJobsTB;
import com.deliverik.infogovernor.sdl.bl.QuartzJobsType;
import com.deliverik.infogovernor.sdl.dto.IGSDL01DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0110Form;

public class IGSCH01BLImpl extends BaseBLImpl implements IGSCH01BL {
	
	static Log log = LogFactory.getLog(IGSCH01BLImpl.class);
	
	private QuartzJobsBL quartzJobsBL;
	private QuartzProcessRecordBL quartzProcessRecordBL;
	private QuartzProcessParticipantBL quartzProcessParticipantBL;
	private QuartzProcessInfoBL quartzProcessInfoBL;
	private AttachmentBL attachmentBL;
	private CodeDetailBL codeDetailBL;
	protected IG013BL ig013BL;
	protected QuartzProcessInfoEntityBL quartzProcessInfoEntityBL;
	
	/**日常运维计划信息处理BL*/
	protected QuartzJobDetailsBL quartzJobDetailsBL;
	
	
	
	public void setQuartzJobDetailsBL(QuartzJobDetailsBL quartzJobDetailsBL) {
		this.quartzJobDetailsBL = quartzJobDetailsBL;
	}
	
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	public void setQuartzProcessInfoBL(QuartzProcessInfoBL quartzProcessInfoBL) {
		this.quartzProcessInfoBL = quartzProcessInfoBL;
	}

	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}

	public void setQuartzProcessRecordBL(QuartzProcessRecordBL quartzProcessRecordBL) {
		this.quartzProcessRecordBL = quartzProcessRecordBL;
	}

	public void setQuartzProcessParticipantBL(
			QuartzProcessParticipantBL quartzProcessParticipantBL) {
		this.quartzProcessParticipantBL = quartzProcessParticipantBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	public void setQuartzProcessInfoEntityBL(
			QuartzProcessInfoEntityBL quartzProcessInfoEntityBL) {
		this.quartzProcessInfoEntityBL = quartzProcessInfoEntityBL;
	}

	public IGSCH01DTO searchQuartzJobs(IGSCH01DTO dto) throws BLException {
		log.debug("========定时任务查询处理开始========");
		// 查询记录总数
		int totalCount = quartzJobsBL.getSearchCount(dto.getQuartzJobsSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<QuartzJobs> quartzJobsList = quartzJobsBL.searchQuartzJobs(dto.getQuartzJobsSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		String inputStartTime = dto.getQuartzJobsSearchCond().getStartTime();
		String inputEndTime = dto.getQuartzJobsSearchCond().getEndTime();
		if(StringUtils.isNotEmpty(inputStartTime) && StringUtils.isNotEmpty(inputEndTime)){
//			List<QuartzJobs> retQJList = this.getCurrentQuartzJobs(quartzJobsList, inputStartTime, inputEndTime);
			pDto.setTotalCount(quartzJobsList.size());
			dto.setQuartzJobsList(quartzJobsList);
			dto.addMessage(new ActionMessage("IGCO10000.I002", quartzJobsList.size()));
		} else {
			pDto.setTotalCount(totalCount);
			dto.setQuartzJobsList(quartzJobsList);
			dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		}
		log.debug("========定时任务查询处理终了========");
		return dto;
	}

	public IGSCH01DTO deleteQuartzJobs(IGSCH01DTO dto) throws BLException {
		log.debug("========定时任务删除处理开始========");
		Integer qjid = dto.getQjid();
		QuartzJobs quartzJobs = quartzJobsBL.findByPK(qjid);
		
		//查询该运维计划的所有详细设置信息
		QuartzJobDetailsSearchCondImpl cond1 = new QuartzJobDetailsSearchCondImpl();
		cond1.setQjid(qjid);
		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond1,0,0);
		//如果存在详细信息，则先根据详细信息中保存的quartz相关信息将运维计划从quartz中删除
		if(qjdList!=null && qjdList.size()>0){
			for(QuartzJobDetails qjd:qjdList){
				String triggerName = qjd.getQjdtriname();//触发器名称
				String triggerGroupName = qjd.getQjdtrigrpname();//触发器所属组的名称
				String jobName = "Job" + qjid;
				String jobGroupName = "Group" + qjid;
				try {
					JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
					log.debug("========移除定时器jobName = " + jobName + "========");
				} catch (SchedulerException e) {
					log.error("定时器移除移除异常");
					log.debug(e.getMessage());
				}
			}
		}
		
		
		
//		String jobName = "Job" + qjid;
//		String jobGroupName = "Group" + qjid;
//		String triggerName = quartzJobs.getQjtriname();
//		String triggerGroupName = quartzJobs.getQjtrigrp();
//		try {
//			JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
//			log.debug("========移除定时器jobName = " + jobName + "========");
//		} catch (SchedulerException e) {
//			log.error("定时器移除移除异常");
//			log.debug(e.getMessage());
//		}
		
		
		String qjtype = quartzJobs.getQjtype();
		//删除流程相关信息
		if ("W".equals(qjtype)){
			Integer qprid = Integer.valueOf(quartzJobs.getQjinfo());
			QuartzProcessInfoSearchCondImpl qpiCond = new QuartzProcessInfoSearchCondImpl();
			qpiCond.setQprid(qprid);
			List<QuartzProcessInfo> qpiList = quartzProcessInfoBL.searchQuartzProcessInfos(qpiCond, 0, 0);
			quartzProcessInfoBL.deleteQuartzProcessInfos(qpiList);
			log.debug("========删除QuartzProcessInfo========");
			QuartzProcessParticipantSearchCondImpl qppCond = new QuartzProcessParticipantSearchCondImpl();
			qppCond.setQprid(qprid);
			List<QuartzProcessParticipant> qppList = quartzProcessParticipantBL.searchProcessParticipant(qppCond, 0, 0);
			quartzProcessParticipantBL.deleteProcessParticipants(qppList);
			log.debug("========删除QuartzProcessParticipant========");
			QuartzProcessRecord quartzProcessRecord = quartzProcessRecordBL.findByPK(qprid);
			quartzProcessRecordBL.deleteQuartzProcessRecord(quartzProcessRecord);
			log.debug("========删除QuartzProcessRecord========");
		}
		//删除日常运维计划任务
		quartzJobsBL.deleteQuartzJobs(qjid);
		log.debug("========删除QuartzJobs========");
		log.debug("========定时任务删除处理终了========");
		return dto;
	}

	public IGSCH01DTO initIGSCH0101(IGSCH01DTO dto) throws BLException {
		log.debug("========变更用定时任务基本信息查询处理开始========");
		IGSCH0101Form form = dto.getIgsch0101Form();
		QuartzJobs quartzJobs = quartzJobsBL.searchQuartzJobsByKey(dto.getQjid());
		if ( quartzJobs != null ){
			form.setQjname(quartzJobs.getQjname());
			form.setQjdesc(quartzJobs.getQjdesc());
			form.setQjcrtuser(quartzJobs.getQjcrtuser());
			form.setQjimpluser(quartzJobs.getQjimpluser());
			form.setQjcrttime(quartzJobs.getQjcrttime());
			form.setQjendtime(quartzJobs.getQjendtime());
			form.setQjtype(quartzJobs.getQjtype());
			log.debug("========变更用定时任务基本信息查询处理终了========");
		}
		return dto;
	}

	public IGSCH01DTO getQuartzJobs(IGSCH01DTO dto) throws BLException {
		QuartzJobs quartzJobs = quartzJobsBL.findByPK(dto.getQjid());
		dto.setQuartzJobs(quartzJobs);
		return dto;
	}
	
	public void updateQuartzJobs(IGSCH01DTO dto) throws BLException {
		QuartzJobs quartzJobs = quartzJobsBL.findByPK(dto.getQjid());
		IGSCH0101Form form = dto.getIgsch0101Form();
		QuartzJobsTB qjTB = new QuartzJobsTB();
		qjTB.clone(quartzJobs);
		qjTB.setQjcrttime(form.getQjcrttime().trim());
		qjTB.setQjendtime(form.getQjendtime().trim());
		qjTB.setQjid(quartzJobs.getQjid());
		qjTB.setQjtricron(form.getQjtricron());
		qjTB.setQjperiodinfo(form.getQjperiodinfo());
		quartzJobsBL.updateQuartzJobs(qjTB);
		String creatTime = qjTB.getQjcrttime().trim();
		String endTime = qjTB.getQjendtime().trim();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date beganDate = null;
		Date endDate = null;
		String triggerName = quartzJobs.getQjtriname();
		String triggerGroupName = quartzJobs.getQjtrigrp();
		try {
			if(null != endTime && !"".equals(endTime)){
				beganDate = format.parse(creatTime);
				endDate = format.parse(endTime);
				JobManager.modifyJobTime(triggerName, triggerGroupName, 
						qjTB.getQjtricron(), beganDate, endDate);
			} else {
				JobManager.modifyJobTime(qjTB.getQjtriname(), qjTB.getQjtrigrp(), qjTB.getQjtricron());
			}
		} catch (SchedulerException e) {
			log.error("==========Exception form personTimerJob===========");
			e.printStackTrace();
			throw new BLException("SchedulerException");
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
	}
	
	public IGSCH01DTO searchQuartzJobsByPK(IGSCH01DTO dto) throws BLException {
		log.debug("========定时任务查询处理开始========");
		//调用DAO接口查询
		QuartzJobs quartzJobs = null;
		QuartzProcessRecord quartzProcessRecord =  null;
		List<QuartzProcessInfo> quartzProcessInfoList = null;
		if("W".equals(dto.getIgsch0101Form().getQjtype()))
		{
			quartzJobs = quartzJobsBL.findByPK(dto.getIgsch0101Form().getQjid());
			quartzProcessRecord = quartzProcessRecordBL.findByPK(Integer.valueOf(quartzJobs.getQjinfo()));
			QuartzProcessInfoSearchCondImpl qpiCond = new QuartzProcessInfoSearchCondImpl();
			qpiCond.setQprid(quartzProcessRecord.getQprid());
			quartzProcessInfoList = quartzProcessInfoBL.searchQuartzProcessInfos(qpiCond, 0, 0);
			
			if("S".equals(quartzJobs.getQjstatus())){ //服务策略入口
				String attkey = quartzProcessRecord.getQprattkey();
				if(StringUtils.isNotEmpty(attkey)){					
					List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(attkey);
					dto.setAttachmentList(attachmentList);
				}
				String assetid = quartzJobs.getQjassetid();
				if(StringUtils.isNotEmpty(assetid)){
					String einame = ig013BL.searchIG013InfoByKey(Integer.valueOf(assetid)).getEiname();
					dto.setEiname(einame);
				}
				String syscoding = quartzJobs.getQjassettypeid();
				if(StringUtils.isNotEmpty(syscoding)){
					CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
					cond.setSyscoding(syscoding);
					String cvalue = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1).get(0).getCvalue();
					dto.setCvalue(cvalue);
				}
			}
			//==============================>执行人列表
			QuartzProcessParticipantSearchCondImpl cd = new QuartzProcessParticipantSearchCondImpl();
			cd.setQprid(quartzProcessRecord.getQprid());
			List <QuartzProcessParticipant> opList = quartzProcessParticipantBL.searchProcessParticipant(cd, 0, 0);
			dto.setQuartzProcessParticipantList(opList);
			//<==============================
			
			
			//============================>>yangsn
			//获取相关资产ID
			QuartzProcessInfoSearchCondImpl cond = new QuartzProcessInfoSearchCondImpl();
			cond.setQprid(quartzProcessRecord.getQprid());
			cond.setQpivarname(WorkFlowConstDefine.PROCESS_PIVRNAME);
			List <QuartzProcessInfo> processInfoList = quartzProcessInfoBL.searchQuartzProcessInfos(cond, 0, 0);
			if(processInfoList!=null&&processInfoList.size()>0){
				QuartzProcessInfo processInfo = processInfoList.get(0);
				//扩展信息显示出相关资产外的动态表单内容
				quartzProcessInfoList.remove(processInfo);
				
				List<QuartzProcessInfoEntity> pieList = new ArrayList<QuartzProcessInfoEntity>();
				
				//获取当前流程所有相关资产及动态资产表单信息
				List<QuartzProcessInfoEntity> processInfoEntityList = quartzProcessInfoEntityBL.searchQuartzProcessInfoEntityByPrid(quartzProcessRecord.getQprid());
				for(QuartzProcessInfoEntity pie : processInfoEntityList){
					if(pie.getQpiid().equals(processInfo.getQpiid())){
						pieList.add(pie);
					}
				}
				processInfoEntityList.removeAll(pieList);
				dto.setQuartzPieList(pieList);
				dto.setQuartzProcessInfoEntityList(processInfoEntityList);
			}
			//<<============================yangsn
		}
		else if("S".equals(dto.getIgsch0101Form().getQjtype()))
		{
			quartzJobs = quartzJobsBL.findByPK(dto.getIgsch0101Form().getQjid());
		}
		dto.setQuartzProcessInfoList(quartzProcessInfoList);
		dto.setQuartzJobs(quartzJobs);
		dto.setQuartzProcessRecord(quartzProcessRecord);
		log.debug("========定时任务查询处理终了========");
		
		return dto;
	}
	
//	private List<QuartzJobs> getCurrentQuartzJobs(List<QuartzJobs> quartzJobsList, String inputStartTime, String inputEndTime){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		
//		List<QuartzJobs> retQJList = new ArrayList<QuartzJobs>();
//		for (QuartzJobs quartzJobs : quartzJobsList) {
//			String qjtricron = quartzJobs.getQjtricron();
//			String crttime = quartzJobs.getQjcrttime().trim();
//			String endtime = quartzJobs.getQjendtime().trim();
//			
//			String strDate = null;
//			if(qjtricron.contains("/")){
//				strDate = qjtricron.split("/")[1].split(" ")[0];
//			}else{
//				strDate = qjtricron.split(" ")[3];
//			}
//			String year = crttime.split("/")[0];
//			String month = crttime.split("/")[1];
//			String day = crttime.split("/")[2];
//			if(qjtricron.contains("/") && qjtricron.split("/")[1].split(" ")[1].equals("?")) {  //月份
//				int i = 0;
//				while(true){
//					int iAfter = Integer.valueOf(strDate) * i;
//					Date dAfterMonth = this.getAfterMonthTime(year, month, day, iAfter);
//					String srtAfterMonth = sdf.format(dAfterMonth);
//					if(srtAfterMonth.compareTo(endtime) > 0){
//						break;
//					}
//					if(srtAfterMonth.compareTo(inputStartTime) >= 0 && srtAfterMonth.compareTo(inputEndTime) <= 0){
//						retQJList.add(quartzJobs);
//						break;
//					}
//					if(srtAfterMonth.compareTo(inputEndTime) > 0){
//						break;
//					}
//					i++;
//				}
//			} else {
//				int i = 0;
//				while(true){
//					int iAfter = Integer.valueOf(strDate) * i;
//					Date dAfterDay = this.getAfterDayTime(year, month, day, iAfter);
//					String srtAfterDay = sdf.format(dAfterDay);
//					if(srtAfterDay.compareTo(endtime) > 0){
//						break;
//					}
//					if(srtAfterDay.compareTo(inputStartTime) >= 0 && srtAfterDay.compareTo(inputEndTime) <= 0){
//						retQJList.add(quartzJobs);
//						break;
//					}
//					if(srtAfterDay.compareTo(inputEndTime) > 0){
//						break;
//					}
//					i++;
//				}
//			}
//		}
//		return retQJList;
//	}
	
	protected Date getAfterMonthTime(String year, String month, String day, int afterMonth) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);
		cal.set(Calendar.DATE, Integer.valueOf(day));
		cal.add(Calendar.MONTH, afterMonth);
		return cal.getTime();
	}
	
	protected Date getAfterDayTime(String year, String month, String day, int afterDay) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);
		cal.set(Calendar.DATE, Integer.valueOf(day));
		cal.add(Calendar.DATE, afterDay);
		return cal.getTime();
	}
	
	//====================sdl服务管理===========================
	/**
	 * <p>
	 * Description: 根据日期及登录用户查询运维计划（IGSDL0110.JSP查询页使用）
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsForIGSDL0110(IGSDL01DTO dto) throws BLException {
		IGSDL0110Form form = dto.getIgsdl0110Form();
		String qjassetid = form.getQjassetid();
		String qjassettypeid = form.getQjassettypeid();
		
		QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
		if(StringUtils.isNotEmpty(form.getDate())){
			cond.setDate_q(form.getDate()+" 00:00");//点击portal页传入的日期
		}else{
			cond.setDate_q("2010/01/01 00:00");//点击portal页传入的日期
		}
		cond.setUserid(dto.getUserid());
		if(StringUtils.isNotEmpty(form.getDate())){
			cond.setDate_j(form.getDate()+" 23:59");//点击portal页传入的日期
		}else{
			cond.setDate_j("2020/01/01 23:59");//点击portal页传入的日期
		}
		if(StringUtils.isNotEmpty(qjassetid)){
			cond.setQjassetid(qjassetid);
		}
		if(StringUtils.isNotEmpty(qjassettypeid)){
			cond.setQjassettypeid(qjassettypeid);
		}
		int totalCount = this.quartzJobsBL.getQuartzJobsCountByUserDate(cond);
		if (totalCount == 0) {
			log.debug("========数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========检索数据件数过多========");
			// 知识服务检索数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		
		List<QuartzJobsDetail> quartzJobsList = quartzJobsBL.getQuartzJobsByUserDate(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setPagingDto(pDto);
		
		dto.setQuartzJobDetailList(quartzJobsList);
		return dto;
	}
	
	
	public IGSDL01DTO findQuartzJobsForSDL(IGSDL01DTO dto) throws BLException {
		PagingDTO pDto = dto.getPagingDto();
		IGSDL0110Form form = dto.getIgsdl0110Form();
		QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
		cond.setQjtype_q(form.getQjtype_q());
		cond.setQjstatus(QuartzJobsType.SERVICE_STRATEGY);
		String qjassetid = dto.getIgsdl0110Form().getQjassetid();
		String qjassettypeid = dto.getIgsdl0110Form().getQjassettypeid();
		if(StringUtils.isNotEmpty(qjassetid)){
			cond.setQjassetid(qjassetid);
		}
		if(StringUtils.isNotEmpty(qjassettypeid)){
			cond.setQjassettypeid(qjassettypeid);
		}
		
		cond.setDate(form.getDate());
		
		
		
		int totalCount = this.quartzJobsBL.getSearchCount(cond);

		if (totalCount == 0) {

			log.debug("========数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========检索数据件数过多========");
			// 知识服务检索数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		pDto.setTotalCount(totalCount);
		
		List<QuartzJobs> quartzJobsList = quartzJobsBL.searchQuartzJobs(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setPagingDto(pDto);
		dto.setQuartzJobsList(quartzJobsList);
		return dto;
	}

	
	/**
	 * <p>
	 * Description: 根据日期查询服务策略
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsByDate(IGSDL01DTO dto) throws BLException {

		IGSDL0110Form form = dto.getIgsdl0110Form();
		QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
		cond.setQjtype_q(form.getQjtype_q());
		cond.setQjstatus(QuartzJobsType.SERVICE_STRATEGY);
		String qjassetid = dto.getIgsdl0110Form().getQjassetid();
		String qjassettypeid = dto.getIgsdl0110Form().getQjassettypeid();
		if(StringUtils.isNotEmpty(qjassetid)){
			cond.setQjassetid(qjassetid);
		}
		if(StringUtils.isNotEmpty(qjassettypeid)){
			cond.setQjassettypeid(qjassettypeid);
		}
		
		cond.setDate_q(form.getDate());
		cond.setDate_j(form.getDate_j());
		cond.setYmonth_q(form.getYmonth());
		cond.setQjcrtuser(dto.getUserid());
		List<QuartzJobs> quartzJobsList = quartzJobsBL.searchQuartzJobs(cond, 0, 0);
		dto.setQuartzJobsList(quartzJobsList);
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 定时任务按照ID查询QuartzJobDetails
	 * </p>
	 * 
	 * @param integer IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @update
	 */
	public IGSCH01DTO searchQuartzJobDetailsByQjid(IGSCH01DTO dto) throws BLException{
		
		QuartzJobDetailsSearchCondImpl qjdcond = new QuartzJobDetailsSearchCondImpl();
		qjdcond.setQjid(dto.getIgsch0101Form().getQjid());//QuartzJobs表的主键ID

		// 查询记录总数
		int totalCount = quartzJobDetailsBL.getSearchCount(qjdcond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<QuartzJobDetails> pjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(qjdcond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setQuartzJobDetailsList(pjdList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		
		return dto;
	}

	/**
	 * <p>
	 * Description: 根据日期及登录用户查询服务策略
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsByUserDate(IGSDL01DTO dto) throws BLException {

		IGSDL0110Form form = dto.getIgsdl0110Form();
		QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
		String date_q = form.getYmonth()+"/01 00:00";
		String date_j = form.getYmonth()+"/31 23:59";
		if(StringUtils.isNotEmpty(form.getYmonth())){
			date_q = form.getYmonth()+"/01 00:00";
			date_j = form.getYmonth()+"/31 23:59";
		}else{
			String curmonth = IGStringUtils.getCurrentDate().substring(5, 7);//当前月
			String curyear = IGStringUtils.getCurrentYear();//当前年
			date_q = curyear+"/"+curmonth+"/01 00:00";
			date_j = curyear+"/"+curmonth+"/31 23:59";
		}
		cond.setDate_q(date_q);
		cond.setUserid(dto.getUserid());
		cond.setDate_j(date_j);

		List<QuartzJobsDetail> quartzJobsList = quartzJobsBL.getQuartzJobsByUserDate(cond, 0, 0);
		dto.setQuartzJobsDetailList(quartzJobsList);
		return dto;
	}
	
	
}