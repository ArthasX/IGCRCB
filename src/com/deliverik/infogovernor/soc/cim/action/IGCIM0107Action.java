package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0107Form;

/**
 * 设备关系编辑画面Action处理
 *
 * @author
 */
public class IGCIM0107Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0107Action.class);

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
		IGCIM0107Form form = (IGCIM0107Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		dto.setIgcim0107Form(form);
		
		if("1".equals(form.getRelationType())){
			//依赖关系
			dto = ctlBL.searchEiBelongRelationListAction(dto);	
		}else{
			//普通关系
			dto = ctlBL.searchRelationListAction(dto);
					
		}
		//查询关系类型
		dto = ctlBL.searchRelationType(dto);
		req.getSession().setAttribute("ADrelationTypeList", dto.getRelationTypeList());
		req.getSession().setAttribute("ADrelationList", dto.getRelationList());
		//画面跳转设定
		String forward = null;
		
		req.setAttribute("backUrl", req.getParameter("backUrl"));
		//
		if( "DISP".equals(mapping.getParameter())){
			//设备关系登记画面初期显示处理
			log.debug("========设备关系登记画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I001","设备关系信息"));
			
			req.getSession().setAttribute("IGCIM0107Form", form);
			
			saveToken(req);
			
			log.debug("========设备关系登记画面初期显示处理终了========");
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//设备关系编辑处理
			if ((isCancelled(req)||(req.getParameter("backUrl")!=null)) && !"add".equals(req.getParameter("param"))) {
				//按下返回按钮时的返回处理
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//产项关系登记处理
				log.debug("========设备关系登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgcim0107Form(form);
				
				if (isTokenValid(req, true)){
					if("1".equals(form.getRelationType())){
						//登记依赖关系
						dto = ctlBL.insertEntityItemEiBelongRelationAction(dto);
					}else{
						//设备关系登记逻辑调用
						dto = ctlBL.insertEntityItemRelationAction(dto);
					}
					
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}

				log.debug("========设备关系登记处理终了========");
				forward = "BACK";

			} else {
				//设备关系变更处理
				log.debug("========设备关系变更处理开始========");

				//DTO输入参数设定
				dto.setIgcim0107Form(form);
				
				//设备关系变更逻辑调用
				dto = ctlBL.updateEntityItemRelationAction(dto);
				
				log.debug("========设备关系变更处理终了========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//设备关系变更画面初期显示处理
			log.debug("========设备关系变更初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgcim0107Form(form);
			
			//设备关系变更画面初期显示逻辑调用
			dto = ctlBL.initIGASM0307Action(dto);
			
			log.debug("========设备关系变更初期显示处理终了========");

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
