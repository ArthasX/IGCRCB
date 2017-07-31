/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * @Description ���������BLʵ��
 * 
 * @date 2017��6��9��16:24:25
 * 
 * @author WangLiang
 *
 */
public class IGWIM01BLImpl extends BaseBLImpl implements IGWIM01BL{
	
	static Log log = LogFactory.getLog(IGWIM01BLImpl.class);
	
	/** ����������BLע�� */
	protected WorkDefinitionBL workDefinitionBL;
	
	/** ������ʵ������BLע�� */
	protected WorkInstanceBL workInstanceBL;
	
	/** ������־����BLע�� */
	protected WorkLogBL workLogBL;
	
	/** ��ԱBL */
	protected UserBL userBL;
	
	/** �û���ɫBLע�� */
	protected UserRoleBL userRoleBL;
	
	/** ��ɫBLע�� */
	protected RoleBL roleBL;
	
	/**
	 * ���������BL�趨
	 * @param ���������BL
	 */
	public void setWorkDefinitionBL(WorkDefinitionBL workDefinitionBL) {
		this.workDefinitionBL = workDefinitionBL;
	}
	
	/**
	 * ������ʵ������BL�趨
	 * @param ������ʵ������BL
	 */
	public void setWorkInstanceBL(WorkInstanceBL workInstanceBL) {
		this.workInstanceBL = workInstanceBL;
	}

	/**
	 * ������־����BLע���趨
	 * @param ������־����BLע��
	 */
	public void setWorkLogBL(WorkLogBL workLogBL) {
		this.workLogBL = workLogBL;
	}
	
	/**
	 * ��ԱBL
	 * @param ��ԱBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * �û���ɫBL�趨
	 * @param �û���ɫBLע��
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ��ɫBL�趨
	 * @param ��ɫBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * @Description �������Ǽ�
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO registerWorkDefinitionAction(IGWIM01DTO dto) throws BLException {
		log.info("==========������Ǽ�BL����ʼ==========");
		
		//���������Formȡ��
		IGWIM0101Form form = dto.getIgwim0101Form();
		//��½�û�ȡ��
		User user = dto.getUser();
		
		if(form!=null && form instanceof IGWIM0101Form){
			//��ȡϵͳ���ڣ�yyyy/MM/dd hh:mm��
			String currentDateTime = IGStringUtils.getCurrentDateTime();
			//����
			WorkDefinitionTB wdTB = new WorkDefinitionTB();
			BeanUtils.copyProperties(form, wdTB);
			//�����Ƿ�ÿ�����һ�췢��
			wdTB.setMonthLastDay(form.getMonthLastDay()==null?"N":form.getMonthLastDay());
			//���÷����ˣ���ǰ��¼�û���
			wdTB.setInitiatorId(user.getUsername());
			//���ô�������
			wdTB.setCrtDate(currentDateTime);
			
			//����BL���浽���������
			WorkDefinitionInfo definitionInfo = workDefinitionBL.registWorkDefinition(wdTB);
			//���湤��������Ϣ
			dto.setWorkDefinitionInfo(definitionInfo);
			
			//��ӹ���ʵ����ʱ����
			if("1".equals(definitionInfo.getWdstatus())){
				dto.setAddOrRemoveFlag("1");
				//��ӹ�����ʱ����
				jobManageAction(dto);
			}
			//���óɹ���ʾ��Ϣ
			dto.addMessage(new ActionMessage("IGCO10000.I004","��������Ϣ"));
		}
		log.info("==========������Ǽ�BL�������==========");
		return dto;
	}
	
	/**
	 * @Description ���������
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO updateWorkDefinitionAction(IGWIM01DTO dto) throws BLException {
		log.info("==========�������޸�BL������ʼ==========");
		//��ȡForm
		IGWIM0101Form form = dto.getIgwim0101Form();
		
		//ʵ�����������ʵ��
		WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(form.getWdid());
		
		//Copypropertiesʱ�ų�������{"��������","fingerprint","������","����ʱ��","�����ֶ�"}
		String[] strArray={"crtDate","fingerprint","initiatorId","wdcreatetime","reservedFiled"};
		
		//��Form��ֵ���������
		BeanUtils.copyProperties(form, definitionInfo,strArray);
		
		//����BL�޸Ĺ�������Ϣ
		workDefinitionBL.updateWorkDefinition(definitionInfo);
		
		//���湤��������Ϣ
		dto.setWorkDefinitionInfo(definitionInfo);
		
		//��ӹ���ʵ����ʱ����
		if("1".equals(definitionInfo.getWdstatus())){
			dto.setAddOrRemoveFlag("1");
			//��ӹ�����ʱ����
		}
		
		//���¹���ʵ����ʱ����
		jobManageAction(dto);
		
		//���óɹ���ʾ��Ϣ
		dto.addMessage(new ActionMessage("IGCO10000.I005","��������Ϣ"));
		
		log.info("==========�������޸�BL��������==========");
		return dto;
	}
	
	/**
	 * @Description ������������ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGWIM01DTO workDefinitionInitAction(IGWIM01DTO dto) throws BLException {
		log.debug("========������������ʼ��BL����ʼ========");
		
		//��ȡ���������Form
		IGWIM0101Form form = dto.getIgwim0101Form();
		
		// �ܼ���
		List<IGWIM01011VO> weekList = new ArrayList<IGWIM01011VO>();
		IGWIM01011VO week1vo = new IGWIM01011VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("��һ");
		weekList.add(week1vo);
		
		IGWIM01011VO week2vo = new IGWIM01011VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("�ܶ�");
		weekList.add(week2vo);
		
		IGWIM01011VO week3vo = new IGWIM01011VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("����");
		weekList.add(week3vo);
		
		IGWIM01011VO week4vo = new IGWIM01011VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("����");
		weekList.add(week4vo);
		
		IGWIM01011VO week5vo = new IGWIM01011VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("����");
		weekList.add(week5vo);
		
		IGWIM01011VO week6vo = new IGWIM01011VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("����");
		weekList.add(week6vo);
		
		IGWIM01011VO week7vo = new IGWIM01011VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("����");
		weekList.add(week7vo);
		
		// ÿ����������
		List<IGWIM01011VO> monthList = new ArrayList<IGWIM01011VO>();
		for (int i = 1; i < 31; i++) {
			// ��
			String dayvalue = String.valueOf(i);
			// �Ƿ���ѡ��
			IGWIM01011VO monthvo = new IGWIM01011VO();
			monthvo.setDayvalue(dayvalue);
			monthList.add(monthvo);
		}
		
		//Сʱ����
		List<IGWIM01011VO> hourList = new ArrayList<IGWIM01011VO>();
		for (int i = 0; i < 24; i++) {
			String hour = String.valueOf(i);
			IGWIM01011VO hourVo = new IGWIM01011VO();
			hourVo.setHourvalue(hour);
			hourList.add(hourVo);
		}
		
		//�ּ���
		List<IGWIM01011VO> minutesList = new ArrayList<IGWIM01011VO>();
		int j=0;
		for (int i = 0; i < 4; i++) {
			String minutes = String.valueOf(j);
			IGWIM01011VO minutesVo = new IGWIM01011VO();
			minutesVo.setMinutesvalue(minutes);
			minutesList.add(minutesVo);
			j+=15;
		}
		
		//��������wdid��Ϊ�գ���ѯ��������Ϣ
		if(form!=null && form.getWdid()!=null && form.getWdid()!=0){
			WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(form.getWdid());
			dto.setWorkDefinitionInfo(definitionInfo);
		}
		
		//����Ƶ�������ڼ���
		dto.setWeekList(weekList);
		//����Ƶ������������
		dto.setMonthList(monthList);
		//����Ƶ��Сʱ����
		dto.setHourList(hourList);
		//����Ƶ�ʷּ���
		dto.setMinutesList(minutesList);
		log.debug("========������������ʼ��BL�������========");

		return dto;
	}
	
	/**
	 * @Description ���ɹ�����ʱ������ʽ������
	 * @param wdCycle ����/Ƶ�ʣ�Y��day��week��month��quarter��halfyear��year��
	 * @param wdHour Сʱ
	 * @param wdMinutes ����
	 * @param beginDate ��ʼ���ڣ�yyyy/MM/dd hh:mm��
	 * @param singleChoose ������/Ƶ��Ϊ�ܻ��·�ʱ������ÿ�ܵ��ܼ�/ÿ�µļ��ţ����������Ϊ��
	 * @return ������ʱ������ʽ������
	 */
	private String generateExpression(String wdCycle, String wdHour, String wdMinutes, String beginDate, String singleChoose) {
		log.info("==========���ɹ�����ʱ������ʽ�����򣩿�ʼ==========");
		
		//������ʽ
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
		
		log.debug("<<<<<<<<<<�����ʱ������ʽ��"+expression+">>>>>>>>>>");
		
		log.info("==========���ɹ�����ʱ������ʽ�����򣩽���==========");
		return expression;
	}
	
