/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0408Form;


/**
 * 应急资源快捷登记Action
 * @author 张剑
 *
 * 2015-2-12 上午9:51:47
 */
public class IGDRM0408Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0408Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BL取得
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		IGDRM0408Form form = (IGDRM0408Form)actionForm;
		
		//DTO生成
		IGDRM04DTO dto = new IGDRM04DTO();
		dto.setUser(user);
		
		//画面跳转设定
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			log.info("=============应急资产快捷登记预处理开始===============");
			log.info("=============应急资产快捷登记预处理结束===============");
			
		}
		if("INSERT".equals(mapping.getParameter())){
			log.info("=============应急资产快捷登记开始===============");
			dto.setForm(form);
			dto.setUser(user);
			ctlBL.regEmergencyResourceShortcut(dto);
			dto.getMessageList().add(new ActionMessage("IGCO10000.I000","应急资源保存成功！"));
			log.info("=============应急资产快捷登记结束===============");
			
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
