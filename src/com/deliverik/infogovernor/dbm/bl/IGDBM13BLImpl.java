/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * @概述 工作管理 BL
 */

public class IGDBM13BLImpl extends BaseBLImpl implements IGDBM13BL {
	
	static Log log = LogFactory.getLog(IGDBM13BLImpl.class);

	/**工作管理 BL */
	public WorkmanagerBL workmanagerBL;
	
	/** 发送短信 */
	
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
	 * @param 发送短信 the sendMessageBL to set
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * @param 工作管理BL the workmanagerBL to set
	 */
	public void setWorkmanagerBL(WorkmanagerBL workmanagerBL) {
		this.workmanagerBL = workmanagerBL;
	}

    /** 工作管理信息查询
     * @param dto
     */
    public IGDBM13DTO searchWorkmanagerInfos(IGDBM13DTO dto) throws BLException {
    	log.debug("========查询工作记录处理开始========");
    	IGDBM1301Form form = dto.getIgdbm1301Form();
    	WorkmanagerSearchCondImpl cond = new WorkmanagerSearchCondImpl();
    	copyProperties(cond, form);
    	// 查询记录总数
		int totalCount = workmanagerBL.getSearchCount(cond);
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
		// 调用DAO接口查询
		List<WorkmanagerInfo> wmList = workmanagerBL.searchWorkmanager(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setWmList(wmList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========查询工作记录处理终了========");
		
        return dto;
    }

    /**
     * 新增工作信息
     */
    public IGDBM13DTO addWorkmanagerInfo(IGDBM13DTO dto) throws BLException {
    	log.debug("===============新增工作信息操作开始=================");
    	
    	IGDBM1302Form form = dto.getIgdbm1302Form();
    	String wmfrequencyweeks = "";
    	String wmfrequencymonths = "";
    	// 检查频率
		String frequency = null;
		if ("week".equals(form.getWmfrequency())) {
			// 频率为周
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
				// 频率为月
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

		// 按 , 拆分字符串,得到一个数组
		String[] startdate = form.getWmstartdate().split("\\ ");
		String starttime = startdate[1];
		String[] begindate = starttime.split("\\:");
		// 时
		String exeHour = begindate[0];
		// 分
		String exeMinute = begindate[1];
//		String exeHour = form.getWmremindh();
//		// 分
//		String exeMinute = form.getWmremindm();
		// 取得执行周期表达式
		String cronExpression = null;

		if (StringUtils.isNotEmpty(form.getWmfrequencymonthlastday())) {// 频率为每月最后一天
			// 取得执行周期表达式,风险检查频率(每月最后一天)
			if ("1".equals(form.getWmfrequencymonthlastday())) {
				// 取得执行周期表达式
				cronExpression = this.creatCronExp(form.getWmfrequencymonthlastday(), exeHour, exeMinute, form.getWmstartdate(), null);
				frequency = "最后一";
			}
		} else {// 频率为周、月
			cronExpression = this.creatCronExp(form.getWmfrequency(), exeHour, exeMinute, form.getWmstartdate(), frequency);
		}
		form.setWmfrequencydesc(frequency);// 频率内容
		form.setWmstatus("0");// 设置状态为未完成
		form.setWmcron(cronExpression);// 执行表达式

//		Date nowDateTime = new Date();
//		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
//		form.setWmstartdate(date);// 登记时间yyyy/MM/dd HH:mm
    	WorkmanagerTB instance = new WorkmanagerTB();
    	copyProperties(instance, form);
    	instance.setWmfrequencyweeks(wmfrequencyweeks);
    	instance.setWmfrequencymonths(wmfrequencymonths);
    	instance.setWmuserid(dto.getUser().getUserid());
    	instance.setWmusername(dto.getUser().getUsername());
    	instance.setWmtype("0");//数据来源登记
    	instance.setWmremind("0");//提醒
    	instance.setWmstartdate(instance.getWmstartdate().trim());
    	instance.setWmlimitdate(instance.getWmlimitdate().trim());
    	WorkmanagerInfo manager = workmanagerBL.registWorkmanager(instance);
    	
    	//插入定时任务
    	insertjob(manager);
    	
        dto.addMessage(new ActionMessage("IGCO10000.I004","工作信息"));
        
        log.debug("===============新增工作信息操作结束=================");
        return dto;
    }

    //插入定时任务
    private void insertjob(WorkmanagerInfo manager) throws BLException {
    	//插入定时任务
    	WorkManagerJob workManagerJob = new WorkManagerJob();// 取得job
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
			//结束时间加一年
			endDate.setYear(endDate.getYear()+1);
			//判断周期
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
			log.error("quarz报错", e);
			throw new BLException("IGRIS0201.E001", "SchedulerException");
		}
    }
    
    //删除定时任务
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
			log.debug("quarz启动报错", e);
			throw new BLException("", "SchedulerException");
		}
		// 判断每月最后一天是否发起检查
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
     * 更新工作提醒状态
     */
    public IGDBM13DTO updateWorkmanagerInfoRemind(IGDBM13DTO dto) throws BLException {
    	log.debug("===============更新工作信息操作开始=================");
    	
    	IGDBM1302Form form = dto.getIgdbm1302Form();
    	WorkmanagerInfo info = workmanagerBL.searchWorkmanagerByPK(form.getWmid());
    	WorkmanagerTB tb = (WorkmanagerTB)SerializationUtils.clone(info);
    	tb.setWmremind("1");//不提醒
    	workmanagerBL.updateWorkmanager(tb);
    	tb.setWmremind(tb.getWmid().toString());
    	//删除定时任务
    	deljob(tb);
    	dto.addMessage(new ActionMessage("IGCO10000.I010","提醒状态设置"));
    	log.debug("===============更新工作信息操作结束=================");
        return dto;
    }

    /**
     * 更新完成状态
     */
    public IGDBM13DTO updateWorkmanagerInfo(IGDBM13DTO dto) throws BLException {
    	log.debug("===============更新工作信息操作开始=================");
    	
    	IGDBM1301Form form = dto.getIgdbm1301Form();
    	WorkmanagerInfo info = workmanagerBL.searchWorkmanagerByPK(form.getWmid());
    	WorkmanagerTB tb = (WorkmanagerTB)SerializationUtils.clone(info);
    	tb.setWmstatus("1");//完成状态
    	tb.setWmfactdate(IGStringUtils.getCurrentDateTime());
    	workmanagerBL.updateWorkmanager(tb);
    	dto.addMessage(new ActionMessage("IGCO10000.I010","更新工作信息"));
    	
    	log.debug("===============更新工作信息操作结束=================");
        return dto;
    }
    
    /**
	 * <p>
	 * Description: 设定quartz执行周期表达式
	 * </p>
	 */
	private String creatCronExp(String periodType, String exeHour, String exeMinute, String qjcrttime, String frequency) {
		String retCronExp = null;
		// 秒 分 时 日 月 周 年
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
			// 每月最后一天
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + "L" + " * ?";
		}
		// 頻率 年 20121023

		else if ("year".equals(periodType)) {
			String day = qjcrttime.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day1 + " " + month + " ?";
		}
		// 頻率半年20121023
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
	 * Description: 工作信息登记初始化
	 * </p>
	 */
	public IGDBM13DTO dispWorkmanagerInfoAction(IGDBM13DTO dto) throws BLException {
		log.debug("========工作信息登记初始化处理开始========");
		// 周集合
		List<IGDBM13012VO> weekList = new ArrayList<IGDBM13012VO>();
		IGDBM13012VO week1vo = new IGDBM13012VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("周一");
		weekList.add(week1vo);
		IGDBM13012VO week2vo = new IGDBM13012VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("周二");
		weekList.add(week2vo);
		IGDBM13012VO week3vo = new IGDBM13012VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("周三");
		weekList.add(week3vo);
		IGDBM13012VO week4vo = new IGDBM13012VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("周四");
		weekList.add(week4vo);
		IGDBM13012VO week5vo = new IGDBM13012VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("周五");
		weekList.add(week5vo);
		IGDBM13012VO week6vo = new IGDBM13012VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("周六");
		weekList.add(week6vo);
		IGDBM13012VO week7vo = new IGDBM13012VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("周日");
		weekList.add(week7vo);
		// 每月天数集合
		List<IGDBM13012VO> monthList = new ArrayList<IGDBM13012VO>();
		;
		for (int i = 1; i < 31; i++) {
			// 天
			String dayvalue = String.valueOf(i);
			// 是否已选择
			IGDBM13012VO monthvo = new IGDBM13012VO();
			monthvo.setDayvalue(dayvalue);
			monthList.add(monthvo);
		}
		dto.setWeekList(weekList);
		dto.setMonthList(monthList);
		log.debug("========工作信息登记初始化处理终了========");

		return dto;
	}
	
	/**
	 * <p>
	 * Description: 工作信息编辑初始化
	 * </p>
	 */
	public IGDBM13DTO editWorkmanagerInfoAction(IGDBM13DTO dto) throws BLException {
		log.debug("========工作信息登记初始化处理开始========");
		IGDBM1302Form form = dto.getIgdbm1302Form();
		String wmfrequencyweeks = "";
		String wmfrequencymonths = "";
		if(null != form){
			wmfrequencyweeks = form.getWmfrequencyweeks();
			wmfrequencymonths = form.getWmfrequencymonths();
		}
		// 周集合
		List<IGDBM13012VO> weekList = new ArrayList<IGDBM13012VO>();
		IGDBM13012VO week1vo = new IGDBM13012VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("周一");
//		weekList.add(week1vo);
		IGDBM13012VO week2vo = new IGDBM13012VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("周二");
//		weekList.add(week2vo);
		IGDBM13012VO week3vo = new IGDBM13012VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("周三");
//		weekList.add(week3vo);
		IGDBM13012VO week4vo = new IGDBM13012VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("周四");
//		weekList.add(week4vo);
		IGDBM13012VO week5vo = new IGDBM13012VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("周五");
//		weekList.add(week5vo);
		IGDBM13012VO week6vo = new IGDBM13012VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("周六");
//		weekList.add(week6vo);
		IGDBM13012VO week7vo = new IGDBM13012VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("周日");
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
		// 每月天数集合
		List<IGDBM13012VO> monthList = new ArrayList<IGDBM13012VO>();
		for (int i = 1; i < 31; i++) {
			// 天
			String dayvalue = String.valueOf(i);
			// 是否已选择
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
		log.debug("========工作信息登记初始化处理终了========");

		return dto;
	}
	
	 /** 工作信息复制
     * @param dto
     */
    public void copyWorkmanagerInfo(IGDBM13DTO dto) throws BLException {
    	log.debug("========工作信息复制处理开始========");
    	
    	WorkmanagerInfo info = workmanagerBL.searchWorkmanagerByPK(dto.getWmid());
//    	//查询此工作的复制版本中最新的一条进行再次复制
//    	WorkmanagerSearchCondImpl cond = new WorkmanagerSearchCondImpl();
//    	cond.setRewmid(dto.getWmid().toString());//数据源id
//    	cond.setWmremind("0");//需要提醒
//    	List<WorkmanagerInfo> infoList = workmanagerBL.searchNewWorkmanager(cond);
    	WorkmanagerTB tb = null;
    	//是否需要提醒
    	if("1".equals(info.getWmremind())){
    		//不提醒
    		return;
    	}else{
    		//提醒
    		tb = (WorkmanagerTB)SerializationUtils.clone(info);
    	}
    	tb.setWmid(null);
    	tb.setWmstartdate(IGStringUtils.getCurrentDateTime());
    	tb.setWmstatus("0");//完成状态
    	tb.setWmtype("1");//数据来源复制
    	tb.setWmremind("0");//提醒状态-提醒
    	tb.setRewmid(dto.getWmid().toString());
    	tb.setWmfactdate("");
    	WorkmanagerInfo manager = workmanagerBL.registWorkmanager(tb);
		//更新上一条不再提醒
    	if(null != info){
    		WorkmanagerTB update = (WorkmanagerTB)SerializationUtils.clone(info);
    		update.setWmremind("1");
    		workmanagerBL.updateWorkmanager(update);
    	}
    	//删除定时任务
    	deljob(tb);
		
		//插入定时任务
		insertjob(manager);
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("159","6"));
    	if("1".equals(codeDetail.getCvalue())){
    		//发送短信
        	this.sendMessageBL.sendSmsToUser(manager.getWmuserid(),manager.getWmusername()+",您有"+"\""+manager.getWmname()+"\""+"工作待处理。");
    	}
    	log.debug("========工作信息复制处理结束========");
    }
   
    /**
     * 编辑工作信息
     */
    public IGDBM13DTO editWorkmanagerInfo(IGDBM13DTO dto) throws BLException {
    	log.debug("========工作信息编辑处理开始========");
    	
	    IGDBM1302Form form = dto.getIgdbm1302Form();
		WorkmanagerInfo manager = workmanagerBL.searchWorkmanagerByPK(form.getWmid());
		copyProperties(form, manager);
		dto.setInfo(manager);
		
		log.debug("========工作信息编辑处理结束========");
    	return dto;
	}
    
    /**
     * 更新工作信息
     */
    public IGDBM13DTO updateWorkmanager(IGDBM13DTO dto) throws BLException {
    	log.debug("========工作信息更新处理开始========");
    	
    	IGDBM1302Form form = dto.getIgdbm1302Form();
    	WorkmanagerTB tb = new WorkmanagerTB();
    	copyProperties(tb, form);
    	tb.setWmstartdate(tb.getWmstartdate().trim());
    	tb.setWmlimitdate(tb.getWmlimitdate().trim());
    	workmanagerBL.updateWorkmanager(tb);
    	
    	dto.addMessage(new ActionMessage("IGCO10000.I010","更新工作信息"));
    	log.debug("========工作信息更新处理结束========");
    	return dto;
    }
    
    /** 工作管理信息导出查询
     * @param dto
     */
    public IGDBM13DTO exportWorkmanagerInfos(IGDBM13DTO dto) throws BLException {
    	log.debug("========查询工作记录处理开始========");
    	IGDBM1301Form form = dto.getIgdbm1301Form();
    	WorkmanagerSearchCondImpl cond = new WorkmanagerSearchCondImpl();
    	copyProperties(cond, form);
		// 调用DAO接口查询
		List<WorkmanagerInfo> wmList = workmanagerBL.searchWorkmanager(cond, 0, 0);
		dto.setWmList(wmList);
		dto.addMessage(new ActionMessage("IGCO10000.I010","工作信息导出"));
		log.debug("========查询工作记录处理终了========");
		
        return dto;
    }
    
    /** 查询每日待处理工作
     * @param dto
     */
    public IGDBM13DTO searchDealWorkmanagerInfos(IGDBM13DTO dto) throws BLException {
    	log.debug("========查询每日待处理工作处理开始========");
    	CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("159","6"));
    	if("1".equals(codeDetail.getCvalue())){
    		//获取系统当前时间
        	String currentDate = IGStringUtils.getCurrentDateTime();
	    	  Date date = new Date();
	    	  Calendar cal = Calendar.getInstance();
	    	  cal.setTime(date);
	    	  cal.add(Calendar.MINUTE, 5);
    		WorkmanagerSearchCondImpl cond = new WorkmanagerSearchCondImpl();
        	cond.setWmstartdate_from(currentDate);
        	cond.setWmstartdate_to((new SimpleDateFormat("yyyy/MM/dd HH:mm")).format(cal.getTime()).toString());
        	cond.setWmstatus("0");//未完成
        	// 查询记录总数
        	List<WorkmanagerVW> list = workmanagerBL.searchSumByCond(cond);
    		if(null!= list && list.size() > 0){
    			for (WorkmanagerVW info : list) {
					//发送短信  
	    	    	this.sendMessageBL.sendSmsToUser(info.getWmuserid(),info.getWmusername()+",您有"+"\""+info.getWmname()+"\""+"工作即将超时。");
				}
    		}
    	}
    	log.debug("========查询每日待处理工作处理结束========");
    	return dto;
    }
    
    //插入每日查询待处理工作定时任务
    public void insertEveryDayjob() throws BLException {
    	//插入定时任务
    	CheckEveryWorkManagerJob workManagerJob = new CheckEveryWorkManagerJob();// 取得job
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
				//结束时间加一年
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
			log.error("quarz报错", e);
			throw new BLException("IGRIS0201.E001", "SchedulerException");
		}
    }
    
    //删除每日查询待处理工作定时任务
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
			log.debug("quarz启动报错", e);
			throw new BLException("", "SchedulerException");
		}
    }
}

