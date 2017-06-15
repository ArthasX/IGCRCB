/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.SuspendProcess;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.bl.task.RemindConfigureBL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0302Form;
import com.deliverik.infogovernor.smr.form.IGSMR0303Form;
import com.deliverik.infogovernor.smr.form.IGSMR0304Form;
import com.deliverik.infogovernor.smr.job.IGSMR0301JOB;
import com.deliverik.infogovernor.smr.job.IGSMR0302JOB;
import com.deliverik.infogovernor.smr.job.IGSMR0303JOB;
import com.deliverik.infogovernor.smr.job.IGSMR0304JOB;
import com.deliverik.infogovernor.smr.job.IGSMR0305JOB;
import com.deliverik.infogovernor.smr.job.IGSMRJOBCONSTANTS;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCondImpl;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;
import com.deliverik.infogovernor.smr.model.entity.RemindConfigureTB;
import com.deliverik.infogovernor.smr.model.entity.ReportHistorySearchVW;

/**
 * 概述:我的填报（年报）查询 
 * 功能描述：我的填报（年报）查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-07-25
 * 修改记录：
 */
public class IGSMR03BLImpl extends BaseBLImpl implements IGSMR03BL {
	
	private static Log log = LogFactory.getLog(IGSMR03BLImpl.class);
	
	/**年报查询BL*/
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;

	/**流程处理BL*/
	protected FlowOptBL flowOptBL;
	
	/**关系表BL*/
	protected RegulatoryReportDetailBL regulatoryReportDetailBL;
	
	/**流程表BL*/
	protected IG500BL ig500BL;
	
	/**流程设置BL*/
	protected FlowSetBL flowSetBL;
	
	/**发送短信BL*/
	protected SendMessageBL sendMessageBL;
	
	/**用户角色BL*/
	protected UserRoleBL userRoleBL;
	
	/**参与人BL*/
	protected IG337BL ig337BL;
	
	/**流程状态BL*/
	protected IG333BL ig333BL;
	
	/**提醒报表配置BL*/
	protected RemindConfigureBL remindConfigureBL;
	
