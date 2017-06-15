/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.prd.form.IGPRD0158Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01581VO;

/**
 * 概述: 流程通知策略设定Action
 * 功能描述: 流程通知策略设定Action
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public class IGPRD0158Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0158Action.class);
	
	/**
	 * Action处理
	 *
	 * @param mapping ActionMapping
	 * @param actionForm ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @exception Exception
	 * @return ActionForward
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRD0158Form form = (IGPRD0158Form)actionForm;
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		String forward = "";
		dto.setIgPRD0158Form(form);
		request.getSession().setAttribute("ADcount", 0);
		request.getSession().setAttribute("ADValueCount", 0);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========流程通知策略查询处理开始========");
			
			dto = ctlBL.searchRoleByIGBP06Action(dto);
			dto = ctlBL.searchProcessBLByIGBP06Action(dto);
			// 查询角色
			request.setAttribute("lvPsdassignListRO", dto.getLvPsdassignListRO());
			// 状态超时提醒处理Bl集合
			request.setAttribute("lvProcessBLList", dto.getProccessBLList());
			// 整体超时提醒处理Bl集合
			request.setAttribute("lvProcessAllBLList", dto.getProcesstacticsbl_alllist());
			
			//调用BL查询
			dto = ctlBL.initIGPRD0158Action(dto);
			form.setPisize(dto.getPisize());
			form.setPssize(dto.getPssize());
			form.setProcessWholeTactic_listSize(dto.getProcessWholeTactic_listSize());
			
			saveToken(request);
			//构造VO
			IGPRD01581VO vo = new IGPRD01581VO();
//			vo.setLst_ProcessNoticeStrategyDef(dto.getLst_ProcessNoticeStrategyDef());
			vo.setShowMap(dto.getShowMap());
			vo.setProcessWholeTactic_list(dto.getProcessWholeTactic_list());
			super.<IGPRD01581VO>setVO(request, vo);
			log.debug("========流程通知策略查询处理终了========");
		}  else if ("SET".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				//调用BL发起
				ctlBL.setIGPRD0158Action(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		} else if ("EDIT".equals(mapping.getParameter())){//添加参与者
			log.debug("========流程通知策略设定处理开始========");
			if (isTokenValid(request, true)){
				//调用BL发起
				ctlBL.editIGPRD0158Action(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========流程通知策略设定处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
			//历史版本下的查看
			forward = "VIEWHISTORY";
		}else{
			forward = "DISP";
		}
		return mapping.findForward(forward);
	}
	
}
