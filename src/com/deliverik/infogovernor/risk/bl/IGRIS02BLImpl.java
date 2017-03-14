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
 * ���ռ��ҵ���߼�ʵ��
 * 
 */
public class IGRIS02BLImpl extends BaseBLImpl implements IGRIS02BL {

	static Log log = LogFactory.getLog(IGRIS02BLImpl.class);

	/** ���ռ����ϢBL */
	protected RiskCheckBL riskCheckBL;

	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	/** ���̴�����API */
	protected FlowOptBL flowOptBL;

	/** ������API */
	protected FlowSetBL flowSetBL;

	protected FlowSearchBL flowSearchBL;

	/** ƽ̨�û�BL */
	protected UserBL userBL;

	/** ���ռ����ϢBL */
	protected RiskCheckResultBL riskCheckResultBL;

	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;

	protected RiskAuditDefBL riskAuditDefBL;

	protected AuditCheckRelationBL auditCheckRelationBL;

	protected UserRoleBL userRoleBL;

	/** ������BL */
	protected CheckStrategyBL checkStrategyBL;

	/** �����Թ����ʲ�BL */
	protected CheckInfoEntityBL checkInfoEntityBL;

	/** ��������������BL */
	protected CheckworkInfoResultBL checkworkInfoResultBL;

	/** �������BL */
	protected CheckWorkResultBL checkWorkResultBL;

	/** ��鹤�����������BL */
	protected CheckInfoRiskBL checkInfoRiskBL;

	protected SOC0107BL soc0107BL;

	protected AttachmentBL attachmentBL;

	protected SysManageBL sysManageBL;

	/** �ʲ���ϢBL */
	protected SOC0118BL soc0118BL;

	protected RoleActionBL roleActionBL;

	/** ����BL */
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
	 * ���̲�ѯ����API����
	 * 
	 * @param sysManageBL
	 *            ���̲�ѯ����API
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
	 * �ʲ���ϢBL�趨
	 * 
	 * @param soc0118bl
	 *            �ʲ���ϢBL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * ����BL�趨
	 * 
	 * @param ig380bl
	 *            ig380BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * <p>
	 * Description: �趨quartzִ�����ڱ��ʽ
	 * </p>
	 */
	private String creatCronExp(String periodType, String exeHour, String exeMinute, String qjcrttime, String frequency) {
		String retCronExp = null;
		// �� �� ʱ �� �� �� ��
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
			// ÿ�����һ��
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + "L" + " * ?";
		}
		// �l�� �� 20121023

		else if ("year".equals(periodType)) {
			String day = qjcrttime.split("/")[2];
			String day1 = day.split(" ")[0];
			String month = qjcrttime.split("/")[1];
			retCronExp = "0 " + exeMinute + " " + exeHour + " " + day1 + " " + month + " ?";
		}
		// �l�ʰ���20121023
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
	 * Description: ����quartzִ�����ڱ��ʽ
	 * </p>
	 */
	public String getCronInfo(String periodType, String startDate) {
		String period = null;
		if ("week".equals(periodType)) {
			period = "��" + this.getWeekOfDate(startDate, null) + " ";
		} else if ("month".equals(periodType)) {
			period = "��" + Integer.valueOf(startDate.split("/")[2].trim()) + "��  ";
		} else if ("once".equals(periodType)) {
			period = startDate;
			return period;
		} else if ("day".equals(periodType)) {
			period = "��";
		} else if ("quarter".equals(periodType)) {
			period = "������" + Integer.valueOf(startDate.split("/")[2].trim()) + "��  ";
		} else if ("year".equals(periodType)) {
			period = "��" + startDate.split("/")[1].trim() + "��" + startDate.split("/")[2].trim().substring(0, 2) + "��";
		} else if ("halfyear".equals(periodType)) {
			period = "����" + Integer.valueOf(startDate.split("/")[2].trim()) + "��  ";
		}
		return "ÿ" + period;

	}

