/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.SuspendProcess;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0601Form;
import com.deliverik.infogovernor.smr.form.IGSMR0602Form;
import com.deliverik.infogovernor.smr.form.IGSMR0603Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCondImpl;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 概述:季报发起 
 * 功能描述：季报发起 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-07
 * 修改记录：
 */
public class IGSMR06BLImpl extends BaseBLImpl implements IGSMR06BL {
	
	static Log log = LogFactory.getLog(IGSMR06BLImpl.class);
	
	/** 报表填报实例表业务BL */
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;
	
	/** 报表填报明细表业务BL */
	protected RegulatoryReportDetailBL regulatoryReportDetailBL;
	
	/** 流程业务BL */
	protected FlowOptBL flowOptBL;
	
	/** 流程类型定义BL */
	protected IG380BL ig380BL;
	
	/** 角色BL */
	protected RoleBL roleBL;
	
	/** 流程BL */
	protected IG500BL ig500BL;
	
	/**参与人BL*/
	protected IG337BL ig337BL;
	
	/**用户角色BL*/
	protected UserRoleBL userRoleBL;
	
	/**发送短信BL*/
	protected SendMessageBL sendMessageBL;
	
	/**流程设置BL*/
	protected FlowSetBL flowSetBL;
	
	/** 流程处理BL */
	protected IG333BL ig333BL;
	
	/**表单值BL*/
	protected IG599BL ig599BL;
	
	/** 角色菜单BL */
	protected RoleActionBL roleActionBL;
	
	/**
	 * 报表填报实例表业务BL设定
	 * @param regulatoryReportInstanceBL
	 */
	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}

	/**
	 * 报表填报明细表业务BL
	 * @param regulatoryReportDetailBL
	 */
	public void setRegulatoryReportDetailBL(
			RegulatoryReportDetailBL regulatoryReportDetailBL) {
		this.regulatoryReportDetailBL = regulatoryReportDetailBL;
	}
	
	/**
	 * 流程业务BL设定
	 * @param flowOptBL 流程业务BL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	/**
	 * 流程类型定义BL设定
	 * 
	 * @param ig380bl 流程类型定义BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}
	
	/**
	 * 角色BL设定
	 * 
	 * @param roleBL 角色BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**codeDetail常量BL*/
	protected  CodeDetailBL codeDetailBL;
	/**
	 * 流程BL设定
	 * 
	 * @param ig500bl 流程BL
	 */	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
		
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}
	
	/**
	 * 角色菜单BL设定
	 * @param roleActionBL 角色菜单BL
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * 季报发起处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR06DTO insertSMR0601Action(IGSMR06DTO dto) throws BLException {
		log.debug("========季报发起处理开始========");
		IGSMR0601Form form = dto.getIgSMR0601Form();
		
		User user = dto.getUser();
		RegulatoryReportInstanceTB instance = regulatoryReportInstanceBL.getRegulatoryReportInstanceTBInstance();
		instance.setPrtype(IGPRDCONSTANTS.PRTYPE_SEASON);//组类型
		//根据cid查询季度名称
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("QUARTER_CODE").getCcid());
		cond.setCid(form.getQuarter());
		List<CodeDetail> searchCodeDetail = this.codeDetailBL.searchCodeDetail(cond, 0);
		instance.setKey(form.getYear()+"_"+searchCodeDetail.get(0).getCvalue());//组标识
		instance.setInittime(IGStringUtils.getCurrentDateTime());//填报发起时间
		instance.setLimittime(form.getLimittime());//填报限制时间
		instance.setRemark(form.getRemark());//备注
		instance.setStatus(IGSMRCONSTANT.REPORT_STATUS_BEGIN);//状态：开启
		instance.setUserid(user.getUserid());//发起人ID
		instance.setUsername(user.getUsername());//发起人姓名
		instance.setReportdesc(form.getYear()+"_"+searchCodeDetail.get(0).getCvalue()+"_季报");
		instance.setYear(form.getYear());//年
		instance.setQuarter(searchCodeDetail.get(0).getCid());//季度
		this.initRegulatoryReportIntance(instance, IGPRDCONSTANTS.PRTYPE_SEASON_ID, form.getTest());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "季报发起") );
		log.debug("========季报发起处理结束========");
		return dto;
	}
	/**
	 * 获取发起角色ID
	 * 
	 * @return 发起角色ID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		//获取具有"季报发起"菜单的角色ID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname(IGSMRCONSTANT.ACTION_QUARTER);
		List<RoleAction> lst_RoleAction = this.roleActionBL.searchRoleAction(cond);
		if(lst_RoleAction.isEmpty()) {
			throw new BLException("IGCO10000.E004", "填报发起角色");
		}
		return lst_RoleAction.get(0).getRoleid();
	}
	
	/**
	 * 创建填报实例，并且发起报表流程，保存填报明细数据
	 * @param instance 填报实例
	 * @param ptid 模版ID
	 * @param test 是否测试发起，是：1
	 * @throws BLException
	 */
	private void initRegulatoryReportIntance(RegulatoryReportInstanceTB instance, Integer ptid, String test) throws BLException {
		//获取发起角色ID
		Integer roleid = getInitRoleid();
		//创建年报填报实例
		RegulatoryReportInstanceInfo instanceInfo = 
				regulatoryReportInstanceBL.registRegulatoryReportInstanceInfo(instance);
		WorkFlowLog workFlowLog = new WorkFlowLog();
		workFlowLog.setExecutorid(instance.getUserid());//处理人ID
		workFlowLog.setExecutorRoleid(roleid);
		IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
		cond_IG380.setPtid(ptid);//年报模版ID
		if("1".equals(test)) {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_TESTABLE);//测试状态
		} else {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//发布状态
		}
		List<IG380Info> lst_IG380Info = ig380BL.searchIG380Info(cond_IG380);
		if(lst_IG380Info.isEmpty()) {
			throw new BLException("IGCO10000.E004", "报表");
		}
		Map<String, String> formvalue = new HashMap<String, String>();
