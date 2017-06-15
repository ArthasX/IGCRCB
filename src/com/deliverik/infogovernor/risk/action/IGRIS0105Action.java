/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0105Form;

/**
 * 审计项基本信息编辑画面Action处理
 *
 */
public class IGRIS0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0105Action.class);

	/**
	 * 成功处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		//实例化FORM
		IGRIS0105Form form = (IGRIS0105Form)actionForm;
		//获取BL接口实例
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		//实例化DTO
		IGRIS01DTO dto = new IGRIS01DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========审计项新增画面初期显示处理开始========");
			//获取版本名称下拉列表
			dto = ctlBL.searchRiskAuditLabelInUse(dto);
			req.setAttribute("labelList", dto.getLabelList());
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001","审计项基本信息"));
			log.debug("========审计项新增画面初期显示处理终了========");
		}
		if( "EDIT_DISP".equals(mapping.getParameter())){
			log.debug("========审计项管理详细画面初期显示处理开始========");
			dto.setIgRIS0105Form(form);		
			//调用BL查询
			dto = ctlBL.initRiskAuditDefAction(dto);
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========审计项管理详细画面初期显示处理终了========");
		}
		//审计项新增
		if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				log.debug("========审计项新增处理开始========");
				dto.setIgRIS0105Form(form);				
				//调用BL新增
				if (isTokenValid(req, true)){
					dto = ctlBL.insertRiskAuditDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========审计项新增处理终了========");
			}else{
				log.debug("========审计项管理详细画面初期显示处理开始========");
				dto.setIgRIS0105Form(form);		
				//调用BL查询
				dto = ctlBL.editRiskAuditDefAction(dto);			
				log.debug("========审计项管理详细画面初期显示处理终了========");
				List<ActionMessage> messageList = dto.getMessageList();
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
				}
				return mapping.findForward("EDIT");			
			}
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
