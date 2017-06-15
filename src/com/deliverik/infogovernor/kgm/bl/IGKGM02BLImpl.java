/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.bl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.html.ExportHtml;
import com.deliverik.infogovernor.kgm.bl.task.KnowLedgeInfoBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowLogBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeAppImpactBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeGradeBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeProcessBL;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeStatisticsBL;
import com.deliverik.infogovernor.kgm.dto.IGKGM02DTO;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0201Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0207Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0208Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0216Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0228Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0231Form;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.entity.KnowLedgeInfoVW;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeAppImpactTB;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTB;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTBPK;
import com.deliverik.infogovernor.kgm.vo.IGKGM02052VO;
import com.deliverik.infogovernor.util.CodeDefine;




/**
 * 概述: 知识管理业务逻辑BL实现类
 * 功能描述：知识管理业务逻辑BL实现类
 * 修改记录：
 */
public class IGKGM02BLImpl extends BaseBLImpl implements IGKGM02BL {


	static Log log = LogFactory.getLog(IGKGM02BLImpl.class);
	
	/**知识库查询BL */
	protected KnowLedgeInfoBL knowLedgeInfoBL;
	
	/**知识库主表BL*/
	protected KnowledgeBL knowledgeBL;
	
	/** 数据分类信息BL */
	protected CodeCategoryBL codeCategoryBL;
	
	
	/**知识库评分BL*/
	protected KnowledgeGradeBL knowledgeGradeBL;
	
	/**知识库流程关联BL*/
	protected KnowledgeProcessBL knowledgeProcessBL;
	
	/**附件BL*/
	protected AttachmentBL attachmentBL;
	
	/**附件上传BL*/
	protected FileUploadBL fileUploadBL;
	
	/** 基础数据信息BL */
	protected CodeListUtils codeListUtils;
	
	/** 知识库业务系统BL */
	protected KnowledgeAppImpactBL knowledgeAppImpactBL;
	
	/** 流程BL */
	protected IG500BL ig500BL;
	
	/** 流程详情BL */
	protected IG599BL ig599BL;
	
	/**角色信息业务BL*/
	protected RoleBL roleBL;
	/**用户角色BL*/
	protected UserRoleBL userRoleBL;
	
	/**知识日志BL*/
	protected KnowLogBL knowLogBL;
	
	/**知识库统计BL*/
	protected KnowledgeStatisticsBL knowledgeStatisticsBL;
	
	/**数据定义声明BL*/
	protected CodeDetailDefBL codeDetailDefBL;

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 角色信息业务BL设定
	 * @param roleBL 角色信息业务BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 流程详情BL设定
	 * @param ig599BL 流程详情BL
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	/**
	 * 知识库业务系统BL设定
	 * 
	 * @param knowledgeAppImpactBL 知识库业务系统BL
	 */
	public void setKnowledgeAppImpactBL(KnowledgeAppImpactBL knowledgeAppImpactBL) {
		this.knowledgeAppImpactBL = knowledgeAppImpactBL;
	}

	/**
	 * 基础数据信息BL设定
	 * 
	 * @param codeListUtils基础数据信息BL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}
	
	/**
	 * 附件上传BL设定
	 * @param fileUploadBL附件上传BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * 附件BL设定
	 * @param attachmentBL附件BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}


	/**
	 * 知识库流程关联BL设定
	 * @param knowledgeProcessBL知识库流程关联BL
	 */
	public void setKnowledgeProcessBL(KnowledgeProcessBL knowledgeProcessBL) {
		this.knowledgeProcessBL = knowledgeProcessBL;
	}

	/**
	 * 知识库评分BL设定
	 * @param knowledgeGradeBL 知识库评分BL
	 */
	public void setKnowledgeGradeBL(KnowledgeGradeBL knowledgeGradeBL) {
		this.knowledgeGradeBL = knowledgeGradeBL;
	}
	/**
	 * 知识库查询BL设定
	 * @param knowLedgeInfoBL 知识库查询BL
	 */
	public void setKnowLedgeInfoBL(KnowLedgeInfoBL knowLedgeInfoBL) {
		this.knowLedgeInfoBL = knowLedgeInfoBL;
	}
	
	/**
	 * 知识库统计BL设定
	 * @param knowledgeStatisticsBL 知识库统计BL
	 */
	public void setKnowledgeStatisticsBL(KnowledgeStatisticsBL knowledgeStatisticsBL) {
		this.knowledgeStatisticsBL = knowledgeStatisticsBL;
	}

	/**
	 * 知识查询
	 */
	public IGKGM02DTO searchKnowLedgeInfoAction(IGKGM02DTO dto)
			throws BLException {
		
		return dto;
	}

	/**
	 * 知识库登记BL设定
	 * @param knowLedgeBL 知识库登记BL
	 */
	public void setKnowledgeBL(KnowledgeBL knowledgeBL) {
		this.knowledgeBL = knowledgeBL;
	}

	/**
	 * 知识登记获取
	 * @return knowledgeBL知识登记
	 */
	public KnowledgeBL getKnowledgeBL() {
		return this.knowledgeBL;
	}
	
