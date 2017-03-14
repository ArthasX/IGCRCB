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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0114Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01141VO;

/**
 * 流程状态_分派角色设定Action
 *
 */

public class IGPRD0114Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0114Action.class);
	
	/**
	 * <p>
	 * Description: 分派角色设定处理action
	 * </p>
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRD0114Form form = (IGPRD0114Form)actionForm;
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setIgPRD0114Form(form);
		dto.setPdid(form.getPdid());

		if ("DISP".equals(mapping.getParameter())){
			log.debug("========已添加参与者查询处理开始========");
			//调用BL查询
			//查询参与者
			dto = ctlBL.searchDispatchProcessParticipant(dto);
			//查询权限
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//构造VO
			IGPRD01141VO vo = new IGPRD01141VO(dto.getProcessParticipantDefList());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01141VO>setVO(request, vo);
			log.debug("========已添加参与者查询处理终了========");
		}
		//分派角色设定
		if ("ASSIGN".equals(mapping.getParameter())){
			log.debug("========分派角色设定处理开始========");

			//调用BL发起
			if (isTokenValid(request, true)){
				if("1".equals(form.getMode())){
					ctlBL.clearProcessParticipant(dto);//清除
				} else {
					ctlBL.assignProcessParticipant(dto);//设定
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========分派角色设定处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
