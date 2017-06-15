/**   
* @Title: IGVen01BL.java 
* @Package com.deliverik.infogovernor.ven.bl 
* @Description: TODO
* @author wangyaowen@Deliverik.com 
* @date 2014-12-1 ����10:55:23 
* @version V1.0   
*/
package com.deliverik.infogovernor.ven.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexSearchVWBL;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCondImpl;
import com.deliverik.infogovernor.risk.bl.IGRIS02BLImpl;
import com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.bl.task.RiskMonitoringBL;
import com.deliverik.infogovernor.ven.bl.task.RiskStrategyBL;
import com.deliverik.infogovernor.ven.bl.task.StrategyIndexRelationBL;
import com.deliverik.infogovernor.ven.dto.IGVEN01DTO;
import com.deliverik.infogovernor.ven.form.IGVEN0101Form;
import com.deliverik.infogovernor.ven.form.IGVEN0102Form;
import com.deliverik.infogovernor.ven.form.IGVEN0103Form;
import com.deliverik.infogovernor.ven.job.VenCheckJob;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskStrategySearchCondImpl;
import com.deliverik.infogovernor.ven.model.condition.StrategyIndexRelationSearchCondImpl;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;
import com.deliverik.infogovernor.ven.model.entity.RiskStrategyTB;
import com.deliverik.infogovernor.ven.model.entity.StrategyIndexRelationTB;
import com.deliverik.infogovernor.ven.vo.IGVEN01022VO;

public class IGVEN01BLImpl extends BaseBLImpl implements IGVEN01BL {

	static Log log = LogFactory.getLog(IGRIS02BLImpl.class);
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	/** ��ʷ��¼����ҵ��BL*/
	protected AttachmentBL attachmentBL;
	
	/** �ʲ���ϢBL */
	protected SOC0118BL soc0118BL;
	
	/** �ʲ�����BL*/
	protected SOC0107BL soc0107BL;
	
	/** ���ղ���BL*/
	protected RiskStrategyBL riskStrategyBL;
	
	/** ���ղ��Թ�����BL*/
	protected StrategyIndexRelationBL strategyIndexRelationBL;
	
	/** ��������BL*/
	protected RiskMonitoringBL riskMonitoringBL;
	
	/** ���չ���BL*/
	protected MonitoringWorkBL monitoringWorkBL;
	
	/** �û���ɫ��Ȩ��ϢBL*/
	protected UserRoleBL userRoleBL;
	
	/**����ָ���ѯ*/
	protected RiskIndexSearchVWBL riskIndexSearchVWBL;
	
	/** ��ɫ�˵���ȨBL*/
	protected RoleActionBL roleActionBL;

	/** ���̴�����API */
	protected FlowOptBL flowOptBL;
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ƽ̨�û�BL */
	protected UserBL userBL;
	
	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;
	
	/**
	 * ���ղ���BL�趨
	 * @param riskStrategyBL
	 */
	public void setRiskStrategyBL(RiskStrategyBL riskStrategyBL) {
		this.riskStrategyBL = riskStrategyBL;
	}

	/**
	 * ���ղ��Թ�����BL�趨
	 * @param strategyIndexRelationBL
	 */
	public void setStrategyIndexRelationBL(
			StrategyIndexRelationBL strategyIndexRelationBL) {
		this.strategyIndexRelationBL = strategyIndexRelationBL;
	}
	
	/**
	 * ��������BL�趨
	 * @param riskMonitoringBL
	 */
	public void setRiskMonitoringBL(RiskMonitoringBL riskMonitoringBL) {
		this.riskMonitoringBL = riskMonitoringBL;
	}

	/**
	 * ���չ���BL�趨
	 * @param monitoringWorkBL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/**
	 * �ļ��ϴ�BL�趨
	 * @param fileUploadBL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * ��ʷ��¼����ҵ��BL�趨
	 * @param attachmentBL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * �ʲ���ϢBL�趨
	 * @param soc0118bl
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * �ʲ�����BL�趨
	 * @param soc0107bl
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	/**
	 * �û���ɫ��Ȩ��ϢBL�趨
	 * @param userRoleBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	
	/**
	 * ����ָ��BL�趨
	 * @param riskIndexSearchVWBL
	 */
	public void setRiskIndexSearchVWBL(RiskIndexSearchVWBL riskIndexSearchVWBL) {
		this.riskIndexSearchVWBL = riskIndexSearchVWBL;
	}

