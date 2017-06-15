/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.bl;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH04DTO;
import com.deliverik.infogovernor.scheduling.form.IGSCH0401Form;
import com.deliverik.infogovernor.scheduling.jobs.IGSCH0401JOB;
import com.deliverik.infogovernor.scheduling.jobs.JOBCONSTANTS;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzJobsTB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_�������_�¼��ල�ӿ�ʵ����
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSCH04BLImpl extends BaseBLImpl implements IGSCH04BL {

	static Log log = LogFactory.getLog(IGSCH04BLImpl.class);

	private QuartzJobsBL quartzJobsBL;
	
	private RoleBL roleBL;
	
	private CodeDetailBL codeDetailBL;

	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * ��ѯ�¼�����
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO searchRoleAction(IGSCH04DTO dto) throws BLException {
		log.debug("========��ȡ�¼�������ʼ========");
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
		//����DAO�ӿڲ�ѯ
		List<Role> roleList = roleBL.searchRole(cond, 0, 0);
		cond.setRoletype(WorkFlowConstDefine.DISPATCH_ROLE_TYPE);
		//����DAO�ӿڲ�ѯ
		roleList.addAll(roleBL.searchRole(cond, 0, 0));
		dto.setRoleList(roleList);
		log.debug("========��ȡ�¼�����������========");
		return dto;
	}

	/**
	 * ���湤��
	 * 
	 * qjdesc����ٴ�����ʱ�����
	 * qjtricron��ű����ϼ�ʱ�����
	 * qjinfo���Ԥ�ƽ��ʱ����ԣ���ʽΪ��ʱ��#ʱ��#...
	 * qjcrtuser����¼������ɫid
	 * qjimpluser����¼������ɫ����
	 * qjorgname��Ž����̶�cidֵ����ʽΪ��cid#cid#...
	 * ͨ��qjname=JOBCONSTANTS.INCIDENT_MONITOR��ʶ������¼
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO saveQuartzJobsAction(IGSCH04DTO dto) throws BLException {
		log.debug("========�¼��ල���洦��ʼ========");
		IGSCH0401Form form = dto.getIgsch0401Form();
		String[] notifyTime = form.getNotifyTime();//�ٴ�����ʱ��
		String[] reportTime = form.getReportTime();//�����ϼ�ʱ��
		String[] resolveTime = form.getResolveTime();//Ԥ�ƽ��ʱ��
		String[] urgency = form.getUrgency();//�����̶�cidֵ
		form.setQjname(JOBCONSTANTS.INCIDENT_MONITOR);
		form.setQjtriname(JOBCONSTANTS.INCIDENT_MONITOR);
		form.setQjtrigrp(JOBCONSTANTS.INCIDENT_MONITOR_GROUP);
		
		String notifyTime_str = "";
		String reportTime_str = "";
		String resolveTime_str = "";
		String urgency_str = "";
		int count = form.getUrgencycount();
		//ƴ��ʱ������ַ���
		for(int i=0;i<count-1;i++){
			notifyTime_str += notifyTime[i]+"#";
			reportTime_str += reportTime[i]+"#";
			resolveTime_str += resolveTime[i]+"#";
			urgency_str += urgency[i]+"#";
		}
		notifyTime_str += notifyTime[count-1];
		reportTime_str += reportTime[count-1];
		resolveTime_str += resolveTime[count-1];
		urgency_str += urgency[count-1];
		
		form.setQjdesc(notifyTime_str);
		form.setQjtricron(reportTime_str);
		form.setQjinfo(resolveTime_str);
		form.setQjcrttime(IGStringUtils.getCurrentDateTime());
		form.setQjorgname(urgency_str);
		//ͣ��ʱ����
		if (!"A".equals(form.getQjstatus())) {
			try {
				JobManager.addJob(JOBCONSTANTS.INCIDENT_MONITOR,
						JOBCONSTANTS.INCIDENT_MONITOR_GROUP,
						JOBCONSTANTS.INCIDENT_MONITOR_TRI,
						JOBCONSTANTS.INCIDENT_MONITOR_TRI_GROUP,
						new IGSCH0401JOB(), JOBCONSTANTS.INCIDENT_MONITOR_PARSE);
			} catch (SchedulerException e) {
				throw new BLException("IGSCH0401.E005");
			} catch (ParseException e) {
				throw new BLException("IGSCH0401.E004");
			}
		}
		form.setQjstatus("A");//����
		QuartzJobs qj = quartzJobsBL.saveQuartzJobs(form);
		form.setQjid(qj.getQjid());
		form.setDefinitioned("1");
		dto.addMessage(new ActionMessage("IGSCH0401.I002"));
		log.debug("========�¼��ල���洦������========");
		return dto;
	}

	/**
	 * ��ֹ����
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO removeQuartzJobsAction(IGSCH04DTO dto) throws BLException {
		log.debug("========�¼��ල��ֹ����ʼ========");
		IGSCH0401Form form = dto.getIgsch0401Form();
		QuartzJobsTB qj = (QuartzJobsTB)quartzJobsBL.searchQuartzJobsByKey(form.getQjid());
		qj.setQjstatus("I");
		quartzJobsBL.saveQuartzJobs(qj);
		IGSCH0401Form temp = new IGSCH0401Form();
		this.copyProperties(form, temp);
		try {
			JobManager.removeJob(JOBCONSTANTS.INCIDENT_MONITOR,
					JOBCONSTANTS.INCIDENT_MONITOR_GROUP,
					JOBCONSTANTS.INCIDENT_MONITOR_TRI,
					JOBCONSTANTS.INCIDENT_MONITOR_TRI_GROUP);
		} catch (SchedulerException e) {
			throw new BLException("IGSCH0401.E006");
		}
		dto.addMessage(new ActionMessage("IGSCH0401.I003"));
		log.debug("========�¼��ල��ֹ��������========");
		return dto;
	}
	
	/**
	 * ɾ������
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
	public IGSCH04DTO deleteQuartzJobsAction(IGSCH04DTO dto) throws BLException {
		log.debug("========�¼��ලɾ������ʼ========");
		IGSCH0401Form form = dto.getIgsch0401Form();
		quartzJobsBL.deleteQuartzJobs(form.getQjid());
		IGSCH0401Form temp = new IGSCH0401Form();
		this.copyProperties(form, temp);
		try {
			JobManager.removeJob(JOBCONSTANTS.INCIDENT_MONITOR,
					JOBCONSTANTS.INCIDENT_MONITOR_GROUP,
					JOBCONSTANTS.INCIDENT_MONITOR_TRI,
					JOBCONSTANTS.INCIDENT_MONITOR_TRI_GROUP);
		} catch (SchedulerException e) {
			throw new BLException("IGSCH0401.E006");
		}
		dto.addMessage(new ActionMessage("IGSCH0401.I004"));
		log.debug("========�¼��ලɾ����������========");
		return dto;
	}
	
	/**
	 * ��ѯ����
	 * 
	 * @param dto IGSCH04DTO
	 * @return IGSCH04DTO
	 * @throws BLException
	 */
//	public IGSCH04DTO searchDynamicQuartzJobsAction(IGSCH04DTO dto) throws BLException {
	public IGSCH04DTO searchQuartzJobsAction(IGSCH04DTO dto) throws BLException {
		log.debug("========�¼��ල��ѯ����ʼ========");
		IGSCH0401Form form = dto.getIgsch0401Form();
		QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
		cond.setQjname(JOBCONSTANTS.INCIDENT_MONITOR);
		List<QuartzJobs> qjList = quartzJobsBL.searchQuartzJobs(cond, 0, 0);
		if (qjList.size() > 1) {
			throw new BLException("IGSCH0401.E001");
		} else if (qjList.size() == 1){
			form.setDefinitioned("1");
		}
		//��¼�¼���������
		int count = 0;
		String[] notifyTime = null;//�ٴ�����ʱ��
		String[] reportTime = null;//�����ϼ�ʱ��
		String[] resolveTime = null;//Ԥ�ƽ��ʱ��
		String[] urgencyname = null;//�����̶���������
		String[] urgency = null;//�����̶�����
		CodeDetailSearchCondImpl cdcond = new CodeDetailSearchCondImpl();
		cdcond.setCcid(CodeDefine.PROCESS_PRIORITY_I.getCcid());
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		count = codeDetailList.size();
		urgency = new String[count];
		urgencyname = new String[count];
		for(int i=0;i<count;i++){
			urgency[i] = codeDetailList.get(i).getCid();
			urgencyname[i] = codeDetailList.get(i).getCvalue();
		}
		if(qjList.isEmpty()){
			notifyTime = new String[count];
			reportTime = new String[count];
			resolveTime = new String[count];
		}else{
			for (QuartzJobs qj : qjList) {
				String notify = qj.getQjdesc();
				String report = qj.getQjtricron();
				String info = qj.getQjinfo();
				notifyTime = notify.split("#");
				reportTime = report.split("#");
				resolveTime = info.split("#");
				form.setQjcrtuser(qj.getQjcrtuser());
				form.setQjimpluser(qj.getQjimpluser());
				form.setQjid(qj.getQjid());
				form.setQjstatus(qj.getQjstatus());
			}
		}
		if (notifyTime == null) {
			throw new BLException("IGSCH0401.E002");
		}
		if (reportTime == null) {
			throw new BLException("IGSCH0401.E003");
		}
		if (resolveTime == null) {
			throw new BLException("IGSCH0401.E007");
		}
		form.setNotifyTime(notifyTime);
		form.setReportTime(reportTime);
		form.setResolveTime(resolveTime);
		form.setUrgency(urgency);
		form.setUrgencycount(count);
		form.setUrgencyname(urgencyname);
		dto.addMessage(new ActionMessage("IGSCH0401.I001"));
		log.debug("========�¼��ල��ѯ��������========");
		return dto;
	}

}