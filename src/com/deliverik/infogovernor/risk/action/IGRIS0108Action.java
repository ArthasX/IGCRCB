/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0104Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01051VO;

/**
 * 审计项详细查询Action处理
 *
 */
public class IGRIS0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0108Action.class);

	/**
	 * 成功处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {

		//实例化FORM
		IGRIS0104Form form = (IGRIS0104Form)actionForm;
		//获取BL接口实例
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		//实例化DTO
		IGRIS01DTO dto = new IGRIS01DTO();
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========审计项管理详细画面初期显示处理开始========");
			dto.setIgRIS0104Form(form);
			
			dto.setRiskAuditDefSearchCond(form);
			
			//调用BL查询
			dto = ctlBL.initIGRIS0108Action(dto);
			//构造VO
			IGRIS01051VO vo = new IGRIS01051VO();
			vo.setRiskAuditDef(dto.getRiskAuditDef());
			super.<IGRIS01051VO>setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========审计项管理详细画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} 
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
