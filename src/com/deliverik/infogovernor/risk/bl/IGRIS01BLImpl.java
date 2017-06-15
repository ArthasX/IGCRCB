/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.risk.bl.task.AuditCheckRelationBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditDefBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditDefResultVWBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditInsBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditResultBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0102Form;
import com.deliverik.infogovernor.risk.form.IGRIS0104Form;
import com.deliverik.infogovernor.risk.form.IGRIS0105Form;
import com.deliverik.infogovernor.risk.form.IGRIS0110Form;
import com.deliverik.infogovernor.risk.form.IGRIS0112Form;
import com.deliverik.infogovernor.risk.form.IGRIS0113Form;
import com.deliverik.infogovernor.risk.form.IGRIS0114Form;
import com.deliverik.infogovernor.risk.form.IGRIS0115Form;
import com.deliverik.infogovernor.risk.form.IGRIS0117Form;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditDefTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditInsTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditResultTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditTB;

/**
 * 审计版本业务逻辑实现
 *
 */
public class IGRIS01BLImpl extends BaseBLImpl implements IGRIS01BL {

	static Log log = LogFactory.getLog(IGRIS01BLImpl.class);
	
	/** 审计版本信息BL */
	protected RiskAuditBL riskAuditBL;
	
	/** 审计发起信息BL */
	protected RiskAuditInsBL riskAuditInsBL;
	
	/** 审计项信息BL */
	protected RiskAuditDefBL riskAuditDefBL;
	
	/** 审计项和相关审计人外联视图信息BL */
	protected RiskAuditDefResultVWBL riskAuditDefResultVWBL;
	
	/** 审计评估信息BL */
	protected RiskAuditResultBL riskAuditResultBL;
	
	/** 审计风险检查关系信息BL */
	protected AuditCheckRelationBL auditCheckRelationBL;
	
	/** 风险检查信息BL */
	protected RiskCheckBL riskCheckBL;
	
	/** 风险检查结果信息BL */
	protected RiskCheckResultBL riskCheckResultBL;
	
	/** 基础数据BL */
	protected CodeDetailBL codeDetailBL;
	
	protected AttachmentBL attachmentBL;
	
	protected IGRIS02BL igris02BL;
	
	
	public void setIgris02BL(IGRIS02BL igris02BL) {
		this.igris02BL = igris02BL;
	}

