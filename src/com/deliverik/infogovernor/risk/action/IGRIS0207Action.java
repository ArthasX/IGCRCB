package com.deliverik.infogovernor.risk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0201Form;
import com.deliverik.infogovernor.risk.form.IGRIS0202Form;
import com.deliverik.infogovernor.risk.vo.IGRIS02011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0402Form;

/**
 * 风险检查查询画面Action处理
 *
 */
public class IGRIS0207Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0207Action.class);

	/**
	 * 风险检查查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//BL取得
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		
		//DTO生成
		IGRIS02DTO dto = new IGRIS02DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		
		String flag = "0";
		
		if( "DISP".equals(mapping.getParameter())){
			//类型查询画面初期显示处理
			log.debug("========风险检查查询画面初期显示处理开始========");
			
			//FORM取得
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险检查查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========风险检查查询处理开始========");

			//FORM取得
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if(StringUtils.isEmpty(form.getRcstatus_q())){
				form.setRcstatus_q("0");//启用状态
			}
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
				if ( form == null ) {
					form = new IGRIS0201Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0201");
			
			//DTO输入参数设定
			dto.setIgRIS0201Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchRiskCheckAction(dto);
				
			//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckDataList(dto.getRiskCheckDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========风险检查查询处理终了========");
		}else if ("CHANGE".equals(mapping.getParameter())){
			//修改状态1启用 0停用
			log.debug("========风险检查状态变化处理开始========");

			//FORM取得
			IGRIS0202Form form = (IGRIS0202Form)actionForm;

			dto.setIgRIS0202Form(form);
			dto = ctlBL.changeRiskCheckStatusAction(dto);
			
			log.debug("========风险检查状态变化处理终了========");
		}else if ("READ".equals(mapping.getParameter())){
			log.debug("========风险检查查看处理开始========");

			//FORM取得
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			dto.setIgRIS0201Form(form);
			dto = ctlBL.readRiskCheckAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheck(dto.getRiskCheck());
			vo.setAttachmentDataList(dto.getAttachmentList());
			vo.setCronInfo(dto.getCronInfo());
			super.<IGRIS02011VO>setVO(req, vo);
			flag = req.getParameter("flag");
			
			if(flag!=null && "1".equals(flag)){
				return mapping.findForward("DISP2");
			}

			log.debug("========风险检查查看处理终了========");
		}else if( "RESULT".equals(mapping.getParameter())||"RESULT1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========风险检查查询处理开始========");

			//FORM取得
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0201");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("RESULT1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
				if ( form == null ) {
					form = new IGRIS0201Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGRIS0201Form) req.getSession().getAttribute("IGRIS0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0201");
			
			//DTO输入参数设定
			dto.setIgRIS0201Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchRiskCheckAction(dto);
			
			
			//req.setAttribute("pageNum", pDto.getFromCount());
			//req.setAttribute("pageCount", pDto.getPageDispCount());
	
			//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckDataList(dto.getRiskCheckDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========风险检查查询处理终了========");
		}else if ("RESULTREAD".equals(mapping.getParameter())){
			log.debug("========风险检查查看处理开始========");

			//FORM取得
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			dto.setIgRIS0201Form(form);
			dto = ctlBL.readRiskCheckAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheck(dto.getRiskCheck());
			vo.setAttachmentDataList(dto.getAttachmentList());
			vo.setCronInfo(dto.getCronInfo());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========风险检查查看处理终了========");
		}else if ( "RELEVANCEDISP".equals(mapping.getParameter())){
			log.debug("========关联审计项初始化处理开始========");

			//FORM取得
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			req.setAttribute("rcid", form.getRcid());
			//获取版本名称下拉列表
			//BL取得
			IGRIS01BL ctlBL1 = (IGRIS01BL) getBean("igRIS01BL");
			//DTO生成
			IGRIS01DTO dto1 = new IGRIS01DTO();
			dto1 = ctlBL1.searchRiskAuditLabelInUse(dto1);
			req.setAttribute("labelList", dto1.getLabelList());
			
			log.debug("========关联审计项初始化处理终了========");
		} else if ( "RELEVANCE".equals(mapping.getParameter())){
			log.debug("========关联审计项查询处理开始========");

			//FORM取得
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			//BL取得
			IGRIS01BL ctlBL1 = (IGRIS01BL) getBean("igRIS01BL");
			//DTO生成
			IGRIS01DTO dto1 = new IGRIS01DTO();
			dto1 = ctlBL1.searchRiskAuditLabelInUse(dto1);
			req.setAttribute("labelList", dto1.getLabelList());
			
			req.setAttribute("rcid", form.getRcid());
			dto.setIgRIS0201Form(form);
			
			dto = ctlBL.searchRiskAuditDefAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			
			vo.setRadMaxLevel(dto.getRadMaxLevel());
			vo.setRadMaxLevelList(dto.getRadMaxLevelList());
			vo.setRiskAuditDefList(dto.getRiskAuditDefList());
			
			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========关联审计项查询处理终了========");
		} else if ( "SAVE".equals(mapping.getParameter())){
			log.debug("========关联审计项保存处理开始========");

			//FORM取得
			IGRIS0201Form form = (IGRIS0201Form)actionForm;

			//获取BL接口实例
			IGSYM04BL ctlBL04 = (IGSYM04BL) getBean("igsym04BL");
			//实例化DTO
			IGSYM04DTO dto04 = new IGSYM04DTO();
			//角色授权查询
			IGSYM0402Form form04 = new IGSYM0402Form();
			form04.setUserid(user.getUserid());
			dto04.setUserRoleVWSearchCond(form04);
			//调用BL查询
			dto04 = ctlBL04.searchUserRoleForManagerAction(dto04);
			
			// 检查策略管理加权限控制，只有信息安全审批可以审批
			for(UserRoleInfo uri : dto04.getOwnRoleList()) {
				if(uri.getRoleid() == 1127){
					form.setIsSecurityApproval("1");
					break;
				}
			}
			
			dto.setIgRIS0201Form(form);
			
			dto = ctlBL.insertRiskAuditDefAction(dto);

			log.debug("========关联审计项保存处理终了========");
		} 
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		return mapping.findForward("DISP");
	}
}
