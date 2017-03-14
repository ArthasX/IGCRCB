package com.deliverik.infogovernor.mtp.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerUtils;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.CronTriggerImpl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.mtp.bl.task.QuartzJobDetailsBL;
import com.deliverik.infogovernor.mtp.dto.IGMTP01DTO;
import com.deliverik.infogovernor.mtp.dto.IGMTP03DTO;
import com.deliverik.infogovernor.mtp.dto.IGMTP04DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0101Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0103Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0106Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0107Form;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCondImpl;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;
import com.deliverik.infogovernor.mtp.vo.IGMTP01011VO;
import com.deliverik.infogovernor.mtp.vo.IGMTP01042VO;
import com.deliverik.infogovernor.mtp.vo.IGMTP01043VO;
import com.deliverik.infogovernor.mtp.vo.IGMTP01061VO;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessInfoEntityBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessRecordBL;
import com.deliverik.infogovernor.scheduling.jobs.EnterpriseTimerJob;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.scheduling.jobs.PersonTimerJob;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzJobsTB;

public class IGMTP01BLImpl extends BaseBLImpl implements IGMTP01BL {
	
	static Log log = LogFactory.getLog(IGMTP01BLImpl.class);

	/**运维任务BL*/
	private QuartzJobsBL quartzJobsBL;
	
	/**运维任务发起流程BL*/
	private QuartzProcessRecordBL quartzProcessRecordBL;
	
	/**流程模板BL*/
	protected IG259BL ig259BL;
	
	/**流程定义BL*/
	protected IG380BL ig380BL;
	
	/**流程变量定义BL*/
	protected IG007BL ig007BL;
	
	/**流程多资产BL*/
	protected IG731BL ig731BL;
	
	/**流程变量多资产BL*/
	protected QuartzProcessInfoEntityBL quartzProcessInfoEntityBL;
	
	/**流程BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**日常运维计划信息处理BL*/
	protected QuartzJobDetailsBL quartzJobDetailsBL;
	
	
	
