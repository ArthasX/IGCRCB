/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00005BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00006BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00007BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG00DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0001Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0002Form;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.model.Mss00006Info;
import com.deliverik.infogovernor.syslog.model.Mss00007Info;
import com.deliverik.infogovernor.syslog.model.entity.Mss00005TB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 设备实时、历史日志告警业务逻辑实现类
 * @author 王省
 *
 */
public class IGLOG00BLImpl extends BaseBLImpl implements IGLOG00BL {

	static Log log = LogFactory.getLog(IGLOG00BLImpl.class);
	
	/** 告警信息天表taskBL */
	protected Mss00005BL mss00005BL;
	
	/** 告警信息月表taskBL */
	protected Mss00006BL mss00006BL;
	
	/** 告警信息历史表taskBL */
	protected Mss00007BL mss00007BL;
	
	/** 用于两表查询时记录起始位置 */
	protected static int fromCount;
	
	/** 用于两表查询时记录查询记录条数 */
	protected static int pageDispCount;
	
	/** 基础数据taskBL */
	protected CodeDetailBL codeDetailBL;
	
    /** 流程表单处理taskBL */
	protected IG599BL  ig599BL;
	
	
	
	/**
	 * 流程表单处理taskBL设定
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}
	
	public IGLOG00DTO searchSysLogAlarmListAction(IGLOG00DTO dto)
			throws BLException, Exception {
		log.debug("========设备告警信息查询开始========");
		IGLOG0001Form form = dto.getIglog0001Form();
		int totalCount = this.mss00005BL.getSearchCount(form);
		
		if(totalCount == 0){
			log.debug("========设备告警信息查询数据不存在========");
			dto.setTotalcount(totalCount);
			return dto;
		}
		if(totalCount > dto.getMaxSearchCount()){
			log.debug("========超过查询最大记录数========");
			return dto;
		}
		List<Mss00005Info> sysLogAlarmList = this.mss00005BL.searchMss00005(form);
		dto.setSysLogAlarmList(sysLogAlarmList);
		dto.setTotalcount(totalCount);
		log.debug("========设备告警信息查询终了========");
		return dto;
	}


	public IGLOG00DTO searchHistorySysLogAlarmListAction(IGLOG00DTO dto)
			throws BLException, Exception {
		log.debug("========设备历史告警信息查询开始========");
		List hisSysLogAlarmList = new ArrayList(); 
		int totalCount = 0;
		IGLOG0002Form form = dto.getIglog0002Form();
		String timeFrom = form.getAlarmtime_from();//2013/01/01 09:54
		String timeTo = form.getAlarmtime_to();
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date beginDay = null;
		Date endDay = null;
		if(StringUtils.isNotEmpty(timeFrom)) {
			beginDay = format.parse(timeFrom);
		}
		if(StringUtils.isNotEmpty(timeTo)) {
			endDay = format.parse(timeTo); 
		}
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		/** 如果起始和结束时间均为空 或者 起始和结束时间均在3个月内，直接在月表查询 */
		if((beginDay != null && endDay != null && getMonths(beginDay, today)<3 && getMonths(endDay, today)<3)){
			totalCount = this.mss00006BL.getSearchCount(form);
			if(totalCount == 0){
				log.debug("========设备历史告警信息查询数据不存在========");
				dto.setTotalcount(totalCount);
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========超过查询最大记录数========");
				return dto;
			}
			hisSysLogAlarmList = this.mss00006BL.searchMss00006(form,pDto.getFromCount(),pDto.getPageDispCount());
		/** 如果结束时间在3个月之前月之前，直接在历史表查询 */
		}else if(endDay != null && getMonths(endDay, today)>2){
			totalCount = this.mss00007BL.getSearchCount(form);
			if(totalCount == 0){
				log.debug("========设备历史告警信息查询数据不存在========");
				dto.setTotalcount(totalCount);
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========超过查询最大记录数========");
				return dto;
			}
			hisSysLogAlarmList = this.mss00007BL.searchMss00007(form,pDto.getFromCount(),pDto.getPageDispCount());
		}else{
			int mss00006Count = this.mss00006BL.getSearchCount(form);
			int mss00007Count = this.mss00007BL.getSearchCount(form);
			List<Mss00006Info> currentMonthSysLogAlarmList = new ArrayList<Mss00006Info>(); 
			List<Mss00007Info> historySysLogAlarmList = new ArrayList<Mss00007Info>(); 
			
			totalCount = mss00006Count + mss00007Count;
			if(totalCount == 0){
				log.debug("========设备历史告警信息查询数据不存在========");
				dto.setTotalcount(totalCount);
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========超过查询最大记录数========");
				return dto;
			}
			//起始条数+取得条数(先查06表)
			if(pDto.getFromCount()+pDto.getPageDispCount() <= mss00006Count){
				currentMonthSysLogAlarmList = this.mss00006BL.searchMss00006(form,pDto.getFromCount(),pDto.getPageDispCount());
			//06表和07表同时查
			}else if(pDto.getFromCount() <= mss00006Count){
				fromCount = 0;
				currentMonthSysLogAlarmList = this.mss00006BL.searchMss00006(form,pDto.getFromCount(),pDto.getPageDispCount());
				pageDispCount = pDto.getPageDispCount() - (mss00006Count - pDto.getFromCount());
				historySysLogAlarmList = this.mss00007BL.searchMss00007(form,fromCount,pageDispCount);
				fromCount = pageDispCount;
			//06表已经查完
			}else{
				historySysLogAlarmList = this.mss00007BL.searchMss00007(form,fromCount,pDto.getPageDispCount());
				fromCount = fromCount + pDto.getPageDispCount();
			}
			
			Map<Integer,Object> map = new LinkedHashMap<Integer,Object>();//使用LinkedHashMap保证排序不被打乱
			
			//用map做中转容器，防止历史表和月表中有重复的告警记录
			if(currentMonthSysLogAlarmList.size()!=0){
				for(Mss00006Info info:currentMonthSysLogAlarmList){
					map.put(info.getAlarmid(), info);
				}
			}
			if(historySysLogAlarmList.size()!=0){
				for(Mss00007Info info:historySysLogAlarmList){
					map.put(info.getAlarmid(), info);
				}
			}
			
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				Integer alarmid = (Integer) iterator.next();
				hisSysLogAlarmList.add(map.get(alarmid));
			}
		}
		pDto.setTotalCount(totalCount);
		dto.setHistorySysLogAlarmList(hisSysLogAlarmList);
		dto.setTotalcount(totalCount);
		
		log.debug("========设备历史告警信息查询终了========");
		return dto;
	}


	public IGLOG00DTO FixSysLogAlarmsAction(IGLOG00DTO dto) throws BLException,
			Exception {
		log.debug("========设备日志告警信息修复开始========");
		IGLOG0001Form form = dto.getIglog0001Form();
		List<Mss00005Info> sysLogAlarmList = this.mss00005BL.searchMss00005(form);
		for(Mss00005Info info:sysLogAlarmList){
//			Mss00006TB instance6 = this.mss00006BL.getMss00006TBInstance();
			Mss00005TB instance5 =(Mss00005TB)SerializationUtils.clone(info);
//			instance6.setAlarmid(info.getAlarmid());
//			instance6.setAlarmstate(1);//1:fixed 0:not fixed
			instance5.setAlarmstate(1);//1:fixed 0:not fixed
//			instance6.setAlarmtime(info.getAlarmtime());
//			instance6.setDeviceid(info.getDevceid());
//			instance6.setDeviceip(info.getDeviceip());
//			instance6.setDevicename(info.getDevicename());
//			instance6.setRuleconditionid(info.getRuleconditionid());
//			instance6.setRuleid(info.getRuleid());
//			instance6.setRulelevel(info.getRulelevel());
//			instance6.setSyslogmsg(info.getSyslogmsg());
//			instance6.setSyslogtime(info.getSyslogtime());
//			instance6.setSystime(new Date());//for trigger
			
//			this.mss00006BL.registMss00006(instance6);//insert into month-alerm
			this.mss00005BL.updateMss00005(instance5);//update day-alerm
		}
		log.debug("========设备日志告警信息修复终了========");
		return dto;
	}

	public IGLOG00DTO searchHistorySysLogAlarmListNopageAction(IGLOG00DTO dto)
			throws BLException, Exception {
		log.debug("========设备历史告警信息查询开始========");
		List hisSysLogAlarmList = new ArrayList(); 
		int totalCount = 0;
		IGLOG0002Form form = dto.getIglog0002Form();
		String timeFrom = form.getAlarmtime_from();
		String timeTo = form.getAlarmtime_to();
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date beginDay = null;
		Date endDay = null;
		if(StringUtils.isNotEmpty(timeFrom)) {
			beginDay = format.parse(timeFrom);
		}
		if(StringUtils.isNotEmpty(timeTo)) {
			endDay = format.parse(timeTo); 
		}
		
		/** 如果起始和结束时间均为空 或者 起始和结束时间均在3个月内，直接在月表查询 */
		if((beginDay != null && endDay != null && getMonths(beginDay, today)<3 && getMonths(endDay, today)<3)){
			totalCount = this.mss00006BL.getSearchCount(form);
			if(totalCount == 0){
				log.debug("========设备历史告警信息查询数据不存在========");
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========超过查询最大记录数========");
				return dto;
			}
			hisSysLogAlarmList = this.mss00006BL.searchMss00006(form);
		/** 如果结束时间在3个月之前月之前，直接在历史表查询 */
		}else if(endDay != null && getMonths(endDay, today)>2){
			totalCount = this.mss00007BL.getSearchCount(form);
			if(totalCount == 0){
				log.debug("========设备历史告警信息查询数据不存在========");
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========超过查询最大记录数========");
				return dto;
			}
			hisSysLogAlarmList = this.mss00007BL.searchMss00007(form);
		}else{
			int mss00006Count = this.mss00006BL.getSearchCount(form);
			int mss00007Count = this.mss00007BL.getSearchCount(form);
			List<Mss00006Info> currentMonthSysLogAlarmList = new ArrayList<Mss00006Info>(); 
			List<Mss00007Info> historySysLogAlarmList = new ArrayList<Mss00007Info>(); 
			
			totalCount = mss00006Count + mss00007Count;
			if(totalCount == 0){
				log.debug("========设备历史告警信息查询数据不存在========");
				return dto;
			}
			if(totalCount > dto.getMaxSearchCount()){
				log.debug("========超过查询最大记录数========");
				return dto;
			}
			currentMonthSysLogAlarmList = this.mss00006BL.searchMss00006(form);
			historySysLogAlarmList = this.mss00007BL.searchMss00007(form);
			
			Map<Integer,Object> map = new LinkedHashMap<Integer,Object>();//使用LinkedHashMap保证排序不被打乱
			
			//用map做中转容器，防止历史表和月表中有重复的告警记录
			if(currentMonthSysLogAlarmList.size()!=0){
				for(Mss00006Info info:currentMonthSysLogAlarmList){
					map.put(info.getAlarmid(), info);
				}
			}
			if(historySysLogAlarmList.size()!=0){
				for(Mss00007Info info:historySysLogAlarmList){
					map.put(info.getAlarmid(), info);
				}
			}
			
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				Integer alarmid = (Integer) iterator.next();
				hisSysLogAlarmList.add(map.get(alarmid));
			}
		}
		dto.setHistorySysLogAlarmList(hisSysLogAlarmList);
		
		log.debug("========设备历史告警信息查询终了========");
		return dto;
	}
	
	/**
	* 计算两个日期之间相差的月数
	* 
	* @param date1
	* @param date2
	* @return
	* @author 王省
	*/
	public static int getMonths(Date date1, Date date2)throws Exception {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date1);
	  
	    
	    int year = c.get(Calendar.YEAR);
	    int month = c.get(Calendar.MONTH);
	    
	    c.setTime(date2);
	    int year1 = c.get(Calendar.YEAR);
	    int month1 = c.get(Calendar.MONTH);
	    
	    int result;
	    if(year==year1) 
	    	result=month1-month;//两个日期相差几个月，即月份差
	    else 
	    	result=12*(year1-year)+month1-month;//两个日期相差几个月，即月份差

	    return result;
	}
	
	public void setMss00005BL(Mss00005BL mss00005BL) {
		this.mss00005BL = mss00005BL;
	}
	
	public void setMss00006BL(Mss00006BL mss00006BL) {
		this.mss00006BL = mss00006BL;
	}

	public void setMss00007BL(Mss00007BL mss00007BL) {
		this.mss00007BL = mss00007BL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}


	public IGLOG00DTO getAlarmPriority(IGLOG00DTO dto) throws Exception {
		String alarmPrioritiesStr = "";
        CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        dto.setAlarmPrioritiesList(cds);
        for(CodeDetail cd:cds){
        	alarmPrioritiesStr = alarmPrioritiesStr + cd.getCid()+"&"+cd.getCvalue()+",";
        }
        dto.setAlarmPrioritiesStr(alarmPrioritiesStr);
        return dto;
	}
	