//		formvalue.put("填报限制时间", instance.getLimittime());
		//formvalue.put("填报人", instance.getLimittime());
		//定义流程ID集合
		List<Integer> lst_Prid = new ArrayList<Integer>();
		for(IG380Info info : lst_IG380Info) {
			ProcessRecord process = new ProcessRecord(workFlowLog);
			process.setCrtuserid(instance.getUserid());//发起人ID
			process.setTitle(instanceInfo.getKey() + "（" + info.getPdname() + "）");//标题
			process.setDefid(info.getPdid());
			process.setRoleid(roleid);
			process.setFormvalue(formvalue);
			process.setDescription(instance.getRemark());//描述
			lst_Prid.add(flowOptBL.initProcessAction(process));
		}
		//保存填报明细表数据
		for(Integer prid : lst_Prid) {
			RegulatoryReportDetailTB detail = new RegulatoryReportDetailTB();
			detail.setPrid(prid);//流程ID
			detail.setInstanceID(instanceInfo.getInstanceID());//填报实例ID
			this.regulatoryReportDetailBL.registRegulatoryReportDetailInfo(detail);
		}
	}
	/**
	 * 季报填报查询
	 * @throws BLException 
	 *
	 */
	public IGSMR06DTO needMeManagerAction(IGSMR06DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将年报的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_QUARTER);
		//将流程状态名放进cond中
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
		//查询需要我处理的季报
		List<AnnualReportVWInfo> list_arq = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//将集合遍历组成以年报说明为键，每条流程为值的map集合
		Map<String,List<AnnualReportVW>> map_arq = new LinkedHashMap<String, List<AnnualReportVW>>();
		//遍历查询结果的集合
		for(AnnualReportVWInfo info:list_arq){
			AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
			//判断最外层map里面是否存在某一个首层名称
			if(map_arq.get(info.getReportdesc())==null){
				//定义一个临时list集合
				List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
				//将循环到的实体放进临时集合里面
				secondList.add(tb);
				//将临时数据list放进map里面
				map_arq.put(info.getReportdesc(),secondList);
			}else{
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
	public IGSMR06DTO reportExamineAction(IGSMR06DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将年报的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_QUARTER);
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
	 * 查询季报审批
	 *
	 */
	public IGSMR06DTO AnnualreportExamineAction(IGSMR06DTO dto) {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将年报的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_QUARTER);
		//将流程状态名放进cond中
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_SECONDE);
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
	 * 填报监督
	 *
	 */
	public IGSMR06DTO seeFillInAction(IGSMR06DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		CodeDetailSearchCondImpl condcd = new CodeDetailSearchCondImpl();
		condcd.setCcid(CodeDefine.getCodeDefine("QUARTER_CODE").getCcid());
		condcd.setCid(dto.getIgSMR0602Form().getQuarter());
		List<CodeDetail> searchCodeDetail = this.codeDetailBL.searchCodeDetail(condcd, 0);
		//如果form中年份不为空，则将季度放进cond中
		cond.setKey_eq(dto.getIgSMR0602Form().getYear()+"_"+searchCodeDetail.get(0).getCvalue());
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_QUARTER);
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
				//将循环到的实体放进临时集合里面
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
	 *
	 */
	public IGSMR06DTO stopFillInAction(IGSMR06DTO dto) throws BLException {
		//form取得
		IGSMR0602Form form = dto.getIgSMR0602Form();
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
	public IGSMR06DTO pressAction(IGSMR06DTO dto) throws BLException {
		//得到form
		IGSMR0602Form form = dto.getIgSMR0602Form();
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
					if(pp.getPpuserid()!=null||"".equals(pp.getPpuserid())){						
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
	 * 季报明细列表查询处理
	 *
	 * @param dto IGSMR06DTO
	 * @return IGSMR06DTO
	 */
	public IGSMR06DTO initIGSMR0604Action(IGSMR06DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setInstanceid(dto.getInstanceID());
		//查询出所有流程包括流程的填报完成时间和报表审批完成时间
		List<BatchExamineVWInfo> list_be = regulatoryReportInstanceBL.findBatchExanmie(cond);
		//新建一个包含填报人和报表审批人的集合
		List<BatchExamineVW> list_all = new ArrayList<BatchExamineVW>();
		//遍历集合根据流程id查询对应的填报人和报表审批人
		for(BatchExamineVWInfo bean:list_be){
			BatchExamineVW tb = (BatchExamineVW)SerializationUtils.clone(bean);
			//定义填报人
			String fillinusername ="";
			//定义填报人状态标识码
			String fillincode = "";
			//到状态表中查询状态码
			IG333SearchCondImpl cond333 = new IG333SearchCondImpl();
			cond333.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
			cond333.setPdid(bean.getPrpdid());
			List<IG333Info> ig333 = ig333BL.searchIG333Info(cond333);
			for(IG333Info info3:ig333){
				fillincode = info3.getPsdcode();
			}
			//实例化参与者查询条件
			IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPpstatus_q(fillincode);
			cond337.setPrid(bean.getPrid());
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

			//定义报表审批人
			String examineusername = "";
			//定义报表填报状态标识码
			String examinecode = "";
			//到状态表中查询状态码
			IG333SearchCondImpl cond_3 = new IG333SearchCondImpl();
			cond_3.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
			cond_3.setPdid(bean.getPrpdid());
			List<IG333Info> ig_3 = ig333BL.searchIG333Info(cond_3);
			for(IG333Info info3:ig_3){
				examinecode = info3.getPsdcode();
			}
			//实例化参与者查询条件
			IG337SearchCondImpl cond_ig337 = new IG337SearchCondImpl();
			cond_ig337.setPpstatus(examinecode);
			cond_ig337.setPrid(bean.getPrid());
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
			//将填报人放进实体中
			tb.setFillinusername(fillinusername);
			//将报表审批人放进实体中
			tb.setExanimeusername(examineusername);
			IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
		    cond599.setPrid(bean.getPrid());
		    cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
		    List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
		    if(ig599!=null&&ig599.size()!=0){		    	
		    	//判断是否报送空表设置标识
		    	if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
		    		tb.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
		    	}
		    }
			//将实体放进集合中
			list_all.add(tb);
		}
		dto.setLst_Report(list_all);
		return dto;
	}
	
	/**
	 * 季报审批处理
	 *
	 * @param dto IGSMR06DTO
	 * @return IGSMR06DTO
	 */
	public IGSMR06DTO managerIGSMR0604Action(IGSMR06DTO dto) throws BLException {
		//form取得
		IGSMR0603Form form = dto.getIgSMR0603Form();
		for(Integer prid:form.getPrids()){						
			//循环选择的流程，将流程进行驳回或审批通过处理
			if("1".equals(form.getType())){
				flowOptBL.transitionProcess(prid, dto.getUser().getUserid(), "审批通过", IGStringUtils.getCurrentDateTime());
			}
			if("2".equals(form.getType())){
				flowOptBL.transitionProcess(prid, dto.getUser().getUserid(), "驳回", IGStringUtils.getCurrentDateTime());
			}
		}
		return dto;
	}

}
