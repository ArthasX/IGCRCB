package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0507Form;

/**
 * 专项预案关系编辑画面Action处理
 *
 * @author
 */
public class IGDRM0507Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0507Action.class);

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
		IGDRM0507Form form = (IGDRM0507Form)actionForm;
		
		//BL取得
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		
		//DTO生成
		IGDRM05DTO dto = new IGDRM05DTO();
		
		dto = ctlBL.searchRelationListAction(dto);
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		
		//画面跳转设定
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//专项预案关系登记画面初期显示处理
			log.debug("========专项预案关系登记画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I001","专项预案关系信息"));
			
			req.getSession().setAttribute("IGDRM0507Form", form);
			
			log.debug("========专项预案关系登记画面初期显示处理终了========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//专项预案关系编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//按下返回按钮时的返回处理
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//产项关系登记处理
				log.debug("========专项预案关系登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgdrm0507Form(form);
				if (isTokenValid(req, true)){
					//专项预案关系登记逻辑调用
					dto = ctlBL.insertEntityItemRelationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========专项预案关系登记处理终了========");
				forward = "BACK";

			} else {
				//专项预案关系变更处理
				log.debug("========专项预案关系变更处理开始========");

				//DTO输入参数设定
				dto.setIgdrm0507Form(form);
				
				//专项预案关系变更逻辑调用
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========专项预案关系变更处理终了========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//专项预案关系变更画面初期显示处理
			log.debug("========专项预案关系变更初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgdrm0507Form(form);
			
			//专项预案关系变更画面初期显示逻辑调用
			dto = ctlBL.initIGDRM0507Action(dto);
			
			log.debug("========专项预案关系变更初期显示处理终了========");

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
