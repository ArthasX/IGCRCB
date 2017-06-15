/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dbm.bl.task.WorkmanagerBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM1301Form;
import com.deliverik.infogovernor.dbm.form.IGDBM1302Form;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCondImpl;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerTB;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;
import com.deliverik.infogovernor.dbm.vo.IGDBM13012VO;
import com.deliverik.infogovernor.scheduling.jobs.CheckEveryWorkManagerJob;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.scheduling.jobs.WorkManagerJob;
import com.ibm.icu.text.DateFormat;

/**
 * @���� �������� BL
 */

public class IGDBM13BLImpl extends BaseBLImpl implements IGDBM13BL {
	
	static Log log = LogFactory.getLog(IGDBM13BLImpl.class);

	/**�������� BL */
	public WorkmanagerBL workmanagerBL;
	
	/** ���Ͷ��� */
	
	public SendMessageBL sendMessageBL;
	
	public CodeDetailBL codeDetailBL;
	
    /**
	 * @param log the log to set
	 */
	public static void setLog(Log log) {
		IGDBM13BLImpl.log = log;
	}

	/**
	 * @param codeDetailBL the codeDetailBL to set
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * @param ���Ͷ��� the sendMessageBL to set
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * @param ��������BL the workmanagerBL to set
	 */
	public void setWorkmanagerBL(WorkmanagerBL workmanagerBL) {
		this.workmanagerBL = workmanagerBL;
	}

