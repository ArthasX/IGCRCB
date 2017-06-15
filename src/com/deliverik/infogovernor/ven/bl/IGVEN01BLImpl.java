/**   
* @Title: IGVen01BL.java 
* @Package com.deliverik.infogovernor.ven.bl 
* @Description: TODO
* @author wangyaowen@Deliverik.com 
* @date 2014-12-1 上午10:55:23 
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
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	
	/** 历史记录附件业务BL*/
	protected AttachmentBL attachmentBL;
	
	/** 资产信息BL */
	protected SOC0118BL soc0118BL;
	
	/** 资产属性BL*/
	protected SOC0107BL soc0107BL;
	
	/** 风险策略BL*/
	protected RiskStrategyBL riskStrategyBL;
	
	/** 风险策略关联表BL*/
	protected StrategyIndexRelationBL strategyIndexRelationBL;
	
	/** 风险任务BL*/
	protected RiskMonitoringBL riskMonitoringBL;
	
	/** 风险工作BL*/
	protected MonitoringWorkBL monitoringWorkBL;
	
	/** 用户角色授权信息BL*/
	protected UserRoleBL userRoleBL;
	
	/**风险指标查询*/
	protected RiskIndexSearchVWBL riskIndexSearchVWBL;
	
	/** 角色菜单授权BL*/
	protected RoleActionBL roleActionBL;

	/** 流程处理类API */
	protected FlowOptBL flowOptBL;
	
	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 平台用户BL */
	protected UserBL userBL;
	
	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;
	
	/**
	 * 风险策略BL设定
	 * @param riskStrategyBL
	 */
	public void setRiskStrategyBL(RiskStrategyBL riskStrategyBL) {
		this.riskStrategyBL = riskStrategyBL;
	}

	/**
	 * 风险策略关联表BL设定
	 * @param strategyIndexRelationBL
	 */
	public void setStrategyIndexRelationBL(
			StrategyIndexRelationBL strategyIndexRelationBL) {
		this.strategyIndexRelationBL = strategyIndexRelationBL;
	}
	
	/**
	 * 风险任务BL设定
	 * @param riskMonitoringBL
	 */
	public void setRiskMonitoringBL(RiskMonitoringBL riskMonitoringBL) {
		this.riskMonitoringBL = riskMonitoringBL;
	}

	/**
	 * 风险工作BL设定
	 * @param monitoringWorkBL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/**
	 * 文件上传BL设定
	 * @param fileUploadBL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * 历史记录附件业务BL设定
	 * @param attachmentBL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 资产信息BL设定
	 * @param soc0118bl
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * 资产属性BL设定
	 * @param soc0107bl
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	/**
	 * 用户角色授权信息BL设定
	 * @param userRoleBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	
	/**
	 * 风险指标BL设定
	 * @param riskIndexSearchVWBL
	 */
	public void setRiskIndexSearchVWBL(RiskIndexSearchVWBL riskIndexSearchVWBL) {
		this.riskIndexSearchVWBL = riskIndexSearchVWBL;
	}

	/**
	 * 角色菜单授权BL设定
	 * @param roleActionBL the 角色菜单授权BL
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * 流程处理类API设定
	 * @param flowOptBL the 流程处理类API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL the 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 平台用户BL设定
	 * @param userBL the 平台用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL the 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 更新类API设定
	 * @param flowSetBL the 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * <p>
	 * Description: 风险检查登记初始化
	 * </p>
	 */
	public IGVEN01DTO dispRiskCheckAction(IGVEN01DTO dto) throws BLException {
		log.debug("========风险检查登记初始化处理开始========");
		//周集合
		List<IGVEN01022VO> weekList = new ArrayList<IGVEN01022VO>();
		IGVEN01022VO week1vo = new IGVEN01022VO();
		week1vo.setWeekvalue("MON");
		week1vo.setWeekdata("周一");
		weekList.add(week1vo);
		IGVEN01022VO week2vo = new IGVEN01022VO();
		week2vo.setWeekvalue("TUE");
		week2vo.setWeekdata("周二");
		weekList.add(week2vo);
		IGVEN01022VO week3vo = new IGVEN01022VO();
		week3vo.setWeekvalue("WED");
		week3vo.setWeekdata("周三");
		weekList.add(week3vo);
		IGVEN01022VO week4vo = new IGVEN01022VO();
		week4vo.setWeekvalue("THU");
		week4vo.setWeekdata("周四");
		weekList.add(week4vo);
		IGVEN01022VO week5vo = new IGVEN01022VO();
		week5vo.setWeekvalue("FRI");
		week5vo.setWeekdata("周五");
		weekList.add(week5vo);
		IGVEN01022VO week6vo = new IGVEN01022VO();
		week6vo.setWeekvalue("SAT");
		week6vo.setWeekdata("周六");
		weekList.add(week6vo);
		IGVEN01022VO week7vo = new IGVEN01022VO();
		week7vo.setWeekvalue("SUN");
		week7vo.setWeekdata("周日");
		weekList.add(week7vo);
		//每月天数集合
		List<IGVEN01022VO> monthList = new ArrayList<IGVEN01022VO>();;
		for(int i = 1;i<31;i++){
			//天
			String dayvalue = String.valueOf(i);
			//是否已选择
			IGVEN01022VO monthvo = new IGVEN01022VO();
			monthvo.setDayvalue(dayvalue);
			monthList.add(monthvo);
		}
		dto.setWeekList(weekList);
		dto.setMonthList(monthList);
		log.debug("========风险检查登记初始化处理终了========");

		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 检查策略保存
	 * </p>
	 */
	public IGVEN01DTO insertCheckStrategAction(IGVEN01DTO dto) throws BLException{
		
		log.debug("========风险检查新增处理开始========");
		IGVEN0102Form form = dto.getIgVEN0102Form();
		RiskStrategyTB csTb = new RiskStrategyTB();
		AttachmentTB attachment = new AttachmentTB();
		String attkey = IGStringUtils.getAttKey();//附件id
		attachment.setAttkey(attkey);
		
		//上传文件检测
		Map<Integer, FormFile> filemap = form.getFileMap();
		Iterator<Integer> iterator = filemap.keySet().iterator();
		while(iterator.hasNext()){
			FormFile file = filemap.get(iterator.next());
			if ( file != null && file.getFileSize() > 0) {
				//上传文件存在的情况
				//上传文件路径
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				
				//根目录
				pathBuf.append(rootPath);
				//当前模块目录
				pathBuf.append("risk");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				//文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey+"_"+fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				
				//上传文件名保存
				attachment.setAttname(attkey+"_"+fileName.toString());
				//上传文件名URL
				attachment.setAtturl("risk");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		// 检查频率
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// 频率为周
			for (String week : form.getRcfrequencyweek()) {
				if(StringUtils.isEmpty(frequency)){
					frequency = week;
				}else{
					frequency = frequency + "," + week;
				}
			}
		}else if("month".equals(form.getRcfrequency())){
			if(form.getRcfrequencymonth()!=null){				
				// 频率为月
				for (String month : form.getRcfrequencymonth()) {
					if(StringUtils.isEmpty(frequency)){
						frequency = month;
					}else{
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
		//取得执行周期表达式
		String cronExpression =  null;
		
		if(StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())){//频率为每月最后一天
			//取得执行周期表达式,风险检查频率(每月最后一天)
			if("1".equals(form.getRcfrequencymonthlastday())){
				//取得执行周期表达式
				cronExpression =  this.creatCronExp(form.getRcfrequencymonthlastday(),exeHour, exeMinute,form.getRcstartdate(),null);
				frequency = "最后一";
			}
		}else{//频率为周、月
			cronExpression =  this.creatCronExp(form.getRcfrequency(),exeHour, exeMinute,form.getRcstartdate(),frequency);
		}
		
		form.setRcfrequencydesc(frequency);// 风险检查频率内容
		//保存RiskCheck
		form.setRcstatus(IGRISCONSTANTS.RISKS_STRATEGY_ENABLE);//设置状态为启用
		form.setRcattch(attkey);//附件id
		form.setRccron(cronExpression);// 风险检查策略执行表达式
		
		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRccreatetime(date);// 风险检查登记时间yyyy/MM/dd HH:mm
		// 登录风险检查信息
//		RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
//		dto.setRiskCheck(rc);
		csTb = copyPropertie(csTb, form);
		
		RiskStrategyInfo info = this.riskStrategyBL.registRiskStrategy(csTb);
		dto.setIgVEN0102Form(form);
		dto.setRiskStrategyInfo(info);
		
		List<String> eiids = dto.getEiids();
		List<RiskCheck> checkList = new ArrayList<RiskCheck>();
		//插入检查项，这里需要通过资产的eiid和eiversion来取出资产的属性
		for(int i = 0;i<eiids.size();i++){
			//关系表实例取得
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
		dto.addMessage(new ActionMessage( "IGRIS0202.I001", "检查策略设定成功") );
		log.debug("========风险检查新增处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 初始化今天应该进行的风险检查
	 * </p>
	 */
	public void initRiskCheckResult(IGVEN01DTO dto) throws BLException {	
		RiskStrategyInfo info = riskStrategyBL.searchRiskStrategyByPK(dto.getCsid());
		//发起检查任务
		RiskMonitoringTB riskWorkTB = new RiskMonitoringTB();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		//监测任务名称
		riskWorkTB.setRmname(info.getRsname() + format.format(new Date()));
		riskWorkTB.setRsid(info.getRsid());
		riskWorkTB.setRmrate("0");
		riskWorkTB.setRmstartdate(info.getRsstartdate());
		RiskMonitoringInfo cwInfo = riskMonitoringBL.registRiskMonitoring(riskWorkTB);
		//检查任务完毕
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
	 * 复制属性
	 * @param csTb
	 * @param form
	 * @return
	 */
	private RiskStrategyTB copyPropertie(RiskStrategyTB csTb,
			IGVEN0102Form form) {
		// TODO Auto-generated method stub
		csTb.setRsname(form.getRcname());
		csTb.setRsdesc(form.getRccommon());
		//设置为停用
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
	 * Description: 风险检查查询
	 * </p>
	 */
	
	public IGVEN01DTO searchRiskCheckAction(IGVEN01DTO dto) throws BLException {
		log.debug("========风险检查查询处理开始========");
		IGVEN0101Form form = dto.getIgven0101Form();
		RiskStrategySearchCondImpl cond = new RiskStrategySearchCondImpl();
		//设定风险策略名称
		cond.setRsname(form.getRcname());
		
		// 查询记录总数
		int totalCount = this.riskStrategyBL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<RiskStrategyInfo> riskStrategyList = this.riskStrategyBL.searchRiskStrategy(cond, pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		User user = dto.getUser();//当前用户
		UserRoleVWSearchCondImpl usercond = new UserRoleVWSearchCondImpl();
		usercond.setUserid(user.getUserid());
		//取得当前用户所具有的角色
		List<UserRoleInfo> rolelist = this.userRoleBL.searchUserRoleVW(usercond, 0, 0);
		//信息安全岗直接返回所有数据
		for(int i=0;i<rolelist.size();i++){
			if(rolelist.get(i).getRoleid()==1127||rolelist.get(i).getRoleid()==1121){
				dto.setRiskStrategyList(riskStrategyList);
				return dto;
			}
		}
		dto.setRiskStrategyList(riskStrategyList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========风险检查查询处理终了========");
		return dto;
	}
	
	/**	
	 * 功能：根据检查策略id查询检查策略
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
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
		//设定一个不存在的EIID，下面做判断
		riskCond.setEiid_In("'0'");
		if(strategyList!=null && strategyList.size()>0){
			//获取所有的风险指标
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
	 * Description: 风险检查变更
	 * </p>
	 */
	public IGVEN01DTO updateRiskCheckAction(IGVEN01DTO dto) throws BLException {
		log.debug("========风险检查变更处理开始========");
		RiskStrategyTB csTb = (RiskStrategyTB)riskStrategyBL.searchRiskStrategyByPK(dto.getIgVEN0102Form().getRsid());
		IGVEN0102Form form = dto.getIgVEN0102Form();
		//删除附件
		if (StringUtils.isNotEmpty(form.getPredelkey())) {
			String[] keys = form.getPredelkey().split(",");
			for (String key : keys) {
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
		}
		//添加新附件
		if(StringUtils.isBlank(form.getRcattch())){
			form.setRcattch(IGStringUtils.getAttKey());
		}
		updateAttachment(dto);
		
		// 检查频率
		String frequency = null;
		if ("week".equals(form.getRcfrequency())) {
			// 频率为周
			for (String week : form.getRcfrequencyweek()) {
				if(StringUtils.isEmpty(frequency)){
					frequency = week;
				}else{
					frequency = frequency + "," + week;
				}
			}
			// 将风险检查频率(每月最后一天)清空
			form.setRcfrequencymonthlastday(null);
		}else if("month".equals(form.getRcfrequency())){
			// 频率为月
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
		
		//取得执行周期表达式
		String cronExpression =  null;
		if(StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())){//频率为每月最后一天
			//取得执行周期表达式,风险检查频率(每月最后一天)
			if("1".equals(form.getRcfrequencymonthlastday())){
				//取得执行周期表达式
				cronExpression =  this.creatCronExp(form.getRcfrequencymonthlastday(),exeHour, exeMinute,form.getRcstartdate(),null);
				frequency = "最后一 ";
			}
		}else{//频率为周、月
			cronExpression =  this.creatCronExp(form.getRcfrequency(),exeHour, exeMinute,form.getRcstartdate(),frequency);
		}
		form.setRcfrequencydesc(frequency);// 风险检查频率内容
		form.setRccron(cronExpression);// 
		
		Date nowDateTime = new Date();
		String date = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setRcupdatetime(date);// 风险检查处理时间yyyy/MM/dd HH:mm
		
		form.setRccreatetime(date);// 风险检查登记时间yyyy/MM/dd HH:mm
		// 登录风险检查信息
//		RiskCheck rc = this.riskCheckBL.registRiskCheck(form);
//		dto.setRiskCheck(rc);
		csTb = copyPropertie(csTb, form);
		csTb.setRsstatus(IGRISCONSTANTS.RISKS_STRATEGY_DISABLE);
		//更新检查策略
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
		//去除重复
		Set<Integer> siridSet = new HashSet<Integer>(siridList);
		//取得迭代器
		Iterator<Integer> iterator = siridSet.iterator();
		//删除相关的关联信息
		while(iterator.hasNext()){
			strategyIndexRelationBL.deleteStrategyIndexRelationByPK(iterator.next());
		}
		
		List<String> eiids = new ArrayList<String>();
		String[] eiidStrs = dto.getIgVEN0102Form().getEiids().split(",");
		for(int i=0;eiidStrs!=null && i<eiidStrs.length;i++){
			eiids.add(eiidStrs[i]);
		}
		//插入检查项，这里需要通过资产的eiid和eiversion来取出资产的属性
		for(int i = 0;i<eiids.size();i++){
			//关系表实例取得
			StrategyIndexRelationTB tb = strategyIndexRelationBL.getStrategyIndexRelationTBInstance();
			tb.setRiid(Integer.parseInt(eiids.get(i)));
			tb.setRsid(info.getRsid());
			strategyIndexRelationBL.registStrategyIndexRelation(tb);
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I003", "检查策略修改成功") );
		log.debug("========风险检查变更处理终了========");
		return dto;
	}

	/**
	 * 添加新附件
	 * @param dto
	 */
	private void updateAttachment(IGVEN01DTO dto) throws BLException {
		log.debug("========附件新增处理开始========");
		IGVEN0102Form form = dto.getIgVEN0102Form();
		AttachmentTB attachment = new AttachmentTB();
//		String attkey = IGStringUtils.getAttKey();//附件id
		String attkey = form.getRcattch();//附件id
		attachment.setAttkey(attkey);
		
		//上传文件检测
		Map<Integer, FormFile> filemap = form.getFileMap();
		Iterator<Integer> iterator = filemap.keySet().iterator();
		while(iterator.hasNext()){
			FormFile file = filemap.get(iterator.next());
			if ( file != null && file.getFileSize() > 0) {
				//上传文件存在的情况
				//上传文件路径
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				
				//根目录
				pathBuf.append(rootPath);
				//当前模块目录
				pathBuf.append("risk");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				//文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey+"_"+fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				
				//上传文件名保存
				attachment.setAttname(attkey+"_"+fileName.toString());
				//上传文件名URL
				attachment.setAtturl("risk");
					
				this.attachmentBL.registAttachment(attachment);
				
			}
		}
		log.debug("========附件新增处理结束========");
	}
	
	/**
	 * 风险策略调整状态处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO changeCheckStrategyStatusOnlyAction(IGVEN01DTO dto) throws BLException {
		
		log.debug("========风险检查调整状态处理开始========");
		IGVEN0102Form form = dto.getIgVEN0102Form();
		RiskStrategyInfo info = this.riskStrategyBL.searchRiskStrategyByPK(form.getRsid());
		if(info.getRsfrequency().equals("once")){
			RiskStrategyTB checkTB = (RiskStrategyTB)info;
			dto.setCsid(info.getRsid());
			//点击启用
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
     * @Description: TODO 更改风险监测策略状态，添加quarz任务/改变策略
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
        // 停用状态启用策略状态(1.启用2.停用)
        if ("2".equals(info.getRsstatus())) {
            chtb.setRsstatus("1");
            // 检查频率
            String frequency = createCron(info,form);// 没有create
            // 取得执行周期表达式
            String cronExpression = frequency;
            VenCheckJob riskCheckJob = new VenCheckJob();// 取得job
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
                log.error("quarz报错", e);
                throw new BLException("IGRIS0201.E001", "SchedulerException");
            }
        }
        // 启用状态停用策略
        else {
            chtb.setRsstatus("2");
            try {
                JobManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
            } catch (SchedulerException e) {
                log.error("==========Exception form VenCheckJob===========");
                log.debug(e.getMessage());
                log.debug("quarz启动报错", e);
                throw new BLException("", "SchedulerException");
            }
        }
        riskStrategyBL.updateRiskStrategy(chtb);//(chtb);
    }

    private String createCron(RiskStrategyInfo info,IGVEN0102Form form) {
        String frequency = null;
        if ("week".equals(info.getRsfrequency())) {
        	String[] weeks = info.getRsfrequencydesc().split(",");
            // 频率为周
            for (String week : weeks) {
                if (StringUtils.isEmpty(frequency)) {
                    frequency = week;
                } else {
                    frequency = frequency + "," + week;
                }
            }
        } else if ("month".equals(info.getRsfrequency())) {
        	String[] months = info.getRsfrequencydesc().split(",");
            // 频率为月
            for (String month : months) {
                if (StringUtils.isEmpty(frequency)) {
                    frequency = month;
                } else {
                    frequency = frequency + "," + month;
                }
            }
        }

        // 按 , 拆分字符串,得到一个数组
        String[] startdate = info.getRsstartdate().split("\\ ");
        String starttime = startdate[1];
        String[] begindate = starttime.split("\\:");
        // 时
        String exeHour = begindate[0];
        // 分
        String exeMinute = begindate[1];
        // 取得执行周期表达式
        String cronExpression = null;
        // ---------------------getRcfrequencymonthlastday 将会从form
        // 里面取得------------------------------
        if (StringUtils.isNotEmpty(form.getRcfrequencymonthlastday())) {// 频率为每月最后一天
            // 取得执行周期表达式,风险检查频率(每月最后一天)
            if ("1".equals(form.getRcfrequencymonthlastday())) {
                // 取得执行周期表达式
                cronExpression = this.creatCronExp(form.getRcfrequencymonthlastday(), exeHour, exeMinute, info.getRsstartdate(), null);
                frequency = "最后一";
            }
        } else {// 频率为周、月
            cronExpression = this.creatCronExp(info.getRsfrequency(), exeHour, exeMinute, info.getRsstartdate(), frequency);
        }
        return cronExpression;

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
	 * 风险策略复制逻辑
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
		//复制检车策略
		RiskStrategyInfo riskStrategyInfo2 = this.riskStrategyBL.registRiskStrategy(riskStrategytb);
		
		StrategyIndexRelationSearchCondImpl cond = new StrategyIndexRelationSearchCondImpl();
		cond.setRsid(rsid);
		//查询所有的检查策略关联检查项数据
		List<StrategyIndexRelationInfo> strategyRiskList =  this.strategyIndexRelationBL.searchStrategyIndexRelation(cond);
		if(strategyRiskList!=null && strategyRiskList.size()>0){
			
			for(int i=0;i<strategyRiskList.size();i++){
				
				StrategyIndexRelationInfo info = strategyRiskList.get(i);
				StrategyIndexRelationTB tb = new StrategyIndexRelationTB();
				//复制属性
				tb.setRiid(info.getRiid());
				tb.setRsid(riskStrategyInfo2.getRsid());
				tb.setSirid(0);
				//复制关系表
				this.strategyIndexRelationBL.registStrategyIndexRelation(tb);
			}
		}
		return dto;
	}
	/**
	 * 功能：批量发起监测工作指派流程
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO batchFlowAction(IGVEN01DTO dto) throws BLException{
		log.debug("==============变更批量处理操作开始===============");
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
			workFlowLog.setExecutorid(user.getUserid());//处理人ID
			workFlowLog.setExecutorRoleid(3029);
			//workFlowLog.setAuthuserid(user.getUserid());
			Map<String, String> formvalue = new HashMap<String, String>();
			//userRoleBL.searchUserRoleByKey(user.getUserid().tos);
			formvalue.put("指标编号", vwInfo.get(0).getEilabel());
			formvalue.put("风险领域", vwInfo.get(0).getRiskly());
			formvalue.put("风险项", vwInfo.get(0).getRiskitem());
			formvalue.put("风险子域", vwInfo.get(0).getRiskarea());
			formvalue.put("风险监测任务名称", riskMonitoringBL.searchRiskMonitoringByPK(monitoringWorkInfo.getRmid()).getRmname());
			formvalue.put("分派标示","1");
			formvalue.put("人员", rcrids[i].toString());
			ProcessRecord process = new ProcessRecord(workFlowLog);
			//process.setDefstatus("Z");
			process.setCrtuserid(user.getUserid());//发起人ID
			process.setTitle(vwInfo.get(0).getRiskarea());//标题
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
		log.debug("==============变更批量处理操作结束===============");
		dto.setIgVEN0103Form(igven0103Form);
		return dto;
	}
	
	/**
	 * 变更批量处理页面初始化操作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVEN01DTO initIGRIS0402Action(IGVEN01DTO dto) throws BLException {
		log.debug("=================变更批量处理页面初始化操作开始================");
		if (dto.getIgVEN0103Form() != null ) {
			// 可被分派节点查询
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL
					.searchAssignedStatusDef("0100401001",
							"10");
			/*for(int i = 0;i<lst_ProcessStatusDef.size();i++){
				if(lst_ProcessStatusDef.get(i).getPsdname()!=null && lst_ProcessStatusDef.get(i).getPsdname().equals("标准变更执行")){
					lst_ProcessStatusDef.remove(i);
				}
			}*/
			Map<IG333Info, Map<Role, List<UserInfo>>> map = new LinkedHashMap<IG333Info, Map<Role, List<UserInfo>>>();
			for (IG333Info psd : lst_ProcessStatusDef) {
				map.put(psd, new LinkedHashMap<Role, List<UserInfo>>());
				// 查询可分派角色
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
	public IGVEN01DTO assignAction(IGVEN01DTO dto) throws BLException {
		log.debug("================变更批量操作开始===============");
		if (dto.getIgVEN0103Form() != null ) {
			// dto参数取得
			IGVEN0103Form form = (IGVEN0103Form) dto.getIgVEN0103Form();
			User user = dto.getUser();
			if (form.getPrids() != null && form.getPrids().length > 0) {
				// 可被分派节点查询
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL
						.searchAssignedStatusDef(form.getPrstatus(),
								form.getButtonCode());
				for (Integer prid : form.getPrids()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
					// 获取用户处理角色
					UserRoleInfo ur = this.workFlowOperationBL
							.getUserRolesInProcessParticipants(prid,
									user.getUserid(), pr.getPrpdid() + form.getPrstatus().substring(7))
							.get(0);
					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(ur.getRoleid());
					// 删除原来节点参与者
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
					// 跃迁流程
					flowOptBL.transitionProcess(prid, user.getUserid(),
							form.getButtonName(),
							IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================变更批量操作结束===============");
		return dto;
	}
}
