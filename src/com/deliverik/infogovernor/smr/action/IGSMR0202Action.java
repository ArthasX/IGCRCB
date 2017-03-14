/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.infogovernor.smr.bl.IGSMR02BL;
import com.deliverik.infogovernor.smr.dto.IGSMR02DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0202Form;
import com.deliverik.infogovernor.smr.vo.IGSMR02021VO;

/**
 * 审批意见查询Action处理
 *
 */
public class IGSMR0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0101Action.class);

	/**
	 * 审批意见查询处理
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
		IGSMR0202Form form = (IGSMR0202Form)actionForm;
		
		//BL取得
		IGSMR02BL ctlBL = (IGSMR02BL) getBean("igSMR02BL");
		
		//DTO生成
		IGSMR02DTO dto = new IGSMR02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//年报发起处理画面初期显示处理
			log.debug("========审批意见查询页面初始化显示处理开始========");
			dto.setIgSMR0202Form(form);
			ctlBL.searchApproveSuggestionAllByPidid(dto);
			
			//封装VO
			IGSMR02021VO vo = new IGSMR02021VO();
			vo.setIg500Info(dto.getIg500Info());
			vo.setLstApproveSuggestionInfo(dto.getLstApproveSuggestionInfo());
			super.<IGSMR02021VO>setVO(request, vo);
			log.debug("========审批意见查询页面初始化显示处理结束========");
			
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
