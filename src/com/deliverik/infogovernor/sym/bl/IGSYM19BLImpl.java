/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.ProcessTimeBL;
import com.deliverik.framework.workflow.prr.bl.task.ProcessWorkTimeBL;
import com.deliverik.framework.workflow.prr.bl.task.ProcessWorkTimeTemplateBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessTimeSearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeSearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.ProcessWorkTimeTemplateSearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.ProcessTimeTB;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTB;
import com.deliverik.framework.workflow.prr.model.entity.ProcessWorkTimeTemplateTB;
import com.deliverik.infogovernor.sym.dto.IGSYM19DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1901Form;
import com.deliverik.infogovernor.sym.form.IGSYM1902Form;
import com.deliverik.infogovernor.sym.form.IGSYM1903Form;
import com.deliverik.infogovernor.sym.vo.IGSYM19012VO;
import com.deliverik.infogovernor.util.SVCHelper;

/**
 * 概述:服务流程有效时间计算业务逻辑实现 功能描述：服务流程有效时间计算 创建记录：张楠 2011/10/18
 */
public class IGSYM19BLImpl extends BaseBLImpl implements IGSYM19BL {
	static Log log = LogFactory.getLog(IGSYM19BLImpl.class);

	/**
	 * 作息日期模板BL
	 */
	protected ProcessWorkTimeTemplateBL processWorkTimeTemplateBL;

	/**
	 * 用户工作日期BL
	 */
	protected ProcessWorkTimeBL processWorkTimeBL;

	/**
	 * 流程计时BL
	 */
	protected ProcessTimeBL processTimeBL;

	/**
	 * 流程记录BL
	 */
	protected IG500BL ig500BL;

	public void setProcessWorkTimeTemplateBL(ProcessWorkTimeTemplateBL processWorkTimeTemplateBL) {
		this.processWorkTimeTemplateBL = processWorkTimeTemplateBL;
	}

	public void setProcessWorkTimeBL(ProcessWorkTimeBL processWorkTimeBL) {
		this.processWorkTimeBL = processWorkTimeBL;
	}

	public void setProcessTimeBL(ProcessTimeBL processTimeBL) {
		this.processTimeBL = processTimeBL;
	}

	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * 作息日期查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO searchProcessWorkTimeTemplate(IGSYM19DTO dto)
			throws BLException {
		log.debug("========作息日期查询处理开始========");
		ProcessWorkTimeTemplateSearchCondImpl cond = new ProcessWorkTimeTemplateSearchCondImpl();
		IGSYM1901Form igsym1901Form = dto.getIgsym1901Form();
		Integer year = igsym1901Form.getYear();
		Integer month = igsym1901Form.getMonth();
		// 月份小于10，则在前面补0
		if (month + 1 < 10) {
			cond.setDate_like(year + "/0" + (month + 1));
		} else {
			cond.setDate_like(year + "/" + (month + 1));
		}
		// 作息日期查询
		List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList = processWorkTimeTemplateBL.searchProcessWorkTimeTemplate(cond);
		if (processWorkTimeTemplateInfoList != null&& processWorkTimeTemplateInfoList.size() > 0) {
			// 日历中VO集合,保存每天的数据
			Map<String, IGSYM19012VO> voMap = new HashMap<String, IGSYM19012VO>();
			Calendar cal = new GregorianCalendar();
			// 设置日期为当前年当前月1日
			cal.set(year, month, 1);
			// 取得当前年当前月1日是星期几
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			// 初始化voMap
			for (int i = 1; i <= 42; i++) {
				voMap.put("vo" + i, null);

			}
			for (int i = 0; i < processWorkTimeTemplateInfoList.size(); i++) {
				IGSYM19012VO igsym19012vo = new IGSYM19012VO();
				ProcessWorkTimeTemplateInfo processWorkTimeTemplateInfo = processWorkTimeTemplateInfoList.get(i);
				Integer pwtId = processWorkTimeTemplateInfo.getPwtId();
				Integer factTime = processWorkTimeTemplateInfo.getFactTime();
				String pwtDate = processWorkTimeTemplateInfo.getPwtDate();
				Integer pwtSleepTime = processWorkTimeTemplateInfo.getPwtSleepTime();
				// 初始化igsym19012vo
				igsym19012vo.setPwtId(pwtId);
				igsym19012vo.setFactTime(factTime);
				igsym19012vo.setYear(pwtDate.substring(0, 4));
				igsym19012vo.setMonth(pwtDate.substring(5, 7));
				igsym19012vo.setDay(pwtDate.substring(8));
				igsym19012vo.setPwtSleepTime(pwtSleepTime);
				// 如果工时为0，显示灰色
				if (factTime == 0) {
					igsym19012vo.setCellColor("#e3efff");
					igsym19012vo.setDayColor("red");
				} 
				// voMap赋值
				voMap.put("vo" + (dayOfWeek + i), igsym19012vo);
			}
			dto.setVoMap(voMap);
			dto.setProcessWorkTimeTemplateInfoList(processWorkTimeTemplateInfoList);
		}
		log.debug("========作息日期查询处理终了========");
		return dto;
	}

