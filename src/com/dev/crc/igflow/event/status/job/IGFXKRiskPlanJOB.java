/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.crc.igflow.event.status.job;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.infogovernor.fxk.bl.IGFXK03BLType;
/***
 * 风险计划定时发起指派工作 
 * @time 2014/07/26
 * @author 
 * @email 
 * @version 1.0
 */
public class IGFXKRiskPlanJOB implements Job {
	
	/** 初始化日志*/
	private static Log log = LogFactory.getLog(IGFXKRiskPlanJOB.class);
	
	/**定义风险计划定时任务 名称*/
	public static final String JOB_NAME = "RISKPLAN_JOB";
	public static final String GROUP_NAME = "RISKPLAN_GROUP";
	public static final String TRIGGER_NAME = "RISKPLAN_TRIGGER";
	public static final String TRIGGERGROUP_NAME = "RISKPLAN_TRIGGERGROUP";
	public static final String RISKPLAN_CRON_EXPRESSION="0 */10 * * * ?";//秒 分 时 日 月 周
	
	/**
	 * 执行入口
	 */
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		log.debug("====================风险计划定时任务开始=========================");
		//时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:ss");
		
		/** 获取流程处理API */
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		/** 获取流程查询API */
		FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
		
		//流程条件封装
		IG500SearchCondImpl cond_500 = new IG500SearchCondImpl();
		cond_500.setPrpdid(IGFXK03BLType.PROCESS_RISK_PDID);	//风险记录流程类型ID
		cond_500.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_END_STATUS); //流程状态不等于关闭
		
		//查询流程状态不是“关闭”的风险计划流程
		List<IG500Info> lst_ProcessRecord = workFlowOperationBL.searchProcessRecord(cond_500);

