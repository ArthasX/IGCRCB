/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0506Form;
import com.deliverik.framework.base.BaseAction;



/**
 * 接待处理Action
 * 
 */
public class IGLOM0506Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0506Action.class);
	
	String forward = "";

	/**
	 * 食堂接待信息处理
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORM取得
		IGLOM0506Form form = (IGLOM0506Form) actionForm;
		// BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		// DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// 食堂接待登记初期显示处理
			log.debug("========食堂接待登记画面初期显示处理开始========");

			addMessage(req, new ActionMessage("IGCO10000.I001", "食堂接待信息"));
			
			log.debug("========食堂接待信息登记画面初期显示处理终了========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				
				log.debug("========食堂接待信息登记处理开始========");
				// DTO输入参数设定
				dto.setEentertainment(form);
				dto.setIglom0506Form(form);

				if (isTokenValid(req, true)) {
					// 食堂接待信息登记逻辑调用
					dto = ctlBL.insertEentertainmentAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========食堂接待信息登记处理终了========");

				forward = "DISP";
				
			}else {
				//食堂接待信息变更处理
				log.debug("========食堂接待信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setEentertainment(form);
				dto.setIglom0506Form(form);
				
				//食堂接待信息变更逻辑调用
				dto = ctlBL.updateEentertainmentAction(dto);
				
				log.debug("========食堂接待信息变更处理终了========");
				
				return mapping.findForward("DETAIL");

			}
		}	else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========食堂接待管理变更处理开始========");
			
			//DTO输入参数设定
			dto.setIglom0506Form(form);
			
			dto = ctlBL.initEentertainmentAction(dto);
			
			log.debug("========食堂接待管理变更初期显示处理终了========");
			return mapping.findForward("DISP");
			
		}//删除
		else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========通知删除处理开始========");
			dto.setDeleteEeid(form.getDeleteEeid());
			ctlBL.deleteEentertainmentAction(dto);
			forward = "DISP";
			log.debug("========通知删除处理终了========");
		}

		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}

		return mapping.findForward(forward);
	}
}
