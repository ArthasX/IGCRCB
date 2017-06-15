package com.deliverik.infogovernor.risk.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.risk.bl.task.AuditCheckRelationBL;
import com.deliverik.infogovernor.risk.bl.task.CheckInfoEntityBL;
import com.deliverik.infogovernor.risk.bl.task.CheckInfoRiskBL;
import com.deliverik.infogovernor.risk.bl.task.CheckStrategyBL;
import com.deliverik.infogovernor.risk.bl.task.CheckWorkResultBL;
import com.deliverik.infogovernor.risk.bl.task.CheckworkInfoResultBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditDefBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0201Form;
import com.deliverik.infogovernor.risk.form.IGRIS0202Form;
import com.deliverik.infogovernor.risk.form.IGRIS0203Form;
import com.deliverik.infogovernor.risk.form.IGRIS0204Form;
import com.deliverik.infogovernor.risk.form.IGRIS0205Form;
import com.deliverik.infogovernor.risk.form.IGRIS0206Form;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoRiskSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.CheckStrategySearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckSearchCondImpl;
import com.deliverik.infogovernor.risk.model.entity.AuditCheckRelationTB;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoRiskTB;
import com.deliverik.infogovernor.risk.model.entity.CheckStrategyTB;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkResultTB;
import com.deliverik.infogovernor.risk.model.entity.CheckworkInfoResultTB;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;
import com.deliverik.infogovernor.risk.vo.IGRIS02022VO;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.scheduling.jobs.RiskCheckJob;

/**
 * 风险检查业务逻辑实现
 * 
 */
public class IGRIS02BLImpl extends BaseBLImpl implements IGRIS02BL {

	static Log log = LogFactory.getLog(IGRIS02BLImpl.class);

	/** 风险检查信息BL */
	protected RiskCheckBL riskCheckBL;

	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	/** 流程处理类API */
	protected FlowOptBL flowOptBL;

	/** 更新类API */
	protected FlowSetBL flowSetBL;

	protected FlowSearchBL flowSearchBL;

	/** 平台用户BL */
	protected UserBL userBL;

	/** 风险检查信息BL */
	protected RiskCheckResultBL riskCheckResultBL;

	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;

	protected RiskAuditDefBL riskAuditDefBL;

	protected AuditCheckRelationBL auditCheckRelationBL;

	protected UserRoleBL userRoleBL;

	/** 检查策略BL */
	protected CheckStrategyBL checkStrategyBL;

	/** 检查策略关联资产BL */
	protected CheckInfoEntityBL checkInfoEntityBL;

	/** 检查任务关联工作BL */
	protected CheckworkInfoResultBL checkworkInfoResultBL;

	/** 检查任务BL */
	protected CheckWorkResultBL checkWorkResultBL;

	/** 检查工作关联检查项BL */
	protected CheckInfoRiskBL checkInfoRiskBL;

	protected SOC0107BL soc0107BL;

	protected AttachmentBL attachmentBL;

	protected SysManageBL sysManageBL;

	/** 资产信息BL */
	protected SOC0118BL soc0118BL;

	protected RoleActionBL roleActionBL;

	/** 流程BL */
	protected IG380BL ig380BL;

	/**
	 * @param riskAuditDefBL
	 *            the riskAuditDefBL to set
	 */
	public void setRiskAuditDefBL(RiskAuditDefBL riskAuditDefBL) {
		this.riskAuditDefBL = riskAuditDefBL;
	}

	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * @param soc0107bl
	 *            the soc0107BL to set
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	/**
	 * @param roleActionBL
	 *            the roleActionBL to set
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * @param userBL
	 *            the userBL to set
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * @param auditCheckRelationBL
	 *            the auditCheckRelationBL to set
	 */
	public void setAuditCheckRelationBL(AuditCheckRelationBL auditCheckRelationBL) {
		this.auditCheckRelationBL = auditCheckRelationBL;
	}

	/**
	 * @param flowOptBL
	 *            the flowOptBL to set
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * @param flowSetBL
	 *            the flowSetBL to set
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * @param workFlowOperationBL
	 *            the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * @param workFlowDefinitionBL
	 *            the workFlowDefinitionBL to set
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * @param riskCheckBL
	 *            the riskCheckBL to set
	 */
	public void setRiskCheckBL(RiskCheckBL riskCheckBL) {
		this.riskCheckBL = riskCheckBL;
	}

	/**
	 * @param riskCheckResultBL
	 *            the riskCheckResultBL to set
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * 流程查询功能API设置
	 * 
	 * @param sysManageBL
	 *            流程查询功能API
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * @param checkStrategyBL
	 *            the checkStrategyBL to set
	 */
	public void setCheckStrategyBL(CheckStrategyBL checkStrategyBL) {
		this.checkStrategyBL = checkStrategyBL;
	}

	/**
	 * @param checkInfoEntityBL
	 *            the checkInfoEntityBL to set
	 */
	public void setCheckInfoEntityBL(CheckInfoEntityBL checkInfoEntityBL) {
		this.checkInfoEntityBL = checkInfoEntityBL;
	}

	/**
	 * @param checkworkInfoResultBL
	 *            the checkworkInfoResultBL to set
	 */
	public void setCheckworkInfoResultBL(CheckworkInfoResultBL checkworkInfoResultBL) {
		this.checkworkInfoResultBL = checkworkInfoResultBL;
	}

	/**
	 * @param checkWorkResultBL
	 *            the checkWorkResultBL to set
	 */
	public void setCheckWorkResultBL(CheckWorkResultBL checkWorkResultBL) {
		this.checkWorkResultBL = checkWorkResultBL;
	}

	/**
	 * @param checkInfoRiskBL
	 *            the checkInfoRiskBL to set
	 */
	public void setCheckInfoRiskBL(CheckInfoRiskBL checkInfoRiskBL) {
		this.checkInfoRiskBL = checkInfoRiskBL;
	}

	/**
	 * 资产信息BL设定
	 * 
	 * @param soc0118bl
	 *            资产信息BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * 流程BL设定
	 * 
	 * @param ig380bl
	 *            ig380BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * <p>
	 * Description: 设定quartz执行周期表达式
	 * </p>
	 */
	private String creatCronExp(String periodType, String exeHour, String exeMinute, String qjcrttime, String frequency) {
		String retCronExp = null;
		// 秒 分 时 日 月 周 年
		if ("week".equals(periodType)) {
			// String week = this.getWeekOfDate(qjcrttime, "eng");
			retCronExp = "0 " + exeMinute + " " + exeHour + " ? * " + frequency;
		} else if ("month".equals(periodType)) {
			// String day = qjcrttime.split("/")[2];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + frequency + " * ?";
		} else if ("once".equals(periodType)) {
			String day = qjcrttime.split("/")[2].split(" ")[0];
			String month = qjcrttime.split("/")[1];
			String year = qjcrttime.split("/")[0];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day + " " + month + " ? " + year;
		} else if ("day".equals(periodType)) {
			retCronExp = "0 " + exeMinute + " " + exeHour + " * * ?";
		} else if ("quarter".equals(periodType)) {
			String day = qjcrttime.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day1 + " " + month + "/3 ?";
		} else if ("1".equals(periodType)) {
			// 每月最后一天
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + "L" + " * ?";
		}
		// 頻率 年 20121023

		else if ("year".equals(periodType)) {
			String day = qjcrttime.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day1 + " " + month + " ?";
		}
		// 頻率半年20121023
		else if ("halfyear".equals(periodType)) {
			String day = qjcrttime.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day1 + " " + month + "," + ((Integer.parseInt(month) + 6) % 12) + " ?";
		}
		log.debug(retCronExp);
		return retCronExp;
	}

	/**
	 * <p>
	 * Description: 解释quartz执行周期表达式
	 * </p>
	 */
	public String getCronInfo(String periodType, String startDate) {
		String period = null;
		if ("week".equals(periodType)) {
			period = "周" + this.getWeekOfDate(startDate, null) + " ";
		} else if ("month".equals(periodType)) {
			period = "月" + Integer.valueOf(startDate.split("/")[2].trim()) + "日  ";
		} else if ("once".equals(periodType)) {
			period = startDate;
			return period;
		} else if ("day".equals(periodType)) {
			period = "日";
		} else if ("quarter".equals(periodType)) {
			period = "三个月" + Integer.valueOf(startDate.split("/")[2].trim()) + "日  ";
		} else if ("year".equals(periodType)) {
			period = "年" + startDate.split("/")[1].trim() + "月" + startDate.split("/")[2].trim().substring(0, 2) + "日";
		} else if ("halfyear".equals(periodType)) {
			period = "半年" + Integer.valueOf(startDate.split("/")[2].trim()) + "日  ";
		}
		return "每" + period;

	}