//		String nowDate = IGStringUtils.getCurrentDate();
//		//查询风险计划当天发起的数量
//		StringBuffer startTime = new StringBuffer();
//		startTime.append(nowDate).append(" 00:00");
//		List<ProcessRecordInfo> lst_process = new ArrayList<ProcessRecordInfo>();
//		try {
//			lst_process = flowSearchBL.searchProcessInfo(IGFXK03BLType.PROCESS_RISK_PDID, null, null);
//		} catch (BLException e) {
//			e.printStackTrace();
//			log.debug("风险计划流程查询失败!");
//		}
		
		//根据流程发起
		if(lst_ProcessRecord != null && lst_ProcessRecord.size() > 0){	//begin if1
			
			//遍历所有风险计划流程，获取不是“待发起”和“中止”状态的风险计划
			for (IG500Info processRecordInfo : lst_ProcessRecord) {	//begin for1
				//风险计划未关闭时，查询表格式表单信息
				if(!IGPRDCONSTANTS.PROCESS_TERMINATE.equals(processRecordInfo.getPrstatus())
						&& !IGPRDCONSTANTS.PROCESS_START_STATUS.equals(processRecordInfo.getPrstatus())){	//begin if2
					
					//获取表格式表单查询BL
					IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
					
					//表格式表单查询实例生成
					IG898SearchCondImpl cond = new IG898SearchCondImpl();
					cond.setPrid(processRecordInfo.getPrid());	//流程信息主键(prid)
					cond.setPidname(IGFXK03BLType.RISK_TABLE_NAME); //查询的表格式表单名称
					
					//查询指定流程信息中的表格式表单“工作列表”的所有信息
					List<IG898Info> lst_ig898_job = ig898BL.searchIG898(cond);
					
					//根据行号保存表格式表单信息
					Map<String, IG898Info> map_alue = new HashMap<String, IG898Info>();
					//根据列名保存该列名下的所有表格式表单信息
//					Map<String, List<Map<String, IG898Info>>> map_pvcolname = new HashMap<String,  List<Map<String,IG898Info>>>();
					Map<String, Map<String, IG898Info>> map_pvcolname = new HashMap<String,  Map<String,IG898Info>>();
					
					//遍历关联工作信息，如果关联工作中没有记录值，查询对应的工作提醒时间
					if(lst_ig898_job != null && lst_ig898_job.size() > 0){	//begin if3
						//封装工作列表集合和Map信息
						List<IG898Info> lst_job = new ArrayList<IG898Info>();
						//遍历流程的表格式表单
						for (IG898Info ig898Info : lst_ig898_job) {
							
							//封装关联工作的集合
							if(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_JOB.equals(ig898Info.getPvcolname())){
								lst_job.add(ig898Info);
							}
							
							//如果当前列名在Map中有记录，则将记录的表格式表单信息添加进Map中；如果当前列名在Map中没有记录，初始化Map信息并将记录的表格式表单信息添加进Map中
							if(map_pvcolname.get(ig898Info.getPvcolname()) != null){
								map_pvcolname.get(ig898Info.getPvcolname()).put(ig898Info.getPvrownumber(), ig898Info);
							}else{
								//初始化Map
								map_alue = new HashMap<String, IG898Info>();
								//根据行号记录表格式表单信息
								map_alue.put(ig898Info.getPvrownumber(), ig898Info);
								//根据列名记录表单信息
								map_pvcolname.put(ig898Info.getPvcolname(), map_alue);
							}
						}
						
						//遍历所有关联工作信息
						for (IG898Info ig898Info : lst_job) {	//begin for2
							//关联工作表单值为空时，判断是否发起相关指派工作
							if(StringUtils.isEmpty(ig898Info.getPvalue())){	//begin if4
								
								//克隆"关联工作"表单实体
								IG898TB ig898TB = (IG898TB)SerializationUtils.clone(ig898Info);
								
								//如果提醒时间大于当前时间，发起指派工作流程
								if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_REMTIME) != null 
										&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_REMTIME)
												.get(ig898Info.getPvrownumber()) != null){	//begin if5
									
									//获取"工作提醒时间"
									String time_rem =  map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_REMTIME)
															.get(ig898Info.getPvrownumber()).getPvalue();
									//获取当前时间
									String nowTime = IGStringUtils.getCurrentDateTime();
									
									try {
										//如果工作提醒时间大于当前时间，根据负责人信息发起指派工作
										if(sdf.parse(time_rem).getTime() < sdf.parse(nowTime).getTime()){	//begin if5-1
											 
											//根据负责人信息发起指派工作
											if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_MANAGER) != null 
													&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_MANAGER)
															.get(ig898Info.getPvrownumber()) != null){ //begin if5-2
												
												//获取"负责人"信息
												String userid_username = map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_MANAGER)
																			.get(ig898Info.getPvrownumber()).getPvalue();
												//发起指派工作
												if(StringUtils.isNotEmpty(userid_username)){ //begin if5-3
													if(userid_username.split("_user_").length >= 3){ //begin if5-4
														try {
														
															/** 1、获取指派工作发起相关信息 */
															String title = "";//指派工作名称
															String desc = "";//指派工作描述
															String userid = "";//指派工作发起人ID
															Integer roleid = 0;////指派工作发起用户ID
															//获取"工作名称"
															if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKNAME) != null 
																	&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKNAME)
																			.get(ig898Info.getPvrownumber()) != null){
																title = map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKNAME)
																				.get(ig898Info.getPvrownumber()).getPvalue();
															}
															//获取"工作说明"
															if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKDESC) != null 
																	&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKDESC)
																			.get(ig898Info.getPvrownumber()) != null){
																desc = map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_WORKDESC)
																			.get(ig898Info.getPvrownumber()).getPvalue();
															}
															//获取发起人ID(负责人ID)
															//获取发起人角色ID(负责人角色ID)
															userid = userid_username.split("_user_")[0];
															roleid = Integer.valueOf(userid_username.split("_user_")[2]);
															
															/** 2、调用发起方法 */
															Integer procesInit = procesInit(userid,roleid, title, desc);
															
															/** 3、更新【关联工作】信息 */
															ig898TB.setPvalue(procesInit.toString());
															ig898BL.registIG898(ig898TB);
															
															/** 4、更新【状态】 */
															//当可以获取【状态】表单时,更新该表单的值为“进行中”
															if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS) != null 
																	&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS)
																	.get(ig898Info.getPvrownumber()) != null){
																
																//获取状态信息
																IG898TB ig898TB_status = 
																		(IG898TB)SerializationUtils.clone(map_pvcolname
																				.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS)
																				.get(ig898Info.getPvrownumber()));
																ig898TB_status.setPvalue("进行中");
																//更新状态
																ig898BL.registIG898(ig898TB_status);
															}
														
														
														} catch (BLException e) {
															e.printStackTrace();
															log.debug("指派工作发起异常!");
														}
														
													}//end if5-4
												}//end if5-3
											}//end if5-2
										}//end if5-1
									} catch (ParseException e) {
										e.printStackTrace();
										log.debug("时间格式转换失败!");
									}
								}//end if5
							}//end if4
							else{
								
								try {
									//根据【关联工作】表单记录的流程ID，查询关联的指派工作流程信息
									List<ProcessRecordInfo> pr_job = flowSearchBL.searchProcessInfo(Integer.valueOf(ig898Info.getPvalue()), "");
									
									//如果关联指派工作流程已关闭，则更新【状态】表单为“已完成”
									if(pr_job != null && pr_job.size() > 0){
										
										//取程关联的指派工作流程信息
										ProcessRecordInfo pr = pr_job.get(0);
										//判断指派工作是否已关闭
										if(StringUtils.isNotEmpty(pr.getPrclosetime())){
											
											//更新"状态"
											if(map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS) != null 
													&& map_pvcolname.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS)
															.get(ig898Info.getPvrownumber()) != null){
												//获取状态信息
												IG898TB ig898TB_status = 
														(IG898TB)SerializationUtils.clone(map_pvcolname
																.get(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_STATUS)
																.get(ig898Info.getPvrownumber()).getPvalue());
												ig898TB_status.setPvalue("已完成");
												//更新状态
												ig898BL.registIG898(ig898TB_status);
											}
										}
									}
									
								} catch (NumberFormatException e1) {
									e1.printStackTrace();
									log.debug("流程PRID转换成整型失败!");
								} catch (BLException e1) {
									e1.printStackTrace();
									log.debug("更新【状态】表单失败!");
								}
								
							}
						}//end for2
					}//end if3
					
					//更新当前流程的工作完成情况
					try {
						updateFinishByRiskRelatedProcess(processRecordInfo);
					} catch (Exception e) {
						e.printStackTrace();
						log.debug("更新【计划完成情况】表单失败!");
					}
				}//end if2
			}//end for1
		}//end if1
		
		log.debug("====================风险计划定时任务结束=========================");
	}
	
	/**
	 * 指派工作发起
	 * 
	 * @throws BLException
	 */
	private Integer procesInit(String crtuserid, Integer crtroleid, String title, String desc) throws BLException{
		/** 流程处理功能API */
		FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport.getBean("flowOptBL");
		WorkFlowLog wfLog = new WorkFlowLog();
		wfLog.setExecutorid(crtuserid);
		wfLog.setExecutorRoleid(crtroleid);
		wfLog.setComment("指派工作发起");
		ProcessRecord process_init = new ProcessRecord(wfLog);
		process_init.setCrtuserid(crtuserid);
		process_init.setDefid("01042");
		process_init.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
		process_init.setRoleid(crtroleid);
		process_init.setTitle(title);
		process_init.setDescription(desc);
		Map<String, String> map_pivalue = new HashMap<String, String>();
		map_pivalue.put("限期完成时间", "");
		map_pivalue.put("工作类型", "");
		map_pivalue.put("紧急程度", "");
		map_pivalue.put("影响程度", "");
		map_pivalue.put("处理人", "");
		process_init.setFormvalue(map_pivalue);
		
		return flowOptBL.saveProcessAction(process_init);
	}

	/**
	 * 根据关联工作信息更新计划完成情况
	 * 
	 * @param prid
	 * @throws Exception
	 */
	private void updateFinishByRiskRelatedProcess(IG500Info process) throws Exception {
		Integer prid = process.getPrid();
		/** 获取流程查询API */
		FlowSearchBL flowSearchBL = (FlowSearchBL) WebApplicationSupport.getBean("flowSearchBL");
		/** 流程处理功能API */
		FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport.getBean("flowOptBL");
		 /** 获取表单处理BL */
	    IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");
		
		//判断流程ID是否存在
		if(prid != null){

			//获取表格式表单查询BL
			IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
			IG898SearchCondImpl cond = new IG898SearchCondImpl();
			cond.setPrid(prid);
			//查询关联工作信息
			cond.setPidname("工作列表");
			List<IG898Info> lst_ig898_job = ig898BL.searchIG898(cond);
			
			//记录完成情况
			float finish = 0;
			
			//遍历所有关联工作信息，查询关联的流程
			if(lst_ig898_job != null && lst_ig898_job.size() > 0){
				int count = lst_ig898_job.size();
				int sum = 0;
				for (IG898Info ig898Info : lst_ig898_job) {
					if("关联工作".equals(ig898Info.getPvcolname()) && StringUtils.isNotEmpty(ig898Info.getPvalue())){
						//查询关联的流程信息
						List<ProcessRecordInfo> searchProcessInfo = flowSearchBL.searchProcessInfo(Integer.valueOf(ig898Info.getPvalue()), "");
						//如果关联流程已关闭，则对记录关联流程关闭的变量进行累加
						if(searchProcessInfo != null && searchProcessInfo.size() > 0){
							ProcessRecordInfo processRecordInfo = searchProcessInfo.get(0);
							if(StringUtils.isNotEmpty(processRecordInfo.getPrclosetime())){
								sum ++;
							}
						}
					}
				}
				
				//计算完成情况
				finish = sum / count; 
			}
			//格式转换
		    Format format_float = new DecimalFormat("###.##");
		    String text = format_float.format(finish * 100) + "%";
		   
			//更新表单【工作完成情况】的信息
			List<IG599Info> lst_ig599 = ig599BL.searchIG599InfosByKey(prid);
			for (IG599Info ig599Info : lst_ig599) {
				if("工作完成情况".equals(ig599Info.getPivarname())){
					IG599TB ig599TB = (IG599TB)SerializationUtils.clone(ig599Info);
					ig599TB.setPivarvalue(text);
					ig599BL.saveIG599Info(ig599TB);
				}
			}
			
			//当【工作完成情况】为100%时，流程关闭
			if(finish == 1){
				//流程跃迁
				flowOptBL.transitionProcess(prid, process.getPruserid(), "提交", IGStringUtils.getCurrentDateTime());
			}
		}
	}
}