	/**
	 * @Description ����ʵ����ʱ�������/����
	 * @param dto IGWIM01DTO ���� WorkDefinitionInfo��Ϣ��addOrRemoveFlag�������ʱ�������/�Ƴ���ʶaddOrRemoveFlag
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO jobManageAction(IGWIM01DTO dto) throws BLException {
		log.info("==========��ʱ�������BL������ʼ==========");
		
		//��ȡ��������Ϣ
		WorkDefinitionInfo wdInfo = dto.getWorkDefinitionInfo();
		
		//���������ƣ��൱��һ�������ռ䣩
		String jobGroupName = "WorkItemCheckGroup" + wdInfo.getWdid();	
		
		//����������
		String triggerName = "WorkItemCheckJobTrigger" + wdInfo.getWdid();	
		
		//������������
		String triggerGroupName = "WorkItemCheckJobTriggerGroup" + wdInfo.getWdid();	
		
		if("1".equals(dto.getAddOrRemoveFlag())){
			log.info("=====��Ӷ�ʱ����Job��ʼ=====");
			//���Job
			try {
				//���ڸ�ʽ��������
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				
				//Jobȡ��
				WorkItemJob workItemJob = new WorkItemJob();	
				
				//�����������keyname List����
				List<String> keyname = new ArrayList<String>();
				keyname.add("wdid");
				
				//�����������keyname Map����
				Map<String, Integer> args = new HashMap<String, Integer>();
				args.put("wdid", wdInfo.getWdid());
				
				//<<<<<��ʱ������ʽ�������������ȡ��ʼ>>>>>
				
				//������/�µ�ĳһ��
				String singleChoose = null;
				if ("week".equals(wdInfo.getCycle())) {
					// Ƶ��Ϊ��
					singleChoose = wdInfo.getWdweek();
				} else if ("month".equals(wdInfo.getCycle())) {
					//Ƶ��Ϊ��
					singleChoose = wdInfo.getWdmonth();
				}
				
				String wdHour = "";	//Сʱ
				String wdMinutes = "";	//����
				
				//ͨ������/Ƶ�ʾ�����ʼ���ڵĻ�ȡ��ʽ
				if("day".equals(wdInfo.getCycle()) || "week".equals(wdInfo.getCycle()) || "month".equals(wdInfo.getCycle())){
					//�죬�ܣ���ͨ�������б��ȡ��ʼ����
					wdHour = wdInfo.getWdhour();
					wdMinutes = wdInfo.getWdminute();
					
				}else{
					//���ȣ����꣬��ͨ�����ڿؼ���ȡ��ʼ����
					String[] startDate = wdInfo.getBeginDate().split("\\ ");
					//��ֿ�ʼ�����ַ������ʱ��
					String starttime = startDate[1];
					wdHour = starttime.split("\\:")[0];
					wdMinutes = starttime.split("\\:")[1];
				}

				// ȡ��ִ�����ڱ��ʽ
				String expression = null;

				if ("month".equals(wdInfo.getCycle()) && "Y".equals(wdInfo.getMonthLastDay())) {// Ƶ��Ϊÿ�����һ��
					// ȡ��ִ�����ڱ��ʽ,ÿ�����һ��
					expression = this.generateExpression(wdInfo.getMonthLastDay(), wdHour, wdMinutes, wdInfo.getBeginDate(), null);
					singleChoose = "���һ";
				} else {
					// �������һ������������/Ƶ��
					expression = this.generateExpression(wdInfo.getCycle(), wdHour, wdMinutes, wdInfo.getBeginDate(), singleChoose);
				}
				
				//<<<<<��ʱ������ʽ�������������ȡ����>>>>>
				
				//��ʼ����
				Date beganDate = format.parse(wdInfo.getBeginDate().length()>10?
						wdInfo.getBeginDate():wdInfo.getBeginDate()+" "+wdHour+":"+wdMinutes);
				
				//��������
				Date endDate = format.parse(wdInfo.getEstimateFinishDate());
				
				//��ӹ�����ʱ����
				JobManager.addJob(WorkItemJob.JOB_NAME, jobGroupName, triggerName, triggerGroupName, workItemJob, 
						keyname, args, expression, beganDate, endDate);
//				JobManager.addJob(WorkItemJob.JOB_NAME,workItemJob, expression);
				
			} catch (Exception e) {
				log.error("==========Exception form WorkItemCheckJob===========");
				log.debug(e.getMessage());
				log.error("quartz����", e);
				throw new BLException("", "SchedulerException");
			}
			log.info("=====��Ӷ�ʱ����Job����=====");
		}else{
			log.info("=====�Ƴ���ʱ����Job��ʼ=====");
			try {
				//�Ƴ�������ʱ����
				JobManager.removeJob(WorkItemJob.JOB_NAME, jobGroupName, triggerName, triggerGroupName);
			} catch (SchedulerException e) {
				log.error("==========Exception form WorkItemCheckJob===========");
				log.debug(e.getMessage());
				log.debug("quartz��������", e);
				throw new BLException("", "SchedulerException");
			}
			log.info("=====�Ƴ���ʱ����Job����=====");
		}
		log.info("==========��ʱ�������BL��������==========");
		return dto;
	}


	/**
	 * @Description �������ѯ
	 * @param dto
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO searchWorkDefinition(IGWIM01DTO dto) throws BLException {
		log.info("==========�������ѯBL����ʼ==========");
		
		//��ȡ�������ѯForm
		IGWIM0102Form form = dto.getIgwim0102Form();
		//ʵ������ѯ����
		WorkDefinitionSearchCondImpl cond = new WorkDefinitionSearchCondImpl();
		//���ù���������
		cond.setWdname(form.getWdname());
		//���÷�����
		cond.setInitiatorId(form.getInitiatorId());
		//���ø�����
		cond.setLeaderName(form.getLeaderName());
		//��������״̬
		cond.setWdstatus(form.getWdstatus());
		//���ÿ�ʼ���ڴ�
		cond.setBeginDateStart(form.getBeginDateStart());
		//���ÿ�ʼ���ڵ�
		cond.setBeginDateOver(form.getBeginDateOver());
		
		if(hasMostPower(dto.getUser().getUserid())){
			
			//�����Ȩ�ޣ����Բ鿴���з����˵Ĺ���
			//�����û�Ȩ�ޱ�ʶ
			form.setIsNormalUser("0");
			
		}else if(StringUtils.isNotEmpty(hasLeaderPower(dto.getUser().getUserid()))){
			
			//�����ĸ�����Ȩ�ޣ���ѯ�������Ĳ����µķ����˵����й���
			UserSearchCondImpl userCond = new UserSearchCondImpl();
			//���ò�ѯ����ORGID
			userCond.setOrgid(hasLeaderPower(dto.getUser().getUserid()));
			//������Ӧ����id���û��б�
			List<User> userList = userBL.searchUser(userCond);
			//ʵ�������ĸ��������û�userid����
			List<String> newlist = new ArrayList<String>();
			
			if(userList!=null && userList.size()>0){
				//�����������µ������û�ȡ��userid�ŵ�newlist������
				for (int i = 0; i < userList.size(); i++) {
					newlist.add(userList.get(i).getUsername());
				}
			}
			cond.setInitiatorId_in(newlist);
			//�����û�Ȩ�ޱ�ʶ
			form.setIsNormalUser("0");
			
		}else{
			
			//��������userid
			User user = userBL.searchUserByKey(dto.getUser().getUserid());
			//��ͨ�û���ֻ�ܲ鿴�Լ�����Ĺ���
			cond.setInitiatorId(dto.getUser().getUsername());
			//���õ�ǰ�û�ΪĬ�Ϸ�����
			form.setInitiatorId(user.getUsername());
			//������ͨ�û���ʶ
			form.setIsNormalUser("1");
		}
		
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		
		//��������
		int totalCount = workDefinitionBL.searchWorkDefinition(cond, 0, 0).size();
		
		if (totalCount == 0) {
			log.info("========������������ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.info("========���������ݼ�������========");
			// �û��������ݼ�������
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//����BL��ѯ��������Ϣ
		List<WorkDefinitionInfo> wdList = workDefinitionBL.searchWorkDefinition(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		//�����ѯ�����
		dto.setDefinitionInfos(wdList);
		//���÷�ҳ������
		pDto.setTotalCount(totalCount);
		
		log.info("==========�������ѯBL�������==========");
		return dto;
	}
	
	/**
	 * @Description ��������Ϣɾ������
	 * @param dto IGWIM01DTO
	 * @return IGRIS06DTO
	 * @throws BLException
	 */
	public IGWIM01DTO deleteWorkDefinitoinAction(IGWIM01DTO dto) throws BLException {
		log.debug("========��������Ϣɾ��BL����ʼ========");
		
		//����洢��ʾ��Ϣ���ַ�������
		StringBuffer sbMsg = new StringBuffer();
		
		//�����ѷ���Ĺ��������
		int launched = 0;
		
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			
			//��ȡɾ����wdid
			String wdid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ����������ȷ��
			WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(Integer.parseInt(wdid));
			
			if (definitionInfo == null){
				throw new BLException("IGCO10000.E004","ɾ�������������");
			}
			
			//�����������Ƿ��Ѿ�����
			WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
			
			//���ù������id��ѯ����
			cond.setWdid(definitionInfo.getWdid());
			
			//����BL��ѯ����ʵ��
			List<WorkInstanceInfo> wiInfoList = workInstanceBL.searchWorkInstance(cond);
			
			if(wiInfoList!=null && wiInfoList.size()>0){
				
				//�������ѷ���
				if(launched>0){
					sbMsg.append("��"+wiInfoList.get(0).getWdname());
					
				}else{
					sbMsg.append("���������ѷ���Ĺ����ɾ��ʧ�ܣ�\n");
					sbMsg.append(wiInfoList.get(0).getWdname());
				}
				
				launched++;
				
				log.info("##########"+sbMsg);
			}
			
		}
		
