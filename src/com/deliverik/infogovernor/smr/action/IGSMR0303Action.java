/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.bl.IGSMR03BL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0302Form;
import com.deliverik.infogovernor.smr.form.IGSMR0303Form;

/**
 * 概述:定时提醒 
 * 功能描述：定时提醒 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-05
 * 修改记录：
 */
public class IGSMR0303Action extends BaseAction {
	static Log log = LogFactory.getLog(IGSMR0303Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0303Form form = (IGSMR0303Form)actionForm;
								
		//BL取得
		IGSMR03BL ctlBL = (IGSMR03BL) getBean("igSMR03BL");
								
		//DTO生成
		IGSMR03DTO dto = new IGSMR03DTO();
						
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);						
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========定时提醒画面初期显示处理开始========");	
			//将form放进dto中
			dto.setIgSMR0303Form(form);
			//查询
			dto = ctlBL.searchCautionTimeAction(dto);
			//将结果放进request中
			if(dto.getRc()!=null){				
				request.setAttribute("year_m", dto.getRc().getRcmonth());
				if(dto.getRc().getRcday()==null){
					request.setAttribute("year_d", "a");
				}else{
					request.setAttribute("year_d", dto.getRc().getRcday());
				}
				
			}else{
				request.setAttribute("year_d", "a");
			}
			if(dto.getRc1()!=null){			
				request.setAttribute("month1_m", dto.getRc1().getRcmonth());
				if(dto.getRc1().getRcday()==null){
					request.setAttribute("month1_d", "a");
				}else{										
					request.setAttribute("month1_d", dto.getRc1().getRcday());
				}
			}else{
				request.setAttribute("month1_d", "a");
			}
			if(dto.getRc2()!=null){				
				request.setAttribute("month2_m", dto.getRc2().getRcmonth());
				if(dto.getRc2().getRcday()==null){
					request.setAttribute("month2_d", "a");
				}else{
					request.setAttribute("month2_d", dto.getRc2().getRcday());					
				}
				
			}else{
				request.setAttribute("month2_d", "a");
			}
			if(dto.getRc3()!=null){				
				request.setAttribute("month3_m", dto.getRc3().getRcmonth());
				if(dto.getRc3().getRcday()==null){
					request.setAttribute("month3_d", "a");
				}else{
					request.setAttribute("month3_d", dto.getRc3().getRcday());
				}
				
			}else{
				request.setAttribute("month3_d", "a");
			}
			if(dto.getRc4()!=null){				
				request.setAttribute("month4_m", dto.getRc4().getRcmonth());
				if(dto.getRc4().getRcday()==null){
					request.setAttribute("month4_d", "a");
				}else{
					request.setAttribute("month4_d", dto.getRc4().getRcday());
				}
				
			}else{
				request.setAttribute("month4_d", "a");
			}
			saveToken(request);
			log.debug("========定时提醒画面初期显示处理终了========");
			
		}
		if("SET".equals(mapping.getParameter())){
			log.debug("========时间设定处理开始========");
				//将form放进dto中
				dto.setIgSMR0303Form(form);
				//设置时间
				dto = ctlBL.setCautionTimeAction(dto);			
				forward = "SET";
			
			log.debug("========时间设定处理结束========");
		}
		if("CLEAR".equals(mapping.getParameter())){
			log.debug("========提醒时间清除处理开始========");
				//将form放进dto中
				dto.setIgSMR0303Form(form);
				//设置时间
				dto = ctlBL.eliminateCautionTimeAction(dto);			
				forward = "CLEAR";
			log.debug("========提醒时间清除处理结束========");
		}
		if("STOP".equals(mapping.getParameter())){
			log.debug("========提醒时间清除处理开始========");
				//将form放进dto中
				dto.setIgSMR0303Form(form);
				//中止时间
				dto = ctlBL.stopCautionTimeAction(dto);			
				forward = "STOP";
			log.debug("========提醒时间清除处理结束========");
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
				
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				 addMessage(request, message);
			}
					
		}
		return mapping.findForward(forward);
	}

}
