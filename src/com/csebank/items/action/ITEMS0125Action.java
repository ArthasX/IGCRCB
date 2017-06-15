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
import com.csebank.items.form.ITEMS0125Form;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseAction;

public class ITEMS0125Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0125Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ITEMS01BL items01BL = (ITEMS01BL)this.getBean("items01BL");
		if("DISP".equals(mapping.getParameter())){
			req.setAttribute("requestStatus", 
					items01BL.getRequsetStatus(DefineUtils.ITEMSCODES_ITEMSCODES_REQUESTSTATUS));
		} else if("CHANGE".equals(mapping.getParameter())){
			ITEMS0125Form form = (ITEMS0125Form)actionForm;
			String requestStatus = form.getRequestStatus();
			if(requestStatus.equals("0")){
				requestStatus = "1";
			} else if(requestStatus.equals("1")){
				requestStatus = "0";
			}
			items01BL.changeRequsetStatus(DefineUtils.ITEMSCODES_ITEMSCODES_REQUESTSTATUS,requestStatus);
		}
		return mapping.findForward("DISP");
	}
	
}
