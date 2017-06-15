/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.scheduling.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG113BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BLType;
import com.deliverik.infogovernor.mtp.bl.task.QuartzJobDetailsBL;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCondImpl;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessInfoBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessParticipantBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessRecordBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH05DTO;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCondImpl;

/**
 * <p>
 * 概述：运维计划定时发起
 * </p>
 * <p>
 * 功能: 运维计划自定义流程发起
 * </p>
 * <p>
 * 创建: 杨盛楠	2010-12-9
 * </p>
 */
public class IGSCH05BLImpl extends BaseBLImpl implements IGSCH05BL {
	
	static Log log = LogFactory.getLog(IGSCH05BLImpl.class);
	
	/** 角色处理BL */
	protected RoleBL roleBL;
	
	/** 用户角色处理BL */
	protected UserRoleBL userRoleBL;
	
	/** 发送短信处理BL */
	protected SendMessageBL sendMessageBL;
	
	/** 流程信息处理BL */
	protected IG500BL ig500BL;
	
	/** 流程表单定义处理BL */
	protected IG007BL ig007BL;
	
	/** 流程表单处理BL */
	protected IG599BL ig599BL;
	
	/** 流程参与人员处理BL */
	protected IG337BL ig337BL;
	
	/** 流程模板处理BL */
	protected IG259BL ig259BL;
	
	/** 流程类型处理BL */
	protected IG380BL ig380BL;

	/** 流程状态定义处理BL */
	protected IG333BL ig333BL;
	
	/** 流程日志处理BL */
	protected IG036BL ig036BL;
	
	/** 流程状态日志信息处理BL */
	protected IG113BL ig113BL;
	
	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** 日常运维计划处理BL */
	protected QuartzJobsBL quartzJobsBL;
	
	/** 日常运维计划信息处理BL */
	protected QuartzJobDetailsBL quartzJobDetailsBL;
	
	/** 定时任务流程表单处理BL */
	protected QuartzProcessInfoBL quartzProcessInfoBL;
	
	/** 定时任务流程信息处理BL */
	protected QuartzProcessRecordBL quartzProcessRecordBL;
	
	/** 定时任务流程参与人员处理BL */
	protected QuartzProcessParticipantBL quartzProcessParticipantBL;
	
	/**
	 * 流程状态日志信息处理BL设定
	 * @param ig113BL 流程状态日志信息处理BL
	 */
	public void setIg113BL(IG113BL ig113BL) {
		this.ig113BL = ig113BL;
	}

