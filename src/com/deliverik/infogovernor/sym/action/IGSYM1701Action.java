/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.IGSYM17BL;
import com.deliverik.infogovernor.sym.dto.IGSYM17DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1701Form;
import com.deliverik.infogovernor.sym.vo.IGSYM17011VO;

/**
 * 概述: 流程定义查询Action处理
 * 功能描述：流程定义查询Action处理
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public class IGSYM1701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1701Action.class);

	/**
	 * 功能：流程定义查询处理
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
		IGSYM1701Form form = (IGSYM1701Form)actionForm;
		
		//BL取得
		IGSYM17BL ctlBL = (IGSYM17BL) getBean("igSYM17BL");
		
		//DTO生成
		IGSYM17DTO dto = new IGSYM17DTO();
		
		dto.setIgSYM1701Form(form);
		
		if( "DISP".equals(mapping.getParameter())){
			//流程定义查询画面初期显示处理
			log.debug("========流程定义查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========流程定义查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//流程定义查询处理
			log.debug("========流程定义查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGSYM1701");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSYM1701Form) req.getSession().getAttribute("IGSYM1701Form");
				if ( form == null ) {
					form = new IGSYM1701Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGSYM1701Form) req.getSession().getAttribute("IGSYM1701Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGSYM1701");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//流程定义信息检索逻辑调用
			dto = ctlBL.searchProcessDefinitionAction(dto);
			
			//将流程定义信息检索结果设定到VO中
			IGSYM17011VO vo = new IGSYM17011VO(dto.getProcessDefinitionList());
			
			super.<IGSYM17011VO>setVO(req, vo);
			
			log.debug("========流程定义查询处理终了========");
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
