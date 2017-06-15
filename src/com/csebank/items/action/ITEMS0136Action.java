/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0136Form;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0136Action extends BaseAction {

	static Log log = LogFactory.getLog(ITEMS0136Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if ("SEARCH".equals(mapping.getParameter())) {
			ITEMS01BL items01BL = (ITEMS01BL) this.getBean("items01BL");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			ITEMS01DTO dto = new ITEMS01DTO();
			dto.setUser(user);
			ITEMS0136Form form = (ITEMS0136Form)actionForm;
			dto.setItems0136form(form);
			dto = items01BL.searchPaymentDetail(dto);
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setOutStockList(dto.getOsList());
			
			if("exportOrg".equals(form.getPath())){
				req.setAttribute("form", form);
				req.setAttribute("vo", vo);
				return mapping.findForward("EXPORT_ORG");
			} else if("exportAll".equals(form.getPath())){
				req.setAttribute("form", form);
				req.setAttribute("vo", vo);
				return mapping.findForward("EXPORT_ALL");
			}
			
			super.<ITEMS01011VO>setVO(req, vo);
		}
		return mapping.findForward("DISP");

	}

}
