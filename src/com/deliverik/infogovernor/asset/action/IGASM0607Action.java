package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM06BL;
import com.deliverik.infogovernor.asset.dto.IGASM06DTO;
import com.deliverik.infogovernor.asset.form.IGASM0607Form;

/**
 * 软件关系编辑画面Action处理
 *
 * @author
 */
public class IGASM0607Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0607Action.class);

	/**
	 * 事件处理
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
		IGASM0607Form form = (IGASM0607Form)actionForm;
		
		//BL取得
		IGASM06BL ctlBL = (IGASM06BL) getBean("igasm06BL");
		
		//DTO生成
		IGASM06DTO dto = new IGASM06DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//画面跳转设定
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//软件关系登记画面初期显示处理
			log.debug("========软件关系登记画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I001","软件关系信息"));
			
			req.getSession().setAttribute("IGASM0607Form", form);
			
			log.debug("========软件关系登记画面初期显示处理终了========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//软件关系编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//按下返回按钮时的返回处理
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//产项关系登记处理
				log.debug("========软件关系登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgasm0607Form(form);
				
				if (isTokenValid(req, true)){
					//软件关系登记逻辑调用
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========软件关系登记处理终了========");
				forward = "BACK";

			} else {
				//软件关系变更处理
				log.debug("========软件关系变更处理开始========");

				//DTO输入参数设定
				dto.setIgasm0607Form(form);
				
				//软件关系变更逻辑调用
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========软件关系变更处理终了========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//软件关系变更画面初期显示处理
			log.debug("========软件关系变更初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgasm0607Form(form);
			
			//软件关系变更画面初期显示逻辑调用
			dto = ctlBL.initIGASM0607Action(dto);
			
			log.debug("========软件关系变更初期显示处理终了========");

			saveToken(req);
			
			forward = "DISP";
			
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
