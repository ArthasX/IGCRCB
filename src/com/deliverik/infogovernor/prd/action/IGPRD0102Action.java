/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

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
import com.deliverik.infogovernor.prd.form.IGPRD0102Form;
import com.deliverik.infogovernor.prd.form.IGPRD0104Form;

/**
 * 流程定义基本信息编辑画面Action处理
 *
 */
public class IGPRD0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0102Action.class);

	/**
	 * 流程定义处理
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
		IGPRD0102Form form = (IGPRD0102Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//流程定义登记画面初期显示处理
			log.debug("========流程定义登记画面初期显示处理开始========");
			dto = ctlBL.searchActionListAction(dto);
			req.setAttribute("actionLabelValueList", dto.getActionLabelValueList());
			//监管报表
			String message = "";
			addMessage(req, new ActionMessage("IGCO10000.I001",message));
			log.debug("========流程定义登记画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				//流程定义登记处理
				log.debug("========流程定义登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgPRD0102Form(form);
				if (isTokenValid(req, true)){
					//流程定义信息登记逻辑调用
					dto = ctlBL.insertProcessDefinitionAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========流程定义登记处理终了========");
				
				forward = "DISP";
				
			} else {
				//流程定义变更处理
				log.debug("========流程定义基本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setIgPRD0102Form(form);
				
				//流程定义信息变更逻辑调用
				dto = ctlBL.updateProcessDefinitionAction(dto);
				
				log.debug("========流程定义基本信息变更处理终了========");
				
				forward = "BACK";
			}
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========流程定义基本信息变更初期显示处理开始========");
			dto.setIgPRD0102Form(form);
			
			dto = ctlBL.initIGPRD0102Action(dto);
			dto = ctlBL.searchActionListAction(dto);
            req.setAttribute("actionLabelValueList", dto.getActionLabelValueList());
			dto.setPdid(form.getPdid());
			dto = ctlBL.isProcessDefinitionInUse(dto);
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			log.debug("========流程定义基本信息变更初期显示处理终了========");
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				forward = "VIEWHISTORY";
			}else{
				forward = "DISP";
			}
		} else if ("CHANGE".equals(mapping.getParameter())){
				log.debug("========流程定义停用/启用处理开始========");
				IGPRD0104Form form1 = new IGPRD0104Form();
				form1.setPdid(form.getPdid());
				dto.setIgPRD0102Form(form);
				dto.setIgPRD0104Form(form1);
				
				ctlBL.changeProcessDefinitionAction(dto);
				
				log.debug("========流程定义停用/启用处理终了========");
				
				if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
					//历史版本下的查看
					forward = "VIEWHISTORY";
				}else{
					forward = "DISP";
				}
		} else if ("TEST".equals(mapping.getParameter())){
			log.debug("========流程定义测试处理开始========");
			IGPRD0104Form form1 = new IGPRD0104Form();
			form1.setPdid(form.getPdid());
			dto.setIgPRD0102Form(form);
			dto.setIgPRD0104Form(form1);
			
			ctlBL.testProcessDefinitionAction(dto);
			
			log.debug("========流程定义测试处理终了========");
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
