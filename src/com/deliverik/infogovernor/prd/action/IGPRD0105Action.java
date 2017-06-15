package com.deliverik.infogovernor.prd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0105Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01051VO;

/**
 * 概述：流程状态基本信息编辑画面Action处理
 * 功能描述: 流程定义业务逻辑实现 
 * 创建记录: 2010/11/07
 * 修改记录: 2013/02/25		130225	流程机构相关修改(状态节点参与者类型修改)
 */
public class IGPRD0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0105Action.class);

	/**
	 * 流程状态处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGPRD0105Form form = (IGPRD0105Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setPdid(form.getPdid());
		//画面跳转设定
		String forward = null;

		//====>130225Begin
		//查询参与者类型列表
		ctlBL.searchCodedetailFromPsdassign(dto);
		// 存入request
		req.setAttribute("lvPsdassignListUR", dto.getLvPsdassignListUR());
		req.setAttribute("lvPsdassignListRO", dto.getLvPsdassignListRO());
		//====>130225End
		
		if( "DISP".equals(mapping.getParameter())){
			//流程状态登记画面初期显示处理
			log.debug("========流程状态登记画面初期显示处理开始========");
			if(StringUtils.isEmpty(form.getMode())){
				form.setMode("0");
			}
			dto.setIgPRD0105Form(form);
			dto = ctlBL.searchProcessStatusDef(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			IGPRD01051VO vo = new IGPRD01051VO();
			vo.setProcessStatusDefList(dto.getProcessStatusDefList());
			super.<IGPRD01051VO>setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","流程状态基本信息"));
			log.debug("========流程状态登记画面初期显示处理终了========");
			
			return mapping.findForward("DISP");
		} else if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				//流程状态登记处理
				log.debug("========流程状态登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgPRD0105Form(form);
				
				//流程状态信息登记逻辑调用
				dto = ctlBL.insertProcessStatusDefinitionAction(dto);
				
				log.debug("========流程状态登记处理终了========");
				
				forward = "DISP";
				
			} else {
				//流程状态变更处理
				log.debug("========流程状态基本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setIgPRD0105Form(form);
				
				//流程状态信息变更逻辑调用
				dto = ctlBL.updateProcessStatusDefinitionAction(dto);
				
				log.debug("========流程状态基本信息变更处理终了========");
				if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
					//历史版本下的查看
					forward = "VIEWHISTORY";
				}else{
					forward = "DISP";
				}
			}
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========流程状态基本信息变更初期显示处理开始========");
			form.setMode("1");
			dto.setIgPRD0105Form(form);
			
			dto = ctlBL.initIGPRD0105Action(dto);
			dto = ctlBL.searchProcessStatusDef(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			IGPRD01051VO vo = new IGPRD01051VO();
			vo.setProcessStatusDefList(dto.getProcessStatusDefList());
			vo.setApList(dto.getApList());
			super.<IGPRD01051VO>setVO(req, vo);
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			log.debug("========流程状态基本信息变更初期显示处理终了========");

			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				forward = "VIEWHISTORY";
			}else{
				forward = "DISP";
			}
		}else if("UPDATEZ".equals(mapping.getParameter())){
			log.debug("========流程状态基本信息变更初期显示处理开始========");
			if(isTokenValid(req,true)){
				dto.setIgPRD0105Form(form);
				dto = ctlBL.updateProcessStatusDefZAction(dto);
			}else{
				return null;
			}
			log.debug("========流程状态基本信息变更初期显示处理终了========");
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				forward = "VIEWHISTORY";
			}else{
				forward = "DISP";
			}
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