//	/**
//	 * 设备告警带流程的列表
//	 * @作者 zhaoyong
//	 */
	public IGLOG00DTO searchSysLogAlarmListActionWithProcess(IGLOG00DTO dto)
			throws BLException {
//		log.debug("========查询带流程的设备告警列表处理开始========");
//		//新创建一个集合，来存放带有流程的告警信息
//		List<IGLOG0003VO> list_vo = new ArrayList<IGLOG0003VO>();
//		//查询所有带有告警id的流程
//		//实例化IG599查询条件
//		IG599SearchCondImpl cond = new IG599SearchCondImpl();
//		cond.setPivarname("设备告警id");
//		List<IG599Info> list_ig599 = ig599BL.searchIG599InfosByCond(cond);
//		//如果实时告警信息不为空遍历该集合
//		if(dto.getSysLogAlarmList()!=null){
//			for( Mss00005Info info:dto.getSysLogAlarmList()){
//				IGLOG0003VO vo = new IGLOG0003VO();
//				vo.setAlarmid(info.getAlarmid());
//				vo.setAlarmstate(info.getAlarmstate());
//				vo.setAlarmtime(info.getAlarmtime());
//				vo.setDevceid(info.getDevceid());
//				vo.setDeviceip(info.getDeviceip());
//				vo.setDevicename(info.getDevicename());
//				vo.setRuleconditionid(info.getRuleconditionid());
//				vo.setRuleid(info.getRuleid());
//				vo.setRulelevel(info.getRulelevel());
//				vo.setSyslogmsg(info.getSyslogmsg());
//				vo.setSyslogtime(info.getSyslogtime());
//		        for(IG599Info ig599:list_ig599){
//		        	if(String.valueOf(info.getAlarmid()).equals(ig599.getPivarvalue())){		        				        		
//		        		vo.setPrid(ig599.getPrid());
//		        		break;
//		        	}
//		        }
//		        if(vo.getPrid()==null){
//		        	vo.setPrid(0);
//		        }
//		        list_vo.add(vo);
//			}
//		}
//		dto.setList_vo(list_vo);
//		
//		log.debug("========查询带流程的设备告警列表处理结束========");
//		
		return dto;
	}

	public IGLOG00DTO getRefreshRate(IGLOG00DTO dto) throws BLException {
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid("950");
        condimpl.setCid("4");
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String rate = cds.get(0).getCvalue();
        if(StringUtils.isEmpty(rate) || "0".equals(rate)) rate = "60";
        dto.setRefreshRate(rate.trim());
		return dto;
	}

}
	


