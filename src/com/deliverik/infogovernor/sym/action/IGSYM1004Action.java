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
import com.deliverik.infogovernor.sym.bl.IGSYM10BL;
import com.deliverik.infogovernor.sym.dto.IGSYM10DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1004Form;

/**
 * 数据信息编辑画面Action处理
 *
 */
public class IGSYM1004Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1004Action.class);

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
		IGSYM1004Form form = (IGSYM1004Form)actionForm;
		
		//BL取得
		IGSYM10BL ctlBL = (IGSYM10BL) getBean("igsym10BL");
		
		//DTO生成
		IGSYM10DTO dto = new IGSYM10DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//数据信息登记画面初期显示处理
			log.debug("========数据信息登记画面初期显示处理开始========");
			dto.setIgsym1004Form(form);
			ctlBL.initIGSYM1004Action(dto);
			req.setAttribute("IGSYM1004Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","数据信息"));
			log.debug("========数据信息登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}

		if( "LIST".equals(mapping.getParameter())){
			//层次数据登记画面初期显示处理
			log.debug("========层次数据登记画面初期显示处理开始========");
			form.setCid("");
			form.setCvalue("");
			addMessage(req, new ActionMessage("IGCO10000.I001","数据信息"));
			log.debug("========层次数据登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			//数据信息编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//数据信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回类型登记画面
					return mapping.findForward("BACK1");
				} else if (form.getRoute().equals("1")){
					//返回类型详细 画面
					return mapping.findForward("BACK2");
				} else {
					//返回层次数据详细 画面
					return mapping.findForward("BACK3");
				}
			}
			if (form.getMode().equals("0")||form.getMode().equals("2")){
				//数据信息登记处理
				log.debug("========数据信息登记处理开始========");

				//DTO输入参数设定
				dto.setIgsym1004Form(form);
				
				//数据信息登记逻辑调用
				dto = ctlBL.insertCodeDetailAction(dto);
				
				log.debug("========数据信息登记处理终了========");
				
				if (form.getRoute().equals("0")){
					forward = "DISP";
				} else if (form.getRoute().equals("1")){
					forward = "DETAIL";
				} else {
					//返回层次数据详细 画面
					forward = "BACK3";
				}

			} else {
				//数据信息变更处理
				log.debug("========数据信息变更处理开始========");

				//DTO输入参数设定
				dto.setIgsym1004Form(form);
				
				//数据信息变更逻辑调用
				dto = ctlBL.updateCodeDetailAction(dto);
				if(dto.isError() == true){
					forward = "ERROR";
				} else {
					forward = "DETAIL";
				}
				log.debug("========数据信息变更处理终了========");
			}
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//数据信息编辑画面初期处理
			log.debug("========数据信息编辑画面初期处理开始========");

			//DTO输入参数设定
			dto.setIgsym1004Form(form);
			
			//数据信息编辑画面初期处理逻辑调用
			dto = ctlBL.initIGSYM1004Action(dto);
			
			log.debug("========数据信息变更处理终了========");

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
