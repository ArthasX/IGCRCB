/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.bl.task.RemindConfigureBL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0701Form;
import com.deliverik.infogovernor.smr.form.IGSMR0703Form;
import com.deliverik.infogovernor.smr.form.IGSMR0704Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
 * 不定期填报业务逻辑实现
 *
 */
public class IGSMR07BLImpl extends BaseBLImpl implements IGSMR07BL {
	
	static Log log = LogFactory.getLog(IGSMR07BLImpl.class);
	
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
	
	
	/**流程设置BL*/
	protected FlowSetBL flowSetBL;
	
	/**发送短信BL*/
	protected SendMessageBL sendMessageBL;
	
	/**用户角色BL*/
	protected UserRoleBL userRoleBL;
	
	/**参与人BL*/
	protected IG337BL ig337BL;
	
	/**表单值BL*/
	protected IG599BL ig599BL;
	
	/**提醒报表配置BL*/
	protected RemindConfigureBL remindConfigureBL;
	
	/** 角色菜单BL */
	protected RoleActionBL roleActionBL;

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

	/**
	 * 流程BL设定
	 * 
	 * @param ig500bl 流程BL
	 */	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
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
	 * 获取发起角色ID
	 * 
	 * @return 发起角色ID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		//获取具有"不定期发起"菜单的角色ID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname(IGSMRCONSTANT.ACTION_NONSKED);
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
	private void initRegulatoryReportIntance(RegulatoryReportInstanceTB instance, Integer ptid, String test, IGSMR07DTO dto) throws BLException {
		//获取发起角色ID
		Integer roleid = getInitRoleid();
		//创建不定期报表填报实例
		RegulatoryReportInstanceInfo instanceInfo = 
				regulatoryReportInstanceBL.registRegulatoryReportInstanceInfo(instance);
		WorkFlowLog workFlowLog = new WorkFlowLog();
		workFlowLog.setExecutorid(instance.getUserid());//处理人ID
		workFlowLog.setExecutorRoleid(roleid);
		IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
		cond_IG380.setPtid(ptid);//不定期报表模版ID
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
		String pdids = dto.getIgSMR0701Form().getPdids();
		for(IG380Info info : lst_IG380Info) {
			if(pdids.indexOf(info.getPdid())==-1){
				continue;
			}
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

	public IGSMR07DTO insertSMR0701Action(IGSMR07DTO dto) throws BLException{
		log.debug("========不定期报表发起处理开始========");
		IGSMR0701Form form = dto.getIgSMR0701Form();
		User user = dto.getUser();
		RegulatoryReportInstanceTB instance = regulatoryReportInstanceBL.getRegulatoryReportInstanceTBInstance();
		instance.setPrtype(IGPRDCONSTANTS.PRTYPE_IRREGULAR);//组类型
		instance.setKey(form.getRemark());//组标识
		instance.setInittime(IGStringUtils.getCurrentDateTime());//填报发起时间
		instance.setLimittime(form.getLimittime());//填报限制时间
		instance.setStatus(IGSMRCONSTANT.REPORT_STATUS_BEGIN);//状态：开启
		instance.setUserid(user.getUserid());//发起人ID
		instance.setUsername(user.getUsername());//发起人姓名
		instance.setReportdesc(form.getRemark()+"_不定期报表");
		this.initRegulatoryReportIntance(instance, IGPRDCONSTANTS.PRTYPE_IRREGULAR_ID, form.getTest(),dto);
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "不定期报表发起") );
		log.debug("========不定期报表发起处理结束========");
		return dto;
	}
	/**
	 * 不定期报表发起页初始化
	 *
	 *2013-8-8下午04:46:05
	 *@throws BLException
	 */
	public IGSMR07DTO initSMR0701Action(IGSMR07DTO dto) throws BLException {
		log.debug("========不定期报表初始化开始========");
		
		IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
		cond_IG380.setPtid(IGPRDCONSTANTS.PRTYPE_IRREGULAR_ID);//不定期报表模版ID
		if("1".equals(dto.getIgSMR0701Form().getTest())) {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_TESTABLE);//测试状态
		} else {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//发布状态
		}
		List<IG380Info> ig380List = ig380BL.searchIG380Info(cond_IG380);
		dto.setIg380List(ig380List);
		log.debug("========不定期报表初始化结束========");
		
		return dto;
		
	}
	/**
	 * 查询需要我处理的不定期报表
	 * @throws BLException 
	 *
	 */
	public IGSMR07DTO needMeManagerAction(IGSMR07DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将不定期报表的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRTYPE_IRREGULAR);
		//将流程状态名放进cond中
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
		//查询需要我处理的不定期报表
		List<AnnualReportVWInfo> list_arq = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//将集合遍历组成以不定期报表说明为键，每条流程为值的map集合
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
	public IGSMR07DTO reportExamineAction(IGSMR07DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将不定期报表的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRTYPE_IRREGULAR);
		//将流程状态名放进cond中
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
		//查询需要我处理的不定期报表
		List<AnnualReportVWInfo> first_list = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//将集合遍历组成以不定期报表说明为键，每条流程为值的map集合
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
	 * 查询不定期报表审批
	 *
	 */
	public IGSMR07DTO AnnualreportExamineAction(IGSMR07DTO dto) {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//将当前登录者的userid放进cond中
		cond.setUserid(dto.getUser().getUserid());
		//将不定期报表的流程类型放进cond中
		cond.setPrtype(IGSMRCONSTANT.PRTYPE_IRREGULAR);
		//将流程状态名放进cond中
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_IRREGULAREXAMINE);
		//将将实例状态放进cond中
		cond.setStatus_eq("1");
		//设定排序方式为倒序
		cond.setOrderby("desc");
		//查询需要我处理的不定期报表
		List<RegulatoryReportInstanceInfo> second_list = regulatoryReportInstanceBL.findSectionAnnualReportByCond(cond,0,0);
        dto.setSecond_list(second_list);
		return dto;
	}
	/**
	 * 填报查看
	 * @throws BLException 
	 *
	 */
	public IGSMR07DTO seeFillInAction(IGSMR07DTO dto) throws BLException {
		IGSMR0703Form form = dto.getIGSMR0703Form();
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setPropentime(form.getPropentime());
		cond.setProclosetime(form.getProclosetime());
		cond.setPrtype(IGPRDCONSTANTS.PRTYPE_IRREGULAR);
		List<AnnualReportVWInfo> list_rri = regulatoryReportInstanceBL.lookatFillIn(cond);
		//将集合遍历组成以不定期报表说明为键，每条流程为值的map集合
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
	 * 不定期报表明细列表查询处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR07DTO initIGSMR0704Action(IGSMR07DTO dto) throws BLException {
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
			//实例化参与者查询条件
			IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPpstatus_q("Y");
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
			//实例化参与者查询条件
			IG337SearchCondImpl cond_ig337 = new IG337SearchCondImpl();
			cond_ig337.setPpstatus("X");
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
	 * 不定期报表审批处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR07DTO managerIGSMR0704Action(IGSMR07DTO dto) throws BLException {
		//form取得
		IGSMR0704Form form = dto.getIgSMR0704Form();
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