	/**
	 * 流程BL设定
	 * @param ig500BL 知识库登记BL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * 流程BL获取
	 * @return processRecordBL流程BL
	 */
	public IG500BL getProcessRecordBL() {
		return this.ig500BL;
	}
	
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}
	
	//-----------------------------------------------------------宋海洋----------------------------------------------------------------------
	

	/**
	 * 功能：知识管理(查询)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeAction(IGKGM03DTO dto) throws BLException {

		log.debug("========知识检索处理开始========");
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();//页面显示集合
		
		boolean spgl = dto.getKnowledgeSearchCond() instanceof IGKGM0208Form;
		
		if(spgl){
			//按知识审批人过滤leexuzhi
			dto = this.getRoleKnApproveRole(dto);//取得知识审批人角色
			IGKGM0208Form kdcond = (IGKGM0208Form) dto.getKnowledgeSearchCond();
			boolean qx = false;//是否有知识审批人权限
			List<Role> roleList = dto.getRoleList();
			Integer[] kars = null;
			if(roleList!=null&&roleList.size()>0){
				kars = new Integer[roleList.size()];
				
				for(int i=0;i<roleList.size();i++){
					Role role = roleList.get(i);
					User user = dto.getUser();
					UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
					urcond.setUserid(user.getUserid());
					urcond.setRoleid(role.getRoleid());
					List<UserRole> urList = userRoleBL.searchUserRole(urcond);
					if(urList!=null&&urList.size()>0){
						kars[i]=role.getRoleid();
						qx = true;
					}
				}
				
			}
			
			int totalCount = 0;
			
			if(qx){
				kdcond.setKnapproveroles(kars);
				totalCount = this.knowledgeBL.getSearchCount(kdcond);
			}
			
			if (totalCount == 0) {

				log.debug("========知识检索数据不存在========");
				// 知识服务检索数据不存在
				dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

				return dto;
			}

			if (totalCount > dto.getMaxSearchCount()) {

				log.debug("========知识检索数据件数过多========");
				// 知识服务检索数据件数过多
				dto.addMessage(new ActionMessage("IGCO00000.E005", dto
						.getMaxSearchCount(), totalCount));

				return dto;
			}
			
			if(qx){
				knowledgeList = knowledgeBL.searchKnowledgeByCond(kdcond, pDto.getFromCount(), pDto.getPageDispCount());
			}
			
			dto.setKnowledgeList(knowledgeList);
			pDto.setTotalCount(totalCount);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		}else{
			int totalCount  = this.knowledgeBL.getSearchCount(dto.getKnowledgeSearchCond());
			
			if (totalCount == 0) {

				log.debug("========知识检索数据不存在========");
				// 知识服务检索数据不存在
				dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

				return dto;
			}

			if (totalCount > dto.getMaxSearchCount()) {

				log.debug("========知识检索数据件数过多========");
				// 知识服务检索数据件数过多
				dto.addMessage(new ActionMessage("IGCO00000.E005", dto
						.getMaxSearchCount(), totalCount));

				return dto;
			}
			
			knowledgeList = knowledgeBL.searchKnowledgeByCond(dto.getKnowledgeSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
			
			
			dto.setKnowledgeList(knowledgeList);
			pDto.setTotalCount(totalCount);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		}
		
		

		

		log.debug("========知识检索处理终了========");

		return dto;
	}
	
	/**
	 * 功能：更新知识状态
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateKnowLedgeStatus(IGKGM03DTO dto) throws BLException {

		String[] knids = dto.getKnids();
		String[] knrejects = dto.getKnrejects();
		String[] knversions = dto.getKnversions();
		KnowledgeTB tb = new KnowledgeTB();

		for (int i = 0; i < knids.length; i++) {
			
			//审核时：首先将现有知识状态改为删除
			if(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED.equals(dto.getKnstatus()) && Integer.valueOf(knversions[i])>1){
				//更新当期版本
				KnowledgeSearchCondImpl searchCon = new KnowledgeSearchCondImpl();
				searchCon.setKnid(Integer.valueOf(knids[i]));
				searchCon.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
				Knowledge knowledgeNow = this.knowledgeBL.searchKnowledgeByByKnid(searchCon);
				if(knowledgeNow !=null){
					KnowledgeTB knowledgeNowTB = (KnowledgeTB)SerializationUtils.clone(knowledgeNow);
					knowledgeNowTB.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_DELETE);
					this.knowledgeBL.updateKnowledge(knowledgeNowTB);
				}
			}
			
			
			//更新或驳回处理，将知识状态更新。
			KnowledgeTBPK pk = new KnowledgeTBPK(Integer.valueOf(knids[i]),Integer.valueOf(knversions[i]));
			Knowledge knowledge = this.knowledgeBL.searchKnowledgeByPK(pk);
			tb = (KnowledgeTB)SerializationUtils.clone(knowledge);
			tb.setKnstatus(dto.getKnstatus());
			if(IGKGMCONSTANTS.KNOWLEDGE_REJECT.equals(dto.getKnstatus())){//填写驳回原因
				tb.setKnreject(knrejects[i]);
			}
			tb.setKnapprover(dto.getUser().getUserid());
			tb.setKnapprovername(dto.getUser().getUsername());
			tb.setKnapprovetime(IGStringUtils.getCurrentDateTime());

			this.knowledgeBL.updateKnowledge(tb);
			
		}

		return dto;
	}
	
	/**
	 * 功能：更新知识状态
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateOneKnowLedgeStatus(IGKGM03DTO dto) throws BLException {

		KnowledgeTB tb = new KnowledgeTB();

		//审核时：首先将现有知识状态改为删除
		if(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED.equals(dto.getKnstatus()) && Integer.valueOf(dto.getKnversion())>1){
			//更新当期版本
			KnowledgeSearchCondImpl searchCon = new KnowledgeSearchCondImpl();
			searchCon.setKnid(Integer.valueOf(dto.getKnid()));
			searchCon.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
			Knowledge knowledgeNow = this.knowledgeBL.searchKnowledgeByByKnid(searchCon);
			if(knowledgeNow !=null){
				KnowledgeTB knowledgeNowTB = (KnowledgeTB)SerializationUtils.clone(knowledgeNow);
				knowledgeNowTB.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_DELETE);
				this.knowledgeBL.updateKnowledge(knowledgeNowTB);
			}
		}
		
		
		//更新或驳回处理，将知识状态更新。
		KnowledgeTBPK pk = new KnowledgeTBPK(Integer.valueOf(dto.getKnid()),Integer.valueOf(dto.getKnversion()));
		Knowledge knowledge = this.knowledgeBL.searchKnowledgeByPK(pk);
		tb = (KnowledgeTB)SerializationUtils.clone(knowledge);
		tb.setKnstatus(dto.getKnstatus());
		if("2".equals(dto.getKnstatus())){
			this.knowLogBL.addKnowLog(tb.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_RJECT+"  "+dto.getRlcomment());
		}
		if(StringUtils.isNotEmpty(dto.getRlcomment())){
			tb.setKnreject(dto.getRlcomment());
		}
		tb.setKnapprover(dto.getUser().getUserid());
		tb.setKnapprovername(dto.getUser().getUsername());
		tb.setKnapprovetime(IGStringUtils.getCurrentDateTime());

		this.knowledgeBL.updateKnowledge(tb);
		return dto;
	}
	
	/**
	 * 功能：查询自己提交的知识
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchMyKnowLedgeAction(IGKGM03DTO dto) throws BLException {

		log.debug("========知识检索处理开始========");
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();//页面显示集合
	
		int totalCount = this.knowledgeBL.getSearchCount(dto.getKnowledgeSearchCond());

		if (totalCount == 0) {

			log.debug("========知识检索数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========知识检索数据件数过多========");
			// 知识服务检索数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		knowledgeList = knowledgeBL.searchKnowledgeByCond(dto.getKnowledgeSearchCond(), pDto
				.getFromCount(), pDto.getPageDispCount());
		dto.setKnowledgeList(knowledgeList);
		pDto.setTotalCount(totalCount);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========知识检索处理终了========");

		return dto;
	}
	//-----------------------------------------------------------刘鹏----------------------------------------------------------------------
	
	
	
	//-----------------------------------------------------------王晓强----------------------------------------------------------------------

	/**
	 * 知识查询
	 */
	public IGKGM03DTO searchKnowLedgeInfoAction(IGKGM03DTO dto)
			throws BLException {
		log.debug("========知识检索处理开始========");
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		IGKGM0203Form form = dto.getIgkgm0203Form();
		if(form.getKnkey() != null){
			String[] keys = form.getKnkey().split(" ");
			form.setKnkeys(keys);
		}
		String[] titles = form.getKntitle().split(" ");
		List<KnowLedgeInfo> knowLedgeList = new ArrayList<KnowLedgeInfo>();//页面显示集合
	
		form.setKntitles(titles);
		int totalCount = this.knowLedgeInfoBL.getSearchCount(form);

		if (totalCount == 0) {

			log.debug("========知识检索数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========知识检索数据件数过多========");
			// 知识服务检索数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		knowLedgeList = knowLedgeInfoBL.searchKnowLedgeInfoByCond(form, pDto
				.getFromCount(), pDto.getPageDispCount());
		List<KnowLedgeInfo> knowLedgeListkl = new ArrayList<KnowLedgeInfo>();
		for(KnowLedgeInfo kli:knowLedgeList){
			KnowLedgeInfoVW kliVW = (KnowLedgeInfoVW)kli;
//			kliVW.setKntitle(getTurnString(kliVW.getKntitle()));
			knowLedgeListkl.add(kliVW);
		}
		dto.setKnowLedgeInfoList(knowLedgeListkl);
		pDto.setTotalCount(totalCount);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========知识检索处理终了========");

		return dto;
	}
	
	/**
	 * 知识库明细查询
	 * @param knid
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeDetailAction(IGKGM03DTO dto)
			throws BLException {
		//联合主键
		KnowledgeTBPK pk = new KnowledgeTBPK();
		//联合主键设定
		pk.setKnid(dto.getKnid());
		pk.setKnversion(dto.getKnversion());
		//查询知识详细内容
		Knowledge knowledge = this.knowledgeBL.searchKnowledgeByPK(pk);
		//知识相关流程查询
		List<KnowledgeProcess> knowledgeProcessList = knowledgeProcessBL.searchProcessByKnid(dto.getKnid());
		
		dto.setKnowledge(knowledge);
		
		dto.setKnowledgeProcessList(knowledgeProcessList);
		
		return dto;
	}


	/**
	 * 知识评分表查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeGradeAction(IGKGM03DTO dto)
			throws BLException {
		
		//cond初始化
		KnowledgeGradeSearchCondImpl cond = new KnowledgeGradeSearchCondImpl();
		
		if(dto.getKnid()!=null){
			cond.setKnid(dto.getKnid());
		}
		
		int totalCount = this.knowledgeGradeBL.getSearchCount(cond);

		if (totalCount == 0) {

			log.debug("========知识评分检索数据不存在========");
			// 知识服务检索数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));

			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {

			log.debug("========知识检索数据件数过多========");
			// 知识服务检索数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));

			return dto;
		}
		
		
		List<KnowledgeGrade> knowledgeGradeList = this.knowledgeGradeBL.findKnowledgeGradeByCond(cond, 0,0);
		dto.setKnowledgeGradeList(knowledgeGradeList);
		
		
		return dto;
	}

	/**
	 * 知识评分登记
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO registKnowledgeGradeAction(IGKGM03DTO dto)
			throws BLException {
		//form取得
		IGKGM0207Form form = dto.getIgkgm0207Form();
		//评分登记
		this.knowledgeGradeBL.saveKnowledgeGrade(form);
		
		List<KnowledgeProcess> knowledgeProcessList = knowledgeProcessBL.searchProcessByKnid(dto.getKnid());
		
		dto.setKnowledgeProcessList(knowledgeProcessList);
		
		this.knowLogBL.addKnowLog(form.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(),IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_PINGFEN+"  分数:"+form.getKggrade()+"\n评语:"+form.getKgappraise());
		return dto;
	}

	/**
	 * 功能：知识详细信息查询(主键查询)
	 *
	 * @param IGKGM03DTO 
	 * @return IGKGM03DTO
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeDetailActionbyPK(IGKGM03DTO dto)
			throws BLException {
		//联合主键
		KnowledgeTBPK pk = new KnowledgeTBPK();
		//联合主键设定
		pk.setKnid(dto.getKnid());
		
		pk.setKnversion(dto.getKnversion());
		//查询知识详细内容
		dto.setKnowledge(this.knowledgeBL.searchKnowledgeByPK(pk));
		//在流程处理中关联打开知识明细页面的流程
		dto.setKnowledgeProcessList(this.knowledgeProcessBL.searchProcessByKnid(dto.getKnid()));
		if(dto.getPrid() != null && dto.getPrid() > 0) {
			this.knowledgeProcessBL.registKnowledgeProcess(dto.getPrid(), dto.getKnid(), dto.getKnversion());
		}
		if(dto.getSfid() != null && dto.getSfid() > 0) {
			this.knowledgeProcessBL.registKnowledgeService(dto.getSfid(), dto.getKnid(), dto.getKnversion());
		}
		return dto;
	}
	
	/**
	 * 功能：查询知识历史信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeHistory(IGKGM03DTO dto) throws BLException {
		//查询条件
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		//设定知识ID
		cond.setKnid(dto.getKnid());
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);
		//查询知识历史版本结果
		List<Knowledge> knowledgeList = knowledgeBL.getKnowledgeHistory(cond);
		//除去第一条记录
		//knowledgeList.remove(0);

		List<IGKGM02052VO> voList = new ArrayList<IGKGM02052VO>();
		for(Knowledge kl : knowledgeList){
			IGKGM02052VO vo = new IGKGM02052VO();
			vo.setKnowledge(kl);
			KnowledgeAppImpactSearchCondImpl kacond = new KnowledgeAppImpactSearchCondImpl();
			kacond.setKnid(kl.getKnid());
			kacond.setKnversion(kl.getKnversion());
			List<KnowledgeAppImpact> processAppImpactList = knowledgeAppImpactBL.findKnowledgeAppImpactByCond(kacond, 0, 0);
			vo.setKnowledgeAppImpactList(processAppImpactList);
			voList.add(vo);
		}

		dto.setVoList(voList);
		dto.setKnowledgeList(knowledgeList);
		return dto;
	}
	
	/**
	 * 功能：查看知识关联的流程和服务工单
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeProcessByKnid(IGKGM03DTO dto) throws BLException {
		//查询问题关联流程List
		List<KnowledgeProcess> knowledgeProcessList = knowledgeProcessBL.searchKnowledgeProcessByKnid(dto.getKnid());
		//查询结果设定到DTO中
		dto.setKnowledgeProcessList(knowledgeProcessList);
		return dto;
	}
	
	//-----------------------------------------------------------崔东东----------------------------------------------------------------------

	/**
	 * 知识更新,查询Knowledge表
	 */
	public IGKGM03DTO searchUpdateKnowLedgeActionbyPK(IGKGM03DTO dto) throws BLException {
		
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();
		KnowledgeTBPK knowledgeTBPK = new KnowledgeTBPK();
		knowledgeTBPK.setKnid(dto.getIgkgm0216Form().getKnid());
		knowledgeTBPK.setKnversion(dto.getIgkgm0216Form().getKnversion());
		Knowledge knowledge = knowledgeBL.searchKnowledgeByPK(knowledgeTBPK);
		
		knowledgeList.add(knowledge);
		IGKGM0216Form iGKGM0216Form = dto.getIgkgm0216Form();
		iGKGM0216Form.setKnversion(knowledge.getKnversion());
		iGKGM0216Form.setKntelarea(knowledge.getKntelarea());
		iGKGM0216Form.setKntelareaname(knowledge.getKntelareaname());
		iGKGM0216Form.setKnarea(knowledge.getKnarea());
		iGKGM0216Form.setKnareaname(knowledge.getKnareaname());
		iGKGM0216Form.setKntitle(knowledge.getKntitle());
		iGKGM0216Form.setKnserial(knowledge.getKnserial());
		iGKGM0216Form.setKnreject(knowledge.getKnreject());
		iGKGM0216Form.setKndepartment(knowledge.getKndepartment());
		iGKGM0216Form.setKnapprover(knowledge.getKnapprover());
		iGKGM0216Form.setKnapprovetime(knowledge.getKnapprovetime());
		iGKGM0216Form.setKnclass(knowledge.getKnclass());
		iGKGM0216Form.setKnkey(knowledge.getKnkey());
		iGKGM0216Form.setKnorigin(knowledge.getKnorigin());
		iGKGM0216Form.setKnoriginname(knowledge.getKnoriginname());
		iGKGM0216Form.setKnproffer(knowledge.getKnproffer());
		iGKGM0216Form.setKnproffertime(knowledge.getKnproffertime());
		iGKGM0216Form.setKndes(knowledge.getKndes());
		iGKGM0216Form.setKnfaultcause(knowledge.getKnfaultcause());
		iGKGM0216Form.setKnsolveway(knowledge.getKnsolveway());
		iGKGM0216Form.setKnstatus(knowledge.getKnstatus());
		iGKGM0216Form.setKnclassname(knowledge.getKnclassname());
		iGKGM0216Form.setKnattkey(knowledge.getKnattkey());
		iGKGM0216Form.setKnapproverole(knowledge.getKnapproverole());
		dto.setIgkgm0216Form(iGKGM0216Form);
		dto.setKnowledgeList(knowledgeList);
		//流程关联知识集合查询处理
		dto.setKnowledgeProcessList(this.knowledgeProcessBL.searchProcessByKnid(dto.getIgkgm0216Form().getKnid()));
		return dto;
	}
	
	/**
	 * 知识登记,查询Knowledge表
	 */
	public IGKGM03DTO searchKnowLedgeActionbyPK(IGKGM03DTO dto) throws BLException {
		
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();
		KnowledgeTBPK knowledgeTBPK = new KnowledgeTBPK();
		knowledgeTBPK.setKnid(dto.getIgkgm0201Form().getKnid());
		knowledgeTBPK.setKnversion(dto.getIgkgm0201Form().getKnversion());
		Knowledge knowledge = knowledgeBL.searchKnowledgeByPK(knowledgeTBPK);
		knowledgeList.add(knowledge);
		IGKGM0201Form iGKGM0201Form = dto.getIgkgm0201Form();
		iGKGM0201Form.setKntitle(knowledge.getKntitle());
		iGKGM0201Form.setKnoriginname(knowledge.getKnoriginname());
		iGKGM0201Form.setKnarea(knowledge.getKnarea());
		iGKGM0201Form.setKnareaname(knowledge.getKnareaname());
		iGKGM0201Form.setKntelarea(knowledge.getKntelarea());
		iGKGM0201Form.setKntelareaname(knowledge.getKntelareaname());
		iGKGM0201Form.setKnserial(knowledge.getKnserial());
		iGKGM0201Form.setKnreject(knowledge.getKnreject());
		iGKGM0201Form.setKndepartment(knowledge.getKndepartment());
		iGKGM0201Form.setKnapprover(knowledge.getKnapprover());
		iGKGM0201Form.setKnapprovetime(knowledge.getKnapprovetime());
		iGKGM0201Form.setKnclass(knowledge.getKnclass());
		iGKGM0201Form.setKnkey(knowledge.getKnkey());
		iGKGM0201Form.setKnorigin(knowledge.getKnorigin());
		iGKGM0201Form.setKnproffer(knowledge.getKnproffer());
		iGKGM0201Form.setKnproffertime(knowledge.getKnproffertime());
		iGKGM0201Form.setKndes(knowledge.getKndes());
		iGKGM0201Form.setKnfaultcause(knowledge.getKnfaultcause());
		iGKGM0201Form.setKnsolveway(knowledge.getKnsolveway());
		iGKGM0201Form.setKnstatus(knowledge.getKnstatus());
		iGKGM0201Form.setKnclassname(knowledge.getKnclassname());
		iGKGM0201Form.setKnattkey(knowledge.getKnattkey());
		iGKGM0201Form.setKnapproverole(knowledge.getKnapproverole());
		dto.setIgkgm0201Form(iGKGM0201Form);
		dto.setKnowledgeList(knowledgeList);
		
		//流程关联知识集合查询处理
		dto.setKnowledgeProcessList(this.knowledgeProcessBL.searchProcessByKnid(dto.getIgkgm0201Form().getKnid()));
		return dto;
	}
	
	/**
	 * 知识登记,修改后保存到Knowledge表
	 */
	public IGKGM03DTO updateKnowLedgeAction(IGKGM03DTO dto) throws BLException {
		
		IGKGM0201Form iGKGM0201Form = dto.getIgkgm0201Form();
		///this.uploadFileAction(dto);  song
		KnowledgeTB knowledgeTB = new KnowledgeTB();
		knowledgeTB.setKnid(Integer.valueOf(iGKGM0201Form.getKnid()));
		knowledgeTB.setKnversion(Integer.valueOf(iGKGM0201Form.getKnversion()));
		knowledgeTB.setKnkey(iGKGM0201Form.getKnkey());
		knowledgeTB.setKnreject(iGKGM0201Form.getKnreject());
		knowledgeTB.setKnproffer(dto.getUser().getUserid());
		if(StringUtils.isNotEmpty(iGKGM0201Form.getKnproffername())){
			knowledgeTB.setKnapprover(iGKGM0201Form.getKnapprover());//归档人
			knowledgeTB.setKnproffer(iGKGM0201Form.getKnproffer());
			knowledgeTB.setKnproffername(iGKGM0201Form.getKnproffername());//知识贡献人
		}else{
			KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
			cond.setKnid(Integer.valueOf(iGKGM0201Form.getKnid()));
			Knowledge kl = knowledgeBL.searchKnowledgeByByKnid(cond);//获取最新版本知识信息
			knowledgeTB.setKnapprover(kl.getKnapprover());//归档人
			knowledgeTB.setKnproffer(iGKGM0201Form.getKnproffer());//贡献人
			knowledgeTB.setKnproffername(kl.getKnproffername());

		}
		knowledgeTB.setKnproffertime(iGKGM0201Form.getKnproffertime());
		knowledgeTB.setKnserial(iGKGM0201Form.getKnserial());
		knowledgeTB.setKnorigin(iGKGM0201Form.getKnorigin());
		knowledgeTB.setKnoriginname(iGKGM0201Form.getKnoriginname());
		knowledgeTB.setKnarea(iGKGM0201Form.getKnarea());
		knowledgeTB.setKnareaname(iGKGM0201Form.getKnareaname());
		knowledgeTB.setKntelarea(iGKGM0201Form.getKntelarea());
		knowledgeTB.setKntelareaname(iGKGM0201Form.getKntelareaname());
		
		knowledgeTB.setKntitle(iGKGM0201Form.getKntitle());
		knowledgeTB.setKnclass(iGKGM0201Form.getKnclass());
		knowledgeTB.setKnclassname(iGKGM0201Form.getKnclassname());
		knowledgeTB.setKndepartment(iGKGM0201Form.getKndepartment());
		knowledgeTB.setKndes(iGKGM0201Form.getKndes());
		knowledgeTB.setKnfaultcause(iGKGM0201Form.getKnfaultcause());
		knowledgeTB.setKnsolveway(iGKGM0201Form.getKnsolveway());
		knowledgeTB.setKnstatus(iGKGM0201Form.getKnstatus());
		if(iGKGM0201Form.getFileMap() !=null && iGKGM0201Form.getFileMap().size()>0){
			knowledgeTB.setKnattkey(this.uploadFileAction(iGKGM0201Form.getKnattkey(),iGKGM0201Form.getFileMap()));
		}
		knowledgeTB.setKnapproverole(iGKGM0201Form.getKnapproverole());
		if(StringUtils.isNotEmpty(iGKGM0201Form.getKnattkey())){
			knowledgeTB.setKnattkey(iGKGM0201Form.getKnattkey());
		}
		Knowledge knowledge = knowledgeBL.updateKnowledge(knowledgeTB);
		//知识关联流程处理
		this.knowledgeProcessBL.knowledgeRelateProcess(knowledge.getKnid(), knowledge.getKnversion(), iGKGM0201Form.getProcessList());
		//<<<<<<<<<<<<<< add by wangxiaoqiang 知识业务系统更新
		dto.setKnid(knowledge.getKnid());
		dto.setKnversion(knowledge.getKnversion());
		//更新
//		if(!dto.isCheckflag()){
			List<KnowledgeAppImpact> knowledgeAppImpactList = this.getKnowledgeAppImpact(dto).getKnowledgeAppImpactList();
			if(knowledgeAppImpactList!=null && knowledgeAppImpactList.size()>0){
				for(int i=0;i<knowledgeAppImpactList.size();i++){
					knowledgeAppImpactBL.deleteKnowledgeAppImpact(knowledgeAppImpactList.get(i));
				}
			}
		
			if(iGKGM0201Form.getKaicodes()!=null && iGKGM0201Form.getKaicodes().length>0){
				for(int i=0;i<iGKGM0201Form.getKaicodes().length;i++){
					if(!("".equals(iGKGM0201Form.getKaicodes()[i]))){
						KnowledgeAppImpactTB knowledgeAppImpactTB = new KnowledgeAppImpactTB();
						knowledgeAppImpactTB.setKaicode(iGKGM0201Form.getKaicodes()[i]);
						knowledgeAppImpactTB.setKnid(dto.getKnid());
						knowledgeAppImpactTB.setKnversion(knowledge.getKnversion());
						knowledgeAppImpactBL.saveKnowledgeAppImpact(knowledgeAppImpactTB);
					}
				}
			}
//		}
		//<<<<<<<<<<<<<< add by wangxiaoqiang 知识业务系统更新
		
		
		
	//删除指定附件开始=====================>
		if(StringUtils.isNotEmpty(dto.getDelFiles())){
			String[] files = (dto.getDelFiles()).split("[|]");
			if(files != null){
				for(String fileId:files){
					if(StringUtils.isNotEmpty(fileId)){
						Attachment attFile = attachmentBL.searchAttachmentByKey(Integer.parseInt(fileId));
						attachmentBL.deleteAttachment(attFile);
					}
				}
			}
		}
	//删除指定附件结束=====================<
	

	//删除相关案例开始=====================>
		if(StringUtils.isNotEmpty(dto.getDelKgm())){
			String[] kgms = (dto.getDelKgm()).split("[|]");
			if(kgms != null){
				for(String kpid:kgms){
					if(StringUtils.isNotEmpty(kpid)){
						knowledgeProcessBL.deleteKnowledgeProcess(Integer.parseInt(kpid));
					}
				}
			}
		}
	//删除相关案例结束=====================<

		if(iGKGM0201Form.getKnstatus().equals(IGKGMCONSTANTS.KNOWLEDGE_INIT)){
			knowLogBL.addKnowLog(knowledge.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_UPDATE);
		}else if(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE.equals(iGKGM0201Form.getKnstatus())){
			knowLogBL.addKnowLog(knowledge.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_WAIT);
		}else if(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED.equals(iGKGM0201Form.getKnstatus())){
			knowLogBL.addKnowLog(knowledge.getKnid(), dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_APPROCE);
		}
		
		
		log.debug("========知识信息变更处理终了========");
		return dto;
	}
	
	/**
	 * 插入一条知识更新数据
	 */
	public synchronized IGKGM03DTO  insertKnowledgeAction(IGKGM03DTO dto) throws BLException {
		synchronized (this) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new BLException("IGCO00000.E001");
			}

		IGKGM0216Form form = dto.getIgkgm0216Form();
		KnowledgeTB recordLogKnTB = new KnowledgeTB();
		recordLogKnTB.setKnid(form.getKnid());
		int version = form.getKnversion().intValue() + 1;
		recordLogKnTB.setKnversion(version);
		recordLogKnTB.setKnserial(form.getKnserial());
		recordLogKnTB.setKndepartment(form.getKndepartment());
		recordLogKnTB.setKnproffer(dto.getUser().getUserid());
		recordLogKnTB.setKnproffername(dto.getUser().getUsername());//知识贡献人
		recordLogKnTB.setKnproffertime(IGStringUtils.getCurrentDateTime());//知识贡献时间
		recordLogKnTB.setKnclass(form.getKnclass());
		recordLogKnTB.setKnclassname(form.getKnclassname());
		recordLogKnTB.setKnkey(form.getKnkey());
		recordLogKnTB.setKnorigin(form.getKnorigin());
		recordLogKnTB.setKnoriginname(form.getKnoriginname());
		
		recordLogKnTB.setKnarea(form.getKnarea());
		recordLogKnTB.setKnareaname(form.getKnareaname());
		recordLogKnTB.setKntelarea(form.getKntelarea());
		recordLogKnTB.setKntelareaname(form.getKntelareaname());
		
		recordLogKnTB.setKntitle(form.getKntitle());
		recordLogKnTB.setKndes(form.getKndes());
		recordLogKnTB.setKnfaultcause(form.getKnfaultcause());
		recordLogKnTB.setKnsolveway(form.getKnsolveway()); 
		recordLogKnTB.setKnstatus(form.getKnstatus());
		recordLogKnTB.setKndes(form.getKndes());
		recordLogKnTB.setKnapproverole(form.getKnapproverole());
