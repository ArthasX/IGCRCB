/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0118Form;

/**
 * 表单信息基本信息编辑画面Action处理
 *
 */
public class IGPRD0118Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0118Action.class);

	/**
	 * 表单信息处理
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
		IGPRD0118Form form = (IGPRD0118Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//表单信息登记画面初期显示处理
			log.debug("========表单信息登记画面初期显示处理开始========");
			String maxSort = ResourceUtility.getString("MAX_SORT");
			addMessage(req, new ActionMessage("IGCO10000.I001","表单信息基本信息"));
			req.setAttribute("maxSort", Integer.valueOf(maxSort));
			saveToken(req);
			log.debug("========表单信息登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				//表单信息登记处理
				log.debug("========表单信息登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgPRD0118Form(form);
				
				//表单信息信息登记逻辑调用
				
				
				if (isTokenValid(req, true)){
					dto = ctlBL.insertProcessInfoDefGeneralAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				req.setAttribute("pdid", "");
				
				log.debug("========表单信息登记处理终了========");
				
				forward = "DISP";
				
			} else {
				//表单信息变更处理
				log.debug("========表单信息基本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setIgPRD0118Form(form);
				
				//表单信息信息变更逻辑调用
				dto = ctlBL.updateProcessInfoDefGeneralAction(dto);
				
				log.debug("========表单信息基本信息变更处理终了========");
				
				forward = "BACK";
			}
		} 
		else if( "COPYGT".equals(mapping.getParameter())){
			log.debug("========共通变量赋值表单信息基本信息显示处理开始========");
			form.setPdid(req.getParameter("pdid"));
			dto.setIgPRD0118Form(form);
			ctlBL.insertProcessInfoDefFromProcessInfoDefGeneralAction(dto);
			req.setAttribute("pdid", form.getPdid());
			log.debug("========共通变量赋值表单信息基本信息显示处理终了========");

			if("basic".equals(form.getBasic())) {
				forward = "BASIC";
			} else {
				forward = "DISP";
			}
		}
		else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========表单信息基本信息变更初期显示处理开始========");
			dto.setIgPRD0118Form(form);
			
			dto = ctlBL.initIGPRD0118Action(dto);
			
			log.debug("========表单信息基本信息变更初期显示处理终了========");

			forward = "DISP";
		} else if ("DELETE".equals(mapping.getParameter())){
				log.debug("========表单信息删除处理开始========");
				
				dto.setIgPRD0118Form(form);
				
				dto = ctlBL.deleteProcessInfoDefGeneralAction(dto);
				if("no".equals(dto.getDelFalg())){
					forward = "NO";
				}
				log.debug("========表单信息删除处理终了========");
				
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
