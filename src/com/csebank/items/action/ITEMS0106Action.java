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
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0106Form;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0106Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0106Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		
		if("DISP".equals(mapping.getParameter())){
			req.setAttribute("itemsCodesList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_CATEGORY));
			req.setAttribute("itemTypeList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_TYPE));
			req.setAttribute("natureList", items01BL.getItemsCodes(DefineUtils.ITEMSCODES_STOCK_NATURE));
			saveToken(req);
		} else if("INSERT".equals(mapping.getParameter())){
			ITEMS0106Form form = (ITEMS0106Form)actionForm;
			ITEMS01DTO dto = new ITEMS01DTO();
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			form.setUserid(user.getUserid());
			form.setUsername(user.getUsername());
			dto.setItems0106form(form);
			if(isTokenValid(req, true)){
				dto = items01BL.doStock(dto, "insertInStockAction");
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		
		return mapping.findForward("DISP");
		
	}
	
}