	/**
	 * ��ɫ�˵���ȨBL�趨
	 * @param roleActionBL the ��ɫ�˵���ȨBL
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * ���̴�����API�趨
	 * @param flowOptBL the ���̴�����API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL the ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ƽ̨�û�BL�趨
	 * @param userBL the ƽ̨�û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL the ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ������API�趨
	 * @param flowSetBL the ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * <p>
	 * Description: ���ռ��Ǽǳ�ʼ��
	 * </p>
	 */
	public IGVEN01DTO dispRiskCheckAction(IGVEN01DTO dto) throws BLException {
		log.debug("========���ռ��Ǽǳ�ʼ������ʼ========");
		//�ܼ���
		List<IGVEN01022VO> weekList = new ArrayList<IGVEN01022VO>();
		IGVEN01022VO week1vo = new IGVEN01022VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("��һ");
		weekList.add(week1vo);
		IGVEN01022VO week2vo = new IGVEN01022VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("�ܶ�");
		weekList.add(week2vo);
		IGVEN01022VO week3vo = new IGVEN01022VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("����");
		weekList.add(week3vo);
		IGVEN01022VO week4vo = new IGVEN01022VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("����");
		weekList.add(week4vo);
		IGVEN01022VO week5vo = new IGVEN01022VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("����");
		weekList.add(week5vo);
		IGVEN01022VO week6vo = new IGVEN01022VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("����");
		weekList.add(week6vo);
		IGVEN01022VO week7vo = new IGVEN01022VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("����");
		weekList.add(week7vo);
		//ÿ����������
		List<IGVEN01022VO> monthList = new ArrayList<IGVEN01022VO>();;
		for(int i = 1;i<31;i++){
			//��
			String dayvalue = String.valueOf(i);
			//�Ƿ���ѡ��
			IGVEN01022VO monthvo = new IGVEN01022VO();
			monthvo.setDayvalue(dayvalue);
			monthList.add(monthvo);
		}
		dto.setWeekList(weekList);
		dto.setMonthList(monthList);
		log.debug("========���ռ��Ǽǳ�ʼ����������========");

		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �����Ա���
	 * </p>
	 */
	public IGVEN01DTO insertCheckStrategAction(IGVEN01DTO dto) throws BLException{
		
		log.debug("========���ռ����������ʼ========");
		IGVEN0102Form form = dto.getIgVEN0102Form();
		RiskStrategyTB csTb = new RiskStrategyTB();
		AttachmentTB attachment = new AttachmentTB();
		String attkey = IGStringUtils.getAttKey();//����id
		attachment.setAttkey(attkey);
		
		//�ϴ��ļ����
		Map<Integer, FormFile> filemap = form.getFileMap();
		Iterator<Integer> iterator = filemap.keySet().iterator();
		while(iterator.hasNext()){
			FormFile file = filemap.get(iterator.next());
			if ( file != null && file.getFileSize() > 0) {
				//�ϴ��ļ����ڵ����
				//�ϴ��ļ�·��
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				
				//��Ŀ¼
				pathBuf.append(rootPath);
				//��ǰģ��Ŀ¼
				pathBuf.append("risk");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				//�ļ��ϴ�����
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey+"_"+fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				
				//�ϴ��ļ�������
				attachment.setAttname(attkey+"_"+fileName.toString());
				//�ϴ��ļ���URL
				attachment.setAtturl("risk");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		// ���Ƶ��
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// Ƶ��Ϊ��
			for (String week : form.getRcfrequencyweek()) {
				if(StringUtils.isEmpty(frequency)){
					frequency = week;
				}else{
					frequency = frequency + "," + week;
				}
			}
		}else if("month".equals(form.getRcfrequency())){
			if(form.getRcfrequencymonth()!=null){				
				// Ƶ��Ϊ��
				for (String month : form.getRcfrequencymonth()) {
					if(StringUtils.isEmpty(frequency)){
						frequency = month;
					}else{
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
		//ȡ��ִ�����ڱ��ʽ
		String cronExpression =  null;
		
		if(StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())){//Ƶ��Ϊÿ�����һ��
			//ȡ��ִ�����ڱ��ʽ,���ռ��Ƶ��(ÿ�����һ��)
			if("1".equals(form.getRcfrequencymonthlastday())){
				//ȡ��ִ�����ڱ��ʽ
				cronExpression =  this.creatCronExp(form.getRcfrequencymonthlastday(),exeHour, exeMinute,form.getRcstartdate(),null);
				frequency = "���һ";
			}
		}else{//Ƶ��Ϊ�ܡ���
			cronExpression =  this.creatCronExp(form.getRcfrequency(),exeHour, exeMinute,form.getRcstartdate(),frequency);
		}
		
		form.setRcfrequencydesc(frequency);// ���ռ��Ƶ������
		//����RiskCheck
		form.setRcstatus(IGRISCONSTANTS.RISKS_STRATEGY_ENABLE);//����״̬Ϊ����
		form.setRcattch(attkey);//����id
		form.setRccron(cronExpression);// ���ռ�����ִ�б��ʽ
		
		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRccreatetime(date);// ���ռ��Ǽ�ʱ��yyyy/MM/dd HH:mm
		// ��¼���ռ����Ϣ
//		RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
//		dto.setRiskCheck(rc);
		csTb = copyPropertie(csTb, form);
		
		RiskStrategyInfo info = this.riskStrategyBL.registRiskStrategy(csTb);
		dto.setIgVEN0102Form(form);
		dto.setRiskStrategyInfo(info);
		
		List<String> eiids = dto.getEiids();
		List<RiskCheck> checkList = new ArrayList<RiskCheck>();
		//�������������Ҫͨ���ʲ���eiid��eiversion��ȡ���ʲ�������
		for(int i = 0;i<eiids.size();i++){
			//��ϵ��ʵ��ȡ��
			StrategyIndexRelationTB tb = strategyIndexRelationBL.getStrategyIndexRelationTBInstance();
			tb.setRiid(Integer.parseInt(eiids.get(i)));
			tb.setRsid(info.getRsid());
			strategyIndexRelationBL.registStrategyIndexRelation(tb);
		}
		dto.setRiskCheckList(checkList);
		if(info.getRsfrequency().equals("once")){
			RiskStrategyTB checkTB = (RiskStrategyTB)info;
			dto.setCsid(info.getRsid());
			checkTB.setRsstatus(IGRISCONSTANTS.RISKS_STRATEGY_ENABLE);
			initRiskCheckResult(dto);
			//checkStrategyBL.updateCheckStrategy(checkTB);
		}else{
			changeRiskStatusAction2(info,form);			
		}
		dto.addMessage(new ActionMessage( "IGRIS0202.I001", "�������趨�ɹ�") );
		log.debug("========���ռ��������������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ʼ������Ӧ�ý��еķ��ռ��
	 * </p>
	 */
	public void initRiskCheckResult(IGVEN01DTO dto) throws BLException {	
		RiskStrategyInfo info = riskStrategyBL.searchRiskStrategyByPK(dto.getCsid());
		//����������
		RiskMonitoringTB riskWorkTB = new RiskMonitoringTB();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		//�����������
		riskWorkTB.setRmname(info.getRsname() + format.format(new Date()));
		riskWorkTB.setRsid(info.getRsid());
		riskWorkTB.setRmrate("0");
		riskWorkTB.setRmstartdate(info.getRsstartdate());
		RiskMonitoringInfo cwInfo = riskMonitoringBL.registRiskMonitoring(riskWorkTB);
		//����������
		StrategyIndexRelationSearchCondImpl cond = new StrategyIndexRelationSearchCondImpl();
		cond.setRsid(info.getRsid());
		List<StrategyIndexRelationInfo> criList = strategyIndexRelationBL.searchStrategyIndexRelation(cond);
		for(StrategyIndexRelationInfo sirInfo:criList){
			//wangjiahui
			MonitoringWorkTB tb = new MonitoringWorkTB();
			tb.setRiid(sirInfo.getRiid());
			tb.setRmid(cwInfo.getRmid());
			monitoringWorkBL.registMonitoringWork(tb);
		}
	}
	/**
	 * ��������
	 * @param csTb
	 * @param form
	 * @return
	 */
	private RiskStrategyTB copyPropertie(RiskStrategyTB csTb,
			IGVEN0102Form form) {
		// TODO Auto-generated method stub
		csTb.setRsname(form.getRcname());
		csTb.setRsdesc(form.getRccommon());
		//����Ϊͣ��
		csTb.setRsstatus(IGRISCONSTANTS.RISKS_STRATEGY_DISABLE);
		csTb.setRsstartdate(form.getRcstartdate());
		csTb.setRsenddate(form.getRcenddate());
		csTb.setRsfrequency(form.getRcfrequency());
		csTb.setRsattachkey(form.getRcattch());
		csTb.setRsfrequencydesc(form.getRcfrequencydesc());
		return csTb;
	}

	/**
	 * <p>
	 * Description: ���ռ���ѯ
	 * </p>
	 */
	
	public IGVEN01DTO searchRiskCheckAction(IGVEN01DTO dto) throws BLException {
		log.debug("========���ռ���ѯ����ʼ========");
		IGVEN0101Form form = dto.getIgven0101Form();
		RiskStrategySearchCondImpl cond = new RiskStrategySearchCondImpl();
		//�趨���ղ�������
		cond.setRsname(form.getRcname());
		
		// ��ѯ��¼����
		int totalCount = this.riskStrategyBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<RiskStrategyInfo> riskStrategyList = this.riskStrategyBL.searchRiskStrategy(cond, pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		User user = dto.getUser();//��ǰ�û�
		UserRoleVWSearchCondImpl usercond = new UserRoleVWSearchCondImpl();
		usercond.setUserid(user.getUserid());
		//ȡ�õ�ǰ�û������еĽ�ɫ
		List<UserRoleInfo> rolelist = this.userRoleBL.searchUserRoleVW(usercond, 0, 0);
		//��Ϣ��ȫ��ֱ�ӷ�����������
		for(int i=0;i<rolelist.size();i++){
			if(rolelist.get(i).getRoleid()==1127||rolelist.get(i).getRoleid()==1121){
				dto.setRiskStrategyList(riskStrategyList);
				return dto;
			}
		}
		dto.setRiskStrategyList(riskStrategyList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========���ռ���ѯ��������========");
		return dto;
	}
	
	/**	
	 * ���ܣ����ݼ�����id��ѯ������
	 * @param dto
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */
	public IGVEN01DTO searchCheckStrategyByCsid(IGVEN01DTO dto)
			throws BLException {
		RiskStrategyInfo riskStrategyInfo = riskStrategyBL.searchRiskStrategyByPK(dto.getIgVEN0102Form().getRsid());
		//dto.setCheckStrategyInfo(checkStrategyInfo);
		
		if(StringUtils.isNotEmpty(riskStrategyInfo.getRsattachkey())){
			List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(riskStrategyInfo.getRsattachkey());
			dto.setAttachmentList(attachmentList);
		}
		StrategyIndexRelationSearchCondImpl cond = new StrategyIndexRelationSearchCondImpl();
		IGVEN0102Form form = dto.getIgVEN0102Form();
		
		cond.setRsid(dto.getIgVEN0102Form().getRsid());

		StringBuffer eiids = new StringBuffer();
		StringBuffer eiversions = new StringBuffer();
		StringBuffer risklys = new StringBuffer();
		StringBuffer riskareas = new StringBuffer();
		StringBuffer riskitems = new StringBuffer();
		StringBuffer eilabels = new StringBuffer();
		StringBuffer einames = new StringBuffer();
		
		List<StrategyIndexRelationInfo> strategyList = strategyIndexRelationBL.searchStrategyIndexRelation(cond);
		RiskIndexSearchVWSearchCondImpl riskCond = new RiskIndexSearchVWSearchCondImpl();
		StringBuffer eiid_In = new StringBuffer();
		//�趨һ�������ڵ�EIID���������ж�
		riskCond.setEiid_In("'0'");
		if(strategyList!=null && strategyList.size()>0){
			//��ȡ���еķ���ָ��
			for(int i=0;i<strategyList.size();i++ ){
				Integer riid = strategyList.get(i).getRiid();
				eiid_In.append("'");
				eiid_In.append(riid.toString());
				eiid_In.append("'");
				if(i<strategyList.size()-1){
					eiid_In.append(",");
				}
			}
			if(StringUtils.isNotEmpty(eiid_In.toString())){
				riskCond.setEiid_In(eiid_In.toString());
			}
		}
		riskCond.setSyscoding("999019");
		List<RiskIndexSearchVWInfo> riskVM = riskIndexSearchVWBL.searchRiskIndexSearchVW(riskCond);
		if(riskVM!=null && riskVM.size()>0){
			for(int i=0;i<riskVM.size();i++){
				eiids.append(riskVM.get(i).getEiid());
				eiversions.append(riskVM.get(i).getEiversion());
				risklys.append(riskVM.get(i).getRiskly());
				riskareas.append(riskVM.get(i).getRiskarea());
				riskitems.append(riskVM.get(i).getRiskitem());
				eilabels.append(riskVM.get(i).getEilabel());
				einames.append(riskVM.get(i).getEiname());
				if(i< riskVM.size()-1){
					eiids.append(",");
					eiversions.append(",");
					risklys.append(",");
					riskareas.append(",");
					riskitems.append(",");
					eilabels.append(",");
					einames.append(",");
				}
			}
		}
		dto.getIgVEN0102Form().setEiids(eiids.toString());
		dto.getIgVEN0102Form().setEinames(einames.toString());
		dto.getIgVEN0102Form().setEiversions(eiversions.toString());
		dto.getIgVEN0102Form().setRisklys((risklys.toString().replaceAll("\r", " ").replaceAll("\n", " ")));
		dto.getIgVEN0102Form().setRiskitems(riskitems.toString());
		dto.getIgVEN0102Form().setEilabels(eilabels.toString());
		dto.getIgVEN0102Form().setRiskareas(riskareas.toString().replaceAll("\r", " ").replaceAll("\n", " "));
		
		form.setRsid(riskStrategyInfo.getRsid());
		form.setRcname(riskStrategyInfo.getRsname());
		form.setRcfrequencydesc(riskStrategyInfo.getRsfrequencydesc());
		form.setRccommon(riskStrategyInfo.getRsdesc());
		form.setRcstartdate(riskStrategyInfo.getRsstartdate());
		form.setRcenddate(riskStrategyInfo.getRsenddate());
		form.setRcfrequency(riskStrategyInfo.getRsfrequency());
		form.setRcattch(riskStrategyInfo.getRsattachkey());
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ռ����
	 * </p>
	 */
	public IGVEN01DTO updateRiskCheckAction(IGVEN01DTO dto) throws BLException {
		log.debug("========���ռ��������ʼ========");
		RiskStrategyTB csTb = (RiskStrategyTB)riskStrategyBL.searchRiskStrategyByPK(dto.getIgVEN0102Form().getRsid());
		IGVEN0102Form form = dto.getIgVEN0102Form();
		//ɾ������
		if (StringUtils.isNotEmpty(form.getPredelkey())) {
			String[] keys = form.getPredelkey().split(",");
			for (String key : keys) {
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
		}
		//����¸���
		if(StringUtils.isBlank(form.getRcattch())){
			form.setRcattch(IGStringUtils.getAttKey());
		}
		updateAttachment(dto);
		
		// ���Ƶ��
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// Ƶ��Ϊ��
			for (String week : form.getRcfrequencyweek()) {
				if(StringUtils.isEmpty(frequency)){
					frequency = week;
				}else{
					frequency = frequency + "," + week;
				}
			}
			// �����ռ��Ƶ��(ÿ�����һ��)���
			form.setRcfrequencymonthlastday(null);
		}else if("month".equals(form.getRcfrequency())){
			// Ƶ��Ϊ��
			if(form.getRcfrequencymonth()!=null){				
				for (String month : form.getRcfrequencymonth()) {
					if(StringUtils.isEmpty(frequency)){
						frequency = month;
					}else{
						frequency = frequency + "," + month;
					}
				}
			}
		}
		if(!"month".equals(form.getRcfrequency())){
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
		
		//ȡ��ִ�����ڱ��ʽ
		String cronExpression =  null;
		if(StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())){//Ƶ��Ϊÿ�����һ��
			//ȡ��ִ�����ڱ��ʽ,���ռ��Ƶ��(ÿ�����һ��)
			if("1".equals(form.getRcfrequencymonthlastday())){
				//ȡ��ִ�����ڱ��ʽ
				cronExpression =  this.creatCronExp(form.getRcfrequencymonthlastday(),exeHour, exeMinute,form.getRcstartdate(),null);
				frequency = "���һ ";
			}
		}else{//Ƶ��Ϊ�ܡ���
			cronExpression =  this.creatCronExp(form.getRcfrequency(),exeHour, exeMinute,form.getRcstartdate(),frequency);
		}
		form.setRcfrequencydesc(frequency);// ���ռ��Ƶ������
		form.setRccron(cronExpression);// 
		
		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRcupdatetime(date);// ���ռ�鴦��ʱ��yyyy/MM/dd HH:mm
		
		form.setRccreatetime(date);// ���ռ��Ǽ�ʱ��yyyy/MM/dd HH:mm
		// ��¼���ռ����Ϣ
//		RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
//		dto.setRiskCheck(rc);
		csTb = copyPropertie(csTb, form);
		csTb.setRsstatus(IGRISCONSTANTS.RISKS_STRATEGY_DISABLE);
		//���¼�����
		RiskStrategyInfo info = this.riskStrategyBL.updateRiskStrategy(csTb);
		dto.setIgVEN0102Form(form);		
		
		Integer rsid = info.getRsid();
		StrategyIndexRelationSearchCondImpl strategyCond = new StrategyIndexRelationSearchCondImpl();
		strategyCond.setRsid(rsid);
		List<StrategyIndexRelationInfo> riskInfos = strategyIndexRelationBL.searchStrategyIndexRelation(strategyCond);
		
		List<Integer> siridList = new ArrayList<Integer>();
		for(int i =0 ; i<riskInfos.size();i++){
			siridList.add(riskInfos.get(i).getSirid());
		}
		//ȥ���ظ�
		Set<Integer> siridSet = new HashSet<Integer>(siridList);
		//ȡ�õ�����
		Iterator<Integer> iterator = siridSet.iterator();
		//ɾ����صĹ�����Ϣ
		while(iterator.hasNext()){
			strategyIndexRelationBL.deleteStrategyIndexRelationByPK(iterator.next());
		}
		
		List<String> eiids = new ArrayList<String>();
		String[] eiidStrs = dto.getIgVEN0102Form().getEiids().split(",");
		for(int i=0;eiidStrs!=null && i<eiidStrs.length;i++){
			eiids.add(eiidStrs[i]);
		}
		//�������������Ҫͨ���ʲ���eiid��eiversion��ȡ���ʲ�������
		for(int i = 0;i<eiids.size();i++){
			//��ϵ��ʵ��ȡ��
			StrategyIndexRelationTB tb = strategyIndexRelationBL.getStrategyIndexRelationTBInstance();
			tb.setRiid(Integer.parseInt(eiids.get(i)));
			tb.setRsid(info.getRsid());
			strategyIndexRelationBL.registStrategyIndexRelation(tb);
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I003", "�������޸ĳɹ�") );
		log.debug("========���ռ������������========");
		return dto;
	}

	/**
	 * ����¸���
	 * @param dto
	 */
	private void updateAttachment(IGVEN01DTO dto) throws BLException {
		log.debug("========������������ʼ========");
		IGVEN0102Form form = dto.getIgVEN0102Form();
		AttachmentTB attachment = new AttachmentTB();
//		String attkey = IGStringUtils.getAttKey();//����id
		String attkey = form.getRcattch();//����id
		attachment.setAttkey(attkey);
		
		//�ϴ��ļ����
		Map<Integer, FormFile> filemap = form.getFileMap();
		Iterator<Integer> iterator = filemap.keySet().iterator();
		while(iterator.hasNext()){
			FormFile file = filemap.get(iterator.next());
			if ( file != null && file.getFileSize() > 0) {
				//�ϴ��ļ����ڵ����
				//�ϴ��ļ�·��
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				
				//��Ŀ¼
				pathBuf.append(rootPath);
				//��ǰģ��Ŀ¼
				pathBuf.append("risk");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				//�ļ��ϴ�����
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey+"_"+fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				
				//�ϴ��ļ�������
				attachment.setAttname(attkey+"_"+fileName.toString());
				//�ϴ��ļ���URL
				attachment.setAtturl("risk");
					
				this.attachmentBL.registAttachment(attachment);
				
			}
		}
		log.debug("========���������������========");
	}
	
	/**
	 * ���ղ��Ե���״̬����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO changeCheckStrategyStatusOnlyAction(IGVEN01DTO dto) throws BLException {
		
		log.debug("========���ռ�����״̬����ʼ========");
		IGVEN0102Form form = dto.getIgVEN0102Form();
		RiskStrategyInfo info = this.riskStrategyBL.searchRiskStrategyByPK(form.getRsid());
		if(info.getRsfrequency().equals("once")){
			RiskStrategyTB checkTB = (RiskStrategyTB)info;
			dto.setCsid(info.getRsid());
			//�������
			if((IGRISCONSTANTS.RISKS_STRATEGY_DISABLE).equals(info.getRsstatus())){
				checkTB.setRsstatus(IGRISCONSTANTS.RISKS_STRATEGY_ENABLE);
				initRiskCheckResult(dto);
			}else if((IGRISCONSTANTS.RISKS_STRATEGY_ENABLE).equals(info.getRsstatus())){
				checkTB.setRsstatus(IGRISCONSTANTS.RISKS_STRATEGY_DISABLE);
			}
			riskStrategyBL.updateRiskStrategy(checkTB);
		}else{
			changeRiskStatusAction2(info,form);
		}
		return dto;
	}
	 /**
     * 
     * @Title: changeRiskStatusAction
     * @Description: TODO ���ķ��ռ�����״̬�����quarz����/�ı����
     * @param info
     * @throws BLException
     *             void
     * @throws
     */
    private void changeRiskStatusAction2(RiskStrategyInfo info,IGVEN0102Form form) throws BLException {
        RiskStrategyTB chtb = (RiskStrategyTB) info;
        String jobName = "VenCheckJob" + info.getRsid();
        String jobGroupName = "VenCheckGroup" + info.getRsid();
        String triggerName = "VenCheckJobTrigger" + info.getRsid();
        String triggerGroupName = "VenCheckJobTriggerGroup" + info.getRsid();
        // ͣ��״̬���ò���״̬(1.����2.ͣ��)
        if ("2".equals(info.getRsstatus())) {
            chtb.setRsstatus("1");
            // ���Ƶ��
            String frequency = createCron(info,form);// û��create
            // ȡ��ִ�����ڱ��ʽ
            String cronExpression = frequency;
            VenCheckJob riskCheckJob = new VenCheckJob();// ȡ��job
            String creatTime = info.getRsstartdate();
            String endTime = info.getRsenddate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date beganDate = null;
            Date endDate = null;
            log.debug(cronExpression);
            try {
                beganDate = format.parse(creatTime);
                endDate = format.parse(endTime);
                Map<String, Integer> args = new HashMap<String, Integer>();
                args.put("rsid", info.getRsid());
                List<String> keyname = new ArrayList<String>();
                keyname.add("rsid");
                JobManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, riskCheckJob, keyname, args, cronExpression, beganDate,
                        endDate);

            } catch (Exception e) {
                log.error("==========Exception form VenCheckJob===========");
                log.error("quarz����", e);
                throw new BLException("IGRIS0201.E001", "SchedulerException");
            }
        }
        // ����״̬ͣ�ò���
        else {
            chtb.setRsstatus("2");
            try {
                JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
            } catch (SchedulerException e) {
                log.error("==========Exception form VenCheckJob===========");
                log.debug(e.getMessage());
                log.debug("quarz��������", e);
                throw new BLException("", "SchedulerException");
            }
        }
        riskStrategyBL.updateRiskStrategy(chtb);//(chtb);
    }

    private String createCron(RiskStrategyInfo info,IGVEN0102Form form) {
        String frequency = null;
        if ("week".equals(info.getRsfrequency())) {
        	String[] weeks = info.getRsfrequencydesc().split(",");
            // Ƶ��Ϊ��
            for (String week : weeks) {
                if (StringUtils.isEmpty(frequency)) {
                    frequency = week;
                } else {
                    frequency = frequency + "," + week;
                }
            }
        } else if ("month".equals(info.getRsfrequency())) {
        	String[] months = info.getRsfrequencydesc().split(",");
            // Ƶ��Ϊ��
            for (String month : months) {
                if (StringUtils.isEmpty(frequency)) {
                    frequency = month;
                } else {
                    frequency = frequency + "," + month;
                }
            }
        }

        // �� , ����ַ���,�õ�һ������
        String[] startdate = info.getRsstartdate().split("\\ ");
        String starttime = startdate[1];
        String[] begindate = starttime.split("\\:");
        // ʱ
        String exeHour = begindate[0];
        // ��
        String exeMinute = begindate[1];
        // ȡ��ִ�����ڱ��ʽ
        String cronExpression = null;
        // ---------------------getRcfrequencymonthlastday �����form
        // ����ȡ��------------------------------
        if (StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())) {// Ƶ��Ϊÿ�����һ��
            // ȡ��ִ�����ڱ��ʽ,���ռ��Ƶ��(ÿ�����һ��)
            if ("1".equals(form.getRcfrequencymonthlastday())) {
                // ȡ��ִ�����ڱ��ʽ
                cronExpression = this.creatCronExp(form.getRcfrequencymonthlastday(), exeHour, exeMinute, info.getRsstartdate(), null);
                frequency = "���һ";
            }
        } else {// Ƶ��Ϊ�ܡ���
            cronExpression = this.creatCronExp(info.getRsfrequency(), exeHour, exeMinute, info.getRsstartdate(), frequency);
        }
        return cronExpression;

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
	 * ���ղ��Ը����߼�
	 * @param dto
	 * @return IGVEN01DTO
	 * @throws BLException
	 */
	public IGVEN01DTO copyCheckStrategyStatusAction(IGVEN01DTO dto)
			throws BLException {
		// TODO Auto-generated method stub
		Integer rsid = 0;
		rsid = dto.getIgVEN0102Form().getRsid();			
		
		RiskStrategyInfo riskStrategyInfo = this.riskStrategyBL.searchRiskStrategyByPK(rsid);
		
		RiskStrategyTB riskStrategytb = new RiskStrategyTB();
		
		this.copyProperties(riskStrategytb, riskStrategyInfo);
		riskStrategytb.setRsid(0);
		riskStrategytb.setRsstatus(IGRISCONSTANTS.RISKS_STRATEGY_DISABLE);
		//���Ƽ쳵����
		RiskStrategyInfo riskStrategyInfo2 = this.riskStrategyBL.registRiskStrategy(riskStrategytb);
		
		StrategyIndexRelationSearchCondImpl cond = new StrategyIndexRelationSearchCondImpl();
		cond.setRsid(rsid);
		//��ѯ���еļ����Թ������������
		List<StrategyIndexRelationInfo> strategyRiskList =  this.strategyIndexRelationBL.searchStrategyIndexRelation(cond);
		if(strategyRiskList!=null && strategyRiskList.size()>0){
			
			for(int i=0;i<strategyRiskList.size();i++){
				
				StrategyIndexRelationInfo info = strategyRiskList.get(i);
				StrategyIndexRelationTB tb = new StrategyIndexRelationTB();
				//��������
				tb.setRiid(info.getRiid());
				tb.setRsid(riskStrategyInfo2.getRsid());
				tb.setSirid(0);
				//���ƹ�ϵ��
				this.strategyIndexRelationBL.registStrategyIndexRelation(tb);
			}
		}
		return dto;
	}
	/**
	 * ���ܣ����������⹤��ָ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO batchFlowAction(IGVEN01DTO dto) throws BLException{
		log.debug("==============����������������ʼ===============");
		IGVEN0103Form igven0103Form = dto.getIgVEN0103Form();
		User user = dto.getUser();
		//Integer roleid = getInitRoleid();
		Integer[] rcrids =  igven0103Form.getRmids();
		Integer[] prids = new Integer[rcrids.length];
		for(int i = 0;i<rcrids.length;i++){
			
			MonitoringWorkInfo monitoringWorkInfo = monitoringWorkBL.searchMonitoringWorkByPK(rcrids[i]);
			Integer eiid = monitoringWorkInfo.getRiid();
			RiskIndexSearchVWSearchCondImpl cond = new RiskIndexSearchVWSearchCondImpl();
			cond.setEiid(eiid.toString());
			cond.setSyscoding("999019");
			List<RiskIndexSearchVWInfo> vwInfo = riskIndexSearchVWBL.searchRiskIndexSearchVW(cond);
			
			WorkFlowLog workFlowLog = new WorkFlowLog();
			workFlowLog.setExecutorid(user.getUserid());//������ID
			workFlowLog.setExecutorRoleid(3029);
			//workFlowLog.setAuthuserid(user.getUserid());
			Map<String, String> formvalue = new HashMap<String, String>();
			//userRoleBL.searchUserRoleByKey(user.getUserid().tos);
			formvalue.put("ָ����", vwInfo.get(0).getEilabel());
			formvalue.put("��������", vwInfo.get(0).getRiskly());
			formvalue.put("������", vwInfo.get(0).getRiskitem());
			formvalue.put("��������", vwInfo.get(0).getRiskarea());
			formvalue.put("���ռ����������", riskMonitoringBL.searchRiskMonitoringByPK(monitoringWorkInfo.getRmid()).getRmname());
			formvalue.put("���ɱ�ʾ","1");
			formvalue.put("��Ա", rcrids[i].toString());
			ProcessRecord process = new ProcessRecord(workFlowLog);
			//process.setDefstatus("Z");
			process.setCrtuserid(user.getUserid());//������ID
			process.setTitle(vwInfo.get(0).getRiskarea());//����
			process.setDefid("01004");
			process.setRoleid(3029);
			//process.setDefstatus("Z");
			process.setFormvalue(formvalue);
			Integer prid = flowOptBL.initProcessAction(process);
			prids[i] = prid ;
			workFlowLog.setPrid(prid);
			//flowSetBL.setProcessLog(workFlowLog, "", Constants.PROCESS_LOG_TYPE_PROCESSING);
			MonitoringWorkTB tb = (MonitoringWorkTB)monitoringWorkInfo;
			tb.setAssignprid(prid);
			monitoringWorkBL.updateMonitoringWork(tb);
		}
		igven0103Form.setPrids(prids);
		log.debug("==============������������������===============");
		dto.setIgVEN0103Form(igven0103Form);
		return dto;
	}
	
	/**
	 * �����������ҳ���ʼ������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO initIGRIS0402Action(IGVEN01DTO dto) throws BLException {
		log.debug("=================�����������ҳ���ʼ��������ʼ================");
		if (dto.getIgVEN0103Form() != null ) {
			// �ɱ����ɽڵ��ѯ
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL
					.searchAssignedStatusDef("0100401001",
							"10");
			/*for(int i = 0;i<lst_ProcessStatusDef.size();i++){
				if(lst_ProcessStatusDef.get(i).getPsdname()!=null && lst_ProcessStatusDef.get(i).getPsdname().equals("��׼���ִ��")){
					lst_ProcessStatusDef.remove(i);
				}
			}*/
			Map<IG333Info, Map<Role, List<UserInfo>>> map = new LinkedHashMap<IG333Info, Map<Role, List<UserInfo>>>();
			for (IG333Info psd : lst_ProcessStatusDef) {
				map.put(psd, new LinkedHashMap<Role, List<UserInfo>>());
				// ��ѯ�ɷ��ɽ�ɫ
				List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL
						.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
				for (IG298Info psrd : lst_ProcessStatusRoleDef) {
					UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
					userInfoCond.setRoleida(psrd.getRoleid());
					if (IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
						userInfoCond.setOrgida(dto.getUser().getOrgid());
					}
					map.get(psd).put(psrd.getRole(),
							userBL.searchUserInfo(userInfoCond));
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
	public IGVEN01DTO assignAction(IGVEN01DTO dto) throws BLException {
		log.debug("================�������������ʼ===============");
		if (dto.getIgVEN0103Form() != null ) {
			// dto����ȡ��
			IGVEN0103Form form = (IGVEN0103Form) dto.getIgVEN0103Form();
			User user = dto.getUser();
			if (form.getPrids() != null && form.getPrids().length > 0) {
				// �ɱ����ɽڵ��ѯ
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL
						.searchAssignedStatusDef(form.getPrstatus(),
								form.getButtonCode());
				for (Integer prid : form.getPrids()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
					// ��ȡ�û������ɫ
					UserRoleInfo ur = this.workFlowOperationBL
							.getUserRolesInProcessParticipants(prid,
									user.getUserid(), pr.getPrpdid() + form.getPrstatus().substring(7))
							.get(0);
					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(ur.getRoleid());
					// ɾ��ԭ���ڵ������
					StatusParticipant participant = new StatusParticipant(
							logInfo);
					
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
					flowOptBL.transitionProcess(prid, user.getUserid(),
							form.getButtonName(),
							IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================���������������===============");
		return dto;
	}
}