	/**
	 * @param attachmentTBDAO the attachmentTBDAO to set
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * 风险检查结果信息BL设定
	 * 
	 * @param riskCheckBL
	 */

	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}
	
	/**
	 * 风险检查信息BL设定
	 * 
	 * @param riskCheckBL
	 */

	public void setRiskCheckBL(RiskCheckBL riskCheckBL) {
		this.riskCheckBL = riskCheckBL;
	}
	
	
	/**
	 * 审计风险检查关系信息BL设定
	 * 
	 * @param auditCheckRelationBL
	 */

	public void setAuditCheckRelationBL(AuditCheckRelationBL auditCheckRelationBL) {
		this.auditCheckRelationBL = auditCheckRelationBL;
	}
	
	/**
	 * 审计项信息BL设定
	 * 
	 * @param riskAuditDefBL
	 */

	public void setRiskAuditDefBL(RiskAuditDefBL riskAuditDefBL) {
		this.riskAuditDefBL = riskAuditDefBL;
	}

	/**
	 * 审计版本信息BL设定
	 * 
	 * @param riskAuditBL
	 */
	public void setRiskAuditBL(RiskAuditBL riskAuditBL) {
		this.riskAuditBL = riskAuditBL;
	}
	
	/**
	 * 审计发起信息BL设定
	 * 
	 * @param riskAuditInsBL
	 */
	public void setRiskAuditInsBL(RiskAuditInsBL riskAuditInsBL) {
		this.riskAuditInsBL = riskAuditInsBL;
	}
	
	/**
	 * 审计结果信息BL设定
	 * 
	 * @param riskAuditResultBL
	 */
	public void setRiskAuditResultBL(RiskAuditResultBL riskAuditResultBL) {
		this.riskAuditResultBL = riskAuditResultBL;
	}

	/**
	 * 审计项和相关审计人外联视图信息BL设定
	 * 
	 * @param riskAuditDefResultVWBL
	 */
	public void setRiskAuditDefResultVWBL(
			RiskAuditDefResultVWBL riskAuditDefResultVWBL) {
		this.riskAuditDefResultVWBL = riskAuditDefResultVWBL;
	}
	
	/**
	 * 基础数据BL设定
	 * 
	 * @param codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	
	//-----------------------------------------------------------审计版本----------------------------------------------------------------------
	


	/**
	 * 审计版本信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========审计版本信息查询处理开始========");
		
		//审计版本信息查询件数取得 
		int totalCount = this.riskAuditBL.getSearchCount(dto.getRiskAuditSearchCond());
		
		if (totalCount == 0) {
			log.debug("========审计版本信息查询数据不存在========");
			//审计版本信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========审计版本信息查询数据件数过多========");
			//审计版本信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页审计版本信息取得
		List<RiskAudit> riskAuditList = this.riskAuditBL.searchRiskAudit(dto.getRiskAuditSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setRiskAuditList(riskAuditList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========审计版本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 审计版本信息登记处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO insertRiskAuditAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========审计版本信息登记处理开始========");
		
		IGRIS0102Form form = dto.getIgRIS0102Form();
		
		form.setRadate(IGStringUtils.getCurrentDate());
		
		if(dto.getUser() == null) {
			throw new BLException("IGCO10000.E004","登陆用户基本");
		}
		form.setRauserid(dto.getUser().getUserid());
		
		form.setRausername(dto.getUser().getUsername());
		
		form.setRastatus(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE);
		
		String maxRootID = this.riskAuditBL.getMaxRacode();
		
		if(StringUtils.isEmpty(maxRootID)) {
			form.setRacode(IGRISCONSTANTS.RISKAUDIT_ROOT_MIN_ID);
		} else {
			Integer rootID = new Integer(maxRootID);
			if(IGRISCONSTANTS.RISKAUDIT_ROOT_MAX_ID.equals(rootID.toString())) {
				throw new BLException("IGRIS0102.E002");
			} else {
				form.setRacode(StringUtils.leftPad(String.valueOf(rootID + 1),IGRISCONSTANTS.RISKAUDIT_ROOT_LENGTH,IGRISCONSTANTS.RISKAUDIT_ROOT_LEFT_PAD));
			}
		}
		
		//审计版本信息登记处理
		this.riskAuditBL.registRiskAudit(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "审计版本基本信息") );
		
		log.debug("========审计版本信息登记处理终了========");
		return dto;
	}
	
	/**
	 * 审计版本信息停用/启用处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditAction(IGRIS01DTO dto) throws BLException {
		log.debug("========审计版本信息停用/启用处理开始========");
		IGRIS0102Form form = dto.getIgRIS0102Form();
		
		RiskAudit ra = this.riskAuditBL.searchRiskAuditByKey(form.getRaid());
		
		//复制对象
		RiskAuditTB pdTB = (RiskAuditTB)SerializationUtils.clone(ra);
		
		if(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE.equals(form.getRastatus())) {
			pdTB.setRastatus(IGRISCONSTANTS.RISKAUDIT_STATUS_DISABLE);//停用
			log.debug("========停用========");
			dto.addMessage(new ActionMessage( "IGCO10000.I008", "审计版本") );
		} else if(IGRISCONSTANTS.RISKAUDIT_STATUS_DISABLE.equals(form.getRastatus())) {
			pdTB.setRastatus(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE);//启用
			log.debug("========启用========");
			dto.addMessage(new ActionMessage( "IGCO10000.I009", "审计版本") );
		}
		this.riskAuditBL.updateRiskAudit(pdTB);
		log.debug("========审计版本信息停用/启用处理终了========");
		return dto;
	}
	
	//-----------------------------------------------------------审计项----------------------------------------------------------------------

	/**
	 * <p>
	 * Description: 审计项新增
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO insertRiskAuditDefAction(IGRIS01DTO dto) throws BLException {
		log.debug("========审计项新增处理开始========");
		//取得当前所选上级审计项的下级审计项的最后的code,将其加1作为新增审计项的code
		IGRIS0105Form form = dto.getIgRIS0105Form();
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRadparcode_q(form.getRadparcode());
		List<RiskAuditDef> riskAuditDeflist = riskAuditDefBL.searchRiskAuditDef(cond,0,0);//查该结点的下级审计项树
		String syscode = "";	
		String auditnum = ResourceUtility.getString("AUDIT_NUM");//审计项编码的层次数
		if(auditnum == null || "".equals(auditnum)){
			auditnum = "6";
		}
		int auditnumInt = Integer.valueOf(auditnum);
		int audit_code_len = 19;//审计项编码的默认长度
		if(auditnumInt>1 && auditnumInt<10){
			audit_code_len = 4+3*(auditnumInt-1);
		}
		if(riskAuditDeflist.size()>0){//存在下级审计项
			int size = riskAuditDeflist.size()-1;
			RiskAuditDef riskAuditDef = riskAuditDeflist.get(size);
			syscode = riskAuditDef.getRadcode();
			String temp = syscode.substring(syscode.length()-3);
			
			if(temp.substring(temp.length()-3).equals(IGRISCONSTANTS.RISKAUDITDEF_ROOT_MAX_ID)){
				throw new BLException("IGRIS0105.E004","审计项基本信息");
			}
			
			if("0".equals(temp.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(temp)+1);
				if(tmp.length()==1){
					temp = "00"+tmp;
				}else if(tmp.length()==2){
					temp = "0"+tmp;
				}else{
					temp = tmp;
				}
				syscode = syscode.substring(0,syscode.length()-3)+temp;
			}else{//***
				syscode = syscode.substring(0,syscode.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
			}
			form.setRadcode(syscode);
		}else{
			syscode = form.getRadparcode();		
			//判断是否已经达到规定的层次数
			if(syscode!=null && syscode.length()>=audit_code_len){
				throw new BLException("IGRIS0105.E005","审计项基本信息");
			}
			form.setRadcode(syscode+"001");
		}
		int radlevel = form.getRadcode().length()-7;
		if (radlevel == 0) {
			form.setRadlevel("1");
		}else{
			int level = radlevel/3+1;
			form.setRadlevel(level+"");
		}
		form.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		this.riskAuditDefBL.registRiskAuditDef(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "审计项基本信息") );
		log.debug("========审计项新增处理终了========");
		return dto;
	}
	
	/**
	 * 审计项信息停用/启用处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditDefAction(IGRIS01DTO dto) throws BLException {
		log.debug("========审计项信息停用/启用处理开始========");
		IGRIS0104Form form = dto.getIgRIS0104Form();
		
		RiskAuditDef riskAuditDef = this.riskAuditDefBL.searchRiskAuditDefByKey(form.getRadid());
		
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRadparcode_q(riskAuditDef.getRadcode());
		cond.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);
		if (riskAuditDefList.size()==0) {
			//复制对象
			RiskAuditDefTB riskAuditDefTB = (RiskAuditDefTB)SerializationUtils.clone(riskAuditDef);
			
			if(IGRISCONSTANTS.RISKAUDITDEF_STATUS_DISABLE.equals(form.getRadstatus())) {
				riskAuditDefTB.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);//启用
				log.debug("========停用========");
				dto.addMessage(new ActionMessage( "IGCO10000.I009", "审计项") );
			} else if(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE.equals(form.getRadstatus())) {
				riskAuditDefTB.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_DISABLE);//停用
				log.debug("========启用========");
				dto.addMessage(new ActionMessage( "IGCO10000.I008", "审计项") );
			}
			this.riskAuditDefBL.updateRiskAuditDef(riskAuditDefTB);
		}else{
			dto.addMessage(new ActionMessage( "IGRIS0105.E003" ,""));
		}
		log.debug("========审计项信息停用/启用处理终了========");
		return dto;
	}
	
	/**
	 * 审计项详细信息查看处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initIGRIS0108Action(IGRIS01DTO dto) throws BLException {
		log.debug("========审计项详细信息处理开始========");
		IGRIS0104Form form = dto.getIgRIS0104Form();
		
		RiskAuditDef riskAuditDef = this.riskAuditDefBL.searchRiskAuditDefByKey(form.getRadid());
		
		dto.setRiskAuditDef(riskAuditDef);
		log.debug("========审计项详细信息处理终了========");
		return dto;
	}
	/**
	 * 审计项详细信息修改初始化处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initRiskAuditDefAction(IGRIS01DTO dto) throws BLException{
		log.debug("========审计项信息修改初始化处理开始========");
		IGRIS0105Form form = dto.getIgRIS0105Form();
		
		RiskAuditDef riskAuditDef = this.riskAuditDefBL.searchRiskAuditDefByKey(form.getRadid());
		
		if (riskAuditDef.getRadparcode().length() == 4) {
			form.setRadparname(riskAuditDef.getRaversion());
			
		}else{			
			RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
			cond.setRadcode_q(riskAuditDef.getRadparcode());
			List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);
			for (RiskAuditDef riskAudit : riskAuditDefList) {
				form.setRadparname(riskAudit.getRadname());
			}
		}
		
		form.setMode("1");
		form.setRaversion(riskAuditDef.getRaversion());
		form.setRaddesc(riskAuditDef.getRaddesc());
		form.setRadfrequency(riskAuditDef.getRadfrequency());
		form.setRadlevel(riskAuditDef.getRadlevel());
		form.setRadname(riskAuditDef.getRadname());
		form.setRadorg(riskAuditDef.getRadorg());
		form.setRadorgcoding(riskAuditDef.getRadorgcoding());
		form.setRadparcode(riskAuditDef.getRadparcode());
		form.setRadrisklevel(riskAuditDef.getRadrisklevel());
		form.setRadstatus(riskAuditDef.getRadstatus());
		form.setRadtype(riskAuditDef.getRadtype());
		form.setRaduserid(riskAuditDef.getRaduserid());
		form.setRadusername(riskAuditDef.getRadusername());
		form.setRadmode(riskAuditDef.getRadmode());
		form.setRaid(riskAuditDef.getRaid());
		form.setRadcode(riskAuditDef.getRadcode());
		
		dto.setIgRIS0105Form(form);
	
		log.debug("========审计项详细信息修改初始化处理终了========");
		
		return dto;
		
	}
	
	/**
	 * 审计项详细信息修改处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO editRiskAuditDefAction(IGRIS01DTO dto) throws BLException {
		log.debug("========审计项详细信息处理开始========");
		IGRIS0105Form form = dto.getIgRIS0105Form();
		this.riskAuditDefBL.updateRiskAuditDef(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005","审计项基本信息"));
		log.debug("========审计项详细信息处理终了========");
		return dto;
	}
	/**
	 * 审计项信息全部下级查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefAllAction(IGRIS01DTO dto) throws BLException{
		
		log.debug("========审计项信息查询处理开始========");
		
		IGRIS0104Form form = dto.getIgRIS0104Form();
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRaid(form.getRaid());
		cond.setRadparcode(form.getRadparcode_q());
		//审计项信息查询件数取得 
		int totalCount = this.riskAuditDefBL.getSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========审计项信息查询数据不存在========");
			//审计项信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========审计项信息查询数据件数过多========");
			//审计项信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页审计项信息取得
		List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setRiskAuditDefList(riskAuditDefList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========审计项信息查询处理终了========");
		return dto;
	}
	/**
	 * 审计项信息下一级查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefNextAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========审计项信息查询处理开始========");
		
		//审计项信息查询件数取得 
		IGRIS0104Form form = dto.getIgRIS0104Form();
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRaid(form.getRaid());
		cond.setRadparcode_q(form.getRadparcode_q());
		int totalCount = this.riskAuditDefBL.getSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========审计项信息查询数据不存在========");
			//审计项信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========审计项信息查询数据件数过多========");
			//审计项信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		//当前页审计项信息取得
		List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setRiskAuditDefList(riskAuditDefList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========审计项信息查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询存在的上级审计项（一级审计项）
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 */
	
	public IGRIS01DTO searchAuditTreeAction(IGRIS01DTO dto) throws BLException{
		log.debug("========一级审计项查询处理开始========");
		
		IGRIS0104Form form = dto.getIgRIS0104Form();
		RiskAudit riskAudit = this.riskAuditBL.searchRiskAuditByKey(form.getRaid());
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		if (riskAudit == null) {
			return dto;
		}
			
		TreeNode pNode = new TreeNode();
		pNode.setId(riskAudit.getRacode());
		pNode.setName(riskAudit.getRaversion());
		
		RiskAuditDefSearchCondImpl cond1 = new RiskAuditDefSearchCondImpl();
		cond1.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		cond1.setRadparcode_q(riskAudit.getRacode());
		List<RiskAuditDef> riskAuditDeflist = riskAuditDefBL.searchRiskAuditDef(cond1,0,0);//查该结点的下级审计项树
		for (RiskAuditDef riskAuditDef : riskAuditDeflist) {				
			
			//设置当前结点的完整树(从该级结点向下)			
			RiskAuditDefSearchCondImpl cond2 = new RiskAuditDefSearchCondImpl();
			cond2.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
			cond2.setRadcode(riskAuditDef.getRadcode());
			List<RiskAuditDef> riskAuditDeflist1 = riskAuditDefBL.searchRiskAuditDef(cond2,0,0);//查该结点的下级审计项树

			TreeNode ptNode = new TreeNode();
			ptNode.setId(riskAuditDeflist1.get(0).getRadcode());
			ptNode.setName(riskAuditDeflist1.get(0).getRadname());
			//添加孩子结点
			int nowlen = riskAuditDeflist1.get(0).getRadcode().length();
			getChildTreeNodeMap(riskAuditDeflist1,ptNode,nowlen,riskAuditDef.getRadcode());
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
	
		}
		
		treeNodeMap.put(pNode.getId(),pNode);		
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========一级审计项查询处理结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的code的长度
	 * @author maozhipeng@deliverik.com
	 */
	private void getChildTreeNodeMap(List<RiskAuditDef> ret,TreeNode ptNode,int ptlen,String radcode){

		List<RiskAuditDef> nextret = getNextLevelNodes(ret,ptlen,radcode);//取得该级结点的LIST

		for(int i=0,j=nextret.size();i<j;i++){
			String code = nextret.get(i).getRadcode();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextret.get(i).getRadcode());
			pdNode.setName(nextret.get(i).getRadname());
				
			getChildTreeNodeMap(ret,pdNode,code.length(),code);
			
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}

	}
	
	/**
	 * <p>
	 * 取下一level的结点集合
	 * </p>
	 * @param 全部的结点LIST
	 * @param 当前结点的len
	 * @param 当前结点的radcode
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 */
	
	private List<RiskAuditDef> getNextLevelNodes(List<RiskAuditDef> ret,int levellen,String radcode) {
		
		List<RiskAuditDef> riskAuditDef = new ArrayList<RiskAuditDef>();
		for(int i=0,j=ret.size();i<j;i++){
			String code = ret.get(i).getRadcode();
			if(code.length()==(levellen+3) && (code.substring(0,code.length()-3)).equals(radcode)){
				riskAuditDef.add(ret.get(i));
			}
			
		}		
		return riskAuditDef;
	}
	
	//-----------------------------------------------------------审计评估----------------------------------------------------------------------
	/**
	 * 审计评估信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditResultAction(IGRIS01DTO dto) throws BLException{
		
		log.debug("========审计评估信息查询处理开始========");
		
		IGRIS0113Form form = dto.getIgRIS0113Form();
		//构造查询条件，当前用户的可以评估的审计项
		RiskAuditResultSearchCondImpl cond = new RiskAuditResultSearchCondImpl();
		cond.setRaruserid(form.getRaruserid());
		cond.setRaiid(form.getRaiid());
		List<RiskAuditResult> riskAuditResultList = this.riskAuditResultBL.searchRiskAuditResult(cond, 0, 0);
		
		for(Iterator<RiskAuditResult> iter = riskAuditResultList.iterator(); iter.hasNext();) {
			RiskAuditResult riskAuditResult = iter.next();
			RiskAuditInsSearchCondImpl cond1 = new RiskAuditInsSearchCondImpl();
			cond1.setRaistatus(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE);
			cond1.setRaiid(riskAuditResult.getRaiid());
			List<RiskAuditIns> riskAuditInsList = this.riskAuditInsBL.searchRiskAuditIns(cond1, 0, 0);
			if (riskAuditInsList.size() == 0) {
				iter.remove();
			}
		}
		List<String> list = new ArrayList<String>();
		Boolean flag = true;
		for (RiskAuditResult riskAuditResult: riskAuditResultList) {
			flag = true;
			String radcode = riskAuditResult.getRiskAuditDefTB().getRadcode();
			for (RiskAuditResult rar: riskAuditResultList) {
				String temp = rar.getRiskAuditDefTB().getRadcode();
				if(radcode.contains(temp) && !radcode.equals(temp)){
					if(radcode.length()>temp.length()){
						if(radcode.substring(0, temp.length()).equals(temp)){
							flag = false;
							break;
						}
					}else{
						if(temp.substring(0, radcode.length()).equals(radcode)){
							flag = false;
							break;
						}
					}
					
				}
			}
			if(flag){
				list.add(radcode);
			}		
		}
		
		List<RiskAuditResult> rdrList = new ArrayList<RiskAuditResult>();
		for (String str : list) {	
			RiskAuditResultSearchCondImpl cond1 = new RiskAuditResultSearchCondImpl();
			cond1.setRaiid(form.getRaiid());
			cond1.setRadcode(str);
			List<RiskAuditResult> rad = this.riskAuditResultBL.searchRiskAuditResult(cond1, 0, 0);
			for (RiskAuditResult riskAuditResult : rad) {
				rdrList.add(riskAuditResult);
			}
		}
		dto.setRiskAuditResultList(rdrList);
		
		log.debug("========审计评估信息查询处理终了========");
		return dto;
	}
	/**
	 * <p>
	 * Description: 审计评估初始化
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO initRiskAuditResultAction(IGRIS01DTO dto) throws BLException{
		IGRIS0114Form form = dto.getIgRIS0114Form();
		RiskAuditResult riskAuditResult = this.riskAuditResultBL.searchRiskAuditResultByKey(form.getRarid());
		form.setRadid(riskAuditResult.getRadid());
		form.setRaiid(riskAuditResult.getRaiid());
		form.setRarid(riskAuditResult.getRarid());
		form.setRaruserid(riskAuditResult.getRaruserid());
		form.setRarusername(riskAuditResult.getRarusername());
		form.setRardate(riskAuditResult.getRardate());
		form.setRarexecdesc(riskAuditResult.getRarexecdesc());
		form.setRarexecscore(riskAuditResult.getRarexecscore());
		form.setRaroveralldesc(riskAuditResult.getRaroveralldesc());
		form.setRaroverallscore(riskAuditResult.getRaroverallscore());
		form.setRarplandesc(riskAuditResult.getRarplandesc());
		form.setRarplanscore(riskAuditResult.getRarplanscore());
		form.setRadcode(riskAuditResult.getRadcode());
		dto.setIgRIS0114Form(form);
		return dto;
	}
	/**
	 * <p>
	 * Description: 审计评估新增
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO updateRiskAuditResultAction(IGRIS01DTO dto) throws BLException{
		
		IGRIS0114Form form = dto.getIgRIS0114Form();
		String date = IGStringUtils.getCurrentDate();
		form.setRardate(date);
		form.setRaruserid(dto.getUser().getUserid());
		form.setRarusername(dto.getUser().getUsername());
		this.riskAuditResultBL.updateRiskAuditResult(form);
		dto.addMessage(new ActionMessage( "IGRIS0114.I001", "审计评估") );
		return dto;
	}
	
	/**
	 * 获取已启用的审计批次号下拉列表
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditInsLabelInUse(IGRIS01DTO dto) throws BLException {
		log.debug("========获取已启用的审计批次号下拉列表处理开始========");
		
		List<LabelValueBean> labelList = this.riskAuditInsBL.searchRiskAuditInsLabelInUse();
		
		dto.setLabelList(labelList);
		
		log.debug("========获取已启用的审计批次号下拉列表处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 风险检查查询
	 * </p>
	 */
	
	public IGRIS01DTO searchRiskCheckAction(IGRIS01DTO dto) throws BLException {
		IGRIS0115Form form = dto.getIgRIS0115Form();
		AuditCheckRelationSearchCondImpl cond = new AuditCheckRelationSearchCondImpl();
		cond.setRadid(form.getRadid());
		List<AuditCheckRelation> auditCheckRelationList = this.auditCheckRelationBL.searchAuditCheckRelation(cond, 0, 0);
		List<RiskCheck> riskCheckList = new ArrayList<RiskCheck>();
		for (AuditCheckRelation auditCheckRelation : auditCheckRelationList) {
			RiskCheck riskCheck = this.riskCheckBL.searchRiskCheckByKey(auditCheckRelation.getRcid());
			riskCheckList.add(riskCheck);
		}
		dto.setRiskCheckList(riskCheckList);
		return dto;
	}
	/**
	 * <p>
	 * Description: 风险检查查看页
	 * </p>
	 */
	
	public IGRIS01DTO initRiskCheckAction(IGRIS01DTO dto) throws BLException {
		log.debug("========风险检查查看处理开始========");
		IGRIS0115Form form = dto.getIgRIS0115Form();
		RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
		dto.setRiskCheck(rc);
		
		//解释风险检查策略的表达式
		String cronInfo = this.igris02BL.getCronInfo(rc.getRcfrequency(),rc.getRcstartdate());
		dto.setCronInfo(cronInfo);
		
		//查询附件信息
		List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(rc.getRcattch());
		dto.setAttachmentList(attachmentList);
		
		log.debug("========风险检查查看处理终了========");
		return dto;
	}
	/**
	 * <p>
	 * Description: 风险检查结果查询
	 * </p>
	 */
	
	public IGRIS01DTO searchRiskCheckResultAction(IGRIS01DTO dto) throws BLException {
		IGRIS0115Form form = dto.getIgRIS0115Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRcid(form.getRcid());
		List<RiskCheckResult> riskCheckResultList = this.riskCheckResultBL.searchRiskCheckResult(cond, 0, 0);
		Map<RiskCheckResult, List<Attachment>> attachmentMap = new HashMap<RiskCheckResult, List<Attachment>>();
		for (RiskCheckResult riskCheckResult : riskCheckResultList) {		
			//查询附件信息
			if (StringUtils.isNotEmpty(riskCheckResult.getRcrattch())) {
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(riskCheckResult.getRcrattch());
				attachmentMap.put(riskCheckResult, attachmentList);			
			}else{
				attachmentMap.put(riskCheckResult, new ArrayList<Attachment>());	
			}
		}
		dto.setAttachmentMap(attachmentMap);
		return dto;
	}
	//-----------------------------------------------------------审计发起----------------------------------------------------------------------
	
	/**
	 * 审计发起信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditInsAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========审计发起信息查询处理开始========");
		
		//审计发起信息查询件数取得 
		int totalCount = this.riskAuditInsBL.getSearchCount(dto.getRiskAuditInsSearchCond());
		
		if (totalCount == 0) {
			log.debug("========审计发起信息查询数据不存在========");
			//审计发起信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========审计发起信息查询数据件数过多========");
			//审计发起信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页审计发起信息取得
		List<RiskAuditIns> riskAuditInsList = this.riskAuditInsBL.searchRiskAuditIns(dto.getRiskAuditInsSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setRiskAuditInsList(riskAuditInsList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========审计发起信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 审计发起信息登记处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO insertRiskAuditInsAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========审计发起信息登记处理开始========");
		
		IGRIS0110Form form = dto.getIgRIS0110Form();
		
		form.setRaistatus(IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE);
		
		//审计发起信息登记处理
		RiskAuditIns rai = this.riskAuditInsBL.registRiskAuditIns(form);
		
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		
		cond.setRaid(form.getRaid());
		
		List<RiskAuditDef> radList = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);
		
		for(RiskAuditDef rad : radList) {
			RiskAuditResultTB rarTB = new RiskAuditResultTB();
			rarTB.setRadid(rad.getRadid());
			rarTB.setRadcode(rad.getRadcode());
			rarTB.setRaiid(rai.getRaiid());
			this.riskAuditResultBL.registRiskAuditResult(rarTB);
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "审计发起基本信息") );
		
		log.debug("========审计发起信息登记处理终了========");
		return dto;
	}
	
	/**
	 * 审计发起信息关闭/启用处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditInsAction(IGRIS01DTO dto) throws BLException {
		log.debug("========审计发起信息关闭/启用处理开始========");
		IGRIS0110Form form = dto.getIgRIS0110Form();
		
		RiskAuditIns rai = this.riskAuditInsBL.searchRiskAuditInsByKey(form.getRaiid());
		
		//复制对象
		RiskAuditInsTB pdTB = (RiskAuditInsTB)SerializationUtils.clone(rai);
		
		if(IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE.equals(form.getRaistatus())) {
			pdTB.setRaistatus(IGRISCONSTANTS.RISKAUDITINS_STATUS_DISABLE);//关闭
			log.debug("========关闭========");
			dto.addMessage(new ActionMessage( "IGRIS0109.I001") );
		} else if(IGRISCONSTANTS.RISKAUDITINS_STATUS_DISABLE.equals(form.getRaistatus())) {
			pdTB.setRaistatus(IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE);//启用
			log.debug("========启用========");
			dto.addMessage(new ActionMessage( "IGCO10000.I009", "审计发起") );
		}
		this.riskAuditInsBL.updateRiskAuditIns(pdTB);
		log.debug("========审计发起信息关闭/启用处理终了========");
		return dto;
	}
	
	/**
	 * 审计发起信息变更处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO updateRiskAuditInsAction(IGRIS01DTO dto) throws BLException {

		log.debug("========审计发起信息变更处理开始========");
		IGRIS0110Form form = dto.getIgRIS0110Form();
		
		RiskAuditIns rai = this.riskAuditInsBL.searchRiskAuditInsByKey(form.getRaiid());
		
		//复制对象
		RiskAuditInsTB raiTB = (RiskAuditInsTB)SerializationUtils.clone(rai);
		
		raiTB.setRaistart(form.getRaistart());
		
		raiTB.setRaiend(form.getRaiend());
		
		raiTB.setRaidesc(form.getRaidesc());
		
		//审计发起信息变更处理
		this.riskAuditInsBL.updateRiskAuditIns(raiTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "审计发起基本信息") );

		log.debug("========审计发起信息变更处理终了========");
		return dto;
	}
	
	/**
	 * 审计发起信息变更初始化处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initIGRIS0110Action(IGRIS01DTO dto) throws BLException {
		log.debug("========审计发起信息变更初始化处理开始========");
		
		IGRIS0110Form form = dto.getIgRIS0110Form();
		
		RiskAuditIns rai = this.riskAuditInsBL.searchRiskAuditInsByKey(form.getRaiid());
		
		form.setRaicode(rai.getRaicode());
		
		form.setRaistart(rai.getRaistart());
		
		form.setRaiend(rai.getRaiend());
		
		form.setRaidesc(rai.getRaidesc());
		
		form.setRaversion(rai.getRaversion());
		
		form.setMode("1");
		
		log.debug("========审计发起信息变更初始化处理终了========");
		return dto;
	}
	
	/**
	 * 获取已启用的审计版本号下拉列表
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditLabelInUse(IGRIS01DTO dto) throws BLException {
		log.debug("========获取已启用的审计版本号下拉列表处理开始========");
		List<LabelValueBean> labelList = this.riskAuditBL.searchRiskAuditLabelInUse();
		
		dto.setLabelList(labelList);
		
		log.debug("========获取已启用的审计版本号下拉列表处理终了========");
		return dto;
	}
	
	//-----------------------------------------------------------审计人----------------------------------------------------------------------
	
	/**
	 * 审计人信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefResultVWAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========审计人信息查询处理开始========");
		
		IGRIS0112Form form = dto.getIgRIS0112Form();
		
		form.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		
		//当前页审计人信息取得
		List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList = this.riskAuditDefResultVWBL.searchRiskAuditDefResultVW(form, 0, 0);
		
		if(riskAuditDefResultVWInfoList.isEmpty()) {
			dto.addMessage(new ActionMessage( "IGCO10000.E004", "审计项基本") );
		} else {
			String radMaxLevel = this.riskAuditDefResultVWBL.getMaxRadlevel(form);
			if(StringUtils.isNotEmpty(radMaxLevel)) {
				dto.setRadMaxLevel(Integer.parseInt(radMaxLevel));
				List<Integer> list = new ArrayList<Integer>();
				for(int i = 1; i <= Integer.parseInt(radMaxLevel); i++) {
					list.add(i);
				}
				dto.setRadMaxLevelList(list);
			}
		}
		
		String[] rarusername = new String[riskAuditDefResultVWInfoList.size()];
		
		int i = 0;
		
		for(RiskAuditDefResultVWInfo radrVWInfo : riskAuditDefResultVWInfoList) {
			rarusername[i++] = radrVWInfo.getRarusername();
		}
		
		form.setRarusername(rarusername);
		
		dto.setRiskAuditDefResultVWInfoList(riskAuditDefResultVWInfoList);
		
		log.debug("========审计人信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 审计人信息保存处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO saveRiskAuditResultAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========审计人信息保存处理开始========");
		
		IGRIS0112Form form = dto.getIgRIS0112Form();
		
		if (form.getRadid() != null && form.getRadid().length > 0 ) {
			for( int i = 0 ; i < form.getRadid().length; i++ ) {
				RiskAuditResultTB rarTB = new RiskAuditResultTB();
				if (StringUtils.isEmpty(form.getRarid()[i])) {
					if(StringUtils.isNotEmpty(form.getRaruserid()[i])) {
						rarTB.setRadid(Integer.parseInt(form.getRadid()[i]));
						rarTB.setRaiid(form.getRaiid());
						rarTB.setRaruserid(form.getRaruserid()[i]);
						rarTB.setRarusername(form.getRarusername()[i]);
						this.riskAuditResultBL.registRiskAuditResult(rarTB);
					}
				} else {
					RiskAuditResult rar = this.riskAuditResultBL.searchRiskAuditResultByKey(Integer.parseInt(form.getRarid()[i]));
					if(StringUtils.isEmpty(form.getRaruserid()[i]) && StringUtils.isNotEmpty(rar.getRaruserid())) {
						rarTB = (RiskAuditResultTB)SerializationUtils.clone(rar);
						rarTB.setRaruserid(null);
						rarTB.setRarusername(null);
						this.riskAuditResultBL.updateRiskAuditResult(rarTB);
					} else if(StringUtils.isNotEmpty(form.getRaruserid()[i]) && StringUtils.isNotEmpty(rar.getRaruserid())) {
						if(!form.getRaruserid()[i].equals(rar.getRaruserid())) {
							rarTB = (RiskAuditResultTB)SerializationUtils.clone(rar);
							rarTB.setRaruserid(form.getRaruserid()[i]);
							rarTB.setRarusername(form.getRarusername()[i]);
							this.riskAuditResultBL.updateRiskAuditResult(rarTB);
						}
					}else if(StringUtils.isNotEmpty(form.getRaruserid()[i]) && StringUtils.isEmpty(rar.getRaruserid())) {
						rarTB = (RiskAuditResultTB)SerializationUtils.clone(rar);
						rarTB.setRaruserid(form.getRaruserid()[i]);
						rarTB.setRarusername(form.getRarusername()[i]);
						this.riskAuditResultBL.updateRiskAuditResult(rarTB);
					}
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGRIS0112.I001") );
		
		log.debug("========审计人信息保存处理终了========");
		return dto;
	}
	
//-----------------------------------------------------------审计报告----------------------------------------------------------------------
	
	/**
	 * 审计报告信息查询处理
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditReportAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========审计报告信息查询处理开始========");
		
		IGRIS0117Form form = dto.getIgRIS0117Form();
		
		form.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		
		dto.setRiskAuditIns(this.riskAuditInsBL.searchRiskAuditInsByKey(form.getRaiid()));
		
		//当前页审计报告信息取得
		List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList = this.riskAuditDefResultVWBL.searchRiskAuditDefResultVW(form, 0, 0);
		
		if(riskAuditDefResultVWInfoList.isEmpty()) {
			dto.addMessage(new ActionMessage( "IGCO10000.E004", "审计项基本信息") );
		} else {
			String radMaxLevel = this.riskAuditDefResultVWBL.getMaxRadlevel(form);
			if(StringUtils.isNotEmpty(radMaxLevel)) {
				dto.setRadMaxLevel(Integer.parseInt(radMaxLevel));
				List<Integer> list = new ArrayList<Integer>();
				for(int i = 1; i <= Integer.parseInt(radMaxLevel); i++) {
					list.add(i);
				}
				dto.setRadMaxLevelList(list);
			}
			CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
			
			cond.setCcid(IGRISCONSTANTS.RADRISKLEVEL_CODE);
			List<CodeDetail> radrisklevel = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRadrisklevelList(radrisklevel);
			
			cond.setCcid(IGRISCONSTANTS.RADFREQUENCY_CODE);
			List<CodeDetail> radfrequency = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRadfrequencyList(radfrequency);
			
			cond.setCcid(IGRISCONSTANTS.RADMODE_CODE);
			List<CodeDetail> radmode = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRadmodeList(radmode);
			
			cond.setCcid(IGRISCONSTANTS.RADTYPE_CODE);
			List<CodeDetail> radtype = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRadtypeList(radtype);
			
			cond.setCcid(IGRISCONSTANTS.RARPLANSCORE_CODE);
			List<CodeDetail> rarplanscore = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRarplanscoreList(rarplanscore);
			
			cond.setCcid(IGRISCONSTANTS.RAREXECSCORE_CODE);
			List<CodeDetail> rarexecscore = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRarexecscoreList(rarexecscore);
			
			cond.setCcid(IGRISCONSTANTS.RAROVERALLSCORE_CODE);
			List<CodeDetail> raroverallscore = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRaroverallscoreList(raroverallscore);
			/*//统计各级审计项孩子数,合并行时可能用到，但想迷糊了
			Map<String, Integer> childCountMap = new HashMap<String, Integer>();
			for(RiskAuditDefResultVWInfo radrVWInfo : riskAuditDefResultVWInfoList) {
				if(StringUtils.isNotEmpty(radrVWInfo.getRadcode())) {
					if(childCountMap.containsKey(radrVWInfo.getRadcode())) {
						childCountMap.put(radrVWInfo.getRadcode(), childCountMap.get(radrVWInfo.getRadcode()) + 1);
					} else {
						childCountMap.put(radrVWInfo.getRadcode(), 1);
					}
					Set<Map.Entry<String,Integer>> set = childCountMap.entrySet();
					for(Iterator<Map.Entry<String,Integer>> iter = set.iterator();iter.hasNext();){
						Map.Entry<String,Integer> entry = iter.next();
						if(radrVWInfo.getRadcode().startsWith(entry.getKey())) {
							entry.setValue(entry.getValue() + 1);
						}
					}
					if(!childCountMap.containsKey(radrVWInfo.getRadcode())) {
						childCountMap.put(radrVWInfo.getRadcode(), 1);
					}
					
				}
			}
			dto.setChildCountMap(childCountMap);*/
		}
		
		dto.setRiskAuditDefResultVWInfoList(riskAuditDefResultVWInfoList);
		
		log.debug("========审计报告信息查询处理终了========");
		return dto;
	}
}
