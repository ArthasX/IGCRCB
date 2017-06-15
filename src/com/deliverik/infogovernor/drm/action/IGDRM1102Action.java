package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM11BL;
import com.deliverik.infogovernor.drm.dto.IGDRM11DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1102Form;
import com.deliverik.infogovernor.drm.vo.IGDRM11021VO;

/**
 * 代签到Action处理
 *
 */
public class IGDRM1102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1102Action.class);

	/**
	 * 
	 * 处理
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGDRM1102Form form = (IGDRM1102Form)actionForm;
		//当前登录用户
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//BL取得
		IGDRM11BL ctlBL = (IGDRM11BL) getBean("igdrm11BL");
		
		//DTO生成
		IGDRM11DTO dto = new IGDRM11DTO();
		dto.setUser(user);
		dto.setIgdrm1102Form(form);
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("===========代签到初始化页面显示处理开始===========");
			form.setSiuserid(null);
			dto=ctlBL.initIGDRM1102Action(dto);
			//构造VO
			IGDRM11021VO vo = new IGDRM11021VO();
			vo.setSigninMap(dto.getSigninMap());
			super.<IGDRM11021VO>setVO(req, vo);
			log.debug("===========代签到初始化页面显示处理开始===========");
			return mapping.findForward("DISP");
		}
		if( "SIGNIN".equals(mapping.getParameter())){
			log.debug("===========代签到初始化页面显示处理开始===========");
			dto=ctlBL.updateIGDRM1102Action(dto);
			ctlBL.pushSigninHelpMessage(dto);
			log.debug("===========代签到初始化页面显示处理开始===========");
			return mapping.findForward("DISP");
		}

		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
				
		return mapping.findForward("DISP");
	}
}
