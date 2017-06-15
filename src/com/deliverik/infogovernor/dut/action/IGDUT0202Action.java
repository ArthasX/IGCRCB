/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.infogovernor.dut.bl.IGDUT02BL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0202Form;
import com.deliverik.infogovernor.dut.vo.IGDUT02021VO;

/**
 * 
 * 添加值班人Action
 * 
 */
public class IGDUT0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0202Action.class);

	/**
	 * 添加值班人
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		IGDUT02BL ctlBL = (IGDUT02BL) getBean("igdut02BL");
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		IGDUT0202Form form = (IGDUT0202Form) actionForm;
		IGDUT02DTO dto = new IGDUT02DTO();
		dto.setUser(user);
		dto.setIgdut0202Form(form);
		dto.setDutyPlanSearchCond(form);
		IGDUT02021VO vo = new IGDUT02021VO();
		if ("DISP".equals(mapping.getParameter())) {
			dto = ctlBL.initIGDUT0202Action(dto);
			vo.setDayShiftUsers(dto.getDayShiftUsers());
			vo.setDayShiftDutyUsers(dto.getDayShiftDutyUsers());
			vo.setNightShiftUsers(dto.getNightShiftUsers());
			vo.setNightShiftDutyUsers(dto.getNightShiftDutyUsers());
			if("0".equals(form.getDayshift())){
				vo.setDayShift("0");
			}
		} else if ("INSERT".equals(mapping.getParameter())) {
			if("0".equals(form.getDayshift())){
				vo.setDayShift("0");
			}
			if("1".equals(form.getMode())){				
				ctlBL.addDutyPersonAction(dto);
			} else {
				ctlBL.removeDutyPersonAction(dto);
			}
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
		}
		super.<IGDUT02021VO>setVO(req, vo);
		return mapping.findForward("DISP");
	}
}
