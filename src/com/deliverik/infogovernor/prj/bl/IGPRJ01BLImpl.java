/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.fin.bl.task.BudgetBL;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.prj.bl.task.InvestUseInfoBL;
import com.deliverik.infogovernor.prj.bl.task.PbsummaryVWBL;
import com.deliverik.infogovernor.prj.bl.task.ProjectBL;
import com.deliverik.infogovernor.prj.bl.task.ProjectBudgetRelationBL;
import com.deliverik.infogovernor.prj.bl.task.ProjectLogBL;
import com.deliverik.infogovernor.prj.bl.task.ProjectLogBusinessBL;
import com.deliverik.infogovernor.prj.bl.task.ProjectLogContractBL;
import com.deliverik.infogovernor.prj.bl.task.ProjectPlanBL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0101DetailForm;
import com.deliverik.infogovernor.prj.form.IGPRJ0102Form;
import com.deliverik.infogovernor.prj.form.IGPRJ0109Form;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.ProjectBudgetRelationInfo;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.ProjectLogContractInfo;
import com.deliverik.infogovernor.prj.model.ProjectPlan;
import com.deliverik.infogovernor.prj.model.condition.InvestUseInfoSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.ProjectBudgetRelationSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogBusinessSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogContractSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCond;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.ProjectPlanSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCondImpl;
import com.deliverik.infogovernor.prj.model.entity.ProjectBudgetRelationTB;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogBusinessTB;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogContractTB;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogTB;
import com.deliverik.infogovernor.prj.model.entity.ProjectTB;
import com.deliverik.infogovernor.prj.vo.IGPRJ01011VO;
import com.deliverik.infogovernor.prj.vo.IGPRJ01HistoryVO;
import com.deliverik.infogovernor.util.PRJHelper;
import com.deliverik.infogovernor.util.SVCHelper;

public class IGPRJ01BLImpl extends BaseBLImpl implements IGPRJ01BL {

	static Log log = LogFactory.getLog(IGPRJ01BLImpl.class);

	protected ProjectBL projectBL;

	protected ProjectLogBL projectLogBL;

	protected AttachmentBL attachmentBL;

	protected UserRoleBL userRoleBL;

	protected FileUploadBL fileUploadBL;

	protected CodeDetailBL codeDetailBL;

	protected RoleBL roleBL;
	
	protected ProjectLogContractBL projectLogContractBL;
	
	protected ProjectLogBusinessBL projectLogBusinessBL;
	
	protected BudgetBL budgetBL;
	
	protected ProjectPlanBL projectPlanBL;
	
	/**预算及工程分类信息视图BL*/
	protected PbsummaryVWBL pbsummaryVWBL;
	
	/** 项目与预算关系bl */
	protected ProjectBudgetRelationBL projectBudgetRelationBL;
	
	/** 投资使用情况bl */
	protected InvestUseInfoBL investUseInfoBL;
	
	/**
	 * 预算及工程分类信息视图BL设定
	 * @param pbsummaryVWBL 预算及工程分类信息视图BL
	 */
	public void setPbsummaryVWBL(PbsummaryVWBL pbsummaryVWBL) {
		this.pbsummaryVWBL = pbsummaryVWBL;
	}
	/**
	 * projectPlanBL设定
	 * @param projectPlanBL projectPlanBL
	 */
	public void setProjectPlanBL(ProjectPlanBL projectPlanBL) {
		this.projectPlanBL = projectPlanBL;
	}

	public void setBudgetBL(BudgetBL budgetBL) {
		this.budgetBL = budgetBL;
	}
	
	public void setProjectLogBusinessBL(ProjectLogBusinessBL projectLogBusinessBL) {
		this.projectLogBusinessBL = projectLogBusinessBL;
	}

