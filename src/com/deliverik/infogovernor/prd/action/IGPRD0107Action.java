/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0107Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01071VO;

/**
 * 流程状态_参与者Action
 *
 */

public class IGPRD0107Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0107Action.class);
	
	/**
	 * <p>
	 * Description: 参与者处理action
	 * </p>
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRD0107Form form = (IGPRD0107Form)actionForm;
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();

		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========参与者查询处理开始========");
			String psdid = request.getParameter("psdid");
			String pdid = request.getParameter("pdid");
			if(psdid!=null && !"".equals(psdid)){
				form.setPsdid(psdid);
			}
			if(pdid!=null && !"".equals(pdid)){
				form.setPdid(pdid);
				request.setAttribute("pdid", pdid);
			}
			dto.setIgPRD0107Form(form);
			dto.setPdid(form.getPdid());
			//调用BL查询
			dto = ctlBL.getProcessParticipants(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			//构造VO
			IGPRD01071VO vo = new IGPRD01071VO(dto.getRoleList(),dto.getProcessParticipantDefList());
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			vo.setProcessParticipantDefMap(dto.getProcessParticipantDefMap());
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01071VO>setVO(request, vo);
			//OA模式
			if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(dto.getProcessStatusDef().getPsdtype())) {
				forward = "DISP2";
			}
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				forward = "VIEWHISTORY";
				//OA模式
				if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
					forward = "VIEWHISTORY1";
				}
			}
			log.debug("========参与者查询处理终了========");
		} else if ("INSERT".equals(mapping.getParameter())){//添加参与者
			log.debug("========参与者处理开始========");

			dto.setIgPRD0107Form(form);
			//删除角色
			if("0".equals(form.getMode())){
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.removeProcessParticipants(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}else{//添加角色
				if (isTokenValid(request, true)){
					//调用BL发起
					ctlBL.addProcessParticipants(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========参与者处理终了========");
		}
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("===========参与者变更处理操作开始===========");
			//dto参数设定
			dto.setIgPRD0107Form(form);
			if (isTokenValid(request, true)){
				dto = ctlBL.changeProcessParticipants(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("===========参与者变更处理操作结束===========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}
	
}
