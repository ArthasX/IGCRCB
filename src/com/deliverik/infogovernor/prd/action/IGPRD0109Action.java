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
import com.deliverik.infogovernor.prd.form.IGPRD0109Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01091VO;

/**
 * 规则定义查询Action处理
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0109Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0109Action.class);

	/**
	 * 规则定义查询处理
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
		IGPRD0109Form form = (IGPRD0109Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			//规则定义查询画面初期显示处理
			log.debug("========规则定义查询画面初期显示处理开始========");
			
			dto.setIgPRD0109Form(form);
			dto.setPdid(form.getPdid());
			//规则定义信息检索逻辑调用
			
			dto.setFlag(form.getFlag());
			dto = ctlBL.searchProcessTransitionDefAction(dto);
			dto = ctlBL.isProcessDefinitionInUse(dto);
		
			req.setAttribute("processStatusDefList", dto.getLabelList());
			req.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			
			//将规则定义信息检索结果设定到VO中
			IGPRD01091VO vo = new IGPRD01091VO(dto.getProcessTransitionDefList(), 
					dto.getProcessStatusDef(),dto.getProcessParticipantDefList());
			vo.setParticipantDefaultButtonDefInfoList(dto.getParticipantDefaultButtonDefInfoList());
			vo.setProcessParticipantButtonDefMap(dto.getProcessParticipantButtonDefMap());
			//是否缺省规则定义
			if("1".equals(form.getFlag())) {
				forward = "DISP1";
			}
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				forward = "VIEWHISTORY";
				//历史缺省规则定义
				if("1".equals(form.getFlag())) {
					forward = "VIEWHISTORY1";
				}
			}
			super.<IGPRD01091VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========规则定义查询画面初期显示处理终了========");
		} else if("INSERT".equals(mapping.getParameter())) {
			log.debug("========规则定义增加处理开始========");
			
			dto.setIgPRD0109Form(form);
			
			//规则定义信息检索逻辑调用
			dto = ctlBL.insertProcessTransitionDefAction(dto);
			
			log.debug("========规则定义增加处理终了========");
		} else if("DELETE".equals(mapping.getParameter())) {
			log.debug("========规则定义删除处理开始========");
			
			dto.setIgPRD0109Form(form);
			
			//规则定义信息检索逻辑调用
			dto = ctlBL.deleteProcessTransitionDefAction(dto);
			
			log.debug("========规则定义删除处理终了========");
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