//		recordLogKnTB.setKnattkey(form.getKnattkey());
		if(version==1 && form.getFileMap() !=null && form.getFileMap().size()>0){
		    recordLogKnTB.setKnattkey(this.uploadFileAction(form.getKnattkey(),form.getFileMap()));
		}
		if(form.getKnattkey()!=null){
			recordLogKnTB.setKnattkey(form.getKnattkey());
		}
		
		//知识库更新附件修改
		if (version > 1) {

			List<Attachment> attachmentList = new ArrayList<Attachment>();
			if (form.getKnattkey() != null && (!"".equals(form.getKnattkey()))) {
				// 取得原有的附件list
				attachmentList = attachmentBL.searchAttachmentsByAttkey(form
						.getKnattkey());
				// 剩余的附件list
				//List<Attachment> attachmentLeaveList = new ArrayList<Attachment>();
				
				if (StringUtils.isNotEmpty(dto.getDelFiles())) {// 前台画面进行了附件删除操作
					String[] files = (dto.getDelFiles()).split("[|]");
					if (files != null) {
						// 从原有附件列表中，去掉本次画面上删除的附件
						for (Iterator<Attachment> iter = attachmentList.iterator(); iter.hasNext();) {
							
							Attachment attachment = null;
							attachment = iter.next();
							for (String fileId : files) {
								if (StringUtils.isNotEmpty(fileId)
										&& attachment.getAttid() == Integer
												.parseInt(fileId)) {
									iter.remove();
								}
							}
						}
					}
				}
			}
			
			
			
			

			String attkey_new = null;// 新的附件key
			// 前台画面添加附件时，调用附件上传函数生成key
			if (form.getFileMap() != null && form.getFileMap().size() > 0) {
				attkey_new = this.uploadFileAction(null, form.getFileMap());
				for (int i = 0; i < attachmentList.size(); i++) {
					AttachmentTB attachmentTB = new AttachmentTB();
					attachmentTB.setAttkey(attkey_new);
					attachmentTB.setAttdesc(attachmentList.get(i).getAttdesc());
					attachmentTB.setAttname(attachmentList.get(i).getAttname());
					attachmentTB.setAtturl(attachmentList.get(i).getAtturl());
					attachmentBL.registAttachment(attachmentTB);
				}
			// 前台没有添加附件，但是上版知识有附件，用随机函数生成key
			} else if(attachmentList !=null && attachmentList.size()>0){
				attkey_new = IGStringUtils.getAttKey();
				for (int i = 0; i < attachmentList.size(); i++) {
					AttachmentTB attachmentTB = new AttachmentTB();
					attachmentTB.setAttkey(attkey_new);
					attachmentTB.setAttdesc(attachmentList.get(i).getAttdesc());
					attachmentTB.setAttname(attachmentList.get(i).getAttname());
					attachmentTB.setAtturl(attachmentList.get(i).getAtturl());
					attachmentBL.registAttachment(attachmentTB);
				}
			}
			
			recordLogKnTB.setKnattkey(attkey_new);
			
			//删除相关案例开始=====================>
			if(StringUtils.isNotEmpty(dto.getDelKgm())){
				String[] kgms = (dto.getDelKgm()).split("[|]");
				if(kgms != null){
					for(String kpid:kgms){
						if(StringUtils.isNotEmpty(kpid)){
							knowledgeProcessBL.deleteKnowledgeProcess(Integer.parseInt(kpid));
						}
					}
				}
			}
		//删除相关案例结束=====================<
		}
		
		Knowledge recordLogKn = this.knowledgeBL.registKnowledge(recordLogKnTB);
		
		//<<<<<<<<<<<<<< add by wangxiaoqiang 知识业务系统更新
		dto.setKnid(recordLogKn.getKnid());
		dto.setKnversion(recordLogKn.getKnversion());
		List<KnowledgeAppImpact> knowledgeAppImpactList = this.getKnowledgeAppImpact(dto).getKnowledgeAppImpactList();
		if(knowledgeAppImpactList!=null && knowledgeAppImpactList.size()>0){
			for(int i=0;i<knowledgeAppImpactList.size();i++){
				knowledgeAppImpactBL.deleteKnowledgeAppImpact(knowledgeAppImpactList.get(i));
			}
		}
		
		if(form.getKaicodes()!=null && form.getKaicodes().length>0){
			for(int i=0;i<form.getKaicodes().length;i++){
				if(!("".equals(form.getKaicodes()[i]))){
					KnowledgeAppImpactTB knowledgeAppImpactTB = new KnowledgeAppImpactTB();
					knowledgeAppImpactTB.setKaicode(form.getKaicodes()[i]);
					knowledgeAppImpactTB.setKnid(dto.getKnid());
					knowledgeAppImpactTB.setKnversion(recordLogKn.getKnversion());
					knowledgeAppImpactBL.saveKnowledgeAppImpact(knowledgeAppImpactTB);
				}
			}
			
		}
		//<<<<<<<<<<<<<< add by wangxiaoqiang 知识业务系统更新
		
		

		//知识关联流程处理
		this.knowledgeProcessBL.knowledgeRelateProcess(recordLogKn.getKnid(), recordLogKn.getKnversion(), form.getProcessList());
		knowLogBL.addKnowLog(recordLogKn.getKnid(),dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_UPDATE);


		dto.addMessage(new ActionMessage( "IGCO10000.I004", "知识") );
		return dto;
		}
	}
	
	/**
	 * 插入知识登记
	 */
	public synchronized IGKGM03DTO insertAction(IGKGM03DTO dto) throws BLException {
		synchronized (this) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new BLException("IGCO00000.E001");
			}

		int temp = 0;
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		List<Knowledge> knowledgeList = knowledgeBL.searchKnowledgeByCond(cond, 0, 0);
		if(null != knowledgeList && knowledgeList.size() >0){
			
			for(int i=0;i<knowledgeList.size();i++){
				if(knowledgeList.get(i).getKnid().intValue() > temp){
					temp = knowledgeList.get(i).getKnid().intValue();
				}
			}
		}
		Integer maxid = Integer.valueOf(temp + 1);
		IGKGM0201Form form = dto.getIgkgm0201Form();
		KnowledgeTB KnowledgeTB = new KnowledgeTB();
		int id = maxid.intValue() + 1;
		KnowledgeTB.setKnid(Integer.valueOf(String.valueOf(id)));
		KnowledgeTB.setKnversion(Integer.valueOf("1"));
		KnowledgeTB.setKnserial(form.getKnserial());
		
		KnowledgeTB.setKnarea(form.getKnarea());
		KnowledgeTB.setKnareaname(form.getKnareaname());
		KnowledgeTB.setKntelarea(form.getKntelarea());
		KnowledgeTB.setKntelareaname(form.getKntelareaname());
		KnowledgeTB.setKnorigin(form.getKnorigin());
		KnowledgeTB.setKnoriginname(form.getKnoriginname());
		
		KnowledgeTB.setKndepartment(form.getKndepartment());
		KnowledgeTB.setKnproffer(dto.getUser().getUserid());
		KnowledgeTB.setKnproffername(dto.getUser().getUsername());//知识贡献人
		KnowledgeTB.setKnproffertime(IGStringUtils.getCurrentDateTime());//知识贡献时间
		KnowledgeTB.setKnclass(form.getKnclass());
		KnowledgeTB.setKnclassname(form.getKnclassname());
		KnowledgeTB.setKnkey(form.getKnkey());
		KnowledgeTB.setKntitle(form.getKntitle());
		KnowledgeTB.setKndes(form.getKndes());
		KnowledgeTB.setKnfaultcause(form.getKnfaultcause());
		KnowledgeTB.setKnsolveway(form.getKnsolveway()); 
		KnowledgeTB.setKnstatus(form.getKnstatus());
		KnowledgeTB.setKndes(form.getKndes());
		if(form.getFileMap() !=null && form.getFileMap().size()>0){
		    KnowledgeTB.setKnattkey(this.uploadFileAction(form.getKnattkey(),form.getFileMap()));
		}
		KnowledgeTB.setKnapproverole(form.getKnapproverole());
		Knowledge recordLogKn = this.knowledgeBL.registKnowledge(KnowledgeTB);
		Integer knid = recordLogKn.getKnid();
		if(form.getKaicodes()!=null && form.getKaicodes().length>0){
			for(int i=0;i<form.getKaicodes().length;i++){
				if(!("".equals(form.getKaicodes()[i]))){
					KnowledgeAppImpactTB knowledgeAppImpactTB = new KnowledgeAppImpactTB();
					knowledgeAppImpactTB.setKaicode(form.getKaicodes()[i]);
					knowledgeAppImpactTB.setKnid(knid);
					knowledgeAppImpactTB.setKnversion(recordLogKn.getKnversion());
					knowledgeAppImpactBL.saveKnowledgeAppImpact(knowledgeAppImpactTB);
				}
			}
		}
		
		//知识关联流程处理
		this.knowledgeProcessBL.knowledgeRelateProcess(recordLogKn.getKnid(), recordLogKn.getKnversion(), form.getProcessList());
		knowLogBL.addKnowLog(recordLogKn.getKnid(),dto.getUser().getUserid(), dto.getUser().getUsername(), IGStringUtils.getCurrentDateTime(), IGKGMCONSTANTS.KNOWLOG_INSERT);

		dto.addMessage(new ActionMessage( "IGCO10000.I004", "知识") );
		return dto;
		}
	}
	
	/**
	 * 知识评分表查询
	 * @param dto
	 * @return 返回值0表示没有未审批的“知识更新”数据。1表示有。
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeNotCheckAction(IGKGM03DTO dto)
			throws BLException {
		
		//知识更新，查找是否有更新但未审批过的知识。
		int totalCount = 0;
		KnowledgeSearchCondImpl knowledgeSearchCond = new KnowledgeSearchCondImpl();
//		knowledgeSearchCond.setKnid(dto.getIgkgm0216Form().getKnid());
		knowledgeSearchCond.setKnid(dto.getKnid());
		knowledgeSearchCond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE +","+IGKGMCONSTANTS.KNOWLEDGE_REJECT +","+IGKGMCONSTANTS.KNOWLEDGE_INIT);
		List<Knowledge> knowledgeList = this.knowledgeBL.searchKnowledgeByCond(knowledgeSearchCond, 0,0);
		if(null != knowledgeList && knowledgeList.size()>0){
			totalCount = 1;
			dto.setKnowledgeList(knowledgeList);
			dto.setKnowledge(knowledgeList.get(0));
		}
		dto.setVersions(totalCount);
		return dto;
	}

	/**
	 * 知识详细页面查询
	 * @param dto
	 * @return 返回值0表示没有未审批的“知识更新”数据。1表示有。
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeNotCheckActionForKGMDis(IGKGM03DTO dto)
			throws BLException {
		//知识更新，查找是否有更新但未审批过的知识。
		int totalCount = 0;
		KnowledgeSearchCondImpl knowledgeSearchCond = new KnowledgeSearchCondImpl();
		knowledgeSearchCond.setKnid(dto.getKnid());
		knowledgeSearchCond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE +","+IGKGMCONSTANTS.KNOWLEDGE_REJECT +","+IGKGMCONSTANTS.KNOWLEDGE_INIT);
		List<Knowledge> knowledgeList = this.knowledgeBL.searchKnowledgeByCond(knowledgeSearchCond, 0,0);
		if(null != knowledgeList && knowledgeList.size()>0){
			totalCount = 1;
		}
		dto.setVersions(totalCount);
		return dto;
	}
	
	/**
	 * 删除知识
	 */
	public IGKGM03DTO deleteKnowLedgeAction(IGKGM03DTO dto) throws BLException {
			log.debug("========知识删除处理开始========");
			//循环删除
			String knids[] = dto.getIgkgm0202Form().getKnids();
			
			for( int i=0;i<knids.length;i++ ){
				//知识删除主键
				KnowledgeTBPK knowledgeTBPK = new KnowledgeTBPK();
				knowledgeTBPK.setKnid(Integer.valueOf(knids[i]));
				
				KnowledgeSearchCondImpl knowledgeSearchCond = new KnowledgeSearchCondImpl();
				knowledgeSearchCond.setKnid(Integer.valueOf(knids[i]));
				knowledgeSearchCond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE +","+IGKGMCONSTANTS.KNOWLEDGE_REJECT +","+IGKGMCONSTANTS.KNOWLEDGE_INIT);
				List<Knowledge> knowledgeList = this.knowledgeBL.searchKnowledgeByCond(knowledgeSearchCond, 0,0);
				if(null != knowledgeList && knowledgeList.size()>0){
					knowledgeTBPK.setKnversion(knowledgeList.get(0).getKnversion());
				}
				Knowledge knowledge = knowledgeBL.searchKnowledgeByPK(knowledgeTBPK);
				knowledgeBL.deleteKnowledge(knowledge);
			}
			dto.addMessage(new ActionMessage("IGCO10000.I006", "知识基本信息")); 
			log.debug("========知识删除处理终了========");
			return dto;
		}
	