	public void setProjectLogContractBL(ProjectLogContractBL projectLogContractBL) {
		this.projectLogContractBL = projectLogContractBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setProjectBL(ProjectBL projectBL) {
		this.projectBL = projectBL;
	}

	public void setProjectLogBL(ProjectLogBL projectLogBL) {
		this.projectLogBL = projectLogBL;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 投资使用情况bl设定
	 * @param investUseInfoBL 投资使用情况bl
	 */
	public void setInvestUseInfoBL(InvestUseInfoBL investUseInfoBL) {
		this.investUseInfoBL = investUseInfoBL;
	}
	/**
	 * 项目与预算关系bl设定
	 * @param projectBudgetRelationBL 项目与预算关系bl
	 */
	public void setProjectBudgetRelationBL(
			ProjectBudgetRelationBL projectBudgetRelationBL) {
		this.projectBudgetRelationBL = projectBudgetRelationBL;
	}
	/**
	 * 根据项目类型编码，返回项目类型名称
	 */
	public IGPRJ01DTO findProjectTypeAction(IGPRJ01DTO dto) {
		String topcode = "";
		StringBuffer ptype_name = new StringBuffer();
		CodeDetailSearchCondImpl cdscond = new CodeDetailSearchCondImpl();
		String ptype = dto.getPtype();
		//查询项目类别
		if(StringUtils.isNotEmpty(ptype)){
			if(ptype!=null && ptype.length()>6){
				topcode = ptype.substring(0,6);
				cdscond.setSyscoding(topcode);
				List<CodeDetail> detailList = codeDetailBL.searchCodeDetail(cdscond, 0);
				if(detailList!=null && detailList.size()>0){
					ptype_name.append(detailList.get(0).getCvalue());
					ptype_name.append("-");
				}

			}
			cdscond.setSyscoding(ptype);
			List<CodeDetail> list = codeDetailBL.searchCodeDetail(cdscond, 0);
			if(list!=null && list.size()>0){
				ptype_name.append(list.get(0).getCvalue());
			}
			dto.setPtype_name(ptype_name.toString());
		}else{
			dto.setPtype_name("");
		}

		return dto;

	}

	//插入登记信息
	public IGPRJ01DTO insertEntityAction(IGPRJ01DTO dto) throws BLException {

		IGPRJ0102Form igprj0102Form = dto.getIgPrj0102Form();
		User user = dto.getUser();
		String pcode = igprj0102Form.getPcode();
		ProjectSearchCondImpl cond = new ProjectSearchCondImpl();
		//取项目编号
		if(StringUtils.isNotEmpty(pcode)){
			cond.setPcode(pcode);
			List<Project> projectList = this.projectBL.findByCond(cond, 0, 0);
			if(null != projectList && projectList.size() > 0) {
				return dto;
			}
		} else {
			int projectIndex = projectBL.findAllProject().size();
			pcode = PRJHelper.getPcode(projectIndex);
			boolean flag = true;
			while(flag){
				cond.setPcode(pcode);
				List<Project> projectList = this.projectBL.findByCond(cond, 0, 0);
				if(null != projectList && projectList.size() > 0){
					pcode = PRJHelper.getPcode(projectIndex + 1);
					continue;
				}
				flag = false;
			}
			igprj0102Form.setPcode(pcode);
		}
		String orgsyscoding = user.getOrgid();//当期用户的所属机构
		String porg = "";
		//取登记人所属机构的前2级作为porg
		if(orgsyscoding!=null && orgsyscoding.length()>7){
			porg = orgsyscoding.substring(0,7);
		}else if(orgsyscoding!=null && orgsyscoding.length()<=7){
			porg = orgsyscoding;
		}
		igprj0102Form.setPorg(porg);
		//=================================================================
		//获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String currentTime = format.format(new Date());
		//定义项目总计资本金（开发）总额
		double pbzdevelop = 0.0;
		//定义项目总计资本金（硬件）总额
		double pbzhardware = 0.0;
		//定义项目总计资本金（软件）总额
		double pbzsoftware = 0.0;
		//定义项目总计资本金（工程）总额
		double pbzproject = 0.0;
		//定义项目总计资本金（其他）总额
		double pbzelse = 0.0;
		//定义项目总计成本金（实施）总额
		double pbcimplement = 0.0;
		//定义项目总计成本金（其他）总额
		double pbcelse = 0.0;
		//定义预算-项目关系实体集合
		List<ProjectBudgetRelationTB> pbRelationList = new ArrayList<ProjectBudgetRelationTB>();
		if(igprj0102Form.getBzdevelop()!=null&&igprj0102Form.getBzdevelop().length>0){
			for(int i=0;i<igprj0102Form.getBzdevelop().length;i++){
				//获取项目总计资本金（开发）金额；
				pbzdevelop+=igprj0102Form.getBzdevelop()[i];
				//获取项目总计资本金（硬件）金额；
				pbzhardware+=igprj0102Form.getBzhardware()[i];
				//获取项目总计资本金（软件）金额；
				pbzsoftware+=igprj0102Form.getBzsoftware()[i];
				//获取项目总计资本金（工程）金额；
				pbzproject+=igprj0102Form.getBzproject()[i];
				//获取项目总计资本金（其他）金额；
				pbzelse+=igprj0102Form.getBzelse()[i];
				//获取项目总计成本金（实施）金额；
				pbcimplement+=igprj0102Form.getBcimplement()[i];
				//获取项目总计成本金（其他）金额；
				pbcelse+=igprj0102Form.getBcelse()[i];
				//保存预算-项目关系实体
				ProjectBudgetRelationTB pbRelationTB = new ProjectBudgetRelationTB();
				pbRelationTB.setBid(igprj0102Form.getBid()[i]);
				pbRelationTB.setBzdevelop(igprj0102Form.getBzdevelop()[i]);
				pbRelationTB.setBzhardware(igprj0102Form.getBzhardware()[i]);
				pbRelationTB.setBzsoftware(igprj0102Form.getBzsoftware()[i]);
				pbRelationTB.setBzproject(igprj0102Form.getBzproject()[i]);
				pbRelationTB.setBzelse(igprj0102Form.getBzelse()[i]);
				pbRelationTB.setBcimplement(igprj0102Form.getBcimplement()[i]);
				pbRelationTB.setBcelse(igprj0102Form.getBcelse()[i]);
				pbRelationTB.setPbdatetime(currentTime);
				pbRelationList.add(pbRelationTB);
			}
		}
		ProjectTB project = new ProjectTB();
		project.setPname(igprj0102Form.getPname());
		project.setPcode(pcode);
		project.setPopentime(igprj0102Form.getPopentime());
		project.setPclosetime(igprj0102Form.getPclosetime());
		project.setPplanclosetime(igprj0102Form.getPplanclosetime());
		project.setPdesc(igprj0102Form.getPdesc());
		project.setPaim(igprj0102Form.getPaim());
		project.setPpurpose(igprj0102Form.getPpurpose());
		project.setPbranch(igprj0102Form.getPbranch());
		project.setIsUseBudget(igprj0102Form.getIsUseBudget());
		project.setPorg(porg);
		project.setPstatus(IGPRJ01BLType.OPEN_STATUS);
		project.setPuser(user.getUserid());
		project.setPlcid(igprj0102Form.getPlcid());
		project.setPpquality(igprj0102Form.getPpquality());
		project.setPtype(igprj0102Form.getPtype());
		//保存项目发起人信息，用于过滤按钮
		project.setProle(igprj0102Form.getProle());
		if(igprj0102Form.getIsUseBudget().equals(IGPRJ01BLType.USE_BUDGET)){
			project.setPzdevelop(pbzdevelop);
			project.setPzhardware(pbzhardware);
			project.setPzsoftware(pbzsoftware);
			project.setPzproject(pbzproject);
			project.setPzelse(pbzelse);
			project.setPcimplement(pbcimplement);
			project.setPcelse(pbcelse);
			project.setPlimit(pbzdevelop+pbzhardware+pbzsoftware+pbzproject+pbzelse+pbcimplement+pbcelse);
		}else{
			project.setPzdevelop(igprj0102Form.getPbzdevelop());
			project.setPzhardware(igprj0102Form.getPbzhardware());
			project.setPzsoftware(igprj0102Form.getPbzsoftware());
			project.setPzproject(igprj0102Form.getPbzproject());
			project.setPzelse(igprj0102Form.getPbzelse());
			project.setPcimplement(igprj0102Form.getPbcimplement());
			project.setPcelse(igprj0102Form.getPbcelse());
			project.setPlimit(igprj0102Form.getPbzdevelop()+igprj0102Form.getPbzhardware()+igprj0102Form.getPbzsoftware()+igprj0102Form.getPbzproject()+igprj0102Form.getPbzelse()+igprj0102Form.getPbcimplement()+igprj0102Form.getPbcelse());
		}
		//=================================================================
		//项目发起
		Project retProject = this.projectBL.saveProject(project);
		if(igprj0102Form.getIsUseBudget().equals(IGPRJ01BLType.USE_BUDGET)){
			for(ProjectBudgetRelationTB pbRelation : pbRelationList){
				pbRelation.setPid(retProject.getPid());
				projectBudgetRelationBL.saveProjectBudgetRelation(pbRelation);
			}
		}
		dto.setProject(retProject);
		igprj0102Form.setPid(retProject.getPid());
		return dto;
	}

	// 根据查询条件取得结果
	public IGPRJ01DTO findProjectByCond(IGPRJ01DTO dto) throws BLException {

		int totalCount = this.projectBL.getSearchCount(dto.getProjectSearchCond());
		PagingDTO pDto = dto.getPagingDto();
		List<Project> projectTempList = this.projectBL.findByCond(dto.getProjectSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		List<Pbsummary> pbsummaryList = pbsummaryVWBL.searchPbsummary(new PbsummaryVWSearchCondImpl(), 0, 0);
		Map<Integer, List<Pbsummary>> pbsummaryMap = new HashMap<Integer, List<Pbsummary>>();
		if(pbsummaryList!=null&&pbsummaryList.size()>0){
			for(Pbsummary pbsum:pbsummaryList){
				if(pbsummaryMap.get(pbsum.getPid())==null){
					List<Pbsummary> pbList = new ArrayList<Pbsummary>();
					pbList.add(pbsum);
					pbsummaryMap.put(pbsum.getPid(), pbList);
				}else{
					pbsummaryMap.get(pbsum.getPid()).add(pbsum);
				}
			}
		}
		List<IGPRJ01011VO> voList = new ArrayList<IGPRJ01011VO>();
		if(projectTempList!=null&&projectTempList.size()>0){
			for(Project p:projectTempList){
				IGPRJ01011VO vo = new IGPRJ01011VO();
				vo.setIsUseBudget(p.getIsUseBudget());
				vo.setPid(p.getPid());
				vo.setPname(p.getPname());
				vo.setPlimit(p.getPlimit());
				vo.setPcode(p.getPcode());
				vo.setPopentime(p.getPopentime());
				vo.setPclosetime(p.getPclosetime());
				vo.setPstatus(p.getPstatus());
				vo.setPbsummaryList(pbsummaryMap.get(p.getPid()));
				voList.add(vo);
			}
		}
		dto.setVoList(voList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		pDto.setTotalCount(totalCount);
		return dto;

	}

	/**
	 * <p>
	 * Description: 获取项目按钮显示（处理按钮权限）
	 * </p>
	 */
	public IGPRJ01DTO findProjectById(IGPRJ01DTO dto) throws BLException {
		log.debug("========获取项目按钮显示开始========");

		String projectId = dto.getProjectId();
		// 查询项目信息
		Project project = this.projectBL.findByPK(Integer.valueOf(projectId));
		IGPRJ0102Form form = new IGPRJ0102Form();
		//根据项目ID找到所属预算
		Budget budget = budgetBL.findByPK(project.getPbid());
		if(budget!=null){
			form.setPbname(budget.getBtitle().toString());
			form.setPamount(budget.getBamount().toString());
		}else{
			form.setPbname(null);
			form.setPamount(null);
		}
		form.setPaim(project.getPaim());
		form.setPamount(project.getPamount());
		form.setPbranch(project.getPbranch());
		form.setPclosetime(project.getPclosetime());
		form.setPstatus(project.getPstatus());
		form.setPopentime(project.getPopentime());
		form.setPlimit(project.getPlimit());
		form.setPuse(project.getPuse());
		form.setPdesc(project.getPdesc());
		form.setPcode(project.getPcode());
		form.setPname(project.getPname());
		form.setPpurpose(project.getPpurpose());
		form.setIsUseBudget(project.getIsUseBudget());
		form.setPplanclosetime(project.getPplanclosetime());
		// 添加项目信息到VO中
		dto.setProject(project);
		dto.setIgPrj0102Form(form);
		

		List<String> actionList = new ArrayList<String>();// 按钮集合
		User user = dto.getUser();
		String prole = project.getProle();
		String puser = project.getPuser();
		String userid = user.getUserid();
		if (prole != null) {
			String[] proles = project.getProle().split(",");// 项目负责人
			// 判断当前用户是否为项目负责人，并授予相应的按钮权限
			if (proles != null) {
				for (int i = 0, j = proles.length; i < j; i++) {
					if (userid.equals(proles[i])) {
						
						if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_TZJH)) {
							actionList.add(IGPRJ01BLType.PROJECT_ACTION_TZJH);
						}
						if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_XMJZ)) {
							actionList.add(IGPRJ01BLType.PROJECT_ACTION_XMJZ);
						}
						if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_ZTJK)) {
							actionList.add(IGPRJ01BLType.PROJECT_ACTION_ZTJK);
						}
						if(!"C".equals(project.getPstatus())){
							if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_XMRZ)) {
								actionList.add(IGPRJ01BLType.PROJECT_ACTION_XMRZ);
							}
							if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_XMGB)) {
								actionList.add(IGPRJ01BLType.PROJECT_ACTION_XMGB);
							}
						}
						if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_CKLS)) {
							actionList.add(IGPRJ01BLType.PROJECT_ACTION_CKLS);
						}
						if(!"C".equals(project.getPstatus())){
							if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_FZR)) {
								actionList.add(IGPRJ01BLType.PROJECT_ACTION_FZR);
							}
							if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_CYR)) {
								actionList.add(IGPRJ01BLType.PROJECT_ACTION_CYR);
							}
						}
						dto.setActionnameList(actionList);
						log.debug("========获取项目按钮显示结束========");
						return dto;
					}
				}
			}
		}
		
		if (puser != null) {
			String[] pusers = project.getPuser().split(",");// 项目参与人
			// 判断当前用户是否为项目参与人，并授予相应的按钮权限
			if (pusers != null) {
				for (int i = 0, j = pusers.length; i < j; i++) {
					if (userid.equals(pusers[i])) {

						if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_TZJH)) {
							actionList.add(IGPRJ01BLType.PROJECT_ACTION_TZJH);
						}
						if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_XMJZ)) {
							actionList.add(IGPRJ01BLType.PROJECT_ACTION_XMJZ);
						}
						if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_ZTJK)) {
							actionList.add(IGPRJ01BLType.PROJECT_ACTION_ZTJK);
						}
						if(!"C".equals(project.getPstatus())){
							if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_XMRZ)) {
								actionList.add(IGPRJ01BLType.PROJECT_ACTION_XMRZ);
							}
						}
						if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_CKLS)) {
							actionList.add(IGPRJ01BLType.PROJECT_ACTION_CKLS);
						}
						
						
						dto.setActionnameList(actionList);
						log.debug("========获取项目按钮显示结束========");
						return dto;
					}
				}
			}
		}
		
		//若既不是负责人也不是参与人
		if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_ZTJK)) {
			actionList.add(IGPRJ01BLType.PROJECT_ACTION_ZTJK);
		}
		if (!actionList.contains(IGPRJ01BLType.PROJECT_ACTION_CKLS)) {
			actionList.add(IGPRJ01BLType.PROJECT_ACTION_CKLS);
		}
		dto.setActionnameList(actionList);
		log.debug("========获取项目按钮显示结束========");
		return dto;
	}

	protected List<ProjectLog> findProjectLogByCond(IGPRJ01DTO dto)throws BLException {
		ProjectLogSearchCond cond = dto.getProjectLogSearchCond();
		List<ProjectLog> projectLogList = this.projectLogBL.findByCond(cond, 0, 0);
		return projectLogList;
	}

	// 插入ProjectLog表
	public IGPRJ01DTO insertProjectLog(IGPRJ01DTO dto) throws BLException {
		IGPRJ0101DetailForm form = dto.getIGPRJ0101DetailForm();
		String attkey = this.insertUploadFile(dto);
//		form.setSiattkey(attkey);
		ProjectLogTB projectLogTB = new ProjectLogTB();
		projectLogTB.setPid(form.getPid());
		projectLogTB.setPlroleid(form.getPlroleid());
		projectLogTB.setPlrolename(form.getPlrolename());
		projectLogTB.setPluserid(form.getPluserid());
		projectLogTB.setPlusername(form.getPlusername());
		projectLogTB.setPlinfo(form.getPlinfo());
		projectLogTB.setPltype(form.getPltype());
		projectLogTB.setPltime(form.getPltime());
		projectLogTB.setPlattkey(attkey);
		ProjectLog projectLog = this.projectLogBL.saveProjectLog(projectLogTB);
		/**当日志信息为合同签订时，将数据插入项目日志合同表*/
		if(form.getPltype().equals(IGPRJ01BLType.PROJECT_LOG_ContractTypeC)){
			int pbsummaryListSize = form.getPbsummaryListSize();
			ProjectLogContractTB projectLogContractTB = new ProjectLogContractTB();
			projectLogContractTB.setPlcsum(Double.parseDouble(form.getPlcsum()));
			projectLogContractTB.setPlcsumterm(form.getPlcsumterm());
			if(StringUtils.isNotEmpty(form.getPlcfirst())){
				projectLogContractTB.setPlcfirst(Double.parseDouble(form.getPlcfirst()));
			}
			projectLogContractTB.setPlcfirstterm(form.getPlcfirstterm());
			if(StringUtils.isNotEmpty(form.getPlcsecond())){
				projectLogContractTB.setPlcsecond(Double.parseDouble(form.getPlcsecond()));
			}
			projectLogContractTB.setPlcsecondterm(form.getPlcsecondterm());
			if(StringUtils.isNotEmpty(form.getPlcthird())){
				projectLogContractTB.setPlcthird(Double.parseDouble(form.getPlcthird()));
			}
			projectLogContractTB.setPlcthirdterm(form.getPlcthirdterm());
			if(StringUtils.isNotEmpty(form.getPlcfourth())){
				projectLogContractTB.setPlcfourth(Double.parseDouble(form.getPlcfourth()));
			}
			projectLogContractTB.setPlcfourthterm(form.getPlcfourthterm());
			if(StringUtils.isNotEmpty(form.getPlcfifth())){
				projectLogContractTB.setPlcfifth(Double.parseDouble(form.getPlcfifth()));
			}
			projectLogContractTB.setPlcfifthterm(form.getPlcfifthterm());
			projectLogContractTB.setPlcnumber(form.getPlcnumber());
			projectLogContractTB.setPlcpid(form.getPid());
			projectLogContractTB.setPlcplid(projectLog.getPlid());
			Double bzdevelop = 0.0;
			Double bzhardware = 0.0;
			Double bzsoftware = 0.0;
			Double bzproject = 0.0;
			Double bzelse = 0.0;
			Double bcimplement = 0.0;
			Double bcelse = 0.0;
			if(pbsummaryListSize>0){
				for (int i = 0; i < pbsummaryListSize; i++) {				
				/******预算与项目关系表*****/
				ProjectBudgetRelationTB projectBudgetRelation = new ProjectBudgetRelationTB();
				projectBudgetRelation = (ProjectBudgetRelationTB) this.projectBudgetRelationBL.findByPK(form.getPbrid()[i]);
				//资本金开发
				projectBudgetRelation.setBzdevelop(Double.valueOf(form.getUse1()[i]));
				bzdevelop = SVCHelper.getAdd(bzdevelop, Double.valueOf(form.getUse1()[i]));
				//资本金硬件
				projectBudgetRelation.setBzhardware(Double.valueOf(form.getUse2()[i]));
				bzhardware = SVCHelper.getAdd(bzhardware, Double.valueOf(form.getUse2()[i]));
				//资本金软件
				projectBudgetRelation.setBzsoftware(Double.valueOf(form.getUse3()[i]));
				bzsoftware = SVCHelper.getAdd(bzsoftware, Double.valueOf(form.getUse3()[i]));
				//资本金工程
				projectBudgetRelation.setBzproject(Double.valueOf(form.getUse4()[i]));
				bzproject =  SVCHelper.getAdd(bzproject, Double.valueOf(form.getUse4()[i]));
				//资本金其他
				projectBudgetRelation.setBzelse(Double.valueOf(form.getUse5()[i]));
				bzelse = SVCHelper.getAdd(bzelse, Double.valueOf(form.getUse5()[i]));
				//成本金实施
				projectBudgetRelation.setBcimplement(Double.valueOf(form.getUse6()[i]));
				bcimplement = SVCHelper.getAdd(bcimplement, Double.valueOf(form.getUse6()[i]));
				//成本金其他
				projectBudgetRelation.setBcelse(Double.valueOf(form.getUse7()[i]));	
				bcelse = SVCHelper.getAdd(bcelse, Double.valueOf(form.getUse7()[i]));
				//更新时间
				projectBudgetRelation.setPbdatetime(IGStringUtils.getCurrentDateTime());
				
				this.projectBudgetRelationBL.updateProjectBudgetRelation(projectBudgetRelation);
				
				}
			}else if(pbsummaryListSize==0){
				//资本金开发
				bzdevelop = Double.valueOf(form.getUse1()[0]);
				//资本金硬件
				bzhardware = Double.valueOf(form.getUse2()[0]);
				//资本金软件
				bzsoftware = Double.valueOf(form.getUse3()[0]);
				//资本金工程
				bzproject =  Double.valueOf(form.getUse4()[0]);
				//资本金其他
				bzelse = Double.valueOf(form.getUse5()[0]);
				//成本金实施
				bcimplement = Double.valueOf(form.getUse6()[0]);
				//成本金其他
				bcelse = Double.valueOf(form.getUse7()[0]);
			}
			projectLogContractTB.setBzdevelop(bzdevelop);
			projectLogContractTB.setBzhardware(bzhardware);
			projectLogContractTB.setBzsoftware(bzsoftware);
			projectLogContractTB.setBzproject(bzproject);
			projectLogContractTB.setBzelse(bzelse);
			projectLogContractTB.setBcimplement(bcimplement);
			projectLogContractTB.setBcelse(bcelse);
			projectLogContractBL.registProjectLogContract(projectLogContractTB);
		}
		/**当日志信息为付款时，将数据插入项目日志付款表*/
		if(form.getPltype().equals(IGPRJ01BLType.PROJECT_LOG_ContractTypeJ)){
			ProjectLogBusinessTB projectLogBusinessTB = new ProjectLogBusinessTB();
			projectLogBusinessTB.setPlbplcsum(Double.parseDouble(form.getPlbplcsum()));
			if(StringUtils.isNotEmpty(form.getPlbfirst())){
				projectLogBusinessTB.setPlbfirst(Double.parseDouble(form.getPlbfirst()));
			}
			if(StringUtils.isNotEmpty(form.getPlbsecond())){
				projectLogBusinessTB.setPlbsecond(Double.parseDouble(form.getPlbsecond()));
			}
			if(StringUtils.isNotEmpty(form.getPlbthird())){
				projectLogBusinessTB.setPlbthird(Double.parseDouble(form.getPlbthird()));
			}
			if(StringUtils.isNotEmpty(form.getPlbfourth())){
				projectLogBusinessTB.setPlbfourth(Double.parseDouble(form.getPlbfourth()));
			}
			if(StringUtils.isNotEmpty(form.getPlbfifth())){
				projectLogBusinessTB.setPlbfifth(Double.parseDouble(form.getPlbfifth()));
			}
			projectLogBusinessTB.setPlbplid(projectLog.getPlid());
			projectLogBusinessTB.setPlbpid(form.getPid());
			projectLogBusinessTB.setPlbsum(Double.parseDouble(form.getPlbsum()));
			projectLogBusinessTB.setPlbscale(Double.parseDouble(form.getPlbscale()));
			projectLogBusinessTB.setPlbnotsum(Double.parseDouble(form.getPlbnotsum()));
			projectLogBusinessTB.setPlbnotscale(Double.parseDouble(form.getPlbnotscale()));
			projectLogBusinessBL.registProjectLogBusiness(projectLogBusinessTB);
		}
		dto.setProjectLog(projectLog);
		return dto;
	}

	// 上传文件
	protected String insertUploadFile(IGPRJ01DTO dto) throws BLException {

		AttachmentTB attachment = new AttachmentTB();
		String retAttkey = null;
		// 上传文件检测
		Map<Integer, FormFile> map = dto.getIGPRJ0101DetailForm().getFileMap();
		if (map != null && map.size() > 0) {
			retAttkey = IGStringUtils.getAttKey();
			attachment.setAttkey(retAttkey);
		}

		Iterator<Integer> iterator = map.keySet().iterator();

		while (iterator.hasNext()) {
			FormFile file = (FormFile) map.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuilder pathBuilder = new StringBuilder();

				// 根目录
				pathBuilder.append(rootPath);
				pathBuilder.append("prj");
				pathBuilder.append(File.separator);

				StringBuilder uploadFileNameSB = new StringBuilder();
				String fileType = "";
				String uploadFileName = file.getFileName();
				int point = uploadFileName.lastIndexOf(".");
				if (point != -1) {
					fileType = uploadFileName.substring(point);
					uploadFileName = uploadFileName.substring(0, point);
				}

				uploadFileNameSB.append(retAttkey).append("_").append(uploadFileName).append(fileType);

				// 文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuilder.toString(),uploadFileNameSB.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}

				// 上传文件名保存
				attachment.setAttname(uploadFileNameSB.toString());
				// 上传文件路径保存
				attachment.setAtturl("prj");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return retAttkey;
	}

	// 关闭项目
	public IGPRJ01DTO closeProject(IGPRJ01DTO dto) throws BLException {
		Project project = dto.getProject();
		this.projectBL.saveProject(project);
		IGPRJ0101DetailForm form = dto.getIGPRJ0101DetailForm();
		String attkey = this.insertUploadFile(dto);
		form.setSiattkey(attkey);
		this.projectLogBL.saveProjectLog(form);
		return dto;
	}

	// 获取项目历史
	public IGPRJ01DTO findAllProject(IGPRJ01DTO dto) throws BLException {
		
		String projectId = dto.getProjectId();
		ProjectLogSearchCondImpl cond = new ProjectLogSearchCondImpl();
		cond.setPltype_ne("P");
		if(projectId!=null){
		cond.setPid(Integer.valueOf(projectId));
		}
		if(dto.getIGPRJ0101DetailForm()!=null){//获得模糊查询条件
		  IGPRJ0101DetailForm form=dto.getIGPRJ0101DetailForm();
		  cond.setPlinfo(form.getPlinfo());
		  if(StringUtils.isNotEmpty(form.getPltime_from())){
			  cond.setPltime_from(form.getPltime_from()+" 00:00");
		  }
		  if(StringUtils.isNotEmpty(form.getPltime_to())){
			  cond.setPltime_to(form.getPltime_to()+" 23:59");
		  }
		  cond.setPltype(form.getPltype());
		  cond.setPid(form.getPid());
		}
		List<ProjectLog> projectLogList = this.projectLogBL.findByCond(cond, 0, 0);
		IGPRJ01HistoryVO[] historyVOs = new IGPRJ01HistoryVO[projectLogList.size()];
		int i = 0;
		for (int j = 0; j < projectLogList.size(); j++) {
			IGPRJ01HistoryVO historyVO = new IGPRJ01HistoryVO();
			ProjectLog projectLog = projectLogList.get(j);
			String attKey = projectLog.getPlattkey();
			if (attKey != null) {
				List<Attachment> attachmentList = this.attachmentBL.searchAttachmentsByAttkey(attKey);
				historyVO.setAttachmentList(attachmentList);
			}
			historyVO.setProjectLog(projectLog);
			historyVOs[i] = historyVO;
			i++;
		}
		dto.setHistoryVOs(historyVOs);
		CodeDetailSearchCondImpl cdCond = new CodeDetailSearchCondImpl();
		cdCond.setCcid("315");
		List<CodeDetail> cdList = this.codeDetailBL.searchCodeDetail(cdCond, 0);
		dto.setCodeDetailList(cdList);
		return dto;
	}

	public IGPRJ01DTO getPrincipal(IGPRJ01DTO dto) throws BLException {
		log.debug("========负责人查询处理开始========");
		Integer pid = dto.getIgprj0104Form().getPid();
		Project project = projectBL.findByPK(pid);
		String prole = project.getProle();
		List<String> principalList = new ArrayList<String>(3);
		if (prole!=null&&prole.contains(",")) {
			String[] proles = prole.split(",");
			for (int i = 0; i < proles.length; i++) {
				principalList.add(proles[i]);
			}
		} else {
			if(StringUtils.isNotEmpty(prole)){
				principalList.add(prole);
			}
		}
		dto.setPrincipalList(principalList);
		List<Role> roleList = roleBL.searchRole(new RoleSearchCondImpl());
		dto.setRoleMap(PRJHelper.getRoleMap(roleList));
		log.debug("========负责人查询处理终了========");
		return dto;
	}

	public IGPRJ01DTO addPrincipal(IGPRJ01DTO dto) throws BLException {
		Integer pid = dto.getIgprj0104Form().getPid();
		Project project = projectBL.findByPK(pid);
		String prole = project.getProle();
		String[] allPrincipals = dto.getIgprj0104Form().getUserids();
		Set<String> principalsSet = new HashSet<String>();
		if (prole.contains(",")) {
			String[] proles = prole.split(",");
			for (int i = 0; i < proles.length; i++) {
				principalsSet.add(proles[i]);
			}
		} else {
			principalsSet.add(prole);
		}
		for (int i = 0; i < allPrincipals.length; i++) {
			String principal = allPrincipals[i];
			if (principal.contains(",,,,")) {
				String[] principals = principal.split(",,,,");
				for (int j = 0; j < principals.length; j++) {
					principalsSet.add(principals[j]);
				}
			} else {
				principalsSet.add(principal);
			}
		}

		if(principalsSet.size() > 3){
			throw new BLException("","");
		}
		String newProle = null;
		Iterator<String> it = principalsSet.iterator();
		boolean isBegin = true;
		while(it.hasNext()){
			if(isBegin){
				newProle = it.next();
				isBegin = false;
			} else {
				newProle = newProle + "," + it.next();
			}
		}
		ProjectTB projectTB = new ProjectTB();
		projectTB.clone(project);
		projectTB.setPid(project.getPid());
		projectTB.setProle(newProle);
		Project retProject = projectBL.saveProject(projectTB);
		dto.setProject(retProject);
		return dto;
	}

	public IGPRJ01DTO removePrincipal(IGPRJ01DTO dto) throws BLException {
		Integer pid = dto.getIgprj0104Form().getPid();
		Project project = projectBL.findByPK(pid);
		String prole = project.getProle();
		List<String> principalList = new ArrayList<String>(3);
		if(prole.contains(",")){
			String[] proles = prole.split(",");
			for (int i = 0; i < proles.length; i++) {
				principalList.add(proles[i]);
			}
		} else {
			principalList.add(prole);
		}
		String[] allPrincipals = dto.getIgprj0104Form().getUserids();
		for (int i = 0; i < allPrincipals.length; i++) {
			principalList.remove(allPrincipals[i]);
		}
		if(null == principalList || 0 == principalList.size()){
			throw new BLException("","");
		}
		String newProle = null;
		for (int i = 0; i < principalList.size(); i++) {
			if(i == 0){
				newProle = principalList.get(i);
			} else {
				newProle = newProle + "," + principalList.get(i);
			}
		}
		ProjectTB projectTB = new ProjectTB();
		projectTB.clone(project);
		projectTB.setPid(project.getPid());
		projectTB.setProle(newProle);
		Project retProject = projectBL.saveProject(projectTB);
		dto.setProject(retProject);
		return dto;
	}

	public IGPRJ01DTO getParticipant(IGPRJ01DTO dto) throws BLException {
		log.debug("========参与人查询处理开始========");
		Integer pid = dto.getIgprj0107Form().getPid();
		Project project = projectBL.findByPK(pid);
		String puser = project.getPuser();
		List<String> participantList = new ArrayList<String>();
		if(null != puser){
			if(puser.contains(",")){
				String[] pusers = puser.split(",");
				for (int i = 0; i < pusers.length; i++) {
					participantList.add(pusers[i]);
				}
			} else {
				participantList.add(puser);
			}
		}
		dto.setParticipantList(participantList);
		List<Role> roleList = roleBL.searchRole(new RoleSearchCondImpl());
		dto.setRoleMap(PRJHelper.getRoleMap(roleList));
		log.debug("========参与人查询处理终了========");
		return dto;
	}

	public IGPRJ01DTO addParticipant(IGPRJ01DTO dto) throws BLException {
		Integer pid = dto.getIgprj0107Form().getPid();
		Project project = projectBL.findByPK(pid);
		String puser = project.getPuser();
		String[] allParticipants = dto.getIgprj0107Form().getUserids();
		Set<String> participantsSet = new HashSet<String>();
		if(null != puser){
			if(puser.contains(",")){
				String[] pusers = puser.split(",");
				for (int i = 0; i < pusers.length; i++) {
					participantsSet.add(pusers[i]);
				}
			} else {
				participantsSet.add(puser);
			}
		}
		for (int i = 0; i < allParticipants.length; i++) {
			String participant = allParticipants[i];
			if(participant.contains(",,,,")){
				String[] participants = participant.split(",,,,");
				for (int j = 0; j < participants.length; j++) {
					participantsSet.add(participants[j]);
				}
			} else {
				participantsSet.add(participant);
			}
		}

		if(participantsSet.size() > 8){
			throw new BLException("","");
		}
		String newPuser = null;
		Iterator<String> it = participantsSet.iterator();
		boolean isBegin = true;
		while(it.hasNext()){
			if(isBegin){
				newPuser = it.next();
				isBegin = false;
			} else {
				newPuser = newPuser + "," + it.next();
			}
		}
		ProjectTB projectTB = new ProjectTB();
		projectTB.clone(project);
		projectTB.setPid(project.getPid());
		projectTB.setPuser(newPuser);
		Project retProject = projectBL.saveProject(projectTB);
		dto.setProject(retProject);
		return dto;
	}

	public IGPRJ01DTO removeParticipant(IGPRJ01DTO dto) throws BLException {
		Integer pid = dto.getIgprj0107Form().getPid();
		Project project = projectBL.findByPK(pid);
		String puser = project.getPuser();
		List<String> participantList = new ArrayList<String>();
		if(puser.contains(",")){
			String[] pusers = puser.split(",");
			for (int i = 0; i < pusers.length; i++) {
				participantList.add(pusers[i]);
			}
		} else {
			participantList.add(puser);
		}
		String[] allParticipants = dto.getIgprj0107Form().getUserids();
		for (int i = 0; i < allParticipants.length; i++) {
			participantList.remove(allParticipants[i]);
		}
		String newPuser = null;
		for (int i = 0; i < participantList.size(); i++) {
			if(i == 0){
				newPuser = participantList.get(i);
			} else {
				newPuser = newPuser + "," + participantList.get(i);
			}
		}
		ProjectTB projectTB = new ProjectTB();
		projectTB.clone(project);
		projectTB.setPid(project.getPid());
		projectTB.setPuser(newPuser);
		Project retProject = projectBL.saveProject(projectTB);
		dto.setProject(retProject);
		return dto;
	}

	/**
	 * <p>
	 * Description: 获得日志类别显示
	 * </p>
	 */
	public IGPRJ01DTO findProjectLogType(IGPRJ01DTO dto) throws BLException {
		log.debug("========获得日志类别显示开始========");
		//查询基础数据，获得日志类别
		CodeDetailSearchCondImpl cdCond = new CodeDetailSearchCondImpl();
		cdCond.setCcid("315");
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(cdCond, 0);
		dto.setCodeDetailList(codeDetailList);
		log.debug("========获得日志类别显示结束========");
		//当用户选择付款选项时，取得合同总数
		if(StringUtils.isNotEmpty(dto.getProjectType())&&((dto.getProjectType().equals(IGPRJ01BLType.PROJECT_LOG_ContractTypeJ))||(dto.getProjectType().equals(IGPRJ01BLType.PROJECT_LOG_ContractTypeC)))){
			/**获得项目日志*/
			ProjectLogSearchCondImpl plCond = new ProjectLogSearchCondImpl();
			plCond.setPid(Integer.parseInt(dto.getProjectId()));
			plCond.setPltype(dto.getProjectType());
			List<ProjectLog> projectLogList = projectLogBL.findByCond(plCond, 0, 0);
			if(projectLogList.size()>0&&StringUtils.isNotEmpty(projectLogList.get(0).getPlinfo())){
				dto.setProjectLogInfo(projectLogList.get(0).getPlinfo());
			}
			/**获得合同总数*/				
			ProjectLogContractSearchCondImpl plcCond = new ProjectLogContractSearchCondImpl();
			plcCond.setPlcpid(Integer.parseInt(dto.getProjectId()));
			List<ProjectLogContractInfo> plcList = projectLogContractBL.searchProjectLogContract(plcCond);
			if((plcList.size()>0)&&(plcList.get(0).getPlcsum()!=null)){
				dto.setProjectLogContractSum(plcList.get(0).getPlcsum().toString());
			}
			if((plcList.size()>0)&&(plcList.get(0).getPlcfirst()!=null)){
				dto.setProjectLogContractFirst(plcList.get(0).getPlcfirst().toString());
			}
			if((plcList.size()>0)&&(plcList.get(0).getPlcsecond()!=null)){
				dto.setProjectLogContractSecond(plcList.get(0).getPlcsecond().toString());
			}
			if((plcList.size()>0)&&(plcList.get(0).getPlcthird()!=null)){
				dto.setProjectLogContractThird(plcList.get(0).getPlcthird().toString());
			}
			if((plcList.size()>0)&&(plcList.get(0).getPlcfourth()!=null)){
				dto.setProjectLogContractFourth(plcList.get(0).getPlcfourth().toString());
			}
			if((plcList.size()>0)&&(plcList.get(0).getPlcfifth()!=null)){
				dto.setProjectLogContractFifth(plcList.get(0).getPlcfifth().toString());
			}
			if((plcList.size()>0)&&StringUtils.isNotEmpty(plcList.get(0).getPlcsumterm())){
				dto.setProjectLogContractSumTerm(plcList.get(0).getPlcsumterm());
			}
			if((plcList.size()>0)&&StringUtils.isNotEmpty(plcList.get(0).getPlcfirstterm())){
				dto.setProjectLogContractFirstTerm(plcList.get(0).getPlcfirstterm());
			}
			if((plcList.size()>0)&&StringUtils.isNotEmpty(plcList.get(0).getPlcsecondterm())){
				dto.setProjectLogContractSecondTerm(plcList.get(0).getPlcsecondterm());
			}
			if((plcList.size()>0)&&StringUtils.isNotEmpty(plcList.get(0).getPlcthirdterm())){
				dto.setProjectLogContractThirdTerm(plcList.get(0).getPlcthirdterm());
			}
			if((plcList.size()>0)&&StringUtils.isNotEmpty(plcList.get(0).getPlcfourthterm())){
				dto.setProjectLogContractFourthTerm(plcList.get(0).getPlcfourthterm());
			}
			if((plcList.size()>0)&&StringUtils.isNotEmpty(plcList.get(0).getPlcfifthterm())){
				dto.setProjectLogContractFifthTerm(plcList.get(0).getPlcfifthterm());
			}
			if((plcList.size()>0)&&StringUtils.isNotEmpty(plcList.get(0).getPlcnumber())){
				dto.setPlcnumber(plcList.get(0).getPlcnumber());
			}
			/**取得预算及工程分类信息视图数据集合*/
			PbsummaryVWSearchCondImpl pbsummaryCond = new PbsummaryVWSearchCondImpl();
			pbsummaryCond.setPid(Integer.parseInt(dto.getProjectId()));
			List<Pbsummary> pbsummaryList = this.pbsummaryVWBL.searchPbsummary(pbsummaryCond, 0, 0);
			dto.setPbsummaryList(pbsummaryList);
			//存在预算时，将所属预算集合内的信息放入Form
			if(pbsummaryList.size()>0){
				String[] use1;
				String[] use2;
				String[] use3;
				String[] use4;
				String[] use5;
				String[] use6;
				String[] use7;
				String[] sub1;
				String[] sub2;
				String[] sub3;
				String[] sub4;
				String[] sub5;
				String[] sub6;
				String[] sub7;
				String[] btitle;
				Integer[] pbrid;
				
				use1 = new String[pbsummaryList.size()];
				use2 = new String[pbsummaryList.size()];
				use3 = new String[pbsummaryList.size()];
				use4 = new String[pbsummaryList.size()];
				use5 = new String[pbsummaryList.size()];
				use6 = new String[pbsummaryList.size()];
				use7 = new String[pbsummaryList.size()];
				sub1 = new String[pbsummaryList.size()];
				sub2 = new String[pbsummaryList.size()];
				sub3 = new String[pbsummaryList.size()];
				sub4 = new String[pbsummaryList.size()];
				sub5 = new String[pbsummaryList.size()];
				sub6 = new String[pbsummaryList.size()];
				sub7 = new String[pbsummaryList.size()];
				btitle = new String[pbsummaryList.size()];
				pbrid = new Integer[pbsummaryList.size()];
				for (int i = 0;i<pbsummaryList.size();i++) {
					use1[i] = String.valueOf(pbsummaryList.get(i).getUse1());
					use2[i] = String.valueOf(pbsummaryList.get(i).getUse2());
					use3[i] = String.valueOf(pbsummaryList.get(i).getUse3());
					use4[i] = String.valueOf(pbsummaryList.get(i).getUse4());
					use5[i] = String.valueOf(pbsummaryList.get(i).getUse5());
					use6[i] = String.valueOf(pbsummaryList.get(i).getUse6());
					use7[i] = String.valueOf(pbsummaryList.get(i).getUse7());
					sub1[i] = String.valueOf(pbsummaryList.get(i).getSub1());
					sub2[i] = String.valueOf(pbsummaryList.get(i).getSub2());
					sub3[i] = String.valueOf(pbsummaryList.get(i).getSub3());
					sub4[i] = String.valueOf(pbsummaryList.get(i).getSub4());
					sub5[i] = String.valueOf(pbsummaryList.get(i).getSub5());
					sub6[i] = String.valueOf(pbsummaryList.get(i).getSub6());
					sub7[i] = String.valueOf(pbsummaryList.get(i).getSub7());
					btitle[i] = String.valueOf(pbsummaryList.get(i).getBtitle());
					pbrid[i] = pbsummaryList.get(i).getPbid();
				}
				IGPRJ0101DetailForm detailForm = dto.getIGPRJ0101DetailForm();
				detailForm.setUse1(use1);
				detailForm.setUse2(use2);
				detailForm.setUse3(use3);
				detailForm.setUse4(use4);
				detailForm.setUse5(use5);
				detailForm.setUse6(use6);
				detailForm.setUse7(use7);
				detailForm.setSub1(sub1);
				detailForm.setSub2(sub2);
				detailForm.setSub3(sub3);
				detailForm.setSub4(sub4);
				detailForm.setSub5(sub5);
				detailForm.setSub6(sub6);
				detailForm.setSub7(sub7);
				detailForm.setBtitle(btitle);
				detailForm.setPbrid(pbrid);
				dto.setIGPRJ0101DetailForm(detailForm);
			}else{//当不存在预算时，合同表内已有 预算信息时放入已有信息，否则放入0
				String[] use1;
				String[] use2;
				String[] use3;
				String[] use4;
				String[] use5;
				String[] use6;
				String[] use7;
				String[] btitle;
				use1 = new String[1];
				use2 = new String[1];
				use3 = new String[1];
				use4 = new String[1];
				use5 = new String[1];
				use6 = new String[1];
				use7 = new String[1];
				btitle = new String[1];
				if((plcList.size()>0)&&(plcList.get(0).getBzdevelop()!=null)){					
					use1[0] = String.valueOf(plcList.get(0).getBzdevelop());
				}else{
					use1[0] = String.valueOf(0.0);
				}
				if((plcList.size()>0)&&(plcList.get(0).getBzhardware()!=null)){					
					use2[0] = String.valueOf(plcList.get(0).getBzhardware());
				}else{
					use2[0] = String.valueOf(0.0);
				}
				if((plcList.size()>0)&&(plcList.get(0).getBzsoftware()!=null)){					
					use3[0] = String.valueOf(plcList.get(0).getBzsoftware());
				}else{
					use3[0] = String.valueOf(0.0);
				}
				if((plcList.size()>0)&&(plcList.get(0).getBzproject()!=null)){					
					use4[0] = String.valueOf(plcList.get(0).getBzproject());
				}else{
					use4[0] = String.valueOf(0.0);
				}
				if((plcList.size()>0)&&(plcList.get(0).getBzelse()!=null)){					
					use5[0] = String.valueOf(plcList.get(0).getBzelse());
				}else{
					use5[0] = String.valueOf(0.0);
				}
				if((plcList.size()>0)&&(plcList.get(0).getBcimplement()!=null)){					
					use6[0] = String.valueOf(plcList.get(0).getBcimplement());
				}else{
					use6[0] = String.valueOf(0.0);
				}
				if((plcList.size()>0)&&(plcList.get(0).getBcelse()!=null)){					
					use7[0] = String.valueOf(plcList.get(0).getBcelse());
				}else{
					use7[0] = String.valueOf(0.0);
				}
				btitle[0] = String.valueOf("已用预算");
				IGPRJ0101DetailForm detailForm = dto.getIGPRJ0101DetailForm();
				detailForm.setUse1(use1);
				detailForm.setUse2(use2);
				detailForm.setUse3(use3);
				detailForm.setUse4(use4);
				detailForm.setUse5(use5);
				detailForm.setUse6(use6);
				detailForm.setUse7(use7);
				detailForm.setBtitle(btitle);
				dto.setIGPRJ0101DetailForm(detailForm);
			}
		}
		if(StringUtils.isNotEmpty(dto.getProjectType())&&(dto.getProjectType().equals(IGPRJ01BLType.PROJECT_LOG_ContractTypeJ))){
			/**获得已有付款信息*/
			ProjectLogBusinessSearchCondImpl plbCond = new ProjectLogBusinessSearchCondImpl();
			plbCond.setPlbpid(Integer.parseInt(dto.getProjectId()));
			List<ProjectLogBusinessInfo> plbList = projectLogBusinessBL.searchProjectLogBusiness(plbCond);
			if(plbList.size()>0){
				if(plbList.get(0).getPlbfirst()!=null){						
					dto.setProjectLogBusinessFirst(plbList.get(0).getPlbfirst().toString());
				}
				if(plbList.get(0).getPlbsecond()!=null){
					dto.setProjectLogBusinessSecond(plbList.get(0).getPlbsecond().toString());
				}
				if(plbList.get(0).getPlbthird()!=null){
					dto.setProjectLogBusinessThird(plbList.get(0).getPlbthird().toString());
				}
				if(plbList.get(0).getPlbfourth()!=null){
					dto.setProjectLogBusinessFourth(plbList.get(0).getPlbfourth().toString());
				}
				if(plbList.get(0).getPlbfifth()!=null){
					dto.setProjectLogBusinessFifth(plbList.get(0).getPlbfifth().toString());
				}				
				if(plbList.get(0).getPlbsum()!=null){
					dto.setProjectLogBusinessSum(plbList.get(0).getPlbsum().toString());
				}
				if(plbList.get(0).getPlbnotsum()!=null){
					dto.setProjectLogBusinessNotsum(plbList.get(0).getPlbnotsum().toString());
				}
				if(plbList.get(0).getPlbscale()!=null){
					dto.setProjectLogBusinessScale(plbList.get(0).getPlbscale().toString());
				}
				if(plbList.get(0).getPlbnotscale()!=null){
					dto.setProjectLogBusinessNotscale(plbList.get(0).getPlbnotscale().toString());
				}
			}
		}
		return dto;
	}

	
	/**
	 * <p>
	 * Description: 查找日志类别详细信息显示
	 * </p>
	 */
	public IGPRJ01DTO searchProjectLogTypeMessage(IGPRJ01DTO dto) throws BLException{
		log.debug("========查找日志类别详细信息显示开始========");
		//根据项目日志类别查询详细信息
		if(StringUtils.isNotEmpty(dto.getProjectType())){
			if(dto.getProjectType().equals(IGPRJ01BLType.PROJECT_LOG_ContractTypeC)){
				//合同签订
				ProjectLogContractSearchCondImpl plcCond = new ProjectLogContractSearchCondImpl();
				plcCond.setPlcplid(dto.getPlid());
				List<ProjectLogContractInfo> plcList = this.projectLogContractBL.searchProjectLogContract(plcCond);
				dto.setPlcList(plcList);
				/**取得预算及工程分类信息视图数据集合*/
				PbsummaryVWSearchCondImpl pbsummaryCond = new PbsummaryVWSearchCondImpl();
				pbsummaryCond.setPid(Integer.parseInt(dto.getProjectId()));
				List<Pbsummary> pbsummaryList = this.pbsummaryVWBL.searchPbsummary(pbsummaryCond, 0, 0);
				dto.setPbsummaryList(pbsummaryList);
			}else if(dto.getProjectType().equals(IGPRJ01BLType.PROJECT_LOG_ContractTypeJ)){
				//付款
				ProjectLogBusinessSearchCondImpl plbCond = new ProjectLogBusinessSearchCondImpl();
				plbCond.setPlbplid(dto.getPlid());
				List<ProjectLogBusinessInfo> plbList = this.projectLogBusinessBL.searchProjectLogBusiness(plbCond);
				dto.setPlbList(plbList);
			}
		}
		log.debug("========查找日志类别详细信息显示结束========");
		return dto;
	}	
	
	/**
	 * <p>
	 * Description: 项目删除处理
	 * </p>
	 */
	public IGPRJ01DTO removeProject(IGPRJ01DTO dto) throws BLException {
		log.debug("========项目删除处理开始========");
		if(StringUtils.isNotEmpty(dto.getProjectId())){	
			//项目类别为合同签订日志信息删除
			ProjectLogContractSearchCondImpl plcCond = new ProjectLogContractSearchCondImpl();
			plcCond.setPlcpid(Integer.parseInt(dto.getProjectId()));
			List<ProjectLogContractInfo> plcList = this.projectLogContractBL.searchProjectLogContract(plcCond);
			if(plcList!=null){
				for (ProjectLogContractInfo plcInfo : plcList) {
					this.projectLogContractBL.deleteProjectLogContractByPK(plcInfo.getPlcid());
				}
			}
			//项目类别为付款日志信息删除
			ProjectLogBusinessSearchCondImpl plbCond = new ProjectLogBusinessSearchCondImpl();
			plbCond.setPlbid(Integer.parseInt(dto.getProjectId()));
			List<ProjectLogBusinessInfo> plbList = this.projectLogBusinessBL.searchProjectLogBusiness(plbCond);
			if(plbList!=null){
				for (ProjectLogBusinessInfo plbInfo : plbList) {
					this.projectLogBusinessBL.deleteProjectLogBusinessByPK(plbInfo.getPlbid());
				}
			}
			//项目计划信息删除
			ProjectPlanSearchCondImpl ppCond = new ProjectPlanSearchCondImpl();
			ppCond.setPid(Integer.parseInt(dto.getProjectId()));
			List<ProjectPlan> ppList = this.projectPlanBL.findByCond(ppCond, 0, 0);
			if(ppList!=null){
				for (ProjectPlan pp : ppList) {
					this.projectPlanBL.deleteProjectPlanByPK(pp.getPplid());
				}
			}
			//项目日志信息删除
			ProjectLogSearchCondImpl plCond = new ProjectLogSearchCondImpl();
			plCond.setPid(Integer.parseInt(dto.getProjectId()));
			List<ProjectLog> plList = this.projectLogBL.findByCond(plCond, 0, 0);
			if(plList!=null){
				for (ProjectLog pl : plList) {
					this.projectLogBL.deleteProjectLogByPK(pl.getPlid());
				}
			}
			//项目预算信息删除
			ProjectBudgetRelationSearchCondImpl pbcond = new ProjectBudgetRelationSearchCondImpl();
			pbcond.setPid_eq(Integer.parseInt(dto.getProjectId()));
			List<ProjectBudgetRelationInfo> pbList = projectBudgetRelationBL.findByCond(pbcond, 0, 0);
			if(pbList!=null){
				projectBudgetRelationBL.deleteProjectBudgetRelation(pbList);
			}
			//项目信息删除
			this.projectBL.deleteProjectByPK(Integer.parseInt(dto.getProjectId()));
			dto.addMessage(new ActionMessage("IGPRJ0101.I001"));
		}
		log.debug("========项目删除处理结束========");
		return dto;
	}

	/**
	 * 项目基本信息修改
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRJ01DTO updateProject(IGPRJ01DTO dto) throws BLException {
		log.debug("========项目基本信息修改开始========");
		IGPRJ0109Form form = dto.getIgPrj0109Form();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String currentTime = format.format(new Date());
		//定义项目总计资本金（开发）总额
		double pbzdevelop = 0.0;
		//定义项目总计资本金（硬件）总额
		double pbzhardware = 0.0;
		//定义项目总计资本金（软件）总额
		double pbzsoftware = 0.0;
		//定义项目总计资本金（工程）总额
		double pbzproject = 0.0;
		//定义项目总计资本金（其他）总额
		double pbzelse = 0.0;
		//定义项目总计成本金（实施）总额
		double pbcimplement = 0.0;
		//定义项目总计成本金（其他）总额
		double pbcelse = 0.0;
		//定义预算-项目关系实体集合
		List<ProjectBudgetRelationTB> pbRelationList = new ArrayList<ProjectBudgetRelationTB>();
		if(form.getBzdevelop()!=null&&form.getBzdevelop().length>0){
			for(int i=0;i<form.getBzdevelop().length;i++){
				//获取项目总计资本金（开发）金额；
				pbzdevelop+=form.getBzdevelop()[i];
				//获取项目总计资本金（硬件）金额；
				pbzhardware+=form.getBzhardware()[i];
				//获取项目总计资本金（软件）金额；
				pbzsoftware+=form.getBzsoftware()[i];
				//获取项目总计资本金（工程）金额；
				pbzproject+=form.getBzproject()[i];
				//获取项目总计资本金（其他）金额；
				pbzelse+=form.getBzelse()[i];
				//获取项目总计成本金（实施）金额；
				pbcimplement+=form.getBcimplement()[i];
				//获取项目总计成本金（其他）金额；
				pbcelse+=form.getBcelse()[i];
				//保存预算-项目关系实体
				ProjectBudgetRelationTB pbRelationTB = new ProjectBudgetRelationTB();
				pbRelationTB.setBid(form.getBid()[i]);
				pbRelationTB.setBzdevelop(form.getBzdevelop()[i]);
				pbRelationTB.setBzhardware(form.getBzhardware()[i]);
				pbRelationTB.setBzsoftware(form.getBzsoftware()[i]);
				pbRelationTB.setBzproject(form.getBzproject()[i]);
				pbRelationTB.setBzelse(form.getBzelse()[i]);
				pbRelationTB.setBcimplement(form.getBcimplement()[i]);
				pbRelationTB.setBcelse(form.getBcelse()[i]);
				pbRelationTB.setPbdatetime(currentTime);
				pbRelationList.add(pbRelationTB);
			}
		}
		Project project = projectBL.findByPK(form.getPid());
		ProjectTB projectTB = (ProjectTB)SerializationUtils.clone(project);
		projectTB.setPname(form.getPname());
		projectTB.setPcode(form.getPcode());
		projectTB.setPpquality(form.getPpquality());
		projectTB.setPtype(form.getPtype());
		if(form.getIsUseBudget().equals(IGPRJ01BLType.USE_BUDGET)&&IGPRJ01BLType.HASPC_N.equals(form.getHasPc())){
			projectTB.setPzdevelop(pbzdevelop);
			projectTB.setPzhardware(pbzhardware);
			projectTB.setPzsoftware(pbzsoftware);
			projectTB.setPzproject(pbzproject);
			projectTB.setPzelse(pbzelse);
			projectTB.setPcimplement(pbcimplement);
			projectTB.setPcelse(pbcelse);
			projectTB.setPlimit(pbzdevelop+pbzhardware+pbzsoftware+pbzproject+pbzelse+pbcimplement+pbcelse);
		}else{
			projectTB.setPzdevelop(form.getPbzdevelop());
			projectTB.setPzhardware(form.getPbzhardware());
			projectTB.setPzsoftware(form.getPbzsoftware());
			projectTB.setPzproject(form.getPbzproject());
			projectTB.setPzelse(form.getPbzelse());
			projectTB.setPcimplement(form.getPbcimplement());
			projectTB.setPcelse(form.getPbcelse());
			projectTB.setPlimit(form.getPbzdevelop()+form.getPbzhardware()+form.getPbzsoftware()+form.getPbzproject()+form.getPbzelse()+form.getPbcimplement()+form.getPbcelse());
		}
		projectTB.setPlimit(form.getPlimit());//项目总金额
		projectTB.setPopentime(form.getPopentime());
		projectTB.setPplanclosetime(form.getPplanclosetime());
		projectTB.setPclosetime(form.getPclosetime());
		projectTB.setPdesc(form.getPdesc());
		projectTB.setPaim(form.getPaim());
		projectTB.setPpurpose(form.getPpurpose());
		projectTB.setPbranch(form.getPbranch());
		projectTB.setIsUseBudget(form.getIsUseBudget());
		projectBL.saveProject(projectTB);
		//更新预算项目关系记录
		ProjectBudgetRelationSearchCondImpl cond = new ProjectBudgetRelationSearchCondImpl();
		cond.setPid_eq(projectTB.getPid());
		List<ProjectBudgetRelationInfo> pbList = projectBudgetRelationBL.findByCond(cond, 0, 0);
		projectBudgetRelationBL.deleteProjectBudgetRelation(pbList);
		if(form.getIsUseBudget().equals(IGPRJ01BLType.USE_BUDGET)){
			for(ProjectBudgetRelationTB pbRelation : pbRelationList){
				pbRelation.setPid(projectTB.getPid());
				projectBudgetRelationBL.saveProjectBudgetRelation(pbRelation);
			}
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I005", "项目基本信息修改"));
		log.debug("========项目基本信息修改结束========");
		return dto;
	}
	
	/**
	 * 项目基本信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.prj.bl.IGPRJ01BL#selectProject(com.deliverik.infogovernor.prj.dto.IGPRJ01DTO)
	 */
	public IGPRJ01DTO selectProject(IGPRJ01DTO dto) throws BLException {
		log.debug("========项目基本信息查询开始========");
		Project project = projectBL.findByPK(Integer.parseInt(dto.getProjectId()));
		IGPRJ0109Form form = dto.getIgPrj0109Form();
		if(null!=project){
			//将项目内容设置到actionform并传回页面
			form.setPaim(project.getPaim());
			form.setPbranch(project.getPbranch());
			form.setPclosetime(project.getPclosetime());
			form.setPopentime(project.getPopentime());
			form.setPlimit(project.getPlimit());
			form.setPuse(project.getPuse());
			form.setPdesc(project.getPdesc());
			form.setPcode(project.getPcode());
			form.setPname(project.getPname());
			form.setPpurpose(project.getPpurpose());
			form.setIsUseBudget(project.getIsUseBudget());
			form.setPplanclosetime(project.getPplanclosetime());
			form.setPpquality(project.getPpquality());
			form.setPtype(project.getPtype());
			form.setPbcelse(project.getPcelse());
			form.setPbcimplement(project.getPcimplement());
			form.setPbzdevelop(project.getPzdevelop());
			form.setPbzelse(project.getPzelse());
			form.setPbzhardware(project.getPzhardware());
			form.setPbzproject(project.getPzproject());
			form.setPbzsoftware(project.getPzsoftware());
			//查询是否关联合同
			ProjectLogContractSearchCondImpl pccond = new ProjectLogContractSearchCondImpl();
			pccond.setPlcpid(project.getPid());
			List<ProjectLogContractInfo> pcList = projectLogContractBL.searchProjectLogContract(pccond);
			if(pcList==null||pcList.size()==0){
				form.setHasPc(IGPRJ01BLType.HASPC_N);
			}else{
				form.setHasPc(IGPRJ01BLType.HASPC_Y);
			}
			
			//查询预算
			PbsummaryVWSearchCondImpl cond = new PbsummaryVWSearchCondImpl();
			cond.setPid(project.getPid());
			List<Pbsummary> pbsummaryList = pbsummaryVWBL.searchPbsummary(cond, 0, 0);
			dto.setPbsummaryList(pbsummaryList);
		}
		
		dto.setIgPrj0109Form(form);
		
		log.debug("========项目基本信息询结束========");
		return dto;
	}
	
	/***
	 * 投资使用情况导出查询
	 */
	public IGPRJ01DTO exportSearchAction(IGPRJ01DTO dto){
		log.debug("=================投资使用情况导出开始======================");
		InvestUseInfoSearchCondImpl investcond = new InvestUseInfoSearchCondImpl();
		List<InvestUseInfoVW> investList = investUseInfoBL.findAll(investcond);
		dto.setInvestUseInfoList(investList);
		CodeDetailSearchCondImpl codecond = new CodeDetailSearchCondImpl();
		codecond.setCcid("290");
		List<CodeDetail> ppqCode = codeDetailBL.searchCodeDetail(codecond, 0);
		codecond.setCcid("288");
		List<CodeDetail> ptypeCode = codeDetailBL.searchCodeDetail(codecond, 0);
		dto.setPpqCodeList(ppqCode);
		dto.setPtypeCodeList(ptypeCode);
		log.debug("=================投资使用情况导出结束======================");
		return dto;
	}
	
	/***
	 * 投资类使用合同明细报表导出查询
	 * @param dto
	 * @return
	 */
	public IGPRJ01DTO exportSearchInvestCaAction(IGPRJ01DTO dto){
		List<InvestContractInfoVW> investList = investUseInfoBL.findInvestContractInfo();
		dto.setInvestContractInfoList(investList);
		return dto;
	}
}