		//���û���ѷ���Ĺ��������ִ��ɾ��
		if(launched<=0){
			for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
				
				//��ȡɾ����wdid
				String wdid = dto.getDeleteEntityItem()[i];
				
				//ɾ��ǰɾ����������ȷ��
				WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(Integer.parseInt(wdid));
				
				//������ɾ��
				workDefinitionBL.deleteWorkDefinition(definitionInfo);
			}
			sbMsg.append("������ɾ���ɹ���");
		}
		
		//������ʾ��Ϣ
		dto.setMsg(sbMsg.toString());
		
		log.debug("========��������Ϣɾ��BL�������========");
		return dto;
	}
	
	/**
	 * @Description У�鹤�����Ƿ�Ϸ�
	 * @param info ����������Ϣ
	 * @return
	 * @throws ParseException 
	 */
	private IGWIM01DTO checkQuartzIslegitimate(IGWIM01DTO dto) throws ParseException{
		//�Ϸ���ʶ(false��Ĭ����Ч)
		String isInvalid = "0";
		
		WorkDefinitionInfo info = dto.getWorkDefinitionInfo();
		
		//����ϵͳ��ǰʱ��
		String currentTime = IGStringUtils.getCurrentDateTime();
		
		//��ȡԤ�����ʱ��
		String estimateFinishDate = info.getEstimateFinishDate();
		
		//����ѭ�����Ҵ�����ʶ
		int loopNum = 0;
		
		//��ȡ��ʼ���ڣ�yyyy/MM/dd hh:ss��
		String beginTime = info.getBeginDate();
		
		//������Ϊ�ա��»���
		String startTime = info.getBeginDate().substring(0, 10);	//��ȡ��ʼ���ڣ�yyyy/MM/dd��
		//ƴ�ӿ�ʼ���ں�ʱ�����ƴ�Ӻ��ʽΪ��yyyy/MM/dd hh:mm��
		if(StringUtils.isNotEmpty(startTime)){
			startTime += " "+info.getWdhour()+":"+info.getWdminute();
		}
		
		
		//ȡ���û�ѡ������ں�
		String chooseDay = info.getWdmonth();
		if(StringUtils.isNotEmpty(chooseDay) && chooseDay.length() < 2){
			//���ڣ�d�������һλ����
			chooseDay = "0"+chooseDay;
		}
		//�������һ��
		String chooseLastday = info.getMonthLastDay();
		
		//����ѡ�����
		String wdweek = info.getWdweek();
		//������ת����0~6��ֵ����
		int chooseWeek = -1;
		
		//<<<<<�������ڵļ�������ȽϷ�����ʱ��Ϳ�ʼ���ڣ���ʼ���ڲ������ڷ�����ʱ�䣩>>>>>
		if("quarter".equals(info.getCycle()) || "halfyear".equals(info.getCycle()) || "year".equals(info.getCycle())){
			
			//������Ϊ���ȡ��������
			int compairDate = compairDate(strParseDate(info.getBeginDate()), strParseDate(currentTime));
			if(compairDate == -1 || compairDate==0){
				isInvalid = "1";
				dto.setMsg("������״̬����ʧ�ܣ���ʼ����Ӧ������ϵͳ���ڣ�");
				dto.setIsInvalid(isInvalid);
				return dto;
			}
			
			if("quarter".equals(info.getCycle())){
				
				//����Ϊ����
				loopNum = 92;
				
			}else if("halfyear".equals(info.getCycle())){
				
				//����Ϊ����
				loopNum = 183;
				
			}else if("year".equals(info.getCycle())){
				
				//����Ϊ��
				loopNum = 366;
			}
			
			//2017��7��12�պ�FXyȷ�ϵ��߼�Ϊ��֤Quartz������ִ��һ��Ϊ��׼����֤�����ȡ����ꡢ��������У��
			//<<<<<����ѭ��У��>>>>>
			
		}else{
			
			//�ȽϿ�ʼ���ں�ϵͳ����
			int compairDate = compairDate(strParseDate(startTime), strParseDate(currentTime));
			
			if(compairDate ==-1 || compairDate==0){
				//�����ʼ����С��ϵͳ���ڣ�������ʾ
				isInvalid = "1";
				dto.setMsg("������״̬����ʧ�ܣ���ʼ����Ӧ������ϵͳ���ڣ�");
				dto.setIsInvalid(isInvalid);
				return dto;
			}
			
			if("day".equals(info.getCycle())){
				
				//����Ϊ�ա�����Ҫѭ�����ң���Ϊ��ÿ��Ϊ���ڣ�ֻҪ��֤��ʼ���ڴ���ϵͳ���ں�Ԥ���������С�ڿ�ʼ����ͨ�����ɡ�
				isInvalid = "0";
				dto.setIsInvalid(isInvalid);
				return dto;
				
			}else if("week".equals(info.getCycle())){
				
				//����Ϊ��
				loopNum = 7;
				
			}else{
				
				//����Ϊ��
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
		
		//����Ԥ��������ںͿ�ʼ���ڵĲ�ֵ������ѭ�������ǲ�ֵ����С��1������С��31�죬����Ҫ�õ�ÿ������ڣ��ţ���ѡ��Ľ��жԱȣ�û�������֤δͨ����
		//����ֵ>=31����һ������Quartz����ִ��һ�εĹ���ͨ����֤
		
		Date startDate = new Date(startTime);	//�ѿ�ʼ����ת�����ڸ�ʽ
		
		Date estimatedDate = new Date(estimateFinishDate);	//��Ԥ���������ת�����ڸ�ʽ
		
		int diff = daysBetween(startTime, estimateFinishDate);	//�����������ڵĲ�죩

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm");
		
		Calendar cal = Calendar.getInstance();  
		
		//<<<<<��ʼѭ��У��>>>>>
		if(diff > 0){
			//���ڲ�С��ָ���죬�������ڲ������������һһ�Ա�
			if(diff < loopNum){
				
				//�����Ƿ�ƥ�����ڵı�ʶ��0����1���ǣ���
				int equalFlag = 0;
				
				for (int i = 0; i <= diff; i++) {
					
					if("month".equals(info.getCycle())){
						
						//�Ƚ������һ��
						if("Y".equals(chooseLastday)){
							if(i!=0){
								
								//��ȡ��ʼ���ڵ���һ����û�ѡ������ڱȽ�
								String dateAfter=sdf.format(getDateAfter(strParseDate(startTime), i+1));  
								if(!(dateAfter.substring(5,7) .equals(startTime.substring(5,7)))){
									//�����һ���ʱ�䣨hh:mm�����ڵ����û�ѡ������ڣ�dd��������һ������ڣ��ţ�ƥ�䵽�û�ѡ������ںţ�����Ϊ��Ч��������Ч
									equalFlag = 1;
									break;
								}
							}else{
								//�Ƚϵ�һ��
								//��ȡ��ʼ���ڵ���һ����û�ѡ������ڱȽ�
								String dateAfter=sdf.format(getDateAfter(strParseDate(startTime),0));  
								if(!(dateAfter.substring(5,7) .equals(startTime.substring(5,7)))){
									//�����һ���ʱ�䣨hh:mm�����ڵ����û�ѡ������ڣ�dd��������һ������ڣ��ţ�ƥ�䵽�û�ѡ������ںţ�����Ϊ��Ч��������Ч
									equalFlag = 1;
									break;
								}
								
							}
						}else{
							//�Ƚ���
							
							//��ȡ1~30��
							if(i!=0){
								
								//��ȡ��ʼ���ڵ���һ����û�ѡ������ڱȽ�
								String dateAfter=sdf.format(getDateAfter(strParseDate(startTime),i));  
								if(dateAfter.substring(8,10).equals(chooseDay)){
									//�����һ���ʱ�䣨hh:mm�����ڵ����û�ѡ������ڣ�dd��������һ������ڣ��ţ�ƥ�䵽�û�ѡ������ںţ�����Ϊ��Ч��������Ч
									equalFlag = 1;
									break;
								}
							}else{
								//�Ƚϵ�һ��
								if(startTime.substring(8,10).equals(chooseDay)){
									//�����һ���ʱ�䣨hh:mm�����ڵ����û�ѡ������ڣ�dd��������һ������ڣ��ţ�ƥ�䵽�û�ѡ������ںţ�����Ϊ��Ч��������Ч
									equalFlag = 1;
									break;
								}
								
							}
						}
					}
					
					
					//�Ƚ���
					if("week".equals(info.getCycle())){
						if(i!=0){
							
							//��ȡ��ʼ���������ڼ�
							
					        cal.setTime(getDateAfter(strParseDate(startTime), i));  
					        int whichWeek = cal.get(Calendar.DAY_OF_WEEK) - 1; 
							
							//��ȡ��ʼ���ڵ���һ����û�ѡ������ڱȽ�
							if(whichWeek == chooseWeek){
								//�����һ���ʱ�䣨hh:mm�����ڵ����û�ѡ������ڣ�dd��������һ������ڣ��ţ�ƥ�䵽�û�ѡ������ںţ�����Ϊ��Ч��������Ч
								equalFlag = 1;
								break;
							}
						}else{
							
							//��ȡ��ʼ���������ڼ�
							cal.setTime(startDate);  
							int whichWeek = cal.get(Calendar.DAY_OF_WEEK) - 1; 
							
							//�Ƚϵ�һ��
							if(whichWeek == chooseWeek){
								//�����һ���ʱ�䣨hh:mm�����ڵ����û�ѡ������ڣ�dd��������һ������ڣ��ţ�ƥ�䵽�û�ѡ������ںţ�����Ϊ��Ч��������Ч
								equalFlag = 1;
								break;
							}
							
						}
					}
					
					if("quarter".equals(info.getCycle()) || "halfyear".equals(info.getCycle()) || "year".equals(info.getCycle())){
						//�Ƚϼ��ȡ����ꡢ��
						if(i!=0){
							
							//��ȡ��ʼ���ڵ���һ����û�ѡ������ڱȽ�
							String dateAfter=sdf.format(getDateAfter(strParseDate(beginTime),i)); 
							if(dateAfter.substring(8,10) == chooseDay){
								//�����һ���ʱ�䣨hh:mm�����ڵ����û�ѡ������ڣ�dd��������һ������ڣ��ţ�ƥ�䵽�û�ѡ������ںţ�����Ϊ��Ч��������Ч
								equalFlag = 1;
								break;
							}
						}else{
							//�Ƚϵ�һ��
							if(beginTime.substring(8,10) == chooseDay){
								//�����һ���ʱ�䣨hh:mm�����ڵ����û�ѡ������ڣ�dd��������һ������ڣ��ţ�ƥ�䵽�û�ѡ������ںţ�����Ϊ��Ч��������Ч
								equalFlag = 1;
								break;
							}
							
						}
					}
					
				}
				//ѭ��������
				if(equalFlag==0){
					isInvalid = "1";
					dto.setMsg("������״̬����ʧ�ܣ��ù��������ڳ�����Χ�����޸ĺ��������ã�");
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
			//�Ƚ��û���ѡ���ڣ�dd���Ƿ�Ϳ�ʼ����Ϊͬһ�죬������ǣ���Ƿ�
			if(startTime.substring(8,10) != chooseDay){
				isInvalid = "1";
				dto.setMsg("������״̬����ʧ�ܣ��ù��������ڳ�����Χ�����޸ĺ��������ã�");
				dto.setIsInvalid(isInvalid);
				return dto;
			}else{
				isInvalid = "0";
				dto.setIsInvalid(isInvalid);
			}
		}
		//<<<<<����ѭ��У��>>>>>
		return dto;
	}
	
	/**
	 * @Description ������״̬�޸�
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 * @throws ParseException 
	 * @throws BeansException 
	 */
	public IGWIM01DTO updateWorkDefinitionStatusAction(IGWIM01DTO dto) throws BLException, BeansException, ParseException {
		log.info("==========������״̬�޸�BL������ʼ==========");
		
		//��ȡ���������Form
		IGWIM0101Form form = dto.getIgwim0101Form();
		
		//ʵ�����������ʵ��
		WorkDefinitionInfo definitionInfo = workDefinitionBL.searchWorkDefinitionByPK(form.getWdid());
		
		if(definitionInfo!=null){
			
			dto.setWorkDefinitionInfo(definitionInfo);
			
			//�����0֤��Ҫ����
			if("0".equals(definitionInfo.getWdstatus())){
				
				//У��Quartz�Ϸ���
				dto = checkQuartzIslegitimate(dto);
				
				if("0".equals(dto.getIsInvalid())){
					
					//ʵ����WorkDefinitionTB
					WorkDefinitionTB definitionTB = new WorkDefinitionTB();
					
					//��definitionInfo��ֵ��definitionTB
					BeanUtils.copyProperties(definitionInfo, definitionTB);
					
					//<!----------ͣ�ù�����ʱ���ʵ��������ڿ�ʼ-2017��7��3��13:13:04-WangLiang-------->
					if("1".equals(definitionInfo.getWdstatus())){
						
						definitionTB.setActualFinishDate("");
					}
					//<!----------ͣ�ù�����ʱ���ʵ��������ڽ���---------->
					
					//��������1��������ͣ��0��������������
					definitionTB.setWdstatus("1".equals(definitionInfo.getWdstatus())?"0":"1");
					
					//����BL�޸Ĺ�������Ϣ
					WorkDefinitionInfo wdInfo = workDefinitionBL.updateWorkDefinition(definitionTB);
					
					if("1".equals(wdInfo.getWdstatus())){
						dto.setAddOrRemoveFlag("1");
					}else{
						dto.setAddOrRemoveFlag("2");
					}
					
					//���湤����ʱ����
					dto.setWorkDefinitionInfo(wdInfo);
					
					//�����ʱ�������
					jobManageAction(dto);
					
					dto.setMsg("������״̬���³ɹ���");
					
				}else{
					
					return dto;
				}
			}else{
				
				//ʵ����WorkDefinitionTB
				WorkDefinitionTB definitionTB = new WorkDefinitionTB();
				
				//��definitionInfo��ֵ��definitionTB
				BeanUtils.copyProperties(definitionInfo, definitionTB);
				
				//<!----------ͣ�ù�����ʱ���ʵ��������ڿ�ʼ-2017��7��3��13:13:04-WangLiang-------->
				if("1".equals(definitionInfo.getWdstatus())){
					
					definitionTB.setActualFinishDate("");
				}
				//<!----------ͣ�ù�����ʱ���ʵ��������ڽ���---------->
				
				//��������1��������ͣ��0��������������
				definitionTB.setWdstatus("1".equals(definitionInfo.getWdstatus())?"0":"1");
				
				//����BL�޸Ĺ�������Ϣ
				WorkDefinitionInfo wdInfo = workDefinitionBL.updateWorkDefinition(definitionTB);
				
				if("1".equals(wdInfo.getWdstatus())){
					dto.setAddOrRemoveFlag("1");
				}else{
					dto.setAddOrRemoveFlag("2");
				}
				
				//���湤����ʱ����
				dto.setWorkDefinitionInfo(wdInfo);
				
				//�����ʱ�������
				jobManageAction(dto);
				
				dto.setMsg("������״̬���³ɹ���");
			}
			
			
		}
		log.info("==========������״̬�޸�BL��������==========");
		return dto;
	}
	
	
	/**
	 * @Description ������ʵ��
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 * 
	 */
	public IGWIM01DTO registerWorkInstanceAction(IGWIM01DTO dto) throws BLException{
		log.info("==========����ʵ������BL����ʼ==========");
		//�����������������Ϣ
		WorkDefinitionInfo wdInfo = workDefinitionBL.searchWorkDefinitionByPK(dto.getWdid());
		
		//ʵ��������ʵ��
		WorkInstanceTB wiTB = new WorkInstanceTB();
		//���ù������id
		wiTB.setWdid(wdInfo.getWdid());
		//���ù���������
		wiTB.setWdname(wdInfo.getWdname()+"������"+DateUtils.getCurrentYear()+DateUtils.getCurrentMonth()+DateUtils.getCurrentDate());
		//���ù���״̬
		wiTB.setWistatus("δִ��");
		
		//�����ʶ��Ϊ�գ����ֶ����𣬷���Ϊ�Զ�����
		if(StringUtils.isNotEmpty(dto.getLaunchFlag())){
			
			//�ֶ��������÷�����
			wiTB.setInitiatorId(dto.getUser().getUsername());
			//���÷�������
			wiTB.setWiLunchType("2");
			//���ÿ�ʼ����
			wiTB.setBeginDate(IGStringUtils.getCurrentDateTime());
		}else{
			
			//�Զ��������÷�����
			wiTB.setInitiatorId(wdInfo.getInitiatorId());
			//���÷�������
			wiTB.setWiLunchType("1");
			//���ÿ�ʼ����
			wiTB.setBeginDate(wdInfo.getBeginDate());
		}
		//��������/Ƶ��
		wiTB.setCycle(wdInfo.getCycle());
		//���ø�����id
		wiTB.setLeaderId(wdInfo.getLeaderId());
		//���ø���������
		wiTB.setLeaderName(wdInfo.getLeaderName());
		//����ִ����id
		wiTB.setExcutorId(wdInfo.getExcutorId());
		//����ִ��������
		wiTB.setExcutorName(wdInfo.getExcutorName());
		//���ô�������
		wiTB.setCrtDate(DateUtils.getCurrentTime());
		//����BL��������ʵ��
		WorkInstanceInfo workInstanceInfo = workInstanceBL.registWorkInstance(wiTB);
		
		//���湤����ʵ����Ϣ
		dto.setWorkInstanceInfo(workInstanceInfo);
		
		//������־����Ϣ
		registerWorkLogAction(dto);
		
		dto.setMsg("����ʵ������ɹ���");
		
		log.info("==========����ʵ������BL�������==========");
		return dto;
	}
	
	
	/**
	 * @Description ����������־
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 * 
	 */
	public IGWIM01DTO registerWorkLogAction(IGWIM01DTO dto) throws BLException{
		log.info("==========������־����BL����ʼ==========");
		//��ȡ����ʵ��
		WorkInstanceInfo workInstanceInfo = dto.getWorkInstanceInfo();
		
		//ʵ����������־
		WorkLogTB wlTB = null;
		
		if(workInstanceInfo!=null){
			//��ȡִ����id
			String excutorId = workInstanceInfo.getExcutorId();
			//��ȡִ��������
			String excutorName = workInstanceInfo.getExcutorName();
			//ʵ����������־
			
			for (int i = 0; i < excutorId.split("��").length; i++) {
				
				wlTB = new WorkLogTB();
				
				//���ù���ʵ��wiid
				wlTB.setWiid(workInstanceInfo.getWiid());
				//����ִ����id
				wlTB.setExcutorId(excutorId.split("��")[i]);
				//����ִ��������
				wlTB.setExcutorName(excutorName.split("��")[i]);
				//���ð�ť����
				wlTB.setBtnAction("2");
				//���ô�������
				wlTB.setCrtDate(IGStringUtils.getCurrentDateTime());
				
				//����BL����������־
				workLogBL.registWorkLog(wlTB);
			}
			
		}
		
		log.info("==========������־����BL�������==========");
		return dto;
	}
	
	/**
	 * @Description ���������ݵ���
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO importData(IGWIM01DTO dto) throws BLException{
		log.info("==========���������ݵ���BL����ʼ==========");
		//��ȡform
		IGWIM0102Form form = dto.getIgwim0102Form();
		//������
        Workbook xwb = null;
        FormFile file = null;
        file = form.getFileMap();
        try {
    		log.info("==============����excel�ļ�����==============");
    		xwb = Workbook.getWorkbook(file.getInputStream());
    		log.info("============�ļ������ɹ�============");
    	} catch (Exception e) {
    		saveResult(form,"�����ļ�����!");
    	}
        //��ȡsheetҳ
        Sheet sheet = xwb.getSheet(0);
        //��ȡ��������
        int rows = sheet.getRows();
        //�ж��Ƿ�������ݣ�����������������׳�����
        if(rows<=2){
        	saveResult(form,"û�������������ϴ���");
        }
        //�������ݲ��Ҳ�������
        for(int i=2;i<rows-1;i++){
        	//��ȡ����������
        	 String startPeople =  sheet.getCell(0,i).getContents();
        	 if(StringUtils.isEmpty(startPeople)){
        		 break;
        	 }
        	 //�ж��Ƿ���Ա�Ƿ����
        	 if(!(StringUtils.isNotEmpty(startPeople)&&searchUser(startPeople,""))){
        		 saveResult(form,"��"+(i+1)+"�з�����("+startPeople+")û�����ݻ��߷�������д����ȷ��˶Ժ����ϴ���");
        	 }
        	 //��ȡ����������
        	 String workName =  sheet.getCell(1,i).getContents();
        	 if(StringUtils.isEmpty(workName)){
        		 saveResult(form,"��"+(i+1)+"�й���������û��������˶Ժ����ϴ���");
        	 }
        	 //��ȡ����������
        	 String workDesc =  sheet.getCell(2,i).getContents();
        	 //��ȡ����
        	 String cycle  =  sheet.getCell(3,i).getContents();
        	 if(StringUtils.isEmpty(cycle)){
        		 saveResult(form,"��"+(i+1)+"������û��������˶Ժ����ϴ���");
        	 }
        	 //��ȡ������
        	 String weekContent = sheet.getCell(4,i).getContents();
        	 if("ÿ��".equals(cycle)&&StringUtils.isEmpty(weekContent)){
        		 saveResult(form,"��"+(i+1)+"������ѡ�����ÿ�ܣ�����Ϊ������˶Ժ����ϴ���"); 
        	 }
        	 //��ȡ����
        	 String monthContent = sheet.getCell(5,i).getContents();
        	 if("ÿ��".equals(cycle)&&StringUtils.isEmpty(monthContent)){
        		 saveResult(form,"��"+(i+1)+"������ѡ�����ÿ�£�������Ϊ������˶Ժ����ϴ���"); 
        	 }
        	 //��ȡʱ
        	 String hour = sheet.getCell(6,i).getContents();
        	 if(("ÿ��".equals(cycle)||"ÿ��".equals(cycle)||"ÿ��".equals(cycle))&&StringUtils.isEmpty(hour)){
        		 saveResult(form,"��"+(i+1)+"������ѡ�����ÿ���ÿ�ܻ�ÿ�£���СʱΪ������˶Ժ����ϴ���"); 
        	 }
        	 
        	 //��ȡ��
        	 String minute = sheet.getCell(7,i).getContents();
        	 if(("ÿ��".equals(cycle)||"ÿ��".equals(cycle)||"ÿ��".equals(cycle))&&StringUtils.isEmpty(minute)){
        		 saveResult(form,"��"+(i+1)+"������ѡ�����ÿ���ÿ�ܻ�ÿ�£����Ϊ������˶Ժ����ϴ���"); 
        	 } 
        	 
        	 //��ȡ��ʼ����
        	 String startDate = sheet.getCell(8,i).getContents();
        	 if(StringUtils.isEmpty(startDate)){
        		 saveResult(form,"��"+(i+1)+"�п�ʼ����Ϊ������˶Ժ����ϴ���"); 
        	 } 
        	 if(!isDate(startDate)){
        		 saveResult(form,"��"+(i+1)+"�п�ʼ������д������˶Ժ����ϴ���");
        	 }
        	 //��ȡԤ�����ʱ��
        	 String expectDate = sheet.getCell(9,i).getContents();
        	 if(StringUtils.isNotEmpty(expectDate)&&!isDate(expectDate)){
        		 saveResult(form,"��"+(i+1)+"��Ԥ�����ʱ����д������˶Ժ����ϴ���");
        	 }
        	 //��ȡ������ID
        	 String leadPeopleId =  sheet.getCell(10,i).getContents();
        	 //�ж��Ƿ���Ա�Ƿ����
        	 if(!(StringUtils.isNotEmpty(leadPeopleId)&&searchUser(leadPeopleId,""))){
        		 saveResult(form,"��"+(i+1)+"�и�����("+leadPeopleId+")û�����ݻ��߷�������д����ȷ��˶Ժ����ϴ���");
        	 }
        	 String leadPeopleName = searchUserName(leadPeopleId);
        	 //��ȡִ����
        	 String excutePeopleId = sheet.getCell(11,i).getContents();
        	 String[] excutePeopleIdArr =  excutePeopleId.split("��");
        	 String excutePeopleName = "";
        	 if(excutePeopleIdArr == null||excutePeopleIdArr.length==0){
        		 saveResult(form,"��"+(i+1)+"��ִ����("+excutePeopleId+")û�����ݻ��߷�������д����ȷ��˶Ժ����ϴ���");
        	 }else{
        		 for(String userid:excutePeopleIdArr){
                	 //�ж��Ƿ���Ա�Ƿ����
                	 if(!(searchUser(userid,""))){
                		 saveResult(form,"��"+(i+1)+"��ִ����("+excutePeopleId+")û�����ݻ��߷�������д����ȷ��˶Ժ����ϴ���");
                	 }else{
                		 excutePeopleName+=searchUserName(userid)+"��";
                		 
                	 }
        		 }
        	 }
        	 //��ȡ��ʱ����ʱ��
        	 String overDate =  sheet.getCell(12,i).getContents();
        	 if(StringUtils.isEmpty(overDate)){
        		 saveResult(form,"��"+(i+1)+"�г�ʱ����ʱ��û��������˶Ժ����ϴ���");
        	 }
        	 //��������0���ϵ�����
        	 try {
				int overTimes = Integer.parseInt(overDate);
			} catch (NumberFormatException e) {
				saveResult(form,"��"+(i+1)+"�г�ʱ����ʱ����д������˶Ժ����ϴ���");
			}
        	 if(Integer.parseInt(overDate)<1){
        		 saveResult(form,"��"+(i+1)+"�г�ʱ����ʱ����д������˶Ժ����ϴ���");
        	 }
        	//��ȡ��ʱֹͣ����ʱ��
        	 String overStopDate =  sheet.getCell(13,i).getContents();
        	 if(StringUtils.isEmpty(overDate)){
        		 saveResult(form,"��"+(i+1)+"�г�ʱֹͣ����ʱ��û��������˶Ժ����ϴ���");
        	 }
        	 //��������0���ϵ�����
        	 try {
				int overStopTime = Integer.parseInt(overStopDate);
			} catch (NumberFormatException e) {
				saveResult(form,"��"+(i+1)+"�г�ʱֹͣ����ʱ����д������˶Ժ����ϴ���");
			}
        	 if(Integer.parseInt(overStopDate)<1){
        		 saveResult(form,"��"+(i+1)+"�г�ʱֹͣ����ʱ����д������˶Ժ����ϴ���");
        	 }
        	 String desc =  sheet.getCell(14,i).getContents();
        	 saveWorkDefine(startPeople, workName, workDesc, cycle, weekContent, monthContent, hour, minute, startDate, expectDate, leadPeopleId, leadPeopleName, excutePeopleId, excutePeopleName, overDate, overStopDate, desc);
        }
        form.setResult("����ɹ���");
		log.info("==========���������ݵ���BL�������==========");
		return dto;
		
	}
	/**
	 * ��ѯ���Ƿ����
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
	 * ��ѯ���Ƿ����
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
	 * ����У���������׳�����
	 * @param result У����
	 * @param result form
	 * @throws BLException
	 */
	private void saveResult(IGWIM0102Form form,String result) throws BLException{
		log.error(result);
 		form.setResult(result);
 		throw new BLException("IGALM0101.E001",result);
	}
	
	/**
	 * У��������д�Ƿ���ȷ
	 * @param date �����ַ���
	 * @return
	 */
	private boolean isDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			format.parse(date);
			return true;
		} catch (ParseException e) {
			e.printStackTrace();
			log.error(date+"ת�����ڸ�ʽ����");
			return false;
		}
	}
	
	/**
	 * ���湤�����
	 * @param startPeople ������
	 * @param workName ����������
	 * @param workDesc ����������
	 * @param cycle ����
	 * @param weekContent ��
	 * @param monthContent ����
	 * @param hour Сʱ
	 * @param minute ����
	 * @param startDate ��ʼ����
	 * @param expectDate Ԥ��
	 * @param leadPeople ������ID
	 * @param leadPeopleName ����������
	 * @param excutePeople ִ����ID
	 * @param excutePeopleName ִ��������
	 * @param overDate ��ʱ����ʱ��
	 * @param overStopDate ��ʱֹͣ����ʱ��
	 * @param desc ��ע
	 * @throws BLException 
	 */
	private void saveWorkDefine(String startPeople,String workName,String workDesc,String cycle,String weekContent,String monthContent,String hour,String minute,String startDate,String expectDate,String leadPeopleId,String leadPeopleName,String excutePeopleId,String excutePeopleName,String overDate,String overStopDate,String desc) throws BLException{
		WorkDefinitionTB tb = new WorkDefinitionTB();
		//���������û��������û���Ϊ������
		User user = userBL.searchUserByKey(startPeople);
		tb.setInitiatorId(user.getUsername());
		tb.setWdname(workName);
		tb.setDescription(workDesc);
		//��������
		String zhouqi = "";
		
		if("ÿ��".equals(cycle)){
			zhouqi = "day";
		}else if("ÿ��".equals(cycle)){
			zhouqi = "week";
		}else if("ÿ��".equals(cycle)){
			zhouqi = "month";
		}else if("ÿ����".equals(cycle)){
			zhouqi = "quarter";
		}else if("ÿ����".equals(cycle)){
			zhouqi = "halfyear";
		}else if("ÿ��".equals(cycle)){
			zhouqi = "year";
		}else{
			zhouqi = "";
		}
		tb.setCycle(zhouqi);
		//������
		String week = "";
		
		if("��һ".equals(weekContent)){
			week = "MON";
		}else if("�ܶ�".equals(weekContent)){
			week = "TUE";
		}else if("����".equals(weekContent)){
			week = "WED";
		}else if("����".equals(weekContent)){
			week = "THU";
		}else if("����".equals(weekContent)){
			week = "FRI";
		}else if("����".equals(weekContent)){
			week = "SAT";
		}else if("����".equals(weekContent)){
			week = "SUN";
		}else{
			week = "";
		}
		
		
		
		if("ÿ��".equals(zhouqi)){
			tb.setWdweek(week);
		}
		if("ÿ��".equals(cycle)){
			if("�����һ��".equals(monthContent)){
				tb.setMonthLastDay("Y");
			}else{
				tb.setWdmonth(monthContent);
				tb.setMonthLastDay("N");
			}
		}
		
		if("ÿ��".equals(cycle)||"ÿ��".equals(cycle) ||"ÿ��".equals(cycle)){
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
	 * hasLeaderPower�Ƿ���и�����Ȩ�ޡ��Ȳ鿴���������û�������Ȩ��
	 * @param orgsyscoding �˽�ɫ˵����Ļ�����
	 * @return hasLeaderPower
	 */
	private String hasLeaderPower(String userid) {
		//�Ƿ���и�����Ȩ��
		String orgsyscoding = "";
		for(LeaderRoleids roleid : LeaderRoleids.values()){
			Integer id = Integer.parseInt(roleid.toString().split("_")[1]);
			//�Ƿ���в鿴���������û���Ȩ��
			boolean tempPower = userRoleBL.isRoleInUserRole(userid, id);
			if(tempPower){
				Role roleInfo;
				try {
					roleInfo = roleBL.searchRoleByKey(id);
					orgsyscoding = roleInfo.getRoledomain();
					return orgsyscoding;
				} catch (BLException e) {
					log.error("��ѯ��ɫ����roleid��"+id+"---"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return orgsyscoding;
	}
	
	/**
	 * hasMostPower ��ѯ�û��Ƿ�������Ȩ�ޣ��Ȳ鿴�����û��Ĺ���
	 * @param userid �û�id
	 * @return boolean
	 */
	private boolean hasMostPower(String userid) {
		//�Ƿ���в鿴���й��������Ȩ��
		boolean hasMostPower = userRoleBL.isRoleInUserRole(userid, IGWIMCONSTANTS.IGWIM_MOST_POWER_ROLEID);
		return hasMostPower;
	}
	
	/**
	 * @Description ��ѯ�û��Ƿ������ĸ��������ϸ�λ
	 * @param dto IGWIM01DTO userid:�û�id
	 * @return IGWIM01DTO
	 */
	public IGWIM01DTO searchIsLeader(IGWIM01DTO dto){
		log.info("==========��ѯ�û��Ƿ������ĸ��������ϸ�λ��ʼ==========");
		
		//�����û��Ƿ������ĸ�����Ȩ��
		String hasLeader = hasLeaderPower(dto.getUser().getUserid());
		//�����û��Ƿ��пƼ��ܾ�����ߣ�Ȩ��
		boolean isMost = hasMostPower(dto.getUser().getUserid());
		
		if(StringUtils.isNotEmpty(hasLeader) || isMost){
			//�и����˼������ϸ�λȨ��
			dto.setIsLeader("1");
		}else{
			//��ͨԱ��
			dto.setIsLeader("0");
		}
		
		log.info("==========��ѯ�û��Ƿ������ĸ��������ϸ�λ����==========");
		return dto;
	}
	
	/**
	 * ��ȡ���ں��������
	 * @param d ���������
	 * @param day ���ӵ�����
	 * @return
	 */
	private Date getDateAfter(Date d, int day) {  
		
        Calendar now = Calendar.getInstance();  
        //���õ�ϵͳ����
        now.setTime(d);
        //ϵͳ����+��
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
	
	/**
	 * �Ƚ����ڴ�С
	 * @param dt1 ����1
	 * @param dt2 ����2
	 * @return ����1������1>����2������-1������1<����2������0������1=����2
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
	 * �ַ�����ʽת������
	 * @param str �ַ���
	 * @return ����
	 */
	private Date strParseDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("�ַ���ǿת�����ڸ�ʽʧ�ܣ�Ҫת�����ַ���:"+str+"\n�ࣺWorkRemindBLImpl��������strParseDate() Line��331\n"+e.getMessage());
			e.printStackTrace();
		}
		return date;
	}
	
	/**  
     * ������������֮����������  
     * @param smdate ��С��ʱ�� 
     * @param bdate  �ϴ��ʱ�� 
     * @return ������� 
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
