/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0135Form;
import com.csebank.items.vo.ITEMS01011VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;

public class ITEMS0135Action extends BaseAction {

	static Log log = LogFactory.getLog(ITEMS0135Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if ("SEARCH".equals(mapping.getParameter())) {
			ITEMS01BL items01BL = (ITEMS01BL) this.getBean("items01BL");
			ITEMS0135Form form = (ITEMS0135Form)actionForm;
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			ITEMS01DTO dto = new ITEMS01DTO();
			dto.setUser(user);
			
			String outtime_f = form.getOuttime_f();
			String outtime_t = form.getOuttime_t();
			if(StringUtils.isNotEmpty(outtime_f) && outtime_f.length()==10){
				
				form.setOuttime_f(form.getOuttime_f() + " 00:00");
			}
			if(StringUtils.isNotEmpty(outtime_t) && outtime_t.length()==10){
				
				form.setOuttime_t(form.getOuttime_t() + " 23:59");
			}

			dto.setItemsPaySearchCond(form);
			dto.setMaxSearchCount(getMaxDataCount("DEFAULT"));
			dto = items01BL.searchPaymentItems(dto);
			ITEMS01011VO vo = new ITEMS01011VO();
			vo.setPaymentList(dto.getPaymentList());
			super.<ITEMS01011VO>setVO(req, vo);
			form.setOuttime_f(outtime_f);
			form.setOuttime_t(outtime_t);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			if("excel".equals(form.getPath())){
				req.setAttribute("form", form);
				req.setAttribute("vo", vo);
				return mapping.findForward("EXCEL");
			}
		}
		return mapping.findForward("DISP");
	}

}
