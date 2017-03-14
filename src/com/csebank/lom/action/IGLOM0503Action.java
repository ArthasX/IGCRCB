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
import com.csebank.lom.form.IGLOM0503Form;
import com.csebank.lom.form.IGLOM0518Form;
import com.csebank.lom.form.IGLOM0519Form;
import com.csebank.lom.vo.IGLOM05181VO;
import com.deliverik.framework.base.BaseAction;



/**
 * 接待处理Action
 * 
 */
public class IGLOM0503Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGLOM0503Action.class);
	
	String forward = "";

	/**
	 * 食堂工作餐信息处理
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
		IGLOM0503Form form = (IGLOM0503Form) actionForm;
		// BL取得
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		// DTO生成
		IGLOM05DTO dto = new IGLOM05DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			
			// 食堂工作餐登记初期显示处理
			log.debug("========食堂工作餐登记画面初期显示处理开始========");
			
			req.getSession().setAttribute("IGLOM0503Form", new IGLOM0503Form());
			addMessage(req, new ActionMessage("IGCO10000.I001", "食堂工作餐信息"));
			IGLOM0519Form formPage = new IGLOM0519Form();
			formPage.setDesc("1");
			dto.setLunchCardSearchCond(formPage);
			dto = ctlBL.searchELunchCardAction(dto);
			
			//将餐卡管理信息检索结果设定到VO中
			IGLOM05181VO vo = new IGLOM05181VO();
			if(dto.getItemsCodesList()==null || (dto.getItemsCodesList()!=null && dto.getItemsCodesList().size()==0)){
				addMessage(req, new ActionMessage("IGLOM0503.E001"));
			}else{
				vo.setLunchCardList(dto.getItemsCodesList());
			}
			super.<IGLOM05181VO>setVO(req, vo);
			log.debug("========食堂工作餐信息登记画面初期显示处理终了========");
			saveToken(req);
			
			forward = "DISP";
			
		} else if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// 类型登记处理
				log.debug("========食堂工作餐信息登记处理开始========");
				// DTO输入参数设定
				dto.setEworkingLunch(form);
				dto.setIglom0503Form(form);

				if (isTokenValid(req, true)) {
					// 类型信息登记逻辑调用
					dto = ctlBL.insertEworkingLunchAction(dto);
				} else {
					
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========食堂工作餐信息登记处理终了========");

				forward = "DISP";
				
			}else {
				//接待信息变更处理
				log.debug("========食堂工作餐信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setEworkingLunch(form);
				dto.setIglom0503Form(form);
				
				//接待信息变更逻辑调用
				dto = ctlBL.updateEworkingLunchAction(dto);
				
				log.debug("========食堂工作餐信息变更处理终了========");
				
				return mapping.findForward("DETAIL");

			}
		}	else if ("EDIT".equals(mapping.getParameter())){
			
			log.debug("========食堂工作餐管理变更初期显示处理开始========");
			
			//DTO输入参数设定
			IGLOM0518Form formPage = new IGLOM0518Form();
			IGLOM0519Form formCond = new IGLOM0519Form();
			formPage.setIcid(form.getIcid());
			dto.setIglom0518Form(formPage);
			formCond.setIcid(formPage.getIcid());
			dto.setLunchCardSearchCond(formCond);
			dto = ctlBL.searchELunchCardAction(dto);
			
			//将餐卡管理信息检索结果设定到VO中
			IGLOM05181VO vo = new IGLOM05181VO();
			vo.setLunchCardList(dto.getItemsCodesList());
			
			super.<IGLOM05181VO>setVO(req, vo);
			form.setMode("1");
			
			dto.setIglom0503Form(form);
			dto = ctlBL.initEworkingLunchAction(dto);
			log.debug("========食堂工作餐管理变更初期显示处理终了========");
			return mapping.findForward("DISP");
			
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