    /** ����������Ϣ��ѯ
     * @param dto
     */
    public IGDBM13DTO searchWorkmanagerInfos(IGDBM13DTO dto) throws BLException {
    	log.debug("========��ѯ������¼����ʼ========");
    	IGDBM1301Form form = dto.getIgdbm1301Form();
    	WorkmanagerSearchCondImpl cond = new WorkmanagerSearchCondImpl();
    	copyProperties(cond, form);
    	// ��ѯ��¼����
		int totalCount = workmanagerBL.getSearchCount(cond);
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
		// ����DAO�ӿڲ�ѯ
		List<WorkmanagerInfo> wmList = workmanagerBL.searchWorkmanager(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setWmList(wmList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========��ѯ������¼��������========");
		
        return dto;
    }

    /**
     * ����������Ϣ
     */
    public IGDBM13DTO addWorkmanagerInfo(IGDBM13DTO dto) throws BLException {
    	log.debug("===============����������Ϣ������ʼ=================");
    	
    	IGDBM1302Form form = dto.getIgdbm1302Form();
    	String wmfrequencyweeks = "";
    	String wmfrequencymonths = "";
    	// ���Ƶ��
		String frequency = null;
		if ("week".equals(form.getWmfrequency())) {
			// Ƶ��Ϊ��
			for (String week : form.getWmfrequencyweek()) {
				if (StringUtils.isEmpty(frequency)) {
					frequency = week;
				} else {
					frequency = frequency + "," + week;
				}
			}
			wmfrequencyweeks = frequency;
		} else if ("month".equals(form.getWmfrequency())) {
			if (form.getWmfrequencymonth() != null) {
				// Ƶ��Ϊ��
				for (String month : form.getWmfrequencymonth()) {
					if (StringUtils.isEmpty(frequency)) {
						frequency = month;
					} else {
						frequency = frequency + "," + month;
					}
				}
				wmfrequencymonths = frequency;
			}
		}

		// �� , ����ַ���,�õ�һ������
		String[] startdate = form.getWmstartdate().split("\\ ");
		String starttime = startdate[1];
		String[] begindate = starttime.split("\\:");
		// ʱ
		String exeHour = begindate[0];
		// ��
		String exeMinute = begindate[1];
//		String exeHour = form.getWmremindh();
//		// ��
//		String exeMinute = form.getWmremindm();
		// ȡ��ִ�����ڱ��ʽ
		String cronExpression = null;

		if (StringUtils.isNotEmpty(form.getWmfrequencymonthlastday())) {// Ƶ��Ϊÿ�����һ��
			// ȡ��ִ�����ڱ��ʽ,���ռ��Ƶ��(ÿ�����һ��)
			if ("1".equals(form.getWmfrequencymonthlastday())) {
				// ȡ��ִ�����ڱ��ʽ
				cronExpression = this.creatCronExp(form.getWmfrequencymonthlastday(), exeHour, exeMinute, form.getWmstartdate(), null);
				frequency = "���һ";
			}
		} else {// Ƶ��Ϊ�ܡ���
			cronExpression = this.creatCronExp(form.getWmfrequency(), exeHour, exeMinute, form.getWmstartdate(), frequency);
		}
		form.setWmfrequencydesc(frequency);// Ƶ������
		form.setWmstatus("0");// ����״̬Ϊδ���
		form.setWmcron(cronExpression);// ִ�б��ʽ

//		Date nowDateTime = new Date();
//		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
//		form.setWmstartdate(date);// �Ǽ�ʱ��yyyy/MM/dd HH:mm
    	WorkmanagerTB instance = new WorkmanagerTB();
    	copyProperties(instance, form);
    	instance.setWmfrequencyweeks(wmfrequencyweeks);
    	instance.setWmfrequencymonths(wmfrequencymonths);
    	instance.setWmuserid(dto.getUser().getUserid());
    	instance.setWmusername(dto.getUser().getUsername());
    	instance.setWmtype("0");//������Դ�Ǽ�
    	instance.setWmremind("0");//����
    	instance.setWmstartdate(instance.getWmstartdate().trim());
    	instance.setWmlimitdate(instance.getWmlimitdate().trim());
    	WorkmanagerInfo manager = workmanagerBL.registWorkmanager(instance);
    	
    	//���붨ʱ����
    	insertjob(manager);
    	
        dto.addMessage(new ActionMessage("IGCO10000.I004","������Ϣ"));
        
        log.debug("===============����������Ϣ��������=================");
        return dto;
    }

    //���붨ʱ����
    private void insertjob(WorkmanagerInfo manager) throws BLException {
    	//���붨ʱ����
    	WorkManagerJob workManagerJob = new WorkManagerJob();// ȡ��job
		String jobName = "WorkManagerJob" + manager.getWmid();
		String jobGroupName = "WorkManagerGroup" + manager.getWmid();
		String triggerName = "WorkManagerJobTrigger" + manager.getWmid();
		String triggerGroupName = "WorkManagerJobTriggerGroup" + manager.getWmid();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar c = Calendar.getInstance();  
		String creatTime = manager.getWmstartdate();
		String endTime = manager.getWmlimitdate();
		Date beganDate = null;
		Date endDate = null;
//		String cron = "0 0/1 * * * ?";
//		log.debug(manager.getWmcron());
		try {
			beganDate = format.parse(creatTime);
			c.setTime(beganDate);  
			endDate = format.parse(endTime);
			//����ʱ���һ��
			endDate.setYear(endDate.getYear()+1);
			//�ж�����
			if ("day".equals(manager.getWmfrequency())) {
				int day = c.get(Calendar.DATE);  
				c.set(Calendar.DATE, day + 1);
			}else if ("week".equals(manager.getWmfrequency())) {
				int day = c.get(Calendar.DATE);  
				c.set(Calendar.DATE, day + 7);
			}else if ("month".equals(manager.getWmfrequency())) {
				int month = c.get(Calendar.MONTH);  
				c.set(Calendar.MONTH, month + 1);
			}else if ("quarter".equals(manager.getWmfrequency())) {
				int quarter = c.get(Calendar.MONTH);  
				c.set(Calendar.MONTH, quarter + 3);
			}else if ("halfyear".equals(manager.getWmfrequency())) {
				int halfyear = c.get(Calendar.MONTH);  
				c.set(Calendar.MONTH, halfyear + 6);
			}else if ("year".equals(manager.getWmfrequency())) {
				int year = c.get(Calendar.YEAR);  
				c.set(Calendar.YEAR, year + 1);
			}
			Map<String, Integer> args = new HashMap<String, Integer>();
			args.put("wmid", manager.getWmid());
			List<String> keyname = new ArrayList<String>();
			keyname.add("wmid");
			JobManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, workManagerJob, keyname, args, manager.getWmcron(), c.getTime(), endDate);
		
		} catch (Exception e) {
			log.error("==========Exception form RiskCheckJob===========");
			log.error("quarz����", e);
			throw new BLException("IGRIS0201.E001", "SchedulerException");
		}
    }
    
    //ɾ����ʱ����
    private void deljob(WorkmanagerTB tb) throws BLException{
    	
		String jobName = "WorkManagerJob" + tb.getRewmid();
		String jobGroupName = "WorkManagerGroup" + tb.getRewmid();
		String triggerName = "WorkManagerJobTrigger" + tb.getRewmid();
		String triggerGroupName = "WorkManagerJobTriggerGroup" + tb.getRewmid();
    	
    	try {
			JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
		} catch (SchedulerException e) {
			log.error("==========Exception form RiskCheckJob===========");
			log.debug(e.getMessage());
			log.debug("quarz��������", e);
			throw new BLException("", "SchedulerException");
		}
		// �ж�ÿ�����һ���Ƿ�����
		if (StringUtils.isNotEmpty(tb.getWmfrequencymonthlastday())) {
			String jobNameLastDay = "WorkManagerJobLastDay" + tb.getRewmid();
			String jobGroupNameLastDay = "WorkManagerGroupLastDay" + tb.getRewmid();
			String triggerNameLastDay = "WorkManagerJobTriggerLastDay" +tb.getRewmid();
			String triggerGroupNameLastDay = "WorkManagerJobTriggerGroupLastDay" +tb.getRewmid();

			try {
				JobManager.removeJob(jobNameLastDay, jobGroupNameLastDay, triggerNameLastDay, triggerGroupNameLastDay);
			} catch (SchedulerException e) {
				log.error("==========Exception form RiskCheckJob===========");
				log.debug(e.getMessage());
				throw new BLException("", "SchedulerException");
			}
		}
		
    }
    
    /**
     * ���¹�������״̬
     */
    public IGDBM13DTO updateWorkmanagerInfoRemind(IGDBM13DTO dto) throws BLException {
    	log.debug("===============���¹�����Ϣ������ʼ=================");
    	
    	IGDBM1302Form form = dto.getIgdbm1302Form();
    	WorkmanagerInfo info = workmanagerBL.searchWorkmanagerByPK(form.getWmid());
    	WorkmanagerTB tb = (WorkmanagerTB)SerializationUtils.clone(info);
    	tb.setWmremind("1");//������
    	workmanagerBL.updateWorkmanager(tb);
    	tb.setWmremind(tb.getWmid().toString());
    	//ɾ����ʱ����
    	deljob(tb);
    	dto.addMessage(new ActionMessage("IGCO10000.I010","����״̬����"));
    	log.debug("===============���¹�����Ϣ��������=================");
        return dto;
    }

    /**
     * �������״̬
     */
    public IGDBM13DTO updateWorkmanagerInfo(IGDBM13DTO dto) throws BLException {
    	log.debug("===============���¹�����Ϣ������ʼ=================");
    	
    	IGDBM1301Form form = dto.getIgdbm1301Form();
    	WorkmanagerInfo info = workmanagerBL.searchWorkmanagerByPK(form.getWmid());
    	WorkmanagerTB tb = (WorkmanagerTB)SerializationUtils.clone(info);
    	tb.setWmstatus("1");//���״̬
    	tb.setWmfactdate(IGStringUtils.getCurrentDateTime());
    	workmanagerBL.updateWorkmanager(tb);
    	dto.addMessage(new ActionMessage("IGCO10000.I010","���¹�����Ϣ"));
    	
    	log.debug("===============���¹�����Ϣ��������=================");
        return dto;
    }
    
    /**
	 * <p>
	 * Description: �趨quartzִ�����ڱ��ʽ
	 * </p>
	 */
	private String creatCronExp(String periodType, String exeHour, String exeMinute, String qjcrttime, String frequency) {
		String retCronExp = null;
		// �� �� ʱ �� �� �� ��
		if ("week".equals(periodType)) {
			// String week = this.getWeekOfDate(qjcrttime, "eng");
			retCronExp = "0 " + exeMinute + " " + exeHour + " ? * " + frequency;
		} else if ("month".equals(periodType)) {
			// String day = qjcrttime.split("/")[2];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + frequency + " * ?";
		} else if ("once".equals(periodType)) {
			String day = qjcrttime.split("/")[2].split(" ")[0];
			String month = qjcrttime.split("/")[1];
			String year = qjcrttime.split("/")[0];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + month + " ? " + year;
		} else if ("day".equals(periodType)) {
			retCronExp = "0 " + exeMinute + " " + exeHour + " * * ?";
		} else if ("quarter".equals(periodType)) {
			String day = qjcrttime.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day1 + " " + month + "/3 ?";
		} else if ("1".equals(periodType)) {
			// ÿ�����һ��
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + "L" + " * ?";
		}
		// �l�� �� 20121023

		else if ("year".equals(periodType)) {
			String day = qjcrttime.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day1 + " " + month + " ?";
		}
		// �l�ʰ���20121023
		else if ("halfyear".equals(periodType)) {
			String day = qjcrttime.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day1 + " " + month + "," + ((Integer.parseInt(month) + 6) % 12) + " ?";
		}
		log.debug(retCronExp);
		return retCronExp;
	}
	
	/**
	 * <p>
	 * Description: ������Ϣ�Ǽǳ�ʼ��
	 * </p>
	 */
	public IGDBM13DTO dispWorkmanagerInfoAction(IGDBM13DTO dto) throws BLException {
		log.debug("========������Ϣ�Ǽǳ�ʼ������ʼ========");
		// �ܼ���
		List<IGDBM13012VO> weekList = new ArrayList<IGDBM13012VO>();
		IGDBM13012VO week1vo = new IGDBM13012VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("��һ");
		weekList.add(week1vo);
		IGDBM13012VO week2vo = new IGDBM13012VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("�ܶ�");
		weekList.add(week2vo);
		IGDBM13012VO week3vo = new IGDBM13012VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("����");
		weekList.add(week3vo);
		IGDBM13012VO week4vo = new IGDBM13012VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("����");
		weekList.add(week4vo);
		IGDBM13012VO week5vo = new IGDBM13012VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("����");
		weekList.add(week5vo);
		IGDBM13012VO week6vo = new IGDBM13012VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("����");
		weekList.add(week6vo);
		IGDBM13012VO week7vo = new IGDBM13012VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("����");
		weekList.add(week7vo);
		// ÿ����������
		List<IGDBM13012VO> monthList = new ArrayList<IGDBM13012VO>();
		;
		for (int i = 1; i < 31; i++) {
			// ��
			String dayvalue = String.valueOf(i);
			// �Ƿ���ѡ��
			IGDBM13012VO monthvo = new IGDBM13012VO();
			monthvo.setDayvalue(dayvalue);
			monthList.add(monthvo);
		}
		dto.setWeekList(weekList);
		dto.setMonthList(monthList);
		log.debug("========������Ϣ�Ǽǳ�ʼ����������========");

		return dto;
	}
	
	/**
	 * <p>
	 * Description: ������Ϣ�༭��ʼ��
	 * </p>
	 */
	public IGDBM13DTO editWorkmanagerInfoAction(IGDBM13DTO dto) throws BLException {
		log.debug("========������Ϣ�Ǽǳ�ʼ������ʼ========");
		IGDBM1302Form form = dto.getIgdbm1302Form();
		String wmfrequencyweeks = "";
		String wmfrequencymonths = "";
		if(null != form){
			wmfrequencyweeks = form.getWmfrequencyweeks();
			wmfrequencymonths = form.getWmfrequencymonths();
		}
		// �ܼ���
		List<IGDBM13012VO> weekList = new ArrayList<IGDBM13012VO>();
		IGDBM13012VO week1vo = new IGDBM13012VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("��һ");
//		weekList.add(week1vo);
		IGDBM13012VO week2vo = new IGDBM13012VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("�ܶ�");
//		weekList.add(week2vo);
		IGDBM13012VO week3vo = new IGDBM13012VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("����");
//		weekList.add(week3vo);
		IGDBM13012VO week4vo = new IGDBM13012VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("����");
//		weekList.add(week4vo);
		IGDBM13012VO week5vo = new IGDBM13012VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("����");
//		weekList.add(week5vo);
		IGDBM13012VO week6vo = new IGDBM13012VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("����");
//		weekList.add(week6vo);
		IGDBM13012VO week7vo = new IGDBM13012VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("����");
		if(!"".equals(wmfrequencyweeks)&&null!=wmfrequencyweeks){
			if(wmfrequencyweeks.indexOf(",") > 0){
				String []weekdays = wmfrequencyweeks.split(",");
				for(String weekday : weekdays){
					if(week1vo.getWeekvalue().equals(weekday))
						week1vo.setIschecked("true");
					else if (week2vo.getWeekvalue().equals(weekday))
						week2vo.setIschecked("true");
					else if (week3vo.getWeekvalue().equals(weekday))
						week3vo.setIschecked("true");
					else if (week4vo.getWeekvalue().equals(weekday))
						week4vo.setIschecked("true");
					else if (week5vo.getWeekvalue().equals(weekday))
						week5vo.setIschecked("true");
					else if (week6vo.getWeekvalue().equals(weekday))
						week6vo.setIschecked("true");
					else if (week7vo.getWeekvalue().equals(weekday))
						week7vo.setIschecked("true");
				}
			}else{
				if(week1vo.getWeekvalue().equals(wmfrequencyweeks))
					week1vo.setIschecked("true");
				else if (week2vo.getWeekvalue().equals(wmfrequencyweeks))
					week2vo.setIschecked("true");
				else if (week3vo.getWeekvalue().equals(wmfrequencyweeks))
					week3vo.setIschecked("true");
				else if (week4vo.getWeekvalue().equals(wmfrequencyweeks))
					week4vo.setIschecked("true");
				else if (week5vo.getWeekvalue().equals(wmfrequencyweeks))
					week5vo.setIschecked("true");
				else if (week6vo.getWeekvalue().equals(wmfrequencyweeks))
					week6vo.setIschecked("true");
				else if (week7vo.getWeekvalue().equals(wmfrequencyweeks))
					week7vo.setIschecked("true");
			}
		}
		weekList.add(week1vo);
		weekList.add(week2vo);
		weekList.add(week3vo);
		weekList.add(week4vo);
		weekList.add(week5vo);
		weekList.add(week6vo);
		weekList.add(week7vo);
		// ÿ����������
		List<IGDBM13012VO> monthList = new ArrayList<IGDBM13012VO>();
		for (int i = 1; i < 31; i++) {
			// ��
			String dayvalue = String.valueOf(i);
			// �Ƿ���ѡ��
			IGDBM13012VO monthvo = new IGDBM13012VO();
			monthvo.setDayvalue(dayvalue);
			if(!"".equals(wmfrequencymonths)&&null!=wmfrequencymonths){
				if(wmfrequencymonths.indexOf(",") > 0){
					String []monthdays = wmfrequencymonths.split(",");
					for(String weekday : monthdays){
						if(dayvalue.equals(weekday)){
							monthvo.setIschecked("true");
						}
					}
				}else if(dayvalue.equals(wmfrequencymonths)){
					monthvo.setIschecked("true");
				}
			}
			monthList.add(monthvo);
		}
		dto.setWeekList(weekList);
		dto.setMonthList(monthList);
		log.debug("========������Ϣ�Ǽǳ�ʼ����������========");

		return dto;
	}
	
	 /** ������Ϣ����
     * @param dto
     */
    public void copyWorkmanagerInfo(IGDBM13DTO dto) throws BLException {
    	log.debug("========������Ϣ���ƴ���ʼ========");
    	
    	WorkmanagerInfo info = workmanagerBL.searchWorkmanagerByPK(dto.getWmid());
//    	//��ѯ�˹����ĸ��ư汾�����µ�һ�������ٴθ���
//    	WorkmanagerSearchCondImpl cond = new WorkmanagerSearchCondImpl();
//    	cond.setRewmid(dto.getWmid().toString());//����Դid
//    	cond.setWmremind("0");//��Ҫ����
//    	List<WorkmanagerInfo> infoList = workmanagerBL.searchNewWorkmanager(cond);
    	WorkmanagerTB tb = null;
    	//�Ƿ���Ҫ����
    	if("1".equals(info.getWmremind())){
    		//������
    		return;
    	}else{
    		//����
    		tb = (WorkmanagerTB)SerializationUtils.clone(info);
    	}
    	tb.setWmid(null);
    	tb.setWmstartdate(IGStringUtils.getCurrentDateTime());
    	tb.setWmstatus("0");//���״̬
    	tb.setWmtype("1");//������Դ����
    	tb.setWmremind("0");//����״̬-����
    	tb.setRewmid(dto.getWmid().toString());
    	tb.setWmfactdate("");
    	WorkmanagerInfo manager = workmanagerBL.registWorkmanager(tb);
		//������һ����������
    	if(null != info){
    		WorkmanagerTB update = (WorkmanagerTB)SerializationUtils.clone(info);
    		update.setWmremind("1");
    		workmanagerBL.updateWorkmanager(update);
    	}
    	//ɾ����ʱ����
    	deljob(tb);
		
		//���붨ʱ����
		insertjob(manager);
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("159","6"));
    	if("1".equals(codeDetail.getCvalue())){
    		//���Ͷ���
        	this.sendMessageBL.sendSmsToUser(manager.getWmuserid(),manager.getWmusername()+",����"+"\""+manager.getWmname()+"\""+"����������");
    	}
    	log.debug("========������Ϣ���ƴ������========");
    }
   
