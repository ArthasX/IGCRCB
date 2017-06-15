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

	/**��ά����BL*/
	private QuartzJobsBL quartzJobsBL;
	
	/**��ά����������BL*/
	private QuartzProcessRecordBL quartzProcessRecordBL;
	
	/**����ģ��BL*/
	protected IG259BL ig259BL;
	
	/**���̶���BL*/
	protected IG380BL ig380BL;
	
	/**���̱�������BL*/
	protected IG007BL ig007BL;
	
	/**���̶��ʲ�BL*/
	protected IG731BL ig731BL;
	
	/**���̱������ʲ�BL*/
	protected QuartzProcessInfoEntityBL quartzProcessInfoEntityBL;
	
	/**����BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**�ճ���ά�ƻ���Ϣ����BL*/
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
	 * ȡ������ģ�嶨����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGMTP01DTO getProcessDefinitions(IGMTP01DTO dto) throws BLException {
//		IG259Info pt = ig259BL.searchIG259ByPrType("WB");
		IG259Info pt = ig259BL.searchIG259ByPrType("WD");
		if(pt == null){
			throw new BLException("IGCO10000.E004","����ģ��");
		}
		List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
		dto.setPdList(pdList);
		return dto;
	}

	/**
	 * ������������Ϊ���ڼ��������������ͷ���ֵ
	 * @param strDate ����
	 * @param language ����
	 * @return
	 */
	public String getWeekOfDate(String strDate,String language) {
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
        if("eng".equals(language)){
        	return engWeekDays[w];
        }
        return weekDays[w];
    }
	
	/**
	 * ���ݵǼǵ���ά�ƻ���Ϣ����ִ�����ڱ��ʽ
	 * @param periodType ��������
	 * @param exeHour Сʱ
	 * @param exeMinute ����
	 * @param qjcrttime ��ʼ����
	 * @return
	 */
	public String creatCronExp(String periodType,String exeHour, String exeMinute, String qjcrttime){
		String retCronExp = null;
		//�� �� ʱ �� �� ��
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
	 * ������ά�ƻ��Ǽ���Ϣ����ִ�����ڱ��ʽ˵��
	 * @param periodType ��������
	 * @param exeHour Сʱ
	 * @param exeMinute ����
	 * @param startDate ��ʼ����
	 * @return
	 */
	public String getPeriodInfo(String periodType, String exeHour, String exeMinute,String startDate){
		String period = null;
		if("week".equals(periodType)){
			period = "��" + getWeekOfDate(startDate,null) + " ";
		} else if ("month".equals(periodType)){
			period = "��" + Integer.valueOf(startDate.split("/")[2].trim()) + "��  ";
		} else if ("once".equals(periodType)){
			period = startDate + " " + exeHour + ":" + exeMinute;
			return period;
		} else if ("day".equals(periodType)){
			period = "��";
		} else if ("quarter".equals(periodType)){
			period = "������" + Integer.valueOf(startDate.split("/")[2].trim()) + "��  ";
		} 
		return "ÿ" + period + exeHour + ":" + exeMinute;
	}

	/**
	 * ��ʼ����ά�ƻ���ϸ����ҳ�棨IGMTP0104��
	 * @param dto 
	 * @param cronExpression quartz���ʽ
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IGMTP01DTO initIGMTP0104(IGMTP01DTO dto,String cronExpression) throws Exception{
		IGMTP0101Form form = dto.getIgmtp0101Form();
		//String periodType = form.getPeriodType();//��������
		String qjcrttime = form.getQjcrttime().trim();//��ʼ����
		String qjendtime = form.getQjendtime().trim();//��������
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
			
			//������ά�ƻ���ʱ��
//			CronTrigger trigger = new CronTrigger("temp_job_1", "temp_trigger_1");
//			trigger.setCronExpression(cronExpression);
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			triggerBuilder.withIdentity("temp_job_1", "temp_trigger_1");
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
			Trigger trigger = triggerBuilder.build();
			//���ÿ�ʼ����
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
			
			//���ý�������
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
    		
    		//ȡ����Ҫִ����ά�ƻ�������
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
	 * �Ǽǹ����ƻ�������ʼ��
	 * @param dto 
	 * @return
	 * @throws Exception
	 */
	public IGMTP03DTO initIGMTP0104Action(IGMTP03DTO dto) throws BLException {
		IGMTP0103Form form = dto.getIgmtp0103Form();
		//��������������
		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, dto.getCalendarMonth());
		thisMonth.set(Calendar.YEAR, dto.getCalendarYear());
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
		//��������ȡ��
		int rowLenth = 5;
		if (35 - firstIndex - maxIndex < 0) {
			rowLenth = 6;
		}
		int showDay = 1;
		//��������Ԫ������
		List<IGMTP01042VO> rowList = new ArrayList<IGMTP01042VO>();
		for (int i = 0; i < rowLenth; i++) {
			IGMTP01042VO rowVO = new IGMTP01042VO();
			List<IGMTP01043VO> cellList = new ArrayList<IGMTP01043VO>();
			for (int j = 0; j < 7; j++) {
				IGMTP01043VO cellVO = new IGMTP01043VO();
				if ((i == 0 && j < firstIndex) || showDay > maxIndex) {
					// #FFFFFFֵ����Ϊ3
					//û������ɫ������
					cellVO.setBgColor("#FFFFFF");
				} else {
					String dptime = dto.getCalendarYear() + "/"
							+ appendZero(dto.getCalendarMonth() + 1) + "/"
							+ appendZero(showDay);
					if (dptime.compareTo(dto.getTodayYMD()) == 0) {
						// ��ǰ���ڱ�ʶ
						cellVO.setImg("<img src=\"images/igmtp3.gif\" width=\"14\" height=\"18\" border=\"0\">");
					}
					if (dto.getSelectedCheck() == null) {
						 // �ƻ�ѡ������
							// #ADF795ֵ����Ϊ0
						if (dptime.compareTo(form.getBegin_time()) < 0
								|| dptime.compareTo(form.getEnd_time()) > 0) { // ���ڼƻ����ڷ�Χ֮��,��Ϊ��ɫ
							// #EFEFEFֵ����Ϊ1
							cellVO.setBgColor("#EFEFEF");
						} else
						if (!(dptime.compareTo(form.getBegin_time()) < 0 || dptime
								.compareTo(form.getEnd_time()) > 0)) { // �ƻ����ڷ�Χ֮��
							// ����ѡ��
							// #E6FDD9ֵ����Ϊ2
							cellVO.setBgColor("#ADF795");
							cellVO.setSelectedDate("1");
							cellVO.setDateYMD(dptime);
						}
					}else
					if (dto.getSelectedCheck() != null) {
						if (dptime.equals(dto.getSelectedCheck().get(dptime))) { // �ƻ�ѡ������
							// #ADF795ֵ����Ϊ0
							cellVO.setBgColor("#ADF795");
							cellVO.setSelectedDate("1");
							cellVO.setDateYMD(dptime);
						}
						else if (dptime.compareTo(form.getBegin_time()) < 0
								|| dptime.compareTo(form.getEnd_time()) > 0) { // ���ڼƻ����ڷ�Χ֮��
							// #EFEFEFֵ����Ϊ1
							cellVO.setBgColor("#EFEFEF");
						} else if (!(dptime.compareTo(form.getBegin_time()) < 0 || dptime
								.compareTo(form.getEnd_time()) > 0)) { // �ƻ����ڷ�Χ֮��
							// ����ѡ��
							// #E6FDD9ֵ����Ϊ2
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
	 * С��10����
	 */
	private String appendZero(int arg){
		if(arg < 10){
			return "0" + arg;
		}
		return String.valueOf(arg);
	}
	
	/**
	 * �޸Ĺ����ƻ�������ʼ��
	 * @param dto 
	 * @return
	 * @throws Exception
	 */
	public IGMTP03DTO initIGMTP0107Action(IGMTP03DTO dto) throws BLException {
		IGMTP0107Form form = dto.getIgmtp0107Form();
		//��������������
		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, dto.getCalendarMonth());
		thisMonth.set(Calendar.YEAR, dto.getCalendarYear());
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
		int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
		//��������ȡ��
		int rowLenth = 5;
		if (35 - firstIndex - maxIndex < 0) {
			rowLenth = 6;
		}
		int showDay = 1;
		//��������Ԫ������
		List<IGMTP01042VO> rowList = new ArrayList<IGMTP01042VO>();
		for (int i = 0; i < rowLenth; i++) {
			IGMTP01042VO rowVO = new IGMTP01042VO();
			List<IGMTP01043VO> cellList = new ArrayList<IGMTP01043VO>();
			for (int j = 0; j < 7; j++) {
				IGMTP01043VO cellVO = new IGMTP01043VO();
				if ((i == 0 && j < firstIndex) || showDay > maxIndex) {
					// #FFFFFFֵ����Ϊ3
					//û������ɫ������
					cellVO.setBgColor("#FFFFFF");
				} else {
					String dptime = dto.getCalendarYear() + "/"
							+ appendZero(dto.getCalendarMonth() + 1) + "/"
							+ appendZero(showDay);
					if (dptime.compareTo(dto.getTodayYMD()) == 0) {
						// ��ǰ���ڱ�ʶ
						cellVO.setImg("<img src=\"images/igmtp3.gif\" width=\"14\" height=\"18\" border=\"0\">");
						//�鿴��ǰ�������Ƿ��мƻ�����,�����������������ֵ
						for(int k=0;k<dto.getDateList().size();k++){
							String[] time = dto.getDateList().get(k).split("_");
							if(dptime.compareTo(time[0]) == 0){
								if(time[1].compareTo("1") == 0){
									//��ִ��
									cellVO.setBgColor("#EFEFEF");
									//cellVO.setSelectedDate("0");
									//cellVO.setDateYMD(dptime);
									cellVO.setImg("<img src=\"images/igmtp2.gif\" width=\"14\" height=\"18\" border=\"0\">");
								}else{
									//δִ��
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
						 // �ƻ�ѡ������
							// #ADF795ֵ����Ϊ0
						if (dptime.compareTo(form.getBegin_time()) < 0
								|| dptime.compareTo(form.getEnd_time()) > 0) { // ���ڼƻ����ڷ�Χ֮��,��Ϊ��ɫ
							// #EFEFEFֵ����Ϊ1
							cellVO.setBgColor("#EFEFEF");
						} else
						if (!(dptime.compareTo(form.getBegin_time()) < 0 || dptime
								.compareTo(form.getEnd_time()) > 0)) { // �ƻ����ڷ�Χ֮��
							// ����ѡ��
							// #E6FDD9ֵ����Ϊ2
							cellVO.setBgColor("#ADF795");
							cellVO.setSelectedDate("1");
							cellVO.setDateYMD(dptime);
						}
					}else
					if (dto.getSelectedCheck() != null) {
						if (dptime.equals(dto.getSelectedCheck().get(dptime))) { // �ƻ�ѡ������
							
							if (dptime.compareTo(dto.getTodayYMD())>0) {
								//���δִ�����ڼƻ���Χ������ͼ��Ϊ�Ժ�
								// #ADF795ֵ����Ϊ0
								cellVO.setBgColor("#ADF795");
								cellVO.setSelectedDate("1");
								cellVO.setDateYMD(dptime);
								cellVO
										.setImg("<img src=\"images/igmtp1.gif\" width=\"14\" height=\"18\" border=\"0\">");
							} else {
								
								//�����ִ�����ڼƻ���Χ������ͼ��ΪX��
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
								|| dptime.compareTo(form.getEnd_time()) > 0) { // ���ڼƻ����ڷ�Χ֮��
							// #EFEFEFֵ����Ϊ1
							cellVO.setBgColor("#EFEFEF");
						} else if (!(dptime.compareTo(form.getBegin_time()) < 0 || dptime
								.compareTo(form.getEnd_time()) > 0)) { // �ƻ����ڷ�Χ֮��
							// ����ѡ��
							// #E6FDD9ֵ����Ϊ2
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
	 * �޸Ĺ����ƻ�������ʼ��(IGMTP0107Action)
	 */
	public IGMTP03DTO initIGMTP0107(IGMTP03DTO dto) throws BLException {
		
		 //��ʼ��������ѡ�������
		if (dto.getIgmtp01061VO() != null) {
			dto.setSelectedCheck(this.initSelectedCheck(dto.getIgmtp01061VO()));
			dto.getIgmtp0107Form().setBegin_time(dto.getIgmtp01061VO().getStartDate());
			dto.getIgmtp0107Form().setEnd_time(dto.getIgmtp01061VO().getEndDate());
		} 
		//vo����ʱΪ��һ�γ�ʼ��
		if(dto.getIgmtp01061VO() !=null){
			dto.setDateList(dto.getIgmtp01061VO().getDateList());
		}

		//�ƻ���Χ��ѡ�����ڴ���
		if (dto.getIgmtp0107Form().getSelectedCheck() != null) {
			dto.setSelectedCheck(this.getSelectedCheck(dto.getIgmtp0107Form(),dto.getSelectedCheck()));
		}
		// ��ǰ�����ջ��
		GregorianCalendar currentDay = new GregorianCalendar();
		int today = currentDay.get(Calendar.DAY_OF_MONTH);
		int month = currentDay.get(Calendar.MONTH);
		int year = currentDay.get(Calendar.YEAR);
		String todayYMD = year + "/" + appendZero(month + 1) + "/"+ appendZero(today);
		dto.setTodayYMD(todayYMD);
		
		// ��ʼ���»��
		int smonth;
		int syear;
		if(dto.getIgmtp01061VO() == null){//�ǵ�һ�γ�ʼ��ʱ��������
			String[] sd = dto.getIgmtp0107Form().getBegin_time().split("/");
			 smonth = Integer.parseInt(sd[1])-1;
			 syear = Integer.parseInt(sd[0]);
		}else{//��һ�γ�ʼ��ʱ��������
			String[] sd = dto.getIgmtp01061VO().getStartDate().split("/");
		 smonth = Integer.parseInt(sd[1])-1;
		 syear = Integer.parseInt(sd[0]);
		}
		
		dto.setSyear(syear);
		dto.setSmonth(smonth);

		return dto;
	}
	
	//����ѡ��ƻ������ڳ�ʼֵmap
	private Map<String, String> initSelectedCheck(IGMTP01061VO vo){
		//ȡ�����б�
		List<String> dateList = vo.getDateList();
		//ѡ�������map
		Map<String, String> selectedCheck = new HashMap<String, String>();
		if (dateList != null) {
			//����ֵ
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
	//�ƻ���Χ��ѡ�����ڴ���
	private Map<String, String> getSelectedCheck(IGMTP0107Form form,Map<String, String> selectedCheck){
		for (int i = 0; i < form.getSelectedCheck().length; i++) {
			String[] s = form.getSelectedCheck()[i].split("_");
			if (s[1].equals("0")) {
				if (selectedCheck.get(s[0]) != null) {//Ϊ��ʱ�����ݱ��Ƴ�
					selectedCheck.remove(s[0]);//ȡ��ѡ��ʱ�Ƴ�������
				}
			} else {//�����������
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
	 * ��ʼ����ά�ƻ���ϸ�����޸�ҳ�棨IGMTP0106��
	 * @param dto 
	 * @param cronExpression quartz���ʽ
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IGMTP01DTO initIGMTP0107(IGMTP01DTO dto,String cronExpression) throws Exception{
		IGMTP0106Form form = dto.getIgmtp0106Form();
		//String periodType = form.getPeriodType();//��������
		String qjcrttime = form.getQjcrttime().trim();//��ʼ����
		String qjendtime = form.getQjendtime().trim();//��������
		String exeHour = form.getQjhour();//ִ��ʱ�䣨Сʱ��
		String exeMinute = form.getQjminute();//ִ��ʱ�䣨���ӣ�
		Integer qjid = form.getQjid();//QuartzJobs������
		if(StringUtils.isNotEmpty(qjcrttime) && StringUtils.isNotEmpty(qjendtime) && StringUtils.isNotEmpty(exeHour) && 
				StringUtils.isNotEmpty(exeMinute)){
			int start_year = Integer.valueOf(qjcrttime.split("/")[0]);
			int start_month = Integer.valueOf(qjcrttime.split("/")[1]);
			int start_day = Integer.valueOf(qjcrttime.split("/")[2]);
			
			int end_year = Integer.valueOf(qjendtime.split("/")[0]);
			int end_month = Integer.valueOf(qjendtime.split("/")[1]);
			int end_day = Integer.valueOf(qjendtime.split("/")[2]);
			
			//������ά�ƻ���ʱ��
//			CronTrigger trigger = new CronTrigger("temp_job_1", "temp_trigger_1");
//			trigger.setCronExpression(cronExpression);
			
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
	        triggerBuilder.withIdentity("temp_job_1", "temp_trigger_1");
	        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
	        Trigger trigger = triggerBuilder.build();
			
			//���ÿ�ʼ����
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
			
			//���ý�������
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
    		
    		//ȡ����Ҫִ����ά�ƻ�������
    		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd");
    		List<Date> list = TriggerUtils.computeFireTimesBetween((CronTriggerImpl)trigger, new AnnualCalendar(), start.getTime(), end.getTime());
    		
    		//��ѯ�Ǽǵ���ά�ƻ���ϸ��Ϣ����
    		QuartzJobDetailsSearchCondImpl cond = new QuartzJobDetailsSearchCondImpl();
    		cond.setQjid(dto.getQjid());
    		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond, 0, 0);

    		List<String> dateList = new ArrayList<String>();//ִ�����ڼ���
    		List<String> new_date_List = new ArrayList<String>();//qjdList�����ڵ�ִ�����ڼ���
    		
    		//��ѯQuartzJobs
    		QuartzJobs qj = quartzJobsBL.findByPK(qjid);
    		
    		//���δ�޸Ľ���������ʹ�����ݿ��е����ڼ���
    		if(qjendtime.equals(qj.getQjendtime())){
    			for(QuartzJobDetails qjd:qjdList){
    				dateList.add(qjd.getQjdtime().substring(0,10)+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
    			}
    		}else{
    			if(list!=null && qjdList!=null){
        			//�ж��޸ĺ��ִ�����ڷ�Χ�Ƿ�����֮ǰ���õ����ڷ�Χ
        			if(qjendtime.compareTo(qj.getQjendtime())>=0){
        				for(Date date:list){
        	            	boolean flag = true;//���������ִ�����������ݿ����Ƿ��ѱ����
        	            	Calendar temp = Calendar.getInstance();
        	            	temp.setTime(date);
        	            	String temp_date = sdfTime.format(temp.getTime());
        	            	for(QuartzJobDetails qjd:qjdList){
        	                	//������������ִ�����������ݿ����ѱ�������������ݿ��еļ�¼�滻����õ��ļ�¼
        	            		if(qjd.getQjdtime().length()>=10 && temp_date.equals(qjd.getQjdtime().substring(0,10))){
        	            			dateList.add(temp_date+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
        	            			flag = false;
        	            			break;
        	            		}
        	            	}
        	            	//�������õ���ִ�����ڴ��ڵ����޸�ǰ�Ľ�������,˵��������Ϊ��������
        	            	if(flag && temp_date.compareTo(qj.getQjendtime())>=0){
        	            		new_date_List.add(temp_date+"_"+IGMTP01BLType.JOB_TYPE_UNEXECUTION+"_0");
        	            	}
        	            }
        				
        			}else{
        				//�޸ĺ��ִ�����ڷ�ΧС��ԭִ������ʱ,�����ݿ��б�����ִ������С�ڵ����½������ڵļ�¼���浽������
        				for(QuartzJobDetails qjd:qjdList){
        					if(qjendtime.compareTo(qjd.getQjdtime().substring(0,10))>=0){
        						dateList.add(qjd.getQjdtime().substring(0,10)+"_"+qjd.getQjdtype()+"_"+String.valueOf(qjd.getQjdid()));
        					}
            				
            			}
//        				for(QuartzJobDetails qjd:qjdList){
//        					boolean flag = true;//���������ִ�����������ݿ����Ƿ��ѱ����
//        					for(Date date:list){
//        						Calendar temp = Calendar.getInstance();
//            	            	temp.setTime(date);
//            	            	String temp_date = sdfTime.format(temp.getTime());
//            	            	//������������ִ�����������ݿ����ѱ�������������ݿ��еļ�¼�滻����õ��ļ�¼
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
        			//���ֶ��޸ĵ�ִ�����ڲ��䵽������
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
	 * �ճ���ά�ƻ��޸Ĵ���
	 * @param dto
	 * @throws BLException
	 */
	public IGMTP01DTO updateQuartzJobs(IGMTP01DTO dto) throws BLException {
		QuartzJobs quartzJobs = quartzJobsBL.findByPK(dto.getQjid());
		IGMTP0106Form form = dto.getIgmtp0106Form();
		//�����ճ���ά�ƻ�
		QuartzJobsTB qjTB = new QuartzJobsTB();
		qjTB.clone(quartzJobs);
		qjTB.setQjcrttime(form.getQjcrttime().trim());
		qjTB.setQjendtime(form.getQjendtime().trim());
		qjTB.setQjid(quartzJobs.getQjid());
		qjTB.setQjtricron(form.getQjtricron());
		qjTB.setQjperiodinfo(form.getQjperiodinfo());
		QuartzJobs qj = quartzJobsBL.updateQuartzJobs(qjTB);
		
		//��������
		String qjendtime = qjTB.getQjendtime().trim();
		//��ѯ��������
		QuartzProcessRecord qpr = quartzProcessRecordBL.findByPK(Integer.valueOf(qjTB.getQjinfo()));
		if(qpr==null){
			throw new BLException("IGMTP0108.E002");
		}
		String prtype = qpr.getQprtype();//��������
		//��ά�ƻ��޸�ʱ��������ѡ�е����ڼ���,��ʽyyyy/mm/dd_type_qjdid
		List<String> selectList = dto.getSelectList();
		String exeHour = form.getQjhour();
		String exeMinute = form.getQjminute();
		
		//��ά�ƻ���ϸ��Ϣ����������
		List<Integer> qjdidList = new ArrayList<Integer>();
		
		//�����ճ���ά�ƻ���ϸ��Ϣ
		for(String date:selectList){
			try {
				String[] temps = date.split("_");
				if(temps!=null && temps.length>=1){
					String qjdid = temps[1];//QuartzJobDetails����ID
					String selectDate = temps[0];//������ѡ�������
					//����������ʱ���棬����ʱ����
					if("0".equals(qjdid)){
						//������ά�ƻ���ϸ��Ϣ
						QuartzJobDetailsTB quartzJobDetailsTB = new QuartzJobDetailsTB();
						quartzJobDetailsTB.setQjid(quartzJobs.getQjid());
						quartzJobDetailsTB.setQjdtime(selectDate+" "+exeHour+":"+exeMinute);
						quartzJobDetailsTB.setQjdweek(getWeekOfDate(selectDate,"CH"));
						quartzJobDetailsTB.setQjdtype(IGMTP01BLType.JOB_TYPE_UNEXECUTION);//����Ϊδִ��
						quartzJobDetailsTB.setQjdtriname("trigger" + IGMTP01BLType.getTriggerKey());
						quartzJobDetailsTB.setQjdtrigrpname("tigGroup" + IGMTP01BLType.getTriggerKey());
						//����
						QuartzJobDetails qjd = quartzJobDetailsBL.saveQuartzJobDetails(quartzJobDetailsTB);
						if(IGMTP01BLType.PROCESS_ENTERPRISE_TYPE.equals(prtype)){
							//ע��ָ�ɹ�����������quartz��
							try{
								createEnterpriseTimerJob(qjd,creatCronExp("once",exeHour,exeMinute,selectDate));
							}catch(Exception e){
								dto.addMessage(new ActionMessage("IGMTP0108.E003"));
								return dto;
							}
							
						}else if(IGMTP01BLType.PROCESS_PERSON_TYPE.equals(prtype)){
							//ע����˹�����������quartz��
							try{
								createPersonJobs(qjd,creatCronExp("once",exeHour,exeMinute,selectDate));
							}catch(Exception e){
								dto.addMessage(new ActionMessage("IGMTP0108.E003"));
								return dto;
							}
						}
						//��������
						qjdidList.add(qjd.getQjdid());
					}else{
						//��ѯ�ճ���ά�ƻ���ϸ��Ϣ
						QuartzJobDetails qjd = quartzJobDetailsBL.searchQuartzJobDetailsByQjdid(Integer.valueOf(qjdid));
						
						//�ж�ִ��ʱ���Ƿ��ڽ�������֮ǰ������������Quartz���Ƴ�����������޸�
						if(qjendtime.compareTo(selectDate)>=0){
							//�Ѿ�ִ�й����������޸�
							if(IGMTP01BLType.JOB_TYPE_EXECUTION.equals(qjd.getQjdtype())){
								//��������
								qjdidList.add(qjd.getQjdid());
							}else{
								//�޸Ķ�ʱ��,��ɾ���󱣴�
								String triggerName = qjd.getQjdtriname();//����������
								String triggerGroupName = qjd.getQjdtrigrpname();//�����������������
								String jobName = "Job" + qjd.getQjid();
								String jobGroupName = "Group" + qjd.getQjid();
								
								JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
								if(IGMTP01BLType.PROCESS_ENTERPRISE_TYPE.equals(prtype)){
									//ע��ָ�ɹ�����������quartz��
									try{
										createEnterpriseTimerJob(qjd,creatCronExp("once",exeHour,exeMinute,selectDate));
									}catch(Exception e){
										dto.addMessage(new ActionMessage("IGMTP0108.E003"));
										return dto;
									}
									
								}else if(IGMTP01BLType.PROCESS_PERSON_TYPE.equals(prtype)){
									//ע����˹�����������quartz��
									try{
										createPersonJobs(qjd,creatCronExp("once",exeHour,exeMinute,selectDate));
									}catch(Exception e){
										dto.addMessage(new ActionMessage("IGMTP0108.E003"));
										return dto;
									}

								}
								
								//JobManager.modifyJobTime(qjd.getQjdtriname(), qjd.getQjdtrigrpname(), creatCronExp("once",form.getQjhour(),form.getQjminute(),selectDate));
								//�����ճ���ά�ƻ���ϸ��Ϣ
								QuartzJobDetailsTB quartzJobDetailsTB = (QuartzJobDetailsTB)SerializationUtils.clone(qjd);
								quartzJobDetailsTB.setQjdid(null);
								quartzJobDetailsTB.setQjdtime(selectDate+" "+exeHour+":"+exeMinute);
								quartzJobDetailsTB.setQjdweek(getWeekOfDate(selectDate,"CH"));
								
								//��ɾ��
								quartzJobDetailsBL.deleteQuartzJobDetails(Integer.valueOf(qjdid));
								//�󱣴�
								QuartzJobDetails qjDetails =quartzJobDetailsBL.updateQuartzJobDetails(quartzJobDetailsTB);
								//��������
								qjdidList.add(qjDetails.getQjdid());
							}
						}
//						else{
//							//ɾ��
//							quartzJobDetailsBL.deleteQuartzJobDetails(Integer.valueOf(qjdid));
//							//��Quartz���Ƴ�
//							String triggerName = qjd.getQjdtriname();//����������
//							String triggerGroupName = qjd.getQjdtrigrpname();//�����������������
//							String jobName = "Job" + qjd.getQjid();
//							String jobGroupName = "Group" + qjd.getQjid();
//							
//							JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
//							log.debug("========�Ƴ���ʱ����jobName = " + jobName + "========");
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
		
		//��ѯ���ݿ��д��ڵ���ά������ϸ
		QuartzJobDetailsSearchCondImpl cond = new QuartzJobDetailsSearchCondImpl();
		cond.setQjid(qj.getQjid());
		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond, 0, 0);
		
		//ɾ���޸ĺ����ϵ���ά�ƻ�������ϸ��¼
		for(QuartzJobDetails qjd:qjdList){
			//���qjdList�е�����ID��qjdidList�в����ڣ���ɾ���ü�¼
			if(!qjdidList.contains(qjd.getQjdid())){
				try {
					//ɾ��
					quartzJobDetailsBL.deleteQuartzJobDetails(qjd.getQjdid());
					//��Quartz���Ƴ�
					String triggerName = qjd.getQjdtriname();//����������
					String triggerGroupName = qjd.getQjdtrigrpname();//�����������������
					String jobName = "Job" + qjd.getQjid();
					String jobGroupName = "Group" + qjd.getQjid();
					
					JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
					log.debug("========�Ƴ���ʱ����jobName = " + jobName + "========");
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
	 * ��ʱ��ע����ά�ƻ�����(ָ�ɹ���)
	 * @param quartzJobs
	 * @throws BLException
	 */
	private void createEnterpriseTimerJob(QuartzJobDetails quartzJobDetails,String cronExpression) throws BLException{
		EnterpriseTimerJob enterpriseTimerJob = new EnterpriseTimerJob();
		String jobName = "Job" + quartzJobDetails.getQjdid();
		String jobGroupName = "Group" + quartzJobDetails.getQjdid();
		try {
			//��ִ��һ��
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
	 * ��ʱ��ע����ά�ƻ�����(���˹���)
	 * @param quartzJobs
	 * @throws BLException
	 */
	public void createPersonJobs(QuartzJobDetails quartzJobDetails,String cronExpression) throws BLException {
		PersonTimerJob personTimerJob = new PersonTimerJob();
		String jobName = "Job" + quartzJobDetails.getQjdid();
		String jobGroupName = "Group" + quartzJobDetails.getQjdid();
		try {
			//��ִ��һ��
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
	 * �޸Ĺ����ƻ�������ʼ��(IGMTP0104Action)
	 */
	public IGMTP03DTO initIGMTP0104(IGMTP03DTO dto) throws BLException {
		// ��ʼ��������ѡ�������
		if (dto.getIgmtp01011VO() != null) {
			dto.setSelectedCheck(this.getSelectedCheck(dto.getIgmtp01011VO()));
			dto.getIgmtp0103Form().setBegin_time(dto.getIgmtp01011VO().getStartDate());
			dto.getIgmtp0103Form().setEnd_time(dto.getIgmtp01011VO().getEndDate());
		}
		//�ƻ���Χ��ѡ�����ڴ���
		if (dto.getIgmtp0103Form().getSelectedCheck() != null) {
			for (int i = 0; i < dto.getIgmtp0103Form().getSelectedCheck().length; i++) {
				String[] s = dto.getIgmtp0103Form().getSelectedCheck()[i].split("_");
				if (s[1].equals("0")) {
					if (dto.getSelectedCheck().get(s[0]) != null) {
						dto.getSelectedCheck().remove(s[0]);//ȡ��ѡ��ʱ�Ƴ�������
					}
				} else {
					dto.getSelectedCheck().put(s[0], s[0]);
				}
			}
		}
		
		// ��ǰ�����ջ��
		GregorianCalendar currentDay = new GregorianCalendar();
		int today = currentDay.get(Calendar.DAY_OF_MONTH);
		int month = currentDay.get(Calendar.MONTH);
		int year = currentDay.get(Calendar.YEAR);
		
		// ��ʼ�����ջ��
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