	/**表单值bl*/
	protected IG599BL ig599BL;
	

	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}

	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	public void setRegulatoryReportDetailBL(
			RegulatoryReportDetailBL regulatoryReportDetailBL) {
		this.regulatoryReportDetailBL = regulatoryReportDetailBL;
	}

	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	
	public void setRemindConfigureBL(RemindConfigureBL remindConfigureBL) {
		this.remindConfigureBL = remindConfigureBL;
	}

	
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}	
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**
	 * 查询需要我处理的年报
	 * @throws BLException 
	 *
	 */
	public IGSMR03DTO needMeManagerAction(IGSMR03DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将年报的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_REPORT);
		//将流程状态名放进cond中
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
		//查询需要我处理的年报
		List<AnnualReportVWInfo> list_arq = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//将集合遍历组成以年报说明为键，每条流程为值的map集合
		Map<String,List<AnnualReportVW>> map_arq = new LinkedHashMap<String, List<AnnualReportVW>>();
		//遍历查询结果的集合
		for(AnnualReportVWInfo info:list_arq){
			//判断最外层map里面是否存在某一个首层名称
			if(map_arq.get(info.getReportdesc())==null){
				//定义一个临时list集合
				List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
				 //得到实体
			    AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
				//将循环到的实体放进临时集合里面
				secondList.add(tb);
				//将临时数据list放进map里面
				map_arq.put(info.getReportdesc(),secondList);
			}else{
				 //得到实体
			    AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
				map_arq.get(info.getReportdesc()).add(tb);
			}
		}
        dto.setMap_arq(map_arq);
		return dto;
	}
	
	/**
	 * 查询报表审批
	 * @throws BLException 
	 *
	 */
	public IGSMR03DTO reportExamineAction(IGSMR03DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将年报的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_REPORT);
		//将流程状态名放进cond中
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
		//查询需要我处理的年报
		List<AnnualReportVWInfo> first_list = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//将集合遍历组成以年报说明为键，每条流程为值的map集合
		Map<String,List<AnnualReportVW>> map_first = new LinkedHashMap<String, List<AnnualReportVW>>();
		//遍历查询结果的集合
		for(AnnualReportVWInfo info:first_list){
			AnnualReportVW ar = (AnnualReportVW)SerializationUtils.clone(info);
			//判断最外层map里面是否存在某一个首层名称
			if(map_first.get(info.getReportdesc())==null){
			    //定义一个临时list集合
			    List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
			    IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
			    cond599.setPrid(info.getPrid());
			    cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
			    List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
			    if(ig599!=null&&ig599.size()!=0){			    	
			    	//判断是否报送空表设置标识
			    	if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
			    		ar.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
			    	}
			    }
				//将循环到的实体放进临时集合里面
				secondList.add(ar);
				//将临时数据list放进map里面
				map_first.put(info.getReportdesc(),secondList);
			}else{
				IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
				cond599.setPrid(info.getPrid());
				cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
				List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
				if(ig599!=null&&ig599.size()!=0){					 
					//判断是否报送空表设置标识
					if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
						ar.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
					}
				}
				map_first.get(info.getReportdesc()).add(ar);
			}
		}
		dto.setMap_first(map_first);
		return dto;
	}
	
	/**
	 * 查询年报审批
	 *
	 */
	public IGSMR03DTO AnnualreportExamineAction(IGSMR03DTO dto) {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将年报的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_REPORT);
		//将流程状态名放进cond中
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_SECONDEXAMINE);
		//将将实例状态放进cond中
		cond.setStatus_eq("1");
		//设定排序方式为倒序
		cond.setOrderby("desc");
		//查询需要我处理的年报
		List<RegulatoryReportInstanceInfo> second_list = regulatoryReportInstanceBL.findSectionAnnualReportByCond(cond,0,0);
        dto.setSecond_list(second_list);
		return dto;
	}
	/**
	 * 填报查看
	 * @throws BLException 
	 *
	 */
	public IGSMR03DTO seeFillInAction(IGSMR03DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//如果form中年份不为空，则将年份放进cond中
		if(StringUtils.isNotEmpty(dto.getIgSMR0302Form().getYear())){
			cond.setKey_eq(dto.getIgSMR0302Form().getYear());
		}
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_REPORT);
		List<AnnualReportVWInfo> list_rri = regulatoryReportInstanceBL.lookatFillIn(cond);
		//将集合遍历组成以年报说明为键，每条流程为值的map集合
		Map<String,List<AnnualReportVW>> map_see = new LinkedHashMap<String, List<AnnualReportVW>>();
		//遍历查询结果的集合
		for(AnnualReportVWInfo info:list_rri){
			//判断最外层map里面是否存在某一个首层名称
			if(map_see.get(info.getReportdesc() + "###" + info.getInittime())==null){
			    //定义一个临时list集合
			    List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
			    //得到实体
			    AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
				//将循环到的实体放进临时集合里面
				IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
				 cond599.setPrid(info.getPrid());
				 cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
				 List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
				 if(ig599!=null&&ig599.size()!=0){					 
					 //判断是否报送空表设置标识
					 if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
						 tb.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
					 }
				 }
				secondList.add(tb);
				//将临时数据list放进map里面
				map_see.put(info.getReportdesc() + "###" + info.getInittime(),secondList);
			}else{
				//得到实体
			    AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
				IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
				 cond599.setPrid(info.getPrid());
				 cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
				 List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
				 if(ig599!=null&&ig599.size()!=0){					 
					 //判断是否报送空表设置标识
					 if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
						 tb.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
					 }
				 }				
				map_see.get(info.getReportdesc() + "###" + info.getInittime()).add(tb);
			}
		}		
		dto.setMap_see(map_see);	
		
		return dto;
	}
	/**
	 * 填报中止
	 * @throws BLException 
	 *
	 */
	public IGSMR03DTO stopFillInAction(IGSMR03DTO dto) throws BLException {
		//form取得
		IGSMR0302Form form = dto.getIgSMR0302Form();
		//将form中的实例主键取出
		Integer instanceID = form.getInstanceID();
		//将该条实例对应的状态变为中止
		RegulatoryReportInstanceInfo rri = regulatoryReportInstanceBL.searchRegulatoryReportInstanceInfoByPK(instanceID);
		RegulatoryReportInstanceTB tb = (RegulatoryReportInstanceTB)SerializationUtils.clone(rri);
		tb.setStatus("2");
		regulatoryReportInstanceBL.updateRegulatoryReportInstanceInfo(tb);		
		//实例化查询条件
		RegulatoryReportDetailSearchCondImpl cond = new RegulatoryReportDetailSearchCondImpl();
		cond.setInstanceID(instanceID);
		//根据实例主键查询所有流程的prid
		List<RegulatoryReportDetailInfo> list_rrd = regulatoryReportDetailBL.searchRegulatoryReportDetailInfo(cond);
		//遍历集合取出prid
		for(RegulatoryReportDetailInfo info:list_rrd){	
			//根据主键查询发起人角色id
			IG500Info ig = ig500BL.searchIG500InfoByKey(info.getPrid());
			//将对应的实例表中的状态和对应流程的状态全部变为中止
			WorkFlowLog log = new WorkFlowLog();
			//将执行人放进日志中
			log.setExecutorid(dto.getUser().getUserid());	
			log.setExecutorRoleid(ig.getPrroleid());
			log.setPrid(info.getPrid());
			log.setComment("中止");
			SuspendProcess sp = new SuspendProcess(log);			
			flowOptBL.suspendProcess(sp);			
		}
		return dto;
	}

	/**
	 * 催办
	 *
	 */
	public IGSMR03DTO pressAction(IGSMR03DTO dto) throws BLException {
		//得到form
		IGSMR0302Form form = dto.getIgSMR0302Form();
		//得到流程id
		String prids = form.getPrid();
		String[] prid =null;
		//定义处理人角色id
		Integer roleid = 0;
		//截取字符串将得到流程id集合
		if(prids!=null&&prids.length()>0){			
			prid = prids.split(",");
		}
		//根据角色类型和当前登录者的userid查询角色id
		UserRoleVWSearchCondImpl condrole = new UserRoleVWSearchCondImpl();
		//将角色类型插入到查询条件中
		condrole.setRoletype(IGSMRCONSTANT.ROLETYPE_REPORT);
		//将当前登录者的userid放进查询条件中
		condrole.setUserid(dto.getUser().getUserid());
		//查询取出处理角色的某一角色id
		List<UserRoleInfo> listrole = userRoleBL.searchUserRoleVW(condrole);
		//遍历结合取出某一角色id
		for(UserRoleInfo info:listrole){
			roleid = info.getRoleid();
			break;
		}
		//遍历流程id集合，记录流程日志并且给这些流程的当前处理人发送催办信息
		for(String p:prid){
			//根据流程主键查询流程信息
			IG500Info pr = ig500BL.searchIG500InfoByKey(Integer.parseInt(p));
			//添加流程日志表
			WorkFlowLog wfl = new WorkFlowLog();
			wfl.setPrid(Integer.parseInt(p));
			wfl.setExecutorid(dto.getUser().getUserid());	
			wfl.setExecutorRoleid(roleid);
			wfl.setAuthuserid("");
			wfl.setComment(form.getView());
			flowSetBL.setProcessLog(wfl, "催办", Constants.PROCESS_LOG_TYPE_PROCESSING);
			//给当前处理人发短信
	        //查询当前处理人
			//实例化查询条件
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(Integer.parseInt(p));
			cond.setPpstatus_q(pr.getPrstatus());
			List<IG337Info> list_pp = ig337BL.getIG337Infos(cond);
			//判断当前状态下是否有参与者，如果没有给当前处理的角色下所有人发送短信
			if(list_pp!=null&&list_pp.size()>0){
				//遍历集合发送短信
				for(IG337Info pp:list_pp){
					//判断当前是否有参与人如果有发送给当前处理人，如果没有发送给当前角色下的所有人
					if(StringUtils.isNotEmpty(pp.getPpuserid())){	
						sendMessageBL.sendSmsToUser(pp.getPpuserid(), form.getView());
					}else{
//						sendMessageBL.sendSmsToRoleformanager(pp.getPproleid(), form.getView());
					}
				}
			}
		}
		return dto;
	}
	/**
	 * 设置提醒时间
	 *
	 */
	public IGSMR03DTO setCautionTimeAction(IGSMR03DTO dto) throws BLException {
		//form取得
		IGSMR0303Form form = dto.getIgSMR0303Form();
		//实例化查询条件，查询是否有这一类型的报表配置信息
		RemindConfigureSearchCondImpl cond = new RemindConfigureSearchCondImpl();
		cond.setRctype(form.getRctype());
		cond.setRcyear(IGStringUtils.getCurrentYear());
		//查询是否有当前年的这个类型的报表配置
		List<RemindConfigureInfo> list_rc = remindConfigureBL.searchRemindConfigure(cond);
		//如果没有当前年的这个类型的报表设置，则重新插入该类型的报表设置，设定quarz
		if(list_rc==null||list_rc.size()<=0){
			//实例化实例
			RemindConfigureTB tb = new RemindConfigureTB();
			tb.setRcyear(IGStringUtils.getCurrentYear());
			tb.setRctype(form.getRctype());
			tb.setRcmonth(form.getRcmonth());
			tb.setRcday(form.getRcday());
			remindConfigureBL.registRemindConfigure(tb);
			//设定提醒月份
			String month ="";
			if("0".equals(form.getRcmonth().substring(0,1))){
				month = form.getRcmonth().substring(1,2);
			}else{
				month = form.getRcmonth();
			}
			//设定日期
			String day ="";
			if("0".equals(form.getRcday().substring(0,1))){
				day = form.getRcday().substring(1,2);
			}else{
				day =form.getRcday(); 
			}
			//设定触发时间
			String TRIGGER = "0 0 "+IGSMRCONSTANT.MOMENT+" "+day+" "+month+" ?";
			if("1".equals(form.getRctype())){				
				//设定年报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP,
							new IGSMR0301JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("2".equals(form.getRctype())){
				//设定一季度季报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP,
							new IGSMR0302JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("3".equals(form.getRctype())){
				//设定二季度季报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP,
							new IGSMR0303JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("4".equals(form.getRctype())){
				//设定三季度季报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP,
							new IGSMR0304JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("5".equals(form.getRctype())){
				//设定四季度季报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP,
							new IGSMR0305JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}

		}else{
			//遍历集合得到实例
			for(RemindConfigureInfo rc :list_rc){
				RemindConfigureTB rtb = (RemindConfigureTB)SerializationUtils.clone(rc);
				//将月份和日改变
				rtb.setRcmonth(form.getRcmonth());
				rtb.setRcday(form.getRcday());
				//改变时间
				remindConfigureBL.updateRemindConfigure(rtb);				
			}
			//设定提醒月份
			String month ="";
			if("0".equals(form.getRcmonth().substring(0,1))){
				month = form.getRcmonth().substring(1,2);
			}else{
				month = form.getRcmonth();
			}
			//设定日期
			String day ="";
			if("0".equals(form.getRcday().substring(0,1))){
				day = form.getRcday().substring(1,2);
			}else{
				day =form.getRcday(); 
			}
			//设定触发时间
			String TRIGGER = "0 0 "+IGSMRCONSTANT.MOMENT+" "+day+" "+month+" ?";
			if("1".equals(form.getRctype())){				
				//设定年报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP,
							new IGSMR0301JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("2".equals(form.getRctype())){
				//设定一季度季报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP,
							new IGSMR0302JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("3".equals(form.getRctype())){
				//设定二季度季报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP,
							new IGSMR0303JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("4".equals(form.getRctype())){
				//设定三季度季报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP,
							new IGSMR0304JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("5".equals(form.getRctype())){
				//设定四季度季报quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP,
							new IGSMR0305JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGSMR0301.I001") );
		return dto;
	}
	/**
	 * 清除提醒时间
	 *
	 */
	@SuppressWarnings("null")
	public IGSMR03DTO eliminateCautionTimeAction(IGSMR03DTO dto)
			throws BLException {
		//form取得
		IGSMR0303Form form = dto.getIgSMR0303Form();
		//实例化查询条件，查询是否有这一类型的报表配置信息
		RemindConfigureSearchCondImpl cond = new RemindConfigureSearchCondImpl();
		cond.setRctype(form.getRctype());
		cond.setRcyear(IGStringUtils.getCurrentYear());
		//查询是否有当前年的这个类型的报表配置
		List<RemindConfigureInfo> list_rc = remindConfigureBL.searchRemindConfigure(cond);
		//如果有则清除该条配置，并且移除该quarz提醒
		if(list_rc!=null||list_rc.size()>0){
			for(RemindConfigureInfo info :list_rc){
				remindConfigureBL.deleteRemindConfigure(info);
				if("1".equals(form.getRctype())){				
					//设定年报quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
									IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}else if("2".equals(form.getRctype())){
					//设定一季度季报quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
									IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}else if("3".equals(form.getRctype())){
					//设定二季度季报quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
									IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}else if("4".equals(form.getRctype())){
					//设定三季度季报quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
									IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}else if("5".equals(form.getRctype())){
					//设定四季度季报quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
									IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGSMR0301.I002") );
		return dto;
	}
	/**
	 * 提醒时间查询
	 *
	 */
	public IGSMR03DTO searchCautionTimeAction(IGSMR03DTO dto)
			throws BLException {
		//查询当前年的年报日期
		//实例化查询条件
		RemindConfigureSearchCondImpl cond_year = new RemindConfigureSearchCondImpl();
		//将当前年放进cond中
		cond_year.setRcyear(IGStringUtils.getCurrentYear());
		//将年类型放进cond中
		cond_year.setRctype("1");
		//查询年报日期
		List<RemindConfigureInfo> list_year =remindConfigureBL.searchRemindConfigure(cond_year);
		//循环将记录取出放进dto中
		for(RemindConfigureInfo rc:list_year){
			dto.setRc(rc);
			break;
		}
		//查询一季度季报提醒时间
		//实例化查询条件
		RemindConfigureSearchCondImpl cond_rc1 = new RemindConfigureSearchCondImpl();
		//将当前年放进cond中
		cond_rc1.setRcyear(IGStringUtils.getCurrentYear());
		//将年类型放进cond中
		cond_rc1.setRctype("2");
		//查询年报日期
		List<RemindConfigureInfo> list_rc1 =remindConfigureBL.searchRemindConfigure(cond_rc1);
		//循环将记录取出放进dto中
		for(RemindConfigureInfo rc1:list_rc1){
			dto.setRc1(rc1);
			break;
		}
		//查询二季度季报提醒时间
		//实例化查询条件
		RemindConfigureSearchCondImpl cond_rc2 = new RemindConfigureSearchCondImpl();
		//将当前年放进cond中
		cond_rc2.setRcyear(IGStringUtils.getCurrentYear());
		//将年类型放进cond中
		cond_rc2.setRctype("3");
		//查询年报日期
		List<RemindConfigureInfo> list_rc2 =remindConfigureBL.searchRemindConfigure(cond_rc2);
		//循环将记录取出放进dto中
		for(RemindConfigureInfo rc2:list_rc2){
			dto.setRc2(rc2);
			break;
		}
		//查询三季度季报提醒时间
		//实例化查询条件
		RemindConfigureSearchCondImpl cond_rc3 = new RemindConfigureSearchCondImpl();
		//将当前年放进cond中
		cond_rc3.setRcyear(IGStringUtils.getCurrentYear());
		//将年类型放进cond中
		cond_rc3.setRctype("4");
		//查询年报日期
		List<RemindConfigureInfo> list_rc3 =remindConfigureBL.searchRemindConfigure(cond_rc3);
		//循环将记录取出放进dto中
		for(RemindConfigureInfo rc3:list_rc3){
			dto.setRc3(rc3);
			break;
		}			
		//查询四季度季报提醒时间
		//实例化查询条件
		RemindConfigureSearchCondImpl cond_rc4 = new RemindConfigureSearchCondImpl();
		//将当前年放进cond中
		cond_rc4.setRcyear(IGStringUtils.getCurrentYear());
		//将年类型放进cond中
		cond_rc4.setRctype("5");
		//查询年报日期
		List<RemindConfigureInfo> list_rc4 =remindConfigureBL.searchRemindConfigure(cond_rc4);
		//循环将记录取出放进dto中
		for(RemindConfigureInfo rc4:list_rc4){
			dto.setRc4(rc4);
			break;
		}	
		return dto;
	}
	/**
	 * 中止提醒时间
	 *
	 */
	public IGSMR03DTO stopCautionTimeAction(IGSMR03DTO dto) throws BLException {
		//form取得
		IGSMR0303Form form = dto.getIgSMR0303Form();
		if("1".equals(form.getRctype())){				
			//设定年报quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}else if("2".equals(form.getRctype())){
			//设定一季度季报quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}else if("3".equals(form.getRctype())){
			//设定二季度季报quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}else if("4".equals(form.getRctype())){
			//设定三季度季报quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}else if("5".equals(form.getRctype())){
			//设定四季度季报quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}
		dto.addMessage(new ActionMessage( "IGSMR0301.I003") );
		return dto;
	}
	
	/**
	 * 点击首页跳转到报表的我的工作
	 *
	 */
	public IGSMR03DTO init0304Action(IGSMR03DTO dto) throws BLException {
		//查询当前处理人是我的所有报表流程
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//处理人是当前处理人
		cond.setUserid(dto.getUser().getUserid());
		List<AnnualReportVWInfo> list_arq = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//将集合遍历组成以年报说明为键，每条流程为值的map集合
		Map<String,List<AnnualReportVW>> map_more = new LinkedHashMap<String, List<AnnualReportVW>>();
		//遍历查询结果的集合
		for(AnnualReportVWInfo info:list_arq){
			AnnualReportVW ar = (AnnualReportVW)SerializationUtils.clone(info);
			//判断最外层map里面是否存在某一个首层名称
			if(map_more.get(info.getReportdesc())==null){
				//定义一个临时list集合
				List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
				 IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
				 cond599.setPrid(info.getPrid());
				 cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
				 List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
				 if(ig599!=null&&ig599.size()!=0){					 
					 //判断是否报送空表设置标识
					 if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
						 ar.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
					 }
				 }
				 
				 //将循环到的实体放进临时集合里面
				 secondList.add(ar);
				//将临时数据list放进map里面
				map_more.put(info.getReportdesc(),secondList);
			}else{
				IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
				 cond599.setPrid(info.getPrid());
				 cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
				 List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
				 if(ig599!=null&&ig599.size()!=0){					 
					 //判断是否报送空表设置标识
					 if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
						 ar.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
					 }
				 }
				map_more.get(info.getReportdesc()).add(ar);
			}
		}
		dto.setMap_more(map_more);
		return dto;
	}
	
	/**
	 * 通用查询 
	 *
	 */
	public IGSMR03DTO init0305Action(IGSMR03DTO dto) throws BLException {
		//form取得
		IGSMR0304Form form = dto.getIgsmr0304Form();
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setPrtype(form.getPrtype());
		cond.setPrtitle(form.getPrtitle());
		cond.setPropentime(form.getPrstarttime());
		cond.setProclosetime(form.getPrclosetime());
		//目标信息查询件数取得 
		int totalCount = this.regulatoryReportInstanceBL.findReportHistoryCount(cond);
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<ReportHistorySearchVWInfo> list_all = regulatoryReportInstanceBL.findReportHistory(cond, pDto.getFromCount(), pDto.getPageDispCount());
		//新建一个包含填报人和报表审批人的集合
		List<ReportHistorySearchVW> list_rhs = new ArrayList<ReportHistorySearchVW>();
		//遍历集合添加填报人和报表审批人
		for(ReportHistorySearchVWInfo info:list_all){
			ReportHistorySearchVW tb = (ReportHistorySearchVW)SerializationUtils.clone(info);
			//定义填报人
			String fillinusername ="";
			//定义填报人状态标识码
			String fillincode = "";
			//到状态表中查询状态码
			IG333SearchCondImpl cond333 = new IG333SearchCondImpl();
			cond333.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
			cond333.setPdid(info.getPrpdid());
			List<IG333Info> ig333 = ig333BL.searchIG333Info(cond333);
			for(IG333Info info3:ig333){
				fillincode = info3.getPsdcode();
			}
			//实例化参与者查询条件
			IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPpstatus_q(fillincode);
			cond337.setPrid(info.getPrid());
			List<IG337Info> list_337 = ig337BL.getIG337Infos(cond337);
			//遍历结合拼写填报人
			for(int i=0;i<list_337.size();i++){
				IG337Info info1 = list_337.get(i);
				if(i!=list_337.size()-1){
					fillinusername = fillinusername+info1.getPpusername()+",";
				}else{
					fillinusername =fillinusername +info1.getPpusername();
				}
			}
			tb.setFillinname(fillinusername);
			//定义报表审批人
			String examineusername = "";
			//定义报表填报状态标识码
			String examinecode = "";
			//到状态表中查询状态码
			IG333SearchCondImpl cond_3 = new IG333SearchCondImpl();
			cond_3.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
			cond_3.setPdid(info.getPrpdid());
			List<IG333Info> ig_3 = ig333BL.searchIG333Info(cond_3);
			for(IG333Info info3:ig_3){
				examinecode = info3.getPsdcode();
			}
			//实例化参与者查询条件
			IG337SearchCondImpl cond_ig337 = new IG337SearchCondImpl();
			cond_ig337.setPpstatus(examinecode);
			cond_ig337.setPrid(info.getPrid());
			List<IG337Info> list_ig337 = ig337BL.getIG337Infos(cond_ig337);			
			//遍历结合拼写报表审批人
			for(int i=0;i<list_ig337.size();i++){
				IG337Info info2 = list_ig337.get(i);
				if(i!=list_ig337.size()-1){
					examineusername = examineusername+info2.getPpusername()+",";
				}else{
					examineusername =examineusername +info2.getPpusername();
				}
			}
			tb.setReportapprovename(examineusername);
			list_rhs.add(tb);
		}
		
		pDto.setTotalCount(totalCount);
		dto.setList_rhs(list_rhs);
		return dto;
	}

}
