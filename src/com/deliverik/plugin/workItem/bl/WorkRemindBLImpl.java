/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.plugin.workItem.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.bl.task.WorkInstanceBL;
import com.deliverik.infogovernor.wim.bl.task.WorkLogBL;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCondImpl;

/**
 * 
 * @Description 工作项-工作实例提醒BL实现
 *
 * @date 2017年6月22日
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkRemindBLImpl extends BaseBLImpl implements WorkRemindBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(WorkRemindBLImpl.class);
	
	/** 发送短信BL */
	protected SendMessageBL sendMessageBL;
	
	/** 工作定义BL */
	protected WorkDefinitionBL workDefinitionBL;
	
	/** 工作实例BL */
	protected WorkInstanceBL workInstanceBL;
	
	/** 工作日志BL */
	protected WorkLogBL workLogBL; 
	
	/** 基础工具详类细BL */
	protected CodeDetailBL codeDetailBL;
	
	/**
	 * 发送短信BL设定
	 *
	 * @param sendMessageBL 发送短信BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}
	
	/**
	 * 工作定义BL设定
	 * @param 工作定义BL
	 */
	public void setWorkDefinitionBL(WorkDefinitionBL workDefinitionBL) {
		this.workDefinitionBL = workDefinitionBL;
	}


	/**
	 * 工作实例BL设定
	 * @param 工作实例BL
	 */
	public void setWorkInstanceBL(WorkInstanceBL workInstanceBL) {
		this.workInstanceBL = workInstanceBL;
	}

	/**
	 * 工作日志BL
	 * @param 工作日志BL
	 */
	public void setWorkLogBL(WorkLogBL workLogBL) {
		this.workLogBL = workLogBL;
	}

	/**
	 * 基础工具详类细BL设定
	 * @param 基础工具详类细BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 工作实例提醒
	 */
	public void workInstanceRemind() throws BLException{
		log.info("=========工作实例提醒开始=========");
		//工作实例每日提醒
		everyDayRemind();
		//工作实例超时提醒
		overTimeTips();
    	log.info("=========工作实例提醒结束=========");
    }
	
	/**
	 * 工作实例每日提醒
	 * @throws BLException
	 */
	public void everyDayRemind() throws BLException{
		log.info("=========工作实例每日提醒处理开始=========");
		
		//=====1.调用工作项管理BL<检索工作实例表当天发起的所有工作实例，并根据工作实例状态为（未执行或执行中）状态条件筛选>=====
		List<WorkInstanceInfo> workInstance = workInstanceBL.findInstanceByTips();
		
		//=====2.若不为空，<循环检索结果获取每一条工作实例的执行人>=====
		if(workInstance!=null && workInstance.size()>0){
			for (int i = 0; i < workInstance.size(); i++) {
				//获取执行人id
				String excutorId = workInstance.get(i).getExcutorId();
				//获取执行人name
				String excutorName = workInstance.get(i).getExcutorName();
				
				//=====3.然后<根据工作wiid（实例表主键）检索工作日志表>，并<根据btnAction字段为1（1为[提交]动作，0为[保存]动作）日期栏日期为系统当前日期like筛选>出已确认的数据=====
				WorkLogSearchCondImpl logCond = new WorkLogSearchCondImpl();
				logCond.setWiid(workInstance.get(i).getWiid());	//设置外键工作实例wiid
				logCond.setTitleDate(IGStringUtils.getCurrentDate());	//设置日期栏日期
				logCond.setBtnAction("1");	//设置操作按钮为1（1：提交，2：保存）
				//调用BL检索已确认工作的执行人日志信息集合
				List<WorkLogInfo> workLog = workLogBL.searchWorkLog(logCond);
				
				//=====4.如果日志信息不为空，筛选后和对应工作实例表的<多执行人一一替换>，为空则需要提醒工作实例的全部执行人,不为空则提醒经过筛选替换后剩余的用户=====
				if(workLog!=null && workLog.size()>0){
					
					//筛选出未确认当日工作的执行人，进行短信提醒
					for (int j = 0; j < workLog.size(); j++) {
						
						if(excutorId.contains(workLog.get(j).getExcutorId()+"、")){
							//替换带“、”的userid
							excutorId = excutorId.replace(workLog.get(j).getExcutorId()+"、","");
							
						}else{
							//替换不带“、”的userid
							excutorId = excutorId.replace(workLog.get(j).getExcutorId(),"");
						}
						
						//处理可能遗留的“、”
						if(StringUtils.isNotEmpty(excutorId) && "、".equals(excutorId.substring(excutorId.length()-1))){
							
							excutorId = excutorId.substring(0, excutorId.length()-1);
						}
						if(StringUtils.isNotEmpty(excutorId)){
							for (int x = 0; x < excutorId.split("、").length; x++) {
								//发送每日提醒短信
								sendEveryDayMessage(excutorId.split("、")[x], 
										workInstance.get(i).getWdname(),workInstance.get(i).getCrtDate());
								
								log.info("→→→→→→→→→已发送每日工作提醒短信的工作名称："+workInstance.get(i).getWdname()
										+"，提醒的用户ID："+excutorId.split("、")[x]+"，提醒的用户名："+excutorName.split("、")[x]+"←←←←←←←←←←");
							}
						}
					}
				}else{
					//需要一一提醒该工作实例的执行人
					if(StringUtils.isNotEmpty(excutorId)){
						for (int x = 0; x < excutorId.split("、").length; x++) {
							//发送每日提醒短信
							sendEveryDayMessage(excutorId.split("、")[x], 
									workInstance.get(i).getWdname(),workInstance.get(i).getCrtDate());
							log.info("→→→→→→→→→已发送每日工作提醒短信的工作名称："+workInstance.get(i).getWdname()
									+"，提醒的用户ID："+excutorId.split("、")[x]+"，提醒的用户名："+excutorName.split("、")[x]+"←←←←←←←←←←");
						}
					}
				}
				
			}
		}
		log.info("=========工作实例每日提醒处理开始=========");
	}
	
	/**
	 * 工作超时提醒
	 * @throws BLException
	 */
	public void overTimeTips() throws BLException{
		log.info("==========工作实例超时提醒处理开始==========");
		//=====1.调用工作项管理BL<检索工作实例表当天发起的所有工作实例，并根据工作实例状态为（未执行或执行中）状态条件筛选>=====
		List<WorkInstanceInfo> workInstance = workInstanceBL.findInstanceByTips();
		
		//=====2.若不为空，<循环检索结果获取每一条工作实例的执行人>=====
		if(workInstance!=null && workInstance.size()>0){
			for (int i = 0; i < workInstance.size(); i++) {
				//获取执行人id
				String excutorId = workInstance.get(i).getExcutorId();
				//获取执行人name
				String excutorName = workInstance.get(i).getExcutorName();
				//取得工作定义表对象
				WorkDefinitionInfo workDefinitionInfo = workDefinitionBL.searchWorkDefinitionByPK(workInstance.get(i).getWdid());
				
				//=====3.然后<根据工作wiid（实例表主键）检索工作日志表>，并<根据btnAction字段为1（1为[提交]动作，0为[保存]动作）日期栏日期为系统当前日期like筛选>出已确认的数据=====
				WorkLogSearchCondImpl logCond = new WorkLogSearchCondImpl();
				logCond.setWiid(workInstance.get(i).getWiid());	//设置外键工作实例wiid
				logCond.setTitleDate(IGStringUtils.getCurrentDate());	//设置日期栏日期
				logCond.setBtnAction("1");	//设置操作按钮为1（1：提交，2：保存）
				//调用BL检索已确认工作的执行人日志信息集合
				List<WorkLogInfo> workLog = workLogBL.searchWorkLog(logCond);
				
				//=====4.如果日志信息不为空，筛选后和对应工作实例表的<多执行人一一替换>，为空则根据超时天数设置计算，
				//若已超时通过短信提醒全部执行人,不为空根据超时天数设置计算，若已超时提醒经过筛选替换后剩余的用户=====
				if(workLog!=null && workLog.size()>0){
					
					//筛选出未确认当日工作的执行人，进行短信提醒
					for (int j = 0; j < workLog.size(); j++) {
						
						if(excutorId.contains(workLog.get(j).getExcutorId()+"、")){
							//替换带“、”的userid
							excutorId = excutorId.replace(workLog.get(j).getExcutorId()+"、","");
							
						}else{
							//替换不带“、”的userid
							excutorId = excutorId.replace(workLog.get(j).getExcutorId(),"");
						}
						
						//处理可能遗留的“、”
						if(StringUtils.isNotEmpty(excutorId) && "、".equals(excutorId.substring(excutorId.length()-1))){
							
							excutorId = excutorId.substring(0, excutorId.length()-1);
						}
						
						//未确认工作的执行人结果集
						if(StringUtils.isNotEmpty(excutorId)){
							
							for (int x = 0; x < excutorId.split("、").length; x++) {
								
								//获取工作实例预计完成时间+超时提醒天数 > 系统日期，则需要提醒，否则 不提醒
								Date dateAfter = getDateAfter(strParseDate(workDefinitionInfo.getEstimateFinishDate()), 
										Integer.parseInt(workDefinitionInfo.getOvertimeTipsTime()));
								
								if(compairDate(dateAfter, new Date())==-1){
									
									//发送超时提醒短信
									sendOverTimeMessage(excutorId.split("、")[x], 
											workInstance.get(i).getWdname(),workInstance.get(i).getCrtDate());
									log.info("→→→→→→→→→已加入发送超时工作提醒短信的工作名称："+workInstance.get(i).getWdname()
											+"，提醒的用户ID："+excutorId.split("、")[x]+"，提醒的用户名："+excutorName.split("、")[x]+"←←←←←←←←←←");
								};
								
							}
						}
					}
				}else{
					//工作实例所有执行人结果集
					if(StringUtils.isNotEmpty(excutorId)){
						for (int x = 0; x < excutorId.split("、").length; x++) {
							//获取工作实例+超时提醒天数 > 系统日期，则需要提醒，否则 不提醒
							Date dateAfter = getDateAfter(strParseDate(workDefinitionInfo.getEstimateFinishDate()), 
									Integer.parseInt(workDefinitionInfo.getOvertimeTipsTime()));
							
							if(compairDate(dateAfter, new Date())==-1){
								
								//发送超时提醒短信
								sendOverTimeMessage(excutorId.split("、")[x], 
										workInstance.get(i).getWdname(),workInstance.get(i).getCrtDate());
								log.info("→→→→→→→→→已加入发送超时工作提醒短信的工作名称："+workInstance.get(i).getWdname()
										+"，提醒的用户ID："+excutorId.split("、")[x]+"，提醒的用户名："+excutorName.split("、")[x]+"←←←←←←←←←←");
							};
						}
					}
				}
				
			}
		}
		log.info("==========工作实例超时提醒处理结束==========");
	}
	
	
	/**
	 * @Description 发送每日提醒短信
	 * @param userid 用户userid
	 * @param workName 工作名称
	 * @param launchDate 工作发起日期
	 * @return
	 */
	private String sendEveryDayMessage(String userid,String workName,String launchDate){
		//短信内容
		String msg = "每日工作提醒：您有一份工作名称为【"+workName+"】，日期是："+launchDate+" 的工作待处理，请您尽快完成工作！";
		//发送短信
		sendMessageBL.sendSmsToUser(userid, msg);
		return msg;
	}
	
	/**
	 * @Description 发送超时提醒短信
	 * @param userid 用户userid
	 * @param workName 工作名称
	 * @param launchDate 工作发起日期
	 * @return
	 */
	private String sendOverTimeMessage(String userid,String workName,String launchDate){
		//短信内容
		String msg = "工作超时提醒：您有一份工作名称为【"+workName+"】，日期是："+launchDate+" 的工作已超时，请您尽快完成工作！";
		//发送短信
		sendMessageBL.sendSmsToUser(userid, msg);
		return msg;
	}
	
	/**
	 * 获取日期后几天的日期
	 * @param d 传入的日期
	 * @param day 增加的天数
	 * @return
	 */
	private Date getDateAfter(Date d, int day) {  
		
        Calendar now = Calendar.getInstance();  
        //设置当系统日期
        now.setTime(d);
        //系统日期+天
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
	
	/**
	 * 比较日期大小
	 * @param dt1 日期1
	 * @param dt2 日期2
	 * @return 返回1：日期1>日期2，返回-1：日期1<日期2，返回0：日期1=日期2
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
	 * 字符串格式转成日期
	 * @param str 字符串
	 * @return 日期
	 */
	private Date strParseDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("字符串强转成日期格式失败，要转换的字符串:"+str+"\n类：WorkRemindBLImpl，方法：strParseDate() Line：331\n"+e.getMessage());
			e.printStackTrace();
		}
		return date;
	}
}