	/**
	 * 流程状态定义处理BL设定
	 * @param ig333BL 流程状态定义处理BL
	 */
	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}
	
	/**
	 * 用户角色处理BL设定
	 * @param userRoleBL 用户角色处理BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 日常运维计划信息处理BL设定
	 * @param quartzJobDetailsBL 日常运维计划信息处理BL
	 */
	public void setQuartzJobDetailsBL(QuartzJobDetailsBL quartzJobDetailsBL) {
		this.quartzJobDetailsBL = quartzJobDetailsBL;
	}
	
	/**
	 * 发送短信处理BL设定
	 * @param sendMessageBL 发送短信处理BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * 定时任务流程表单处理BL设定
	 * @param quartzProcessInfoBL 定时任务流程表单处理BL
	 */
	public void setQuartzProcessInfoBL(QuartzProcessInfoBL quartzProcessInfoBL) {
		this.quartzProcessInfoBL = quartzProcessInfoBL;
	}

	/**
	 * 流程表单处理BL设定
	 * @param ig599BL 流程表单处理BL
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	/**
	 * 日常运维计划处理BL设定
	 * @param quartzJobsBL 日常运维计划处理BL
	 */
	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}

	/**
	 * 流程模板处理BL设定
	 * @param ig259BL 流程模板处理BL
	 */
	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	/**
	 * 流程类型处理BL设定
	 * @param ig380BL 流程类型处理BL
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	/**
	 * 流程表单定义处理BL设定
	 * @param ig007BL 流程表单定义处理BL
	 */
	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	/**
	 * 流程日志处理BL设定
	 * @param ig036BL 流程日志处理BL
	 */
	public void setIg036BL(IG036BL ig036BL) {
		this.ig036BL = ig036BL;
	}

	/**
	 * 定时任务流程信息处理BL设定
	 * @param quartzProcessRecordBL 定时任务流程信息处理BL
	 */
	public void setQuartzProcessRecordBL(QuartzProcessRecordBL quartzProcessRecordBL) {
		this.quartzProcessRecordBL = quartzProcessRecordBL;
	}

	/**
	 * 定时任务流程参与人员处理BL设定
	 * @param workFlowOperationBL 定时任务流程参与人员处理BL
	 */
	public void setQuartzProcessParticipantBL(
			QuartzProcessParticipantBL quartzProcessParticipantBL) {
		this.quartzProcessParticipantBL = quartzProcessParticipantBL;
	}
	
	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * 角色处理BL设定
	 * @param roleBL 角色处理BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 流程信息处理BL设定
	 * @param ig500BL 流程信息处理BL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * 流程参与人员处理BL设定
	 * @param ig337BL 流程参与人员处理BL
	 */
	public void setIg337BL(IG337BL ig337BL) {
		this.ig337BL = ig337BL;
	}


	/**
	 * <p>
	 * 功能: 运维计划定时任务发起
	 * </p>
	 * <p>
	 * 参数: IGSCH05DTO
	 * </p>
	 */
	public void init(IGSCH05DTO dto) throws BLException {
		
		//查询任务详细信息
		QuartzJobDetailsSearchCondImpl cond1 = new QuartzJobDetailsSearchCondImpl();
		cond1.setQjdtriname(dto.getTriggerName());
		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond1,0,0);
		if(qjdList == null || qjdList.size() == 0){
			return;
		}

		QuartzJobs qj = quartzJobsBL.searchQuartzJobsByKey(qjdList.get(0).getQjid());
		if(qj == null){
			return;
		}
		QuartzJobs quartzJobs = qj;
		String qjtype = quartzJobs.getQjtype();
		if("S".equals(qjtype)){ //短信
			String qjinfo = quartzJobs.getQjinfo();
			String userid = quartzJobs.getQjimpluser();
			sendMessageBL.sendSmsToUser(userid, qjinfo);
		} else if("W".equals(qjtype)){	//工作
			String qjinfo = quartzJobs.getQjinfo();
			Integer qprid = Integer.valueOf(qjinfo);
			// quartz流程信息取出
			QuartzProcessRecord quartzProcessRecord = quartzProcessRecordBL.findByPK(qprid);
			IG500TB prTB = this.copyProcessRecord(quartzProcessRecord);
			// 保存流程信息
			IG500Info processRecord = ig500BL.registIG500Info(prTB);
			Integer prid = processRecord.getPrid();
			
			// 发起人信息
			UserTB userTB = new UserTB();
			userTB.setUserid(processRecord.getPruserid());
			userTB.setUsername(processRecord.getPrusername());
			userTB.setOrgid(processRecord.getProrgid());
			userTB.setOrgname(processRecord.getProrgname());
			
			// 添加日志
			addRecordLog(prid, userTB, prTB.getPrroleid(), processRecord.getPrdesc(), IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE, null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
			
			// 查询quartz流程参与人信息
			QuartzProcessParticipantSearchCondImpl pqqCond = new QuartzProcessParticipantSearchCondImpl();
			pqqCond.setQprid(qprid);
			List<QuartzProcessParticipant> qppList = quartzProcessParticipantBL.searchProcessParticipant(pqqCond, 0, 0);
			for (QuartzProcessParticipant quartzProcessParticipant : qppList) {
				IG337TB ppTB = this.copyProcessParticipant(quartzProcessParticipant);
				ppTB.setPrid(prid);
				// 添加人员
				addProcessParticipant(ppTB,userTB,ppTB.getPproleid(),"",IGPRDCONSTANTS.COMMENT_OPENER_MESSAGE,null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
			}
			
			// 填写提交日志
			IG036Info rl = this.addRecordLog(prid, userTB, processRecord.getPrroleid(), processRecord.getPrdesc(), IGPRDCONSTANTS.RLDESC_DATA, null,IGPRDCONSTANTS.RECORDLOG_TYPE_TJ);

			// 提取表单信息
			List<IG599Info> prInfoList = new ArrayList<IG599Info>();
			QuartzProcessInfoSearchCondImpl qpiCond = new QuartzProcessInfoSearchCondImpl();
			qpiCond.setQprid(qprid);
			List<QuartzProcessInfo> qpiList = quartzProcessInfoBL.searchQuartzProcessInfos(qpiCond, 0, 0);
			for(QuartzProcessInfo qpi : qpiList){
				IG599Info pi = this.copyQuartzProcessInfo(qpi, prid);
				prInfoList.add(pi);
			}
			// 添加表单
			List<IG599Info> piList = ig599BL.saveOrUpdIG599Infos(prInfoList);
			
			// 增加表单日志
			addRecordLogVarInfo(piList,rl);
			
			// 下一节点id
			String psdid = this.ig333BL.getIG333InfoIdByStatus(processRecord.getPrpdid(), IGPRDCONSTANTS.PROCESS_START_STATUS);
			
			// 匹配跃迁 
			workFlowOperationBL.checkAndTransition(userTB,psdid,processRecord.getPrroleid(),IGPRDCONSTANTS.BUTTON_SUBMIT,prid,piList);
		}
		
		//设置运维计划任务状态为已执行
		QuartzJobDetailsTB qjdtb = (QuartzJobDetailsTB)SerializationUtils.clone(qjdList.get(0));
		qjdtb.setQjdtype(IGMTP01BLType.JOB_TYPE_EXECUTION);
		quartzJobDetailsBL.updateQuartzJobDetails(qjdtb);
		
	}
	
	/**
	 * 增加表单日志信息
	 * 
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @param IG036Info	   流程日志
	 * @return 表单日志是否保存成功
	 */
	public boolean addRecordLogVarInfo(List<IG599Info> prInfoList,IG036Info rl) throws BLException{
		
		boolean flag = true;//表单变量是否存在
		//判断表单变量是否存在
		if(prInfoList != null && !prInfoList.isEmpty()){
			Integer prid = rl.getPrid();
			for(IG599Info pi : prInfoList){
				String varvalue = pi.getPivarvalue();//对象类变量名称
				
				if(pi.getPivartype().equals("4")){  //资产
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_asset_")){
						varvalue = varvalue.split("_asset_")[1];
					}
				} else if(pi.getPivartype().equals("5")){  //流程
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_svc_")){
						varvalue = varvalue.split("_svc_")[1].split("_name=")[1];
					}
				} else if(pi.getPivartype().equals("6")){  //项目
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_prj_")){
						varvalue = varvalue.split("_prj_")[1];
					}
				} else if(pi.getPivartype().equals("R")){  //角色
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_role_")){
						varvalue = varvalue.split("_role_")[1];
					}
				}
				
				IG113TB rlvtb = new IG113TB();
				rlvtb.setPiattkey(pi.getPiattkey());
				rlvtb.setPidid(pi.getPidid());
				rlvtb.setPiid(pi.getPiid());
				rlvtb.setPivarlabel(pi.getPivarlabel());
				rlvtb.setPivarname(pi.getPivarname());
				rlvtb.setPivartype(pi.getPivartype());
				rlvtb.setPivarvalue(pi.getPivarvalue());
				rlvtb.setPrid(prid);
				rlvtb.setRlid(rl.getRlid());
				//如果为对象类型变量且有值时则保存显示名称
				if(StringUtils.isNotEmpty(varvalue) && StringUtils.isNotEmpty(pi.getPivarvalue())){
					rlvtb.setPishowvarname(varvalue);
				}else{
					rlvtb.setPishowvarname("");
				}
				this.ig113BL.registIG113Info(rlvtb);
			}
		}else{
			flag = false;
		}

		return flag;
	}

	/**
	 * <p>
	 * 流程参与者增加
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */

	public IG337Info addProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,String type) throws BLException {
		processParticipant = ig337BL.registIG337Info(processParticipant);
		addRecordLog(processParticipant.getPrid(), user, roleid, comment, desc, null, type);
		return processParticipant;
	}

	/**
	 * <p>
	 * 日志增加,roleid为null则不记录操作角色名称
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param type 日志类型 0系统日志，1批准，2驳回，3提交，4中止，5更新
	 * @return 参与者信息
	 * @return 日志
	 * @throws BLException
	 *
	 */

	public IG036Info addRecordLog(Integer prid, User user, Integer roleid, String comment, String desc, String attkey,String type) throws BLException {
		IG036TB recordLog = new IG036TB();
		recordLog.setPrid(prid);
		recordLog.setRluserid(user.getUserid());
		recordLog.setRlusername(user.getUsername());
		recordLog.setRldesc(desc);
		recordLog.setRlcomment(comment);
		recordLog.setRltime(IGStringUtils.getCurrentDateTime());
		recordLog.setRltype(type);
		if(roleid != null && roleid > 0) {
			recordLog.setRoleid(roleid);
			Role role = roleBL.searchRoleByKey(roleid);
			recordLog.setRlrolename(role.getRolename());
		} else {
			recordLog.setRlrolename(WorkFlowConstDefine.UnspecifiedRoleName);
		}
		recordLog.setRlorgid(user.getOrgid());
		recordLog.setRlorgname(user.getOrgname());
		recordLog.setRlattkey(attkey);
		
		//查询流程
		IG500Info processRecord = ig500BL.searchIG500InfoByKey(prid);
		
		//设置流程状态
		recordLog.setPsdcode(processRecord.getPrstatus());
		
		//查询流程状态名称
		IG333SearchCondImpl pscond = new IG333SearchCondImpl();
		pscond.setPdid(processRecord.getPrpdid());
		pscond.setPsdcode(processRecord.getPrstatus());
		List<IG333Info> psList = ig333BL.searchIG333Info(pscond);
		if(psList!=null && psList.size()>0){
			recordLog.setPsname(psList.get(0).getPsdname());
		}
		
		//判断是否角色负责人
		if(userRoleBL.checkRoleManagerByID(user.getUserid(),roleid)){
			//是角色负责人
			recordLog.setRolemanger(IGPRDCONSTANTS.ROLEMANAGER);
		}else{
			recordLog.setRolemanger(IGPRDCONSTANTS.NOT_ROLEMANAGER);
		}
		
		//非决角色负责人时，需判断是否是被授予提交权限的值班人
		if(IGPRDCONSTANTS.NOT_ROLEMANAGER.equals(recordLog.getRolemanger())) {
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(prid);
			cond.setPpsubstatus(IGPRDCONSTANTS.DUTYPERSON_ACCESS);//授权标识
			cond.setPproleid(roleid);
			cond.setPpuserid(user.getUserid());
			List<IG337Info> ppList = ig337BL.getIG337Infos(cond);
			for(IG337Info pp : ppList){
				//是否值班人
				if(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
					//假定为角色负责人标识
					recordLog.setRolemanger(IGPRDCONSTANTS.ROLEMANAGER);
				}
			}
		}
		
		return ig036BL.registIG036Info(recordLog);
	}
	protected IG599TB copyQuartzProcessInfo(QuartzProcessInfo qpi, int prid){
		IG599TB piTB = new IG599TB();
		piTB.setPivarlabel(qpi.getQpivarlabel());
		piTB.setPiattkey(qpi.getQpiattkey());
		piTB.setPivarname(qpi.getQpivarname());
		piTB.setPivartype(qpi.getQpivartype());
		piTB.setPivarvalue(qpi.getQpivarvalue());
		piTB.setPidid(qpi.getQpidid());
		piTB.setPrid(prid);
		return piTB;
	}
	
	protected IG731TB copyQuartzProcessInfoEntity(QuartzProcessInfoEntity qpie){
		IG731TB pieTB = new IG731TB();
		pieTB.setPrid(qpie.getQprid());
		pieTB.setPiid(qpie.getQpiid());
		pieTB.setEiid(qpie.getQeiid());
		return pieTB;
	}
	
	protected IG500TB copyProcessRecord(QuartzProcessRecord qpr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String today = sdf.format(System.currentTimeMillis());
		IG500TB prTB = new IG500TB();
		prTB.setPrassetid(qpr.getQprassetid());
		prTB.setPrassetname(qpr.getQprassetname());
		prTB.setPrbackplan(qpr.getQprbackplan());
		prTB.setPrbusiness(qpr.getQprbusiness());
		prTB.setPrclosetime(qpr.getQprclosetime());
		prTB.setPrdesc(qpr.getQprdesc());
		if(StringUtils.isNotEmpty(qpr.getQprduration())){
			prTB.setPrduration(sdf.format(System.currentTimeMillis() + 86400000 * Integer.valueOf(qpr.getQprduration().trim())));
		}else{
			prTB.setPrduration("");
		}
		
		prTB.setPrimpact(qpr.getQprimpact());
		prTB.setPrimplplan(qpr.getQprimplplan());
		prTB.setPropentime(today);
		prTB.setPrplantime(today);
		prTB.setPrstatus(qpr.getQprstatus());
		prTB.setPrsubstatus(qpr.getQprsubstatus());
		prTB.setPrtitle(qpr.getQprtitle());
		prTB.setPrtype(qpr.getQprtype());
		prTB.setPrurgency(qpr.getQprurgency());
		prTB.setPrvfyplan(qpr.getQprvfyplan());
		prTB.setPrinfo(qpr.getQprinfo());
		prTB.setPid(qpr.getQpid());
		prTB.setPcode(qpr.getQpcode());
		prTB.setPname(qpr.getQpname());
		prTB.setPrsubtype(qpr.getQprsubtype());
		prTB.setPrcortype(qpr.getQprcortype());
		prTB.setPrcorid(qpr.getQprcorid());
		prTB.setPrcortitle(qpr.getQprcortitle());
		prTB.setPrassetcategory(qpr.getQprassetcategory());
		prTB.setPrusername(qpr.getQprusername());
		prTB.setPrrolename(qpr.getQprrolename());
		prTB.setPruserid(qpr.getQpruserid());
		prTB.setPrroleid(qpr.getQprroleid());
		prTB.setPrpdid(qpr.getQprpdid());
		prTB.setPrpdname(qpr.getQprpdname());
		prTB.setProrgid(qpr.getQprorgid());
		prTB.setProrgname(qpr.getQprorgname());
		return prTB;
	}
	
	protected IG337TB copyProcessParticipant(QuartzProcessParticipant qpp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String today = sdf.format(System.currentTimeMillis());
		IG337TB ppTB = new IG337TB();
		ppTB.setPpattkey(qpp.getQppattkey());
		ppTB.setPpcomment(qpp.getQppcomment());
		if(qpp.getQppinittime() != null){
			ppTB.setPpinittime(today);
		}else{
			ppTB.setPpinittime(qpp.getQppinittime());
		}
		ppTB.setPporgid(qpp.getQpporgid());
		if(qpp.getQppproctime() != null){
			ppTB.setPpproctime(today);
		}else{
			ppTB.setPpproctime(qpp.getQppproctime());
		}
		ppTB.setPproleid(qpp.getQpproleid());
		ppTB.setPprolename(qpp.getQpprolename());
		ppTB.setPpstatus(qpp.getQppstatus());
		ppTB.setPptype(qpp.getQpptype());
		ppTB.setPpuserid(qpp.getQppuserid());
		ppTB.setPpusername(qpp.getQppusername());
		ppTB.setPpuserinfo(qpp.getQppuserinfo());
		ppTB.setPrid(qpp.getQprid());
		ppTB.setPporgname(qpp.getQpporgname());
		return ppTB;
	}
	public String getPeriodInfo(String periodType, String CustomDate, 
			String exeHour, String exeMinute,String startDate){
		String period = null;
		if("week".equals(periodType)){
			period = "周" + this.getWeekOfDate(startDate,null) + " ";
		} else if ("month".equals(periodType)){
			period = "月" + Integer.valueOf(startDate.split("/")[2]) + "日  ";
		} else if ("once".equals(periodType)){
			period = startDate + " " + exeHour + ":" + exeMinute;
			return period;
		}
		return "每" + period + exeHour + ":" + exeMinute;
	}
	
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
	
}