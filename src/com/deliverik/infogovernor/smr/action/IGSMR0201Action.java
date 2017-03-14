/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.bl.IGSMR02BL;
import com.deliverik.infogovernor.smr.dto.IGSMR02DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0201Form;
import com.deliverik.infogovernor.smr.vo.IGSMR02011VO;

/**
 * 审批意见添加Action处理
 *
 */
public class IGSMR0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0101Action.class);

	/**
	 * 审批意见添加处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGSMR0201Form form = (IGSMR0201Form)actionForm;
		
		//BL取得
		IGSMR02BL ctlBL = (IGSMR02BL) getBean("igSMR02BL");
		
		//DTO生成
		IGSMR02DTO dto = new IGSMR02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//年报发起处理画面初期显示处理
			log.debug("========审批意见添加页面初始化显示处理开始========");
			dto.setIgSMR0201Form(form);
			ctlBL.searchApproveSuggestion(dto);
			if(dto.getApproveSuggestionInfo() != null){
				form.setId(dto.getApproveSuggestionInfo().getId());
				form.setSuggestion(dto.getApproveSuggestionInfo().getSuggestion());
			}
			
			//封装VO
			IGSMR02011VO vo = new IGSMR02011VO();
			vo.setIg500Info(dto.getIg500Info());
			vo.setPidname(dto.getPidname());
			super.<IGSMR02011VO>setVO(request, vo);
			log.debug("========审批意添加见页面初始化显示处理结束========");
			
		} else if( "INSERT".equals(mapping.getParameter())){
			//审批意见新增处理
			log.debug("========审批意见新增处理开始========");
			
			//DTO输入参数设定
			dto.setIgSMR0201Form(form);
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto = ctlBL.saveApproveSuggestion(dto);//审批意见新增
			
			//处理成功标识
			request.setAttribute("flag", "1");
			
			//是否设置了审批意见
			if(StringUtils.isNotEmpty(form.getSuggestion())) {
				request.setAttribute("content", "1");
			}
			
			log.debug("========审批意见新增处理结束========");
			
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
