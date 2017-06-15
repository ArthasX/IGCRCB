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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0152Form;

/**
 * 概述: 阜新拓扑，关系登记Action
 * 功能描述: 阜新拓扑，关系登记Action
 * 创建记录: 2013/10/25
 * 修改记录: 
 */
public class IGCIM0152Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0152Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM0152Form form = (IGCIM0152Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setIgcim0152Form(form);
		dto.setLocale(this.getLocale(req));
		dto = ctlBL.initIGCIM0152Action(dto);
		//增加过滤条件
		List<LabelValueBean> ADrelationList = dto.getRelationList();
		
		req.getSession().setAttribute("ADrelationList", ADrelationList);
		
		//画面跳转设定
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//应用关系登记画面初期显示处理
			log.debug("========应用关系登记画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I001","应用关系信息"));
			
			req.getSession().setAttribute("IGCIM0152Form", form);
			
			log.debug("========应用关系登记画面初期显示处理终了========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "INSERT".equals(mapping.getParameter())){
			log.debug("========应用关系登记处理开始========");
			if (form.getMode().equals("0")){
				//DTO输入参数设定
				dto.setIgcim0152Form(form);
				if (isTokenValid(req, true)){
					//应用关系登记逻辑调用
					dto = ctlBL.insertEntityItemRelationActionApp2(dto);
					req.setAttribute("eiid", form.getPareiid());
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				forward = "BACK";
			}
			log.debug("========应用关系登记处理终了========");
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