	/**
	 * 作息日期新增
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO insertProcessWorkTimeTemplateAction(IGSYM19DTO dto)
			throws BLException {
		IGSYM1902Form igsym1902Form = dto.getIgsym1902Form();
		ProcessWorkTimeTemplateSearchCondImpl cond = new ProcessWorkTimeTemplateSearchCondImpl();
		cond.setDate_like(String.valueOf(igsym1902Form.getYear()));
		// 查询该年记录
		List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList = processWorkTimeTemplateBL.searchProcessWorkTimeTemplate(cond);
		// 如果有记录则不做新增处理
		if (processWorkTimeTemplateInfoList != null&& processWorkTimeTemplateInfoList.size() > 0) {
			return dto;
		}
		log.debug("========作息日期登记处理开始========");

		Integer year = igsym1902Form.getYear();
		String pwtStartTimeHour = igsym1902Form.getPwtStartTimeHour();
		String pwtStartTimeMin = igsym1902Form.getPwtStartTimeMin();
		String pwtEndTimeHour = igsym1902Form.getPwtEndTimeHour();
		String pwtEndTimeMin = igsym1902Form.getPwtEndTimeMin();
		// 工作开始时间
		String startTime = pwtStartTimeHour + ":" + pwtStartTimeMin;
		// 工作结束时间
		String endTime = pwtEndTimeHour + ":" + pwtEndTimeMin;
		// 工时
		Integer factTime = igsym1902Form.getFactTime();
		// 遍历每个月份
		int maxDay = 0;
		for (int i = 1; i <= 12; i++) {
			maxDay = SVCHelper.getMaxDayForMonth(year, i);
			// 遍历每一天
			for (int j = 1; j <= maxDay; j++) {
				Calendar curDay = new GregorianCalendar();
				curDay.set(year, i - 1, j);
				// 获取周末
				boolean isWeekend = SVCHelper.getWeekend(year, i - 1, j);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				// 取得当天日期
				String date = sdf.format(curDay.getTime());
				// 初始化作息模板实体
				ProcessWorkTimeTemplateTB processWorkTimeTemplateTB = new ProcessWorkTimeTemplateTB();
				processWorkTimeTemplateTB.setPwtDate(date);
				// 周末
				if (isWeekend) {
					processWorkTimeTemplateTB.setPwtSleepTime(8);
					processWorkTimeTemplateTB.setFactTime(0);
				}// 工作日
				else {
					processWorkTimeTemplateTB.setPwtStartTime(startTime);
					processWorkTimeTemplateTB.setPwtEndTime(endTime);
					processWorkTimeTemplateTB.setPwtSleepTime(0);
					processWorkTimeTemplateTB.setFactTime(factTime);
				}

				// 新增作息日期
				processWorkTimeTemplateBL.registProcessWorkTimeTemplate(processWorkTimeTemplateTB);
			}
		}
		log.debug("========作息日期登记处理终了========");
		return dto;
	}

	/**
	 * 作息日期变更
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO updateProcessWorkTimeTemplateAction(IGSYM19DTO dto)
			throws BLException, ParseException {
		log.debug("========作息日期变更处理开始========");
		IGSYM1903Form igsym1903Form = dto.getIgsym1903Form();
		String pwtStartTimeHour = igsym1903Form.getPwtStartTimeHour();
		String pwtStartTimeMin = igsym1903Form.getPwtStartTimeMin();
		String pwtEndTimeHour = igsym1903Form.getPwtEndTimeHour();
		String pwtEndTimeMin = igsym1903Form.getPwtEndTimeMin();
		// 工作开始时间
		String startTime="";
		if(StringUtils.isNotEmpty(pwtStartTimeHour)&&StringUtils.isNotEmpty(pwtStartTimeMin)){
			startTime = pwtStartTimeHour + ":" + pwtStartTimeMin;
		}
		// 工作结束时间
		String endTime ="";
		if(StringUtils.isNotEmpty(pwtEndTimeHour)&&StringUtils.isNotEmpty(pwtEndTimeMin)){
			endTime = pwtEndTimeHour + ":" + pwtEndTimeMin;
		}	
		// 休息时间
		Integer sleepTime = igsym1903Form.getPwtSleepTime();
		// 工时
		Integer factTime = igsym1903Form.getFactTime();
		// 变更日期
		String pwtDate = igsym1903Form.getPwtDate();
		// 初始化作息模板实体
		ProcessWorkTimeTemplateTB processWorkTimeTemplateTB = new ProcessWorkTimeTemplateTB();
		processWorkTimeTemplateTB.setPwtDate(pwtDate);
		processWorkTimeTemplateTB.setPwtStartTime(startTime);
		processWorkTimeTemplateTB.setPwtEndTime(endTime);
		processWorkTimeTemplateTB.setFactTime(factTime);
		processWorkTimeTemplateTB.setPwtSleepTime(sleepTime);
		processWorkTimeTemplateTB.setPwtId(igsym1903Form.getPwtId());
		// 更新模板记录
		processWorkTimeTemplateBL.updateProcessWorkTimeTemplate(processWorkTimeTemplateTB);
		ProcessWorkTimeSearchCondImpl processWorkTimeSearchCond = new ProcessWorkTimeSearchCondImpl();
		processWorkTimeSearchCond.setPwDate(pwtDate);
		processWorkTimeSearchCond.setPwFlg("0");
		// 查询未设定过该日期的所有用户记录
		List<ProcessWorkTimeInfo> processWorkTimeList = processWorkTimeBL.searchProcessWorkTime(processWorkTimeSearchCond);
		// 保存流程计时表流程ID
		Map<Integer, Integer> pridMap = new HashMap<Integer, Integer>();
		if (processWorkTimeList != null) {
			for (ProcessWorkTimeInfo processWorkTimeInfo : processWorkTimeList) {
				// 初始化用户工作日期表实体
				ProcessWorkTimeTB processWorkTimeTB = (ProcessWorkTimeTB) SerializationUtils.clone(processWorkTimeInfo);
				processWorkTimeTB.setPwStartTime(startTime);
				processWorkTimeTB.setPwEndTime(endTime);
				processWorkTimeTB.setFactTime(factTime);
				processWorkTimeTB.setPwSleep(sleepTime);
				// 更新未设定过该日期的所有用户记录
				processWorkTimeBL.updateProcessWorkTime(processWorkTimeTB);
				ProcessTimeSearchCondImpl processTimeSearchCond = new ProcessTimeSearchCondImpl();
				processTimeSearchCond.setUserId(processWorkTimeInfo.getUserId());
				processTimeSearchCond.setPrtstartTime_le(pwtDate + " 23:59");
				processTimeSearchCond.setPrtEndTime_ge(pwtDate + " 00:00");
				// 查询受影响的流程
				List<ProcessTimeInfo> processTimeList = processTimeBL.searchProcessTime(processTimeSearchCond);
				if (processTimeList != null) {
					for (ProcessTimeInfo processTime : processTimeList) {
						ProcessTimeTB processTimeTB = (ProcessTimeTB) SerializationUtils.clone(processTime);
						// 计算有效时间开始
						ProcessWorkTimeSearchCondImpl pwCond = new ProcessWorkTimeSearchCondImpl();
						pwCond.setStartDate(SVCHelper.formatDate(processTime.getPrtstartTime(), "yyyy/MM/dd HH:ss","yyyy/MM/dd"));
						pwCond.setEndDate(SVCHelper.formatDate(processTime.getPrtEndTime(), "yyyy/MM/dd HH:ss","yyyy/MM/dd"));
						pwCond.setUserId(processWorkTimeInfo.getUserId());
						// 用户这某时间段内的作息时间
						List<ProcessWorkTimeInfo> workTimeList = processWorkTimeBL.searchProcessWorkTime(pwCond);
						factTime = 0;
						if (workTimeList != null) {
							//如果结束时间不为空则从新计算有效时间
							if(processTime.getPrtEndTime()!=null){
								for (ProcessWorkTimeInfo pwBean : workTimeList) {
									if(StringUtils.isNotEmpty(pwBean.getPwStartTime())&&StringUtils.isNotEmpty(pwBean.getPwEndTime())){
										//如果结束时间与开始时间时同一天，结束时间-用开始时间
										if(SVCHelper.formatDate(processTime.getPrtEndTime(), "yyyy/MM/dd HH:ss","yyyy/MM/dd").equals(SVCHelper.formatDate(processTime.getPrtstartTime(), "yyyy/MM/dd HH:ss","yyyy/MM/dd"))){
											factTime+=SVCHelper.calculateTime(processTime.getPrtstartTime(),processTime.getPrtEndTime());
										//如果是结束时间则 用结束时间 - 上班时间
										}else if(processTime.getPrtEndTime().contains(pwBean.getPwDate())) {
											factTime += SVCHelper.calculateTime(pwBean.getPwDate()+ " " + pwBean.getPwStartTime(),processTime.getPrtEndTime());
										// 如果是开始时间则用下班时间 - 流程计时开始时间
										} else if (processTime.getPrtstartTime().contains(pwBean.getPwDate())) {
											factTime += SVCHelper.calculateTime(processTime.getPrtstartTime(),pwBean.getPwDate() + " "+ pwBean.getPwEndTime());
										} else {
											factTime += pwBean.getFactTime();
										}
									}
								}
							}
						}
						// 计算有效时间结束
						processTimeTB.setFactTime(factTime);
						// 重新计算流程有效时间
						processTimeBL.updateProcessTime(processTimeTB);
						Integer prid = processTime.getPrid();
						pridMap.put(prid, factTime);
					}
				}
			}
		}
		if (pridMap.size() > 0) {
			Set<Integer> pridSet = pridMap.keySet();
			for (Integer prid : pridSet) {
				IG500Info pr = ig500BL.searchIG500InfoByKey(prid);
				// 计算流程实际有效时间开始
				ProcessTimeSearchCondImpl ptCond = new ProcessTimeSearchCondImpl();
				ptCond.setPrid(prid);
				List<ProcessTimeInfo> ptList = processTimeBL.searchProcessTime(ptCond, 0, 0);
				if (ptList != null) {
					int sumTime = 0;
					for (ProcessTimeInfo ptInfo : ptList) {
						if (ptInfo.getFactTime() != null) {
							sumTime += ptInfo.getFactTime();
						}
					}
					IG500TB prtb = (IG500TB) SerializationUtils.clone(pr);
					prtb.setPrfacttime(sumTime);
					ig500BL.updateIG500Info(prtb);
				}

				// 计算流程实际有效时间结束
			}
		}
		log.debug("========作息日期变更处理终了========");
		return dto;
	}

	/**
	 * 用户作息日期数量查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO searchProcessWorkTimeCount(IGSYM19DTO dto)
			throws BLException {
		ProcessWorkTimeSearchCondImpl processWorkTimeSearchCond = new ProcessWorkTimeSearchCondImpl();
		processWorkTimeSearchCond.setUserId(dto.getUserId());
		Calendar cal = Calendar.getInstance();
		Integer year_like = cal.get(Calendar.YEAR);
		processWorkTimeSearchCond.setPwDate_like(String.valueOf(year_like));
		//用户作息日期数量查询
		int processWorkTimeCount = processWorkTimeBL.getSearchCount(processWorkTimeSearchCond);
		dto.setProcessWorkTimeCount(processWorkTimeCount);
		return dto;
	}
	
	/**
	 * 作息日期模板主键检索
	 * @param dto
	 * @return
	 */
	public IGSYM19DTO searchProcessWorkTimeTemplateByPK(IGSYM19DTO dto) throws BLException{
		IGSYM1903Form igsym1903Form = dto.getIgsym1903Form();
		Integer pwtId = igsym1903Form.getPwtId();
		//作息日期模板主键检索
		ProcessWorkTimeTemplateInfo processWorkTimeTemplateInfo = processWorkTimeTemplateBL.searchProcessWorkTimeTemplateByPK(pwtId);
		//获取日期
		String pwtDate = processWorkTimeTemplateInfo.getPwtDate();
		//获取工作开始时间
		String pwtStartTime = processWorkTimeTemplateInfo.getPwtStartTime();
		if(StringUtils.isNotEmpty(pwtStartTime)){
			String[] StartTime = pwtStartTime.split(":");
			igsym1903Form.setPwtStartTimeHour(StartTime[0]);
			igsym1903Form.setPwtStartTimeMin(StartTime[1]);
		}
		//获取工作结束时间
		String pwtEndTime = processWorkTimeTemplateInfo.getPwtEndTime();
		if(StringUtils.isNotEmpty(pwtEndTime)){
			String[] EndTime = pwtEndTime.split(":");
			igsym1903Form.setPwtEndTimeHour(EndTime[0]);
			igsym1903Form.setPwtEndTimeMin(EndTime[1]);
		}
		//获取休息时间
		Integer pwtSleepTime = processWorkTimeTemplateInfo.getPwtSleepTime();
		//获取工时
		Integer factTime = processWorkTimeTemplateInfo.getFactTime();
		igsym1903Form.setPwtDate(pwtDate);
		igsym1903Form.setPwtSleepTime(pwtSleepTime);
		igsym1903Form.setFactTime(factTime);
		dto.setIgsym1903Form(igsym1903Form);
		return dto;
	}
}