	/**
	 * <p>
	 * Description: 取得传入日期是星期几
	 * </p>
	 */
	private String getWeekOfDate(String strDate, String language) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		String[] engWeekDays = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(strDate));
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		if ("eng".equals(language)) {
			return engWeekDays[w];
		}
		return weekDays[w];
	}

	/**
	 * <p>
	 * Description: 修改风险检查job
	 * </p>
	 */
	@SuppressWarnings("unused")
	private void updateQuartzJobs(RiskCheck rc, String cronExpression, IGRIS0202Form form) throws BLException {
		String triggerName = "RiskCheckJobTrigger" + rc.getRcid();
		String triggerGroupName = "RiskCheckJobTriggerGroup" + rc.getRcid();
		String creatTime = form.getRcstartdate();
		String endTime = form.getRcenddate();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date beganDate = null;
		Date endDate = null;
		log.debug(cronExpression);

		try {
			beganDate = format.parse(creatTime);
			endDate = format.parse(endTime);
			JobManager.modifyJobTimeForRiskCheck(triggerName, triggerGroupName, cronExpression, beganDate, endDate);

		} catch (SchedulerException e) {
			log.error("==========Exception form personTimerJob===========");
			throw new BLException("", "SchedulerException");
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
	}

	/**
	 * <p>
	 * Description: 初始化今天应该进行的风险检查
	 * </p>
	 */
	public void initRiskCheckResult(IGRIS02DTO dto) throws BLException {

		CheckStrategyInfo info = checkStrategyBL.searchCheckStrategyByPK(dto.getCsid());

		// 发起检查任务
		CheckWorkResultTB resultTB = new CheckWorkResultTB();
		resultTB.setCwrid(100);

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		resultTB.setCwrname(info.getCsname() + format.format(new Date()));
		resultTB.setCsid(info.getCsid());
		resultTB.setCwrplandate(info.getCsstartdate());
		// 检查方式设定
		resultTB.setCwrtestmode(info.getCsrtestmode());
		resultTB.setCwruserid(info.getCsuserid());
		resultTB.setCwrrate("0");
		resultTB.setCwrusername(info.getCsusername());
		resultTB.setCwrassetid(info.getCsasset());
		resultTB.setCwrassetname(info.getCsassetname());
		CheckWorkResultInfo cwInfo = checkWorkResultBL.registCheckWorkResult(resultTB);
		// 检查任务完毕

		CheckInfoRiskSearchCondImpl cond = new CheckInfoRiskSearchCondImpl();
		cond.setCsid(info.getCsid());
		List<CheckInfoRiskInfo> criList = checkInfoRiskBL.searchCheckInfoRisk(cond);
		for (CheckInfoRiskInfo cri : criList) {
			// wangjiahui
			RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(cri.getRcid());
			SOC0118Info ci = this.soc0118BL.searchEntityItemByKey(rc.getRcasset());
			if (!"1".equals(ci.getEistatus())) {
				continue;
			}
			String nowdatetime = IGStringUtils.getCurrentDateTime();// 当期日期（年/月/日
																	// 时分）

			RiskCheckResultTB rcrTB = new RiskCheckResultTB();
			rcrTB.setRcruserid(cwInfo.getCwruserid());
			rcrTB.setRcrusername(cwInfo.getCwrusername());
			rcrTB.setRcid(rc.getRcid());
			rcrTB.setRcrplandate(nowdatetime);
			rcrTB.setRctype(rc.getRctype());// 风险检查重要程度
			rcrTB.setRcrnextdate(null);// 下次执行检查时间
			// 插入检查项说明
			rcrTB.setRccommon(rc.getRccommon());
			// 插入检查项名称
			rcrTB.setRcname(rc.getRcname());
			// 插入检查项描述
			rcrTB.setRcdesc(rc.getRcdesc());
			// 插入检查项类型
			rcrTB.setRcrclass(rc.getRcclass());
			RiskCheckResult rcrInfo = this.riskCheckResultBL.registRiskCheckResult(rcrTB);

			// 插入任务工作关联表
			CheckworkInfoResultTB checkWorkResultTB = new CheckworkInfoResultTB();
			checkWorkResultTB.setRcrid(rcrInfo.getRcrid());
			checkWorkResultTB.setCwrid(cwInfo.getCwrid());
			checkworkInfoResultBL.registCheckworkInfoResult(checkWorkResultTB);
		}
	}

	/**
	 * <p>
	 * Description: 风险检查新增
	 * </p>
	 */
	public IGRIS02DTO insertRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查新增处理开始========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		AttachmentTB attachment = new AttachmentTB();
		String attkey = IGStringUtils.getAttKey();// 附件id
		attachment.setAttkey(attkey);

		// 上传文件检测
		Map<Integer, FormFile> filemap = form.getFileMap();
		Iterator<Integer> iterator = filemap.keySet().iterator();
		while (iterator.hasNext()) {
			FormFile file = (FormFile) filemap.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();

				// 根目录
				pathBuf.append(rootPath);
				// 当前模块目录
				pathBuf.append("risk");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// 文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}

				// 上传文件名保存
				attachment.setAttname(attkey + "_" + fileName.toString());
				// 上传文件名URL
				attachment.setAtturl("risk");

				this.attachmentBL.registAttachment(attachment);

			}
		}
		// 检查频率
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// 频率为周
			for (String week : form.getRcfrequencyweek()) {
				if (StringUtils.isEmpty(frequency)) {
					frequency = week;
				} else {
					frequency = frequency + "," + week;
				}
			}
		} else if ("month".equals(form.getRcfrequency())) {
			if (form.getRcfrequencymonth() != null) {
				// 频率为月
				for (String month : form.getRcfrequencymonth()) {
					if (StringUtils.isEmpty(frequency)) {
						frequency = month;
					} else {
						frequency = frequency + "," + month;
					}
				}
			}
		}

		// 按 , 拆分字符串,得到一个数组
		String[] startdate = form.getRcstartdate().split("\\ ");
		String starttime = startdate[1];
		String[] begindate = starttime.split("\\:");
		// 时
		String exeHour = begindate[0];
		// 分
		String exeMinute = begindate[1];
		// 取得执行周期表达式
		String cronExpression = null;

		if (StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())) {// 频率为每月最后一天
			// 取得执行周期表达式,风险检查频率(每月最后一天)
			if ("1".equals(form.getRcfrequencymonthlastday())) {
				// 取得执行周期表达式
				cronExpression = this.creatCronExp(form.getRcfrequencymonthlastday(), exeHour, exeMinute, form.getRcstartdate(), null);
				frequency = "最后一";
			}
		} else {// 频率为周、月
			cronExpression = this.creatCronExp(form.getRcfrequency(), exeHour, exeMinute, form.getRcstartdate(), frequency);
		}
		form.setRcfrequencydesc(frequency);// 风险检查频率内容
		// 保存RiskCheck
		form.setRcstatus(IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE);// 设置状态为启用
		form.setRcattch(attkey);// 附件id
		form.setRccron(cronExpression);// 风险检查策略执行表达式

		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRccreatetime(date);// 风险检查登记时间yyyy/MM/dd HH:mm
		// 登录风险检查信息
		RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
		dto.setRiskCheck(rc);

		dto.addMessage(new ActionMessage("IGRIS0202.I001", "检查策略设定成功"));
		log.debug("========风险检查新增处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查变更初始化
	 * </p>
	 */
	public IGRIS02DTO initupdateRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查变更初始化处理开始========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		// 由主键查找检查项详细信息
		RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
		form.setRcasset(rc.getRcasset());// 风险检查相关资产ID
		form.setRcassetname(rc.getRcassetname());// 风险检查相关资产名称
		form.setRcattch(rc.getRcattch());// 风险检查附件ID
		form.setRccron(rc.getRccron());// 风险检查策略执行表达式
		form.setRcdesc(rc.getRcdesc());// 风险检查描述
		form.setRcenddate(rc.getRcenddate());// 风险检查结束时间
		form.setRcfrequency(rc.getRcfrequency());// 风险检查频率
		form.setRcid(rc.getRcid());// 风险检查ID
		form.setRcname(rc.getRcname());// 风险检查名称
		form.setRcrtestmode(rc.getRcrtestmode());// 风险检查方式
		form.setRcoption(rc.getRcoption());// 风险检查选项
		form.setRcroleid(rc.getRcroleid());// 风险检查责任组角色ID
		form.setRcrolename(rc.getRcrolename());// 风险检查责任组角色名
		form.setRcstartdate(rc.getRcstartdate());// 风险检查起始时间
		form.setRcstatus(rc.getRcstatus());// 风险检查状态
		form.setRctype(rc.getRctype());// 风险检查类型
		form.setRcuserid(rc.getRcuserid());// 风险检查责任人ID
		form.setRcusername(rc.getRcusername());// 风险检查责任人姓名
		form.setRccategory(rc.getRccategory());// 风险检查项类别
		form.setRccategoryname(rc.getRccategoryname());// 风险检查项类别名称
		form.setRccreatetime(rc.getRccreatetime());// 风险检查登记时间
		form.setRcfrequencymonthlastday(rc.getRcfrequencymonthlastday());// 风险检查频率(每月最后一天)
		form.setRcupdatetime(rc.getRcupdatetime());// 风险检查处理时间
		form.setRcclass(rc.getRcclass());
		form.setRccommon(rc.getRccommon());
		form.setCog(rc.getCog());
		form.setCogid(rc.getCogid());
		form.setCiiop(rc.getCiiop());
		form.setCiiopid(rc.getCiiopid());
		form.setWtip(rc.getWtip());
		String[] rcfrequency = null;
		// 按 , 拆分字符串,得到一个数组
		if (StringUtils.isNotEmpty(rc.getRcfrequencydesc())) {
			rcfrequency = rc.getRcfrequencydesc().split("\\,");
		}
		// 周集合
		List<IGRIS02022VO> weekList = new ArrayList<IGRIS02022VO>();
		// 每月天数集合
		List<IGRIS02022VO> monthList = new ArrayList<IGRIS02022VO>();
		// 周一到周日数据
		List<IGRIS02022VO> wList = new ArrayList<IGRIS02022VO>();
		IGRIS02022VO week1vo = new IGRIS02022VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("周一");
		wList.add(week1vo);
		IGRIS02022VO week2vo = new IGRIS02022VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("周二");
		wList.add(week2vo);
		IGRIS02022VO week3vo = new IGRIS02022VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("周三");
		wList.add(week3vo);
		IGRIS02022VO week4vo = new IGRIS02022VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("周四");
		wList.add(week4vo);
		IGRIS02022VO week5vo = new IGRIS02022VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("周五");
		wList.add(week5vo);
		IGRIS02022VO week6vo = new IGRIS02022VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("周六");
		wList.add(week6vo);
		IGRIS02022VO week7vo = new IGRIS02022VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("周日");
		wList.add(week7vo);
		// 判断频率类别
		if ("week".equals(rc.getRcfrequency())) {
			// 风险检查频率(周)
			form.setRcfrequencyweek(rcfrequency);
			for (IGRIS02022VO vo : wList) {
				// 判断是否已选择
				String ischecked = null;
				for (String st : rcfrequency) {
					if (vo.getWeekvalue().equals(st)) {
						ischecked = st;
					}
				}
				// 风险检查信息检索结果ＶＯ
				IGRIS02022VO weekvo = new IGRIS02022VO();
				weekvo.setWeekdata(vo.getWeekdata());// 周文字显示
				weekvo.setWeekvalue(vo.getWeekvalue());// 频率为周内容
				weekvo.setIschecked(ischecked);// 是否已选择标识
				weekList.add(weekvo);
			}
			dto.setWeekList(weekList);
		} else {
			dto.setWeekList(wList);
		}

		if ("month".equals(rc.getRcfrequency())) {
			// 风险检查频率(月)
			form.setRcfrequencymonth(rcfrequency);

		}
		for (int i = 1; i < 31; i++) {
			// 天
			String dayvalue = String.valueOf(i);
			// 判断是否已选择
			String ischecked = null;
			if ("month".equals(rc.getRcfrequency())) {
				if (rcfrequency != null) {
					for (String st : rcfrequency) {
						if (dayvalue.equals(st)) {
							ischecked = st;
						}
					}
				}
			}
			IGRIS02022VO mouthvo = new IGRIS02022VO();
			mouthvo.setDayvalue(dayvalue);// 频率为天内容
			mouthvo.setIschecked(ischecked);// 是否已选择标识
			monthList.add(mouthvo);
		}

		dto.setMonthList(monthList);

		// 查询附件信息
		if (StringUtils.isNotEmpty(rc.getRcattch())) {
			List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(rc.getRcattch());
			dto.setAttachmentList(attachmentList);
		}
		form.setMode("1");// 0为新增 1为变更
		dto.setRiskCheck(form);
		dto.addMessage(new ActionMessage("IGCO10000.I001", "风险检查基本信息"));
		log.debug("========风险检查变更初始化处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查变更
	 * </p>
	 */
	public IGRIS02DTO updateRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查变更处理开始========");
		CheckStrategyTB csTb = (CheckStrategyTB) checkStrategyBL.searchCheckStrategyByPK(dto.getIgRIS0202Form().getCsid());
		IGRIS0202Form form = dto.getIgRIS0202Form();
		// 删除附件
		if (StringUtils.isNotEmpty(form.getPredelkey())) {
			String[] keys = form.getPredelkey().split(",");
			for (String key : keys) {
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
			form.setRcattch("");
		}
		// 检查频率
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// 频率为周
			for (String week : form.getRcfrequencyweek()) {
				if (StringUtils.isEmpty(frequency)) {
					frequency = week;
				} else {
					frequency = frequency + "," + week;
				}
			}
			// 将风险检查频率(每月最后一天)清空
			form.setRcfrequencymonthlastday(null);
		} else if ("month".equals(form.getRcfrequency())) {
			// 频率为月
			if (form.getRcfrequencymonth() != null) {
				for (String month : form.getRcfrequencymonth()) {
					if (StringUtils.isEmpty(frequency)) {
						frequency = month;
					} else {
						frequency = frequency + "," + month;
					}
				}
			}
		}
		if (!"month".equals(form.getRcfrequency())) {
			// 将风险检查频率(每月最后一天)清空
			form.setRcfrequencymonthlastday(null);
		}

		// 按 , 拆分字符串,得到一个数组
		String[] startdate = form.getRcstartdate().split("\\ ");
		String starttime = startdate[1];
		String[] begindate = starttime.split("\\:");
		// 时
		String exeHour = begindate[0];
		// 分
		String exeMinute = begindate[1];

		// 取得执行周期表达式
		String cronExpression = null;
		if (StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())) {// 频率为每月最后一天
			// 取得执行周期表达式,风险检查频率(每月最后一天)
			if ("1".equals(form.getRcfrequencymonthlastday())) {
				// 取得执行周期表达式
				cronExpression = this.creatCronExp(form.getRcfrequencymonthlastday(), exeHour, exeMinute, form.getRcstartdate(), null);
				frequency = "最后一 ";
			}
		} else {// 频率为周、月
			cronExpression = this.creatCronExp(form.getRcfrequency(), exeHour, exeMinute, form.getRcstartdate(), frequency);
		}
		form.setRcfrequencydesc(frequency);// 风险检查频率内容
		form.setRccron(cronExpression);//

		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRcupdatetime(date);// 风险检查处理时间yyyy/MM/dd HH:mm

		form.setRccreatetime(date);// 风险检查登记时间yyyy/MM/dd HH:mm
		// 登录风险检查信息
		// RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
		// dto.setRiskCheck(rc);
		csTb = copyPropertie(csTb, form);

		// 更新检查策略
		CheckStrategyInfo info = this.checkStrategyBL.updateCheckStrategy(csTb);
		dto.setIgRIS0202Form(form);

		Integer csid = info.getCsid();
		CheckInfoRiskSearchCondImpl checkInfo = new CheckInfoRiskSearchCondImpl();
		checkInfo.setCsid(csid);
		List<CheckInfoRiskInfo> riskInfos = checkInfoRiskBL.searchCheckInfoRisk(checkInfo, 0, 0);
		for (CheckInfoRiskInfo checkInfoRiskInfo : riskInfos) {
			checkInfoRiskBL.deleteCheckInfoRisk(checkInfoRiskInfo);
		}
//		List<Integer> rcidList = new ArrayList<Integer>();
//		for (int i = 0; i < riskInfos.size(); i++) {
//			rcidList.add(riskInfos.get(i).getRcid());
//		}
//		Set<Integer> rcidSet = new HashSet<Integer>(rcidList);
//		Iterator<Integer> iterator = rcidSet.iterator();
//		// 删除相关的检查项
//		while (iterator.hasNext()) {
//			riskCheckBL.deleteRiskCheck(iterator.next());
//		}

		List<String> eiids = new ArrayList<String>();
		List<String> eiversions = new ArrayList<String>();
		String[] eiidStrs = dto.getIgRIS0202Form().getEiids().split(",");
		String[] eiversionStrs = dto.getIgRIS0202Form().getEiversions().split(",");

		for (int i = 0; eiidStrs != null && i < eiidStrs.length; i++) {
			eiids.add(eiidStrs[i]);
			if (eiversionStrs[i] == null || eiversionStrs[i].equals("") || eiversionStrs[i].equals("null")) {
				eiversionStrs[i] = "1";
			}
			eiversions.add(eiversionStrs[i]);
		}

		List<RiskCheck> checkList = new ArrayList<RiskCheck>();
		// 插入检查项，这里需要通过资产的eiid和eiversion来取出资产的属性
		for (int i = 0; eiids != null && i < eiids.size(); i++) {
			// 查询资产属性
			SOC0107SearchCondImpl soc0107cond = new SOC0107SearchCondImpl();
			IGRIS0202Form igris0202Form = dto.getIgRIS0202Form();
			soc0107cond.setEiid(eiids.get(i));
			soc0107cond.setCiversion(eiversions.get(i));
			List<SOC0107Info> soc0107InfoList = soc0107BL.searchSOC0107(soc0107cond, 0, 0);
			for (int j = 0; j < soc0107InfoList.size(); j++) {
				SOC0107Info socInfo = soc0107InfoList.get(j);
				if (socInfo.getCid().equals("CI210000000001")) {
					// 设置检查项名称
					igris0202Form.setRcname(socInfo.getCivalue());
					igris0202Form.setRcassetname(socInfo.getCivalue());
					igris0202Form.setRcassetversion(socInfo.getCiversion());
				} else if (socInfo.getCid().equals("CI210000000002")) {
					// 设置检查项说明
					igris0202Form.setRcdesc(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000003")) {
					// 设置检查方法
					igris0202Form.setRccommon(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000004")) {

				} else if (socInfo.getCid().equals("CI210000000005")) {
					// 检查项类别
					Integer in = Integer.parseInt(socInfo.getCivalue()) - 999021000;
					igris0202Form.setRcclass(in.toString());
				}
			}
			if (eiids.get(i) != null && !(eiids.get(i).equals(""))) {
				SOC0118Info soc0118 = soc0118BL.searchEntityItemByKey(Integer.parseInt(eiids.get(i)));
				igris0202Form.setRcstatus(soc0118.getEistatus());
			}
			// 关联相应资产id
			igris0202Form.setRcasset(Integer.parseInt(eiids.get(i)));
			RiskCheck check = this.riskCheckBL.registRiskCheck(igris0202Form);

			// 插入检查策略关联检查项表
			CheckInfoRiskTB riskTB = new CheckInfoRiskTB();
			riskTB.setCsid(info.getCsid());
			riskTB.setRcid(check.getRcid());
			checkInfoRiskBL.registCheckInfoRisk(riskTB);
			checkList.add(check);
		}
		dto.setRiskCheckList(checkList);

		dto.addMessage(new ActionMessage("IGCO10000.I003", "检查策略修改成功"));
		log.debug("========风险检查变更处理终了========");
		return dto;
	}

	/**
	 * 关联审计项初始化处理
	 * 
	 * @param dto
	 *            IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS02DTO searchRiskAuditDefAction(IGRIS02DTO dto) throws BLException {

		log.debug("========关联审计项初始化处理开始========");
		IGRIS0201Form form = dto.getIgRIS0201Form();

		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		cond.setRaid(form.getRaid());
		cond.setByLevelDesc("1");

		// 该版本审计项信息取得
		List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);

		if (riskAuditDefList != null && riskAuditDefList.size() > 0) {
			// 取得审计项的最大级次
			String radMaxLevel = riskAuditDefList.get(0).getRadlevel();
			if (StringUtils.isNotEmpty(radMaxLevel)) {
				dto.setRadMaxLevel(Integer.parseInt(radMaxLevel));
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 1; i <= Integer.parseInt(radMaxLevel); i++) {
					list.add(i);
				}
				dto.setRadMaxLevelList(list);
			}
			// 查询已关联的审计项的相关信息
			AuditCheckRelationSearchCondImpl cond1 = new AuditCheckRelationSearchCondImpl();
			cond1.setRcid(form.getRcid());

			List<AuditCheckRelation> auditCheckRelationList = this.auditCheckRelationBL.searchAuditCheckRelation(cond1, 0, 0);

			String[] radid = new String[auditCheckRelationList.size()];

			int i = 0;

			for (AuditCheckRelation info : auditCheckRelationList) {
				radid[i++] = String.valueOf(info.getRadid());
			}

			form.setRadids(radid);

			cond = new RiskAuditDefSearchCondImpl();
			cond.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
			cond.setRaid(form.getRaid());
			// 该版本审计项信息取得
			List<RiskAuditDef> riskAuditDefList1 = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);

			dto.setRiskAuditDefList(riskAuditDefList1);
		}

		log.debug("========关联审计项初始化处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 关联审计项保存
	 * </p>
	 */

	public IGRIS02DTO insertRiskAuditDefAction(IGRIS02DTO dto) throws BLException {
		IGRIS0201Form form = dto.getIgRIS0201Form();
		String[] radids = form.getRadids();
		Integer rcid = form.getRcid();
		if (radids != null) {
			// 删除已保存的关联审计项纪录
			if (rcid != null && rcid != 0) {
				AuditCheckRelationSearchCondImpl cond = new AuditCheckRelationSearchCondImpl();
				cond.setRcid(rcid);
				List<AuditCheckRelation> list = this.auditCheckRelationBL.searchAuditCheckRelation(cond, 0, 0);
				for (AuditCheckRelation acr : list) {
					this.auditCheckRelationBL.deleteAuditCheckRelation(acr.getAcrid());
				}
			}
			// 保存新的关联审计项纪录
			for (int i = 0, j = radids.length; i < j; i++) {
				AuditCheckRelationTB acrtb = new AuditCheckRelationTB();
				acrtb.setRcid(rcid);
				acrtb.setRadid(Integer.valueOf(radids[i]));

				this.auditCheckRelationBL.registAuditCheckRelation(acrtb);
			}
			dto.addMessage(new ActionMessage("IGRIS0201.I001", "关联审计项成功完成"));
		}

		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查查询
	 * </p>
	 */

	public IGRIS02DTO searchRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查查询处理开始========");
		IGRIS0201Form form = dto.getIgRIS0201Form();
		CheckStrategySearchCondImpl cond = new CheckStrategySearchCondImpl();
		// 设定检查方式
		cond.setCsrtestmode(form.getRcrtestmode());
		// 设定检查策略名称
		cond.setCsname(form.getRcname());
		// 设定重要程度
		cond.setCstype(form.getRctype());
		// 设定状态
		cond.setCsstatus(form.getRcstatus());
		// 设定责任组
		cond.setCsrolename(form.getRcrolename());
		// 设定责任人姓名
		cond.setCsusername(form.getRcusername());
		// 设定频率
		cond.setCsfrequency(form.getRcfrequency());
		// 查询记录总数
		int totalCount = this.checkStrategyBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<CheckStrategyInfo> checkStrategyList = this.checkStrategyBL.searchCheckStrategy(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		User user = dto.getUser();// 当前用户
		UserRoleVWSearchCondImpl usercond = new UserRoleVWSearchCondImpl();
		usercond.setUserid(user.getUserid());
		// 取得当前用户所具有的角色
		List<UserRoleInfo> rolelist = this.userRoleBL.searchUserRoleVW(usercond, 0, 0);
		// 信息安全岗直接返回所有数据
		for (int i = 0; i < rolelist.size(); i++) {
			if (rolelist.get(i).getRoleid() == 1127 || rolelist.get(i).getRoleid() == 1121) {
				dto.setCheckStrategyList(checkStrategyList);
				return dto;
			}
		}
		if (checkStrategyList != null && checkStrategyList.size() > 0) {
			List<CheckStrategyInfo> rcrlist = new ArrayList<CheckStrategyInfo>();
			boolean flag = false;
			for (CheckStrategyInfo rcr : checkStrategyList) {
				flag = false;
				CheckStrategyTB rc = (CheckStrategyTB) rcr;
				for (UserRoleInfo uri : rolelist) {
					if (rc != null && uri != null) {
						// 判断当前用户具有的角色是否与风险检查责任组的角色相同
						if (uri.getRoleid() != null && rc.getCsroleid() != null && !"".equals(rc.getCsroleid())) {
							if (uri.getRoleid().equals(Integer.valueOf(rc.getCsroleid()))) {
								flag = true;
								break;
							} else if (user.getUserid().equals(rc.getCsroleid())) {// 在不是风险检查责任组的角色时判断当前用户是否是合作执行人ID以确保分支逻辑正确执行
								flag = true;
								break;
							}
						}
					}

				}
				if (flag) {
					rcrlist.add(rcr);
				}
			}
			if (rcrlist != null && rcrlist.size() > 0) {
				dto.setCheckStrategyList(rcrlist);
			}

		}
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========风险检查查询处理终了========");
		return dto;
	}

	public IGRIS02DTO searchRiskStrategyAction(IGRIS02DTO dto) throws BLException {

		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查调整状态
	 * </p>
	 */

	public IGRIS02DTO changeRiskCheckStatusAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查调整状态处理开始========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		String status = form.getRcstatus();
		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);// yyyy/MM/dd
																			// HH:mm
		if (IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE.equals(status)) {
			// 停用
			RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
			RiskCheckTB rctb = (RiskCheckTB) SerializationUtils.clone(rc);
			rctb.setRcstatus(form.getRcstatus());
			rctb.setRcapprovetime(date);// 审批时间
			rctb.setRcapprover(dto.getUser().getUsername());// 审批人
			RiskCheck riskcheck = this.riskCheckBL.updateRiskCheck(rctb);
			dto.setRiskCheck(riskcheck);

			String jobName = "RiskCheckJob" + riskcheck.getRcid();
			String jobGroupName = "RiskCheckGroup" + riskcheck.getRcid();
			String triggerName = "RiskCheckJobTrigger" + riskcheck.getRcid();
			String triggerGroupName = "RiskCheckJobTriggerGroup" + riskcheck.getRcid();

			try {
				JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
			} catch (SchedulerException e) {
				log.error("==========Exception form RiskCheckJob===========");
				log.debug(e.getMessage());
				log.debug("quarz启动报错", e);
				throw new BLException("", "SchedulerException");
			}
			// 判断每月最后一天是否发起检查
			if (StringUtils.isNotEmpty(riskcheck.getRcfrequencymonthlastday())) {
				String jobNameLastDay = "RiskCheckJobLastDay" + riskcheck.getRcid();
				String jobGroupNameLastDay = "RiskCheckGroupLastDay" + riskcheck.getRcid();
				String triggerNameLastDay = "RiskCheckJobTriggerLastDay" + riskcheck.getRcid();
				String triggerGroupNameLastDay = "RiskCheckJobTriggerGroupLastDay" + riskcheck.getRcid();

				try {
					JobManager.removeJob(jobNameLastDay, jobGroupNameLastDay, triggerNameLastDay, triggerGroupNameLastDay);
				} catch (SchedulerException e) {
					log.error("==========Exception form RiskCheckJob===========");
					log.debug(e.getMessage());
					throw new BLException("", "SchedulerException");
				}
			}

		} else {
			// 启用
			RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
			RiskCheckTB rctb = (RiskCheckTB) SerializationUtils.clone(rc);
			rctb.setRcstatus(form.getRcstatus());
			rctb.setRcapprovetime(date);// 审批时间
			rctb.setRcapprover(dto.getUser().getUsername());// 审批人
			RiskCheck riskcheck = this.riskCheckBL.updateRiskCheck(rctb);
			dto.setRiskCheck(riskcheck);

			// 检查频率
			String frequency = riskcheck.getRccron();
			// 取得执行周期表达式
			String cronExpression = frequency;

			RiskCheckJob riskCheckJob = new RiskCheckJob();// 取得job
			String jobName = "RiskCheckJob" + riskcheck.getRcid();
			String jobGroupName = "RiskCheckGroup" + riskcheck.getRcid();
			String triggerName = "RiskCheckJobTrigger" + riskcheck.getRcid();
			String triggerGroupName = "RiskCheckJobTriggerGroup" + riskcheck.getRcid();
			String creatTime = riskcheck.getRcstartdate();
			String endTime = riskcheck.getRcenddate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date beganDate = null;
			Date endDate = null;
			log.debug(cronExpression);
			try {

				beganDate = format.parse(creatTime);
				endDate = format.parse(endTime);
				Map<String, Integer> args = new HashMap<String, Integer>();
				args.put("rcid", riskcheck.getRcid());
				args.put("cwrid", dto.getCwrid());
				List<String> keyname = new ArrayList<String>();
				keyname.add("rcid");
				keyname.add("cwrid");

				JobManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, riskCheckJob, keyname, args, cronExpression, beganDate, endDate);

			} catch (Exception e) {
				log.error("==========Exception form RiskCheckJob===========");
				log.error("quarz报错", e);
				throw new BLException("IGRIS0201.E001", "SchedulerException");
			}
		}

		log.debug("========风险检查调整状态处理终了========");
		return dto;
	}

	/**
	 * 改变检查策略状态
	 */
	public IGRIS02DTO changeCheckStrategyStatusAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查调整状态处理开始========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		String status = form.getRcstatus();
		// Date nowDateTime = new Date();
		// String date =
		// CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);// yyyy/MM/dd
		// HH:mm
		if (IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE.equals(status)) {
			// 停用
			CheckStrategyInfo info = this.checkStrategyBL.searchCheckStrategyByPK(form.getCsid());
			CheckStrategyTB chtb = (CheckStrategyTB) SerializationUtils.clone(info);
			chtb.setCsstatus(form.getRcstatus());
			/*
			 * chtb.setRcapprovetime(date);// 审批时间
			 * chtb.setRcapprover(dto.getUser().getUsername());// 审批人
			 */
			CheckStrategyInfo checkinfo = this.checkStrategyBL.updateCheckStrategy(chtb);
			dto.setCheckInfo(checkinfo);

			String jobName = "RiskCheckJob" + checkinfo.getCsid();
			String jobGroupName = "RiskCheckGroup" + checkinfo.getCsid();
			String triggerName = "RiskCheckJobTrigger" + checkinfo.getCsid();
			String triggerGroupName = "RiskCheckJobTriggerGroup" + checkinfo.getCsid();

			try {
				JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
			} catch (SchedulerException e) {
				log.error("==========Exception form RiskCheckJob===========");
				log.debug(e.getMessage());
				log.debug("quarz启动报错", e);
				throw new BLException("", "SchedulerException");
			}
		} else {
			// 启用
			CheckStrategyInfo info = this.checkStrategyBL.searchCheckStrategyByPK(form.getCsid());
			CheckStrategyTB chtb = (CheckStrategyTB) SerializationUtils.clone(info);
			chtb.setCsstatus(form.getRcstatus());
			/*
			 * chtb.setRcapprovetime(date);// 审批时间
			 * chtb.setRcapprover(dto.getUser().getUsername());// 审批人
			 */
			CheckStrategyInfo checkinfo = this.checkStrategyBL.updateCheckStrategy(chtb);
			dto.setCheckInfo(checkinfo);

			// 检查频率
			String frequency = checkinfo.getCscron();
			// 取得执行周期表达式
			String cronExpression = frequency;

			RiskCheckJob riskCheckJob = new RiskCheckJob();// 取得job
			String jobName = "RiskCheckJob" + checkinfo.getCsid();
			String jobGroupName = "RiskCheckGroup" + checkinfo.getCsid();
			String triggerName = "RiskCheckJobTrigger" + checkinfo.getCsid();
			String triggerGroupName = "RiskCheckJobTriggerGroup" + checkinfo.getCsid();
			String creatTime = checkinfo.getCsstartdate();
			String endTime = checkinfo.getCsenddate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date beganDate = null;
			Date endDate = null;
			log.debug(cronExpression);
			try {

				beganDate = format.parse(creatTime);
				endDate = format.parse(endTime);
				Map<String, Integer> args = new HashMap<String, Integer>();
				args.put("csid", checkinfo.getCsid());
				List<String> keyname = new ArrayList<String>();
				keyname.add("csid");

				JobManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, riskCheckJob, keyname, args, cronExpression, beganDate, endDate);

			} catch (Exception e) {
				log.error("==========Exception form RiskCheckJob===========");
				log.error("quarz报错", e);
				throw new BLException("IGRIS0201.E001", "SchedulerException");
			}
		}

		log.debug("========风险检查调整状态处理终了========");
		return dto;
	}

	public IGRIS02DTO changeCheckStrategyStatusOnlyAction(IGRIS02DTO dto) throws BLException {

		log.debug("========风险检查调整状态处理开始========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		CheckStrategyInfo info = this.checkStrategyBL.searchCheckStrategyByPK(form.getCsid());
		if (info.getCsfrequency().equals("once")) {
			CheckStrategyTB checkTB = (CheckStrategyTB) info;
			dto.setCsid(info.getCsid());
			// 点击启用
			if ((IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE).equals(info.getCsstatus())) {
				checkTB.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE);
				initRiskCheckResult(dto);
			} else if ((IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE).equals(info.getCsstatus())) {
				checkTB.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE);
			}
			checkStrategyBL.updateCheckStrategy(checkTB);
		} else {
			changeRiskStatusAction(info);
		}
		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查查看页
	 * </p>
	 */

	public IGRIS02DTO readRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查查看处理开始========");
		IGRIS0201Form form = dto.getIgRIS0201Form();
		RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
		if(rc == null){
			RiskCheckResultSearchCondImpl rcrCond = new RiskCheckResultSearchCondImpl();
			rcrCond.setRcid(form.getRcid());
			List<RiskCheckResult> rcrList = riskCheckResultBL.searchRiskCheckResult(rcrCond, 0, 0);
			for (RiskCheckResult riskCheckResult : rcrList) {
				RiskCheckSearchCondImpl rcCond = new RiskCheckSearchCondImpl();
				rcCond.setRcname(riskCheckResult.getRcname());
				rcCond.setRcdesc(riskCheckResult.getRcdesc());
				rcCond.setRcuserid(riskCheckResult.getRcruserid());
				List<RiskCheck> rcList = riskCheckBL.searchRiskCheck(rcCond, 0, 0);
				for (RiskCheck riskCheck : rcList) {
					rc = riskCheck;
				}
			}
		}
		dto.setRiskCheck(rc);

		// 解释风险检查策略的表达式
		String cronInfo = this.getfrequencydesc(rc.getRcfrequency(), rc.getRcstartdate(), rc.getRcfrequencydesc());
		dto.setCronInfo(cronInfo);

		// 查询附件信息
		if (StringUtils.isNotEmpty(rc.getRcattch())) {
			List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(rc.getRcattch());
			dto.setAttachmentList(attachmentList);
		}

		log.debug("========风险检查查看处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查结果日报查询
	 * </p>
	 */

	public IGRIS02DTO searchRiskCheckResultReportByDayAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查结果日报查询处理开始========");
		IGRIS0204Form form = dto.getIgRIS0204Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRcrplandate(form.getRcrplandate());
		List<RiskCheckResult> list = this.riskCheckResultBL.searchRiskCheckResult(cond, 0, 0);

		// 查询记录总数
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.searchRiskCheckResult(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskCheckResultDataList(rcrList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========风险检查结果日报查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查阶段结果查询
	 * </p>
	 */

	public IGRIS02DTO searchRiskCheckResultReportByPeriodAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查阶段结果查询处理开始========");
		IGRIS0206Form form = dto.getIgRIS0206Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRccategory(form.getRccategory());
		cond.setRcid(form.getRcid());
		cond.setStartdate(form.getStartdate());
		cond.setEnddate(form.getEnddate());
		List<RiskCheckResult> list = this.riskCheckResultBL.searchRiskCheckResult(cond, 0, 0);

		// 查询记录总数
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.searchRiskCheckResult(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskCheckResultDataList(rcrList);

		log.debug("========风险检查阶段结果查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 最近一次风险检查结果查询(统计分析页显示使用)
	 * </p>
	 */

	public List<RiskCheckResult> searchLastRiskCheckResultToVo() throws BLException {
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.findResultByCond(cond, 0, 0);

		return rcrList;
	}

	/**
	 * <p>
	 * Description: 最近一次风险检查结果查询
	 * </p>
	 */

	public IGRIS02DTO searchLastRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException {
		log.debug("========最近一次风险检查结果查询处理开始========");
		IGRIS0205Form IgRIS0205Form = dto.getIgRIS0205Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRcusername_like(IgRIS0205Form.getRcusername_like());// 责任人
		cond.setRcname_like(IgRIS0205Form.getRcname_like());// 检查项
		cond.setNtime_from(IgRIS0205Form.getNtime_from());// 计划开始时间
		cond.setNtime_to(IgRIS0205Form.getNtime_to());
		cond.setRcrresult(IgRIS0205Form.getRcrresult());// 检查结果
		cond.setRcrstatic(IgRIS0205Form.getRcrstatic());// 风险检查状态
		cond.setRcrusername(IgRIS0205Form.getRcrusername());
		if (StringUtils.isNotEmpty(IgRIS0205Form.getChtype())) {
			cond.setChtype(IgRIS0205Form.getChtype());// 未检查工作标识
		}
		cond.setRccategory(IgRIS0205Form.getRccategory());// 风险检查项类别
		cond.setRctype_eq(IgRIS0205Form.getRctype_eq());// 重要程度
		// 查询用户角色列表
		List<Integer> roleIds = sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		// 用户角色
		String roleLine = "";

		for (int roleId : roleIds) {
			roleLine += roleId + "_";
		}
		// 如果用户拥有信息安全审批角色，则全部显示;合作执行人和信息安全员可查询自己的
		if (roleLine.indexOf(IGRISCONSTANTS.INFORMATION_SAFETY_APPROVAL) > 0) {

		} else {
			cond.setRcrelateduser(dto.getUser().getUsername());
		}

		List<RiskCheckResult> list = this.riskCheckResultBL.findResultByCond(cond, 0, 0);

		// 查询记录总数
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.findResultByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskCheckResultDataList(rcrList);

		log.debug("========最近一次风险检查结果查询处理终了========");
		return dto;
	}

	/***
	 * 检查任务查询
	 * 
	 */
	public IGRIS02DTO searchCheckWorkResulReportAction(IGRIS02DTO dto) throws BLException {

		IGRIS0205Form igRIS0205Form = dto.getIgRIS0205Form();
		List<CheckworkInfoResultInfo> checkList = checkworkInfoResultBL.searchCheckworkInfoResult();
		// StringBuffer cwrid_inBuffer = new StringBuffer();
		List<Integer> cwridList = new ArrayList<Integer>();
		if (checkList != null && checkList.size() > 0) {
			for (int i = 0; i < checkList.size(); i++) {
				cwridList.add(checkList.get(i).getCwrid());
			}
		}
		Set<Integer> cwridList2 = new HashSet<Integer>(cwridList);

		// Iterator<Integer> it = cwridList2.iterator();
		// while(it.hasNext()){
		// cwrid_inBuffer.append(it.next());
		// cwrid_inBuffer.append(",");
		// }
		// String cwrid_in = cwrid_inBuffer.subSequence(0,
		// cwrid_inBuffer.length()-1).toString();

		CheckWorkResultSearchCondImpl cond = new CheckWorkResultSearchCondImpl();
		cond.setCsid(igRIS0205Form.getCsid());
		cond.setCwrid_inSet(cwridList2);
		// cond.setCwrid_in(cwrid_in);

		// 检查方式没有
		cond.setCwrtestmode(igRIS0205Form.getRcrtestmode());
		// 检查任务名称
		cond.setCwrname(igRIS0205Form.getRcrcomment());
		// 责任人
		cond.setCwrusername(igRIS0205Form.getRcusername_like());
		// 任务开始时间
		cond.setCwrplandate_from(igRIS0205Form.getNtime_from());
		cond.setCwrplandate_to(igRIS0205Form.getNtime_to());
		// 任务完成时间
		cond.setCwrrealtime_from(igRIS0205Form.getEtime_from());
		cond.setCwrrealtime_to(igRIS0205Form.getEtime_to());

		// 查询用户角色列表
		// List<Integer> roleIds =
		// sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		// 用户角色
		// String roleLine = "";
		//
		// for(int roleId : roleIds){
		// roleLine += roleId + "_";
		// }

		List<CheckWorkResultInfo> list = this.checkWorkResultBL.searchCheckWorkResult(cond, 0, 0);

		// 查询记录总数
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<CheckWorkResultInfo> rcrList = this.checkWorkResultBL.searchCheckWorkResult(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setCheckWorkResultInfos(rcrList);

		log.debug("========最近一次风险检查结果查询处理终了========");

		return dto;
	}

	/**
	 * <p>
	 * Description: 检查工作监督查询
	 * </p>
	 */
	public IGRIS02DTO searchSuperviseRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException {
		log.debug("========最近一次风险检查结果查询处理开始========");
		IGRIS0205Form IgRIS0205Form = dto.getIgRIS0205Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRcusername_like(IgRIS0205Form.getRcusername_like());// 责任人
		cond.setRcname_like(IgRIS0205Form.getRcname_like());// 检查项
		cond.setNtime_from(IgRIS0205Form.getNtime_from());// 计划开始时间
		cond.setNtime_to(IgRIS0205Form.getNtime_to());
		cond.setRcrresult(IgRIS0205Form.getRcrresult());// 检查结果
		cond.setRcrstatic(IgRIS0205Form.getRcrstatic());// 风险检查状态
		if (StringUtils.isNotEmpty(IgRIS0205Form.getChtype())) {
			cond.setChtype(IgRIS0205Form.getChtype());// 未检查工作标识
		}
		cond.setRccategory(IgRIS0205Form.getRccategory());// 风险检查项类别
		cond.setRctype_eq(IgRIS0205Form.getRctype_eq());// 重要程度
		cond.setRcclass(IgRIS0205Form.getRcclass());// 风险检查类型
		// //查询用户角色列表
		// List<Integer> roleIds =
		// sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		// //用户角色
		// String roleLine = "";
		//
		// for(int roleId : roleIds){
		// roleLine += roleId + "_";
		// }
		// //如果用户拥有信息安全审批角色，则全部显示;合作执行人和信息安全员可查询自己的
		// if(roleLine.indexOf("1127")>0){
		//
		// }else{
		// cond.setRcruserid(dto.getUser().getUserid());
		// }

		List<RiskCheckResult> list = this.riskCheckResultBL.findResultByCond(cond, 0, 0);

		// 查询记录总数
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.findResultByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskCheckResultDataList(rcrList);

		log.debug("========最近一次风险检查结果查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查结果查看页
	 * </p>
	 */

	public IGRIS02DTO readRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查结果查看处理开始========");
		IGRIS0204Form form = dto.getIgRIS0204Form();
		RiskCheckResult rcr = this.riskCheckResultBL.searchRiskCheckResultByKey(form.getRcrid());
		dto.setRiskCheckResult(rcr);

		// 查询附件信息
		if (StringUtils.isNotEmpty(rcr.getRcrattch())) {
			List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(rcr.getRcrattch());
			dto.setAttachmentList(attachmentList);
		}

		log.debug("========风险检查结果查看处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 风险检查结果查询
	 * </p>
	 */

	public IGRIS02DTO searchRiskCheckResultAction(IGRIS02DTO dto) throws BLException {

		IGRIS0203Form form = dto.getIgRIS0203Form();

		User user = dto.getUser();// 当前用户
		UserRoleVWSearchCondImpl usercond = new UserRoleVWSearchCondImpl();
		usercond.setUserid(user.getUserid());

		// 取得当前用户所具有的角色
		List<UserRoleInfo> rolelist = this.userRoleBL.searchUserRoleVW(usercond, 0, 0);
		// String nowdate = IGStringUtils.getCurrentDate();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		// cond.setRcrplandate(nowdate);
		cond.setRcruserid_isNull("1");
		cond.setRcrrealtime_isNull("1");
		cond.setCiiop(form.getCiiop());
		cond.setRcusername_like(form.getRcusername());
		cond.setRcrplandate_from(form.getRcrplandate_from());
		cond.setRcrplandate_to(form.getRcrplandate_to());
		cond.setRcclass(form.getRcclass());

		List<RiskCheckResult> list = this.riskCheckResultBL.searchRiskCheckResult(cond, 0, 0);
		// 信息安全岗直接返回所有数据
		for (int i = 0; i < rolelist.size(); i++) {
			if (rolelist.get(i).getRoleid() == 1127 || rolelist.get(i).getRoleid() == 1121) {
				dto.setRiskCheckResultDataList(list);
				return dto;
			}
		}
		// 取得当期用户能够看见的风险检查结果集合
		if (list != null && list.size() > 0) {
			List<RiskCheckResult> rcrlist = new ArrayList<RiskCheckResult>();
			boolean flag = false;
			for (RiskCheckResult rcr : list) {
				flag = false;
				RiskCheckTB rc = rcr.getRiskCheck();
				for (UserRoleInfo uri : rolelist) {
					if (rc != null && uri != null) {
						// 判断当前用户具有的角色是否与风险检查责任组的角色相同
						if (uri.getRoleid() != null && rc.getRcroleid() != null && !"".equals(rc.getRcroleid())) {
							if (uri.getRoleid().equals(Integer.valueOf(rc.getRcroleid()))) {
								flag = true;
								break;
							} else if (user.getUserid().equals(rc.getCiiopid())) {// 在不是风险检查责任组的角色时判断当前用户是否是合作执行人ID以确保分支逻辑正确执行
								flag = true;
								break;
							}
						}
					}

				}
				if (flag) {
					rcrlist.add(rcr);
				}
			}
			if (rcrlist != null && rcrlist.size() > 0) {
				dto.setRiskCheckResultDataList(rcrlist);
			}

		}
		return dto;
	}

	/**
	 * 判断页面提交的记录是否已经被其他用户提交过
	 */
	@SuppressWarnings("unused")
	private boolean checkRiskCheckResultStatus(IGRIS0203Form form) throws BLException {
		boolean flag = false;
		Integer[] rcrids = form.getRcrids();

		if (rcrids != null) {
			for (int i = 0, j = rcrids.length; i < j; i++) {
				RiskCheckResult rcr = this.riskCheckResultBL.searchRiskCheckResultByKey(rcrids[i]);
				if (rcr.getRcruserid() != null && !"".equals(rcr.getRcruserid())) {
					flag = true;
					break;
				}
			}
		}

		return flag;
	}

	/**
	 * <p>
	 * Description: 风险检查结果保存
	 * </p>
	 */

	public synchronized IGRIS02DTO insertRiskCheckResultAction(IGRIS02DTO dto) throws BLException {

		IGRIS0203Form form = dto.getIgRIS0203Form();
		Integer[] rcrids = form.getRcrids();
		String[] rcrresults = form.getRcrresults();
		String[] rcrcomments = form.getRcrcomments();
		Integer[] filenum = form.getFilenum();
		User user = dto.getUser();// 当前用户
		// if(!checkRiskCheckResultStatus(form)){
		if (rcrids != null) {
			for (int i = 0, j = rcrids.length; i < j; i++) {
				RiskCheckResult rcr = this.riskCheckResultBL.searchRiskCheckResultByKey(rcrids[i]);
				RiskCheckResultTB rcrtb = (RiskCheckResultTB) SerializationUtils.clone(rcr);
				rcrtb.setRcruserid(user.getUserid());// 提交人id
				rcrtb.setRcrusername(user.getUsername());// 提交人姓名
				rcrtb.setRcrrealtime(IGStringUtils.getCurrentDateTime());// 提交时间
				rcrtb.setRcrresult(rcrresults[i]);// 结果
				rcrtb.setRcrcomment(rcrcomments[i]);// 说明

				AttachmentTB attachment = new AttachmentTB();
				String attkey = IGStringUtils.getAttKey();// 附件id
				attachment.setAttkey(attkey);

				// 上传文件检测
				Map<Integer, FormFile> filemap = form.getFileMap();

				FormFile file = (FormFile) filemap.get(filenum[i]);
				if (file != null && file.getFileSize() > 0) {
					// 上传文件存在的情况
					// 上传文件路径
					String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();

					// 根目录
					pathBuf.append(rootPath);
					// 当前模块目录
					pathBuf.append("risk");
					pathBuf.append(File.separator);
					StringBuffer fileName = new StringBuffer();
					fileName.append(file.getFileName());
					// 文件上传处理
					try {
						this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}

					// 上传文件名保存
					attachment.setAttname(attkey + "_" + fileName.toString());
					// 上传文件名URL
					attachment.setAtturl("risk");

					this.attachmentBL.registAttachment(attachment);
				}
				rcrtb.setRcrattch(attkey);// 附件
				rcrtb.setRcrtestmode("已完成");
				this.riskCheckResultBL.updateRiskCheckResult(rcrtb);
			}

			CheckworkInfoResultSearchCondImpl checkCond = new CheckworkInfoResultSearchCondImpl();
			checkCond.setCwrid(form.getCwrid());
			List<CheckworkInfoResultInfo> checkWorkList = this.checkworkInfoResultBL.searchCheckworkInfoResult(checkCond, 0, 0);
			Integer[] rcrid_in = new Integer[checkWorkList.size()];
			for (int i = 0; i < checkWorkList.size(); i++) {
				rcrid_in[i] = checkWorkList.get(i).getRcrid();
			}
			// 插入进度
			Integer rate = 0;

			RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
			cond.setRcrid_in(rcrid_in);
			// 查询出总的数量
			int sum = this.riskCheckResultBL.getSearchCountForRate(cond);
			cond.setRcrrealtime_isNull("1");
			// 查询出已经需要处理的工作数量
			int count = this.riskCheckResultBL.getSearchCountForRate(cond);
			// 计算出已处理完成的数量
			rate = (int) (((1 - (double) count / (double) sum)) * 100);

			CheckWorkResultInfo info = this.checkWorkResultBL.searchCheckWorkResultByPK(form.getCwrid());
			CheckWorkResultTB tb = (CheckWorkResultTB) info;
			// 如果进度为100,则该任务已完成
			if (rate == 100) {
				Date time = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				tb.setCwrrealtime(format.format(time));
			}
			if (rate > 100) {
				rate = 100;
				Date time = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				tb.setCwrrealtime(format.format(time));
			}
			// 如果进度小于100,则该任务未完成
			if (rate < 100) {
				tb.setCwrrealtime("");
			}
			// 将进度重新插入到该检查任务上
			tb.setCwrrate(rate.toString());
			// 更新数据
			this.checkWorkResultBL.updateCheckWorkResult(tb);
		}
		// }else{
		// dto.setGoToError(IGRISCONSTANTS.RISKCHECKRESULT_SUBMIT_ERROR);
		// }
		dto.addMessage(new ActionMessage("IGCO10000.I003", "检查工作执行成功。"));
		return dto;
	}

	/**
	 * <p>
	 * Description: 检查策略保存
	 * </p>
	 */
	public IGRIS02DTO insertCheckStrategAction(IGRIS02DTO dto) throws BLException {

		log.debug("========风险检查新增处理开始========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		CheckStrategyTB csTb = new CheckStrategyTB();
		AttachmentTB attachment = new AttachmentTB();
		String attkey = IGStringUtils.getAttKey();// 附件id
		attachment.setAttkey(attkey);

		// 上传文件检测
		Map<Integer, FormFile> filemap = form.getFileMap();
		Iterator<Integer> iterator = filemap.keySet().iterator();
		while (iterator.hasNext()) {
			FormFile file = (FormFile) filemap.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();

				// 根目录
				pathBuf.append(rootPath);
				// 当前模块目录
				pathBuf.append("risk");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// 文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}

				// 上传文件名保存
				attachment.setAttname(attkey + "_" + fileName.toString());
				// 上传文件名URL
				attachment.setAtturl("risk");

				this.attachmentBL.registAttachment(attachment);

			}
		}
		// 检查频率
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// 频率为周
			for (String week : form.getRcfrequencyweek()) {
				if (StringUtils.isEmpty(frequency)) {
					frequency = week;
				} else {
					frequency = frequency + "," + week;
				}
			}
		} else if ("month".equals(form.getRcfrequency())) {
			if (form.getRcfrequencymonth() != null) {
				// 频率为月
				for (String month : form.getRcfrequencymonth()) {
					if (StringUtils.isEmpty(frequency)) {
						frequency = month;
					} else {
						frequency = frequency + "," + month;
					}
				}
			}
		}

		// 按 , 拆分字符串,得到一个数组
		String[] startdate = form.getRcstartdate().split("\\ ");
		String starttime = startdate[1];
		String[] begindate = starttime.split("\\:");
		// 时
		String exeHour = begindate[0];
		// 分
		String exeMinute = begindate[1];
		// 取得执行周期表达式
		String cronExpression = null;

		if (StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())) {// 频率为每月最后一天
			// 取得执行周期表达式,风险检查频率(每月最后一天)
			if ("1".equals(form.getRcfrequencymonthlastday())) {
				// 取得执行周期表达式
				cronExpression = this.creatCronExp(form.getRcfrequencymonthlastday(), exeHour, exeMinute, form.getRcstartdate(), null);
				frequency = "最后一";
			}
		} else {// 频率为周、月
			cronExpression = this.creatCronExp(form.getRcfrequency(), exeHour, exeMinute, form.getRcstartdate(), frequency);
		}

		form.setRcfrequencydesc(frequency);// 风险检查频率内容
		// 保存RiskCheck
		form.setRcstatus(IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE);// 设置状态为启用
		form.setRcattch(attkey);// 附件id
		form.setRccron(cronExpression);// 风险检查策略执行表达式

		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRccreatetime(date);// 风险检查登记时间yyyy/MM/dd HH:mm
		// 登录风险检查信息
		// RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
		// dto.setRiskCheck(rc);
		csTb = copyPropertie(csTb, form);
		CheckStrategyInfo info = this.checkStrategyBL.registCheckStrategy(csTb);
		dto.setIgRIS0202Form(form);
		dto.setCheckStrategyInfo(info);

		List<String> eiids = dto.getEiids();
		List<String> eiversions = dto.getEiversions();
		List<RiskCheck> checkList = new ArrayList<RiskCheck>();
		// 插入检查项，这里需要通过资产的eiid和eiversion来取出资产的属性
		for (int i = 0; i < eiids.size(); i++) {
			// 查询资产属性
			SOC0107SearchCondImpl soc0107cond = new SOC0107SearchCondImpl();
			IGRIS0202Form igris0202Form = dto.getIgRIS0202Form();
			soc0107cond.setEiid(eiids.get(i));
			soc0107cond.setCiversion(eiversions.get(i));
			List<SOC0107Info> soc0107InfoList = soc0107BL.searchSOC0107(soc0107cond, 0, 0);
			for (int j = 0; j < soc0107InfoList.size(); j++) {
				SOC0107Info socInfo = soc0107InfoList.get(j);
				if (socInfo.getCid().equals("CI210000000001")) {
					// 设置检查项名称
					igris0202Form.setRcname(socInfo.getCivalue());
					igris0202Form.setRcassetname(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000002")) {
					// 设置检查项说明
					igris0202Form.setRcdesc(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000003")) {
					// 设置检查方法
					igris0202Form.setRccommon(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000004")) {

				} else if (socInfo.getCid().equals("CI210000000005")) {
					// 检查项类别
					Integer in = Integer.parseInt(socInfo.getCivalue()) - 999021000;
					igris0202Form.setRcclass(in.toString());
				}

			}
			if (eiids.get(i) != null && !(eiids.get(i).equals(""))) {
				SOC0118Info soc0118 = soc0118BL.searchEntityItemByKey(Integer.parseInt(eiids.get(i)));
				igris0202Form.setRcstatus(soc0118.getEistatus());
			}
			// 关联相应资产id
			igris0202Form.setRcasset(Integer.parseInt(eiids.get(i)));
			RiskCheck check = this.riskCheckBL.registRiskCheck(igris0202Form);

			// 插入检查策略关联检查项表
			CheckInfoRiskTB riskTB = new CheckInfoRiskTB();
			riskTB.setCsid(info.getCsid());
			riskTB.setRcid(check.getRcid());
			checkInfoRiskBL.registCheckInfoRisk(riskTB);
			checkList.add(check);
		}
		dto.setRiskCheckList(checkList);
		if (info.getCsfrequency().equals("once")) {
			CheckStrategyTB checkTB = (CheckStrategyTB) info;
			dto.setCsid(info.getCsid());
			checkTB.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE);
			initRiskCheckResult(dto);
			checkStrategyBL.updateCheckStrategy(checkTB);
		} else {
			changeRiskStatusAction(info);
		}
		dto.addMessage(new ActionMessage("IGRIS0202.I001", "检查策略设定成功"));
		log.debug("========风险检查新增处理终了========");
		return dto;
	}

	private void changeRiskStatusAction(CheckStrategyInfo info) throws BLException {
		CheckStrategyTB chtb = (CheckStrategyTB) info;
		String jobName = "RiskCheckJob" + info.getCsid();
		String jobGroupName = "RiskCheckGroup" + info.getCsid();
		String triggerName = "RiskCheckJobTrigger" + info.getCsid();
		String triggerGroupName = "RiskCheckJobTriggerGroup" + info.getCsid();
		// 停用状态启用策略
		if (IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE.equals(info.getCsstatus())) {
			chtb.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE);
			// 检查频率
			String frequency = info.getCscron();
			// 取得执行周期表达式
			String cronExpression = frequency;
			RiskCheckJob riskCheckJob = new RiskCheckJob();// 取得job
			String creatTime = info.getCsstartdate();
			String endTime = info.getCsenddate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date beganDate = null;
			Date endDate = null;
			log.debug(cronExpression);
			try {

				beganDate = format.parse(creatTime);
				endDate = format.parse(endTime);
				Map<String, Integer> args = new HashMap<String, Integer>();
				args.put("csid", info.getCsid());
				List<String> keyname = new ArrayList<String>();
				keyname.add("csid");
				JobManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, riskCheckJob, keyname, args, cronExpression, beganDate, endDate);

			} catch (Exception e) {
				log.error("==========Exception form RiskCheckJob===========");
				log.error("quarz报错", e);
				throw new BLException("IGRIS0201.E001", "SchedulerException");
			}
		}
		// 启用状态停用策略
		else {
			chtb.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE);
			try {
				JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
			} catch (SchedulerException e) {
				log.error("==========Exception form RiskCheckJob===========");
				log.debug(e.getMessage());
				log.debug("quarz启动报错", e);
				throw new BLException("", "SchedulerException");
			}
		}
		checkStrategyBL.updateCheckStrategy(chtb);
	}

	/**
	 * 复制属性
	 * 
	 * @param csTb
	 * @param form
	 * @return
	 */
	private CheckStrategyTB copyPropertie(CheckStrategyTB csTb, IGRIS0202Form form) {
		// TODO Auto-generated method stub
		// csTb.setCsid(100);
		csTb.setCsname(form.getRcname());
		csTb.setCsdesc(form.getRccommon());
		// 设置为启用
		csTb.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE);
		csTb.setCsstartdate(form.getRcstartdate());
		csTb.setCsenddate(form.getRcenddate());
		csTb.setCsfrequency(form.getRcfrequency());
		// 设置检查方式
		csTb.setCsrtestmode(form.getRcrtestmode());
		// 设置重要程度
		csTb.setCstype(form.getRctype());
		csTb.setCscron(form.getRccron());
		// 设置责任人id
		csTb.setCsuserid(form.getRcuserid());
		csTb.setCsusername(form.getRcusername());
		// 设置责任组id
		if (form.getRcroleid() != null && !(form.getRcroleid().equals(""))) {
			csTb.setCsroleid(form.getRcroleid().toString());
		}
		csTb.setCsrolename(form.getRcrolename());
		// 设置合作责任人id
		csTb.setCsasset(form.getCiiopid());
		csTb.setCsassetname(form.getCiiop());
		// 设置合作责任组id
		csTb.setCsassetorgid(form.getCogid());
		csTb.setCsassetorgname(form.getCog());
		csTb.setCsattch(form.getRcattch());
		csTb.setCsoption(form.getRcrtestmode());// 检查方式设定
		return csTb;
	}

	/**
	 * <p>
	 * Description: 检查项频率内容
	 * </p>
	 */

	public String getfrequencydesc(String periodType, String startDate, String desc) {

		Map<String, String> weeksMap = new HashMap<String, String>();
		weeksMap.put("MON", "一");
		weeksMap.put("TUE", "二");
		weeksMap.put("WED", "三");
		weeksMap.put("THU", "四");
		weeksMap.put("FRI", "五");
		weeksMap.put("SAT", "六");
		weeksMap.put("SUN", "日");
		String period = null;
		String datetime = startDate.split("/")[2].trim();
		if ("week".equals(periodType)) {
			StringBuffer desc1 = new StringBuffer();
			String weeks[] = desc.split(",");
			for (int i = 0; i < weeks.length; i++) {
				desc1.append(weeksMap.get(weeks[i]));
				if (i < weeks.length - 1) {
					desc1.append("，");
				}
			}
			period = "每周" + desc1 + datetime.split(" ")[1].trim();
		} else if ("month".equals(periodType)) {
			// period = "月" + Integer.valueOf(startDate.split("/")[2].trim()) +
			// "日  ";
			period = "每月" + desc + "日" + datetime.split(" ")[1].trim();
		} else if ("once".equals(periodType)) {
			period = startDate;
			return period;
		} else if ("day".equals(periodType)) {
			period = "每日" + datetime.split(" ")[1].trim();
		} else if ("quarter".equals(periodType)) {
			// period = "三个月" + Integer.valueOf(startDate.split("/")[2].trim())
			// + "日  ";
			period = startDate.split(" ")[0].trim() + "日开始季度第一个" + datetime.split(" ")[0].trim() + "日" + datetime.split(" ")[1].trim();
		}
		// 增加频率每年，每半年 20121024 崔学志
		else if ("year".equals(periodType)) {
			period = "每年" + startDate.split("/")[1].trim() + "月" + startDate.split("/")[2].trim().substring(0, 2) + "日" + datetime.split(" ")[1].trim();
		} else if ("halfyear".equals(periodType)) {
			period = startDate.split(" ")[0].trim() + "日开始每半年第一个" + datetime.split(" ")[0].trim() + "日" + datetime.split(" ")[1].trim();
		}
		return period;

	}

	/**
	 * <p>
	 * Description: 风险检查登记初始化
	 * </p>
	 */
	public IGRIS02DTO dispRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========风险检查登记初始化处理开始========");
		// 周集合
		List<IGRIS02022VO> weekList = new ArrayList<IGRIS02022VO>();
		IGRIS02022VO week1vo = new IGRIS02022VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("周一");
		weekList.add(week1vo);
		IGRIS02022VO week2vo = new IGRIS02022VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("周二");
		weekList.add(week2vo);
		IGRIS02022VO week3vo = new IGRIS02022VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("周三");
		weekList.add(week3vo);
		IGRIS02022VO week4vo = new IGRIS02022VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("周四");
		weekList.add(week4vo);
		IGRIS02022VO week5vo = new IGRIS02022VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("周五");
		weekList.add(week5vo);
		IGRIS02022VO week6vo = new IGRIS02022VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("周六");
		weekList.add(week6vo);
		IGRIS02022VO week7vo = new IGRIS02022VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("周日");
		weekList.add(week7vo);
		// 每月天数集合
		List<IGRIS02022VO> monthList = new ArrayList<IGRIS02022VO>();
		;
		for (int i = 1; i < 31; i++) {
			// 天
			String dayvalue = String.valueOf(i);
			// 是否已选择
			IGRIS02022VO monthvo = new IGRIS02022VO();
			monthvo.setDayvalue(dayvalue);
			monthList.add(monthvo);
		}
		dto.setWeekList(weekList);
		dto.setMonthList(monthList);
		log.debug("========风险检查登记初始化处理终了========");

		return dto;
	}

	public IGRIS02DTO sel(IGRIS02DTO dto) {

		CheckworkInfoResultSearchCondImpl checkCond = new CheckworkInfoResultSearchCondImpl();

		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();

		if (dto.getIgRIS0202Form() != null) {
			checkCond.setCwrid(dto.getIgRIS0202Form().getCwrid());
			cond.setRcclass(dto.getIgRIS0202Form().getRcclass());
			cond.setRcusername(dto.getIgRIS0202Form().getRcusername());
			cond.setCiiop(dto.getIgRIS0202Form().getCiiop());
			cond.setRcapprovetime(dto.getIgRIS0202Form().getRcapprovetime());
			cond.setRcrplandate_from(dto.getIgRIS0202Form().getRcrplandate_from());
			cond.setRcrplandate_to(dto.getIgRIS0202Form().getRcrplandate_to());
			// if("1".equals(dto.getIgRIS0202Form().getIsNull())){
			// cond.setRcruserid_isNull("1");
			// cond.setRcrrealtime_isNull("1");
			// }
		}
		if (dto.getIgRIS0203Form() != null) {
			cond.setRcclass(dto.getIgRIS0203Form().getRcclass());
			cond.setRcusername(dto.getIgRIS0203Form().getRcusername());
			cond.setCiiop(dto.getIgRIS0203Form().getCiiop());
			// cond.setRcapprovetime(dto.getIgRIS0203Form().getRcapprovetime());
			cond.setRcrplandate_from(dto.getIgRIS0203Form().getRcrplandate_from());
			cond.setRcrplandate_to(dto.getIgRIS0203Form().getRcrplandate_to());
			// cond.setRcruserid_isNull("1");
			// cond.setRcrrealtime_isNull("1");
		}
		// 文档信息查询件数取得
		// int totalCount = this.riskCheckResultBL.getSearchCount(cond);
		int totalCount = this.checkworkInfoResultBL.getSearchCount(checkCond);

		if (totalCount == 0) {
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		Map<Integer, List<RiskCheckResult>> map = new HashMap<Integer, List<RiskCheckResult>>();
		List<RiskCheckResult> list = new ArrayList<RiskCheckResult>();
		List<CheckworkInfoResultInfo> infoResultInfos = this.checkworkInfoResultBL.searchCheckworkInfoResult(checkCond, 0, 0);
		// List<CheckworkInfoResultInfo> infoResultInfos =
		// this.checkworkInfoResultBL.searchCheckworkInfoResult(checkCond,pDto.getFromCount(),
		// pDto.getPageDispCount());
		int cidx = 0;
		int index = 0;
		int num = 0;
		for (int i = 0; i < infoResultInfos.size(); i++) {
			cond.setRcrid(infoResultInfos.get(i).getRcrid());
			List<RiskCheckResult> listRiskCheck = this.riskCheckResultBL.sel(cond, 0, 0);
			if (listRiskCheck != null && listRiskCheck.size() > 0) {
				RiskCheckResultTB rctb = (RiskCheckResultTB) SerializationUtils.clone(listRiskCheck.get(0));
				if (rctb.getRiskCheck() == null) {
					rctb.setRiskCheck(new RiskCheckTB());
				}
				list.add(rctb);
				index++;
				if (index == pDto.getPageDispCount()) {
					map.put(cidx, list);
					cidx++;
					list = new ArrayList<RiskCheckResult>();
					index = 0;
				}
				num++;
			}

		}
		if (list.size() > 0) {
			map.put(cidx, list);
		}

		int currentFrom = 0;
		if (pDto.getFromCount() > 0) {
			currentFrom = pDto.getFromCount() / 12;
		}

		dto.setRiskCheckResultDataList(map.get(currentFrom));
		pDto.setTotalCount(num);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;

	}

	/**
	 * 查询检查项
	 */
	public IGRIS02DTO selPoint(IGRIS02DTO dto) {
		log.debug("========风险检查查询处理开始========");
		IGRIS0201Form form = dto.getIgRIS0201Form();
		RiskCheckSearchCondImpl cond = new RiskCheckSearchCondImpl();
		cond.setRcname_q(form.getRcname_q());
		cond.setRcstatus(form.getRcstatus());
		cond.setRccategory(form.getRccategory());
		cond.setRcrolename(form.getRcrolename());
		cond.setRcusername(form.getRcusername());
		cond.setRcfrequency(form.getRcfrequency());
		cond.setRcclass(form.getRcclass());

		CheckInfoRiskSearchCondImpl condInfo = new CheckInfoRiskSearchCondImpl();
		if (dto.getCsid() != null && !(dto.getCsid().equals("0"))) {
			condInfo.setCsid(dto.getCsid());
		}
		// 查询记录总数
		// int totalCount = this.riskCheckBL.getSearchCount(cond);
		int totalCount = this.checkInfoRiskBL.getSearchCount(condInfo);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 查询出所有检查项ID
		List<CheckInfoRiskInfo> checkInfoList = this.checkInfoRiskBL.searchCheckInfoRisk(condInfo, 0, 0);
		Integer[] rcid_in = new Integer[totalCount];
		for (int i = 0; i < checkInfoList.size(); i++) {
			rcid_in[i] = checkInfoList.get(i).getRcid();
		}
		cond.setRcid_in(rcid_in);
		// 调用DAO接口查询
		List<RiskCheck> riskCheckList = this.riskCheckBL.searchRiskCheck(cond, pDto.getFromCount(), pDto.getPageDispCount());
		if (riskCheckList != null) {
			pDto.setTotalCount(riskCheckList.size());
		}

		User user = dto.getUser();// 当前用户
		UserRoleVWSearchCondImpl usercond = new UserRoleVWSearchCondImpl();
		usercond.setUserid(user.getUserid());
		// 取得当前用户所具有的角色
		List<UserRoleInfo> rolelist = this.userRoleBL.searchUserRoleVW(usercond, 0, 0);
		// 信息安全岗直接返回所有数据
		for (int i = 0; i < rolelist.size(); i++) {
			if (rolelist.get(i).getRoleid() == 1127 || rolelist.get(i).getRoleid() == 1121) {
				dto.setRiskCheckDataList(riskCheckList);
				return dto;
			}
		}
		if (riskCheckList != null && riskCheckList.size() > 0) {
			List<RiskCheck> rcrlist = new ArrayList<RiskCheck>();
			boolean flag = false;
			for (RiskCheck rcr : riskCheckList) {
				flag = false;
				RiskCheckTB rc = (RiskCheckTB) rcr;
				for (UserRoleInfo uri : rolelist) {
					if (rc != null && uri != null) {
						// 判断当前用户具有的角色是否与风险检查责任组的角色相同
						if (uri.getRoleid() != null && rc.getRcroleid() != null && !"".equals(rc.getRcroleid())) {
							if (uri.getRoleid().equals(Integer.valueOf(rc.getRcroleid()))) {
								flag = true;
								break;
							} else if (user.getUserid().equals(rc.getCiiopid())) {// 在不是风险检查责任组的角色时判断当前用户是否是合作执行人ID以确保分支逻辑正确执行
								flag = true;
								break;
							}
						}
					}

				}
				if (flag) {
					rcrlist.add(rcr);
				}
			}
			if (rcrlist != null && rcrlist.size() > 0) {
				dto.setRiskCheckDataList(rcrlist);
			}

		}
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========风险检查查询处理终了========");
		return dto;
	}

	/**
	 * 复制检查策略
	 */
	public IGRIS02DTO copyCheckStrategyStatusAction(IGRIS02DTO dto) throws BLException {
		// TODO Auto-generated method stub
		Integer csid = 0;
		csid = dto.getIgRIS0202Form().getCsid();
		List<RiskCheck> list = new ArrayList<RiskCheck>();

		CheckStrategyInfo checkStrategyInfo = this.checkStrategyBL.searchCheckStrategyByPK(csid);

		CheckStrategyTB checkStrategytb = new CheckStrategyTB();

		copyProperties(checkStrategytb, checkStrategyInfo);
		checkStrategytb.setCsid(0);
		// 复制检车策略
		CheckStrategyInfo checkStrategyInfo2 = this.checkStrategyBL.registCheckStrategy(checkStrategytb);

		CheckInfoRiskSearchCondImpl cond = new CheckInfoRiskSearchCondImpl();
		cond.setCsid(csid);
		// 查询所有的检查策略关联检查项数据
		List<CheckInfoRiskInfo> checkRiskList = this.checkInfoRiskBL.searchCheckInfoRisk(cond, 0, 0);
		for (int i = 0; i < checkRiskList.size(); i++) {

			CheckInfoRiskTB tb = (CheckInfoRiskTB) checkRiskList.get(i);

			RiskCheckTB riskTB = (RiskCheckTB) this.riskCheckBL.searchRiskCheckByKey(tb.getRcid());

			RiskCheckTB riskTb2 = new RiskCheckTB();

			copyProperties(riskTb2, riskTB);
			riskTb2.setRcid(0);
			// 复制检查项
			RiskCheck riskTB2 = this.riskCheckBL.registRiskCheck(riskTb2);

			CheckInfoRiskTB tb2 = new CheckInfoRiskTB();
			// 更新检查策略关联检查项表数据
			tb2.setCsid(checkStrategyInfo2.getCsid());
			tb2.setRcid(riskTB2.getRcid());
			// 复制检查策略关联检查项数据
			this.checkInfoRiskBL.registCheckInfoRisk(tb2);
			list.add(riskTB2);
		}

		// //获取检查工作
		// CheckWorkResultSearchCondImpl checkCond = new
		// CheckWorkResultSearchCondImpl();
		// checkCond.setCsid(csid);
		// List<CheckWorkResultInfo> resultInfoList =
		// this.checkWorkResultBL.searchCheckWorkResult(checkCond, 0, 0);
		//
		// CheckWorkResultTB checkTB = (CheckWorkResultTB)
		// resultInfoList.get(0);
		//
		// CheckWorkResultTB resultTB = new CheckWorkResultTB();
		// copyProperties(resultTB, checkTB);
		// resultTB.setCwrid(0);
		// //复制检查工作
		// CheckWorkResultInfo checkWorkResultInfo =
		// checkWorkResultBL.registCheckWorkResult(resultTB);
		dto.setRiskCheckList(list);
		dto.setCsid(checkStrategyInfo2.getCsid());
		// dto.setCwrid(checkWorkResultInfo.getCwrid());
		return dto;
	}

	/**
	 * 功能：根据检查策略id查询检查策略
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 *             修改记录：null
	 */
	public IGRIS02DTO searchCheckStrategyByCsid(IGRIS02DTO dto) throws BLException {
		CheckStrategyInfo checkStrategyInfo = checkStrategyBL.searchCheckStrategyByPK(dto.getIgRIS0202Form().getCsid());
		dto.setCheckStrategyInfo(checkStrategyInfo);
		CheckInfoRiskSearchCondImpl cond = new CheckInfoRiskSearchCondImpl();
		IGRIS0202Form form = dto.getIgRIS0202Form();

		cond.setCsid(dto.getIgRIS0202Form().getCsid());
		StringBuffer eiids = new StringBuffer();
		StringBuffer einames = new StringBuffer();
		StringBuffer eiversions = new StringBuffer();
		StringBuffer eidesc = new StringBuffer();
		StringBuffer eimode = new StringBuffer();
		StringBuffer rcommon = new StringBuffer();
		StringBuffer eistatus = new StringBuffer();

		List<RiskCheck> riskChecks = new ArrayList<RiskCheck>();

		List<CheckInfoRiskInfo> checkList = checkInfoRiskBL.searchCheckInfoRisk(cond, 0, 0);
		if (checkList != null && checkList.size() > 0) {
			for (int i = 0; i < checkList.size(); i++) {
				Integer rcid = checkList.get(i).getRcid();
				RiskCheck riskCheck = riskCheckBL.searchRiskCheckByKey(rcid);
				// eiid取得
				eiids.append(riskCheck.getRcasset());
				// einame 取得
				einames.append(riskCheck.getRcassetname());
				// eiversion取得
				eiversions.append(riskCheck.getRcassetversion());
				// 检查项分类取得
				if (riskCheck.getRcclass() != null) {
					if (riskCheck.getRcclass().equals("1")) {
						eimode.append("机房");
					} else if (riskCheck.getRcclass().equals("2")) {
						eimode.append("网络");
					} else if (riskCheck.getRcclass().equals("3")) {
						eimode.append("系统");
					} else if (riskCheck.getRcclass().equals("4")) {
						eimode.append("桌面安全");
					} else if (riskCheck.getRcclass().equals("5")) {
						eimode.append("访问控制");
					} else if (riskCheck.getRcclass().equals("6")) {
						eimode.append("开发");
					} else if (riskCheck.getRcclass().equals("7")) {
						eimode.append("其他");
					}
				}
				eidesc.append(riskCheck.getRcdesc());
				rcommon.append(riskCheck.getRccommon());
				if (riskCheck.getRcstatus().equals("0")) {
					eistatus.append("停用");
				} else {
					eistatus.append("启用");
				}
				riskChecks.add(riskCheck);

				if (i < checkList.size() - 1) {
					eiids.append(",");
					einames.append(",");
					eiversions.append(",");
					eimode.append(",");
					eidesc.append(",");
					rcommon.append(",");
					eistatus.append(",");
				}
			}
		}

		dto.getIgRIS0202Form().setEiids(eiids.toString());
		dto.getIgRIS0202Form().setEinames(einames.toString());
		dto.getIgRIS0202Form().setEiversions(eiversions.toString());
		dto.getIgRIS0202Form().setEidesc(eidesc.toString().replaceAll("\r", " ").replaceAll("\n", " "));
		dto.getIgRIS0202Form().setRiskitem(eimode.toString());
		dto.getIgRIS0202Form().setEistatus(eistatus.toString());
		dto.getIgRIS0202Form().setRcommon(rcommon.toString().replaceAll("\r", " ").replaceAll("\n", " "));

		Map<String, List<RiskCheck>> map = new LinkedHashMap<String, List<RiskCheck>>();
		Map<Integer, String> mapType = new LinkedHashMap<Integer, String>();
		int i = 0;

		// map(key,value) 检查分类 检查集合
		for (RiskCheck info : riskChecks) {
			if (map.get(info.getRcclass()) == null) {
				map.put(info.getRcclass(), new ArrayList<RiskCheck>());
				mapType.put(i, info.getRcclass());
				i++;
			}
			map.get(info.getRcclass()).add(info);
		}
		dto.setRiskCheckmap(map);
		dto.setMapType(mapType);
		dto.setRiskCheckList(riskChecks);
		CheckStrategyInfo csi = dto.getCheckStrategyInfo();
		form.setCsid(csi.getCsid());
		form.setRcname(csi.getCsname());
		form.setRccommon(csi.getCsdesc());
		form.setRcstartdate(csi.getCsstartdate());
		form.setRcenddate(csi.getCsenddate());
		form.setRcfrequency(csi.getCsfrequency());
		form.setRcrtestmode(csi.getCsrtestmode());
		form.setRctype(csi.getCstype());
		form.setRccron(csi.getCscron());
		// 责任人id取得
		form.setRcuserid(csi.getCsuserid());
		form.setRcusername(csi.getCsusername());
		// 责任组id取得
		if (csi.getCsroleid() != null && !(csi.getCsroleid().equals(""))) {
			form.setRcroleid(Integer.parseInt(csi.getCsroleid()));
		}
		form.setRcrolename(csi.getCsrolename());
		// 合作责任组
		form.setCogid(csi.getCsassetorgid());
		form.setCog(csi.getCsassetorgname());
		// 合作责任人
		form.setCiiopid(csi.getCsasset());
		form.setCiiop(csi.getCsassetname());
		form.setRcattch(csi.getCsattch());
		System.out.println(form.getRcrtestmode());
		// form.setRcrtestmode(csi.getCsoption());
		return dto;
	}

	/**
	 * 功能：批量发起检查工作指派流程
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO batchFlowAction(IGRIS02DTO dto) throws BLException {
		log.debug("==============变更批量处理操作开始===============");
		IGRIS0203Form igris0203Form = dto.getIgRIS0203Form();
		User user = dto.getUser();
		Integer roleid = getInitRoleid();
		Integer[] rcrids = igris0203Form.getRcrids();
		Integer[] prids = new Integer[rcrids.length];
		for (int i = 0; i < rcrids.length; i++) {
			RiskCheckResult result = riskCheckResultBL.searchRiskCheckResultByKey(rcrids[i]);
			WorkFlowLog workFlowLog = new WorkFlowLog();
			workFlowLog.setExecutorid(user.getUserid());// 处理人ID
			workFlowLog.setExecutorRoleid(3029);
			// workFlowLog.setAuthuserid(user.getUserid());
			Map<String, String> formvalue = new HashMap<String, String>();
			// userRoleBL.searchUserRoleByKey(user.getUserid().tos);
			formvalue.put("检查方法", result.getRccommon());
			formvalue.put("处理人", user.getUsername());
			formvalue.put("分派标示", "1");
			formvalue.put("人员", "" + "#" + result.getRcrusername() + "#" + rcrids[i].toString());
			ProcessRecord process = new ProcessRecord(workFlowLog);
			// process.setDefstatus("Z");

			process.setCrtuserid(user.getUserid());// 发起人ID
			process.setTitle(result.getRcname());// 标题
			IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
			cond380.setPdid_like("01140");
			List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);
			process.setDefid(list380.get(list380.size() - 1).getPdid());
			process.setRoleid(3029);
			// process.setDefstatus("Z");
			process.setFormvalue(formvalue);
			process.setDescription(result.getRcdesc());// 描述
			Integer prid = flowOptBL.initProcessAction(process);
			prids[i] = prid;
			workFlowLog.setPrid(prid);
			// flowSetBL.setProcessLog(workFlowLog, "",
			// Constants.PROCESS_LOG_TYPE_PROCESSING);
			RiskCheckResultTB tb = (RiskCheckResultTB) result;
			tb.setAssignprid(prid);
			riskCheckResultBL.updateRiskCheckResult(tb);
		}
		igris0203Form.setPrids(prids);
		log.debug("==============变更批量处理操作结束===============");
		dto.setIgRIS0203Form(igris0203Form);
		return dto;
	}

	/**
	 * 变更批量处理页面初始化操作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO initIGRIS0402Action(IGRIS02DTO dto) throws BLException {
		log.debug("=================变更批量处理页面初始化操作开始================");
		if (dto.getIgRIS0203Form() != null) {
			// dto参数取得
			IGRIS0203Form form = (IGRIS0203Form) dto.getIgRIS0203Form();
			IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
			cond380.setPdid_like("01140");
			List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);
			// 可被分派节点查询
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(list380.get(list380.size() - 1).getPdid() + "001", "10");
			/*
			 * for(int i = 0;i<lst_ProcessStatusDef.size();i++){
			 * if(lst_ProcessStatusDef.get(i).getPsdname()!=null &&
			 * lst_ProcessStatusDef.get(i).getPsdname().equals("标准变更执行")){
			 * lst_ProcessStatusDef.remove(i); } }
			 */
			Map<IG333Info, Map<Role, List<UserInfo>>> map = new LinkedHashMap<IG333Info, Map<Role, List<UserInfo>>>();
			for (IG333Info psd : lst_ProcessStatusDef) {
				map.put(psd, new LinkedHashMap<Role, List<UserInfo>>());
				// 查询可分派角色
				List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
				for (IG298Info psrd : lst_ProcessStatusRoleDef) {
					UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
					userInfoCond.setRoleida(psrd.getRoleid());
					if (IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
						userInfoCond.setOrgida(dto.getUser().getOrgid());
					}
					map.get(psd).put(psrd.getRole(), userBL.searchUserInfo(userInfoCond));
				}
			}
			dto.setAssignInfo(map);
		}
		log.debug("=================变更批量处理页面初始化操作结束================");
		return dto;
	}

	/**
	 * 变更批量
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO assignAction(IGRIS02DTO dto) throws BLException {
		log.debug("================变更批量操作开始===============");
		if (dto.getIgRIS0203Form() != null) {
			// dto参数取得
			IGRIS0203Form form = (IGRIS0203Form) dto.getIgRIS0203Form();
			User user = dto.getUser();
			if (form.getPrids() != null && form.getPrids().length > 0) {
				// 可被分派节点查询
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(form.getPrstatus(), form.getButtonCode());
				for (Integer prid : form.getPrids()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
					// 获取用户处理角色
					UserRoleInfo ur = this.workFlowOperationBL.getUserRolesInProcessParticipants(prid, user.getUserid(), pr.getPrpdid() + form.getPrstatus().substring(7)).get(0);
					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(ur.getRoleid());
					// 删除原来节点参与者
					StatusParticipant participant = new StatusParticipant(logInfo);

					for (IG333Info psd : lst_ProcessStatusDef) {
						participant.setStatuscode(psd.getPsdid());
						flowSetBL.deleteStatusParticipant(participant);
					}
					if (form.getParticipants() != null) {
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							participant.setStatuscode(info[0]);
							participant.setRoleid(Integer.valueOf(info[1]));
							participant.setUserid(info[2]);
							flowSetBL.setStatusParticipant(participant);
						}
					}
					// 跃迁流程
					flowOptBL.transitionProcess(prid, user.getUserid(), form.getButtonName(), IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================变更批量操作结束===============");
		return dto;
	}

	/**
	 * 获取发起角色ID
	 * 
	 * @return 发起角色ID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		// 获取具有"季报发起"菜单的角色ID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname("ACT04RIS0302");
		List<RoleAction> lst_RoleAction = this.roleActionBL.searchRoleAction(cond);
		if (lst_RoleAction.isEmpty()) {
			throw new BLException("IGCO10000.E004", "填报发起角色");
		}
		return lst_RoleAction.get(0).getRoleid();
	}

}
