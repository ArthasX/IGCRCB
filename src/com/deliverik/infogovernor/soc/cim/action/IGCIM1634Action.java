package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM16BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1634Form;

/**
 * 密码拓扑关系画面Action处理
 *
 */
public class IGCIM1634Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1634Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM1634Form form = (IGCIM1634Form)actionForm;
		
		//BL取得
		IGCIM16BL ctlBL = (IGCIM16BL) getBean("igcim16BL");
		
		IGCIM16DTO dto = new IGCIM16DTO();
		
		String forward = "";
		
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("==============密码拓扑关系添加页面预处理开始=================");
			
			dto.setIgcim1634Form(form);
			
			ctlBL.initIGCIM1634TopoBelongAction(dto);
			
			req.setAttribute("topoXML", dto.getTopoXML());
			
			forward = "DISP";
			log.debug("==============密码拓扑关系添加页面预处理结束=================");
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
