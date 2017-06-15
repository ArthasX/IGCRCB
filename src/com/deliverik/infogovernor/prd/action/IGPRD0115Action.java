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
import com.deliverik.infogovernor.prd.form.IGPRD0115Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01151VO;

/**
 * 流程并行节点规则定义Action处理
 *
 */
public class IGPRD0115Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0115Action.class);

	/**
	 * 流程并行节点规则定义处理
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
		IGPRD0115Form form = (IGPRD0115Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		dto.setIgPRD0115Form(form);
		
		if( "DISP".equals(mapping.getParameter())){
			//规则定义查询画面初期显示处理
			log.debug("========并行节点规则定义查询画面初期显示处理开始========");
			
			dto.setPdid(form.getPdid());
			//规则定义信息检索逻辑调用
			dto = ctlBL.searchConcurrencyProcessTransitionDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
			req.setAttribute("processStatusDefList", dto.getLabelList());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			//将规则定义信息检索结果设定到VO中
			IGPRD01151VO vo = new IGPRD01151VO(dto.getProcessTransitionDefList(), 
					dto.getProcessStatusDef());
			
			super.<IGPRD01151VO>setVO(req, vo);
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========并行节点规则定义查询画面初期显示处理终了========");
		} else if("INSERT".equals(mapping.getParameter())) {
			log.debug("========并行节点规则定义增加处理开始========");
			
			//并行节点规则定义信息新增处理
			if (isTokenValid(req, true)){
				dto = ctlBL.insertConcurrencyProcessTransitionDefAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========并行节点规则定义增加处理终了========");
		} else if("DELETE".equals(mapping.getParameter())) {
			log.debug("========并行节点规则定义删除处理开始========");
			
			//并行节点规则定义信息删除处理
			if (isTokenValid(req, true)){
				dto = ctlBL.deleteConcurrencyProcessTransitionDefAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========并行节点规则定义删除处理终了========");
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
