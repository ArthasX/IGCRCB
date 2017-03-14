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
import com.deliverik.infogovernor.sym.bl.IGSYM17BL;
import com.deliverik.infogovernor.sym.dto.IGSYM17DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1702Form;
import com.deliverik.infogovernor.sym.vo.IGSYM17021VO;

/**
 * 概述: 流程策略设定Action处理
 * 功能描述：流程策略设定Action处理
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public class IGSYM1702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1702Action.class);

	/**
	 * 功能：流程策略设定处理
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
		IGSYM1702Form form = (IGSYM1702Form)actionForm;
		
		//BL取得
		IGSYM17BL ctlBL = (IGSYM17BL) getBean("igSYM17BL");
		
		//DTO生成
		IGSYM17DTO dto = new IGSYM17DTO();
		
		dto.setIgSYM1702Form(form);
		
		if( "DISP".equals(mapping.getParameter())){
			//流程定义登记画面初期显示处理
			log.debug("========流程策略设定画面初期显示处理开始========");
			
			dto = ctlBL.initIGSYM1702Action(dto);
			
			form.setStrategyMap(dto.getStrategyMap());
			
			//将流程策略信息设定到VO中
			IGSYM17021VO vo = new IGSYM17021VO();
			
			vo.setPrurgencyList(dto.getPrurgencyList());
			
			vo.setPrstatusList(dto.getPrstatusList());
			
			vo.setProcessDefinition(dto.getProcessDefinition());
			
			vo.setMaxPsdversion(dto.getMaxPsdversion());
			
			super.<IGSYM17021VO>setVO(req.getSession(), vo);
			
			log.debug("========流程策略设定画面初期显示处理终了========");
			
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========流程策略设定编辑处理开始========");
			
			dto = ctlBL.editIGSYM1702Action(dto);
			
			log.debug("========流程策略设定编辑处理终了========");

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
