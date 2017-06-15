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

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0101Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;



/**
 * 接待处理Action
 * 
 */
public class IGLOM0101Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0101Action.class);
	
	String forward = "";

	/**
	 * 接待处理
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
		IGLOM0101Form form = (IGLOM0101Form) actionForm;
		// BL取得
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		// DTO生成
		IGLOM01DTO dto = new IGLOM01DTO();
		// 下拉菜单
		req.setAttribute("recption_rscale", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSCALE));
		req.setAttribute("recption_status", LOMHelper.getItemsCodes(CodeUtils.RECPTION_STATUS));
		req.setAttribute("recption_rstandard", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSTANDARD));
		req.setAttribute("lodge_standard", LOMHelper.getItemsCodes(CodeUtils.LODGE_STANDARD));
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// 接待登记初期显示处理
			log.debug("========接待登记画面初期显示处理开始========");

			addMessage(req, new ActionMessage("IGCO10000.I001", "接待基本信息"));
			
			log.debug("========接待登记画面初期显示处理终了========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//接待登记画面再显示处理
			log.debug("========接待登记画面再显示处理开始========");
			
			dto.setIglom0101Form(form);
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			
			log.debug("========接待登记画面再显示处理终了========");
			
			forward = "DISP";
			
		}else
		
		
		if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// 类型登记处理
				log.debug("========接待处理开始========");
				// DTO输入参数设定
				dto.setRecption(form);
				dto.setIglom0101Form(form);
               //struts同步令牌机制，防止重复提交
				if (isTokenValid(req, true)) {
					dto = ctlBL.insertRecptionAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========接待处理终了========");

				forward = "DISP";
				
			}else {
				//接待信息变更处理
				log.debug("========接待信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setRecption(form);
				dto.setIglom0101Form(form);

				if (isTokenValid(req, true)) {
					
					//接待信息变更逻辑调用
					dto = ctlBL.updateRecptionAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========接待信息变更处理终了========");
				
				forward = "DISP1";

			}
		}
		//变更页面初始化
		if("EDIT".equals(mapping.getParameter())){
			
			log.debug("========接待信息变更初期显示处理开始========");
			form.setMode("1");
			
			dto.setIglom0101Form(form);

			dto = ctlBL.initRecption(dto);
			forward = "DISP";
			log.debug("========接待信息变更初期显示处理终了========");
		
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
