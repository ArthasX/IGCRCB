/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP01BLImpl extends BaseBLImpl implements IGDWP01BL{

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGDWP01BLImpl.class);
	
	/** �ճ������ƻ�ʵ��BL */
	protected IGDWP0001BL igdwp0001BL;
	
	/** �ճ������ƻ�������ϢBL */
	protected IGDWP0002BL igdwp0002BL;
	
	/** �ճ������ƻ�����ϢBL */
	protected IGDWP0003BL igdwp0003BL;
	
	/** �ճ������ƻ���������ϢBL */
	protected IGDWP0004BL igdwp0004BL;
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ���ŷ���BL */
	protected SendMessageBL sendMessageBL;
	
	/** �û���ϢBL */
	protected UserBL userBL;
	
	/** ��ɫ��ϢBL */
	protected RoleBL roleBL;
	
	/** ���̴���API */
	protected FlowOptBL flowOptBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;

	/** ���˹�������ID */
	protected String personageWork = "01084";
	/**
	 * �ճ������ƻ�ʵ��BL�趨
	 * @param igdwp0001BL �ճ������ƻ�ʵ��BL
	 */
	public void setIgdwp0001BL(IGDWP0001BL igdwp0001bl) {
		igdwp0001BL = igdwp0001bl;
	}
	
	/**
	 * �ճ������ƻ�������ϢBL�趨
	 * @param igdwp0002BL �ճ������ƻ�������ϢBL
	 */
	public void setIgdwp0002BL(IGDWP0002BL igdwp0002bl) {
		igdwp0002BL = igdwp0002bl;
	}

	/**
	 * �ճ������ƻ�����ϢBL�趨
	 * @param igdwp0003BL �ճ������ƻ�����ϢBL
	 */
	public void setIgdwp0003BL(IGDWP0003BL igdwp0003bl) {
		igdwp0003BL = igdwp0003bl;
	}

	/**
	 * �ճ������ƻ���������ϢBL�趨
	 * @param igdwp0004BL �ճ������ƻ���������ϢBL
	 */
	public void setIgdwp0004BL(IGDWP0004BL igdwp0004bl) {
		igdwp0004BL = igdwp0004bl;
	}

	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ���ŷ���BL�趨
	 * @param sendMessageBL ���ŷ���BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * �û���ϢBL�趨
	 * @param userBL �û���ϢBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ��ɫ��ϢBL�趨
	 * @param roleBL ��ɫ��ϢBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * ���̴���API�趨
	 * @param flowOptBL ���̴���API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * ������API�趨
	 * @param flowSetBL ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * �ճ������ƻ���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO searchDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("===============�ճ������ƻ���ѯ������ʼ===============");
		//ʵ������ѯ����
		IGDWP0001SearchCondImpl cond = new IGDWP0001SearchCondImpl();
		cond.setIsAddJob(IGDWPUtils.IS_ADD_JOB_NO);
		List<IGDWP0001Info> tempList = igdwp0001BL.search(cond);
		for(IGDWP0001Info info:tempList){
			igdwp0001BL.delete(info);
		}
		cond.setIsAddJob(IGDWPUtils.IS_ADD_JOB_YES);
		//����ѯ������ֵ
		this.copyProperties(cond, dto.getForm());
		//��ѯ�ܼ�¼��
		int totalCount = igdwp0001BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		List<IGDWP0001Info> list = igdwp0001BL.search(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setDayWorkPlanList(list);
		log.debug("===============�ճ������ƻ���ѯ��������===============");
		return dto;
	}
	
	/**
	 * �������Ͳ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO searchProcessDefinitions(IGDWP01DTO dto) throws BLException {
		log.debug("===============�������Ͳ�ѯ������ʼ================");
		//ʵ������ѯ����
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPrpdid_like_or(IGDWPUtils.getInstance().getProcessDefinitions().toArray(new String[0]));
		cond.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
		//��ѯ���̶�����Ϣ
		List<IG380Info> list = workFlowDefinitionBL.searchLastProcessDefinition(cond,0,0);
		//�������̶�������
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
		log.debug("===============�������Ͳ�ѯ��������================");
		return dto;
	}
	
	/**
	 * ��ʼ���ճ������ƻ�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("================�ճ������ƻ���Ϣ��ʼ��������ʼ=================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0103Form){
			//����ȡ��
			IGDWP0103Form form = (IGDWP0103Form) dto.getForm();
			if(form.getId() != null && form.getId() > 0){
				//�����ƻ���ѯ
				IGDWP0001Info info = igdwp0001BL.searchByPk(form.getId());
				this.copyProperties(form, info);
			}else{
				form.setPtype(IGDWPUtils.TASK_EXECUTE_TYPE_DAY);
				//==========�ö�Ϊ��³�����߼�start============
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
				//==========�ö�Ϊ��³�����߼�end==============
			}
		}
		log.debug("================�ճ������ƻ���Ϣ��ʼ����������=================");
		return dto;
	}
	
	/**
	 * �����ճ������ƻ�
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO insertDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("==============�ճ������ƻ�����������ʼ===============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0103Form){
			//����ȡ��
			IGDWP0103Form form = (IGDWP0103Form) dto.getForm();
			//��¼�û�ȡ��
			User user = dto.getUser();
			//ʵ����ʵ��
			IGDWP0001TB entity = new IGDWP0001TB();
			this.copyProperties(entity, form);
			entity.setPuserid(user.getUserid());
			entity.setPusername(user.getUsername());
			entity.setIsAddJob(IGDWPUtils.IS_ADD_JOB_NO);
			IGDWP0001Info info = igdwp0001BL.regist(entity);
			//����Ƕ��ŷ�ʽ�����ö��Ų���
			if(IGDWPUtils.TASK_MODE_SMS.equals(form.getPmode())){
				if(entity.getPdid().startsWith(personageWork)){
					setStrategy(info);
				}else{
					dto.setAssignFlag(IGDWPUtils.ASSIGN_FLAG_YES);
				}
			}
			form.setId(info.getId());
		}
		log.debug("==============�ճ������ƻ�������������===============");
		return dto;
	}
	
	/**
	 * ���ò���
	 * @param plan �ƻ���Ϣʵ��
	 */
	private void setStrategy(IGDWP0001Info plan) throws BLException{
		//��ȡ���ʽ
		String cronExpression = creatCronExp(plan.getPtype(), plan.getStartdate(), plan.getEnddate(), plan.getPhour(), plan.getPminute());
		String jobName = "DayWorkPlanJob" + plan.getId();
		String jobGroupName = "DayWorkPlanGroup" + plan.getId();
		String triggerName = "DayWorkPlanTrigger" + plan.getId();
		String triggerGroupName = "DayWorkPlanTriggerGroup" + plan.getId();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			IGDWP0001TB tb = (IGDWP0001TB)SerializationUtils.clone(plan);
			//���ƻ�û�н���ʱ�䣬��ȡ�ƻ���ʼʱ��Ϊ����ʱ��
			if(StringUtils.isEmpty(plan.getStartdate())){
				throw new RuntimeException("�ƻ�δ���ÿ�ʼʱ�䣡");
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
			//���¼ƻ���Ϣ
			tb.setIsAddJob(IGDWPUtils.IS_ADD_JOB_YES);
			igdwp0001BL.update(tb);
		} catch (Exception e) {
			log.error("==========Exception form DayWorkPlanInformJob===========");
			log.error("quarz����", e);
			throw new BLException("IGCO10000.E141", "quarz����");
		}
	}
	
	/**
	 * ɾ������
	 * @param plan ������Ϣ
	 */
	public void deleteStrategy(IGDWP0001Info plan){
		//ɾ��JOB
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
	 * ��ȡquartzִ�б��ʽ
	 * @param ptype ִ����������
	 * @param startdate ��ʼʱ��
	 * @param enddate ����ʱ��
	 * @param hour ʱ
	 * @param minute ��
	 * @return quartzִ�б��ʽ
	 */
	private String creatCronExp(String ptype, String startdate,String enddate,
			String hour, String minute){
		//quartzִ�б��ʽ
		String retCronExp = null;
		//�� �� ʱ �� �� ��
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
	 * ȡ��ָ�����������ڼ�
	 * @param strDate ����
	 * @param language ���Ը�ʽ(Ĭ�����ģ�en��ΪӢ��)
	 * @return ���ڼ�
	 */
	private String getWeekOfDate(String strDate,String language) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String[] weekDays = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};
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
	 * �ճ������ƻ��޸Ĳ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO changeDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("==============�ճ������ƻ��޸Ĳ�����ʼ==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0103Form){
			IGDWP0103Form form = (IGDWP0103Form) dto.getForm();
			//��ѯ�ƻ���Ϣ
			IGDWP0001TB planTB = (IGDWP0001TB) igdwp0001BL.searchByPk(form.getId());
			this.copyProperties(planTB, form);
			IGDWP0001Info plan = igdwp0001BL.update(planTB);
			//�������quartz
			deleteStrategy(plan);
			setStrategy(plan);
		}
		log.debug("==============�ճ������ƻ��޸Ĳ�������==============");
		return dto;
	}
	
	/**
	 * ����ִ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO execute(IGDWP01DTO dto) throws BLException {
		log.debug("=============����ִ�в�����ʼ==============");
		//ȡ�üƻ���Ϣ
		IGDWP0001Info plan = igdwp0001BL.searchByPk(dto.getId());
		//֪ͨ�����ִ��
		if(IGDWPUtils.TASK_MODE_SMS.equals(plan.getPmode())){
			sendMessage(plan);
		}else{
			launchProcess(plan);
		}
		log.debug("=============����ִ�в�������==============");
		return dto;
	}

	/**
	 * ��������
	 * @param plan �ƻ���Ϣ
	 */
	private void launchProcess(IGDWP0001Info plan) throws BLException{
		//��ʼʱ��
		String planStartPidid= plan.getPdid()+"002";
 		//����ʱ��
		String planEndPidid  = plan.getPdid()+"016";
		//��ѯҪ���������
		IGDWP0002SearchCondImpl cond = new IGDWP0002SearchCondImpl();
		cond.setPlanid(plan.getId());
		List<IGDWP0002Info> prList = igdwp0002BL.search(cond);
		for(IGDWP0002Info info:prList){
			//ʵ������־��Ϣ
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setExecutorid(plan.getPuserid());
			logInfo.setExecutorRoleid(info.getPrroleid());
			//ʵ����������Ϣ
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
			//��ѯ��ֵ
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
//						//�ƻ���ʼʱ��
//						//ȡ������  Ȼ�������ֵ
//						map.put(pid.getPidname(), "");
//					}else{
						//ȡ������  Ȼ�������ֵ
						map.put(pid.getPidname(), pi.getPivarvalue());
//					}
				}
			}
			record.setFormvalue(map);
			Integer prid = saveProcess(record,IGPRDCONSTANTS.BUTTON_UPDATE);
			logInfo.setPrid(prid);
			if(entityMap.size() > 0){
				//�����ʲ���Ϣ
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
			//��ѯ�����ɽڵ�
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(plan.getPdid() + "001", IGPRDCONSTANTS.BUTTON_SUBMIT);
			if(!lst_ProcessStatusDef.isEmpty()){
//				flowOptBL.transitionProcess(prid, plan.getPuserid(), "�ύ", IGStringUtils.getCurrentDateTime());
				//��ѯ����������Ϣ
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
				//�������ID ��Ϊ�� ��û�з����쳣 ��ô���̷�����
				//��Ҫ���ж���֪ͨ
				
				this.sendMessageBL.sendSmsToUser(plan.getPuserid(), plan.getPusername()+"����"+info.getPrtitle()+"�Ĺ���������!");
			}
			
		}
	}
		
	/**
	 * 
	 * ���̷���
	 * 
	 * @param processRecordInfo ���̷�����Ϣ
	 * @param action ��������
	 * @return ����ID
	 * @throws BLException
	 */
	private Integer saveProcess(ProcessRecordInfo processRecordInfo,String action) throws BLException{
		User user = userBL.searchUserByKey(processRecordInfo.getLogInfo().getExecutorid());
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(processRecordInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(processRecordInfo.getLogInfo().getAuthuserid());
		}
		//�����߽�ɫ
		Role role = roleBL.searchRoleByKey(processRecordInfo.getLogInfo().getExecutorRoleid());
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(processRecordInfo.getDefid());
		cond.setPdstatus(processRecordInfo.getDefstatus());
		List<IG380Info> lst_ProcessDefinition = workFlowDefinitionBL.searchProcessDefinition(cond);
		if(lst_ProcessDefinition.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "���̶���ID��" + processRecordInfo.getDefid() + "��");
		} else {
			IG259Info processTemplate = workFlowDefinitionBL.searchProcessTemplateByKey(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPtid());
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());
			psdCond.setPsdcode(Constants.PROCESS_STATUS_START);
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "����״̬");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "����״̬");
			} else {
				List<IG599Info> prInfoList = new ArrayList<IG599Info>();
				//��ѯ���̱�������Ϣ
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
						prInfo.setPidaccess("3");//��д
						prInfoList.add(prInfo);
					}
				}
				IG500TB instance = workFlowOperationBL.getProcessRecordTBInstance();
				instance.setPrpdid(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());//���̶���ID
				instance.setPrpdname(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdname());//���̶�������
				instance.setPrtitle(processRecordInfo.getTitle());//���̱���
				instance.setPrdesc(processRecordInfo.getDescription());//��������
				instance.setPrtype(processTemplate.getPttype());//��������
				instance.setPrinfo(user.getUsermobile());//���̷�������ϵ��ʽ
				instance.setPruserid(user.getUserid());//���̷�����ID
				instance.setPrusername(user.getUsername());//���̷���������
				instance.setPrroleid(role.getRoleid());//���̷����߽�ɫID
				instance.setPrrolename(role.getRolename());//���̷����߽�ɫ����
				instance.setProrgid(user.getOrgid());//���̷����߻��������
				instance.setProrgname(user.getOrgname());//���̷����߻�������
				//�Ƿ��������
				if(IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdstatus())){
					instance.setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
				}
				IG500Info processRecord = workFlowOperationBL.launchProcess(instance, user,
						processRecordInfo.getLogInfo().getExecutorRoleid(),
						null, null, processTemplate.getPttype(), prInfoList, processRecordInfo.getLogInfo().getComment(),
						lst_ProcessStatusDef.get(lst_ProcessDefinition.size() - 1).getPsdid(), action, null, authorizeuser,null,null,new HashMap<String, List<IG506TB>>(),null,null);
				log.debug(">>>�������̷������������������ID��" + processRecord.getPrid());
				return processRecord.getPrid();
			}
		}
		
	}
	/**
	 * ���Ͷ���
	 * @param plan �ƻ���Ϣʵ��
	 */
	private void sendMessage(IGDWP0001Info plan) {
		//ȡ�ö��ŷ�������
		String content = plan.getSmscontent();
		//==========�ö�Ϊ��³�����߼�===========
		//���˹������ŷ���ָ�����Ե���
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
		//���Ͷ���
		//==========�ö�Ϊ��³�����߼�===========
	}
	
	/**
	 * �������̶�����Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initProcessDefinitionAction(IGDWP01DTO dto) throws BLException {
		log.debug("=============�������̶�����Ϣ������ʼ================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0105Form){
			//��¼�û�ȡ��
			User user = dto.getUser();
			//����ȡ��
			IGDWP0105Form form = (IGDWP0105Form) dto.getForm();
			//��ѯ�ƻ���Ϣ
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getId());
			dto.setPlan(plan);
			//��ѯ���̶�����Ϣ
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(plan.getPdid());
			dto.setProcessDefinition(pd);
			//��ȡ�����ɫ
			List<LabelValueBean> roleList = this.workFlowDefinitionBL.searchInitProcessParticipantRole(user.getUserid(), pd.getPdid());
			if(roleList.isEmpty()) {
				throw new BLException("IGCO10000.E004","�����ɫ����");
			}
			if(StringUtils.isEmpty(form.getPrinfo())){
				form.setPrinfo(user.getUsermobile());
			}
			if(form.getPrroleid() == null || form.getPrroleid() == 0){
				form.setPrroleid(Integer.valueOf(roleList.get(0).getValue()));
			}
			dto.setLabelValueBeanList(roleList);
			//��ѯ���ⶨ����Ϣ
			IG243SearchCondImpl titlecond = new IG243SearchCondImpl();
			titlecond.setPdid(pd.getPdid());
			List<IG243Info> lstProcessTitleDef = workFlowDefinitionBL.searchProcessTitleDef(titlecond);
			dto.setPtdInfo(lstProcessTitleDef.get(0));
			//��ѯ��Ȩ��
			String psdid = pd.getPdid() + "001";
			//��ѯ״̬������Ϣ
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
			dto.setProcessStatusDef(psd);
			List<IG893Info> participantVariableVW = workFlowOperationBL.searchParticipantVariableVW(psdid,form.getPrroleid());
			Map<String, IG893Info> participantVariableMap = new HashMap<String, IG893Info>();
			for(IG893Info info:participantVariableVW){
				participantVariableMap.put(info.getPidid(), info);
			}
			//��ѯ��������Ϣ
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
		log.debug("=============�������̶�����Ϣ��������================");
		return dto;
	}
	
	/**
	 * �������̵Ǽǲ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO craeteProcessAction(IGDWP01DTO dto) throws BLException {
		log.debug("===============�������̵Ǽǲ�����ʼ==================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0105Form){
			//����ȡ��
			IGDWP0105Form form = (IGDWP0105Form) dto.getForm();
			//��ѯ�ƻ���Ϣ
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getId());
			//ʵ����������Ϣʵ��
			IGDWP0002TB prTB = new IGDWP0002TB();
			this.copyProperties(prTB, form);
			prTB.setId(null);
			prTB.setPlanid(form.getId());
			//��������ʵ����Ϣ
			IGDWP0002Info pr = igdwp0002BL.regist(prTB);
			dto.setProcess(pr);
			//�����ʲ���Ϣ
			Map<String, List<String>> entityMap = new HashMap<String, List<String>>();
			for(Iterator<Entry<Integer, String>> iter = form.getEntityMap().entrySet().iterator();iter.hasNext();){
				Entry<Integer, String> next = iter.next();
				String[] split = next.getValue().split("#");
				if(entityMap.get(split[0]) == null){
					entityMap.put(split[0],new ArrayList<String>());
				}
				entityMap.get(split[0]).add(split[1]);
			}
			//��¼��ֵ
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
					 * ��ʱһ�������ĸķ�
					 */
					//TODO
					if(form.getPidid().length==(i+1)){
						break;
					}
				}
			}
			//��ѯ�Ƿ���Ҫ����
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(plan.getPdid() + "001", IGPRDCONSTANTS.BUTTON_SUBMIT);
			if(!lst_ProcessStatusDef.isEmpty()){
				dto.setAssignFlag(IGDWPUtils.ASSIGN_FLAG_YES);
			}else{
				setStrategy(plan);
			}
		}
		log.debug("===============�������̵Ǽǲ�������==================");
		return dto;
	}
	
	/**
	 * �ճ������ƻ�����ҳ��ʼ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO initDayWorkPlanAssignAction(IGDWP01DTO dto) throws BLException {
		log.debug("============�ճ������ƻ�����ҳ��ʼ��������ʼ==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0106Form){
			//ҳ�����
			IGDWP0106Form form = (IGDWP0106Form) dto.getForm();
			//��ѯ�ƻ���Ϣ
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getPlanid());
			Map<IG333Info,Map<Role, List<UserInfo>>> map = new LinkedHashMap<IG333Info, Map<Role,List<UserInfo>>>();
			if(IGDWPUtils.TASK_MODE_SMS.equals(plan.getPmode())){
				IG333TB psd = new IG333TB();
				psd.setPsdid(plan.getPdid() + "001");
				psd.setPsdname("������Ա");
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
				//��ѯ�����ɽڵ�
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(plan.getPdid() + "001", IGPRDCONSTANTS.BUTTON_SUBMIT);
				UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
				for(IG333Info psd:lst_ProcessStatusDef){
					Map<Role, List<UserInfo>> roleMap = new LinkedHashMap<Role, List<UserInfo>>();
					//��ѯ�ɱ����ɽ�ɫ
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
		log.debug("============�ճ������ƻ�����ҳ��ʼ����������==============");
		return dto;
	}
	
	/**
	 * ���������Ϣ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO saveAssignAction(IGDWP01DTO dto) throws BLException {
		log.debug("==============���������Ϣ������ʼ===============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0106Form){
			//ҳ����Ϣ
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
			//��ѯ�ƻ���Ϣ
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getPlanid());
			//���ò���
			setStrategy(plan);
		}
		log.debug("==============���������Ϣ��������===============");
		return dto;
	}
	
	/**
	 * �ճ������ƻ�ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO deleteDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("============�ճ������ƻ�ɾ��������ʼ=============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0101Form){
			//ҳ�����ȡ��
			IGDWP0101Form form = (IGDWP0101Form) dto.getForm();
			//��ѯ�ƻ���Ϣ
			IGDWP0001Info plan = igdwp0001BL.searchByPk(form.getPlanid());
			//ɾ��JOB
			deleteStrategy(plan);
			//ɾ���ƻ���Ϣ
			igdwp0001BL.delete(plan);
		}
		log.debug("============�ճ������ƻ�ɾ����������=============");
		return dto;
	}
	
	/**
	 * �༭�ճ������ƻ���ʼ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDWP01DTO editDayWorkPlanAction(IGDWP01DTO dto) throws BLException {
		log.debug("=============�༭�ճ������ƻ���ʼ��������ʼ================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDWP0103Form){
			//����ȡ��
			IGDWP0103Form form = (IGDWP0103Form) dto.getForm();
			//�����ƻ���ѯ
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
			
			//��¼�û�ȡ��
			User user = dto.getUser();
			//��ѯ���̶�����Ϣ
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(igdwp0001info.getPdid());
			dto.setProcessDefinition(pd);
			//��η��������Ƕ����򲻲�ѯ������Ϣ
			if("0".equals(form.getPmode())){
				return dto;
			}
			//��ȡ�����ɫ
			List<LabelValueBean> roleList = this.workFlowDefinitionBL.searchInitProcessParticipantRole(user.getUserid(), pd.getPdid());
			if(roleList.isEmpty()) {
				throw new BLException("IGCO10000.E004","�����ɫ����");
			}
			if(StringUtils.isEmpty(form.getPrinfo())){
				form.setPrinfo(user.getUsermobile());
			}
			if(form.getPrroleid() == null || form.getPrroleid() == 0){
				form.setPrroleid(Integer.valueOf(roleList.get(0).getValue()));
			}
			dto.setLabelValueBeanList(roleList);
			
			//��ѯ���ⶨ����Ϣ
			IG243SearchCondImpl titlecond = new IG243SearchCondImpl();
			titlecond.setPdid(pd.getPdid());
			List<IG243Info> lstProcessTitleDef = workFlowDefinitionBL.searchProcessTitleDef(titlecond);
			dto.setPtdInfo(lstProcessTitleDef.get(0));
			//��ѯ��Ȩ��
			String psdid = pd.getPdid() + "001";
			//��ѯ״̬������Ϣ
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
			dto.setProcessStatusDef(psd);
			List<IG893Info> participantVariableVW = workFlowOperationBL.searchParticipantVariableVW(psdid,form.getPrroleid());
			Map<String, IG893Info> participantVariableMap = new HashMap<String, IG893Info>();
			for(IG893Info info:participantVariableVW){
				participantVariableMap.put(info.getPidid(), info);
			}
			//��ѯ��������Ϣ
			List<IG007Info> pidList = workFlowOperationBL.getProcessInfoDefs(pd.getPdid());
			List<IG007Info> processInfoList = new ArrayList<IG007Info>();
			for(IG007Info info:pidList){
				IG893Info variable = participantVariableMap.get(info.getPidid());
				if(variable != null){
					if(IGPRDCONSTANTS.PROCESSTITLE_HIDE.compareTo(variable.getPidaccess()) < 0){
						IG007TB tb = (IG007TB) info;
						// ֻ��
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
		log.debug("=============�༭�ճ������ƻ���ʼ����������================");
		return dto;
	}
}