    /**
     * �༭������Ϣ
     */
    public IGDBM13DTO editWorkmanagerInfo(IGDBM13DTO dto) throws BLException {
    	log.debug("========������Ϣ�༭����ʼ========");
    	
	    IGDBM1302Form form = dto.getIgdbm1302Form();
		WorkmanagerInfo manager = workmanagerBL.searchWorkmanagerByPK(form.getWmid());
		copyProperties(form, manager);
		dto.setInfo(manager);
		
		log.debug("========������Ϣ�༭�������========");
    	return dto;
	}
    
    /**
     * ���¹�����Ϣ
     */
    public IGDBM13DTO updateWorkmanager(IGDBM13DTO dto) throws BLException {
    	log.debug("========������Ϣ���´���ʼ========");
    	
    	IGDBM1302Form form = dto.getIgdbm1302Form();
    	WorkmanagerTB tb = new WorkmanagerTB();
    	copyProperties(tb, form);
    	tb.setWmstartdate(tb.getWmstartdate().trim());
    	tb.setWmlimitdate(tb.getWmlimitdate().trim());
    	workmanagerBL.updateWorkmanager(tb);
    	
    	dto.addMessage(new ActionMessage("IGCO10000.I010","���¹�����Ϣ"));
    	log.debug("========������Ϣ���´������========");
    	return dto;
    }
    