	public void setQuartzJobDetailsBL(QuartzJobDetailsBL quartzJobDetailsBL) {
		this.quartzJobDetailsBL = quartzJobDetailsBL;
	}

	
	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}
	
	public void setIg731BL(IG731BL ig731BL) {
		this.ig731BL = ig731BL;
	}

	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}

	public void setQuartzProcessRecordBL(QuartzProcessRecordBL quartzProcessRecordBL) {
		this.quartzProcessRecordBL = quartzProcessRecordBL;
	}

	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	public void setQuartzProcessInfoEntityBL(
			QuartzProcessInfoEntityBL quartzProcessInfoEntityBL) {
		this.quartzProcessInfoEntityBL = quartzProcessInfoEntityBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 取得流程模板定义信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMTP01DTO getProcessDefinitions(IGMTP01DTO dto) throws BLException {
//		IG259Info pt = ig259BL.searchIG259ByPrType("WB");
		IG259Info pt = ig259BL.searchIG259ByPrType("WD");
		if(pt == null){
			throw new BLException("IGCO10000.E004","流程模板");
		}
		List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
		dto.setPdList(pdList);
		return dto;
	}

	/**
	 * 解析传入日期为星期几并根据语言类型返回值
	 * @param strDate 日期
	 * @param language 语言
	 * @return
	 */
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
	
	/**
	 * 根据登记的运维计划信息生成执行周期表达式
	 * @param periodType 周期类型
	 * @param exeHour 小时
	 * @param exeMinute 分钟
	 * @param qjcrttime 开始日期
	 * @return
	 */
	public String creatCronExp(String periodType,String exeHour, String exeMinute, String qjcrttime){
		String retCronExp = null;
		//秒 分 时 日 月 周
		if ("week".equals(periodType)) {
			String week = getWeekOfDate(qjcrttime, "eng");
			retCronExp = "0 " + exeMinute + " " + exeHour + " ? * " + week;
		} else if ("month".equals(periodType)){
			String day = qjcrttime.split("/")[2];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " * ?";
		} else if ("once".equals(periodType)){
			String day = qjcrttime.split("/")[2];
			String month = qjcrttime.split("/")[1];
			String year = qjcrttime.split("/")[0];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + month + " ? " + year;
		} else if ("day".equals(periodType)){
			retCronExp = "0 " + exeMinute + " " + exeHour + " * * ?";
		} else if ("quarter".equals(periodType)){
			String day = qjcrttime.split("/")[2];
			//String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + "*/3 ?";
		}
		
		return retCronExp;
	}
	
	
	/**
	 * 根据运维计划登记信息生成执行周期表达式说明
	 * @param periodType 周期类型
	 * @param exeHour 小时
	 * @param exeMinute 分钟
	 * @param startDate 开始日期
	 * @return
	 */
	public String getPeriodInfo(String periodType, String exeHour, String exeMinute,String startDate){
		String period = null;
		if("week".equals(periodType)){
			period = "周" + getWeekOfDate(startDate,null) + " ";
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

	/**
	 * 初始化运维计划详细设置页面（IGMTP0104）
	 * @param dto 
	 * @param cronExpression quartz表达式
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IGMTP01DTO initIGMTP0104(IGMTP01DTO dto,String cronExpression) throws Exception{
		IGMTP0101Form form = dto.getIgmtp0101Form();
		//String periodType = form.getPeriodType();//周期类型
		String qjcrttime = form.getQjcrttime().trim();//开始日期
		String qjendtime = form.getQjendtime().trim();//结束日期
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		if(StringUtils.isNotEmpty(qjcrttime) && StringUtils.isNotEmpty(qjendtime) && StringUtils.isNotEmpty(exeHour) && 
				StringUtils.isNotEmpty(exeMinute)){
			int start_year = Integer.valueOf(qjcrttime.split("/")[0]);
			int start_month = Integer.valueOf(qjcrttime.split("/")[1]);
			int start_day = Integer.valueOf(qjcrttime.split("/")[2]);
			
			int end_year = Integer.valueOf(qjendtime.split("/")[0]);
			int end_month = Integer.valueOf(qjendtime.split("/")[1]);
			int end_day = Integer.valueOf(qjendtime.split("/")[2]);
			
			//设置运维计划定时器
//			CronTrigger trigger = new CronTrigger("temp_job_1", "temp_trigger_1");
//			trigger.setCronExpression(cronExpression);
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			triggerBuilder.withIdentity("temp_job_1", "temp_trigger_1");
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
			Trigger trigger = triggerBuilder.build();
			//设置开始日期
			Calendar start = Calendar.getInstance();
			Date d1 = new Date();   
			start.setTime(d1);
			start.set(Calendar.YEAR, start_year);
			start.set(Calendar.MONTH, (start_month-1));
			start.set(Calendar.DAY_OF_MONTH, (start_day-1));
			//start.set(Calendar.DAY_OF_MONTH, start_day);
			start.set(Calendar.HOUR_OF_DAY,Integer.valueOf(exeHour));
			start.set(Calendar.MINUTE,Integer.valueOf(exeMinute));
			start.set(Calendar.SECOND,0);
			
			//设置结束日期
			Calendar end = Calendar.getInstance();
			Date d2 = new Date();
			end.setTime(d2);
    		end.set(Calendar.YEAR, end_year);
    		end.set(Calendar.MONTH, (end_month-1));
    		end.set(Calendar.DAY_OF_MONTH, end_day);
//    		if("day".equals(periodType)){
//    			end.set(Calendar.DAY_OF_MONTH, end_day);
//    		}else{
//    			end.set(Calendar.DAY_OF_MONTH, (end_day+1));
//    		}

    		end.set(Calendar.HOUR_OF_DAY,Integer.valueOf(exeHour));
    		end.set(Calendar.MINUTE,Integer.valueOf(exeMinute));
    		end.set(Calendar.SECOND,0);
    		
    		//取得需要执行运维计划的日期
    		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd");
    		List<Date> list = TriggerUtils.computeFireTimesBetween((CronTriggerImpl)trigger, new AnnualCalendar(), start.getTime(), end.getTime());
    		List<String> dateList = new ArrayList<String>();
            for(Date date:list){
        		Calendar temp = Calendar.getInstance();
            	temp.setTime(date);
            	dateList.add(sdfTime.format(temp.getTime()));   
            }
			if(dateList.size()>0){
				dto.setDateList(dateList);
			}
		}else{
			throw new BLException("IGMTP0101.E001");
		}
		
		return dto;
	}
	
	/**
	 * 登记工作计划日历初始化
	 * @param dto 
	 * @return
	 * @throws Exception
	 */
	public IGMTP03DTO initIGMTP0104Action(IGMTP03DTO dto) throws BLException {
		IGMTP0103Form form = dto.getIgmtp0103Form();
		//日历年月周设置
		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, dto.getCalendarMonth());
		thisMonth.set(Calendar.YEAR, dto.getCalendarYear());
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
		//日历行数取得
		int rowLenth = 5;
		if (35 - firstIndex - maxIndex < 0) {
			rowLenth = 6;
		}
		int showDay = 1;
		//月中日期元素设置
		List<IGMTP01042VO> rowList = new ArrayList<IGMTP01042VO>();
		for (int i = 0; i < rowLenth; i++) {
			IGMTP01042VO rowVO = new IGMTP01042VO();
			List<IGMTP01043VO> cellList = new ArrayList<IGMTP01043VO>();
			for (int j = 0; j < 7; j++) {
				IGMTP01043VO cellVO = new IGMTP01043VO();
				if ((i == 0 && j < firstIndex) || showDay > maxIndex) {
					// #FFFFFF值设置为3
					//没有日期色彩设置
					cellVO.setBgColor("#FFFFFF");
				} else {
					String dptime = dto.getCalendarYear() + "/"
							+ appendZero(dto.getCalendarMonth() + 1) + "/"
							+ appendZero(showDay);
					if (dptime.compareTo(dto.getTodayYMD()) == 0) {
						// 当前日期标识
						cellVO.setImg("<img src=\"images/igmtp3.gif\" width=\"14\" height=\"18\" border=\"0\">");
					}
					if (dto.getSelectedCheck() == null) {
						 // 计划选择日期
							// #ADF795值设置为0
						if (dptime.compareTo(form.getBegin_time()) < 0
								|| dptime.compareTo(form.getEnd_time()) > 0) { // 不在计划日期范围之内,设为灰色
							// #EFEFEF值设置为1
							cellVO.setBgColor("#EFEFEF");
						} else
						if (!(dptime.compareTo(form.getBegin_time()) < 0 || dptime
								.compareTo(form.getEnd_time()) > 0)) { // 计划日期范围之内
							// 可以选择
							// #E6FDD9值设置为2
							cellVO.setBgColor("#ADF795");
							cellVO.setSelectedDate("1");
							cellVO.setDateYMD(dptime);
						}
					}else
					if (dto.getSelectedCheck() != null) {
						if (dptime.equals(dto.getSelectedCheck().get(dptime))) { // 计划选择日期
							// #ADF795值设置为0
							cellVO.setBgColor("#ADF795");
							cellVO.setSelectedDate("1");
							cellVO.setDateYMD(dptime);
						}
						else if (dptime.compareTo(form.getBegin_time()) < 0
								|| dptime.compareTo(form.getEnd_time()) > 0) { // 不在计划日期范围之内
							// #EFEFEF值设置为1
							cellVO.setBgColor("#EFEFEF");
						} else if (!(dptime.compareTo(form.getBegin_time()) < 0 || dptime
								.compareTo(form.getEnd_time()) > 0)) { // 计划日期范围之内
							// 可以选择
							// #E6FDD9值设置为2
							cellVO.setBgColor("#E6FDD9");
							cellVO.setDateYMD(dptime);
							cellVO.setSelectedDate("0");
						} 
					}


					cellVO.setShowDay(String.valueOf(showDay));
					showDay = showDay + 1;

				}
				cellList.add(cellVO);
			}
			rowVO.setCellVOList(cellList);
			rowList.add(rowVO);
		}
		dto.setRowList(rowList);
		return dto;
	}
	/**
	 * 小于10处理
	 */
	private String appendZero(int arg){
		if(arg < 10){
			return "0" + arg;
		}
		return String.valueOf(arg);
	}
	
	/**
	 * 修改工作计划日历初始化
	 * @param dto 
	 * @return
	 * @throws Exception
	 */
	public IGMTP03DTO initIGMTP0107Action(IGMTP03DTO dto) throws BLException {
		IGMTP0107Form form = dto.getIgmtp0107Form();
		//日历年月周设置
		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, dto.getCalendarMonth());
		thisMonth.set(Calendar.YEAR, dto.getCalendarYear());
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
		//日历行数取得
		int rowLenth = 5;
		if (35 - firstIndex - maxIndex < 0) {
			rowLenth = 6;
		}
		int showDay = 1;
		//月中日期元素设置
		List<IGMTP01042VO> rowList = new ArrayList<IGMTP01042VO>();
		for (int i = 0; i < rowLenth; i++) {
			IGMTP01042VO rowVO = new IGMTP01042VO();
			List<IGMTP01043VO> cellList = new ArrayList<IGMTP01043VO>();
			for (int j = 0; j < 7; j++) {
				IGMTP01043VO cellVO = new IGMTP01043VO();
				if ((i == 0 && j < firstIndex) || showDay > maxIndex) {
					// #FFFFFF值设置为3
					//没有日期色彩设置
					cellVO.setBgColor("#FFFFFF");
				} else {
					String dptime = dto.getCalendarYear() + "/"
							+ appendZero(dto.getCalendarMonth() + 1) + "/"
							+ appendZero(showDay);
					if (dptime.compareTo(dto.getTodayYMD()) == 0) {
						// 当前日期标识
						cellVO.setImg("<img src=\"images/igmtp3.gif\" width=\"14\" height=\"18\" border=\"0\">");
						//查看当前日期上是否有计划任务,如果有则重新设置其值
						for(int k=0;k<dto.getDateList().size();k++){
							String[] time = dto.getDateList().get(k).split("_");
							if(dptime.compareTo(time[0]) == 0){
								if(time[1].compareTo("1") == 0){
									//已执行
									cellVO.setBgColor("#EFEFEF");
									//cellVO.setSelectedDate("0");
									//cellVO.setDateYMD(dptime);
									cellVO.setImg("<img src=\"images/igmtp2.gif\" width=\"14\" height=\"18\" border=\"0\">");
								}else{
									//未执行
									cellVO.setBgColor("#ADF795");
									cellVO.setSelectedDate("1");
									cellVO.setDateYMD(dptime);
									cellVO.setImg("<img src=\"images/igmtp1.gif\" width=\"14\" height=\"18\" border=\"0\">");
								}
								break;
							}
						}
						
					}
					if (dto.getSelectedCheck() == null) {
						 // 计划选择日期
							// #ADF795值设置为0
						if (dptime.compareTo(form.getBegin_time()) < 0
								|| dptime.compareTo(form.getEnd_time()) > 0) { // 不在计划日期范围之内,设为灰色
							// #EFEFEF值设置为1
							cellVO.setBgColor("#EFEFEF");
						} else
						if (!(dptime.compareTo(form.getBegin_time()) < 0 || dptime
								.compareTo(form.getEnd_time()) > 0)) { // 计划日期范围之内
							// 可以选择
							// #E6FDD9值设置为2
							cellVO.setBgColor("#ADF795");
							cellVO.setSelectedDate("1");
							cellVO.setDateYMD(dptime);
						}
					}else
					if (dto.getSelectedCheck() != null) {
						if (dptime.equals(dto.getSelectedCheck().get(dptime))) { // 计划选择日期
							
							if (dptime.compareTo(dto.getTodayYMD())>0) {
								//如果未执行且在计划范围内设置图标为对号
								// #ADF795值设置为0
								cellVO.setBgColor("#ADF795");
								cellVO.setSelectedDate("1");
								cellVO.setDateYMD(dptime);
								cellVO
										.setImg("<img src=\"images/igmtp1.gif\" width=\"14\" height=\"18\" border=\"0\">");
							} else {
								
								//如果已执行且在计划范围内设置图标为X号
								if(dptime.compareTo(dto.getTodayYMD()) != 0){
									cellVO.setBgColor("#EFEFEF");
									// cellVO.setSelectedDate("1");
									cellVO.setDateYMD(dptime);
									cellVO.setImg("<img src=\"images/igmtp2.gif\" width=\"14\" height=\"18\" border=\"0\">");
								}
							}
//							dto.setTodayYMD(dto.getTodayYMD());
						}
						else if (dptime.compareTo(form.getBegin_time()) < 0
								|| dptime.compareTo(form.getEnd_time()) > 0) { // 不在计划日期范围之内
							// #EFEFEF值设置为1
							cellVO.setBgColor("#EFEFEF");
						} else if (!(dptime.compareTo(form.getBegin_time()) < 0 || dptime
								.compareTo(form.getEnd_time()) > 0)) { // 计划日期范围之内
							// 可以选择
							// #E6FDD9值设置为2
							cellVO.setBgColor("#E6FDD9");
							cellVO.setDateYMD(dptime);
							cellVO.setSelectedDate("0");
						} 
					}


					cellVO.setShowDay(String.valueOf(showDay));
					showDay = showDay + 1;

				}
				cellList.add(cellVO);
			}
			rowVO.setCellVOList(cellList);
			rowList.add(rowVO);
		}
		dto.setRowList(rowList);
		return dto;
	}
	
	/**
	 * 修改工作计划变量初始化(IGMTP0107Action)
	 */
	public IGMTP03DTO initIGMTP0107(IGMTP03DTO dto) throws BLException {
		
		 //初始化所有已选择的日期
		if (dto.getIgmtp01061VO() != null) {
			dto.setSelectedCheck(this.initSelectedCheck(dto.getIgmtp01061VO()));
			dto.getIgmtp0107Form().setBegin_time(dto.getIgmtp01061VO().getStartDate());
			dto.getIgmtp0107Form().setEnd_time(dto.getIgmtp01061VO().getEndDate());
		} 
		//vo不空时为第一次初始化
		if(dto.getIgmtp01061VO() !=null){
			dto.setDateList(dto.getIgmtp01061VO().getDateList());
		}

		//计划范围中选中日期处理
		if (dto.getIgmtp0107Form().getSelectedCheck() != null) {
			dto.setSelectedCheck(this.getSelectedCheck(dto.getIgmtp0107Form(),dto.getSelectedCheck()));
		}
		// 当前年月日获得
		GregorianCalendar currentDay = new GregorianCalendar();
		int today = currentDay.get(Calendar.DAY_OF_MONTH);
		int month = currentDay.get(Calendar.MONTH);
		int year = currentDay.get(Calendar.YEAR);
		String todayYMD = year + "/" + appendZero(month + 1) + "/"+ appendZero(today);
		dto.setTodayYMD(todayYMD);
		
		// 起始年月获得
		int smonth;
		int syear;
		if(dto.getIgmtp01061VO() == null){//非第一次初始化时日期设置
			String[] sd = dto.getIgmtp0107Form().getBegin_time().split("/");
			 smonth = Integer.parseInt(sd[1])-1;
			 syear = Integer.parseInt(sd[0]);
		}else{//第一次初始化时设置日期
			String[] sd = dto.getIgmtp01061VO().getStartDate().split("/");
		 smonth = Integer.parseInt(sd[1])-1;
		 syear = Integer.parseInt(sd[0]);
		}
		
		dto.setSyear(syear);
		dto.setSmonth(smonth);

		return dto;
	}
	
	//设置选择计划的日期初始值map
	private Map<String, String> initSelectedCheck(IGMTP01061VO vo){
		//取日期列表
		List<String> dateList = vo.getDateList();
		//选择的日期map
		Map<String, String> selectedCheck = new HashMap<String, String>();
		if (dateList != null) {
			//设置值
			for (int i = 0; i < dateList.size(); i++) {
				selectedCheck.put(dateList.get(i).split("_")[0], dateList.get(i).split("_")[0]);
			}
		}
		return selectedCheck;
	}
	private Map<String, String> getSelectedCheck(IGMTP01011VO vo){
		List<String> dateList = vo.getDateList();
		Map<String, String> selectedCheck = new HashMap<String, String>();
		if (dateList != null) {
			for (int i = 0; i < dateList.size(); i++) {
				selectedCheck.put(dateList.get(i), dateList.get(i));
			}
		}
		return selectedCheck;
	}
	//计划范围中选中日期处理
	private Map<String, String> getSelectedCheck(IGMTP0107Form form,Map<String, String> selectedCheck){
		for (int i = 0; i < form.getSelectedCheck().length; i++) {
			String[] s = form.getSelectedCheck()[i].split("_");
			if (s[1].equals("0")) {
				if (selectedCheck.get(s[0]) != null) {//为空时该数据被移除
					selectedCheck.remove(s[0]);//取消选择时移除该数据
				}
			} else {//新增数据添加
				selectedCheck.put(s[0], s[0]);
			}
		}
		return selectedCheck;
	}
	
	public IGMTP04DTO getQuartzJobs(IGMTP04DTO dto) throws BLException {
		QuartzJobs quartzJobs = quartzJobsBL.findByPK(dto.getQjid());
		dto.setQuartzJobs(quartzJobs);
		return dto;
	}
	
	/**
	 * 初始化运维计划详细设置修改页面（IGMTP0106）
	 * @param dto 
	 * @param cronExpression quartz表达式
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IGMTP01DTO initIGMTP0107(IGMTP01DTO dto,String cronExpression) throws Exception{
		IGMTP0106Form form = dto.getIgmtp0106Form();
		//String periodType = form.getPeriodType();//周期类型
		String qjcrttime = form.getQjcrttime().trim();//开始日期
		String qjendtime = form.getQjendtime().trim();//结束日期
		String exeHour = form.getQjhour();//执行时间（小时）
		String exeMinute = form.getQjminute();//执行时间（分钟）
		Integer qjid = form.getQjid();//QuartzJobs表主键
		if(StringUtils.isNotEmpty(qjcrttime) && StringUtils.isNotEmpty(qjendtime) && StringUtils.isNotEmpty(exeHour) && 
				StringUtils.isNotEmpty(exeMinute)){
			int start_year = Integer.valueOf(qjcrttime.split("/")[0]);
			int start_month = Integer.valueOf(qjcrttime.split("/")[1]);
			int start_day = Integer.valueOf(qjcrttime.split("/")[2]);
			
			int end_year = Integer.valueOf(qjendtime.split("/")[0]);
			int end_month = Integer.valueOf(qjendtime.split("/")[1]);
			int end_day = Integer.valueOf(qjendtime.split("/")[2]);
			
			//设置运维计划定时器
//			CronTrigger trigger = new CronTrigger("temp_job_1", "temp_trigger_1");
//			trigger.setCronExpression(cronExpression);
			
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
	        triggerBuilder.withIdentity("temp_job_1", "temp_trigger_1");
	        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
	        Trigger trigger = triggerBuilder.build();
			
			//设置开始日期
			Calendar start = Calendar.getInstance();
			Date d1 = new Date();   
			start.setTime(d1);
			start.set(Calendar.YEAR, start_year);
			start.set(Calendar.MONTH, (start_month-1));
			start.set(Calendar.DAY_OF_MONTH, (start_day-1));
			//start.set(Calendar.DAY_OF_MONTH, start_day);
			start.set(Calendar.HOUR_OF_DAY,Integer.valueOf(exeHour));
			start.set(Calendar.MINUTE,Integer.valueOf(exeMinute));
			start.set(Calendar.SECOND,0);
			
			//设置结束日期
			Calendar end = Calendar.getInstance();
			Date d2 = new Date();
			end.setTime(d2);
    		end.set(Calendar.YEAR, end_year);
    		end.set(Calendar.MONTH, (end_month-1));
    		end.set(Calendar.DAY_OF_MONTH, end_day);
//    		if("day".equals(periodType)){
//    			end.set(Calendar.DAY_OF_MONTH, end_day);
//    		}else{
//    			end.set(Calendar.DAY_OF_MONTH, (end_day+1));
//    		}

    		end.set(Calendar.HOUR_OF_DAY,Integer.valueOf(exeHour));
    		end.set(Calendar.MINUTE,Integer.valueOf(exeMinute));
    		end.set(Calendar.SECOND,0);
    		
    		//取得需要执行运维计划的日期
    		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd");
    		List<Date> list = TriggerUtils.computeFireTimesBetween((CronTriggerImpl)trigger, new AnnualCalendar(), start.getTime(), end.getTime());
    		
    		//查询登记的运维计划详细信息集合
    		QuartzJobDetailsSearchCondImpl cond = new QuartzJobDetailsSearchCondImpl();
    		cond.setQjid(dto.getQjid());
    		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond, 0, 0);

    		List<String> dateList = new ArrayList<String>();//执行日期集合
    		List<String> new_date_List = new ArrayList<String>();//qjdList不存在的执行日期集合
    		
    		//查询QuartzJobs
    		QuartzJobs qj = quartzJobsBL.findByPK(qjid);
    		
    		//如果未修改结束日期则使用数据库中的日期集合
    		if(qjendtime.equals(qj.getQjendtime())){
    			for(QuartzJobDetails qjd:qjdList){
    				dateList.add(qjd.getQjdtime().substring(0,10)+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
    			}
    		}else{
    			if(list!=null && qjdList!=null){
        			//判断修改后的执行周期范围是否大等于之前设置的周期范围
        			if(qjendtime.compareTo(qj.getQjendtime())>=0){
        				for(Date date:list){
        	            	boolean flag = true;//计算出来的执行日期在数据库中是否已保存过
        	            	Calendar temp = Calendar.getInstance();
        	            	temp.setTime(date);
        	            	String temp_date = sdfTime.format(temp.getTime());
        	            	for(QuartzJobDetails qjd:qjdList){
        	                	//如果计算出来的执行日期在数据库中已保存过，则用数据库中的记录替换计算得到的记录
        	            		if(qjd.getQjdtime().length()>=10 && temp_date.equals(qjd.getQjdtime().substring(0,10))){
        	            			dateList.add(temp_date+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
        	            			flag = false;
        	            			break;
        	            		}
        	            	}
        	            	//如果计算得到在执行日期大于等于修改前的结束日期,说明该日期为新增日期
        	            	if(flag && temp_date.compareTo(qj.getQjendtime())>=0){
        	            		new_date_List.add(temp_date+"_"+IGMTP01BLType.JOB_TYPE_UNEXECUTION+"_0");
        	            	}
        	            }
        				
        			}else{
        				//修改后的执行周期范围小于原执行周期时,将数据库中保存在执行日期小于等于新结束日期的记录保存到集合中
        				for(QuartzJobDetails qjd:qjdList){
        					if(qjendtime.compareTo(qjd.getQjdtime().substring(0,10))>=0){
        						dateList.add(qjd.getQjdtime().substring(0,10)+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
        					}
            				
            			}
//        				for(QuartzJobDetails qjd:qjdList){
//        					boolean flag = true;//计算出来的执行日期在数据库中是否已保存过
//        					for(Date date:list){
//        						Calendar temp = Calendar.getInstance();
//            	            	temp.setTime(date);
//            	            	String temp_date = sdfTime.format(temp.getTime());
//            	            	//如果计算出来的执行日期在数据库中已保存过，则用数据库中的记录替换计算得到的记录
//        	            		if(qjd.getQjdtime().length()>=10 && temp_date.equals(qjd.getQjdtime().substring(0,10))){
//        	            			dateList.add(temp_date+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
//        	            			flag = false;
//        	            			break;
//        	            		}
//        					}
//        					if(flag && qjendtime.compareTo(qjd.getQjdtime().substring(0,10))>=0){
//        	            		new_date_List.add(qjd.getQjdtime().substring(0,10)+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
//        	            	}
//    	            	}
        			}
        			//将手动修改的执行日期补充到集合中
    				for(QuartzJobDetails qjd:qjdList){
    					String date = qjd.getQjdtime().substring(0,10);
    					if(!list.contains(date) && !new_date_List.contains(date) && qjendtime.compareTo(qjd.getQjdtime().substring(0,10))>=0){
    						dateList.add(qjd.getQjdtime().substring(0,10)+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
    					}
    				}
    				
        			
        		}

    		}
    		
    		
    		    		
            
            
            dateList.addAll(new_date_List);
			if(dateList.size()>0){
				dto.setDateList(dateList);
			}
		}else{
			throw new BLException("IGMTP0101.E001");
		}
		
		return dto;
	}
	
	/**
	 * 日常运维计划修改处理
	 * @param dto
	 * @throws BLException
	 */
	public IGMTP01DTO updateQuartzJobs(IGMTP01DTO dto) throws BLException {
		QuartzJobs quartzJobs = quartzJobsBL.findByPK(dto.getQjid());
		IGMTP0106Form form = dto.getIgmtp0106Form();
		//更新日常运维计划
		QuartzJobsTB qjTB = new QuartzJobsTB();
		qjTB.clone(quartzJobs);
		qjTB.setQjcrttime(form.getQjcrttime().trim());
		qjTB.setQjendtime(form.getQjendtime().trim());
		qjTB.setQjid(quartzJobs.getQjid());
		qjTB.setQjtricron(form.getQjtricron());
		qjTB.setQjperiodinfo(form.getQjperiodinfo());
		QuartzJobs qj = quartzJobsBL.updateQuartzJobs(qjTB);
		
		//结束日期
		String qjendtime = qjTB.getQjendtime().trim();
		//查询工作类型
		QuartzProcessRecord qpr = quartzProcessRecordBL.findByPK(Integer.valueOf(qjTB.getQjinfo()));
		if(qpr==null){
			throw new BLException("IGMTP0108.E002");
		}
		String prtype = qpr.getQprtype();//流程类型
		//运维计划修改时日历画面选中的日期集合,格式yyyy/mm/dd_type_qjdid
		List<String> selectList = dto.getSelectList();
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		
		//运维计划详细信息的主键集合
		List<Integer> qjdidList = new ArrayList<Integer>();
		
		//更新日常运维计划详细信息
		for(String date:selectList){
			try {
				String[] temps = date.split("_");
				if(temps!=null && temps.length>=1){
					String qjdid = temps[1];//QuartzJobDetails主键ID
					String selectDate = temps[0];//日历中选择的日期
					//主键不存在时保存，存在时更新
					if("0".equals(qjdid)){
						//保存运维计划详细信息
						QuartzJobDetailsTB quartzJobDetailsTB = new QuartzJobDetailsTB();
						quartzJobDetailsTB.setQjid(quartzJobs.getQjid());
						quartzJobDetailsTB.setQjdtime(selectDate+" "+exeHour+":"+exeMinute);
						quartzJobDetailsTB.setQjdweek(getWeekOfDate(selectDate,"CH"));
						quartzJobDetailsTB.setQjdtype(IGMTP01BLType.JOB_TYPE_UNEXECUTION);//设置为未执行
						quartzJobDetailsTB.setQjdtriname("trigger" + IGMTP01BLType.getTriggerKey());
						quartzJobDetailsTB.setQjdtrigrpname("tigGroup" + IGMTP01BLType.getTriggerKey());
						//保存
						QuartzJobDetails qjd = quartzJobDetailsBL.saveQuartzJobDetails(quartzJobDetailsTB);
						if(IGMTP01BLType.PROCESS_ENTERPRISE_TYPE.equals(prtype)){
							//注册指派工作到调度器quartz中
							try{
								createEnterpriseTimerJob(qjd,creatCronExp("once",exeHour,exeMinute,selectDate));
							}catch(Exception e){
								dto.addMessage(new ActionMessage("IGMTP0108.E003"));
								return dto;
							}
							
						}else if(IGMTP01BLType.PROCESS_PERSON_TYPE.equals(prtype)){
							//注册个人工作到调度器quartz中
							try{
								createPersonJobs(qjd,creatCronExp("once",exeHour,exeMinute,selectDate));
							}catch(Exception e){
								dto.addMessage(new ActionMessage("IGMTP0108.E003"));
								return dto;
							}
						}
						//保存主键
						qjdidList.add(qjd.getQjdid());
					}else{
						//查询日常运维计划详细信息
						QuartzJobDetails qjd = quartzJobDetailsBL.searchQuartzJobDetailsByQjdid(Integer.valueOf(qjdid));
						
						//判断执行时间是否在结束日期之前，如果不在则从Quartz中移除，在则进行修改
						if(qjendtime.compareTo(selectDate)>=0){
							//已经执行过的任务则不修改
							if(IGMTP01BLType.JOB_TYPE_EXECUTION.equals(qjd.getQjdtype())){
								//保存主键
								qjdidList.add(qjd.getQjdid());
							}else{
								//修改定时器,先删除后保存
								String triggerName = qjd.getQjdtriname();//触发器名称
								String triggerGroupName = qjd.getQjdtrigrpname();//触发器所属组的名称
								String jobName = "Job" + qjd.getQjid();
								String jobGroupName = "Group" + qjd.getQjid();
								
								JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
								if(IGMTP01BLType.PROCESS_ENTERPRISE_TYPE.equals(prtype)){
									//注册指派工作到调度器quartz中
									try{
										createEnterpriseTimerJob(qjd,creatCronExp("once",exeHour,exeMinute,selectDate));
									}catch(Exception e){
										dto.addMessage(new ActionMessage("IGMTP0108.E003"));
										return dto;
									}
									
								}else if(IGMTP01BLType.PROCESS_PERSON_TYPE.equals(prtype)){
									//注册个人工作到调度器quartz中
									try{
										createPersonJobs(qjd,creatCronExp("once",exeHour,exeMinute,selectDate));
									}catch(Exception e){
										dto.addMessage(new ActionMessage("IGMTP0108.E003"));
										return dto;
									}

								}
								
								//JobManager.modifyJobTime(qjd.getQjdtriname(), qjd.getQjdtrigrpname(), creatCronExp("once",form.getQjhour(),form.getQjminute(),selectDate));
								//更新日常运维计划详细信息
								QuartzJobDetailsTB quartzJobDetailsTB = (QuartzJobDetailsTB)SerializationUtils.clone(qjd);
								quartzJobDetailsTB.setQjdid(null);
								quartzJobDetailsTB.setQjdtime(selectDate+" "+exeHour+":"+exeMinute);
								quartzJobDetailsTB.setQjdweek(getWeekOfDate(selectDate,"CH"));
								
								//先删除
								quartzJobDetailsBL.deleteQuartzJobDetails(Integer.valueOf(qjdid));
								//后保存
								QuartzJobDetails qjDetails =quartzJobDetailsBL.updateQuartzJobDetails(quartzJobDetailsTB);
								//保存主键
								qjdidList.add(qjDetails.getQjdid());
							}
						}
//						else{
//							//删除
//							quartzJobDetailsBL.deleteQuartzJobDetails(Integer.valueOf(qjdid));
//							//从Quartz中移除
//							String triggerName = qjd.getQjdtriname();//触发器名称
//							String triggerGroupName = qjd.getQjdtrigrpname();//触发器所属组的名称
//							String jobName = "Job" + qjd.getQjid();
//							String jobGroupName = "Group" + qjd.getQjid();
//							
//							JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
//							log.debug("========移除定时任务jobName = " + jobName + "========");
//						}

					}
					
				}

			} catch (SchedulerException e) {
				log.error("==========Exception form Quartz===========");
				e.printStackTrace();
				dto.addMessage(new ActionMessage("IGMTP0108.E003"));
				return dto;
			} 
		}
		
		//查询数据库中存在的运维任务详细
		QuartzJobDetailsSearchCondImpl cond = new QuartzJobDetailsSearchCondImpl();
		cond.setQjid(qj.getQjid());
		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond, 0, 0);
		
		//删除修改后作废的运维计划任务详细记录
		for(QuartzJobDetails qjd:qjdList){
			//如果qjdList中的主键ID在qjdidList中不存在，则删除该记录
			if(!qjdidList.contains(qjd.getQjdid())){
				try {
					//删除
					quartzJobDetailsBL.deleteQuartzJobDetails(qjd.getQjdid());
					//从Quartz中移除
					String triggerName = qjd.getQjdtriname();//触发器名称
					String triggerGroupName = qjd.getQjdtrigrpname();//触发器所属组的名称
					String jobName = "Job" + qjd.getQjid();
					String jobGroupName = "Group" + qjd.getQjid();
					
					JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
					log.debug("========移除定时任务jobName = " + jobName + "========");
				}catch (SchedulerException e) {
					log.error("==========Exception form Quartz===========");
					//e.printStackTrace();
					dto.addMessage(new ActionMessage("IGMTP0108.E003"));
					return dto;
				} 
				
			}
		}
		dto.addMessage(new ActionMessage("IGSCH0101.I001"));
		return dto;
		
	}
	
	/**
	 * 向定时器注册运维计划任务(指派工作)
	 * @param quartzJobs
	 * @throws BLException
	 */
	private void createEnterpriseTimerJob(QuartzJobDetails quartzJobDetails,String cronExpression) throws BLException{
		EnterpriseTimerJob enterpriseTimerJob = new EnterpriseTimerJob();
		String jobName = "Job" + quartzJobDetails.getQjdid();
		String jobGroupName = "Group" + quartzJobDetails.getQjdid();
		try {
			//仅执行一次
			JobManager.addJob(jobName, jobGroupName, quartzJobDetails.getQjdtriname(), 
					quartzJobDetails.getQjdtrigrpname(), enterpriseTimerJob, cronExpression);
		
		} catch (SchedulerException e) {
			log.error("==========Exception form personTimerJob===========");
			log.debug(e.getMessage());
			throw new BLException("IGMTP0108.E003");
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
		
	}
	
	/**
	 * 向定时器注册运维计划任务(个人工作)
	 * @param quartzJobs
	 * @throws BLException
	 */
	public void createPersonJobs(QuartzJobDetails quartzJobDetails,String cronExpression) throws BLException {
		PersonTimerJob personTimerJob = new PersonTimerJob();
		String jobName = "Job" + quartzJobDetails.getQjdid();
		String jobGroupName = "Group" + quartzJobDetails.getQjdid();
		try {
			//仅执行一次
			JobManager.addJob(jobName, jobGroupName, quartzJobDetails.getQjdtriname(), 
					quartzJobDetails.getQjdtrigrpname(), personTimerJob, cronExpression);
		
		} catch (SchedulerException e) {
			log.error("==========Exception form personTimerJob===========");
			e.printStackTrace();
			log.debug(e.getMessage());
			throw new BLException("IGMTP0108.E003");
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
	}
	
	/**
	 * 修改工作计划变量初始化(IGMTP0104Action)
	 */
	public IGMTP03DTO initIGMTP0104(IGMTP03DTO dto) throws BLException {
		// 初始化所有已选择的日期
		if (dto.getIgmtp01011VO() != null) {
			dto.setSelectedCheck(this.getSelectedCheck(dto.getIgmtp01011VO()));
			dto.getIgmtp0103Form().setBegin_time(dto.getIgmtp01011VO().getStartDate());
			dto.getIgmtp0103Form().setEnd_time(dto.getIgmtp01011VO().getEndDate());
		}
		//计划范围中选中日期处理
		if (dto.getIgmtp0103Form().getSelectedCheck() != null) {
			for (int i = 0; i < dto.getIgmtp0103Form().getSelectedCheck().length; i++) {
				String[] s = dto.getIgmtp0103Form().getSelectedCheck()[i].split("_");
				if (s[1].equals("0")) {
					if (dto.getSelectedCheck().get(s[0]) != null) {
						dto.getSelectedCheck().remove(s[0]);//取消选择时移除该数据
					}
				} else {
					dto.getSelectedCheck().put(s[0], s[0]);
				}
			}
		}
		
		// 当前年月日获得
		GregorianCalendar currentDay = new GregorianCalendar();
		int today = currentDay.get(Calendar.DAY_OF_MONTH);
		int month = currentDay.get(Calendar.MONTH);
		int year = currentDay.get(Calendar.YEAR);
		
		// 起始年月日获得
		if(dto.getIgmtp01011VO() == null){
			String[] sd = dto.getIgmtp0103Form().getBegin_time().split("/");
			dto.setSyear(Integer.parseInt(sd[0]));
			dto.setSmonth(Integer.parseInt(sd[1])-1);
		}else{
			String[] sd = dto.getIgmtp01011VO().getStartDate().split("/");
			dto.setSyear(Integer.parseInt(sd[0]));
			dto.setSmonth(Integer.parseInt(sd[1])-1);
		}
		
		String todayYMD = year + "/" + appendZero(month + 1) + "/"+ appendZero(today);
		dto.setTodayYMD(todayYMD);

		return dto;
	}
}