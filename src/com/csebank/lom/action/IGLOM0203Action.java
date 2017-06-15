/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.dto.IGLOM02DTO;
import com.csebank.lom.form.IGLOM0203Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class IGLOM0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0203Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		IGLOM02BL ctlBL = (IGLOM02BL) this.getBean("iglom02BL");
		if ("DISP".equals(mapping.getParameter())) {
			req.setAttribute("itemsCodesList", LOMHelper.getItemsCodes(CodeUtils.GOODS_CATEGORY));
			saveToken(req);
		} else if ("INSERT".equals(mapping.getParameter())) {
			IGLOM0203Form form = (IGLOM0203Form) actionForm;
			IGLOM02DTO dto = new IGLOM02DTO();
			User user = (User) req.getSession().getAttribute(
					SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setIglom0203Form(form);
			// dto.setItems0106form(form);
			if (isTokenValid(req, true)) {
				dto = ctlBL.doStock(dto, "insertInStockAction");
			} else {
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		return mapping.findForward("DISP");
	}
}