	/**
	 * <p>
	 * Description: ȡ�ô������������ڼ�
	 * </p>
	 */
	private String getWeekOfDate(String strDate, String language) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String[] weekDays = { "������", "����һ", "���ڶ�", "������", "������", "������", "������" };
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
	 * Description: �޸ķ��ռ��job
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
	 * Description: ��ʼ������Ӧ�ý��еķ��ռ��
	 * </p>
	 */
	public void initRiskCheckResult(IGRIS02DTO dto) throws BLException {

		CheckStrategyInfo info = checkStrategyBL.searchCheckStrategyByPK(dto.getCsid());

		// ����������
		CheckWorkResultTB resultTB = new CheckWorkResultTB();
		resultTB.setCwrid(100);

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		resultTB.setCwrname(info.getCsname() + format.format(new Date()));
		resultTB.setCsid(info.getCsid());
		resultTB.setCwrplandate(info.getCsstartdate());
		// ��鷽ʽ�趨
		resultTB.setCwrtestmode(info.getCsrtestmode());
		resultTB.setCwruserid(info.getCsuserid());
		resultTB.setCwrrate("0");
		resultTB.setCwrusername(info.getCsusername());
		resultTB.setCwrassetid(info.getCsasset());
		resultTB.setCwrassetname(info.getCsassetname());
		CheckWorkResultInfo cwInfo = checkWorkResultBL.registCheckWorkResult(resultTB);
		// ����������

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
			String nowdatetime = IGStringUtils.getCurrentDateTime();// �������ڣ���/��/��
																	// ʱ�֣�

			RiskCheckResultTB rcrTB = new RiskCheckResultTB();
			rcrTB.setRcruserid(cwInfo.getCwruserid());
			rcrTB.setRcrusername(cwInfo.getCwrusername());
			rcrTB.setRcid(rc.getRcid());
			rcrTB.setRcrplandate(nowdatetime);
			rcrTB.setRctype(rc.getRctype());// ���ռ����Ҫ�̶�
			rcrTB.setRcrnextdate(null);// �´�ִ�м��ʱ��
			// ��������˵��
			rcrTB.setRccommon(rc.getRccommon());
			// ������������
			rcrTB.setRcname(rc.getRcname());
			// ������������
			rcrTB.setRcdesc(rc.getRcdesc());
			// ������������
			rcrTB.setRcrclass(rc.getRcclass());
			RiskCheckResult rcrInfo = this.riskCheckResultBL.registRiskCheckResult(rcrTB);

			// ����������������
			CheckworkInfoResultTB checkWorkResultTB = new CheckworkInfoResultTB();
			checkWorkResultTB.setRcrid(rcrInfo.getRcrid());
			checkWorkResultTB.setCwrid(cwInfo.getCwrid());
			checkworkInfoResultBL.registCheckworkInfoResult(checkWorkResultTB);
		}
	}

	/**
	 * <p>
	 * Description: ���ռ������
	 * </p>
	 */
	public IGRIS02DTO insertRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ����������ʼ========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		AttachmentTB attachment = new AttachmentTB();
		String attkey = IGStringUtils.getAttKey();// ����id
		attachment.setAttkey(attkey);

		// �ϴ��ļ����
		Map<Integer, FormFile> filemap = form.getFileMap();
		Iterator<Integer> iterator = filemap.keySet().iterator();
		while (iterator.hasNext()) {
			FormFile file = (FormFile) filemap.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();

				// ��Ŀ¼
				pathBuf.append(rootPath);
				// ��ǰģ��Ŀ¼
				pathBuf.append("risk");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// �ļ��ϴ�����
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}

				// �ϴ��ļ�������
				attachment.setAttname(attkey + "_" + fileName.toString());
				// �ϴ��ļ���URL
				attachment.setAtturl("risk");

				this.attachmentBL.registAttachment(attachment);

			}
		}
		// ���Ƶ��
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// Ƶ��Ϊ��
			for (String week : form.getRcfrequencyweek()) {
				if (StringUtils.isEmpty(frequency)) {
					frequency = week;
				} else {
					frequency = frequency + "," + week;
				}
			}
		} else if ("month".equals(form.getRcfrequency())) {
			if (form.getRcfrequencymonth() != null) {
				// Ƶ��Ϊ��
				for (String month : form.getRcfrequencymonth()) {
					if (StringUtils.isEmpty(frequency)) {
						frequency = month;
					} else {
						frequency = frequency + "," + month;
					}
				}
			}
		}

		// �� , ����ַ���,�õ�һ������
		String[] startdate = form.getRcstartdate().split("\\ ");
		String starttime = startdate[1];
		String[] begindate = starttime.split("\\:");
		// ʱ
		String exeHour = begindate[0];
		// ��
		String exeMinute = begindate[1];
		// ȡ��ִ�����ڱ��ʽ
		String cronExpression = null;

		if (StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())) {// Ƶ��Ϊÿ�����һ��
			// ȡ��ִ�����ڱ��ʽ,���ռ��Ƶ��(ÿ�����һ��)
			if ("1".equals(form.getRcfrequencymonthlastday())) {
				// ȡ��ִ�����ڱ��ʽ
				cronExpression = this.creatCronExp(form.getRcfrequencymonthlastday(), exeHour, exeMinute, form.getRcstartdate(), null);
				frequency = "���һ";
			}
		} else {// Ƶ��Ϊ�ܡ���
			cronExpression = this.creatCronExp(form.getRcfrequency(), exeHour, exeMinute, form.getRcstartdate(), frequency);
		}
		form.setRcfrequencydesc(frequency);// ���ռ��Ƶ������
		// ����RiskCheck
		form.setRcstatus(IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE);// ����״̬Ϊ����
		form.setRcattch(attkey);// ����id
		form.setRccron(cronExpression);// ���ռ�����ִ�б��ʽ

		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRccreatetime(date);// ���ռ��Ǽ�ʱ��yyyy/MM/dd HH:mm
		// ��¼���ռ����Ϣ
		RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
		dto.setRiskCheck(rc);

		dto.addMessage(new ActionMessage("IGRIS0202.I001", "�������趨�ɹ�"));
		log.debug("========���ռ��������������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ���ռ������ʼ��
	 * </p>
	 */
	public IGRIS02DTO initupdateRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ������ʼ������ʼ========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		// ���������Ҽ������ϸ��Ϣ
		RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
		form.setRcasset(rc.getRcasset());// ���ռ������ʲ�ID
		form.setRcassetname(rc.getRcassetname());// ���ռ������ʲ�����
		form.setRcattch(rc.getRcattch());// ���ռ�鸽��ID
		form.setRccron(rc.getRccron());// ���ռ�����ִ�б��ʽ
		form.setRcdesc(rc.getRcdesc());// ���ռ������
		form.setRcenddate(rc.getRcenddate());// ���ռ�����ʱ��
		form.setRcfrequency(rc.getRcfrequency());// ���ռ��Ƶ��
		form.setRcid(rc.getRcid());// ���ռ��ID
		form.setRcname(rc.getRcname());// ���ռ������
		form.setRcrtestmode(rc.getRcrtestmode());// ���ռ�鷽ʽ
		form.setRcoption(rc.getRcoption());// ���ռ��ѡ��
		form.setRcroleid(rc.getRcroleid());// ���ռ���������ɫID
		form.setRcrolename(rc.getRcrolename());// ���ռ���������ɫ��
		form.setRcstartdate(rc.getRcstartdate());// ���ռ����ʼʱ��
		form.setRcstatus(rc.getRcstatus());// ���ռ��״̬
		form.setRctype(rc.getRctype());// ���ռ������
		form.setRcuserid(rc.getRcuserid());// ���ռ��������ID
		form.setRcusername(rc.getRcusername());// ���ռ������������
		form.setRccategory(rc.getRccategory());// ���ռ�������
		form.setRccategoryname(rc.getRccategoryname());// ���ռ�����������
		form.setRccreatetime(rc.getRccreatetime());// ���ռ��Ǽ�ʱ��
		form.setRcfrequencymonthlastday(rc.getRcfrequencymonthlastday());// ���ռ��Ƶ��(ÿ�����һ��)
		form.setRcupdatetime(rc.getRcupdatetime());// ���ռ�鴦��ʱ��
		form.setRcclass(rc.getRcclass());
		form.setRccommon(rc.getRccommon());
		form.setCog(rc.getCog());
		form.setCogid(rc.getCogid());
		form.setCiiop(rc.getCiiop());
		form.setCiiopid(rc.getCiiopid());
		form.setWtip(rc.getWtip());
		String[] rcfrequency = null;
		// �� , ����ַ���,�õ�һ������
		if (StringUtils.isNotEmpty(rc.getRcfrequencydesc())) {
			rcfrequency = rc.getRcfrequencydesc().split("\\,");
		}
		// �ܼ���
		List<IGRIS02022VO> weekList = new ArrayList<IGRIS02022VO>();
		// ÿ����������
		List<IGRIS02022VO> monthList = new ArrayList<IGRIS02022VO>();
		// ��һ����������
		List<IGRIS02022VO> wList = new ArrayList<IGRIS02022VO>();
		IGRIS02022VO week1vo = new IGRIS02022VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("��һ");
		wList.add(week1vo);
		IGRIS02022VO week2vo = new IGRIS02022VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("�ܶ�");
		wList.add(week2vo);
		IGRIS02022VO week3vo = new IGRIS02022VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("����");
		wList.add(week3vo);
		IGRIS02022VO week4vo = new IGRIS02022VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("����");
		wList.add(week4vo);
		IGRIS02022VO week5vo = new IGRIS02022VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("����");
		wList.add(week5vo);
		IGRIS02022VO week6vo = new IGRIS02022VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("����");
		wList.add(week6vo);
		IGRIS02022VO week7vo = new IGRIS02022VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("����");
		wList.add(week7vo);
		// �ж�Ƶ�����
		if ("week".equals(rc.getRcfrequency())) {
			// ���ռ��Ƶ��(��)
			form.setRcfrequencyweek(rcfrequency);
			for (IGRIS02022VO vo : wList) {
				// �ж��Ƿ���ѡ��
				String ischecked = null;
				for (String st : rcfrequency) {
					if (vo.getWeekvalue().equals(st)) {
						ischecked = st;
					}
				}
				// ���ռ����Ϣ��������֣�
				IGRIS02022VO weekvo = new IGRIS02022VO();
				weekvo.setWeekdata(vo.getWeekdata());// ��������ʾ
				weekvo.setWeekvalue(vo.getWeekvalue());// Ƶ��Ϊ������
				weekvo.setIschecked(ischecked);// �Ƿ���ѡ���ʶ
				weekList.add(weekvo);
			}
			dto.setWeekList(weekList);
		} else {
			dto.setWeekList(wList);
		}

		if ("month".equals(rc.getRcfrequency())) {
			// ���ռ��Ƶ��(��)
			form.setRcfrequencymonth(rcfrequency);

		}
		for (int i = 1; i < 31; i++) {
			// ��
			String dayvalue = String.valueOf(i);
			// �ж��Ƿ���ѡ��
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
			mouthvo.setDayvalue(dayvalue);// Ƶ��Ϊ������
			mouthvo.setIschecked(ischecked);// �Ƿ���ѡ���ʶ
			monthList.add(mouthvo);
		}

		dto.setMonthList(monthList);

		// ��ѯ������Ϣ
		if (StringUtils.isNotEmpty(rc.getRcattch())) {
			List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(rc.getRcattch());
			dto.setAttachmentList(attachmentList);
		}
		form.setMode("1");// 0Ϊ���� 1Ϊ���
		dto.setRiskCheck(form);
		dto.addMessage(new ActionMessage("IGCO10000.I001", "���ռ�������Ϣ"));
		log.debug("========���ռ������ʼ����������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ���ռ����
	 * </p>
	 */
	public IGRIS02DTO updateRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ��������ʼ========");
		CheckStrategyTB csTb = (CheckStrategyTB) checkStrategyBL.searchCheckStrategyByPK(dto.getIgRIS0202Form().getCsid());
		IGRIS0202Form form = dto.getIgRIS0202Form();
		// ɾ������
		if (StringUtils.isNotEmpty(form.getPredelkey())) {
			String[] keys = form.getPredelkey().split(",");
			for (String key : keys) {
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
			form.setRcattch("");
		}
		// ���Ƶ��
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// Ƶ��Ϊ��
			for (String week : form.getRcfrequencyweek()) {
				if (StringUtils.isEmpty(frequency)) {
					frequency = week;
				} else {
					frequency = frequency + "," + week;
				}
			}
			// �����ռ��Ƶ��(ÿ�����һ��)���
			form.setRcfrequencymonthlastday(null);
		} else if ("month".equals(form.getRcfrequency())) {
			// Ƶ��Ϊ��
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
			// �����ռ��Ƶ��(ÿ�����һ��)���
			form.setRcfrequencymonthlastday(null);
		}

		// �� , ����ַ���,�õ�һ������
		String[] startdate = form.getRcstartdate().split("\\ ");
		String starttime = startdate[1];
		String[] begindate = starttime.split("\\:");
		// ʱ
		String exeHour = begindate[0];
		// ��
		String exeMinute = begindate[1];

		// ȡ��ִ�����ڱ��ʽ
		String cronExpression = null;
		if (StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())) {// Ƶ��Ϊÿ�����һ��
			// ȡ��ִ�����ڱ��ʽ,���ռ��Ƶ��(ÿ�����һ��)
			if ("1".equals(form.getRcfrequencymonthlastday())) {
				// ȡ��ִ�����ڱ��ʽ
				cronExpression = this.creatCronExp(form.getRcfrequencymonthlastday(), exeHour, exeMinute, form.getRcstartdate(), null);
				frequency = "���һ ";
			}
		} else {// Ƶ��Ϊ�ܡ���
			cronExpression = this.creatCronExp(form.getRcfrequency(), exeHour, exeMinute, form.getRcstartdate(), frequency);
		}
		form.setRcfrequencydesc(frequency);// ���ռ��Ƶ������
		form.setRccron(cronExpression);//

		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRcupdatetime(date);// ���ռ�鴦��ʱ��yyyy/MM/dd HH:mm

		form.setRccreatetime(date);// ���ռ��Ǽ�ʱ��yyyy/MM/dd HH:mm
		// ��¼���ռ����Ϣ
		// RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
		// dto.setRiskCheck(rc);
		csTb = copyPropertie(csTb, form);

		// ���¼�����
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
//		// ɾ����صļ����
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
		// �������������Ҫͨ���ʲ���eiid��eiversion��ȡ���ʲ�������
		for (int i = 0; eiids != null && i < eiids.size(); i++) {
			// ��ѯ�ʲ�����
			SOC0107SearchCondImpl soc0107cond = new SOC0107SearchCondImpl();
			IGRIS0202Form igris0202Form = dto.getIgRIS0202Form();
			soc0107cond.setEiid(eiids.get(i));
			soc0107cond.setCiversion(eiversions.get(i));
			List<SOC0107Info> soc0107InfoList = soc0107BL.searchSOC0107(soc0107cond, 0, 0);
			for (int j = 0; j < soc0107InfoList.size(); j++) {
				SOC0107Info socInfo = soc0107InfoList.get(j);
				if (socInfo.getCid().equals("CI210000000001")) {
					// ���ü��������
					igris0202Form.setRcname(socInfo.getCivalue());
					igris0202Form.setRcassetname(socInfo.getCivalue());
					igris0202Form.setRcassetversion(socInfo.getCiversion());
				} else if (socInfo.getCid().equals("CI210000000002")) {
					// ���ü����˵��
					igris0202Form.setRcdesc(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000003")) {
					// ���ü�鷽��
					igris0202Form.setRccommon(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000004")) {

				} else if (socInfo.getCid().equals("CI210000000005")) {
					// ��������
					Integer in = Integer.parseInt(socInfo.getCivalue()) - 999021000;
					igris0202Form.setRcclass(in.toString());
				}
			}
			if (eiids.get(i) != null && !(eiids.get(i).equals(""))) {
				SOC0118Info soc0118 = soc0118BL.searchEntityItemByKey(Integer.parseInt(eiids.get(i)));
				igris0202Form.setRcstatus(soc0118.getEistatus());
			}
			// ������Ӧ�ʲ�id
			igris0202Form.setRcasset(Integer.parseInt(eiids.get(i)));
			RiskCheck check = this.riskCheckBL.registRiskCheck(igris0202Form);

			// ��������Թ���������
			CheckInfoRiskTB riskTB = new CheckInfoRiskTB();
			riskTB.setCsid(info.getCsid());
			riskTB.setRcid(check.getRcid());
			checkInfoRiskBL.registCheckInfoRisk(riskTB);
			checkList.add(check);
		}
		dto.setRiskCheckList(checkList);

		dto.addMessage(new ActionMessage("IGCO10000.I003", "�������޸ĳɹ�"));
		log.debug("========���ռ������������========");
		return dto;
	}

	/**
	 * ����������ʼ������
	 * 
	 * @param dto
	 *            IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS02DTO searchRiskAuditDefAction(IGRIS02DTO dto) throws BLException {

		log.debug("========����������ʼ������ʼ========");
		IGRIS0201Form form = dto.getIgRIS0201Form();

		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		cond.setRaid(form.getRaid());
		cond.setByLevelDesc("1");

		// �ð汾�������Ϣȡ��
		List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);

		if (riskAuditDefList != null && riskAuditDefList.size() > 0) {
			// ȡ����������󼶴�
			String radMaxLevel = riskAuditDefList.get(0).getRadlevel();
			if (StringUtils.isNotEmpty(radMaxLevel)) {
				dto.setRadMaxLevel(Integer.parseInt(radMaxLevel));
				List<Integer> list = new ArrayList<Integer>();
				for (int i = 1; i <= Integer.parseInt(radMaxLevel); i++) {
					list.add(i);
				}
				dto.setRadMaxLevelList(list);
			}
			// ��ѯ�ѹ����������������Ϣ
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
			// �ð汾�������Ϣȡ��
			List<RiskAuditDef> riskAuditDefList1 = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);

			dto.setRiskAuditDefList(riskAuditDefList1);
		}

		log.debug("========����������ʼ����������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ����������
	 * </p>
	 */

	public IGRIS02DTO insertRiskAuditDefAction(IGRIS02DTO dto) throws BLException {
		IGRIS0201Form form = dto.getIgRIS0201Form();
		String[] radids = form.getRadids();
		Integer rcid = form.getRcid();
		if (radids != null) {
			// ɾ���ѱ���Ĺ���������¼
			if (rcid != null && rcid != 0) {
				AuditCheckRelationSearchCondImpl cond = new AuditCheckRelationSearchCondImpl();
				cond.setRcid(rcid);
				List<AuditCheckRelation> list = this.auditCheckRelationBL.searchAuditCheckRelation(cond, 0, 0);
				for (AuditCheckRelation acr : list) {
					this.auditCheckRelationBL.deleteAuditCheckRelation(acr.getAcrid());
				}
			}
			// �����µĹ���������¼
			for (int i = 0, j = radids.length; i < j; i++) {
				AuditCheckRelationTB acrtb = new AuditCheckRelationTB();
				acrtb.setRcid(rcid);
				acrtb.setRadid(Integer.valueOf(radids[i]));

				this.auditCheckRelationBL.registAuditCheckRelation(acrtb);
			}
			dto.addMessage(new ActionMessage("IGRIS0201.I001", "���������ɹ����"));
		}

		return dto;
	}

	/**
	 * <p>
	 * Description: ���ռ���ѯ
	 * </p>
	 */

	public IGRIS02DTO searchRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ���ѯ����ʼ========");
		IGRIS0201Form form = dto.getIgRIS0201Form();
		CheckStrategySearchCondImpl cond = new CheckStrategySearchCondImpl();
		// �趨��鷽ʽ
		cond.setCsrtestmode(form.getRcrtestmode());
		// �趨����������
		cond.setCsname(form.getRcname());
		// �趨��Ҫ�̶�
		cond.setCstype(form.getRctype());
		// �趨״̬
		cond.setCsstatus(form.getRcstatus());
		// �趨������
		cond.setCsrolename(form.getRcrolename());
		// �趨����������
		cond.setCsusername(form.getRcusername());
		// �趨Ƶ��
		cond.setCsfrequency(form.getRcfrequency());
		// ��ѯ��¼����
		int totalCount = this.checkStrategyBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<CheckStrategyInfo> checkStrategyList = this.checkStrategyBL.searchCheckStrategy(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		User user = dto.getUser();// ��ǰ�û�
		UserRoleVWSearchCondImpl usercond = new UserRoleVWSearchCondImpl();
		usercond.setUserid(user.getUserid());
		// ȡ�õ�ǰ�û������еĽ�ɫ
		List<UserRoleInfo> rolelist = this.userRoleBL.searchUserRoleVW(usercond, 0, 0);
		// ��Ϣ��ȫ��ֱ�ӷ�����������
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
						// �жϵ�ǰ�û����еĽ�ɫ�Ƿ�����ռ��������Ľ�ɫ��ͬ
						if (uri.getRoleid() != null && rc.getCsroleid() != null && !"".equals(rc.getCsroleid())) {
							if (uri.getRoleid().equals(Integer.valueOf(rc.getCsroleid()))) {
								flag = true;
								break;
							} else if (user.getUserid().equals(rc.getCsroleid())) {// �ڲ��Ƿ��ռ��������Ľ�ɫʱ�жϵ�ǰ�û��Ƿ��Ǻ���ִ����ID��ȷ����֧�߼���ȷִ��
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
		log.debug("========���ռ���ѯ��������========");
		return dto;
	}

	public IGRIS02DTO searchRiskStrategyAction(IGRIS02DTO dto) throws BLException {

		return dto;
	}

	/**
	 * <p>
	 * Description: ���ռ�����״̬
	 * </p>
	 */

	public IGRIS02DTO changeRiskCheckStatusAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ�����״̬����ʼ========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		String status = form.getRcstatus();
		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);// yyyy/MM/dd
																			// HH:mm
		if (IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE.equals(status)) {
			// ͣ��
			RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
			RiskCheckTB rctb = (RiskCheckTB) SerializationUtils.clone(rc);
			rctb.setRcstatus(form.getRcstatus());
			rctb.setRcapprovetime(date);// ����ʱ��
			rctb.setRcapprover(dto.getUser().getUsername());// ������
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
				log.debug("quarz��������", e);
				throw new BLException("", "SchedulerException");
			}
			// �ж�ÿ�����һ���Ƿ�����
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
			// ����
			RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
			RiskCheckTB rctb = (RiskCheckTB) SerializationUtils.clone(rc);
			rctb.setRcstatus(form.getRcstatus());
			rctb.setRcapprovetime(date);// ����ʱ��
			rctb.setRcapprover(dto.getUser().getUsername());// ������
			RiskCheck riskcheck = this.riskCheckBL.updateRiskCheck(rctb);
			dto.setRiskCheck(riskcheck);

			// ���Ƶ��
			String frequency = riskcheck.getRccron();
			// ȡ��ִ�����ڱ��ʽ
			String cronExpression = frequency;

			RiskCheckJob riskCheckJob = new RiskCheckJob();// ȡ��job
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
				log.error("quarz����", e);
				throw new BLException("IGRIS0201.E001", "SchedulerException");
			}
		}

		log.debug("========���ռ�����״̬��������========");
		return dto;
	}

	/**
	 * �ı������״̬
	 */
	public IGRIS02DTO changeCheckStrategyStatusAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ�����״̬����ʼ========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		String status = form.getRcstatus();
		// Date nowDateTime = new Date();
		// String date =
		// CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);// yyyy/MM/dd
		// HH:mm
		if (IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE.equals(status)) {
			// ͣ��
			CheckStrategyInfo info = this.checkStrategyBL.searchCheckStrategyByPK(form.getCsid());
			CheckStrategyTB chtb = (CheckStrategyTB) SerializationUtils.clone(info);
			chtb.setCsstatus(form.getRcstatus());
			/*
			 * chtb.setRcapprovetime(date);// ����ʱ��
			 * chtb.setRcapprover(dto.getUser().getUsername());// ������
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
				log.debug("quarz��������", e);
				throw new BLException("", "SchedulerException");
			}
		} else {
			// ����
			CheckStrategyInfo info = this.checkStrategyBL.searchCheckStrategyByPK(form.getCsid());
			CheckStrategyTB chtb = (CheckStrategyTB) SerializationUtils.clone(info);
			chtb.setCsstatus(form.getRcstatus());
			/*
			 * chtb.setRcapprovetime(date);// ����ʱ��
			 * chtb.setRcapprover(dto.getUser().getUsername());// ������
			 */
			CheckStrategyInfo checkinfo = this.checkStrategyBL.updateCheckStrategy(chtb);
			dto.setCheckInfo(checkinfo);

			// ���Ƶ��
			String frequency = checkinfo.getCscron();
			// ȡ��ִ�����ڱ��ʽ
			String cronExpression = frequency;

			RiskCheckJob riskCheckJob = new RiskCheckJob();// ȡ��job
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
				log.error("quarz����", e);
				throw new BLException("IGRIS0201.E001", "SchedulerException");
			}
		}

		log.debug("========���ռ�����״̬��������========");
		return dto;
	}

	public IGRIS02DTO changeCheckStrategyStatusOnlyAction(IGRIS02DTO dto) throws BLException {

		log.debug("========���ռ�����״̬����ʼ========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		CheckStrategyInfo info = this.checkStrategyBL.searchCheckStrategyByPK(form.getCsid());
		if (info.getCsfrequency().equals("once")) {
			CheckStrategyTB checkTB = (CheckStrategyTB) info;
			dto.setCsid(info.getCsid());
			// �������
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
	 * Description: ���ռ��鿴ҳ
	 * </p>
	 */

	public IGRIS02DTO readRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ��鿴����ʼ========");
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

		// ���ͷ��ռ����Եı��ʽ
		String cronInfo = this.getfrequencydesc(rc.getRcfrequency(), rc.getRcstartdate(), rc.getRcfrequencydesc());
		dto.setCronInfo(cronInfo);

		// ��ѯ������Ϣ
		if (StringUtils.isNotEmpty(rc.getRcattch())) {
			List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(rc.getRcattch());
			dto.setAttachmentList(attachmentList);
		}

		log.debug("========���ռ��鿴��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ���ռ�����ձ���ѯ
	 * </p>
	 */

	public IGRIS02DTO searchRiskCheckResultReportByDayAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ�����ձ���ѯ����ʼ========");
		IGRIS0204Form form = dto.getIgRIS0204Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRcrplandate(form.getRcrplandate());
		List<RiskCheckResult> list = this.riskCheckResultBL.searchRiskCheckResult(cond, 0, 0);

		// ��ѯ��¼����
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.searchRiskCheckResult(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskCheckResultDataList(rcrList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========���ռ�����ձ���ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ���ռ��׶ν����ѯ
	 * </p>
	 */

	public IGRIS02DTO searchRiskCheckResultReportByPeriodAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ��׶ν����ѯ����ʼ========");
		IGRIS0206Form form = dto.getIgRIS0206Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRccategory(form.getRccategory());
		cond.setRcid(form.getRcid());
		cond.setStartdate(form.getStartdate());
		cond.setEnddate(form.getEnddate());
		List<RiskCheckResult> list = this.riskCheckResultBL.searchRiskCheckResult(cond, 0, 0);

		// ��ѯ��¼����
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.searchRiskCheckResult(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskCheckResultDataList(rcrList);

		log.debug("========���ռ��׶ν����ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ���һ�η��ռ������ѯ(ͳ�Ʒ���ҳ��ʾʹ��)
	 * </p>
	 */

	public List<RiskCheckResult> searchLastRiskCheckResultToVo() throws BLException {
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.findResultByCond(cond, 0, 0);

		return rcrList;
	}

	/**
	 * <p>
	 * Description: ���һ�η��ռ������ѯ
	 * </p>
	 */

	public IGRIS02DTO searchLastRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���һ�η��ռ������ѯ����ʼ========");
		IGRIS0205Form IgRIS0205Form = dto.getIgRIS0205Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRcusername_like(IgRIS0205Form.getRcusername_like());// ������
		cond.setRcname_like(IgRIS0205Form.getRcname_like());// �����
		cond.setNtime_from(IgRIS0205Form.getNtime_from());// �ƻ���ʼʱ��
		cond.setNtime_to(IgRIS0205Form.getNtime_to());
		cond.setRcrresult(IgRIS0205Form.getRcrresult());// �����
		cond.setRcrstatic(IgRIS0205Form.getRcrstatic());// ���ռ��״̬
		cond.setRcrusername(IgRIS0205Form.getRcrusername());
		if (StringUtils.isNotEmpty(IgRIS0205Form.getChtype())) {
			cond.setChtype(IgRIS0205Form.getChtype());// δ��鹤����ʶ
		}
		cond.setRccategory(IgRIS0205Form.getRccategory());// ���ռ�������
		cond.setRctype_eq(IgRIS0205Form.getRctype_eq());// ��Ҫ�̶�
		// ��ѯ�û���ɫ�б�
		List<Integer> roleIds = sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		// �û���ɫ
		String roleLine = "";

		for (int roleId : roleIds) {
			roleLine += roleId + "_";
		}
		// ����û�ӵ����Ϣ��ȫ������ɫ����ȫ����ʾ;����ִ���˺���Ϣ��ȫԱ�ɲ�ѯ�Լ���
		if (roleLine.indexOf(IGRISCONSTANTS.INFORMATION_SAFETY_APPROVAL) > 0) {

		} else {
			cond.setRcrelateduser(dto.getUser().getUsername());
		}

		List<RiskCheckResult> list = this.riskCheckResultBL.findResultByCond(cond, 0, 0);

		// ��ѯ��¼����
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.findResultByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskCheckResultDataList(rcrList);

		log.debug("========���һ�η��ռ������ѯ��������========");
		return dto;
	}

	/***
	 * ��������ѯ
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

		// ��鷽ʽû��
		cond.setCwrtestmode(igRIS0205Form.getRcrtestmode());
		// �����������
		cond.setCwrname(igRIS0205Form.getRcrcomment());
		// ������
		cond.setCwrusername(igRIS0205Form.getRcusername_like());
		// ����ʼʱ��
		cond.setCwrplandate_from(igRIS0205Form.getNtime_from());
		cond.setCwrplandate_to(igRIS0205Form.getNtime_to());
		// �������ʱ��
		cond.setCwrrealtime_from(igRIS0205Form.getEtime_from());
		cond.setCwrrealtime_to(igRIS0205Form.getEtime_to());

		// ��ѯ�û���ɫ�б�
		// List<Integer> roleIds =
		// sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		// �û���ɫ
		// String roleLine = "";
		//
		// for(int roleId : roleIds){
		// roleLine += roleId + "_";
		// }

		List<CheckWorkResultInfo> list = this.checkWorkResultBL.searchCheckWorkResult(cond, 0, 0);

		// ��ѯ��¼����
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<CheckWorkResultInfo> rcrList = this.checkWorkResultBL.searchCheckWorkResult(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setCheckWorkResultInfos(rcrList);

		log.debug("========���һ�η��ռ������ѯ��������========");

		return dto;
	}

	/**
	 * <p>
	 * Description: ��鹤���ල��ѯ
	 * </p>
	 */
	public IGRIS02DTO searchSuperviseRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���һ�η��ռ������ѯ����ʼ========");
		IGRIS0205Form IgRIS0205Form = dto.getIgRIS0205Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRcusername_like(IgRIS0205Form.getRcusername_like());// ������
		cond.setRcname_like(IgRIS0205Form.getRcname_like());// �����
		cond.setNtime_from(IgRIS0205Form.getNtime_from());// �ƻ���ʼʱ��
		cond.setNtime_to(IgRIS0205Form.getNtime_to());
		cond.setRcrresult(IgRIS0205Form.getRcrresult());// �����
		cond.setRcrstatic(IgRIS0205Form.getRcrstatic());// ���ռ��״̬
		if (StringUtils.isNotEmpty(IgRIS0205Form.getChtype())) {
			cond.setChtype(IgRIS0205Form.getChtype());// δ��鹤����ʶ
		}
		cond.setRccategory(IgRIS0205Form.getRccategory());// ���ռ�������
		cond.setRctype_eq(IgRIS0205Form.getRctype_eq());// ��Ҫ�̶�
		cond.setRcclass(IgRIS0205Form.getRcclass());// ���ռ������
		// //��ѯ�û���ɫ�б�
		// List<Integer> roleIds =
		// sysManageBL.searchRoleListByUserid(dto.getUser().getUserid());
		// //�û���ɫ
		// String roleLine = "";
		//
		// for(int roleId : roleIds){
		// roleLine += roleId + "_";
		// }
		// //����û�ӵ����Ϣ��ȫ������ɫ����ȫ����ʾ;����ִ���˺���Ϣ��ȫԱ�ɲ�ѯ�Լ���
		// if(roleLine.indexOf("1127")>0){
		//
		// }else{
		// cond.setRcruserid(dto.getUser().getUserid());
		// }

		List<RiskCheckResult> list = this.riskCheckResultBL.findResultByCond(cond, 0, 0);

		// ��ѯ��¼����
		int totalCount = list == null ? 0 : list.size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<RiskCheckResult> rcrList = this.riskCheckResultBL.findResultByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);

		dto.setRiskCheckResultDataList(rcrList);

		log.debug("========���һ�η��ռ������ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ���ռ�����鿴ҳ
	 * </p>
	 */

	public IGRIS02DTO readRiskCheckResultReportAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ�����鿴����ʼ========");
		IGRIS0204Form form = dto.getIgRIS0204Form();
		RiskCheckResult rcr = this.riskCheckResultBL.searchRiskCheckResultByKey(form.getRcrid());
		dto.setRiskCheckResult(rcr);

		// ��ѯ������Ϣ
		if (StringUtils.isNotEmpty(rcr.getRcrattch())) {
			List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(rcr.getRcrattch());
			dto.setAttachmentList(attachmentList);
		}

		log.debug("========���ռ�����鿴��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ���ռ������ѯ
	 * </p>
	 */

	public IGRIS02DTO searchRiskCheckResultAction(IGRIS02DTO dto) throws BLException {

		IGRIS0203Form form = dto.getIgRIS0203Form();

		User user = dto.getUser();// ��ǰ�û�
		UserRoleVWSearchCondImpl usercond = new UserRoleVWSearchCondImpl();
		usercond.setUserid(user.getUserid());

		// ȡ�õ�ǰ�û������еĽ�ɫ
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
		// ��Ϣ��ȫ��ֱ�ӷ�����������
		for (int i = 0; i < rolelist.size(); i++) {
			if (rolelist.get(i).getRoleid() == 1127 || rolelist.get(i).getRoleid() == 1121) {
				dto.setRiskCheckResultDataList(list);
				return dto;
			}
		}
		// ȡ�õ����û��ܹ������ķ��ռ��������
		if (list != null && list.size() > 0) {
			List<RiskCheckResult> rcrlist = new ArrayList<RiskCheckResult>();
			boolean flag = false;
			for (RiskCheckResult rcr : list) {
				flag = false;
				RiskCheckTB rc = rcr.getRiskCheck();
				for (UserRoleInfo uri : rolelist) {
					if (rc != null && uri != null) {
						// �жϵ�ǰ�û����еĽ�ɫ�Ƿ�����ռ��������Ľ�ɫ��ͬ
						if (uri.getRoleid() != null && rc.getRcroleid() != null && !"".equals(rc.getRcroleid())) {
							if (uri.getRoleid().equals(Integer.valueOf(rc.getRcroleid()))) {
								flag = true;
								break;
							} else if (user.getUserid().equals(rc.getCiiopid())) {// �ڲ��Ƿ��ռ��������Ľ�ɫʱ�жϵ�ǰ�û��Ƿ��Ǻ���ִ����ID��ȷ����֧�߼���ȷִ��
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
	 * �ж�ҳ���ύ�ļ�¼�Ƿ��Ѿ��������û��ύ��
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
	 * Description: ���ռ��������
	 * </p>
	 */

	public synchronized IGRIS02DTO insertRiskCheckResultAction(IGRIS02DTO dto) throws BLException {

		IGRIS0203Form form = dto.getIgRIS0203Form();
		Integer[] rcrids = form.getRcrids();
		String[] rcrresults = form.getRcrresults();
		String[] rcrcomments = form.getRcrcomments();
		Integer[] filenum = form.getFilenum();
		User user = dto.getUser();// ��ǰ�û�
		// if(!checkRiskCheckResultStatus(form)){
		if (rcrids != null) {
			for (int i = 0, j = rcrids.length; i < j; i++) {
				RiskCheckResult rcr = this.riskCheckResultBL.searchRiskCheckResultByKey(rcrids[i]);
				RiskCheckResultTB rcrtb = (RiskCheckResultTB) SerializationUtils.clone(rcr);
				rcrtb.setRcruserid(user.getUserid());// �ύ��id
				rcrtb.setRcrusername(user.getUsername());// �ύ������
				rcrtb.setRcrrealtime(IGStringUtils.getCurrentDateTime());// �ύʱ��
				rcrtb.setRcrresult(rcrresults[i]);// ���
				rcrtb.setRcrcomment(rcrcomments[i]);// ˵��

				AttachmentTB attachment = new AttachmentTB();
				String attkey = IGStringUtils.getAttKey();// ����id
				attachment.setAttkey(attkey);

				// �ϴ��ļ����
				Map<Integer, FormFile> filemap = form.getFileMap();

				FormFile file = (FormFile) filemap.get(filenum[i]);
				if (file != null && file.getFileSize() > 0) {
					// �ϴ��ļ����ڵ����
					// �ϴ��ļ�·��
					String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();

					// ��Ŀ¼
					pathBuf.append(rootPath);
					// ��ǰģ��Ŀ¼
					pathBuf.append("risk");
					pathBuf.append(File.separator);
					StringBuffer fileName = new StringBuffer();
					fileName.append(file.getFileName());
					// �ļ��ϴ�����
					try {
						this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}

					// �ϴ��ļ�������
					attachment.setAttname(attkey + "_" + fileName.toString());
					// �ϴ��ļ���URL
					attachment.setAtturl("risk");

					this.attachmentBL.registAttachment(attachment);
				}
				rcrtb.setRcrattch(attkey);// ����
				rcrtb.setRcrtestmode("�����");
				this.riskCheckResultBL.updateRiskCheckResult(rcrtb);
			}

			CheckworkInfoResultSearchCondImpl checkCond = new CheckworkInfoResultSearchCondImpl();
			checkCond.setCwrid(form.getCwrid());
			List<CheckworkInfoResultInfo> checkWorkList = this.checkworkInfoResultBL.searchCheckworkInfoResult(checkCond, 0, 0);
			Integer[] rcrid_in = new Integer[checkWorkList.size()];
			for (int i = 0; i < checkWorkList.size(); i++) {
				rcrid_in[i] = checkWorkList.get(i).getRcrid();
			}
			// �������
			Integer rate = 0;

			RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
			cond.setRcrid_in(rcrid_in);
			// ��ѯ���ܵ�����
			int sum = this.riskCheckResultBL.getSearchCountForRate(cond);
			cond.setRcrrealtime_isNull("1");
			// ��ѯ���Ѿ���Ҫ����Ĺ�������
			int count = this.riskCheckResultBL.getSearchCountForRate(cond);
			// ������Ѵ�����ɵ�����
			rate = (int) (((1 - (double) count / (double) sum)) * 100);

			CheckWorkResultInfo info = this.checkWorkResultBL.searchCheckWorkResultByPK(form.getCwrid());
			CheckWorkResultTB tb = (CheckWorkResultTB) info;
			// �������Ϊ100,������������
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
			// �������С��100,�������δ���
			if (rate < 100) {
				tb.setCwrrealtime("");
			}
			// ���������²��뵽�ü��������
			tb.setCwrrate(rate.toString());
			// ��������
			this.checkWorkResultBL.updateCheckWorkResult(tb);
		}
		// }else{
		// dto.setGoToError(IGRISCONSTANTS.RISKCHECKRESULT_SUBMIT_ERROR);
		// }
		dto.addMessage(new ActionMessage("IGCO10000.I003", "��鹤��ִ�гɹ���"));
		return dto;
	}

	/**
	 * <p>
	 * Description: �����Ա���
	 * </p>
	 */
	public IGRIS02DTO insertCheckStrategAction(IGRIS02DTO dto) throws BLException {

		log.debug("========���ռ����������ʼ========");
		IGRIS0202Form form = dto.getIgRIS0202Form();
		CheckStrategyTB csTb = new CheckStrategyTB();
		AttachmentTB attachment = new AttachmentTB();
		String attkey = IGStringUtils.getAttKey();// ����id
		attachment.setAttkey(attkey);

		// �ϴ��ļ����
		Map<Integer, FormFile> filemap = form.getFileMap();
		Iterator<Integer> iterator = filemap.keySet().iterator();
		while (iterator.hasNext()) {
			FormFile file = (FormFile) filemap.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();

				// ��Ŀ¼
				pathBuf.append(rootPath);
				// ��ǰģ��Ŀ¼
				pathBuf.append("risk");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// �ļ��ϴ�����
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}

				// �ϴ��ļ�������
				attachment.setAttname(attkey + "_" + fileName.toString());
				// �ϴ��ļ���URL
				attachment.setAtturl("risk");

				this.attachmentBL.registAttachment(attachment);

			}
		}
		// ���Ƶ��
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// Ƶ��Ϊ��
			for (String week : form.getRcfrequencyweek()) {
				if (StringUtils.isEmpty(frequency)) {
					frequency = week;
				} else {
					frequency = frequency + "," + week;
				}
			}
		} else if ("month".equals(form.getRcfrequency())) {
			if (form.getRcfrequencymonth() != null) {
				// Ƶ��Ϊ��
				for (String month : form.getRcfrequencymonth()) {
					if (StringUtils.isEmpty(frequency)) {
						frequency = month;
					} else {
						frequency = frequency + "," + month;
					}
				}
			}
		}

		// �� , ����ַ���,�õ�һ������
		String[] startdate = form.getRcstartdate().split("\\ ");
		String starttime = startdate[1];
		String[] begindate = starttime.split("\\:");
		// ʱ
		String exeHour = begindate[0];
		// ��
		String exeMinute = begindate[1];
		// ȡ��ִ�����ڱ��ʽ
		String cronExpression = null;

		if (StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())) {// Ƶ��Ϊÿ�����һ��
			// ȡ��ִ�����ڱ��ʽ,���ռ��Ƶ��(ÿ�����һ��)
			if ("1".equals(form.getRcfrequencymonthlastday())) {
				// ȡ��ִ�����ڱ��ʽ
				cronExpression = this.creatCronExp(form.getRcfrequencymonthlastday(), exeHour, exeMinute, form.getRcstartdate(), null);
				frequency = "���һ";
			}
		} else {// Ƶ��Ϊ�ܡ���
			cronExpression = this.creatCronExp(form.getRcfrequency(), exeHour, exeMinute, form.getRcstartdate(), frequency);
		}

		form.setRcfrequencydesc(frequency);// ���ռ��Ƶ������
		// ����RiskCheck
		form.setRcstatus(IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE);// ����״̬Ϊ����
		form.setRcattch(attkey);// ����id
		form.setRccron(cronExpression);// ���ռ�����ִ�б��ʽ

		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRccreatetime(date);// ���ռ��Ǽ�ʱ��yyyy/MM/dd HH:mm
		// ��¼���ռ����Ϣ
		// RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
		// dto.setRiskCheck(rc);
		csTb = copyPropertie(csTb, form);
		CheckStrategyInfo info = this.checkStrategyBL.registCheckStrategy(csTb);
		dto.setIgRIS0202Form(form);
		dto.setCheckStrategyInfo(info);

		List<String> eiids = dto.getEiids();
		List<String> eiversions = dto.getEiversions();
		List<RiskCheck> checkList = new ArrayList<RiskCheck>();
		// �������������Ҫͨ���ʲ���eiid��eiversion��ȡ���ʲ�������
		for (int i = 0; i < eiids.size(); i++) {
			// ��ѯ�ʲ�����
			SOC0107SearchCondImpl soc0107cond = new SOC0107SearchCondImpl();
			IGRIS0202Form igris0202Form = dto.getIgRIS0202Form();
			soc0107cond.setEiid(eiids.get(i));
			soc0107cond.setCiversion(eiversions.get(i));
			List<SOC0107Info> soc0107InfoList = soc0107BL.searchSOC0107(soc0107cond, 0, 0);
			for (int j = 0; j < soc0107InfoList.size(); j++) {
				SOC0107Info socInfo = soc0107InfoList.get(j);
				if (socInfo.getCid().equals("CI210000000001")) {
					// ���ü��������
					igris0202Form.setRcname(socInfo.getCivalue());
					igris0202Form.setRcassetname(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000002")) {
					// ���ü����˵��
					igris0202Form.setRcdesc(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000003")) {
					// ���ü�鷽��
					igris0202Form.setRccommon(socInfo.getCivalue());
				} else if (socInfo.getCid().equals("CI210000000004")) {

				} else if (socInfo.getCid().equals("CI210000000005")) {
					// ��������
					Integer in = Integer.parseInt(socInfo.getCivalue()) - 999021000;
					igris0202Form.setRcclass(in.toString());
				}

			}
			if (eiids.get(i) != null && !(eiids.get(i).equals(""))) {
				SOC0118Info soc0118 = soc0118BL.searchEntityItemByKey(Integer.parseInt(eiids.get(i)));
				igris0202Form.setRcstatus(soc0118.getEistatus());
			}
			// ������Ӧ�ʲ�id
			igris0202Form.setRcasset(Integer.parseInt(eiids.get(i)));
			RiskCheck check = this.riskCheckBL.registRiskCheck(igris0202Form);

			// ��������Թ���������
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
		dto.addMessage(new ActionMessage("IGRIS0202.I001", "�������趨�ɹ�"));
		log.debug("========���ռ��������������========");
		return dto;
	}

	private void changeRiskStatusAction(CheckStrategyInfo info) throws BLException {
		CheckStrategyTB chtb = (CheckStrategyTB) info;
		String jobName = "RiskCheckJob" + info.getCsid();
		String jobGroupName = "RiskCheckGroup" + info.getCsid();
		String triggerName = "RiskCheckJobTrigger" + info.getCsid();
		String triggerGroupName = "RiskCheckJobTriggerGroup" + info.getCsid();
		// ͣ��״̬���ò���
		if (IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE.equals(info.getCsstatus())) {
			chtb.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_ENABLE);
			// ���Ƶ��
			String frequency = info.getCscron();
			// ȡ��ִ�����ڱ��ʽ
			String cronExpression = frequency;
			RiskCheckJob riskCheckJob = new RiskCheckJob();// ȡ��job
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
				log.error("quarz����", e);
				throw new BLException("IGRIS0201.E001", "SchedulerException");
			}
		}
		// ����״̬ͣ�ò���
		else {
			chtb.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE);
			try {
				JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
			} catch (SchedulerException e) {
				log.error("==========Exception form RiskCheckJob===========");
				log.debug(e.getMessage());
				log.debug("quarz��������", e);
				throw new BLException("", "SchedulerException");
			}
		}
		checkStrategyBL.updateCheckStrategy(chtb);
	}

	/**
	 * ��������
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
		// ����Ϊ����
		csTb.setCsstatus(IGRISCONSTANTS.RISKCHECK_STATUS_DISABLE);
		csTb.setCsstartdate(form.getRcstartdate());
		csTb.setCsenddate(form.getRcenddate());
		csTb.setCsfrequency(form.getRcfrequency());
		// ���ü�鷽ʽ
		csTb.setCsrtestmode(form.getRcrtestmode());
		// ������Ҫ�̶�
		csTb.setCstype(form.getRctype());
		csTb.setCscron(form.getRccron());
		// ����������id
		csTb.setCsuserid(form.getRcuserid());
		csTb.setCsusername(form.getRcusername());
		// ����������id
		if (form.getRcroleid() != null && !(form.getRcroleid().equals(""))) {
			csTb.setCsroleid(form.getRcroleid().toString());
		}
		csTb.setCsrolename(form.getRcrolename());
		// ���ú���������id
		csTb.setCsasset(form.getCiiopid());
		csTb.setCsassetname(form.getCiiop());
		// ���ú���������id
		csTb.setCsassetorgid(form.getCogid());
		csTb.setCsassetorgname(form.getCog());
		csTb.setCsattch(form.getRcattch());
		csTb.setCsoption(form.getRcrtestmode());// ��鷽ʽ�趨
		return csTb;
	}

	/**
	 * <p>
	 * Description: �����Ƶ������
	 * </p>
	 */

	public String getfrequencydesc(String periodType, String startDate, String desc) {

		Map<String, String> weeksMap = new HashMap<String, String>();
		weeksMap.put("MON", "һ");
		weeksMap.put("TUE", "��");
		weeksMap.put("WED", "��");
		weeksMap.put("THU", "��");
		weeksMap.put("FRI", "��");
		weeksMap.put("SAT", "��");
		weeksMap.put("SUN", "��");
		String period = null;
		String datetime = startDate.split("/")[2].trim();
		if ("week".equals(periodType)) {
			StringBuffer desc1 = new StringBuffer();
			String weeks[] = desc.split(",");
			for (int i = 0; i < weeks.length; i++) {
				desc1.append(weeksMap.get(weeks[i]));
				if (i < weeks.length - 1) {
					desc1.append("��");
				}
			}
			period = "ÿ��" + desc1 + datetime.split(" ")[1].trim();
		} else if ("month".equals(periodType)) {
			// period = "��" + Integer.valueOf(startDate.split("/")[2].trim()) +
			// "��  ";
			period = "ÿ��" + desc + "��" + datetime.split(" ")[1].trim();
		} else if ("once".equals(periodType)) {
			period = startDate;
			return period;
		} else if ("day".equals(periodType)) {
			period = "ÿ��" + datetime.split(" ")[1].trim();
		} else if ("quarter".equals(periodType)) {
			// period = "������" + Integer.valueOf(startDate.split("/")[2].trim())
			// + "��  ";
			period = startDate.split(" ")[0].trim() + "�տ�ʼ���ȵ�һ��" + datetime.split(" ")[0].trim() + "��" + datetime.split(" ")[1].trim();
		}
		// ����Ƶ��ÿ�꣬ÿ���� 20121024 ��ѧ־
		else if ("year".equals(periodType)) {
			period = "ÿ��" + startDate.split("/")[1].trim() + "��" + startDate.split("/")[2].trim().substring(0, 2) + "��" + datetime.split(" ")[1].trim();
		} else if ("halfyear".equals(periodType)) {
			period = startDate.split(" ")[0].trim() + "�տ�ʼÿ�����һ��" + datetime.split(" ")[0].trim() + "��" + datetime.split(" ")[1].trim();
		}
		return period;

	}

	/**
	 * <p>
	 * Description: ���ռ��Ǽǳ�ʼ��
	 * </p>
	 */
	public IGRIS02DTO dispRiskCheckAction(IGRIS02DTO dto) throws BLException {
		log.debug("========���ռ��Ǽǳ�ʼ������ʼ========");
		// �ܼ���
		List<IGRIS02022VO> weekList = new ArrayList<IGRIS02022VO>();
		IGRIS02022VO week1vo = new IGRIS02022VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("��һ");
		weekList.add(week1vo);
		IGRIS02022VO week2vo = new IGRIS02022VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("�ܶ�");
		weekList.add(week2vo);
		IGRIS02022VO week3vo = new IGRIS02022VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("����");
		weekList.add(week3vo);
		IGRIS02022VO week4vo = new IGRIS02022VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("����");
		weekList.add(week4vo);
		IGRIS02022VO week5vo = new IGRIS02022VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("����");
		weekList.add(week5vo);
		IGRIS02022VO week6vo = new IGRIS02022VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("����");
		weekList.add(week6vo);
		IGRIS02022VO week7vo = new IGRIS02022VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("����");
		weekList.add(week7vo);
		// ÿ����������
		List<IGRIS02022VO> monthList = new ArrayList<IGRIS02022VO>();
		;
		for (int i = 1; i < 31; i++) {
			// ��
			String dayvalue = String.valueOf(i);
			// �Ƿ���ѡ��
			IGRIS02022VO monthvo = new IGRIS02022VO();
			monthvo.setDayvalue(dayvalue);
			monthList.add(monthvo);
		}
		dto.setWeekList(weekList);
		dto.setMonthList(monthList);
		log.debug("========���ռ��Ǽǳ�ʼ����������========");

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
		// �ĵ���Ϣ��ѯ����ȡ��
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
		// ��ҳ����Ϣȡ��
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
	 * ��ѯ�����
	 */
	public IGRIS02DTO selPoint(IGRIS02DTO dto) {
		log.debug("========���ռ���ѯ����ʼ========");
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
		// ��ѯ��¼����
		// int totalCount = this.riskCheckBL.getSearchCount(cond);
		int totalCount = this.checkInfoRiskBL.getSearchCount(condInfo);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ��ѯ�����м����ID
		List<CheckInfoRiskInfo> checkInfoList = this.checkInfoRiskBL.searchCheckInfoRisk(condInfo, 0, 0);
		Integer[] rcid_in = new Integer[totalCount];
		for (int i = 0; i < checkInfoList.size(); i++) {
			rcid_in[i] = checkInfoList.get(i).getRcid();
		}
		cond.setRcid_in(rcid_in);
		// ����DAO�ӿڲ�ѯ
		List<RiskCheck> riskCheckList = this.riskCheckBL.searchRiskCheck(cond, pDto.getFromCount(), pDto.getPageDispCount());
		if (riskCheckList != null) {
			pDto.setTotalCount(riskCheckList.size());
		}

		User user = dto.getUser();// ��ǰ�û�
		UserRoleVWSearchCondImpl usercond = new UserRoleVWSearchCondImpl();
		usercond.setUserid(user.getUserid());
		// ȡ�õ�ǰ�û������еĽ�ɫ
		List<UserRoleInfo> rolelist = this.userRoleBL.searchUserRoleVW(usercond, 0, 0);
		// ��Ϣ��ȫ��ֱ�ӷ�����������
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
						// �жϵ�ǰ�û����еĽ�ɫ�Ƿ�����ռ��������Ľ�ɫ��ͬ
						if (uri.getRoleid() != null && rc.getRcroleid() != null && !"".equals(rc.getRcroleid())) {
							if (uri.getRoleid().equals(Integer.valueOf(rc.getRcroleid()))) {
								flag = true;
								break;
							} else if (user.getUserid().equals(rc.getCiiopid())) {// �ڲ��Ƿ��ռ��������Ľ�ɫʱ�жϵ�ǰ�û��Ƿ��Ǻ���ִ����ID��ȷ����֧�߼���ȷִ��
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
		log.debug("========���ռ���ѯ��������========");
		return dto;
	}

	/**
	 * ���Ƽ�����
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
		// ���Ƽ쳵����
		CheckStrategyInfo checkStrategyInfo2 = this.checkStrategyBL.registCheckStrategy(checkStrategytb);

		CheckInfoRiskSearchCondImpl cond = new CheckInfoRiskSearchCondImpl();
		cond.setCsid(csid);
		// ��ѯ���еļ����Թ������������
		List<CheckInfoRiskInfo> checkRiskList = this.checkInfoRiskBL.searchCheckInfoRisk(cond, 0, 0);
		for (int i = 0; i < checkRiskList.size(); i++) {

			CheckInfoRiskTB tb = (CheckInfoRiskTB) checkRiskList.get(i);

			RiskCheckTB riskTB = (RiskCheckTB) this.riskCheckBL.searchRiskCheckByKey(tb.getRcid());

			RiskCheckTB riskTb2 = new RiskCheckTB();

			copyProperties(riskTb2, riskTB);
			riskTb2.setRcid(0);
			// ���Ƽ����
			RiskCheck riskTB2 = this.riskCheckBL.registRiskCheck(riskTb2);

			CheckInfoRiskTB tb2 = new CheckInfoRiskTB();
			// ���¼����Թ�������������
			tb2.setCsid(checkStrategyInfo2.getCsid());
			tb2.setRcid(riskTB2.getRcid());
			// ���Ƽ����Թ������������
			this.checkInfoRiskBL.registCheckInfoRisk(tb2);
			list.add(riskTB2);
		}

		// //��ȡ��鹤��
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
		// //���Ƽ�鹤��
		// CheckWorkResultInfo checkWorkResultInfo =
		// checkWorkResultBL.registCheckWorkResult(resultTB);
		dto.setRiskCheckList(list);
		dto.setCsid(checkStrategyInfo2.getCsid());
		// dto.setCwrid(checkWorkResultInfo.getCwrid());
		return dto;
	}

	/**
	 * ���ܣ����ݼ�����id��ѯ������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 *             �޸ļ�¼��null
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
				// eiidȡ��
				eiids.append(riskCheck.getRcasset());
				// einame ȡ��
				einames.append(riskCheck.getRcassetname());
				// eiversionȡ��
				eiversions.append(riskCheck.getRcassetversion());
				// ��������ȡ��
				if (riskCheck.getRcclass() != null) {
					if (riskCheck.getRcclass().equals("1")) {
						eimode.append("����");
					} else if (riskCheck.getRcclass().equals("2")) {
						eimode.append("����");
					} else if (riskCheck.getRcclass().equals("3")) {
						eimode.append("ϵͳ");
					} else if (riskCheck.getRcclass().equals("4")) {
						eimode.append("���氲ȫ");
					} else if (riskCheck.getRcclass().equals("5")) {
						eimode.append("���ʿ���");
					} else if (riskCheck.getRcclass().equals("6")) {
						eimode.append("����");
					} else if (riskCheck.getRcclass().equals("7")) {
						eimode.append("����");
					}
				}
				eidesc.append(riskCheck.getRcdesc());
				rcommon.append(riskCheck.getRccommon());
				if (riskCheck.getRcstatus().equals("0")) {
					eistatus.append("ͣ��");
				} else {
					eistatus.append("����");
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

		// map(key,value) ������ ��鼯��
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
		// ������idȡ��
		form.setRcuserid(csi.getCsuserid());
		form.setRcusername(csi.getCsusername());
		// ������idȡ��
		if (csi.getCsroleid() != null && !(csi.getCsroleid().equals(""))) {
			form.setRcroleid(Integer.parseInt(csi.getCsroleid()));
		}
		form.setRcrolename(csi.getCsrolename());
		// ����������
		form.setCogid(csi.getCsassetorgid());
		form.setCog(csi.getCsassetorgname());
		// ����������
		form.setCiiopid(csi.getCsasset());
		form.setCiiop(csi.getCsassetname());
		form.setRcattch(csi.getCsattch());
		System.out.println(form.getRcrtestmode());
		// form.setRcrtestmode(csi.getCsoption());
		return dto;
	}

	/**
	 * ���ܣ����������鹤��ָ������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO batchFlowAction(IGRIS02DTO dto) throws BLException {
		log.debug("==============����������������ʼ===============");
		IGRIS0203Form igris0203Form = dto.getIgRIS0203Form();
		User user = dto.getUser();
		Integer roleid = getInitRoleid();
		Integer[] rcrids = igris0203Form.getRcrids();
		Integer[] prids = new Integer[rcrids.length];
		for (int i = 0; i < rcrids.length; i++) {
			RiskCheckResult result = riskCheckResultBL.searchRiskCheckResultByKey(rcrids[i]);
			WorkFlowLog workFlowLog = new WorkFlowLog();
			workFlowLog.setExecutorid(user.getUserid());// ������ID
			workFlowLog.setExecutorRoleid(3029);
			// workFlowLog.setAuthuserid(user.getUserid());
			Map<String, String> formvalue = new HashMap<String, String>();
			// userRoleBL.searchUserRoleByKey(user.getUserid().tos);
			formvalue.put("��鷽��", result.getRccommon());
			formvalue.put("������", user.getUsername());
			formvalue.put("���ɱ�ʾ", "1");
			formvalue.put("��Ա", "" + "#" + result.getRcrusername() + "#" + rcrids[i].toString());
			ProcessRecord process = new ProcessRecord(workFlowLog);
			// process.setDefstatus("Z");

			process.setCrtuserid(user.getUserid());// ������ID
			process.setTitle(result.getRcname());// ����
			IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
			cond380.setPdid_like("01140");
			List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);
			process.setDefid(list380.get(list380.size() - 1).getPdid());
			process.setRoleid(3029);
			// process.setDefstatus("Z");
			process.setFormvalue(formvalue);
			process.setDescription(result.getRcdesc());// ����
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
		log.debug("==============������������������===============");
		dto.setIgRIS0203Form(igris0203Form);
		return dto;
	}

	/**
	 * �����������ҳ���ʼ������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO initIGRIS0402Action(IGRIS02DTO dto) throws BLException {
		log.debug("=================�����������ҳ���ʼ��������ʼ================");
		if (dto.getIgRIS0203Form() != null) {
			// dto����ȡ��
			IGRIS0203Form form = (IGRIS0203Form) dto.getIgRIS0203Form();
			IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
			cond380.setPdid_like("01140");
			List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);
			// �ɱ����ɽڵ��ѯ
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(list380.get(list380.size() - 1).getPdid() + "001", "10");
			/*
			 * for(int i = 0;i<lst_ProcessStatusDef.size();i++){
			 * if(lst_ProcessStatusDef.get(i).getPsdname()!=null &&
			 * lst_ProcessStatusDef.get(i).getPsdname().equals("��׼���ִ��")){
			 * lst_ProcessStatusDef.remove(i); } }
			 */
			Map<IG333Info, Map<Role, List<UserInfo>>> map = new LinkedHashMap<IG333Info, Map<Role, List<UserInfo>>>();
			for (IG333Info psd : lst_ProcessStatusDef) {
				map.put(psd, new LinkedHashMap<Role, List<UserInfo>>());
				// ��ѯ�ɷ��ɽ�ɫ
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
		log.debug("=================�����������ҳ���ʼ����������================");
		return dto;
	}

	/**
	 * �������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRIS02DTO assignAction(IGRIS02DTO dto) throws BLException {
		log.debug("================�������������ʼ===============");
		if (dto.getIgRIS0203Form() != null) {
			// dto����ȡ��
			IGRIS0203Form form = (IGRIS0203Form) dto.getIgRIS0203Form();
			User user = dto.getUser();
			if (form.getPrids() != null && form.getPrids().length > 0) {
				// �ɱ����ɽڵ��ѯ
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(form.getPrstatus(), form.getButtonCode());
				for (Integer prid : form.getPrids()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
					// ��ȡ�û������ɫ
					UserRoleInfo ur = this.workFlowOperationBL.getUserRolesInProcessParticipants(prid, user.getUserid(), pr.getPrpdid() + form.getPrstatus().substring(7)).get(0);
					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(ur.getRoleid());
					// ɾ��ԭ���ڵ������
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
					// ԾǨ����
					flowOptBL.transitionProcess(prid, user.getUserid(), form.getButtonName(), IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================���������������===============");
		return dto;
	}

	/**
	 * ��ȡ�����ɫID
	 * 
	 * @return �����ɫID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		// ��ȡ����"��������"�˵��Ľ�ɫID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname("ACT04RIS0302");
		List<RoleAction> lst_RoleAction = this.roleActionBL.searchRoleAction(cond);
		if (lst_RoleAction.isEmpty()) {
			throw new BLException("IGCO10000.E004", "������ɫ");
		}
		return lst_RoleAction.get(0).getRoleid();
	}

}
