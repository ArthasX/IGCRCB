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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0116Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01161VO;

/**
 * 流程状态_缺省参与者_权限Action处理
 *
 */
public class IGPRD0116Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0116Action.class);

	/**
	 * 流程状态_缺省参与者_权限处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGPRD0116Form form = (IGPRD0116Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//form里有值，但页面不能显示
		if(StringUtils.isNotEmpty(form.getPpsdid())) {
			req.setAttribute("ppsdid", form.getPpsdid());
		}
		
		if( "DISP".equals(mapping.getParameter())){
			//查询画面初期显示处理
			log.debug("========流程状态_缺省参与者_权限画面初期显示处理开始========");
			dto.setPdid(form.getPdid());
			dto.setIgPRD0116Form(form);
			dto = ctlBL.participantDefaultVariableInitAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			dto = ctlBL.searchDefaultRelevantProcessDefinitionAction(dto);
			IGPRD01161VO vo = new IGPRD01161VO();
			vo.setPsdid(form.getPsdid());
			vo.setPdid(form.getPdid());
			vo.setProcessStatusDef(dto.getProcessStatusDef());
			vo.setLst_ParticipantDefaultVariableVW(dto.getLst_ParticipantDefaultVariableVW());
			vo.setProcessParticipantButtonDefVWInfoList(dto.getProcessParticipantButtonDefVWInfoList());
			vo.setLst_processDefinitionInfo(dto.getRelevantProcessDefinitionList());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			super.<IGPRD01161VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========流程状态_缺省参与者_权限画面初期显示处理终了========");
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				return mapping.findForward("VIEWHISTORY");
			}
			return mapping.findForward("DISP");
		} else if ( "GRANT".equals(mapping.getParameter())){
			log.debug("========流程状态_缺省参与者_权限授权处理开始========");
			
			dto.setIgPRD0116Form(form);
			//逻辑调用
			dto = ctlBL.grantDefaultPermissionAction(dto);
			// 设置相关发起的自定义流程类型信息
            dto = ctlBL.grantDefaultRelevantProcessAction(dto);
			//addMessage(req,new ActionMessage("IGCO10000.I010","权限"));
			log.debug("========流程状态_缺省参与者_权限授权处理终了========");
		} 
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
