package com.deliverik.infogovernor.soc.iop.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.iop.bl.IGIOP01BL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP01DTO;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0101Form;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * IP段登记Action处理
 * 
 */
public class IGIOP0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIOP0101Action.class);

	/**
	 * IP段登记处理
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		log.debug("==============IP段登记处理开始==============");

		// FORM取得
		IGIOP0101Form form = (IGIOP0101Form) actionForm;

		// BL取得
		IGIOP01BL ctlBL = (IGIOP01BL) getBean("igiop01BL");

		// DTO生成
		IGIOP01DTO dto = new IGIOP01DTO();
		dto.setLocale(this.getLocale(req));

		if ("DISP".equals(mapping.getParameter())) {
			
			log.debug("========IP段登记初期显示处理开始========");
			
			
			log.debug("========IP段登记初期显示处理处理终了========");
			return mapping.findForward("DISP");
		}

		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("==============IP段登记处理开始===============");
			User user = (User)getSessionAttribute(req, SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			form.setCreatDate(DateUtils.getCurrentYear()+"/"+DateUtils.getCurrentMonth()+"/"+DateUtils.getCurrentDate());
			dto.setIgiop0101Form(form);
			ctlBL.regSubNet(dto);
			
			log.debug("==============IP段登记处理结束===============");
		}
		if ("DELETE".equals(mapping.getParameter())) {
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		log.debug("==============IP段登记处理结束==============");
		return mapping.findForward("DISP");
	}
}
