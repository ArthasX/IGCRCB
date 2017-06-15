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
	
	/**�ճ���ά�ƻ���Ϣ����BL*/
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
		log.debug("========��ʱ�����ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = quartzJobsBL.getSearchCount(dto.getQuartzJobsSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
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
		log.debug("========��ʱ�����ѯ��������========");
		return dto;
	}

	public IGSCH01DTO deleteQuartzJobs(IGSCH01DTO dto) throws BLException {
		log.debug("========��ʱ����ɾ������ʼ========");
		Integer qjid = dto.getQjid();
		QuartzJobs quartzJobs = quartzJobsBL.findByPK(qjid);
		
		//��ѯ����ά�ƻ���������ϸ������Ϣ
		QuartzJobDetailsSearchCondImpl cond1 = new QuartzJobDetailsSearchCondImpl();
		cond1.setQjid(qjid);
		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond1,0,0);
		//���������ϸ��Ϣ�����ȸ�����ϸ��Ϣ�б����quartz�����Ϣ����ά�ƻ���quartz��ɾ��
		if(qjdList!=null && qjdList.size()>0){
			for(QuartzJobDetails qjd:qjdList){
				String triggerName = qjd.getQjdtriname();//����������
				String triggerGroupName = qjd.getQjdtrigrpname();//�����������������
				String jobName = "Job" + qjid;
				String jobGroupName = "Group" + qjid;
				try {
					JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
					log.debug("========�Ƴ���ʱ��jobName = " + jobName + "========");
				} catch (SchedulerException e) {
					log.error("��ʱ���Ƴ��Ƴ��쳣");
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
//			log.debug("========�Ƴ���ʱ��jobName = " + jobName + "========");
//		} catch (SchedulerException e) {
//			log.error("��ʱ���Ƴ��Ƴ��쳣");
//			log.debug(e.getMessage());
//		}
		
		
		String qjtype = quartzJobs.getQjtype();
		//ɾ�����������Ϣ
		if ("W".equals(qjtype)){
			Integer qprid = Integer.valueOf(quartzJobs.getQjinfo());
			QuartzProcessInfoSearchCondImpl qpiCond = new QuartzProcessInfoSearchCondImpl();
			qpiCond.setQprid(qprid);
			List<QuartzProcessInfo> qpiList = quartzProcessInfoBL.searchQuartzProcessInfos(qpiCond, 0, 0);
			quartzProcessInfoBL.deleteQuartzProcessInfos(qpiList);
			log.debug("========ɾ��QuartzProcessInfo========");
			QuartzProcessParticipantSearchCondImpl qppCond = new QuartzProcessParticipantSearchCondImpl();
			qppCond.setQprid(qprid);
			List<QuartzProcessParticipant> qppList = quartzProcessParticipantBL.searchProcessParticipant(qppCond, 0, 0);
			quartzProcessParticipantBL.deleteProcessParticipants(qppList);
			log.debug("========ɾ��QuartzProcessParticipant========");
			QuartzProcessRecord quartzProcessRecord = quartzProcessRecordBL.findByPK(qprid);
			quartzProcessRecordBL.deleteQuartzProcessRecord(quartzProcessRecord);
			log.debug("========ɾ��QuartzProcessRecord========");
		}
		//ɾ���ճ���ά�ƻ�����
		quartzJobsBL.deleteQuartzJobs(qjid);
		log.debug("========ɾ��QuartzJobs========");
		log.debug("========��ʱ����ɾ����������========");
		return dto;
	}

	public IGSCH01DTO initIGSCH0101(IGSCH01DTO dto) throws BLException {
		log.debug("========����ö�ʱ���������Ϣ��ѯ����ʼ========");
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
			log.debug("========����ö�ʱ���������Ϣ��ѯ��������========");
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
		log.debug("========��ʱ�����ѯ����ʼ========");
		//����DAO�ӿڲ�ѯ
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
			
			if("S".equals(quartzJobs.getQjstatus())){ //����������
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
			//==============================>ִ�����б�
			QuartzProcessParticipantSearchCondImpl cd = new QuartzProcessParticipantSearchCondImpl();
			cd.setQprid(quartzProcessRecord.getQprid());
			List <QuartzProcessParticipant> opList = quartzProcessParticipantBL.searchProcessParticipant(cd, 0, 0);
			dto.setQuartzProcessParticipantList(opList);
			//<==============================
			
			
			//============================>>yangsn
			//��ȡ����ʲ�ID
			QuartzProcessInfoSearchCondImpl cond = new QuartzProcessInfoSearchCondImpl();
			cond.setQprid(quartzProcessRecord.getQprid());
			cond.setQpivarname(WorkFlowConstDefine.PROCESS_PIVRNAME);
			List <QuartzProcessInfo> processInfoList = quartzProcessInfoBL.searchQuartzProcessInfos(cond, 0, 0);
			if(processInfoList!=null&&processInfoList.size()>0){
				QuartzProcessInfo processInfo = processInfoList.get(0);
				//��չ��Ϣ��ʾ������ʲ���Ķ�̬������
				quartzProcessInfoList.remove(processInfo);
				
				List<QuartzProcessInfoEntity> pieList = new ArrayList<QuartzProcessInfoEntity>();
				
				//��ȡ��ǰ������������ʲ�����̬�ʲ�����Ϣ
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
		log.debug("========��ʱ�����ѯ��������========");
		
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
//			if(qjtricron.contains("/") && qjtricron.split("/")[1].split(" ")[1].equals("?")) {  //�·�
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
	
	//====================sdl�������===========================
	/**
	 * <p>
	 * Description: �������ڼ���¼�û���ѯ��ά�ƻ���IGSDL0110.JSP��ѯҳʹ�ã�
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
			cond.setDate_q(form.getDate()+" 00:00");//���portalҳ���������
		}else{
			cond.setDate_q("2010/01/01 00:00");//���portalҳ���������
		}
		cond.setUserid(dto.getUserid());
		if(StringUtils.isNotEmpty(form.getDate())){
			cond.setDate_j(form.getDate()+" 23:59");//���portalҳ���������
		}else{
			cond.setDate_j("2020/01/01 23:59");//���portalҳ���������
		}
		if(StringUtils.isNotEmpty(qjassetid)){
			cond.setQjassetid(qjassetid);
		}
		if(StringUtils.isNotEmpty(qjassettypeid)){
			cond.setQjassettypeid(qjassettypeid);
		}
		int totalCount = this.quartzJobsBL.getQuartzJobsCountByUserDate(cond);
		if (totalCount == 0) {
			log.debug("========���ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========�������ݼ�������========");
			// ֪ʶ����������ݼ�������
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

			log.debug("========���ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========�������ݼ�������========");
			// ֪ʶ����������ݼ�������
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
	 * Description: �������ڲ�ѯ�������
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
	 * Description: ��ʱ������ID��ѯQuartzJobDetails
	 * </p>
	 * 
	 * @param integer IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @update
	 */
	public IGSCH01DTO searchQuartzJobDetailsByQjid(IGSCH01DTO dto) throws BLException{
		
		QuartzJobDetailsSearchCondImpl qjdcond = new QuartzJobDetailsSearchCondImpl();
		qjdcond.setQjid(dto.getIgsch0101Form().getQjid());//QuartzJobs�������ID

		// ��ѯ��¼����
		int totalCount = quartzJobDetailsBL.getSearchCount(qjdcond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<QuartzJobDetails> pjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(qjdcond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setQuartzJobDetailsList(pjdList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		
		return dto;
	}

	/**
	 * <p>
	 * Description: �������ڼ���¼�û���ѯ�������
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
			String curmonth = IGStringUtils.getCurrentDate().substring(5, 7);//��ǰ��
			String curyear = IGStringUtils.getCurrentYear();//��ǰ��
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