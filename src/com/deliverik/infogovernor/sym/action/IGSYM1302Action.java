/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.infogovernor.sym.bl.IGSYM13BL;
import com.deliverik.infogovernor.sym.dto.IGSYM13DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1302Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 邮件测试ACTION
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class IGSYM1302Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM1302Action.class);
	
	/**
	 * <p>
	 * Description: 成功后跳转
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if("INSERT".equals(mapping.getParameter())){
			IGSYM1302Form form = (IGSYM1302Form)actionForm;
			IGSYM13BL ctlBL = (IGSYM13BL) getBean("igsym13BL");
			IGSYM13DTO dto = new IGSYM13DTO();
			dto.setIgsym1302Form(form);
			dto = ctlBL.sendMail(dto);
			List<ActionMessage> messageList = dto.getMessageList();
			if(messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			if(dto.isEnable() == false){
				return mapping.findForward("INPUT");
			}
		}
		return mapping.findForward("DISP");
	}
	
}
