/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.sym.form.IGSYM1301Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���Ų���ACTION
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class IGSYM1301Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM1301Action.class);
	
	/**
	 * <p>
	 * Description: �ɹ�����ת
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
			IGSYM1301Form form = (IGSYM1301Form)actionForm;
			IGSYM13BL ctlBL = (IGSYM13BL) getBean("igsym13BL");
			IGSYM13DTO dto = new IGSYM13DTO();
			dto.setIgsym1301Form(form);
			dto = ctlBL.sendSMS(dto);
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
