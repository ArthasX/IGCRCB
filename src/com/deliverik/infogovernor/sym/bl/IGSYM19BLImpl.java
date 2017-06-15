/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����:����������Чʱ�����ҵ���߼�ʵ�� ��������������������Чʱ����� ������¼����� 2011/10/18
 */
public class IGSYM19BLImpl extends BaseBLImpl implements IGSYM19BL {
	static Log log = LogFactory.getLog(IGSYM19BLImpl.class);

	/**
	 * ��Ϣ����ģ��BL
	 */
	protected ProcessWorkTimeTemplateBL processWorkTimeTemplateBL;

	/**
	 * �û���������BL
	 */
	protected ProcessWorkTimeBL processWorkTimeBL;

	/**
	 * ���̼�ʱBL
	 */
	protected ProcessTimeBL processTimeBL;

	/**
	 * ���̼�¼BL
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
	 * ��Ϣ���ڲ�ѯ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO searchProcessWorkTimeTemplate(IGSYM19DTO dto)
			throws BLException {
		log.debug("========��Ϣ���ڲ�ѯ����ʼ========");
		ProcessWorkTimeTemplateSearchCondImpl cond = new ProcessWorkTimeTemplateSearchCondImpl();
		IGSYM1901Form igsym1901Form = dto.getIgsym1901Form();
		Integer year = igsym1901Form.getYear();
		Integer month = igsym1901Form.getMonth();
		// �·�С��10������ǰ�油0
		if (month + 1 < 10) {
			cond.setDate_like(year + "/0" + (month + 1));
		} else {
			cond.setDate_like(year + "/" + (month + 1));
		}
		// ��Ϣ���ڲ�ѯ
		List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList = processWorkTimeTemplateBL.searchProcessWorkTimeTemplate(cond);
		if (processWorkTimeTemplateInfoList != null&& processWorkTimeTemplateInfoList.size() > 0) {
			// ������VO����,����ÿ�������
			Map<String, IGSYM19012VO> voMap = new HashMap<String, IGSYM19012VO>();
			Calendar cal = new GregorianCalendar();
			// ��������Ϊ��ǰ�굱ǰ��1��
			cal.set(year, month, 1);
			// ȡ�õ�ǰ�굱ǰ��1�������ڼ�
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			// ��ʼ��voMap
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
				// ��ʼ��igsym19012vo
				igsym19012vo.setPwtId(pwtId);
				igsym19012vo.setFactTime(factTime);
				igsym19012vo.setYear(pwtDate.substring(0, 4));
				igsym19012vo.setMonth(pwtDate.substring(5, 7));
				igsym19012vo.setDay(pwtDate.substring(8));
				igsym19012vo.setPwtSleepTime(pwtSleepTime);
				// �����ʱΪ0����ʾ��ɫ
				if (factTime == 0) {
					igsym19012vo.setCellColor("#e3efff");
					igsym19012vo.setDayColor("red");
				} 
				// voMap��ֵ
				voMap.put("vo" + (dayOfWeek + i), igsym19012vo);
			}
			dto.setVoMap(voMap);
			dto.setProcessWorkTimeTemplateInfoList(processWorkTimeTemplateInfoList);
		}
		log.debug("========��Ϣ���ڲ�ѯ��������========");
		return dto;
	}

	/**
	 * ��Ϣ��������
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
		// ��ѯ�����¼
		List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList = processWorkTimeTemplateBL.searchProcessWorkTimeTemplate(cond);
		// ����м�¼������������
		if (processWorkTimeTemplateInfoList != null&& processWorkTimeTemplateInfoList.size() > 0) {
			return dto;
		}
		log.debug("========��Ϣ���ڵǼǴ���ʼ========");

		Integer year = igsym1902Form.getYear();
		String pwtStartTimeHour = igsym1902Form.getPwtStartTimeHour();
		String pwtStartTimeMin = igsym1902Form.getPwtStartTimeMin();
		String pwtEndTimeHour = igsym1902Form.getPwtEndTimeHour();
		String pwtEndTimeMin = igsym1902Form.getPwtEndTimeMin();
		// ������ʼʱ��
		String startTime = pwtStartTimeHour + ":" + pwtStartTimeMin;
		// ��������ʱ��
		String endTime = pwtEndTimeHour + ":" + pwtEndTimeMin;
		// ��ʱ
		Integer factTime = igsym1902Form.getFactTime();
		// ����ÿ���·�
		int maxDay = 0;
		for (int i = 1; i <= 12; i++) {
			maxDay = SVCHelper.getMaxDayForMonth(year, i);
			// ����ÿһ��
			for (int j = 1; j <= maxDay; j++) {
				Calendar curDay = new GregorianCalendar();
				curDay.set(year, i - 1, j);
				// ��ȡ��ĩ
				boolean isWeekend = SVCHelper.getWeekend(year, i - 1, j);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				// ȡ�õ�������
				String date = sdf.format(curDay.getTime());
				// ��ʼ����Ϣģ��ʵ��
				ProcessWorkTimeTemplateTB processWorkTimeTemplateTB = new ProcessWorkTimeTemplateTB();
				processWorkTimeTemplateTB.setPwtDate(date);
				// ��ĩ
				if (isWeekend) {
					processWorkTimeTemplateTB.setPwtSleepTime(8);
					processWorkTimeTemplateTB.setFactTime(0);
				}// ������
				else {
					processWorkTimeTemplateTB.setPwtStartTime(startTime);
					processWorkTimeTemplateTB.setPwtEndTime(endTime);
					processWorkTimeTemplateTB.setPwtSleepTime(0);
					processWorkTimeTemplateTB.setFactTime(factTime);
				}

				// ������Ϣ����
				processWorkTimeTemplateBL.registProcessWorkTimeTemplate(processWorkTimeTemplateTB);
			}
		}
		log.debug("========��Ϣ���ڵǼǴ�������========");
		return dto;
	}

	/**
	 * ��Ϣ���ڱ��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO updateProcessWorkTimeTemplateAction(IGSYM19DTO dto)
			throws BLException, ParseException {
		log.debug("========��Ϣ���ڱ������ʼ========");
		IGSYM1903Form igsym1903Form = dto.getIgsym1903Form();
		String pwtStartTimeHour = igsym1903Form.getPwtStartTimeHour();
		String pwtStartTimeMin = igsym1903Form.getPwtStartTimeMin();
		String pwtEndTimeHour = igsym1903Form.getPwtEndTimeHour();
		String pwtEndTimeMin = igsym1903Form.getPwtEndTimeMin();
		// ������ʼʱ��
		String startTime="";
		if(StringUtils.isNotEmpty(pwtStartTimeHour)&&StringUtils.isNotEmpty(pwtStartTimeMin)){
			startTime = pwtStartTimeHour + ":" + pwtStartTimeMin;
		}
		// ��������ʱ��
		String endTime ="";
		if(StringUtils.isNotEmpty(pwtEndTimeHour)&&StringUtils.isNotEmpty(pwtEndTimeMin)){
			endTime = pwtEndTimeHour + ":" + pwtEndTimeMin;
		}	
		// ��Ϣʱ��
		Integer sleepTime = igsym1903Form.getPwtSleepTime();
		// ��ʱ
		Integer factTime = igsym1903Form.getFactTime();
		// �������
		String pwtDate = igsym1903Form.getPwtDate();
		// ��ʼ����Ϣģ��ʵ��
		ProcessWorkTimeTemplateTB processWorkTimeTemplateTB = new ProcessWorkTimeTemplateTB();
		processWorkTimeTemplateTB.setPwtDate(pwtDate);
		processWorkTimeTemplateTB.setPwtStartTime(startTime);
		processWorkTimeTemplateTB.setPwtEndTime(endTime);
		processWorkTimeTemplateTB.setFactTime(factTime);
		processWorkTimeTemplateTB.setPwtSleepTime(sleepTime);
		processWorkTimeTemplateTB.setPwtId(igsym1903Form.getPwtId());
		// ����ģ���¼
		processWorkTimeTemplateBL.updateProcessWorkTimeTemplate(processWorkTimeTemplateTB);
		ProcessWorkTimeSearchCondImpl processWorkTimeSearchCond = new ProcessWorkTimeSearchCondImpl();
		processWorkTimeSearchCond.setPwDate(pwtDate);
		processWorkTimeSearchCond.setPwFlg("0");
		// ��ѯδ�趨�������ڵ������û���¼
		List<ProcessWorkTimeInfo> processWorkTimeList = processWorkTimeBL.searchProcessWorkTime(processWorkTimeSearchCond);
		// �������̼�ʱ������ID
		Map<Integer, Integer> pridMap = new HashMap<Integer, Integer>();
		if (processWorkTimeList != null) {
			for (ProcessWorkTimeInfo processWorkTimeInfo : processWorkTimeList) {
				// ��ʼ���û��������ڱ�ʵ��
				ProcessWorkTimeTB processWorkTimeTB = (ProcessWorkTimeTB) SerializationUtils.clone(processWorkTimeInfo);
				processWorkTimeTB.setPwStartTime(startTime);
				processWorkTimeTB.setPwEndTime(endTime);
				processWorkTimeTB.setFactTime(factTime);
				processWorkTimeTB.setPwSleep(sleepTime);
				// ����δ�趨�������ڵ������û���¼
				processWorkTimeBL.updateProcessWorkTime(processWorkTimeTB);
				ProcessTimeSearchCondImpl processTimeSearchCond = new ProcessTimeSearchCondImpl();
				processTimeSearchCond.setUserId(processWorkTimeInfo.getUserId());
				processTimeSearchCond.setPrtstartTime_le(pwtDate + " 23:59");
				processTimeSearchCond.setPrtEndTime_ge(pwtDate + " 00:00");
				// ��ѯ��Ӱ�������
				List<ProcessTimeInfo> processTimeList = processTimeBL.searchProcessTime(processTimeSearchCond);
				if (processTimeList != null) {
					for (ProcessTimeInfo processTime : processTimeList) {
						ProcessTimeTB processTimeTB = (ProcessTimeTB) SerializationUtils.clone(processTime);
						// ������Чʱ�俪ʼ
						ProcessWorkTimeSearchCondImpl pwCond = new ProcessWorkTimeSearchCondImpl();
						pwCond.setStartDate(SVCHelper.formatDate(processTime.getPrtstartTime(), "yyyy/MM/dd HH:ss","yyyy/MM/dd"));
						pwCond.setEndDate(SVCHelper.formatDate(processTime.getPrtEndTime(), "yyyy/MM/dd HH:ss","yyyy/MM/dd"));
						pwCond.setUserId(processWorkTimeInfo.getUserId());
						// �û���ĳʱ����ڵ���Ϣʱ��
						List<ProcessWorkTimeInfo> workTimeList = processWorkTimeBL.searchProcessWorkTime(pwCond);
						factTime = 0;
						if (workTimeList != null) {
							//�������ʱ�䲻Ϊ������¼�����Чʱ��
							if(processTime.getPrtEndTime()!=null){
								for (ProcessWorkTimeInfo pwBean : workTimeList) {
									if(StringUtils.isNotEmpty(pwBean.getPwStartTime())&&StringUtils.isNotEmpty(pwBean.getPwEndTime())){
										//�������ʱ���뿪ʼʱ��ʱͬһ�죬����ʱ��-�ÿ�ʼʱ��
										if(SVCHelper.formatDate(processTime.getPrtEndTime(), "yyyy/MM/dd HH:ss","yyyy/MM/dd").equals(SVCHelper.formatDate(processTime.getPrtstartTime(), "yyyy/MM/dd HH:ss","yyyy/MM/dd"))){
											factTime+=SVCHelper.calculateTime(processTime.getPrtstartTime(),processTime.getPrtEndTime());
										//����ǽ���ʱ���� �ý���ʱ�� - �ϰ�ʱ��
										}else if(processTime.getPrtEndTime().contains(pwBean.getPwDate())) {
											factTime += SVCHelper.calculateTime(pwBean.getPwDate()+ " " + pwBean.getPwStartTime(),processTime.getPrtEndTime());
										// ����ǿ�ʼʱ�������°�ʱ�� - ���̼�ʱ��ʼʱ��
										} else if (processTime.getPrtstartTime().contains(pwBean.getPwDate())) {
											factTime += SVCHelper.calculateTime(processTime.getPrtstartTime(),pwBean.getPwDate() + " "+ pwBean.getPwEndTime());
										} else {
											factTime += pwBean.getFactTime();
										}
									}
								}
							}
						}
						// ������Чʱ�����
						processTimeTB.setFactTime(factTime);
						// ���¼���������Чʱ��
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
				// ��������ʵ����Чʱ�俪ʼ
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

				// ��������ʵ����Чʱ�����
			}
		}
		log.debug("========��Ϣ���ڱ����������========");
		return dto;
	}

	/**
	 * �û���Ϣ����������ѯ
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
		//�û���Ϣ����������ѯ
		int processWorkTimeCount = processWorkTimeBL.getSearchCount(processWorkTimeSearchCond);
		dto.setProcessWorkTimeCount(processWorkTimeCount);
		return dto;
	}
	
	/**
	 * ��Ϣ����ģ����������
	 * @param dto
	 * @return
	 */
	public IGSYM19DTO searchProcessWorkTimeTemplateByPK(IGSYM19DTO dto) throws BLException{
		IGSYM1903Form igsym1903Form = dto.getIgsym1903Form();
		Integer pwtId = igsym1903Form.getPwtId();
		//��Ϣ����ģ����������
		ProcessWorkTimeTemplateInfo processWorkTimeTemplateInfo = processWorkTimeTemplateBL.searchProcessWorkTimeTemplateByPK(pwtId);
		//��ȡ����
		String pwtDate = processWorkTimeTemplateInfo.getPwtDate();
		//��ȡ������ʼʱ��
		String pwtStartTime = processWorkTimeTemplateInfo.getPwtStartTime();
		if(StringUtils.isNotEmpty(pwtStartTime)){
			String[] StartTime = pwtStartTime.split(":");
			igsym1903Form.setPwtStartTimeHour(StartTime[0]);
			igsym1903Form.setPwtStartTimeMin(StartTime[1]);
		}
		//��ȡ��������ʱ��
		String pwtEndTime = processWorkTimeTemplateInfo.getPwtEndTime();
		if(StringUtils.isNotEmpty(pwtEndTime)){
			String[] EndTime = pwtEndTime.split(":");
			igsym1903Form.setPwtEndTimeHour(EndTime[0]);
			igsym1903Form.setPwtEndTimeMin(EndTime[1]);
		}
		//��ȡ��Ϣʱ��
		Integer pwtSleepTime = processWorkTimeTemplateInfo.getPwtSleepTime();
		//��ȡ��ʱ
		Integer factTime = processWorkTimeTemplateInfo.getFactTime();
		igsym1903Form.setPwtDate(pwtDate);
		igsym1903Form.setPwtSleepTime(pwtSleepTime);
		igsym1903Form.setFactTime(factTime);
		dto.setIgsym1903Form(igsym1903Form);
		return dto;
	}
}