    /** ����������Ϣ������ѯ
     * @param dto
     */
    public IGDBM13DTO exportWorkmanagerInfos(IGDBM13DTO dto) throws BLException {
    	log.debug("========��ѯ������¼����ʼ========");
    	IGDBM1301Form form = dto.getIgdbm1301Form();
    	WorkmanagerSearchCondImpl cond = new WorkmanagerSearchCondImpl();
    	copyProperties(cond, form);
		// ����DAO�ӿڲ�ѯ
		List<WorkmanagerInfo> wmList = workmanagerBL.searchWorkmanager(cond, 0, 0);
		dto.setWmList(wmList);
		dto.addMessage(new ActionMessage("IGCO10000.I010","������Ϣ����"));
		log.debug("========��ѯ������¼��������========");
		
        return dto;
    }
    
    /** ��ѯÿ�մ�������
     * @param dto
     */
    public IGDBM13DTO searchDealWorkmanagerInfos(IGDBM13DTO dto) throws BLException {
    	log.debug("========��ѯÿ�մ�����������ʼ========");
    	CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("159","6"));
    	if("1".equals(codeDetail.getCvalue())){
    		//��ȡϵͳ��ǰʱ��
        	String currentDate = IGStringUtils.getCurrentDateTime();
	    	  Date date = new Date();
	    	  Calendar cal = Calendar.getInstance();
	    	  cal.setTime(date);
	    	  cal.add(Calendar.MINUTE, 5);
    		WorkmanagerSearchCondImpl cond = new WorkmanagerSearchCondImpl();
        	cond.setWmstartdate_from(currentDate);
        	cond.setWmstartdate_to((new SimpleDateFormat("yyyy/MM/dd HH:mm")).format(cal.getTime()).toString());
        	cond.setWmstatus("0");//δ���
        	// ��ѯ��¼����
        	List<WorkmanagerVW> list = workmanagerBL.searchSumByCond(cond);
    		if(null!= list && list.size() > 0){
    			for (WorkmanagerVW info : list) {
					//���Ͷ���  
	    	    	this.sendMessageBL.sendSmsToUser(info.getWmuserid(),info.getWmusername()+",����"+"\""+info.getWmname()+"\""+"����������ʱ��");
				}
    		}
    	}
    	log.debug("========��ѯÿ�մ��������������========");
    	return dto;
    }
    
    //����ÿ�ղ�ѯ����������ʱ����
    public void insertEveryDayjob() throws BLException {
    	//���붨ʱ����
    	CheckEveryWorkManagerJob workManagerJob = new CheckEveryWorkManagerJob();// ȡ��job
		String jobName = "CheckEveryWorkManagerJob";
		String jobGroupName = "CheckEveryWorkManagerGroup";
		String triggerName = "CheckEveryWorkManagerJobTrigger";
		String triggerGroupName = "CheckEveryWorkManagerJobTriggerGroup";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar c = Calendar.getInstance();  
		String creatTime = IGStringUtils.getCurrentDateTime();
//		String endTime = manager.getWmlimitdate();
		Date beganDate = null;
		Date endDate = null;
//		log.debug(manager.getWmcron());
//		String cron = "0 0 9 * * ?";
		//0 0 12 * * ?
//		String cron = "0/5 * * * * ?";
		String cron = "0 0/5 * * * ?";
		try {
			boolean isadd = JobManager.isJobAdded(jobName);
			if(!isadd){
				beganDate = format.parse(creatTime);
				c.setTime(beganDate);  
				endDate = format.parse(creatTime);
				//����ʱ���һ��
				endDate.setYear(endDate.getYear()+1);
				int day = c.get(Calendar.DATE);  
//				c.set(Calendar.DATE, day + 1);
				Map<String, Integer> args = new HashMap<String, Integer>();
//				args.put("wmid", manager.getWmid());
				List<String> keyname = new ArrayList<String>();
//				keyname.add("wmid");
				JobManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, workManagerJob, keyname, args, cron, c.getTime(), endDate);
			}
			
		} catch (Exception e) {
			log.error("==========Exception form RiskCheckJob===========");
			log.error("quarz����", e);
			throw new BLException("IGRIS0201.E001", "SchedulerException");
		}
    }
    
    //ɾ��ÿ�ղ�ѯ����������ʱ����
    public void delEveryDayjob() throws BLException {
    	
    	String jobName = "CheckEveryWorkManagerJob";
		String jobGroupName = "CheckEveryWorkManagerGroup";
		String triggerName = "CheckEveryWorkManagerJobTrigger";
		String triggerGroupName = "CheckEveryWorkManagerJobTriggerGroup";
    	try {
			JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
		} catch (SchedulerException e) {
			log.error("==========Exception form RiskCheckJob===========");
			log.debug(e.getMessage());
			log.debug("quarz��������", e);
			throw new BLException("", "SchedulerException");
		}
    }
}

