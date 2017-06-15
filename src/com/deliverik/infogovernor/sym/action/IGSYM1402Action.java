/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.bl.IGSYM14BL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1402Form;

/**
 * 报表基本信息编辑画面Action处理
 *
 */
public class IGSYM1402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1402Action.class);

	/**
	 * 报表处理
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
		IGSYM1402Form form = (IGSYM1402Form)actionForm;
		
		//BL取得
		IGSYM14BL ctlBL = (IGSYM14BL) getBean("igSYM14BL");
		
		//DTO生成
		IGSYM14DTO dto = new IGSYM14DTO();
		
		//跳转
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			//报表新增画面初期显示处理
			log.debug("========报表新增画面初期显示处理开始========");
			
			addMessage(req, new ActionMessage("IGCO10000.I001","报表基本信息"));
			
			saveToken(req);
			dto=ctlBL.searchPrtypeAndRfdFilenameList(dto);
			req.setAttribute("ADPrTypeList", dto.getPrtypeList());
			req.setAttribute("rfdFileNameList", dto.getRfdFileNameList());
			log.debug("========报表新增画面初期显示处理终了========");
			
		} else if( "INSERT".equals(mapping.getParameter())){//报表新增处理
			
			log.debug("========报表新增处理开始========");
			
			//DTO输入参数设定
			dto.setIgSYM1402Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//报表信息新增逻辑调用
			if (isTokenValid(req, true)){
				dto = ctlBL.insertReportFileDefinitionAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========报表新增处理终了========");
			
		} else if ("INIT".equals(mapping.getParameter())){ //报表信息变更页面初始化
			
			log.debug("========报表信息变更初期显示处理开始========");
			
			dto.setIgSYM1402Form(form);
			dto=ctlBL.searchPrtypeAndRfdFilenameList(dto);
			dto = ctlBL.initReportFileDefinitionAction(dto);
			req.setAttribute("ADPrTypeList", dto.getPrtypeList());
			req.setAttribute("rfdFileNameList", dto.getRfdFileNameList());
			log.debug("========报表信息变更初期显示处理终了========");
		} else if ("EDIT".equals(mapping.getParameter())){ //报表信息变更
			
			log.debug("========报表信息变更处理开始========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			dto.setIgSYM1402Form(form);
			
			dto = ctlBL.editReportFileDefinitionAction(dto);
			
			log.debug("========报表信息变更处理终了========");
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