//	/**
//	 * 修改处理多个附件
//	 * @param dto
//	 * @return
//	 * @throws BLException
//	 */
//	private String uploadFileUpdateAction(IGKGM03DTO dto) throws BLException {
//		IGKGM0216Form form = dto.getIgkgm0216Form();
//		AttachmentTB attachment = new AttachmentTB();
//		// 上传文件检测
//	    String  attkey = form.getKnattkey();
//		if (attkey==null ||attkey.equals("")) {
//			attkey = IGStringUtils.getAttKey();		
//		} 
//		attachment.setAttkey(attkey);
//		 
//		Map<Integer, FormFile> fileMap = form.getFileMap();
//		Set<Map.Entry<Integer,FormFile>> set = fileMap.entrySet();
//		for(Iterator<Map.Entry<Integer,FormFile>> iter = set.iterator();iter.hasNext();){
//				
//			Map.Entry<Integer,FormFile> entry = iter.next();
//			 FormFile file = entry.getValue();
//			 if (file != null && file.getFileSize() > 0) {
//				 // 上传文件存在的情况
//				 // 上传文件路径
//				 String rootPath = ResourceUtility
//				 .getString("UPLOAD_FILE_ROOT_PATH");
//				 StringBuffer pathBuf = new StringBuffer();
//				 // 根目录
//				 pathBuf.append(rootPath);
//				 // 机能ID
//				 pathBuf.append("kgm");
//				 pathBuf.append(File.separator);
//				 StringBuffer fileName = new StringBuffer();
//				 fileName.append(file.getFileName());
//				 // 文件上传处理
//				 try {
//					 this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
//							 + "_" + fileName.toString());
//				 } catch (FileNotFoundException e) {
//					 log.debug(e.getMessage());
//				 } catch (IOException e) {
//					 log.debug(e.getMessage());
//				 }
//				 // 上传文件名保存
//				 attachment.setAttname(attkey + "_" + fileName.toString());
//				 // 上传文件名URL
//				 attachment.setAtturl("kgm");
//				 this.attachmentBL.registAttachment(attachment);
//			 }
//		 }
//		return attkey;
//	}
	
	/**
	 * 修改处理多个附件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private String uploadFileAction(String attkey,Map<Integer, FormFile> fileMap) throws BLException {
		//IGKGM0201Form form = dto.getIgkgm0201Form();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测
	   // String  attkey = form.getKnattkey();
		if (attkey==null ||attkey.equals("")) {
			attkey = IGStringUtils.getAttKey();		
		} 
		attachment.setAttkey(attkey);
		 
		//Map<Integer, FormFile> fileMap = form.getFileMap();
		Set<Map.Entry<Integer,FormFile>> set = fileMap.entrySet();
		for(Iterator<Map.Entry<Integer,FormFile>> iter = set.iterator();iter.hasNext();){
				
			Map.Entry<Integer,FormFile> entry = iter.next();
			 FormFile file = entry.getValue();
			 if (file != null && file.getFileSize() > 0) {
				 // 上传文件存在的情况
				 // 上传文件路径
				 String rootPath = ResourceUtility
				 .getString("UPLOAD_FILE_ROOT_PATH");
				 StringBuffer pathBuf = new StringBuffer();
				 // 根目录
				 pathBuf.append(rootPath);
				 // 机能ID
				 pathBuf.append("kgm");
				 pathBuf.append(File.separator);
				 StringBuffer fileName = new StringBuffer();
				 fileName.append(file.getFileName());
				 // 文件上传处理
				 try {
					 this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
							 + "_" + fileName.toString());
				 } catch (FileNotFoundException e) {
					 log.debug(e.getMessage());
				 } catch (IOException e) {
					 log.debug(e.getMessage());
				 }
				 // 上传文件名保存
				 attachment.setAttname(attkey + "_" + fileName.toString());
				 // 上传文件名URL
				 attachment.setAtturl("kgm");
				 this.attachmentBL.registAttachment(attachment);
			 }
		 }
		return attkey;
	}

	/**
	 * 功能：查找关键字
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowledgeKeyAction(IGKGM03DTO dto,CodeDetailBL codeDetailBL) throws BLException
	{
		
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("KNOWLEDGE_KEYS").getCcid());
		cond.setCdstatus(String.valueOf(CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1));
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);//查所有的1级结点
		ArrayList<String> keys = new ArrayList<String>();
		CodeDetailSearchCondImpl cond2 = new CodeDetailSearchCondImpl();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			cond2.setSyscoding_q(syscoding);
			cond2.setCdstatus(String.valueOf(CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1));
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(cond2, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
			keys.add(detail.get(0).getCvalue());
		}
		dto.setKeysFromDB(keys);
		log.debug("========查询Special_CODE_TREE_By_CdStatus结束========");
		return dto;
	}
	

	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
	}

	/**
	 * 功能：知识关联业务系统List取得
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getKnowledgeAppImpact(IGKGM03DTO dto) throws BLException {
		KnowledgeAppImpactSearchCondImpl cond = new KnowledgeAppImpactSearchCondImpl();
		cond.setKnid(dto.getKnid());
		cond.setKnversion(dto.getKnversion());
		List<KnowledgeAppImpact> processAppImpactList = knowledgeAppImpactBL.findKnowledgeAppImpactByCond(cond, 0, 0);
		dto.setKnowledgeAppImpactList(processAppImpactList);
		return dto;
	}

	/**
	 * 功能：知识关联业务系统初始化取得
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getKnowledgeAppImpact_Disp(IGKGM03DTO dto)
			throws BLException {
		List<LabelValueBean> system_typeList = this.getSystem_typeList(dto).getSystem_typeList();
		List<KnowledgeAppImpact> knowledgeAppImpactList = this.getKnowledgeAppImpact(dto).getKnowledgeAppImpactList();
		Map<LabelValueBean,String> knowledgeAppImpactMap = new LinkedHashMap<LabelValueBean,String>();
		//初始化进行整理
		if(knowledgeAppImpactList!=null && knowledgeAppImpactList.size()>0){
			for(int i=0; i<system_typeList.size();i++){
				for(int j=0; j<knowledgeAppImpactList.size();j++){
					if(system_typeList.get(i).getValue().equals(knowledgeAppImpactList.get(j).getKaicode())){
						knowledgeAppImpactMap.put(system_typeList.get(i), "1");
						break;
					}else{
						knowledgeAppImpactMap.put(system_typeList.get(i), "0");
					}
				}
			}
		}else {
			for(int i=0; i<system_typeList.size();i++){
				knowledgeAppImpactMap.put(system_typeList.get(i), "0");
					
			}
		}
		dto.setKnowledgeAppImpactMap(knowledgeAppImpactMap);
		dto.setKnowledgeAppImpactList(knowledgeAppImpactList);
		return dto;
	}

	/**
	 * 功能：业务系统List取得
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getSystem_typeList(IGKGM03DTO dto) throws BLException {
		List<LabelValueBean> system_typeList = codeListUtils.getCodeList(CodeDefine.getCodeDefine("BUSINESS_SYSTEM_CODE").getCcid(), null, null, false, false);
		dto.setSystem_typeList(system_typeList);
		return dto;
	}

	/**
	 * 功能：根据流程id查找流程名称
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO searchProcessRecordByKey(IGKGM03DTO dto) throws BLException {
		IG500Info processRecord = ig500BL
		.searchIG500InfoByKey(Integer.valueOf(dto.getProcessID()));
		
		if(null != processRecord && null != processRecord.getPrtitle()){
			dto.setProcessName(processRecord.getPrtitle());
			
		}
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 查询知识审批人角色
	 * </p>
	 * @return IGKGM03DTO
	 * @author leexuzhi@deliverik.com
	 */
	public IGKGM03DTO getRoleKnApproveRole(IGKGM03DTO dto) throws BLException{
		log.debug("========查询知识审批人角色开始========");
			RoleSearchCondImpl cond = new RoleSearchCondImpl();
			cond.setRoletype(WorkFlowConstDefine.KNOW_APPROVER_ROLE);
			List<Role> roleList = roleBL.searchRole(cond);
			dto.setRoleList(roleList);
		log.debug("========查询知识审批人角色结束========");
		return dto;
	}
	
	/**
	 * 功能：知识下载
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO downKnowLedgeAction(IGKGM03DTO dto) throws BLException{
		log.debug("========知识下载开始========");
		KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
		cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);//审批通过
		//最后审批通过的知识信息
		List<KnowLedgeInfo> knList = knowLedgeInfoBL.searchKnowLedgeInfoByCond(cond, 0, 0);
		
		//生成HTML并打ZIP包
		try{
			ExportHtml.downHtmlsForKn(knList, dto.getSessionID());
		}catch(Exception e){
			log.error("知识打包异常：", e);
		}
		log.debug("========知识下载结束========");
		return dto;
	}
	
	/**
	 * 功能：知识批量导出
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO exportKnowLedgeAction(IGKGM03DTO dto) throws BLException{
		
		//获取form
		IGKGM0228Form form = dto.getIgkgm0228Form();
		
		//需要导出知识的ID数组
		String[] knids = form.getKnids();
		
		//需要导出知识的信息集合
		List<Knowledge> knowledgelist = new ArrayList<Knowledge>();
		
		if(knids != null && knids.length > 0){
			for(String knid : knids){
				//查询条件
				KnowledgeSearchCondImpl cond = new KnowledgeSearchCondImpl();
				cond.setKnid(Integer.parseInt(knid));
				cond.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);//审批通过
				//最后审批通过的知识信息
				Knowledge knowledge = knowledgeBL.searchKnowledgeByByKnid(cond);
				knowledgelist.add(knowledge);
			}
		}
		
		dto.setKnowledgelist(knowledgelist);
		
		return dto;
	}
	
	/**
	 * 功能：知识批量导出用业务系统查询
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public String searchKnowLedgeAppImpactAction(Integer knid, Integer knversion) throws BLException{
		
		// 获取业务系统集合
		KnowledgeAppImpactSearchCondImpl cond = new KnowledgeAppImpactSearchCondImpl();
		cond.setKnid(knid);
		cond.setKnversion(knversion);
		List<KnowledgeAppImpact> kalist = knowledgeAppImpactBL.findKnowledgeAppImpactByCond(cond, 0, 0);
		
		// 业务系统字符串
		StringBuffer knareaname = new StringBuffer();
		if(kalist != null && kalist.size() > 0){
			for(KnowledgeAppImpact ka : kalist){
				String str = ka.getKaicode();
				if(StringUtils.isNotEmpty(str) && str.contains("_")){
					knareaname.append(str.split("_")[1]).append(" ");
				}
			}
		}
		
		return knareaname.toString();
	}
	
	
	/**
	 * 转译特殊字符
	 * @param ystr
	 * @return
	 */
	public String getTurnString(String ystr){
		String newstr = null;
		
		if(ystr!=null){
			// 将字符转成byte码
			byte[] argms = ystr.getBytes();
			
			boolean single = true;
			boolean dou = true;
			
			// 转译后的byte码字符串
			List<String> linkedturn = new ArrayList<String>();
			
			// 
			for(int i=0;i<argms.length;i++){
				byte untr = argms[i];
				
				// 过滤换行符
				if(untr==new Byte(String.valueOf(13)) || untr==new Byte(String.valueOf(10))){
					
				}
				
				// 过滤单引号
				else if(untr==new Byte(String.valueOf(39))){
					if(single){
						linkedturn.add(String.valueOf(-95));
						linkedturn.add(String.valueOf(-82));
					}else{
						linkedturn.add(String.valueOf(-95));
						linkedturn.add(String.valueOf(-81));
					}
					single = !single;
					
				}
				
				//过滤双引号
				else if(untr==new Byte(String.valueOf(34))){
					if(dou){
						linkedturn.add(String.valueOf(-95));
						linkedturn.add(String.valueOf(-80));
					}else{
						linkedturn.add(String.valueOf(-95));
						linkedturn.add(String.valueOf(-79));
					}
					dou = !dou;
				}
				else{
					linkedturn.add(String.valueOf(untr));
				}
			}
			
			byte[] turnxo = new byte[linkedturn.size()];
			
			for(int i=0;i<linkedturn.size();i++){
				turnxo[i]=new Byte(linkedturn.get(i));
			}
			
			newstr = new String(turnxo);
		}
		try{
			String a1 = new String(newstr.getBytes("ISO8859-1"),"UTF-8");
			String a2 = new String(newstr.getBytes("GBK"),"UTF-8");
			String a3 = new String(newstr.getBytes("UTF-8"),"ISO8859-1");
			String a4 = new String(newstr.getBytes("GBK"),"ISO8859-1");
			String a5 = new String(newstr.getBytes("ISO8859-1"),"GBK");
			String a6 = new String(newstr.getBytes("UTF-8"),"GBK");
			log.debug("***************************************************");
			log.debug(a1+"===="+a2+"===="+a3+"===="+a4+"===="+a5+"===="+a6+"===="+newstr);
			System.out.println(a1+"===="+a2+"===="+a3+"===="+a4+"===="+a5+"===="+a6+"===="+newstr);
			log.debug("***************************************************");
		}catch(Exception e){
			
		}
		return newstr;
	}

	public IGKGM03DTO getKnowledgeCount(IGKGM03DTO dto) throws BLException {
		// TODO Auto-generated method stub
		dto.setCount(knowledgeBL.getSearchCount(dto.getKnowledgeSearchCond()));
		return dto;
	}

	public void setKnowLogBL(KnowLogBL knowLogBL) {
		this.knowLogBL = knowLogBL;
	}

	/**
	 * 知识管理(查询)
	 * @param dto
	 */
	public IGKGM02DTO searchProcessRecordLogAction(IGKGM02DTO dto)
			throws BLException {
		KnowLogSearchCond cond = dto.getKnowLogSearchCond();
		List<KnowLogInfo> recordLogList = knowLogBL.searchKnowLog(cond);
		dto.setRecordList(recordLogList);
		return dto;
	}
	
	/**
	 * 知识贡献数量统计(查询)
	 * @param dto
	 */
	public IGKGM02DTO searchStatisticalKnowledgeContribution(IGKGM02DTO dto)
			throws BLException {
		IGKGM0231Form form = dto.getIgkgm0231Form();
		KnowledgeStatisticsSearchCondImpl cond = new KnowledgeStatisticsSearchCondImpl();
		List<KnowledgeStatisticsInfo> ksList = this.knowledgeStatisticsBL.searchKnprofferStatistics(cond);
//		String svcXml = "<chart caption='知识贡献数量统计' subcaption='' palette='3' baseFontSize='12'"+
//				"bgcolor='#FFFFFF' xAxisName='数量' showValues='1' decimals='1' formatNumberScale='0' useRoundEdges='1'>";
		String svcXml = "<chart caption='' subcaption='' palette='3' baseFontSize='12' bgAngle='360'  startingAngle='70'"+
				"bgcolor='#FFFFFF' xAxisName='' showValues='1' decimals='1' formatNumberScale='0' useRoundEdges='1'>";
		for (KnowledgeStatisticsInfo ksInfo : ksList) {
			svcXml+= "<set label='"+ksInfo.getKnproffername()+"' value='"+ksInfo.getKlscount()+"' />";
		}
		svcXml+= "<styles>"+
				"<definition>"+
				"<style name='Anim1' type='animation' param='_xscale' start='0' duration='1' />"+
				"<style name='Anim2' type='animation' param='_alpha' start='0' duration='0.6' />"+
				"<style name='DataShadow' type='Shadow' alpha='40'/>"+
				"</definition>"+
				"<application>"+
				"<apply toObject='DIVLINES' styles='Anim1' />"+
				"<apply toObject='HGRID' styles='Anim2' />"+
				"<apply toObject='DATALABELS' styles='DataShadow,Anim2' />"+
				"</application>"+
				"</styles>"+
				"</chart>";
		form.setSvcxml(svcXml);
		return dto;
	}
	
	/**
	 * 查询业务系统分类
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM02DTO searchBusinessSystem(IGKGM02DTO dto) throws BLException{
		
		List<CodeDetailDef> list = new ArrayList<CodeDetailDef>();
		if(StringUtils.isNotEmpty(dto.getBusinessSystemSyscoding())){
			
			list = codeDetailDefBL.getFinalBusSys(dto.getBusinessSystemSyscoding());
			
		}else{
			//查询业务系统分类的所有一级分类
			CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
			cond.setPccid("101");
			cond.setPcid("0001");
			 list = codeDetailDefBL.searchCodeDetailDef(cond);
		}
		dto.setBusinessSystemList(list);
		return dto;
	}

}
